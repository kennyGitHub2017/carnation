package com.sinco.carnation.order.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import net.sf.json.JSONObject;

import org.elasticsearch.common.collect.Maps;
import org.elasticsearch.common.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import org.nlpcn.commons.lang.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.pay.alipay.config.AlipayConfig;
import vc.thinker.b2b2c.pay.alipay.services.AlipayService;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.github.cuter44.alipay.AlipayFactory;
import com.github.cuter44.alipay.reqs.RequestBase;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.jiuye.model.JiuyeOrder;
import com.sinco.carnation.jiuye.service.JiuyeOrderFormService;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.enums.EmQrPayOrderPaymentType;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.dao.GoldRecordDao;
import com.sinco.carnation.user.model.GoldRecord;
import com.sinco.carnation.user.service.UserMoneyService;
import com.weixin.api.PayUtils;
import com.weixin.bean.PayH5QrCode;
import com.weixin.bean.PayNativeInput;
import com.weixin.bean.PayPackage;

/**
 * 
 * <p>
 * Title: PayTools.java
 * </p>
 * 
 * <p>
 * Description:在线支付工具类，用来生成主流常见支付平台的在线支付信息，并提交到支付平台 及支付宝手机网页在线支付
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-4-28
 * 
 * @version 1.0.1
 */
@Component
@SuppressWarnings({"rawtypes", "unchecked", "unused", "null"})
public class PayTools {

	private static final Logger log = LoggerFactory.getLogger(PayTools.class);
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormTools orderFormtools;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private GoldRecordDao goldRecordDao;

	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserMoneyService userMoneyService;

	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	@Autowired
	private StoreService storeService;

	@Value(value = "${carnation.isDebug}")
	private Integer isDebug = 0;

	public Integer getIsDebug() {
		return isDebug;
	}
	@Autowired
	private JiuyeOrderFormService jiuyeOrderFormService;
	/**
	 * 是否支付密码为空
	 * 
	 * @param uid
	 * @return
	 */
	public boolean isPaymentPasswordNull(Long uid) {
		return userMoneyService.isPasswordNull(uid);
	}

	/**
	 * 得到支付回调地址
	 * 
	 * @param url
	 * @param type
	 * @return
	 */
	public String getNotifyUrl(String url, String type) {
		if (PaymentConstants.PAYMENT_MARK_ALIPAY.equals(type)
				|| PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(type)
				|| PaymentConstants.PAYMENT_MARK_ALIPAY_WAP.equals(type)
				|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(type)
				|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(type)) {
			return url + "/alipay_notify.htm";
		}
		if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(type)
				|| PaymentConstants.PAYMENT_MARK_WX_PAY.equals(type)
				|| PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(type)) {
			return url + "/weixin_notify.htm";
		}
		return url;
	}

	public String getOrderInfo(String partner, String seller, String outTradeNo, String notifyUrl,
			String subject, String body, String price) {
		// 签约合作者身份ID
		String orderInfo = "partner=" + "\"" + partner + "\"";

		// 签约卖家支付宝账号
		orderInfo += "&seller_id=" + "\"" + seller + "\"";

		// 商户网站唯一订单号
		orderInfo += "&out_trade_no=" + "\"" + outTradeNo + "\"";

		// 商品名称
		orderInfo += "&subject=" + "\"" + subject + "\"";

		// 商品详情
		orderInfo += "&body=" + "\"" + body + "\"";

		// 商品金额
		orderInfo += "&total_fee=" + "\"" + price + "\"";

		// 服务器异步通知页面路径
		orderInfo += "&notify_url=" + "\"" + notifyUrl + "\"";

		// 服务接口名称， 固定值
		orderInfo += "&service=\"mobile.securitypay.pay\"";

		// 支付类型， 固定值
		orderInfo += "&payment_type=\"1\"";

		// 参数编码， 固定值
		orderInfo += "&_input_charset=\"utf-8\"";

		// 设置未付款交易的超时时间
		// 默认30分钟，一旦超时，该笔交易就会自动被关闭。
		// 取值范围：1m～15d。
		// m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
		// 该参数数值不接受小数点，如1.5h，可转换为90m。
		orderInfo += "&it_b_pay=\"30m\"";

		// extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
		// orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

		// 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
		orderInfo += "&return_url=\"m.alipay.com\"";

		// 调用银行卡支付，需配置此参数，参与签名， 固定值 （需要签约《无线银行卡快捷支付》才能使用）
		// orderInfo += "&paymethod=\"expressGateway\"";

		return orderInfo;
	}

	/**
	 * sign the order info. 对订单信息进行签名
	 * 
	 * @param content
	 *            待签名订单信息
	 */
	public String sign(String content, String rsa_private) {
		return SignUtils.sign(content, rsa_private);
	}

	/**
	 * get the sign type we use. 获取签名方式
	 * 
	 */
	public String getSignType() {
		return "sign_type=\"RSA\"";
	}

	/**
	 * 
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String appPay(String url, String payment_id, String type, String id) {

		boolean submit = true;
		OrderForm of = null;
		GroupOrderBO go = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		Map<String, String> params = Maps.newHashMap();
		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		}
		if (type.equals("cash")) {
			pd = this.predepositService.getObjById(CommUtil.null2Long(id));
			if (pd.getPdPayStatus() >= 2) {
				submit = false;// 预存款已经完成充值
			}
		}
		if (type.equals("gold")) {
			gold = this.goldRecordDao.get(CommUtil.null2Long(id));
			if (gold.getGoldPayStatus() >= 2) {
				submit = false;// 金币已经完成充值
			}
		}
		if (type.equals("integral")) {
			ig_order = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
			if (ig_order.getIgoStatus() >= 20) {
				submit = false;// 积分订单已经完成支付
			}
		}
		if (type.equals("group")) {
			go = this.groupOrderService.getObjById(CommUtil.null2Long(id));
			if (go.getOrderStatus() >= 20) {// 团购订单已经处于支付状态
				submit = false;
			}
		}
		if (submit) {

			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {// || type.equals("group")
				out_trade_no = of.getTradeNo();
			}
			if (type.equals("group")) {
				out_trade_no = go.getTradeNo();
			}
			if (type.equals("cash")) {
				out_trade_no = pd.getPdNo();
			}
			if (type.equals("integral")) {
				out_trade_no = ig_order.getIgoOrderSn();
			}
			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderId();
				orderNo = of.getOrderId();
			}
			if (type.equals("cash")) {
				subject = webName + "充值";
				orderNo = pd.getPdSn();
			}
			if (type.equals("gold")) {
				subject = gold.getGoldSn();
				orderNo = gold.getGoldSn();
			}
			if (type.equals("integral")) {
				subject = webName + "订单-" + ig_order.getIgoOrderSn();
				orderNo = ig_order.getIgoOrderSn();
			}
			if (type.equals("store_deposit")) {
				subject = "store_deposit";
			}
			if (type.equals("group")) {
				subject = go.getOrderId();
				orderNo = go.getOrderId();
			}
			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				double total_price = this.orderFormtools.query_order_price(CommUtil.null2String(of.getId()));
				total_fee = CommUtil.null2String(total_price);
			}
			if (type.equals("cash")) {
				total_fee = CommUtil.null2String(pd.getPdAmount());
			}
			if (type.equals("gold")) {
				total_fee = CommUtil.null2String(gold.getGoldMoney());
			}
			if (type.equals("integral")) {
				total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
			}
			if (type.equals("group")) {
				total_fee = CommUtil.null2String(go.getTotalPrice());
			}
			if (isDebug == 1) {
				total_fee = "0.01"; // 测试使用
			}
			try {
				Payment payment = this.paymentService.findById(Long.parseLong(payment_id));
				String mark = payment.getMark();
				if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)) {

					String orderInfo = getOrderInfo(payment.getPartner(), payment.getSellerEmail(),
							out_trade_no, url + "/alipay_notify.htm", subject, body, total_fee);
					// String orderInfo =
					// getOrderInfo(payment.getPartner(),payment.getSellerEmail(),out_trade_no,
					// url + "/alipay_notify.htm",subject, body, "0.01");
					// 对订单做RSA 签名
					String sign = sign(orderInfo, payment.getAppPrivateKey());
					try {
						// 仅需对sign 做URL编码
						sign = URLEncoder.encode(sign, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					// 完整的符合支付宝参数规范的订单信息
					String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

					return payInfo;

				} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(mark)) {
					/*
					 * params.put("appid",payment.getWxAppid());
					 * params.put("mch_id",payment.getMerchantAcctid());
					 * params.put("trade_type","NATIVE");
					 * params.put("spbill_create_ip",localIp());
					 * params.put("product_id",subject);
					 * params.put("body","订单号:"+orderNo); params.put("attach",
					 * type); params.put("out_trade_no",out_trade_no);
					 * params.put("total_fee", "1"); params.put("nonce_str",
					 * UUID.randomUUID().toString().replace("-", ""));
					 * params.put("notify_url",url + "/weixin_notify.htm");
					 * params.put("sign", Signature.generateSign(params,
					 * payment.getWxPaysignkey())); return
					 * Signature.toURL(params);
					 */
					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					// payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("APP");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					// payPackage.setTotal_fee("1");//total_fee
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());

					return content;
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}
	}

	/**
	 * 统一支付接口
	 * 
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String pay(String url, String payment_id, String type, String id, String bank) {
		boolean submit = true;
		OrderForm of = null;
		GroupOrderBO go = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();

		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		} else if (type.equals("cash")) {
			pd = this.predepositService.getObjById(CommUtil.null2Long(id));
			if (pd.getPdPayStatus() >= 2) {
				submit = false;// 预存款已经完成充值
			}
		} else if (type.equals("gold")) {
			gold = this.goldRecordDao.get(CommUtil.null2Long(id));
			if (gold.getGoldPayStatus() >= 2) {
				submit = false;// 金币已经完成充值
			}
		} else if (type.equals("integral")) {
			ig_order = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
			if (ig_order.getIgoStatus() >= 20) {
				submit = false;// 积分订单已经完成支付
			}
		} else if (type.equals("group")) {
			// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			go = groupOrderService.getObjById(CommUtil.null2Long(id));
			if (go.getOrderStatus() >= 20) { // XXX 团购订单已经处于支付状态
				submit = false;
			}
		}
		if (submit) {

			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {
				out_trade_no = of.getTradeNo();
			}
			if (type.equals("group")) {
				out_trade_no = go.getTradeNo();
			}
			if (type.equals("cash")) {
				out_trade_no = pd.getPdNo();
			}
			if (type.equals("integral")) {
				out_trade_no = ig_order.getIgoOrderSn();
			}
			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderId();
				orderNo = of.getOrderId();
			}
			if (type.equals("cash")) {
				subject = webName + "充值";
				orderNo = pd.getPdSn();
			}
			if (type.equals("gold")) {
				subject = gold.getGoldSn();
				orderNo = gold.getGoldSn();
			}
			if (type.equals("integral")) {
				subject = webName + "订单-" + ig_order.getIgoOrderSn();
				orderNo = ig_order.getIgoOrderSn();
			}
			if (type.equals("store_deposit")) {
				subject = "store_deposit";
			}
			if (type.equals("group")) {
				subject = go.getOrderId();
				orderNo = go.getOrderId();
			}
			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				double total_price = this.orderFormtools.query_order_price(CommUtil.null2String(of.getId()));
				total_fee = CommUtil.null2String(total_price);
			}
			if (type.equals("cash")) {
				total_fee = CommUtil.null2String(pd.getPdAmount());
			}
			if (type.equals("gold")) {
				total_fee = CommUtil.null2String(gold.getGoldMoney());
			}
			if (type.equals("integral")) {
				total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
			}
			if (type.equals("group")) {
				total_fee = CommUtil.null2String(go.getTotalPrice());
			}

			if (isDebug == 1) {
				total_fee = "0.01"; // 测试使用
			}

			try {
				Payment payment = this.paymentService.findById(Long.parseLong(payment_id));
				String mark = payment.getMark();
				if (PaymentConstants.PAYMENT_MARK_ALIPAY.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)) {
					Properties aconf = new Properties();
					aconf.setProperty("KEY", payment.getSafeKey());
					aconf.setProperty("partner", payment.getPartner());
					aconf.setProperty("sign_type", "MD5");
					aconf.setProperty("_input_charset", "utf-8");
					aconf.setProperty("seller_email", payment.getSellerEmail());
					aconf.setProperty("return_url", url + "/alipay_return.htm");
					AlipayFactory factory = new AlipayFactory(aconf);

					RequestBase req;

					// url="http://echovi.xicp.net:25800"; //测试

					if (StringUtils.isEmpty(bank)) {
						req = factory.newCreateDirectPayByUser(aconf)

						.setProperty("out_trade_no", out_trade_no).setProperty("subject", subject)
								.setProperty("body", body).setProperty("payment_type", "1")
								// .setProperty("total_fee", "0.01")//total_fee
								.setProperty("total_fee", total_fee)// total_fee
								.setProperty("notify_url", url + "/alipay_notify.htm");
					} else {
						req = factory.newCreateDirectPayByUserBank(aconf)

						.setProperty("out_trade_no", out_trade_no).setProperty("subject", subject)
								.setProperty("body", body).setProperty("payment_type", "1")
								// .setProperty("total_fee", "0.01")//total_fee
								.setProperty("total_fee", total_fee)
								// total_fee
								.setProperty("defaultbank", bank)
								.setProperty("notify_url", url + "/alipay_notify.htm");
					}
					log.debug("[payment] payment id=" + payment_id);
					log.debug("[payment] KEY=" + aconf.getProperty("KEY"));
					log.debug("[payment] partner=" + aconf.getProperty("partner"));
					log.debug("[payment] sign_type=" + aconf.getProperty("sign_type"));
					log.debug("[payment] _input_charset=" + aconf.getProperty("_input_charset"));
					log.debug("[payment] seller_email=" + aconf.getProperty("seller_email"));
					log.debug("[payment] return_url=" + aconf.getProperty("return_url"));
					log.debug("[payment] out_trade_no=" + aconf.getProperty("out_trade_no"));
					log.debug("[payment] body=" + aconf.getProperty("body"));
					log.debug("[payment] payment_type=" + aconf.getProperty("payment_type"));
					log.debug("[payment] total_fee=" + aconf.getProperty("total_fee"));
					log.debug("[payment] notify_url=" + aconf.getProperty("notify_url"));
					log.debug("[payment] defaultbank=" + aconf.getProperty("defaultbank"));
					log.debug("[payment] URL=" + req.build().sign().toURL());
					return (req.build().sign().toURL());

				} else if (PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(mark)) {
					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("NATIVE");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());
					Document doc = Jsoup.parse(content, "", Parser.xmlParser());
					if (doc.select("return_code").text().equals("SUCCESS")
							&& doc.select("return_msg").text().equals("OK"))
						return "/wx_qr_pay.html?code=" + doc.select("code_url").text() + "&totalFee="
								+ total_fee + "&orderNo=" + orderNo + "&type=" + type;
					else
						// XmlMapper xmlMapper = new XmlMapper();
						// PayNativeInput payNativeInput =
						// xmlMapper.readValue(content, PayNativeInput.class);

						return "";
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}

	}

	@Transactional
	public String mchAliQrPay(SellerBO seller, BigDecimal totalFee, BigDecimal originalPrice, String url,
			String phone, String serverName) throws Exception {

		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_ALIPAY_WAP);
		if (payment == null)
			throw new Exception("请设置'商家微信扫码支付'支付信息！");

		//StoreBO storeBo = storeService.getStoreBOById(seller.getStoreId());
		StoreBO storeBo = this.storeService.getStoreStatus(seller.getStoreId());
		if (storeBo == null) {
			throw new Exception("店铺信息不存在！");
		}

		ShopQrPayOrderBO order = shopQrPayOrderService.newShopQrPayOrder(seller.getUid(), totalFee,
				EmQrPayOrderPaymentType.AliPay, phone, "商户专属码【支付宝支付】");
		order.setOriginalPrice(originalPrice);
		order.setPaymentId(payment.getId());
		shopQrPayOrderService.save(order);

		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		String subject = webName + "商家店内扫描支付";

		subject += "订单号:" + order.getPayOrderNo();
		subject += storeBo.getStoreName() == null ? "" : "\n 商家:" + storeBo.getStoreName();

		try {

			Properties aconf = new Properties();
			aconf.setProperty("KEY", payment.getSafeKey());
			aconf.setProperty("partner", payment.getPartner());
			aconf.setProperty("sign_type", "MD5");
			aconf.setProperty("_input_charset", "utf-8");
			aconf.setProperty("seller_email", payment.getSellerEmail());
			aconf.setProperty("seller_id", payment.getSellerEmail());
			aconf.setProperty("return_url", url + "/alipay_return.htm");
			AlipayFactory factory = new AlipayFactory(aconf);

			RequestBase req = factory.newWapTradeCreateDirect(aconf)
					.setProperty("out_trade_no", order.getPayOrderNo()).setProperty("subject", subject)
					.setProperty("body", "mchAliQrPay").setProperty("payment_type", "1")
					.setProperty("total_fee", String.valueOf(totalFee.doubleValue()))
					.setProperty("notify_url", url + "/alipay_notify.htm");

			return (req.build().sign().toURL());

		} catch (Exception ex) {
			log.error("生成支付失败", ex);
			return "";
		}
	}

	@Transactional
	public PayH5QrCode mchWxQrPay(SellerBO seller, BigDecimal totalFee, BigDecimal originalPrice, String url,
			String openid, String phone, String serverName, Long userId) throws Exception {
		// 获取支付方式
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY);
		if (payment == null)
			throw new Exception("请设置'商家微信扫码支付'支付信息！");
		log.debug("[mchWxQrPay] payment=" + JSONObject.fromObject(payment).toString());
		StoreBO storeBo = storeService.getStoreBOById(seller.getStoreId());
		if (storeBo == null) {
			throw new Exception("店铺信息不存在！");
		}
		log.debug("[mchWxQrPay] storeBo=" + JSONObject.fromObject(storeBo).toString());
		PayH5QrCode model = null;
		if (serverName == null || serverName.trim().length() <= 0) {
			serverName = "商户专属码【微信支付】";
		}
		ShopQrPayOrderBO order = shopQrPayOrderService.newShopQrPayOrder(seller.getUid(), totalFee,
				EmQrPayOrderPaymentType.WX, phone, serverName);
		order.setPaymentId(payment.getId());
		log.debug("---------------userId=" + userId + "-------------------");
		order.setOriginalPrice(originalPrice);
		order.setUserId(userId);
		shopQrPayOrderService.save(order);

		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		String subject = webName + "商家店内扫描支付";
		log.debug("[mchWxQrPay] config=" + JSONObject.fromObject(config).toString());
		// 调用微信统一下单接口
		PayPackage payPackage = new PayPackage();
		payPackage.setAppid(payment.getWxAppid());
		payPackage.setMch_id(payment.getTenpayPartner());
		payPackage.setDevice_info("WEB");
		payPackage.setTrade_type("JSAPI");
		payPackage.setSpbill_create_ip(localIp());
		payPackage.setProduct_id(subject);
		String body = "订单号:" + order.getPayOrderNo();
		body += storeBo.getStoreName() == null ? "" : "\n 商家:" + storeBo.getStoreName();

		payPackage.setBody(body); // + "-" + seller.getCompanyName());
		payPackage.setAttach("mchWxQrPay");
		payPackage.setOut_trade_no(order.getPayOrderNo());
		payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(totalFee, 100)).longValue())));// total_fee
		payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		payPackage.setNotify_url(url + "/weixin_notify.htm");
		payPackage.setOpenid(openid); // trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
		log.debug("[mchWxQrPay] payPackage=" + JSONObject.fromObject(payPackage).toString());
		String content = PayUtils.generatePayNativeReplyXML(payPackage, payment.getTenpayPartner(),
				payment.getWxPaysignkey());

		log.debug("[mchWxQrPay] content->" + content);
		Document doc = Jsoup.parse(content, "", Parser.xmlParser());
		if (doc.select("return_code").text().equals("SUCCESS")
				&& doc.select("return_msg").text().equals("OK")) {
			order.setPrepayId(doc.select("prepay_id").text());
			order.setPaymentId(payment.getId());
			shopQrPayOrderService.save(order);
			model = new PayH5QrCode(payment.getWxAppid(), payment.getWxPaysignkey(), order.getPrepayId());

		} else {
			log.error("商家店内扫码微信下单失败:" + doc.toString());
			throw new Exception("微信下单失败");
		}

		return model;
	}

	/**
	 * 微信扫码支付，生成预支付订单（商城支付） 由于微信扫商户二维码支付和商城支付不太一样，新添加
	 * 
	 * @param seller
	 * @param totalFee
	 * @param url
	 * @param openid
	 * @param phone
	 * @param serverName
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@Transactional
	public PayH5QrCode mchWxQrPayOrder(String url, BigDecimal money, String orderId, String tradeNo,
			String openid) throws ServiceException {
		// 获取支付方式
		Payment payment = this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY);
		if (payment == null)
			throw new ServiceException("请设置'商家微信扫码支付'支付信息！");
		log.debug("[mchWxQrPay] payment=" + JSONObject.fromObject(payment).toString());
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		String subject = webName + "商家店内扫描支付";
		log.debug("[mchWxQrPay] config=" + JSONObject.fromObject(config).toString());
		// 调用微信统一下单接口
		PayPackage payPackage = new PayPackage();
		payPackage.setAppid(payment.getWxAppid());
		payPackage.setMch_id(payment.getTenpayPartner());
		payPackage.setDevice_info("WEB");
		payPackage.setTrade_type("JSAPI");
		payPackage.setSpbill_create_ip(localIp());
		payPackage.setProduct_id(subject);
		String body = "订单号:" + orderId;
		body += "\n 云尚大健康-产品";

		payPackage.setBody(body); // + "-" + seller.getCompanyName());
		payPackage.setAttach("goods");
		payPackage.setOut_trade_no(tradeNo);
		payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(money, 100)).longValue())));// total_fee
		payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		payPackage.setNotify_url(url + "/weixin_notify.htm");
		payPackage.setOpenid(openid); // trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识
		log.debug("[mchWxQrPay] payPackage=" + JSONObject.fromObject(payPackage).toString());
		String content = PayUtils.generatePayNativeReplyXML(payPackage, payment.getTenpayPartner(),
				payment.getWxPaysignkey());

		log.debug("[mchWxQrPay] content->" + content);

		PayH5QrCode model = null;

		Document doc = Jsoup.parse(content, "", Parser.xmlParser());
		if (doc.select("return_code").text().equals("SUCCESS")
				&& doc.select("return_msg").text().equals("OK")) {
			String prepayId = doc.select("prepay_id").text();
			model = new PayH5QrCode(payment.getWxAppid(), payment.getWxPaysignkey(), prepayId);

		} else {
			log.error("商家店内扫码微信下单失败:" + doc.toString());
			throw new ServiceException("微信下单失败");
		}

		return model;
	}

	@Transactional
	public ShopQrPayOrderBO mchJgQrPay(Long userId, SellerBO seller, BigDecimal totalFee,
			BigDecimal originalPrice, String url, String phone, String serverName, String payPwd)
			throws ServiceException {

		// 判断商家是否存在
		//StoreBO storeBo = storeService.getStoreBOById(seller.getStoreId());
		StoreBO storeBo =	this.storeService.getStoreStatus(seller.getStoreId());
		if (storeBo == null) {
			throw new ServiceException("店铺信息不存在！");
		}

		// 保存订单
		ShopQrPayOrderBO order = shopQrPayOrderService.newShopQrPayOrder(seller.getUid(), totalFee,
				EmQrPayOrderPaymentType.JGPay, phone, serverName);
		order.setPaymentId(0L);
		order.setUserId(userId);
		order.setOriginalPrice(originalPrice);
		shopQrPayOrderService.save(order);

		// 验证支付金额&支付
		String info = String.format("店铺扫描支付订单:%s,扣减云豆", order.getPayOrderNo());
		boolean moneyEnough = userMoneyService.consumptionMoney(userId, CommUtil.null2Double(totalFee),
				payPwd, info);

		if (!moneyEnough) {
			throw new ServiceException("账号余额不足！");
		}

		// 完成订单&分润
		shopQrPayOrderService.complateOrderByPayOrderNo(order.getPayOrderNo(), "");
		
		//赠送积分
		try {
			//this.groupOrderService.o2oShopSendIntegral(userId, CommUtil.null2Double(totalFee));
		} catch (Exception e) {
			log.error("[O2O shop sendSendIntegral error]{}",e);
		}

		return order;
	}

	@SuppressWarnings("deprecation")
	public Map<String, String> GetQrPath(String urlAddress, Long sellerId, boolean encode) {

		urlAddress += "/";
		Map<String, String> map = new HashMap<String, String>();

		if (encode) {
			String wxQrPath = urlAddress + URLEncoder.encode("q/wx_s.htm?s=" + sellerId);

			String aliQrPath = urlAddress
					+ URLEncoder.encode(String.format("q/pay.htm?s=%s&t=alipay", sellerId));

			String jgQrPath = urlAddress
					+ URLEncoder.encode(String.format("q/pay.htm?s=%s&t=jgpay", sellerId));

			String qrHomePath = urlAddress
					+ URLEncoder.encode(String.format("merchant_home.htm?s=%s", sellerId));

			map.put("wxQrPath", (wxQrPath));
			map.put("aliQrPath", (aliQrPath));
			map.put("jgQrPath", (jgQrPath));
			map.put("qrHomePath", (qrHomePath));
		} else {
			String wxQrPath = urlAddress + ("q/wx_s.htm?s=" + sellerId);

			String aliQrPath = urlAddress + (String.format("q/pay.htm?s=%s&t=alipay", sellerId));

			String jgQrPath = urlAddress + (String.format("q/pay.htm?s=%s&t=jgpay", sellerId));

			String qrHomePath = urlAddress + (String.format("merchant_home.htm?s=%s", sellerId));

			map.put("wxQrPath", (wxQrPath));
			map.put("aliQrPath", (aliQrPath));
			map.put("jgQrPath", (jgQrPath));
			map.put("qrHomePath", (qrHomePath));
		}
		return map;
	}

	// @Deprecated
	// public String genericAlipayCreateDirectPay(String url,String
	// payment_id,String type,String id,String bank){
	// boolean submit = true;
	// OrderForm of = null;
	// Predeposit pd = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// try{
	// AlipayFactory factory = AlipayFactory.getDefaultInstance();
	// Properties conf = factory.getConf();
	// PaymentBO payment = this.paymentService.findByMark("alipay");
	// if(StringUtils.isNotBlank(payment.getSafeKey())
	// && StringUtils.isNotBlank(payment.getPartner())){
	//
	// conf.setProperty("return_url",url + "/alipay_return.htm");
	// }
	//
	// if (type.equals("goods")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// pd = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (pd.getPdPayStatus() >= 2) {
	// submit = false;// 预存款已经完成充值
	// }
	// }
	// /*if (type.equals("gold")) {
	// gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
	// if (gold.getGoldPayStatus() >= 2) {
	// submit = false;// 金币已经完成充值
	// }
	// }*/
	// if (type.equals("integral")) {
	// ig_order = this.integralGoodsOrderService.getObjById(CommUtil
	// .null2Long(id));
	// if (ig_order.getIgoStatus() >= 20) {
	// submit = false;// 积分订单已经完成支付
	// }
	// }
	// if (type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrderStatus() >= 20) {// 团购订单已经处于支付状态
	// submit = false;
	// }
	// }
	//
	// if (submit) {
	//
	// String out_trade_no = "";
	// String trade_no = CommUtil.formatTime("yyyyMMddHHmmss",
	// new Date());
	// if (type.equals("goods") || type.equals("group")) {
	// of.setTradeNo("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// out_trade_no = "order-" + trade_no + "-"
	// + of.getId().toString();
	// }
	// }
	// if (type.equals("cash")) {
	// pd.setPdNo("pd-" + trade_no + "-" + pd.getId().toString());
	// boolean flag = this.predepositService.update(pd);
	// if (flag) {
	// out_trade_no = "pd-" + trade_no + "-"
	// + pd.getId().toString();
	// }
	// }
	// // 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
	// String subject = "";//
	// if (type.equals("goods")) {
	// subject = of.getOrderId();
	// }
	// if (type.equals("cash")) {
	// subject = pd.getPdSn();
	// }
	// if (type.equals("gold")) {
	// subject = gold.getGoldSn();
	// }
	// if (type.equals("integral")) {
	// subject = ig_order.getIgoOrderSn();
	// }
	// if (type.equals("store_deposit")) {
	// subject = "store_deposit";
	// }
	// if (type.equals("group")) {
	// subject = of.getOrderId();
	// }
	// // 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
	// String body = type;
	// RequestBase req;
	// if(StringUtils.isEmpty(bank)){
	// req = factory.newCreateDirectPayByUser()
	//
	// .setProperty("out_trade_no", out_trade_no)
	// .setProperty("subject", subject)
	// .setProperty("body", body)
	// .setProperty("payment_type", "1")
	// .setProperty("total_fee", "0.01")
	// .setProperty("notify_url", url + "/alipay_notify.htm");
	// }else{
	// req = factory.newCreateDirectPayByUserBank()
	//
	// .setProperty("out_trade_no", out_trade_no)
	// .setProperty("subject", "直接到帐支付测试")
	// .setProperty("payment_type", "1")
	// .setProperty("total_fee", "0.01")
	// .setProperty("defaultbank", bank)
	// .setProperty("notify_url", url + "/alipay_notify.htm");
	// }
	// return(req.build().sign().toURL());
	// }else {
	// return "该订单已经完成支付！";
	// }
	// }
	// catch (Exception ex)
	// {
	// ex.printStackTrace();
	// return(null);
	// }
	//
	// }

	private String appid = "wxd861f9b2766a49a3"; // 微信后台获取
	private String mch_id = "1236624702"; // 微信支付申请人邮箱获取
	private String partner_key; // 微信支付申请人邮箱获取
	private String pay_sign_key = "6F5C40FA65F8D4F886E54DCD9544F6C7"; // 微信支付申请人邮箱获取

	/**
	 * 获取本机Ip
	 * 
	 * 通过 获取系统所有的networkInterface网络接口 然后遍历 每个网络下的InterfaceAddress组。 获得符合
	 * <code>InetAddress instanceof Inet4Address</code> 条件的一个IpV4地址
	 * 
	 * @return
	 */
	private String localIp() {
		String ip = null;
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
				List<InterfaceAddress> InterfaceAddress = netInterface.getInterfaceAddresses();
				for (InterfaceAddress add : InterfaceAddress) {
					InetAddress Ip = add.getAddress();
					if (Ip != null && Ip instanceof Inet4Address) {
						ip = Ip.getHostAddress();
					}
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
		}
		return ip;
	}

	@Deprecated
	public String genericWxqrpay(String url, String payment_id, String type, String id) {

		try {
			PayPackage payPackage = new PayPackage();
			payPackage.setAppid(appid);
			payPackage.setMch_id(mch_id);
			payPackage.setDevice_info("WEB");
			payPackage.setTrade_type("NATIVE");
			payPackage.setSpbill_create_ip(localIp());
			payPackage.setProduct_id("123456789");
			payPackage.setBody("商品名称");
			payPackage.setOut_trade_no("test_trade_123456789");
			payPackage.setTotal_fee("1");
			payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
			payPackage.setNotify_url(url + "/wap/weixin_return.htm");
			String content = PayUtils.generatePayNativeReplyXML(payPackage, "", "");
			XmlMapper xmlMapper = new XmlMapper();
			PayNativeInput payNativeInput = xmlMapper.readValue(content, PayNativeInput.class);
			return "/wx_qr_pay.html?code=" + payNativeInput.getCode_url();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * 根据支付类型生成支付宝在线表单 0为及时支付、1为担保支付、2为标准双接口,支持分润处理,由于支付宝限制，分润操作只支持即时到帐
	 * 
	 * @param url
	 *            系统url
	 * @param payment_id
	 *            支付方式id
	 * @param type
	 *            支付类型，分为goods支付商品，cash在线充值
	 * @param order_id
	 *            订单编号，根据type区分类型
	 * @return
	 */
	@Deprecated
	public String genericAlipay(String url, String payment_id, String type, String id) {
		boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
		String result = "";
		OrderForm of = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		}
		if (type.equals("cash")) {
			pd = this.predepositService.getObjById(CommUtil.null2Long(id));
			if (pd.getPdPayStatus() >= 2) {
				submit = false;// 预存款已经完成充值
			}
		}
		/*
		 * if (type.equals("gold")) { gold =
		 * this.goldRecordService.getObjById(CommUtil.null2Long(id)); if
		 * (gold.getGold_pay_status() >= 2) { submit = false;// 金币已经完成充值 } } if
		 * (type.equals("integral")) { ig_order =
		 * this.integralGoodsOrderService.getObjById(CommUtil .null2Long(id));
		 * if (ig_order.getIgo_status() >= 20) { submit = false;// 积分订单已经完成支付 }
		 * } if (type.equals("group")) { of =
		 * this.orderFormService.getObjById(CommUtil.null2Long(id)); if
		 * (of.getOrder_status() >= 20) {// 团购订单已经处于支付状态 submit = false; } }
		 */
		if (submit) {
			Payment payment = this.paymentService.getObjById(CommUtil.null2Long(payment_id));
			if (payment == null)
				payment = new Payment();
			int interfaceType = payment.getInterfaceType();
			AlipayConfig config = new AlipayConfig();
			Map params = new HashMap();
			params.put("mark", "alipay");
			PaymentBO shop_payment = this.paymentService.findByMark("alipay");
			List<Payment> payments = this.paymentService.findInstalledAll();/*
																			 * .query(
																			 * "select obj from Payment obj where obj.mark=:mark"
																			 * , params, -1, -1);
																			 */
			// Payment shop_payment = new Payment();
			/*
			 * if (payments.size() > 0) { shop_payment = payments.get(0); }
			 */
			if (!CommUtil.null2String(payment.getSafeKey()).equals("")
					&& !CommUtil.null2String(payment.getPartner()).equals("")) {
				config.setKey(payment.getSafeKey());
				config.setPartner(payment.getPartner());
			} else {
				config.setKey(shop_payment.getSafeKey());
				config.setPartner(shop_payment.getPartner());
			}
			config.setSeller_email(payment.getSellerEmail());
			config.setNotify_url(url + "/alipay_notify.htm");
			config.setReturn_url(url + "/aplipay_return.htm");
			SysConfig sys_config = this.configService.getSysConfig();
			if (interfaceType == 0) {// 及时到账支付
				String out_trade_no = "";
				String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
				if (type.equals("goods") || type.equals("group")) {
					of.setTradeNo("order-" + trade_no + "-" + of.getId().toString());
					boolean flag = this.orderFormService.update(of);// 更新订单流水号
					if (flag) {
						out_trade_no = "order-" + trade_no + "-" + of.getId().toString();
					}
				}

				if (type.equals("cash")) {
					pd.setPdNo("pd-" + trade_no + "-" + pd.getId().toString());
					boolean flag = this.predepositService.update(pd);
					if (flag) {
						out_trade_no = "pd-" + trade_no + "-" + pd.getId().toString();
					}
				}
				/*
				 * if (type.equals("gold")) { gold.setGoldSn("gold-" + trade_no
				 * + "-" + gold.getId().toString()); boolean flag =
				 * this.goldRecordService.update(gold); if (flag) { out_trade_no
				 * = "gold-" + trade_no + "-" + gold.getId().toString(); } } if
				 * (type.equals("integral")) { ig_order.setIgo_order_sn("igo-" +
				 * trade_no + "-" + ig_order.getId().toString()); boolean flag =
				 * this.integralGoodsOrderService .update(ig_order); if (flag) {
				 * out_trade_no = "igo-" + trade_no + "-" +
				 * ig_order.getId().toString(); } }
				 */
				// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
				String subject = "";//
				if (type.equals("goods")) {
					subject = of.getOrderId();
				}
				if (type.equals("cash")) {
					subject = pd.getPdSn();
				}
				if (type.equals("gold")) {
					subject = gold.getGoldSn();
				}
				if (type.equals("integral")) {
					subject = ig_order.getIgoOrderSn();
				}
				if (type.equals("store_deposit")) {
					subject = "store_deposit";
				}
				if (type.equals("group")) {
					subject = of.getOrderId();
				}
				// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
				String body = type;
				// 订单总金额，显示在支付宝收银台里的“应付总额”里
				String total_fee = "";//
				if (type.equals("goods")) {
					double total_price = 0.1;/*
												 * this.orderFormtools.
												 * .query_order_price(CommUtil.
												 * null2String(of.getId()));
												 */
					total_fee = CommUtil.null2String(total_price);
				}
				if (type.equals("cash")) {
					total_fee = CommUtil.null2String(pd.getPdAmount());
				}
				if (type.equals("gold")) {
					total_fee = CommUtil.null2String(gold.getGoldMoney());
				}
				if (type.equals("integral")) {
					total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
				}
				if (type.equals("group")) {
					total_fee = CommUtil.null2String(of.getTotalPrice());
				}
				// 扩展功能参数——默认支付方式//
				// 默认支付方式，取值见“即时到帐接口”技术文档中的请求参数列表
				String paymethod = "";
				// 默认网银代号，代号列表见“即时到帐接口”技术文档“附录”→“银行列表”
				String defaultbank = "";
				// 扩展功能参数——防钓鱼//
				// 防钓鱼时间戳
				String anti_phishing_key = "";
				// 获取客户端的IP地址，建议：编写获取客户端IP地址的程序
				String exter_invoke_ip = "";
				// 注意：
				// 1.请慎重选择是否开启防钓鱼功能
				// 2.exter_invoke_ip、anti_phishing_key一旦被设置过，那么它们就会成为必填参数
				// 3.开启防钓鱼功能后，服务器、本机电脑必须支持远程XML解析，请配置好该环境。
				// 4.建议使用POST方式请求数据
				// 示例：
				// anti_phishing_key = AlipayService.query_timestamp();
				// //获取防钓鱼时间戳函数
				// exter_invoke_ip = "202.1.1.1";

				// 扩展功能参数——其他///

				// 自定义参数，可存放任何内容（除=、&等特殊字符外），不会显示在页面上
				String extra_common_param = type;
				// 默认买家支付宝账号
				String buyer_email = "";
				// 商品展示地址，要用http:// 格式的完整路径，不允许加?id=123这类自定义参数
				String show_url = "";
				// 扩展功能参数——分润(若要使用，请按照注释要求的格式赋值)//s
				// 提成类型，该值为固定值：10，不需要修改
				String royalty_type = "10";
				// 减去支付宝手续费
				// 提成信息集
				String royalty_parameters = "";
				// 注意：
				// 与需要结合商户网站自身情况动态获取每笔交易的各分润收款账号、各分润金额、各分润说明。最多只能设置10条
				// 各分润金额的总和须小于等于total_fee
				// 提成信息集格式为：收款方Email_1^金额1^备注1|收款方Email_2^金额2^备注2
				// 把请求参数打包成数组
				Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("payment_type", "1");
				sParaTemp.put("out_trade_no", out_trade_no);
				sParaTemp.put("subject", subject);
				sParaTemp.put("body", body);
				sParaTemp.put("total_fee", total_fee);
				sParaTemp.put("show_url", show_url);
				sParaTemp.put("paymethod", paymethod);
				sParaTemp.put("defaultbank", defaultbank);
				sParaTemp.put("anti_phishing_key", anti_phishing_key);
				sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
				sParaTemp.put("extra_common_param", extra_common_param);
				sParaTemp.put("buyer_email", buyer_email);
				// 构造函数，生成请求URL
				result = AlipayService.create_direct_pay_by_user(config, sParaTemp);
			}
			if (interfaceType == 1) {// 担保支付接口
				// 请与贵网站订单系统中的唯一订单号匹配
				String out_trade_no = "";
				String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
				if (type.equals("goods")) {
					of.setTradeNo("order-" + trade_no + "-" + of.getId().toString());
					boolean flag = this.orderFormService.update(of);// 更新订单流水号
					if (flag) {
						out_trade_no = "order-" + trade_no + "-" + of.getId().toString();
					}
				}

				if (type.equals("cash")) {
					pd.setPdNo("pd-" + trade_no + "-" + pd.getId().toString());
					boolean flag = this.predepositService.update(pd);
					if (flag) {
						out_trade_no = "pd-" + trade_no + "-" + pd.getId().toString();
					}
				}
				/*
				 * if (type.equals("gold")) { gold.setGoldSn("gold-" + trade_no
				 * + "-" + gold.getId().toString()); boolean flag =
				 * this.goldRecordService.update(gold); if (flag) { out_trade_no
				 * = "gold-" + trade_no + "-" + gold.getId().toString(); } } if
				 * (type.equals("integral")) { ig_order.setIgo_order_sn("igo-" +
				 * trade_no + "-" + ig_order.getId().toString()); boolean flag =
				 * this.integralGoodsOrderService .update(ig_order); if (flag) {
				 * out_trade_no = "igo-" + trade_no + "-" +
				 * ig_order.getId().toString(); } }
				 * 
				 * if (type.equals("group")) { of.setTrade_no("order-" +
				 * trade_no + "-" + of.getId().toString()); boolean flag =
				 * this.orderFormService.update(of);// 更新订单流水号 if (flag) {
				 * out_trade_no = "order-" + trade_no + "-" +
				 * of.getId().toString(); } }
				 */
				// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
				String subject = "";//
				if (type.equals("goods")) {
					subject = of.getOrderId();
				}
				if (type.equals("cash")) {
					subject = pd.getPdSn();
				}
				if (type.equals("gold")) {
					subject = gold.getGoldSn();
				}
				if (type.equals("integral")) {
					subject = ig_order.getIgoOrderSn();
				}
				if (type.equals("store_deposit")) {
					subject = "store_deposit";
				}
				if (type.equals("group")) {
					subject = of.getOrderId();
				}
				// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
				String body = type;
				// 订单总金额，显示在支付宝收银台里的“应付总额”里
				String total_fee = "";//
				if (type.equals("goods")) {
					total_fee = CommUtil.null2String(of.getTotalPrice());
				}
				if (type.equals("cash")) {
					total_fee = CommUtil.null2String(pd.getPdAmount());
				}
				if (type.equals("gold")) {
					total_fee = CommUtil.null2String(gold.getGoldMoney());
				}
				if (type.equals("integral")) {
					total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
				}
				if (type.equals("group")) {
					total_fee = CommUtil.null2String(of.getTotalPrice());
				}
				// 订单总金额，显示在支付宝收银台里的“应付总额”里
				String price = String.valueOf(total_fee);
				// 物流费用，即运费。
				String logistics_fee = "0.00";
				// 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
				String logistics_type = "EXPRESS";
				// 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
				String logistics_payment = "SELLER_PAY";
				// 商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。
				String quantity = "1";
				// 扩展参数//
				// 自定义参数，可存放任何内容（除=、&等特殊字符外），不会显示在页面上
				String extra_common_param = "";
				// 买家收货信息（推荐作为必填）
				// 该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
				// 若要使用该功能，请至少保证receive_name、receive_address有值
				String receive_name = "";
				String receive_address = "";
				String receive_zip = "";
				String receive_phone = ""; // 收货人电话号码
				String receive_mobile = "";
				// 网站商品的展示地址，不允许加?id=123这类自定义参数
				String show_url = "";
				// 把请求参数打包成数组
				Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("payment_type", "1");
				sParaTemp.put("show_url", show_url);
				sParaTemp.put("out_trade_no", out_trade_no);
				sParaTemp.put("subject", subject);
				sParaTemp.put("body", body);
				sParaTemp.put("price", price);
				sParaTemp.put("logistics_fee", logistics_fee);
				sParaTemp.put("logistics_type", logistics_type);
				sParaTemp.put("logistics_payment", logistics_payment);
				sParaTemp.put("quantity", quantity);
				sParaTemp.put("extra_common_param", extra_common_param);
				sParaTemp.put("receive_name", receive_name);
				sParaTemp.put("receive_address", receive_address);
				sParaTemp.put("receive_zip", receive_zip);
				sParaTemp.put("receive_phone", receive_phone);
				sParaTemp.put("receive_mobile", receive_mobile);

				// 构造函数，生成请求URL
				result = AlipayService.create_partner_trade_by_buyer(config, sParaTemp);
			}
			if (interfaceType == 2) {// 标准双接口
				// 请与贵网站订单系统中的唯一订单号匹配
				String out_trade_no = "";
				String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
				if (type.equals("goods")) {
					of.setTradeNo("order-" + trade_no + "-" + of.getId().toString());
					boolean flag = this.orderFormService.update(of);// 更新订单流水号
					if (flag) {
						out_trade_no = "order-" + trade_no + "-" + of.getId().toString();
					}
				}

				if (type.equals("cash")) {
					pd.setPdNo("pd-" + trade_no + "-" + pd.getId().toString());
					boolean flag = this.predepositService.update(pd);
					if (flag) {
						out_trade_no = "pd-" + trade_no + "-" + pd.getId().toString();
					}
				}
				/*
				 * if (type.equals("gold")) { gold.setGoldSn("gold-" + trade_no
				 * + "-" + gold.getId().toString()); boolean flag =
				 * this.goldRecordService.update(gold); if (flag) { out_trade_no
				 * = "gold-" + trade_no + "-" + gold.getId().toString(); } } if
				 * (type.equals("integral")) { ig_order.setIgo_order_sn("igo-" +
				 * trade_no + "-" + ig_order.getId().toString()); boolean flag =
				 * this.integralGoodsOrderService .update(ig_order); if (flag) {
				 * out_trade_no = "igo-" + trade_no + "-" +
				 * ig_order.getId().toString(); } } if (type.equals("group")) {
				 * of.setTrade_no("order-" + trade_no + "-" +
				 * of.getId().toString()); boolean flag =
				 * this.orderFormService.update(of);// 更新订单流水号 if (flag) {
				 * out_trade_no = "order-" + trade_no + "-" +
				 * of.getId().toString(); } }
				 */
				// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
				String subject = "";//
				if (type.equals("goods")) {
					subject = of.getOrderId();
				}
				if (type.equals("cash")) {
					subject = pd.getPdSn();
				}
				if (type.equals("gold")) {
					subject = gold.getGoldSn();
				}
				if (type.equals("integral")) {
					subject = ig_order.getIgoOrderSn();
				}
				if (type.equals("store_deposit")) {
					subject = "store_deposit";
				}
				if (type.equals("group")) {
					subject = of.getOrderId();
				}
				// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
				String body = type;
				// 订单总金额，显示在支付宝收银台里的“应付总额”里
				String total_fee = "";//
				if (type.equals("goods")) {
					total_fee = CommUtil.null2String(of.getTotalPrice());
				}
				if (type.equals("cash")) {
					total_fee = CommUtil.null2String(pd.getPdAmount());
				}
				if (type.equals("gold")) {
					total_fee = CommUtil.null2String(gold.getGoldMoney());
				}
				if (type.equals("integral")) {
					total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
				}
				if (type.equals("group")) {
					total_fee = CommUtil.null2String(of.getTotalPrice());
				}
				// 订单总金额，显示在支付宝收银台里的“应付总额”里
				String price = String.valueOf(total_fee);

				// 物流费用，即运费。
				String logistics_fee = "0.00";
				// 物流类型，三个值可选：EXPRESS（快递）、POST（平邮）、EMS（EMS）
				String logistics_type = "EXPRESS";
				// 物流支付方式，两个值可选：SELLER_PAY（卖家承担运费）、BUYER_PAY（买家承担运费）
				String logistics_payment = "SELLER_PAY";

				// 商品数量，建议默认为1，不改变值，把一次交易看成是一次下订单而非购买一件商品。
				String quantity = "1";
				// 买家收货信息（推荐作为必填）
				String extra_common_param = "";
				// 该功能作用在于买家已经在商户网站的下单流程中填过一次收货信息，而不需要买家在支付宝的付款流程中再次填写收货信息。
				// 若要使用该功能，请至少保证receive_name、receive_address有值
				String receive_name = "";
				String receive_address = "";
				String receive_zip = "";
				String receive_phone = ""; // 收货人电话号码，如：0571-81234567
				String receive_mobile = "";
				// 网站商品的展示地址，不允许加?id=123这类自定义参数
				String show_url = "";
				// 把请求参数打包成数组
				Map<String, String> sParaTemp = new HashMap<String, String>();
				sParaTemp.put("payment_type", "1");
				sParaTemp.put("show_url", show_url);
				sParaTemp.put("out_trade_no", out_trade_no);
				sParaTemp.put("subject", subject);
				sParaTemp.put("body", body);
				sParaTemp.put("price", price);
				sParaTemp.put("logistics_fee", logistics_fee);
				sParaTemp.put("logistics_type", logistics_type);
				sParaTemp.put("logistics_payment", logistics_payment);
				sParaTemp.put("quantity", quantity);
				sParaTemp.put("extra_common_param", extra_common_param);
				sParaTemp.put("receive_name", receive_name);
				sParaTemp.put("receive_address", receive_address);
				sParaTemp.put("receive_zip", receive_zip);
				sParaTemp.put("receive_phone", receive_phone);
				sParaTemp.put("receive_mobile", receive_mobile);
				// 构造函数，生成请求URL
				result = AlipayService.trade_create_by_buyer(config, sParaTemp);
			}
		} else {
			result = "该订单已经完成支付！";
		}

		return result;
	}

	// /**
	// * 生成快钱在线表单
	// *
	// * @param url
	// * 系统url
	// * @param payment_id
	// * 支付方式id
	// * @param type
	// * 支付类型，分为goods支付商品，cash在线充值
	// * @param order_id
	// * 订单编号，根据type区分类型
	// */
	// public String generic99Bill(String url, String payment_id, String type,
	// String id) throws UnsupportedEncodingException {
	// boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
	// String result = "";
	// OrderForm of = null;
	// Predeposit pd = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (type.equals("goods")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// pd = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (pd.getPd_pay_status() >= 2) {
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
	// if (type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 团购订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (submit) {
	// Payment payment = this.paymentService.getObjById(CommUtil
	// .null2Long(payment_id));
	// if (payment == null)
	// payment = new Payment();
	// BillConfig config = new BillConfig(payment.getMerchantAcctId(),
	// payment.getRmbKey(), payment.getPid());
	// // 人民币网关账户号
	// // /请登录快钱系统获取用户编号，用户编号后加01即为人民币网关账户号。
	// String merchantAcctId = config.getMerchantAcctId();
	// String key = config.getKey();
	// String inputCharset = "1";// 字符编码 1为UTF-8 2为GBK 3为GB2312
	// String bgUrl = url + "/bill_notify_return.htm";// 服务器接受支付结果的异步后台地址
	// String pageUrl = url + "/bill_return.htm";// 服务器接受支付结果的同步后台地址
	// String version = "v2.0";// 网关版本
	// String language = "1";// 网关页面显示语言种类,1为中文
	// String signType = "1";// 签名类型,1代表MD5加密签名方式,快钱3.0后该值推荐为4，但是为1 可以使用
	// // 支付人姓名
	// // /可为中文或英文字符
	// String payerName = SecurityUserHolder.getCurrentUser()
	// .getUserName();
	// // 支付人联系方式类型.固定选择值
	// // /只能选择1
	// // /1代表Email
	// String payerContactType = "1";
	// // 支付人联系方式
	// // /只能选择Email或手机号
	// String payerContact = "";
	// // 商户订单号
	// // /由字母、数字、或[-][_]组成
	// String orderId = "";
	// String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
	// if (type.equals("goods")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// orderId = "order-" + trade_no + "-" + of.getId().toString();
	// }
	// }
	//
	// if (type.equals("cash")) {
	// pd.setPd_no("pd-" + trade_no + "-" + pd.getId().toString());
	// boolean flag = this.predepositService.update(pd);
	// if (flag) {
	// orderId = "pd-" + trade_no + "-" + pd.getId().toString();
	// }
	// }
	// if (type.equals("gold")) {
	// gold.setGold_sn("gold-" + trade_no + "-"
	// + gold.getId().toString());
	// boolean flag = this.goldRecordService.update(gold);
	// if (flag) {
	// orderId = "gold-" + trade_no + "-"
	// + gold.getId().toString();
	// }
	// }
	// if (type.equals("integral")) {
	// ig_order.setIgo_order_sn("igo-" + trade_no + "-"
	// + ig_order.getId().toString());
	// boolean flag = this.integralGoodsOrderService.update(ig_order);
	// if (flag) {
	// orderId = "igo-" + trade_no + "-"
	// + ig_order.getId().toString();
	// }
	// }
	// if (type.equals("group")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// orderId = "order-" + trade_no + "-" + of.getId().toString();
	// }
	// }
	// // 订单金额
	// // /以分为单位，必须是整型数字
	// // /比方2，代表0.02元
	// String orderAmount = "";
	// if (type.equals("goods")) {
	// double total_price = this.orderFormtools
	// .query_order_price(CommUtil.null2String(of.getId()));
	// orderAmount = String.valueOf((int) Math.floor(CommUtil
	// .null2Double(total_price) * 100));
	// }
	// if (type.equals("cash")) {
	// orderAmount = String.valueOf((int) Math.floor(CommUtil
	// .null2Double(pd.getPd_amount()) * 100));
	// }
	// if (type.equals("gold")) {
	// orderAmount = String.valueOf((int) Math.floor(CommUtil
	// .null2Double(gold.getGold_money()) * 100));
	// }
	// if (type.equals("integral")) {
	// orderAmount = String.valueOf((int) Math.floor(CommUtil
	// .null2Double(ig_order.getIgo_trans_fee()) * 100));
	// }
	// if (type.equals("group")) {
	// orderAmount = String.valueOf((int) Math.floor(CommUtil
	// .null2Double(of.getTotalPrice()) * 100));
	// }
	// // 订单提交时间
	// // /14位数字。年[4位]月[2位]日[2位]时[2位]分[2位]秒[2位]
	// // /如；20080101010101
	// String orderTime = new java.text.SimpleDateFormat("yyyyMMddHHmmss")
	// .format(new java.util.Date());
	// // 商品名称
	// // /可为中文或英文字符
	// String productName = "";
	// if (type.equals("goods")) {
	// productName = of.getOrder_id();
	// }
	// if (type.equals("cash")) {
	// productName = pd.getPd_sn();
	// }
	// if (type.equals("gold")) {
	// productName = gold.getGold_sn();
	// }
	// if (type.equals("integral")) {
	// productName = ig_order.getIgo_order_sn();
	// }
	// if (type.equals("store_deposit")) {
	// productName = "store_deposit";
	// }
	// if (type.equals("group")) {
	// productName = of.getOrder_id();
	// }
	// // 商品数量
	// // /可为空，非空时必须为数字
	// String productNum = "1";
	//
	// // 商品代码
	// // /可为字符或者数字
	// String productId = "";
	//
	// // 商品描述
	// String productDesc = "";
	//
	// // 扩展字段1
	// // /在支付结束后原样返回给商户
	// String ext1 = "";
	// if (type.equals("goods")) {
	// ext1 = of.getId().toString();
	// }
	// if (type.equals("cash")) {
	// ext1 = pd.getId().toString();
	// }
	// if (type.equals("gold")) {
	// ext1 = gold.getId().toString();
	// }
	// if (type.equals("integral")) {
	// ext1 = ig_order.getId().toString();
	// }
	// if (type.equals("group")) {
	// ext1 = of.getId().toString();
	// }
	// // 扩展字段2
	// // /在支付结束后原样返回给商户
	// String ext2 = type;
	//
	// // 支付方式.固定选择值
	// // /只能选择00、10、11、12、13、14
	// //
	// /00：组合支付（网关支付页面显示快钱支持的各种支付方式，推荐使用）10：银行卡支付（网关支付页面只显示银行卡支付）.11：电话银行支付（网关支付页面只显示电话支付）.12：快钱账户支付（网关支付页面只显示快钱账户支付）.13：线下支付（网关支付页面只显示线下支付方式）
	// String payType = "00";
	//
	// // 同一订单禁止重复提交标志
	// // /固定选择值： 1、0
	// //
	// /1代表同一订单号只允许提交1次；0表示同一订单号在没有支付成功的前提下可重复提交多次。默认为0建议实物购物车结算类商户采用0；虚拟产品类商户采用1
	// String redoFlag = "0";
	//
	// // 快钱的合作伙伴的账户号
	// // /如未和快钱签订代理合作协议，不需要填写本参数
	// String pid = "";
	// if (config.getPid() != null)
	// pid = config.getPid();
	// // 生成加密签名串
	// // /请务必按照如下顺序和规则组成加密串！
	// String signMsgVal = "";
	// signMsgVal = BillCore.appendParam(signMsgVal, "inputCharset",
	// inputCharset);
	// signMsgVal = BillCore.appendParam(signMsgVal, "pageUrl", pageUrl);
	// signMsgVal = BillCore.appendParam(signMsgVal, "bgUrl", bgUrl);
	// signMsgVal = BillCore.appendParam(signMsgVal, "version", version);
	// signMsgVal = BillCore.appendParam(signMsgVal, "language", language);
	// signMsgVal = BillCore.appendParam(signMsgVal, "signType", signType);
	// signMsgVal = BillCore.appendParam(signMsgVal, "merchantAcctId",
	// merchantAcctId);
	// signMsgVal = BillCore.appendParam(signMsgVal, "payerName",
	// payerName);
	// signMsgVal = BillCore.appendParam(signMsgVal, "payerContactType",
	// payerContactType);
	// signMsgVal = BillCore.appendParam(signMsgVal, "payerContact",
	// payerContact);
	// signMsgVal = BillCore.appendParam(signMsgVal, "orderId", orderId);
	// signMsgVal = BillCore.appendParam(signMsgVal, "orderAmount",
	// orderAmount);
	// signMsgVal = BillCore.appendParam(signMsgVal, "orderTime",
	// orderTime);
	// signMsgVal = BillCore.appendParam(signMsgVal, "productName",
	// productName);
	// signMsgVal = BillCore.appendParam(signMsgVal, "productNum",
	// productNum);
	// signMsgVal = BillCore.appendParam(signMsgVal, "productId",
	// productId);
	// signMsgVal = BillCore.appendParam(signMsgVal, "productDesc",
	// productDesc);
	// signMsgVal = BillCore.appendParam(signMsgVal, "ext1", ext1);
	// signMsgVal = BillCore.appendParam(signMsgVal, "ext2", ext2);
	// signMsgVal = BillCore.appendParam(signMsgVal, "payType", payType);
	// signMsgVal = BillCore.appendParam(signMsgVal, "redoFlag", redoFlag);
	// signMsgVal = BillCore.appendParam(signMsgVal, "pid", pid);
	// signMsgVal = BillCore.appendParam(signMsgVal, "key", key);
	// // 生成加密签名串
	// String signMsg = MD5Util.md5Hex(signMsgVal.getBytes("UTF-8"))
	// .toUpperCase();
	//
	// // 把请求参数打包成数组
	// Map<String, String> sParaTemp = new HashMap<String, String>();
	// sParaTemp.put("inputCharset", inputCharset);
	// sParaTemp.put("pageUrl", pageUrl);
	// sParaTemp.put("bgUrl", bgUrl);
	// sParaTemp.put("version", version);
	// sParaTemp.put("language", language);
	// sParaTemp.put("signType", signType);
	// sParaTemp.put("signMsg", signMsg);
	// sParaTemp.put("merchantAcctId", merchantAcctId);
	// sParaTemp.put("payerName", payerName);
	// sParaTemp.put("payerContactType", payerContactType);
	// sParaTemp.put("payerContact", payerContact);
	// sParaTemp.put("orderId", orderId);
	// sParaTemp.put("orderAmount", orderAmount);
	// sParaTemp.put("orderTime", orderTime);
	// sParaTemp.put("productName", productName);
	// sParaTemp.put("productNum", productNum);
	// sParaTemp.put("productId", productId);
	// sParaTemp.put("productDesc", productDesc);
	// sParaTemp.put("ext1", ext1);
	// sParaTemp.put("ext2", ext2);
	// sParaTemp.put("payType", payType);
	// sParaTemp.put("redoFlag", redoFlag);
	// sParaTemp.put("pid", pid);
	// result = BillService.buildForm(config, sParaTemp, "post", "确定");
	// } else {
	// result = "该订单已经完成支付！";
	// }
	//
	// return result;
	// }
	//
	// /**
	// * 生成网银在线表单
	// *
	// * @param url
	// * 系统url
	// * @param payment_id
	// * 支付方式id
	// * @param type
	// * 支付类型，分为goods支付商品，cash在线充值
	// * @param id
	// * 订单编号，根据type区分类型
	// *
	// */
	// public String genericChinaBank(String url, String payment_id, String
	// type,
	// String id) {
	// boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
	// String result = "";
	// OrderForm of = null;
	// Predeposit pd = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (type.equals("goods")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// pd = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (pd.getPd_pay_status() >= 2) {
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
	// if (type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 团购订单已经处于支付状态
	// submit = false;
	// }
	// }
	//
	// if (submit) {
	// Payment payment = this.paymentService.getObjById(CommUtil
	// .null2Long(payment_id));
	// if (payment == null)
	// payment = new Payment();
	// List<SysMap> list = new ArrayList<SysMap>();
	// String v_mid = payment.getChinabank_account();// 网银商户号
	// list.add(new SysMap("v_mid", v_mid));
	// String key = payment.getChinabank_key();// 网银私钥
	// list.add(new SysMap("key", key));
	// String v_url = url + "/chinabank_return.htm";// 网银付款回调地址
	// list.add(new SysMap("v_url", v_url));
	// String v_oid = "";
	// String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
	// if (type.equals("goods")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// v_oid = "order-" + trade_no + "-" + of.getId().toString();
	// }
	// }
	//
	// if (type.equals("cash")) {
	// pd.setPd_no("pd-" + trade_no + "-" + pd.getId().toString());
	// boolean flag = this.predepositService.update(pd);
	// if (flag) {
	// v_oid = "pd-" + trade_no + "-" + pd.getId().toString();
	// }
	// }
	// if (type.equals("gold")) {
	// gold.setGold_sn("gold-" + trade_no + "-"
	// + gold.getId().toString());
	// boolean flag = this.goldRecordService.update(gold);
	// if (flag) {
	// v_oid = "gold-" + trade_no + "-" + gold.getId().toString();
	// }
	// }
	// if (type.equals("integral")) {
	// ig_order.setIgo_order_sn("igo-" + trade_no + "-"
	// + ig_order.getId().toString());
	// boolean flag = this.integralGoodsOrderService.update(ig_order);
	// if (flag) {
	// v_oid = "igo-" + trade_no + "-"
	// + ig_order.getId().toString();
	// }
	// }
	// if (type.equals("group")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// v_oid = "order-" + trade_no + "-" + of.getId().toString();
	// }
	// }
	// list.add(new SysMap("v_oid", v_oid));
	// String v_amount = "";
	// if (type.equals("goods")) {
	// double total_price = this.orderFormtools
	// .query_order_price(CommUtil.null2String(of.getId()));
	// v_amount = CommUtil.null2String(total_price);// 订单总价格
	// }
	// if (type.equals("cash")) {
	// v_amount = CommUtil.null2String(pd.getPd_amount());// 订单总价格
	// }
	// if (type.equals("gold")) {
	// v_amount = CommUtil.null2String(gold.getGold_money());// 订单总价格
	// }
	// if (type.equals("integral")) {
	// v_amount = CommUtil.null2String(ig_order.getIgo_trans_fee());// 订单总价格
	// }
	// if (type.equals("group")) {
	// v_amount = CommUtil.null2String(of.getTotalPrice());// 订单总价格
	// }
	// list.add(new SysMap("v_amount", v_amount));
	// String v_moneytype = "CNY";// 支付币种，CNY表示人民币
	// list.add(new SysMap("v_moneytype", v_moneytype));
	// String temp = v_amount + v_moneytype + v_oid + v_mid + v_url + key; //
	// 拼凑加密串
	// String v_md5info = Md5Encrypt.md5(temp).toUpperCase();// 使用MD5加密字符串
	// list.add(new SysMap("v_md5info", v_md5info));
	// // 以下为可选项
	// String v_rcvname = "";// 收货人
	// String v_rcvaddr = "";// 收货地址
	// String v_rcvtel = "";// 收货人电话
	// String v_rcvpost = "";// 收货人邮编
	// String v_rcvemail = "";// 收货人邮件
	// String v_rcvmobile = "";// 收货人手机号码
	// String remark1 = "";// 备注1
	// if (type.equals("goods")) {
	// remark1 = of.getId().toString();
	// }
	// if (type.equals("cash")) {
	// remark1 = pd.getId().toString();
	// }
	// if (type.equals("gold")) {
	// remark1 = gold.getId().toString();
	// }
	// if (type.equals("integral")) {
	// remark1 = ig_order.getId().toString();
	// }
	// if (type.equals("group")) {
	// remark1 = of.getId().toString();
	// }
	// list.add(new SysMap("remark1", remark1));
	// String remark2 = type;// 备注2
	// list.add(new SysMap("remark2", remark2));
	// result = ChinaBankSubmit.buildForm(list);
	// } else {
	// result = "该订单已经完成支付！";
	// }
	//
	// return result;
	// }
	//
	// /**
	// * 生成Paypal支付表单并自动提交
	// *
	// * @param url
	// * @param payment_id
	// * @param type
	// * @param id
	// * @return
	// */
	// public String genericPaypal(String url, String payment_id, String type,
	// String id) {
	// boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
	// String result = "";
	// OrderForm of = null;
	// Predeposit pd = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (type.equals("goods")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// pd = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (pd.getPd_pay_status() >= 2) {
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
	// if (type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 团购订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (submit) {
	// Payment payment = this.paymentService.getObjById(CommUtil
	// .null2Long(payment_id));
	// if (payment == null)
	// payment = new Payment();
	// List<SysMap> sms = new ArrayList<SysMap>();
	// String business = payment.getPaypal_userId();// Paypal商户号
	// sms.add(new SysMap("business", business));
	// String return_url = url + "/paypal_return.htm";// paypal付款回调地址
	// String notify_url = url + "/paypal_return.htm";// paypal notify地址
	// sms.add(new SysMap("return", return_url));
	// String item_name = "";
	// String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
	// if (type.equals("goods")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// item_name = "order-" + trade_no + "-"
	// + of.getId().toString();
	// }
	// }
	//
	// if (type.equals("cash")) {
	// pd.setPd_no("pd-" + trade_no + "-" + pd.getId().toString());
	// boolean flag = this.predepositService.update(pd);
	// if (flag) {
	// item_name = "pd-" + trade_no + "-" + pd.getId().toString();
	// }
	// }
	// if (type.equals("gold")) {
	// gold.setGold_sn("gold-" + trade_no + "-"
	// + gold.getId().toString());
	// boolean flag = this.goldRecordService.update(gold);
	// if (flag) {
	// item_name = "gold-" + trade_no + "-"
	// + gold.getId().toString();
	// }
	// }
	// if (type.equals("integral")) {
	// ig_order.setIgo_order_sn("igo-" + trade_no + "-"
	// + ig_order.getId().toString());
	// boolean flag = this.integralGoodsOrderService.update(ig_order);
	// if (flag) {
	// item_name = "igo-" + trade_no + "-"
	// + ig_order.getId().toString();
	// }
	// }
	// if (type.equals("group")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// item_name = "order-" + trade_no + "-"
	// + of.getId().toString();
	// }
	// }
	// sms.add(new SysMap("item_name", item_name));
	// String amount = "";
	// String item_number = "";
	// if (type.equals("goods")) {
	// double total_price = this.orderFormtools
	// .query_order_price(CommUtil.null2String(of.getId()));
	// amount = CommUtil.null2String(total_price);// 订单总价格
	// item_number = of.getOrder_id();
	// }
	// if (type.equals("cash")) {
	// amount = CommUtil.null2String(pd.getPd_amount());// 订单总价格
	// item_number = pd.getPd_sn();
	// }
	// if (type.equals("gold")) {
	// amount = CommUtil.null2String(gold.getGold_money());// 订单总价格
	// item_number = gold.getGold_sn();
	// }
	// if (type.equals("integral")) {
	// amount = CommUtil.null2String(ig_order.getIgo_trans_fee());// 订单总价格
	// item_number = ig_order.getIgo_order_sn();
	// }
	// if (type.equals("group")) {
	// amount = CommUtil.null2String(of.getTotalPrice());// 订单总价格
	// item_number = of.getOrder_id();
	// }
	// sms.add(new SysMap("amount", amount));
	// sms.add(new SysMap("notify_url", notify_url));
	// sms.add(new SysMap("cmd", "_xclick"));
	// sms.add(new SysMap("currency_code", payment.getCurrency_code()));
	// sms.add(new SysMap("item_number", item_number));
	// // sms.add(new SysMap("no_shipping", "1"));
	// // sms.add(new SysMap("no_note", "1"));
	// // 以下为可选项
	// String custom = "";// 备注1
	// if (type.equals("goods")) {
	// custom = of.getId().toString();
	// }
	// if (type.equals("cash")) {
	// custom = pd.getId().toString();
	// }
	// if (type.equals("gold")) {
	// custom = gold.getId().toString();
	// }
	// if (type.equals("integral")) {
	// custom = ig_order.getId().toString();
	// }
	// if (type.equals("group")) {
	// custom = of.getId().toString();
	// }
	// custom = custom + "," + type;
	// sms.add(new SysMap("custom", custom));
	// result = PaypalTools.buildForm(sms);
	// } else {
	// result = "该订单已经完成支付！";
	// }
	// return result;
	// }
	//
	// /**
	// * 生成手机端网页支付信息,V1.3版手机网页客户端仅仅支持用户支付,mobile_mark手机端支付标识，该标识存在时说明为手机端支付，
	// * 支付完成后调用手机端回调地址
	// *
	// * @param url
	// * @param payment_id
	// * @param type
	// * @param id
	// * @return
	// * @throws Exception
	// */
	// public String genericAlipayWap(String url, String payment_id, String
	// type,
	// String id) throws Exception {
	// boolean submit = true;// 是否继续提交支付，防止订单重复支付，pc端打开支付页面，另外一个人用app完成了支付
	// String result = "";
	// OrderForm of = null;
	// Predeposit pd = null;
	// GoldRecord gold = null;
	// IntegralGoodsOrder ig_order = null;
	// if (type.equals("goods")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (type.equals("cash")) {
	// pd = this.predepositService.getObjById(CommUtil.null2Long(id));
	// if (pd.getPd_pay_status() >= 2) {
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
	// if (type.equals("group")) {
	// of = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// if (of.getOrder_status() >= 20) {// 团购订单已经处于支付状态
	// submit = false;
	// }
	// }
	// if (submit) {
	// Payment payment = this.paymentService.getObjById(CommUtil
	// .null2Long(payment_id));
	// if (payment == null)
	// payment = new Payment();
	// int interfaceType = payment.getInterfaceType();
	// AlipayConfig config = new AlipayConfig();
	// Map params = new HashMap();
	// params.put("mark", "alipay_wap");
	// List<Payment> payments = this.paymentService.query(
	// "select obj from Payment obj where obj.mark=:mark", params,
	// -1, -1);
	// Payment shop_payment = new Payment();
	// if (payments.size() > 0) {
	// shop_payment = payments.get(0);
	// }
	// if (!CommUtil.null2String(payment.getSafeKey()).equals("")
	// && !CommUtil.null2String(payment.getPartner()).equals("")) {
	// config.setKey(payment.getSafeKey());
	// config.setPartner(payment.getPartner());
	// } else {
	// config.setKey(shop_payment.getSafeKey());
	// config.setPartner(shop_payment.getPartner());
	// }
	// config.setSeller_email(payment.getSeller_email());
	// //
	// //////////////////////////////////调用授权接口alipay.wap.trade.create.direct获取授权码token//////////////////////////////////////
	// // 返回格式
	// String format = "xml";
	// // 必填，不需要修改
	// // 返回格式
	// String v = "2.0";
	// // 必填，不需要修改
	// // 请求号
	// String req_id = UtilDate.getOrderNum();
	// // 必填，须保证每次请求都是唯一
	// // req_data详细信息
	// // 服务器异步通知页面路径
	// String notify_url = url + "/wap/alipay_notify.htm";
	// // 需http://格式的完整路径，不能加?id=123这类自定义参数
	// // 页面跳转同步通知页面路径
	// String call_back_url = url + "/wap/alipay_return.htm";
	// // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
	// // 操作中断返回地址
	// String merchant_url = url + "/wap/index.htm";
	// // 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
	// // String pay_body = type;
	// // 用户付款中途退出返回商户的地址。需http://格式的完整路径，不允许加?id=123这类自定义参数
	// // 卖家支付宝帐户
	// String seller_email = payment.getSeller_email();
	// // System.out.println("seller_email:" + seller_email);
	// // 必填
	// // 商户订单号
	// String out_trade_no = "";
	// // begin
	// String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
	// if (type.equals("goods")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// out_trade_no = "order-" + trade_no + "-"
	// + of.getId().toString() + "-" + type;
	// }
	// }
	//
	// if (type.equals("cash")) {
	// pd.setPd_no("pd-" + trade_no + "-" + pd.getId().toString());
	// boolean flag = this.predepositService.update(pd);
	// if (flag) {
	// out_trade_no = "pd-" + trade_no + "-"
	// + pd.getId().toString() + "-" + type;
	// }
	// }
	// if (type.equals("gold")) {
	// gold.setGold_sn("gold-" + trade_no + "-"
	// + gold.getId().toString());
	// boolean flag = this.goldRecordService.update(gold);
	// if (flag) {
	// out_trade_no = "gold-" + trade_no + "-"
	// + gold.getId().toString() + "-" + type;
	// }
	// }
	// if (type.equals("integral")) {
	// ig_order.setIgo_order_sn("igo-" + trade_no + "-"
	// + ig_order.getId().toString());
	// boolean flag = this.integralGoodsOrderService.update(ig_order);
	// if (flag) {
	// out_trade_no = "igo-" + trade_no + "-"
	// + ig_order.getId().toString() + "-" + type;
	// }
	// }
	// if (type.equals("group")) {
	// of.setTrade_no("order-" + trade_no + "-"
	// + of.getId().toString());
	// boolean flag = this.orderFormService.update(of);// 更新订单流水号
	// if (flag) {
	// out_trade_no = "order-" + trade_no + "-"
	// + of.getId().toString() + "-" + type;
	// }
	// }
	// // System.out.println("out_trade_no:" + out_trade_no);
	// // 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
	// // 商户网站订单系统中唯一订单号，必填
	// // 订单名称
	// String subject = "goods";//
	// if (type.equals("goods")) {
	// subject = of.getOrder_id();
	// }
	// if (type.equals("cash")) {
	// subject = pd.getPd_sn();
	// }
	// if (type.equals("gold")) {
	// subject = gold.getGold_sn();
	// }
	// if (type.equals("integral")) {
	// subject = ig_order.getIgo_order_sn();
	// }
	// if (type.equals("store_deposit")) {
	// subject = "store_deposit";
	// }
	// // System.out.println("subject:" + subject);
	// // 必填
	// // 付款金额
	// // 订单总金额，显示在支付宝收银台里的“应付总额”里
	// String total_fee = "";//
	// if (type.equals("goods")) {
	// // 获取订单总价格
	// double total_price = this.orderFormtools
	// .query_order_price(CommUtil.null2String(of.getId()));
	// total_fee = CommUtil.null2String(total_price);
	// }
	// if (type.equals("cash")) {
	// total_fee = CommUtil.null2String(pd.getPd_amount());
	// }
	// if (type.equals("gold")) {
	// total_fee = CommUtil.null2String(gold.getGold_money());
	// }
	// if (type.equals("integral")) {
	// total_fee = CommUtil.null2String(ig_order.getIgo_trans_fee());
	// }
	// // 必填
	// // 请求业务参数详细
	// String req_dataToken = "<direct_trade_create_req><notify_url>"
	// + notify_url + "</notify_url><call_back_url>"
	// + call_back_url + "</call_back_url><seller_account_name>"
	// + seller_email + "</seller_account_name><out_trade_no>"
	// + out_trade_no + "</out_trade_no><subject>" + subject
	// + "</subject><total_fee>" + total_fee
	// + "</total_fee><merchant_url>" + merchant_url
	// + "</merchant_url><pay_body>" + type
	// + "</pay_body></direct_trade_create_req>";
	// // 必填
	// //
	// ////////////////////////////////////////////////////////////////////////////////
	// // 把请求参数打包成数组
	// Map<String, String> sParaTempToken = new HashMap<String, String>();
	// sParaTempToken.put("service", "alipay.wap.trade.create.direct");
	// sParaTempToken.put("partner", config.getPartner());
	// sParaTempToken.put("_input_charset", config.getInput_charset());
	// sParaTempToken.put("sec_id", config.getSign_type());
	// sParaTempToken.put("format", format);
	// sParaTempToken.put("v", v);
	// sParaTempToken.put("req_id", req_id);
	// sParaTempToken.put("req_data", req_dataToken);
	// // 建立请求
	// String sHtmlTextToken = AlipaySubmit.buildRequest(config, "wap",
	// sParaTempToken, "", "");
	// // URLDECODE返回的信息
	// sHtmlTextToken = URLDecoder.decode(sHtmlTextToken,
	// config.getInput_charset());
	// // System.out.println(sHtmlTextToken);
	// // 获取token
	// String request_token = AlipaySubmit.getRequestToken(config,
	// sHtmlTextToken);
	// // System.out.println(request_token);
	// //
	// //////////////////////////////////根据授权码token调用交易接口alipay.wap.auth.authAndExecute//////////////////////////////////////
	// // 业务详细
	// String req_data = "<auth_and_execute_req><request_token>"
	// + request_token + "</request_token></auth_and_execute_req>";
	// // 必填
	// // 把请求参数打包成数组
	// Map<String, String> sParaTemp = new HashMap<String, String>();
	// sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
	// sParaTemp.put("partner", config.getPartner());
	// sParaTemp.put("_input_charset", config.getInput_charset());
	// sParaTemp.put("sec_id", config.getSign_type());
	// sParaTemp.put("format", format);
	// sParaTemp.put("v", v);
	// sParaTemp.put("req_data", req_data);
	// // 建立请求
	// String WAP_ALIPAY_GATEWAY_NEW =
	// "http://wappaygw.alipay.com/service/rest.htm?";
	// result = AlipaySubmit.buildForm(config, sParaTemp,
	// WAP_ALIPAY_GATEWAY_NEW, "get", "确认");
	// // System.out.println(result);
	// } else {
	// result = "该订单已经完成支付！";
	// }
	// return result;
	// }

	/**
	 * 云购币订单统一支付接口
	 * 
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String yg_pay(String url, String payment_id, String type, String id, String bank,
			String actualPrice) {
		boolean submit = true;
		OrderForm of = null;
		GroupOrderBO go = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		}
		if (submit) {
			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {
				out_trade_no = of.getTradeNo();
			}
			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderId();
				orderNo = of.getOrderId();
			}
			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				// double total_price =
				// this.orderFormtools.query_order_price(CommUtil.null2String(of.getId()));
				double total_price = Double.valueOf(actualPrice);
				total_fee = CommUtil.null2String(total_price);
			}

			if (isDebug == 1) {
				total_fee = "0.01"; // 测试使用
			}
			
			try {
				Payment payment = this.paymentService.findById(CommUtil.null2Long(payment_id));
				String mark = payment.getMark();
				if (PaymentConstants.PAYMENT_MARK_ALIPAY.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_JF_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_AL.equals(mark)) {
					Properties aconf = new Properties();
					aconf.setProperty("KEY", payment.getSafeKey());
					aconf.setProperty("partner", payment.getPartner());
					aconf.setProperty("sign_type", "MD5");
					aconf.setProperty("_input_charset", "utf-8");
					aconf.setProperty("seller_email", payment.getSellerEmail());
					aconf.setProperty("return_url", url + "/alipay_return.htm");
					AlipayFactory factory = new AlipayFactory(aconf);

					RequestBase req;

					// url="http://echovi.xicp.net:25800"; //测试

					if (StringUtils.isEmpty(bank)) {
						req = factory.newCreateDirectPayByUser(aconf)

						.setProperty("out_trade_no", out_trade_no).setProperty("subject", subject)
								.setProperty("body", body).setProperty("payment_type", "1")
								// .setProperty("total_fee", "0.01")//total_fee
								.setProperty("total_fee", total_fee)// total_fee
								.setProperty("notify_url", url + "/alipay_notify.htm");
					} else {
						req = factory.newCreateDirectPayByUserBank(aconf)

						.setProperty("out_trade_no", out_trade_no).setProperty("subject", subject)
								.setProperty("body", body).setProperty("payment_type", "1")
								// .setProperty("total_fee", "0.01")//total_fee
								.setProperty("total_fee", total_fee)
								// total_fee
								.setProperty("defaultbank", bank)
								.setProperty("notify_url", url + "/alipay_notify.htm");
					}
					log.debug("[payment] payment id=" + payment_id);
					log.debug("[payment] KEY=" + aconf.getProperty("KEY"));
					log.debug("[payment] partner=" + aconf.getProperty("partner"));
					log.debug("[payment] sign_type=" + aconf.getProperty("sign_type"));
					log.debug("[payment] _input_charset=" + aconf.getProperty("_input_charset"));
					log.debug("[payment] seller_email=" + aconf.getProperty("seller_email"));
					log.debug("[payment] return_url=" + aconf.getProperty("return_url"));
					log.debug("[payment] out_trade_no=" + aconf.getProperty("out_trade_no"));
					log.debug("[payment] body=" + aconf.getProperty("body"));
					log.debug("[payment] payment_type=" + aconf.getProperty("payment_type"));
					log.debug("[payment] total_fee=" + aconf.getProperty("total_fee"));
					log.debug("[payment] notify_url=" + aconf.getProperty("notify_url"));
					log.debug("[payment] defaultbank=" + aconf.getProperty("defaultbank"));
					log.debug("[payment] URL=" + req.build().sign().toURL());
					return (req.build().sign().toURL());

				} else if (PaymentConstants.PAYMENT_MARK_WX_QR_PAY.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_WX.equals(mark) 
						|| PaymentConstants.PAYMENT_MARK_JF_WX.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_WX.equals(mark)) {
					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("NATIVE");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());
					Document doc = Jsoup.parse(content, "", Parser.xmlParser());
					if (doc.select("return_code").text().equals("SUCCESS")
							&& doc.select("return_msg").text().equals("OK"))
						return "/wx_qr_pay.html?code=" + doc.select("code_url").text() + "&totalFee="
								+ total_fee + "&orderNo=" + orderNo + "&type=" + type;
					else
						// XmlMapper xmlMapper = new XmlMapper();
						// PayNativeInput payNativeInput =
						// xmlMapper.readValue(content, PayNativeInput.class);

						return "";
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}

	}

	/**
	 * 获取专属码生成地址
	 * 
	 * @param urlAddress
	 * @param sellerId
	 * @return
	 */
	public Map<String, String> exclusiveCode_GetQrPath(String urlAddress, Long sellerId) {

		urlAddress += "/";
		Map<String, String> map = new HashMap<String, String>();
		String unified_QrPath = "";
		try {
			unified_QrPath = urlAddress + URLEncoder.encode("q/exclusive.htm?s=" + sellerId, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		} finally {
			map.put("unified_QrPath", unified_QrPath);
		}
		return map;
	}

	/**
	 * 
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String appPay_forYg(String url, String payment_id, String type, String id) {

		boolean submit = true;
		OrderForm of = null;
		GroupOrderBO go = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		Map<String, String> params = Maps.newHashMap();

		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		}

		if (submit) {

			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {// || type.equals("group")
				out_trade_no = of.getTradeNo();
			}

			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderId();
				orderNo = of.getOrderId();
			}

			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				// double total_price =
				// this.orderFormtools.query_order_price(CommUtil.null2String(of.getId()));

				double total_price = this.orderFormService.subtractOrderNeedAmount(of.getId());

				total_fee = CommUtil.null2String(total_price);
			}

						if (isDebug == 1) {
							total_fee = "0.01"; // 测试使用
						}
			try {

				Payment payment = this.paymentService.findById(Long.parseLong(payment_id));
				String mark = payment.getMark();

				if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_AL.equals(mark)) {

					String orderInfo = getOrderInfo(payment.getPartner(), payment.getSellerEmail(),
							out_trade_no, url + "/alipay_notify.htm", subject, body, total_fee);

					String sign = sign(orderInfo, payment.getAppPrivateKey());
					try {
						// 仅需对sign 做URL编码
						sign = URLEncoder.encode(sign, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					// 完整的符合支付宝参数规范的订单信息
					String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

					return payInfo;

				} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_WX.equals(mark)) {

					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					// payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("APP");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					// payPackage.setTotal_fee("1");//total_fee
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());

					return content;
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}
	}
	
	/**
	 * 酒业商品订单支付公用服务
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String jiuyeCommonPay(String url, String payment_id, String type, String id, BigDecimal amount) {
		boolean submit = true;
		JiuyeOrder of = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		Map<String, String> params = Maps.newHashMap();
		
		if (type.equals("goods")) {
			of = jiuyeOrderFormService.findByOrderId(CommUtil.null2Long(id));
		}
		if (submit) {

			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {// || type.equals("group")
				out_trade_no = of.getTradeNo();
			}

			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderNo();
				orderNo = of.getOrderNo();
			}

			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				BigDecimal total_price = amount;
				total_fee = CommUtil.null2String(total_price);
			}

			if (isDebug == 1) {
				total_fee = "0.01"; // 测试使用
			}
			try {

				Payment payment = this.paymentService.findById(Long.parseLong(payment_id));
				String mark = payment.getMark();

				if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_JF_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_AL.equals(mark)) {

					String orderInfo = getOrderInfo(payment.getPartner(), payment.getSellerEmail(),
							out_trade_no, url + "/alipay_notify.htm", subject, body, total_fee);

					String sign = sign(orderInfo, payment.getAppPrivateKey());
					try {
						// 仅需对sign 做URL编码
						sign = URLEncoder.encode(sign, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					// 完整的符合支付宝参数规范的订单信息
					String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

					return payInfo;

				} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_WX.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_JF_WX.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_WX.equals(mark)) {

					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					// payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("APP");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					// payPackage.setTotal_fee("1");//total_fee
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());

					return content;
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}
	}
	
	/***
	 * 微信订单支付查询
	 * @param paymentId
	 * @param trade_no
	 * @return
	 */
	public Map selectPayStatus(Long paymentId,String trade_no) {
		Payment payment = this.paymentService.findById(paymentId);
		String content = "";
		PayPackage payPackage = new PayPackage();
		payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
	/*	payPackage.setAppid(payment.getWxAppid());
		payPackage.setMch_id(payment.getTenpayPartner());*/
		payPackage.setAppid("wx104076d4c695c187");
		payPackage.setMch_id("1377634902");
		payPackage.setOut_trade_no(trade_no);
		/*content = PayUtils.generateOrderQueryXML(payPackage,payment.getTenpayPartner(), payment.getWxPaysignkey());*/
		content = PayUtils.generateOrderQueryXML(payPackage,"1377634902", "qweasdzxciu12412k3n1lk23nmdsflkj");
		XmlMapper xmlMapper = new XmlMapper();
		if (StringUtil.isNotBlank(content)) {
			xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
			try {
				Map map = xmlMapper.readValue(content, Map.class);
				return map;
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 商品订单支付公用服务
	 * @param url
	 * @param payment_id
	 * @param type
	 * @param id
	 * @param bank
	 * @return
	 */
	public String appCommonPay(String url, String payment_id, String type, String id, BigDecimal amount) {

		boolean submit = true;
		OrderForm of = null;
		GroupOrderBO go = null;
		Predeposit pd = null;
		GoldRecord gold = null;
		IntegralGoodsOrder ig_order = null;
		SysConfigBO config = configService.getSysConfig();
		String webName = config.getWebsiteName();
		Map<String, String> params = Maps.newHashMap();

		if (type.equals("goods")) {
			of = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (of.getOrderStatus() >= 20) {// 订单已经处于支付状态
				submit = false;
			}
		}

		if (submit) {

			String out_trade_no = "";
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			if (type.equals("goods")) {// || type.equals("group")
				out_trade_no = of.getTradeNo();
			}

			// 订单名称，显示在支付宝收银台里的“商品名称”里，显示在支付宝的交易管理的“商品名称”的列表里。
			String subject = "";//
			String orderNo = "";
			if (type.equals("goods")) {
				subject = webName + "订单-" + of.getOrderId();
				orderNo = of.getOrderId();
			}

			// 订单描述、订单详细、订单备注，显示在支付宝收银台里的“商品描述”里
			String body = type;

			String total_fee = "";//
			if (type.equals("goods")) {
				BigDecimal total_price = amount;
				total_fee = CommUtil.null2String(total_price);
			}

						if (isDebug == 1) {
							total_fee = "0.01"; // 测试使用
						}
			try {

				Payment payment = this.paymentService.findById(Long.parseLong(payment_id));
				String mark = payment.getMark();

				if (PaymentConstants.PAYMENT_MARK_ALIPAY_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYB.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_ALIPAYC.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_JF_AL.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_AL.equals(mark)) {

					String orderInfo = getOrderInfo(payment.getPartner(), payment.getSellerEmail(),
							out_trade_no, url + "/alipay_notify.htm", subject, body, total_fee);

					String sign = sign(orderInfo, payment.getAppPrivateKey());
					try {
						// 仅需对sign 做URL编码
						sign = URLEncoder.encode(sign, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}

					// 完整的符合支付宝参数规范的订单信息
					String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();

					return payInfo;

				} else if (PaymentConstants.PAYMENT_MARK_WX_APP.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_YG_WX.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_JF_WX.equals(mark)
						|| PaymentConstants.PAYMENT_MARK_PTJF_WX.equals(mark)) {

					PayPackage payPackage = new PayPackage();
					payPackage.setAppid(payment.getWxAppid());

					payPackage.setMch_id(payment.getTenpayPartner());
					// payPackage.setDevice_info("WEB");
					payPackage.setTrade_type("APP");
					payPackage.setSpbill_create_ip(localIp());
					payPackage.setProduct_id(subject);
					payPackage.setBody("订单号:" + orderNo);
					payPackage.setAttach(type);
					payPackage.setOut_trade_no(out_trade_no);
					// payPackage.setTotal_fee("1");//total_fee
					payPackage.setTotal_fee(String.valueOf((new Double(CommUtil.mul(total_fee, 100))
							.longValue())));// total_fee
					payPackage.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
					payPackage.setNotify_url(url + "/weixin_notify.htm");
					String content = PayUtils.generatePayNativeReplyXML(payPackage,
							payment.getTenpayPartner(), payment.getWxPaysignkey());

					return content;
				} else {
					return "";
				}
			} catch (Exception ex) {
				log.error("生成支付失败", ex);
				return "";
			}
		} else {
			return "该订单已经完成支付！";
		}
	}
}
