package vc.thinker.b2b2c.action.complain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.AdminUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.service.ComplaintService;
import com.sinco.carnation.shop.service.ComplaintSubjectService;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ComplaintManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统投诉管理类
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
 * @version 1.0
 */
@Controller
public class SelfComplaintManageAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private UserAccountService userAccount;

	@Autowired
	private ComplaintSubjectService complaintsubjectService;

	/**
	 * Complaint列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "自营投诉列表", value = "/admin/self_complaint_list.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_list.htm")
	public ModelAndView complaint_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String status, String formName, String title, String beginTime,
			String endTime, MyPage<ComplaintBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaint_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(50);
		complaintService.queryComplaintPageListSelf(status, title, formName, beginTime, endTime, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("status", CommUtil.null2String(status).equals("") ? "new" : status);
		mv.addObject("formName", formName);
		mv.addObject("title", title);
		mv.addObject("beginTime", beginTime);
		mv.addObject("endTime", endTime);
		return mv;
	}

	@SecurityMapping(title = "自营投诉详情", value = "/admin/self_complaint_view.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_view.htm")
	public ModelAndView complaint_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaint_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ComplaintBO obj = complaintService.queryComplaintById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		}
		mv.addObject("orderFormTools", orderFormTools);
		return mv;
	}

	@SecurityMapping(title = "投诉仲裁", value = "/admin/self_complaint_handle_close.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_handle_close.htm")
	public ModelAndView complaint_handle_close(HttpServletRequest request, HttpServletResponse response,
			String id, String handle_content) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		this.complaintService.updateComplaintHandleClose(uid, id, handle_content);
		mv.addObject("op_title", "投诉仲裁成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_complaint_list.htm?status=close");

		return mv;
	}

	@SecurityMapping(title = "投诉审核", value = "/admin/self_complaint_audit.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_audit.htm")
	public ModelAndView complaint_audit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		obj.setStatus(2);
		complaintService.update(obj);
		mv.addObject("op_title", "审核投诉成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_complaint_list.htm?status=talk");

		return mv;
	}

	@SecurityMapping(title = "发布投诉对话", value = "/admin/self_complaint_talk.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_talk.htm")
	public void complaint_talk(HttpServletRequest request, HttpServletResponse response, String id,
			String talkContent) throws IOException {
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		if (!CommUtil.null2String(talkContent).equals("")) {
			AdminUserDetails userDetails = (AdminUserDetails) SecurityUserHolder.getCurrentUserDetails();
			String temp = "管理员[" + userDetails.getName() + "] " + CommUtil.formatLongDate(new Date()) + "说: "
					+ talkContent;
			if (obj.getTalkContent() == null) {
				obj.setTalkContent(temp);
			} else {
				obj.setTalkContent(temp + "\n\r" + obj.getTalkContent());
			}
			complaintService.update(obj);
		}
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		for (String s : CommUtil.str2list(obj.getTalkContent())) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("content", s);
			if (s.indexOf("管理员") == 0) {
				map.put("role", "admin");
			}
			if (s.indexOf("投诉") == 0) {
				map.put("role", "from_user");
			}
			if (s.indexOf("申诉") == 0) {
				map.put("role", "to_user");
			}
			maps.add(map);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(maps, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ComplaintSubject列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "投诉主题列表", value = "/admin/self_complaintsubject_list.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaintsubject_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String self, String q_type, MyPage<ComplaintSubject> page) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaintsubject_list.html",
				configService.getSysConfig(), 0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(50);
		complaintsubjectService.queryComplaintPageList(q_type, page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/self_complaintsubject_list.htm", "", "", page, mv);
		mv.addObject("q_type", q_type);
		mv.addObject("self", self);
		return mv;
	}

	/**
	 * complaintsubject添加管理
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "投诉主题添加", value = "/admin/self_complaintsubject_add.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaintsubject_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response, String self,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaintsubject_add.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("currentPage", currentPage);
		mv.addObject("self", self);
		return mv;
	}

	@SecurityMapping(title = "投诉设置", value = "/admin/self_complaint_set.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_set.htm")
	public ModelAndView complaint_set(HttpServletRequest request, HttpServletResponse response, String self,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaint_set.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("config", this.configService.getSysConfig());
		mv.addObject("self", self);
		return mv;
	}

	/**
	 * complaintsubject保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "投诉主题保存", value = "/admin/self_complaintsubject_save.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaintsubject_save.htm")
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

	@SecurityMapping(title = "投诉主题删除", value = "/admin/self_complaintsubject_del.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaintsubject_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		complaintsubjectService.deleteComplaint(mulitId);
		return "redirect:self_complaintsubject_list.htm?currentPage=" + currentPage;
	}

	/**
	 * complaintsubject编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "投诉主题编辑", value = "/admin/self_complaintsubject_edit.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaintsubject_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/self_complaintsubject_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ComplaintSubject complaintsubject = complaintsubjectService.getObjById(Long.parseLong(id));
			mv.addObject("obj", complaintsubject);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	@SecurityMapping(title = "投诉设置保存", value = "/admin/self_complaint_set_save.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/self_complaint_set_save.htm")
	public ModelAndView complaint_set_save(HttpServletRequest request, HttpServletResponse response,
			String id, String complaintTime) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig config = this.configService.getSysConfig();
		config.setComplaintTime(CommUtil.null2Int(complaintTime));
		complaintService.saveComplaintSet(id, config);
		mv.addObject("op_title", "投诉设置成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_complaint_set.htm");
		return mv;
	}
}
