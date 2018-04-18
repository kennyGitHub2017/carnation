package com.sinco.carnation.resource.web.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * 第三方登录用户验证(微信/QQ、微博)
 * 
 * @author king
 * 
 */
public class TokenAuthUtils {

	// 微信用户基本信息接口
	private final static String WEIXIN_USER_INFO = "https://api.weixin.qq.com/sns/userinfo";
	private final static String WEIBO_USER_INFO = "https://api.weibo.com/oauth2/get_token_info";
	private final static String QQ_USER_INFO = "https://graph.qq.com/oauth2.0/me";

	/**
	 * 微博 根据用户ID获取用户信息 请求参数：access_token&&(uid||screen_name) return:json
	 */
	private final static String WEIBO_USER_SHOW = "https://api.weibo.com/2/users/show.json";
	/**
	 * QQ 根据用户ID获取用户信息 请求参数：access_token&&oauth_consumer_key&&openid return:json
	 */
	private final static String QQ_USER_SHOW = "https://graph.qq.com/user/get_simple_userinfo";
	private final static String OAUTH_CONSUMER_KEK = "1105487225";
	//
	// callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );

	String reString = "\"openid\":\"(.+?)\"";

	/**
	 * 验证用户是否属于微信平台
	 * 
	 * @return
	 */
	public static boolean getWeixin_Userinfo(String token, String openId) {
		try {
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("access_token", token);
			params1.put("openid", openId);
			params1.put("lang", "zh_CN");
			// 获取用户信息
			String info = HttpKit.get(WEIXIN_USER_INFO, params1);
			String p_openoid = regularOpenId(info);
			if (openId.equals(p_openoid))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 验证用户是否属于微信平台2
	 * 
	 * @return
	 */
	public static boolean getWeixin_Userinfo2(String token, String openId) {
		try {
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("access_token", token);
			params1.put("openid", openId);
			params1.put("lang", "zh_CN");
			// 获取用户信息
			String info = HttpKit.get(WEIXIN_USER_INFO, params1);
			String unionid = null;
			Pattern pattern = Pattern.compile("\"unionid\":\"(.+?)\"");
			Matcher matcher = pattern.matcher(info);
			if (matcher.find()) {
				unionid = matcher.group(1);
			}
			if (openId.equals(unionid))
				return true;
			else
				return false;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 验证用户是否属于微博平台
	 * 
	 * @return
	 */
	public static boolean getWeibo_UserInfo(String token, String uid) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("access_token", token);
			// 获取用户信息
			String info = HttpKit.weiboPost(WEIBO_USER_INFO, token);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(info);
			String n_uid = node.get("uid").toString();
			if (uid.equals(n_uid)) {
				return true;
			}
			return false;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 验证用户是否属于QQ平台
	 * 
	 * @return
	 */
	public static boolean getQQ_UserInfo(String token, String uid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("access_token", token);
		// 获取用户信息
		String info = HttpKit.get(QQ_USER_INFO, params);
		// 获取openid
		String openId = qqOpenId(info);
		if (StringUtils.isNotBlank(openId) && uid.equals(openId)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取openid
	 * 
	 * @param json
	 * @return
	 */
	public static String regularOpenId(String json) {
		Pattern pattern = Pattern.compile("\"openid\":\"(.+?)\"");
		Matcher matcher = pattern.matcher(json);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	public static String qqOpenId(String json) {
		Pattern pattern = Pattern.compile("\"openid\":\"(.+?)\"");
		Matcher matcher = pattern.matcher(json);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	/**
	 * 获取微信用户昵称
	 * 
	 * @return String 用户昵称
	 */
	public static String getWeixin_UserNickName(String token, String openId) {
		try {
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("access_token", token);
			params1.put("openid", openId);
			params1.put("lang", "zh_CN");
			// 获取用户信息
			String info = HttpKit.get(WEIXIN_USER_INFO, params1);
			String nickName = null;
			Pattern pattern = Pattern.compile("\"nickname\":\"(.+?)\"");
			Matcher matcher = pattern.matcher(info);
			if (matcher.find()) {
				nickName = matcher.group(1);
			}
			return nickName;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 获取微博用户昵称
	 * 
	 * @param token
	 * @param uid
	 * @return String 用户昵称
	 */
	public static String getWeibo_UserNickName(String token, String uid) {
		try {
			Map<String, String> params1 = new HashMap<String, String>();
			params1.put("access_token", token);
			params1.put("uid", uid);
			// 获取用户信息
			String info = HttpKit.get(WEIBO_USER_SHOW, params1);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(info);
			String nickName = node.get("screen_name").toString();
			return nickName;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取QQ用户昵称 access_token token oauth_consumer_key appid openid openid
	 * 
	 * @return String 用户昵称
	 */
	public static String getQQ_UserNickName(String token, String openid) {
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("access_token", token);
			params.put("oauth_consumer_key", OAUTH_CONSUMER_KEK);
			params.put("openid", openid);
			String info = HttpKit.get(QQ_USER_SHOW, params);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(info);
			String nickname = node.get("nickname").toString();
			return nickname;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		// String str = TokenAuthUtils.getAccessToken();
		// System.out.println(str);
		// // System.out.println(TokenAuthUtils.getAccessToken());
		// Pattern pattern = Pattern.compile("\"access_token\":\"(.+?)\"");
		// Matcher matcher = pattern.matcher(str);
		// if (matcher.find()) {
		// System.out.println(matcher.group(1));
		// }

		// System.out.println(TokenAuthUtils.getUserinfo(
		// "OezXcEiiBSKSxW0eoylIeLFshmg0GuLyxrDD1S7qMQHBKXrHBVcS0xEiIYBtgn-rl6dQYkyIijZX6wsJ8VLnDmLwfmN98qM3xT4DN3w1Jxlltcqt7wB8QcEE5AYPqjSUBFfqbEUy9ffnBQ2tUiTd8g",
		// "oGIrss8TPAT5yy7eeWTVN5S1gYko"));
		String token = "4kseiuoMLErvVneuoboaFUEc2R29zqS8Vlr75oKRc1AeCBaaYcVSdU6OG2yUbUgpfG6Ti6__3RCtCER1ufOvPP2bGBREz8V8u84HkUnKSF8";
		String openid = "oS6yovz2uig5fr9SKivsQ8-VVJU4";
		System.out.println(TokenAuthUtils.getWeixin_UserNickName(token, openid));

	}
}
