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

import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.service.ComplaintService;
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
public class ComplaintManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private UserAccountService userAccount;

	/**
	 * Complaint列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "投诉列表", value = "/admin/complaint_list.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_list.htm")
	public ModelAndView complaint_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String status, String formName, String title, String beginTime,
			String endTime, MyPage<ComplaintBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/complaint_list.html", configService.getSysConfig(),
				0, request, response);
		page.setPageSize(5);
		complaintService.queryComplaintPageList(status, title, formName, beginTime, endTime, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("status", CommUtil.null2String(status).equals("") ? "new" : status);
		mv.addObject("formName", formName);
		mv.addObject("title", title);
		mv.addObject("beginTime", beginTime);
		mv.addObject("endTime", endTime);
		return mv;
	}

	@SecurityMapping(title = "投诉设置", value = "/admin/complaint_set.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_set.htm")
	public ModelAndView complaint_set(HttpServletRequest request, HttpServletResponse response, String self,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/complaint_set.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("config", this.configService.getSysConfig());
		mv.addObject("self", self);
		return mv;
	}

	@SecurityMapping(title = "投诉设置保存", value = "/admin/complaint_set_save.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_set_save.htm")
	public ModelAndView complaint_set_save(HttpServletRequest request, HttpServletResponse response,
			String id, String complaintTime) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig config = this.configService.getSysConfig();
		config.setComplaintTime(CommUtil.null2Int(complaintTime));
		complaintService.saveComplaintSet(id, config);
		mv.addObject("op_title", "投诉设置成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/complaint_set.htm");
		return mv;
	}

	@SecurityMapping(title = "投诉详情", value = "/admin/complaint_view.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_view.htm")
	public ModelAndView complaint_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/complaint_view.html", configService.getSysConfig(),
				0, request, response);
		if (StringUtils.isNotBlank(id)) {
			ComplaintBO obj = complaintService.queryComplaintById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		}
		mv.addObject("orderFormTools", orderFormTools);
		return mv;
	}

	@SecurityMapping(title = "投诉图片", value = "/admin/complaint_img.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_img.htm")
	public ModelAndView complaint_img(HttpServletRequest request, HttpServletResponse response, String id,
			String type) {
		ModelAndView mv = new JModelAndView("admin/blue/complaint_img.html", configService.getSysConfig(), 0,
				request, response);
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("type", type);

		return mv;
	}

	@SecurityMapping(title = "投诉审核", value = "/admin/complaint_audit.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_audit.htm")
	public ModelAndView complaint_audit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Complaint obj = this.complaintService.getObjById(CommUtil.null2Long(id));
		obj.setStatus(1);
		complaintService.update(obj);
		mv.addObject("op_title", "审核投诉成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/complaint_list.htm");
		return mv;
	}

	@SecurityMapping(title = "投诉关闭", value = "/admin/complaint_close.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_close.htm")
	public ModelAndView complaint_close(HttpServletRequest request, HttpServletResponse response, String id,
			String handleContent) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		complaintService.updateComplaintClose(id, handleContent);
		mv.addObject("op_title", "关闭投诉成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/complaint_list.htm");
		return mv;
	}

	@SecurityMapping(title = "发布投诉对话", value = "/admin/complaint_talk.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_talk.htm")
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

	@SecurityMapping(title = "投诉仲裁", value = "/admin/complaint_handle_close.htm*", rtype = "admin", rname = "投诉管理", rcode = "complaint_manage", rgroup = "商城管理")
	@RequestMapping("/admin/complaint_handle_close.htm")
	public ModelAndView complaint_handle_close(HttpServletRequest request, HttpServletResponse response,
			String id, String handle_content) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		this.complaintService.updateComplaintHandleClose(uid, id, handle_content);
		mv.addObject("op_title", "投诉仲裁成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/complaint_list.htm");
		return mv;
	}
}