package com.sinco;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CharactorFilter implements Filter {

	private String encoding = "UTF-8";

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request1 = (HttpServletRequest) request;
		if (encoding != null) {
			if (request1.getRequestURI().toLowerCase().indexOf(".html") > 0) {
				request.setCharacterEncoding(encoding);
				response.setContentType("text/html;charset=" + encoding);
			} else if (request1.getRequestURI().toLowerCase().indexOf(".css") > 0) {
				request.setCharacterEncoding(encoding);
				response.setContentType("text/css;charset=" + encoding);
			}
		}
		chain.doFilter(request, response);

	}

	public void destroy() {

	}

}
