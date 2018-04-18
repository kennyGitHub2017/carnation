package vc.thinker.b2b2c.action.seller;

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

import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreAdjustInfo;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.service.StoreAdjustInfoService;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreAdjustInfoVO;
import com.sinco.carnation.sys.service.SysConfigService;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: StoreAdjustApplyAction.java
 * </p>
 * 
 * <p>
 * Description: 商家店铺相关调整申请控制器
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
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class StoreAdjustApplyAction {
	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreService storeService;
//	@Autowired
//	private IUserConfigService  userConfigService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private GoodsClassService goodsclassService;
//	@Autowired
//	private IUserService userService;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private StoreAdjustInfoService adjustInfoService;

	@SecurityMapping(title = "调整类目申请", value = "/seller/adjust_goodsclass.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_goodsclass.htm")
	public ModelAndView adjust_goodsclass(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = null;
		// 获取商户的商铺
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		StoreGrade storeGrade = storeGradeService.getObjById(store.getGradeId());
		StoreAdjustInfoVO vo = new StoreAdjustInfoVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreAdjustInfo> infos = adjustInfoService.findListByVo(vo);
		if (infos.size() == 0) {
			mv = new JModelAndView("user/default/sellercenter/adjust_goodsclass.html",
					configService.getSysConfig(), 0, request, response);
			List<StoreGrade> grades = this.storeGradeService.findAllList();
//			List<StoreGrade> grades = this.storeGradeService
//					.query("select obj from StoreGrade obj order by obj.sequence asc",
//							null, -1, -1);
			mv.addObject("grades", grades);
			List<GoodsClassBO> gcs = this.goodsclassService.findParnetIsNull();
			for (GoodsClassBO gcbo : gcs) {
				gcbo.setChilds(goodsclassService.findByParent(gcbo.getId()));
			}
//					.query("select obj from GoodsClass obj where obj.parent.id is null ",
//							null, -1, -1);
			mv.addObject("goodsClass", gcs);
			mv.addObject("store", store);
			mv.addObject("storeGrade", storeGrade);
			if (store.getGcDetailInfo() != null) {// 店铺详细类目
				Set<GoodsClass> detail_gcs = this.storeTools.query_store_DetailGc(store.getGcDetailInfo());
				mv.addObject("detail_gcs", detail_gcs);
			}
			GoodsClass main_gc = this.goodsClassService.getObjById(store.getGcMainId());// 店铺主营类目
			mv.addObject("main_gc", main_gc);
			return mv;
		} else {
			StoreAdjustInfo adjustInfo = infos.get(0);
			mv = new JModelAndView("user/default/sellercenter/adjust_info.html",
					configService.getSysConfig(), 0, request, response);
			if (adjustInfo.getApplyStatus() == 0) {
				mv.addObject("title", "我们正在处理您提交的申请...");
			}
			if (adjustInfo.getApplyStatus() == 5) {
				mv.addObject("title", "您提交的调整申请已经被拒绝！");
				mv.addObject("again", true);
			}
		}
		return mv;
	}

	@SecurityMapping(title = "重新提交申请", value = "/seller/adjust_again.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_again.htm")
	public String adjust_again(HttpServletRequest request, HttpServletResponse response) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreAdjustInfoVO vo = new StoreAdjustInfoVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreAdjustInfo> infos = adjustInfoService.findListByVo(vo);
		adjustInfoService.deletes(infos);
		return "redirect:adjust_goodsclass.htm";
	}

	@SecurityMapping(title = "新增经营类目", value = "/seller/add_gc_detail.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/add_gc_detail.htm")
	public void add_gc_detail(HttpServletRequest request, HttpServletResponse response, String grade_id,
			String gc_main_id) {
		String jsonList = "";
		StoreGrade storeGrade = this.storeGradeService.getObjById(CommUtil.null2Long(grade_id));
		if (storeGrade != null && storeGrade.getMainLimit() == 1) {// 限制
			GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(gc_main_id));
			List<GoodsClassBO> goodChilds = goodsclassService.findByParent(gc.getId());
			List<Map> list = new ArrayList<Map>();
			for (GoodsClassBO child : goodChilds) {
				Map map = new HashMap();
				map.put("id", child.getId());
				map.put("name", child.getClassName());
				list.add(map);
			}
			jsonList = Json.toJson(list, JsonFormat.compact());
		}
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

	@SecurityMapping(title = "保存类目", value = "/seller/adjust_gc_save.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_gc_save.htm")
	public void adjust_gc_save(HttpServletRequest request, HttpServletResponse response, String ids,
			String gc_detail_info) {
		Map mapJson = null;// 用于转换成店铺中的详细经营类目json
		String[] idsStr = ids.split(",");
		String listJson = "";
		for (String id : idsStr) {
			GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(id));
			if (gc != null) {

				GoodsClass parent = goodsclassService.getObjById(CommUtil.null2Long(gc.getParentId()));
				if (gc_detail_info != null && !gc_detail_info.equals("")) {
					mapJson = Json.fromJson(HashMap.class, gc_detail_info);
					Map map = new HashMap();
					map.put("gc_id", id);
					map.put("gc_name", gc.getClassName());
					map.put("parent_name", parent.getClassName());
					map.put("parent_id", parent.getId());
					mapJson.put(id, map);
				} else {
					mapJson = new HashMap();
					Map map = new HashMap();
					map.put("gc_id", id);
					map.put("gc_name", gc.getClassName());
					map.put("parent_name", parent.getClassName());
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

	@SecurityMapping(title = "删除类目", value = "/seller/adjust_gc_del.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_gc_del.htm")
	public void adjust_gc_del(HttpServletRequest request, HttpServletResponse response, String id,
			String gc_detail_info) {
		GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(id));
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

	@SecurityMapping(title = "调整类目申请保存", value = "/seller/adjust_apply_save.htm*", rtype = "seller", rname = "经营类目调整", rcode = "adjust_seller", rgroup = "我的店铺")
	@RequestMapping("/seller/adjust_apply_save.htm")
	public ModelAndView adjust_apply_save(HttpServletRequest request, HttpServletResponse response,
			String gc_main, String gc_detail_info, String store_grade) {

		ModelAndView mv = null;
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = new Store();
		if (userDetails != null) {
			if (userDetails.getStoreId() != null) {
				store = storeService.getObjById(userDetails.getStoreId());
			}
		}
		StoreAdjustInfoVO vo = new StoreAdjustInfoVO();
		vo.setStoreId(userDetails.getStoreId());
		List<StoreAdjustInfo> infos = adjustInfoService.findListByVo(vo);
		if (infos.size() == 0) {
			mv = new JModelAndView("user/default/sellercenter/adjust_info.html",
					configService.getSysConfig(), 0, request, response);
			StoreAdjustInfo storeAdjustInfo = new StoreAdjustInfo();
			storeAdjustInfo.setAddTime(new Date());
			storeAdjustInfo.setStoreId(store.getId());
			storeAdjustInfo.setStoreName(store.getStoreName());
			storeAdjustInfo.setAdjustType("gc");
			storeAdjustInfo.setApplyStatus(0);
			storeAdjustInfo.setAdjustGcInfo(Json.toJson(gc_detail_info, JsonFormat.compact()));
			GoodsClass gc = this.goodsclassService.getObjById(CommUtil.null2Long(gc_main));
			storeAdjustInfo.setAdjustGcMain(gc.getClassName());
			storeAdjustInfo.setAdjustGcMainId(CommUtil.null2Long(gc_main));
			StoreGrade sg = this.storeGradeService.getObjById(CommUtil.null2Long(store_grade));
			storeAdjustInfo.setAdjustStoreGrade(sg.getGradeName());
			storeAdjustInfo.setAdjustStoreGradeId(CommUtil.null2Long(store_grade));
			this.adjustInfoService.save(storeAdjustInfo);
			mv.addObject("title", "申请成功，我们会尽快为您处理...");
			return mv;
		} else {
			mv = new JModelAndView("user/default/sellercenter/adjust_info.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("title", "我们正在处理您提交的申请...");
		}
		return mv;
	}
}
