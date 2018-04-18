package com.sinco.carnation.pay.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.dao.WxMsgLogDao;
import com.sinco.carnation.sys.model.WxMsgLog;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.StringUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Component
public class WxMpTools {

	private final Logger logger = Logger.getLogger(WxMpTools.class.getName());

	@Autowired
	private WxMsgLogDao wxMsgLogDao;

	@Autowired
	private SysConfigService configService;

	/**
	 * 初始化菜单
	 * 
	 * @param token
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean initMenue(String token, String menueData) {

//		StringBuilder sb = new StringBuilder();
//		sb.append(" { \"button\":[   ");
//		//sb.append(String.format("   {\"type\":\"click\",\"name\":\"我的二维码\",\"key\":\"%s\"},  ",WxMsgType.ButtonType.JG_MY_INVITATION));
//		sb.append(String.format("   {\"type\":\"view\",\"name\":\"我的推荐码\",\"url\":\"%s\"}  ",this.getMpRedirectUrl(url, "")));
//		sb.append("   ] }  ");

		try {

			String result = this.Post(WxAccountConfig.MENUE_CREATE_URL + "?access_token=" + token, menueData);

			WxMsgLog msgLog = new WxMsgLog();
			msgLog.setType("initMenue");
			msgLog.setContent(result);
			wxMsgLogDao.save(msgLog);

			Map map = JSON.parseObject(result, Map.class);
			if (map.get("errcode") == null || CommUtil.null2String(map.get("errcode")).equals("0")) {
				return true;

			} else {
				logger.info("初始化菜单结果返回 " + result);
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("初始化菜单异常" + CommUtil.getStackTrace(e));
			return false;
		}

	}

	/**
	 * 获取微信回调url 进入授权页面同意授权，获取code
	 * 
	 * @param jumpToUrl
	 * @param state
	 * @return
	 */
	public StringBuilder getMpRedirectUrl(String jumpToUrl, String state) {
		// 这里使用微信的回调使用oauth2获取openid
		StringBuilder redirectUrl = new StringBuilder("https://open.weixin.qq.com/connect/oauth2/authorize?");
		SysConfigBO config = configService.getSysConfig();
		// 微信会对授权链接做正则强匹配校验，如果链接的参数顺序不对，授权页面将无法正常访问
		redirectUrl.append(String.format("appid=%s", config.getWeixinAppId()));
		try {
			redirectUrl.append(String.format("&redirect_uri=%s", URLEncoder.encode(jumpToUrl, "UTF-8")));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		redirectUrl.append("&response_type=code");
		/**
		 * scope参数中的snsapi_base和snsapi_userinfo snsapi_base：仅能获取openId snsapi_userinfo:可以获取用户信息和UnionID
		 */
		redirectUrl.append("&scope=snsapi_userinfo");

		redirectUrl.append("&state=" + state);
		redirectUrl.append("&#wechat_redirect");
		return redirectUrl;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map getQrUrl(String token, String scene_id) {
		Map map = new HashMap<String, String>();

		String qrStr = String
				.format(" {\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\" }}}",
						scene_id);

		try {

			String result = this.Post(WxAccountConfig.QR_CODE_CREATE_URL + "?access_token=" + token, qrStr);

			WxMsgLog msgLog = new WxMsgLog();
			msgLog.setType("getQrUrl");
			msgLog.setContent(result);
			wxMsgLogDao.save(msgLog);

			Map mapJson = JSON.parseObject(result, Map.class);
			if (mapJson.get("errcode") == null || StringUtils.isEmpty(mapJson.get("errcode").toString())) {
				map.put("url", mapJson.get("url").toString());
				map.put("ticket", mapJson.get("ticket").toString());
				map.put("showUrl", WxAccountConfig.QR_CODE_SHOW + "?ticket="
						+ mapJson.get("ticket").toString());
			} else {
				logger.info("获取二维码错误结果返回 " + result);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取二维码错误结果异常" + CommUtil.getStackTrace(e));
		}
		return map;
	}

	@SuppressWarnings("deprecation")
	private String Post(String url, String body) throws Exception {
		final HttpClient httpClient = new HttpClient();
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);
		httpClient.getHttpConnectionManager().getParams().setSoTimeout(10 * 1000);

		final PostMethod method = new PostMethod(url);

		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		method.setRequestBody(body);

		String result = "";
		try {
			httpClient.executeMethod(method);
			result = new String(method.getResponseBody(), "UTF-8");
		} catch (final Exception e) {
			throw e;
		} finally {
			method.releaseConnection();
		}
		return result;
	}
}
