package vc.thinker.b2b2c.core.security.support;

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
		// TODO 增加处理逻辑
		targetUrl = request.getContextPath() + "/admin/login.htm";
		request.getSession(false).removeAttribute("refererUrl");
		response.sendRedirect(targetUrl);
	}

}
