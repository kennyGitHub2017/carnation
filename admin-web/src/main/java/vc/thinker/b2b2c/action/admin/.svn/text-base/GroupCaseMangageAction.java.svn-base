package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.bo.GroupCaseContentBO;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.model.GroupCase;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupCaseContentService;
import com.sinco.carnation.o2o.service.GroupCaseService;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.vo.GroupCaseVO;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import freemarker.core.ParseException;

/**
 * <p>
 * Title: GroupCaseMangageAction.java
 * </p>
 * 
 * <p>
 * Description: 团购橱窗管理控制器，用来管理团购首页等页面橱窗展示，团购首页橱窗展示位置在推荐商品通栏的tab页
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
 * @author t2w
 * @date 2015-9-8
 * @version 1.0.1
 */
@Controller
public class GroupCaseMangageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private GroupCaseService groupCaseService;

	@Autowired
	private GroupGoodsService groupGoodsService;

	@Autowired
	private GroupCaseContentService groupCaseContentService;

	@Autowired
	private GroupClassService groupClassService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private GroupClassService groupclassService;

	@SecurityMapping(title = "团购橱窗增加", value = "/admin/group_case_add.htm*", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_add.html")
	public ModelAndView group_case_add(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GoodsCaseVO vo, MyPage<GoodsCaseBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_add.html", configService.getSysConfig(), 0, request,
				response);
		mv.addObject("currentPage", currentPage);
		return mv;
	}
	

	@SecurityMapping(title = "团购橱窗保存", value = "/admin/group_case_save.htm*", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_save.html")
	public ModelAndView group_case_save(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String list_url, String add_url, GroupCaseVO groupCaseVO)
					throws IllegalAccessException, InvocationTargetException {
		if (groupCaseVO != null) {
			if (groupCaseVO.getId() != null && groupCaseVO.getId() > 0) {
				this.groupCaseService.update(groupCaseVO);
			} else {
				groupCaseVO.setAddTime(new Date());
				this.groupCaseService.save(groupCaseVO);
			}
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
				response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存橱窗成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "团购橱窗商品查询", value = "/admin/group_case_selected_goods.html", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_selected_goods.html")
	public ModelAndView group_case_selected_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String group_ids, String cityid) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_selected_goods.html", configService.getSysConfig(), 0,
				request, response);
		if (group_ids != null) {
			List<GroupGoodsBO> groupGoodsList = new ArrayList<GroupGoodsBO>();
			String ids[] = group_ids.split(",");
			for (String gid : ids) {
					if(gid!=null&&!gid.equals("")){
					GroupGoodsBO obj = this.groupGoodsService.getObjById(CommUtil.null2Long(gid));
					groupGoodsList.add(obj);
					}
			}
			mv.addObject("goods_list", groupGoodsList);
		} else if (id != null && !id.equals("")) {
			List<GroupGoodsBO> groupGoodsList = new ArrayList<GroupGoodsBO>();
			List<GroupCaseContentBO> groupCaseContentList = groupCaseContentService
					.groupCaseGoodsListByCaseIdAndCityId(CommUtil.null2Long(id),CommUtil.null2Long(cityid));
			if (groupCaseContentList != null && groupCaseContentList.size() > 0) {
				for (GroupCaseContentBO obj : groupCaseContentList) {
					GroupGoodsBO groupGoodsBO = this.groupGoodsService.getObjById(CommUtil.null2Long(obj.getGoodsId()));
					groupGoodsList.add(groupGoodsBO);
				}
			}
			mv.addObject("goods_list", groupGoodsList);
		}

		return mv;
	}
	
	
	@SecurityMapping(title = "团购橱窗查询", value = "/admin/group_case_list.html", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_list.html")
	public ModelAndView group_case_list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GroupCaseVO vo, MyPage<GroupCaseBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_list.html", configService.getSysConfig(), 0, request,
				response);

		this.groupCaseService.findPageByVO(vo, page);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "商品分类异步加载", value = "/admin/group_case_goods_gc.htm*", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_goods_gc.htm")
	public ModelAndView group_case_goods_gc(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_goods_gc.html", configService.getSysConfig(), 0,
				request, response);
		// List<GoodsClassBO> gcs = this.groupClassService.findLevelAll(true);
		// mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "团购橱窗服务增加", value = "/admin/group_case_goods_list.html", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_goods_list.html")
	public ModelAndView group_case_goods_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String group_ids) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_goods_list.html", configService.getSysConfig(), 0,
				request, response);
		if (group_ids != null && !group_ids.equals("")) {
			List<GroupGoodsBO> groupGoodsList = new ArrayList<GroupGoodsBO>();
			String ids[] = group_ids.split(",");
			for (String gid : ids) {
				if (!gid.equals("")) {
					GroupGoodsBO obj = this.groupGoodsService.getObjById(CommUtil.null2Long(gid));
					groupGoodsList.add(obj);
				}
			}
			mv.addObject("goods_list", groupGoodsList);
		} else if (id != null && !id.equals("")) {
			List<GroupGoodsBO> groupGoodsList = new ArrayList<GroupGoodsBO>();
			List<GroupCaseContentBO> groupCaseContentList = groupCaseContentService
					.groupCaseGoodsList(CommUtil.null2Long(id));
			if (groupCaseContentList != null && groupCaseContentList.size() > 0) {
				for (GroupCaseContentBO obj : groupCaseContentList) {
					GroupGoodsBO groupGoodsBO = this.groupGoodsService.getObjById(CommUtil.null2Long(obj.getGoodsId()));
					groupGoodsList.add(groupGoodsBO);
				}
			}
			mv.addObject("goods_list", groupGoodsList);
		}

		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areaService.getAllParentIsNull());

		if (areas.size() > 0) {
			Long parentId = areas.get(0).getId();
			mv.addObject("citys", areaService.getCacheByParentId(parentId.toString()));
		}

		List<GroupClassBO> gcs = this.groupclassService.findCacheLevelAll();
		GroupClass parent = this.groupclassService.getObjById(CommUtil.null2Long(-1l));
		GroupClass obj = new GroupClass();
		obj.setDisplay(true);
		if (null != parent) {
			obj.setParentId(parent.getId());
		}
		mv.addObject("obj", obj);
		mv.addObject("gcs", gcs);
		mv.addObject("id", id);
		mv.addObject("goods_ids", group_ids);

		return mv;
	}


	@SecurityMapping(title = "商品加载", value = "/admin/group_case_goods_load.html", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_goods_load.html")
	public ModelAndView group_case_goods_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupGoodsVO vo, MyPage<GroupGoodsBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_goods_load.html", configService.getSysConfig(), 0,
				request, response);
		Set<Long> groupClassIds = new HashSet<Long>();
		if(vo.getGgGcId()!=null)
		{
			List<GroupClassBO> childs = groupClassService.findChildList(vo.getGgGcId());
			
			groupClassIds.add(vo.getGgGcId());
			for(GroupClassBO child :childs)
			{
				groupClassIds.add(child.getId());
			}
			vo.setGroupClassIds(groupClassIds);
			vo.setGgGcId(null);
		}	
		
		page.setPageSize(7);
		this.groupGoodsService.findListByVO(page, vo);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/admin/group_case_goods_load.html", "",
				"&ggGcId=" + (vo.getGgGcId()==null?"":vo.getGgGcId()) + "&ggGaId=" + (vo.getGgGaId()==null?"":vo.getGgGaId()) + "&ggName=" + (vo.getGgName()==null?"":vo.getGgName()), page, mv);
		// }
		return mv;
	}

	@RequestMapping("/admin/group_case_city_select.html")
	public ModelAndView selectCity(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_city_select.html", configService.getSysConfig(), 0,
				request, response);
		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areaService.getAllParentIsNull());

		if (areas.size() > 0) {
			Long parentId = areas.get(0).getId();
			mv.addObject("citys", areaService.getCacheByParentId(parentId.toString()));
		}

		return mv;
	}

	@SecurityMapping(title = "团购商品分类异步加载", value = "/admin/group_case_gc.html", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_gc.html")
	public ModelAndView goods_case_gc(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_gc.html", configService.getSysConfig(), 0, request,
				response);
		List<GroupClassBO> gcs = this.groupClassService.findAllParents();
		mv.addObject("gcs", gcs);
		return mv;
	}

	/**
	 * groupcase编辑管理
	 *
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "橱窗编辑", value = "/admin/group_case_edit.htm*", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_edit.htm")
	public ModelAndView group_case_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_case_add.html", configService.getSysConfig(), 0, request,
				response);
		if (id != null && !id.equals("")) {
			GroupCase groupcase = this.groupCaseService.getObjById(Long.parseLong(id));
			List<GroupCaseContentBO> groupCaseContentBOList = groupCaseContentService
					.groupCaseGoodsList(Long.parseLong(id));
			if (groupCaseContentBOList != null && groupCaseContentBOList.size() > 0)
				mv.addObject("count", groupCaseContentBOList.size());
			mv.addObject("obj", groupcase);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
		}
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "橱窗删除", value = "/admin/group_case_del.htm*", rtype = "admin", rname = "服务橱窗", rcode = "group_case", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_del.htm")
	public String group_case_del(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				GroupCase groupCase = this.groupCaseService.getObjById(Long
						.parseLong(id));
				this.groupCaseService.delete(Long.parseLong(id));
			}
		}
		return "redirect:group_case_list.html?currentPage=1";
		}	


	@SecurityMapping(title = "橱窗Ajax更新", value = "/admin/group_case_ajax_update_display.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_ajax_update_display.htm")
	public void group_case_ajax_update_display(HttpServletRequest request,
			HttpServletResponse response, String id,
			String value) throws ClassNotFoundException {
		this.groupCaseService.updateDisplay(Long.parseLong(id),Integer.parseInt(value));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(value.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	@SecurityMapping(title = "橱窗Ajax更新", value = "/admin/group_case_ajax_update_seq.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_case_ajax_update_seq.htm")
	public void group_case_ajax_update_seq(HttpServletRequest request,
			HttpServletResponse response, String id,
			String value) throws ClassNotFoundException {
		this.groupCaseService.updateSequnce(Long.parseLong(id),Integer.parseInt(value));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(value.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}		
	
}
