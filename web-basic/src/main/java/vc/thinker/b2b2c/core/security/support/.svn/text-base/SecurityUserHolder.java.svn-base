package vc.thinker.b2b2c.core.security.support;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.common.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import vc.thinker.b2b2c.core.security.token.TokenAuthenticationUtils;

import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.UserService;

/**
 * 
 * <p>
 * Title: SecurityUserHolder.java
 * </p>
 * 
 * <p>
 * Description: SpringSecurity用户获取工具类，该类的静态方法可以直接获取已经登录的用户信息
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2015-5-20
 * 
 * @version 1.0.1
 */
public class SecurityUserHolder {
	private final static Logger log = LoggerFactory.getLogger(SecurityUserHolder.class);

	public static Long getCurrentUserId() {
		UserBO user = getCurrentUser();
		if (user != null) {
			return user.getId();
		}
		return null;
	}

	/**
	 * Returns the current user
	 * 
	 * @return
	 */
	public static UserBO getCurrentUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();

		System.out.println("this is SecurityUserHolder:" + request.getParameter("tag"));

		if (null == request.getParameter("tag")
				|| StringUtils.isBlank(String.valueOf(request.getParameter("tag")))
				|| "false".equals(String.valueOf(request.getParameter("tag")))) {
			if (SecurityContextHolder.getContext().getAuthentication() != null
					&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof BasicUserDetails) {
				return getCurrentUserDetails().getUser();
			} else {
				UserBO user = null;
				if (RequestContextHolder.getRequestAttributes() != null) {
					user = (request.getSession().getAttribute("user") != null ? (UserBO) request.getSession()
							.getAttribute("user") : null);
				}
				return user;
			}
		} else if ("true".equals(String.valueOf(request.getParameter("tag")))) {
			try {
				String authToken = String.valueOf(request.getParameter("uid"));
				String uid = TokenAuthenticationUtils.authenticate(authToken);
				WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
				UserService userService = wac.getBean(UserService.class);
				if (null == userService) {
					return null;
				}
				UserBO userBO = userService.findById(Long.valueOf(uid));
				return userBO;
			} catch (Exception e) {
				log.error("[get user] error", e);
			}

		}
		return null;
	}

	/**
	 * Returns the current user details
	 * 
	 * @return
	 */
	public static BasicUserDetails getCurrentUserDetails() {
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof BasicUserDetails) {

			return (BasicUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		return null;
	}

}
