package vc.thinker.b2b2c.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.Log;
import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.qrcode.QRCodeUtil;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.foundation.domain.LogType;

import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImageViewTools;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.IPUtil;

/**
 * 
 * <p>
 * Title: LoginViewAction.java
 * </p>
 * 
 * <p>
 * Description: 用户登录、注册管理控制器，用来管理用户登录、注册、密码找回
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-13
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"unchecked", "unused", "rawtypes"})
public class LoginViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
//	@Autowired
//	private IntegralLogService integralLogService;
//	@Autowired
//	private AlbumService albumService;
	@Autowired
	private DocumentService documentService;
//	@Autowired
//	private AreaService areaService;
//	@Autowired
//	private VerifyCodeService verifyCodeService;
//	@Autowired
//	private QRLoginService qRLoginService;
	@Autowired
	private ImageViewTools imageViewTools;
	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private RedisCacheService redisCacheService;
	@Autowired
	private GoodsCartService cartService;
	@Autowired
	private UserAccountService accountService;

	@Autowired
	private GoodsCaseViewTools goodsCaseViewTools;
	@Autowired
	private UserRelationService relationService;
//	@Autowired
//	private MsgTools msgTools;
	private static final String REGEX1 = "(.*管理员.*)";
	private static final String REGEX2 = "(.*admin.*)";

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 用户登录后去向控制，根据用户角色UserRole进行控制,该请求不纳入权限管理
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@Log(title = "用户登陆", type = LogType.LOGIN)
	@RequestMapping("/login_success.htm")
	public void login_success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (SecurityUserHolder.getCurrentUserDetails() != null) {
			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();

			String ref = (String) request.getSession().getAttribute("ref");

			Long storeId = userDetails != null ? userDetails.getStoreId() : null;

			String cart_session_id = this.goodsCaseViewTools.getCartSessionId(request, response);

			// 个人用户登录
			customerService.login(userDetails.getId(), userDetails.getUsername(), IPUtil.getIpAddr(request));

			// 合并购物车
			cartService.mergerCart(userDetails.getId(), storeId, cart_session_id);

			HttpSession session = request.getSession(false);
			session.setAttribute("user", userDetails.getUser());
			session.setAttribute("userName", userDetails.getUsername());
			session.setAttribute("lastLoginDate", new Date());// 设置登录时间
			session.setAttribute("loginIp", CommUtil.getIpAddr(request));// 设置登录IP
			session.setAttribute("login", true);// 设置登录标识

			String url = CommUtil.getURL(request) + "/index.htm";

			boolean ajax_login = CommUtil.null2Boolean(session.getAttribute("ajax_login"));
			boolean isRef = (ref != null && ref.trim().length() > 0);
			if (isRef) {
				request.getSession().removeAttribute("ref");
				response.sendRedirect(ref);
			} else if (ajax_login) {
				response.setContentType("text/plain");
				response.setHeader("Cache-Control", "no-cache");
				response.setCharacterEncoding("UTF-8");
				PrintWriter writer;
				try {
					writer = response.getWriter();
					response.sendRedirect(url);
					writer.print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				String userAgent = request.getHeader("user-agent");
				if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
					url = CommUtil.getURL(request) + "/index.htm";
				} else if (!CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"))
						.equals("")) {
					url = CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"));
					request.getSession(false).removeAttribute("refererUrl");
				}
				response.sendRedirect(url);
			}
		} else {
			String url = CommUtil.getURL(request) + "/index.htm";
			response.sendRedirect(url);
		}

	}

	/**
	 * 用户成功退出后的URL导向
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/logout_success.htm")
	public void logout_success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);

		String targetUrl = CommUtil.getURL(request) + "/user/login.htm";

		if (session != null) {
			//
			String userName = CommUtil.null2String(session.getAttribute("userName"));

			List<Object> objs = this.sessionRegistry.getAllPrincipals();
			for (Object obj : objs) {
				if (CommUtil.null2String(obj).equals(userName)) {
					List<SessionInformation> ilist = this.sessionRegistry.getAllSessions(obj, true);
					for (SessionInformation sif : ilist) {
						// SessionInformation sif = ilist[j];
						// 以下踢出用户
						sif.expireNow();
						this.sessionRegistry.removeSessionInformation(sif.getSessionId());
					}
				}
			}
			//
			session.removeAttribute("user");
			session.removeAttribute("userName");
			session.removeAttribute("login");
		}

		String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
			targetUrl = CommUtil.getURL(request) + "/index.htm";
		}

		response.sendRedirect(targetUrl);
	}

	@RequestMapping("/login_error.htm")
	public ModelAndView login_error(HttpServletRequest request, HttpServletResponse response) {
		/*String login_role = (String) request.getSession(false).getAttribute(
				"login_role");
		ModelAndView mv = null;
		String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
			String targetUrl = CommUtil.getURL(request) + "/index.htm";
			try {
				response.sendRedirect(targetUrl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String thinkervc_view_type = CommUtil.null2String(request.getSession(
				false).getAttribute("thinkervc_view_type"));
		if (thinkervc_view_type != null && !thinkervc_view_type.equals("")) {
			if (thinkervc_view_type.equals("weixin")) {
				String store_id = CommUtil.null2String(request
						.getSession(false).getAttribute("store_id"));
				mv = new JModelAndView("weixin/error.html",
						configService.getSysConfig(),
						1, request,
						response);
				mv.addObject("url", CommUtil.getURL(request)
						+ "/weixin/index.htm?store_id=" + store_id);
			}
		} else {
			mv = new JModelAndView("error.html",
					configService.getSysConfig(),
					1, request,
					response);
			*/
		Object ex = request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (ex instanceof BadCredentialsException) {
			request.setAttribute("message", "用户名或者密码错误。");
		} else if (ex instanceof UsernameNotFoundException) {
			request.setAttribute("message", "用户名不存在，或者状态异常。");
		} else if (ex instanceof LockedException)
			request.setAttribute("message", "该用户已被锁定");
		ModelAndView mv = new JModelAndView("web_mobile/login.html", configService.getSysConfig(), 1,
				request, response);
		/*return login(request, response, null);
		}*/
		mv.addObject("op_title", "登录失败");
		return mv;
	}

	/**
	 * 用户登录页面
	 * 
	 * @param request
	 * @return
	 */
	// @RequestMapping("/user/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String url) {
		/*		ModelAndView mv = new JModelAndView("login.html",
						configService.getSysConfig(),
						 1, request, response);*/
		/*H5*/
		ModelAndView mv = new JModelAndView("web_mobile/login.html", configService.getSysConfig(), 1,
				request, response);
		request.getSession().removeAttribute("verify_code");
		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if (url != null && !url.equals("")) {
			request.getSession(false).setAttribute("refererUrl", url);
		}
		if (domain_error) {
			mv.addObject("op_title", "域名绑定错误，请与管理员联系");
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		} else {
			/*mv.addObject("imageViewTools", imageViewTools);*/
		}
		return mv;
	}

	/**
	 * 微信授权登陆 author:yuleijia
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
	@RequestMapping("/user/login.htm")
	public ModelAndView weChat_login(HttpServletRequest request, HttpServletResponse response, String url) {
		ModelAndView mv = new ModelAndView("redirect:/weChat.htm");
		return mv;
	}

	/**
	 * 微信授权登陆Url跳转 author:yuleijia
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
	@RequestMapping("/user/loginUrl.htm")
	public ModelAndView weChat_login_url(HttpServletRequest request, HttpServletResponse response,
			String url, String invitationCode) {
		log.info("============== weChat_login_url  ============");
		ModelAndView mv = new ModelAndView("redirect:/weChatUrl.htm");
		mv.addObject("url", url);
		log.info("<<<<<<<< url->" + url);
		String login = request.getParameter("login");
		if (login != null && login.trim().length() > 0 && login.equals("0")) {
			log.info("<<<<< login->" + login);
			mv.addObject("login", "0");
		}
		System.out.println("szj:" + url);
		mv.addObject("invitationCode", invitationCode);
		return mv;
	}

	/**
	 * 用户注册页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/register.htm")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response, String message) {
		ModelAndView mv = new JModelAndView("register.html", configService.getSysConfig(), 1, request,
				response);
		request.getSession().removeAttribute("verify_code");
		Document doc = this.documentService.findByMark("reg_agree");
		mv.addObject("doc", doc);
		mv.addObject("imageViewTools", imageViewTools);
		mv.addObject("message", message);
		return mv;
	}

	/**
	 * 手机注册页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/mobile_register.htm")
	public ModelAndView mobile_register(HttpServletRequest request, HttpServletResponse response,
			String invitationCode) {
		ModelAndView mv = new JModelAndView("mobile/register.html", configService.getSysConfig(), 1, request,
				response);
		// request.getSession().removeAttribute("verify_code");
		mv.addObject("invitationCode", invitationCode);
		return mv;
	}

	/**
	 * 手机注册页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/mr.htm")
	public ModelAndView mr(HttpServletRequest request, HttpServletResponse response, String u) {
		ModelAndView mv = new JModelAndView("mobile/register.html", configService.getSysConfig(), 1, request,
				response);
		// request.getSession().removeAttribute("verify_code");
		mv.addObject("invitationCode", u);
		return mv;
	}

	@RequestMapping("/m.htm")
	public ModelAndView m(HttpServletRequest request, HttpServletResponse response, String u) {
		ModelAndView mv = new JModelAndView("mobile/register-m.html", configService.getSysConfig(), 1,
				request, response);
		// request.getSession().removeAttribute("verify_code");
		mv.addObject("invitationCode", u);
		return mv;
	}

	/**
	 * 手机注册成功跳转页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/mobile_register_success.htm")
	public ModelAndView mobile_register_success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("mobile/register-success.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	/**
	 * 注册第二步
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/register2.htm")
	public ModelAndView register2(HttpServletRequest request, HttpServletResponse response, String mobile,
			String code, String message) {
		Document doc = this.documentService.findByMark("reg_agree");
		ModelAndView mv = new JModelAndView("register2.html", configService.getSysConfig(), 1, request,
				response);
		HttpSession session = request.getSession(false);
		String verify_code = "";
		verify_code = (String) session.getAttribute("verify_code");
		boolean ret = false;
		if (code != null && !code.equals("") && verify_code != null && !verify_code.equals("")) {
			if (CommUtil.null2String(code.toUpperCase()).equals(verify_code)) {
				ret = true;
			}
		}
		if (ret) {
			session.setAttribute("validateName", mobile);
			mv.addObject("mobile", mobile);
			mv.addObject("doc", doc);
			mv.addObject("imageViewTools", imageViewTools);
			mv.addObject("message", message);
			mv.addObject("code", code);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证码错误！");
			mv.addObject("url", CommUtil.getURL(request) + "/register.htm");
		}
		return mv;
	}

	/**
	 * 注册完成
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @param email
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws InterruptedException
	 */
	@RequestMapping("/register_finish.htm")
	public String register_finish(HttpServletRequest request, HttpServletResponse response, String userName,
			String mobile, String password, String email, String user_type, String code, String mobileCode,
			String invitationCode) throws HttpException, IOException, InterruptedException {

		boolean reg = true;// 防止机器注册，如后台开启验证码则强行验证验证码
//		if (code != null && !code.equals("")) {
//			code = CommUtil.filterHTML(code);// 过滤验证码
//		}
//		if (this.configService.getSysConfig().getSecurityCodeRegister()) {
//			if (!request.getSession(false).getAttribute("verify_code")
//					.equals(code)) {
//				reg = false;
//			}
//		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);

		String message = "";
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			reg = false;
			message = "未申请发送过手机验证码，或者验证号已过期!";
		} else if (!mobileCode.equals(codeRedis)) {
			// 验证码是否正确
			reg = false;
			message = "手机验证码错误!";
		} else if (userName.matches(REGEX1) || userName.toLowerCase().matches(REGEX2)) {
			// 禁止用户注册带有 管理员 admin 等字样用户名
			reg = false;
			message = "不能有特殊字段（管理员，admin）等等!";
		}

		if (invitationCode != null && !invitationCode.equals("")) {
			UserBO user = userService.findByInvitationCode(invitationCode);
			if (null == user || user.getStatus() != 1) {
				reg = false;
				message = "邀请码不正确";
			}
		}

		if (reg) {
			int result = relationService.registerUser(userName, mobile, password, IPUtil.getIpAddr(request),
					mobileCode, invitationCode);
			request.getSession(false).removeAttribute("verify_code");
			if (result > 0) {
				return "redirect:b2b2c_login.htm?username=" + CommUtil.encode(mobile) + "&password="
						+ password + "&encode=true";
			}
			if (result == -4) {
				message = "账户已存在!";
			} else if (result == -5) {
				message = "用户昵称已存在!";
			}
		}
		return "redirect:register2.htm?mobile=" + mobile + "&code=" + code + "&message="
				+ URLEncoder.encode(message, "utf-8");

	}

	/**
	 * 分享注册完成
	 * 
	 * @param request
	 * @param userName
	 * @param password
	 * @param email
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws InterruptedException
	 */
	@RequestMapping("/mobile_register_finish.htm")
	public String mobile_register_finish(HttpServletRequest request, HttpServletResponse response,
			String mobile, String password, String mobileCode, String invitationCode) throws HttpException,
			IOException, InterruptedException {

		boolean reg = true;// 防止机器注册，如后台开启验证码则强行验证验证码
		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		String message = "";
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			reg = false;
			message = "未申请发送过手机验证码，或者验证号已过期!";
		} else if (!mobileCode.equals(codeRedis)) {
			// 验证码是否正确
			reg = false;
			message = "手机验证码错误!";
		}
		if (invitationCode != null && !invitationCode.equals("")) {
			UserBO user = userService.findByInvitationCode(invitationCode);
			if (null == user || user.getStatus() != 1) {
				reg = false;
				message = "邀请码不正确";
			}
		}
		if (reg) {
			int result = relationService.registerUserByMoblie(mobile, password, IPUtil.getIpAddr(request),
					mobileCode, invitationCode);
			request.getSession(false).removeAttribute("verify_code");
			if (result > 0) {
				return "redirect:mobile_register_success.htm";
			}
			if (result == -4) {
				message = "账户已存在!";
			} else if (result == -4) {
				message = "用户名已存在!";
			}
		}
		return "redirect:mobile_register.htm?message=" + URLEncoder.encode(message, "utf-8");
	}

	/**
	 * 绑定手机号(微信授权登陆) author:yuleijia 2016-09-22
	 * 
	 * @param request
	 * @param response
	 * @param mobile
	 * @param password
	 * @param mobileCode
	 * @return
	 */
	@RequestMapping(value = "/binding_mobile.htm")
	public ModelAndView binding_mobile_finish(HttpServletRequest request, HttpServletResponse response,
			String mobile, String password, String mobileCode, String ref) {
		long uid = SecurityUserHolder.getCurrentUserId();
		boolean reg = true;// 防止机器注册，如后台开启验证码则强行验证验证码
		String codeRedis = redisCacheService.getSmsCode(0L, mobile);
		String message = "";
		// 用户未申请发送过验证码，或者验证号已过期
		if (!mobileCode.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			if (StringUtils.isBlank(codeRedis)) {
				reg = false;
				message = "未申请发送过手机验证码，或者验证号已过期!";
			} else if (!mobileCode.equals(codeRedis)) {
				// 验证码是否正确
				reg = false;
				message = "手机验证码错误!";
			}
		}
		String userName = "";
		String pwd = "";
		if (reg) {
			UserAccount resultObj = customerService.updateMobileByUIDAndPassWord(uid, mobile, password);
			userName = resultObj.getLoginName();
			pwd = resultObj.getPassword();
			request.getSession().setAttribute("ref", ref);
			request.getSession().setAttribute("verify_code", " ");
		}
		return this.login(userName, pwd);
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

//	/**
//	 * springsecurity登录成功后跳转到该页面，如有登录相关处理可以在该方法中完成
//	 * 
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@RequestMapping("/user_login_success.htm")
//	public String user_login_success(HttpServletRequest request,
//			HttpServletResponse response) {
//		String url = CommUtil.getURL(request) + "/index.htm";
//		HttpSession session = request.getSession(false);
//		if (session.getAttribute("refererUrl") != null
//				&& !session.getAttribute("refererUrl").equals("")) {
//			url = (String) session.getAttribute("refererUrl");
//			session.removeAttribute("refererUrl");
//		}
//		String bind = CommUtil.null2String(request.getSession(false)
//				.getAttribute("bind"));
//		if (!bind.equals("")) {
//			return "redirect:out_login_success.htm";
//		}
//		return "redirect:" + url;
//	}

	/**
	 * 外部系统登录成功提示页，系统默认支持QQ登录、新浪微博账号登录，使用第三方账号登录后，要求输入一个本系统的用户名和密码进行绑定， 绑定成功后就以使用QQ、新浪微博或者本系统账号登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/out_login_success.htm")
	public ModelAndView out_login_success(HttpServletRequest request, HttpServletResponse response) {
		String bind = CommUtil.null2String(request.getSession(false).getAttribute("bind"));
		ModelAndView mv = new JModelAndView(bind + "_login_bind.html", configService.getSysConfig(), 1,
				request, response);
		User user = SecurityUserHolder.getCurrentUser();
		mv.addObject("user", user);
		request.getSession(false).removeAttribute("bind");
		return mv;
	}

	/**
	 * 弹窗登录页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/user_dialog_login.htm")
	public ModelAndView user_dialog_login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user_dialog_login.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	/**
	 * 找回密码第一步
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/forget1.htm")
	public ModelAndView forget1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("forget1.html", configService.getSysConfig(), 1, request,
				response);
		SysConfigBO config = this.configService.getSysConfig();
//		if (!config.getEmailEnable() && !config.getSmsEnbale()) {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					 1, request,
//					response);
//			mv.addObject("op_title", "系统关闭邮件及手机短信功能，不能找回密码");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//		}
		return mv;
	}

	/**
	 * 找回密码第二步
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/forget2.htm")
	public ModelAndView forget2(HttpServletRequest request, HttpServletResponse response, String userName,
			String code) {
		ModelAndView mv = new JModelAndView("forget2.html", configService.getSysConfig(), 1, request,
				response);
//		SysConfigBO config = this.configService.getSysConfig();
//		if (!config.getEmailEnable() && !config.getSmsEnbale()) {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					 1, request,
//					response);
//			mv.addObject("op_title", "系统关闭邮件及手机短信功能，不能找回密码");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//		} else {
//			
//		}
		HttpSession session = request.getSession(false);
		String verify_code = "";
		verify_code = (String) session.getAttribute("verify_code");
		boolean ret = false;
		if (code != null && !code.equals("") && verify_code != null && !verify_code.equals("")) {
			if (CommUtil.null2String(code.toUpperCase()).equals(verify_code)) {
				ret = true;
			}
		}
		if (ret) {
			User user = this.userService.findByLoginName(userName);
			if (user != null) {
				UserCustomerBO customer = this.customerService.findSessionUser(user.getId());
				mv.addObject("user", customer);
				mv.addObject("userName", userName);
				session.setAttribute("validateName", userName);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "不存在该用户");
				mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证码错误！");
			mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
		}

		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param userName
	 * @return
	 */
	@RequestMapping("/forget3.htm")
	public ModelAndView forget3(HttpServletRequest request, HttpServletResponse response, String accept_type,
			String userName, String verify_code) {
		ModelAndView mv = new JModelAndView("forget3.html", configService.getSysConfig(), 1, request,
				response);
//		if (accept_type.equals("email")) {
//			VerifyCode vc = this.verifyCodeService.getObjByProperty(null,
//					"email", email);
//			if (vc != null) {
//				if (!vc.getCode().equals(verify_code)) {
//					mv = new JModelAndView("error.html",
//							configService.getSysConfig(),
//							 1, request,
//							response);
//					mv.addObject("op_title", "验证码输入错误");
//					mv.addObject("url", CommUtil.getURL(request)
//							+ "/forget2.htm?userName=" + userName);
//				} else {
//					String verify_session = CommUtil.randomString(64)
//							.toLowerCase();
//					mv.addObject("verify_session", verify_session);
//					request.getSession(false).setAttribute("verify_session",
//							verify_session);
//					mv.addObject("userName", userName);
//					this.verifyCodeService.delete(vc.getId());
//				}
//			} else {
//				mv = new JModelAndView("error.html",
//						configService.getSysConfig(),
//						 1, request,
//						response);
//				mv.addObject("op_title", "验证码输入错误");
//				mv.addObject("url", CommUtil.getURL(request)
//						+ "/forget2.htm?userName=" + userName);
//			}
//		}
//		if (accept_type.equals("mobile")) {

		User user = this.userService.findByLoginName(userName);

		if (user == null) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "用户不存在");
			mv.addObject("url", CommUtil.getURL(request) + "/forget2.htm?userName=" + userName);
			return mv;
		}

		String codeRedis = redisCacheService.getSmsCode(user.getId(), userName);
		// 用户未申请发送过验证码，或者验证号已过期
		if (StringUtils.isBlank(codeRedis)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "未发送过验证码，或者验证号已过期");
			mv.addObject("url", CommUtil.getURL(request) + "/forget2.htm?userName=" + userName);
			return mv;
		}
		// 验证码是否正确
		if (!codeRedis.equals(verify_code)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "验证码不正确");
			mv.addObject("url", CommUtil.getURL(request) + "/forget2.htm?userName=" + userName);
			return mv;
		}

		redisCacheService.delSmsCode(user.getId(), userName);
		String verify_session = CommUtil.randomString(64).toLowerCase();
		mv.addObject("verify_session", verify_session);
		request.getSession(false).setAttribute("verify_session", verify_session);
		mv.addObject("userName", userName);

		return mv;
	}

	@RequestMapping("/forget4.htm")
	public ModelAndView forget4(HttpServletRequest request, HttpServletResponse response, String userName,
			String password, String verify_session) {
		ModelAndView mv = new JModelAndView("forget4.html", configService.getSysConfig(), 1, request,
				response);
		String verify_session1 = CommUtil.null2String(request.getSession(false)
				.getAttribute("verify_session"));
		User user = this.userService.findByLoginName(userName);
		if (!verify_session1.equals("") && verify_session1.equals(verify_session)) {
			this.userService.updatePassword(user.getId(), password);
			request.getSession(false).removeAttribute("verify_session");
			mv.addObject("op_title", "密码修改成功，请使用新密码登录");
			mv.addObject("url", CommUtil.getURL(request) + "/user/login.htm");
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "会话过期，找回密码失败");
			mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
		}
		return mv;
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param code_name
	 * @throws UnsupportedEncodingException
	 */

	@RequestMapping("/reg_code_get.htm")
	public void reg_code_get(HttpServletRequest request, HttpServletResponse response, String accept_type,
			String email, String mobile, String userName) throws UnsupportedEncodingException {
		int ret = 0;// 0为发送失败，1为发送成功，-1为邮件发送失败，-2为手机短信发送失败
		if (accept_type.equals("email")) {
//			if (this.configService.getSysConfig().isEmailEnable()) {
//				String subject = this.configService.getSysConfig()
//						.getWebsiteName() + " 邮件验证码";
//				String code = CommUtil.randomString(4).toUpperCase();
//				VerifyCode vc = this.verifyCodeService.getObjByProperty(null,
//						"email", email);
//				if (vc == null) {
//					vc = new VerifyCode();
//					vc.setAddTime(new Date());
//					vc.setCode(code);
//					vc.setEmail(email);
//					vc.setUserName(userName);
//					this.verifyCodeService.save(vc);
//				} else {
//					vc.setAddTime(new Date());
//					vc.setCode(code);
//					vc.setEmail(email);
//					vc.setUserName(userName);
//					this.verifyCodeService.update(vc);
//				}
//				String content = "您的邮件验证码为:" + code + ",验证码有效时间为30分钟！";
//				boolean ret1 = this.msgTools.sendEmail(email, subject, content);
//				if (ret1) {
//					ret = 1;
//				}
//			} else {
//				ret = -1;
//			}
		}
		HttpSession session = request.getSession(false);
		String validateName = "";
		if (session != null && session.getAttribute("validateName") != null) {
			validateName = (String) session.getAttribute("validateName");
		}
		boolean isSend = false;
		if (mobile != null && !mobile.equals("") && validateName != null && !validateName.equals("")) {
			if (validateName.equals(mobile)) {
				isSend = true;
			}
		}
		if (isSend) {
			if (accept_type.equals("mobile")) {
				User user = userService.findByLoginName(mobile);
				// 如果用户不存在为注册的验证，否则其它
				if (user == null) {
					Boolean bo = customerService.sendRegisterValidateCode(mobile, IPUtil.getIpAddr(request));
					if (bo) {
						ret = 1;
					}
				} else {
					Boolean bo = customerService.sendValidateCode(user.getId(), mobile,
							IPUtil.getIpAddr(request));
					if (bo) {
						ret = 1;
					}
				}
//				if (this.configService.getSysConfig().getSmsEnbale()) {
//				} else {
//					ret = -2;
//				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/moblie_reg_code_get.htm")
	public void moblie_reg_code_get(HttpServletRequest request, HttpServletResponse response, String code,
			String mobile) throws UnsupportedEncodingException {
		int ret = 0;// 0为发送失败，1为发送成功，-1为邮件发送失败，-2为手机短信发送失败
		HttpSession session = request.getSession(false);
		String verify_code = "";
		verify_code = (String) session.getAttribute("verify_code");
		boolean isSend = false;
		if (code != null && !code.equals("") && verify_code != null && !verify_code.equals("")) {
			if (CommUtil.null2String(code.toUpperCase()).equals(verify_code)) {
				isSend = true;
			}
		}

		if (isSend) {
			Boolean bo = customerService.sendRegisterValidateCode(mobile, IPUtil.getIpAddr(request));
			if (bo) {
				ret = 1;
				session.removeAttribute("verify_code");
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 通过邮件发送新密码来找回密码
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/find_pws.htm")
	public ModelAndView find_pws(HttpServletRequest request, HttpServletResponse response, String userName,
			String email, String code) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		HttpSession session = request.getSession(false);
		String verify_code = (String) session.getAttribute("verify_code");
//		if (code.toUpperCase().equals(verify_code)) {
//			User user = this.userService.getObjByProperty(null, "userName",
//					userName);
//			if (user.getEmail().equals(email.trim())) {
//				String pws = CommUtil.randomString(6).toLowerCase();
//				String subject = this.configService.getSysConfig().getTitle()
//						+ "密码找回邮件";
//				String content = user.getUsername() + ",您好！您通过密码找回功能重置密码，新密码为："
//						+ pws;
//				boolean ret = this.msgTools.sendEmail(email, subject, content);
//				if (ret) {
//					user.setPassword(Md5Encrypt.md5(pws));
//					this.userService.update(user);
//					mv.addObject("op_title", "新密码已经发送到邮箱:<font color=red>"
//							+ email + "</font>，请查收后重新登录");
//					mv.addObject("url", CommUtil.getURL(request)
//							+ "/user/login.htm");
//				} else {
//					mv = new JModelAndView("error.html",
//							configService.getSysConfig(),
//							 1, request,
//							response);
//					mv.addObject("op_title", "邮件发送失败，密码暂未执行重置");
//					mv.addObject("url", CommUtil.getURL(request)
//							+ "/forget1.htm");
//				}
//			} else {
//				mv = new JModelAndView("error.html",
//						configService.getSysConfig(),
//						 1, request,
//						response);
//				mv.addObject("op_title", "用户名、邮箱不匹配");
//				mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
//			}
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(),
//					 1, request,
//					response);
//			mv.addObject("op_title", "验证码不正确");
//			mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
//		}
		return mv;
	}

	/**
	 * 获得登录二维码，使用app扫描二维码可以完成在线pc端自动登录功能,
	 * 
	 * @param request
	 * @param response
	 * @param accept_type
	 * @param email
	 * @param mobile
	 * @param userName
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/qr_login_img.htm")
	public void qr_login_img(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		String qr_session_id = CommUtil.null2String(request.getSession().getAttribute("qr_session_id"));
		String uploadFilePath = this.configService.getSysConfig().getUploadFilePath();
		Map map = new HashMap();
		String qr_img_url = "";
		if (qr_session_id.equals("")) {
			qr_session_id = this.generic_qr(request, qr_session_id);
			qr_img_url = CommUtil.getURL(request) + "/" + uploadFilePath + "/qr_login/" + "qr_"
					+ qr_session_id + ".png";
		} else {
			String logo = request.getSession().getServletContext().getRealPath("") + File.separator
					+ uploadFilePath + File.separator + "qr_login" + File.separator + "qr_" + qr_session_id
					+ ".png";
			if (!CommUtil.fileExist(logo)) {
				this.generic_qr(request, qr_session_id);
			}
			qr_img_url = CommUtil.getURL(request) + "/" + uploadFilePath + "/qr_login/" + "qr_"
					+ qr_session_id + ".png";
		}
		map.put("qr_img_url", qr_img_url);
		map.put("qr_session_id", qr_session_id);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping("/qr_login.htm")
	public void qr_login(HttpServletRequest request, HttpServletResponse response, String qr_session_id)
			throws UnsupportedEncodingException {
//		Map params = new HashMap();
//		params.put("qr_session_id", qr_session_id);
//		List<QRLogin> qrlist = this.qRLoginService
//				.query("select obj from QRLogin obj where obj.qr_session_id=:qr_session_id",
//						params, -1, -1);
//		Map map = new HashMap();
//		if (qrlist.size() > 0) {
//			QRLogin qrlogin = qrlist.get(0);
//			map.put("ret", "true");
//			map.put("user_id", qrlogin.getUser_id());
//			this.qRLoginService.delete(qrlogin.getId());
//			String qr_log_mark = CommUtil.randomString(16);
//			map.put("qr_log_mark", qr_log_mark);
//			HttpSession session = request.getSession(false);
//			session.setAttribute("qr_log_mark", qr_log_mark);
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(Json.toJson(map, JsonFormat.compact()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@RequestMapping("/qr_login_confirm.htm")
	public String qr_login_confirm(HttpServletRequest request, HttpServletResponse response, String user_id,
			String qr_log_mark) throws UnsupportedEncodingException {
		HttpSession session = request.getSession(false);
		String session_qr_log_mark = session.getAttribute("qr_log_mark").toString();
		String url = "";
//		if (qr_log_mark != null && qr_log_mark.equals(session_qr_log_mark)) {
//			User user = this.userService
//					.getObjById(CommUtil.null2Long(user_id));
//			request.getSession(false).removeAttribute("verify_code");// 清空验证码信息
//			url = "redirect:" + CommUtil.getURL(request)
//					+ "/b2b2c_login.htm?username="
//					+ CommUtil.encode(user.getUsername()) + "&password="
//					+ Globals.THIRD_ACCOUNT_LOGIN + user.getPassword();
//
//		}
		return url;
	}

	/**
	 * 生成登录二维码，封装一个随机信息到二维码中，同时保存到系统session中
	 * 
	 * @param request
	 * @param qr_session_id
	 * @return
	 */
	private String generic_qr(HttpServletRequest request, String qr_session_id) {
		String uploadFilePath = this.configService.getSysConfig().getUploadFilePath();
		String path = request.getSession().getServletContext().getRealPath("") + File.separator
				+ uploadFilePath + File.separator + "qr_login";
		CommUtil.createFolder(path);
		// 生成登录地址二维码
		String rand_str = "";
		if (!CommUtil.null2String(qr_session_id).equals("")) {
			rand_str = qr_session_id;
		} else {
			rand_str = UUID.randomUUID().toString();
		}
		request.getSession().setAttribute("qr_session_id", rand_str);
		String login_url = CommUtil.getURL(request) + "/b2b2c_login.htm?qr_session_id=" + rand_str;
		request.getSession().setAttribute("qr_session_id", rand_str);
		String logoPath = "";
//		if (this.configService.getSysConfig().getQr_logo() != null) {
//			logoPath = request.getSession().getServletContext()
//					.getRealPath("/")
//					+ this.configService.getSysConfig().getQr_logo().getPath()
//					+ File.separator
//					+ this.configService.getSysConfig().getQr_logo().getName();
//		}
		QRCodeUtil.encode(login_url, logoPath, path + "/qr_" + rand_str + ".png", true);
		return rand_str;
	}

	/**
	 * 微信授权后系统注册用户成功跳转页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/weChatRegisterSuccess.htm")
	public ModelAndView weChat_register_success(HttpServletRequest request, HttpServletResponse response,
			String username, String password, String code, String encode) {

		log.info("*************** weChat Authorized login success Page **************** ");

		ModelAndView mv = new JModelAndView("mobile/weChat_register-success.html",
				configService.getSysConfig(), 1, request, response);
		mv.addObject("username", username);
		mv.addObject("password", password);
		mv.addObject("code", code);
		mv.addObject("encode", true);
		request.getSession().setAttribute("verify_code", " ");
		return mv;
	}

	@RequestMapping("/test_boundPhone.htm")
	public ModelAndView test_boundPhone(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("boundPhone/boundPhone.html", configService.getSysConfig(), 1,
				request, response);
		String webPath = CommUtil.getURL(request);
		mv.addObject("webPath", webPath);
		return mv;
	}

	/**
	 * 手机注册成功跳转页面
	 * 
	 * @param request
	 * @return
	 * @author yuleijia
	 */
	/*@RequestMapping("/weChat_register_success.htm")
	public ModelAndView weChat_register_success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("mobile/register-success.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}*/
	/**
	 * 微信授权-绑定手机-发送短信验证码
	 * 
	 * @param request
	 * @param response
	 * @param code
	 * @param mobile
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/boundMoblie_reg_code_get.htm")
	public void boundMoblie_reg_code_get(HttpServletRequest request, HttpServletResponse response,
			String mobile) throws UnsupportedEncodingException {
		int ret = 0;// 0为发送失败，1为发送成功，-1为邮件发送失败，-2为手机短信发送失败
		// HttpSession session = request.getSession(false);
		// String verify_code = "";
		// verify_code = (String) session.getAttribute("verify_code");
		boolean isSend = true;
		/*if (code != null && !code.equals("") && verify_code != null && !verify_code.equals("")) {
			if (CommUtil.null2String(code.toUpperCase()).equals(verify_code)) {
				isSend = true;
			}
		}*/
		UserAccountBO vo = new UserAccountBO();
		vo.setAccountType(UserContant.ACCOUNT_TYPE_2);
		vo.setLoginName(mobile);
		UserAccount phoneUserAccount = accountService.findUserAccount(mobile, UserContant.ACCOUNT_TYPE_2);
		if (phoneUserAccount != null && phoneUserAccount.getId() != 0l) {
			Long uid = phoneUserAccount.getUid();
			UserAccount weChatUserAccount = accountService.findUserAccount(uid, UserContant.ACCOUNT_TYPE_4);
			if (weChatUserAccount != null && weChatUserAccount.getId() != 0l) {
				isSend = false;
				ret = 2; // 当前手机号已绑定微信号
			}
		}
		if (isSend) {
			Boolean bo = customerService.sendRegisterValidateCode(mobile, IPUtil.getIpAddr(request));
			if (bo) {
				ret = 1;
				// session.removeAttribute("verify_code");
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
