package vc.thinker.b2b2c.action.weChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.service.WeChatService;
import com.sinco.common.utils.IPUtil;
import com.sun.jersey.core.util.Base64;

/**
 * 微信授权登陆
 * 
 * @author yuleijia 2016.09.02
 */
@Controller
public class WeChatLoginAction {

	@Autowired
	private WeChatService weChatService;

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserRelationService userRelationService;

	@Autowired
	private WeChatTool weChatTool;

	@Autowired
	private UserCustomerService customerService;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**/
	@RequestMapping(value = "wx/login_test.htm")
	public ModelAndView login_test(HttpServletRequest request, HttpServletResponse response, String userName,
			String password) {
		userName = "oS6yov3Y7jWE9I0KQ5ps_Jm1cxyM";
		password = "89e6a3538573e835357d6119ec3e2ed46f460ea563a24f1fad7b3106";
		request.getSession().setAttribute("verify_code", "");
		return this.login(userName, password);
	}

	/**
	 * 微信授权登陆
	 * 
	 * @param request
	 * @param ref
	 * @return
	 */
	@RequestMapping(value = "/weChat.htm", method = RequestMethod.GET)
	public ModelAndView weChat_Login02(HttpServletRequest request) {
		log.info("//////////////// 微信授权登陆 ///////////////////////");
		ModelAndView mv = new ModelAndView("redirect:/wx/getCode");
		return mv;
	}

	/**
	 * 微信授权登陆
	 * 
	 * @param request
	 * @param ref
	 * @return
	 */
	@RequestMapping(value = "/weChatUrl.htm", method = RequestMethod.GET)
	public ModelAndView weChat_LoginUrl(HttpServletRequest request) {
		String url = request.getParameter("url");
		String invitationCode = request.getParameter("invitationCode");
		String loginIs = request.getParameter("login"); // 是否需要登录
		log.info("//////////////// 微信授权登陆 ///////////////////////");
		ModelAndView mv = new ModelAndView("redirect:/wx/getPublicCode");
		mv.addObject("url", url);
		mv.addObject("invitationCode", invitationCode);
		if (loginIs != null && loginIs.trim().length() > 0 && loginIs.equals("0")) {
			mv.addObject("login", "0");
		}
		return mv;
	}

	/**
	 * 引导用户进入授权页面同意授权，获取code
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/wx/getCode", method = RequestMethod.GET)
	public ModelAndView getWXCode(HttpServletRequest request) {
		log.info("///////////////// 同意授权页面获取Code ///////////////////");
		/*获取域名*/
		String domainName = this.getDomainName(request);
		log.debug("...... domainName=" + domainName);
		String redirect_uri = domainName + "mp/wx/redirect.htm"; // 回调地址
		log.debug("...... redirect_uri:" + redirect_uri);
		try {
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
		} catch (UnsupportedEncodingException e) {

			log.error(e.getMessage());
		}
		Map<String, String> map = new HashMap<String, String>();
		String reqWXCodeURL = this.weChatTool.get_WeChat_Code(redirect_uri, null);
		log.debug("......reqWXCodeURL:" + reqWXCodeURL);
		ModelAndView mv = new ModelAndView("redirect:" + reqWXCodeURL);
		return mv;
	}

	/***
	 * lao shi
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/wx/getPublicCode", method = RequestMethod.GET)
	public ModelAndView getPublicCode(HttpServletRequest request) {
		log.info("///////////////// 同意授权页面获取Code ///////////////////");

		String invitationCode = request.getParameter("invitationCode") == null ? "" : request
				.getParameter("invitationCode");
		/*获取域名*/
		String domainName = this.getDomainName(request);
		String p_redirect_uri = request.getParameter("url");

		System.out.println("p_redirect_uri -test:" + p_redirect_uri);
		System.out.println("invitationCode -test:" + invitationCode);
		// String redirect_uri = domainName +p_redirect_uri; //回调地址
		String redirect_uri = domainName + "mp/wx/redirect_url.htm?url=" + p_redirect_uri; // 回调地址
		// 系统需要执行登录操作判断
		String loginIs = request.getParameter("login");
		if (loginIs != null && loginIs.trim().length() > 0 && loginIs.equals("0")) {
			redirect_uri += "&login=0";
			log.info("******* redirect_uri = " + redirect_uri);
			loginIs = "0";
		} else {
			loginIs = sdf.format(new Date());
		}
		try {
			redirect_uri = java.net.URLEncoder.encode(redirect_uri, "utf-8");
		} catch (UnsupportedEncodingException e) {

			log.error(e.getMessage());
		}

		Map<String, String> map = new HashMap<String, String>();
		// 公众号的唯一标识
		map.put("appid", this.weChatTool.getWeChatAppID());
		// 授权后重定向的回调链接地址
		map.put("redirect_uri", redirect_uri);
		// 返回类型
		map.put("response_type", "code");
		// 应用授权作用域:snsapi_userinfo = 弹出授权页面
		map.put("scope", "snsapi_userinfo");
		// 任意参数值
		map.put("state", loginIs); // sdf.format(new Date())
		map.put("invitationCode", invitationCode);
		map.put("url", p_redirect_uri);
		// 请求地址
		map.put("url", p_redirect_uri);
		String reqWXCodeURL = this.get_Request_WXCode_URL(map);

		log.info("......reqWXCodeURL:" + reqWXCodeURL);
		System.out.println("p_redirect_uri -test2:" + p_redirect_uri);
		ModelAndView mv = new ModelAndView("redirect:" + reqWXCodeURL);
		return mv;
	}

	/**
	 * 授权后重定向
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/mp/wx/redirect.htm", method = RequestMethod.GET)
	public ModelAndView do_WX_Redirect(HttpServletRequest request, HttpServletResponse response) {
		// ,@RequestParam("ref") String ref,@RequestParam("invitationCode") String invitationCode

		log.info("///////////////// 授权后重定向  ///////////////////");

		ModelAndView mv = new ModelAndView(
				"redirect:http://static.ysysgo.com/carnation-static/static/app/share_invite.html?"
						+ "invitationCode=124154&from=singlemessage&isappinstalled=0&isflag=false");

		String code = request.getParameter("code");
		// 若用户禁止授权，则重定向后不会带上code参数
		// 仅会带上state参数redirect_uri?state=STATE
		if (code == null || code.trim().length() == 0) {
			log.info(".....用户禁止授权");
			return mv;
		}
		log.info("<<<<<<< code:" + code);
		// 获取access_token参数Map
		Map<String, String> paramMap = new HashMap<String, String>();
		// 公众号的唯一标识
		paramMap.put("appid", this.weChatTool.getWeChatAppID());
		// 公众号的appsecret
		paramMap.put("secret", this.weChatTool.getWeChatAppSecret());
		// code参数
		paramMap.put("code", code);

		/* ***************** 获取access_token ******************  */

		// 请求地址
		String reqURL = this.get_Request_WXAccess_token(paramMap);
		log.info("....." + reqURL);
		// 发送请求
		String res_Conent = getHttpContent(reqURL, "UTF-8", null);

		log.info("....." + res_Conent);

		// 解析返回参数 获取access_token值
		JSONObject json = JSONObject.fromObject(res_Conent);

		if (!json.containsKey("errcode")) {
			// 网页授权接口调用凭证
			String access_token = json.getString("access_token");
			// 接口调用凭证超时时间，单位（秒）
			int expires_in = json.getInt("expires_in");
			// 用户刷新access_token
			String refresh_token = json.getString("refresh_token");
			// 用户唯一标识
			String openid = json.getString("openid");
			// 用户授权的作用域
			String scope = json.getString("scope");
			// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
			String unionid = "";
			if (json.containsKey("unionid")) {
				unionid = json.getString("unionid");
			}
			/* ****************** 判断用户是否已注册过  ****************** */
			UserAccountBO userAccountBO = this.weChatService.find_WXUnionid_Is_Registered(unionid);
			if (userAccountBO != null) // 已注册过
			{
				/* 系统为用户执行登陆操作   */
				String userName = userAccountBO.getLoginName();
				String password = userAccountBO.getPassword();
				request.getSession().setAttribute("verify_code", " ");
				// 授权后更新用户Openid,有遗留用户Openid为NULL
				UserAccount userAccount = new UserAccount();
				userAccount.setId(userAccountBO.getId());
				userAccount.setOpenId(openid);
				userAccountService.update(userAccount);
				// 补充个人用户信息
				// this.insertUserCustomer(userAccountBO.getId(), access_token, openid);
				return this.login(userName, password);
			}
			/* ****************** 未注册则拉取用户信息  注册用户 ****************** */
			paramMap.clear();
			paramMap.put("access_token", access_token);
			paramMap.put("openid", openid);
			// 请求地址 拉取用户信息
			String getUserInfoURL = this.get_Request_UserInfo(paramMap);
			// 获取返回数据
			String userInfoContent = getHttpContent(getUserInfoURL, "UTF-8", null);

			log.info("...." + userInfoContent);

			JSONObject userInfo_Json = JSONObject.fromObject(userInfoContent);
			if (!userInfo_Json.containsKey("errcode")) {
				// 用户的唯一标识
				String openid_ = userInfo_Json.getString("openid");
				// 用户昵称
				String nickName = userInfo_Json.getString("nickname");
				// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				String sex = userInfo_Json.getString("sex");
				// 用户个人资料填写的省份
				String province = userInfo_Json.getString("province");
				// 普通用户个人资料填写的城市
				String city = userInfo_Json.getString("city");
				// 国家，如中国为CN
				String country = userInfo_Json.getString("country");
				// 用户头像
				String headimgurl = userInfo_Json.getString("headimgurl");
				// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
				String unionid_ = "";
				if (userInfo_Json.containsKey("unionid")) {
					unionid_ = json.getString("unionid");
				}

				// 用户特权信息，json 数组
				// 暂时不用 JSONArray jsonArray = userInfo_Json.getJSONArray("privilege");
				String invitationCode = null;
				/*String ref = request.getParameter("ref").trim();
				
				System.out.println("邀请码invitationCode----------------------->"+invitationCode);
				System.out.println("ref--------------------------------------->"+ref);*/

				paramMap.clear();
				paramMap.put("openid", openid_);
				paramMap.put("nickName", nickName);
				paramMap.put("sex", sex);
				paramMap.put("province", province);
				paramMap.put("city", city);
				paramMap.put("country", country);
				paramMap.put("headimgurl", headimgurl);
				paramMap.put("unionid_", unionid_);
				paramMap.put("invitationCode", invitationCode);
				paramMap.put("requestIp", IPUtil.getIpAddr(request));

				log.info("................ registerUser params:" + paramMap.toString());

				/**
				 * >>>>>>>>用户注册<<<<<<<
				 */
				UserAccount userAccount = this.weChatService.weChat_RegisterUser(paramMap);
				/**
				 * >>>>>>>> 登陆认证操作 <<<<<<<
				 */
				String userName = userAccount.getLoginName();
				String password = userAccount.getPassword();

				log.info(".........login userName=" + userName + " password=" + password);

				/*mv = new ModelAndView("redirect:/weChatRegisterSuccess.htm");
				String pwd =Globals.THIRD_ACCOUNT_LOGIN+password;
				mv.addObject("username", CommUtil.encode(userName));
				mv.addObject("password",pwd);
				mv.addObject("code", "ae937fd9ae2211e58c06001e67cd90fd");
				mv.addObject("encode", true);*/
				return this.login(userName, password);
			} else {
				log.info("......openid无效  " + json.getString("errmsg"));
			}
		} else {
			log.info(".........Code无效错误  " + json.getString("errmsg"));
		}
		return mv;
	}

	/**
	 * lao shi 授权后重定向
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "mp/wx/redirect_url.htm", method = RequestMethod.GET)
	public ModelAndView do_WX_Redirect_Url(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		// ,@RequestParam("ref") String ref,@RequestParam("invitationCode") String invitationCode
		String tempInvitationCode = "";
		log.info("///////////////// 授权后重定向  ///////////////////");
		// -------2017-09-11处理页面钓鱼bug START------------
		String url = request.getParameter("url").replace("'", "").replace(" ", "");
		// -------2017-09-11处理页面钓鱼bug END------------
		url = new String(Base64.decode(url));
		String redirectUrl = "";
		// 健全程序 防止有未带&跳转地址
//		if(url.indexOf("&")>=-1)
//		{
//			redirectUrl = url+"&isflag=false";
//		}
//		else
//		{
//			redirectUrl = url+"?isflag=false";
//		}
		if (url.indexOf("?") > 0) {
			url += "&isflag=1";
			redirectUrl = url + "&isflag=false";
		} else {
			url += "?isflag=1";
			redirectUrl = url + "?isflag=false";
		}
		log.info("******** redirectUrl->" + redirectUrl);

		tempInvitationCode = url.substring(url.lastIndexOf("invitationCode") + "invitationCode".length() + 1);

		if (tempInvitationCode.indexOf("&") > -1) {
			tempInvitationCode = tempInvitationCode.substring(0, tempInvitationCode.indexOf("&"));
		}
		// url = url.replace("*", "&");
		// url= URLDecoder.decode(url,"UTF-8");

		ModelAndView mv = new ModelAndView("redirect:" + redirectUrl);

		String code = request.getParameter("code");
		System.out.println("code-test:" + code);
		System.out.println("tempInvitationCode-test:" + tempInvitationCode);

		String state = request.getParameter("state");

		log.debug("======= wc state->" + state);

		// 若用户禁止授权，则重定向后不会带上code参数
		// 仅会带上state参数redirect_uri?state=STATE
		if (code == null || code.trim().length() == 0) {
			log.info(".....用户禁止授权");
			mv.addObject("des", "用户禁止授权");
			return mv;
		}
		log.info("<<<<<<< code:" + code);
		// 获取access_token参数Map
		Map<String, String> paramMap = new HashMap<String, String>();
		// 公众号的唯一标识
		paramMap.put("appid", this.weChatTool.getWeChatAppID());
		// 公众号的appsecret
		paramMap.put("secret", this.weChatTool.getWeChatAppSecret());
		// code参数
		paramMap.put("code", code);

		/* ***************** 获取access_token ******************  */

		// 请求地址
		String reqURL = this.get_Request_WXAccess_token(paramMap);
		log.info("....." + reqURL);

		// 发送请求
		String res_Conent = getHttpContent(reqURL, "UTF-8", null);
		log.info("http request res_Conent:" + res_Conent);
		// session保存res_Conent access_token
		HttpSession session = request.getSession();

		log.info("....." + res_Conent);

		// 解析返回参数 获取access_token值
		JSONObject json = JSONObject.fromObject(res_Conent);

		// 当发现有错误时，使用session中res_Conent access_token
		if (session.getAttribute("res_Conent") != null && json.containsKey("errcode")) {
			log.info("use session res_Conent-----");
			res_Conent = (String) session.getAttribute("res_Conent");
			json = JSONObject.fromObject(res_Conent);
			log.info("use session res_Conent:" + session.getAttribute("res_Conent"));
		}

		if (!json.containsKey("errcode")) {

			session.setAttribute("res_Conent", res_Conent);
			log.info("containsKey errcode res_Conent:" + session.getAttribute("res_Conent"));

			// 网页授权接口调用凭证
			String access_token = json.getString("access_token");
			// 接口调用凭证超时时间，单位（秒）
			int expires_in = json.getInt("expires_in");
			// 用户刷新access_token
			String refresh_token = json.getString("refresh_token");
			// 用户唯一标识
			String openid = json.getString("openid");
			// 用户授权的作用域
			String scope = json.getString("scope");
			// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
			String unionid = "";
			if (json.containsKey("unionid")) {
				unionid = json.getString("unionid");
			}

			/* ****************** 判断用户是否已注册过  ****************** */
			UserAccountBO userAccountBO = this.weChatService.find_WXUnionid_Is_Registered(unionid);
			// add by yuleijia
			String login = state;
			boolean loginIs = (login != null && login.trim().length() > 0 && "0".equals(login));
			log.debug("*********** loginIs:" + loginIs);
			if (userAccountBO != null) // 已注册过
			{
				// 授权后更新用户Openid,有遗留用户Openid为NULL
				UserAccount userAccount = new UserAccount();
				userAccount.setId(userAccountBO.getId());
				userAccount.setOpenId(openid);
				userAccountService.update(userAccount);
				userRelationService.boundRelation(userAccountBO.getUid(), tempInvitationCode);
				// 补充个人用户信息
				// this.insertUserCustomer(userAccountBO.getId(), access_token, openid);
				// 是否需要系统登陆
				// add by yuleijia
				if (loginIs) {
					log.debug(" ==================== Sys Login Start ================= ");
					String userName = userAccountBO.getLoginName();
					String password = userAccountBO.getPassword();
					request.getSession().setAttribute("ref", url); // 跳转到指定界面
					request.getSession().setAttribute("verify_code", " ");
					return this.login(userName, password);
				}
				return mv;
			}
			/* ****************** 未注册则拉取用户信息  注册用户 ****************** */
			paramMap.clear();
			paramMap.put("access_token", access_token);
			paramMap.put("openid", openid);
			// 请求地址 拉取用户信息
			String getUserInfoURL = this.get_Request_UserInfo(paramMap);
			// 获取返回数据
			String userInfoContent = getHttpContent(getUserInfoURL, "UTF-8", null);

			log.info("...." + userInfoContent);

			JSONObject userInfo_Json = JSONObject.fromObject(userInfoContent);
			if (!userInfo_Json.containsKey("errcode")) {
				// 用户的唯一标识
				String openid_ = userInfo_Json.getString("openid");
				// 用户昵称
				String nickName = userInfo_Json.getString("nickname");
				// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				String sex = userInfo_Json.getString("sex");
				// 用户个人资料填写的省份
				String province = userInfo_Json.getString("province");
				// 普通用户个人资料填写的城市
				String city = userInfo_Json.getString("city");
				// 国家，如中国为CN
				String country = userInfo_Json.getString("country");
				// 用户头像
				String headimgurl = userInfo_Json.getString("headimgurl");
				// 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段
				String unionid_ = "";
				if (userInfo_Json.containsKey("unionid")) {
					unionid_ = json.getString("unionid");
				}

				// 用户特权信息，json 数组
				// 暂时不用 JSONArray jsonArray = userInfo_Json.getJSONArray("privilege");
				String invitationCode = tempInvitationCode;

				paramMap.clear();
				paramMap.put("openid", openid_);
				paramMap.put("nickName", nickName);
				paramMap.put("sex", sex);
				paramMap.put("province", province);
				paramMap.put("city", city);
				paramMap.put("country", country);
				paramMap.put("headimgurl", headimgurl);
				paramMap.put("unionid_", unionid_);
				paramMap.put("invitationCode", invitationCode);
				paramMap.put("requestIp", IPUtil.getIpAddr(request));

				log.info("................ registerUser params:" + paramMap.toString());

				/**
				 * >>>>>>>>用户注册<<<<<<<
				 */
				UserAccount userAccount = this.weChatService.weChat_RegisterUser(paramMap);
				// 是否需要系统登陆
				// add by yuleijia
				if (loginIs) {
					log.debug(" ==================== Sys Login Start ================= ");
					String userName = userAccount.getLoginName();
					String password = userAccount.getPassword();
					request.getSession().setAttribute("ref", url); // 跳转到指定界面
					request.getSession().setAttribute("verify_code", " ");
					return this.login(userName, password);
				}
				return mv;
			} else {
				log.info("......openid无效  " + json.getString("errmsg"));
			}
		} else {
			log.info(".........Code无效错误  " + json.getString("errmsg"));
		}
		return mv;
	}

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	private String get_Request_WXCode_URL(Map<String, String> paramMap) {
		String result_URL = "";
		if (paramMap != null) {
			log.info("<<<<<<<< " + paramMap.toString());

			result_URL = MessageFormat.format(req_WXCode_URL, paramMap.get("appid"),
					paramMap.get("redirect_uri"), paramMap.get("response_type"), paramMap.get("scope"),
					paramMap.get("state"));
		}
		return result_URL;
	}

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	private String get_Request_WXAccess_token(Map<String, String> paramMap) {
		String result_URL = "";
		if (paramMap != null) {
			log.info("<<<<<<<< " + paramMap.toString());
			result_URL = MessageFormat.format(req_WX_Access_Token, paramMap.get("appid"),
					paramMap.get("secret"), paramMap.get("code"));
		}
		return result_URL;
	}

	/**
	 * 生成用于获取access_token的Code的Url
	 * 
	 * @param paramMap
	 * @return
	 */
	private String get_Request_UserInfo(Map<String, String> paramMap) {
		String result_URL = "";
		if (paramMap != null) {
			log.info("<<<<<<<< " + paramMap.toString());
			result_URL = MessageFormat.format(req_WX_GetUserInfo_URL, paramMap.get("access_token"),
					paramMap.get("openid"));
		}
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

	/**
	 * 获取域名
	 * 
	 * @param request
	 * @return
	 */
	private String getDomainName(HttpServletRequest request) {
		int endIndex = request.getRequestURL().length() - request.getPathInfo().length() + 1;
		String domainName = request.getRequestURL().substring(0, endIndex);
		return domainName;
	}

	/**
	 * 系统提交登陆请求
	 * 
	 * @param userName_
	 * @param password_
	 * @return
	 */
	private ModelAndView login(String userName_, String password_) {
		log.info("================= user login ============= ");
		log.info("<<<<<<<<< userName->" + userName_ + " password->" + password_);
		/* 系统为用户执行登陆操作   */
		String userName = userName_;
		String password = password_;
		ModelAndView mv = new ModelAndView("redirect:/b2b2c_login.htm");
		mv.addObject("username", CommUtil.encode(userName));
		String pwd = Globals.THIRD_ACCOUNT_LOGIN + password;
		mv.addObject("password", pwd);
		mv.addObject("code", "ae937fd9ae2211e58c06001e67cd90fd");
		mv.addObject("encode", true);
		return mv;
	}

	/**
	 * 补充个人用户信息
	 * 
	 * @param uid
	 * @param access_token
	 * @param openid
	 */
	@SuppressWarnings("unused")
	private void insertUserCustomer(long uid, String access_token, String openid) {
		UserCustomer userCustomer = userCustomerService.findById(uid);
		if (userCustomer == null) {
			log.debug("==================== uid " + uid + " is null for insert UserCustomer ============== ");
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("access_token", access_token);
			paramMap.put("openid", openid);
			// 请求地址 拉取用户信息
			String getUserInfoURL = this.get_Request_UserInfo(paramMap);
			// 获取返回数据
			String userInfoContent = getHttpContent(getUserInfoURL, "UTF-8", null);
			log.info("...." + userInfoContent);
			JSONObject userInfo_Json = JSONObject.fromObject(userInfoContent);
			if (!userInfo_Json.containsKey("errcode")) {
				// 用户的唯一标识
				// String openid_ = userInfo_Json.getString("openid");
				// 用户昵称
				String nickName = userInfo_Json.getString("nickname");
				// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				String sex = userInfo_Json.getString("sex");
				// 用户个人资料填写的省份
				// String province = userInfo_Json.getString("province");
				// 普通用户个人资料填写的城市
				// String city = userInfo_Json.getString("city");
				// 国家，如中国为CN
				// String country = userInfo_Json.getString("country");
				// 用户头像
				String headimgurl = userInfo_Json.getString("headimgurl");
				this.customerService.createCustomer(uid, null, nickName, "", null, Integer.valueOf(sex),
						null, headimgurl);
			}
		}
	}

	// 用户授权并获取code URL
	private static final String req_WXCode_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type={2}&scope={3}&state={4}#wechat_redirect";
	// 通过code换取网页授权access_token URL
	private static final String req_WX_Access_Token = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid={0}&secret={1}&code={2}&grant_type=authorization_code";
	// 拉取用户信息URL
	private static final String req_WX_GetUserInfo_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}&lang=zh_CN";
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public static void main(String[] args) {
//		String url = "http://static.ysysgo.com/carnation-static/static/app/share_invite.html?invitationCode=141987";
//		//String url = "http://mobile.ysysgo.com/goods_1928.htm?isflag=false&test=1";
//		System.out.println(url.indexOf("&"));
//		
//		
//		String tt = "aHR0cDovL3N0YXRpYy55c3lzZ28uY29tL2Nhcm5hdGlvbi1zdGF0aWMvc3RhdGljL2FwcC9zaGFyZV9pbnZpdGUuaHRtbD9pbnZpdGF0aW9uQ29kZT0xNDE5ODc=";
//		String ttt = "aHR0cDovL3N0YXRpYy55c3lzZ28uY29tL2Nhcm5hdGlvbi1zdGF0aWMvc3RhdGljL2FwcC9zaGFyZV9pbnZpdGUuaHRtbD9pbnZpdGF0aW9uQ29kZT0xNDE5ODc=";
//		System.out.println("tt:"+new String(Base64.decode(tt)));
//		System.out.println("ttt:"+new String(Base64.decode(ttt)));
//		
//		String yy = new String(Base64.decode(ttt));
		String yy = "http://static.ysysgo.com/carnation-static/static/app/share_invite.html?invitationCode=141987";
		String redirectUrl = "";
		if (yy.indexOf("?") > 0) {
			redirectUrl = yy + "&isflag=false";
		} else {
			redirectUrl = yy + "?isflag=false";
		}
		System.out.println(redirectUrl);

		System.out.println(yy.indexOf("?"));

		String url = "http://mobile.ysysgo.com?invitationCode=123456";

		String a = url.substring(url.lastIndexOf("invitationCode") + "invitationCode".length() + 1);

		System.out.println(a);
	}
}
