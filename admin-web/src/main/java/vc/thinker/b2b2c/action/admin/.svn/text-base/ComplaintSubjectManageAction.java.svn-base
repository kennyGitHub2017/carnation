package vc.thinker.b2b2c.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.service.ComplaintSubjectService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

/**
 * 
 * <p>
 * Title: ComplaintSubjectManageAction.java
 * </p>
 * 
 * <p>
 * Description: 投诉主题管理控制器，用来管理投诉主题，用户在投诉商品时候需要选择一个投诉主题，便于管理员快速分类处理投诉信息
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
public class ComplaintSubjectManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private ComplaintSubjectService complaintsubjectService;

	/**
	 * ComplaintSubject列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "投诉主题列表", value = "/admin/complaintsubject_list.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaintsubject_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String self, String q_type, MyPage<ComplaintSubject> page) {
		ModelAndView mv = new JModelAndView("admin/blue/complaintsubject_list.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(50);
		complaintsubjectService.queryComplaintPageList(q_type, page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/complaintsubject_list.htm", "", "", page, mv);
		mv.addObject("q_type", q_type);
		mv.addObject("self", self);
		return mv;
	}

	/**
	 * complaintsubject添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "投诉主题添加", value = "/admin/complaintsubject_add.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaintsubject_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, String self,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/complaintsubject_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		mv.addObject("self", self);
		return mv;
	}

	/**
	 * complaintsubject编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "投诉主题编辑", value = "/admin/complaintsubject_edit.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaintsubject_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/complaintsubject_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ComplaintSubject complaintsubject = complaintsubjectService.getObjById(Long.parseLong(id));
			mv.addObject("obj", complaintsubject);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * complaintsubject保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "投诉主题保存", value = "/admin/complaintsubject_save.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaintsubject_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String cmd, String list_url, String add_url) {
		WebForm wf = new WebForm();
		ComplaintSubject complaintsubject = wf.toPo(request, ComplaintSubject.class);
		complaintsubjectService.saveComplaint(complaintsubject);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存投诉主题成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}
		return mv;
	}

	@SecurityMapping(title = "投诉主题删除", value = "/admin/complaintsubject_del.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaintsubject_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		complaintsubjectService.deleteComplaint(mulitId);
		return "redirect:complaintsubject_list.htm?currentPage=" + currentPage;
	}
}