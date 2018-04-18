package com.sinco.carnation.o2o.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;
import cn.eeepay.EeePayUtils;

import com.google.common.collect.Maps;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupGoodsConstants;
import com.sinco.carnation.o2o.constants.GroupInfoConstants;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.dao.GroupComplaintDao;
import com.sinco.carnation.o2o.dao.GroupInfoDao;
import com.sinco.carnation.o2o.dao.GroupOrderDao;
import com.sinco.carnation.o2o.dao.GroupOrderLogDao;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.model.GroupOrderLog;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.OrderTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.shop.bo.PredepositPfLogBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.dao.PredepositLogDao;
import com.sinco.carnation.shop.dao.PredepositPfLogDao;
import com.sinco.carnation.shop.enums.EmShopQrOrderPayStatus;
import com.sinco.carnation.shop.model.BalanceExceptionOrder;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.service.BalanceExceptionOrderService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.bo.orcl.CnValidatPasswordBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.IntegralRegService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.dao.UserMoneyDao;
import com.sinco.carnation.user.dao.UserRelationDao;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.model.UserMoney;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.HashidUtils;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;
import com.sinco.messager.MessageHandler;

@Service
@Transactional(rollbackFor = {ServiceException.class})
public class GroupOrderService {
	private static final Logger log = LoggerFactory.getLogger(GroupOrderService.class);
	@Autowired
	private UserMoneyDao moneyDao;
	@Autowired
	private PredepositLogDao predepositLogDao;
	@Autowired
	private DicNameMappingHandle mappingHandle;
	@Autowired
	UserCustomerDao userCustomerDao;
	@Autowired
	UserDao userDao;
	@Autowired
	GroupComplaintDao groupComplaintDao;
	@Autowired
	MsgTools msgTools;
	@Autowired
	UserMoneyService userMoneyService;
	@Autowired
	MessageService messageService;
	@Autowired
	GroupInfoService groupInfoService;
	@Autowired
	private GroupInfoDao groupInfoDao;
	@Autowired
	PaymentService paymentService;
	@Autowired
	GroupGoodsService groupGoodsService;
	@Autowired
	OrderFormTools orderFormTools;
	@Autowired
	private OrderTools orderTools;
	@Autowired
	SysConfigService sysConfigService;
	@Autowired
	UserCustomerService userCustomerService;
	@Autowired
	UserService userService;
	@Autowired
	private GroupOrderDao groupOrderDao;
	@Autowired
	GroupOrderLogDao groupOrderLogDao;
	@Autowired
	StoreService storeService;
	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private GroupInfoService infoService;

	@Autowired
	private RebateService rebateService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private PredepositPfLogDao pfLogDao;
	@Autowired
	private UserAccountDao userAccountDao;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	@Autowired
	private NoticeMessageService noticeMessageService;

	@Autowired
	private UserRelationDao userRelationDao;
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private UserRelationService userRelationService;
	@Autowired
	private BalanceExceptionOrderService balanceExceptionOrderService;
	@Autowired
	private IntegralRegService integralRegService;

	/**
	 * 现金
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderPayByCashCoupon() {
		return groupOrderDao.findGroupOrderPayByCashCoupon();
	}

	/**
	 * 代金券
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderPayByCouPon() {
		return groupOrderDao.findGroupOrderPayByCouPon();
	}

	/**
	 * O2O线上服务
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderCanPayOff() {
		return groupOrderDao.findGroupOrderCanPayOff();
	}

	/**
	 * 线下支付
	 * 
	 * @return
	 */
	public List<GroupOrder> findGroupOrderCanPayUpline() {
		return groupOrderDao.findGroupOrderPayByUpline();
	}

	/**
	 * 查找各订单状态的数量
	 * 
	 * @param userId
	 * @param statusList
	 * @return
	 */
	public List<GroupOrderBO> statusCount(Long userId, List<Integer> statusList) {
		return groupOrderDao.statusCount(userId, statusList);
	}

	/**
	 * by young
	 * 
	 * @param id
	 * @return
	 */
	public GroupOrderBO fetch(Long id) {
		return groupOrderDao.findOne(id);
	}

	/**
	 * 支付回调
	 * 
	 * @param orderNo
	 *            订单ID：o2o_group_order.id
	 * @param mark
	 *            交易方式
	 * @param pay_info
	 *            支付说明
	 * @param trade_no
	 *            交易单号
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@Transactional(isolation = Isolation.REPEATABLE_READ)
	public void generate_groupInfos(String orderNo, String mark, String pay_info, String trade_no) {
		synchronized (orderNo.intern()) {
			GroupOrderBO order = getObjById(CommUtil.null2Long(orderNo));
			if (order.getOrderStatus() < GroupOrderConstants.ORDER_STATUS_PAYMENT 
					&& order.getOrderStatus() != GroupOrderConstants.ORDER_STATUS_CANCEL) {
				order.setOutOrderId(trade_no);
				order.setPayTime(new Date());
				// 生活团购订单付款时增加退款时效
				Calendar ca = Calendar.getInstance();
				ca.add(Calendar.DATE, sysConfigService.getSysConfig().getGrouplifeOrderReturn());
				SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String latertime = bartDateFormat.format(ca.getTime());
				order.setReturnShipTime(CommUtil.formatDate(latertime));
				// 2扫码支付3优惠买单
				if ((2 == order.getOrderType() || 3 == order.getOrderType())
						&& (PaymentConstants.PAYMENT_MARK_WX_APP.equals(order.getPaymentMark())
								|| PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(order.getPaymentMark()) || PaymentConstants.PAYMENT_MARK_BALANCE
									.equals(order.getPaymentMark()))) {
					order.setOrderStatus(GroupOrderConstants.ORDER_STATUS_USEED);
					processAppScanPay(order);
					// 生成GroupInfo信息
					// 扫码支付分润必须生成记录
					this.createGroupInfo(order);
					try {
						this.o2oShopSendIntegral(order.getUserId(), CommUtil.null2Double(order.getTotalPrice()));
					} catch (Exception e) {
						log.info("o2oShopSendIntegral MEHTOD {}",order.getOrderType());
						e.printStackTrace();
					}
				} else {
					order.setOrderStatus(GroupOrderConstants.ORDER_STATUS_PAYMENT);
				}
				update(order);
				
				GroupOrderLog ofl = new GroupOrderLog();
				ofl.setAddTime(new Date());
				ofl.setLogInfo(pay_info);
				UserCustomer buyer = userCustomerService.findById(CommUtil.null2Long(order.getUserId()));
				ofl.setLogUserId(buyer.getUid());
				ofl.setOfId(order.getId());
				groupOrderLogDao.save(ofl);
	
				// 向商户扫描付款的商品是没有商品信息的
				Store store = storeService.getObjById(CommUtil.null2Long(order.getStoreId()));
				if (StringUtils.isNotBlank(order.getGroupInfo())) {
					Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
					Date goodsEndTime = java.sql.Date.valueOf(map.get("goods_end_time").toString());
					int count = CommUtil.null2Int(map.get("goods_count").toString());
					String goods_id = map.get("goods_id").toString();
					GroupGoods goods = groupGoodsService.getObjById(CommUtil.null2Long(goods_id));
					goods.setGroupCount(goods.getGroupCount() - CommUtil.null2Int(count));
					goods.setSelledCount(goods.getSelledCount() + CommUtil.null2Int(count));
					groupGoodsService.update(goods);
	
					// 生成服务消费码
					List<String> code_list = new ArrayList(); // 存放服务消费码
					for (int i = 0; i < count; i++) {
						GroupInfo info = new GroupInfo();
						info.setAddTime(new Date());
						info.setGoodsId(goods.getId());
						info.setOrderId(order.getId());
						info.setUserId(buyer.getUid());
						info.setGroupSn(RandomStringUtils.randomNumeric(10));
						Calendar ca2 = Calendar.getInstance();
						ca2.add(Calendar.DATE, sysConfigService.getSysConfig().getGrouplifeOrderReturn());
						SimpleDateFormat bartDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String latertime2 = bartDateFormat2.format(ca2.getTime());
						info.setRefundTime(CommUtil.formatDate(latertime2));
						info.setEndTime(goodsEndTime);
						try {
							groupInfoService.save(info);
						} catch (DuplicateKeyException e) {
							info.setGroupSn(RandomStringUtils.randomNumeric(10));
							groupInfoService.save(info);
						}
						code_list.add(info.getGroupSn());
					}
					// 发送系统站内信给买家
					String msg_content = "恭喜您成功购买服务" + map.get("goods_name") + "，消费码分别为："
							+ StringUtils.join(code_list, "，") + "您可以到用户中心-我的线上服务订单中查看消费码的使用情况";
					Message tobuyer_msg = new Message();
					tobuyer_msg.setAddTime(new Date());
					tobuyer_msg.setStatus(0);
					tobuyer_msg.setType(0);
					tobuyer_msg.setContent(msg_content);
					tobuyer_msg.setFromUserId(1L);
					tobuyer_msg.setToUserId(buyer.getUid());
					messageService.save(tobuyer_msg);
	
					// 发送系统站内信给卖家
					Message toSeller_msg = new Message();
					toSeller_msg.setAddTime(new Date());
					toSeller_msg.setStatus(0);
					toSeller_msg.setType(0);
					toSeller_msg.setContent(buyer.getNickname() + "购买了你的服务");
					toSeller_msg.setFromUserId(1L);
					toSeller_msg.setToUserId(goods.getUserId());
					messageService.save(toSeller_msg);
					// 尊敬的用户：您的（商户名称）：套餐券密码：（消费码）。商家电话：（商户电话）
					// 尊敬的用户：您的$1：套餐券密码：$2。商家电话：$3
					String smsmark = null;
					if (goods.getGoodsType() == 1)
						smsmark = "sms_tobuyer_merchant_order_pay_combo_notify";
					else
						smsmark = "sms_tobuyer_merchant_order_pay_coupon_notify";
					msgTools.sendSms(smsmark, buyer.getMobile(), store.getStoreName(), // goods.getGgName(),
							StringUtils.join(code_list, "，"), store.getStoreTelephone());
				}
				// TODO 商户收款通知
				if (2 == order.getOrderType() || 3 == order.getOrderType()) {
					try{
						noticeMessageService.pushReceiveMoneyMessage(store.getCreateUserId(), order.getTotalPrice(),
								order.getId());
						//处理首次消费绑定关系 返润的时候绑定了关系
						userRelationService.firstConsumptionRelation(order.getUserId(), order.getStoreId());
					}catch(Exception e){
						log.error("首次消费绑定关系异常", e);
					}
				}
			}
		}
	}

	public GroupOrderBO findByTradeNo(String tradeNo) {
		return groupOrderDao.findByTradeNo(tradeNo);
	}

	/**
	 * 处理APP扫码支付后没创建订单的问题
	 * 
	 * @param order
	 */
	private void processAppScanPay(GroupOrderBO order) {
		// APP扫码支付订单没有创建shop_qr_pay_order，所以在这里创建
		// 如果不为空为会员
		if (order.getUserId() != null) {
			UserCustomer customer = userCustomerService.findById(order.getUserId());
			if (customer != null) {
				order.setUserNickname(customer.getNickname());
			}
			order.setIsSysUser(true);
		} else {
			order.setIsSysUser(false);
		}
		ShopQrPayOrderBO qrOrder = new ShopQrPayOrderBO();
		if (order.getStoreId() != null && StringUtils.isNumeric(order.getStoreId())) {
			//Seller seller = sellerService.findByStore(Long.parseLong(order.getStoreId()));
			//StoreBO storeBo = storeService.findObjById(Long.parseLong(order.getStoreId()));
			StoreBO storeBo = this.storeDao.getStoreStatus(Long.parseLong(order.getStoreId()));//修该查询
			if (storeBo != null) {
				order.setProportion(storeBo.getCommissionRebate());
				qrOrder.setSellerId(storeBo.getCreateUserId());//增加店铺卖家ID
			}
		}
		qrOrder.setOriginalPrice(order.getOriginalPrice());
		qrOrder.setPayOrderNo(order.getOutOrderId());
		qrOrder.setWxTransactionId(order.getTradeNo());
		qrOrder.setTotalFee(order.getTotalPrice());
		qrOrder.setPrepayId("");
		qrOrder.setUserId(order.getUserId());
		qrOrder.setOrderId(order.getOrderId());
		qrOrder.setPayStatus((byte) EmShopQrOrderPayStatus.PaySuccess.getValue());
		qrOrder.setCreateTime(new Date());
		if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(order.getPaymentMark())) {
			qrOrder.setPaymentType((byte) 1);
		} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(order.getPaymentMark())) {
			qrOrder.setPaymentType((byte) 2);
		} else if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(order.getPaymentMark())) {
			qrOrder.setPaymentType((byte) 0);
		}
		qrOrder.setPhone(order.getMobile());
		qrOrder.setServerName(order.getLocalGroupName());
		shopQrPayOrderService.save(qrOrder);
		BigDecimal amount = null;
		Long storeId = null;
		try {
			// 分润
			/*this.mchWXQrPayRebate(order);*/
			/*============ 增加卖家云购币 ============*/
			// 返润比例
			// SellerBO sellerbo = sellerService.findByUid(qrOrder.getSellerId());
			SellerBO sellerbo = this.sellerService.findSessionById(qrOrder.getSellerId(), true, false);
			// StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
			StoreBO storeBo = storeService.getStoreStatus(sellerbo.getStoreId());
			storeId = sellerbo.getStoreId();
			BigDecimal commissionRebate = storeBo.getCommissionRebate();
			// 扫描支付总金额
			BigDecimal totalFee = qrOrder.getOriginalPrice();
			// 卖家ID
			Long sellerID = qrOrder.getSellerId();
			User user = this.userDao.findById(sellerID);
			if (sellerID != null && user != null) {
				// 总金额 * 返润比例 = 返润金额
				BigDecimal fanRun = totalFee.multiply(commissionRebate);
				// 总金额-返润金额 = 所得实际金额
				amount = qrOrder.getTotalFee().subtract(fanRun);
//				this.moneyDao.addMoney(sellerID, amount.doubleValue());
//				// 余额
//				double balance = moneyDao.get(sellerID).getAvailableBalance().doubleValue();
				this.moneyDao.addMoneyV2(sellerID, amount.doubleValue(), UserContant.ACCOUNT_TYPE_MERCHANT);
				double balance = moneyDao.get(sellerID).getO2oBalance().doubleValue();
				/*流水日志*/
				PredepositLog log = new PredepositLog();
				log.setPdLogAdminId(0L);
				log.setAddTime(new Date());
				log.setPdLogAmount(amount);
				log.setBalance(BigDecimal.valueOf(balance));
				log.setPdLogInfo(qrOrder.getServerName());
				log.setPdLogUserId(sellerID);
				log.setPdOpType("线下消费");
				log.setPdType(UserContants.PD_TYPE_AVAILABLE_MONEY);
				log.setUserCode(Long.valueOf(UserContant.USER_CODE_O2O));
				this.predepositLogDao.save(log);
			}
		} catch (Exception e) {
			// TODO: handle exception
			log.error(String.format("%s店内扫描支付 分润失败 ,订单号：%s  线上订单号：%s  异常堆栈：%s",
					String.valueOf(qrOrder.getPaymentType()), qrOrder.getPayOrderNo(),
					qrOrder.getWxTransactionId(), CommUtil.getStackTrace(e)));
			BalanceExceptionOrder exOrder = new BalanceExceptionOrder();
			exOrder.setAddTime(new Date());
			exOrder.setDeleteStatus(false);
			exOrder.setAmount(amount);
			exOrder.setExceptionMsg(e.getMessage());
			exOrder.setOrderId(qrOrder.getId());
			exOrder.setSellerId(qrOrder.getSellerId());
			exOrder.setServerName(qrOrder.getServerName());
			exOrder.setStoreId(storeId);
			balanceExceptionOrderService.save(exOrder);
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(GroupOrder groupOrder) {
		groupOrderDao.save(groupOrder);
		GroupOrderLog ofl = new GroupOrderLog();
		ofl.setAddTime(new Date());
		ofl.setOfId(groupOrder.getId());
		ofl.setLogInfo("提交订单");
		if (groupOrder.getUserId() != null) {
			ofl.setLogUserId(groupOrder.getUserId());
		}
		ofl.setLogUserId(groupOrder.getUserId());
		groupOrderLogDao.save(ofl);

		return true;
	}

	/**
	 * 进行订单支付
	 * 
	 * @param payType
	 * @param orderId
	 * @param isAvailableBalance
	 * @param paymentPassword
	 * @param accountType
	 *            判断账号是不是CN用户
	 * @throws ServiceException
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public GroupOrderBO orderPay(String payType, Long orderId, Long uid, boolean isAvailableBalance,
			String paymentPassword, String accountType) throws ServiceException {
		GroupOrderBO order = getObjById(orderId);

		if (order != null && order.getOrderStatus() != GroupOrderConstants.ORDER_STATUS_SUBMIT) {
			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				return order;
			}
			throw new ServiceException("参数错误，付款失败");
		}
		double group_total_price = 0d;
		// 线下刷卡或扫描支付
		if (2 == order.getOrderType() || 3 == order.getOrderType()) {
			group_total_price = order.getTotalPrice().doubleValue();
		} else {
			Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
			group_total_price = Double.parseDouble(map.get("goods_total_price").toString());
			long goods_id = Long.parseLong(map.get("goods_id").toString());
			int goods_count = Integer.parseInt(map.get("goods_count").toString());
			GroupGoodsBO goods = groupGoodsService.getObjById(goods_id);
			Date goodsEndTime = java.sql.Date.valueOf(map.get("goods_end_time").toString());
			if (DateUtils.truncatedCompareTo(goodsEndTime, new Date(), Calendar.DATE) < 0)
				throw new ServiceException("订单中的服务已过期，无法进行支付");
			if (goods == null || !goods.getGgStatus().equals(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING))
				throw new ServiceException("订单中的服务不存在，请重新下单");
			if (goods.getGroupCount() < goods_count)
				throw new ServiceException("订单中服务库存不足，请重新下单");
		}
		double availableBalance = userMoneyService.getAvailableBalance(uid);
		// 使用云豆支付
		if (isAvailableBalance) {
			order.setPaymentMark(PaymentConstants.PAYMENT_MARK_BALANCE); // 支付方式
			update(order);
			// CN帐号验证
			boolean bl = false;
			if (StringUtils.isNotBlank(paymentPassword)) {
				if (null != accountType && "8".equals(accountType)) {
					bl = this.validatCNPassword(null, paymentPassword, uid);
					if (!bl) {
						throw new ServiceException("cn支付密码错误");
					}
				} else {
					UserMoney money = userMoneyService.isExistAndCreate(uid);
					// 用户支付密码是否为空
					if (StringUtils.isBlank(money.getPassword())) {
						throw new MoneyPasswordNullConsumption();
					}
					if (!PasswordUtils.validatePassword(paymentPassword, money.getPassword())) {
						throw new ServiceException("支付密码错误!");
					}
				}
			}
			if (availableBalance >= group_total_price) { // 如果云豆足够
				// 如果密码为空,则不验证密码
				boolean bo = false;
				String logInfo = "购买服务减少可用云豆";
				if (StringUtils.isNotBlank(paymentPassword)) {
					if (null != accountType && "8".equals(accountType)) {
						bo = userMoneyService.consumptionMoney(order.getUserId(), group_total_price, logInfo);
					} else {
						bo = userMoneyService.consumptionMoney(order.getUserId(), group_total_price,
								paymentPassword, logInfo);
					}
				} else {
					bo = userMoneyService.consumptionMoney(order.getUserId(), group_total_price, logInfo);
				}
				if (!bo) {
					throw new ServiceException("云豆支付失败");
				}
				try {
					generate_groupInfos(orderId.toString(), PaymentConstants.PAYMENT_MARK_BALANCE, logInfo,
							order.getOutOrderId());
				} catch (Exception e) {
					throw new ServiceException(e.getMessage());
				}
				return getObjById(orderId);
			}
		}

		if (StringUtils.isBlank(payType)) {
			throw new ServiceException("支付方式错误");
		}
		payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYB) ? PaymentConstants.PAYMENT_MARK_ALIPAYB
				: payType;
		payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYC) ? PaymentConstants.PAYMENT_MARK_ALIPAYC
				: payType;
		// 拿到在线支付的方式

		// 使用云豆不足，需要在线充值,充值完成后会使用云豆支付
		if (isAvailableBalance) {
			// 如果云豆不够，不足的部分充值到云豆后，再完成云豆支付
			BigDecimal pdAmount = new BigDecimal(group_total_price)
					.subtract(new BigDecimal(availableBalance));
			Long pid = predepositService.save(order.getId(), PaymentConstants.ORDER_TYPE_GROUP, payType,
					pdAmount, uid);
			order.setCashId(pid);
			update(order);
		} else {
			// 产生订单支付id
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());

			// 使用在线支付,设置在线支付方式
			order.setPaymentMark(payType); // 支付方式
			update(order);
		}
//		//处理首次消费绑定关系 返润的时候绑定了关系(调整为支付完成后绑定关系)
		//userRelationService.firstConsumptionRelation(uid, order.getStoreId());
		return order;
	}

	public List<GroupOrderBO> search(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		List<GroupOrderBO> list = groupOrderDao.search(vo, page);
		for (GroupOrderBO order : list) {
			try {
				order.setGroupComplaintBO(groupComplaintDao.findByOrder(order.getId()));
				order.setStore(storeDao.findObjById(Long.valueOf(order.getStoreId())));
			} catch (Exception e) {

			}
		}

		return list;
	}

	public List<GroupOrderBO> offLine(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		List<GroupOrderBO> list = groupOrderDao.offLine(vo, page);
		for (GroupOrderBO order : list) {
			try {
				order.setGroupComplaintBO(groupComplaintDao.findByOrder(order.getId()));
				order.setStore(storeDao.findObjById(Long.valueOf(order.getStoreId())));
			} catch (Exception e) {

			}
		}
		return list;
	}

	public GroupOrderBO getObjById(Long id) {
		GroupOrderBO bo = groupOrderDao.get(id);
		try {
			if (getOrderStatus(id) == -1) {
				bo.setStatus(-1);
			}
			bo.setUserCustomer(userCustomerService.findById(bo.getUserId()));
			bo.setStore(storeDao.findObjById(Long.valueOf(bo.getStoreId())));
			Long createUserId = bo.getStore().getCreateUserId();
			UserCustomer uc = userCustomerDao.findById(createUserId);
			bo.setStoreMobile(uc.getMobile());
			mappingHandle.mappinHandle(bo);
			mappingHandle.mappinHandle(bo.getStore());
			GroupComplaintBO gc = bo.getGroupComplaintBO();
			UserBO handle = userDao.findById(gc.getHandleUserId());
			gc.setHandleUser(handle);
		} catch (Exception e) {

		}

		return bo;
	}

	public GroupOrderBO getGroupOrderBOById(Long id) {
		return groupOrderDao.getGroupOrderBOById(id);
	}

	public boolean delete(Long id) {
		this.groupOrderDao.remove(id);
		return true;
	}

	public boolean batchDelete(List<Serializable> GroupOrderIds) {
		for (Serializable id : GroupOrderIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(GroupOrder GroupOrder) {
		this.groupOrderDao.update(GroupOrder);
		return true;
	}

	public List<GroupOrderBO> findPageByVo(MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		return groupOrderDao.findPageByVo(page, vo);
	}

	public void queryMerchantOrderList(Long uid, Integer orderStatus, Integer orderType, Integer localStatus,
			MyPage<GroupOrderBO> page) {
		StoreBO store = storeDao.queryStoreByCreateUserId(uid);
		//StoreBO store = this.storeDao.queryStoreStatus(uid, true, false);// 修改固定搜索
		if (store != null) {
			if (orderType == 1) {
				page.setContent(groupOrderDao.queryMerchantOrderList(store.getId(), orderStatus, orderType,
						localStatus, page));
			} else if (orderType == 2) {
				page.setContent(groupOrderDao.queryMerchantOrderLineList(store.getId(), orderStatus,
						orderType, localStatus, page));
			}
			// 商户线下和线上的订单暂时都显示在一个菜单 2017/1/3 16:45
			// 待后续增加线下订单管理菜单
			// page.setContent(groupOrderDao.queryAllMerchantOrderList(store.getId(), orderStatus, orderType,
			// localStatus, page));
		}
	}

	/**
	 * 根据id查询订单详情
	 * 
	 * @param orderId
	 * @return
	 */
	public GroupOrderBO queryGroupOrderById(Long orderId) {
		// return groupOrderDao.findOne(orderId);
		return groupOrderDao.queryGroupOrderById(orderId);
	}

	public List<GroupOrderBO> selectOrderBySellerId(GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		return groupOrderDao.selectOrderBySellerId(vo, page);
	}

	public List<GroupOrderBO> queryGroupOrderListByVO(@Param("vo") GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		return groupOrderDao.queryGroupOrderListByVO(vo, page);
	}

	/**
	 * 
	 * @param mobile
	 * @param goodsName
	 * @param price
	 */
	@Transactional(readOnly = false)
	public Long createGroupOrder(String mobile, String goodsName, BigDecimal price) {
		UserCustomerBO customer = userCustomerService.findByMobile(mobile);
		if (customer != null) {
			GroupOrder groupOrder = new GroupOrder();
			groupOrder.setUserId(customer.getUid());
			groupOrder.setOrderType(2);
			groupOrder.setTotalPrice(price);
			groupOrder.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
			groupOrder.setAddTime(new Date());
			groupOrder.setLocalGroupName(goodsName);
			groupOrderDao.save(groupOrder);
			return groupOrder.getId();
		}
		return null;
	}

	/**
	 * 
	 * @param mobile
	 * @param goodsName
	 * @param price
	 * @param orderType
	 *            订单类型2扫码支付3优惠买单
	 */
	@Transactional(readOnly = false)
	public Long createGroupOrder(long uid, long storeId, String goodsName, BigDecimal price, Integer orderType) {
		UserCustomer customer = userCustomerService.findById(uid);
		if (customer != null) {
			BigDecimal originalPrice = new BigDecimal(price.doubleValue());
			// 计算折扣
			StoreBO storeBo = storeService.getStoreBOById(storeId);
			// 扫码支付新增折扣价
			if (storeBo.getIsO2o() && storeBo.getGroupDiscount() != null
					&& storeBo.getGroupDiscount().compareTo(BigDecimal.ZERO) == 1) {
				price = originalPrice.multiply(storeBo.getGroupDiscount()).setScale(2, RoundingMode.HALF_UP);
			}

			GroupOrder groupOrder = new GroupOrder();
			groupOrder.setStoreId(String.valueOf(storeId));
			groupOrder.setUserId(customer.getUid());
			groupOrder.setOrderType(orderType);
			groupOrder.setTotalPrice(price);
			groupOrder.setOriginalPrice(originalPrice);
			// String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			// groupOrder.setOrderId("life" + customer.getUid() + order_suffix + price);
			groupOrder.setOrderId(orderTools.generateShopQrPayOrderNo(customer.getUid()));
			groupOrder.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
			groupOrder.setAddTime(new Date());
			groupOrder.setLocalGroupName(goodsName);
			groupOrderDao.save(groupOrder);
			return groupOrder.getId();
		}
		return null;
	}

	/**
	 * 线下支付
	 */
	@Transactional(readOnly = false)
	public GroupOrderBO linePay(String url, String mobile, String goodsName, Double price, Long uid)
			throws ServiceException {
		BigDecimal decimal = new BigDecimal(price);

		GroupOrder order = createGroupOrder(mobile, goodsName, decimal, uid, "");
		if (order != null && order.getId() != null) {
			GroupOrderBO orderBO = groupOrderDao.findOne(order.getId());
			StoreBO storeBO = storeDao.queryStoreById(CommUtil.null2Long(orderBO.getStoreId()));
			Map<String, String> payPackage = Maps.newHashMap();
			payPackage.put("out_trade_no", orderBO.getOrderId());
			payPackage.put("subject", orderBO.getLocalGroupName());
			payPackage.put("body", "1234");
			payPackage.put("total_fee", CommUtil.null2String(price));
			payPackage.put("sign_type", "MD5");
			payPackage.put("notify_url", url + "/eeepay_notify.htm");
			if (StringUtils.isNotBlank(storeBO.getEepayMid())
					&& StringUtils.isNotBlank(storeBO.getEepayKey())) {
				// "255410000256155", "EEEPAY888144116081363145537"
				String tradeno = EeePayUtils.generateMchPayNativeRequestURL(payPackage,
						storeBO.getEepayMid(), storeBO.getEepayKey());
				// String tradeno =
				// EeePayUtils.generateMchPayNativeRequestURL(payPackage,
				// "255410000256155", "EEEPAY888144116081363145537");
				if (StringUtils.isNotBlank(tradeno)) {
					// 更新流水号
					orderBO.setTradeNo(tradeno);
					groupOrderDao.save(orderBO);
					return orderBO;
				}
			}
			return null;
		}
		return null;
	}

	@Autowired
	private IntegralService integralService;

	/**
	 * 店铺内扫码支付
	 */
	@Transactional(readOnly = false)
	public GroupOrder mchQrPay(String url, String mobile, String goodsName, Double price, Long uid,
			String tradeNo) throws ServiceException {
		BigDecimal decimal = new BigDecimal(price);

		GroupOrder groupOrder = createGroupOrder(mobile, goodsName, decimal, uid, tradeNo);

		return groupOrder;
	}

	/**
	 * 店铺内扫码支付分润
	 */
	@Transactional(readOnly = false)
	public void mchWXQrPayRebate(GroupOrder groupOrder) throws ServiceException {
		// 消费反润
		double amount = groupOrder.getTotalPrice().doubleValue();
		if (groupOrder != null) {
			// 分润
			rebateService.lineProfit(amount, groupOrder, false);
		}
	}

	/**
	 * 创建线下订单
	 * 
	 * @param mobile
	 * @param goodsName
	 * @param price
	 * @param uid
	 * @return
	 */
	@Transactional(readOnly = false)
	public GroupOrder createGroupOrder(String mobile, String goodsName, BigDecimal price, Long uid,
			String tradeNo) throws ServiceException {
		// UserCustomerBO userCustomerBO =
		// userCustomerService.findByMobile(mobile);
		UserAccountBO accountBO = accountService.findByLoginName(mobile);
		StoreBO storeBO = storeDao.queryStoreInfo(uid, true, false);
		GroupOrder groupOrder = new GroupOrder();
		groupOrder.setTotalPrice(price);
		groupOrder.setOrderType(2);
		groupOrder.setStoreId(CommUtil.null2String(storeBO.getId()));
		groupOrder.setAddTime(new Date());
		groupOrder.setLocalGroupName(goodsName);
		groupOrder.setLocalReturnStatus(1);
		groupOrder.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
		groupOrder.setLocalReturnStatus(1);
		groupOrder.setProportion(storeBO.getCommissionRebate());
		groupOrder.setTradeNo(tradeNo);
		// 如果不为空为会员
		if (accountBO != null) {
			String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			groupOrder.setOrderId(accountBO.getUid() + order_suffix + storeBO.getId());
			groupOrder.setUserId(accountBO.getUid());
			UserCustomer customer = userCustomerService.findById(accountBO.getUid());
			if (customer != null) {
				groupOrder.setUserNickname(customer.getNickname());
			}
			groupOrder.setIsSysUser(true);
		} else {
			String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			mobile = StringUtils.isBlank(mobile) ? "0" : mobile;
			groupOrder.setOrderId(HashidUtils.encode(CommUtil.null2Long(mobile), "goods", 8) + order_suffix
					+ storeBO.getId());
			groupOrder.setUserNickname(mobile);
			groupOrder.setIsSysUser(false);
		}
		groupOrderDao.save(groupOrder);
		return groupOrder;
	}

	/**
	 * 微信扫码支付逻辑，需要获取用户信息来处理分润的问题
	 * 
	 * @param userId
	 * @param goodsName
	 * @param price
	 * @param uid
	 * @param tradeNo
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public GroupOrder createGroupOrder(Long userId, String mobile, String goodsName, BigDecimal price,
			BigDecimal originalPrice, Long sellerId, String orderNo, String tradeNo, String paymentMark)
			throws ServiceException {
		StoreBO storeBO = storeDao.queryStoreInfo(sellerId, true, false);
		GroupOrder groupOrder = new GroupOrder();
		groupOrder.setTotalPrice(price);
		groupOrder.setOriginalPrice(originalPrice);
		groupOrder.setOrderType(2);
		groupOrder.setStoreId(CommUtil.null2String(storeBO.getId()));
		groupOrder.setAddTime(new Date());
		groupOrder.setLocalGroupName(goodsName);
		groupOrder.setLocalReturnStatus(1);
		groupOrder.setOrderStatus(GroupOrderConstants.ORDER_STATUS_USEED);
		groupOrder.setPaymentMark(paymentMark);
		// groupOrder.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
		groupOrder.setLocalReturnStatus(1);
		groupOrder.setProportion(storeBO.getCommissionRebate());
		groupOrder.setTradeNo(tradeNo);
		groupOrder.setUserId(userId);
		groupOrder.setPayTime(new Date());//支付时间新增
		// 如果不为空为会员
		if (userId != null) {
			// String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			// groupOrder.setOrderId(
			// "life" + userId + order_suffix + new Double(CommUtil.mul(price, 100)).longValue());
			groupOrder.setOrderId(orderTools.generateShopQrPayOrderNo(userId));
			groupOrder.setUserId(userId);
			UserCustomer customer = userCustomerService.findById(userId);
			if (customer != null) {
				groupOrder.setUserNickname(customer.getNickname());
			}
			groupOrder.setIsSysUser(true);
		} else {
			// String order_suffix = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			mobile = StringUtils.isBlank(mobile) ? "0" : mobile;
			// groupOrder.setOrderId(
			// "life" + sellerId + order_suffix + new Double(CommUtil.mul(price, 100)).longValue());
			groupOrder.setOrderId(orderTools.generateShopQrPayOrderNo(sellerId));
			groupOrder.setUserNickname(mobile);
			groupOrder.setIsSysUser(false);
		}
		// 直接用预支付订单号，保持微信通知的订单号和o2o订单号一至
		if (StringUtils.isNotBlank(orderNo)) {
			groupOrder.setOrderId(orderNo);
		}
		groupOrderDao.save(groupOrder);
		return groupOrder;
	}

	/**
	 * 生成订单信息，微信扫码支付，新添加
	 * 
	 * @param orderId
	 * @param userId
	 * @param proportion
	 * @return
	 */
	public GroupInfo createGroupInfo(GroupOrder groupOrder) {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setAddTime(new Date());
		groupInfo.setDeleteStatus(false);
		groupInfo.setOrderId(groupOrder.getId());
		groupInfo.setStatus(GroupInfoConstants.STATUS_USE);
		groupInfo.setUserId(groupOrder.getUserId());
		groupInfo.setProportion(groupOrder.getProportion());
		groupInfoService.save(groupInfo);
		return groupInfo;
	}

	public BigDecimal queryOrderTotalPrice(Integer orderType, Long storeId, Date startTime, Date endTime) {
		return groupOrderDao.queryOrderTotalPrice(orderType, storeId, startTime, endTime);
	}

	public BigDecimal queryOrderPriceByDate(Long storeId, String startDate, String endDate) {
		return groupOrderDao.queryOrderPriceByDate(storeId, startDate, endDate);
	}

	public List<GroupOrderBO> queryGroupOrderByMonth(Long storeId, Integer orderType) {
		return groupOrderDao.queryGroupOrderByMonth(storeId, orderType);
	}

	public void groupOrderDetails(Long storeId, Integer orderType, MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.groupOrderDetails(storeId, orderType, page));
	}

	public void queryGroupOrderLineDetails(Long storeId, Integer orderType, MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.queryGroupOrderLineDetails(storeId, orderType, page));
	}

	public int queryOrderCountByDate(Long storeId, String startDate, String endDate) {
		return groupOrderDao.queryOrderCountByDate(storeId, startDate, endDate);
	}

	public BigDecimal queryOnLineTotalPrice(Long storeId, String startTime, String endTime) {
		return groupOrderDao.queryOnLineTotalPrice(storeId, startTime, endTime);
	}

	public BigDecimal queryLineTotalPrice(Long storeId, String startTime, String endTime) {
		return groupOrderDao.queryLineTotalPrice(storeId, startTime, endTime);
	}

	public BigDecimal queryTotalPrice(Long storeId) {
		return groupOrderDao.queryTotalPrice(storeId);
	}

	/**
	 * 查询买家所有订单，包括线上线下
	 * 
	 * @param status
	 *            状态|0已取消,10未付款20未使用,30已使用100退款|
	 * @param orderType
	 *            订单类型1线上订单2扫码支付3优惠买单4套餐券5代金券
	 * @param uid
	 *            用户ID
	 * @param page
	 */
	public void queryAllGroupOrderPageList(Integer status, Integer orderType, Long uid,
			MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.queryAllGroupOrderPageList(status, orderType, uid, page));
	}

	public void queryGroupOrderPageList(Integer status, Long uid, MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.queryGroupOrderPageList(status, uid, page));
	}

	public void queryGroupOrderLinePageList(Long uid, Integer orderType, MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.queryGroupOrderLinePageList(uid, orderType, page));
	}

	public GroupOrderBO queryGroupOrderId(Long orderId) {
		GroupOrderBO bo = groupOrderDao.queryGroupOrderId(orderId);
		Date edTime = null;
		if (bo != null) {
			bo.setGroupInfoBOList(groupInfoDao.findByOrder(bo.getId()));
			List<GroupInfoBO> infos = bo.getGroupInfoBOList();
			for (GroupInfoBO infoBO : infos) {
				if (null != infoBO && infoBO.getStatus() == 6) {// 改状态
					GroupInfo info = new GroupInfo();
					info.setOrderId(bo.getId());
					info.setReadStatus(1);
					groupInfoDao.changeReadStatus(info);
				}
				edTime = infoBO.getEndTime();
			}
		}
		if (null == edTime) {
			if (null != bo.getReturnShipTime() && bo.getReturnShipTime().getTime() < new Date().getTime()
					&& bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_PAYMENT.intValue()) {
				bo.setOrderStatus(GroupOrderConstants.ORDER_STATUS_OVERDUE);
			}
		} else {
			if (edTime.getTime() < new Date().getTime()
					&& bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_PAYMENT.intValue()) {
				bo.setOrderStatus(GroupOrderConstants.ORDER_STATUS_OVERDUE);
			}
		}
		if (bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_OVERDUE.intValue()) {
			bo.setOrderStatus(GroupOrderConstants.ORDER_STATUS_OVERDUE);
		}

		return bo;
	}

	public List<GroupOrderBO> queryOrderCouponInfo(Long orderId) {
		return groupOrderDao.queryOrderCouponInfo(orderId);
	}

	public GroupOrderBO getGroupOrderById(Long id) {
		return groupOrderDao.findOne(id);
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Long appCreateOrder(Long goodsId, Integer count, Long uid, Long storeId) {
		try {
			UserCustomer customer = customerService.findById(uid);
			GroupGoods goods = groupGoodsService.getObjById(goodsId);
			double group_total_price = CommUtil.null2Double(goods.getGroupPrice()) * CommUtil.null2Int(count);
			GroupOrder orderForm = new GroupOrder();
			orderForm.setAddTime(new Date());
			orderForm.setUserId(uid);
			orderForm.setUserNickname(customer.getNickname());
			if (goods.getGoodsType() == 1) {
				orderForm.setOrderType(4);// 套餐券
			} else {
				orderForm.setOrderType(5);// 代金券
			}
			orderForm.setStoreId(CommUtil.null2String(storeId));
			Map json = new HashMap();
			json.put("goods_id", goods.getId().toString());
			json.put("goods_name", goods.getGgName());
			json.put("goods_type", goods.getGoodsType());
			json.put("goods_price", goods.getGroupPrice());
			json.put("goods_count", CommUtil.null2Int(count));
			json.put("goods_total_price", group_total_price);
			json.put("goods_mainphoto_path", goods.getGroupAccPath());
			json.put("goods_begin_time", CommUtil.formatShortDate(goods.getBeginTime()));
			json.put("goods_end_time", CommUtil.formatShortDate(goods.getEndTime()));
			orderForm.setGroupInfo(Json.toJson(json, JsonFormat.compact()));
			orderForm.setTotalPrice(new BigDecimal(group_total_price));
			orderForm.setGroupRebateAmount(goods.getGroupRebateAmount());
			if (goods.getGoodsType() == 0) {
				if (goods.getStoreId() != null) {
					orderForm.setStoreId(goods.getStoreId().toString());
				}
				orderForm.setOrderForm(0);
			} else {
				orderForm.setOrderForm(1);
			}
			orderForm.setTotalPrice(BigDecimal.valueOf(group_total_price));
			// orderForm.setOrderId("life" + uid + CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
			orderForm.setOrderId(orderTools.generateShopQrPayOrderNo(uid));
			orderForm.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
			this.save(orderForm);
			return orderForm.getId();
		} catch (Exception e) {
		}
		return 0l;
	}

	/**
	 * 取消订单
	 * 
	 * @param orderId
	 * @throws ServiceException
	 */
	@Transactional(readOnly = false)
	public void cancelOrder(Long orderId) throws ServiceException {
		GroupOrderBO orderBO = this.getObjById(orderId);
		if (orderBO == null) {
			throw new ServiceException("没有找到该订单");
		}
		orderBO.setOrderStatus(GroupOrderConstants.ORDER_STATUS_CANCEL);
		this.groupOrderDao.update(orderBO);
	}

	public GroupOrderBO findByOrderNo(String orderNo) {
		return groupOrderDao.findByOrderNo(orderNo);
	}

	public GroupOrderBO findByOrderNoBig(String orderNo) {
		return groupOrderDao.findByOrderNoBig(orderNo);
	}

	/**
	 * 卡消费收益统计
	 * 
	 * @param uid
	 * @return
	 */
	public BigDecimal queryPredepositTotal(Long uid, Date startTime, Date endTime) {
		return pfLogDao.queryPredepositTotal(uid, startTime, endTime);
	}

	/**
	 * 线下刷卡月收益统计
	 * 
	 * @param uid
	 * @return
	 */
	public List<PredepositPfLogBO> queryMonthlyPre(Long uid) {
		return pfLogDao.queryMonthlyPre(uid);
	}

	public void queryGroupOrderlist(Long uid, Integer orderType, MyPage<GroupOrderBO> page) {
		page.setContent(groupOrderDao.queryGroupOrderlist(uid, orderType, page));
	}

	public GroupOrderBO queryGroupOrderIdBySpecifiyStatus(Long orderId) {
		GroupOrderBO bo = groupOrderDao.queryGroupOrderId(orderId);
		if (bo != null) {
			bo.setGroupInfoBOList(groupInfoDao.findByOrderStatus(bo.getId()));
		}
		return bo;
	}

	private boolean validatCNPassword(String userAlias, String password, Long uid) {
		boolean bl = false;
		UserAccountBO vo = new UserAccountBO();
		vo.setUid(uid);
		vo.setAccountType("8");
		UserAccountBO account = this.userAccountDao.findAccountByVo(vo);
		CnValidatPasswordBO pwd = this.cnPayBaseService.validatPassword2(account.getLoginName(), password);
		if (0 == pwd.getISPAY()) {// 错误
			bl = false;
		}
		if (1 == pwd.getISPAY().intValue()) {// 正确
			bl = true;
		}
		return bl;
	}

	/**
	 * 统计商户优惠买单的订单金额
	 * 
	 * @param storeId
	 * @return
	 */
	public BigDecimal staticsDiscountPayAmount(Long storeId) {
		if (storeId == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal money = groupOrderDao.staticsDiscountPayAmount(storeId);
		return money == null ? BigDecimal.ZERO : money;
	}

	/**
	 * 根据id查询返润金额
	 * 
	 * @param id
	 * @return
	 */
	public BigDecimal queryRebateAmountById(Long id) {
		if (id == null) {
			return BigDecimal.ZERO;
		}
		BigDecimal rebateAmount = groupOrderDao.queryRebateAmountById(id);
		return rebateAmount == null ? BigDecimal.ZERO : rebateAmount;
	}

	/**
	 * 获取返润金额
	 * 
	 * @param id
	 *            订单id
	 * @param proportion
	 *            返润比例
	 * @return
	 */
	public BigDecimal getRebateAmountById(Long id, BigDecimal proportion) {
		BigDecimal result = BigDecimal.ZERO;
		if (id == null) {
			return result;
		}
		GroupOrderBO bo = groupOrderDao.findOne(id);
		if (bo != null) {
			if (bo.getOrderType() == 5) {
				result = bo.getGroupRebateAmount();
			} else if (bo.getOrderType() == 4) {
				result = bo.getGroupRebateAmount();
			} else {
				result = bo.getTotalPrice().multiply(proportion);
			}
		}
		return result;
	}

	public List<GroupOrderBO> queryUnpaySuccessOrder() {
		return groupOrderDao.queryUnpaySuccessOrder();
	}

	/**
	 * 查询订单状态
	 * 
	 * @param orderId
	 * @return result -1过期
	 */
	public int getOrderStatus(Long orderId) {
		int result = 0;
		if (null == orderId) {
			result = 0;
		}
		List<GroupInfoBO> infos = groupInfoDao.findByOrder(orderId);
		GroupOrderBO bo = groupOrderDao.queryGroupOrderId(orderId);
		Date edTime = null;
		if (infos.size() > 0) {
			edTime = infos.get(0).getEndTime();
		}
		if (null == edTime) {
			if (bo.getReturnShipTime() != null && bo.getReturnShipTime().getTime() < new Date().getTime()
					&& bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_PAYMENT.intValue()) {
				result = -1;
			}
		} else {
			if (edTime.getTime() < new Date().getTime()
					&& bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_PAYMENT.intValue()) {
				result = -1;
			}
		}
		if (bo.getOrderStatus().intValue() == GroupOrderConstants.ORDER_STATUS_OVERDUE.intValue()) {
			result = -1;
		}
		return result;
	}
	
	/***
	 * 周边消费赠送积分
	 * @param uid
	 * @param price
	 * @throws Exception
	 */
	public void o2oShopSendIntegral (Long uid, Double price) throws Exception {
		String content = "周边服务消费"+price;
		IntegralReg integralReg = this.integralRegService
				.getObjByType(IntegralConstants.INTEGRAL_O2O_SHOP);
		System.out.println("o2oShopSendIntegral"+ uid+"------"+price );
		this.integralService.addIntegralLog(content, CommUtil.null2String(price),
				integralReg, uid, null, 0, null);
		this.customerService.addIntegral(uid, price.intValue());//赠送积分
	}
}
