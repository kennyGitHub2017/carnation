package vc.thinker.b2b2c.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.UserAccountService;

public class BullerInterceptorAdapter extends HandlerInterceptorAdapter {
	private static final Logger log = LoggerFactory.getLogger(BullerInterceptorAdapter.class);

	private UserAccountService userAccountService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String path = request.getPathInfo();
		if (path.matches(SysContants.NO_INTERCEPTOR_PATH)) {
			return true;
		}
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (null != user && user.getUsername() != null && 
				user.getUsername().startsWith(UserContant.ACCOUNT_TYPE_AN)) {//增加AN开头验证
			return true;
		}
		if (null != user && null != user.getId() && user.getUsername() != null
				&& user.getUsername().startsWith(UserContant.ACCOUNT_TYPE_CN)) {
			System.out.println(user.getId() + "===============2");
			UserAccountBO account = new UserAccountBO();
			account.setAccountType(UserContant.ACCOUNT_TYPE_2);
			account.setUid(user.getId());
			UserAccountBO userAccountBO = userAccountService.findAccountByVo(account);
			if (null == userAccountBO) {
				log.info("该cn账户,未绑定手机,跳转至绑定手机号页面" + CommUtil.getURL(request) + "/cn_bandphone.htm");
				response.sendRedirect(CommUtil.getURL(request) + "/cn_bandphone.htm");
				return false;
			}

			UserAccountBO account_ = new UserAccountBO();
			account_.setAccountType(UserContant.ACCOUNT_TYPE_4);
			account_.setUid(user.getId());
			UserAccountBO userAccount = userAccountService.findAccountByVo(account_);
			if (null == userAccount) {
				log.info("该cn账户,未绑定微信,跳转至绑定微信" + CommUtil.getURL(request)
						+ "/weChat/login.htm?type=1&mobile=" + userAccountBO.getLoginName());
				response.sendRedirect(CommUtil.getURL(request) + "/weChat/login.htm?type=1&mobile="
						+ userAccountBO.getLoginName());
				return false;
			}
		} else if (null != user && null != user.getId() && user.getUsername() != null
				&& user.getUsername().length() == 11) {
			System.out.println(user.getId() + "===============1");
			UserAccountBO account_ = new UserAccountBO();
			account_.setAccountType(UserContant.ACCOUNT_TYPE_4);
			account_.setUid(user.getId());
			UserAccountBO userAccount = userAccountService.findAccountByVo(account_);
			if (null == userAccount) {
				String weChatLoginURL = CommUtil.getURL(request) + "/weChat/login.htm?type=2&mobile="
						+ user.getUsername();
				log.info("手机号注册未绑定微信,跳转至绑定微信" + weChatLoginURL);
				response.sendRedirect(weChatLoginURL);
				return false;
			}
		}
		return true;
	}

	public void setUserAccountService(UserAccountService userAccountService) {
		this.userAccountService = userAccountService;
	}

}
