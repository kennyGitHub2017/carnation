package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.weedfs.client.WeedFSClient;

import org.json.simple.JSONObject;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.Log;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.constant.Globals;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;
import vc.thinker.b2b2c.core.tools.WebForm;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;
import vc.thinker.b2b2c.foundation.domain.LogType;

import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;

/**
 * 
 * <p>
 * Title: BaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台管理基础控制，这里包含平台管理的基础方法、系统全局配置信息的保存、修改及一些系统常用请求
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
 * @date 2014-5-9
 * 
 * @version 1.0.1
 */
@Controller
public class BaseManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
//	@Autowired
//	private IGoodsService goodsService;
//	@Autowired
//	private IStoreService storeService;
//	@Autowired
//	private IIntegralLogService integralLogService;
	@Autowired
	private DatabaseTools databaseTools;
//	@Autowired
//	private IStoreStatService storeStatService;
//	@Autowired
//	private SystemTipService systemTipService;
//	@Autowired
//	private MsgTools msgTools;
//	@Autowired
//	private StatTools statTools;
	@Autowired
	private SessionRegistry sessionRegistry;
	@Autowired
	private ConsultingService consulService;
	@Autowired
	private WeedFSClient fsClient;
	@Autowired
	private UserAccountService userAccountService;

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(BaseManageAction.class);

	/**
	 * 用户登录后去向控制，根据用户角色UserRole进行控制,该请求不纳入权限管理
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	@Log(title = "用户登陆", type = LogType.LOGIN)
	@RequestMapping("/login_success.htm")
	public void login_success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (SecurityUserHolder.getCurrentUser() != null) {
			UserBO user = SecurityUserHolder.getCurrentUser();
			if (this.configService.getSysConfig().getIntegral()) {
//				if (user.getLoginDate() == null
//						|| user.getLoginDate().before(
//								CommUtil.formatDate(CommUtil
//										.formatShortDate(new Date())))) {
//					user.setIntegral(user.getIntegral()
//							+ this.configService.getSysConfig()
//									.getMemberDayLogin());
//					IntegralLog log = new IntegralLog();
//					log.setAddTime(new Date());
//					log.setContent("用户"
//							+ CommUtil.formatLongDate(new Date())
//							+ "登录增加"
//							+ this.configService.getSysConfig()
//									.getMemberDayLogin() + "分");
//					log.setIntegral(this.configService.getSysConfig()
//							.getMemberRegister());
//					log.setIntegral_user(user);
//					log.setType("login");
//					this.integralLogService.save(log);
//				}
			}
//			user.setLoginDate(new Date());
//			user.setLoginIp(CommUtil.getIpAddr(request));
//			user.setLoginCount(user.getLoginCount() + 1);
//			this.userService.update(user);
			HttpSession session = request.getSession(false);
			session.setAttribute("user", user);
//			session.setAttribute("userName", user.getUsername());
			session.setAttribute("lastLoginDate", new Date());// 设置登录时间
			session.setAttribute("loginIp", CommUtil.getIpAddr(request));// 设置登录IP
			session.setAttribute("login", true);// 设置登录标识
			String role = user.getUserRole();
			String url = CommUtil.getURL(request) + "/user_login_success.htm";
			if (!CommUtil.null2String(request.getSession(false).getAttribute("refererUrl")).equals("")) {
				url = CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"));
			}
			String login_role = (String) session.getAttribute("login_role");
			boolean ajax_login = CommUtil.null2Boolean(session.getAttribute("ajax_login"));
			if (ajax_login) {
				response.setContentType("text/plain");
				response.setHeader("Cache-Control", "no-cache");
				response.setCharacterEncoding("UTF-8");
				PrintWriter writer;
				try {
					writer = response.getWriter();
					writer.print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
//				if (login_role.equalsIgnoreCase("admin")) {
//					if (role.indexOf("ADMIN") >= 0) {
//						url = CommUtil.getURL(request) + "/admin/index.htm";
//						request.getSession(false).setAttribute("admin_login",
//								true);
//					}
//				}
				url = CommUtil.getURL(request) + "/admin/index.htm";
				request.getSession(false).setAttribute("admin_login", true);
//				if (login_role.equalsIgnoreCase("seller")
//						&& role.indexOf("SELLER") >= 0) {
//					url = CommUtil.getURL(request) + "/seller/index.htm";
//					request.getSession(false)
//							.setAttribute("seller_login", true);
//				}
				if (!CommUtil.null2String(request.getSession(false).getAttribute("refererUrl")).equals("")) {
					url = CommUtil.null2String(request.getSession(false).getAttribute("refererUrl"));
					request.getSession(false).removeAttribute("refererUrl");
				}
				String userAgent = request.getHeader("user-agent");
				if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
					url = CommUtil.getURL(request) + "/wap/index.htm";
				}
				response.sendRedirect(url);
			}
		} else {
			String url = CommUtil.getURL(request) + "/index.htm";
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
	@SuppressWarnings("unused")
	@RequestMapping("/logout_success.htm")
	public void logout_success(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);

		String targetUrl = CommUtil.getURL(request) + "/admin/login.htm";
		//
//		String userName = CommUtil
//				.null2String(session.getAttribute("userName"));
		// System.out.println(userName);
//		List<Object> objs = this.sessionRegistry.getAllPrincipals();
//		for (Object obj : objs) {
//			if (CommUtil.null2String(obj).equals(userName)) {
//				List<SessionInformation> ilist = this.sessionRegistry
//						.getAllSessions(obj, true);
//				for (SessionInformation sif: ilist) {
//					//SessionInformation sif = ilist[j];
//					// 以下踢出用户
//					sif.expireNow();
//					this.sessionRegistry.removeSessionInformation(sif
//							.getSessionId());
//				}
//			}
//		}
		//
//		session.removeAttribute("admin_login");
//		session.removeAttribute("seller_login");
//		session.removeAttribute("user");
//		session.removeAttribute("userName");
//		session.removeAttribute("login");
//		session.removeAttribute("role");
//		session.removeAttribute("cart");
//		((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
//				.getRequest().getSession(false).removeAttribute("user");
		String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
			targetUrl = CommUtil.getURL(request) + "/wap/index.htm";
		}
		response.sendRedirect(targetUrl);
	}

	@RequestMapping("/login_error.htm")
	public ModelAndView login_error(HttpServletRequest request, HttpServletResponse response) {
		String login_role = (String) request.getSession(false).getAttribute("login_role");
		ModelAndView mv = null;
		String userAgent = request.getHeader("user-agent");
		if (userAgent != null && userAgent.indexOf("Mobile") > 0) {
			String targetUrl = CommUtil.getURL(request) + "/wap/index.htm";
			try {
				response.sendRedirect(targetUrl);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String thinkervc_view_type = CommUtil.null2String(request.getSession(false).getAttribute(
				"thinkervc_view_type"));
		if (thinkervc_view_type != null && !thinkervc_view_type.equals("")) {
			if (thinkervc_view_type.equals("weixin")) {
				String store_id = CommUtil.null2String(request.getSession(false).getAttribute("store_id"));
				mv = new JModelAndView("weixin/error.html", configService.getSysConfig(), 1, request,
						response);
				mv.addObject("url", CommUtil.getURL(request) + "/weixin/index.htm?store_id=" + store_id);
			}
		} else {
			if (login_role == null)
				login_role = "user";
			if (login_role.equalsIgnoreCase("admin")) {
				mv = new JModelAndView("admin/blue/login_error.html", configService.getSysConfig(), 0,
						request, response);
			}
			if (login_role.equalsIgnoreCase("seller")) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("url", CommUtil.getURL(request) + "/seller/login.htm");
			}
			if (login_role.equalsIgnoreCase("user")) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("url", CommUtil.getURL(request) + "/user/login.htm");
			}
		}
		mv.addObject("op_title", "登录失败");
		return mv;
	}

	/**
	 * 管理页面
	 * 
	 * @param request
	 * @return
	 */
	// @SecurityMapping(title = "商城后台管理", value = "/admin/index.htm*", rtype = "admin", rname = "商城后台管理",
	// rcode = "admin_index", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/index.htm")
	public ModelAndView manage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/manage.html", configService.getSysConfig(), 0,
				request, response);
		User user = SecurityUserHolder.getCurrentUser();
		boolean ret = false;
		boolean isAdmin = false;
		// 专家
		if (user.getUserType().equals(UserContant.USER_TYPE_3)) {
			ret = true;
		} else if (user.getUserType().equals(UserContant.USER_TYPE_9)) // 系统管理员
		{
			UserAccount userAccount = userAccountService.findByUid(user.getId());
			boolean boo = userAccount.getLoginName().trim().equals("admin");
			isAdmin = boo;
		}
		mv.addObject("ret", ret);
		mv.addObject("isAdmin", isAdmin);
		return mv;
	}

	@RequestMapping("/admin/count_consulting.htm")
	public void count_consulting(HttpServletRequest request, HttpServletResponse response) {
		User user = SecurityUserHolder.getCurrentUser();
		int count = 0;
		String id = "";
		if (user != null) {
			// 获取未回复的咨询
			List<ConsultingBO> list = consulService.queryNotDoConsulListByExp(user.getId());
			if (list != null && list.size() > 0) {
				count = list.size();
				id = list.get(0).getId() + "";
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(count + "," + id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 管理页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("index.htm")
	public String index(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/admin/index.htm";
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "欢迎页面", value = "/admin/welcome.htm*", rtype = "admin", rname = "欢迎页面", rcode = "admin_index_welcome", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/welcome.htm")
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/welcome.html", configService.getSysConfig(), 0,
				request, response);
		Properties props = System.getProperties();
		mv.addObject("os", props.getProperty("os.name"));
		mv.addObject("java_version", props.getProperty("java.version"));
		mv.addObject("shop_version", Globals.DEFAULT_SHOP_VERSION);
		mv.addObject("database_version", this.databaseTools.queryDatabaseVersion());
		mv.addObject("web_server_version", request.getSession(false).getServletContext().getServerInfo());
//		List<StoreStat> stats = this.storeStatService.query(
//				"select obj from StoreStat obj order by obj.addTime desc",
//				null, -1, -1);
		Map params = new HashMap();
		params.put("st_status", 0);
//		List<SystemTip> sts = this.systemTipService
//				.query("select obj from SystemTip obj where obj.st_status=:st_status order by obj.st_level desc",
//						params, -1, -1);
//		StoreStat stat = null;
//		if (stats.size() > 0) {
//			stat = stats.get(0);
//		} else {
//			stat = new StoreStat();
//		}
//		mv.addObject("stat", stat);
//		mv.addObject("sts", sts);
		return mv;
	}

	@SecurityMapping(title = "系统提醒页", value = "/admin/sys_tip_list.htm*", rtype = "admin", rname = "系统提示页", rcode = "admin_index_remind", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/sys_tip_list.htm")
	public ModelAndView sys_tip_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/sys_tip_list.html", configService.getSysConfig(), 0,
				request, response);
//		SystemTipQueryObject qo = new SystemTipQueryObject(currentPage, mv,
//				orderBy, orderType);
//		qo.setOrderBy("st_status asc,obj.st_level desc,obj.addTime");
//		qo.setOrderType("desc");
//		IPageList pList = this.systemTipService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
		return mv;
	}

	@SecurityMapping(title = "系统提醒删除", value = "/admin/sys_tip_del.htm*", rtype = "admin", rname = "系统提示页", rcode = "admin_index_remind", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/sys_tip_del.htm")
	public String sys_tip_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
//				SystemTip st = this.systemTipService.getObjById(CommUtil
//						.null2Long(id));
//				this.systemTipService.delete(Long.parseLong(id));
			}
		}
		return "redirect:sys_tip_list.htm";
	}

	@SecurityMapping(title = "系统提醒处理", value = "/admin/sys_tip_do.htm*", rtype = "admin", rname = "系统提示页", rcode = "admin_index_remind", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/sys_tip_do.htm")
	public String sys_tip_do(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
//				SystemTip st = this.systemTipService.getObjById(CommUtil
//						.null2Long(id));
//				st.setSt_status(1);
//				this.systemTipService.save(st);
			}
		}
		return "redirect:sys_tip_list.htm";
	}

	@SecurityMapping(title = "关于我们", value = "/admin/aboutus.htm*", rtype = "admin", rname = "关于我们", rcode = "admin_index_about", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/aboutus.htm")
	public ModelAndView aboutus(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/aboutus.html", configService.getSysConfig(), 0,
				request, response);
		return mv;
	}

	@SecurityMapping(title = "站点设置", value = "/admin/set_site.htm*", rtype = "admin", rname = "站点设置", rcode = "admin_set_site", rgroup = "系统管理")
	@RequestMapping("/admin/set_site.htm")
	public ModelAndView site_set(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_site_setting.html", configService.getSysConfig(),
				0, request, response);
		return mv;
	}

	@SecurityMapping(title = "上传设置", value = "/admin/set_image.htm*", rtype = "admin", rname = "上传设置", rcode = "admin_set_image", rgroup = "系统管理")
	@RequestMapping("/admin/set_image.htm")
	public ModelAndView set_image(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_image_setting.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "保存商城配置", value = "/admin/sys_config_save.htm*", rtype = "admin", display = false, rname = "保存商城配置", rcode = "admin_config_save", rgroup = "系统管理")
	@RequestMapping("/admin/sys_config_save.htm")
	public ModelAndView sys_config_save(HttpServletRequest request, HttpServletResponse response, String id,
			String list_url, String op_title, String app_download, String android_download,
			String ios_download) {
		WebForm wf = new WebForm();

		SysConfig sysConfig = wf.toPo(request, SysConfig.class);

		sysConfig.setAppDownload(CommUtil.null2Int(app_download));
		sysConfig.setAndroidDownload(android_download);
		sysConfig.setIosDownload(ios_download);

		// 保存
		this.configService.save(sysConfig, request);

		if (sysConfig.getAddress() != null && !sysConfig.getAddress().equals("")) {
			String address = sysConfig.getAddress();
			if (address.indexOf("http://") < 0) {
				address = "http://" + address;
				sysConfig.setAddress(address);
			}
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", op_title);
		mv.addObject("list_url", list_url);
		return mv;
	}

	@SecurityMapping(title = "Email设置", value = "/admin/set_email.htm*", rtype = "admin", rname = "Email设置", rcode = "admin_set_email", rgroup = "系统管理")
	@RequestMapping("/admin/set_email.htm")
	public ModelAndView set_email(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_email_setting.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "短信设置", value = "/admin/set_sms.htm*", rtype = "admin", rname = "短信设置", rcode = "admin_set_sms", rgroup = "系统管理")
	@RequestMapping("/admin/set_sms.htm")
	public ModelAndView set_sms(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_sms_setting.html", configService.getSysConfig(),
				0, request, response);
		return mv;
	}

	@SecurityMapping(title = "SEO设置", value = "/admin/set_seo.htm*", rtype = "admin", rname = "SEO设置", rcode = "admin_set_seo", rgroup = "系统管理")
	@RequestMapping("/admin/set_seo.htm")
	public ModelAndView set_seo(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_seo_setting.html", configService.getSysConfig(),
				0, request, response);
		return mv;
	}

	@SecurityMapping(title = "二级域名设置", value = "/admin/set_second_domain.htm*", rtype = "admin", rname = "二级域名", rcode = "admin_set_second_domain", rgroup = "系统管理")
	@RequestMapping("/admin/set_second_domain.htm")
	public ModelAndView set_second_domain(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_second_domain.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "二级域名设置保存", value = "/admin/set_second_domain_save.htm*", rtype = "admin", rname = "二级域名", rcode = "admin_set_second_domain", rgroup = "系统管理")
	@RequestMapping("/admin/set_second_domain_save.htm")
	public ModelAndView set_second_domain_save(HttpServletRequest request, HttpServletResponse response,
			String id, String domain_allow_count, String sys_domain, String second_domain_open) {
		String serverName = request.getServerName().toLowerCase();
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		// System.out.println("二级域名："+Globals.SSO_SIGN);
		if (Globals.SSO_SIGN) {
			SysConfig config = this.configService.getSysConfig();
			config.setDomainAllowCount(CommUtil.null2Int(domain_allow_count));
			config.setSysDomain(sys_domain);
			config.setSecondDomainOpen(CommUtil.null2Boolean(second_domain_open));
			if (id.equals("")) {
				this.configService.save(config);
			} else
				this.configService.update(config);
			mv.addObject("op_title", "二级域名保存成功");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/set_second_domain.htm");
		} else {
			SysConfig config = this.configService.getSysConfig();
			config.setDomainAllowCount(CommUtil.null2Int(domain_allow_count));
			config.setSysDomain(sys_domain);
			config.setSecondDomainOpen(false);
			if (id.equals("")) {
				this.configService.save(config);
			} else
				this.configService.update(config);
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "当前网站无法开启二级域名");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/set_second_domain.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "QQ互联登录", value = "/admin/set_site_qq.htm*", rtype = "admin", rname = "二级域名", rcode = "admin_set_second_domain", rgroup = "系统管理")
	@RequestMapping("/admin/set_site_qq.htm")
	public ModelAndView set_site_qq(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_second_domain.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	/**
	 * 管理员退出，清除管理员权限数据,退出后，管理员可以作为普通登录用户进行任意操作，该请求在前台将不再使用，保留以供二次开发使用
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/admin/logout.htm")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		User user = SecurityUserHolder.getCurrentUser();
		if (user != null) {
//			Authentication authentication = new UsernamePasswordAuthenticationToken(
//					SecurityContextHolder.getContext().getAuthentication()
//							.getPrincipal(), SecurityContextHolder.getContext()
//							.getAuthentication().getCredentials(),
//					user.getCommonAuthorities());
//			SecurityContextHolder.getContext()
//					.setAuthentication(authentication);
		}
		return "redirect:../index.htm";
	}

	/**
	 * 登录页面
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/admin/login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/login.html", configService.getSysConfig(), 0,
				request, response);
		User user = SecurityUserHolder.getCurrentUser();
		request.getSession(false).removeAttribute("verify_code");
		if (user != null) {
			mv.addObject("user", user);
		}
		return mv;
	}

	@RequestMapping("/success.htm")
	public ModelAndView success(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 默认错误页面
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/error.htm")
	public ModelAndView error(HttpServletRequest request, HttpServletResponse response) {
		User user = SecurityUserHolder.getCurrentUser();
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
//		if (user != null && user.getUserRole().equalsIgnoreCase("ADMIN")) {
//			mv = new JModelAndView("admin/blue/error.html",
//					configService.getSysConfig(),
//					0, request,
//					response);
//
//		}
		mv.addObject("op_title", request.getSession(false).getAttribute("op_title"));
		mv.addObject("list_url", request.getSession(false).getAttribute("url"));
		mv.addObject("url", request.getSession(false).getAttribute("url"));
		request.getSession(false).removeAttribute("op_title");
		request.getSession(false).removeAttribute("url");
		return mv;
	}

	/**
	 * 默认异常出现
	 * 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/exception.htm")
	public ModelAndView exception(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
//		if (user != null && user.getUserRole().equalsIgnoreCase("ADMIN")) {
		mv = new JModelAndView("admin/blue/exception.html", configService.getSysConfig(), 0, request,
				response);
//		} else {
//			mv.addObject("op_title", "系统出现异常");
//			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
//		}
		return mv;
	}

	/**
	 * 超级后台默认无权限页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/authority.htm")
	public ModelAndView authority(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/authority.html", configService.getSysConfig(), 0,
				request, response);
		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if (domain_error) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "域名绑定错误，请与http://www.thinker.vc联系");
		}
		return mv;
	}

	/**
	 * 语言验证码处理
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/voice.htm")
	public ModelAndView voice(HttpServletRequest request, HttpServletResponse response) {
		return new JModelAndView("include/flash/soundPlayer.swf", this.configService.getSysConfig(), request,
				response);
	}

	/**
	 * flash获取验证码
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/getCode.htm")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession(false);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.print("result=true&code=" + (String) session.getAttribute("verify_code"));
	}

	/**
	 * 初始化系统相关图片，如商品默认图等，管理员修改后可以选择恢复默认
	 * 
	 * @param request
	 * @param response
	 * @param type
	 * @throws IOException
	 */
	@SuppressWarnings({"unused", "rawtypes", "unchecked"})
	@SecurityMapping(title = "初始化系统默认图片", value = "/admin/restore_img.htm*", rtype = "admin", rname = "商城后台管理", rcode = "admin_index", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/restore_img.htm")
	public void restore_img(HttpServletRequest request, HttpServletResponse response, String type)
			throws IOException {
		SysConfig config = this.configService.getSysConfig();
		Map map = new HashMap();
//		if (type.equals("member")) {// 恢复系统默认会员头像
//			Accessory acc = config.getMemberIcon();
//			if (acc == null) {
//				acc = new Accessory();
//			} else {
//				acc = config.getMemberIcon();
//			}
//			acc.setPath("resources/style/common/images");
//			acc.setName("member.jpg");
//			config.setMemberIcon(acc);
//			this.configService.update(config);
//			map.put("path", CommUtil.getURL(request)
//					+ "/resources/style/common/images/member.jpg");
//		}
//		if (type.equals("goods")) {// 恢复系统默认商品头像
//			Accessory acc = config.getGoodsImage();
//			if (acc == null) {
//				acc = new Accessory();
//			} else {
//				acc = config.getGoodsImage();
//			}
//			acc.setPath("resources/style/common/images");
//			acc.setName("good.jpg");
//			config.setGoodsImage(acc);
//			this.configService.update(config);
//			map.put("path", CommUtil.getURL(request)
//					+ "/resources/style/common/images/good.jpg");
//		}
//		if (type.equals("store")) {// 恢复系统默认店铺头像
//			Accessory acc = config.getStoreImage();
//			if (acc == null) {
//				acc = new Accessory();
//			} else {
//				acc = config.getStoreImage();
//			}
//			acc.setPath("resources/style/common/images");
//			acc.setName("store.jpg");
//			config.setStoreImage(acc);
//			this.configService.update(config);
//			map.put("path", CommUtil.getURL(request)
//					+ "/resources/style/common/images/store.jpg");
//		}
//		if (type.equals("admin_login_img")) {// 恢复平台管理登录页左上角Logo
//			Accessory acc = config.getAdmin_login_logo();
//			config.setAdmin_login_logo(null);
//			this.configService.update(config);
//			if (acc != null) {
//				this.accessoryService.delete(acc.getId());
//			}
//			map.put("path",
//					CommUtil.getURL(request)
//							+ "/resources/style/system/manage/blue/images/login/login_logo.png");
//		}
//		if (type.equals("admin_manage_img")) {// 恢复平台管理中心左上角的Logo
//			Accessory acc = config.getAdmin_manage_logo();
//			config.setAdmin_manage_logo(null);
//			this.configService.update(config);
//			if (acc != null) {
//				this.accessoryService.delete(acc.getId());
//			}
//			map.put("path", CommUtil.getURL(request)
//					+ "/resources/style/system/manage/blue/images/logo.png");
//		}
		map.put("type", type);
		HttpSession session = request.getSession(false);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter writer = response.getWriter();
		writer.print(Json.toJson(map, JsonFormat.compact()));
	}

	@RequestMapping("/js.htm")
	public ModelAndView js(HttpServletRequest request, HttpServletResponse response, String js) {
		ModelAndView mv = new JModelAndView("resources/js/" + js + ".js", configService.getSysConfig(), 2,
				request, response);
		return mv;
	}

	@SuppressWarnings("unused")
	@RequestMapping("/admin/test_mail.htm")
	public void test_email(HttpServletResponse response, String email) {
		String subject = this.configService.getSysConfig().getTitle() + "测试邮件";
//		boolean ret = this.msgTools.sendEmail(email, subject, subject);
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@SuppressWarnings("unused")
	@RequestMapping("/admin/test_sms.htm")
	public void test_sms(HttpServletResponse response, String mobile) throws UnsupportedEncodingException {
		String content = this.configService.getSysConfig().getTitle() + "亲,如果您收到短信，说明发送成功！";
//		boolean ret = this.msgTools.sendSMS(mobile, content);
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * 商城平台样式设置，默认样式为blue
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "websiteCss设置", value = "/admin/set_websiteCss.htm*", rtype = "admin", rname = "站点设置", rcode = "admin_set_site", rgroup = "系统管理")
	@RequestMapping("/admin/set_websiteCss.htm")
	public void set_websiteCss(HttpServletRequest request, HttpServletResponse response, String webcss) {
		SysConfig obj = this.configService.getSysConfig();
		if (!webcss.equals("blue") && !webcss.equals("black")) {
			webcss = "blue";
		}
		obj.setWebsiteCss(webcss);
		this.configService.update(obj);
	}

	/**
	 * 系统编辑器图片上传
	 * 
	 * @param request
	 * @param response
	 * @throws ClassNotFoundException
	 */
	public static final int maxSize = 8 * 1024 * 1024;

	@SuppressWarnings({"unchecked", "unused"})
	@RequestMapping("/upload.htm")
	public void upload(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("imgFile") MultipartFile file)
	// throws ClassNotFoundException {
			throws Exception {
		// 限制图片体积
		if (file.getSize() > maxSize) {
			throw new Exception("图片超出限制");
		}

		JSONObject obj = new JSONObject();
		if (file != null) {
			String fileUrl=FileUploadTools.fileUpload(file, UploadConstants.EDITOR);
			obj.put("error", 0);
			obj.put("url", fileUrl);
		} else {
			obj.put("error", "file is null");
		}
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(obj.toJSONString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
