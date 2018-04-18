package vc.thinker.b2b2c.action.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.ImageViewTools;

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

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private ImageViewTools imageViewTools;

	@SuppressWarnings("unused")
	private static final String REGEX1 = "(.*管理员.*)";
	@SuppressWarnings("unused")
	private static final String REGEX2 = "(.*admin.*)";

	/**
	 * 用户登录页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/user/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String url) {
		ModelAndView mv = new JModelAndView("login.html", configService.getSysConfig(), 1, request, response);
		request.getSession(false).removeAttribute("verify_code");
		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if (url != null && !url.equals("")) {
			request.getSession(false).setAttribute("refererUrl", url);
		}
		if (domain_error) {
			mv.addObject("op_title", "域名绑定错误，请与http://www.ysysgo.com联系");
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
		} else {
			mv.addObject("imageViewTools", imageViewTools);
		}
		return mv;
	}

	/**
	 * springsecurity登录成功后跳转到该页面，如有登录相关处理可以在该方法中完成
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/user_login_success.htm")
	public String user_login_success(HttpServletRequest request, HttpServletResponse response) {
		String url = CommUtil.getURL(request) + "/index.htm";
		HttpSession session = request.getSession(false);
		if (session.getAttribute("refererUrl") != null && !session.getAttribute("refererUrl").equals("")) {
			url = (String) session.getAttribute("refererUrl");
			session.removeAttribute("refererUrl");
		}
		String bind = CommUtil.null2String(request.getSession(false).getAttribute("bind"));
		if (!bind.equals("")) {
			return "redirect:out_login_success.htm";
		}
		return "redirect:" + url;
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
}
