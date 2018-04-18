package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.notice.model.NoticeMessage;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;
import com.sinco.carnation.resource.bo.shop.ReturnGoodsLogBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderFormBO;
import com.sinco.carnation.resource.bo.shop.YgPayModeBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.constant.ResultCodeConstant;
import com.sinco.carnation.resource.vo.shop.ShopCreateOrderFormVO;
import com.sinco.carnation.resource.vo.shop.ShopTradePaymetVO;
import com.sinco.carnation.resource.vo.shop.ShopTradePaymetViewVO;
import com.sinco.carnation.resource.vo.shop.ShopTradeReturnApplyVO;
import com.sinco.carnation.resource.vo.shop.ShopTradeReturnCancelVO;
import com.sinco.carnation.resource.vo.shop.ShopTradeReturnListVO;
import com.sinco.carnation.resource.vo.shop.ShopTradeReturnShipSaveVO;
import com.sinco.carnation.resource.vo.shop.ShopTradeReturnViewVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.NullResponse;
import com.sinco.carnation.resource.web.response.shop.ShopOrderCreateCreateResponse;
import com.sinco.carnation.resource.web.response.shop.ShopPaymetResponse;
import com.sinco.carnation.resource.web.response.shop.ShopTradePaymetResponse;
import com.sinco.carnation.resource.web.response.shop.ShopTradePaymetViewResponse;
import com.sinco.carnation.resource.web.response.shop.ShopTradeReturnListResponse;
import com.sinco.carnation.resource.web.response.shop.ShopTradeReturnViewResponse;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.SelectYgPayModeBO;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.service.NoticeMessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;
import com.weixin.utils.Signature;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "交易API", namespace = "shop_trade")
public class ShopTradeAction extends BasicApiController {

	private static final Logger log = LoggerFactory.getLogger(ShopTradeAction.class);
	@Autowired
	IntegralGoodsOrderService integralGoodsOrderService;

	@Autowired
	private GoodsCartService goodsCartService;

	@Autowired
	private OrderFormService orderFormService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private OrderFormTools ofTools;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private PredepositService predepositService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;

	@Autowired
	private PayTools payTools;

	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	private NoticeMessageService noticeMessageService;

	@Autowired
	private Mapper mapper;
	@Autowired
	private UserAccountService userAccountService;
	
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/shop/trade/order/create", method = RequestMethod.POST)
	@MethodMapping(desc = "创建商城订单")
	public @ResponseBody
	ShopOrderCreateCreateResponse createOrder(@Valid @ModelAttribute @Param ShopCreateOrderFormVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopOrderCreateCreateResponse response = new ShopOrderCreateCreateResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();

		Map<String, String> errorParam = new HashMap<>();
		Map<String, String> transports = new HashMap<>();
		try {
			transports = JSON.parseObject(vo.getTransportIds(), new TypeReference<Map<String, String>>() {});
		} catch (Exception e) {
			errorParam.put("param", "transport");
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
			return response;
		}
		Map<String, String> msgs = new HashMap<>();
		if (StringUtils.isNotBlank(vo.getMsgs())) {
			try {
				msgs = JSON.parseObject(vo.getMsgs(), new TypeReference<Map<String, String>>() {});
			} catch (Exception e) {
				errorParam.put("param", "msgs");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		}
		Map<String, Long> couponIds = new HashMap<>();
		if (StringUtils.isNotBlank(vo.getCouponIds())) {
			try {
				couponIds = JSON.parseObject(vo.getCouponIds(), new TypeReference<Map<String, Long>>() {});
			} catch (Exception e) {
				errorParam.put("param", "couponIds");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		}

		OrderFormBO mainOrder = null;
		String[] integralIds = StringUtils.isNotBlank(vo.getIntegralIds()) ? vo.getIntegralIds().split(",")
				: new String[] {};
		try {
			mainOrder = goodsCartService.createOrderForm(uid, vo.getAddrId(), transports, msgs, couponIds,
					integralIds, vo.getGcIds().split(","), null, null, null, true, null, vo.getPayTypeFlag());
		} catch (ServiceException e) {
			errorParam.put("msg", e.getErrorCode());
			response.putErrorMessage("4.shop_trade.createOrder.failure", errorParam);
			return response;
		}
		
		response.setOrder(mapper.map(mainOrder, ShopOrderFormBO.class));

		SelectYgPayModeBO selectYgPayMode = null;

		if (null != mainOrder.getIsygOrder() && mainOrder.getIsygOrder()) {// 是否是精选专区
			if (vo.getPayTypeFlag().intValue() == 1) { // 重消支付
				selectYgPayMode = this.orderFormService.getCxPayMode(CommUtil.null2String(mainOrder.getId()),
						uid);
				response.setYgPayMode(mapper.map(selectYgPayMode, YgPayModeBO.class));
				response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllygPrice().add(
						mainOrder.getShipPrice())));
			} else if (vo.getPayTypeFlag().intValue() == 2) { // 积分支付
				selectYgPayMode = this.orderFormService.getBeautyPayMode(
						CommUtil.null2String(mainOrder.getId()), uid);
				response.setYgPayMode(mapper.map(selectYgPayMode, YgPayModeBO.class));
				response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllIntegral().add(
						mainOrder.getAllCashPrice())));
			} else if (vo.getPayTypeFlag().intValue() == 3) {//普通会员精选专区支付
				//当前积分
				try {
					selectYgPayMode = this.orderFormService.getJingXuanPayMode(CommUtil.null2String(mainOrder.getId()), uid);
				} catch (ServiceException e) {
					log.info("created order ",e);
				}
				response.setYgPayMode(mapper.map(selectYgPayMode, YgPayModeBO.class));
				response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllIntegral().add(
						mainOrder.getAllCashPrice())));
			}

		} else if (mainOrder.getOrderTypeFlag() != null && mainOrder.getOrderTypeFlag().intValue() == 2) {
			response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllygPrice().add(
					mainOrder.getAllCashPrice())));
		} else {
			response.setTotalPrice(ofTools.query_order_price(mainOrder));
		}
		response.setPayTypeFlag(vo.getPayTypeFlag());
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/shop/trade/paymet", method = RequestMethod.POST)
	@MethodMapping(desc = "订单支付")
	public @ResponseBody
	synchronized ShopTradePaymetResponse tradePaymet(@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			BindingResult result, HttpServletRequest request) {

		ShopTradePaymetResponse response = new ShopTradePaymetResponse();

		SysConfigBO config = configService.getSysConfig();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		// 消息推送日志
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		NoticeMessage noticeMesg = new NoticeMessage();
		noticeMesg.setUid(uid);
		// noticeMesg.setNoticeType("payNotice");
		noticeMesg.setPushType("payNotice");
		String message;// = "您于" + date + "付款成功";

		// 验证是否为用户云豆支付
		Map<String, String> errorParam = new HashMap<>();
		// 验证是否为云购币

		if (vo.getIsUserMoneyPaymet() != null && vo.getIsUserMoneyPaymet()) {// 云豆支付不等于空
			// 支付密码是否为空
			if (StringUtils.isBlank(vo.getPaymetPassword())) {
				errorParam.put("param", "paymetPassword");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		} else if (vo.getIsYunGouMoney() != null && vo.getIsYunGouMoney()) {

			if (StringUtils.isBlank(vo.getBonusYunGouPwd())) {
				errorParam.put("param", "bonusYunGouPwd");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}

		} else {
			// 支付方式是否正确
			if (StringUtils.isBlank(vo.getPaymentType())
					|| !(PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType()) || PaymentConstants.PAYMENT_MARK_WX_APP
							.equals(vo.getPaymentType()))) {
				errorParam.put("param", "paymetType");
				response.putErrorMessage(MsgCodeConstant.ERROR_PARAM, errorParam);
				return response;
			}
		}

		if (null != vo.getType()) {// 商城支付,才需要验证
			OrderForm zeroFormOrder = this.orderFormService.getObjById(vo.getMainOrderId());
			System.out.println(vo.getMainOrderId() + vo.getType());
			if (null != zeroFormOrder && zeroFormOrder.getOrderTypeFlag().equals(1) && vo.getType().equals(1)) {
				Long time = CommUtil.DateTimeDiff(zeroFormOrder.getAddTime(), new Date());
				if (time >= 3 * 60 * 1000) {
					errorParam.put("msg", "0元购订单失效!");
					response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
					return response;
				}
			}
		}

		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);
		String accountType = "0";
		for (UserAccountBO type : userAccount) {
			if ("8".equals(type.getAccountType())) {
				accountType = type.getAccountType();
				break;
			}
		}

		// 商城支付
		log.info("payType=================" + vo.getType());
		if (vo.getType() == 1) {
			try {
				OrderFormBO order = this.orderFormService.orderPay(vo.getPaymentType(),
						CommUtil.null2Long(vo.getMainOrderId()), uid, vo.getIsUserMoneyPaymet(),
						vo.getPaymetPassword(), vo.getIsYunGouMoney(), vo.getBonusYunGouPwd(), accountType,
						true);// 写死

				Payment payment = null;
				String type = PaymentConstants.ORDER_TYPE_GOODS;
				String id = order.getId().toString();
				// 如果完成支付
				if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
					response.setIsCompletePay(true);
					return response;
				} else {
					// 如果云豆支付
					if (OrderFormConstants.ORDER_PAY_TYPE_BALANCE.equals(order.getPayType())) {

						Predeposit pr = predepositService.getObjById(order.getCashId());

						// 如果使用云豆支付，找云豆充值记录上的支付方式
						payment = this.paymentService.findByMark(pr.getPdPayment());
						type = PaymentConstants.ORDER_TYPE_CASH;
						id = order.getCashId().toString();

					} else if (OrderFormConstants.ORDER_PAY_TYPE_ONLINE.equals(order.getPayType())) {
						// 如果没有使用云豆支付，找订单上的支付方式
						payment = this.paymentService.findById(order.getPaymentId());

					} else if (OrderFormConstants.ORDER_PAY_TYPE_YUNGOUMONEY.equals(order.getPayType())) {
						Predeposit pr = predepositService.getObjById(order.getCashId());
						payment = this.paymentService.findByMark(pr.getPdPayment());
						type = PaymentConstants.ORDER_TYPE_CASH;
						id = order.getCashId().toString();
					}

					if (vo.getIsYunGouMoney() && StringUtils.isNotBlank(vo.getPaymentType())) {

						if (null != vo.getPaymentType()
								&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {
							payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_WX_APP);
						} else if (null != vo.getPaymentType()
								&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {
							payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_APP);
						}

						String paySignature = payTools.appPay_forYg(config.getAddress(), payment.getId()
								.toString(), type, id);

						if (null != vo.getPaymentType()
								&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {
							response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
						} else if (null != vo.getPaymentType()
								&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {

							response.setPaySignature(paySignature);
						}
						response.setPaymetType(payment.getMark());

					} else {

						String paySignature = payTools.appPay(config.getAddress(),
								payment.getId().toString(), type, id);

						if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(payment.getMark())) {

							response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));

						} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {

							response.setPaySignature(paySignature);
						}
						response.setPaymetType(payment.getMark());
					}

					return response;
				}
			} catch (ServiceException e) {
				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);

			}
		} else if (vo.getType() == 2) {// o2o支付
			try {
				GroupOrderBO order = groupOrderService.orderPay(vo.getPaymentType(),
						CommUtil.null2Long(vo.getMainOrderId()), uid, vo.getIsUserMoneyPaymet(),
						vo.getPaymetPassword(), accountType);// 这里增加CN用户判断
				Payment payment = null;
				String type = PaymentConstants.ORDER_TYPE_GROUP;
				String id = order.getId().toString();
				// 如果完成支付
				if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
					response.setIsCompletePay(true);

					/*try {
						//消息推送
						 message = "您的订单"+order.getOrderId()+"于"+date + "付款成功";
						 noticeMesg.setNoticeMessage(message);
						 noticeMesg.setCreateTime(new Date());
						noticeMessageService.save(noticeMesg);
						noticeMessageService.pushMessage(noticeMesg);
						log.info("=======消息推送=========");
					} catch (Exception e) {
						log.info("=======订单支付：消息推送出现异常=========");
					}*/
					return response;
				} else {
					// 如果云豆支付
					if (OrderFormConstants.ORDER_PAY_TYPE_BALANCE.equals(order.getPaymentMark())) {

						Predeposit pr = predepositService.getObjById(order.getCashId());

						// 如果使用云豆支付，找云豆充值记录上的支付方式
						payment = this.paymentService.findByMark(pr.getPdPayment());
						type = PaymentConstants.ORDER_TYPE_CASH;
						id = order.getCashId().toString();
					} else {
						// 如果没有使用云豆支付，找订单上的支付方式
						// payment =
						// this.paymentService.findById(order.getPaymentMark());
						payment = paymentService.findByMark(order.getPaymentMark(), null);
					}

					String paySignature = payTools.appPay(config.getAddress(), payment.getId().toString(),
							type, id);

					if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(payment.getMark())) {
						response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
					} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {
						response.setPaySignature(paySignature);
					}
					response.setPaymetType(payment.getMark());

					/*try {
						//消息推送
						 message = "您的订单"+order.getOrderId()+"于"+date + "付款成功";
						 noticeMesg.setNoticeMessage(message);
						 noticeMesg.setCreateTime(new Date());
						noticeMessageService.save(noticeMesg);
						noticeMessageService.pushMessage(noticeMesg);
						log.info("=======消息推送=========");
					} catch (Exception e) {
						log.info("=======订单支付：消息推送出现异常=========");
					}*/
					return response;
				}
			} catch (ServiceException e) {
				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}
		} else if (vo.getType() == 3) { // 积分商城邮费支付
			try {
				IntegralGoodsOrderBO order = integralGoodsOrderService.orderPay(vo.getPaymentType(),
						vo.getMainOrderId(), uid, vo.getIsUserMoneyPaymet(), vo.getPaymetPassword());
				Payment payment = null;
				String type = PaymentConstants.ORDER_TYPE_INTEGRAL;
				String id = order.getId().toString();
				// 如果完成支付
				if (order.getIgoStatus() >= IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED) {
					response.setIsCompletePay(true);

					/*try {
						//消息推送
						 message = "您的订单"+order.getIgoOrderSn()+"于"+date + "付款成功";
						 noticeMesg.setNoticeMessage(message);
						 noticeMesg.setCreateTime(new Date());
						noticeMessageService.save(noticeMesg);
						noticeMessageService.pushMessage(noticeMesg);
						log.info("=======消息推送=========");
					} catch (Exception e) {
						log.info("=======订单支付：消息推送出现异常=========");
					}*/

					return response;
				} else {
					// 如果云豆支付
					if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(order.getIgoPayment())) {

						Predeposit pr = predepositService.getObjById(order.getCashId());

						// 如果使用云豆支付，找云豆充值记录上的支付方式
						payment = this.paymentService.findByMark(pr.getPdPayment());
						type = PaymentConstants.ORDER_TYPE_CASH;
						id = order.getCashId().toString();
					} else {
						// 如果没有使用云豆支付，找订单上的支付方式
						// payment =
						// this.paymentService.findById(order.getPaymentMark());
						payment = paymentService.findByMark(order.getIgoPayment(), null);
					}

					String paySignature = payTools.appPay(config.getAddress(), payment.getId().toString(),
							type, id);

					if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(payment.getMark())) {
						response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
					} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(payment.getMark())) {
						response.setPaySignature(paySignature);
					}
					response.setPaymetType(payment.getMark());

					/*	try {
							//消息推送igoPayTime
							 message = "您的订单"+order.getIgoOrderSn()+"于"+date+ "付款成功";
							 noticeMesg.setCreateTime(new Date());
							 noticeMesg.setNoticeMessage(message);
							noticeMessageService.save(noticeMesg);
							noticeMessageService.pushMessage(noticeMesg);
							log.info("=======消息推送=========");
						} catch (Exception e) {
							log.info("=======订单支付：消息推送出现异常=========");
						}*/

					return response;
				}
			} catch (ServiceException e) {
				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}
		}

		return response;
	}

	@SuppressWarnings("unchecked")
	private WeiXinPaymetBO makeWeixinPaymet(Payment payment, String content) {
		Document doc = Jsoup.parse(content, "", Parser.xmlParser());

		WeiXinPaymetBO weiXinPaymet = new WeiXinPaymetBO();
		weiXinPaymet.setAppid(payment.getWxAppid());
		weiXinPaymet.setPrepayid(doc.select("prepay_id").text());
		weiXinPaymet.setNoncestr(UUID.randomUUID().toString().replace("-", ""));
		weiXinPaymet.setPartnerid(payment.getTenpayPartner());
		weiXinPaymet.setTimestamp(String.valueOf(new Date().getTime() / 1000));

		Map<String, String> map = null;
		try {
			map = BeanUtils.describe(weiXinPaymet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("package", map.get("package1"));
		map.remove("class");
		map.remove("package1");

		String sign = Signature.generateSign(map, payment.getWxPaysignkey());
		weiXinPaymet.setSign(sign);
		return weiXinPaymet;
	}

	/***
	 * 订单列表 去支付
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/shop/trade/paymet/view", method = RequestMethod.POST)
	@MethodMapping(desc = "订单支付需的的详情")
	public @ResponseBody
	ShopTradePaymetViewResponse paymetView(@Valid @ModelAttribute @Param ShopTradePaymetViewVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopTradePaymetViewResponse response = new ShopTradePaymetViewResponse();
		Map<String, String> errorParam = new HashMap<>();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		OrderForm mainOrder = this.orderFormService.getObjById(vo.getId());
		if (mainOrder != null) {
			response.setOrder(mapper.map(mainOrder, ShopOrderFormBO.class));
			if (null != mainOrder.getIsygOrder() && mainOrder.getIsygOrder()) {// 表示精选专区订单
				SelectYgPayModeBO selectYgPayMode = new SelectYgPayModeBO();
				if (mainOrder.getPayTypeFlag().intValue() == 2) {// 积分支付
					if (mainOrder.getOrderStatus() != OrderFormConstants.ORDER_STATUS_TO_BE_YG) {
						selectYgPayMode = this.orderFormService.getBeautyPayMode(
								CommUtil.null2String(mainOrder.getId()), mainOrder.getUserId());
					} else {
						selectYgPayMode.setActualPrice(CommUtil.null2Double(mainOrder.getAllCashPrice()));
						selectYgPayMode.setActualIntegralBalance(0.0);
						selectYgPayMode.setRes(30);
						selectYgPayMode.setPay_mode(OrderFormConstants.YG_ORDER_PAY_TYPE_CASH);
						Double resPv = this.orderFormService.getCnUserPv(mainOrder.getUserId());
						selectYgPayMode.setCurrentIntegralBalance(resPv);//增加当前积分
					}
					response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllCashPrice().add(mainOrder.getAllIntegral())));
					
				} else if (mainOrder.getPayTypeFlag().intValue() == 1) {// 云购币支付
					selectYgPayMode = this.orderFormService.getCxPayMode(
							CommUtil.null2String(mainOrder.getId()), mainOrder.getUserId());
					// 重消+运费支付总价
					response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllygPrice().add(
							mainOrder.getShipPrice())));
				} else if (mainOrder.getPayTypeFlag().intValue() == 3) {//普通会员的精选专区
					
					try {
						selectYgPayMode = this.orderFormService.getJingXuanPayMode(
								CommUtil.null2String(mainOrder.getId()), mainOrder.getUserId());
						response.setTotalPrice(CommUtil.null2Double(mainOrder.getAllCashPrice().add(mainOrder.getAllIntegral())));
					} catch (ServiceException e) {
						errorParam.put("msg", e.getErrorCode());
						response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
					}
				}
				response.setYgPayMode(mapper.map(selectYgPayMode, YgPayModeBO.class));

			} else if (mainOrder.getOrderTypeFlag().intValue() == 2) {// 表示非专区的云购币订单
				response.setTotalPrice(ofTools.query_yg_order_price(mainOrder));
			} else {
				response.setTotalPrice(ofTools.query_order_price(mainOrder));// 普通订单价格
			}

		}

		return response;
	}

	@RequestMapping(value = "/shop/trade/return/apply", method = RequestMethod.POST)
	@MethodMapping(desc = "订单退货申请")
	public @ResponseBody
	NullResponse tradeReturnApply(@Valid @ModelAttribute @Param ShopTradeReturnApplyVO vo,
			BindingResult result, HttpServletRequest request) {
		NullResponse response = new NullResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		Map<String, String> errorParam = new HashMap<>();

		try {
			this.orderFormService.applyOrderReturn(vo.getOrderId(), uid, vo.getReturnGoodsContent(),
					vo.getGoodsId(), "", vo.getGoodsGspIds());
		} catch (ServiceException e) {
			errorParam.put("msg", e.getErrorCode());
			response.putErrorMessage("4.shop_trade.tradeReturnApply.failure", errorParam);
		}

		return response;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping(value = "/shop/trade/return/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商品退货记录列表")
	public @ResponseBody
	ShopTradeReturnListResponse tradeReturnList(@Valid @ModelAttribute @Param ShopTradeReturnListVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopTradeReturnListResponse response = new ShopTradeReturnListResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		MyPage<Map> page = new MyPage<Map>();
		page.setCurrentPage(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		returnGoodsLogService.selectByUser(uid, page);

		List<ReturnGoodsLogBO> list = MapperUtils.map(mapper, page.getResult(), ReturnGoodsLogBO.class);
		response.setList(list);
		response.setTotalPage(page.getTotalPages());
		response.setCurrentPage(page.getCurrentPage());
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/shop/trade/return/view", method = RequestMethod.POST)
	@MethodMapping(desc = "商品退货记录详情")
	public @ResponseBody
	ShopTradeReturnViewResponse tradeReturnView(@Valid @ModelAttribute @Param ShopTradeReturnViewVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopTradeReturnViewResponse response = new ShopTradeReturnViewResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		ReturnGoodsLogBO obj = mapper.map(this.returnGoodsLogService.getObjById(vo.getId()),
				ReturnGoodsLogBO.class);
		response.setReturnGoodsLog(obj);
		return response;
	}

	@RequestMapping(value = "/shop/trade/return/ship/save", method = RequestMethod.POST)
	@MethodMapping(desc = "订单退货物流信息保存")
	public @ResponseBody
	NullResponse saveReturnShip(@Valid @ModelAttribute @Param ShopTradeReturnShipSaveVO vo,
			BindingResult result, HttpServletRequest request) {
		NullResponse response = new NullResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		Map<String, String> errorParam = new HashMap<>();

		try {
			this.returnGoodsLogService.saveUserReturnExpress(vo.getReturnGoodsLogId(), uid,
					vo.getExpressId(), vo.getExpressCode());
		} catch (ServiceException e) {
			errorParam.put("msg", e.getErrorCode());
			response.putErrorMessage("4.shop_trade.saveReturnShip.failure", errorParam);
		}

		return response;
	}

	@RequestMapping(value = "/shop/trade/return/cancel", method = RequestMethod.POST)
	@MethodMapping(desc = "订单退货取消")
	public @ResponseBody
	NullResponse cancelReturn(@Valid @ModelAttribute @Param ShopTradeReturnCancelVO vo, BindingResult result,
			HttpServletRequest request) {
		NullResponse response = new NullResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();

		Map<String, String> errorParam = new HashMap<>();
		try {
			this.returnGoodsLogService.cancelReturnGoods(vo.getOrderId(), vo.getGoodsId(),
					vo.getGoodsGspIds(), uid);
		} catch (ServiceException e) {
			errorParam.put("msg", e.getErrorCode());
			response.putErrorMessage("4.shop_trade.saveReturnShip.failure", errorParam);
		}

		return response;
	}

	@RequestMapping(value = "/shop/order_status/get", method = RequestMethod.POST)
	@MethodMapping(desc = "获取订单状态")
	public @ResponseBody
	ShopTradePaymetResponse getOrderFormStatus(
			@Valid @RequestParam(value = "orderId") @Param(desc = "订单id") Long orderId) {
		ShopTradePaymetResponse response = new ShopTradePaymetResponse();
		if (orderId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}
		OrderForm order = orderFormService.getObjById(orderId);
		if (order != null) {
			// 设置订单状态
			response.setOrderStatus(order.getOrderStatus());
			// TODO
			// 临时处理，app端是根据状态=20来判断是否成功支付
			// 下个版本恢复
			if (order.getOrderStatus() == 30) {
				response.setOrderStatus(20);
			}
		}
		return response;
	}

	/***
	 * 
	 * 云购币专区支付
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/shop/trade/yg/paymet", method = RequestMethod.POST)
	@MethodMapping(desc = "云购币专区支付")
	public @ResponseBody
	ShopTradePaymetResponse yg_order_pay(@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			BindingResult result, HttpServletRequest request) {

		SysConfigBO config = configService.getSysConfig();
		ShopTradePaymetResponse response = new ShopTradePaymetResponse();

		Map<String, String> errorParam = new HashMap<>();
		Long uid = ActionsUtil.getOwnerUid();
		OrderFormBO order = orderFormService.fetch(CommUtil.null2Long(vo.getMainOrderId()));
		int payMode = this.orderFormService.getpayMode(vo.getPayType());
		Payment payment = this.orderFormService.getPayment(payMode, vo.getPaymentType());

		int res = 100;

		if (payMode != 3) {// 云购+其他
			try {
				res = orderFormService.ygorder_Pay(payMode, CommUtil.null2String(vo.getMainOrderId()),
						vo.getBonusYunGouPwd(), vo.getActualygPrice(), vo.getActualPrice(), uid,
						payment.getId());
			} catch (ServiceException e) {

				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}

			OrderFormBO resOrder = orderFormService.selectById(CommUtil.null2String(vo.getMainOrderId()));
			if (resOrder.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				response.setIsCompletePay(true);
				return response;
			}

		} else { // 云购加 第三方
			System.out.println("payMode2cash---------->" + payMode);
			String type = PaymentConstants.ORDER_TYPE_GOODS;

			if (!StringUtils.isEmpty(vo.getActualygPrice())
					&& Double.valueOf(vo.getActualygPrice()).intValue() != 0
					&& order.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TO_BE_YG) {

				try {
					res = orderFormService.ygorder_Pay(payMode, CommUtil.null2String(vo.getMainOrderId()),
							vo.getBonusYunGouPwd(), vo.getActualygPrice(), "0", uid, payment.getId());
				} catch (ServiceException e) {

					log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
					errorParam.put("msg", e.getErrorCode());
					response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
				}

			} else {
				this.orderFormService.updateOrderPayment(order, payment.getId());
			}

			if (res == 100) {

				if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {
					payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_WX_APP);
				} else if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {

					payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_APP);

				}

				System.out.println("WXali 下单");
				String paySignature = payTools.appPay_forYg(config.getAddress(), payment.getId().toString(),
						type, CommUtil.null2String(vo.getMainOrderId()));

				if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {

					response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
				} else if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {

					response.setPaySignature(paySignature);
				}
				response.setPaymetType(payment.getMark());

			}

		}

		return response;
	}

	/***
	 * 
	 * 精品专区-积分支付
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/shop/trade/integral/paymet", method = RequestMethod.POST)
	@MethodMapping(desc = "精品专区积分支付")
	public @ResponseBody
	ShopTradePaymetResponse integral_order_pay(@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			BindingResult result, HttpServletRequest request) {

		SysConfigBO config = configService.getSysConfig();
		ShopTradePaymetResponse response = new ShopTradePaymetResponse();

		Map<String, String> errorParam = new HashMap<>();
		Long uid = ActionsUtil.getOwnerUid();
		OrderFormBO order = orderFormService.fetch(CommUtil.null2Long(vo.getMainOrderId()));
		int payMode = this.orderFormService.getpayMode(vo.getPayType());
		Payment payment = this.orderFormService.getBeautyPaymentApp(payMode, vo.getPaymentType());

		int res = 100;
		if (payMode != 3) {// 云购+其他
			try {
				res = this.orderFormService.beautyIntegralPay0(payMode, vo.getMainOrderId().toString(),
						vo.getBonusYunGouPwd(), vo.getActualJfPrice(), vo.getActualPrice(), uid,
						payment.getId());

			} catch (ServiceException e) {

				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}

			OrderFormBO resOrder = orderFormService.selectById(CommUtil.null2String(vo.getMainOrderId()));
			if (resOrder.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				response.setIsCompletePay(true);
				return response;
			}

		} else { // 云购加 第三方
			String type = PaymentConstants.ORDER_TYPE_GOODS;

			try {

				this.orderFormService.beautyIntegralPay2(vo.getMainOrderId().toString(), payment.getId(),
						uid, vo.getBonusYunGouPwd(), vo.getActualJfPrice());

			} catch (ServiceException e) {
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}

			if (res == 100) {

				if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {
					payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_WX_APP);
				} else if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {

					payment = paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_APP);

				}

				String paySignature = this.payTools.appCommonPay(config.getAddress(),
						CommUtil.null2String(payment.getId()), type,
						CommUtil.null2String(vo.getMainOrderId()),
						CommUtil.null2BigDecimal(vo.getActualPrice()));

				if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {

					response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));

				} else if (null != vo.getPaymentType()
						&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {

					response.setPaySignature(paySignature);
				}
				response.setPaymetType(payment.getMark());

			}

		}

		return response;
	}

	/***
	 * 
	 * 重消+运费支付
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 * @author yuanming
	 */
	@RequestMapping(value = "/shop/trade/cx/paymet", method = RequestMethod.POST)
	@MethodMapping(desc = "重消+运费支付")
	public @ResponseBody
	ShopTradePaymetResponse cxOrderPay(@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopTradePaymetResponse response = new ShopTradePaymetResponse();
		Map<String, String> errorParam = new HashMap<String, String>();
		SysConfigBO config = configService.getSysConfig();
		// 校验参数
		if (null == vo) {
			log.error(String.format("支付错误：参数异常"));
			errorParam.put("msg", "parameter error!");
			response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			return response;
		}
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
		// 根据订单ID获取订单信息
		OrderFormBO order = orderFormService.fetch(CommUtil.null2Long(vo.getMainOrderId()));
		if (null == order) {
			log.error(String.format("支付错误：订单不存在"));
			errorParam.put("msg", "order error!");
			response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			return response;
		}
		// 1：重消+工资、2：重消+充值帐户、3：重消+第三方支付
		int payMode = 3;
		// 获取支付的相关信息
		Payment payment = this.orderFormService.getPayment(payMode, vo.getPaymentType());
		int res = 100;
		System.out.println("payMode2cash---------->" + payMode);
		// 充值需要处理的订单的类型: 商品: goods 积分商品:integral 云豆充值：cash 服务订单类型：group
		String type = PaymentConstants.ORDER_TYPE_GOODS;
		if (!BigDecimal.ZERO.equals(order.getActualygPrice())
				&& order.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TO_BE_YG) {
			try {
				// 如果需要支付的重消不为空，并且未支付过的情况下，支付重消
				res = orderFormService.ygorder_Pay(payMode, CommUtil.null2String(vo.getMainOrderId()),
						vo.getBonusYunGouPwd(), order.getAllygPrice() + "", "0", uid, payment.getId());
			} catch (ServiceException e) {
				log.error(String.format("支付错误：%s", CommUtil.getStackTrace(e)));
				errorParam.put("msg", e.getErrorCode());
				response.putErrorMessage("4.shop_trade.tradePaymet.failure", errorParam);
			}
		} else {
			// 如果重消为空，或者已支付过则更新相关信息
			this.orderFormService.updateOrderPayment(order, payment.getId());
		}
		if (res == 100) { // 状态100为支付成功
			// 获取运费价格
			BigDecimal shipPrice = order.getShipPrice();
			// 第三方支付
			String paySignature = payTools.appCommonPay(config.getAddress(), payment.getId().toString(),
					type, CommUtil.null2String(vo.getMainOrderId()), shipPrice);
			if (null != vo.getPaymentType()) {
				if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPaymentType())) {
					response.setWeiXinPaymet(makeWeixinPaymet(payment, paySignature));
				} else if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPaymentType())) {
					response.setPaySignature(paySignature);
				}
			}
			response.setPaymetType(vo.getPaymentType());
		}
		return response;
	}
	
	/***
	 * 精选专区普通会员支付接口
	 * 
	 * @param vo
	 * @param result
	 * @param request
	 * @throws ServiceException/shop/trade
	 */
	@RequestMapping(value = "/shop/trade/jingxuan/pay", method = RequestMethod.POST)
	@MethodMapping(desc = "普通用户支付")
	@ResponseBody
	public ShopPaymetResponse jingxuanOrderPay(
			@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			HttpServletRequest request) throws ServiceException {

		SysConfigBO config = configService.getSysConfig();
		ShopPaymetResponse response = new ShopPaymetResponse();
		PaymentBO paymentBO = this.orderFormService.getPayment(vo.getPayType(),
				2);
		// 获取当前用户ID
		Long uid = ActionsUtil.getOwnerUid();
		OrderFormBO order = null;
		try {
			order = this.orderFormService
					.jingpinOrderPay(vo.getMainOrderId(),
							vo.getIsUserMoneyPaymet(), vo.getPaymetPassword(),
							vo.getPayType(), uid, paymentBO.getId());  
			
		} catch (ServiceException e) {
			response.setM_status(ResultCodeConstant.ERROR_STATUS);
			log.info("e.getMessage{} + e.getErrorCode{}",e.getMessage(),e.getErrorCode());
			response.setM_errorMsg(e.getErrorCode());
			response.setM_errorCode(ResultCodeConstant.PARAMETER_ERROR);
			return response;
		}

		
		if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			response.setIsCompletePay(true);
			return response;
		} else {

			if (null != vo.getPayType()
					&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPayType())) {
				paymentBO = paymentService
						.findByMark(PaymentConstants.PAYMENT_MARK_WX_APP);
				log.info("PAYMENT_MARK_WX_APP{}",paymentBO.getId());
			} else if (null != vo.getPayType()
					&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPayType())) {
				paymentBO = paymentService
						.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_APP);
				log.info("PAYMENT_MARK_ALIPAY_APP{}",paymentBO.getId());

			}
			String type = PaymentConstants.ORDER_TYPE_GOODS;
			String paySignature = this.payTools.appCommonPay(
					config.getAddress(),
					CommUtil.null2String(paymentBO.getId()), type,
					CommUtil.null2String(vo.getMainOrderId()),
					CommUtil.null2BigDecimal(order.getAllCashPrice()));
				log.info("paySignature{}",paySignature);
			if (null != vo.getPayType()
					&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo.getPayType())) {
				response.setWeiXinPaymet(makeWeixinPaymet(paymentBO,paySignature));
						
			} else if (null != vo.getPayType()
					&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo.getPayType())) {
				response.setPaySignature(paySignature);
			}
			log.info("setPaymetType{}",paymentBO.getMark());
			response.setPaymetType(paymentBO.getMark());
		}
		return response;

	}

}
