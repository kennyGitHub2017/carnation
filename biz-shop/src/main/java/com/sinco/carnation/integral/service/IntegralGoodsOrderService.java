package com.sinco.carnation.integral.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.dao.IntegralGoodsDao;
import com.sinco.carnation.shop.dao.IntegralGoodsOrderDao;
import com.sinco.carnation.shop.dao.PaymentDao;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.vo.IntegralGoodsOrderVO;
import com.sinco.carnation.sys.bo.orcl.CnValidatPasswordBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.MessageDao;
import com.sinco.carnation.sys.dao.UserAccountDao;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.dao.IntegralLogDao;
import com.sinco.carnation.user.dao.UserCustomerDao;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(rollbackFor = ServiceException.class)
public class IntegralGoodsOrderService {
	@Autowired
	private IntegralGoodsOrderDao integralGoodsOrderDao;
	@Autowired
	private MessageDao messageDao;
	@Autowired
	private IntegralGoodsDao integralGoodsDao;
	@Autowired
	private UserCustomerDao userCustomerDao;
	@Autowired
	private IntegralLogDao integralLogDao;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private PaymentDao paymentDao;
	@Autowired
	private UserMoneyService moneyService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PredepositService predepositService;
	@Autowired
	private UserAccountDao userAccountDao;
	@Autowired
	private CnPayBaseService cnPayBaseService;

	@Autowired
	private IntegralLogService integralLogService;

	/**
	 * 根据订单号
	 * 
	 * @param igoOrderSn
	 * @return
	 */
	public IntegralGoodsOrderBO findByIgoOrderSn(String igoOrderSn) {
		return integralGoodsOrderDao.findByIgoOrderSn(igoOrderSn);
	}

	/**
	 * 进行订单支付
	 * 
	 * @param payType
	 * @param orderId
	 * @param isAvailableBalance
	 * @param paymentPassword
	 * @throws ServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public IntegralGoodsOrderBO orderPay(String payType, Long orderId, Long uid, boolean isAvailableBalance,
			String paymentPassword) throws ServiceException {

		IntegralGoodsOrderBO order = this.integralGoodsOrderDao.get(orderId);

		if (order == null || order.getIgoTransFee() == null) {
			throw new ServiceException("未找到对应的订单");
		}

		if (order.getIgoStatus() != 0) {
			throw new ServiceException("该订单不能进行付款！");
		}

		double order_total_price = order.getIgoTransFee().doubleValue();

		double availableBalance = 0;
		if (isAvailableBalance) {
			availableBalance = this.moneyService.getAvailableBalance(uid);
		}

		// 使用云豆支付
		if (isAvailableBalance) {
			UserAccount account = this.userAccountDao.findByUid(uid, UserContant.ACCOUNT_TYPE_8);
			boolean bl = false;
			if (account != null) {
				CnValidatPasswordBO val = this.cnPayBaseService.validatPassword2(account.getLoginName(),
						paymentPassword);
				if (val != null && val.getISPAY().intValue() == 1) {
					bl = true;
				} else {
					throw new ServiceException("支付密码错误");
				}
			}

			// 订单支付方式为云豆支付
			paymentService.findByMark(PaymentConstants.PAYMENT_MARK_BALANCE);
			order.setIgoPayment(OrderFormConstants.ORDER_PAY_TYPE_BALANCE); // 云豆支付
			this.update(order);
			// 如果云豆足够
			if (availableBalance >= order_total_price && !bl) {
				return this.completeMoneyPay(order.getId(), paymentPassword);
			}
			if (availableBalance >= order_total_price && bl) {// 表示CN账号 不需要验证本地密码
				return this.completeMoneyPay(order.getId(), null);
			}

		}

		if (StringUtils.isBlank(payType))
			throw new ServiceException("您的云豆余额不足");
		payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYB) ? PaymentConstants.PAYMENT_MARK_ALIPAYB
				: payType;
		payType = payType.startsWith(PaymentConstants.PAYMENT_MARK_ALIPAYC) ? PaymentConstants.PAYMENT_MARK_ALIPAYC
				: payType;

		PaymentBO onlinePayment = this.paymentService.findByMark(payType); // 拿到在线支付的方式

		// 产生支付id
		String tradeNo = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		order.setIgoOrderSn("igo-" + tradeNo + "-" + order.getId());
		update(order);

		// 使用云豆不足，需要在线充值,充值完成后会使用云豆支付
		if (isAvailableBalance) {

			// 如果云豆不够，不足的部分充值到云豆后，再完成云豆支付
			BigDecimal pdAmount = new BigDecimal(order_total_price)
					.subtract(new BigDecimal(availableBalance));

			Long cashId = predepositService.save(order.getId(), PaymentConstants.ORDER_TYPE_INTEGRAL,
					payType, pdAmount, uid);
			order.setCashId(cashId);
		} else {
			order.setIgoPayment(onlinePayment.getMark());
			update(order);
		}

		return order;
	}

	/**
	 * 使用云豆完成订单支付
	 * 
	 * @param mainOrderId
	 * @param tradeNo
	 * @param uid
	 * @param logInfo
	 * @return
	 * @throws ServiceException
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized IntegralGoodsOrderBO completeMoneyPay(Long orderId, String password)
			throws ServiceException {
		IntegralGoodsOrderBO igOrder = this.integralGoodsOrderDao.get(orderId);

		if (igOrder == null) {
			throw new ServiceException("未找到对应的订单");
		}

		double orderTotalPrice = igOrder.getIgoTransFee() != null ? igOrder.getIgoTransFee().doubleValue()
				: 0;

		String logInfo = igOrder.getIgoOrderSn() + " 积分订单购物减少可用云豆";

		boolean bo = false;

		// 如果密码为空,则不验证密码
		if (StringUtils.isNotBlank(password)) {
			bo = moneyService.consumptionMoney(igOrder.getIgoUserId(), orderTotalPrice, password, logInfo);
		} else {
			bo = moneyService.consumptionMoney(igOrder.getIgoUserId(), orderTotalPrice, logInfo);
		}
		if (!bo) {
			throw new ServiceException("云豆支付失败");
		}

		return completePay(orderId, PaymentConstants.PAYMENT_MARK_BALANCE);
	}

	/**
	 * 完成订单支付
	 * 
	 * @param mainOrderId
	 * @param tradeNo
	 * @param uid
	 * @param logInfo
	 * @return
	 * @throws ServiceException
	 */
	@SuppressWarnings({"rawtypes", "unused"})
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public synchronized IntegralGoodsOrderBO completePay(Long orderId, String paymetType)
			throws ServiceException {
		IntegralGoodsOrderBO igOrder = this.integralGoodsOrderDao.get(orderId);

		if (igOrder == null) {
			throw new ServiceException("未找到对应的订单");
		}

		// 如果订单已经支付，直接返回
		if (igOrder.getIgoStatus() >= IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED) {
			return igOrder;
		}

		igOrder.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED);
		igOrder.setIgoPayTime(new Date());
		/*igOrder.setIgoPayment(paymetType);*/
		this.integralGoodsOrderDao.update(igOrder);

		List<Map> ig_maps = this.orderFormTools.query_integral_goodsinfo(igOrder.getGoodsInfo());
//		for (Map map : ig_maps) {
		// 减少库存
//			IntegralGoods goods = this.integralGoodsDao.get(CommUtil.null2Long(map.get("id")));

//			Integer goodsCounts =  goods.getIgGoodsCount() - CommUtil.null2Int(map.get("ig_goods_count"));

//			goods.setIgGoodsCount(goodsCounts);

//			long id = CommUtil.null2Long(map.get("id"));
//			
//			int count = CommUtil.null2Int(map.get("ig_goods_count"))<0?0:CommUtil.null2Int(map.get("ig_goods_count"));
//
//			this.integralGoodsDao.subtractGoodsCount(id, count);
//
//			this.integralGoodsDao.addExchangeCount(id, count);
//		}
		return igOrder;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean save(IntegralGoodsOrder integralGoodsOrder) {
		/**
		 * init other field here
		 */
		try {
			this.integralGoodsOrderDao.save(integralGoodsOrder);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<IntegralGoodsOrderBO> selectByUser(long userId, MyPage<IntegralGoodsOrderBO> page) {
		return integralGoodsOrderDao.selectByUser(userId, page);
	}

	public IntegralGoodsOrderBO getObjById(Long id) {
		IntegralGoodsOrderBO integralGoodsOrder = integralGoodsOrderDao.get(id);
		if (integralGoodsOrder != null) {
			UserCustomer userCustomer = userCustomerDao.findById(integralGoodsOrder.getIgoUserId());
			integralGoodsOrder.setUserCustomer(userCustomer);
			return integralGoodsOrder;
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean delete(Long id) {
		try {
			this.integralGoodsOrderDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean batchDelete(List<Serializable> integralGoodsOrderIds) {
		for (Serializable id : integralGoodsOrderIds) {
			delete((Long) id);
		}
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean update(IntegralGoodsOrder integralGoodsOrder) {
		try {
			this.integralGoodsOrderDao.update(integralGoodsOrder);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void findPageByVo(MyPage<IntegralGoodsOrderBO> page, IntegralGoodsOrderVO vo) {
		List<IntegralGoodsOrderBO> content = this.integralGoodsOrderDao.findListByVo(page, vo);
		page.setContent(content);
	}

	/** 查询运费总额 **/
	public BigDecimal countTransFeeByVO(IntegralGoodsOrderVO vo) {
		BigDecimal result = this.integralGoodsOrderDao.countTransFeeByVO(vo);
		if (null == result) {
			result = BigDecimal.ZERO;
		}
		return result;
	}

	/** 兑换积分总额 **/
	public Long countIntegralByVO(IntegralGoodsOrderVO vo) {
		Long result = this.integralGoodsOrderDao.countIntegralByVO(vo);
		if (null == result) {
			result = 0L;
		}
		return result;
	}

	public IntegralGoodsOrderBO getById(Long id) {
		IntegralGoodsOrderBO result = this.integralGoodsOrderDao.getById(id);
		if (result != null) {
			return result;
		}
		return null;
	}

	/**
	 * 积分兑换订单保存业务方法
	 * 
	 * @param vo
	 * @param obj
	 * @param ec
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void integralGoodsOrderShipSave(IntegralGoodsOrderVO vo, IntegralGoodsOrder obj, ExpressCompany ec) {
		obj.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_SENT);
		obj.setIgoShipCode(vo.getIgoShipCode());
		if (obj.getIgoShipTime() == null) {// 为空存进发货时间，不为空表示是修改物流，不操作。
			obj.setIgoShipTime(new Date());
			String msg_content = "您积分订单号为：" + obj.getIgoOrderSn() + "的商品已发货，物流单号为：" + vo.getIgoShipCode()
					+ "，请注意查收！";
			// 发送系统站内信
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setStatus(0);
			msg.setType(0);
			msg.setContent(msg_content);
			msg.setFromUserId(vo.getUid());
			msg.setToUserId(obj.getIgoUserId());
			this.messageDao.save(msg);
		} else {// 修改物流单号
			String msg_content = "您积分订单号为：" + obj.getIgoOrderSn() + "的商品已经更改物流信息，新物流单号为："
					+ vo.getIgoShipCode() + "，请注意查收！";
			// 发送系统站内信
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setStatus(0);
			msg.setType(0);
			msg.setContent(msg_content);
			msg.setFromUserId(vo.getUid());
			msg.setToUserId(obj.getIgoUserId());
			this.messageDao.save(msg);
		}
		obj.setIgoShipContent(vo.getIgoShipContent());
		Map<String, Object> json_map = new HashMap<String, Object>();
		json_map.put("express_company_id", ec.getId());
		json_map.put("express_company_name", ec.getCompanyName());
		json_map.put("express_company_mark", ec.getCompanyMark());
		json_map.put("express_company_type", ec.getCompanyType());
		String express_json = Json.toJson(json_map, JsonFormat.compact());
		obj.setIgoExpressInfo(express_json);
		update(obj);
	}

	/**
	 * 积分兑换取消业务方法
	 * 
	 * @param adminUid
	 * @param obj
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void integralGoodsOrderCancel(Long adminUid, IntegralGoodsOrder obj) {

		// 订单状态设置为取消状态
		obj.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_CANCELLED);
		this.integralGoodsOrderDao.update(obj);

		// 返回库存
		List<IntegralGoods> igs = this.orderFormTools.query_integral_all_goods(CommUtil.null2String(obj
				.getId()));
		for (IntegralGoods ig : igs) {
			int count = this.orderFormTools.query_integral_one_goods_count(obj,
					CommUtil.null2String(obj.getId()));
			ig.setIgGoodsCount(ig.getIgGoodsCount() + count);
			this.integralGoodsDao.update(ig);
		}
		// 记录日志
		UserCustomerBO userBO = userCustomerDao.findSessionUser(obj.getIgoUserId());
		integralLogService.saveLog("取消" + obj.getIgoOrderSn() + "积分兑换，返还积分", obj.getIgoUserId(), adminUid,
				obj.getIgoTotalIntegral(), userBO.getIntegral(), IntegralConstants.INTEGRAL_ORDER);

		// 返还积分
		this.userCustomerDao.addIntegral(obj.getIgoUserId(), obj.getIgoTotalIntegral());

	}

	/**
	 * 积分兑换 查询待发货订单
	 * 
	 * @return
	 */
	public List<IntegralGoodsOrderBO> findForExcel(MyPage<IntegralGoodsOrderBO> page, String startTime,
			String endTime, String status) {
		return integralGoodsOrderDao.findForExcel(page, startTime, endTime, status);
	}

	/***
	 * 积分自动取消功能
	 * 
	 */
	@Transactional
	public void IntegralOrderAutoCancel() {
		List<IntegralGoodsOrderBO> res = this.integralGoodsOrderDao.findNoPayThirdDay();// 72小时未支付的订单

		for (IntegralGoodsOrderBO bo : res) {
			// 订单状态设置为取消状态
			IntegralGoodsOrder order = new IntegralGoodsOrder();
			order.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_CANCELLED);
			order.setId(bo.getId());
			this.integralGoodsOrderDao.update(order);

			// 记录日志
			UserCustomerBO userBO = userCustomerDao.findSessionUser(bo.getIgoUserId());
			integralLogService.saveLog("取消" + bo.getIgoOrderSn() + "积分兑换，返还积分", bo.getIgoUserId(), null,
					bo.getIgoTotalIntegral(), userBO.getIntegral(), IntegralConstants.INTEGRAL_ORDER);

			// 返还积分
			this.userCustomerDao.addIntegral(bo.getIgoUserId(), bo.getIgoTotalIntegral());
		}

	}
}
