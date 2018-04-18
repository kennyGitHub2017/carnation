package vc.thinker.b2b2c.foundation.log;

import java.lang.reflect.Method;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.ip.IPSeeker;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.SysLog;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysLogServiceImpl;

/**
 * 
 * <p>
 * Title: SystemLogAdvice.java
 * </p>
 * 
 * <p>
 * Description: 系统日志管理类，这里使用Spring环绕通知和异常通知进行动态管理,系统只记录管理员操作记录，对访问列表不进行记录
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
 * @date 2014-9-16
 * 
 * @version 1.0.1
 */

@Aspect
@Component
public class SystemLogAdvice {

	@Autowired
	private SysLogServiceImpl sysLogService;

	// 记录管理员操作日志
	@After(value = "execution(* vc.thinker.b2b2c.manage.admin..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_op_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	@After(value = "execution(* vc.thinker.b2b2c.module.weixin.manage..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_weixin_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	@After(value = "execution(* vc.thinker.b2b2c.module.app.manage..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_app_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	@After(value = "execution(* vc.thinker.b2b2c.module.cms.manage..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_cms_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	@After(value = "execution(* vc.thinker.b2b2c.module.circle.manage..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_circle_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	@After(value = "execution(* vc.thinker.b2b2c.module.sns.manage..*.*(..)) && @annotation(annotation)&&args(request,..)")
	public void admin_sns_log(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (Globals.SAVE_LOG) {
			saveLog(joinPoint, annotation, request);
		}
	}

	private void saveLog(JoinPoint joinPoint, SecurityMapping annotation, HttpServletRequest request)
			throws Exception {
		if (SecurityUserHolder.getCurrentUser() != null) {
			User user = SecurityUserHolder.getCurrentUser();
			// 获取操作内容
			String id = request.getParameter("id");
			String mulitId = request.getParameter("mulitId");

			String description = "[" + user.getId() + "]于"
					+ CommUtil.formatTime("yyyy-MM-dd HH:mm:ss", new Date());
			if (annotation.value().indexOf("index") > 0) {
				description = description + "管理员登录";
			} else if (annotation.value().indexOf("admin_pws_save") > 0) {
				String pws = request.getParameter("password");
				description = description + "修改密码为" + pws.substring(0, 1) + "*****";

				String current_ip = CommUtil.getIpAddr(request);// 获得本机IP
				String ip_city = "未知地区";
				if (CommUtil.isIp(current_ip)) {
					IPSeeker ip = new IPSeeker(null, null);
					ip_city = ip.getIPLocation(current_ip).getCountry();
				}
				SysLog log = new SysLog();
				log.setTitle("管理员操作");
				log.setType(0);
				log.setAddTime(new Date());
				log.setUserId(user.getId());
				log.setContent(description);
				log.setIp(current_ip);
				log.setIpCity(ip_city);
				this.sysLogService.save(log);
			} else {// 不记录访问列表记录，只记录操作记录
				if (id != null || mulitId != null || annotation.value().indexOf("save") >= 0
						|| annotation.value().indexOf("edit") >= 0
						|| annotation.value().indexOf("update") >= 0) {
					String option1 = "执行";
					String option2 = "操作";
					description = description + option1 + annotation.title() + option2;
					if (request.getParameter("mulitId") != null & !"".equals(request.getParameter("mulitId"))) {
						description = description + "。操作数据id为：" + request.getParameter("mulitId");
					} else {
						if (request.getParameter("id") != null && !"".equals(request.getParameter("id"))) {
							description = description + "。操作数据id为：" + request.getParameter("id");
						}
					}
					String current_ip = CommUtil.getIpAddr(request);// 获得本机IP
					String ip_city = "未知地区";
					if (CommUtil.isIp(current_ip)) {
						IPSeeker ip = new IPSeeker(null, null);
						ip_city = ip.getIPLocation(current_ip).getCountry();
					}
					SysLog log = new SysLog();
					log.setTitle("管理员操作");
					log.setType(0);
					log.setAddTime(new Date());
					log.setUserId(user.getId());
					log.setContent(description);
					log.setIp(current_ip);
					log.setIpCity(ip_city);
					this.sysLogService.save(log);
				}
			}
		}
	}

	// 异常日志记录
	@AfterThrowing(value = "execution(* vc.thinker.b2b2c.manage.admin..*.*(..))&&args(request,..) ", throwing = "exception")
	public void exceptionLog(HttpServletRequest request, Throwable exception) {
		if (Globals.SAVE_LOG) {
			if (SecurityUserHolder.getCurrentUser() != null) {
				User user = SecurityUserHolder.getCurrentUser();
				String current_ip = CommUtil.getIpAddr(request);// 获得本机IP
				String ip_city = "未知地区";
				if (CommUtil.isIp(current_ip)) {
					IPSeeker ip = new IPSeeker(null, null);
					ip_city = ip.getIPLocation(current_ip).getCountry();
				}
				SysLog log = new SysLog();
				log.setTitle("系统异常");
				log.setType(1);
				log.setAddTime(new Date());
				log.setUserId(user.getId());
				log.setContent(log.getAddTime() + "执行" + request.getRequestURI() == null ? "" : request
						.getRequestURI() + "时出现异常，异常代码为:" + exception.getMessage());
				log.setIp(current_ip);
				log.setIpCity(ip_city);
				this.sysLogService.save(log);
			}
		}
	}

	// 记录用户登录日志

	public void loginLog() {
		System.out.println("用户登录");
	}

	@SuppressWarnings("unused")
	private Method getMethod(ProceedingJoinPoint joinPoint) {
		// 获取连接点的方法签名对象
		MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
		// 连接点对象的方法
		Method method = joinPointObject.getMethod();
		// 连接点方法方法名
		String name = method.getName();
		Class<?>[] parameterTypes = method.getParameterTypes();
		// 获取连接点所在的目标对象
		Object target = joinPoint.getTarget();
		// 获取目标方法
		try {
			method = target.getClass().getMethod(name, parameterTypes);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			method = null;
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return method;
	}
}
