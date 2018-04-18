package vc.thinker.b2b2c.action.weChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinco.carnation.sys.service.SysConfigService;

/**
 * HS网页授权微信工具类
 * 
 * @author yuleijia
 * 
 */
@Component
public class WeChatTool {

	public static final Logger log = LoggerFactory.getLogger(WeChatTool.class);
	@Autowired
	private SysConfigService configService;
	/**
	 * 获取token地址
	 */
	public static final String req_WX_Access_Token = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid={0}&secret={1}&code={2}&grant_type=authorization_code";
	/**
	 * 拉取用户信息URL
	 */
	public static final String req_WX_GetUserInfo_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";
	/**
	 * 用户授权并获取code URL
	 */
	private static final String req_WXCode_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type={2}&scope={3}&state={4}#wechat_redirect";

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * 第一步：用户同意授权，获取code(弹出授权页面)
	 * 
	 * @param redirect_uri
	 *            授权后微信调用的回调地址
	 * @param state
	 *            重定向后会带上state参数
	 * @return
	 */
	public String get_WeChat_Code(String redirect_uri, String state) {
		Map<String, String> map = new HashMap<String, String>();
		// 公众号的唯一标识
		map.put("appid", this.getWeChatAppID());
		// 授权后重定向的回调链接地址
		map.put("redirect_uri", redirect_uri);
		// 返回类型
		map.put("response_type", "code");
		// 应用授权作用域:snsapi_userinfo = 弹出授权页面
		map.put("scope", "snsapi_userinfo");
		// 任意参数值
		map.put("state", state == null ? sdf.format(new Date()) : state);
		String result_URL = MessageFormat.format(req_WXCode_URL, map.get("appid"), map.get("redirect_uri"),
				map.get("response_type"), map.get("scope"), map.get("state"));
		log.debug("<<<<<<<<< get_WeChat_Code URL -> " + result_URL);
		return result_URL;
	}

	/**
	 * 第二步：通过code换取网页授权access_token(接口调用凭证)
	 * 
	 * @param code
	 *            回调获取的code参数
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	public WCAccessTokenBO getAccessToken(String code) throws Exception {
		JSONObject json = null;
		/**
		 * 获取Access_token接口 appid=公众号的唯一标识 secret=公众号的appsecret
		 */
		String reqURL = this.get_Request_WXAccess_token(this.getWeChatAppID(), this.getWeChatAppSecret(),
				code);
		// 发送请求
		String res_Conent = this.getHttpContent(reqURL, "UTF-8", null);
		log.debug("===================== get weChat access_token result content -> " + res_Conent);
		json = JSONObject.fromObject(res_Conent);
		log.debug("===================== json toString ->" + json.toString());
		if (json.containsKey("errcode")) {
			throw new Exception("获取微信access_token失败【" + json.toString() + "】");
		}
		WCAccessTokenBO accessToken = new WCAccessTokenBO();
		accessToken.setAccessToken(json.getString("access_token"));
		accessToken.setExpiresIn(json.getString("expires_in"));
		accessToken.setOpenid(json.getString("refresh_token"));
		accessToken.setRefreshToken(json.getString("openid"));
		accessToken.setScope(json.getString("scope"));
		accessToken.setUnionid(json.getString("unionid"));
		return accessToken;
	}

	/**
	 * 第三步：拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param accessToken
	 *            WCAccessTokenBO
	 * @return
	 * @throws Exception
	 */
	public WCUserInfoBO getWCUserInfo(WCAccessTokenBO accessToken) throws Exception {
		WCUserInfoBO userInfo = null;
		if (accessToken != null) {

			// 请求获取用户信息URL
			String reqURL = this.get_Request_UserInfo(accessToken.getAccessToken(), accessToken.getOpenid());
			// 获取返回数据
			String userInfoContent = getHttpContent(reqURL, "UTF-8", null);
			log.debug("<<<<<<<<<<<<<<<< WCUserInfo -> " + userInfoContent);
			JSONObject userInfo_Json = JSONObject.fromObject(userInfoContent);
			if (!userInfo_Json.containsKey("errcode")) {
				throw new Exception("获取用户信息失败");
			}
			userInfo = new WCUserInfoBO();
			userInfo.setOpenid(userInfo_Json.getString("openid"));
			userInfo.setNickName(userInfo_Json.getString("nickname"));
			userInfo.setSex(userInfo_Json.getString("sex"));
			userInfo.setProvince(userInfo_Json.getString("province"));
			userInfo.setCity(userInfo_Json.getString("city"));
			userInfo.setCountry(userInfo_Json.getString("country"));
			userInfo.setHeadimgurl(userInfo_Json.getString("headimgurl"));
			userInfo.setPrivilege(userInfo_Json.getString("privilege"));
			userInfo.setUnionid(userInfo_Json.getString("unionid"));
		} else {
			throw new Exception("accessToken is null");
		}
		return userInfo;
	}

	/**
	 * 获取微信AppID(应用ID)
	 * 
	 * @return
	 */
	public String getWeChatAppID() {
		return this.configService.getSysConfig().getWeixinAppId().trim();
	}

	/**
	 * 获取微信AppSecret(应用密钥)
	 * 
	 * @return
	 */
	public String getWeChatAppSecret() {
		return this.configService.getSysConfig().getWeixinAppSecret().trim();
	}

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	public String get_Request_WXAccess_token(String appid, String secret, String code) {
		String result_URL = MessageFormat.format(req_WX_Access_Token, appid, secret, code);
		log.debug("<<<<<<<<<<<<<<<Get Token URL -> " + result_URL);
		return result_URL;
	}

	/**
	 * 生成获取用户信息URL
	 * 
	 * @param paramMap
	 * @return
	 */
	public String get_Request_UserInfo(String access_token, String openID) {
		String result_URL = MessageFormat.format(req_WX_GetUserInfo_URL, access_token, openID);
		log.debug("<<<<<<<<<<<<<<< Get UserInfo URL -> " + result_URL);
		return result_URL;
	}

	/**
	 * 模拟http访问，返回相关数据
	 * 
	 * @param url
	 *            请求地址
	 * @param charSet
	 *            编码
	 * @param method
	 *            请求方法
	 * @return
	 */
	private static String getHttpContent(String url, String charSet, String method) {
		HttpURLConnection connection = null;
		String content = "";
		if (method == null || method.trim().length() == 0) {
			method = "GET";
		}
		try {
			URL address_url = new URL(url);
			connection = (HttpURLConnection) address_url.openConnection();
			connection.setRequestMethod(method);
			// 设置访问超时时间及读取网页流的超时时间,毫秒值
			connection.setConnectTimeout(1000000);
			connection.setReadTimeout(1000000);
			// 得到访问页面的返回值
			int response_code = connection.getResponseCode();
			if (response_code == HttpURLConnection.HTTP_OK) {
				InputStream in = connection.getInputStream();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, charSet));
				String line = null;
				while ((line = reader.readLine()) != null) {
					content += line;
				}
				return content;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
		return "";
	}
}
