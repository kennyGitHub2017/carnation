package vc.thinker.b2b2c.action.admin;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.bo.RoleBO;
import com.sinco.carnation.sys.bo.RoleGroupBO;
import com.sinco.carnation.sys.bo.SysLogBO;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.security.PasswordUtils;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.ResService;
import com.sinco.carnation.sys.service.RoleGroupServiceImpl;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.SysLogServiceImpl;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserGroupService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.bo.UserGroupBO;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.service.ManagerService;
import com.sinco.carnation.user.vo.ManagerVO;
import com.sinco.carnation.user.vo.UserGroupVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.ClassUtils;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.SecurityManager;
import vc.thinker.b2b2c.core.security.support.BasicUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 
 * <p>
 * Title: AdminManageAction.java
 * </p>
 * 
 * <p>
 * Description: 超级管理员管理控制器,用来添加、编辑管理员信息，包括给管理员分配权限，初始化系统权限等等
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
 * @date 2014-5-16
 * 
 * @version 1.0.1
 */
@Controller
public class AdminManageAction implements ServletContextAware {
	private ServletContext servletContext;

	@Autowired
	private UserService userService;

	@Autowired
	private UserAccountService accountService;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleGroupServiceImpl roleGroupService;

	@Autowired
	private SecurityManager securityManager;

	@Autowired
	private ResService resService;

	@Autowired
	private SysLogServiceImpl syslogService;

	@Autowired
	private AccessoryServiceImpl accessoryService;

	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserGroupService userGroupService;

	@SecurityMapping(title = "管理员列表", value = "/admin/admin_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_list.htm")
	public ModelAndView admin_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<ManagerBO> page, ManagerVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_list.html", configService.getSysConfig(), 0,
				request, response);

		managerService.selectManagePageByVO(vo, page);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/admin/admin_list.htm", "", "", page, mv);
		mv.addObject("userRole", "ADMIN");
		return mv;
	}

	@SecurityMapping(title = "管理员添加", value = "/admin/admin_add.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_add.htm")
	public ModelAndView admin_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_add.html", configService.getSysConfig(), 0,
				request, response);
		List<UserGroupBO> userGroupList = this.userGroupService.findAllUserGroup();
		mv.addObject("userGroupList", userGroupList);
		mv.addObject("op", "add");
		return mv;
	}

	@SecurityMapping(title = "管理员编辑", value = "/admin/admin_edit.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_edit.htm")
	public ModelAndView admin_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String op) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_add.html", configService.getSysConfig(), 0,
				request, response);
		List<UserGroupBO> userGroupList = this.userGroupService.findAllUserGroup();
		mv.addObject("userGroupList", userGroupList);

		if (StringUtils.isNotEmpty(id)) {
			Long userId = CommUtil.null2Long(id);
			UserBO user = new UserBO();
			user.setId(userId);
			ManagerBO manager = managerService.getObjById(userId);
			user.setUserName(manager.getName());
			UserGroupBO userGroupBO = this.userGroupService.findUserGroupByUid(userId);
			user.setUserGroup(userGroupBO);

			mv.addObject("obj", user);
		}
		mv.addObject("op", op);
		return mv;
	}

	@SecurityMapping(title = "管理员保存", value = "/admin/admin_save.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_save.htm")
	public ModelAndView admin_save(HttpServletRequest request, HttpServletResponse response, String id,
			String list_url, String add_url, String userName, String password, String new_password,
			Long groupId) {
		WebForm wf = new WebForm();
		Manager user = wf.toPo(request, Manager.class);
		user.setName(userName);
		if (StringUtils.isNotBlank(id)) {
			user.setUid(Long.parseLong(id));
		}
		managerService.save(user, userName, password, new_password, IPUtil.getIpAddr(request), groupId);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存管理员成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "管理员删除", value = "/admin/admin_del.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_del.htm")
	public String admin_del(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");

		managerService.deleteManager(String.valueOf(SecurityUserHolder.getCurrentUserId()), ids);

		return "redirect:admin_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "管理员修改密码", value = "/admin/admin_pws.htm*", rtype = "admin", rname = "商城后台管理", rcode = "admin_index", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/admin_pws.htm")
	public ModelAndView admin_pws(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_pws.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("user", this.userService.findById(SecurityUserHolder.getCurrentUser().getId()));
		return mv;
	}

	@SecurityMapping(title = "管理员密码保存", value = "/admin/admin_pws_save.htm*", rtype = "admin", rname = "商城后台管理", rcode = "admin_index", display = false, rgroup = "系统管理")
	@RequestMapping("/admin/admin_pws_save.htm")
	public ModelAndView admin_pws_save(HttpServletRequest request, HttpServletResponse response,
			String old_password, String password) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		BasicUserDetails user = SecurityUserHolder.getCurrentUserDetails();
		UserAccount account = accountService.findByLoginName(user.getUsername());

		if (PasswordUtils.validatePassword(old_password, account.getPassword())) {
			this.accountService.passwordUpdate(user.getUser().getId(), password);
			mv.addObject("op_title", "修改密码成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "原密码错误");
		}
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/admin_pws.htm");
		return mv;
	}

	@SecurityMapping(title = "管理员操作日志", value = "/admin/admin_log_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_log_list.htm")
	public ModelAndView admin_log_list(MyPage<SysLogBO> page, String orderBy, String orderType,
			HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_log_list.html", configService.getSysConfig(),
				0, request, response);

		this.syslogService.list(page);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	@SecurityMapping(title = "管理员操作日志", value = "/admin/admin_log_delete.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_log_delete.htm")
	public String admin_log_delete(String currentPage, HttpServletRequest request,
			HttpServletResponse response, String mulitId, String type) {
		if (type != null && type.equals("all")) {
			this.syslogService.deleteAll();
		} else {
			String[] ids = mulitId.split(",");
			List<Long> idList = new ArrayList<Long>();
			for (String id : ids) {
				idList.add(Long.parseLong(id));
			}
			syslogService.batchDelete(idList);
		}
		return "redirect:/admin/admin_log_list.htm?currentPage=" + currentPage;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/admin/init_role.htm")
	public String init_role() {
		// TODO Auto-generated method stub
		User current_user = SecurityUserHolder.getCurrentUser();
		if (current_user != null) {
			// 统一加载所有 action class
			Set<Class<?>> clzs = ClassUtils.getClasses("vc.thinker.b2b2c.action");
			List<SecurityMapping> mappings = new ArrayList<SecurityMapping>();
			for (Class clz : clzs) {
				Method[] ms = clz.getMethods();
				for (Method m : ms) {
					Annotation[] annotation = m.getAnnotations();
					for (Annotation tag : annotation) {
						if (SecurityMapping.class.isAssignableFrom(tag.annotationType())) {
							if (((SecurityMapping) tag).rcode().equalsIgnoreCase("admin_index_welcome")) {
								System.out.println("sss");
							}
							mappings.add((SecurityMapping) tag);
						}
					}
				}
			}
			managerService.initManagerUser(mappings);

			// 重新加载系统权限
			Map<String, String> urlAuthorities = this.securityManager.loadUrlAuthorities();
			this.servletContext.setAttribute("urlAuthorities", urlAuthorities);
			return "redirect:admin_list.htm";
		} else {
			return "redirect:login.htm";
		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;
	}

	@SecurityMapping(title = "角色列表", value = "/admin/admin_group_list.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_group_list.htm")
	public ModelAndView admin_group_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<UserGroupBO> page, UserGroupVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_group_list.html", configService.getSysConfig(),
				0, request, response);

		userGroupService.selectGroupPageByVO(vo, page);

		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		CommUtil.saveIPageList2ModelAndView(url + "/admin/admin_group_list.htm", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "角色删除", value = "/admin/admin_group_del.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_group_del.htm")
	public String admin_group_del(HttpServletRequest request, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		userGroupService.deleteUserGroup(ids);
		return "redirect:admin_group_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "角色添加", value = "/admin/admin_group_add.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_group_add.htm")
	public ModelAndView admin_group_add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_group_add.html", configService.getSysConfig(),
				0, request, response);
		List<RoleGroupBO> rgs = this.roleGroupService.findRoleByType("ADMIN");
		mv.addObject("rgs", rgs);
		mv.addObject("op", "add");
		return mv;
	}

	@SecurityMapping(title = "角色编辑", value = "/admin/admin_group_edit.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_group_edit.htm")
	public ModelAndView admin_group_edit(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_group_add.html", configService.getSysConfig(),
				0, request, response);
		UserGroupBO obj = this.userGroupService.findById(id);
		// List<RoleBO> listRoles = roleService.findRolesByGroupId(id);
		// obj.setRoles(listRoles);

		List<RoleGroupBO> rgs = this.roleGroupService.findRoleByType("ADMIN");
		mv.addObject("rgs", rgs);
		mv.addObject("op", "edit");
		mv.addObject("obj", obj);
		return mv;
	}

	@SecurityMapping(title = "角色保存", value = "/admin/admin_group_save.htm*", rtype = "admin", rname = "管理员管理", rcode = "admin_manage", rgroup = "系统管理")
	@RequestMapping("/admin/admin_group_save.htm")
	public ModelAndView admin_group_save(HttpServletRequest request, HttpServletResponse response, String id,
			String role_ids, String list_url, String add_url, UserGroupVO vo) {

		List<Long> rids = null;
		if (StringUtils.isNotBlank(role_ids)) {
			String[] ridStrs = role_ids.split(",");
			rids = new ArrayList<Long>();
			for (int i = 0; i < ridStrs.length; i++) {
				if (StringUtils.isNotBlank(ridStrs[i])) {
					rids.add(Long.parseLong(ridStrs[i]));
				}
			}

		}
		// 添加管理员时 ，加默认权限
		// this.addRoleIdByCode(rids, "ROLE_ADMIN_INDEX",
		// "ROLE_ADMIN_INDEX_WELCOME", "ROLE_ADMIN_INDEX_REMIND",
		// "ROLE_ADMIN_INDEX_ABOUT");

		// 这里添加一些默认的权限，但是不明白为什么Buyer 也添加呢？？？？？
		List<RoleBO> adminRoles = roleService.findByType("ADMIN", "BUYER");
		for (RoleBO roleBO : adminRoles) {
			if ("BUYER".equals(roleBO.getType())
					|| ("ADMIN".equals(roleBO.getType()) && roleBO.getDisplay() == false)) {
				if (!rids.contains(roleBO.getId())) {
					rids.add(roleBO.getId());
				}
			}
		}

		if (vo.getId() == null) {
			vo.setCreateTime(new Date());
			vo.setCreateBy(SecurityUserHolder.getCurrentUserId());
		} else {
			vo.setModifyTime(new Date());
			vo.setModifyBy(SecurityUserHolder.getCurrentUserId());
		}

		userGroupService.saveUserGroupRole(vo, UserContant.ROLE_TYPE_ADMIN,
				rids != null ? rids.toArray(new Long[rids.size()]) : null);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存角色成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;

	}

	// /**
	// * 通过rolecode 查找id 并添加到 rids集合中
	// *
	// * @param rids
	// * @param codeArrays
	// */
	// private void addRoleIdByCode(List<Long> rids, String... codeArrays) {
	// for (String code : codeArrays) {
	// List<RoleBO> roleBOs = roleService.findByRoleCode(code);
	// if (CollectionUtils.isNotEmpty(roleBOs)) {
	// if (!rids.contains(roleBOs.get(0).getId())) {
	// rids.add(roleBOs.get(0).getId());
	// }
	// }
	// }
	// }

	@RequestMapping("/q_sql.htm")
	public ModelAndView excuteSql(HttpServletRequest request, HttpServletResponse response, String sql) {
		ModelAndView mv = new JModelAndView("admin/blue/excute_sql.html", configService.getSysConfig(), 0,
				request, response);

		if (StringUtils.isBlank(sql)) {
			mv.addObject("errStr", "SQL语句为空");
			return mv;
		}
		mv.addObject("sql", sql);
		String sqlLower = sql.toLowerCase();
		if (sqlLower.contains("insert") || sqlLower.contains("update") || sqlLower.contains("replace")) {
			mv.addObject("errStr", "SQL语句暂不支持 insert update replace 操作");
			return mv;
		}

		BasicUserDetails user = SecurityUserHolder.getCurrentUserDetails();
		if (user.getName().equalsIgnoreCase("admin")) {
			mv.addObject("errStr", "只有管理员-admin 帐号才能操作SQL");
			return mv;
		}
		List<HashMap<String, Object>> list = managerService.getResultBySql(sql);
		mv.addObject("list", list);

		return mv;
	}

	/**
	 * 用户名ajax验证方法
	 * 
	 * @param response
	 */
	@RequestMapping("/verify_user_group_name.htm")
	@ResponseBody
	public String verify_user_group_name(HttpServletRequest request, HttpServletResponse response,
			String groupName, String id) {
		boolean ret = true;

		UserGroupBO bo = this.userGroupService.findUserGroupByName(groupName);
		if (bo != null && !bo.getId().equals(CommUtil.null2Long(id))) {
			ret = false;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		return ret ? "true" : "false";
	}

}
