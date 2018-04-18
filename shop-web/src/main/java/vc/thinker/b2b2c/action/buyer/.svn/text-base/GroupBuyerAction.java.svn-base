package vc.thinker.b2b2c.action.buyer;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.model.GroupInfo;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.service.AlbumService;
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
public class GroupBuyerAction {
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
	@Autowired
	private StoreService storeService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;

	@SecurityMapping(title = "买家生活购订单列表", value = "/buyer/group.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/group.htm")
	public ModelAndView buyer_group(HttpServletRequest request, HttpServletResponse response,
			String currentPage, GroupOrderVO vo) {
		long currUserId = SecurityUserHolder.getCurrentUserId();
		ModelAndView mv = null;

		if (vo.getOrderType() != null && vo.getOrderType() == 1) { // 线上订单
			mv = new JModelAndView("user/default/usercenter/buyer_group.html", configService.getSysConfig(),
					0, request, response);
			mv.addObject("status10", statusCount(10));
			mv.addObject("status20", statusCount(20));
			mv.addObject("status999", statusCount(999));
		} else { // 线下刷卡
			mv = new JModelAndView("user/default/usercenter/buyer_card.html", configService.getSysConfig(),
					0, request, response);
		}

		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		vo.setUserId(currUserId);
		groupOrderService.search(vo, page);
		if (page.getContent() != null && page.getContent().size() > 0) {
			for (GroupOrderBO orderBO : page.getContent()) {
				StoreBO storeBO = storeService.findObjById(CommUtil.null2Long(orderBO.getStoreId()));
				if (storeBO != null) {
					orderBO.setStoreName(storeBO.getStoreName());
					AlbumBO albumBO = albumService.getStoreAlbum(storeBO.getCreateUserId());
					if (albumBO != null) {
						Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
						if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
							orderBO.setGroupAccPath(accessory.getPath());
						}
					}
				}
				if (orderBO.getOrderType() != null) {
					if (orderBO.getOrderType() == 1) {
						orderBO.setLocalGroupName("线上订单");
					} else if (orderBO.getOrderType() == 2) {
						orderBO.setLocalGroupName("扫码支付");
					} else if (orderBO.getOrderType() == 3) {
						orderBO.setLocalGroupName("优惠买单");
					} else if (orderBO.getOrderType() == 4) {
						orderBO.setLocalGroupName("套餐券");
					} else if (orderBO.getOrderType() == 5) {
						orderBO.setLocalGroupName("代金券");
					}
				}
			}
		}
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		return mv;
	}

	private int statusCount(int status) {
		MyPage<GroupOrderBO> page = new MyPage<GroupOrderBO>();
		GroupOrderVO vo = new GroupOrderVO();
		vo.setOrderStatus(status);
		vo.setUserId(SecurityUserHolder.getCurrentUserId());
		vo.setOrderType(1);
		groupOrderService.search(vo, page);

		return page.getRowCount();
	}

//	/**
//	 * 买家中心消费码列表页
//	 * 
//	 * @param currentPage
//	 * @param orderBy
//	 * @param orderType
//	 * @param request
//	 * @return
//	 */
//	@SecurityMapping(title = "买家生活购消费码列表", value = "/buyer/groupinfo_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
//	@RequestMapping("/buyer/groupinfo_list.htm")
//	public ModelAndView groupinfo_list(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String orderBy,
//			String orderType, String info_id) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/usercenter/groupinfo_list.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		String url = this.configService.getSysConfig().getAddress();
//		if (url == null || url.equals("")) {
//			url = CommUtil.getURL(request);
//		}
//		String params = "";
//		GroupInfoQueryObject qo = new GroupInfoQueryObject(currentPage, mv,
//				orderBy, orderType);
//		qo.addQuery("obj.user_id", new SysMap("user_id", user.getId()), "=");
//		if (!CommUtil.null2String(info_id).equals("")) {
//			qo.addQuery("obj.group_sn", new SysMap("group_sn", "%" + info_id
//					+ "%"), "like");
//			mv.addObject("info_id", info_id);
//		}
//		WebForm wf = new WebForm();
//		wf.toQueryPo(request, qo, GroupInfo.class, mv);
//		IPageList pList = this.groupinfoService.list(qo);
//		CommUtil.saveIPageList2ModelAndView(url + "/buyer/groupinfo_list.htm",
//				"", params, pList, mv);
//		return mv;
//	}

	/**
	 * 支付生活购订单
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "支付生活购订单", value = "/buyer/pay_lifeorder.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/pay_lifeorder.htm")
	public ModelAndView pay_lifeorder(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("life_order_pay.html", configService.getSysConfig(), 1, request,
				response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
				&& obj.getOrderStatus() == GroupOrderConstants.ORDER_STATUS_SUBMIT) {
			Map map = orderFormTools.queryGroupInfo(obj.getGroupInfo());
			Date goodsEndTime = java.sql.Date.valueOf(map.get("goods_end_time").toString());
			if (DateUtils.truncatedCompareTo(goodsEndTime, new Date(), Calendar.DATE) < 0) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "订单中的服务已过期，无法进行支付");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");

				return mv;
			}

			mv.addObject("order", obj);
			mv.addObject("all_of_price", obj.getTotalPrice());
			mv.addObject("paymentTools", paymentTools);
			mv.addObject("group", true);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
		}

		return mv;
	}

	/**
	 * 生活购订单详情
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "生活购订单详情", value = "/buyer/lifeorder_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/lifeorder_view.htm")
	public ModelAndView lifeorder_view(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String type) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/lifeorder_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(type))
			mv = new JModelAndView("user/default/usercenter/lifeorder_view_down.html",
					configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getUserId().equals(SecurityUserHolder.getCurrentUserId())
				&& obj.getOrderStatus() >= GroupOrderConstants.ORDER_STATUS_PAYMENT) {
			String url = configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}

			// 获取订单店铺名称
			if (obj.getStore() != null) {
				AlbumBO albumBO = albumService.getStoreAlbum(obj.getStore().getCreateUserId());
				if (albumBO != null) {
					Accessory accessory = accessoryService.getObjById(albumBO.getAlbumCoverId());// 商户默认封面
					if (accessory != null && StringUtils.isNotBlank(accessory.getPath())) {
						obj.setGroupAccPath(accessory.getPath());
					}
				}
			}
			if (obj.getOrderType() != null) {
				if (obj.getOrderType() == 1) {
					obj.setLocalGroupName("线上订单");
				} else if (obj.getOrderType() == 2) {
					obj.setLocalGroupName("扫码支付");
				} else if (obj.getOrderType() == 3) {
					obj.setLocalGroupName("优惠买单");
				} else if (obj.getOrderType() == 4) {
					obj.setLocalGroupName("套餐券");
				} else if (obj.getOrderType() == 5) {
					obj.setLocalGroupName("代金券");
				}
			}

			CommUtil.saveIPageList2ModelAndView(url + "/buyer/groupinfo_list.htm", "", "", null, mv);
			mv.addObject("infos", obj.getGroupInfoBOList());
			mv.addObject("order", obj);
			mv.addObject("store", obj.getStore());
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm");
		}

		return mv;
	}

	/**
	 * 团购商品退款
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "团购商品退款", value = "/buyer/refundInfo_view.htm", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/refundInfo_view.htm")
	public String refundInfo(HttpServletRequest request, String id, String refundReasion) {
		GroupInfo gi = groupInfoService.refundInfo(id, refundReasion, SecurityUserHolder.getCurrentUserId());

		return "redirect:/buyer/lifeorder_view.htm?id=" + gi.getOrderId();
	}

	@SecurityMapping(title = "订单取消", value = "/buyer/lifeorder_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/lifeorder_cancel.htm")
	public String lifeorder_cancel(HttpServletRequest request, String currentPage, String id,
			Integer orderType) throws ServiceException {
		GroupOrderBO of = groupOrderService.getObjById(CommUtil.null2Long(id));
		if (of.getUserId().equals(SecurityUserHolder.getCurrentUserId())) {
			groupOrderService.cancelOrder(of.getId());
		}

		return "redirect:" + "/buyer/group.htm?orderType=" + orderType + "&currentPage=" + currentPage;
	}
}
