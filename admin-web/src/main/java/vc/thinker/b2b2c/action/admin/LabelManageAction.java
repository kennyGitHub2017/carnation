package vc.thinker.b2b2c.action.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.google.common.collect.Lists;
import com.sinco.carnation.label.bo.LabelBO;
import com.sinco.carnation.label.bo.LabelClassBO;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.sys.service.LabelClassService;
import com.sinco.carnation.sys.service.LabelService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 标签系统
 * 
 * @author Administrator
 * 
 */
@Controller
public class LabelManageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private LabelService labelService;

	@Autowired
	private LabelClassService labelClassService;

	/**
	 * 标签分页
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param currentPage
	 * @param labelName
	 * @return
	 */
	@SecurityMapping(title = "标签管理", value = "/admin/label_manage_list.htm*", rtype = "admin", rname = "标签管理", rcode = "label", rgroup = "标签管理")
	@RequestMapping("/admin/label_manage_list.htm")
	public ModelAndView label_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<LabelBO> page, String currentPage, String labelName) {
		ModelAndView mv = new JModelAndView("admin/blue/label_manage_list.html",
				configService.getSysConfig(), 0, request, response);
		labelService.findByPage(page, labelName);
		mv.addObject("labelName", labelName);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	/**
	 * 跳转至标签页面
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param currentPage
	 * @param labelName
	 * @return
	 */
	@SecurityMapping(title = "添加标签", value = "/admin/label_manage_add.htm*", rtype = "admin", rname = "标签管理", rcode = "label", rgroup = "标签管理")
	@RequestMapping("/admin/label_manage_add.htm")
	public ModelAndView label_add(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/label_manage_add.html", configService.getSysConfig(),
				0, request, response);
		List<LabelClassBO> acs = labelClassService.findAllOrder();
		mv.addObject("acs", acs);
		return mv;
	}

	/**
	 * 编辑标签
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "编辑标签", value = "/admin/label_edit.htm*", rtype = "admin", rname = "标签管理", rcode = "label", rgroup = "标签管理")
	@RequestMapping("/admin/label_edit.htm")
	public ModelAndView label_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/label_manage_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			Label label = this.labelService.getObjById(Long.parseLong(id));
			List<LabelClassBO> acs = labelClassService.findAllOrder();
			mv.addObject("acs", acs);
			mv.addObject("obj", label);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	/**
	 * 保存标签
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param currentPage
	 * @param labelName
	 * @return
	 */
	@SecurityMapping(title = "保存标签", value = "/admin/label_save.htm*", rtype = "admin", rname = "标签管理", rcode = "label", rgroup = "标签管理")
	@RequestMapping("/admin/label_save.htm")
	public ModelAndView label_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String labelName, String list_url, String add_url, String id, String class_id) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		WebForm wf = new WebForm();
		Label label = wf.toPo(request, Label.class);
		label.setId(StringUtils.isNotBlank(id) ? Long.parseLong(id) : null);
		label.setClass_id(Long.valueOf(class_id));
		this.labelService.save(label);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存标签成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage + "&class_id=" + class_id);
		}
		return mv;
	}

	/**
	 * 删除标签
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "删除标签", value = "/admin/label_del.htm*", rtype = "admin", rname = "标签管理", rcode = "label", rgroup = "标签管理")
	@RequestMapping("/admin/label_del.htm")
	public String label_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		List<Long> idList = Lists.newArrayList();
		for (String id : ids) {
			if (!id.equals("")) {
				idList.add(Long.parseLong(id));
			}
		}
		labelService.batchDelete(idList);

		return "redirect:label_manage_list.htm";
	}
}
