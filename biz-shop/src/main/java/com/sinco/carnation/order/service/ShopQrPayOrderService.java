package com.sinco.carnation.order.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.tools.OrderTools;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.shop.dao.ShopQrPayOrderDao;
import com.sinco.carnation.shop.dao.ShopQrServerInfoDao;
import com.sinco.carnation.shop.enums.EmQrPayOrderPaymentType;
import com.sinco.carnation.shop.enums.EmShopQrOrderPayStatus;
import com.sinco.carnation.shop.model.BalanceExceptionOrder;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.model.ShopQrPayOrder;
import com.sinco.carnation.shop.model.ShopQrServerInfo;
import com.sinco.carnation.shop.service.BalanceExceptionOrderService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.StringUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Service
public class ShopQrPayOrderService {

	@Autowired
	private SellerService sellerService;

	private static final Logger log = LoggerFactory.getLogger(ShopQrPayOrderService.class);

	@Autowired
	private ShopQrPayOrderDao shopQrPayOrderDao;

	@Autowired
	private StoreService storeService;

	@Autowired
	private OrderTools orderTools;
	@Autowired
	private MsgTools msgTools;

	@Autowired
	private GroupOrderService groupOrderServer;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ShopQrServerInfoDao shopQrServerInfoDao;
	@Autowired
	private UserMoneyDao moneyDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PredepositLogDao predepositLogDao;
	@Autowired
	private NoticeMessageService noticeMessageService;
	@Autowired
	private BalanceExceptionOrderService balanceExceptionOrderService;
	@Autowired
	private UserRelationService userRelationService;

	@Transactional
	public ShopQrPayOrderBO newShopQrPayOrder(Long sellerId, BigDecimal totalFee,
			EmQrPayOrderPaymentType paymentType, String phone, String serverName) {

		ShopQrPayOrderBO order = new ShopQrPayOrderBO();
		order.setSellerId(sellerId);
		order.setPayOrderNo(orderTools.generateShopQrPayOrderNo(sellerId));
		order.setWxTransactionId("");
		order.setTotalFee(totalFee);
		order.setPrepayId("");
		order.setOrderId("");
		order.setPayStatus((byte) EmShopQrOrderPayStatus.NoPay.getValue());
		order.setCreateTime(new Date());

		order.setPaymentType((byte) paymentType.getValue());
		if (StringUtils.isNotBlank(phone)) {
			order.setPhone(phone);
		}
		if (StringUtils.isNotBlank(serverName)) {
			order.setServerName(serverName);
		}

		return order;
	}

	@Transactional
	public void save(ShopQrPayOrder order) {
		shopQrPayOrderDao.save(order);
	}

	public ShopQrServerInfo saveServerInfo(ShopQrServerInfo serverInfo) {
		return shopQrServerInfoDao.save(serverInfo);
	}

	public ShopQrServerInfo getServerInfo(Long id) {
		return shopQrServerInfoDao.findOne(id);
	}

	@SuppressWarnings("unused")
	@Transactional(readOnly = false)
	public ShopQrPayOrderBO complateOrderByPayOrderNo(String payOrderNo, String transactionId)
			throws ServiceException {

		synchronized (payOrderNo.intern()) {
			ShopQrPayOrderBO bo = getOrderByPayOrderNo(payOrderNo);// this.getOrderByPayOrderNo(payOrderNo);
			if (bo == null) {
				String errInfo = "店内扫描订单 不存在 单号：" + payOrderNo + "微信/支付宝/云尚单号:" + transactionId;
				log.error(errInfo);
				throw new ServiceException(errInfo);
			} else {
				log.info("---------------微信扫码支付回调开始--------------");
				String paymentTypeDesc = "";
				String paymentType = "";
				for (EmQrPayOrderPaymentType em : EmQrPayOrderPaymentType.values()) {
					if ((byte) em.getValue() == bo.getPaymentType()) {
						paymentTypeDesc = em.getDesc();
						if(em.getValue() == 1){
							paymentType = PaymentConstants.PAYMENT_MARK_WX_APP;
						}else if(em.getValue() == 2){
							paymentType = PaymentConstants.PAYMENT_MARK_ALIPAY_APP;
						}
					}
				}

				if (bo.getPayStatus() != (byte) EmShopQrOrderPayStatus.PaySuccess.getValue()) {
					bo.setPayStatus((byte) EmShopQrOrderPayStatus.PaySuccess.getValue());
					bo.setWxTransactionId(transactionId);
					bo.setModifyTime(new Date());

					// 创建订单
					SysConfigBO config = configService.getSysConfig();

					// 新加微信扫码支付处理逻辑
					// 如果为微信扫码支付，会需要用户信息处理分润
					GroupOrder groupOrder = null;
					// if(bo.getUserId() != null){
					log.info("--------------创建o2o订单createGroupOrder----------------" + bo.getPayOrderNo());
					groupOrder = groupOrderServer.createGroupOrder(bo.getUserId(), bo.getPhone(),
							bo.getServerName(), bo.getTotalFee(), bo.getOriginalPrice(), bo.getSellerId(),
							bo.getPayOrderNo(), bo.getWxTransactionId(), paymentType);
					// 生成GroupInfo信息
					// 扫码支付分润必须生成记录
					groupOrderServer.createGroupInfo(groupOrder);
					// }else{
					// log.info("--------------创建o2o订单mchQrPay----------------");
					// groupOrder = groupOrderServer.mchQrPay(config.getAddress(), bo.getPhone(),
					// bo.getServerName(),
					// bo.getTotalFee().doubleValue(), bo.getSellerId(), bo.getWxTransactionId());
					// }

					bo.setOrderId(groupOrder.getOrderId());
					this.save(bo);
					log.info("--------------创建o2o订单成功----------------" + bo.getOrderId());
					Long sellerId = bo.getSellerId();
					SellerBO sellerbo = sellerService.findByUid(sellerId);
					StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
					log.info("-------------获取商户信息成功-----------------");
					BigDecimal amount = null;
					try {
						// 分润
						groupOrderServer.mchWXQrPayRebate(groupOrder);
						/*============ 增加卖家云购币 ============*/
						// 返润比例
						BigDecimal commissionRebate = storeBo.getCommissionRebate();
						// 扫描支付总金额
						BigDecimal totalFee = bo.getOriginalPrice();
						// 卖家ID
						Long sellerID = bo.getSellerId();
						User user = this.userDao.findById(sellerID);
						if (sellerID != null && user != null) {
							// 总金额 * 返润比例 = 返润金额
							BigDecimal fanRun = totalFee.multiply(commissionRebate);
							// 总金额-返润金额 = 所得实际金额
							amount = bo.getTotalFee().subtract(fanRun);
							
//							this.moneyDao.addMoney(sellerID, amount.doubleValue());
//							// 余额
//							double balance = moneyDao.get(sellerID).getAvailableBalance().doubleValue();
							this.moneyDao.addMoneyV2(sellerID, amount.doubleValue(),UserContant.ACCOUNT_TYPE_MERCHANT);
							double balance = moneyDao.get(sellerID).getO2oBalance().doubleValue();
							
							/*流水日志*/
							PredepositLog log = new PredepositLog();
							log.setPdLogAdminId(0L);
							log.setAddTime(new Date());
							log.setPdLogAmount(amount);
							log.setBalance(BigDecimal.valueOf(balance));
							log.setPdLogInfo(bo.getServerName());
							log.setPdLogUserId(sellerID);
							log.setPdOpType("线下消费");
							log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
							log.setUserCode(Long.valueOf(UserContant.USER_CODE_O2O));
							this.predepositLogDao.save(log);
						}
						System.out.println("complateOrderByPayOrderNo o2oShopSendIntegral 进入");
						
						if (bo != null && bo.getUserId() != null) {
							this.groupOrderServer.o2oShopSendIntegral(bo.getUserId(), CommUtil.null2Double(bo.getTotalFee()));//赠送积分
						}
						
					} catch (Exception e) {
						// TODO: handle exception
						log.error(String.format("%s店内扫描支付 分润失败 ,订单号：%s  线上订单号：%s  异常堆栈：%s", paymentTypeDesc,
								payOrderNo, transactionId, CommUtil.getStackTrace(e)));
						BalanceExceptionOrder exOrder = new BalanceExceptionOrder();
						exOrder.setAddTime(new Date());
						exOrder.setDeleteStatus(false);
						exOrder.setAmount(amount);
						exOrder.setExceptionMsg(e.getMessage());
						exOrder.setOrderId(bo.getId());
						exOrder.setSellerId(bo.getSellerId());
						exOrder.setServerName(bo.getServerName());
						exOrder.setStoreId(sellerbo.getStoreId());
						balanceExceptionOrderService.save(exOrder);
					}
					try {
						// 这里推送消息
						SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
						String date = sdf.format(bo.getModifyTime());

						DecimalFormat myformat = new DecimalFormat("0.00");
						String totalFee = myformat.format(bo.getTotalFee());

						String[] str = new String[] {storeBo.getStoreName(), date, paymentTypeDesc + "扫码收款",
								totalFee, payOrderNo};
						sendMsg(sellerId, sellerbo.getUserName(), "", str);
						//TODO 商户收款通知
						if(2 == groupOrder.getOrderType() || 3 == groupOrder.getOrderType()){
							noticeMessageService.pushReceiveMoneyMessage(sellerId, bo.getTotalFee(), groupOrder.getId());
							//处理首次消费绑定关系 返润的时候绑定了关系
							userRelationService.firstConsumptionRelation(groupOrder.getUserId(), groupOrder.getStoreId());
						}
					} catch (Exception e) {
						// TODO: handle exception
						log.error("店内扫描支付 短信发送失败" + e.getStackTrace());
					}
				}
			}

			return bo;
		}
	}

	/**
	 * 发送短信 您$1于$2[2月29日22：10] $3[支付宝/微信扫码收款] $4[30.50]。订单号$5[1451212541254] [云尚]。 【这个30.50金额是分润前的金额】。
	 * 
	 * @param mobile
	 * @return
	 */
	public boolean sendMsg(Long uid, String mobile, String ip, String[] str) {

		msgTools.sendSms("sms_toshop_pay_complate", mobile, ip, str);
		return true;
	}

	public ShopQrPayOrderBO getOrderByPayOrderNo(String payOrderNo) {

		return shopQrPayOrderDao.getOrderByPayOrderNo(payOrderNo);
	}

	public int updateQrPayOrderPayStatus(String orderNo, String sellerID, byte payStatus) {
		ShopQrPayOrderBO bo = new ShopQrPayOrderBO();
		bo.setPayOrderNo(orderNo);
		if (sellerID != null && sellerID.trim().length() > 0) {
			bo.setSellerId(Long.parseLong(sellerID));
		}
		bo.setPayStatus(payStatus);
		this.shopQrPayOrderDao.updateByPayState(bo);
		return 0;
	}

	/**
	 * 根据卖家uid查询扫码支付订单金额
	 * 
	 * @param sellerId
	 * @return
	 */
	public BigDecimal findAllPaySuccessMoneyBySellerId(Long sellerId, Date startTime, Date endTime) {
		if (sellerId == null) {
			return new BigDecimal(0.00);
		}
		return this.shopQrPayOrderDao.findAllPaySuccessMoney(sellerId, startTime, endTime);
	}

	
	public List<ShopQrPayOrderBO> queryUnpaySuccessOrder() {
		return shopQrPayOrderDao.queryUnpaySuccessOrder();
	}
}
