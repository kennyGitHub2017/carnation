package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.sys.bo.TemplateBO;
import com.sinco.carnation.sys.model.Template;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.sys.vo.TemplateVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 
 * <p>
 * Title: TemplateManageAction.java
 * </p>
 * 
 * <p>
 * Description: 通知模板管理控制器，用来管理系统各类通知模板，包括站内短信通知、邮件通知、手机短信通知
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
 * @date 2014-10-16
 * 
 * @version 1.0.1
 */
@Controller
public class TemplateManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private MsgTools msgTools;

	/**
	 * Template列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "模板列表", value = "/admin/template_list.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_list.htm")
	public ModelAndView template_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<TemplateBO> page, TemplateVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/template_list.html", configService.getSysConfig(), 0,
				request, response);
		if (vo.getType() == null || "".equals(vo.getType())) {
			vo.setType("sms");
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		page.setPageSize(10);
		this.templateService.selectListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * template添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "模板添加", value = "/admin/template_add.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_add.htm")
	public ModelAndView template_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/template_add.html", configService.getSysConfig(), 0,
				request, response);
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * template编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "模板编辑", value = "/admin/template_edit.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_edit.htm")
	public ModelAndView template_edit(HttpServletRequest request, HttpServletResponse response,
			TemplateVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/template_add.html", configService.getSysConfig(), 0,
				request, response);
		if (vo.getId() != null && !"".equals((vo.getId()))) {
			Template template = this.templateService.getObjById(Long.parseLong(vo.getId()));
			mv.addObject("obj", template);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * template保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "模板保存", value = "/admin/template_save.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_save.htm")
	public ModelAndView template_save(HttpServletRequest request, HttpServletResponse response,
			TemplateVO vo, String currentPage, String list_url, String add_url) {
		WebForm wf = new WebForm();
		Template template = null;
		if (!"".equals(vo.getId())) {// 编辑
			Template obj = this.templateService.getObjById(Long.parseLong(vo.getId()));
			template = (Template) wf.toPo(request, obj);
		} else {// 新增
			template = wf.toPo(request, Template.class);
			template.setAddTime(new Date());
		}
		if ("sms".equals(template.getType())) {// 手机短信过滤所有的html代码
			String content = Jsoup.clean(template.getContent(), Whitelist.none()).replace("&nbsp;", "")
					.trim();
			template.setContent(content);
		}
		if (!"".equals(vo.getId())) {// 编辑
			this.templateService.update(template);
		} else {// 新增
			this.templateService.save(template);
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url + "?type=" + template.getType() + "&currentPage=" + currentPage);
		mv.addObject("op_title", "保存模板成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "模板AJAX更新", value = "/admin/template_ajax.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_ajax.htm")
	public void template_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		Template obj = this.templateService.getObjById(Long.parseLong(id));
		Field[] fields = Template.class.getDeclaredFields();
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
		this.templateService.update(obj);
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

	@SecurityMapping(title = "模板开启", value = "/admin/template_open.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_open.htm")
	public String template_open(HttpServletRequest request, String mulitId, String currentPage, String type) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!"".equals(id)) {
				Template obj = this.templateService.getObjById(Long.parseLong(id));
				obj.setOpen(true);
				this.templateService.update(obj);
			}
		}
		return "redirect:template_list.htm?currentPage=" + currentPage + "&type=" + type;
	}

	@RequestMapping("/template/verify_mark.htm")
	public void verify_mark(HttpServletRequest request, HttpServletResponse response, String mark, String id) {
		boolean ret = true;
		List<TemplateBO> list = this.templateService.verifyMark(CommUtil.null2Long(id), mark);
		if (null != list && list.size() > 0) {
			ret = false;
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "模板编辑", value = "/admin/template_copy.htm*", rtype = "admin", rname = "通知模板", rcode = "template_set", rgroup = "系统管理")
	@RequestMapping("/admin/template_copy.htm")
	public ModelAndView template_copy(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/template_add.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !"".equals((id))) {
			Template template = this.templateService.getObjById(Long.parseLong(id));
			mv.addObject("res", "copy");
			mv.addObject("obj", template);
			mv.addObject("currentPage", currentPage);
		}
		return mv;
	}

	@RequestMapping("/admin/sendSMS.htm")
	public void sendSMS(HttpServletRequest request, HttpServletResponse response, String mark, String mobile,
			String param) {
		param = "12345,hhsgshh";
		msgTools.sendSms(mark, mobile, param);
	}
}