package vc.thinker.b2b2c.action.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupFloorBO;
import com.sinco.carnation.o2o.bo.GroupFloorContentBO;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupFloorContentService;
import com.sinco.carnation.o2o.service.GroupFloorService;
import com.sinco.carnation.o2o.vo.GroupFloorVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

/**
 * <p>
 * Title: GroupCaseMangageAction.java
 * </p>
 * 
 * <p>
 * Description: 团购楼层管理控制器，用来管理团购首页楼层等页面橱窗展示，团购首页橱窗展示位置在推荐商品通栏的tab页
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
 * @date 2015-9-10
 * @version 1.0.1
 */
@Controller
public class GroupFloorMangageAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private GroupFloorService groupFloorService;

	@Autowired
	private GroupClassService groupClassService;

	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private GroupFloorContentService groupFloorContentService;

	@Autowired
	private StoreService storeService;

	@SecurityMapping(title = "团购橱窗增加", value = "/admin/group_floor_add.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_add.html")
	public ModelAndView group_floor_add(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GroupFloorVO vo, MyPage<GoodsCaseBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_add.html", configService.getSysConfig(), 0, request,
				response);
		Page<GroupClassBO> p = new Page<GroupClassBO>();
		List<GroupClassBO> gcs = this.groupClassService.findParentIsNullPage(p);
		mv.addObject("gcs", gcs);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "团购橱窗保存", value = "/admin/group_floor_save.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_save.html")
	public ModelAndView group_case_save(HttpServletRequest request, HttpServletResponse response, String currentPage,
			String list_url, String add_url, GroupFloorVO groupFloorVO) {
		if (groupFloorVO != null) {
			if (groupFloorVO.getId() != null && groupFloorVO.getId() > 0) {
				this.groupFloorService.update(groupFloorVO);
			} else {
				groupFloorVO.setAddTime(new Date());
				this.groupFloorService.save(groupFloorVO);
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

	@SecurityMapping(title = "团购橱窗查询", value = "/admin/group_floor_selected_store.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_selected_store.html")
	public ModelAndView group_floor_selected_store(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String group_ids, String cityid) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_selected_store.html", configService.getSysConfig(), 0,
				request, response);
		if (group_ids != null && !group_ids.equals("")) {
			List<StoreBO> groupGoodsList = new ArrayList<StoreBO>();
			String ids[] = group_ids.split(",");
			for (String storeid : ids) {
					if(storeid!=null&&!storeid.equals("")){
					StoreBO storeBO = this.storeService.getObjById(CommUtil.null2Long(storeid));
					groupGoodsList.add(storeBO);
					}
			}
			mv.addObject("goods_list", groupGoodsList);
		} else if (id != null && !id.equals("")) {
			List<StoreBO> storeList = new ArrayList<StoreBO>();
			List<GroupFloorContentBO> groupFloorContentList = groupFloorContentService
					.queryGroupCaseContentlistByFloorIdAndCityId(CommUtil.null2Long(id), CommUtil.null2Long(cityid));
			if (groupFloorContentList != null && groupFloorContentList.size() > 0) {
				for (GroupFloorContentBO obj : groupFloorContentList) {
					StoreBO storeBO = this.storeService.getObjById(CommUtil.null2Long(obj.getStoreId()));
					storeList.add(storeBO);
				}
			}
			mv.addObject("goods_list", storeList);
		}

		return mv;
	}

	@SecurityMapping(title = "团购橱窗查询", value = "/admin/group_floor_list.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_list.html")
	public ModelAndView group_floor_list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GroupFloorVO vo, MyPage<GroupFloorVO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_list.html", configService.getSysConfig(), 0,
				request, response);

		this.groupFloorService.findPageByVO(vo, page);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "商品分类异步加载", value = "/admin/group_floor_store_gc.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_goods_gc.htm")
	public ModelAndView group_case_goods_gc(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_store_gc.html", configService.getSysConfig(), 0,
				request, response);
		// List<GoodsClassBO> gcs = this.groupClassService.findLevelAll(true);
		// mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "团购橱窗服务增加", value = "/admin/group_floor_store_list.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_store_list.html")
	public ModelAndView group_floor_store_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id, String group_ids) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_store_list.html", configService.getSysConfig(), 0,
				request, response);
		if (group_ids != null && !group_ids.equals("")) {
			List<GroupFloorBO> groupGoodsList = new ArrayList<GroupFloorBO>();
			String ids[] = group_ids.split(",");
			for (String gid : ids) {
				if (!gid.equals("")) {
					GroupFloorBO obj = this.groupFloorService.getObjById(CommUtil.null2Long(gid));
					groupGoodsList.add(obj);
				}
			}
			mv.addObject("goods_list", groupGoodsList);
		} else if (id != null && !id.equals("")) {
//			List<StoreBO> storeList = new ArrayList<StoreBO>();
//			List<GroupFloorContentBO> groupFloorContentList = groupFloorContentService
//					.groupCaseGoodsList(CommUtil.null2Long(id));
//			if (groupFloorContentList != null && groupFloorContentList.size() > 0) {
//				for (GroupFloorContentBO obj : groupFloorContentList) {
//					StoreBO storeBO = this.storeService.getStoreBOById(CommUtil.null2Long(obj.getStoreId()));
//					storeList.add(storeBO);
//				}
//			}
//			mv.addObject("goods_list", storeList);
		}

		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areaService.getAllParentIsNull());

		if (areas.size() > 0) {
			Long parentId = areas.get(0).getId();
			mv.addObject("citys", areaService.getCacheByParentId(parentId.toString()));
		}

		Page<GroupClassBO> page = new Page<GroupClassBO>();
		List<GroupClassBO> gcs = this.groupClassService.findParentIsNullPage(page);
		GroupClass parent = this.groupClassService.getObjById(CommUtil.null2Long(-1l));
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

	@SecurityMapping(title = "商品加载", value = "/admin/group_floor_store_load.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_store_load.html")
	public ModelAndView group_floor_store_load(HttpServletRequest request, HttpServletResponse response,
			String currentPage, StoreVO vo, MyPage<StoreBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_store_load.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(7);
		vo.setIsO2o(true);
		this.storeService.findPageByVo(page, vo);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/admin/group_floor_store_load.html", "",
				"&groupMainId=" + (vo.getGroupMainId()==null?"":vo.getGroupMainId()) + "&areaId=" + (vo.getAreaId()==null?"":vo.getAreaId()) + "&storeName=" + (vo.getStoreName()==null?"":vo.getStoreName()), page, mv);
		// }
		return mv;
	}

	@RequestMapping("/admin/group_floor_city_select.html")
	public ModelAndView selectCity(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_city_select.html", configService.getSysConfig(), 0,
				request, response);
		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areaService.getAllParentIsNull());

		if (areas.size() > 0) {
			Long parentId = areas.get(0).getId();
			mv.addObject("citys", areaService.getCacheByParentId(parentId.toString()));
		}

		return mv;
	}

	@SecurityMapping(title = "团购商品分类异步加载", value = "/admin/group_floor_gc.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_gc.html")
	public ModelAndView goods_case_gc(HttpServletRequest request, HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_gc.html", configService.getSysConfig(), 0, request,
				response);
		List<GroupClassBO> gcs = this.groupClassService.findAllParents();
		mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "橱窗编辑", value = "/admin/group_floor_edit.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_edit.htm")
	public ModelAndView group_floor_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_floor_add.html", configService.getSysConfig(), 0, request,
				response);
		if (id != null && !id.equals("")) {
			GroupFloorBO groupFloorBO = this.groupFloorService.getObjById(Long.parseLong(id));
			List<GroupFloorContentBO> groupCaseContentBOList = groupFloorContentService
					.groupCaseGoodsList(Long.parseLong(id));
			if (groupCaseContentBOList != null && groupCaseContentBOList.size() > 0)
				mv.addObject("count", groupCaseContentBOList.size());
			mv.addObject("obj", groupFloorBO);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
			
			Page<GroupClassBO> p = new Page<GroupClassBO>();
			List<GroupClassBO> gcs = this.groupClassService.findParentIsNullPage(p);
			mv.addObject("gcs", gcs);			
			
		}
		return mv;
	}

	@SecurityMapping(title = "橱窗删除", value = "/admin/group_floor_del.html", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_del.html")
	public String group_floor_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				this.groupFloorService.delete(Long.parseLong(id));
			}
		}
		return "redirect:group_floor_list.html?currentPage=1";
	}

	@SecurityMapping(title = "橱窗Ajax更新", value = "/admin/group_floor_ajax_update_display.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_ajax_update_display.htm")
	public void group_floor_ajax_update_display(HttpServletRequest request,
			HttpServletResponse response, String id,
			String value) throws ClassNotFoundException {
		this.groupFloorService.updateDisplay(Long.parseLong(id),value);
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
	
	@SecurityMapping(title = "橱窗Ajax更新", value = "/admin/group_floor_ajax_update_seq.htm*", rtype = "admin", rname = "服务楼层", rcode = "group_floor", rgroup = "商户管理")
	@RequestMapping("/admin/group_floor_ajax_update_seq.htm")
	public void group_floor_ajax_update_seq(HttpServletRequest request,
			HttpServletResponse response, String id,
			String value) throws ClassNotFoundException {
		this.groupFloorService.updateSequnce(Long.parseLong(id),Integer.parseInt(value));
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
