package vc.thinker.b2b2c.action.circle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.circle.service.InvitationClassService;
import com.sinco.carnation.sns.bo.InvitationClassBO;
import com.sinco.carnation.sns.model.InvitationClass;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

@Controller
public class InvitationClassManagerAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private InvitationClassService invitationClassService;

	/**
	 * 帖子分类列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param name
	 * @param parentId
	 * @return
	 */
	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_list.htm*", rtype = "admin", rname = "帖子类型", rcode = "invitation_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String name, Long parentId) {
		ModelAndView mv = new JModelAndView("admin/blue/invitation_class.html", configService.getSysConfig(),
				0, request, response);

		MyPage<InvitationClassBO> page = new MyPage<InvitationClassBO>();
		page.setCurrentPage(currentPage == null ? 1 : Integer.valueOf(currentPage));
		page.setPageSize(10);
		// 查询数据
		this.invitationClassService.queryInvitationClassPage(name, parentId, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("name", name);
		mv.addObject("parentId", parentId);

		return mv;
	}

	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_add.htm*", rtype = "admin", rname = "帖子类型", rcode = "invitation_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_add.htm")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/invitationClass_add.html",
				configService.getSysConfig(), 0, request, response);

		// 查询数据
		List<InvitationClassBO> list = this.invitationClassService.queryInvitationClassBoByParentId(0L);
		mv.addObject("list", list);

		return mv;
	}

	/**
	 * 保存分类
	 * 
	 * @param request
	 * @param response
	 * @param invitationClass
	 * @return
	 */
	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_save.htm*", rtype = "admin", rname = "帖子类型", rcode = "invitation_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_save.htm")
	public ModelAndView save(HttpServletRequest request, HttpServletResponse response,
			InvitationClass invitationClass) {

		if (invitationClass.getParentId() == null) {
			invitationClass.setParentId(0L);
		}

		User user = SecurityUserHolder.getCurrentUser();
		invitationClass.setCreateBy(user.getId() + "");
		invitationClass.setCreateTime(new Date());

		this.invitationClassService.save(invitationClass);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", "/admin/invitationClass_list.htm");
		mv.addObject("add_url", "/admin/invitationClass_add.htm");
		mv.addObject("op_title", "分类保存成功");

		return mv;

	}

	/**
	 * 删除
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_del.htm*", rtype = "admin", rname = "帖子类型", rcode = "circle_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_del.htm")
	public String delete(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");

		request.getParameter("currentPage");

		for (String id : ids) {
			if (!id.equals("")) {

				// 查询，如果有子类 不能删除
				Long count = this.invitationClassService.countChild(Long.parseLong(id));

				if (count == 0) {
					this.invitationClassService.delete(Long.parseLong(id));
				}
			}
		}

		return "redirect:invitationClass_list.htm?currentPage=" + request.getParameter("currentPage");
	}

	/**
	 * 编辑
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_edit.htm*", rtype = "admin", rname = "帖子类型", rcode = "circle_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_edit.htm")
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/invitationClass_edit.html",
				configService.getSysConfig(), 0, request, response);

		InvitationClass model = this.invitationClassService.getById(id);

		if (model != null && model.getParentId() > 0L) {
			InvitationClass parent = this.invitationClassService.getById(model.getParentId());
			List<InvitationClassBO> list = this.invitationClassService
					.queryInvitationClassBoByParentId(parent.getParentId());
			mv.addObject("list", list);
		}

		mv.addObject("model", model);

		return mv;
	}

	/**
	 * 修改
	 * 
	 * @param request
	 * @param response
	 * @param invitationClass
	 * @return
	 */
	@SecurityMapping(title = "帖子类型列表", value = "/admin/invitationClass_update.htm*", rtype = "admin", rname = "帖子类型", rcode = "invitation_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/invitationClass_update.htm")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,
			InvitationClass invitationClass) {

		if (invitationClass.getParentId() == null) {
			invitationClass.setParentId(0L);
		}

		User user = SecurityUserHolder.getCurrentUser();
		invitationClass.setUpdateBy(user.getId() + "");
		invitationClass.setUpdateTime(new Date());

		this.invitationClassService.update(invitationClass);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", "/admin/invitationClass_list.htm");
		mv.addObject("add_url", "/admin/invitationClass_edit.htm");
		mv.addObject("op_title", "分类更新成功");

		return mv;

	}

	@SecurityMapping(title = "帖子类型列表", value = "/admin/getInvitationClassBoByParentId.htm*", rtype = "admin", rname = "帖子类型", rcode = "invitation_class_admin", rgroup = "内容管理")
	@RequestMapping("/admin/getInvitationClassBoByParentId.htm")
	@ResponseBody
	public void getInvitationClassBoByParentId(HttpServletRequest request, HttpServletResponse response,
			Long parentId) {
		// 查询数据
		List<InvitationClassBO> list = this.invitationClassService.queryInvitationClassBoByParentId(parentId);

		Object obj = JSONObject.toJSON(list);

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.print(obj);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}
}
