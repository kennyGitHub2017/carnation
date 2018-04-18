package vc.thinker.b2b2c.action.check;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;

import com.sinco.carnation.check.service.CheckClassService;
import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.check.service.CheckQuestionService;
import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

@Controller
public class CheckOuestionAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserService userService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private CheckClassService checkClassService;
	@Autowired
	private CheckGroupService checkGroupService;
	@Autowired
	private CheckQuestionService checkQuestionService;

	@SecurityMapping(title = "题目列表", value = "/admin/question_list.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_list.htm")
	public ModelAndView question_list(HttpServletRequest request, HttpServletResponse response, Long groupId) {
		ModelAndView mv = new JModelAndView("admin/blue/question_list.html", configService.getSysConfig(), 0,
				request, response);
		List<CheckQuestionBO> list = checkQuestionService.findListByGroup(groupId);
		mv.addObject("groupId", groupId);
		mv.addObject("list", list);
		return mv;
	}

	@SecurityMapping(title = "题目删除", value = "/admin/question_delete.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_delete.htm")
	public String check_question_delete(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage, Long groupId) {
		String[] ids = mulitId.split(",");
		User user = SecurityUserHolder.getCurrentUser();
		checkQuestionService.batchDelete(ids, user.getId());
		return "redirect:question_list.htm?groupId=" + groupId + "&currentPage=" + currentPage;
	}

	@SecurityMapping(title = "题目添加", value = "/admin/question_add.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_add.htm")
	public ModelAndView question_add(HttpServletRequest request, HttpServletResponse response, Long groupId) {
		ModelAndView mv = new JModelAndView("/admin/blue/question_add.html", configService.getSysConfig(), 0,
				request, response);
		List<CheckQuestionBO> list = checkQuestionService.findListByGroup(groupId);
		StringBuffer sortIds = new StringBuffer();
		for (CheckQuestionBO cq : list) {
			sortIds.append(cq.getQuestionIndex()).append(",");
		}
		mv.addObject("groupId", groupId);
		mv.addObject("sortIds", sortIds.toString());
		return mv;
	}

	@SecurityMapping(title = "题目编辑", value = "/admin/question_edit.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_edit.htm")
	public ModelAndView question_edit(HttpServletRequest request, HttpServletResponse response, Long groupId,
			Long id) {
		ModelAndView mv = new JModelAndView("/admin/blue/question_add.html", configService.getSysConfig(), 0,
				request, response);
		CheckQuestionBO question = checkQuestionService.findCheckQuestionById(id);
		mv.addObject("groupId", groupId);
		mv.addObject("question", question);
		List<CheckQuestionBO> list = checkQuestionService.findListByGroup(groupId);
		StringBuffer sortIds = new StringBuffer();
		for (CheckQuestionBO cq : list) {
			if (question.getQuestionIndex().intValue() != cq.getQuestionIndex().intValue()) {
				sortIds.append(cq.getQuestionIndex()).append(",");
			}
		}
		mv.addObject("sortIds", sortIds.toString());
		return mv;
	}

	@SecurityMapping(title = "题目保存", value = "/admin/question_save.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_save.htm")
	public ModelAndView check_group_save(HttpServletRequest request, HttpServletResponse response, Long id,
			Long groupId, String questionTitle, Integer questionIndex, Long[] optionId,
			Integer[] optionIndex, String[] optionDesc, Integer[] score, String listUrl, String addUrl) {
		User user = SecurityUserHolder.getCurrentUser();

		if (id != null) {
			checkQuestionService.updateQuestion(id, groupId, questionTitle, questionIndex, optionId,
					optionIndex, optionDesc, score, user.getId());
		} else {
			checkQuestionService.addQuestion(id, groupId, questionTitle, questionIndex, optionIndex,
					optionDesc, score, user.getId());
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", "保存题目成功");
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}
		return mv;
	}

	@SecurityMapping(title = "题目选项删除", value = "/admin/option_delete.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/option_delete.htm")
	public void check_option_delete(HttpServletRequest request, HttpServletResponse response, Long id) {
		User user = SecurityUserHolder.getCurrentUser();
		checkQuestionService.deleteOption(id, user.getId());
	}

	@SecurityMapping(title = "修改题目排序", value = "/admin/question_index_update.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/question_index_update.htm")
	public ModelAndView question_index_update(HttpServletRequest request, HttpServletResponse response,
			String listUrl, String addUrl, Long[] id, Integer[] questionIndex) {
		User user = SecurityUserHolder.getCurrentUser();
		checkQuestionService.updateQuestionIndex(id, questionIndex, user.getId());
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", listUrl);
		mv.addObject("add_url", addUrl);
		mv.addObject("op_title", "题目排序更新成功");
		return mv;
	}
}
