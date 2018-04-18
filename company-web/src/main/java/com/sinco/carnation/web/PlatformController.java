package com.sinco.carnation.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

@Controller
@RequestMapping("p")
public class PlatformController {

	// access service layout
	@Autowired
	private ArticleService articleService;

	@Autowired
	private AdvertService advertService;

	@RequestMapping(method = RequestMethod.GET)
	public String defaultView(HttpServletRequest request, HttpServletResponse response, Model model) {

		List<Advert> indexSlide = advertService.findIndexSlide();
		model.addAttribute("indexSlide", indexSlide);
		List<Advert> list = advertService.findAdForCompanyDynamic();
		model.addAttribute("companyDynamic", list);
		return "/platform/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexView(HttpServletRequest request, HttpServletResponse response, Model model) {

		List<Advert> list = advertService.findAdForCompanyDynamic();
		model.addAttribute("companyDynamic", list);
		return "/platform/index";
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String downloadView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/download";
	}

	@RequestMapping(value = "/appDownLoad", method = RequestMethod.GET)
	public String appView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/appDownLoad";
	}
	
	@RequestMapping(value = "/shdappDownLoad", method = RequestMethod.GET)
	public String appView2(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/shdappDownLoad";
	}
	
	@RequestMapping(value = "/yysappDownLoad", method = RequestMethod.GET)
	public String appView3(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/yysappDownLoad";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String aboutView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/about";
	}
	
	@RequestMapping(value = "/industrytrends", method = RequestMethod.GET)
	public String industrytrendsView(HttpServletRequest request, HttpServletResponse response, Model model,
			MyPage<ArticleBO> page, ArticleShopVO ao) {
		// add by stone
		page.setPageSize(4);
		articleService.findByParentMark("ZS_HY_EVENT", page);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/platform/industrytrends";
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String newsView(HttpServletRequest request, HttpServletResponse response, Model model,
			MyPage<ArticleBO> page, ArticleShopVO ao) {
		// add by stone
		page.setPageSize(4);
		articleService.selectViewPageList(page, ao);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		
		return "/platform/news";
	}
	
	

	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	public String newsView(@PathVariable("id") long id, Model model) {
		Article refereeArticle = articleService.getObjById(id);
		if (null != refereeArticle) {
			List<ArticleBO> listArticlePrevious = articleService.selectViewDetailsPrevious(
					refereeArticle.getArticleClassId(), id);
			List<ArticleBO> listArticleNext = articleService.selectViewDetailsNext(
					refereeArticle.getArticleClassId(), id);
			ArticleBO alPrevious = listArticlePrevious.size() == 0 ? null : listArticlePrevious.get(0);
			ArticleBO alNext = listArticleNext.size() == 0 ? null : listArticleNext.get(0);

			refereeArticle.setRate(refereeArticle.getRate() + 1);
			articleService.update(refereeArticle);

			model.addAttribute("listArticlePrevious", alPrevious);
			model.addAttribute("listArticleNext", alNext);
			model.addAttribute("refereeArticle", refereeArticle);

			return "/platform/show";
		} else {
			return "/platform/show";
		}
	}

	@RequestMapping(value = "/shop", method = RequestMethod.GET)
	public String shopView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/shop";
	}

	@RequestMapping(value = "/o2o", method = RequestMethod.GET)
	public String o2oView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/o2o";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/contact";
	}

	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public String privacyView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/privacy";
	}

	@RequestMapping(value = "/laws", method = RequestMethod.GET)
	public String lawsView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/laws";
	}

	@RequestMapping(value = "/hr", method = RequestMethod.GET)
	public String hrView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/hr";
	}

	@RequestMapping(value = "/wait", method = RequestMethod.GET)
	public String waitView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/wait";
	}

	@RequestMapping(value = "/bracelet", method = RequestMethod.GET)
	public String braceletView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/platform/bracelet";
	}

}
