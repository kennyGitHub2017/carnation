package vc.thinker.b2b2c.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;

import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.DocumentService;
import com.sinco.carnation.sys.service.SysConfigService;

/**
 * 
 * <p>
 * Title: DocumentViewAction.java
 * </p>
 * 
 * <p>
 * Description:系统文章前台显示控制器
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-5-6
 * 
 * @version 1.0.1
 */
@Controller
public class DocumentViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private DocumentService documentService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;

	@RequestMapping("/doc.htm")
	public ModelAndView doc(HttpServletRequest request, HttpServletResponse response, String mark) {
		ModelAndView mv = new JModelAndView("article.html", configService.getSysConfig(), 1, request,
				response);
		Document obj = documentService.findByMark(mark);
		List<ArticleClassBO> acs = articleClassService.topClass();
		List<ArticleBO> articles = articleService.top6();
		mv.addObject("doc", "doc");
		mv.addObject("obj", obj);
		mv.addObject("articles", articles);
		mv.addObject("acs", acs);

		return mv;
	}
}
