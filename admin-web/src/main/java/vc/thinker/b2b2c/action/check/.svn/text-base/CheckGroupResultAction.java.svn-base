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
import com.sinco.carnation.check.service.CheckGroupResultService;
import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.check.service.CheckQuestionService;
import com.sinco.carnation.sns.bo.CheckGroupResultBO;
import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sns.vo.CheckGroupResultVO;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;

@Controller
public class CheckGroupResultAction {

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
	private CheckGroupResultService checkGroupResultService;
	@Autowired
	private CheckQuestionService checkQuestionService;

	@SecurityMapping(title = "题组结果列表", value = "/admin/group_result_list.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/group_result_list.htm")
	public ModelAndView group_result_list(HttpServletRequest request, HttpServletResponse response,
			Long groupId) {
		ModelAndView mv = new JModelAndView("admin/blue/group_result_list.html",
				configService.getSysConfig(), 0, request, response);

		List<CheckGroupResultBO> resultList = checkGroupResultService.findListByGroup(groupId);
		CheckQuestionBO questionBO = checkQuestionService.queryQuestionSorceRange(groupId);
		mv.addObject("questScoreRange", questionBO);
		mv.addObject("groupId", groupId);
		mv.addObject("resultList", resultList);
		return mv;
	}

	@SecurityMapping(title = "结果删除", value = "/admin/group_result_delete.htm*", rtype = "admin", rname = "自测题管理", rcode = "admin", rgroup = "内容管理")
	@RequestMapping("/admin/group_result_delete.htm")
	public String check_group_delete(HttpServletRequest request, HttpServletResponse response, Long id,
			Long groupId) {
		checkGroupResultService.deleteCheckGroupResult(id);
		return "redirect:group_result_list.htm?groupId=" + groupId;
	}

	@SecurityMapping(title = "结果添加", value = "/admin/group_result_add.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/group_result_add.htm")
	public ModelAndView information_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage, Long groupId) {
		ModelAndView mv = new JModelAndView("/admin/blue/group_result_add.html",
				configService.getSysConfig(), 0, request, response);
		Integer startScore = checkGroupResultService.findMaxEndScoreByGroup(groupId);
		CheckQuestionBO questionBO = checkQuestionService.queryQuestionSorceRange(groupId);
		mv.addObject("questScoreRange", questionBO);
		if (null != startScore && startScore != 0) {
			startScore++;
		} else {
			startScore = 0;
		}
		mv.addObject("startScore", startScore);
		mv.addObject("groupId", groupId);
		return mv;
	}

	@SecurityMapping(title = "结果编辑", value = "/admin/group_result_edit.htm*", rtype = "admin", rname = "自测题管理", rcode = "information_admin", rgroup = "内容管理")
	@RequestMapping("/admin/group_result_edit.htm")
	public ModelAndView information_edit(HttpServletRequest request, HttpServletResponse response, Long id,
			String currentPage, Long groupId) {
		ModelAndView mv = new JModelAndView("admin/blue/group_result_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			CheckGroupResultBO checkGroupResultBO = checkGroupResultService.findById(id);
			CheckQuestionBO questionBO = checkQuestionService.queryQuestionSorceRange(groupId);
			mv.addObject("questScoreRange", questionBO);
			mv.addObject("obj", checkGroupResultBO);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		mv.addObject("groupId", groupId);
		return mv;
	}

	@SecurityMapping(title = "结果保存", value = "/admin/group_result_save.htm*", rtype = "admin", rname = "自测题管理", rcode = "check_admin", rgroup = "内容管理")
	@RequestMapping("/admin/group_result_save.htm")
	public ModelAndView check_group_save(HttpServletRequest request, HttpServletResponse response,
			CheckGroupResultVO vo, String listUrl, String addUrl) {
		User user = SecurityUserHolder.getCurrentUser();
		if (vo.getId() != null) {
			checkGroupResultService.updateById(vo, user.getId());
		} else {
			checkGroupResultService.addCheckGroupResult(vo, user.getId());
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("groupId", vo.getGroupId());
		mv.addObject("list_url", listUrl);
		mv.addObject("op_title", "保存套题结果成功");
		if (addUrl != null) {
			mv.addObject("add_url", addUrl);
		}
		return mv;
	}
}
