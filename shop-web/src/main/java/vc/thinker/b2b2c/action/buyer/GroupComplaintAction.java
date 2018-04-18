package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupComplaintBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupComplaintService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupComplaintVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 买家生活购控制器，查看列表，使用过的状况
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
 * @date 2014-5-23
 * 
 * @version 1.0.1
 */
@Controller
public class GroupComplaintAction {
	@Autowired
	GroupComplaintService groupComplaintService;
	@Autowired
	GroupInfoService groupInfoService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupInfoService groupinfoService;
	@Autowired
	private UserService userService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private PaymentTools paymentTools;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	GroupOrderService groupOrderService;

	/**
	 * 服务投诉列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @return
	 */
	@RequestMapping("/group/complaintList.htm")
	public ModelAndView complaintList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupOrderVO vo) {
		long currUserId = SecurityUserHolder.getCurrentUserId();
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaintList.html",
				configService.getSysConfig(), 0, request, response);
		vo.setOrderType(1);
		vo.setOrderStatus(995);
		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		vo.setUserId(currUserId);
		groupOrderService.search(vo, page);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * 我的服务投诉列表
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param vo
	 * @return
	 */
	@RequestMapping("/group/selfComplaintList.htm")
	public ModelAndView selfComplaintList(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupComplaintVO vo) {
		long currUserId = SecurityUserHolder.getCurrentUserId();
		ModelAndView mv = new JModelAndView("user/default/usercenter/selfComplaintList.html",
				configService.getSysConfig(), 0, request, response);
		vo.setUserId(SecurityUserHolder.getCurrentUserId());
		MyPage<GroupComplaintBO> page = new MyPage<GroupComplaintBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		vo.setUserId(currUserId);
		groupComplaintService.search(vo, page);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	/**
	 * 投诉详情
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("/group/complaintDetails.htm")
	public ModelAndView complaintDetails(HttpServletRequest request, HttpServletResponse response,
			String orderId) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaintDetails.html",
				configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(orderId));
		if (obj != null && obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
				&& obj.getOrderStatus() >= GroupOrderConstants.ORDER_STATUS_PAYMENT) {
			String url = configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}
			CommUtil.saveIPageList2ModelAndView(url + "/group/complaintList.htm", "", "", null, mv);
			mv.addObject("infos", obj.getGroupInfoBOList());
			mv.addObject("order", obj);
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/group/complaintList.htm");
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
	@RequestMapping("/group/complaintDetails_img.htm")
	public ModelAndView complaintDetails_img(HttpServletRequest request, HttpServletResponse response,
			Long orderId) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaintDetails_img.html",
				configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(orderId);
		mv.addObject("order", obj);

		return mv;
	}

	/**
	 * 创建服务投诉的界面
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @param currentPage
	 * @return
	 */
	@RequestMapping("/group/addComplaintView.htm")
	public ModelAndView addComplaintView(HttpServletRequest request, HttpServletResponse response,
			String orderId, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/addComplaintView.html",
				configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(orderId));
		if (obj != null && obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
				&& obj.getOrderStatus() >= GroupOrderConstants.ORDER_STATUS_PAYMENT) {
			String url = configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}
			CommUtil.saveIPageList2ModelAndView(url + "/group/complaintList.htm", "", "", null, mv);
			mv.addObject("infos", obj.getGroupInfoBOList());
			mv.addObject("order", obj);
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/group/complaintList.htm");
		}

		return mv;
	}

	/**
	 * 保存服务投诉
	 * 
	 * @param request
	 * @param response
	 * @param vo
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@RequestMapping("/group/addComplaint.htm")
	public void addComplaint(HttpServletRequest request, HttpServletResponse response, GroupComplaintVO vo) {
		groupComplaintService.addComplaint(request, vo, SecurityUserHolder.getCurrentUserId());
		Map json_map = new HashMap();
		json_map.put("op_title", "投诉提交成功");
		json_map.put("url", CommUtil.getURL(request) + "/group/complaintList.htm");
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json_map, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private int statusCount(int status) {
//		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
//		GroupOrderVO vo = new GroupOrderVO();
//		vo.setOrderStatus(status);
//		vo.setUserId(SecurityUserHolder.getCurrentUserId());
//		vo.setOrderType(1);
//		groupOrderService.search(vo, page);
//		
//		return page.getRowCount();
//	}
//
//	/**
//	 * 支付生活购订单
//	 * 
//	 * @param currentPage
//	 * @param orderBy
//	 * @param orderType
//	 * @param request
//	 * @return
//	 */
//	@SuppressWarnings("rawtypes")
//	@SecurityMapping(title = "支付生活购订单", value = "/buyer/pay_lifeorder.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/pay_lifeorder.htm")
//	public ModelAndView pay_lifeorder(HttpServletRequest request, HttpServletResponse response, String id) {
//		ModelAndView mv = new JModelAndView("life_order_pay.html", configService.getSysConfig(), 1, request, response);
//		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(id));
//		if (obj != null
//				&& obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
//				&& obj.getOrderStatus() == GroupOrderConstants.ORDER_STATUS_SUBMIT) {
//			Map map = orderFormTools.queryGroupInfo(obj.getGroupInfo());
//			Date goodsEndTime = java.sql.Date.valueOf(map.get("goods_end_time").toString());
//			if (DateUtils.truncatedCompareTo(goodsEndTime, new Date(), Calendar.DATE) < 0) {
//				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
//				mv.addObject("op_title", "订单中的服务已过期，无法进行支付");
//				mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
//				
//				return mv;
//			}
//			
//			mv.addObject("order", obj);
//			mv.addObject("all_of_price", obj.getTotalPrice());
//			mv.addObject("paymentTools", paymentTools);
//			mv.addObject("group", true);
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
//			mv.addObject("op_title", "订单编号错误");
//			mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
//		}
//		
//		return mv;
//	}
//
//	/**
//	 * 生活购订单详情
//	 * 
//	 * @param currentPage
//	 * @param orderBy
//	 * @param orderType
//	 * @param request
//	 * @return
//	 */
//	@SecurityMapping(title = "生活购订单详情", value = "/buyer/lifeorder_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/lifeorder_view.htm")
//	public ModelAndView lifeorder_view(HttpServletRequest request,
//			HttpServletResponse response, String id, String currentPage, String type) {
//		ModelAndView mv = new JModelAndView("user/default/usercenter/lifeorder_view.html",
//				configService.getSysConfig(), 0, request, response);
//		if (StringUtils.isNotBlank(type))
//			mv = new JModelAndView("user/default/usercenter/lifeorder_view_down.html",
//					configService.getSysConfig(), 0, request, response);
//		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(id));
//		if (obj != null
//				&& obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
//				&& obj.getOrderStatus() >= GroupOrderConstants.ORDER_STATUS_PAYMENT) {
//			String url = configService.getSysConfig().getAddress();
//			if (url == null || url.equals("")) {
//				url = CommUtil.getURL(request);
//			}
//			CommUtil.saveIPageList2ModelAndView(url + "/buyer/groupinfo_list.htm", "", "", null, mv);
//			mv.addObject("infos", obj.getGroupInfoBOList());
//			mv.addObject("order", obj);
//			mv.addObject("orderFormTools", orderFormTools);
//		} else {
//			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
//			mv.addObject("op_title", "订单编号错误");
//			mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm");
//		}
//		
//		return mv;
//	}
//	
//	/**
//	 * 团购商品退款
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param currentPage
//	 * @return
//	 */
//	@SecurityMapping(title = "团购商品退款", value = "/buyer/refundInfo_view.htm", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/refundInfo_view.htm")
//	public String refundInfo(HttpServletRequest request, String id) {
//		GroupInfo gi = groupInfoService.refundInfo(id, SecurityUserHolder.getCurrentUserId());
//		
//		return "redirect:/buyer/lifeorder_view.htm?id=" + gi.getOrderId();
//	}
//
//	@SecurityMapping(title = "订单取消", value = "/buyer/lifeorder_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/lifeorder_cancel.htm")
//	public String lifeorder_cancel(HttpServletRequest request, String currentPage, String id, Integer orderType) throws ServiceException {
//		GroupOrderBO of = groupOrderService.getObjById(CommUtil.null2Long(id));
//		if (of.getUserId().equals(SecurityUserHolder.getCurrentUserId())) {
//			groupOrderService.cancelOrder(of.getId());
//		}
//		
//		return "redirect:" + "/buyer/group.htm?orderType=" + orderType + "&currentPage=" + currentPage;
//	}
}
