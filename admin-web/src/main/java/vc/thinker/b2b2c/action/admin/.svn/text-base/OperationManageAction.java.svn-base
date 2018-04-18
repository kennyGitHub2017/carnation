package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.IntegralRegBO;
import com.sinco.carnation.sys.bo.VersionControlBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.model.IntegralReg;
import com.sinco.carnation.sys.model.VersionControl;
import com.sinco.carnation.sys.service.IntegralRegService;
import com.sinco.carnation.sys.service.IntegralService;
import com.sinco.carnation.sys.service.NavigationService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.VersionControlService;
import com.sinco.carnation.sys.vo.IntegralRegVO;
import com.sinco.carnation.sys.vo.VersionControlVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: OperationManageAction.java
 * </p>
 * 
 * <p>
 * Description: 超级后台运营基础功能管理器,主要功能: 1、运营基本设置 2、积分规则管理
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class OperationManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private UserConfigService userConfigService;
	@Autowired
	private NavigationService navigationService;
	@Autowired
	private IntegralRegService integralRegService;
	@Autowired
	private IntegralService integralService;
	@Autowired
	private VersionControlService versionControlService;

//	/**
//	 * 系统积分设置
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@SecurityMapping(title = "基本设置", value = "/admin/operation_base_set.htm*", rtype = "admin", rname = "基本设置", rcode = "operation_base", rgroup = "运营")
//	@RequestMapping("/admin/operation_base_set.htm")
//	public ModelAndView operation_base_set(HttpServletRequest request,
//			HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView(
//				"admin/blue/operation_base_setting.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		return mv;
//	}
//
//	/**
//	 * 系统积分设置保存
//	 * 
//	 * @param request
//	 * @return
//	 */
//	@SecurityMapping(title = "基本设置保存", value = "/admin/base_set_save.htm*", rtype = "admin", rname = "基本设置", rcode = "operation_base", rgroup = "运营")
//	@RequestMapping("/admin/base_set_save.htm")
//	public ModelAndView base_set_save(HttpServletRequest request,
//			HttpServletResponse response, String id, String integral,
//			String integralStore, String voucher, String deposit, String gold,
//			String goldMarketValue, String groupBuy, String group_meal_gold,
//			String buygift_status, String buygift_meal_gold,
//			String enoughreduce_status, String enoughreduce_meal_gold,
//			String enoughreduce_max_count, String combin_amount,
//			String combin_scheme_count, String combin_count,
//			String combin_status, String whether_free) {
//		ModelAndView mv = new JModelAndView("admin/blue/success.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		SysConfig config = this.configService.getSysConfig();
//		config.setIntegral(CommUtil.null2Boolean(integral));
//		config.setIntegralStore(CommUtil.null2Boolean(integralStore));
//		config.setVoucher(CommUtil.null2Boolean(voucher));
//		config.setDeposit(CommUtil.null2Boolean(deposit));
//		config.setGold(CommUtil.null2Boolean(gold));
//		config.setGoldMarketValue(CommUtil.null2Int(goldMarketValue));
//		config.setGroupBuy(CommUtil.null2Boolean(groupBuy));
//		config.setGroup_meal_gold(CommUtil.null2Int(group_meal_gold));
//		config.setBuygift_status(CommUtil.null2Int(buygift_status));
//		config.setBuygift_meal_gold(CommUtil.null2Int(buygift_meal_gold));
//		config.setEnoughreduce_status(CommUtil.null2Int(enoughreduce_status));
//		config.setEnoughreduce_meal_gold(CommUtil
//				.null2Int(enoughreduce_meal_gold));
//		config.setEnoughreduce_max_count(CommUtil
//				.null2Int(enoughreduce_max_count));
//		config.setCombin_amount(CommUtil.null2Int(combin_amount));
//		config.setCombin_scheme_count(CommUtil.null2Int(combin_scheme_count));
//		config.setCombin_count(CommUtil.null2Int(combin_count));
//		config.setWhether_free(CommUtil.null2Int(whether_free));		
//		System.out.println(CommUtil.null2Int(combin_status));
//		config.setCombin_status(CommUtil.null2Int(combin_status));
//		if (id.equals("")) {
//			this.configService.save(config);
//		} else {
//			this.configService.update(config);
//		}
//		if (config.isIntegralStore()) {
//			Map params = new HashMap();
//			params.put("url", "integral/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			if (navs.size() == 0) {
//				Navigation nav = new Navigation();
//				nav.setAddTime(new Date());
//				nav.setDisplay(true);
//				nav.setLocation(0);
//				nav.setNew_win(1);
//				nav.setSequence(2);
//				nav.setSysNav(true);
//				nav.setTitle("积分商城");
//				nav.setType("diy");
//				nav.setUrl("integral/index.htm");
//				nav.setOriginal_url("integral/index.htm");
//				this.navigationService.save(nav);
//			}
//		} else {
//			Map params = new HashMap();
//			params.put("url", "integral/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			for (Navigation nav : navs) {
//				this.navigationService.delete(nav.getId());
//			}
//		}
//		if (config.getWhether_free() == 1) {
//			Map params = new HashMap();
//			params.put("url", "free/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			if (navs.size() == 0) {
//				Navigation nav = new Navigation();
//				nav.setAddTime(new Date());
//				nav.setDisplay(true);
//				nav.setLocation(0);
//				nav.setNew_win(1);
//				nav.setSequence(7);
//				nav.setSysNav(true);
//				nav.setTitle("0元试用");
//				nav.setType("diy");
//				nav.setUrl("free/index.htm");
//				nav.setOriginal_url("free/index.htm");
//				this.navigationService.save(nav);
//			}
//		} else {
//			Map params = new HashMap();
//			params.put("url", "free/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			for (Navigation nav : navs) {
//				this.navigationService.delete(nav.getId());
//			}
//		}
//		if (config.isGroupBuy()) {
//			Map params = new HashMap();
//			params.put("url", "group/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			if (navs.size() == 0) {
//				Navigation nav = new Navigation();
//				nav.setAddTime(new Date());
//				nav.setDisplay(true);
//				nav.setLocation(0);
//				nav.setNew_win(1);
//				nav.setSequence(3);
//				nav.setSysNav(true);
//				nav.setTitle("团购");
//				nav.setType("diy");
//				nav.setUrl("group/index.htm");
//				nav.setOriginal_url("group/index.htm");
//				this.navigationService.save(nav);
//			}
//		} else {
//			Map params = new HashMap();
//			params.put("url", "group/index.htm");
//			List<Navigation> navs = this.navigationService.query(
//					"select obj from Navigation obj where obj.url=:url",
//					params, -1, -1);
//			for (Navigation nav : navs) {
//				this.navigationService.delete(nav.getId());
//			}
//		}
//		mv.addObject("op_title", "保存基本设置成功");
//		mv.addObject("list_url", CommUtil.getURL(request)
//				+ "/admin/operation_base_set.htm");
//		return mv;
//	}

	/**
	 * 系统积分规则列表
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "积分规则列表", value = "/admin/integral_reg_list.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/integral_reg_list.htm")
	public ModelAndView integral_reg_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<IntegralRegBO> page, IntegralRegVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_reg_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		this.integralRegService.selectListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "积分规则Ajax更新", value = "/admin/integral_reg_ajax.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/integral_reg_ajax.htm")
	public void ajax(HttpServletRequest request, HttpServletResponse response, String id, String fieldName,
			String value) throws ClassNotFoundException {
		IntegralReg obj = this.integralRegService.getObjById(Long.parseLong(id));
		Field[] fields = IntegralReg.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.integralRegService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 系统积分规则设置
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "积分规则新增页面", value = "/admin/integral_reg_add.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/integral_reg_add.htm")
	public ModelAndView integral_reg_add(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_reg_add.html", configService.getSysConfig(),
				0, request, response);
		IntegralReg integralReg = null;
		if (StringUtils.isNotEmpty(id)) {
			integralReg = this.integralRegService.getObjById(CommUtil.null2Long(id));
			mv.addObject("edit", true);
		}
		mv.addObject("obj", integralReg);

		return mv;
	}

	/**
	 * 系统积分规则保存
	 * 
	 * @param request
	 * @param id
	 * @param memberRegister
	 * @param memberDayLogin
	 * @param indentComment
	 * @param consumptionRatio
	 * @param everyIndentLimit
	 * @return
	 */
	@SecurityMapping(title = "积分规则保存", value = "/admin/integral_reg_save.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/integral_reg_save.htm")
	public ModelAndView integral_rule_save(HttpServletRequest request, HttpServletResponse response,
			IntegralRegVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		if (null != vo.getId()) {
			this.integralRegService.update(vo);
		} else {
			vo.setAddTime(new Date());
			this.integralRegService.save(vo);
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);
		mv.addObject("op_title", "保存积分成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/integral_reg_list.htm");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/integral_reg_add.htm");
		return mv;
	}

	@RequestMapping("/admin/integral_reg_verify.htm")
	public void integral_reg_verify(HttpServletRequest request, HttpServletResponse response, IntegralRegVO vo)
			throws ClassNotFoundException {

		boolean bool = this.integralRegService.checkIntegral(vo);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(bool);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/admin/save_integral.htm")
	public void save_integral(HttpServletRequest request, HttpServletResponse response, String type,
			String id, String integral, Long operateUserId, String consumerType)
			throws ClassNotFoundException {

//		int a=integralService.addIntegral(type, CommUtil.null2Long(id), integral, operateUserId, consumerType);
//		System.err.println("返回积分：====》"+a);
		int a = integralService.getSignDay(CommUtil.null2Long(id), IntegralConstants.INTEGRAL_SIGN_DAY);
		System.err.println(a);
	}

	/**
	 * 版本列表
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "版本列表", value = "/admin/sys_version_control.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/version_control.htm")
	public ModelAndView version_control(HttpServletRequest request, HttpServletResponse response,
			MyPage<VersionControlBO> page, VersionControlVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/version_control.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(10);
		versionControlService.selectListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "APP版本Ajax更新", value = "/admin/sys_version_control_ajax.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/sys_version_control_ajax.htm")
	public void ajax_version_control(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		VersionControlBO obj = versionControlService.findOneById(Integer.valueOf(id));
		Field[] fields = VersionControl.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
		this.versionControlService.update(obj);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * APP版本编辑
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "APP版本编辑", value = "/admin/version_control_update.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/version_control_update.htm")
	public ModelAndView version_control_update(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/version_control_update.html",
				configService.getSysConfig(), 0, request, response);
		VersionControlBO obj = null;
		if (StringUtils.isNotEmpty(id)) {
			obj = versionControlService.findOneById(Integer.valueOf(id));
			mv.addObject("edit", true);
		}
		mv.addObject("obj", obj);
		return mv;
	}

	/**
	 * APP版本保存
	 * 
	 * @param request
	 * @param id
	 * @param memberRegister
	 * @param memberDayLogin
	 * @param indentComment
	 * @param consumptionRatio
	 * @param everyIndentLimit
	 * @return
	 */
	@SecurityMapping(title = "APP版本保存", value = "/admin/version_control_save.htm*", rtype = "admin", rname = "积分规则", rcode = "integral_rule", rgroup = "商城管理")
	@RequestMapping("/admin/version_control_save.htm")
	public ModelAndView version_control_save(HttpServletRequest request, HttpServletResponse response,
			VersionControl vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		if (null != vo.getId()) {
			this.versionControlService.update(vo);
		} else {
			vo.setAddTime(new Date());
			this.versionControlService.save(vo);
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);
		mv.addObject("op_title", "APP版本发布成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/sys_version_control.htm");
		mv.addObject("add_url", CommUtil.getURL(request) + "/admin/version_control_update.htm");
		return mv;
	}

}
