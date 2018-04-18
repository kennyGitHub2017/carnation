package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.pay.alipay.config.AlipayConfig;
import vc.thinker.b2b2c.pay.alipay.util.AlipayNotify;
import cn.eeepay.EeePayUtils;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.dao.ShopBonusRepeatLogDao;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.UserContants;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.GoldLogService;
import com.sinco.carnation.user.service.GoldRecordService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.carnation.user.service.UserRelationService;
import com.weixin.api.PayUtils;

/**
 * 
 * <p>
 * Title: PayViewAction.java
 * </p>
 * 
 * <p>
 * Description:在线支付回调控制器,处理系统支持的所有支付方式回调业务处理，包括支付宝、财付通、快钱、paypal、网银在线
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-25
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unused"})
public class PayViewAction {

	private static final Logger log = LoggerFactory.getLogger(PayViewAction.class);
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private GoldRecordService goldRecordService;
	@Autowired
	private GoldLogService goldLogService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;

	@Autowired
	private IntegralGoodsService integralGoodsService;
	// @Autowired
	// private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private StoreService storeService;
	// @Autowired
	// private GroupLifeGoodsService groupLifeGoodsService;
	// @Autowired
	// private GroupInfoService groupInfoService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private PayoffLogService payoffservice;
	@Autowired
	private LuceneVoTools luceneVoTools;
	// @Autowired
	// private BuyGiftViewTools buyGiftViewTools;
	@Autowired
	private GoodsLogService goodsLogService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private PayTools payTools;
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private UserRelationService relationService;
	@Autowired
	private RebateService rebateService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private ShopBonusRepeatLogDao ShopBonusRepeatLogDao;
	@Autowired
	private JiuyeOrderFormService JiuyeOrderFormService;

	@SecurityMapping(title = "订单支付内容", value = "/pay.htm*", rtype = "buyer", rname = "支付", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/pay.htm")
	public ModelAndView order_pay_view(HttpServletRequest request, HttpServletResponse response,
			Double allOfPrice) {
		ModelAndView mv = new JModelAndView("pay.html", configService.getSysConfig(), 1, request, response);
		UserCustomerBO customer = customerService.findSessionUser(SecurityUserHolder.getCurrentUserId());
		mv.addObject("customer", customer);
		mv.addObject("payTools", payTools);
		mv.addObject("all_of_price", CommUtil.null2Double(request.getAttribute("allOfPrice")));

		User user = SecurityUserHolder.getCurrentUser();
		// CN奖金
		double cnBonus = 0;
		double cnRepeat = 0;
		boolean bl = false;
		List<UserAccountBO> userAccount = this.accountService.findUserAccountByUid(user.getId());
		for (UserAccountBO account : userAccount) {
			if ("8".equals(account.getAccountType())) {
				bl = true;
				break;
			}
		}

		if (bl) {

			UserAccount resAccount = this.accountService.findByUid(user.getId(), "8");
			try {

				CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService.getCnUserBounsMoney(resAccount
						.getLoginName());// 奖金
				if (cnUserMoneyBO != null) {
					if (null != cnUserMoneyBO.getISPAY() && 1 == cnUserMoneyBO.getISPAY().intValue()) {
						// mv.addObject("cnBonus", cnUserMoneyBO.getBONUS());
						if (null != cnUserMoneyBO.getBONUS()) {
							cnBonus = cnUserMoneyBO.getBONUS();
						}
					}
				}

				CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService.getCnUserRepeatMoney(resAccount
						.getLoginName());// 重消
				if (cnUserMoneyBO1 != null) {
					if (null != cnUserMoneyBO1.getISPAY() && 1 == cnUserMoneyBO1.getISPAY().intValue()) {
						// mv.addObject("cnRepeat", cnUserMoneyBO1.getBONUS_REPEAT());
						if (null != cnUserMoneyBO1.getBONUS_REPEAT()) {
							cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
						}
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			mv.addObject("isCnUserFlag", "true");// 表示CN账户
		}
		mv.addObject("cnRepeat", cnRepeat);
		mv.addObject("cnBonus", cnBonus);
		return mv;
	}

	@SecurityMapping(title = "订单是否支付完成", value = "/payResult.htm*", rtype = "buyer", rname = "支付结果", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/payResult.htm")
	public void payResult(HttpServletRequest request, HttpServletResponse response, String type,
			String orderNo) {
		boolean reuslt = false;
		if (PaymentConstants.ORDER_TYPE_GOODS.equals(type)) {
			OrderFormBO of = this.orderFormService.findByOrderNo(orderNo);
			if (of != null && of.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				reuslt = true;
			}
		} else if (PaymentConstants.ORDER_TYPE_CASH.equals(type)) {
			PredepositBO bo = this.predepositService.findByPdSn(orderNo);
			if (bo != null && bo.getPdPayStatus() == UserContants.PD_PAY_STATUS_2) {
				reuslt = true;
			}
		} else if (PaymentConstants.ORDER_TYPE_INTEGRAL.equals(type)) {
			IntegralGoodsOrderBO bo = this.integralGoodsOrderService.findByIgoOrderSn(orderNo);
			if (bo != null && bo.getIgoStatus() >= IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED) {
				reuslt = true;
			}
		} else if (PaymentConstants.ORDER_TYPE_GROUP.equals(type)) {
			GroupOrderBO order = groupOrderService.findByOrderNo(orderNo);
			if (order != null && order.getOrderStatus() >= GroupOrderConstants.ORDER_STATUS_PAYMENT)
				reuslt = true;
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(reuslt);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 支付宝在线支付成功回调控制
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/alipay_return.htm")
	public ModelAndView aplipay_return(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("=====================PayViewAction->alipay_return================");
		ModelAndView mv = new JModelAndView("order_finish.html", configService.getSysConfig(), 1, request,
				response);
		String trade_no = request.getParameter("trade_no"); // 支付宝交易号
		String[] order_nos = request.getParameter("out_trade_no").split("-"); // 获取订单号
		String total_fee = request.getParameter("total_fee"); // 获取总金额
		String subject = request.getParameter("subject");// new

		String type = CommUtil.null2String(request.getParameter("body")).trim();

		// String(request.getParameter("subject").getBytes("ISO-8859-1"),
		// "UTF-8");//
		// 商品名称、订单名称
		String order_no = "";// order_nos[2];
		if (type.equals("mchAliQrPay")) {
			order_no = order_nos[0];
		} else {
			order_no = order_nos[2];
		}

		String trade_status = request.getParameter("trade_status"); // 交易状态
		logger.info("Callback Info: tradeStatus=" + trade_status + ",order_no=" + order_no + ",type=" + type + ",order_nos" + order_nos + ",trade_no=" + trade_no);
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 如果没有配置Tomcat的get编码为UTF-8，需要下面一行代码转码，否则会出现乱码，导致回调失败
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		AlipayConfig config = new AlipayConfig();
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY, true);

		config.setKey(payment.getSafeKey());
		config.setPartner(payment.getPartner());
		config.setSeller_email(payment.getSellerEmail());

		config.setNotify_url(CommUtil.getURL(request) + "/alipay_notify.htm");
		config.setReturn_url(CommUtil.getURL(request) + "/aplipay_return.htm");
		boolean verify_result = AlipayNotify.verify(config, params);
		logger.info("aplipay verify result: " + verify_result);
		// 验证是否成功
		if (!verify_result) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "支付回调失败");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		if (trade_status.equalsIgnoreCase("TRADE_SUCCESS") || trade_status.equalsIgnoreCase("TRADE_FINISHED")) {
			return payHandle(type, trade_no, Double.parseDouble(total_fee), order_no,
					PaymentConstants.PAYMENT_MARK_ALIPAY, request, response);
		} else {
			log.error(String.format("trade_status:%s order_no:%s body:%s", trade_status, order_no, type));
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "支付失败");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
	}

	/**
	 * 
	 * @param type
	 * @param order_no
	 * @return
	 */
	private ModelAndView payHandle(String type, String tradeNo, double totalFee, String orderNo,
			String paymentType, HttpServletRequest request, HttpServletResponse response) {
		logger.info("PayViewAction->payHandle: type=" + type + ",tradeNo=" + tradeNo + ",orderNo=" + orderNo + ",paymentType=" + paymentType + ",money=" + totalFee);
		ModelAndView mv = new JModelAndView("order_finish.html", configService.getSysConfig(), 1, request,
				response);

		try {
			Object obj = doPayHandle(type, tradeNo, totalFee, orderNo, paymentType);
			if (obj == null) {
				return mv;
			}
			if (type.equals("goods")) {
				mv.addObject("all_price", this.orderFormTools.query_order_price((OrderForm) obj));
				mv.addObject("obj", obj);
			}
			if (type.equals("group")) {
				mv = new JModelAndView("order_life_finish.html", configService.getSysConfig(), 1, request,
						response);
				mv.addObject("all_price", ((GroupOrderBO) obj).getTotalPrice());
				mv.addObject("obj", obj);
			}
			if (type.equals("cash")) {
				if (obj instanceof Predeposit) {
					mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "恭喜您，成功充值" + ((Predeposit) obj).getPdAmount() + "元");
					mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
				} else if (obj instanceof GroupOrderBO) {
					mv = new JModelAndView("order_life_finish.html", configService.getSysConfig(), 1,
							request, response);
					Map map = orderFormTools.queryGroupInfo(((GroupOrderBO) obj).getGroupInfo());
					mv.addObject("all_price", map.get("goods_total_price"));
					mv.addObject("obj", obj);
				} else {
					mv.addObject("all_price", this.orderFormTools.query_order_price((OrderForm) obj));
					mv.addObject("obj", obj);
				}
			}
			if (type.equals("gold")) {
				// mv = new JModelAndView("success.html",
				// configService.getSysConfig(),
				// 1, request,
				// response);
				// mv.addObject("op_title", "兑换" + gold.getGold_count()
				// + "金币成功");
				// mv.addObject("url", CommUtil.getURL(request)
				// + "/seller/gold_record_list.htm");
			}
			if (type.equals("integral")) {
				mv = new JModelAndView("integral_order_finish.html", configService.getSysConfig(), 1,
						request, response);
				mv.addObject("obj", obj);
			}
			if (type.equals("mchAliQrPay")) {
				mv = new JModelAndView("qr_pay/order_pay_status.html", configService.getSysConfig(), 1,
						request, response);
				mv.addObject("obj", obj);
				mv.addObject("payInfo", "支付宝支付");
			}

		} catch (ServiceException e) {
			logger.error("payHandle callback failed", e);
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			switch (type) {
				case "goods":
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
					break;
				case "cash":
					mv.addObject("url", CommUtil.getURL(request) + "/buyer/predeposit_list.htm");
					break;
				case "integral":
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
					break;
				default:
					break;
			}
		}

		return mv;
	}

	/**
	 * 
	 * @param type
	 * @param order_no
	 * @return
	 * @throws ServiceException
	 */
	private Object doPayHandle(String type, String tradeNo, double totalFee, String orderNo,
			String paymentType) throws ServiceException {
		logger.info("PayViewAction->doPayHandle: type=" + type + ",tradeNo=" + tradeNo + ",orderNo=" + orderNo + ",paymentType=" + paymentType + ",money=" + totalFee);
		String logInfo = null;
		logInfo = PaymentConstants.getPaymentName(paymentType);
		switch (paymentType) {
			case PaymentConstants.PAYMENT_MARK_ALIPAY:
				logInfo = "支付宝在线支付";
				break;
			case PaymentConstants.PAYMENT_MARK_ALIPAY_APP:
				logInfo = "支付宝在线支付";
				break;
			case PaymentConstants.PAYMENT_MARK_ALIPAY_WAP:
				logInfo = "支付宝在线支付";
				break;
			case PaymentConstants.PAYMENT_MARK_WX_APP:
				logInfo = "微信在线支付";
				break;
			case PaymentConstants.PAYMENT_MARK_WX_PAY:
				logInfo = "微信在线支付";
				break;
			case PaymentConstants.PAYMENT_MARK_WX_QR_PAY:
				logInfo = "微信扫码支付";
				break;
			case PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY:
				logInfo = "微信在线支付";
				break;
		}
		if (type.equals("goods")) {
			OrderForm orderForm = new OrderForm();
			OrderForm orderForm_ = this.orderFormService.fetch(CommUtil.null2Long(orderNo));
			
			if (orderForm_.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED
					|| orderForm_.getOrderStatus() == OrderFormConstants.ORDER_STATUS_ORDER_CANCEL) {
				return orderForm_;
			}
			
			if (null != orderForm_ && null != orderForm_.getIsygOrder()
					&& orderForm_.getIsygOrder() == true
					&& orderForm_.getPayTypeFlag().intValue() == 2) {//表示积分支付
				return this.orderFormService.handle_jforder(orderNo, tradeNo, totalFee);

			} else if (null != orderForm_ && null != orderForm_.getIsygOrder()
					&& orderForm_.getIsygOrder() == true
					&& orderForm_.getPayTypeFlag().intValue() == 1) {
				
				log.debug("进入handle_ygorder(orderNo, tradeNo, totalFee)");
				return this.orderFormService.handle_ygorder(orderNo, tradeNo,
						totalFee);
			} else if (null != orderForm_ && null != orderForm_.getIsygOrder()
					&& orderForm_.getIsygOrder() == true
					&& orderForm_.getPayTypeFlag().intValue() == 3) {//普通会员 精选专区
				return this.orderFormService.handle_jforder(orderNo, tradeNo, totalFee);

			} else {
				System.out.println("orderForm_.getOrderTypeFlag().intValue()"
						+ orderForm_.getOrderTypeFlag().intValue());
				if (null != orderForm_ && null != orderForm_.getOrderTypeFlag()
						&& orderForm_.getOrderTypeFlag().intValue() == 2) {
					return this.orderFormService.completePayForYg(CommUtil.null2Long(orderNo), tradeNo,
							logInfo, totalFee);
				} else {
					return this.orderFormService.completePay(CommUtil.null2Long(orderNo), tradeNo, logInfo);
				}

			}
		}
		if (type.equals("group")) {
			groupOrderService.generate_groupInfos(orderNo, paymentType, logInfo, tradeNo);

			return groupOrderService.getObjById(CommUtil.null2Long(orderNo));
		}
		if (type.equals("cash")) {
			Predeposit predeposit = moneyService.rechargeMoney(CommUtil.null2Long(orderNo), logInfo);
			if (predeposit.getPdOrderId() == null) {
				return predeposit;
			} else {
				if (PaymentConstants.ORDER_TYPE_GOODS.equals(predeposit.getPdOrderType())) {
					// 如果充值有支付订单，进行云豆支付订单
					OrderForm orderForm = orderFormService.completeMoneyPay(predeposit.getPdOrderId(), null,
							"");
					return orderForm;

				} else if (PaymentConstants.ORDER_TYPE_INTEGRAL.equals(predeposit.getPdOrderType())) {
					// 有需要支付的积分定单
					IntegralGoodsOrder igOrder = this.integralGoodsOrderService.completeMoneyPay(
							predeposit.getPdOrderId(), null);
					return igOrder;
				} else if (PaymentConstants.ORDER_TYPE_GROUP.equals(predeposit.getPdOrderType())) {
					// 如果充值有支付订单，进行云豆支付订单
					long uid = groupOrderService.getObjById(predeposit.getPdOrderId()).getUserId();
					GroupOrderBO go = groupOrderService.orderPay(null, predeposit.getPdOrderId(), uid, true,
							null, null);

					return go;
				}
			}
		}
		if (type.equals("gold")) {

		}
		if (type.equals("integral")) {
			IntegralGoodsOrder igOrder = this.integralGoodsOrderService.completePay(
					CommUtil.null2Long(orderNo), paymentType);
			return igOrder;
		} else if (type.equals("mchWxQrPay") || type.equals("mchAliQrPay")) {
			ShopQrPayOrderBO bo = shopQrPayOrderService.complateOrderByPayOrderNo(orderNo, tradeNo);
			return bo;
		}
		return null;
	}

	/**
	 * 支付宝异步通知
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	protected static final String KEY_NOTIFY_DATA = "notify_data";

	/**
	 * 微信回调 方法
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/weixin_notify.htm")
	public void weixin_qr_pay_notify(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("===============PayViewActoin->weixin_qr_pay_notify=================");
		Map payCallbackNotify = PayUtils.payCallbackNotify(request.getInputStream());
		System.out.println(payCallbackNotify);
		if (payCallbackNotify == null) {
			return;
		}
		String returnOutTradeNo = String.valueOf(payCallbackNotify.get("out_trade_no"));
		log.info("returnOutTradeNo{}",returnOutTradeNo);
		String type = String.valueOf(payCallbackNotify.get("attach"));
		String[] order_nos = String.valueOf(payCallbackNotify.get("out_trade_no")).split("-"); // 获取订单号
		String order_no = "";
		String paymentType = PaymentConstants.PAYMENT_MARK_WX_QR_PAY;
		if (type.equals("mchWxQrPay")) {
			paymentType = PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY;
			order_no = String.valueOf(payCallbackNotify.get("out_trade_no"));
		} else {
			order_no = order_nos[2];
		}
		
		Payment payment = null;
		if (returnOutTradeNo.startsWith("jyorder")) {
			payment = this.paymentService.findByMark("wx_app");
		} else {
			payment = getPayment(type, order_no);
		}
		boolean validate = PayUtils.validateAppSignature(payCallbackNotify, payment.getWxPaysignkey());
		logger.info("PayViewActoin->weixin_qr_pay_notify validate=" + validate + ",type=" + type);
		if (validate && "SUCCESS".equals(payCallbackNotify.get("result_code")) && "SUCCESS".equals(payCallbackNotify.get("return_code"))) {
			logger.info("validate success.");
			String trade_no = String.valueOf(payCallbackNotify.get("transaction_id")); // 微信交易号
			String total_fee = String.valueOf(payCallbackNotify.get("total_fee")); // 获取总金额

			if (type.equals("mchWxQrPay")) {
				paymentType = PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY;
			}
			if (returnOutTradeNo.startsWith("jyorder")) {//酒业订单回调
				this.JiuyeOrderFormService.orderPayPayHandle(order_no, CommUtil.div(total_fee, 100));
			} else {
				doPayHandle(type, trade_no, CommUtil.div(total_fee, 100), order_no, paymentType);// 微信支付修改订单状态
			}
			
			String content = PayUtils.generatePaySuccessReplyXML();// 微信通知返回
			response.getOutputStream().write(content.getBytes());
		}
	}

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/eeepay_notify.htm")
	public void eeepay_pay_notify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String responseBody = request.getParameter("responseBody");
		byte[] result = Base64.decodeBase64(responseBody);
		// byte[] result =
		// "success=true&msg=成功&amount=0.02&orderNo=P_1441619116295144161904588272145&channel=0".getBytes();
		String query = new String(result, "utf-8");
		Map<String, String> parameters = EeePayUtils.getQueryMap(query);
		String ssuc = parameters.get("success");
		if ("true".equals(ssuc)) {
			double amount = Double.parseDouble(parameters.get("amount"));
			String orderNo = parameters.get("orderNo");
			String tradeNo = EeePayUtils.validateCallbackNotify(orderNo, amount);
			if (StringUtils.isNotEmpty(tradeNo)) {
				// tradeno为原始订单号，检测订单金额正确后，标记已付款。
				// to james
				GroupOrderBO groupOrderBO = groupOrderService.findByOrderNo(tradeNo);
				amount = groupOrderBO.getTotalPrice().doubleValue();
				if (groupOrderBO != null) {
					boolean flag = rebateService.lineProfit(amount, groupOrderBO, true);
					if (flag) {
						response.getOutputStream().write("success".getBytes());
					}
					// StoreBO storeBO =
					// storeService.getObjById(CommUtil.null2Long(groupOrderBO.getStoreId()));
					// if (num == 200) {
					// // 手续费返润
					// rebateService.sendCommissionChargeRebate(storeBO.getCreateUserId(),
					// groupOrderBO.getId(),
					// groupOrderBO.getTotalPrice());
					// rebateService.addRebateLog(groupOrderBO.getId(), null,
					// "消费返润", true, null);
					// // 赠送积分
					// integralService.addIntegral(IntegralConstants.INTEGRAL_CONSUMER,
					// groupOrderBO.getUserId(),
					// CommUtil.null2String(amount), null, "offlineOrder",
					// null);
					// response.getOutputStream().write("success".getBytes());
					// return;
					// } else {
					//
					// rebateService.addRebateLog(groupOrderBO.getId(), null,
					// "消费返润", false, null);
					// response.getOutputStream().write("fail".getBytes());
					// }
				}
			}
		}

		response.getOutputStream().write("fail".getBytes());

	}

	/**
	 * 根据不同订单拿到支付方式
	 * 
	 * @param type
	 * @param order_no
	 * @return
	 * @throws ServiceException
	 */
	private Payment getPayment(String type, String orderNo) {
		Long orderId = CommUtil.null2Long(orderNo);

		if (type.equals("goods")) {
			OrderForm orderForm = this.orderFormService.getObjById(orderId);
			return paymentService.getObjById(orderForm.getPaymentId());
		} else if (type.equals("group")) {
			GroupOrderBO go = groupOrderService.getObjById(CommUtil.null2Long(orderNo));
			return paymentService.findByMark(go.getPaymentMark());
		} else if (type.equals("cash")) {
			Predeposit predeposit = predepositService.getObjById(orderId);
			return paymentService.findByMark(predeposit.getPdPayment());
		} else if (type.equals("gold")) {
		} else if (type.equals("mchWxQrPay")) {
			return paymentService.findByMark(PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY);
		} else if (type.equals("mchAliQrPay")) {
			return paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_WAP);
		}

		else if (type.equals("integral")) {
			IntegralGoodsOrder igOrder = this.integralGoodsOrderService.getById(orderId);
			return paymentService.findByMark(igOrder.getIgoPayment());
		}
		return null;
	}

	@SuppressWarnings("static-access")
	@RequestMapping("/alipay_notify.htm")
	public void alipay_notify(HttpServletRequest req, HttpServletResponse resp) {
		logger.info("=================HHHHHHHHHHHHHHHHHHHHHHHHHHHHHH====PayViewAction->alipay_notify================");
		String trade_no = req.getParameter("trade_no"); // 支付宝交易号
		System.out.println("trade_no11"+trade_no);
		if (StringUtils.isBlank(trade_no)) {
			resp.setContentType("text/plain");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer;
			try {
				writer = resp.getWriter();
				writer.print("fail");
			} catch (IOException e) {
				log.error("", e);
			}
			return;
		}
		String returnOutTradeNo = req.getParameter("out_trade_no");
		String type = CommUtil.null2String(req.getParameter("body")).trim();
		String[] order_nos = req.getParameter("out_trade_no").split("-"); // 获取订单号
		String total_fee = req.getParameter("total_fee"); // 获取总金额
		String subject = req.getParameter("subject");// new
		// String(request.getParameter("subject").getBytes("ISO-8859-1"),
		// "UTF-8");//
		// 商品名称、订单名称
		String order_no = "";
		if (type.equals("mchAliQrPay")) {
			order_no = order_nos[0];
		} else {
			order_no = order_nos[2];
		}
		String trade_status = req.getParameter("trade_status"); // 交易状态
		logger.info("支付宝 返回 Callback Info: tradeStatus=" + trade_status + ",order_no=" + order_no + ",type=" + type + ",order_nos" + order_nos + ",trade_no=" + trade_no);
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map requestParams = req.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 如果没有配置Tomcat的get编码为UTF-8，需要下面一行代码转码，否则会出现乱码，导致回调失败
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		AlipayConfig config = new AlipayConfig();
		
		Payment payment = null;
		if (returnOutTradeNo.startsWith("jyorder")) {
			payment = this.paymentService.findByMark("alipay_app");
		} else {
			payment = getPayment(type, order_no);
		}

		config.setKey(payment.getSafeKey());
		config.setPartner(payment.getPartner());
		config.setSeller_email(payment.getSellerEmail());
		config.setAli_public_key(payment.getAppPublicKey());
		if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {
			config.setSign_type("RSA");
		}
		
		if (PaymentConstants.PAYMENT_MARK_YG_AL.equals(payment.getMark())) {
			config.setSign_type("RSA");
		}
		
		if (PaymentConstants.PAYMENT_MARK_JF_AL.equals(payment.getMark()) ||
				PaymentConstants.PAYMENT_MARK_PTJF_AL.equals(payment.getMark())) {
			config.setSign_type("RSA");
		}

		config.setNotify_url(CommUtil.getURL(req) + "/alipay_notify.htm");
		config.setReturn_url(CommUtil.getURL(req) + "/aplipay_return.htm");
		boolean verify_result = AlipayNotify.verify(config, params);
		
		log.info("[verify_result]=============>"+verify_result);

		/*
		 * if (gateway.publish(n)) out.print("success");
		 */

		if (!verify_result) {// 验证是否成功
			resp.setContentType("text/plain");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer;
			try {
				writer = resp.getWriter();
				writer.print("fail");
			} catch (IOException e) {
				log.error("", e);
			}
			return;
		}

		try {

			if (trade_status.equalsIgnoreCase("TRADE_SUCCESS")
					|| trade_status.equalsIgnoreCase("TRADE_FINISHED")) {
				log.info("[进入回调改写订单状态的入口]{}",order_no);
				if (returnOutTradeNo.startsWith("jyorder")) {
					this.JiuyeOrderFormService.orderPayPayHandle(order_no, Double.parseDouble(total_fee));
				} else {
					doPayHandle(type, trade_no, Double.parseDouble(total_fee), order_no,
							PaymentConstants.PAYMENT_MARK_ALIPAY);
				}
			

			} else {
				log.error(String.format("trade_status:%s order_no:%s body:%s", trade_status, order_no, type));
				throw new ServiceException("支付失败");
			}
		} catch (ServiceException e1) {
			log.info("支付宝订单["+ trade_no +"]通知执行失败", e1);

			resp.setContentType("text/plain");
			resp.setHeader("Cache-Control", "no-cache");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter writer;
			try {
				writer = resp.getWriter();
				writer.print("fail");
			} catch (IOException e) {
				log.error("", e);
			}
			return;
		}

		resp.setContentType("text/plain");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = resp.getWriter();
			writer.print("success");
		} catch (IOException e) {
			log.error("", e);
		}
	}

	/**
	 * 快钱在线支付回调处理控制
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	// @RequestMapping("/bill_return.htm")
	// public ModelAndView bill_return(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// ModelAndView mv = new JModelAndView("order_finish.html",
	// configService.getSysConfig(),
	// 1, request, response);
	// // 获取扩展字段1
	// String ext1 = (String) request.getParameter("ext1").trim();
	// String ext2 = CommUtil.null2String(request.getParameter("ext2").trim());
	// OrderForm order = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (ext2.equals("goods") || ext2.equals("group")) {
	// order = this.orderFormService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("cash")) {
	// obj = this.predepositService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(ext1));
	// }
	// // 获取人民币网关账户号
	// String merchantAcctId = (String) request.getParameter("merchantAcctId")
	// .trim();
	// // 设置人民币网关密钥
	// // /区分大小写
	// String key = "";
	// if (ext2.equals("goods") || ext2.equals("group")) {
	// key = order.getPayment().getRmbKey();
	// }
	// if (ext2.equals("cash") || ext2.equals("gold")
	// || ext2.equals("integral")) {
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// if (ext2.equals("cash")) {
	// q_params.put("mark", obj.getPd_payment());
	// }
	// if (ext2.equals("gold")) {
	// q_params.put("mark", gold.getGold_payment());
	// }
	// if (ext2.equals("integral")) {
	// q_params.put("mark", ig_order.getIgo_payment());
	// }
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// key = payments.get(0).getRmbKey();
	// }
	// // /快钱会根据版本号来调用对应的接口处理程序。
	// // /本代码版本号固定为v2.0
	// String version = (String) request.getParameter("version").trim();
	// // 获取语言种类.固定选择值。
	// // /只能选择1、2、3
	// // /1代表中文；2代表英文
	// // /默认值为1
	// String language = (String) request.getParameter("language").trim();
	// // 签名类型.固定值
	// // /1代表MD5签名
	// // /快钱3.0后该值为4
	// String signType = (String) request.getParameter("signType").trim();
	//
	// // 获取支付方式
	// // /值为：10、11、12、13、14
	// //
	// /00：组合支付（网关支付页面显示快钱支持的各种支付方式，推荐使用）10：银行卡支付（网关支付页面只显示银行卡支付）.11：电话银行支付（网关支付页面只显示电话支付）.12：快钱账户支付（网关支付页面只显示快钱账户支付）.13：线下支付（网关支付页面只显示线下支付方式）.14：B2B支付（网关支付页面只显示B2B支付，但需要向快钱申请开通才能使用）
	// String payType = (String) request.getParameter("payType").trim();
	//
	// // 获取银行代码
	// // /参见银行代码列表
	// String bankId = (String) request.getParameter("bankId").trim();
	// // 获取商户订单号
	// String orderId = (String) request.getParameter("orderId").trim();
	// // 获取订单提交时间
	// // /获取商户提交订单时的时间.14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	// // /如：20080101010101
	// String orderTime = (String) request.getParameter("orderTime").trim();
	// // 获取原始订单金额
	// // /订单提交到快钱时的金额，单位为分。
	// // /比方2 ，代表0.02元
	// String orderAmount = (String) request.getParameter("orderAmount")
	// .trim();
	// // 获取快钱交易号
	// // /获取该交易在快钱的交易号
	// String dealId = (String) request.getParameter("dealId").trim();
	// // 获取银行交易号
	// // /如果使用银行卡支付时，在银行的交易号。如不是通过银行支付，则为空
	// String bankDealId = (String) request.getParameter("bankDealId").trim();
	// // 获取在快钱交易时间
	// // /14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	// // /如；20080101010101
	// String dealTime = (String) request.getParameter("dealTime").trim();
	// // 获取实际支付金额
	// // /单位为分
	// // /比方 2 ，代表0.02元
	// String payAmount = (String) request.getParameter("payAmount").trim();
	// // 获取交易手续费
	// // /单位为分
	// // /比方 2 ，代表0.02元
	// String fee = (String) request.getParameter("fee").trim();
	// // 获取扩展字段2
	// // /10代表 成功11代表 失败
	// String payResult = (String) request.getParameter("payResult").trim();
	// // 获取错误代码
	// String errCode = (String) request.getParameter("errCode").trim();
	// // 获取加密签名串
	// String signMsg = (String) request.getParameter("signMsg").trim();
	// // 生成加密串。必须保持如下顺序。
	// String merchantSignMsgVal = "";
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "merchantAcctId",
	// merchantAcctId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "version", version);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "language",
	// language);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "signType",
	// signType);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payType", payType);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankId", bankId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderId", orderId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderTime",
	// orderTime);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderAmount",
	// orderAmount);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealId", dealId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankDealId",
	// bankDealId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealTime",
	// dealTime);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payAmount",
	// payAmount);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "fee", fee);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext1", ext1);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext2", ext2);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payResult",
	// payResult);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "errCode", errCode);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "key", key);
	//
	// String merchantSignMsg = MD5Util.md5Hex(
	// merchantSignMsgVal.getBytes("utf-8")).toUpperCase();
	// // 商家进行数据处理，并跳转会商家显示支付结果的页面
	// // /首先进行签名字符串验证
	// if (signMsg.toUpperCase().equals(merchantSignMsg.toUpperCase())) {
	// // /接着进行支付结果判断
	// switch (Integer.parseInt(payResult)) {
	// case 10:
	// //
	// 特别注意：只有signMsg.toUpperCase().equals(merchantSignMsg.toUpperCase())，且payResult=10，才表示支付成功！同时将订单金额与提交订单前的订单金额进行对比校验。
	// if (ext2.equals("goods")) {
	// User buyer = this.userService.getObjById(CommUtil
	// .null2Long(order.getUser_id()));
	// if (order.getOrder_status() != 20) {
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);//
	// 主订单付款成功，订单状态更新，同时更新商品库存，如果是团购商品，则更新团购库存
	// this.update_goods_inventory(order);
	// OrderFormLog main_ofl = new OrderFormLog();
	// main_ofl.setAddTime(new Date());
	// main_ofl.setLog_info("快钱在线支付");
	// main_ofl.setLog_user(buyer);
	// main_ofl.setOf(order);
	// this.orderFormLogService.save(main_ofl);
	// this.send_msg_tobuyer(request, order);
	// this.send_msg_toseller(request, order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals(
	// "")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order
	// .getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil
	// .null2Long(child_map
	// .get("order_id")));
	// child_order.setPayTime(new Date());
	// child_order.setOrder_status(20);
	// this.orderFormService.update(child_order);
	// this.update_goods_inventory(order);
	// OrderFormLog child_ofl = new OrderFormLog();
	// child_ofl.setAddTime(new Date());
	// child_ofl.setLog_info("快钱在线支付");
	// child_ofl.setLog_user(buyer);
	// child_ofl.setOf(child_order);
	// this.orderFormLogService.save(child_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 付款成功，发送短信提示
	// this.send_msg_toseller(request, child_order);
	// }
	//
	// }
	// }
	// mv.addObject("obj", order);
	// }
	// if (ext2.equals("group")) {
	// this.generate_groupInfos(request, order, "bill", "快钱在线支付",
	// "");
	// mv.addObject("obj", order);
	// }
	// if (ext2.equals("cash")) {
	// if (obj.getPd_pay_status() < 2) {// 判断预存款支付状态
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj
	// .getPd_user().getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil
	// .add(user.getAvailableBalance(),
	// obj.getPd_amount())));
	// this.userService.update(user);
	// PredepositLog log = new PredepositLog();
	// log.setAddTime(new Date());
	// log.setPd_log_amount(obj.getPd_amount());
	// log.setPd_log_user(obj.getPd_user());
	// log.setPd_op_type("充值");
	// log.setPd_type("可用预存款");
	// log.setPd_log_info("快钱在线支付");
	// this.predepositLogService.save(log);
	// }
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "充值" + obj.getPd_amount() + "成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/predeposit_list.htm");
	// }
	// if (ext2.equals("gold")) {
	// if (gold.getGold_pay_status() < 2) {// 判断金币充值状态
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold
	// .getGold_user().getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("快钱在线支付");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// }
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "兑换" + gold.getGold_count()
	// + "金币成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/seller/gold_record_list.htm");
	// }
	// if (ext2.equals("integral")) {
	// if (ig_order.getIgo_status() < 20) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("bill");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order
	// .getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map
	// .get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// goods.setIg_exchange_count(goods
	// .getIg_exchange_count()
	// + CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// }
	// mv = new JModelAndView("integral_order_finish.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("obj", ig_order);
	// }
	// break;
	// default:
	// mv = new JModelAndView("error.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "快钱支付失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// break;
	//
	// }
	//
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "快钱支付失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// }
	// return mv;
	// }

	public String appendParam(String returnStr, String paramId, String paramValue) {
		if (!returnStr.equals("")) {
			if (!paramValue.equals("")) {
				returnStr = returnStr + "&" + paramId + "=" + paramValue;
			}
		} else {
			if (!paramValue.equals("")) {
				returnStr = paramId + "=" + paramValue;
			}
		}
		return returnStr;
	}

	// /**
	// * 快钱异步回调处理，如果同步回调出错，异步回调会弥补该功能
	// *
	// * @param request
	// * @param response
	// * @throws Exception
	// */
	// @RequestMapping("/bill_notify_return.htm")
	// public void bill_notify_return(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// int rtnOK = 0;
	// // 获取扩展字段1
	// String ext1 = (String) request.getParameter("ext1").trim();
	// String ext2 = CommUtil.null2String(request.getParameter("ext2").trim());
	// OrderForm order = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (ext2.equals("goods") || ext2.equals("group")) {
	// order = this.orderFormService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("cash")) {
	// obj = this.predepositService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil.null2Long(ext1));
	// }
	// if (ext2.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(ext1));
	// }
	// // 获取人民币网关账户号
	// String merchantAcctId = (String) request.getParameter("merchantAcctId")
	// .trim();
	// // 设置人民币网关密钥
	// // /区分大小写
	// String key = "";
	// if (ext2.equals("goods") || ext2.equals("group")) {
	// key = order.getPayment().getRmbKey();
	// }
	// if (ext2.equals("cash") || ext2.equals("gold")
	// || ext2.equals("integral")) {
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// if (ext2.equals("cash")) {
	// q_params.put("mark", obj.getPd_payment());
	// }
	// if (ext2.equals("gold")) {
	// q_params.put("mark", gold.getGold_payment());
	// }
	// if (ext2.equals("integral")) {
	// q_params.put("mark", ig_order.getIgo_payment());
	// }
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// key = payments.get(0).getRmbKey();
	// }
	// // /快钱会根据版本号来调用对应的接口处理程序。
	// // /本代码版本号固定为v2.0
	// String version = (String) request.getParameter("version").trim();
	// // 获取语言种类.固定选择值。
	// // /只能选择1、2、3
	// // /1代表中文；2代表英文
	// // /默认值为1
	// String language = (String) request.getParameter("language").trim();
	// // 签名类型.固定值
	// // /1代表MD5签名
	// // /快钱3.0后该值为4
	// String signType = (String) request.getParameter("signType").trim();
	//
	// // 获取支付方式
	// // /值为：10、11、12、13、14
	// //
	// /00：组合支付（网关支付页面显示快钱支持的各种支付方式，推荐使用）10：银行卡支付（网关支付页面只显示银行卡支付）.11：电话银行支付（网关支付页面只显示电话支付）.12：快钱账户支付（网关支付页面只显示快钱账户支付）.13：线下支付（网关支付页面只显示线下支付方式）.14：B2B支付（网关支付页面只显示B2B支付，但需要向快钱申请开通才能使用）
	// String payType = (String) request.getParameter("payType").trim();
	//
	// // 获取银行代码
	// // /参见银行代码列表
	// String bankId = (String) request.getParameter("bankId").trim();
	// // 获取商户订单号
	// String orderId = (String) request.getParameter("orderId").trim();
	// // 获取订单提交时间
	// // /获取商户提交订单时的时间.14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	// // /如：20080101010101
	// String orderTime = (String) request.getParameter("orderTime").trim();
	// // 获取原始订单金额
	// // /订单提交到快钱时的金额，单位为分。
	// // /比方2 ，代表0.02元
	// String orderAmount = (String) request.getParameter("orderAmount")
	// .trim();
	// // 获取快钱交易号
	// // /获取该交易在快钱的交易号
	// String dealId = (String) request.getParameter("dealId").trim();
	// // 获取银行交易号
	// // /如果使用银行卡支付时，在银行的交易号。如不是通过银行支付，则为空
	// String bankDealId = (String) request.getParameter("bankDealId").trim();
	// // 获取在快钱交易时间
	// // /14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	// // /如；20080101010101
	// String dealTime = (String) request.getParameter("dealTime").trim();
	// // 获取实际支付金额
	// // /单位为分
	// // /比方 2 ，代表0.02元
	// String payAmount = (String) request.getParameter("payAmount").trim();
	// // 获取交易手续费
	// // /单位为分
	// // /比方 2 ，代表0.02元
	// String fee = (String) request.getParameter("fee").trim();
	// // 获取扩展字段2
	// // /10代表 成功11代表 失败
	// String payResult = (String) request.getParameter("payResult").trim();
	// // 获取错误代码
	// String errCode = (String) request.getParameter("errCode").trim();
	// // 获取加密签名串
	// String signMsg = (String) request.getParameter("signMsg").trim();
	// // 生成加密串。必须保持如下顺序。
	// String merchantSignMsgVal = "";
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "merchantAcctId",
	// merchantAcctId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "version", version);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "language",
	// language);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "signType",
	// signType);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payType", payType);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankId", bankId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderId", orderId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderTime",
	// orderTime);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "orderAmount",
	// orderAmount);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealId", dealId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "bankDealId",
	// bankDealId);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "dealTime",
	// dealTime);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payAmount",
	// payAmount);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "fee", fee);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext1", ext1);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "ext2", ext2);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "payResult",
	// payResult);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "errCode", errCode);
	// merchantSignMsgVal = appendParam(merchantSignMsgVal, "key", key);
	//
	// String merchantSignMsg = MD5Util.md5Hex(
	// merchantSignMsgVal.getBytes("utf-8")).toUpperCase();
	// // 商家进行数据处理，并跳转会商家显示支付结果的页面
	// // /首先进行签名字符串验证
	// if (signMsg.toUpperCase().equals(merchantSignMsg.toUpperCase())) {
	// // /接着进行支付结果判断
	// switch (Integer.parseInt(payResult)) {
	// case 10:
	// //
	// 特别注意：只有signMsg.toUpperCase().equals(merchantSignMsg.toUpperCase())，且payResult=10，才表示支付成功！同时将订单金额与提交订单前的订单金额进行对比校验。
	// if (ext2.equals("goods")) {
	// User buyer = this.userService.getObjById(CommUtil
	// .null2Long(order.getUser_id()));
	// if (order.getOrder_status() != 20) {
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);
	// this.update_goods_inventory(order);// 更新商品库存
	// OrderFormLog main_ofl = new OrderFormLog();
	// main_ofl.setAddTime(new Date());
	// main_ofl.setLog_info("快钱在线支付");
	// main_ofl.setLog_user(buyer);
	// main_ofl.setOf(order);
	// this.orderFormLogService.save(main_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 付款成功，发送短信提示
	// this.send_msg_tobuyer(request, order);
	// this.send_msg_toseller(request, order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals(
	// "")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order
	// .getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil
	// .null2Long(child_map
	// .get("order_id")));
	// child_order.setOrder_status(20);
	// child_order.setPayTime(new Date());
	// this.orderFormService.update(child_order);
	// this.update_goods_inventory(child_order);// 更新商品库存
	// OrderFormLog child_ofl = new OrderFormLog();
	// child_ofl.setAddTime(new Date());
	// child_ofl.setLog_info("快钱在线支付");
	// child_ofl.setLog_user(buyer);
	// child_ofl.setOf(child_order);
	// this.orderFormLogService.save(child_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// this.send_msg_toseller(request, child_order);
	// }
	//
	// }
	// }
	// rtnOK = 1;
	// }
	// if (ext2.equals("group")) {
	// this.generate_groupInfos(request, order, "bill", "快钱在线支付",
	// "");
	// rtnOK = 1;
	// }
	// if (ext2.equals("cash")) {
	// if (obj.getPd_pay_status() < 2) {// 判断预存款支付状态
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj
	// .getPd_user().getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil
	// .add(user.getAvailableBalance(),
	// obj.getPd_amount())));
	// this.userService.update(user);
	// PredepositLog log = new PredepositLog();
	// log.setAddTime(new Date());
	// log.setPd_log_amount(obj.getPd_amount());
	// log.setPd_log_user(obj.getPd_user());
	// log.setPd_op_type("充值");
	// log.setPd_type("可用预存款");
	// log.setPd_log_info("快钱在线支付");
	// this.predepositLogService.save(log);
	// }
	// rtnOK = 1;
	// }
	// if (ext2.equals("gold")) {
	// if (gold.getGold_pay_status() < 2) {// 判断金币充值状态
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold
	// .getGold_user().getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("快钱在线支付");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// }
	// rtnOK = 1;
	// }
	// if (ext2.equals("integral")) {
	// if (ig_order.getIgo_status() < 20) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("bill");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order
	// .getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map
	// .get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// goods.setIg_exchange_count(goods
	// .getIg_exchange_count()
	// + CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// }
	// rtnOK = 1;
	// }
	// break;
	// default:
	//
	// break;
	//
	// }
	//
	// }
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(rtnOK);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// /**
	// * 财付通支付
	// *
	// * @param request
	// * @param response
	// * @throws IOException
	// */
	// @RequestMapping("/tenpay.htm")
	// public void tenpay(HttpServletRequest request,
	// HttpServletResponse response, String id, String type,
	// String payment_id) throws IOException {
	// boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
	// OrderForm of = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (type.equals("goods") || type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// obj = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (obj.getPd_pay_status() >= 2) {
	// submit = false;// 预存款已经完成充值
	// }
	// }
	// if (type.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
	// if (gold.getGold_pay_status() >= 2) {
	// submit = false;// 金币已经完成充值
	// }
	// }
	// if (type.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(id));
	// if (ig_order.getIgo_status() >= 20) {
	// submit = false;// 积分订单已经完成支付
	// }
	// }
	// if (submit) {
	// // 获取提交的商品价格
	// String order_price = "";
	// if (type.equals("goods") || type.equals("gruop")) {
	// order_price = CommUtil.null2String(of.getTotalPrice());
	// }
	// if (type.equals("cash")) {
	// order_price = CommUtil.null2String(obj.getPd_amount());
	// }
	// if (type.equals("gold")) {
	// order_price = CommUtil.null2String(gold.getGold_money());
	// }
	// if (type.equals("integral")) {
	// order_price = CommUtil.null2String(ig_order.getIgo_trans_fee());
	// }
	// /* 商品价格（包含运费），以分为单位 */
	// double total_fee = CommUtil.null2Double(order_price) * 100;
	// int fee = (int) total_fee;
	// // 获取提交的商品名称
	// String product_name = "";
	// if (type.equals("goods") || type.equals("group")) {
	// product_name = of.getOrder_id();
	// }
	// if (type.equals("cash")) {
	// product_name = obj.getPd_sn();
	// }
	// if (type.equals("gold")) {
	// product_name = gold.getGold_sn();
	// }
	// if (type.equals("integral")) {
	// product_name = ig_order.getIgo_order_sn();
	// }
	// // 获取提交的备注信息
	// String remarkexplain = "";
	// if (type.equals("goods") || type.equals("group")) {
	// remarkexplain = of.getMsg();
	// }
	// if (type.equals("cash")) {
	// remarkexplain = obj.getPd_remittance_info();
	// }
	// if (type.equals("gold")) {
	// remarkexplain = gold.getGold_exchange_info();
	// }
	// if (type.equals("integral")) {
	// remarkexplain = ig_order.getIgo_msg();
	// }
	// String attach = "";
	// if (type.equals("goods") || type.equals("group")) {
	// attach = type + "," + of.getId().toString();
	// }
	// if (type.equals("cash")) {
	// attach = type + "," + obj.getId().toString();
	// }
	// if (type.equals("gold")) {
	// attach = type + "," + gold.getId().toString();
	// }
	// if (type.equals("integral")) {
	// attach = type + "," + ig_order.getId().toString();
	// }
	// String desc = "商品：" + product_name;
	// // 获取提交的订单号
	// String out_trade_no = "";
	// if (type.equals("goods") || type.equals("group")) {
	// out_trade_no = of.getOrder_id();
	// }
	// if (type.endsWith("cash")) {
	// out_trade_no = obj.getPd_sn();
	// }
	// if (type.endsWith("gold")) {
	// out_trade_no = gold.getGold_sn();
	// }
	// if (type.equals("integral")) {
	// out_trade_no = ig_order.getIgo_order_sn();
	// }
	// // 支付方式
	// Payment payment = this.paymentService.getObjById(CommUtil
	// .null2Long(payment_id));
	// if (payment == null) {
	// payment = new Payment();
	// }
	// String trade_mode = CommUtil.null2String(payment.getTrade_mode());
	// String currTime = TenpayUtil.getCurrTime();
	// // 创建支付请求对象
	// RequestHandler reqHandler = new RequestHandler(request, response);
	// reqHandler.init();
	// // 设置密钥
	// reqHandler.setKey(payment.getTenpay_key());
	// // 设置支付网关
	// reqHandler.setGateUrl("https://gw.tenpay.com/gateway/pay.htm");
	// // -----------------------------
	// // 设置支付参数
	// // -----------------------------
	// reqHandler.setParameter("partner", payment.getTenpay_partner()); // 商户号
	// reqHandler.setParameter("out_trade_no", out_trade_no); // 商家订单号
	// reqHandler.setParameter("total_fee", String.valueOf(fee)); // 商品金额,以分为单位
	// reqHandler.setParameter("return_url", CommUtil.getURL(request)
	// + "/tenpay_return.htm"); // 交易完成后跳转的URL
	// reqHandler.setParameter("notify_url", CommUtil.getURL(request)
	// + "/tenpay_notify.htm"); // 接收财付通通知的URL
	// reqHandler.setParameter("body", desc); // 商品描述
	// reqHandler.setParameter("bank_type", "DEFAULT"); // 银行类型(中介担保时此参数无效)
	// reqHandler
	// .setParameter("spbill_create_ip", request.getRemoteAddr()); //
	// 用户的公网ip，不是商户服务器IP
	// reqHandler.setParameter("fee_type", "1"); // 币种，1人民币
	// reqHandler.setParameter("subject", desc); // 商品名称(中介交易时必填)
	// // 系统可选参数
	// reqHandler.setParameter("sign_type", "MD5"); // 签名类型,默认：MD5
	// reqHandler.setParameter("service_version", "1.0"); // 版本号，默认为1.0
	// reqHandler.setParameter("input_charset", "UTF-8"); // 字符编码
	// reqHandler.setParameter("sign_key_index", "1"); // 密钥序号
	//
	// // 业务可选参数
	// reqHandler.setParameter("attach", attach); // 附加数据，原样返回
	// reqHandler.setParameter("product_fee", ""); // 商品费用，必须保证transport_fee
	// // +
	// reqHandler.setParameter("transport_fee", "0"); // 物流费用，必须保证transport_fee
	// reqHandler.setParameter("time_start", currTime); //
	// 订单生成时间，格式为yyyymmddhhmmss
	// reqHandler.setParameter("time_expire", ""); // 订单失效时间，格式为yyyymmddhhmmss
	// reqHandler.setParameter("buyer_id", ""); // 买方财付通账号
	// reqHandler.setParameter("goods_tag", ""); // 商品标记
	// reqHandler.setParameter("trade_mode", trade_mode); //
	// 交易模式，1即时到账(默认)，2中介担保，3后台选择（买家进支付中心列表选择）
	// reqHandler.setParameter("transport_desc", ""); // 物流说明
	// reqHandler.setParameter("trans_type", "1"); // 交易类型，1实物交易，2虚拟交易
	// reqHandler.setParameter("agentid", ""); // 平台ID
	// reqHandler.setParameter("agent_type", ""); //
	// 代理模式，0无代理(默认)，1表示卡易售模式，2表示网店模式
	// reqHandler.setParameter("seller_id", ""); // 卖家商户号，为空则等同于partner
	// // 请求的url
	// String requestUrl = reqHandler.getRequestURL();
	// response.sendRedirect(requestUrl);
	// } else {
	// response.getWriter().write("该订单已经完成支付！");
	// }
	//
	// }
	//
	// /**
	// * 财付通在线支付回调控制
	// *
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("/tenpay_return.htm")
	// public ModelAndView tenpay_return(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// ModelAndView mv = new JModelAndView("order_finish.html",
	// configService.getSysConfig(),
	// 1, request, response);
	// ResponseHandler resHandler = new ResponseHandler(request, response);
	// String[] attachs = request.getParameter("attach").split(",");
	// // 商户订单号
	// String out_trade_no = resHandler.getParameter("out_trade_no");
	// OrderForm order = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (attachs[0].equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(attachs[1]));
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// q_params.put("mark", ig_order.getIgo_payment());
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// resHandler.setKey(payments.get(0).getTenpay_key());
	// }
	// if (attachs[0].equals("cash")) {
	// obj = this.predepositService.getObjById(CommUtil
	// .null2Long(attachs[1]));
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// q_params.put("mark", obj.getPd_payment());
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// resHandler.setKey(payments.get(0).getTenpay_key());
	// }
	// if (attachs[0].equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil
	// .null2Long(attachs[1]));
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// q_params.put("mark", gold.getGold_payment());
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// resHandler.setKey(payments.get(0).getTenpay_key());
	// }
	// if (attachs[0].equals("goods") || attachs[0].equals("group")) {
	// order = this.orderFormService.getObjById(CommUtil
	// .null2Long(attachs[1]));
	// resHandler.setKey(order.getPayment().getTenpay_key());
	// }
	// // System.out.println("前台回调返回参数:" + resHandler.getAllParameters());
	// // 判断签名
	// if (resHandler.isTenpaySign()) {
	// // 通知id
	// String notify_id = resHandler.getParameter("notify_id");
	// // 财付通订单号
	// String transaction_id = resHandler.getParameter("transaction_id");
	// // 金额,以分为单位
	// String total_fee = resHandler.getParameter("total_fee");
	// // 如果有使用折扣券，discount有值，total_fee+discount=原请求的total_fee
	// String discount = resHandler.getParameter("discount");
	// // 支付结果
	// String trade_state = resHandler.getParameter("trade_state");
	// // 交易模式，1即时到账，2中介担保
	// String trade_mode = resHandler.getParameter("trade_mode");
	// if ("1".equals(trade_mode)) { // 即时到账
	// if ("0".equals(trade_state)) {
	// // 即时到账处理业务完毕
	// if (attachs[0].equals("cash")) {
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj
	// .getPd_user().getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil
	// .add(user.getAvailableBalance(),
	// obj.getPd_amount())));
	// this.userService.update(user);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("op_title", "充值" + obj.getPd_amount()
	// + "成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/predeposit_list.htm");
	// }
	// if (attachs[0].equals("goods")) {
	// User buyer = this.userService.getObjById(CommUtil
	// .null2Long(order.getUser_id()));
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);
	// this.update_goods_inventory(order);// 更新商品库存
	// OrderFormLog main_ofl = new OrderFormLog();
	// main_ofl.setAddTime(new Date());
	// main_ofl.setLog_info("财付通在线支付");
	// main_ofl.setLog_user(buyer);
	// main_ofl.setOf(order);
	// this.orderFormLogService.save(main_ofl);
	// // 发送邮件短信
	// this.send_msg_tobuyer(request, order);
	// this.send_msg_toseller(request, order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals(
	// "")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order
	// .getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil
	// .null2Long(child_map
	// .get("order_id")));
	// child_order.setOrder_status(20);
	// child_order.setPayTime(new Date());
	// this.orderFormService.update(child_order);
	// this.update_goods_inventory(child_order);// 更新商品库存
	// OrderFormLog child_ofl = new OrderFormLog();
	// child_ofl.setAddTime(new Date());
	// child_ofl.setLog_info("财付通在线支付");
	// child_ofl.setLog_user(buyer);
	// child_ofl.setOf(child_order);
	// this.orderFormLogService.save(child_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 发送邮件短信
	// this.send_msg_toseller(request, child_order);
	// }
	// }
	// mv.addObject("obj", order);
	// }
	// if (attachs[0].equals("group")) {
	// this.generate_groupInfos(request, order, "tenpay",
	// "财付通即时到帐支付", "");
	// mv.addObject("obj", order);
	// }
	// if (attachs[0].equals("gold")) {
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold
	// .getGold_user().getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("财付通及时到账支付");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("op_title", "兑换" + gold.getGold_count()
	// + "金币成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/seller/gold_record_list.htm");
	// }
	// if (attachs[0].equals("integral")) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("bill");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order
	// .getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map
	// .get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// goods.setIg_exchange_count(goods
	// .getIg_exchange_count()
	// + CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// mv = new JModelAndView("integral_order_finish.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("obj", ig_order);
	// }
	// } else {
	// mv = new JModelAndView("error.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "财付通支付失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// }
	// } else if ("2".equals(trade_mode)) { // 中介担保
	// if ("0".equals(trade_state)) {
	// // 中介担保处理业务完毕
	// if (attachs[0].equals("cash")) {
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj
	// .getPd_user().getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil
	// .add(user.getAvailableBalance(),
	// obj.getPd_amount())));
	// this.userService.update(user);
	// PredepositLog log = new PredepositLog();
	// log.setAddTime(new Date());
	// log.setPd_log_amount(obj.getPd_amount());
	// log.setPd_log_user(obj.getPd_user());
	// log.setPd_op_type("充值");
	// log.setPd_type("可用预存款");
	// log.setPd_log_info("财付通中介担保付款");
	// this.predepositLogService.save(log);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("op_title", "充值" + obj.getPd_amount()
	// + "成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/predeposit_list.htm");
	// }
	// if (attachs[0].equals("goods")) {
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals(
	// "")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order
	// .getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil
	// .null2Long(child_map
	// .get("order_id")));
	// child_order.setOrder_status(20);
	// this.orderFormService.update(child_order);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// Store store = this.storeService
	// .getObjById(CommUtil
	// .null2Long(child_order
	// .getStore_id()));
	// User buyer = this.userService
	// .getObjById(CommUtil.null2Long(order
	// .getUser_id()));
	// // 付款成功，发送邮件提示
	// if (child_order.getOrder_form() == 0) {
	// this.msgTools
	// .sendEmailCharge(
	// CommUtil.getURL(request),
	// "email_tobuyer_online_pay_ok_notify",
	// buyer.getEmail(),
	// null,
	// CommUtil.null2String(child_order
	// .getId()),
	// child_order.getStore_id());
	// this.msgTools
	// .sendEmailCharge(
	// CommUtil.getURL(request),
	// "email_toseller_online_pay_ok_notify",
	// store.getUser().getEmail(),
	// null,
	// CommUtil.null2String(child_order
	// .getId()),
	// child_order.getStore_id());
	// // 付款成功，发送短信提示
	// this.msgTools.sendSmsCharge(CommUtil
	// .getURL(request),
	// "sms_tobuyer_online_pay_ok_notify",
	// buyer.getMobile(), null, CommUtil
	// .null2String(child_order
	// .getId()),
	// child_order.getStore_id());
	// this.msgTools
	// .sendSmsCharge(
	// CommUtil.getURL(request),
	// "sms_toseller_online_pay_ok_notify",
	// store.getUser().getMobile(),
	// null,
	// CommUtil.null2String(child_order
	// .getId()),
	// child_order.getStore_id());
	// } else {
	// this.msgTools.sendSmsFree(CommUtil
	// .getURL(request),
	// "sms_tobuyer_online_pay_ok_notify",
	// buyer.getMobile(), null, CommUtil
	// .null2String(child_order
	// .getId()));
	// this.msgTools
	// .sendEmailFree(
	// CommUtil.getURL(request),
	// "email_tobuyer_online_pay_ok_notify",
	// buyer.getEmail(),
	// null,
	// CommUtil.null2String(child_order
	// .getId()));
	// }
	// }
	// }
	// this.update_goods_inventory(order);// 更新商品库存
	// OrderFormLog ofl = new OrderFormLog();
	// ofl.setAddTime(new Date());
	// ofl.setLog_info("财付通中介担保付款成功");
	// ofl.setLog_user(SecurityUserHolder.getCurrentUser());
	// ofl.setOf(order);
	// this.orderFormLogService.save(ofl);
	// mv.addObject("obj", order);
	// }
	// if (attachs[0].equals("gold")) {
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold
	// .getGold_user().getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("财付通中介担保付款成功");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("op_title", "兑换" + gold.getGold_count()
	// + "金币成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/seller/gold_record_list.htm");
	// }
	// if (attachs[0].equals("integral")) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("bill");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order
	// .getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map
	// .get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// goods.setIg_exchange_count(goods
	// .getIg_exchange_count()
	// + CommUtil.null2Int(map
	// .get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// mv = new JModelAndView("integral_order_finish.html",
	// configService.getSysConfig(),
	// 1,
	// request, response);
	// mv.addObject("obj", ig_order);
	// }
	// } else {
	// mv = new JModelAndView("error.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "财付通支付失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// }
	// }
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "财付通认证签名失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// }
	// return mv;
	// }
	//
	// /**
	// * 网银在线回调函数
	// *
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("/chinabank_return.htm")
	// public ModelAndView chinabank_return(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// ModelAndView mv = new JModelAndView("order_finish.html",
	// configService.getSysConfig(),
	// 1, request, response);
	// String remark1 = request.getParameter("remark1"); // 备注1
	// String remark2 = CommUtil.null2String(request.getParameter("remark2"));
	// OrderForm order = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (remark2.equals("goods") || remark2.equals("group")) {
	// order = this.orderFormService.getObjById(CommUtil.null2Long(remark1
	// .trim()));
	// }
	// if (remark2.equals("cash")) {
	// obj = this.predepositService
	// .getObjById(CommUtil.null2Long(remark1));
	// }
	// if (remark2.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil
	// .null2Long(remark1));
	// }
	// if (remark2.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(remark1));
	// }
	// String key = "";
	// if (remark2.equals("goods") || remark2.equals("group")) {
	// key = order.getPayment().getChinabank_key();
	// }
	// if (remark2.equals("cash") || remark2.equals("gold")
	// || remark2.equals("integral")) {
	// Map q_params = new HashMap();
	// q_params.put("install", true);
	// if (remark2.equals("cash")) {
	// q_params.put("mark", obj.getPd_payment());
	// }
	// if (remark2.equals("gold")) {
	// q_params.put("mark", gold.getGold_payment());
	// }
	// if (remark2.equals("integral")) {
	// q_params.put("mark", ig_order.getIgo_payment());
	// }
	// List<Payment> payments = this.paymentService
	// .query("select obj from Payment obj where obj.install=:install and
	// obj.mark=:mark",
	// q_params, -1, -1);
	// key = payments.get(0).getChinabank_key();
	// }
	// String v_oid = request.getParameter("v_oid"); // 订单号
	// String v_pmode = request.getParameter("v_pmode");// new
	// // String(request.getParameter("v_pmode").getBytes("ISO-8859-1"),
	// // "UTF-8"); //
	// // 支付方式中文说明，如"中行长城信用卡"
	// String v_pstatus = request.getParameter("v_pstatus"); //
	// 支付结果，20支付完成；30支付失败；
	// String v_pstring = request.getParameter("v_pstring");// new
	// // String(request.getParameter("v_pstring").getBytes("ISO-8859-1"),
	// // "UTF-8"); //
	// // 对支付结果的说明，成功时（v_pstatus=20）为"支付成功"，支付失败时（v_pstatus=30）为"支付失败"
	// String v_amount = request.getParameter("v_amount"); // 订单实际支付金额
	// String v_moneytype = request.getParameter("v_moneytype"); // 币种
	// String v_md5str = request.getParameter("v_md5str"); // MD5校验码
	// String text = v_oid + v_pstatus + v_amount + v_moneytype + key; // 拼凑加密串
	// String v_md5text = Md5Encrypt.md5(text).toUpperCase();
	// if (v_md5str.equals(v_md5text)) {
	// if ("20".equals(v_pstatus)) {
	// // 支付成功，商户 根据自己业务做相应逻辑处理
	// // 此处加入商户系统的逻辑处理（例如判断金额，判断支付状态(20成功,30失败)，更新订单状态等等）......
	// if (remark2.equals("goods")) {
	// User buyer = this.userService.getObjById(CommUtil
	// .null2Long(order.getUser_id()));
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);
	// this.update_goods_inventory(order);// 更新商品库存
	// OrderFormLog main_ofl = new OrderFormLog();
	// main_ofl.setAddTime(new Date());
	// main_ofl.setLog_info("财付通在线支付");
	// main_ofl.setLog_user(buyer);
	// main_ofl.setOf(order);
	// this.orderFormLogService.save(main_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 发送邮件短信
	// this.send_msg_tobuyer(request, order);
	// this.send_msg_toseller(request, order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals("")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order.getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil.null2Long(child_map
	// .get("order_id")));
	// child_order.setPayTime(new Date());
	// child_order.setOrder_status(20);
	// this.orderFormService.update(child_order);
	// this.update_goods_inventory(child_order);// 更新商品库存
	// OrderFormLog child_ofl = new OrderFormLog();
	// child_ofl.setAddTime(new Date());
	// child_ofl.setLog_info("网银在线支付");
	// child_ofl.setLog_user(buyer);
	// child_ofl.setOf(child_order);
	// this.orderFormLogService.save(child_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 发送邮件短信
	// this.send_msg_toseller(request, child_order);
	// }
	// }
	// }
	// if (remark2.equals("group")) {
	// this.generate_groupInfos(request, order, "chinabank",
	// "网银在线支付", "");
	// mv.addObject("obj", order);
	// }
	// if (remark2.endsWith("cash")) {
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj.getPd_user()
	// .getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil.add(
	// user.getAvailableBalance(), obj.getPd_amount())));
	// this.userService.update(user);
	// PredepositLog log = new PredepositLog();
	// log.setAddTime(new Date());
	// log.setPd_log_amount(obj.getPd_amount());
	// log.setPd_log_user(obj.getPd_user());
	// log.setPd_op_type("充值");
	// log.setPd_type("可用预存款");
	// log.setPd_log_info("网银在线支付");
	// this.predepositLogService.save(log);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "充值" + obj.getPd_amount() + "成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/predeposit_list.htm");
	// }
	// if (remark2.equals("gold")) {
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold.getGold_user()
	// .getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("网银在线支付");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "兑换" + gold.getGold_count()
	// + "金币成功");
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/seller/gold_record_list.htm");
	// }
	// if (remark2.equals("gold")) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("bill");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order.getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map.get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map.get("ig_goods_count")));
	// goods.setIg_exchange_count(goods.getIg_exchange_count()
	// + CommUtil.null2Int(map.get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// mv = new JModelAndView("integral_order_finish.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("obj", ig_order);
	// }
	// }
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "网银在线支付失败！");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	//
	// }
	// return mv;
	// }
	//
	// /**
	// * paypal回调方法,paypal支付成功了后，调用该方法进行后续处理
	// *
	// * @param request
	// * @param response
	// * @return
	// * @throws Exception
	// */
	// @RequestMapping("/paypal_return.htm")
	// public ModelAndView paypal_return(HttpServletRequest request,
	// HttpServletResponse response) throws Exception {
	// ModelAndView mv = new JModelAndView("order_finish.html",
	// configService.getSysConfig(),
	// 1, request, response);
	// Enumeration en = request.getParameterNames();
	// String str = "cmd=_notify-validate";
	// while (en.hasMoreElements()) {
	// String paramName = (String) en.nextElement();
	// String paramValue = request.getParameter(paramName);
	// str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
	// }
	// // System.out.println(request.getParameter("custom"));
	// String[] customs = request.getParameter("custom").split(",");
	// String remark1 = customs[0];
	// String remark2 = customs[1];
	// String item_name = request.getParameter("item_name");
	// String txnId = request.getParameter("txn_id");
	// OrderForm order = null;
	// Predeposit obj = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (remark2.equals("goods") || remark2.equals("group")) {
	// order = this.orderFormService.getObjById(CommUtil.null2Long(remark1
	// .trim()));
	// }
	// if (remark2.equals("cash")) {
	// obj = this.predepositService
	// .getObjById(CommUtil.null2Long(remark1));
	// }
	// if (remark2.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil
	// .null2Long(remark1));
	// }
	// if (remark2.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(remark1));
	// }
	// String txn_id = request.getParameter("txn_id");
	// //
	// // 建议在此将接受到的信息str记录到日志文件中以确认是否收到IPN信息
	// // 将信息POST回给PayPal进行验证
	// // 设置HTTP的头信息
	// // 在Sandbox情况下，设置：
	// // URL u = new URL("http://www.sanbox.paypal.com/cgi-bin/webscr");
	// // URLConnection uc = u.openConnection();
	// // uc.setDoOutput(true);
	// // uc.setRequestProperty("Content-Type",
	// // "application/x-www-form-urlencoded");
	// // PrintWriter pw = new PrintWriter(uc.getOutputStream());
	// // pw.println(str);
	// // pw.close();
	// // // 接受PayPal对IPN回发的回复信息 uc.getOutputStream()
	// // BufferedReader in = new BufferedReader(new
	// // InputStreamReader(uc.getInputStream()));
	// // String res = in.readLine();
	// // in.close();
	// // System.out.println("接受PayPal对IPN回发的回复信息：" + res);
	//
	// // 将POST信息分配给本地变量，可以根据您的需要添加
	// // 该付款明细所有变量可参考：
	// String itemName = request.getParameter("item_name");
	// String paymentStatus = request.getParameter("payment_status");
	// String paymentAmount = request.getParameter("mc_gross");
	// String paymentCurrency = request.getParameter("mc_currency");
	// String receiverEmail = request.getParameter("receiver_email");
	// String payerEmail = request.getParameter("payer_email");
	// // System.out.println("付款明细信息：订单编号:" + itemName + ",支付状态：" +
	// // paymentStatus+ ",金额：" + paymentAmount + ",货币种类：" + paymentCurrency+
	// // ",paypal支付流水号:" + txnId + ",paypal接收方账号：" + receiverEmail+
	// // ",paypal支付方账号" + payerEmail);
	// if (paymentStatus.equals("Completed")
	// || paymentStatus.equals("Pending")) {
	// if (remark2.equals("goods")) {
	// if (order.getOrder_status() < 20
	// && CommUtil.null2String(order.getTotalPrice()).equals(
	// paymentAmount)) {
	// User buyer = this.userService.getObjById(CommUtil
	// .null2Long(order.getUser_id()));
	// order.setOrder_status(20);
	// order.setPayTime(new Date());
	// this.orderFormService.update(order);
	// this.update_goods_inventory(order);// 更新商品库存
	// OrderFormLog main_ofl = new OrderFormLog();
	// main_ofl.setAddTime(new Date());
	// main_ofl.setLog_info("网银在线支付");
	// main_ofl.setLog_user(buyer);
	// main_ofl.setOf(order);
	// this.orderFormLogService.save(main_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 发送邮件短信
	// this.send_msg_tobuyer(request, order);
	// this.send_msg_toseller(request, order);
	// if (order.getOrder_main() == 1
	// && !CommUtil.null2String(
	// order.getChild_order_detail()).equals("")) {// 同步完成子订单付款状态调整
	// List<Map> maps = this.orderFormTools
	// .queryGoodsInfo(order.getChild_order_detail());
	// for (Map child_map : maps) {
	// OrderForm child_order = this.orderFormService
	// .getObjById(CommUtil.null2Long(child_map
	// .get("order_id")));
	// child_order.setOrder_status(20);
	// child_order.setPayTime(new Date());
	// this.orderFormService.update(child_order);
	// this.update_goods_inventory(child_order);// 更新商品库存
	// OrderFormLog child_ofl = new OrderFormLog();
	// child_ofl.setAddTime(new Date());
	// child_ofl.setLog_info("网银在线支付");
	// child_ofl.setLog_user(buyer);
	// child_ofl.setOf(child_order);
	// this.orderFormLogService.save(child_ofl);
	// // 向加盟商家发送付款成功短信提示，自营商品无需发送短信提示
	// // 发送邮件短信
	// this.send_msg_toseller(request, child_order);
	// }
	// }
	// }
	// mv.addObject("obj", order);
	//
	// }
	// if (remark2.equals("group")) {
	// this.generate_groupInfos(request, order, "paypal",
	// "paypal在线支付", "");
	// mv.addObject("obj", order);
	// }
	// if (remark2.endsWith("cash")) {
	// if (obj.getPd_pay_status() < 2) {
	// obj.setPd_status(1);
	// obj.setPd_pay_status(2);
	// this.predepositService.update(obj);
	// User user = this.userService.getObjById(obj.getPd_user()
	// .getId());
	// user.setAvailableBalance(BigDecimal.valueOf(CommUtil.add(
	// user.getAvailableBalance(), obj.getPd_amount())));
	// this.userService.update(user);
	// PredepositLog log = new PredepositLog();
	// log.setAddTime(new Date());
	// log.setPd_log_amount(obj.getPd_amount());
	// log.setPd_log_user(obj.getPd_user());
	// log.setPd_op_type("充值");
	// log.setPd_type("可用预存款");
	// log.setPd_log_info("Paypal在线支付");
	// this.predepositLogService.save(log);
	// }
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "成功充值：" + obj.getPd_amount());
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/buyer/predeposit_list.htm");
	// }
	// if (remark2.equals("gold")) {
	// if (gold.getGold_pay_status() < 2) {
	// gold.setGold_status(1);
	// gold.setGold_pay_status(2);
	// this.goldRecordService.update(gold);
	// User user = this.userService.getObjById(gold.getGold_user()
	// .getId());
	// user.setGold(user.getGold() + gold.getGold_count());
	// this.userService.update(user);
	// GoldLog log = new GoldLog();
	// log.setAddTime(new Date());
	// log.setGl_payment(gold.getGold_payment());
	// log.setGl_content("Paypal");
	// log.setGl_money(gold.getGold_money());
	// log.setGl_count(gold.getGold_count());
	// log.setGl_type(0);
	// log.setGl_user(gold.getGold_user());
	// log.setGr(gold);
	// this.goldLogService.save(log);
	// }
	// mv = new JModelAndView("success.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "成功充值金币:" + gold.getGold_count());
	// mv.addObject("url", CommUtil.getURL(request)
	// + "/seller/gold_record_list.htm");
	// }
	// if (remark2.equals("gold")) {
	// if (ig_order.getIgo_status() < 20) {
	// ig_order.setIgo_status(20);
	// ig_order.setIgo_pay_time(new Date());
	// ig_order.setIgo_payment("paypal");
	// this.integralGoodsOrderService.update(ig_order);
	// List<Map> ig_maps = this.orderFormTools
	// .query_integral_goodsinfo(ig_order.getGoods_info());
	// for (Map map : ig_maps) {
	// IntegralGoods goods = this.integralGoodsService
	// .getObjById(CommUtil.null2Long(map.get("id")));
	// goods.setIg_goods_count(goods.getIg_goods_count()
	// - CommUtil.null2Int(map.get("ig_goods_count")));
	// goods.setIg_exchange_count(goods.getIg_exchange_count()
	// + CommUtil.null2Int(map.get("ig_goods_count")));
	// this.integralGoodsService.update(goods);
	// }
	// }
	// mv = new JModelAndView("integral_order_finish.html",
	// configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("obj", ig_order);
	// }
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(),
	// 1, request,
	// response);
	// mv.addObject("op_title", "Paypal支付失败");
	// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
	// }
	// return mv;
	// }

	// private void generate_groupInfos(HttpServletRequest request,
	// OrderForm order, String mark, String pay_info, String trade_no)
	// throws Exception {
	// if (order.getOrder_status() < 20) {
	// order.setOrder_status(20);
	// order.setOut_order_id(trade_no);
	// order.setPayTime(new Date());
	// // 生活团购订单付款时增加退款时效
	// if (order.getOrder_cat() == 2) {
	// Calendar ca = Calendar.getInstance();
	// ca.add(ca.DATE, this.configService.getSysConfig()
	// .getGrouplife_order_return());
	// SimpleDateFormat bartDateFormat = new SimpleDateFormat(
	// "yyyy-MM-dd HH:mm:ss");
	// String latertime = bartDateFormat.format(ca.getTime());
	// order.setReturn_shipTime(CommUtil.formatDate(latertime));
	// }
	// this.orderFormService.update(order);
	// OrderFormLog ofl = new OrderFormLog();
	// ofl.setAddTime(new Date());
	// ofl.setLog_info(pay_info);
	// User buyer = this.userService.getObjById(CommUtil.null2Long(order
	// .getUser_id()));
	// ofl.setLog_user(buyer);
	// ofl.setOf(order);
	// this.orderFormLogService.save(ofl);
	// Store store = null;
	// if (order.getStore_id() != null && !"".equals(order.getStore_id())) {
	// store = this.storeService.getObjById(CommUtil.null2Long(order
	// .getStore_id()));
	// }
	//
	// if (order.getOrder_cat() == 2) {
	// Map map = this.orderFormTools.queryGroupInfo(order
	// .getGroup_info());
	// int count = CommUtil
	// .null2Int(map.get("goods_count").toString());
	// String goods_id = map.get("goods_id").toString();
	// GroupLifeGoods goods = this.groupLifeGoodsService
	// .getObjById(CommUtil.null2Long(goods_id));
	// goods.setGroup_count(goods.getGroup_count()
	// - CommUtil.null2Int(count));
	// goods.setSelled_count(goods.getSelled_count()
	// + CommUtil.null2Int(count));
	// this.groupLifeGoodsService.update(goods);
	// Map pay_params = new HashMap();
	// pay_params.put("mark", mark);
	// List<Payment> payments = this.paymentService.query(
	// "select obj from Payment obj where obj.mark=:mark",
	// pay_params, -1, -1);
	// int i = 0;
	// List<String> code_list = new ArrayList();// 存放团购消费码
	// String codes = "";
	// while (i < count) {
	// GroupInfo info = new GroupInfo();
	// info.setAddTime(new Date());
	// info.setLifeGoods(goods);
	// info.setPayment(payments.get(0));
	// info.setOrder_id(order.getId());
	// info.setUser_id(buyer.getId());
	// info.setUser_name(buyer.getUserName());
	// info.setGroup_sn(buyer.getId()
	// + CommUtil.formatTime("yyyyMMddHHmmss" + i,
	// new Date()));
	// Calendar ca2 = Calendar.getInstance();
	// ca2.add(ca2.DATE, this.configService.getSysConfig()
	// .getGrouplife_order_return());
	// SimpleDateFormat bartDateFormat2 = new SimpleDateFormat(
	// "yyyy-MM-dd HH:mm:ss");
	// String latertime2 = bartDateFormat2.format(ca2.getTime());
	// info.setRefund_Time(CommUtil.formatDate(latertime2));
	// this.groupInfoService.save(info);
	// codes = codes + info.getGroup_sn() + " ";
	// code_list.add(info.getGroup_sn());
	// i++;
	// }
	// // 更新lucene索引
	// String goods_lucene_path = System.getProperty("thinkervcb2b2c.root")
	// + File.separator + "luence" + File.separator
	// + "grouplifegoods";
	// File file = new File(goods_lucene_path);
	// if (!file.exists()) {
	// CommUtil.createFolder(goods_lucene_path);
	// }
	// //LuceneUtil lucene = LuceneUtil.instance();
	// //lucene.setIndex_path(goods_lucene_path);
	// luceneUtil.update(CommUtil.null2String(goods.getId()),
	// luceneVoTools.updateLifeGoodsIndex(goods));
	// // 如果为运营商发布的团购则进行结算日志生成
	// if (order.getOrder_form() == 0) {
	// PayoffLog plog = new PayoffLog();
	// plog.setPl_sn("pl"
	// + CommUtil.formatTime("yyyyMMddHHmmss", new Date())
	// + store.getUser().getId());
	// plog.setPl_info("团购码生成成功");
	// plog.setAddTime(new Date());
	// plog.setSeller(store.getUser());
	// plog.setO_id(CommUtil.null2String(order.getId()));
	// plog.setOrder_id(order.getOrder_id().toString());
	// plog.setCommission_amount(BigDecimal.valueOf(CommUtil
	// .null2Double("0.00")));// 该订单总佣金费用
	// plog.setGoods_info(order.getGroup_info());
	// plog.setOrder_total_price(order.getTotalPrice());// 该订单总商品金额
	// plog.setTotal_amount(order.getTotalPrice());//
	// 该订单应结算金额：结算金额=订单总商品金额-总佣金费用
	// this.payoffservice.save(plog);
	// store.setStore_sale_amount(BigDecimal.valueOf(CommUtil.add(
	// order.getGoods_amount(),
	// store.getStore_sale_amount())));// 店铺本次结算总销售金额
	// store.setStore_commission_amount(BigDecimal
	// .valueOf(CommUtil.add(order.getCommission_amount(),
	// store.getStore_commission_amount())));// 店铺本次结算总佣金
	// store.setStore_payoff_amount(BigDecimal.valueOf(CommUtil
	// .add(plog.getTotal_amount(),
	// store.getStore_payoff_amount())));// 店铺本次结算总佣金
	// this.storeService.update(store);
	// }
	// // 增加系统总销售金额、总佣金
	// SysConfig sc = this.configService.getSysConfig();
	// sc.setPayoff_all_sale(BigDecimal.valueOf(CommUtil.add(
	// order.getGoods_amount(), sc.getPayoff_all_sale())));
	// sc.setPayoff_all_commission(BigDecimal.valueOf(CommUtil.add(
	// order.getCommission_amount(),
	// sc.getPayoff_all_commission())));
	// this.configService.update(sc);
	// String msg_content = "恭喜您成功购买团购" + map.get("goods_name")
	// + ",团购消费码分别为：" + codes + "您可以到用户中心-我的生活购中查看消费码的使用情况";
	// // 发送系统站内信给买家
	// Message tobuyer_msg = new Message();
	// tobuyer_msg.setAddTime(new Date());
	// tobuyer_msg.setStatus(0);
	// tobuyer_msg.setType(0);
	// tobuyer_msg.setContent(msg_content);
	// tobuyer_msg.setFromUser(this.userService.getObjByProperty(null,
	// "userName", "admin"));
	// tobuyer_msg.setToUser(buyer);
	// this.messageService.save(tobuyer_msg);
	// // 发送系统站内信给卖家
	// Message toSeller_msg = new Message();
	// toSeller_msg.setAddTime(new Date());
	// toSeller_msg.setStatus(0);
	// toSeller_msg.setType(0);
	// toSeller_msg.setContent(buyer.getUsername());
	// toSeller_msg.setFromUser(this.userService.getObjByProperty(
	// null, "userName", "admin"));
	// toSeller_msg.setToUser(goods.getUser());
	// this.messageService.save(toSeller_msg);
	// // 付款成功，发送短信团购消费码
	// this.send_groupInfo_sms(request, order, buyer.getMobile(),
	// "sms_tobuyer_online_ok_send_groupinfo", code_list,
	// buyer.getId().toString(), goods.getUser().getId()
	// .toString());
	// }
	// this.send_msg_tobuyer(request, order);
	// }
	// }

	// /**
	// * 发送短信团购消费码
	// *
	// * @param request
	// * @param order
	// * @param mobile
	// * @param mark
	// * @param codes
	// * @param buyer_id
	// * @param seller_id
	// * @throws Exception
	// */
	// private void send_groupInfo_sms(HttpServletRequest request,
	// OrderForm order, String mobile, String mark, List<String> codes,
	// String buyer_id, String seller_id) throws Exception {
	// Template template = this.templateService.getObjByProperty(null, "mark",
	// mark);
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0; i < codes.size(); i++) {
	// sb.append(codes.get(i) + ",");
	// }
	// String code = sb.toString();
	// if (template != null && template.isOpen()) {
	// ExpressionParser exp = new SpelExpressionParser();
	// EvaluationContext context = new StandardEvaluationContext();
	// context.setVariable("buyer",
	// this.userService.getObjById(CommUtil.null2Long(buyer_id)));
	// context.setVariable("seller",
	// this.userService.getObjById(CommUtil.null2Long(seller_id)));
	// context.setVariable("config", this.configService.getSysConfig());
	// context.setVariable("send_time",
	// CommUtil.formatLongDate(new Date()));
	// context.setVariable("webPath", CommUtil.getURL(request));
	// context.setVariable("order", order);
	// context.setVariable("code", code);
	// Expression ex = exp.parseExpression(template.getContent(),
	// new SpelTemplate());
	// String content = ex.getValue(context, String.class);
	// this.msgTools.sendSMS(mobile, content);
	// }
	// }

	/**
	 * 在线支付回调后，向买家、商家发送短信、邮件提醒订单在线付款成功！
	 * 
	 * @param request
	 * @param order
	 * @throws Exception
	 */
	private void send_msg_tobuyer(HttpServletRequest request, OrderForm order) throws Exception {
		UserCustomer buyer = this.customerService.findSessionUser(order.getUserId());
		if (order.getOrderForm() == OrderFormConstants.ORDER_FORM_SELLER) {
			Seller seller = this.sellerService.findByStore(CommUtil.null2Long(order.getStoreId()));
			this.msgTools.sendEmailCharge(CommUtil.getURL(request), "email_tobuyer_online_pay_ok_notify",
					buyer.getEmail(), null, CommUtil.null2String(order.getId()), order.getStoreId());
			this.msgTools.sendSmsCharge(CommUtil.getURL(request), "sms_tobuyer_online_pay_ok_notify",
					buyer.getMobile(), null, CommUtil.null2String(order.getId()), order.getStoreId());
		} else {
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "email_tobuyer_online_pay_ok_notify",
					buyer.getEmail(), CommUtil.null2String(order.getId()), order.getStoreId());
			this.msgTools.sendSmsFree(CommUtil.getURL(request), "sms_tobuyer_online_pay_ok_notify",
					buyer.getMobile(), null, CommUtil.null2String(order.getId()));
		}
	}

	/**
	 * 在线支付回调后，向买家、商家发送短信、邮件提醒订单在线付款成功！
	 * 
	 * @param request
	 * @param order
	 * @throws Exception
	 */
	private void send_msg_toseller(HttpServletRequest request, OrderForm order) throws Exception {
		if (order.getOrderForm() == OrderFormConstants.ORDER_FORM_SELLER) {
			Seller seller = this.sellerService.findByStore(CommUtil.null2Long(order.getStoreId()));
			this.msgTools.sendEmailCharge(CommUtil.getURL(request), "email_toseller_online_pay_ok_notify",
					seller.getEmail(), null, CommUtil.null2String(order.getId()), order.getStoreId());
			this.msgTools.sendSmsCharge(CommUtil.getURL(request), "sms_toseller_online_pay_ok_notify",
					seller.getMobile(), null, CommUtil.null2String(order.getId()), order.getStoreId());
		}
	}
	
	@SecurityMapping(title = "积分订单支付内容", value = "/pay_integral*", rtype = "buyer", rname = "支付", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/pay_integral.htm")
	public ModelAndView order_pay_integral_view(HttpServletRequest request, HttpServletResponse response,
			Double allOfPrice) {
		ModelAndView mv = new JModelAndView("pay.html", configService.getSysConfig(), 1, request, response);
		UserCustomerBO customer = customerService.findSessionUser(SecurityUserHolder.getCurrentUserId());
		mv.addObject("customer", customer);
		mv.addObject("payTools", payTools);
		mv.addObject("all_of_price", CommUtil.null2Double(request.getAttribute("allOfPrice")));

		User user = SecurityUserHolder.getCurrentUser();
		// CN奖金
		double cnBonus = 0;
		double cnRepeat = 0;
		boolean bl = false;
		List<UserAccountBO> userAccount = this.accountService.findUserAccountByUid(user.getId());
		for (UserAccountBO account : userAccount) {
			if ("8".equals(account.getAccountType())) {
				bl = true;
				break;
			}
		}
		if (bl) {
			UserAccount resAccount = this.accountService.findByUid(user.getId(), "8");
			mv.addObject("isCnUserFlag", "true");// 表示CN账户
		}
		mv.addObject("cnRepeat", cnRepeat);
		mv.addObject("cnBonus", cnBonus);
		return mv;
	}

}
