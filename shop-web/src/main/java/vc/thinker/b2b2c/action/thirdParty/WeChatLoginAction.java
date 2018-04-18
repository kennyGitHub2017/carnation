package vc.thinker.b2b2c.action.thirdParty;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.service.WeChatService;
import com.sinco.common.utils.IPUtil;
import com.sinco.common.utils.StringUtils;

/**
 * PC端微信授权登陆
 * 
 * @author yuleijia
 */
@Controller
public class WeChatLoginAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private WeChatService weChatService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserRelationService relationService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 微信应用唯一标识
	 */
	private static final String APPID = "wx768e007b4c5d6817";
	/**
	 * 微信应用密钥AppSecret
	 */
	private static final String APPSECRET = "e75e3ef8e8ac4e36394ace485ec49c9d";
	/*
	 * 获取微信Code地址
	 */
	private final static String GET_WECHAT_CODE_URL = "https://open.weixin.qq.com/connect/qrconnect?appid={0}&redirect_uri={1}"
			+ "&response_type=code&scope=snsapi_login&state={2}#wechat_redirect";
	/*
	 * 获取access_token地址
	 */
	private final static String GET_WECHAT_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}"
			+ "&secret={1}&code={2}&grant_type=authorization_code";
	/**
	 * access_token检验是否有效地址
	 */
	@SuppressWarnings("unused")
	private final static String ACCESS_TOKEN_AUTH_URL = "https://api.weixin.qq.com/sns/auth?access_token={0}&openid={1}";
	/**
	 * 获取用户个人信息地址
	 */
	private final static String GET_USERINFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}";

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	/*@RequestMapping(value="/weChat/test.htm")
	public ModelAndView testPhoneWeChatBinding(HttpServletRequest request,HttpServletResponse response,String loginName,String pwd,String unionid)
	{
		unionid = "oS6yov3_A0HHYfDT0znJykWTbSr4";
		return this.phoneBindWeChat(loginName, pwd, unionid, request, response);
	}
	
	@RequestMapping(value="/weChat/testWXLogin.htm")
	public ModelAndView testWeChatLogin(HttpServletRequest request,HttpServletResponse response,String unionid)
	{
		return this.generalLogin(unionid, unionid, "test_ylj_01", 1, "-", "-", "-", "http://fi.ysysgo.com/sys_accessory/ea6fb584c4ad4a349c9f08ce0332a754.jpg", request);
	}*/

	@RequestMapping(value = "/weChat/test.htm")
	public String testMobileBindingWeChat(HttpServletRequest request, HttpServletResponse response,
			String mobile, String unionid) {
		customerService.mobileBindingWeChat(mobile, unionid);
		return "redirect:index.htm";
	}

	/**
	 * 第一步：请求CODE
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/weChat/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String type,
			String mobile, String password) throws Exception {
		logger.info("******************** PC WeChat Login ********************");
		// 获取域名
		String domainName = this.getDomainName(request);
		logger.info("...... domainName=" + domainName);

		String redirect = "weChat/callBack.htm";
		if (type != null && mobile != null) {
			logger.info("<<<<<<<<<< param -> type=" + type + " mobile=" + mobile);
			boolean boo = mobile.contains(",");
			if (boo) {
				String[] strArr = mobile.split(",");
				mobile = strArr[0];
			}

			redirect = redirect + "?type=" + type + "&mobile=" + mobile;
			if (password != null) {
				redirect = redirect + "&password=" + password;
			}
			logger.info("<<<<<<<<<< param -> redirect=" + redirect);
		}
		// String test = "http://www.ysysgo.com/weChat/callBack.htm";

		String domainNameRedirect = domainName + redirect;

		logger.info("<<<<<<<<<< weChat callBack URL -> domainNameRedirect =" + domainNameRedirect);

		// 微信回调重定向地址
		String redirect_uri = java.net.URLEncoder.encode(domainNameRedirect, "utf-8");
		String state = sdf.format(new Date());
		String reqURL = MessageFormat.format(GET_WECHAT_CODE_URL, APPID, redirect_uri, state);
		ModelAndView mv = new ModelAndView("redirect:" + reqURL);
		return mv;
	}

	/**
	 * 回调方法
	 * 
	 * @param request
	 * @param reponse
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "/weChat/callBack.htm")
	public ModelAndView callBack(HttpServletRequest request, HttpServletResponse response) {

		logger.info("********** PC WeChat callBack **********");

		ModelAndView mv = new ModelAndView("redirect:/user/login.htm");

		/**
		 * 微信授权后返回参数 通过code的来获取微信access_token
		 */
		String code = request.getParameter("code");
		// String state = request.getParameter("state");
		boolean boo = (code != null && code.trim().length() > 0);
		if (boo) {
			/* ***************** 获取access_token ******************  */
			String reqTokenURL = MessageFormat.format(GET_WECHAT_ACCESS_TOKEN_URL, APPID, APPSECRET, code);
			// 模拟http访问，返回相关数据
			String res_Conent = this.getHttpContent(reqTokenURL, "UTF-8", null);
			logger.info("....." + res_Conent);
			// 解析返回参数 获取access_token值
			JSONObject json = JSONObject.fromObject(res_Conent);
			boolean isError = json.containsKey("errcode");
			if (!isError) {
				// 接口调用凭证
				String access_token = json.getString("access_token");
				// 调用凭证超时时间，单位（秒）
				int expires_in = json.getInt("expires_in");
				// 用户刷新access_token
				String refresh_token = json.getString("refresh_token");
				// 授权用户唯一标识
				String openid = json.getString("openid");
				// 用户授权的作用域
				String scope = json.getString("scope");

				/* ***************** 获取用户个人信息 ******************  */
				String getUserInfoURL = MessageFormat.format(GET_USERINFO_URL, access_token, openid);
				res_Conent = this.getHttpContent(getUserInfoURL, "UTF-8", null);
				json = JSONObject.fromObject(res_Conent);
				boolean iserrcode = json.containsKey("errcode");
				if (!iserrcode) {
					// 普通用户的标识，对当前开发者帐号唯一
					String openid0 = json.getString("openid");
					// 普通用户昵称
					String nickname = json.getString("nickname");
					// 普通用户性别，1为男性，2为女性
					int sex = json.getInt("sex");
					// 普通用户个人资料填写的省份
					String province = json.getString("nickname");
					// 普通用户个人资料填写的城市
					String city = json.getString("city");
					// 国家，如中国为CN
					String country = json.getString("country");
					// 用户头像
					String headimgurl = json.getString("headimgurl");
					// 用户特权信息，json数组，如微信沃卡用户为（chinaunicom）
					String privilege = json.getString("privilege");
					// 用户统一标识
					String unionid = json.getString("unionid");

					String type = request.getParameter("type");

					if (type != null) {
						String mobile = request.getParameter("mobile");
						logger.info(">>>>>>> params -> type:" + type + " unionid:" + unionid + " mobile:"
								+ mobile);
						// ****************** 绑定微信号操作 ******************
						if ("2".equals(type)) // 手机注册后绑定微信号
						{
							String password = request.getParameter("password");
							mobile = CommUtil.decode(mobile);
							return this.phoneBindWeChat(mobile, password, unionid, request, response);
						}
						// cn绑定微信号
						// String mobile = request.getParameter("mobile");
						return this.cn_boundWeChat(request, response, mobile, unionid);
					} else {
						// ****************** 登陆或登陆+注册普通会员操作 ******************
						return this.generalLogin(unionid, openid0, nickname, sex, province, city, country,
								headimgurl, request);
					}
				}
			} else {
				logger.error("【获取微信access_token失败】");
			}
		}
		return mv;
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
	private String getHttpContent(String url, String charSet, String method) {
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
	 * 系统提交登陆请求
	 * 
	 * @param userName_
	 * @param password_
	 * @return
	 */
	private ModelAndView login(String userName_, String password_) {
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

	public ModelAndView cn_boundWeChat(HttpServletRequest request, HttpServletResponse response,
			String mobile, String unionid) {
		logger.info("<<<<<<<<<<<<<<< cn_boundWeChat");
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(unionid)) {
			mv.addObject("op_title", "参数异常");
			mv.addObject("url", CommUtil.getURL(request) + "/weChat/login.htm?type=1&mobile=" + mobile);
			return mv;
		}
		int re = customerService.cnBindingWx(mobile, unionid);
		logger.info(">>>>>>> cn_boundWeChat unionid:" + unionid + " mobile:" + mobile + " re:" + re);
		if (re == 500) {
			mv.addObject("op_title", "该手机号未注册");//
			mv.addObject("url", CommUtil.getURL(request) + "/weChat/login.htm?type=1&mobile=" + mobile);
		} else if (re == 501) {
			mv.addObject("op_title", "该微信已绑定过手机号，请换个微信进行绑定");//
			mv.addObject("url", CommUtil.getURL(request) + "/b2b2c_logout.htm");
		} else if (re == 100) {
			mv.addObject("op_title", "绑定微信成功,账户合并");// 重新登录
			request.getSession().setAttribute("verify_code", " ");
			return login(unionid, unionid);
		}
		return mv;
	}

	/**
	 * 手机号码注册后绑定微信
	 * 
	 * @param loginName
	 *            登陆名
	 * @param pwd
	 *            密码
	 * @param unionid
	 *            微信Unionid
	 * @return
	 */
	public ModelAndView phoneBindWeChat(String loginName, String pwd, String unionid,
			HttpServletRequest request, HttpServletResponse response) {
		logger.info("<<<<<<<<<<<<<<< phoneBindWeChat mobile=" + loginName);
		ModelAndView mv = null;
		String url = null;
		String op_title = null;
		String view = "error.html";
		UserAccount userAccountMobile = userAccountService.fetchByLoginName(loginName);
		if (userAccountMobile != null && userAccountMobile.getId() != 0l) {
			long phoneUID = userAccountMobile.getUid();

			int result = this.userAccountService.banding(unionid, phoneUID, UserContant.ACCOUNT_TYPE_4);
			if (result == 1) // 微信不存在
			{
				// 为微信用户创建系统用户信息
				this.relationService.bindingUser(phoneUID, unionid, null, UserContant.ACCOUNT_TYPE_4);
				op_title = "绑定微信号成功";
				request.getSession().setAttribute("verify_code", "");
				url = "/b2b2c_login.htm?username=" + CommUtil.encode(unionid) + "&password="
						+ Globals.THIRD_ACCOUNT_LOGIN + unionid + "&code=ae937fd9ae2211e58c06001e67cd90fd"
						+ "&encode=true";
				view = "success.html";
			} else if (result == 4) // 当前微信已绑定手机号
			{
				// url = "/weChat/login.htm?type=2&mobile="+CommUtil.encode(loginName);
				url = "/b2b2c_logout.htm"; // 退出登录
				op_title = "该微信已绑定过手机号，请换个微信进行绑定";
			} else if (result == 0) // 绑定成功
			{
				op_title = "绑定微信号成功";
				request.getSession().setAttribute("verify_code", "");
				url = "/b2b2c_login.htm?username=" + CommUtil.encode(unionid) + "&password="
						+ Globals.THIRD_ACCOUNT_LOGIN + unionid + "&code=ae937fd9ae2211e58c06001e67cd90fd"
						+ "&encode=true";
				view = "success.html";
			}
		} else {
			op_title = "当前手机用户不存在，请注册";
			url = "/register.htm";
		}
		mv = new JModelAndView(view, configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", op_title);
		mv.addObject("url", CommUtil.getURL(request) + url);
		return mv;
	}

	/**
	 * 普通登陆操作
	 * 
	 * @param unionid
	 * @param openid0
	 * @param nickname
	 * @param sex
	 * @param province
	 * @param city
	 * @param country
	 * @param headimgurl
	 * @param request
	 * @return
	 */
	public ModelAndView generalLogin(String unionid, String openid0, String nickname, int sex,
			String province, String city, String country, String headimgurl, HttpServletRequest request) {
		// 以用户微信的unionid为条件，判断改微信用户是否存在系统中
		// 如果存在则登录系统,如果不存在则注册改用户
		UserAccountBO userAccount = this.weChatService.find_WXUnionid_Is_Registered(unionid);
		String pwd = null;
		String loginName = null;
		if (userAccount == null) // 不存在
		{
			Map<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("openid", openid0);
			paramMap.put("nickName", nickname);
			paramMap.put("sex", String.valueOf(sex));
			paramMap.put("province", province);
			paramMap.put("city", city);
			paramMap.put("country", country);
			paramMap.put("headimgurl", headimgurl);
			paramMap.put("unionid_", unionid);
			paramMap.put("invitationCode", null);
			paramMap.put("requestIp", IPUtil.getIpAddr(request));
			// 注册用户
			UserAccount userAccountResult = this.weChatService.weChat_RegisterUser(paramMap);
			pwd = userAccountResult.getPassword();
			loginName = userAccountResult.getLoginName();
		} else if (userAccount != null) // 用户存在
		{
			pwd = userAccount.getPassword();
			loginName = userAccount.getLoginName();
		}
		request.getSession().setAttribute("verify_code", " ");
		return this.login(loginName, pwd);
	}

	public static void main(String[] args) {
		String mobile = "13424263022,13424263022";
		boolean boo = mobile.contains(",");
		if (boo) {
			String[] strArr = mobile.split(",");
			System.out.println(strArr[0]);
		}
	}
}
