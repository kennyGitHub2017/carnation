package vc.thinker.b2b2c.action.buyer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.evaluate.tools.EvaluateTools;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: EvaluateBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 用户评价管理
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
 * @date 2015-3-3
 * 
 * @version 1.0.1
 */
@Controller
public class EvaluateBuyerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private ImageTools imageTools;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StorePointService storePointService;
	@Autowired
	private UserService userService;
	@Autowired
	private EvaluateTools evaluateTools;

	//
	@SecurityMapping(title = "买家评价列表", value = "/buyer/evaluate_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_list.htm")
	public ModelAndView evaluate_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<EvaluateBO> page, String currentPage, String evaluateBuyerVal) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/evaluate_list.html",
				configService.getSysConfig(), 0, request, response);
		// EvaluateQueryObject qo = new EvaluateQueryObject(currentPage, mv,
		// "addTime", "desc");
		// qo.addQuery("obj.evaluate_user.id", new SysMap("user_id",
		// SecurityUserHolder.getCurrentUser().getId()), "=");
		// MyPage<EvaluateBO> page = new MyPage<>();
		// // EvaluateVO vo = new EvaluateVO();
		// // vo.setEvaluateUserId(SecurityUserHolder.getCurrentUserId());
		// // this.evaluateService.queryEvaluateListByVO(vo, page);
		// List<EvaluateBO> bos =
		// evaluateService.queryByUserId(SecurityUserHolder.getCurrentUserId());
		// page.setContent(bos);

		evaluateService.queryEvaultePageListByVal(SecurityUserHolder.getCurrentUserId(), evaluateBuyerVal,
				page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("evaluateTools", evaluateTools);
		mv.addObject("evaluateBuyerVal", evaluateBuyerVal);
		mv.addObject("imageTools", imageTools);
		return mv;
	}

	//
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "买家评价修改", value = "/buyer/evaluate_edit.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_edit.htm")
	public ModelAndView evaluate_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/evaluate_edit.html",
				configService.getSysConfig(), 0, request, response);
		EvaluateBO evaluate = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));
		// OrderForm obj = evaluate.getOf();
		OrderFormBO order = orderFormService.fetch(evaluate.getOfId());

		if (orderFormTools.evaluate_able(order.getFinishTime()) == 0) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "已超出评价期限");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		if (null == evaluate || null == order
				|| !order.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString())) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单信息错误");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}
		if (order.getOrderStatus() > 50) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单已关闭评价");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		mv.addObject("evaluate", evaluate);
		mv.addObject("id", id);
		mv.addObject("imageTools", imageTools);
		List<Map> list = orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		for (Map map : list) {
			if (map.get("goods_id").toString().equals(evaluate.getEvaluateGoodsId().toString())) {
				mv.addObject("obj", map);
			}
		}
		mv.addObject("orderFormTools", orderFormTools);
		String evaluate_session = CommUtil.randomString(32);
		request.getSession(false).setAttribute("evaluate_session", evaluate_session);
		mv.addObject("evaluate_session", evaluate_session);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("jsessionid", request.getSession().getId());
		return mv;
	}

	/**
	 * 单个评价修改保存
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param evaluate_session
	 * @return
	 */
	@SecurityMapping(title = "买家修改单个评价保存", value = "/buyer/evaluate_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_save.htm")
	public ModelAndView evaluateSave(HttpServletRequest request, HttpServletResponse response, String id,
			String evaluate_session) {
		// 防止重复提交
		String evaluate_session1 = (String) request.getSession(false).getAttribute("evaluate_session");
		if (evaluate_session1 == null || !evaluate_session1.equals(evaluate_session)) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "禁止重复评价!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}

		Evaluate evaluate = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));

		// 请求参数
		String goods_id = evaluate.getEvaluateGoodsId().toString();
		int descriptionEvaluate = orderFormTools.eva_rate(request.getParameter("description_evaluate"
				+ goods_id));
		int serviceEvaluate = orderFormTools.eva_rate(request.getParameter("service_evaluate" + goods_id));// 对卖家服务态度评价
		int shipEvaluate = orderFormTools.eva_rate(request.getParameter("ship_evaluate" + goods_id));// 对卖家发货速度评价

		String evaluateInfo = request.getParameter("evaluate_info_" + goods_id);// 买家评价信息
		String evaluatePhotos = request.getParameter("evaluate_photos_" + goods_id);// 评价图片包含多张图片的链接
		//
		if (descriptionEvaluate == 0 || serviceEvaluate == 0 || shipEvaluate == 0) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "参数错误，禁止评价");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		OrderFormBO order = orderFormService.fetch(evaluate.getOfId());
		if (null == order
				|| !order.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString())) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单不存在或者你只能评价自己的订单!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		if (orderFormTools.evaluate_able(order.getFinishTime()) == 0) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "已超出评价期限");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		// 封装待修改的评价信息
		evaluate.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil.null2Double(descriptionEvaluate)));
		evaluate.setServiceEvaluate(BigDecimal.valueOf(CommUtil.null2Double(serviceEvaluate)));
		evaluate.setShipEvaluate(BigDecimal.valueOf(CommUtil.null2Double(shipEvaluate)));
		evaluate.setEvaluateInfo(evaluateInfo);
		evaluate.setEvaluatePhotos(evaluatePhotos);

		evaluateService.updateEvaluate(order, evaluate);

		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("op_title", "评价修改成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
		return mv;
	}

	//
	// @SecurityMapping(title = "买家评价保存", value = "/buyer/evaluate_save.htm*",
	// rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/evaluate_save.htm")
	// public ModelAndView evaluate_save(HttpServletRequest request,
	// HttpServletResponse response, String id, String evaluate_session) {
	// JModelAndView mv;
	// EvaluateBO eva =
	// this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));
	//
	// String goods_id = eva.getEvaluateGoodsId().toString();
	//
	// // int description = eva_rate(request.getParameter("description_evaluate"
	// + goods_id));
	// // int service = eva_rate(request.getParameter("service_evaluate" +
	// goods_id));
	// // int ship = eva_rate(request.getParameter("ship_evaluate" + goods_id));
	// // if (description == 0 || service == 0 || ship == 0) {
	// // mv = new JModelAndView("error.html", configService.getSysConfig(), 1,
	// request, response);
	// // mv.addObject("op_title", "参数错误，禁止评价");
	// // mv.addObject("url", CommUtil.getURL(request) +
	// "/buyer/evaluate_list.htm");
	// // return mv;
	// // }
	//
	// // OrderForm obj = eva.getOf();
	// OrderFormBO obj = orderFormService.fetch(eva.getOfId());
	// String evaluate_session1 = (String)
	// request.getSession(false).getAttribute("evaluate_session");
	// Goods goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
	// if (orderFormTools.evaluate_able(obj.getFinishTime()) == 0) {
	// mv = new JModelAndView("error.html", configService.getSysConfig(), 1,
	// request, response);
	// mv.addObject("op_title", "已超出评价期限");
	// mv.addObject("url", CommUtil.getURL(request) +
	// "/buyer/evaluate_list.htm");
	// return mv;
	// } else {
	// if (evaluate_session1 != null &&
	// evaluate_session1.equals(evaluate_session) && obj != null &&
	// obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString()))
	// {
	// request.getSession(false).removeAttribute("evaluate_session");
	// OrderLog ofl = new OrderLog();
	// ofl.setAddTime(new Date());
	// ofl.setLogInfo("修改评价订单");
	// ofl.setLogUserId(SecurityUserHolder.getCurrentUserId());;
	// // ofl.setOf(obj);
	// ofl.setOfId(obj.getId());
	// this.orderFormLogService.save(ofl);
	// List<Accessory> img_list = imageTools.queryImgs(eva.getEvaluatePhotos());
	//
	// eva.setEvaluateInfo(request.getParameter("evaluate_info_" + goods_id));
	// eva.setEvaluatePhotos(request.getParameter("evaluate_photos_" +
	// goods_id));
	// eva.setEvaluateBuyerVal(1);;
	// eva.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil.null2Double(eva_rate(request.getParameter("description_evaluate"
	// + goods_id)))));
	// eva.setServiceEvaluate(BigDecimal.valueOf(CommUtil.null2Double(eva_rate(request.getParameter("service_evaluate"
	// + goods_id)))));
	// eva.setShipEvaluate(BigDecimal.valueOf(CommUtil.null2Double(eva_rate(request.getParameter("ship_evaluate"
	// + goods_id)))));
	// this.evaluateService.update(eva);
	//
	// /*****这个地方不再需要操作附件表 add by david******/
	// /*************
	// String im_str = request.getParameter("evaluate_photos_" + goods_id);
	// if (im_str != null && !im_str.equals("") && im_str.length() > 0) {
	// for (String str : im_str.split(",")) {
	// if (str != null && !str.equals("")) {
	// Accessory image =
	// this.accessoryService.getObjById(CommUtil.null2Long(str));
	// if (image.getInfo().equals("eva_temp")) {
	// image.setInfo("eva_img");
	// this.accessoryService.save(image);
	// }
	// img_list.remove(image);
	// }
	// }
	// }
	// for (Accessory acc : img_list) {
	// // CommUtil.del_acc(request, acc);
	// }
	// ****************/
	// // Map params = new HashMap();
	// if (goods.getGoodsType() == 1) {
	// Store store =
	// this.storeService.getObjById(CommUtil.null2Long(goods.getGoodsStoreId()));
	// // params.put("store_id", store.getId().toString());
	// // List<Evaluate> evas = this.evaluateService.query("select obj from
	// Evaluate obj where obj.of.store_id=:store_id and obj.evaluate_status<2",
	// params, -1, -1);
	// List<Evaluate> evas = evaluateService.queryStatusLess2(store.getId());
	// double store_evaluate = 0;
	// double description_evaluate = 0;
	// double description_evaluate_total = 0;
	// double service_evaluate = 0;
	// double service_evaluate_total = 0;
	// double ship_evaluate = 0;
	// double ship_evaluate_total = 0;
	// int store_credit = 0;
	// DecimalFormat df = new DecimalFormat("0.0");
	// for (Evaluate eva1 : evas) {
	// description_evaluate_total = description_evaluate_total +
	// CommUtil.null2Double(eva1.getDescriptionEvaluate());
	// service_evaluate_total = service_evaluate_total +
	// CommUtil.null2Double(eva1.getServiceEvaluate());
	// ship_evaluate_total = ship_evaluate_total +
	// CommUtil.null2Double(eva1.getShipEvaluate());
	// store_credit += eva1.getEvaluateBuyerVal();
	// }
	// description_evaluate =
	// CommUtil.null2Double(df.format(description_evaluate_total /
	// evas.size()));
	// service_evaluate = CommUtil.null2Double(df.format(service_evaluate_total
	// / evas.size()));
	// ship_evaluate = CommUtil.null2Double(df.format(ship_evaluate_total /
	// evas.size()));
	// store_evaluate = (description_evaluate + service_evaluate +
	// ship_evaluate) / 3;// 综合评分=三项具体评分之和/3
	// store.setStoreCredit(store_credit);
	// this.storeService.update(store);
	// // params.clear();
	// // params.put("store_id", store.getId());
	// // List<StorePoint> sps = this.storePointService.query("select obj from
	// StorePoint obj where obj.store.id=:store_id", params, -1, -1);
	// // StorePoint point = null;
	// // if (sps.size() > 0) {
	// // point = sps.get(0);
	// // } else {
	// // point = new StorePoint();
	// // }
	// StorePoint point = storePointService.fetchByStoreId(store.getId());
	// if (null == point)
	// point = new StorePoint();
	// point.setAddTime(new Date());
	// // point.setStore(store);
	// point.setStoreId(store.getId());
	// point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate > 5
	// ? 5 : description_evaluate));
	// point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate > 5 ? 5 :
	// service_evaluate));
	// point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 :
	// ship_evaluate));
	// point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate > 5 ? 5 :
	// store_evaluate));
	// if (point.getId()!=null &&point.getId() > 0) {
	// this.storePointService.update(point);
	// } else {
	// this.storePointService.save(point);
	// }
	// } else {
	// User sp_user = this.userService.getObjById(obj.getEvaUserId());
	// // params.put("user_id",
	// SecurityUserHolder.getCurrentUser().getId().toString());
	// // List<Evaluate> evas = this.evaluateService.query("select obj from
	// Evaluate obj where obj.of.user_id=:user_id", params, -1, -1);
	// List<EvaluateBO> evas =
	// evaluateService.queryByUserId(SecurityUserHolder.getCurrentUserId());
	// double store_evaluate = 0;
	// double description_evaluate = 0;
	// double description_evaluate_total = 0;
	// double service_evaluate = 0;
	// double service_evaluate_total = 0;
	// double ship_evaluate = 0;
	// double ship_evaluate_total = 0;
	// DecimalFormat df = new DecimalFormat("0.0");
	// for (Evaluate eva1 : evas) {
	// description_evaluate_total = description_evaluate_total +
	// CommUtil.null2Double(eva1.getDescriptionEvaluate());
	// service_evaluate_total = service_evaluate_total +
	// CommUtil.null2Double(eva1.getServiceEvaluate());
	// ship_evaluate_total = ship_evaluate_total +
	// CommUtil.null2Double(eva1.getShipEvaluate());
	// }
	// description_evaluate =
	// CommUtil.null2Double(df.format(description_evaluate_total /
	// evas.size()));
	// service_evaluate = CommUtil.null2Double(df.format(service_evaluate_total
	// / evas.size()));
	// ship_evaluate = CommUtil.null2Double(df.format(ship_evaluate_total /
	// evas.size()));
	// store_evaluate = (description_evaluate + service_evaluate +
	// ship_evaluate) / 3;
	// // params.clear();
	// // params.put("user_id", obj.getEvaUserId());
	// // List<StorePoint> sps = this.storePointService.query("select obj from
	// StorePoint obj where obj.user.id=:user_id", params, -1, -1);
	// // StorePoint point = null;
	// // if (sps.size() > 0) {
	// // point = sps.get(0);
	// // } else {
	// // point = new StorePoint();
	// // }
	// StorePoint point = storePointService.fetchByUserId(obj.getEvaUserId());
	// if (null == point)
	// point = new StorePoint();
	// point.setAddTime(new Date());
	// // point.setUser(sp_user);
	// point.setUserId(sp_user.getId());
	// point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate));
	// point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate));
	// point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate));
	// point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate));
	// if (point.getId()!=null &&point.getId() > 0) {
	// this.storePointService.update(point);
	// } else {
	// this.storePointService.save(point);
	// }
	// }
	// this.goodsService.update(goods);
	//
	// mv = new JModelAndView("success.html", configService.getSysConfig(), 1,
	// request, response);
	// mv.addObject("op_title", "评价修改成功");
	// mv.addObject("url", CommUtil.getURL(request) +
	// "/buyer/evaluate_list.htm");
	// } else {
	// mv = new JModelAndView("error.html", configService.getSysConfig(), 1,
	// request, response);
	// mv.addObject("op_title", "禁止重复评价");
	// mv.addObject("url", CommUtil.getURL(request) +
	// "/buyer/evaluate_list.htm");
	// }
	// }
	// return mv;
	// }

	//
	@SecurityMapping(title = "买家评价删除", value = "/buyer/evaluate_del.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_del.htm")
	public ModelAndView evaluate_del(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/evaluate_edit.html",
				configService.getSysConfig(), 0, request, response);
//		EvaluateBO evaluate = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));
//		OrderFormBO order = orderFormService.fetch(evaluate.getOfId());
//		if (null == order || !order.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString())) {
//			return "订单不存在或者你只能评价自己的订单!";
//		}
//		
//		if (evaluate != null && obj != null && obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
//			evaluate.setEvaluateStatus(2);
//			this.evaluateService.update(evaluate);
//			// Goods goods = evaluate.getEvaluateGoods();
//			GoodsBO goods = goodsService.getGoodsBOById(evaluate.getEvaluateGoodsId());
//			OrderLog ofl = new OrderLog();
//			ofl.setAddTime(new Date());
//			ofl.setLogInfo("删除评价");
//			ofl.setLogUserId(SecurityUserHolder.getCurrentUserId());
//			ofl.setOfId(obj.getId());
//			this.orderFormLogService.save(ofl);
//			// Map params = new HashMap();
//			if (goods.getGoodsType() == 1) {
//				Store store = this.storeService.getObjById(CommUtil.null2Long(goods.getGoodsStoreId()));
//				// params.put("store_id", store.getId().toString());
//				// List<Evaluate> evas = this.evaluateService.query("select obj
//				// from Evaluate obj where obj.of.store_id=:store_id and
//				// obj.evaluate_status<2", params, -1, -1);
//				List<Evaluate> evas = evaluateService.queryStatusLess2(store.getId());
//				double store_evaluate = 0;
//				double description_evaluate = 0;
//				double description_evaluate_total = 0;
//				double service_evaluate = 0;
//				double service_evaluate_total = 0;
//				double ship_evaluate = 0;
//				double ship_evaluate_total = 0;
//				int store_credit = 0;
//				DecimalFormat df = new DecimalFormat("0.0");
//				for (Evaluate eva1 : evas) {
//					description_evaluate_total = description_evaluate_total + CommUtil.null2Double(eva1.getDescriptionEvaluate());
//					service_evaluate_total = service_evaluate_total + CommUtil.null2Double(eva1.getServiceEvaluate());
//					ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double(eva1.getShipEvaluate());
//					store_credit += eva1.getEvaluateBuyerVal();
//				}
//				description_evaluate = CommUtil.null2Double(df.format(description_evaluate_total / evas.size()));
//				service_evaluate = CommUtil.null2Double(df.format(service_evaluate_total / evas.size()));
//				ship_evaluate = CommUtil.null2Double(df.format(ship_evaluate_total / evas.size()));
//				store_evaluate = (description_evaluate + service_evaluate + ship_evaluate) / 3;// 综合评分=三项具体评分之和/3
//				store.setStoreCredit(store_credit);
//				this.storeService.update(store);
//				// params.clear();
//				// params.put("store_id", store.getId());
//				//// List<StorePoint> sps = this.storePointService.query("select
//				// obj from StorePoint obj where obj.store.id=:store_id",
//				// params, -1, -1);
//				// StorePoint point = null;
//				// if (sps.size() > 0) {
//				// point = sps.get(0);
//				// } else {
//				// point = new StorePoint();
//				// }
//				StorePoint point = storePointService.fetchByStoreId(store.getId());
//				if (null == point)
//					point = new StorePoint();
//				point.setAddTime(new Date());
//				point.setStoreId(store.getId());
//				;
//				point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate));
//				point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate));
//				point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate));
//				point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate));
//				if (point.getId() != null && point.getId() > 0) {
//					this.storePointService.update(point);
//				} else {
//					this.storePointService.save(point);
//				}
//			} else {
//				User sp_user = this.userService.getObjById(obj.getEvaUserId());
//				Store store = this.storeService.getObjById(CommUtil.null2Long(goods.getGoodsStoreId()));
//				// params.put("user_id",
//				// SecurityUserHolder.getCurrentUser().getId().toString());
//				// List<Evaluate> evas = this.evaluateService.query("select obj
//				// from Evaluate obj where obj.of.user_id=:user_id", params, -1,
//				// -1);
//				List<EvaluateBO> evas = evaluateService.queryByStoreId(store.getId());
//				double store_evaluate = 0;
//				double description_evaluate = 0;
//				double description_evaluate_total = 0;
//				double service_evaluate = 0;
//				double service_evaluate_total = 0;
//				double ship_evaluate = 0;
//				double ship_evaluate_total = 0;
//				DecimalFormat df = new DecimalFormat("0.0");
//				for (Evaluate eva1 : evas) {
//					description_evaluate_total = description_evaluate_total + CommUtil.null2Double(eva1.getDescriptionEvaluate());
//					service_evaluate_total = service_evaluate_total + CommUtil.null2Double(eva1.getServiceEvaluate());
//					ship_evaluate_total = ship_evaluate_total + CommUtil.null2Double(eva1.getShipEvaluate());
//				}
//				description_evaluate = CommUtil.null2Double(df.format(description_evaluate_total / evas.size()));
//				service_evaluate = CommUtil.null2Double(df.format(service_evaluate_total / evas.size()));
//				ship_evaluate = CommUtil.null2Double(df.format(ship_evaluate_total / evas.size()));
//				store_evaluate = (description_evaluate + service_evaluate + ship_evaluate) / 3;
//				// params.clear();
//				// params.put("user_id", obj.getEva_user_id());
//				// List<StorePoint> sps = this.storePointService.query("select
//				// obj from StorePoint obj where obj.user.id=:user_id", params,
//				// -1, -1);
//				// StorePoint point = null;
//				// if (sps.size() > 0) {
//				// point = sps.get(0);
//				// } else {
//				// point = new StorePoint();
//				// }
//				StorePoint point = storePointService.fetchByStoreId(store.getId());
//				if (null == point)
//					point = new StorePoint();
//				point.setAddTime(new Date());
//				point.setUserId(sp_user.getId());
//				point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate));
//				point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate));
//				point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate));
//				point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate));
//				if (null != point.getId() && point.getId() > 0) {
//					this.storePointService.update(point);
//				} else {
//					this.storePointService.save(point);
//				}
//			}
//		}

		if (!evaluateService.delete(CommUtil.null2Long(id))) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "删除失败");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm?currentPage="
					+ currentPage);
			return mv;
		}

		mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "订单评价删除成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
		return mv;
	}

	//
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "买家追加评价", value = "/buyer/order_evaluate_add.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_add.htm")
	public ModelAndView order_evaluate_add(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/evaluate_add.html",
				configService.getSysConfig(), 0, request, response);
		EvaluateBO evaluate = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));
		OrderFormBO obj = orderFormService.fetch(evaluate.getOfId());
		// Goods goods = evaluate.getEvaluateGoods();
		GoodsBO goods = goodsService.getGoodsBOById(evaluate.getEvaluateGoodsId());
		if (orderFormTools.evaluate_able(obj.getFinishTime()) == 0) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "已超出评价追加期限");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
		} else {
			if (evaluate != null
					&& evaluate.getAddevaStatus() == 0
					&& obj != null
					&& obj.getUserId().toString()
							.equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
				mv.addObject("evaluate", evaluate);
				mv.addObject("imageTools", imageTools);

				List<Map> list = orderFormTools.queryGoodsInfo(obj.getGoodsInfo());
				for (Map map : list) {
					if (map.get("goods_id").toString().equals(goods.getId().toString())) {
						mv.addObject("obj", map);
					}
				}

				mv.addObject("id", id);
				mv.addObject("orderFormTools", orderFormTools);
				String evaluate_session = CommUtil.randomString(32);
				request.getSession(false).setAttribute("evaluate_session", evaluate_session);
				mv.addObject("evaluate_session", evaluate_session);
				if (obj.getOrderStatus() > 50) {
					mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "订单已关闭评价");
					mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
				}
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "评价信息错误");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			}
		}
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("jsessionid", request.getSession().getId());
		return mv;
	}

	@SecurityMapping(title = "买家追加评价保存", value = "/buyer/evaluate_add_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/evaluate_add_save.htm")
	public ModelAndView evaluate_add_save(HttpServletRequest request, HttpServletResponse response,
			String id, String evaluate_session) throws Exception {
		// 防止重复提交
		String evaluate_session1 = (String) request.getSession(false).getAttribute("evaluate_session");
		if (evaluate_session1 == null || !evaluate_session1.equals(evaluate_session)) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "禁止重复评价!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}

		Evaluate evaluate = this.evaluateService.queryEvaluateById(CommUtil.null2Long(id));

		// 请求参数
		String goods_id = evaluate.getEvaluateGoodsId().toString();

		String evaluateInfo = request.getParameter("evaluate_info_" + goods_id);// 买家评价信息
		String evaluatePhotos = request.getParameter("evaluate_photos_" + goods_id);// 评价图片包含多张图片的链接

		OrderFormBO order = orderFormService.fetch(evaluate.getOfId());
		if (null == order
				|| !order.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString())) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单不存在或者你只能评价自己的订单!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htmm");
			return mv;
		}
		if (orderFormTools.evaluate_able(order.getFinishTime()) == 0) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "已超出评价期限");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		if (order.getOrderStatus() != 50 || evaluate.getAddevaStatus() != 0) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "不符合追加评价条件");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
			return mv;
		}

		evaluate.setAddevaInfo(evaluateInfo);
		evaluate.setAddevaPhotos(evaluatePhotos);

		evaluateService.addAnother(order, evaluate);
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("op_title", "订单追加评价成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/evaluate_list.htm");
		return mv;
	}

}
