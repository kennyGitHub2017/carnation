package com.sinco.carnation.pay.tools;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.biz.utils.RedisCacheUtils;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dic.client.util.WebUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Component
public class WxShareTools {

	@Autowired
	private SysConfigService configService;
	
	Logger logger = Logger.getLogger("WxShareTools");

	// web
	public ModelAndView wxShareMv(ModelAndView mv, HttpServletRequest request) {

		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();
		currentUrl.append(url);
		if (StringUtils.isNotBlank(request.getQueryString())) {
			currentUrl.append("?" + request.getQueryString());
		}

		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken();
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());
		// 将界面说需要的参数返回
		mv.addObject("appId", configService.getSysConfig().getWeixinAppId());
		mv.addObject("nonceStr", signatureMap.get("nonceStr"));
		mv.addObject("timestamp", signatureMap.get("timestamp"));
		mv.addObject("signature", signatureMap.get("signature"));
		mv.addObject("url", url);

		mv.addObject("token", token);
		mv.addObject("ticket", ticket);
		mv.addObject("currentUrl", currentUrl);
		return mv;
	}

	// App
	public Model wxShareModel(Model model, HttpServletRequest request, String apiPath) {
		// 获取带参数的Url
		StringBuilder currentUrl = new StringBuilder();
		String url = request.getRequestURL().toString();

		if(apiPath.indexOf("/carnation-apis-resource") >= 0 && url.indexOf("/carnation-apis-resource") >= 0){
				String str[] = apiPath.split("/carnation-apis-resource");
				apiPath = str[0];
		}
		currentUrl.append(apiPath + request.getRequestURI());
		if (StringUtils.isNotBlank(request.getQueryString())) {
			currentUrl.append("?" + request.getQueryString());
		}

		// currentUrl = new
		// StringBuilder("http://www.libt.cn/weixin/index.html");
		// 获取签名验证及前端说需要的参数
		String token = getToken();
		String ticket = getTicken(token);
		Map<String, String> signatureMap = sign(ticket, currentUrl.toString());

		// 将界面说需要的参数返回
		model.addAttribute("appId", configService.getSysConfig().getWeixinAppId());
		model.addAttribute("nonceStr", signatureMap.get("nonceStr"));
		model.addAttribute("timestamp", signatureMap.get("timestamp"));
		model.addAttribute("signature", signatureMap.get("signature"));
		model.addAttribute("url", url);

		model.addAttribute("token", token);
		model.addAttribute("ticket", ticket);
		model.addAttribute("currentUrl", currentUrl.toString());
		return model;
	}

	@Resource(name = "bizCacheUtils")
	private RedisCacheUtils cacheUtils;

	/**
	 * 获取token
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public synchronized String getToken() {
		String token = "";
		if (StringUtils.isNotEmpty(token)) {
			// 验证token
			return token;
		}

		Map<String, String> params = Maps.newHashMap();
		params.put("grant_type", "client_credential");

		SysConfigBO sysBo = configService.getSysConfig();
		params.put("appid", sysBo.getWeixinAppId());
		params.put("secret", sysBo.getWeixinAppSecret());

		String getTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
		try {
			String jsonStr = WebUtils.doGet(getTokenUrl, params);
			// {"access_token":"xxx","expires_in":7200}
			// {"errcode":40125,"errmsg":"invalid appsecret, view more at
			Map map = JSON.parseObject(jsonStr, Map.class);
			if (map.get("errcode") == null || StringUtils.isBlank(map.get("errcode").toString())) {
				token = map.get("access_token").toString();
				
				if (StringUtils.isNotEmpty(token)) {
					//cacheUtils.set("WX_MP_ACCESSTOKEN", token, 20 * 60);
				}
				
			} else {
				logger.info("获取Token错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取Token异常" + CommUtil.getStackTrace(e));
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
		string1 = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str + "&timestamp=" + timestamp + "&url=" + url;
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
}
