package vc.thinker.b2b2c.action.store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.store.bo.StoreAdjustInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.model.StoreAdjustInfo;
import com.sinco.carnation.store.service.StoreAdjustInfoService;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreAdjustInfoVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: StoreAdjustInfoManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台处理商家店铺调整申请的控制器
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
 * @date 2015-1-6
 * 
 */
@Controller
public class StoreAdjustInfoManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreAdjustInfoService storeadjustinfoService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreGradeService storeGradeService;

	/**
	 * 申请列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "申请列表", value = "/admin/adjust_info.htm*", rtype = "admin", rname = "调整申请", rcode = "adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/adjust_info.htm")
	public ModelAndView adjust_info(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreAdjustInfoBO> page, StoreAdjustInfoVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/adjust_info.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		this.storeadjustinfoService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "申请详情", value = "/admin/adjust_info_view.htm*", rtype = "admin", rname = "调整申请", rcode = "adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/adjust_info_view.htm")
	public ModelAndView adjust_info_view(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/adjust_info_view.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		StoreAdjustInfo storeAdjustInfo = this.storeadjustinfoService.getObjById(CommUtil.null2Long(id));
		mv.addObject("adjustInfo", storeAdjustInfo);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "申请审核", value = "/admin/adjust_info_audit.htm*", rtype = "admin", rname = "调整申请", rcode = "adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/adjust_info_audit.htm")
	public ModelAndView adjust_info_audit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String type) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(),
		/* this.userConfigService.getUserConfig(), */0, request, response);
		StoreAdjustInfo storeAdjustInfo = this.storeadjustinfoService.getObjById(CommUtil.null2Long(id));
		if ("succeed".equals(type)) {
			StoreBO store = this.storeService.getObjById(storeAdjustInfo.getStoreId());
			store.setGradeId(storeAdjustInfo.getAdjustStoreGradeId());
			store.setGcMainId(storeAdjustInfo.getAdjustGcMainId());
			store.setGcDetailInfo(this.getStoreGC_detail_info(storeAdjustInfo.getAdjustGcInfo()));
			this.storeService.update(store);
			this.storeadjustinfoService.delete(storeAdjustInfo.getId());

			mv.addObject("op_title", "操作成功");
		}
		if ("defeat".equals(type)) {
			storeAdjustInfo.setApplyStatus(5);
			this.storeadjustinfoService.update(storeAdjustInfo);
			mv.addObject("op_title", "操作成功");
		}
		mv.addObject("list_url", "/admin/adjust_info.htm?currentPage=" + currentPage);
		return mv;
	}

	/**
	 * 由调整申请中的类目信息，得到店铺详细经营类目信息
	 * 
	 * @param adjust_gc_info
	 * @return
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private String getStoreGC_detail_info(String adjust_gc_info) {
		Map fromMap = Json.fromJson(HashMap.class, adjust_gc_info);
		if (fromMap == null) {
			return null;
		}
		List<Map> toList = new ArrayList();
		Iterator<Map> it = fromMap.values().iterator();
		while (it.hasNext()) {
			Map map = it.next();
			int j = 0;
			for (; j < toList.size(); j++) {
				if (map.get("parent_id").equals(toList.get(j).get("m_id"))) {
					List gc_list = (List) toList.get(j).get("gc_list");
					gc_list.add(CommUtil.null2Int(map.get("gc_id")));
					Map toMap = new HashMap();
					toMap.put("m_id", map.get("parent_id"));
					toMap.put("gc_list", gc_list);
					toList.set(j, toMap);
					break;
				}
			}
			if (j == toList.size()) {
				List gc_list = new ArrayList();
				gc_list.add(CommUtil.null2Int(map.get("gc_id")));
				Map toMap = new HashMap();
				toMap.put("m_id", map.get("parent_id"));
				toMap.put("gc_list", gc_list);
				toList.add(toMap);
			}
		}
		return Json.toJson(toList, JsonFormat.compact());

	}

}