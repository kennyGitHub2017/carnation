package com.sinco.carnation.resource.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinco.carnation.check.service.CheckGroupService;
import com.sinco.carnation.check.service.CheckQuestionService;
import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.bo.CheckQuestionBO;
import com.sinco.carnation.sns.vo.CheckQuestionVO;

@Controller
public class WebCheckController {

	@Autowired
	private CheckQuestionService checkQuestionService;

	@Autowired
	private CheckGroupService checkGroupService;

	@RequestMapping(value = "/check/question", method = RequestMethod.GET)
	public String checkQuestion(HttpServletRequest request, CheckQuestionVO vo, Model model) {

		if (vo.getQuestionIndex() == null) {
			vo.setQuestionIndex(1);
		}

		CheckQuestionBO checkQuestionBO = checkQuestionService.selectQuestionByGroupAndIndex(vo);

		model.addAttribute("checkQuestionBO", checkQuestionBO);

		return "check/check_question.htm";
	}

	@RequestMapping(value = "/check/detail", method = RequestMethod.GET)
	public String checkDetail(HttpServletRequest request, Long groupId, Model model) {

		CheckGroupBO checkGroupBO = checkGroupService.findById(groupId);
		model.addAttribute("checkGroupBO", checkGroupBO);

		return "check/check_detail.htm";
	}

	@RequestMapping(value = "/check/ajax_question", method = RequestMethod.POST)
	public @ResponseBody
	CheckQuestionBO ajaxQuestion(HttpServletRequest request, CheckQuestionVO vo, Model model) {
		if (vo.getQuestionIndex() == null) {
			vo.setQuestionIndex(1);
		}

		CheckQuestionBO checkQuestionBO = checkQuestionService.selectQuestionByGroupAndIndex(vo);

		return checkQuestionBO;
	}

	@RequestMapping(value = "/check/main", method = RequestMethod.GET)
	public String check_main(HttpServletRequest request, Model model) {

		return "check/check_main.htm";
	}
}
