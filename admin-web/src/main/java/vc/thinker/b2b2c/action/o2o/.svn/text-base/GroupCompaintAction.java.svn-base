package vc.thinker.b2b2c.action.o2o;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupComplaintService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderLogService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupOrderManageAction.java
 * </p>
 * 
 * <p>
 * Description:后台服务订单管理器
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
 * @date 2015-9-8
 * 
 * @version 1.0.1
 */
@Controller
public class GroupCompaintAction {
	@Autowired
	AreaServiceImpl areaService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupOrderLogService groupOrderLogService;
	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	GroupComplaintService groupComplaintService;

	/**
	 * 服务投诉列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @return
	 */
	@RequestMapping("/admin/group/compaintList.htm")
	public ModelAndView compaintList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupComplaintVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/compaintList.html", configService.getSysConfig(), 0,
				request, response);
		MyPage<GroupComplaintBO> page = new MyPage<GroupComplaintBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		if (vo.getStatus() == null)
			vo.setStatus(1);
		if (vo.getArea3() != null)
			vo.setAreaId(vo.getArea3());
		else if (vo.getArea2() != null)
			vo.setAreaId(vo.getArea2());
		groupComplaintService.search(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("vo", vo);
		List<Area> areas = areaService.getAllParentIsNull();
		mv.addObject("areas", areas);

		return mv;
	}

	/**
	 * 服务投诉详情
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/admin/group/complaintDetails.htm")
	public ModelAndView complaintDetails(HttpServletRequest request, HttpServletResponse response,
			String orderId) {
		ModelAndView mv = new JModelAndView("admin/blue/complaintDetails.html", configService.getSysConfig(),
				0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(orderId));
		if (obj != null) {
			String url = configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}
			CommUtil.saveIPageList2ModelAndView(url + "/admin/group/compaintList.htm", "", "", null, mv);
			mv.addObject("infos", obj.getGroupInfoBOList());
			mv.addObject("order", obj);
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/admin/group/compaintList.htm");
		}

		return mv;
	}

	/**
	 * 投诉图片
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/admin/group/complaintDetails_img.htm")
	public ModelAndView complaintDetails_img(HttpServletRequest request, HttpServletResponse response,
			Long orderId) {
		ModelAndView mv = new JModelAndView("admin/blue/complaintDetails_img.htm",
				configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(orderId);
		mv.addObject("order", obj);

		return mv;
	}

	/**
	 * 处理服务投诉
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@RequestMapping("/admin/group/complaint_handle_close.htm")
	public ModelAndView complaint_handle_close(HttpServletRequest request, HttpServletResponse response,
			String id, String handle_content) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		Long uid = SecurityUserHolder.getCurrentUserId();
		GroupComplaintBO gc = new GroupComplaintBO();
		gc.setId(Long.parseLong(id));
		gc.setStatus(3);
		gc.setHandleUserId(uid);
		gc.setHandleContent(handle_content);
		gc.setHandleTime(new Date());
		groupComplaintService.update(gc);
		mv.addObject("op_title", "投诉处理成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/group/compaintList.htm");

		return mv;
	}
}
