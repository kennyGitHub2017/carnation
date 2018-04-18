package com.weixin.api;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.weixin.bean.PayNativeInput;
import com.weixin.bean.PayPackage;
import com.weixin.bean.PayQrCode;
import com.weixin.utils.Configure;
import com.weixin.utils.HttpsRequest;
import com.weixin.utils.MapUtil;
import com.weixin.utils.Signature;

/**
 * 
 * @author louiseliu
 * 
 */
public class PayUtils {
	private static final Logger log = LoggerFactory.getLogger(PayUtils.class);

	public static String generateMchPayNativeRequestURL(String appid, String mch_id, String productid,
			String key) {
		PayQrCode qrCode = new PayQrCode(appid, mch_id, productid, key);
		Map<String, String> map = new HashMap<String, String>();
		map.put("sign", qrCode.getSign());
		map.put("appid", qrCode.getAppid());
		map.put("mch_id", qrCode.getMch_id());
		map.put("product_id", qrCode.getProduct_id());
		map.put("time_stamp", qrCode.getTime_stamp());
		map.put("nonce_str", qrCode.getNonce_str());

		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map, false, false);
	}

	/**
	 * 
	 * @param inputStream
	 *            request.getInputStream()
	 * @return
	 */
	public static PayNativeInput convertRequest(InputStream inputStream) {
		try {
			String content = IOUtils.toString(inputStream);

			XmlMapper xmlMapper = new XmlMapper();
			PayNativeInput payNativeInput = xmlMapper.readValue(content, PayNativeInput.class);

			return payNativeInput;
		} catch (Exception e) {
			log.error("error", e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static boolean validateAppSignature(PayNativeInput payNativeInput, String key) {
		try {
			Map<String, String> map = BeanUtils.describe(payNativeInput);
			map.remove("class");
			map.put("sign", "");

			String sign = Signature.generateSign(map, key);
			return payNativeInput.getSign().equals(sign) ? true : false;
		} catch (Exception e) {
			log.error("error", e);
		}

		return false;
	}

	@SuppressWarnings("unchecked")
	public static String generatePayNativeReplyXML(PayPackage payPackage, String mch_id, String key) {
		try {
			// 需要修改
			log.debug("arguments, key=" + key);
			log.debug("arguments, mch_id=" + mch_id);
			Map<String, String> map = BeanUtils.describe(payPackage);
			map.remove("class");
			log.debug("arguments, map=" + JSONObject.fromObject(map).toString());
			String sign = Signature.generateSign(map, key);
			payPackage.setSign(sign);
			log.debug("arguments, sign=" + sign);
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
			String xmlContent = xmlMapper.writeValueAsString(payPackage);
			log.debug("xmlContent=" + xmlContent);
			// HttpsRequest httpsRequest = new HttpsRequest(mch_id);
			log.info("INFO xmlContent=" + xmlContent);
			System.out.println("pri xmlContent=" + xmlContent);
			String result = HttpsRequest.sendPost(Configure.UNIFY_PAY_API, xmlContent);
			log.debug("result=" + result);
			log.info("INFO result=" + result);
			System.out.println("pri result=" + result);
			return result;
		} catch (Exception e) {
			log.error("error", e);
			return null;
		}

	}

	@SuppressWarnings("rawtypes")
	public static Map payCallbackNotify(InputStream inputStream) {
		try {
			String content = IOUtils.toString(inputStream);
			log.info("recevice pay callback: " + content);
			/*
			PayCallbackNotify payCallbackNotify = JaxbUtil
					.converyToJavaBean(content, PayCallbackNotify.class);
			if (payCallbackNotify.getResult_code().equals("SUCCESS")
					&& payCallbackNotify.getReturn_code().equals("SUCCESS")) {
				payCallbackNotify.setPaySuccess(true);
			}
			return payCallbackNotify;
			*/
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
			return xmlMapper.readValue(content, Map.class);
		} catch (Exception e) {
			log.error("recevice pay callback exception: ", e);
		}

		return null;
	}

	@SuppressWarnings({"unchecked", "rawtypes"})
	public static boolean validateAppSignature(Map payCallbackNotify, String key) {
		try {
			//Map<String, String> map = BeanUtils.describe(payCallbackNotify);
			String sign = (String) payCallbackNotify.get("sign");
			payCallbackNotify.put("sign", "");
			
			String verifySign = Signature.generateSign(payCallbackNotify, key);
			payCallbackNotify.put("sign", sign);
			
			return verifySign.equals(sign) ? true : false;
		} catch (Exception e) {
			log.error("pay signature failed, out_order_id=" + payCallbackNotify.get("out_trade_no") + ", money=" + payCallbackNotify.get("total_fee"), e);
		}
		return false;
	}
	
	
	@SuppressWarnings("unchecked")
	public static String generateOrderQueryXML(PayPackage payPackage, String mch_id, String key) {
		try {
			Map<String, String> map = BeanUtils.describe(payPackage);
			map.remove("class");
			String sign = Signature.generateSign(map, key);
			payPackage.setSign(sign);
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.setSerializationInclusion(Include.NON_EMPTY);
			String xmlContent = xmlMapper.writeValueAsString(payPackage);
			String result = HttpsRequest.sendPost(Configure.ORDER_QUERY_API, xmlContent);
			return result;
		} catch (Exception e) {
			log.error("error", e);
			return null;
		}
	}

	public static String generatePaySuccessReplyXML() {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("<xml>").append("<return_code><![CDATA[SUCCESS]]></return_code>")
				.append("<return_msg><![CDATA[OK]]></return_msg>").append("</xml>");
		return stringBuffer.toString();
	}
}
