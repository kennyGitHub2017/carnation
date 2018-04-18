package vc.thinker.b2b2c.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.bo.ArticleClassBO;
import com.sinco.carnation.sys.contants.SysContants;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.ArticleViewTools;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: ArticleViewAction.java
 * </p>
 * 
 * <p>
 * Description: 前台文章控制器，主要功能: 1、分类列表文章 2、显示文章
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
 * @date 2014-4-30
 * 
 * @version 1.0.1
 */
@Controller
public class ArticleViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ArticleClassService articleClassService;
	@Autowired
	private ArticleViewTools articleTools;

	@RequestMapping("/articlelist_help.htm")
	public ModelAndView article_list(HttpServletRequest request, HttpServletResponse response, String param,
			MyPage<ArticleBO> page) {
		ModelAndView mv = new JModelAndView("article_list.html", configService.getSysConfig(), 1, request,
				response);
		ArticleClass ac = null;
		Long id = CommUtil.null2Long(param);

		ArticleShopVO vo = new ArticleShopVO();
		String mark = "";
		if (id == -1l) {
			mark = param;
		}
		if (StringUtils.isNotBlank(mark)) {
			ac = this.articleClassService.findByMark(mark);
		}
		if (id != -1l) {
			ac = this.articleClassService.getObjById(id);
		}
		if (ac != null) {
			if (ac.getParentId() == null) {
				List<Long> childId = this.articleClassService.findChildId(ac.getId());
				childId.add(ac.getId());
				vo.setClassIds(childId);
			} else {
				vo.setClassIds(Lists.newArrayList(ac.getId()));
			}
		}
		vo.setDisplay(true);
		vo.setType(SysContants.ARTICLE_TYPE_USER);

		this.articleService.findShopPageByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		List<ArticleClassBO> acs = this.articleClassService.findLevelAllWithOutManager();

		ArticleShopVO articlesVO = new ArticleShopVO();
		articlesVO.setDisplay(true);
		articlesVO.setCount(6);
		List<ArticleBO> articles = this.articleService.findShopByVO(articlesVO);
		mv.addObject("ac", ac);
		mv.addObject("articles", articles);
		mv.addObject("acs", acs);
		return mv;
	}

	@RequestMapping("/article.htm")
	public ModelAndView article(HttpServletRequest request, HttpServletResponse response, String param) {
		ModelAndView mv = new JModelAndView("article.html", configService.getSysConfig(), 1, request,
				response);
		Article obj = null;
		Long id = CommUtil.null2Long(param);
		String mark = "";
		if (id == -1l) {
			mark = param;
		}
		if (id != -1l) {
			obj = this.articleService.getObjById(id);
		}
		if (StringUtils.isNotBlank(mark)) {
			obj = this.articleService.findByMark(mark);
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (userDetails != null) {
			if (obj != null && obj.getType().equals(SysContants.ARTICLE_TYPE_USER)) {
				List<ArticleClassBO> acs = this.articleClassService.findLevelAllWithOutManager();

				ArticleShopVO articlesVO = new ArticleShopVO();
				articlesVO.setDisplay(true);
				articlesVO.setCount(6);
				List<ArticleBO> articles = this.articleService.findShopByVO(articlesVO);

				mv.addObject("articles", articles);
				mv.addObject("acs", acs);
				mv.addObject("obj", obj);
				mv.addObject("articleTools", articleTools);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "商家公告，您无权查看！");
			}
			if (userDetails.getSeller() != null) {
				if (obj != null) {
					List<ArticleClassBO> acs = this.articleClassService.findLevelAllWithOutManager();

					ArticleShopVO articlesVO = new ArticleShopVO();
					articlesVO.setDisplay(true);
					articlesVO.setCount(6);
					List<ArticleBO> articles = this.articleService.findShopByVO(articlesVO);

					mv.addObject("articles", articles);
					mv.addObject("acs", acs);
					mv.addObject("obj", obj);
					mv.addObject("articleTools", articleTools);
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "商家公告，您无权查看！");
				}
			}
		} else {
			if (obj != null && obj.getType().equals("user")) {
				List<ArticleClassBO> acs = this.articleClassService.findLevelAllWithOutManager();

				ArticleShopVO articlesVO = new ArticleShopVO();
				articlesVO.setDisplay(true);
				articlesVO.setCount(6);
				List<ArticleBO> articles = this.articleService.findShopByVO(articlesVO);

				mv.addObject("articles", articles);
				mv.addObject("acs", acs);
				mv.addObject("obj", obj);
				mv.addObject("articleTools", articleTools);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "商家公告，您无权查看！");
			}
		}
		return mv;
	}
}
