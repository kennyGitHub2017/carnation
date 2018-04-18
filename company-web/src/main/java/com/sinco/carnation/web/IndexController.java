package com.sinco.carnation.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.util.Log;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.IpAddressByDetails;

import com.sinco.carnation.recommend.service.AdvertService;
import com.sinco.carnation.sns.bo.SnsActivityBO;
import com.sinco.carnation.sns.model.Advert;
import com.sinco.carnation.sns.vo.SnsActivityVO;
import com.sinco.carnation.sys.bo.ArticleBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.Article;
import com.sinco.carnation.sys.model.ArticleClass;
import com.sinco.carnation.sys.service.ActApplyService;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.ArticleService;
import com.sinco.carnation.sys.service.SnsActivityService;
import com.sinco.carnation.sys.vo.ActApplyVO;
import com.sinco.carnation.sys.vo.ArticleShopVO;
import com.sinco.common.utils.IPUtil;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicBase;

@Controller
public class IndexController {

	@Autowired
	private AdvertService advertService;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private ArticleClassService articleClassService;

	@Autowired
	private ActApplyService actApplyService;

	@Autowired
	private DicContent dicContant;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private SnsActivityService snsActivityService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexView(HttpServletRequest request, HttpServletResponse response, Model model) {
		List<Advert> list = advertService.findAdForCompanyDynamic();
		// System.out.println(SecurityUserHolder.getCurrentUserDetails() ==
		// null);
		List<Advert> indexSlide = advertService.findIndexSlide();
		List<ArticleBO> hyEvent = articleService.listByParentMarkAndCount( 4L ,"ZS_HY_EVENT");
		model.addAttribute("companyDynamic", list);
		model.addAttribute("indexSlide", indexSlide);
		model.addAttribute("hyEvent", hyEvent);
		return "/platform/index";
	}

	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	public String detailView(@PathVariable("id") long id, HttpServletRequest request,
			HttpServletResponse response, MyPage<ArticleBO> page, Model model) {
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

			return "/detail";
		} else {
			return "/404";
		}
	}

	@RequestMapping(value = "/news/more", method = RequestMethod.GET)
	public String moreView(HttpServletRequest request, HttpServletResponse response, MyPage<ArticleBO> page,
			Model model) {
		String mark = request.getParameter("mark");
		ArticleShopVO vo = new ArticleShopVO();
		vo.setMark(mark);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/more";
	}

	@RequestMapping(value = "/e/news/more", method = RequestMethod.GET)
	public String moreEView(HttpServletRequest request, HttpServletResponse response, MyPage<ArticleBO> page,
			Model model) {
		String mark = request.getParameter("mark");
		ArticleShopVO vo = new ArticleShopVO();
		vo.setMark(mark);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/more";
	}

	@RequestMapping(value = "/applyJoin", method = RequestMethod.GET)
	public void applyJoin(HttpServletRequest request, HttpServletResponse response, ActApplyVO vo, Model model) {

		String ip = IPUtil.getIpAddr(request);
		// ip="121.34.128.240";
		String ipdetail = snsActivityService.redIpFind(request, response, ip);
		vo.setAddress(ipdetail);
		vo.setCreateTime(new Date());
		if (actApplyService.save(vo)) {
			CommUtil.returnBody(response, Json.toJson(ActionResult.NewSuccess("")));
		} else {

			CommUtil.returnBody(response, Json.toJson(ActionResult.NewFail("")));
		}

	}

	@RequestMapping(value = "/applySave", method = RequestMethod.GET)
	public void applySave(HttpServletRequest request, HttpServletResponse response, ActApplyVO vo,
			Long actId, Model model) {

		String ip = IPUtil.getIpAddr(request);
		// ip="121.34.128.240";
		String ipdetail = snsActivityService.redIpFind(request, response, ip);
		vo.setAddress(ipdetail);
		vo.setCreateTime(new Date());
		vo.setApplyType(1);
		vo.setApplyActRelation(actId);
		if (actApplyService.save(vo)) {
			CommUtil.returnBody(response, Json.toJson(ActionResult.NewSuccess("")));
		} else {

			CommUtil.returnBody(response, Json.toJson(ActionResult.NewFail("")));
		}
	}

	@RequestMapping(value = "/investmentact", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response, Model model,
			SnsActivityVO vo) {
		ArticleClass articleClass = articleClassService.findByMark(MarkConstants.ZS_MARK_BUSINESS);
		ArticleClass articleClass2 = articleClassService.findByMark(MarkConstants.ZS_MARK_EVENT);

		List<ArticleBO> list = articleService.selectByClassId(articleClass.getId(), 5);
		List<ArticleBO> list2 = articleService.selectByClassId(articleClass2.getId(), 4);

		vo.getAreaId();
		List<SnsActivityBO> readlist = snsActivityService.findbyVORead(vo, null, "4524130", null, null, null,
				1);
		List<SnsActivityBO> bglist = snsActivityService.findbyVOBg(vo, null, "4524130", null, null, null, 1);
		List<SnsActivityBO> endlist = snsActivityService
				.findbyVOEnd(vo, null, "4524130", null, null, null, 1);

		String ip = IPUtil.getIpAddr(request);
		// ip="121.34.128.240";
		String ipdetail = redIpFind(request, response, ip);
		if (ipdetail.equals("[未分配或者内网IP------]") || ipdetail.equals("[---IP地址不正确!----]")) {
			ip = "121.34.128.240";
			ipdetail = redIpFind(request, response, ip);
		}
		Area area = areaService.queryAreaByName(city);
		if (area != null) {
			Long cid = area.getId();
			Long pid = area.getParentId();
			model.addAttribute("cid", cid);
			model.addAttribute("pid", pid);
			// iscity = 1;
			System.out.println("cid:" + cid);
		}

		model.addAttribute("areas", areaService.queryParentArea());
		model.addAttribute("objs", list);
		model.addAttribute("objs2", list2);

		model.addAttribute("readNews", readlist);
		model.addAttribute("bgNews", bglist);
		model.addAttribute("endActNews", endlist);
		return "/business/index";
	}

	@RequestMapping(value = "/minvestmentact", method = RequestMethod.GET)
	public String mindex(HttpServletRequest request, HttpServletResponse response, Model model,
			SnsActivityVO vo) {
		ArticleClass articleClass = articleClassService.findByMark(MarkConstants.ZS_MARK_BUSINESS);
		ArticleClass articleClass2 = articleClassService.findByMark(MarkConstants.ZS_MARK_EVENT);

		List<ArticleBO> list = articleService.selectByClassId(articleClass.getId(), 5);
		List<ArticleBO> list2 = articleService.selectByClassId(articleClass2.getId(), 6);

		vo.getAreaId();
		List<SnsActivityBO> readlist = snsActivityService.findbyVORead(vo, null, "4524130", null, null, null,
				1);
		List<SnsActivityBO> bglist = snsActivityService.findbyVOBg(vo, null, "4524130", null, null, null, 1);
		List<SnsActivityBO> endlist = snsActivityService
				.findbyVOEnd(vo, null, "4524130", null, null, null, 1);

		String ip = IPUtil.getIpAddr(request);
		// ip="121.34.128.240";
		String ipdetail = redIpFind(request, response, ip);
		if (ipdetail.equals("[未分配或者内网IP------]") || ipdetail.equals("[---IP地址不正确!----]")) {
			ip = "121.34.128.240";
			ipdetail = redIpFind(request, response, ip);
		}
		Area area = areaService.queryAreaByName(city);
		if (area != null) {
			Long cid = area.getId();
			Long pid = area.getParentId();
			model.addAttribute("cid", cid);
			model.addAttribute("pid", pid);
			// iscity = 1;
			System.out.println("cid:" + cid);
		}

		model.addAttribute("areas", areaService.queryParentArea());
		model.addAttribute("objs", list);
		model.addAttribute("objs2", list2);
		model.addAttribute("readNews", readlist);
		model.addAttribute("bgNews", bglist);
		model.addAttribute("endActNews", endlist);
		return "/business/mindex";
	}

	String city = "深圳";

	public String redIpFind(HttpServletRequest request, HttpServletResponse response, String ip) {
		String ipdetail = "[---IP地址不正确!----]";
		try {
			if (ip != null && !ip.equals("") && ip.indexOf("0:0:0:0") < 0) {
				String[] split = ip.trim().split(",");
				ipdetail = IpAddressByDetails.GetAddressByIp(split[0].trim());
			}
			String ctys[] = ipdetail.split("--");
			if(ctys.length>1){
				city = ctys[2];
			}
		} catch (Exception e) {
			
		}
		return ipdetail;
	}

	/**
	 * 根据父id加载下级区域，返回json格式数据，这里只返回id和areaName，根据需要可以修改返回数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/load_areaAct")
	@ResponseBody
	public String load_area(HttpServletRequest request, HttpServletResponse response, String pid,
			SnsActivityVO vo, String level) {
		try {
			Map resultMap = new HashMap<String, Object>();
			String provinceAreaid = null;
			String cityAreaid = null;
			String countyAreaid = null;
			if (level.equals("2")) {
				provinceAreaid = pid;
			} else if (level.equals("3")) {
				cityAreaid = pid;
			} else if (level.equals("4")) {
				countyAreaid = pid;
			}
			vo.getAreaId();
			List<SnsActivityBO> readlist = snsActivityService.findbyVORead(vo, null, provinceAreaid,
					cityAreaid, countyAreaid, null, 1);
			List<SnsActivityBO> bglist = snsActivityService.findbyVOBg(vo, null, provinceAreaid, cityAreaid,
					countyAreaid, null, 1);
			List<SnsActivityBO> endlist = snsActivityService.findbyVOEnd(vo, null, provinceAreaid,
					cityAreaid, countyAreaid, null, 1);

			Collection<DicBase> areas = this.dicContant.getDicsByParentCode(Area.class, pid);
			List<Map> list = new ArrayList<Map>();
			for (DicBase area : areas) {
				Map map = new HashMap();
				map.put("id", area.getCode());
				map.put("areaName", area.getName());
				list.add(map);
			}
			new Date();
			resultMap.put("areaList", list);
			resultMap.put("readNews", readlist);
			resultMap.put("bgNews", bglist);
			resultMap.put("endActNews", endlist);

			// list.add(mapnews);
			return Json.toJson(ActionResult.NewSuccess(resultMap));
		} catch (Exception e) {
			Log.error(String.format("%s", CommUtil.getStackTrace(e)));
			// list.add(mapnews);
			return Json.toJson(ActionResult.NewFail("服务器异常"));
		}
	}

	@RequestMapping(value = "/actnews/{id}", method = RequestMethod.GET)
	public String detailActNewsView(@PathVariable("id") long id, HttpServletRequest request,
			HttpServletResponse response, MyPage<SnsActivityBO> page, Model model) {

		SnsActivityBO tnews = snsActivityService.findByIdOne(id, 1);
		if (null != tnews) {
			SnsActivityBO pnews = snsActivityService.findByIdPrevious(id, 1);
			SnsActivityBO nnews = snsActivityService.findByIdNext(id, 1);

			/*refereeArticle.setRate(refereeArticle.getRate() + 1);
			articleService.update(refereeArticle);*/

			model.addAttribute("listArticlePrevious", pnews);
			model.addAttribute("listArticleNext", nnews);
			model.addAttribute("refereeArticle", tnews);

			return "/actnewsdetail";
		} else {
			return "/404";
		}
	}

	@RequestMapping(value = "/jgindex", method = RequestMethod.GET)
	public String jgindexView(HttpServletRequest request, HttpServletResponse response,
			MyPage<ArticleBO> page, Model model) {
		String mark = request.getParameter("mark");
		ArticleShopVO vo = new ArticleShopVO();
		vo.setMark(mark);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/jgGroup/index";
	}

	@RequestMapping(value = "/jgmindex", method = RequestMethod.GET)
	public String jgmindexView(HttpServletRequest request, HttpServletResponse response,
			MyPage<ArticleBO> page, Model model) {
		String mark = request.getParameter("mark");
		ArticleShopVO vo = new ArticleShopVO();
		vo.setMark(mark);
		articleService.selectViewPageListByMark(page, vo);
		CommUtil.saveIPageList3Model("", "", "", page, model);
		return "/jgGroup/mindex";
	}

}
