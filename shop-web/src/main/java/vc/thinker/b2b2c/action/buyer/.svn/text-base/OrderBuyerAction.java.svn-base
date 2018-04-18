package vc.thinker.b2b2c.action.buyer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.jfree.util.Log;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.express.service.ExpressInfoService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.juanpi.vo.JuanpiOrderGoodsVO;
import com.sinco.carnation.kuaidi100.pojo.ResultItem;
import com.sinco.carnation.kuaidi100.post.JacksonHelper;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.OrderLogBO;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.shop.tools.ShipTools;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: OrderBuyerAction.java
 * </p>
 * 
 * <p>
 * Description: 买家订单控制类，用来操作取消订单、查看订单、订单付款、物流查询、订单评价等操作；
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
 * @date 2014-5-19
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class OrderBuyerAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private IUserConfigService userConfigService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private UserService userService;

	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsLogService goodsLogService;
	// @Autowired
	// private ITemplateService templateService;
	@Autowired
	private StorePointService storePointService;
	// @Autowired
	// private IPredepositLogService predepositLogService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private SellerService sellerService;
	// @Autowired
	// private IGoodsCartService goodsCartService;
	// @Autowired
	// private IGroupInfoService groupinfoService;
	// @Autowired
	// private IGoodsReturnService goodsReturnService;
	@Autowired
	private ExpressCompanyService expressCompayService;
	@Autowired
	private OrderFormTools orderFormTools;

	@Autowired
	private PayoffLogService payoffLogservice;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;
	@Autowired
	private ShipTools shipTools;
	@Autowired
	private UserAccountService userAccountService;

	// @Autowired
	// private LuceneVoTools luceneVoTools;
	// @Autowired
	// private IGroupGoodsService groupGoodsService;
	// @Autowired
	// private IAlbumService albumService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private ExpressInfoService expressInfoService;

	@Autowired
	private GoodsViewTools goodsViewTools;
	// @Autowired
	// private IGoodsLogService goodsLogService;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private LuceneUtil luceneUtil;

	@Autowired
	private TransInfoService transInfoService;
	@Autowired
	private JuanpiOrderService juanpiOrderService;

	@SecurityMapping(title = "买家订单列表", value = "/buyer/order.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order.htm")
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response, String currentPage,
			MyPage<OrderFormBO> page, OrderFormVO vo, String order_id, String beginTime, String endTime,
			String order_status) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/buyer_order.html",
				configService.getSysConfig(), 0, request, response);
		/*
		 * OrderFormQueryObject ofqo = new OrderFormQueryObject(currentPage, mv,
		 * "addTime", "desc"); User user =
		 * this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId
		 * ()); ofqo.addQuery("obj.user_id", new SysMap("user_id",
		 * SecurityUserHolder.getCurrentUser().getId().toString()), "=");
		 * ofqo.addQuery("obj.order_main", new SysMap("order_main", 1), "="); //
		 * 只显示主订单,通过主订单完成子订单的加载 ofqo.addQuery("obj.order_cat", new
		 * SysMap("order_cat", 2), "!="); if
		 * (!CommUtil.null2String(order_id).equals("")) {
		 * ofqo.addQuery("obj.order_id", new SysMap("order_id", "%" + order_id +
		 * "%"), "like"); mv.addObject("order_id", order_id); }
		 */

		// if (!CommUtil.null2String(beginTime).equals("")) {
		// ofqo.addQuery("obj.addTime",
		// new SysMap("beginTime", CommUtil.formatDate(beginTime)),
		// ">=");
		mv.addObject("beginTime", beginTime);
		// }
		// if (!CommUtil.null2String(endTime).equals("")) {
		// String ends = endTime + " 23:59:59";
		// ofqo.addQuery(
		// "obj.addTime",
		// new SysMap("endTime", CommUtil.formatDate(ends,
		// "yyyy-MM-dd hh:mm:ss")), "<=");
		mv.addObject("endTime", endTime);
		// }
		// if (!CommUtil.null2String(order_status).equals("")) {
		// if (order_status.equals("order_submit")) {// 已经提交
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 10), "=");
		// }
		// if (order_status.equals("order_pay")) {// 已经付款
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 20), "=");
		// }
		// if (order_status.equals("order_shipping")) {// 已经发货
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 30), "=");
		// }
		// if (order_status.equals("order_receive")) {// 已经收货
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 40), "=");
		// }
		// if (order_status.equals("order_finish")) {// 已经完成
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 50), "=");
		// }
		// if (order_status.equals("order_cancel")) {// 已经取消
		// ofqo.addQuery("obj.order_status",
		// new SysMap("order_status", 0), "=");
		// }
		// }
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("order_status", order_status);
		Integer yungouFlag = 3;// 增加订单查询
		orderFormService.queryByCnd(SecurityUserHolder.getCurrentUserId(), beginTime, endTime, order_id,
				order_status, page, yungouFlag);
		
			for (int i = 0; i < page.getContent().size(); i++) {
				if (page.getContent().get(i).getJuanpiOrder() == 1) {
					boolean bl = true;
					String id = page.getContent().get(i).getOrderId();
					JuanpiOrderGoodsVO goodsVO = new JuanpiOrderGoodsVO();
					goodsVO.setId(CommUtil.null2Long(id));
					List<JuanpiOrderGoodsBO>  list = this.juanpiOrderService.selectOrderGoodsListByVO(goodsVO, null);
					for (JuanpiOrderGoodsBO resBo: list) {
						if (resBo.getStatus() != 3 && resBo.getStatus() != 4) {
							bl = false;
							break;
						}
					}
					page.getContent().get(i).setDelete(bl);
				}
			}

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		// 查询订单信息
		List<OrderFormBO> statusCountList = orderFormService.statusCount(SecurityUserHolder
				.getCurrentUserId());
		mv.addObject("statusCountList", statusCountList);
		mv.addObject("orderFormTools", orderFormTools);

		// // 猜您喜欢 根据cookie商品的分类 销量查询 如果没有cookie则按销量查询
		// List<Goods> your_like_goods = new ArrayList<Goods>();
		// Long your_like_GoodsClass = null;
		// Cookie[] cookies = request.getCookies();
		// if (cookies != null) {
		// for (Cookie cookie : cookies) {
		// if (cookie.getName().equals("goodscookie")) {
		// String[] like_gcid = cookie.getValue().split(",", 2);
		// Goods goods = this.goodsService.getObjById(CommUtil
		// .null2Long(like_gcid[0]));
		// if (goods == null)
		// break;
		// your_like_GoodsClass = goods.getGc().getId();
		// your_like_goods = this.goodsService.query(
		// "select obj from Goods obj where obj.goods_status=0 and obj.gc.id = "
		// + your_like_GoodsClass
		// + " and obj.id is not " + goods.getId()
		// + " order by obj.goods_salenum desc", null,
		// 0, 20);
		// int gcs_size = your_like_goods.size();
		// if (gcs_size < 20) {
		// List<Goods> like_goods = this.goodsService.query(
		// "select obj from Goods obj where obj.goods_status=0 and obj.id is not
		// "
		// + goods.getId()
		// + " order by obj.goods_salenum desc",
		// null, 0, 20 - gcs_size);
		// for (int i = 0; i < like_goods.size(); i++) {
		// // 去除重复商品
		// int k = 0;
		// for (int j = 0; j < your_like_goods.size(); j++) {
		// if (like_goods.get(i).getId()
		// .equals(your_like_goods.get(j).getId())) {
		// k++;
		// }
		// }
		// if (k == 0) {
		// your_like_goods.add(like_goods.get(i));
		// }
		// }
		// }
		// break;
		// } else {
		// your_like_goods = this.goodsService
		// .query("select obj from Goods obj where obj.goods_status=0 order by
		// obj.goods_salenum desc",
		// null, 0, 20);
		// }
		// }
		// } else {
		// your_like_goods = this.goodsService
		// .query("select obj from Goods obj where obj.goods_status=0 order by
		// obj.goods_salenum desc",
		// null, 0, 20);
		// }
		// mv.addObject("your_like_goods", your_like_goods);
		return mv;
	}

	//
	@SecurityMapping(title = "订单取消", value = "/buyer/order_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cancel.htm")
	public ModelAndView order_cancel(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_cancel.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单取消确定", value = "/buyer/order_cancel_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cancel_save.htm")
	public String order_cancel_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String state_info, String other_state_info) throws Exception {
		orderFormService.cancelSave(request, id, state_info, other_state_info,
				SecurityUserHolder.getCurrentUserId());
		return "redirect:order.htm?currentPage=" + currentPage;
	}

	//
	/**
	 * 买家打开收货确认对话框
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 */
	@SecurityMapping(title = "收货确认", value = "/buyer/order_cofirm.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cofirm.htm")
	public ModelAndView order_cofirm(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_cofirm.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
			mv.addObject("obj", obj);
			mv.addObject("child_order", !CommUtil.null2String(obj.getChildOrderDetail()).equals(""));
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	//
	/**
	 * 买家确认收货，确认收货后，订单状态值改变为40，如果是预存款支付，买家冻结预存款中同等订单账户金额自动转入商家预存款，如果开启预存款分润， 则按照分润比例，买家预存款分别进入商家及平台商的账户
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@SecurityMapping(title = "收货确认保存", value = "/buyer/order_cofirm_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cofirm_save.htm")
	public String order_cofirm_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) throws Exception {
		// OrderForm obj =
		// this.orderFormService.getObjById(CommUtil.null2Long(id));
		orderFormService.orderCofirmSave(SecurityUserHolder.getCurrentUserId(), id, CommUtil.getURL(request));
		String url = "redirect:order.htm?currentPage=" + currentPage;
		return url;
	}

	//
	@SecurityMapping(title = "买家评价", value = "/buyer/order_evaluate.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_evaluate.htm")
	public ModelAndView order_evaluate(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_evaluate.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
			mv.addObject("obj", obj);
			mv.addObject("orderFormTools", orderFormTools);
			String evaluate_session = CommUtil.randomString(32);
			request.getSession(false).setAttribute("evaluate_session", evaluate_session);
			mv.addObject("evaluate_session", evaluate_session);
			if (obj.getOrderStatus() >= 50) {
				mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "订单已经评价！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("jsessionid", request.getSession().getId());
		return mv;
	}

	// 关键字过滤
	@RequestMapping("/buyer/word_check.htm")
	public void word_check(HttpServletRequest request, HttpServletResponse response, String content) {
		WordFind wordFind = new WordFind("/dic/sensitive.dic", "sensitive");
		String[] words = wordFind.find(content);
		if (words.length > 0) {
			try {
				response.getWriter().print(false);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// public static int imageCount = 0;
	@SecurityMapping(title = "买家评价图片上传", value = "/buyer/upload_evaluate.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/upload_evaluate.htm")
	public void upload_evaluate(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Map json_map = new HashMap();
		SysConfig config = this.configService.getSysConfig();
		String path = "";
		String uploadFilePath = config.getUploadFilePath();
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		// List<Accessory> imglist =
		// accessoryService.queryForEvaluate(SecurityUserHolder.getCurrentUserId());
		// accessoryService.
		Long goodsId = CommUtil.null2Long(request.getParameter("goods_id"));
//		Evaluate evaluate = evaluateService.fetch(SecurityUserHolder.getCurrentUserId(), goodsId);
//		if(null!=evaluate){
//			String photos = evaluate.getEvaluatePhotos();
//			if (null!=photos) {
//				String[] imgs = photos.split(";");
//				if (imgs.length > 4) {
//					json_map.put("ret", false);
//					json_map.put("msg", "您最近上传过多图片，请稍后重试");
//					response.setContentType("text/plain");
//					response.getWriter().print(Json.toJson(json_map));
//					return;
//				}
//			}
//		}

		String url = this.accessoryService.upload(request, "evaluate_photos_a_" + goodsId, null);
		json_map.put("url", url);
		json_map.put("id", new Date().getTime());
		json_map.put("goods_id", goodsId);
		json_map.put("ret", true);
		response.setContentType("text/plain");
		response.getWriter().print(Json.toJson(json_map));
		// if (imglist.size() > 40) {// 每个用户最多可以上传40张临时图片，半小时清理一次
		// json_map.put("ret", false);
		// json_map.put("msg", "您最近上传过多图片，请稍后重试");
		// response.setContentType("text/plain");
		// response.getWriter().print(Json.toJson(json_map));
		// } else {
		// json_map.put("ret", true);
		// try {
		// // <1>. 判断路径是否存在,若不存在则创建路径
		//
		// String url = this.accessoryService.upload(request,
		// "evaluate_photos_a_" + goods_id, null);
		//
		// json_map.put("url", url);
		// json_map.put("id", new Date().getTime());
		// json_map.put("goods_id", goods_id);
		// response.setContentType("text/plain");
		// response.getWriter().print(Json.toJson(json_map));
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }

	}

	// 新改 买家评价保存
	@SecurityMapping(title = "买家评价保存", value = "/buyer/order_evaluate_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_evaluate_save.htm")
	@Transactional(readOnly = false)
	public ModelAndView orderEvaluateSave(HttpServletRequest request, HttpServletResponse response,
			String id, String evaluate_session) throws Exception {
		String evaluate_session1 = (String) request.getSession(false).getAttribute("evaluate_session");
		if (evaluate_session1 == null || !evaluate_session1.equals(evaluate_session)) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "禁止重复评价!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}
		// 1. 获取订单
		OrderFormBO order = orderFormService.fetch(CommUtil.null2Long(id));
		if (null == order
				|| !order.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString())) {
			ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
					response);
			mv.addObject("op_title", "订单不存在或者你只能评价自己的订单!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}

		// 2. 解析订单的商品信息
		List<Map> goodsInfoMap = orderFormTools.queryGoodsInfo(order.getGoodsInfo());
		for (Map map : goodsInfoMap) {
			map.put("orderId", order.getId());
		}

		// 3。解析订单的自订单
		List<Map> child_order = this.orderFormTools.queryGoodsInfo(order.getChildOrderDetail());
		List<Map> child_goods = new ArrayList<Map>();
		for (Map c : child_order) {
			List<Map> maps = this.orderFormTools.queryGoodsInfo(c.get("order_goods_info").toString());
			for (Map cmap : maps) {
				cmap.put("orderId", c.get("order_id"));
			}
			child_goods.addAll(maps);
		}
		if (child_goods.size() > 0) {
			goodsInfoMap.addAll(child_goods);
		}

		List<Evaluate> evaluates = new ArrayList<>();
		// 批量封装请求参数，为评价对象列表
		for (Map map : goodsInfoMap) {
			String goods_id = map.get("goods_id").toString();
			// 批量解析请求参数############
			int descriptionEvaluate = orderFormTools.eva_rate(request.getParameter("description_evaluate"
					+ goods_id));
			int serviceEvaluate = orderFormTools
					.eva_rate(request.getParameter("service_evaluate" + goods_id));// 对卖家服务态度评价
			int shipEvaluate = orderFormTools.eva_rate(request.getParameter("ship_evaluate" + goods_id));// 对卖家发货速度评价

			int evaluateBuyerVal = orderFormTools.eva_total_rate(request.getParameter("evaluate_buyer_val"
					+ goods_id));// 评价类型，1为好评，0为中评，-1为差评

			String evaluateInfo = request.getParameter("evaluate_info_" + goods_id);// 买家评价信息
			String evaluatePhotos = request.getParameter("evaluate_photos_" + goods_id);// 评价图片包含多张图片的链接

			if (descriptionEvaluate == 0 || serviceEvaluate == 0 || shipEvaluate == 0
					|| evaluateBuyerVal == -5) {
				ModelAndView mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
						response);
				mv.addObject("op_title", "参数错误，禁止评价");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
				return mv;
			}

			// ###封装为评价Evaluate对象###
			Evaluate evaluate = new Evaluate();
			evaluate.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil.null2Double(descriptionEvaluate)));
			evaluate.setServiceEvaluate(BigDecimal.valueOf(CommUtil.null2Double(serviceEvaluate)));
			evaluate.setShipEvaluate(BigDecimal.valueOf(CommUtil.null2Double(shipEvaluate)));
			evaluate.setEvaluateBuyerVal(CommUtil.null2Int(evaluateBuyerVal));
			evaluate.setEvaluateInfo(evaluateInfo);
			evaluate.setEvaluatePhotos(evaluatePhotos);

			// ###继续封装
			evaluate.setGoodsNum(CommUtil.null2Int(map.get("goods_count")));
			evaluate.setGoodsPrice(map.get("goods_price").toString());
			evaluate.setGoodsSpec(map.get("goods_gsp_val").toString());
			evaluate.setEvaluateType("goods");
			// ###继续封装
			evaluate.setAddTime(new Date());
			evaluate.setEvaluateUserId(SecurityUserHolder.getCurrentUserId());
			evaluate.setEvaluateGoodsId(CommUtil.null2Long(goods_id));
			evaluate.setOfId(CommUtil.null2Long(map.get("orderId")));
			// ###继续封装，初次评价
			evaluate.setReplyStatus(0);
			evaluate.setEvaluateStatus(0);
			
			evaluates.add(evaluate);
		}

		evaluateService.add(order, evaluates);

		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);
		mv.addObject("op_title", "订单评价成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		return mv;
	}

	// XXX 买家评价保存
	// @SecurityMapping(title = "买家评价保存", value =
	// "/buyer/order_evaluate_save.htm*", rtype = "buyer", rname = "用户中心", rcode
	// = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/order_evaluate_save.htm")
	// @Transactional(readOnly = false)
	// public ModelAndView order_evaluate_save(HttpServletRequest request,
	// HttpServletResponse response, String id, String evaluate_session) throws
	// Exception {
	//
	// OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
	// String evaluate_session1 = (String)
	// request.getSession(false).getAttribute("evaluate_session");
	// if (evaluate_session1 != null &&
	// evaluate_session1.equals(evaluate_session)) {
	// request.getSession(false).removeAttribute("evaluate_session");
	// if (obj != null &&
	// obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUserId().toString()))
	// {
	// if (obj.getOrderStatus() == 40) {
	// List<Map> json = this.orderFormTools.queryGoodsInfo(obj.getGoodsInfo());
	// for (Map map : json) {
	// String goods_id = map.get("goods_id").toString();
	// int description =
	// orderFormTools.eva_rate(request.getParameter("description_evaluate" +
	// goods_id));
	// int service =
	// orderFormTools.eva_rate(request.getParameter("service_evaluate" +
	// goods_id));
	// int ship = orderFormTools.eva_rate(request.getParameter("ship_evaluate" +
	// goods_id));
	// int total =
	// orderFormTools.eva_total_rate(request.getParameter("evaluate_buyer_val" +
	// goods_id));
	// if (description == 0 || service == 0 || ship == 0 || total == -5) {
	// ModelAndView mv = new JModelAndView("error.html",
	// configService.getSysConfig(), 1, request, response);
	// mv.addObject("op_title", "参数错误，禁止评价");
	// mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
	// return mv;
	// }
	// }
	// obj.setOrderStatus(50);
	// this.orderFormService.update(obj);
	// OrderLog ofl = new OrderLog();
	// ofl.setAddTime(new Date());
	// ofl.setLogInfo("评价订单");
	// ofl.setLogUserId(SecurityUserHolder.getCurrentUserId());
	// ofl.setOfId(obj.getId());
	// this.orderFormLogService.save(ofl);
	// obj.setFinishTime(new Date());
	// this.orderFormService.update(obj);
	//
	// for (Map map : json) {
	// map.put("orderForm", obj.getId());
	// }
	// List<Map> child_order =
	// this.orderFormTools.queryGoodsInfo(obj.getChildOrderDetail());
	// List<Map> child_goods = new ArrayList<Map>();
	// for (Map c : child_order) {
	// List<Map> maps =
	// this.orderFormTools.queryGoodsInfo(c.get("order_goods_info").toString());
	// for (Map cmap : maps) {
	// cmap.put("orderForm", c.get("order_id"));
	// }
	// child_goods.addAll(maps);
	// }
	// if (child_goods.size() > 0) {
	// json.addAll(child_goods);
	// }
	//
	// for (Map map : json) {
	// Evaluate eva = new Evaluate();
	// Goods goods =
	// this.goodsService.getObjById(CommUtil.null2Long(map.get("goods_id")));
	// eva.setAddTime(new Date());
	// eva.setEvaluateGoodsId(goods.getId());
	// goods.setEvaluateCount(goods.getEvaluateCount() + 1);
	// eva.setGoodsNum(CommUtil.null2Int(map.get("goods_count")));
	// eva.setGoodsPrice(map.get("goods_price").toString());
	// eva.setGoodsSpec(map.get("goods_gsp_val").toString());
	// eva.setEvaluateInfo(request.getParameter("evaluate_info_" +
	// goods.getId()));
	// eva.setEvaluatePhotos(request.getParameter("evaluate_photos_" +
	// goods.getId()));
	// eva.setEvaluateBuyerVal(CommUtil.null2Int(orderFormTools.eva_total_rate(request.getParameter("evaluate_buyer_val"
	// + goods.getId()))));
	// eva.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil.null2Double(orderFormTools.eva_rate(request.getParameter("description_evaluate"
	// + goods.getId())))));
	// eva.setServiceEvaluate(BigDecimal.valueOf(CommUtil.null2Double(orderFormTools.eva_rate(request.getParameter("service_evaluate"
	// + goods.getId())))));
	// eva.setShipEvaluate(BigDecimal.valueOf(CommUtil.null2Double(orderFormTools.eva_rate(request.getParameter("ship_evaluate"
	// + goods.getId())))));
	// eva.setEvaluateType("goods");
	// eva.setEvaluateUserId(SecurityUserHolder.getCurrentUserId());
	// //
	// eva.setOf(this.orderFormService.getObjById(CommUtil.null2Long(map.get("orderForm"))));
	// eva.setOfId(obj.getId());
	// OrderForm of =
	// orderFormService.getObjById(CommUtil.null2Long(map.get("orderForm")));
	// eva.setOfId(of.getId());
	// eva.setReplyStatus(0);
	// eva.setEvaluateStatus(0);
	// evaluateService.save(eva);
	//
	// if (goods.getGoodsType() == 1) {
	// Store store =
	// this.storeService.getObjById(CommUtil.null2Long(goods.getGoodsStoreId()));
	// // params.put("store_id", store.getId().toString());
	// // List<Evaluate> evas =
	// // this.evaluateService.query("select obj from
	// // Evaluate obj where obj.of.store_id=:store_id",
	// // params, -1, -1);
	// List<EvaluateBO> evas = evaluateService.queryByStoreId(store.getId());
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
	// ship_evaluate) / 3;// 综合评分=三项具体评分之和/3
	// store.setStoreCredit(store.getStoreCredit() + eva.getEvaluateBuyerVal());
	// this.storeService.update(store);
	// // params.clear();
	// // params.put("store_id", store.getId());
	// // List<StorePoint> sps =
	// // this.storePointService.query("select obj from
	// // StorePoint obj where obj.store.id=:store_id",
	// // params, -1, -1);
	// StorePoint point = storePointService.fetchByStoreId(store.getId());
	// if (null == point)
	// point = new StorePoint();
	// point.setAddTime(new Date());
	// point.setStoreId(store.getId());
	// point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate > 5
	// ? 5 : description_evaluate));
	// point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate > 5 ? 5 :
	// service_evaluate));
	// point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 :
	// ship_evaluate));
	// point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate > 5 ? 5 :
	// store_evaluate));
	// if (point.getId() != null && point.getId() > 0) {
	// this.storePointService.update(point);
	// } else {
	// this.storePointService.save(point);
	// }
	// } else {
	// User sp_user = this.userService.getObjById(obj.getEvaUserId());
	// // params.put("user_id",
	// // SecurityUserHolder.getCurrentUser().getId().toString());
	// // List<Evaluate> evas =
	// // this.evaluateService.query("select obj from
	// // Evaluate obj where obj.of.user_id=:user_id",
	// // params, -1, -1);
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
	// // params.put("user_id", obj.getEvaUserId();
	// // List<StorePoint> sps =
	// // this.storePointService.query("select obj from
	// // StorePoint obj where obj.user.id=:user_id",
	// // params, -1, -1);
	// StorePoint point = storePointService.fetchByUserId(obj.getEvaUserId());
	// if (null == point)
	// point = new StorePoint();
	// point.setAddTime(new Date());
	// point.setUserId(sp_user.getId());
	// point.setDescriptionEvaluate(BigDecimal.valueOf(description_evaluate > 5
	// ? 5 : description_evaluate));
	// point.setServiceEvaluate(BigDecimal.valueOf(service_evaluate > 5 ? 5 :
	// service_evaluate));
	// point.setShipEvaluate(BigDecimal.valueOf(ship_evaluate > 5 ? 5 :
	// ship_evaluate));
	// point.setStoreEvaluate(BigDecimal.valueOf(store_evaluate > 5 ? 5 :
	// store_evaluate));
	// if (null != point.getId() && point.getId() > 0) {
	// this.storePointService.update(point);
	// } else {
	// this.storePointService.save(point);
	// }
	// }
	// this.goodsService.update(goods);
	// // User user =
	// // this.userService.getObjById(CommUtil.null2Long(obj.getUserId()));
	// UserCustomerBO user = customerService.queryUserByUid(obj.getUserId());
	// // 增加评价积分
	// user.setIntegral(user.getIntegral() +
	// this.configService.getSysConfig().getIndentComment());
	// // 增加用户消费金额
	// user.setUserGoodsFee(BigDecimal.valueOf(CommUtil.add(user.getUserGoodsFee(),
	// obj.getTotalPrice())));
	//
	// // this.userService.update(user);
	// // 记录积分明细
	// // if (this.configService.getSysConfig().isIntegral()) {
	// if (configService.getSysConfig().getIntegral()) {
	// IntegralLog log = new IntegralLog();
	// log.setAddtime(new Date());
	// log.setContent("订单评价增加" +
	// this.configService.getSysConfig().getIndentComment() + "分");
	// log.setIntegral(this.configService.getSysConfig().getIndentComment());
	// log.setIntegralUserId(user.getUid());
	// log.setType("order");
	// this.integralLogService.save(log);
	// }
	// }
	// }
	// /*
	// * if (this.configService.getSysConfig().getEmailEnable()) { if
	// * (obj.getOrderForm() == 0) { Store store =
	// * this.storeService.getObjById(CommUtil.null2Long(obj.
	// * getStoreId())); Map map = new HashMap(); map.put("seller_id",
	// * store.getCurrentUserId().toString()); map.put("order_id",
	// * obj.getId().toString()); String json = Json.toJson(map);
	// * this.msgTools.sendEmailCharge(CommUtil.getURL(request),
	// * "email_toseller_evaluate_ok_notify",
	// * store.getUser().getEmail(), json, null, obj.getStore_id());
	// * msgTools.sendEmailCharge(CommUtil.getURL(request),
	// * "email_toseller_evaluate_ok_notify", store.getSmsEmailInfo(),
	// * Json.toJson(map), null, obj.getStoreId()); } }
	// */
	// }
	// ModelAndView mv = new JModelAndView("success.html",
	// configService.getSysConfig(), 1, request, response);
	// mv.addObject("op_title", "订单评价成功");
	// mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
	// return mv;
	// } else {
	// ModelAndView mv = new JModelAndView("error.html",
	// configService.getSysConfig(), 1, request, response);
	// mv.addObject("op_title", "禁止重复评价!");
	// mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
	// return mv;
	// }
	//
	// }

	//
	@SecurityMapping(title = "删除订单信息", value = "/buyer/order_delete.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_delete.htm")
	public String order_delete(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage,Integer juanpiOrder) throws Exception {
		
		if (juanpiOrder != null && juanpiOrder.intValue()==1) {
			JuanpiOrder jp = new JuanpiOrder();
			jp.setDeleteStatus(1);
			jp.setId(CommUtil.null2Long(id));
			juanpiOrderService.update(jp);
		} else {
			
			OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
			if (obj != null
					&& obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
				if (obj.getOrderStatus() == 0) {
					if (obj.getOrderMain() == 1 && obj.getOrderCat() == 0) {
						if (obj.getChildOrderDetail() != null && !obj.getChildOrderDetail().equals("")) {
							List<Map> maps = (List<Map>) Json.fromJson(obj.getChildOrderDetail());
							for (Map map : maps) {
								OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(map
										.get("order_id")));
								child_order.setOrderStatus(0);
								this.orderFormService.delete(child_order.getId());
							}
						}
					}
					this.orderFormService.delete(obj.getId());
				}
			}
		}
		
		return "redirect:order.htm?currentPage=" + currentPage;
	}

	//
	@SecurityMapping(title = "买家订单详情", value = "/buyer/order_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_view.htm")
	public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderFormBO obj = this.orderFormService.fetch(CommUtil.null2Long(id));
		Long userId = SecurityUserHolder.getCurrentUserId();
		if (obj != null && obj.getUserId().toString().equals(userId.toString())) {
			if (obj.getOrderCat() == 1) {// 手机充值订单
				mv = new JModelAndView("user/default/usercenter/recharge_order_view.html",
						configService.getSysConfig(), 0, request, response);
			}
			boolean query_ship = false;// 是否查询物流
			if (!CommUtil.null2String(obj.getShipCode()).equals("")) {
				query_ship = true;
			}
			if (obj.getOrderMain() == 1 && !CommUtil.null2String(obj.getChildOrderDetail()).equals("")) {// 子订单中有商家已经发货，也需要显示
				List<Map> maps = this.orderFormTools.queryGoodsInfo(obj.getChildOrderDetail());
				for (Map child_map : maps) {
					OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(child_map
							.get("order_id")));
					if (!CommUtil.null2String(child_order.getShipCode()).equals("")) {
						query_ship = true;
					}
				}
			}

			// 获取支付方式
			if (obj.getPaymentId() != null) {
				Payment payment = this.paymentService.findById(obj.getPaymentId());
				mv.addObject("payMark", payment.getName());
			}

			// 判断账号是否为CN账号
			Long uid = SecurityUserHolder.getCurrentUserId();
			boolean isCN = userAccountService.check_User_Is_CN(uid);
			mv.addObject("isCN", isCN);

			mv.addObject("obj", obj);
			mv.addObject("shipTools", shipTools);
			mv.addObject("orderFormTools", orderFormTools);
			mv.addObject("query_ship", query_ship);
			// Map params = new HashMap();
			// params.put("of_id", obj.getId());
			// List<OrderLog> ofls = this.orderFormLogService.query("select obj
			// from OrderFormLog obj where obj.of.id=:of_id", params, -1, -1);
			mv.addObject("user", customerService.findSessionUser(userId));
			List<OrderLogBO> ofls = orderFormLogService.queryByOrderId(CommUtil.null2Long(id));
			mv.addObject("ofls", ofls);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("express_company_name",
				this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
		return mv;
	}

	//
	@SecurityMapping(title = "买家物流详情", value = "/buyer/ship_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/ship_view.htm")
	public ModelAndView order_ship_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_ship_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (order != null) {
			if (order.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
				List<TransInfo> transInfo_list = new ArrayList<TransInfo>();
				TransInfo transInfo = orderFormTools.query_ship_getData(order);
				transInfo.setExpress_company_name(this.orderFormTools.queryExInfo(order.getExpressInfo(),
						"express_company_name"));
				transInfo.setExpress_ship_code(order.getShipCode());
				transInfo_list.add(transInfo);
				if (order.getOrderMain() == 1
						&& !CommUtil.null2String(order.getChildOrderDetail()).equals("")) {// 查询子订单的物流跟踪信息
					List<Map> maps = this.orderFormTools.queryGoodsInfo(order.getChildOrderDetail());
					for (Map child_map : maps) {
						OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(child_map
								.get("order_id")));
						if (child_order.getExpressInfo() != null) {
							TransInfo transInfo1 = orderFormTools.query_ship_getData(CommUtil
									.null2String(child_order.getId()));
							transInfo1.setExpress_company_name(this.orderFormTools.queryExInfo(
									child_order.getExpressInfo(), "express_company_name"));
							transInfo1.setExpress_ship_code(child_order.getShipCode());
							transInfo_list.add(transInfo1);
						}
					}

				}
				mv.addObject("transInfo_list", transInfo_list);
				mv.addObject("obj", order);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "您查询的物流不存在！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您查询的物流不存在！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	//
	@SecurityMapping(title = "物流跟踪查询", value = "/buyer/query_ship.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/query_ship.htm")
	public ModelAndView query_ship(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/query_ship_data.html",
				configService.getSysConfig(), 0, request, response);
		TransInfo info = orderFormTools.query_ship_getData(id);
		mv.addObject("transInfo", info);
		return mv;
	}

	@SecurityMapping(title = "虚拟商品信息", value = "/buyer/order_seller_intro.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_seller_intro.htm")
	public ModelAndView order_seller_intro(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_seller_intro.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null && obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId().toString())) {
			mv.addObject("obj", obj);
		}
		return mv;
	}

	@SecurityMapping(title = "买家退货申请", value = "/buyer/order_return_apply.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_apply.htm")
	public ModelAndView order_return_apply(HttpServletRequest request, HttpServletResponse response,
			String id, String oid, String goods_gsp_ids) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_return_apply.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = orderFormService.getObjById(CommUtil.null2Long(oid)); // 用户订单
		if (obj.getUserId().toString().equals(SecurityUserHolder.getCurrentUser().getId().toString())) { // 是否是自己的订单
			List<Map> maps = orderFormTools.queryGoodsInfo(obj.getGoodsInfo()); // 订单商品详情
																				// 订单商品信息，使用json管理
			Goods goods = goodsService.getObjById(CommUtil.null2Long(id)); // 商品
			for (Map m : maps) {
				if (CommUtil.null2String(m.get("goods_id")).equals(id)
						&& (StringUtils.isBlank(goods_gsp_ids) || goods_gsp_ids.equals(CommUtil.null2String(m
								.get("goods_gsp_ids"))))) {
					mv.addObject("return_count", m.get("return_goods_count"));
					mv.addObject("goods", goods);
					if (CommUtil.null2String(m.get("goods_return_status")).equals("5")) {
						mv.addObject("view", true);
						List<Map> return_maps = orderFormTools.queryGoodsInfo(obj.getReturnGoodsInfo());
						for (Map map : return_maps) {
							if (CommUtil.null2String(map.get("return_goods_id")).equals(id)) {
								mv.addObject("return_content", map.get("return_goods_content"));
							}
						}
					}
				}
			}
		}
		mv.addObject("oid", oid);
		mv.addObject("goods_gsp_ids", goods_gsp_ids);
		return mv;
	}

	@SecurityMapping(title = "买家退货申请保存", value = "/buyer/order_return_apply_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_apply_save.htm")
	public String order_return_apply_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String return_goods_content, String goods_id,
			String return_goods_count, String goods_gsp_ids) throws Exception {

		orderFormService.applyOrderReturn(CommUtil.null2Long(id), SecurityUserHolder.getCurrentUserId(),
				return_goods_content, CommUtil.null2Long(goods_id), return_goods_count, goods_gsp_ids);

		return "redirect:order_return_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家退货申请取消", value = "/buyer/order_return_apply_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_apply_cancel.htm")
	public String order_return_apply_cancel(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String goods_id, String goods_gsp_ids) throws Exception {

		returnGoodsLogService.cancelReturnGoods(CommUtil.null2Long(id), CommUtil.null2Long(goods_id),
				goods_gsp_ids, SecurityUserHolder.getCurrentUserId());

		return "redirect:order_return_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家退货申请列表", value = "/buyer/order_return_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_list.htm")
	public ModelAndView order_return_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String order_id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_return_list.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<OrderFormBO> page = new MyPage<OrderFormBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		orderFormService.search(order_id, SecurityUserHolder.getCurrentUserId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	// @SecurityMapping(title = "生活购退款列表", value =
	// "/buyer/group_life_return.htm*", rtype = "buyer", rname = "用户中心", rcode =
	// "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/group_life_return.htm")
	// public ModelAndView group_life_return(HttpServletRequest request,
	// HttpServletResponse response, String currentPage) {
	// ModelAndView mv = new JModelAndView(
	// "user/default/usercenter/group_life_return.html",
	// configService.getSysConfig(),
	// 0, request, response);
	// GroupInfoQueryObject giqo = new GroupInfoQueryObject(currentPage, mv,
	// "addTime", "desc");
	// giqo.addQuery("obj.user_id", new SysMap("user_id", SecurityUserHolder
	// .getCurrentUser().getId()), "=");// 当前用户
	// giqo.addQuery("obj.status", new SysMap("status", 1), "!=");
	// giqo.addQuery("obj.status", new SysMap("status", -1), "!=");
	// giqo.addQuery("obj.refund_Time", new SysMap("refund_Time", new Date()),
	// ">=");
	// IPageList pList = this.groupinfoService.list(giqo);
	// CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
	// return mv;
	// }
	//
	// @SecurityMapping(title = "生活购退款申请", value =
	// "/buyer/group_life_return_apply.htm*", rtype = "buyer", rname = "用户中心",
	// rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/group_life_return_apply.htm")
	// public ModelAndView group_life_return_apply(HttpServletRequest request,
	// HttpServletResponse response, String id) {
	// ModelAndView mv = new JModelAndView(
	// "user/default/usercenter/group_life_return_apply.html",
	// configService.getSysConfig(),
	// 0, request, response);
	// GroupInfo obj = this.groupinfoService
	// .getObjById(CommUtil.null2Long(id));
	// if (obj.getUser_id()
	// .equals(SecurityUserHolder.getCurrentUser().getId())) {
	// mv.addObject("obj", obj);
	// }
	// return mv;
	// }
	//
	// @SecurityMapping(title = "生活购退款申请取消", value =
	// "/buyer/grouplife_return_apply_cancel.htm*", rtype = "buyer", rname =
	// "用户中心", rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/grouplife_return_apply_cancel.htm")
	// public String grouplife_return_apply_cancel(HttpServletRequest request,
	// HttpServletResponse response, String id) {
	// GroupInfo obj = this.groupinfoService
	// .getObjById(CommUtil.null2Long(id));
	// if (obj.getUser_id()
	// .equals(SecurityUserHolder.getCurrentUser().getId())) {
	// obj.setStatus(0);
	// this.groupinfoService.update(obj);
	// }
	// return "redirect:group_life_return.htm";
	// }
	//
	// @SecurityMapping(title = "生活购退款申请保存", value =
	// "/buyer/grouplife_return_apply_save.htm*", rtype = "buyer", rname =
	// "用户中心", rcode = "user_center", rgroup = "用户中心")
	// @RequestMapping("/buyer/grouplife_return_apply_save.htm")
	// public String grouplife_return_apply_save(HttpServletRequest request,
	// HttpServletResponse response, String id,
	// String return_group_content, String reasion) throws Exception {
	// GroupInfo obj = this.groupinfoService
	// .getObjById(CommUtil.null2Long(id));
	// if (obj != null) {
	// if (obj.getUser_id().equals(
	// SecurityUserHolder.getCurrentUser().getId())) {// 订单为生活购订单
	// String mark = "";
	// if (reasion != null && !reasion.equals("")) {
	// String rs_ids[] = reasion.split(",");
	// for (String rid : rs_ids) {
	// if (!rid.equals("")) {
	// if (rid.equals("1")) {
	// mark = "买错了/重新买";
	// } else if (rid.equals("2")) {
	// mark = "计划有变，没时间消费";
	// } else if (rid.equals("3")) {
	// mark = "预约不上";
	// } else if (rid.equals("4")) {
	// mark = "去过了，不太满意";
	// } else if (rid.equals("5")) {
	// mark = "其他";
	// }
	// }
	// obj.setStatus(3);// 申请退款中
	// obj.setRefund_reasion(mark + "[" + return_group_content
	// + "]");// 退款说明
	// this.groupinfoService.update(obj);
	// OrderForm order = this.orderFormService.getObjById(obj
	// .getOrder_id());
	// if (order.getOrder_form() == 0) {
	// User seller = this.userService
	// .getObjById(this.storeService
	// .getObjById(
	// CommUtil.null2Long(order
	// .getStore_id()))
	// .getUser().getId());
	// Map map = new HashMap();
	// map.put("buyer_id", SecurityUserHolder
	// .getCurrentUser().getId().toString());
	// map.put("seller_id", seller.getId().toString());
	// this.msgTools.sendEmailCharge(
	// CommUtil.getURL(request),
	// "email_toseller_order_refund_apply_notify",
	// seller.getEmail(), Json.toJson(map), null,
	// order.getStore_id());
	// map.clear();
	// map.put("buyer_id", SecurityUserHolder
	// .getCurrentUser().getId().toString());
	// map.put("seller_id", seller.getId().toString());
	// this.msgTools.sendSmsCharge(
	// CommUtil.getURL(request),
	// "sms_toseller_order_refund_apply_notify",
	// seller.getMobile(), Json.toJson(map), null,
	// order.getStore_id());
	// }
	// }
	// }
	// }
	// }
	// return "redirect:group_life_return.htm";
	// }

	@SecurityMapping(title = "买家退货申请列表记录", value = "/buyer/order_return_listlog.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_listlog.htm")
	public ModelAndView order_return_listlog(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_return_listlog.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<Map> page = new MyPage<Map>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		returnGoodsLogService.selectByUser(SecurityUserHolder.getCurrentUser().getId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "买家退货物流信息保存", value = "/buyer/order_return_ship_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_ship_save.htm")
	public ModelAndView order_return_ship_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String express_id, String expressCode) {
		ModelAndView mv = new JModelAndView("success.html", configService.getSysConfig(), 1, request,
				response);

		try {
			returnGoodsLogService.saveUserReturnExpress(CommUtil.null2Long(id),
					SecurityUserHolder.getCurrentUserId(), CommUtil.null2Long(express_id), expressCode);

			mv.addObject("op_title", "保存退货物流成功！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order_return_listlog.htm");
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order_return_listlog.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "买家退货填写物流", value = "/buyer/order_returnlog_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_returnlog_view.htm")
	public ModelAndView order_returnlog_view(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/order_returnlog_view.html",
				configService.getSysConfig(), 0, request, response);
		ReturnGoodsLogBO obj = this.returnGoodsLogService.findBOById(CommUtil.null2Long(id));
		User user = SecurityUserHolder.getCurrentUser();
		if (obj.getUserId().equals(user.getId())) {
			if (GoodsConstants.GOODS_RETURN_STATUS_6.equals(obj.getGoodsReturnStatus())
					|| GoodsConstants.GOODS_RETURN_STATUS_7.equals(obj.getGoodsReturnStatus())) {

				List<ExpressCompanyBO> expressCompanys = this.expressCompayService
						.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE);

				mv.addObject("expressCompanys", expressCompanys);
				mv.addObject("obj", obj);
				mv.addObject("user", user);
				OrderForm of = this.orderFormService.getObjById(obj.getReturnOrderId());

				mv.addObject("of", of);
				Goods goods = this.goodsService.getObjById(obj.getGoodsId());
				if (obj.getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
					mv.addObject("name", obj.getStoreName());
					mv.addObject("store_id", obj.getStoreId());
				} else {
					mv.addObject("name", "平台商");
				}
				if (GoodsConstants.GOODS_RETURN_STATUS_7.equals(obj.getGoodsReturnStatus())) {
					TransInfo transInfo = this.queryReturnshipGetData(obj);
					mv.addObject("transInfo", transInfo);
					Map map = Json.fromJson(HashMap.class, obj.getReturnExpressInfo());
					mv.addObject("express_company_name", map.get("express_company_name"));
				}

			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "当前状态无法对退货服务单进行操作");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order_return_listlog.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您没有为" + obj.getReturnServiceId() + "的退货服务号！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order_return_listlog.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "物流ajax", value = "/buyer/ship_ajax.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/ship_ajax.htm")
	public ModelAndView ship_ajax(HttpServletRequest request, HttpServletResponse response, String order_id) {
		ModelAndView mv = new JModelAndView("user/default/usercenter/ship_ajax.html",
				configService.getSysConfig(), 0, request, response);
		List<TransInfo> transInfo_list = new ArrayList<TransInfo>();

		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
		TransInfo transInfo = this.orderFormTools.query_ship_getData(order);
		if (transInfo != null) {
			transInfo.setExpress_company_name(this.orderFormTools.queryExInfo(order.getExpressInfo(),
					"express_company_name"));
			transInfo.setExpress_ship_code(order.getShipCode());
			transInfo_list.add(transInfo);
		}
		if (order.getOrderMain() == 1 && StringUtils.isNotBlank(order.getChildOrderDetail())) {// 查询子订单的物流跟踪信息
			List<Map> maps = this.orderFormTools.queryGoodsInfo(order.getChildOrderDetail());
			for (Map child_map : maps) {
				OrderForm child_order = this.orderFormService.getObjById(CommUtil.null2Long(child_map
						.get("order_id")));
				TransInfo transInfo1 = this.orderFormTools.query_ship_getData(child_order);
				if (transInfo1 != null) {
					transInfo1.setExpress_company_name(this.orderFormTools.queryExInfo(
							child_order.getExpressInfo(), "express_company_name"));
					transInfo1.setExpress_ship_code(child_order.getShipCode());
					transInfo_list.add(transInfo1);
				}
			}

		}
		mv.addObject("transInfo_list", transInfo_list);
		return mv;
	}

	private TransInfo queryReturnshipGetData(String id) {
		ReturnGoodsLog obj = this.returnGoodsLogService.getObjById(CommUtil.null2Long(id));
		if (obj == null) {
			return null;
		}
		return queryReturnshipGetData(obj);
	}

	private TransInfo queryReturnshipGetData(ReturnGoodsLog obj) {

		if (this.configService.getSysConfig().getKuaidiType() == 0) {// 免费物流接口
			return transInfoService.queryShipInfo(obj.getReturnExpressInfo(), obj.getExpressCode(),
					obj.getId());
		}
		return new TransInfo();
	}

	/***
	 * 组装物流查询数据
	 * 
	 * @param oid
	 * @return
	 */
	private String orderShipInfoJson(Long oid) {

		Map map = new HashMap();
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(729));
		if (order.getExpressInfo() != null) {
			map.put("com", this.orderFormTools.queryExInfo(order.getExpressInfo(), "express_company_mark"));
			map.put("num", order.getShipCode());
		}
		String jsonObject = JSONObject.fromObject(map).toString();
		return jsonObject;
	}

	/***
	 * 获取物流信息NEW
	 * 
	 * @param oid
	 */
	public void getExpressInfo(Long oid) {
		String jsonObject = this.orderShipInfoJson(oid);
		if (null != jsonObject) {
			String res = this.transInfoService.getOrderExpressInfo(jsonObject);
			JSONObject jsonObj = JSONObject.fromObject(res);
			String result = (String) jsonObj.get("result");
			String message = (String) jsonObj.get("message");

			if (null != result && result.equals(false)) {
				Log.info("查询失败");
			}
			if (null != message && message.equals("ok")) {
				List<ResultItem> list = JacksonHelper.fromJSONList(jsonObj.getString("data"),
						ResultItem.class);
				Log.info(list.get(0).getContext());
			}
		} else {
			Log.info("订单没有添加物流信息");
		}
	}

}
