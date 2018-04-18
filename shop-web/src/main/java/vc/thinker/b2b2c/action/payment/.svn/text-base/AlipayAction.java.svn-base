package vc.thinker.b2b2c.action.payment;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.enums.EmQrPayOrderPaymentType;
import com.sinco.carnation.shop.enums.EmShopQrOrderPayStatus;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.SellerService;

/**
 * 支付宝支付
 * 
 * @author yuleijia
 */
@Controller
public class AlipayAction {

	@Autowired
	private PaymentService paymentService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	private static final Logger logger = LoggerFactory.getLogger(AlipayAction.class);
	/**
	 * 开放平台应用的APPID
	 */
	private static final String APP_ID = "2016081801765029";
	/**
	 * 请求和签名使用的字符编码格式
	 */
	private static final String CHARSET = "UTF-8";
	/**
	 * 支付宝手机网站支付接口
	 */
	private static final String WAP_APLPAY_URL = "https://openapi.alipay.com/gateway.do";

	/**
	 * 手机网站支付入口
	 * 
	 * @param request
	 * @param response
	 * @param sellerID
	 */
	@RequestMapping("/aliPay/wap.htm")
	public void alipay_wap(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "sellerId") String sellerID, @RequestParam(value = "money") String money) {
		logger.info(" ============== alipay start ============== ");
		String webPath = CommUtil.getURL(request);
		SellerBO sellerbo = sellerService.findByUid(Long.parseLong(sellerID));
		if (sellerbo == null) {
			this.returnBody(response, Json.toJson(ActionResult.NewFail("卖家信息不存在")));
			return;
		}
		BigDecimal totale_ = new BigDecimal(money);
		if (totale_.compareTo(BigDecimal.ZERO) < 1) {
			this.returnBody(response, Json.toJson(ActionResult.NewFail("支付金额必须大于0")));
			return;
		}
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_WAP);
		if (payment == null) {
			this.returnBody(response, Json.toJson(ActionResult.NewFail("请设置'商家支付宝扫码支付'支付信息！")));
			return;
		}
		StoreBO storeBo = storeService.getStoreBOById(sellerbo.getStoreId());
		if (storeBo == null) {
			this.returnBody(response, Json.toJson(ActionResult.NewFail("店铺信息不存在！")));
			return;
		}
		ShopQrPayOrderBO order = shopQrPayOrderService.newShopQrPayOrder(sellerbo.getUid(), totale_,
				EmQrPayOrderPaymentType.AliPay, sellerbo.getMobile(), "用户专属码【支付宝支付】");
		shopQrPayOrderService.save(order);

		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		String subject = webName + "商家店内扫描支付";
		subject += "订单号:" + order.getPayOrderNo();
		subject += storeBo.getStoreName() == null ? "" : "\n 商家:" + storeBo.getStoreName();
		logger.info("========= subject ->" + subject);
		try {
			this.wap_doPost(request, response, payment, money, webPath, order, subject);
		} catch (AlipayApiException | IOException e) {
			logger.error(e.getMessage());
			this.returnBody(response, Json.toJson(ActionResult.NewFail("支付失败")));
		}
	}

	/**
	 * 发送请求
	 * 
	 * @param request
	 * @param response
	 * @param payment
	 * @param money
	 * @param webPath
	 * @param order
	 * @param subject
	 * @throws AlipayApiException
	 * @throws IOException
	 */
	private void wap_doPost(HttpServletRequest request, HttpServletResponse response, Payment payment,
			String money, String webPath, ShopQrPayOrderBO order, String subject) throws AlipayApiException,
			IOException {
		logger.info(" ============== alipay doPost ============== ");
		String APP_PRIVATE_KEY = payment.getAppPrivateKey();
		String ALIPAY_PUBLIC_KEY = payment.getAppPublicKey();

		AlipayClient alipayClient = new DefaultAlipayClient(WAP_APLPAY_URL, APP_ID, APP_PRIVATE_KEY, "json",
				CHARSET, ALIPAY_PUBLIC_KEY);

		String return_url = webPath + "/aliPay/return_url.htm";
		String notify_url = webPath + "/aliPay/notify_url.htm";

		Map<String, String> params = new HashMap<String, String>();
		params.put("out_trade_no", order.getPayOrderNo());
		params.put("total_amount", "" + Double.valueOf(money));
		params.put("subject", URLEncoder.encode(subject, "UTF-8"));
		params.put("product_code", "YSYSGO_PRODUCT_PAY");
		params.put("sign_type", "RSA");

		String sign = AlipaySignature.rsaSign(params, APP_PRIVATE_KEY, CHARSET);

		params.put("sign", sign);
		JSONObject json = JSONObject.fromObject(params);

//		json.element("out_trade_no", order.getPayOrderNo());
//		json.element("total_amount", Double.valueOf(money));
//		json.element("subject", URLEncoder.encode(subject, "UTF-8"));
//		json.element("product_code", "YSYSGO_PRODUCT_PAY");
//		json.element("sign_type", "RSA");
		String bizContent = json.toString();
		logger.info("===== bizContent->" + bizContent);

		AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();

		/*AlipayOpenPublicTemplateMessageIndustryModifyRequest alipayRequest 
			= new AlipayOpenPublicTemplateMessageIndustryModifyRequest();*/

		// 在公共参数中设置回跳和通知地址
		alipayRequest.setReturnUrl(return_url);
		alipayRequest.setNotifyUrl(notify_url);
		alipayRequest.setBizContent(bizContent);// 填充业务参数
		String form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单

		response.setContentType("text/html;charset=" + CHARSET);
		response.getWriter().write(form); // 直接将完整的表单html输出到页面
		response.getWriter().flush();
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/aliPay/return_url.htm")
	public ModelAndView return_url(HttpServletRequest request, HttpServletResponse response) {
		logger.info("=============== aliPay return_url start =============== ");
		ModelAndView mv = new JModelAndView("order_finish.html", configService.getSysConfig(), 1, request,
				response);
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
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());;
			}
			params.put(name, valueStr);
		}
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_WAP);
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, payment.getAppPublicKey(), CHARSET);
			logger.info("===== 验证结果->" + signVerified);
			if (signVerified) {
				// 验签成功后，按照支付结果异步通知中的描述，对支付结果中的业务内容进行二次校验，
				// 校验成功后在response中返回success并继续商户自身业务处理，校验失败返回failure
				String trade_status = "";
				// 交易状态
				try {
					trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),
							"UTF-8");
				} catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage());
				}
				if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
					logger.info(" ============== pay success ============ ");
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "支付失败");
					mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
				}
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "支付回调失败");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
		} catch (AlipayApiException e) {
			logger.error(e.getMessage());
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@RequestMapping("/aliPay/notify_url.htm")
	public void notify_url(HttpServletRequest request, HttpServletResponse response) {
		logger.info("=============== AliPay notify_url start =============== ");
		// 获取支付宝POST过来反馈信息
		Map<String, String> params = new HashMap<String, String>();

		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			// 在通知返回参数列表中，除去sign、sign_type两个参数外，凡是通知返回回来的参数皆是待验签的参数
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			try {
				valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			} catch (UnsupportedEncodingException e) {
				logger.error(e.getMessage());
			}
			params.put(name, valueStr);
		}
		logger.info("<<<<<<<<<<<<<<<<<< params -> " + params.toString());
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_WAP);
		try {
			boolean signVerified = AlipaySignature.rsaCheckV1(params, payment.getAppPublicKey(), CHARSET);
			logger.info("===== 验证结果->" + signVerified);
			if (signVerified) {
				String out_trade_no = "";
				String trade_no = "";
				// 交易状态
				String trade_status = "";
				try {
					// 商户订单号
					out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),
							"UTF-8");
					// 支付宝交易号
					trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
					// 交易状态
					trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),
							"UTF-8");

					logger.info("==================== trade_status->" + trade_status);
					if (trade_status.equals("TRADE_FINISHED")) // 交易结束，不可退款
					{
						// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
						// 保留 扩展使用
					}
					if (trade_status.equals("TRADE_SUCCESS")) // 交易支付成功
					{
						logger.info("================== TRADE_SUCCESS =================== ");
						// 付款完成后，支付宝系统发送该交易状态通知
//						String sellerID = request.getParameter("s");
//						logger.info("<<<<<<<< sellerID->"+sellerID);
						// 修改支付状态
						this.shopQrPayOrderService.updateQrPayOrderPayStatus(out_trade_no, null,
								(byte) EmShopQrOrderPayStatus.PaySuccess.getValue());
					}
				} catch (UnsupportedEncodingException e) {
					logger.error(e.getMessage());
				} catch (Exception e) {
					logger.error(e.getMessage());
				} finally {
					logger.info("==================== response -> success");
					this.responseWriter(response, "success");
				}
			} else {
				logger.info("==================== response -> failure");
				this.responseWriter(response, "failure");
			}
		} catch (AlipayApiException e) {
			logger.error(e.getMessage());
			this.responseWriter(response, "failure");
		} catch (Exception e) {
			logger.error(e.getMessage());
			this.responseWriter(response, "failure");
		}
	}

	/**
	 * 
	 * @param response
	 * @param json
	 */
	public void returnBody(HttpServletResponse response, String json) {
		CommUtil.returnBody(response, json);
	}

	public void responseWriter(HttpServletResponse response, String content) {
		try {
			response.getWriter().print(content);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
