package vc.thinker.b2b2c.action.o2o;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.model.StoreGroupAdjust;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.vo.StoreGroupAdjustVO;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreGroupAdjustService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: StoreGroupAdjustApplyAction.java
 * </p>
 * 
 * <p>
 * Description: 商家店铺服务类目调整申请控制器
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
 * @date 2015-1-5
 * 
 */
@Controller
public class StoreGroupAdjustApplyAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreService storeService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private GroupClassService groupClassService;
	// @Autowired
	// private IUserService userService;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private StoreGroupAdjustService groupAdjustService;

	@Autowired
	private PayTools payTools;

	@SecurityMapping(title = "调整类目申请", value = "/seller/adjust_groupclass.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_groupclass.htm")
	public ModelAndView adjust_groupclass(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null;
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		StoreGroupAdjustVO vo = new StoreGroupAdjustVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreGroupAdjust> infos = groupAdjustService.findListByVo(vo);
		if (infos.size() == 0) {
			mv = new JModelAndView("user/default/sellercenter/adjust_groupclass.html",
					configService.getSysConfig(), 0, request, response);

			List<GroupClassBO> gcs = this.groupClassService.findAllParents();
			for (GroupClassBO gcbo : gcs) {
				gcbo.setChilds(groupClassService.findByParent(gcbo.getId()));
			}
			mv.addObject("groupClass", gcs);
			mv.addObject("store", store);
			if (store.getGroupDetailInfo() != null) {// 店铺服务详细类目
				Set<GroupClass> detail_gcs = this.storeTools.query_o2o_store_DetailGc(store
						.getGroupDetailInfo());
				mv.addObject("detail_gcs", detail_gcs);
			}
			GroupClass main_gc = this.groupClassService.getObjById(store.getGroupMainId());// 店铺服务主营类目
			mv.addObject("main_gc", main_gc);
			return mv;
		} else {
			StoreGroupAdjust adjust = infos.get(0);
			mv = new JModelAndView("user/default/sellercenter/adjust_group_info.html",
					configService.getSysConfig(), 0, request, response);
			if (adjust.getApplyStatus() == 0) {
				mv.addObject("title", "我们正在处理您提交的申请...");
			}
			if (adjust.getApplyStatus() == 5) {
				mv.addObject("refusedDesc", adjust.getRefusedDesc());// 拒绝原因说明
				mv.addObject("title", "您提交的调整申请已经被拒绝！");
				mv.addObject("again", true);
			}
		}
		return mv;
	}

	@SecurityMapping(title = "重新提交申请", value = "/seller/adjust_group_again.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_group_again.htm")
	public String adjust_group_again(HttpServletRequest request, HttpServletResponse response) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreGroupAdjustVO vo = new StoreGroupAdjustVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreGroupAdjust> infos = groupAdjustService.findListByVo(vo);
		groupAdjustService.deletes(infos);
		return "redirect:adjust_groupclass.htm";
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "新增服务经营类目", value = "/seller/add_group_detail.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/add_group_detail.htm")
	public void add_group_detail(HttpServletRequest request, HttpServletResponse response, String grade_id,
			String gc_main_id) {
		String jsonList = "";
		GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(gc_main_id));
		List<GroupClassBO> goodChilds = groupClassService.findByParent(gc.getId());
		List<Map> list = new ArrayList<Map>();
		for (GroupClassBO child : goodChilds) {
			Map map = new HashMap();
			map.put("id", child.getId());
			map.put("name", child.getGcName());
			list.add(map);
		}
		jsonList = Json.toJson(list, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(jsonList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/choose/choose_group_detail.htm")
	public void choose_group_detail(HttpServletRequest request, HttpServletResponse response, String grade_id,
			String gc_main_id) {
		String jsonList = "";
		GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(gc_main_id));
		List<GroupClassBO> goodChilds = groupClassService.findByParent(gc.getId());
		List<Map> list = new ArrayList<Map>();
		for (GroupClassBO child : goodChilds) {
			Map map = new HashMap();
			map.put("id", child.getId());
			map.put("name", child.getGcName());
			list.add(map);
		}
		Map<String, Object> maps = new HashMap<>();
		maps.put("data", list);
		maps.put("result", "1");
		maps.put("desc", "查询成功");
		jsonList = Json.toJson(maps, JsonFormat.compact());
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(jsonList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@SecurityMapping(title = "保存服务类目", value = "/seller/adjust_group_save.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_group_save.htm")
	public void adjust_group_save(HttpServletRequest request, HttpServletResponse response, String ids,
			String gc_detail_info) {
		Map mapJson = null;// 用于转换成店铺中的详细经营类目json
		String[] idsStr = ids.split(",");
		String listJson = "";
		for (String id : idsStr) {
			GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(id));
			if (gc != null) {
				GroupClass parent = groupClassService.getObjById(CommUtil.null2Long(gc.getParentId()));
				if (gc_detail_info != null && !gc_detail_info.equals("")) {
					mapJson = Json.fromJson(HashMap.class, gc_detail_info);
					Map map = new HashMap();
					map.put("gc_id", id);
					map.put("gc_name", gc.getGcName());
					map.put("parent_name", parent.getGcName());
					map.put("parent_id", parent.getId());
					mapJson.put(id, map);
				} else {
					mapJson = new HashMap();
					Map map = new HashMap();
					map.put("gc_id", id);
					map.put("gc_name", gc.getGcName());
					map.put("parent_name", parent.getGcName());
					map.put("parent_id", parent.getId());
					mapJson.put(id, map);
				}
				gc_detail_info = Json.toJson(mapJson, JsonFormat.compact());
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(gc_detail_info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "删除服务类目", value = "/seller/adjust_group_del.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_group_del.htm")
	public void adjust_group_del(HttpServletRequest request, HttpServletResponse response, String id,
			String gc_detail_info) {
		GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(id));
		if (gc_detail_info != null && !gc_detail_info.equals("") && gc != null) {
			Map mapJson = Json.fromJson(HashMap.class, gc_detail_info);
			mapJson.remove(id);
			gc_detail_info = Json.toJson(mapJson, JsonFormat.compact());
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(gc_detail_info);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "服务调整类目申请保存", value = "/seller/adjust_group_apply_save.htm*", rtype = "seller", rname = "服务类目调整", rcode = "group_adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_group_apply_save.htm")
	public ModelAndView adjust_group_apply_save(HttpServletRequest request, HttpServletResponse response,
			String gc_main, String gc_detail_info, String store_grade) {

		ModelAndView mv = null;
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		StoreGroupAdjustVO vo = new StoreGroupAdjustVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreGroupAdjust> infos = groupAdjustService.findListByVo(vo);
		if (infos.size() == 0) {
			mv = new JModelAndView("user/default/sellercenter/adjust_group_info.html",
					configService.getSysConfig(), 0, request, response);
			StoreGroupAdjust info = new StoreGroupAdjust();
			info.setAddTime(new Date());
			info.setStoreId(store.getId());
			info.setStoreName(store.getStoreName());
			info.setAdjustType("gc");
			info.setApplyStatus(0);
			info.setAdjustGcInfo(Json.toJson(gc_detail_info, JsonFormat.compact()));
			GroupClass gc = this.groupClassService.getObjById(CommUtil.null2Long(gc_main));
			info.setAdjustGcMain(gc.getGcName());
			info.setAdjustGcMainId(CommUtil.null2Long(gc_main));
			this.groupAdjustService.save(info);
			mv.addObject("title", "申请成功，我们会尽快为您处理...");
			return mv;
		} else {
			mv = new JModelAndView("user/default/sellercenter/adjust_group_info.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("title", "我们正在处理您提交的申请...");
		}
		return mv;
	}
}
