package vc.thinker.b2b2c.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 
 * <p>
 * Title: LoginUrlEntryPoint.java
 * </p>
 * 
 * <p>
 * Description: SpringSeurity验证切入点，这里用来辨识是否通过过验证
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
public class LoginUrlEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest req, HttpServletResponse res,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String targetUrl = null;
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getRequestURI();
		if (request.getQueryString() != null && !request.getQueryString().equals("")) {
			url = url + "?" + request.getQueryString();
		}
		request.getSession(false).setAttribute("refererUrl", url);
		// 取得登陆前的url
		String refererUrl = request.getHeader("Referer");
		// TODO 增加处理逻辑
		targetUrl = refererUrl;
		if (url.indexOf("/admin/") >= 0) {// 判断是否为超级管理请求
			targetUrl = request.getContextPath() + "/admin/login.htm";
			request.getSession(false).removeAttribute("refererUrl");
		} else {
			if (url.indexOf("/seller/") >= 0) {// 判断是否为商家中心请求
				targetUrl = request.getContextPath() + "/seller/login.htm";
			} else if (url.indexOf("/delivery/") >= 0) {// 判断是否为自提点中心请求
				targetUrl = request.getContextPath() + "/delivery/login.htm";
			} else if (url.indexOf("/wap/") >= 0) {// 判断是否为wap请求
				targetUrl = request.getContextPath() + "/wap/login.htm";
			} else {
				targetUrl = request.getContextPath() + "/user/login.htm";
			}
		}
		response.sendRedirect(targetUrl);
	}

}
