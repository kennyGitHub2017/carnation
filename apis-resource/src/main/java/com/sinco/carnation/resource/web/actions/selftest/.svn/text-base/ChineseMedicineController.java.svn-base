package com.sinco.carnation.resource.web.actions.selftest;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.resource.web.actions.ApiConstants;

/**
 * 中医体质自测
 * 
 * @author yuleijia
 */
@Controller
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "中医自测", namespace = "chineseMedicine")
public class ChineseMedicineController extends BasicApiController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 中医自测
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cm/queList", method = RequestMethod.GET)
	public ModelAndView query_Question_List(HttpServletRequest request) {
		logger.info("============== 中医自测 ==============");

		ModelAndView mv = new ModelAndView("wenjuan/CHMedicine_list.html");
		String webPath = CommUtil.getURL(request);
		mv.addObject("webPath", webPath);
		return mv;
	}

	/**
	 * 中医自测结果
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cm/result", method = RequestMethod.GET)
	public ModelAndView query_Question_Result(HttpServletRequest request) {
		logger.info("============== 中医自测结果 ==============");

		ModelAndView mv = new ModelAndView("wenjuan/CHMedicine_result.html");
		String webPath = CommUtil.getURL(request);
		mv.addObject("webPath", webPath);
		return mv;
	}

	/**
	 * 中医处方
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/cm/chuFan", method = RequestMethod.GET)
	public ModelAndView query_chuFan(HttpServletRequest request) {
		logger.info("============== 中医处方 ==============");

		ModelAndView mv = new ModelAndView("wenjuan/CHMedicine_chuFang.html");
		String webPath = CommUtil.getURL(request);
		mv.addObject("webPath", webPath);
		return mv;
	}
}
