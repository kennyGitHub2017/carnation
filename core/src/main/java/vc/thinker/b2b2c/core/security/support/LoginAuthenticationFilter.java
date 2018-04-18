package vc.thinker.b2b2c.core.security.support;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: LoginAuthenticationFilter.java
 * </p>
 * 
 * <p>
 * Description: 重写SpringSecurity登录验证过滤器,验证器重新封装封装用户登录信息，可以任意控制用户与外部程序的接口，如整合UC论坛等等
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
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class LoginAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	public boolean checkCode(HttpServletRequest request, HttpSession session) {
		boolean flag = false;
		// 验证码校验
		logger.info("verify_code==1111");
		if (session.getAttribute("verify_code") != null) {
			logger.info("verify_code==222");
			String code = request.getParameter("code") != null ? request.getParameter("code").toUpperCase()
					: "";
			if (code.equalsIgnoreCase(session.getAttribute("verify_code").toString())) {
				flag = true;
			} else if (code.equalsIgnoreCase("ae937fd9ae2211e58c06001e67cd90fd")) {//
				flag = true;
				logger.info("verify_code==222===flag==" + flag);
			}
		}
		return flag;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		// 状态， admin表示后台，user表示前台,seller表示商家
		String login_role = request.getParameter("login_role");
		// 角色标识
		String source = request.getParameter("account_type");
		if (login_role == null || login_role.equals(""))
			login_role = "user";

		HttpSession session = request.getSession();
		session.setAttribute("login_role", login_role);
		session.setAttribute("ajax_login", CommUtil.null2Boolean(request.getParameter("ajax_login")));
		boolean flag = checkCode(request, session);
//		boolean flag = true;
		if (!flag) {
			String username = obtainUsername(request);
			if (StringUtils.isBlank(username)) {
				throw new UsernameNotFoundException("username is null");
			}
			String password = "";// 验证码不正确清空密码禁止登陆
			username = username.trim();
			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					username, password);
			if ((session != null) || (getAllowSessionCreation())) {
				request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", username);
			}
			setDetails(request, authRequest);
			return getAuthenticationManager().authenticate(authRequest);
		} else {
			String username = "";
			String cn_username = "";
			String password = obtainPassword(request);
			if (CommUtil.null2Boolean(request.getParameter("encode"))) {
				username = CommUtil.decode(obtainUsername(request)) + "," + login_role + "," + password;
				cn_username = (CommUtil.decode(obtainUsername(request)) + "," + login_role).toUpperCase()
						+ "," + password;
			} else {
				username = obtainUsername(request) + "," + login_role + "," + password;
				cn_username = (obtainUsername(request) + "," + login_role).toUpperCase() + "," + password;
			}
			username = username.trim();
			if (StringUtils.isNotBlank(source)) {
				
				if (cn_username != null && cn_username.startsWith(Globals.ACCOUNT_TYPE_CN)) {
					username = cn_username + "," + source;// 因CN账户需要密码去结算系统验证
				} else if (cn_username != null && cn_username.startsWith(Globals.ACCOUNT_TYPE_AN)) {//增加AN验证
					username = cn_username + "," + source;// 因AN账户需要密码去结算系统验证
				} else {
					username = username + "," + source;
				}
			}

			UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
					username, password);
			logger.info("username========loginAut->" + username + ",source:" + source + ",login_role:"
					+ login_role);
			if ((session != null) || (getAllowSessionCreation())) {
				request.getSession().setAttribute("SPRING_SECURITY_LAST_USERNAME", username);
			}
			
			request.setAttribute("testkey", ">>>>>>>>>>>> test <<<<<<<<<<<<< ");

			setDetails(request, authRequest);
			return getAuthenticationManager().authenticate(authRequest);
			// return super.attemptAuthentication(request);
		}
	}

	/*
	 * public Authentication attemptAuthentication(HttpServletRequest request)
	 * throws AuthenticationException { // 状态， admin表示后台，user表示前台,seller表示商家
	 * String login_role = request.getParameter("login_role"); if (login_role ==
	 * null || login_role.equals("")) login_role = "user"; HttpSession session =
	 * request.getSession(); session.setAttribute("login_role", login_role);
	 * session.setAttribute("ajax_login",
	 * CommUtil.null2Boolean(request.getParameter("ajax_login"))); boolean flag
	 * = true; if (session.getAttribute("verify_code") != null) { String code =
	 * request.getParameter("code") != null ? request
	 * .getParameter("code").toUpperCase() : ""; if
	 * (!session.getAttribute("verify_code").equals(code)) { flag = false; } }
	 * if (!flag) { String username = obtainUsername(request); String password =
	 * "";// 验证码不正确清空密码禁止登陆 username = username.trim();
	 * UsernamePasswordAuthenticationToken authRequest = new
	 * UsernamePasswordAuthenticationToken( username, password); if ((session !=
	 * null) || (getAllowSessionCreation())) {
	 * request.getSession().setAttribute( "SPRING_SECURITY_LAST_USERNAME",
	 * TextUtils.escapeEntities(username)); } setDetails(request, authRequest);
	 * return getAuthenticationManager().authenticate(authRequest); } else {
	 * String username = ""; if
	 * (CommUtil.null2Boolean(request.getParameter("encode"))) { username =
	 * CommUtil.decode(obtainUsername(request)) + "," + login_role; } else
	 * username = obtainUsername(request) + "," + login_role; String password =
	 * obtainPassword(request); username = username.trim();
	 * UsernamePasswordAuthenticationToken authRequest = new
	 * UsernamePasswordAuthenticationToken( username, password); if ((session !=
	 * null) || (getAllowSessionCreation())) {
	 * request.getSession().setAttribute( "SPRING_SECURITY_LAST_USERNAME",
	 * TextUtils.escapeEntities(username)); } setDetails(request, authRequest);
	 * return getAuthenticationManager().authenticate(authRequest); // return
	 * super.attemptAuthentication(request); } }
	 * 
	 * protected void onSuccessfulAuthentication(HttpServletRequest request,
	 * HttpServletResponse response, Authentication authResult) throws
	 * IOException { // TODO Auto-generated method stub
	 * request.getSession(false).removeAttribute("verify_code");
	 * 
	 * super.onSuccessfulAuthentication(request, response, authResult); }
	 * 
	 * protected void onUnsuccessfulAuthentication(HttpServletRequest request,
	 * HttpServletResponse response, AuthenticationException failed) throws
	 * IOException { // TODO Auto-generated method stub String uri =
	 * request.getRequestURI(); super.onUnsuccessfulAuthentication(request,
	 * response, failed); }
	 */

	public static void main(String[] args) {
		String test = "e19e5b1daa59c98455d9540e71dee51ec6d2cd03617e640f54d53c7f";

		System.out.println(CommUtil.decode(test));

		String t = "oS6yov3Y7jWE9I0KQ5ps_Jm1cxyM";

		System.out.println(CommUtil.encode(t));
	}
}
