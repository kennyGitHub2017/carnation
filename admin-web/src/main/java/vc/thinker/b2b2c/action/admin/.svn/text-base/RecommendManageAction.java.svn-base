package vc.thinker.b2b2c.action.admin;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.SysConfigService;

@Controller
public class RecommendManageAction {
	@Autowired
	private SysConfigService configService;

	@SecurityMapping(title = "推荐添加", value = "/admin/recommend_item_add.htm*", rtype = "admin", rname = "推荐管理", rcode = "recommend_manage", rgroup = "内容管理")
	@RequestMapping("/admin/recommend_item_add.htm")
	public ModelAndView addRecommendItem(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/recommend_item_add.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "推荐编辑", value = "/admin/recommend_item_edit.htm*", rtype = "admin", rname = "推荐管理", rcode = "recommend_manage", rgroup = "内容管理")
	@RequestMapping("/admin/recommend_item_edit.htm")
	public ModelAndView editRecommendItem(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/recommend_item_add.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "推荐列表", value = "/admin/recommend_item_list.htm*", rtype = "admin", rname = "推荐管理", rcode = "recommend_manage", rgroup = "内容管理")
	@RequestMapping("/admin/recommend_item_list.htm")
	public ModelAndView recommendItemList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String condition, String value) {
		ModelAndView mv = new JModelAndView("admin/blue//recommend_item_list.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "推荐保存", value = "/admin/recommend_item_save.htm*", rtype = "admin", rname = "推荐管理", rcode = "user_manage", rgroup = "内容管理")
	@RequestMapping("/admin/recommend_item_save.htm")
	public ModelAndView recommendSave(HttpServletRequest request, HttpServletResponse response, String id,
			String role_ids, String list_url, String add_url, String userName, String password) {
		WebForm wf = new WebForm();
		User user = null;
		if (id.equals("")) {
			user = wf.toPo(request, User.class);
			user.setCreateTime(new Date());
		} else {
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "推荐删除", value = "/admin/recommend_item_del.htm*", rtype = "admin", rname = "推荐管理", rcode = "user_manage", rgroup = "内容管理")
	@RequestMapping("/admin/recommend_item_del.htm")
	public String recommendDel(HttpServletRequest request, String mulitId, String currentPage)
			throws Exception {
//		String[] ids = mulitId.split(",");
//		for (String id : ids) {
//			if (!id.equals("")) {
//			}
//		}
		return "redirect:recommend_item_list.htm?currentPage=" + currentPage;
	}
}
