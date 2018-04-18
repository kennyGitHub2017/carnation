package com.sinco.carnation.sys.tools;

import java.io.IOException;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import com.sinco.dic.client.util.WebUtils;

@Component
public class WxshareTools {

	// 通用日志记录
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * CN
	 */
//	String _appId = "wx85e9b7005754ba18";
//	String _appSecret = "d1ba1e149987d109eb92f87bc5e09cc0";

	/**
	 * COM
	 */
	String _appId = "wx9d38abce10c26432";
	String _appSecret = "ff29a5f99cc707ae720c0d210ab666f6";

	/**
	 * 输出json
	 * 
	 * @param response
	 * @param msg
	 */
	@SuppressWarnings("unused")
	private void writeJson(HttpServletResponse response, Map<String, String> msg) {
		/************ 以下是解决避免ie下载文件 *************/
		// response.reset(); //重置浏览器头信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(objectMapper.writeValueAsString(msg));
			writer.flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					logger.error("", e);
				}
			}
		}
	}

	public ModelAndView wxShareMv(ModelAndView mv, HttpServletRequest request) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();
		currentUrl.append(url);
		if (StringUtils.isNotBlank(request.getQueryString())) {
			int sub = url.indexOf("?");
			if (sub >= 0) {
				currentUrl.append("&" + request.getQueryString());
			} else {
				currentUrl.append("?" + request.getQueryString());
			}
		}

		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken(_appId, _appSecret);
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// String path = request.getSession().getServletContext().getRealPath("/");

		// 将界面说需要的参数返回
		mv.addObject("appId", _appId);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", "/wx_act/index.htm?invitationCode=" + getInvitationCode(request));// url

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	public ModelAndView wxShareMvV2(ModelAndView mv, HttpServletRequest request) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();
		String parameter = request.getQueryString();

		currentUrl.append(url);
		if (StringUtils.isNotBlank(parameter)) {
			if (request.getQueryString().indexOf("id=") >= 0) {
				String str[] = parameter.split("id=");
				if (str[1].indexOf("&") >= 0) {
					str[1] = str[1].split("&")[0];
				}
				String strUrl[] = url.split(".htm");
				url = strUrl[0] + "_" + str[1] + ".htm";
				char[] cStr = (strUrl[0] + "_" + str[1] + ".htm").toCharArray();
				currentUrl.delete(0, currentUrl.length());
				currentUrl.append(cStr);

				String[] parameters = parameter.split("id=" + str[1]);
				System.out.println(parameters.length);
				if (parameters.length > 1) {
					parameter = parameters[0] + parameters[1];
				}
				Map<String, String> map = URLRequest(parameter);
				if (null != map) {
					parameter = "";
					for (Map.Entry<String, String> entry : map.entrySet()) {
						System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
						if (!entry.getKey().equals("id")) {
							parameter = parameter + entry.getKey() + "=" + entry.getValue() + "&";
						}
					}
					if (parameter.indexOf("&") == parameter.length()) {
						parameter = parameter.substring(parameter.length() - 1, parameter.length());
					}
				}
			}
			int sub = url.indexOf("?");
			if (sub >= 0) {
				currentUrl.append("&" + parameter);
			} else {
				if (parameter.indexOf("&") == 0) {
					parameter = parameter.substring(1);
				}
				currentUrl.append("?" + parameter);
			}
		}
		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken(_appId, _appSecret);
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// String path = request.getSession().getServletContext().getRealPath("/");

		// 将界面说需要的参数返回
		mv.addObject("appId", _appId);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", "/wx_act/index.htm?invitationCode=" + getInvitationCode(request));// url

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	public ModelAndView wxShareMvV3(ModelAndView mv, HttpServletRequest request, String url) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		if(url==null){
			url = request.getRequestURL().toString();
		}
		currentUrl.append(url);
/*		if (StringUtils.isNotBlank(request.getQueryString())) {
			int sub = url.indexOf("?");
			if (sub >= 0) {
				currentUrl.append("&" + request.getQueryString());
			} else {
				currentUrl.append("?" + request.getQueryString());
			}
		}*/
		System.out.println("[wxshare]"+currentUrl);
		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken(_appId, _appSecret);
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// String path = request.getSession().getServletContext().getRealPath("/");

		// 将界面说需要的参数返回
		mv.addObject("appId", _appId);
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", "/wx_act/index.htm?invitationCode=" + getInvitationCode(request));// url

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	/**
	 * 解析出url参数中的键值对 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
	 * 
	 * @param URL
	 *            url地址
	 * @return url请求参数部分
	 */
	public static Map<String, String> URLRequest(String parameter) {
		Map<String, String> mapRequest = new HashMap<String, String>();
		String[] arrSplit = null;

		if (parameter == null) {
			return mapRequest;
		}
		// 每个键值为一组
		arrSplit = parameter.split("[&]");
		for (String strSplit : arrSplit) {
			String[] arrSplitEqual = null;
			arrSplitEqual = strSplit.split("[=]");

			// 解析出键值
			if (arrSplitEqual.length > 1) {
				// 正确解析
				mapRequest.put(arrSplitEqual[0], arrSplitEqual[1]);

			} else {
				if (arrSplitEqual[0] != "") {
					// 只有参数没有值，不加入
					mapRequest.put(arrSplitEqual[0], "");
				}
			}
		}
		return mapRequest;
	}

	/**
	 * 获取token
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getToken(String appId, String secret) {
		String token = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("grant_type", "client_credential");
		params.put("appid", _appId);
		params.put("secret", _appSecret);

		String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			String jsonStr = WebUtils.doGet(getTokenUrl, params);
			// {"access_token":"xxx","expires_in":7200}
			// {"errcode":40125,"errmsg":"invalid appsecret, view more at
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || StringUtils.isBlank(map.get("errcode").toString())) {
				token = map.get("access_token").toString();
			} else {
				logger.info("获取Token错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取Token异常" + e.getMessage());
		}
		return token;

	}

	/**
	 * 获取token
	 * 
	 * @param token
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private String getTicken(String token) {
		String ticket = "";

		Map<String, String> params = Maps.newHashMap();
		params.put("access_token", token);
		params.put("type", "jsapi");
		String getTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		try {
			String jsonStr = WebUtils.doGet(getTicketUrl, params);
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || map.get("errcode").toString().equals("0")) {
				ticket = map.get("ticket").toString();
			} else {
				logger.info("获取ticket错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取ticket异常" + e.getMessage());
		}
		return ticket;
	}

	/**
	 * 获取加密签名
	 * 
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 */
	private Map<String, String> sign(String jsapi_ticket, String url) {
		Map<String, String> ret = new HashMap<String, String>();
		String nonce_str = create_nonce_str();
		String timestamp = create_timestamp();
		String string1;
		String signature = "";

		// 注意这里参数名必须全部小写，且必须有序
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp
				+ "&url=" + url;
		System.out.println(string1);

		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(string1.getBytes("UTF-8"));
			signature = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		ret.put("url", url);
		ret.put("jsapi_ticket", jsapi_ticket);
		ret.put("nonceStr", nonce_str);
		ret.put("timestamp", timestamp);
		ret.put("signature", signature);

		return ret;
	}

	/**
	 * 转为16禁止
	 * 
	 * @param hash
	 * @return
	 */
	private String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

	/**
	 * @return
	 */
	private String create_nonce_str() {
		return UUID.randomUUID().toString();
	}

	/**
	 * @return
	 */
	private String create_timestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 邀请码
	 * 
	 * @param request
	 * @return
	 */
	private String getInvitationCode(HttpServletRequest request) {
		return request.getParameter("invitationCode");
	}

}
