package com.sinco.carnation.resource.web.actions.jiuye;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.dozer.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.web.BasicApiController;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.biz.utils.httpclient.HttpRequestClient;
import com.sinco.biz.utils.httpclient.Httpclient;
import com.sinco.carnation.jiuye.config.JiuyeConfig;
import com.sinco.carnation.jiuye.constant.JiuyeContants;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.jiuye.utils.IdTypeHandler;
import com.sinco.carnation.jiuye.vo.JiuyeOrderPojectVO;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderFormBO;
import com.sinco.carnation.resource.vo.shop.ShopTradePaymetVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.ShopOrderCreateCreateResponse;
import com.sinco.carnation.resource.web.response.shop.ShopPaymetResponse;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.weixin.utils.Signature;

/**
 * 酒业支付业务
 * 
 * @author Administrator
 * 
 */
@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "酒业支付业务", namespace = "jiuyePay")
public class PaymentAction extends BasicApiController {
	private static final Logger log = LoggerFactory
			.getLogger(PaymentAction.class);
	@Autowired
	private PayTools payTools;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private JiuyeOrderFormService jiuyeOrderFormService;
	@Autowired
	private Mapper mapper;

	/***
	 * 酒业创建订单
	 * 
	 * @param orderId
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/jiuyeOrder/order/create", method = RequestMethod.POST)
	@MethodMapping(desc = "创建订单")
	@ResponseBody
	public ShopOrderCreateCreateResponse createJiuyeOrder(String orderId) {
		ShopOrderCreateCreateResponse response = new ShopOrderCreateCreateResponse();
		Map<String, String> errorParam = new HashMap<String, String>();
		// 组装接口参数
		StringBuffer remoteURL = new StringBuffer();
		remoteURL.append(JiuyeConfig.getRemoteServiceDomain()).append(
				JiuyeContants.TEST_GET_ORDER_LIST);
		Map<String, String> argumentsMap = new HashMap<String, String>();
		Long orderIdLong = IdTypeHandler.decode(orderId);
		argumentsMap.put("orderId", CommUtil.null2String(orderIdLong));
		// 远程数据访问
		Httpclient<JiuyeOrderPojectVO> httpClient = new HttpRequestClient<JiuyeOrderPojectVO>();
		JiuyeOrderPojectVO testJiuyeVO = null;

		try {
			testJiuyeVO = httpClient.get(remoteURL.toString(), argumentsMap,
					JiuyeOrderPojectVO.class);
			if (testJiuyeVO == null) {
				response.setM_status(1);
				response.setM_errorCode("4.shop_trade.tradePaymet.failure");
				response.setM_errorMsg("生成订单出错");
				return response;
			}
		} catch (Exception e) {
			log.debug("createJiuyeOrder HTTP request ", e);
			response.setM_status(1);
			response.setM_errorCode("4.shop_trade.tradePaymet.failure");
			response.setM_errorMsg("生成订单出错");
			return response;
		}
		// 保存到本地数据库
		try {
			int result = jiuyeOrderFormService.save(testJiuyeVO.getOrder());
			if (result == 100) {
				JiuyeOrder res = this.jiuyeOrderFormService
						.findByOrderId(CommUtil.null2Long(orderIdLong));
				ShopOrderFormBO bo = new ShopOrderFormBO();
				bo.setOrderId(res.getOrderNo());
				bo.setOrderTypeFlag(4);
				bo.setOrderStatus(res.getOrderStatus());
				bo.setOrderDetailUrl("http://ys.zjtech.cc/trueme/order/orderDetails.html?orderId="
						+ orderId);
				bo.setId(orderIdLong);
				response.setOrder(bo);
				response.setTotalPrice(CommUtil.null2Double(res.getPayMoney()));
			} else {
				log.debug("createJiuyeOrder save order 1 {}", result);
				response.setM_status(1);
				response.setM_errorCode("4.shop_trade.tradePaymet.failure");
				response.setM_errorMsg("生成订单出错");
			}
		} catch (ServiceException e) {
			log.debug("createJiuyeOrder save order 2 {}", e);
			response.setM_status(1);
			response.setM_errorCode("4.shop_trade.tradePaymet.failure");
			response.setM_errorMsg("生成订单出错");
			return response;
		}
		return response;
	}

	/***
	 * 酒业支付调用
	 * 
	 * @param vo
	 * @param request
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/jiuyeOrder/order/pay", method = RequestMethod.POST)
	@MethodMapping(desc = "酒业支付调用")
	@ResponseBody
	public ShopPaymetResponse jiuyeOrderPay(
			@Valid @ModelAttribute @Param ShopTradePaymetVO vo,
			HttpServletRequest request) throws ServiceException {
		SysConfigBO config = configService.getSysConfig();
		ShopPaymetResponse response = new ShopPaymetResponse();

		JiuyeOrder order = jiuyeOrderFormService.findByOrderId(vo
				.getMainOrderId());
		if (order == null || order.getOrderStatus() != 1) {
			response.setM_status(1);
			response.setM_errorCode("4.shop_trade.tradePaymet.failure");
			response.setM_errorMsg("订单不存在");
			return response;
		}

		// 支付调用
		log.info("JIUYE ORDER PAY START{}", vo.getMainOrderId());

		if (order != null) {// TODO
			String type = PaymentConstants.ORDER_TYPE_GOODS;
			PaymentBO payment = this.getPayment(vo.getPaymentType());

			this.jiuyeOrderFormService.updateOrderPayment(vo.getMainOrderId(),
					payment.getId());
			String paySignature = this.payTools.jiuyeCommonPay(
					config.getAddress(), CommUtil.null2String(payment.getId()),
					type, CommUtil.null2String(vo.getMainOrderId()),
					CommUtil.null2BigDecimal(order.getPayMoney()));// 参数从订单提取
			log.info("paySignature{}", paySignature);
			if (null != vo.getPaymentType()
					&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(vo
							.getPaymentType())) {
				response.setWeiXinPaymet(this.makeWeixinPaymet(payment,
						paySignature));
			} else if (null != vo.getPaymentType()
					&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(vo
							.getPaymentType())) {
				response.setPaySignature(paySignature);
			}
			response.setPaymetType(payment.getMark());
		}
		return response;
	}

	/***
	 * 获取支付信息对象
	 * 
	 * @param paymentType
	 * @return PaymentBO
	 */
	private PaymentBO getPayment(String paymentType) {
		PaymentBO payment = null;
		if (null != paymentType
				&& PaymentConstants.PAYMENT_MARK_WX_APP.equals(paymentType)) {
			payment = paymentService
					.findByMark(PaymentConstants.PAYMENT_MARK_WX_APP);
		} else if (null != paymentType
				&& PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(paymentType)) {
			payment = paymentService
					.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_APP);
		}
		return payment;
	}

	/***
	 * 封装微信支付对象
	 * 
	 * @param payment
	 * @param content
	 * @return
	 */
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
}
