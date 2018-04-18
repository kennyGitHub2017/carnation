package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vc.thinker.b2b2c.core.annotation.Log;
import vc.thinker.b2b2c.core.security.support.OperatorUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.foundation.domain.LogType;

import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.SysLogServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.OperatorBO;
import com.sinco.carnation.user.service.OperatorService;
import com.sinco.common.utils.IPUtil;

@Controller
public class LoginAction {
	@Autowired
	private OperatorService operatorService;
	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private SysLogServiceImpl sysLogService;
	@Autowired
	private UserAccountService userAccountService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping("/login.htm")
	public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("verify_code");
		return "login.html";
	}

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
			OperatorUserDetails userDetails = (OperatorUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			String url = CommUtil.getURL(request) + "/operator/index.htm";
			long uid = userDetails.getId();
			System.out.println("ID222===============" + uid);
			// 个人用户登录
			operatorService.login(uid, userDetails.getUsername(), IPUtil.getIpAddr(request));
			/**
			 * 判断用户是否为CN账号
			 */
			boolean isCN = this.userAccountService.check_User_Is_CN(uid);
			logger.info(" ************* isCN = " + isCN);
			if (isCN) {
				logger.info(" ============ User is CN =========== ");
				// 是否首次登陆
				boolean isFirstLanding = this.is_First_Landing(uid);
				logger.info(" ************* isFirstLanding->" + isFirstLanding);
				if (isFirstLanding) // 首次登陆
				{
					// 跳转需完善帐号信息界面
					url = CommUtil.getURL(request) + "/operator/wanShan.htm";
				}
				boolean isAuditStatus = this.check_Audit_Status(uid);
				if (!isAuditStatus && !isFirstLanding) // 审核
				{
					// 跳转到审核提示界面
//					url = CommUtil.getURL(request)+"/operator/shenHe.htm";
					// 无需审核
					url = CommUtil.getURL(request) + "/operator/index.htm";
				}
				/*SysLog sysLog = new SysLog();
				sysLog.setAddTime(new Date());
				sysLog.setDeleteStatus(0);
				sysLog.setIp(CommUtil.getIpAddr(request));
				sysLog.setTitle("CN登陆YY系统");
				sysLog.setType(0);
				sysLog.setUserId(uid);
				sysLog.setUserName(userDetails.getUsername());
				sysLog.setContent("CN账号登陆YY系统");
				this.sysLogService.save(sysLog);*/
			}
			HttpSession session = request.getSession(false);
			session.setAttribute("user", userDetails.getUser());
			session.setAttribute("userName", userDetails.getUsername());
			session.setAttribute("lastLoginDate", new Date());// 设置登录时间
			session.setAttribute("loginIp", CommUtil.getIpAddr(request));// 设置登录IP
			session.setAttribute("login", true);// 设置登录标识
			session.setAttribute("isCN", isCN); // 是否CN账号标识

			logger.info("*********** url->" + url);
			response.sendRedirect(url);
		} else {
			String url = CommUtil.getURL(request) + "/operator/index.htm";
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

		String targetUrl = CommUtil.getURL(request) + "/login.htm";

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

		response.sendRedirect(targetUrl);
	}

	@RequestMapping("/login_error.htm")
	public String login_error(Model model, HttpServletRequest request, HttpServletResponse response) {
		Object ex = request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (ex instanceof BadCredentialsException) {
			model.addAttribute("message", "用户名或者密码错误。");
		} else if (ex instanceof UsernameNotFoundException) {
			model.addAttribute("message", "用户名不存在，或者状态异常。");
		} else if (ex instanceof LockedException)
			request.setAttribute("message", "您的账号已冻结");
		else {
			model.addAttribute("message", "登录失败！");
		}
		return login(model, request, response);
	}

	/**
	 * 判断CN账户是否首次登陆
	 * 
	 * @param uid
	 * @return false:不是 true:是
	 */
	public boolean is_First_Landing(Long uid) {
		logger.info("<<<<<<<<<<<< uid->" + uid);
		UserAccount cn_userAccount = this.userAccountService.get_CN_User(uid);
		String loginName = cn_userAccount.getLoginName();
		OperatorBO operator = this.operatorService.queryOperatorByLoginName(loginName);
		// 身份证为必填项 CN账户在APP或PC首次登陆时系统会为CN账户初始化YY账户 初始化时 身份证号未空
		String idCard = operator.getIdCard();
		if (idCard == null || idCard.trim().length() <= 0) // 首次登陆
		{
			return true;
		}
		return false;
	}

	/**
	 * 检查运营当前审核状态
	 * 
	 * @param uid
	 * @return true:审核通过 false:审核中
	 */
	private boolean check_Audit_Status(Long uid) {
		System.out.println("ID2333===============" + uid);
		OperatorBO operatorBO = operatorService.getOperatorBOByUserId(uid);
		// 检查当前运营商是否已经审核
		// 0=审核中，1=审核通过，-1=审核不通过
		String auditStatus = operatorBO.getStatus();
		if (!"1".equals(auditStatus)) {
			return false;
		}
		return true;
	}

}
