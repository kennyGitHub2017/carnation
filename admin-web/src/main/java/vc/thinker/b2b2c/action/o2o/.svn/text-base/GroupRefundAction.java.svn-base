package vc.thinker.b2b2c.action.o2o;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupInfoBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupInfoVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: RefundManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台向买家进行退款，退款统一给买家发放预存款，买家通过预存款兑换现金
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
 * @date 2014年5月14日
 * 
 * @version 1.0.1
 */
@Controller
public class GroupRefundAction {
	@Autowired
	GroupOrderService groupOrderService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private GroupInfoService groupInfoService;

	@SecurityMapping(title = "服务退款审核列表", value = "/group/refund/applyList.htm*", rtype = "admin", rname = "服务退款", rcode = "refund_applyList", rgroup = "商户管理")
	@RequestMapping("/group/refund/applyList.htm")
	public ModelAndView applyList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupInfoVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/applyList.html", configService.getSysConfig(), 0,
				request, response);
		MyPage<GroupInfoBO> page = new MyPage<>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		groupInfoService.selectByApply(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "服务退款审核操作", value = "/group/refund/applyIng.htm*", rtype = "admin", rname = "服务退款", rcode = "refund_applyIng", rgroup = "商户管理")
	@RequestMapping("/group/refund/applyIng.htm")
	public String applyIng(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GroupInfoVO vo ) {
		Long uid = SecurityUserHolder.getCurrentUserId();
		String reason = vo .getReason();
		groupInfoService.updateGroupRefund(vo,reason, uid);
		return "redirect:/group/refund/applyList.htm";
	}

	@SecurityMapping(title = "服务退款列表", value = "/group/refund/refundList.htm*", rtype = "admin", rname = "服务退款", rcode = "refund_refundList", rgroup = "商户管理")
	@RequestMapping("/group/refund/refundList.htm")
	public ModelAndView refundList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupInfoVO vo, String tabName) {
		ModelAndView mv = new JModelAndView("admin/blue/refundList.html", configService.getSysConfig(), 0,
				request, response);
		if (vo.getStatus() == null)
			vo.setStatus(57);
		if (vo.getStatus() != null && vo.getStatus() == 7 && "history".equals(tabName))
			mv = new JModelAndView("admin/blue/refundListHistory.html", configService.getSysConfig(), 0,
					request, response);
		MyPage<GroupInfoBO> page = new MyPage<>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		groupInfoService.selectByRefund(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "服务退款操作", value = "/group/refund/refundIng.htm*", rtype = "admin", rname = "服务退款", rcode = "refund_refundIng", rgroup = "商户管理")
	@RequestMapping("/group/refund/refundIng.htm")
	public String refundIng(HttpServletRequest request, HttpServletResponse response, String currentPage,
			GroupInfoVO vo) {
		groupInfoService.refundIng(vo, SecurityUserHolder.getCurrentUserId());

		return "redirect:/group/refund/refundList.htm?status=5";
	}

	@SecurityMapping(title = "线下刷卡服务退款列表", value = "/admin/offline_group_order_refund_list.htm*", rtype = "admin", rname = "线下刷卡服务退款管理", rcode = "admin_offline_refund_order", rgroup = "商户管理")
	@RequestMapping("/admin/offline_group_order_refund_list.htm")
	public ModelAndView offline_group_order_refund_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/offline_group_order_refund_list.html",
				configService.getSysConfig(), 0, request, response);
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		groupOrderService.offLine(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}
}
