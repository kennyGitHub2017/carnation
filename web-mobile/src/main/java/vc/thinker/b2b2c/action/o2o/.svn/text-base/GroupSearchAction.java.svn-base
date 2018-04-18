package vc.thinker.b2b2c.action.o2o;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.interceptor.LbsInterceptorAdapter;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.store.search.StoreDocument;
import com.sinco.carnation.store.search.StoreSearchResult;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.vo.StoreSearchVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupViewAction.java
 * </p>
 * 
 * <p>
 * Description:团购管理控制器，超级后台用来发起团购、审核团购商品，添加团购商品类目、价格区间等等
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
 * @date 2014-5-28
 * 
 * @version 1.0.1
 */
@Controller
public class GroupSearchAction {

	private static final Logger log = LoggerFactory.getLogger(GroupSearchAction.class);

	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreSearchService searchService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private GroupClassService classService;

	@SuppressWarnings("unused")
	@RequestMapping("/group/category/search.htm")
	public ModelAndView categorySearch(HttpServletRequest request, HttpServletResponse response,
			MyPage<StoreDocument> page, Long classId, Long areaId) {

		ModelAndView mv = new JModelAndView("o2o/store_category_list.html", configService.getSysConfig(), 1,
				request, response);

		Area city = (Area) request.getAttribute(LbsInterceptorAdapter.O2O_CITY);
		List<Area> subAreaList = areaService.getCacheByParentId(String.valueOf(city.getId()));
		mv.addObject("subAreaList", subAreaList);

		page.setPageSize(24);

		List<GroupClassBO> gcList = null;
		if (classId == null) {
			// 加载全部一级
			gcList = classService.findCacheRoot();
		} else {
			// 加载全部一级
			GroupClassBO selectGc = classService.findTreeCacheById(classId);
			mv.addObject("selectGc", selectGc);
			if (selectGc.getParentId() != null) {
				gcList = classService.findCahceByParent(selectGc.getParentId());
			} else {
				gcList = Lists.newArrayList(selectGc.getChilds());
				java.util.Collections.sort(gcList);
			}

		}
		mv.addObject("gcList", gcList);
		StoreSearchVO vo = new StoreSearchVO();
		vo.setCityId(city.getId());
		vo.setClassId(classId);
		vo.setAreaId(areaId);
//		vo.setStoreLon(114.02597366);
//		vo.setStoreLat(22.54605355);
//		vo.setDistance(10000);
//		page.setOrder("asc");
//		page.setOrderBy(StoreDocument.StoreOrderType.DISTANCE.name());

		StoreSearchResult result = searchService.search(vo, page);
		mv.addObject(
				"gotoPageFormHTML",
				CommUtil.showPageFormHtml(page.getCurrentPage(), page.getPages(), page.getPageSize(),
						page.getRowCount()));
		mv.addObject("page", page);
		mv.addObject("classId", classId);
		mv.addObject("areaId", areaId);
		mv.addObject("area", areaService.getCacheById(areaId));
		return mv;
	}

	@SuppressWarnings("unused")
	@RequestMapping("/group/keyword/search.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,
			MyPage<StoreDocument> page, @RequestParam("keyword") String keyword) {
		ModelAndView mv = new JModelAndView("o2o/store_keyword_list.html", configService.getSysConfig(), 1,
				request, response);

		Area city = (Area) request.getAttribute(LbsInterceptorAdapter.O2O_CITY);

		page.setPageSize(24);

		try {
			response.addCookie(searchHistoryCookie(request, keyword));
		} catch (UnsupportedEncodingException e) {
			log.error("", e);
		}

		StoreSearchVO vo = new StoreSearchVO();
		vo.setCityId(city.getId());
		vo.setKeyword(keyword);

		StoreSearchResult result = searchService.search(vo, page);
		mv.addObject(
				"gotoPageFormHTML",
				CommUtil.showPageFormHtml(page.getCurrentPage(), page.getPages(), page.getPageSize(),
						page.getRowCount()));
		mv.addObject("page", page);
		mv.addObject("keyword", keyword);

		return mv;
	}

	/**
	 * 得到一个存有搜索数据的Cookie
	 * 
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public Cookie searchHistoryCookie(HttpServletRequest request, String keyword)
			throws UnsupportedEncodingException {
		String str = "";
		Cookie[] cookies = request.getCookies();
		Cookie search_cookie = null;
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("search_o2o_history")) {
				String str_temp = URLDecoder.decode(cookie.getValue(), "UTF-8");
				for (String s : str_temp.split(",")) {
					if (!s.equals(keyword) && !str.equals("")) {
						str = str + "," + s;
					} else if (!s.equals(keyword)) {
						str = s;
					}
				}
				break;
			};
		}
		if (str.equals("")) {
			str = keyword;
			str = URLEncoder.encode(str, "UTF-8");
			search_cookie = new Cookie("search_o2o_history", str);
		} else {
			str = keyword + "," + str;
			str = URLEncoder.encode(str, "UTF-8");
			search_cookie = new Cookie("search_o2o_history", str);
		}
		search_cookie.setDomain(CommUtil.generic_domain(request));
		search_cookie.setPath("/");
		return search_cookie;
	}

}
