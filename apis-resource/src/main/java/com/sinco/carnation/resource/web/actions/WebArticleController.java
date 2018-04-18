package com.sinco.carnation.resource.web.actions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;

@Controller
public class WebArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;

	@RequestMapping(value = "/article/notice_article_detail", method = RequestMethod.GET)
	public String faceArticleDetail(HttpServletRequest request, Model model, Long articleId) {
		Article article = articleService.getObjById(articleId);
		model.addAttribute("article", article);
		return "article/notice_article_detail.htm";
	}

}
