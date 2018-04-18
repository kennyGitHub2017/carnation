package vc.thinker.b2b2c.action.admin;

import java.util.Date;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;
import com.sinco.carnation.activity.service.ActivityService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.sys.model.Navigation;
import com.sinco.carnation.sys.service.ArticleClassService;
import com.sinco.carnation.sys.service.NavigationService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: NavigationManageAction.java
 * </p>
 * <p>
 * Description:系统网站导航管理类
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@Controller
public class NavigationManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private NavigationService navigationService;
	@Autowired
	private ArticleClassService articleClassService;
//	@Autowired
//	private SubjectService subjectService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private ActivityService activityService;

	/**
	 * Navigation列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "页面导航列表", value = "/admin/navigation_list.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "系统管理")
	@RequestMapping("/admin/navigation_list.htm")
	public ModelAndView navigation_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String title) {
		ModelAndView mv = new JModelAndView("admin/blue/navigation_list.html", configService.getSysConfig(),
				0, request, response);
		String url = configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}

		MyPage<Map> page = new MyPage<Map>();
		page.setPageSize(16);
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		navigationService.selectByTitle(title, page);
		CommUtil.saveIPageList2ModelAndView(url + "/admin/navigation_list.htm", "", "", page, mv);
		mv.addObject("title", title);

		return mv;
	}

	/**
	 * navigation添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "页面导航添加", value = "/admin/navigation_add.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "系统管理")
	@RequestMapping("/admin/navigation_add.htm")
	public ModelAndView navigation_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/navigation_add.html", configService.getSysConfig(),
				0, request, response);
//		List<GoodsClass> gcs = this.goodsClassService.query(
//				"select obj from GoodsClass obj where obj.parent.id is null",
//				null, -1, -1);
//		List<ArticleClass> acs = this.articleClassService
//				.query("select obj from ArticleClass obj where obj.parent is null order by obj.sequence asc",
//						null, -1, -1);
//		List<Activity> activitys = this.activityService.query(
//				"select obj from Activity obj order by obj.addTime desc", null,
//				-1, -1);
//		Map map = new HashMap();
//		map.put("display", 1);
//		List<Subject> subjects = this.subjectService
//				.query("select obj from Subject obj where obj.display=:display order by obj.sequence asc",
//						map, -1, -1);
		Navigation obj = new Navigation();
		obj.setDisplay(true);
		obj.setType("diy");
		obj.setNewWin(1);
		obj.setLocation(0);
		mv.addObject("obj", obj);
		mv.addObject("currentPage", currentPage);
//		mv.addObject("gcs", gcs);
//		mv.addObject("acs", acs);
//		mv.addObject("activitys", activitys);
//		mv.addObject("subjects", subjects);
		return mv;
	}

	/**
	 * navigation编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "页面导航编辑", value = "/admin/navigation_edit.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "系统管理")
	@RequestMapping("/admin/navigation_edit.htm")
	public ModelAndView navigation_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/navigation_add.html", configService.getSysConfig(),
				0, request, response);
		if (id != null && !id.equals("")) {
			Navigation navigation = navigationService.getObjById(Long.parseLong(id));
//			List<GoodsClass> gcs = this.goodsClassService
//					.query("select obj from GoodsClass obj where obj.parent.id is null",
//							null, -1, -1);
//			List<ArticleClass> acs = this.articleClassService
//					.query("select obj from ArticleClass obj where obj.parent is null order by obj.sequence asc",
//							null, -1, -1);
//			List<Activity> activitys = this.activityService.query(
//					"select obj from Activity obj order by obj.addTime desc",
//					null, -1, -1);
//			Map map = new HashMap();
//			map.put("display", 1);
//			List<Subject> subjects = subjectService
//					.query("select obj from Subject obj where obj.display=:display order by obj.sequence asc",
//							map, -1, -1);
//			mv.addObject("subjects", subjects);
//			mv.addObject("gcs", gcs);
//			mv.addObject("acs", acs);
//			mv.addObject("activitys", activitys);
			mv.addObject("obj", navigation);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}

		return mv;
	}

	/**
	 * navigation保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "页面导航保存", value = "/admin/navigation_save.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "系统管理")
	@RequestMapping("/admin/navigation_save.htm")
	public ModelAndView navigation_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String list_url, String add_url, String goodsclass_id,
			String articleclass_id, String activity_id, String subject_id, Navigation nav) {
		WebForm wf = new WebForm();
		if (nav.getId() == null || nav.getId() == 0)
			nav.setAddTime(new Date());
		else {
			Navigation obj = navigationService.getObjById(Long.parseLong(id));
			nav = (Navigation) wf.toPo(request, obj);
		}
		nav.setSysNav(false);

		nav.setOriginalUrl(nav.getUrl());
		if (nav.getType().equals("goodsclass")) {
			nav.setTypeId(CommUtil.null2Long(goodsclass_id));
			nav.setUrl("store_goods_list_" + goodsclass_id + ".htm");
			nav.setOriginalUrl("store_goods_list.htm?gc_id=" + goodsclass_id);
		}
		if (nav.getType().equals("articleclass")) {
			nav.setTypeId(CommUtil.null2Long(articleclass_id));
			nav.setUrl("articlelist_help_" + articleclass_id + ".htm");
			nav.setOriginalUrl("articlelist.htm?param=" + articleclass_id);
		}
		if (nav.getType().equals("activity")) {
			nav.setTypeId(CommUtil.null2Long(activity_id));
			nav.setUrl("activity/index_" + activity_id + ".htm");
			nav.setOriginalUrl("activity.htm?id=" + activity_id);
		}
		if (nav.getType().equals("subject")) {
			nav.setTypeId(CommUtil.null2Long(subject_id));
			nav.setUrl("subject/view_" + subject_id + ".htm");
			nav.setOriginalUrl("subject/view.htm?id=" + subject_id);
		}
		if (id.equals("")) {
			navigationService.save(nav);
		} else
			navigationService.update(nav);
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存页面导航成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url + "?currentPage=" + currentPage);
		}

		return mv;
	}

	/**
	 * 页面导航删除
	 * 
	 * @param request
	 * @param mulitId
	 * @return
	 */
	@SecurityMapping(title = "页面导航删除", value = "/admin/navigation_del.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "系统管理")
	@RequestMapping("/admin/navigation_del.htm")
	public String navigation_del(HttpServletRequest request, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				navigationService.delete(Long.parseLong(id));
			}
		}

		return "redirect:navigation_list.htm";
	}

//	@SecurityMapping(title = "页面导航AJAX更新", value = "/admin/navigation_ajax.htm*", rtype = "admin", rname = "页面导航", rcode = "nav_manage", rgroup = "网站")
//	@RequestMapping("/admin/navigation_ajax.htm")
//	public void navigation_ajax(HttpServletRequest request,
//			HttpServletResponse response, String id, String fieldName,
//			String value) throws ClassNotFoundException {
//		Navigation obj = this.navigationService.getObjById(Long.parseLong(id));
//		Field[] fields = Navigation.class.getDeclaredFields();
//		BeanWrapper wrapper = new BeanWrapper(obj);
//		Object val = null;
//		for (Field field : fields) {
//			// System.out.println(field.getName());
//			if (field.getName().equals(fieldName)) {
//				Class clz = Class.forName("java.lang.String");
//				if (field.getType().getName().equals("int")) {
//					clz = Class.forName("java.lang.Integer");
//				}
//				if (field.getType().getName().equals("boolean")) {
//					clz = Class.forName("java.lang.Boolean");
//				}
//				if (!value.equals("")) {
//					val = BeanUtils.convertType(value, clz);
//				} else {
//					val = !CommUtil.null2Boolean(wrapper
//							.getPropertyValue(fieldName));
//				}
//				wrapper.setPropertyValue(fieldName, val);
//			}
//		}
//		this.navigationService.update(obj);
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(val.toString());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
}
