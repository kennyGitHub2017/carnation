package vc.thinker.b2b2c.core.mv;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.interceptor.LbsInterceptorAdapter;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.HttpInclude;

import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.tools.ImagePornDetection;

/**
 * 
 * <p>
 * Title: JModelAndView.java
 * </p>
 * 
 * <p>
 * Description: 顶级视图管理类，封装ModelAndView并进行系统扩展
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
public class JModelAndView extends ModelAndView {
	private static String staticPath;
	
	static{
		Properties prop = new Properties();
		try {
			prop.load(ImagePornDetection.class.getResourceAsStream("/application.properties"));
			staticPath = prop.getProperty("static.path");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 普通视图，根据velocity配置文件的路径直接加载视图
	 * 
	 * @param viewName
	 *            视图名称
	 */
	public JModelAndView(String viewName) {
		super.setViewName(viewName);
	}

	/**
	 * 
	 * @param viewName
	 *            用户自定义的视图，可以添加任意路径
	 * @param request
	 */
	public JModelAndView(String viewName, SysConfig config, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(staticPath);
		String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();
		String webPath = CommUtil.getURL(request);
		super.addObject("staticPath", CommUtil.getStaticUrl(request));
		super.addObject("current_webPath", webPath);
		String port = request.getServerPort() == 80 ? "" : ":" + CommUtil.null2Int(request.getServerPort());
		if (Globals.SSO_SIGN && config.getSecondDomainOpen()
				&& !CommUtil.generic_domain(request).equals("localhost")
				&& !CommUtil.isIp(request.getServerName())) {
			webPath = "http://www." + CommUtil.generic_domain(request) + port + contextPath;
		}
		super.setViewName(viewName);
		super.addObject("domainPath", CommUtil.generic_domain(request));
		if (config.getImageWebServer() != null && !config.getImageWebServer().equals("")) {
			super.addObject("imageWebServer", config.getImageWebServer());
		} else {
			super.addObject("imageWebServer", webPath);
		}
		super.addObject("webPath", webPath);
		super.addObject("o2oCity", request.getAttribute(LbsInterceptorAdapter.O2O_CITY));
		super.addObject("shopPath", config.getAddress());
		super.addObject("config", config);
		super.addObject("PaymentConstants", new PaymentConstants());
		super.addObject("user", SecurityUserHolder.getCurrentUserDetails());
		super.addObject("userDetails", SecurityUserHolder.getCurrentUserDetails());
		super.addObject("httpInclude", new HttpInclude(request, response));
		String query_url = "";
		if (request.getQueryString() != null && !request.getQueryString().equals("")) {
			query_url = "?" + request.getQueryString();
		}
		super.addObject("current_url", request.getRequestURI() + query_url);
		boolean second_domain_view = false;
		String serverName = request.getServerName().toLowerCase();
		if (serverName.indexOf("www.") < 0 && serverName.indexOf(".") >= 0
				&& serverName.indexOf(".") != serverName.lastIndexOf(".") && config.getSecondDomainOpen()) {
			String secondDomain = serverName.substring(0, serverName.indexOf("."));
			second_domain_view = true;// 使用二级域名访问，相关js url需要处理，避免跨域
			super.addObject("secondDomain", secondDomain);
		}
		super.addObject("second_domain_view", second_domain_view);
	}

	/**
	 * 按指定路径加载视图，如不指定则系统默认路径加载
	 * 
	 * @param viewName
	 *            视图名称
	 * @param config
	 *            商城配置
	 * @param userPath
	 *            自定义路径，和type配合使用
	 * @param type
	 *            视图类型 0为后台，1为前台 大于1为自定义路径
	 */
	public JModelAndView(String viewName, SysConfigBO config, int type, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(staticPath);
		if (config.getSysLanguage() != null) {
			if (config.getSysLanguage().equals(Globals.DEFAULT_SYSTEM_LANGUAGE)) {
				if (type == 0) {
					super.setViewName(Globals.SYSTEM_MANAGE_PAGE_PATH + viewName);
				}
				if (type == 1) {
					super.setViewName(Globals.SYSTEM_FORNT_PAGE_PATH + viewName);
				}
				if (type > 1) {
					super.setViewName(viewName);
				}

			} else {
				if (type == 0) {
					super.setViewName(Globals.DEFAULT_SYSTEM_PAGE_ROOT + config.getSysLanguage() + "/system/"
							+ viewName);
				}
				if (type == 1) {
					super.setViewName(Globals.DEFAULT_SYSTEM_PAGE_ROOT + config.getSysLanguage() + "/shop/"
							+ viewName);
				}
				if (type > 1) {
					super.setViewName(viewName);
				}
			}
		} else {
			super.setViewName(viewName);
		}
		super.addObject("staticPath", CommUtil.getStaticUrl(request));
		super.addObject("CommUtil", new CommUtil());
		super.addObject("o2oCity", request.getAttribute(LbsInterceptorAdapter.O2O_CITY));
		super.addObject("PaymentConstants", new PaymentConstants());
		String contextPath = request.getContextPath().equals("/") ? "" : request.getContextPath();
		String webPath = CommUtil.getURL(request);
		String port = request.getServerPort() == 80 ? "" : ":" + CommUtil.null2Int(request.getServerPort());
		super.addObject("current_webPath", webPath);
		if (Globals.SSO_SIGN && config.getSecondDomainOpen()
				&& !CommUtil.generic_domain(request).equals("localhost")
				&& !CommUtil.isIp(request.getServerName())) {
			webPath = "http://www." + CommUtil.generic_domain(request) + port + contextPath;
		}
		super.addObject("domainPath", CommUtil.generic_domain(request));
		super.addObject("webPath", webPath);
		super.addObject("shopPath", config.getAddress());
		if (config.getImageWebServer() != null && !config.getImageWebServer().equals("")) {
			super.addObject("imageWebServer", config.getImageWebServer());
		} else {
			super.addObject("imageWebServer", webPath);
		}
		super.addObject("config", config);
		super.addObject("userDetails", SecurityUserHolder.getCurrentUserDetails());
		super.addObject("httpInclude", new HttpInclude(request, response));
		String query_url = "";
		if (request.getQueryString() != null && !request.getQueryString().equals("")) {
			query_url = "?" + request.getQueryString();
		}
		super.addObject("current_url", request.getRequestURI() + query_url);
		boolean second_domain_view = false;
		String serverName = request.getServerName().toLowerCase();
		if (serverName.indexOf("www.") < 0 && serverName.indexOf(".") >= 0
				&& serverName.indexOf(".") != serverName.lastIndexOf(".") && config.getSecondDomainOpen()) {
			String secondDomain = serverName.substring(0, serverName.indexOf("."));
			second_domain_view = true;// 使用二级域名访问，相关js url需要处理，避免跨域
			super.addObject("secondDomain", secondDomain);
		}
		super.addObject("second_domain_view", second_domain_view);
	}
}
