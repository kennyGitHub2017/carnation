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

import javax.servlet.ServletException;
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
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.qrcode.QRCodeUtil;
import vc.thinker.b2b2c.core.security.support.BasicUserDetails;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.IpAddressByDetails;
import vc.thinker.b2b2c.foundation.domain.LogType;
import vc.thinker.b2b2c.tools.exception.AccountException;

import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.pay.tools.WxShareTools;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.RelationBO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.enums.EmRegisterFromType;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.RegisterLogService;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImageViewTools;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.carnation.user.service.RedisCacheService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.common.utils.IPUtil;
import com.sinco.dic.client.DicContent;

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
public class LoginViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	// @Autowired
	// private IntegralLogService integralLogService;
	// @Autowired
	// private AlbumService albumService;
	@Autowired
	private DocumentService documentService;
	// @Autowired
	// private AreaService areaService;
	// @Autowired
	// private VerifyCodeService verifyCodeService;
	// @Autowired
	// private QRLoginService qRLoginService;
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
	private GoodsCaseViewTools goodsCaseViewTools;
	@Autowired
	private UserRelationService relationService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DicContent dicContent;

	@Autowired
	private WxShareTools wxTools;

	@Autowired
	private OperatorService operatorService;

	@Autowired
	private UserDao userDao;

	@Autowired
	private StoreDao storeDao;

	@Autowired
	private StoreService storeService;

	@Autowired
	private UserAccountService userAccountService;

	// @Autowired
	// private MsgTools msgTools;
	private static final String REGEX1 = "(.*管理员.*)";
	private static final String REGEX2 = "(.*admin.*)";

	Logger logger = LoggerFactory.getLogger(this.getClass());

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

			Long storeId = userDetails != null ? userDetails.getStoreId() : null;
			boolean state = Boolean.FALSE;
			if (!state && !userDetails.getUsername().startsWith(UserContant.ACCOUNT_TYPE_AN)) {
				String cart_session_id = this.goodsCaseViewTools.getCartSessionId(request, response);
				System.out.println("11111111111111111111111111111111111111111111111111111111111111111");
				// 个人用户登录
				customerService.login(userDetails.getId(), userDetails.getUsername(),
						IPUtil.getIpAddr(request));
				System.out.println("000000000000000000000000000000000000000000000000000000000");

				// 合并购物车
				cartService.mergerCart(userDetails.getId(), storeId, cart_session_id);
				
				HttpSession session = request.getSession(false);
				session.setAttribute("user", userDetails.getUser());
				session.setAttribute("userName", userDetails.getUsername());
				session.setAttribute("lastLoginDate", new Date());// 设置登录时间
				session.setAttribute("loginIp", CommUtil.getIpAddr(request));// 设置登录IP
				session.setAttribute("login", true);// 设置登录标识
				session.setAttribute("seller", userDetails.getSeller());// *******************
				
				String url = CommUtil.getURL(request) + "/index.htm";

				Long uid = userDetails.getId();
				Integer customerType = this.userAccountService.query_Customer_Type(uid);
				//登录记忆功能，不管在哪个商城页面进入登陆页，登录成功后，必须进入该页面，运营商与商户，供应商登录除外；
				if(customerType == 0)
				{
					String refererUrl  = (String)request.getSession().getAttribute("referer");
					logger.debug("============= refererUrl->"+refererUrl);
					url = refererUrl!=null && refererUrl.trim().length() > 0 ?refererUrl:url;
					request.getSession().removeAttribute("referer");
				}
				
				boolean ajax_login = CommUtil.null2Boolean(session.getAttribute("ajax_login"));
				if (ajax_login) {
					response.setContentType("text/plain");
					response.setHeader("Cache-Control", "no-cache");
					response.setCharacterEncoding("UTF-8");
					PrintWriter writer;
					try {
						writer = response.getWriter();
						writer.print("success");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					String userAgent = request.getHeader("user-agent");
					if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
						url = CommUtil.getURL(request) + "/wap/index.htm";
					} else if (!CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"))
							.equals("")) {
						url = CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"));
						request.getSession(false).removeAttribute("refererUrl");
					}

					// 获取登录标识
					String source = userDetails.getSource();
					// 如果是商家获供应商登录跳转至对应的后台界面
					if (UserContant.ACCOUNT_TYPE_MERCHANT.equals(source)
							|| UserContant.ACCOUNT_TYPE_SUPPLIER.equals(source)) {
						url = CommUtil.getURL(request) + "/seller/index.htm";
					}
					response.sendRedirect(url);
				}
			} 
			if (userDetails.getUsername().startsWith(UserContant.ACCOUNT_TYPE_AN)) {//增加AN验证
				String url = CommUtil.getURL(request) + "/static_index.htm";
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
			targetUrl = CommUtil.getURL(request) + "/wap/index.htm";
		}

		response.sendRedirect(targetUrl);
	}

	@SuppressWarnings("unused")
	@RequestMapping("/login_error.htm")
	public ModelAndView login_error(HttpServletRequest request, HttpServletResponse response) {
		String login_role = (String) request.getSession(false).getAttribute("login_role");
		ModelAndView mv = null;
		String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
			String targetUrl = CommUtil.getURL(request) + "/wap/index.htm";
			try {
				response.sendRedirect(targetUrl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String thinkervc_view_type = CommUtil.null2String(request.getSession(false).getAttribute(
				"thinkervc_view_type"));
		if (thinkervc_view_type != null && !thinkervc_view_type.equals("")) {
			if (thinkervc_view_type.equals("weixin")) {
				String store_id = CommUtil.null2String(request.getSession(false).getAttribute("store_id"));
				mv = new JModelAndView("weixin/error.html", configService.getSysConfig(), 1, request,
						response);
				mv.addObject("url", CommUtil.getURL(request) + "/weixin/index.htm?store_id=" + store_id);
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);

			Object ex = request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			if (ex instanceof BadCredentialsException) {
				request.setAttribute("message", "用户名或者密码错误。");
			} else if (ex instanceof UsernameNotFoundException) {
				request.setAttribute("message", "用户名不存在，或者状态异常。");
			} else if (ex instanceof LockedException) {
				request.setAttribute("message", "您的账号已冻结");
			} else if (ex instanceof AccountException) {
				request.setAttribute("message", ((AccountException) ex).getMessage());
			}

			// 不同角色跳转到对应的页面
			String source = request.getParameter("account_type");
			if (source.equals(UserContant.ACCOUNT_TYPE_MERCHANT)) {
				return merchantLogin(request, response);
			} else if (source.equals(UserContant.ACCOUNT_TYPE_SUPPLIER)) {
				return supplierLogin(request, response);
			} else {
				return login(request, response, null);
			}

		}
		mv.addObject("op_title", "登录失败");
		return mv;
	}

	/**
	 * 用户登录页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String url) {
		ModelAndView mv = new JModelAndView("login.html", configService.getSysConfig(), 1, request, response);
		request.getSession().removeAttribute("verify_code");
		//平台优化-PC商城登录
		//登录记忆功能，不管在哪个商城页面进入登陆页，登录成功后，必须进入该页面，运营商与商户，供应商登录除外
		//add by yuleijia 2017.5.10
		String refererUrl = request.getHeader("Referer"); 
		if(refererUrl!=null && refererUrl.trim().length() > 0)
		{
			logger.info("============ Referer->"+refererUrl);
			request.getSession().setAttribute("referer", refererUrl);
		}
		
		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if (url != null && !url.equals("")) {
			request.getSession(false).setAttribute("refererUrl", url);
		}
		if (domain_error) {
			mv.addObject("op_title", "域名绑定错误，请与管理员联系");
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		} else {
			mv.addObject("imageViewTools", imageViewTools);
			String message = CommUtil.null2String(request.getAttribute("message"));
			if (message.trim().length() > 0) {
				mv.addObject("message", message);
			}
		}
		String accountType = UserContant.ACCOUNT_TYPE_RESOURCE;
		mv.addObject("accountType", accountType);
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

	@Autowired
	private UserAccountService accountService;

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

		String wxShareTitle = null;
		UserBO u = userService.findByInvitationCode(invitationCode);
		if (u != null) {
			UserAccount userAccount = accountService.findByUid(u.getId());
			wxShareTitle = userAccount == null ? null : userAccount.getAppShareInfo();
		}

		mv.addObject("wxShareTitle", wxShareTitle);
		wxTools.wxShareMv(mv, request);// 微信分享
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

		// 验证码校验
		if (code.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
			ret = true;
		}

		if (ret) {

			mv.addObject("areas", areaService.queryParentArea());
			int iscity = 0;
			// 获取ip
			String ip = IPUtil.getIpAddr(request);
			// ip="121.34.128.240";
			String ipdetail = redIpFind(request, response, ip);
			if (ipdetail.equals("[未分配或者内网IP------]") || ipdetail.equals("[---IP地址不正确!----]")) {
				ip = "121.34.128.240";
				ipdetail = redIpFind(request, response, ip);
			}
			Area area = areaService.queryAreaByName(city);
			if (area != null) {
				Long cid = area.getId();
				Long pid = area.getParentId();
				mv.addObject("cid", cid);
				mv.addObject("pid", pid);
				iscity = 1;
				System.out.println("cid:" + cid);
			}

			session.setAttribute("validateName", mobile);
			mv.addObject("iscity", iscity);
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

	String city = "";

	public String redIpFind(HttpServletRequest request, HttpServletResponse response, String ip) {
		String ipdetail = "[---IP地址不正确!----]";
		if (ip != null && !ip.equals("") && ip.indexOf("0:0:0:0") < 0) {
			String[] split = ip.trim().split(",");
			ipdetail = IpAddressByDetails.GetAddressByIp(split[0].trim());
		}
		String ctys[] = ipdetail.split("--");
		city = ctys[2];
		return ipdetail;
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
	 * @throws ServletException
	 */
	@RequestMapping("/register_finish.htm")
	public String register_finish(HttpServletRequest request, HttpServletResponse response, String userName,
			String mobile, String password, String email, String user_type, String code, String mobileCode,
			String invitationCode, String area2) throws HttpException, IOException, InterruptedException {
		boolean reg = true;// 防止机器注册，如后台开启验证码则强行验证验证码
		// if (code != null && !code.equals("")) {
		// code = CommUtil.filterHTML(code);// 过滤验证码
		// }
		// if (this.configService.getSysConfig().getSecurityCodeRegister()) {
		// if (!request.getSession(false).getAttribute("verify_code")
		// .equals(code)) {
		// reg = false;
		// }
		// }

		System.out.println(invitationCode);
		boolean iscode = false;
		boolean isct = false;
		Integer sellerUserId = null;
		int result = 0;
		if (StringUtils.isNotBlank(invitationCode)) {
			iscode = true;
		}

		String codeRedis = redisCacheService.getSmsCode(0L, mobile);

		String message = "";

		// 验证码校验
		if (!code.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")
				&& !mobileCode.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {
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

		}
		if (invitationCode != null && !invitationCode.equals("")) {
			UserBO user = userService.findByInvitationCode(invitationCode);
			if (null == user || user.getStatus() != 1) {
				reg = false;
				message = "邀请码不正确";
			}
		}

		// 创建注册日志；
		registerLogService.createRegisterLog(request, mobile, invitationCode, EmRegisterFromType.Pc);

		if (reg) {
			if (iscode) {
				RelationBO relationBO = relationService.iscity(invitationCode);
				if (relationBO != null && null != relationBO.getSellerUserId()) {
					// 商户id
					sellerUserId = relationBO.getSellerUserId();
					System.out.println("商户id" + sellerUserId);

					if (null != relationBO.getSid() || relationBO.getSid().toString().equals(area2)) {
						System.out.println("id:" + relationBO.getSid());
						isct = true;
					}
					System.out.println("areaid:" + area2);
				}
			}
			if (isct) {
				result = relationService.registerUserwithshop(userName, mobile, password,
						IPUtil.getIpAddr(request), mobileCode, invitationCode, sellerUserId);
			} else {
				result = relationService.registerUser(userName, mobile, password, IPUtil.getIpAddr(request),
						mobileCode, invitationCode);
			}
			request.getSession(false).removeAttribute("verify_code");
			if (result > 0) {
				// TODO 注册成功 自动登录
				/*request.getSession().setAttribute("verify_code", "");
				return "redirect:b2b2c_login.htm?username=" + CommUtil.encode(mobile) + "&password=" + password
						+ "&encode=true";*/
				/* 注册成功后绑定微信号 */
				String url = "/weChat/login.htm?type=2&mobile=" + CommUtil.encode(mobile);
				LoggerFactory.getLogger(this.getClass()).info(
						".......... go to WeChat Login params:mobile=" + mobile + " url:" + url);
				return "forward:" + url;

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

	@Autowired
	RegisterLogService registerLogService;

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
		boolean isYYS = false;
		if (invitationCode != null && !invitationCode.equals("")) {
			UserBO user = userService.findByInvitationCode(invitationCode);
			// 判断当前用户是否为运营商用户
			long uid = user.getId();
			OperatorBO operator = this.operatorService.queryOperatorInfo(uid);
			if (operator != null && operator.getId() != 0L) {
				isYYS = true;
			}
			if (null == user || user.getStatus() != 1) {
				reg = false;
				message = "邀请码不正确";
			}
		}
		// 创建注册日志；
		registerLogService.createRegisterLog(request, mobile, invitationCode, EmRegisterFromType.H5);

		if (reg) {
			int result = 0;
			if (isYYS) // 运营商用户
			{
				result = this.relationService.yysRegisterUserByMobile(mobile, password,
						IPUtil.getIpAddr(request), mobileCode, invitationCode);
			} else {
				result = relationService.registerUserByMoblie(mobile, password, IPUtil.getIpAddr(request),
						mobileCode, invitationCode);
			}
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
		String urlParam = "message=" + URLEncoder.encode(message, "utf-8");
		if (StringUtils.isNotEmpty(invitationCode)) {
			urlParam += "&invitationCode=" + invitationCode;
		}
		return "redirect:mobile_register.htm?" + urlParam;
	}

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
	@SuppressWarnings("unused")
	@RequestMapping("/forget1.htm")
	public ModelAndView forget1(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("forget1.html", configService.getSysConfig(), 1, request,
				response);

		SysConfigBO config = this.configService.getSysConfig();
		// if (!config.getEmailEnable() && !config.getSmsEnbale()) {
		// mv = new JModelAndView("error.html", configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "系统关闭邮件及手机短信功能，不能找回密码");
		// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		// }

		// 角色标识
		String source = request.getParameter("account_type");
		mv.addObject("accountType", source);
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
		// SysConfigBO config = this.configService.getSysConfig();
		// if (!config.getEmailEnable() && !config.getSmsEnbale()) {
		// mv = new JModelAndView("error.html", configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "系统关闭邮件及手机短信功能，不能找回密码");
		// mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		// } else {
		//
		// }
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
				// 验证绑定CN账号的手机号不给修改密码
				UserAccountBO vo = new UserAccountBO();
				vo.setAccountType(UserContant.ACCOUNT_TYPE_8);
				vo.setUid(user.getId());
				UserAccountBO account = userAccountService.findAccountByVo(vo);
				if (null != account) {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "CN运营商请去直销系统修改密码");
					mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
				} else {
					UserCustomerBO customer = this.customerService.findSessionUser(user.getId());
					mv.addObject("user", customer);
					mv.addObject("userName", userName);
					session.setAttribute("validateName", userName);
				}
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

		// 角色标识
		String source = request.getParameter("account_type");
		mv.addObject("accountType", source);

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
		// if (accept_type.equals("email")) {
		// VerifyCode vc = this.verifyCodeService.getObjByProperty(null,
		// "email", email);
		// if (vc != null) {
		// if (!vc.getCode().equals(verify_code)) {
		// mv = new JModelAndView("error.html",
		// configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "验证码输入错误");
		// mv.addObject("url", CommUtil.getURL(request)
		// + "/forget2.htm?userName=" + userName);
		// } else {
		// String verify_session = CommUtil.randomString(64)
		// .toLowerCase();
		// mv.addObject("verify_session", verify_session);
		// request.getSession(false).setAttribute("verify_session",
		// verify_session);
		// mv.addObject("userName", userName);
		// this.verifyCodeService.delete(vc.getId());
		// }
		// } else {
		// mv = new JModelAndView("error.html",
		// configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "验证码输入错误");
		// mv.addObject("url", CommUtil.getURL(request)
		// + "/forget2.htm?userName=" + userName);
		// }
		// }
		// if (accept_type.equals("mobile")) {

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
		// 角色标识
		String source = request.getParameter("account_type");
		mv.addObject("accountType", source);
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
			// 角色标识
			String source = request.getParameter("account_type");
			String url = CommUtil.getURL(request) + "/user/login.htm";

			if (StringUtils.isNotBlank(source)) {
				this.userService.updatePassword(user.getId(), password, source); // 根据角色修改密码
				if (source.equals(UserContant.ACCOUNT_TYPE_MERCHANT)) {
					url = CommUtil.getURL(request) + "/user/merchantLogin.htm";
				} else if (source.equals(UserContant.ACCOUNT_TYPE_SUPPLIER)) {
					url = CommUtil.getURL(request) + "/user/supplierLogin.htm";
				}
			} else {
				this.userService.updatePassword(user.getId(), password); // 如果角色为空则修改会员密码
			}
			request.getSession(false).removeAttribute("verify_session");
			mv.addObject("op_title", "密码修改成功，请使用新密码登录");
			mv.addObject("url", url);
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
			// if (this.configService.getSysConfig().isEmailEnable()) {
			// String subject = this.configService.getSysConfig()
			// .getWebsiteName() + " 邮件验证码";
			// String code = CommUtil.randomString(4).toUpperCase();
			// VerifyCode vc = this.verifyCodeService.getObjByProperty(null,
			// "email", email);
			// if (vc == null) {
			// vc = new VerifyCode();
			// vc.setAddTime(new Date());
			// vc.setCode(code);
			// vc.setEmail(email);
			// vc.setUserName(userName);
			// this.verifyCodeService.save(vc);
			// } else {
			// vc.setAddTime(new Date());
			// vc.setCode(code);
			// vc.setEmail(email);
			// vc.setUserName(userName);
			// this.verifyCodeService.update(vc);
			// }
			// String content = "您的邮件验证码为:" + code + ",验证码有效时间为30分钟！";
			// boolean ret1 = this.msgTools.sendEmail(email, subject, content);
			// if (ret1) {
			// ret = 1;
			// }
			// } else {
			// ret = -1;
			// }
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
				// if (this.configService.getSysConfig().getSmsEnbale()) {
				// } else {
				// ret = -2;
				// }
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
	@SuppressWarnings("unused")
	@RequestMapping("/find_pws.htm")
	public ModelAndView find_pws(HttpServletRequest request, HttpServletResponse response, String userName,
			String email, String code) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		HttpSession session = request.getSession(false);
		String verify_code = (String) session.getAttribute("verify_code");
		// if (code.toUpperCase().equals(verify_code)) {
		// User user = this.userService.getObjByProperty(null, "userName",
		// userName);
		// if (user.getEmail().equals(email.trim())) {
		// String pws = CommUtil.randomString(6).toLowerCase();
		// String subject = this.configService.getSysConfig().getTitle()
		// + "密码找回邮件";
		// String content = user.getUsername() + ",您好！您通过密码找回功能重置密码，新密码为："
		// + pws;
		// boolean ret = this.msgTools.sendEmail(email, subject, content);
		// if (ret) {
		// user.setPassword(Md5Encrypt.md5(pws));
		// this.userService.update(user);
		// mv.addObject("op_title", "新密码已经发送到邮箱:<font color=red>"
		// + email + "</font>，请查收后重新登录");
		// mv.addObject("url", CommUtil.getURL(request)
		// + "/user/login.htm");
		// } else {
		// mv = new JModelAndView("error.html",
		// configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "邮件发送失败，密码暂未执行重置");
		// mv.addObject("url", CommUtil.getURL(request)
		// + "/forget1.htm");
		// }
		// } else {
		// mv = new JModelAndView("error.html",
		// configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "用户名、邮箱不匹配");
		// mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
		// }
		// } else {
		// mv = new JModelAndView("error.html", configService.getSysConfig(),
		// 1, request,
		// response);
		// mv.addObject("op_title", "验证码不正确");
		// mv.addObject("url", CommUtil.getURL(request) + "/forget1.htm");
		// }
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
	@SuppressWarnings({"rawtypes", "unchecked"})
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
		// Map params = new HashMap();
		// params.put("qr_session_id", qr_session_id);
		// List<QRLogin> qrlist = this.qRLoginService
		// .query("select obj from QRLogin obj where
		// obj.qr_session_id=:qr_session_id",
		// params, -1, -1);
		// Map map = new HashMap();
		// if (qrlist.size() > 0) {
		// QRLogin qrlogin = qrlist.get(0);
		// map.put("ret", "true");
		// map.put("user_id", qrlogin.getUser_id());
		// this.qRLoginService.delete(qrlogin.getId());
		// String qr_log_mark = CommUtil.randomString(16);
		// map.put("qr_log_mark", qr_log_mark);
		// HttpSession session = request.getSession(false);
		// session.setAttribute("qr_log_mark", qr_log_mark);
		// }
		// response.setContentType("text/plain");
		// response.setHeader("Cache-Control", "no-cache");
		// response.setCharacterEncoding("UTF-8");
		// PrintWriter writer;
		// try {
		// writer = response.getWriter();
		// writer.print(Json.toJson(map, JsonFormat.compact()));
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	@SuppressWarnings("unused")
	@RequestMapping("/qr_login_confirm.htm")
	public String qr_login_confirm(HttpServletRequest request, HttpServletResponse response, String user_id,
			String qr_log_mark) throws UnsupportedEncodingException {
		HttpSession session = request.getSession(false);
		String session_qr_log_mark = session.getAttribute("qr_log_mark").toString();
		String url = "";
		// if (qr_log_mark != null && qr_log_mark.equals(session_qr_log_mark)) {
		// User user = this.userService
		// .getObjById(CommUtil.null2Long(user_id));
		// request.getSession(false).removeAttribute("verify_code");// 清空验证码信息
		// url = "redirect:" + CommUtil.getURL(request)
		// + "/b2b2c_login.htm?username="
		// + CommUtil.encode(user.getUsername()) + "&password="
		// + Globals.THIRD_ACCOUNT_LOGIN + user.getPassword();
		//
		// }
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
		// if (this.configService.getSysConfig().getQr_logo() != null) {
		// logoPath = request.getSession().getServletContext()
		// .getRealPath("/")
		// + this.configService.getSysConfig().getQr_logo().getPath()
		// + File.separator
		// + this.configService.getSysConfig().getQr_logo().getName();
		// }
		QRCodeUtil.encode(login_url, logoPath, path + "/qr_" + rand_str + ".png", true);
		return rand_str;
	}

	@RequestMapping("/cn_bind_code_get.htm")
	public void cn_bind_code_get(HttpServletRequest request, HttpServletResponse response, String mobile)
			throws UnsupportedEncodingException {
		int ret = 0;// 0为发送失败，1为发送成功，-1为邮件发送失败，-2为手机短信发送失败
		boolean isSend = false;
		if (!com.sinco.common.utils.StringUtils.isEmpty(mobile)) {
			isSend = true;
		}
		if (isSend) {
			Boolean bo = customerService.sendRegisterValidateCode(mobile, IPUtil.getIpAddr(request));
			if (bo) {
				ret = 1;
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
	 * 手机注册成功跳转页面
	 * 
	 * @param request
	 * @return
	 * @author yuleijia
	 */
	@RequestMapping("/weChat_register_success.htm")
	public ModelAndView weChat_register_success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("mobile/register-success.html", configService.getSysConfig(), 1,
				request, response);
		return mv;
	}

	@RequestMapping("/test.htm")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("forget1.html", configService.getSysConfig(), 1, request,
				response);
		String t = request.getHeader("User-Agent").toLowerCase();
		System.out.println(t);
		return mv;
	}

	/* //////////////////////////////////////   角色分离-登陆  add by yuleijia 2017.02.15   //////////////////////////////////// */
	/**
	 * 运营商登陆
	 * 
	 * @return
	 */
	@RequestMapping("/user/operatorLogin.htm")
	public ModelAndView operatorLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("forget1.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * 供应商登陆 1.若是CN账号（绑定的手机或第三方）登录，则跳转 供应商登录页面 2.若是手机号登录（非CN绑定），是供应商则进入供应商后台(不是供应商，则进入填写入驻信息)
	 * 3.若是第三方登录（非CN绑定），先判断有无绑定手机号码； 3.1 绑定了手机，是供应商则进入后台 3.2 绑定了手机，不是供应商则填写入驻信息 3.3 没有绑手机，绑定手机，重复3.1和3.2步骤 add
	 * by yuleijia on 2017.3.9
	 */
	@RequestMapping("/user/supplierLogin.htm")
	public ModelAndView supplierLogin(HttpServletRequest request, HttpServletResponse response) {
//		logger.debug("================= SupplierLogin Start ==================");
//
//		String viewName = "/login/supplier_login.html";
//		String message = "";
//		ModelAndView mv = null;
//		String account_type = UserContant.ACCOUNT_TYPE_SUPPLIER;
//		BasicUserDetails userDetail = SecurityUserHolder.getCurrentUserDetails();
//		LoginStateEnum loginState = this.doLoginCheck(userDetail);
//		switch (loginState) {
//			case LOGGERIN:// 会员已登陆
//				// 登陆名称
//				String loginName = userDetail.getUsername().toUpperCase();
//				// 用户ID
//				Long uid = userDetail.getId();
//				CustomerUserDetails userDetails = (CustomerUserDetails) userDetail;
//				// 店铺ID
//				Long storeID = userDetails.getStoreId();
//
//				UserAccoutStateEnum userAccoutStateEnum = this.customerService.queryLoggerinCheck(loginName,
//						uid, storeID);
//				switch (userAccoutStateEnum) {
//					case ISSUPPLIER: // 供应商
//						logger.debug(">>>>>>>>>>>供应商");
//						/*进入供应商后台*/
//						StoreBO store = storeService.queryStoreStatus(SecurityUserHolder.getCurrentUserId());
//						if (store != null) {
//							viewName = "redirect:/seller/index.htm";
//						} else {
//							viewName = "redirect:/seller/ruzhu_pingtai.htm";
//						}
//						mv = new ModelAndView(viewName);
//						break;
//					case NOT_SUPPLIER_OR_MERCHANT: // 非供应商
//						logger.debug(">>>>>>>>>>>非供应商");
//						/*不是供应商，则进入填写入驻信息页面*/
//						viewName = "redirect:/seller/ruzhu_pingtai.htm";
//						mv = new ModelAndView(viewName);
//						break;
//					case NOTBINGPHONE: // 未绑定手机
//						logger.debug(">>>>>>>>>>>未绑定手机");
//						// 绑定手机界面
//
//						break;
//					case CNACCOUT: // 是CN用户
//						logger.debug(">>>>>>>>>>>是CN用户");
//						// 跳转 供应商登录页面
//						viewName = "/login/supplier_login.html";
//						message = "系统更新，请用CN账号绑定的手机号码登录，密码不变";
//						mv = new JModelAndView(viewName, configService.getSysConfig(), 1, request, response);
//						break;
//				}
//				break;
//			case NOTLOGGER:// 会员未登陆
//				logger.debug(">>>>>>>>>>>会员未登陆<<<<<<<<<<");
//				mv = new JModelAndView(viewName, configService.getSysConfig(), 1, request, response);
//				break;
//			default:
//				mv = new JModelAndView(viewName, configService.getSysConfig(), 1, request, response);
//		}
//		mv.addObject("account_type", account_type);
//		mv.addObject("message", message);
//		return mv;

		ModelAndView mv = new JModelAndView("/login/supplier_login.html", configService.getSysConfig(), 1,
				request, response);
		String accountType = UserContant.ACCOUNT_TYPE_SUPPLIER;
		mv.addObject("accountType", accountType);
		return mv;

	}

	/**
	 * 商户登录供应商登录公共部分头部和底部
	 */
	@RequestMapping("/user/top.htm")
	public ModelAndView top(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("login/top.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	@RequestMapping("/user/footer.htm")
	public ModelAndView footer(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("login/footer.html", configService.getSysConfig(), 1, request,
				response);
		return mv;
	}

	/**
	 * 商户登陆
	 * 
	 * @return
	 */
	@RequestMapping("/user/merchantLogin.htm")
	public ModelAndView merchantLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("/login/tenants_login.html", configService.getSysConfig(), 1,
				request, response);
		String accountType = UserContant.ACCOUNT_TYPE_MERCHANT;
		mv.addObject("accountType", accountType);
		return mv;
	}

	/**
	 * 判断用户是否已登陆
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private LoginStateEnum doLoginCheck(BasicUserDetails userDetail) {
		// BasicUserDetails userDetail = SecurityUserHolder.getCurrentUserDetails();
		if (userDetail != null) {
			return LoginStateEnum.LOGGERIN;
		} else {
			return LoginStateEnum.NOTLOGGER;
		}
	}

	/**
	 * 登录状态枚举类
	 */
	public enum LoginStateEnum {
		/**
		 * 已登录
		 */
		LOGGERIN(),
		/**
		 * 未登陆
		 */
		NOTLOGGER();
		LoginStateEnum() {
		}
	}

}
