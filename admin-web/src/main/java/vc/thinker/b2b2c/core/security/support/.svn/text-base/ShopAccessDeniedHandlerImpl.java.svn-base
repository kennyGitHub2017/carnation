package vc.thinker.b2b2c.core.security.support;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

import com.sinco.carnation.sys.bo.UserBO;

import edu.emory.mathcs.backport.java.util.Arrays;

/**
 * 
 * <p>
 * Title: ShopAccessDeniedHandlerImpl.java
 * </p>
 * 
 * <p>
 * Description: 重写SpringSecurity权限控制接口，管理系统无权限操作的页面导向，及用户多次登录分别加载对应权限信息，系统可以采用多种登陆机制
 * ，用户从前台登陆，仅仅加载非管理员权限，从管理员页面登陆，通过该控制器加载管理员权限
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
public class ShopAccessDeniedHandlerImpl implements AccessDeniedHandler {
	public static final String SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY = "SPRING_SECURITY_403_EXCEPTION";
	protected static final Log logger = LogFactory.getLog(AccessDeniedHandlerImpl.class);
	private String errorPage;

	@SuppressWarnings({"unused", "unchecked"})
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		this.errorPage = "/authority.htm";
		UserBO user = SecurityUserHolder.getCurrentUser();
		Collection<GrantedAuthority> all_authorities = SecurityUtil.get_all_Authorities(Arrays.asList(user
				.getRoles().toArray()));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<SimpleGrantedAuthority> current_authorities = (Collection<SimpleGrantedAuthority>) auth
				.getAuthorities();
//		if (user.getUserRole().indexOf("ADMIN") < 0) {
//			this.errorPage = "/buyer/authority.htm";
//		} else {
		// for(GrantedAuthority auth1:all_authorities){
		// boolean p=false;
		// for(GrantedAuthority auth2:current_authorities){
		// if(auth1.toString().equals(auth2.toString())){
		// p=true;
		// }
		// }
		// if(p){
		// System.out.println("共同存在:"+auth1.toString());
		// }else{
		// System.out.println("=========================================不存在:"+auth1.toString());
		// }
		// }
//		}
//		if (all_authorities.size() != current_authorities.size()) {
//			this.errorPage = "/admin/login.htm";
//		}
		if (this.errorPage != null) {
			((HttpServletRequest) request).setAttribute("SPRING_SECURITY_403_EXCEPTION",
					accessDeniedException);

			RequestDispatcher rd = request.getRequestDispatcher(this.errorPage);
			rd.forward(request, response);
		}

		if (!response.isCommitted()) {
			((HttpServletResponse) response).sendError(403, accessDeniedException.getMessage());
		}

	}

	@SuppressWarnings("unchecked")
	public void handle(ServletRequest request, ServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		this.errorPage = "/authority.htm";
		UserBO user = SecurityUserHolder.getCurrentUser();
		Collection<GrantedAuthority> all_authorities = SecurityUtil.get_all_Authorities(Arrays.asList(user
				.getRoles().toArray()));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Collection<GrantedAuthority> current_authorities = (Collection<GrantedAuthority>) auth
				.getAuthorities();
		if (user.getUserRole().indexOf("ADMIN") < 0) {
			this.errorPage = "/buyer/authority.htm";
		} else {
			// for(GrantedAuthority auth1:all_authorities){
			// boolean p=false;
			// for(GrantedAuthority auth2:current_authorities){
			// if(auth1.toString().equals(auth2.toString())){
			// p=true;
			// }
			// }
			// if(p){
			// System.out.println("共同存在:"+auth1.toString());
			// }else{
			// System.out.println("=========================================不存在:"+auth1.toString());
			// }
			// }
			if (all_authorities.size() != current_authorities.size()) {
				this.errorPage = "/admin/login.htm";
			}
		}
		if (this.errorPage != null) {
			((HttpServletRequest) request).setAttribute("SPRING_SECURITY_403_EXCEPTION",
					accessDeniedException);

			RequestDispatcher rd = request.getRequestDispatcher(this.errorPage);
			rd.forward(request, response);
		}

		if (!response.isCommitted()) {
			((HttpServletResponse) response).sendError(403, accessDeniedException.getMessage());
		}
	}

	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && (!errorPage.startsWith("/"))) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}

		this.errorPage = errorPage;
	}

}
