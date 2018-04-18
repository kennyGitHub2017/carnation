package vc.thinker.b2b2c.action.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.StoreGroupAdjustBO;
import com.sinco.carnation.o2o.model.StoreGroupAdjust;
import com.sinco.carnation.o2o.vo.StoreGroupAdjustVO;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreGroupAdjustService;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: MerchantAdjustInfoManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台处理商户调整申请的控制器
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
 * @date 2015-9-11
 * 
 */
@Controller
public class MerchantAdjustInfoManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreGroupAdjustService storeGroupAdjustService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private StoreSearchService searchService;

	/**
	 * 申请列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商户申请列表", value = "/admin/merchant_adjust_info_list.htm*", rtype = "admin", rname = "商户调整申请", rcode = "merchant_adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_adjust_info_list.htm")
	public ModelAndView adjust_info(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreGroupAdjustBO> page, StoreGroupAdjustVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_adjust_info_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		this.storeGroupAdjustService.findPageByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "商户申请审核", value = "/admin/merchant_adjust_info_view.htm*", rtype = "admin", rname = "商户调整申请", rcode = "merchant_adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_adjust_info_view.htm")
	public ModelAndView adjust_info_view(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_adjust_info_view.html",
				configService.getSysConfig(), 0, request, response);
		StoreGroupAdjust storeGroupAdjust = this.storeGroupAdjustService.getObjById(CommUtil.null2Long(id));
		mv.addObject("adjustInfo", storeGroupAdjust);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "商户审核保存", value = "/admin/merchant_adjust_info_audit.htm*", rtype = "admin", rname = "商户调整申请", rcode = "merchant_adjust_manage", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_adjust_info_audit.htm")
	public ModelAndView merchant_adjust_info_audit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String type, String refusedDesc) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		StoreGroupAdjust storeGroupAdjust = this.storeGroupAdjustService.getObjById(CommUtil.null2Long(id));
		try {
			storeGroupAdjust.setRefusedDesc(refusedDesc);
			this.storeGroupAdjustService.merchantAdjustInfoAudit(storeGroupAdjust, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 更新索引
		searchService.updateIndex(storeGroupAdjust.getStoreId());
		mv.addObject("op_title", "操作成功");
		mv.addObject("list_url", "/admin/merchant_adjust_info_list.htm?currentPage=" + currentPage);
		return mv;
	}

}