package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ComplaintBO;
import com.sinco.carnation.shop.bo.ComplaintGoodsBO;
import com.sinco.carnation.shop.bo.ComplaintSubjectBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.Complaint;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.service.ComplaintGoodsService;
import com.sinco.carnation.shop.service.ComplaintService;
import com.sinco.carnation.shop.service.ComplaintSubjectService;
import com.sinco.carnation.shop.vo.ComplaintGoodsVO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.service.ManagerService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: ComplaintBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 买家投诉管理器
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
 * @date 2014-6-24
 * 
 * @version 1.0.1
 */
@Controller
public class ComplaintBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintSubjectService complaintSubjectService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	ComplaintGoodsService complaintGoodsService;
	@Autowired
	UserCustomerService userCustomerService;
	@Autowired
	ManagerService managerService;

	@SecurityMapping(title = "可投诉的商品列表", value = "/buyer/order_complaint_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_complaint_list.htm")
	public ModelAndView order_complaint_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String order_id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_complaint_list.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<OrderFormBO> page = new MyPage<OrderFormBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		orderFormService.complain(order_id, SecurityUserHolder.getCurrentUser().getId(), page);
		if (!CommUtil.null2String(order_id).equals(""))
			mv.addObject("order_id", order_id);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "我的投诉", value = "/buyer/complaint.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint.htm")
	public ModelAndView complaint(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String status) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_complaint.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<ComplaintBO> page = new MyPage<ComplaintBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		complaintService.selectByUser(SecurityUserHolder.getCurrentUser().getId(), status, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("status", status);

		return mv;
	}

	@SecurityMapping(title = "买家投诉发起", value = "/buyer/complaint_handle.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_handle.htm")
	public ModelAndView complaint_handle(HttpServletRequest request, HttpServletResponse response,
			String order_id, String goods_id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaint_handle.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm of = orderFormService.getObjById(CommUtil.null2Long(order_id));
		if (!of.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您没有该订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}
		Goods goods = goodsService.getObjById(CommUtil.null2Long(goods_id));
		mv.addObject("of", of);
		mv.addObject("goods", goods);
		mv.addObject("goods_ids", goods_id);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -configService.getSysConfig().getComplaintTime());
		boolean result = true;
		if (of.getOrderStatus() == 60) {
			if (of.getFinishTime().before(calendar.getTime())) {
				result = false;
			}
		}
		boolean result1 = true;
		List<ComplaintSubjectBO> subs = complaintSubjectService.allSeller();

		if (result) {
			if (result1) {
				if (subs.size() > 0) {
					ComplaintBO obj = new ComplaintBO();
					obj.setFromUserId(SecurityUserHolder.getCurrentUser().getId());
					obj.setStatus(0);
					obj.setType("buyer");
					obj.setOfId(of.getId());
					obj.setOrderForm(of);
					Seller seller = sellerService.getByStoreId(CommUtil.null2Long(of.getStoreId()));
					Store store = this.storeService.getObjById(CommUtil.null2Long(of.getStoreId()));
					if (seller != null && store != null) {
						obj.setToUserId(seller.getUid());
						obj.setStore(store);
					}
					mv.addObject("obj", obj);
					mv.addObject("subs", subs);
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "系统未设置投诉主题不可投诉，请联系客服");
					mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
				}
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "该订单已经投诉，不允许重复投诉");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "该订单已经超过投诉有效期，不能投诉");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "提交投诉", value = "/buyer/complaint_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_save.htm")
	public void complaint_save(HttpServletRequest request, HttpServletResponse response, String order_id,
			String cs_id, String from_user_content, String goods_ids, String to_user_id, String type,
			String goods_gsp_ids) {
		complaintService.saveComplaint(request, order_id, cs_id, from_user_content, goods_ids, to_user_id,
				type, goods_gsp_ids, SecurityUserHolder.getCurrentUserId());

		Map json_map = new HashMap();
		json_map.put("op_title", "投诉提交成功");
		json_map.put("url", CommUtil.getURL(request) + "/buyer/complaint.htm");
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

	@SecurityMapping(title = "买家查看投诉详情", value = "/buyer/complaint_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_view.htm")
	public ModelAndView complaint_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaint_view.html",
				configService.getSysConfig(), 0, request, response);
		Long currUserId = SecurityUserHolder.getCurrentUserId();
		ComplaintBO obj = complaintService.getObjById(CommUtil.null2Long(id));
		OrderForm of = orderFormService.getObjById(obj.getOfId());
		ComplaintSubject cs = complaintSubjectService.getObjById(obj.getCsId());
		Manager manager = managerService.getObjById(obj.getHandleUserId());
		ComplaintGoodsVO cgvo = new ComplaintGoodsVO();
		cgvo.setComplaintId(obj.getId());
		List<ComplaintGoodsBO> complaintGoods = complaintGoodsService.findListByVo(cgvo);
		if (cs != null)
			obj.setTitle(cs.getTitle());
		if (manager != null)
			obj.setHandName(manager.getName());
		if (obj.getFromUserId().equals(currUserId) || obj.getToUserId().equals(currUserId)) {
			obj.setOrderForm(of);
			obj.setCgs(complaintGoods);
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，不存在该投诉");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/complaint.htm");
		}

		if (of != null) {
			Store store = storeService.getObjById(CommUtil.null2Long(of.getStoreId()));
			mv.addObject("store", store);
		}
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "买家取消投诉", value = "/buyer/complaint_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_cancel.htm")
	public String complaint_cancel(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		complaintService.delete(CommUtil.null2Long(id));

		return "redirect:complaint.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "投诉图片", value = "/buyer/complaint_img.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_img.htm")
	public ModelAndView complaint_img(HttpServletRequest request, HttpServletResponse response, String id,
			String type) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/complaint_img.html",
				configService.getSysConfig(), 0, request, response);
		Complaint obj = complaintService.getObjById(CommUtil.null2Long(id));
		mv.addObject("type", type);
		mv.addObject("obj", obj);

		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "发布投诉对话", value = "/buyer/complaint_talk.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_talk.htm")
	public void complaint_talk(HttpServletRequest request, HttpServletResponse response, String id,
			String talk_content) throws IOException {
		Complaint obj = complaintService.getObjById(CommUtil.null2Long(id));
		if (StringUtils.isNotBlank(talk_content)) {
			Long currUserId = SecurityUserHolder.getCurrentUserId();
			String user_role = "";
			if (currUserId.equals(obj.getFromUserId())) {
				user_role = "投诉人";
			}
			if (currUserId.equals(obj.getToUserId())) {
				user_role = "申诉人";
			}
			String temp = user_role + "[" + userCustomerService.queryUserByUid(currUserId).getNickname()
					+ "] " + CommUtil.formatLongDate(new Date()) + "说: " + talk_content;
			if (obj.getTalkContent() == null) {
				obj.setTalkContent(temp);
			} else {
				obj.setTalkContent(temp + "\n\r" + obj.getTalkContent());
			}
			complaintService.update(obj);
		}
		List<Map> list = new ArrayList<Map>();
		for (String s : CommUtil.str2list(obj.getTalkContent())) {
			Map map = new HashMap();
			map.put("content", s);
			if (s.indexOf("管理员") == 0) {
				map.put("role", "admin");
			}
			if (s.indexOf("投诉") == 0) {
				map.put("role", "from_user");
			}
			if (s.indexOf("申诉") == 0) {
				map.put("role", "to_user");
			}
			list.add(map);
		}

		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(list, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "申诉提交仲裁", value = "/buyer/complaint_arbitrate.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/complaint_arbitrate.htm")
	public void complaint_arbitrate(HttpServletRequest request, HttpServletResponse response, String id) {
		Complaint obj = complaintService.getObjById(CommUtil.null2Long(id));
		obj.setStatus(3);
		complaintService.update(obj);
	}

	@SecurityMapping(title = "投诉关闭", value = "/buyer/complaint_close.htm*", rtype = "buyer", rname = "投诉管理", rcode = "user_center", rgroup = "交易")
	@RequestMapping("/buyer/complaint_close.htm")
	public void complaint_close(HttpServletRequest request, HttpServletResponse response, String id,
			String handleContent) {
//		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(),
//				0, request, response);
		complaintService.updateComplaintClose(id, handleContent);
//		mv.addObject("op_title", "关闭投诉成功");
//		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/complaint_list.htm");
	}
}
