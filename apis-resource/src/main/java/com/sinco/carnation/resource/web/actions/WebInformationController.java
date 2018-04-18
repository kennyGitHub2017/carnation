package com.sinco.carnation.resource.web.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinco.carnation.cms.service.InformationServiceImpl;
import com.sinco.carnation.sns.bo.InformationBO;

@Controller
public class WebInformationController {

	@Autowired
	private InformationServiceImpl informationServiceImpl;

	@RequestMapping(value = "/information/face_information_detail", method = RequestMethod.GET)
	public String faceInformationDetail(HttpServletRequest request, Model model, Long informationId) {
		InformationBO informationBO = informationServiceImpl.findById(informationId);
		if (informationBO == null) {
			return "404";
		}
		List<InformationBO> listInformation = informationServiceImpl.selectByClassId(informationBO
				.getClassid());
		model.addAttribute("informationBO", informationBO);
		model.addAttribute("listInformation", listInformation);
		model.addAttribute("contactFlag", "0");
		return "article/information_detail.htm";
	}

	@RequestMapping(value = "/information/project_information_detail", method = RequestMethod.GET)
	public String projectInformationDetail(HttpServletRequest request, Model model, Long informationId) {
		InformationBO informationBO = informationServiceImpl.findById(informationId);
		if (informationBO == null) {
			return "404";
		}
		List<InformationBO> listInformation = informationServiceImpl.selectByClassId(informationBO
				.getClassid());
		model.addAttribute("informationBO", informationBO);
		model.addAttribute("listInformation", listInformation);
		model.addAttribute("contactFlag", "0");
		return "article/information_detail.htm";
	}

}
