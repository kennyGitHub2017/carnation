package com.sinco.carnation.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.alibaba.fastjson.JSONObject;
import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.dal.common.MyPage;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping("e")
public class EnterpriseController {

	private static Logger logger = LoggerFactory.getLogger(EnterpriseController.class);

	@Autowired
	private ArticleService articleService;
	@Autowired
	private AdvertService advertService;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	@Value("${web.static.path}")
	private String staticPath;
	@Value("${web.yes.path}")
	private String yesPath;

	@RequestMapping(method = RequestMethod.GET)
	public String defaultView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "redirect:/e/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexView(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Advert> indexSlide = advertService.findZSIndexSlide();
		List<Advert> indexEvent = advertService.findZSIndexEvent();
		List<Advert> indexVideo = advertService.findZSIndexVideo();
		ArticleShopVO vo = new ArticleShopVO();
		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageSize(3);
		vo.setMark(MarkConstants.ZS_MARK_EVENT);
		List<ArticleBO> events = articleService.selectViewPageListByMark(page, vo);
		page.setPageSize(3);
		vo.setMark(MarkConstants.ZS_MARK_VIDEO);
		List<ArticleBO> videos = articleService.selectViewPageListByMark(page, vo);
		page.setPageSize(4);
		vo.setMark(MarkConstants.ZS_MARK_HY_EVENT);
		List<ArticleBO> hyevents = articleService.selectViewPageListByMark(page, vo);
		page.setPageSize(4);
		vo.setMark(MarkConstants.ZS_MARK_CUSTOMER);
		List<ArticleBO> customers = articleService.selectViewPageListByMark(page, vo);

		model.addAttribute("indexSlide", indexSlide);
		model.addAttribute("indexEvent", (null != indexEvent && !indexEvent.isEmpty()) ? indexEvent.get(0)
				: null);
		model.addAttribute("indexVideo", (null != indexVideo && !indexVideo.isEmpty()) ? indexVideo.get(0)
				: null);

		model.addAttribute("events", events);
		model.addAttribute("videos", videos);
		model.addAttribute("hyevents", hyevents);
		model.addAttribute("customers", customers);
		return "/enterprise/index";
	}

	@RequestMapping(value = "/case", method = RequestMethod.GET)
	public String caseView(HttpServletRequest request, HttpServletResponse response, Model model) {
		ArticleShopVO vo = new ArticleShopVO();
		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageSize(5);
		vo.setMark(MarkConstants.ZS_MARK_CUSTOMER);
		List<ArticleBO> custormers = articleService.selectViewPageListByMark(page, vo);
		model.addAttribute("custormers", custormers);
		return "/enterprise/case";
	}

	@RequestMapping(value = "/app", method = RequestMethod.GET)
	public String appView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/app";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contactView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/contact";
	}

	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faqView(HttpServletRequest request, HttpServletResponse response, MyPage<ArticleBO> page,
			Model model) {
		ArticleShopVO vo = new ArticleShopVO();
		vo.setMark(MarkConstants.ZS_MARK_PROBLEM);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/enterprise/faq";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/join";
	}

	@RequestMapping(value = "/merchantsNews", method = RequestMethod.GET)
	public String merchantsNewsView(HttpServletRequest request, HttpServletResponse response, Model model) {
		ArticleShopVO vo = new ArticleShopVO();
		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageSize(1);
		page.setPageNumber(1);
		vo.setMark(MarkConstants.ZS_MARK_BUSINESS);
		List<ArticleBO> businesses = articleService.selectViewPageListByMark(page, vo);
		model.addAttribute("businesses", businesses);
		return "/enterprise/merchantsNews";
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String newsView(Model model, MyPage<ArticleBO> page, ArticleShopVO vo) {
		int pageNum = 1;
		page.setPageNumber(pageNum);
		page.setPageSize(pageNum);
		vo.setMark(MarkConstants.ZS_MARK_HY_EVENT);
		List<ArticleBO> bos = articleService.selectViewPageListByMark(page, vo);
		String eventsHtml = this.getEventsHtml(pageNum);
		String hyeventsHtml = StringUtils.EMPTY;
		if (null != bos && !bos.isEmpty()) {
			hyeventsHtml = this.getHYEventsHtml(bos.get(0).getId());
		}

		model.addAttribute("events", eventsHtml);
		model.addAttribute("hyevents", hyeventsHtml);
		return "/enterprise/news";
	}

	@RequestMapping(value = "/news/event", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String newsEventsAjax(HttpServletRequest request) {
		String num = request.getParameter("page");
		String html = this.getEventsHtml(Integer.valueOf(num));
		return html;
	}

	private String getEventsHtml(int pageNum) {
		ArticleShopVO vo = new ArticleShopVO();
		MyPage<ArticleBO> page = new MyPage<ArticleBO>();
		page.setPageSize(4);
		page.setPageNumber(pageNum);
		vo.setMark(MarkConstants.ZS_MARK_EVENT);
		articleService.selectViewPageListByMark(page, vo);
		String gotoPageAjaxHTML = CommUtil.showPageAjaxViewHtml("/e/news/event", "&page=",
				page.getCurrentPage(), page.getPages(), page.getPageSize(), page.getNumberOfElements());
		JSONObject object = new JSONObject();
		object.put("events", page.getContent());
		object.put("staticPath", staticPath);
		object.put("yesPath", yesPath);
		object.put("gotoPageAjaxHTML", gotoPageAjaxHTML);
		String html = process("event.ftl", object);

		return html;
	}

	@RequestMapping(value = "/news/hyevent", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String newsHYEventsAjax(HttpServletRequest request) {
		String aid = request.getParameter("id");
		String html = this.getHYEventsHtml(Long.valueOf(aid));
		return html;
	}

	private String getHYEventsHtml(long aid) {
		List<ArticleBO> hyevents = articleService.selectPreNextById(aid);
		JSONObject object = new JSONObject();
		if (null != hyevents.get(0).getId()) {
			object.put("preId", hyevents.get(0).getId());
		}
		if (null != hyevents.get(2).getId()) {
			object.put("nextId", hyevents.get(2).getId());
		}
		object.put("article", hyevents.get(1));
		object.put("staticPath", staticPath);
		object.put("yesPath", yesPath);
		String html = process("hyevent.ftl", object);

		return html;
	}

	@RequestMapping(value = "/operator", method = RequestMethod.GET)
	public String operatorView(Model model, MyPage<ArticleBO> page, ArticleShopVO vo) {
		page.setPageSize(4);
		vo.setMark(MarkConstants.ZS_MARK_OPERATOR);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/enterprise/operator";
	}

	@RequestMapping(value = "/privacy", method = RequestMethod.GET)
	public String privacyView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/privacy";
	}

	@RequestMapping(value = "/laws", method = RequestMethod.GET)
	public String lawsView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/laws";
	}

	@RequestMapping(value = "/wait", method = RequestMethod.GET)
	public String waitView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/wait";
	}

	@RequestMapping(value = "/content", method = RequestMethod.GET)
	public String contentView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "/enterprise/content";
	}

	/**
	 * 根据模板返回html信息
	 * 
	 * @param templateName
	 * @param object
	 * @return
	 */
	public String process(String templateName, JSONObject object) {
		try {
			Configuration configuration = freeMarkerConfigurer.getConfiguration();
			Template template = configuration.getTemplate(templateName);
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, object);
		} catch (Exception e) {
			logger.error("获取模板信息出错：", e);
		}

		return StringUtils.EMPTY;
	}
}
