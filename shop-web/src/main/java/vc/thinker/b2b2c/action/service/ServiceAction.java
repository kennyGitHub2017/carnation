package vc.thinker.b2b2c.action.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.sys.service.SysConfigService;

@Controller
public class ServiceAction {

	@Autowired
	private SysConfigService configService;

	@RequestMapping("/static")
	public ModelAndView static1(HttpServletRequest request, HttpServletResponse response, String name) {

		ModelAndView mv = new JModelAndView("o2o/" + name, configService.getSysConfig(), 1, request, response);
		return mv;
	}

	@RequestMapping("/static/include")
	public ModelAndView staticInclude(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new JModelAndView("o2o/" + request.getAttribute("name"),
				configService.getSysConfig(), 1, request, response);
		return mv;
	}

}
