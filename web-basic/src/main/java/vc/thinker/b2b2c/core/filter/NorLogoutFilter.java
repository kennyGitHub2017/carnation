package vc.thinker.b2b2c.core.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.SysLog;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysLogServiceImpl;

/**
 * 
 * <p>
 * Title: NorLogoutFilter.java
 * </p>
 * 
 * <p>
 * Description: SpringSecurity用户退出过滤器，重写LogoutFilter，用来记录用户退出信息，及清除用户登录时保存的相关session信息
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
public class NorLogoutFilter extends LogoutFilter {

	@Autowired
	private SysLogServiceImpl sysLogService;

	public void saveLog(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String thinkervc_view_type = CommUtil.null2String(request.getParameter("thinkervc_view_type"));
		session.setAttribute("thinkervc_view_type", thinkervc_view_type);
		User u = (User) session.getAttribute("user");
		if (u != null) {
			SysLog log = new SysLog();
			log.setAddTime(new Date());
			log.setContent("[" + u.getId() + "]于" + CommUtil.formatTime("yyyy-MM-dd HH:mm:ss", new Date())
					+ "退出系统");
			log.setTitle("用户退出");
			log.setType(0);
			log.setUserId(u.getId());
			log.setIp(CommUtil.getIpAddr(request));
			this.sysLogService.save(log);
		}
	}

	public NorLogoutFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
		super(logoutSuccessUrl, handlers);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
			ServletException {
		// TODO Auto-generated method stub
		// super.doFilter(req, res, chain);
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if (requiresLogout(request, response)) {
			HttpSession session = request.getSession(false);
			if (null != session) {
				saveLog(request);
			}
		}
		super.doFilter(request, response, chain);
	}

}
