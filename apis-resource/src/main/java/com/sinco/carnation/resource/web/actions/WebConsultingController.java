package com.sinco.carnation.resource.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinco.carnation.consulting.service.ConsultingService;
import com.sinco.carnation.resource.vo.favorites.ReplyListVO;
import com.sinco.carnation.sns.bo.ConsultingBO;

@Controller
public class WebConsultingController {

	@Autowired
	private ConsultingService consultingService;

	@RequestMapping(value = "/consulting/my_consulting", method = RequestMethod.GET)
	public String myConsulting(HttpServletRequest request, ReplyListVO vo, Model model, Long id) {
		ConsultingBO consultingBO = consultingService.selectConsultingDetailById(id);
		model.addAttribute("consultingBO", consultingBO);
		return "consulting/consulting.htm";
	}

}
