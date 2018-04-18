package com.sinco.carnation.order.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.user.bo.WxInvitationRelationBO;
import com.sinco.carnation.user.dao.WxInvitationRelationDao;
import com.weixin.utils.MD5;

/***
 * H5微信支付service
 * 
 * @author KENNY
 * 
 */
@Service
public class WeiXinPayWapService {

	@Autowired
	private WxInvitationRelationDao wxInvitationRelationDao;
	@Autowired
	private OrderFormService orderFormService;

	/*private static final String appid = "wx9d38abce10c26432";*/
	private static final String appid = "wx104076d4c695c187";
	private static final String mch_id = "1377634902";
	private static final String appKey = "qweasdzxciu12412k3n1lk23nmdsflkj";
	/*private static final String notify_url = "http://mobile.ysysgo.com/weixinWapPayNotify/";*/// 支付成功回调接口
	private static final String requestUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";// 下单请求接口
	private static final String notify_url = "http://shop.ysysgo.com/weixin_notify.htm";// 支付成功回调接口

	@SuppressWarnings("unchecked")
	public Map<String, String> weixinWapPay(String amount, String body, String ip, Integer sellerId,
			String orderId, String openId) {
		Integer tradeTypeNative = 1;// 表示H5

		BigDecimal big = new BigDecimal(amount);
		BigDecimal multiply = new BigDecimal(100);
		BigDecimal totalFee1 = big.multiply(multiply).setScale(0, BigDecimal.ROUND_HALF_UP);
		OrderFormBO order = this.orderFormService.findByOrderNo(orderId);// 根据订单id查询
		String result = this.requestParamXml(totalFee1.toString(), body, ip, sellerId, tradeTypeNative,
				order.getTradeNo(), openId);// 拼装参数
		System.out.println("统一下单post参数-->" + result);
		Map<String, String> resultMap = this.sendPost(result);// 提交参数
		return resultMap;
	}

	/***
	 * 
	 * POST 提交参数,
	 * 
	 * @param param
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	private Map sendPost(String param) {
		Map<String, String> res = new HashMap();

		String url = requestUrl;
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpEntity entity = new StringEntity(param, "UTF-8");
		post.setEntity(entity);
		post.setHeader("Content-Type", "application/xml; charset=UTF-8");
		HttpResponse httpResponse = null;
		String response = null;

		try {
			httpResponse = httpClient.execute(post);

			if (httpResponse.getStatusLine().getStatusCode() == 200) {
				response = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
			}
			System.out.println("下单返回--" + response);
			res = this.readDom(response);// //解析统一下单 返回结果

		} catch (ClientProtocolException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
		/*return resultCodeUrl;*/
	}

	/****
	 * 解析 微信同意下单 的返回结果
	 * 
	 * @param response
	 * @return kenny
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	private Map<String, String> readDom(String response) {
		Map<String, String> resMap = new HashMap();
		Document document = null;
		try {
			document = DocumentHelper.parseText(response);
		} catch (DocumentException e) {

		}

		Element root = document.getRootElement();

		String returnCode = root.element("return_code").getText().toString();

		if (returnCode.equals("FAIL")) {
			String return_code = root.element("return_code").getText().toString();
			resMap.put("return_code", return_code);
		} else if (returnCode.equals("SUCCESS")) {

			/*String return_code = root.element("return_code").getText().toString();
					
			String appId = root.element("appid").getText().toString();
			String prepay_id = root.element("prepay_id").getText().toString();
			String sign = root.element("paySign").getText().toString();
			String nonce_str = root.element("nonceStr").getText().toString();

			resMap.put("appId", appId);
			resMap.put("prepay_id", prepay_id);
			resMap.put("sign", sign);
			resMap.put("nonce_str", nonce_str);
			resMap.put("return_code", return_code);*/
			String return_code = root.element("return_code").getText().toString();
			resMap.put("return_code", return_code);
			String code_url = root.element("code_url").getText().toString();
			resMap.put("code_url", code_url);

		}
		return resMap;
	}

	/****
	 * 获得签名value
	 * 
	 * @param amount
	 * @param body
	 * @param ip
	 * @return
	 */
	private Map<String, String> getData(String amount, String body, String ip, Integer sellerId,
			Integer tradeType, String orderId, String openId) {
		Map<String, String> map = this.requestParamMap(amount, body, ip, tradeType, orderId, openId);

		List<String> keyList = new ArrayList<>();
		keyList.addAll(map.keySet());
		Collections.sort(keyList);

		String stringA = "";

		for (String key : keyList) {
			stringA += key + "=" + map.get(key) + "&";
		}
		String signStr = stringA.substring(0, stringA.length() - 1);

		String stringSignTemp = signStr + "&key=" + appKey;

		System.out.println("获取签名的参数--->" + stringSignTemp);

		String resSign = MD5.MD5Encode(stringSignTemp).toUpperCase();

		System.out.println("得到的签名---->" + resSign);

		map.put("sign", resSign);

		return map;
	}

	/**
	 * 请求参数拼装成XML格式
	 * 
	 * @param amount
	 * @param body
	 * @param ip
	 * @return
	 */
	private String requestParamXml(String amount, String body, String ip, Integer sellerId,
			Integer tradeType, String OrderId, String openId) {
		Map<String, String> map = this.getData(amount, body, ip, sellerId, tradeType, OrderId, openId);

		String param = "<xml>";

		for (String key : map.keySet()) {
			param += "<" + key + ">" + "<![CDATA[" + map.get(key) + "]]>" + "</" + key + ">";
		}

		param += "</xml>";
		System.out.println("组装之后的参数" + param);
		return param;

	}

	/***
	 * 将提交参数拼装成MAP
	 * 
	 * @param amount
	 * @param body
	 * @param ip
	 */
	private Map<String, String> requestParamMap(String amount, String body, String ip, Integer tradeType,
			String orderId, String openId) {

		String thisTradeType = "JSAPI";
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", appid);
		map.put("mch_id", mch_id);
		map.put("nonce_str", this.getNonceStr());
		map.put("body", body);
		map.put("out_trade_no", orderId);
		map.put("total_fee", amount);
		map.put("spbill_create_ip", ip);
		map.put("attach", "goods");
		map.put("notify_url", notify_url);
		if (tradeType == 1) {
			thisTradeType = "NATIVE";
		}
		if (tradeType == 2) {
			thisTradeType = "NATIVE";
		}
		map.put("trade_type", thisTradeType);
		/*		map.put("openid", openId);*/
		return map;
	}

	/**
	 * 16位随机字符串 [随机字符串 字段]
	 * 
	 * @return NPpDLfJfNAYmCgQj
	 */
	private String getNonceStr() {
		return RandomStringUtils.randomAlphabetic(16);
	}

	/**
	 * 随机产生商户订单号 [商户订单号字段]
	 * 
	 * @return 2015082511520710001
	 */
	@SuppressWarnings("unused")
	private String tradeNo() {
		String flowno = RandomStringUtils.randomNumeric(4);
		StringBuilder sb = new StringBuilder();
		sb.append(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
		sb.append(flowno);
		return sb.toString();
	}

	/***
	 * 得到充值信息
	 * 
	 * @param resInfo
	 * @return
	 */
	public String getNotifyInfo(String resInfo) {

		StringBuffer bf = new StringBuffer();
		Document document = null;
		try {
			document = DocumentHelper.parseText(resInfo);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		String returnCode = root.element("return_code").getText().toString();

		if (returnCode.equals("SUCCESS")) {
			bf.append("<xml><return_code><![CDATA[SUCCESS]]></return_code>");
			bf.append("<return_msg><![CDATA[OK]]></return_msg></xml>");
		}
		return bf.toString();
	}

	/***
	 * 查询用户的OpenId
	 * 
	 * @param userId
	 * @return
	 */
	public WxInvitationRelationBO getUserWxAuth(Long userId) {
		return this.wxInvitationRelationDao.getWxAuthInfo(userId);
	}

	/***
	 * 添加微信用户OpenId
	 * 
	 * @param openId
	 * @param userId
	 * @return
	 */
	public int saveWxAuthInfo(String openId, Long userId) {
		return this.wxInvitationRelationDao.saveWxAuthInfo(openId, userId);
	}

	/***
	 * 获取jsapi 的签名
	 * 
	 * timeStamp //当前的时间戳 prepay_id //统一下单接口返回的prepay_id参数值 nonceStr //随机串
	 * 
	 * @return paySign
	 * 
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public String getPaySign(String timeStamp, String prepay_id, String nonceStr) {

		Map map = new HashMap();
		map.put("signType", "MD5");
		map.put("appid", appid);
		map.put("timeStamp", timeStamp);
		map.put("package", prepay_id);
		map.put("nonceStr", nonceStr);

		List<String> keyList = new ArrayList<>();
		keyList.addAll(map.keySet());
		Collections.sort(keyList);

		String stringA = "";
		for (String key : keyList) {
			stringA += key + "=" + map.get(key) + "&";
		}
		String signStr = stringA.substring(0, stringA.length() - 1);

		String stringSignTemp = signStr + "&key=" + appKey;

		System.out.println("JS获取签名的参数paySign--->" + stringSignTemp);

		String paySign = MD5.MD5Encode(stringSignTemp).toUpperCase();
		System.out.println("JSpaySign--->" + paySign);
		return paySign;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("signType", "MD5");
		map.put("appid", appid);
		map.put("timeStamp", "1414561699");
		map.put("package", "prepay_id=123456789");
		map.put("nonceStr", "5K8264ILTKCH16CQ25");
		List<String> keyList = new ArrayList<>();
		keyList.addAll(map.keySet());
		Collections.sort(keyList);
		String stringA = "";
		for (String key : keyList) {
			stringA += key + "=" + map.get(key) + "&";
		}
		String signStr = stringA.substring(0, stringA.length() - 1);

		String stringSignTemp = signStr + "&key=" + appKey;

		System.out.println("获取签名的参数paySign--->" + stringSignTemp);

		String paySign = MD5.MD5Encode(stringSignTemp).toUpperCase();
		System.out.println("paySign--->" + paySign);
	}

}
