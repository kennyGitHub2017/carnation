package com.sinco.carnation.pay.tools;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.common.utils.StringUtils;
import com.sinco.dic.client.util.WebUtils;

import vc.thinker.b2b2c.core.tools.CommUtil;

@Component
public class WxPayTools {

	private final String WX_ACCESSTOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token";

	private final String WX_GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo";

	private final Logger logger = Logger.getLogger("WxPayTools");

	@Autowired
	private SysConfigService configService;

	/**
	 * 获取token
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	public String getOpenId(String code) {
		String openId = "";
		Map<String, String> map = getAccesssTokenMap(code);
		if (map != null) {
			openId = map.get("openid");
		}
		return openId;
	}

	/**
	 * 获取accesss_token,如果错误返回空
	 * 
	 * @param appId
	 * @param secret
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, String> getAccesssTokenMap(String code) {

		Map<String, String> map = null;
		// 获取openid
		// "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
		Map<String, String> params = Maps.newHashMap();
		// 通过code换取网页授权access_token
		SysConfigBO sysBo = configService.getSysConfig();
		params.put("appid", sysBo.getWeixinAppId());
		params.put("secret", sysBo.getWeixinAppSecret());
		params.put("code", code);
		params.put("grant_type", "authorization_code");

		try {
			String jsonStr = WebUtils.doGet(WX_ACCESSTOKEN_URL, params);
			Map mapJson = JSON.parseObject(jsonStr, Map.class);
			if (mapJson.get("errcode") == null || StringUtils.isBlank(mapJson.get("errcode").toString())) {
				map = new HashMap<String, String>();
				map.put("openid", mapJson.get("openid").toString());
				map.put("access_token", mapJson.get("access_token").toString());
			} else {
				logger.info("获取openId错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取openId异常" + CommUtil.getStackTrace(e));
		}
		return map;
	}

	/**
	 * 获取微信用户信息
	 * 
	 * @param access_token
	 * @param openId
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String, String> getWxUserInfoMap(String access_token, String openId) {

		Map<String, String> map = null;
		// 获取微信用户信息
		// https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN
		Map<String, String> params = Maps.newHashMap();
		params.put("access_token", access_token);
		params.put("openid", openId);
		params.put("lang", "zh_CN");

		/*
		 * openid 用户的唯一标识 nickname 用户昵称 sex 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
		 * province 用户个人资料填写的省份 city 普通用户个人资料填写的城市 country 国家，如中国为CN headimgurl
		 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
		 * 。若用户更换头像，原有头像URL将失效。 privilege 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
		 * unionid 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。详见：获取用户个人信息（UnionID机制）
		 */

		try {
			String jsonStr = WebUtils.doGet(WX_GET_USER_INFO_URL, params);
			Map mapJson = JSON.parseObject(jsonStr, Map.class);
			if (mapJson.get("errcode") == null || StringUtils.isBlank(mapJson.get("errcode").toString())) {
				map = new HashMap<String, String>();
				map.put("nickname", mapJson.get("nickname").toString());
				map.put("sex", mapJson.get("sex").toString());
				map.put("province", mapJson.get("province").toString());
				map.put("city", mapJson.get("city").toString());
				map.put("headimgurl", mapJson.get("headimgurl").toString());
				map.put("unionid", mapJson.get("unionid").toString());
			} else {
				logger.info("获取 获取微信用户信息错误" + jsonStr);
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.info("获取 获取微信用户信息异常" + CommUtil.getStackTrace(e));
		}
		return map;
	}

}
