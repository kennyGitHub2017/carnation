package vc.thinker.b2b2c.action.buyer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dozer.Mapper;
import org.elasticsearch.common.collect.Maps;
import org.jfree.util.Log;
import org.jsoup.helper.StringUtil;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.WordFind;
import vc.thinker.b2b2c.pay.tenpay.util.Sha1Util;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.express.service.ExpressInfoService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCartBO;
import com.sinco.carnation.goods.bo.ReturnGoodsLogBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsLogService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.goods.tools.GoodsCaseViewTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.service.ShopQrPayOrderService;
import com.sinco.carnation.order.service.WeiXinPayWapService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.CnPayBaseService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.OrderLogBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.ShopQrPayOrderBO;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.Evaluate;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.tools.ShipTools;
import com.sinco.carnation.shop.vo.GoodsCartMyVO;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.bo.orcl.CnUserMoneyBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.util.WebUtils;
import com.weixin.bean.PayH5QrCode;
import com.weixin.utils.QRCodeUtils;
import com.sinco.carnation.shop.constants.PaymentConstants;

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
@SuppressWarnings({ "rawtypes", "unused", "unchecked", "deprecation" })
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
	private GoodsCaseViewTools goodsCaseViewTools;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private WeiXinPayWapService weiXinPayWapService;

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
	private PredepositService predepositService;
	@Autowired
	private PayTools payTools;
	@Autowired
	private ShopQrPayOrderService shopQrPayOrderService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private CnPayBaseService cnPayBaseService;
	@Autowired
	private Mapper mapper;
	@Autowired
	private TransportTools transportTools;

	@SecurityMapping(title = "买家订单列表", value = "/buyer/order.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order.htm")
	public ModelAndView order(HttpServletRequest request,
			HttpServletResponse response, String currentPage,
			MyPage<OrderFormBO> page, OrderFormVO vo, String order_id,
			String beginTime, String endTime, String order_status) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/buyer_order.html",
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
		Integer yungouFlag = 0;// 增加订单查询
		orderFormService.queryByCnd(SecurityUserHolder.getCurrentUserId(),
				beginTime, endTime, order_id, order_status, page, yungouFlag);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		// 查询订单信息
		List<OrderFormBO> statusCountList = orderFormService
				.statusCount(SecurityUserHolder.getCurrentUserId());
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

	@SecurityMapping(title = "订单取消", value = "/buyer/order_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cancel.htm")
	public ModelAndView order_cancel(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_cancel.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService
				.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId()
						.toString()
						.equals(SecurityUserHolder.getCurrentUser().getId()
								.toString())) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单取消确定", value = "/buyer/order_cancel_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_cancel_save.htm")
	public String order_cancel_save(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String state_info, String other_state_info) throws Exception {
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
	public ModelAndView order_cofirm(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_cofirm.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService
				.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId()
						.toString()
						.equals(SecurityUserHolder.getCurrentUser().getId()
								.toString())) {
			mv.addObject("obj", obj);
			mv.addObject("child_order",
					!CommUtil.null2String(obj.getChildOrderDetail()).equals(""));
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	//
	/**
	 * 买家确认收货，确认收货后，订单状态值改变为40，如果是预存款支付，买家冻结预存款中同等订单账户金额自动转入商家预存款，如果开启预存款分润，
	 * 则按照分润比例，买家预存款分别进入商家及平台商的账户
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
	public String order_cofirm_save(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage)
			throws Exception {
		// OrderForm obj =
		// this.orderFormService.getObjById(CommUtil.null2Long(id));
		orderFormService.orderCofirmSave(SecurityUserHolder.getCurrentUserId(),
				id, CommUtil.getURL(request));
		String url = "redirect:order.htm?currentPage=" + currentPage;
		return url;
	}

	//
	@SecurityMapping(title = "买家评价", value = "/buyer/order_evaluate.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_evaluate.htm")
	public ModelAndView order_evaluate(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_evaluate.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService
				.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId()
						.toString()
						.equals(SecurityUserHolder.getCurrentUser().getId()
								.toString())) {
			mv.addObject("obj", obj);
			mv.addObject("orderFormTools", orderFormTools);
			String evaluate_session = CommUtil.randomString(32);
			request.getSession(false).setAttribute("evaluate_session",
					evaluate_session);
			mv.addObject("evaluate_session", evaluate_session);
			if (obj.getOrderStatus() >= 50) {
				mv = new JModelAndView("success.html",
						configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "订单已经评价！");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("jsessionid", request.getSession().getId());
		return mv;
	}

	// 关键字过滤
	@RequestMapping("/buyer/word_check.htm")
	public void word_check(HttpServletRequest request,
			HttpServletResponse response, String content) {
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
	public void upload_evaluate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

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
		// Evaluate evaluate =
		// evaluateService.fetch(SecurityUserHolder.getCurrentUserId(),
		// goodsId);
		// if(null!=evaluate){
		// String photos = evaluate.getEvaluatePhotos();
		// if (null!=photos) {
		// String[] imgs = photos.split(";");
		// if (imgs.length > 4) {
		// json_map.put("ret", false);
		// json_map.put("msg", "您最近上传过多图片，请稍后重试");
		// response.setContentType("text/plain");
		// response.getWriter().print(Json.toJson(json_map));
		// return;
		// }
		// }
		// }

		String url = this.accessoryService.upload(request, "evaluate_photos_a_"
				+ goodsId, null);
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
	public ModelAndView orderEvaluateSave(HttpServletRequest request,
			HttpServletResponse response, String id, String evaluate_session)
			throws Exception {
		String evaluate_session1 = (String) request.getSession(false)
				.getAttribute("evaluate_session");
		if (evaluate_session1 == null
				|| !evaluate_session1.equals(evaluate_session)) {
			ModelAndView mv = new JModelAndView("error.html",
					configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "禁止重复评价!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}
		// 1. 获取订单
		OrderFormBO order = orderFormService.fetch(CommUtil.null2Long(id));
		if (null == order
				|| !order
						.getUserId()
						.toString()
						.equals(SecurityUserHolder.getCurrentUserId()
								.toString())) {
			ModelAndView mv = new JModelAndView("error.html",
					configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "订单不存在或者你只能评价自己的订单!");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			return mv;
		}

		// 2. 解析订单的商品信息
		List<Map> goodsInfoMap = orderFormTools.queryGoodsInfo(order
				.getGoodsInfo());
		for (Map map : goodsInfoMap) {
			map.put("orderId", order.getId());
		}

		// 3。解析订单的自订单
		List<Map> child_order = this.orderFormTools.queryGoodsInfo(order
				.getChildOrderDetail());
		List<Map> child_goods = new ArrayList<Map>();
		for (Map c : child_order) {
			List<Map> maps = this.orderFormTools.queryGoodsInfo(c.get(
					"order_goods_info").toString());
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
			int descriptionEvaluate = orderFormTools.eva_rate(request
					.getParameter("description_evaluate" + goods_id));
			int serviceEvaluate = orderFormTools.eva_rate(request
					.getParameter("service_evaluate" + goods_id));// 对卖家服务态度评价
			int shipEvaluate = orderFormTools.eva_rate(request
					.getParameter("ship_evaluate" + goods_id));// 对卖家发货速度评价

			int evaluateBuyerVal = orderFormTools.eva_total_rate(request
					.getParameter("evaluate_buyer_val" + goods_id));// 评价类型，1为好评，0为中评，-1为差评

			String evaluateInfo = request.getParameter("evaluate_info_"
					+ goods_id);// 买家评价信息
			String evaluatePhotos = request.getParameter("evaluate_photos_"
					+ goods_id);// 评价图片包含多张图片的链接

			if (descriptionEvaluate == 0 || serviceEvaluate == 0
					|| shipEvaluate == 0 || evaluateBuyerVal == -5) {
				ModelAndView mv = new JModelAndView("error.html",
						configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "参数错误，禁止评价");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order.htm");
				return mv;
			}

			// ###封装为评价Evaluate对象###
			Evaluate evaluate = new Evaluate();
			evaluate.setDescriptionEvaluate(BigDecimal.valueOf(CommUtil
					.null2Double(descriptionEvaluate)));
			evaluate.setServiceEvaluate(BigDecimal.valueOf(CommUtil
					.null2Double(serviceEvaluate)));
			evaluate.setShipEvaluate(BigDecimal.valueOf(CommUtil
					.null2Double(shipEvaluate)));
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

		ModelAndView mv = new JModelAndView("success.html",
				configService.getSysConfig(), 1, request, response);
		mv.addObject("op_title", "订单评价成功");
		mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		return mv;
	}

	// 买家评价保存
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
	public String order_delete(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage)
			throws Exception {
		OrderForm obj = this.orderFormService
				.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId()
						.toString()
						.equals(SecurityUserHolder.getCurrentUser().getId()
								.toString())) {
			if (obj.getOrderStatus() == 0) {
				if (obj.getOrderMain() == 1 && obj.getOrderCat() == 0) {
					if (obj.getChildOrderDetail() != null
							&& !obj.getChildOrderDetail().equals("")) {
						List<Map> maps = (List<Map>) Json.fromJson(obj
								.getChildOrderDetail());
						for (Map map : maps) {
							OrderForm child_order = this.orderFormService
									.getObjById(CommUtil.null2Long(map
											.get("order_id")));
							child_order.setOrderStatus(0);
							this.orderFormService.delete(child_order.getId());
						}
					}
				}
				this.orderFormService.delete(obj.getId());
			}
		}
		return "redirect:order.htm?currentPage=" + currentPage;
	}

	// TODO
	@SecurityMapping(title = "买家订单详情", value = "/buyer/order_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_view.htm")
	public ModelAndView order_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderFormBO obj = this.orderFormService.fetch(CommUtil.null2Long(id));
		Long userId = SecurityUserHolder.getCurrentUserId();
		if (obj != null && obj.getUserId().toString().equals(userId.toString())) {
			if (obj.getOrderCat() == 1) {// 手机充值订单
				mv = new JModelAndView(
						"user/default/usercenter/recharge_order_view.html",
						configService.getSysConfig(), 0, request, response);
			}
			boolean query_ship = false;// 是否查询物流
			if (!CommUtil.null2String(obj.getShipCode()).equals("")) {
				query_ship = true;
			}
			if (obj.getOrderMain() == 1
					&& !CommUtil.null2String(obj.getChildOrderDetail()).equals(
							"")) {// 子订单中有商家已经发货，也需要显示
				List<Map> maps = this.orderFormTools.queryGoodsInfo(obj
						.getChildOrderDetail());
				for (Map child_map : maps) {
					OrderForm child_order = this.orderFormService
							.getObjById(CommUtil.null2Long(child_map
									.get("order_id")));
					if (!CommUtil.null2String(child_order.getShipCode())
							.equals("")) {
						query_ship = true;
					}
				}
			}
			mv.addObject("obj", obj);
			mv.addObject("shipTools", shipTools);
			mv.addObject("orderFormTools", orderFormTools);
			mv.addObject("query_ship", query_ship);
			// Map params = new HashMap();
			// params.put("of_id", obj.getId());
			// List<OrderLog> ofls = this.orderFormLogService.query("select obj
			// from OrderFormLog obj where obj.of.id=:of_id", params, -1, -1);
			mv.addObject("user", customerService.findSessionUser(userId));
			List<OrderLogBO> ofls = orderFormLogService.queryByOrderId(CommUtil
					.null2Long(id));
			mv.addObject("ofls", ofls);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "订单编号错误");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("express_company_name", this.orderFormTools.queryExInfo(
				obj.getExpressInfo(), "express_company_name"));
		return mv;
	}

	//
	@SecurityMapping(title = "买家物流详情", value = "/buyer/ship_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/ship_view.htm")
	public ModelAndView order_ship_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_ship_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm order = this.orderFormService.getObjById(CommUtil
				.null2Long(id));
		if (order != null) {
			if (order
					.getUserId()
					.toString()
					.equals(SecurityUserHolder.getCurrentUser().getId()
							.toString())) {
				List<TransInfo> transInfo_list = new ArrayList<TransInfo>();
				TransInfo transInfo = orderFormTools.query_ship_getData(order);
				transInfo.setExpress_company_name(this.orderFormTools
						.queryExInfo(order.getExpressInfo(),
								"express_company_name"));
				transInfo.setExpress_ship_code(order.getShipCode());
				transInfo_list.add(transInfo);
				if (order.getOrderMain() == 1
						&& !CommUtil.null2String(order.getChildOrderDetail())
								.equals("")) {// 查询子订单的物流跟踪信息
					List<Map> maps = this.orderFormTools.queryGoodsInfo(order
							.getChildOrderDetail());
					for (Map child_map : maps) {
						OrderForm child_order = this.orderFormService
								.getObjById(CommUtil.null2Long(child_map
										.get("order_id")));
						if (child_order.getExpressInfo() != null) {
							TransInfo transInfo1 = orderFormTools
									.query_ship_getData(CommUtil
											.null2String(child_order.getId()));
							transInfo1
									.setExpress_company_name(this.orderFormTools
											.queryExInfo(child_order
													.getExpressInfo(),
													"express_company_name"));
							transInfo1.setExpress_ship_code(child_order
									.getShipCode());
							transInfo_list.add(transInfo1);
						}
					}

				}
				mv.addObject("transInfo_list", transInfo_list);
				mv.addObject("obj", order);
			} else {
				mv = new JModelAndView("error.html",
						configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "您查询的物流不存在！");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "您查询的物流不存在！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}
		return mv;
	}

	//
	@SecurityMapping(title = "物流跟踪查询", value = "/buyer/query_ship.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/query_ship.htm")
	public ModelAndView query_ship(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/query_ship_data.html",
				configService.getSysConfig(), 0, request, response);
		TransInfo info = orderFormTools.query_ship_getData(id);
		mv.addObject("transInfo", info);
		return mv;
	}

	@SecurityMapping(title = "虚拟商品信息", value = "/buyer/order_seller_intro.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_seller_intro.htm")
	public ModelAndView order_seller_intro(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_seller_intro.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService
				.getObjById(CommUtil.null2Long(id));
		if (obj != null
				&& obj.getUserId().equals(
						SecurityUserHolder.getCurrentUser().getId().toString())) {
			mv.addObject("obj", obj);
		}
		return mv;
	}

	@SecurityMapping(title = "买家退货申请", value = "/buyer/order_return_apply.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_apply.htm")
	public ModelAndView order_return_apply(HttpServletRequest request,
			HttpServletResponse response, String id, String oid,
			String goods_gsp_ids) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_return_apply.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = orderFormService.getObjById(CommUtil.null2Long(oid)); // 用户订单
		if (obj.getUserId().toString()
				.equals(SecurityUserHolder.getCurrentUser().getId().toString())) { // 是否是自己的订单
			List<Map> maps = orderFormTools.queryGoodsInfo(obj.getGoodsInfo()); // 订单商品详情
																				// 订单商品信息，使用json管理
			Goods goods = goodsService.getObjById(CommUtil.null2Long(id)); // 商品
			for (Map m : maps) {
				if (CommUtil.null2String(m.get("goods_id")).equals(id)
						&& (StringUtils.isBlank(goods_gsp_ids) || goods_gsp_ids
								.equals(CommUtil.null2String(m
										.get("goods_gsp_ids"))))) {
					mv.addObject("return_count", m.get("return_goods_count"));
					mv.addObject("goods", goods);
					if (CommUtil.null2String(m.get("goods_return_status"))
							.equals("5")) {
						mv.addObject("view", true);
						List<Map> return_maps = orderFormTools
								.queryGoodsInfo(obj.getReturnGoodsInfo());
						for (Map map : return_maps) {
							if (CommUtil
									.null2String(map.get("return_goods_id"))
									.equals(id)) {
								mv.addObject("return_content",
										map.get("return_goods_content"));
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
	public String order_return_apply_save(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String return_goods_content, String goods_id,
			String return_goods_count, String goods_gsp_ids) throws Exception {

		orderFormService
				.applyOrderReturn(CommUtil.null2Long(id),
						SecurityUserHolder.getCurrentUserId(),
						return_goods_content, CommUtil.null2Long(goods_id),
						return_goods_count, goods_gsp_ids);

		return "redirect:order_return_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家退货申请取消", value = "/buyer/order_return_apply_cancel.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_apply_cancel.htm")
	public String order_return_apply_cancel(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String goods_id, String goods_gsp_ids) throws Exception {

		returnGoodsLogService.cancelReturnGoods(CommUtil.null2Long(id),
				CommUtil.null2Long(goods_id), goods_gsp_ids,
				SecurityUserHolder.getCurrentUserId());

		return "redirect:order_return_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家退货申请列表", value = "/buyer/order_return_list.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_list.htm")
	public ModelAndView order_return_list(HttpServletRequest request,
			HttpServletResponse response, String currentPage, String order_id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_return_list.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<OrderFormBO> page = new MyPage<OrderFormBO>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer
				.parseInt(currentPage));
		orderFormService.search(order_id,
				SecurityUserHolder.getCurrentUserId(), page);
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
	public ModelAndView order_return_listlog(HttpServletRequest request,
			HttpServletResponse response, String currentPage) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_return_listlog.html",
				configService.getSysConfig(), 0, request, response);
		MyPage<Map> page = new MyPage<Map>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer
				.parseInt(currentPage));
		returnGoodsLogService.selectByUser(SecurityUserHolder.getCurrentUser()
				.getId(), page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("orderFormTools", orderFormTools);

		return mv;
	}

	@SecurityMapping(title = "买家退货物流信息保存", value = "/buyer/order_return_ship_save.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_return_ship_save.htm")
	public ModelAndView order_return_ship_save(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage,
			String express_id, String expressCode) {
		ModelAndView mv = new JModelAndView("success.html",
				configService.getSysConfig(), 1, request, response);

		try {
			returnGoodsLogService.saveUserReturnExpress(CommUtil.null2Long(id),
					SecurityUserHolder.getCurrentUserId(),
					CommUtil.null2Long(express_id), expressCode);

			mv.addObject("op_title", "保存退货物流成功！");
			mv.addObject("url", CommUtil.getURL(request)
					+ "/buyer/order_return_listlog.htm");
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request)
					+ "/buyer/order_return_listlog.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "买家退货填写物流", value = "/buyer/order_returnlog_view.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/order_returnlog_view.htm")
	public ModelAndView order_returnlog_view(HttpServletRequest request,
			HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/order_returnlog_view.html",
				configService.getSysConfig(), 0, request, response);
		ReturnGoodsLogBO obj = this.returnGoodsLogService.findBOById(CommUtil
				.null2Long(id));
		User user = SecurityUserHolder.getCurrentUser();
		if (obj.getUserId().equals(user.getId())) {
			if (GoodsConstants.GOODS_RETURN_STATUS_6.equals(obj
					.getGoodsReturnStatus())
					|| GoodsConstants.GOODS_RETURN_STATUS_7.equals(obj
							.getGoodsReturnStatus())) {

				List<ExpressCompanyBO> expressCompanys = this.expressCompayService
						.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE);

				mv.addObject("expressCompanys", expressCompanys);
				mv.addObject("obj", obj);
				mv.addObject("user", user);
				OrderForm of = this.orderFormService.getObjById(obj
						.getReturnOrderId());

				mv.addObject("of", of);
				Goods goods = this.goodsService.getObjById(obj.getGoodsId());
				if (obj.getGoodsType() == GoodsConstants.GOODS_TYPE_SHOP) {
					mv.addObject("name", obj.getStoreName());
					mv.addObject("store_id", obj.getStoreId());
				} else {
					mv.addObject("name", "平台商");
				}
				if (GoodsConstants.GOODS_RETURN_STATUS_7.equals(obj
						.getGoodsReturnStatus())) {
					TransInfo transInfo = this.queryReturnshipGetData(obj);
					mv.addObject("transInfo", transInfo);
					Map map = Json.fromJson(HashMap.class,
							obj.getReturnExpressInfo());
					mv.addObject("express_company_name",
							map.get("express_company_name"));
				}

			} else {
				mv = new JModelAndView("error.html",
						configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "当前状态无法对退货服务单进行操作");
				mv.addObject("url", CommUtil.getURL(request)
						+ "/buyer/order_return_listlog.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(),
					1, request, response);
			mv.addObject("op_title", "您没有为" + obj.getReturnServiceId()
					+ "的退货服务号！");
			mv.addObject("url", CommUtil.getURL(request)
					+ "/buyer/order_return_listlog.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "物流ajax", value = "/buyer/ship_ajax.htm*", rtype = "buyer", rname = "用户中心", rcode = "user_center", rgroup = "用户中心")
	@RequestMapping("/buyer/ship_ajax.htm")
	public ModelAndView ship_ajax(HttpServletRequest request,
			HttpServletResponse response, String order_id) {
		ModelAndView mv = new JModelAndView(
				"user/default/usercenter/ship_ajax.html",
				configService.getSysConfig(), 0, request, response);
		List<TransInfo> transInfo_list = new ArrayList<TransInfo>();

		OrderForm order = this.orderFormService.getObjById(CommUtil
				.null2Long(order_id));
		TransInfo transInfo = this.orderFormTools.query_ship_getData(order);
		if (transInfo != null) {
			transInfo.setExpress_company_name(this.orderFormTools.queryExInfo(
					order.getExpressInfo(), "express_company_name"));
			transInfo.setExpress_ship_code(order.getShipCode());
			transInfo_list.add(transInfo);
		}
		if (order.getOrderMain() == 1
				&& StringUtils.isNotBlank(order.getChildOrderDetail())) {// 查询子订单的物流跟踪信息
			List<Map> maps = this.orderFormTools.queryGoodsInfo(order
					.getChildOrderDetail());
			for (Map child_map : maps) {
				OrderForm child_order = this.orderFormService
						.getObjById(CommUtil.null2Long(child_map
								.get("order_id")));
				TransInfo transInfo1 = this.orderFormTools
						.query_ship_getData(child_order);
				if (transInfo1 != null) {
					transInfo1.setExpress_company_name(this.orderFormTools
							.queryExInfo(child_order.getExpressInfo(),
									"express_company_name"));
					transInfo1.setExpress_ship_code(child_order.getShipCode());
					transInfo_list.add(transInfo1);
				}
			}

		}
		mv.addObject("transInfo_list", transInfo_list);
		return mv;
	}

	private TransInfo queryReturnshipGetData(String id) {
		ReturnGoodsLog obj = this.returnGoodsLogService.getObjById(CommUtil
				.null2Long(id));
		if (obj == null) {
			return null;
		}
		return queryReturnshipGetData(obj);
	}

	private TransInfo queryReturnshipGetData(ReturnGoodsLog obj) {

		if (this.configService.getSysConfig().getKuaidiType() == 0) {// 免费物流接口
			return transInfoService.queryShipInfo(obj.getReturnExpressInfo(),
					obj.getExpressCode(), obj.getId());
		}
		return new TransInfo();
	}

	// /////////////////////////////////////////////////////////H5订单相关
	/***
	 * H5确认订单 第一步
	 * 
	 * @param request
	 * @param response
	 * @param gcs_id
	 *            购物车ID
	 * @return
	 */
	@RequestMapping("confirm-order-page")
	public ModelAndView confirmOrderPage(HttpServletRequest request,
			HttpServletResponse response, String gcs_id, Long userId) {

		ModelAndView mv = new JModelAndView("web_mobile/confirm_order.html",
				configService.getSysConfig(), 1, request, response);

		List<Long> gcList = new ArrayList<Long>();

		GoodsCartMyVO vo = new GoodsCartMyVO();

		User user = SecurityUserHolder.getCurrentUser();

		vo.setUserId(user.getId());

		String[] gcId = null;
		if (null != gcs_id && !"".equals(gcs_id)) { // 从购物车
			gcId = gcs_id.split(",");
			for (String id : gcId) {
				gcList.add(CommUtil.null2Long(id));
			}
			vo.setIds(gcList);
		}

		List<GoodsCartBO> goodsCart = this.goodsCartService.findMyCart(vo);// 购物车信息
		mv.addObject("carts", goodsCart);
		Integer totleNo = 0;
		// 购物车商品总价格
		BigDecimal countPrice = BigDecimal.ZERO;
		Long[] goodsIdLong = new Long[goodsCart.size()];
		Map<Long, Integer> cartGoodsNumMap = new HashMap<Long, Integer>();
		Map<Long, String> specInfoMap = new HashMap<Long, String>();
		Map<Long, GoodsCartBO> goodsIDForCartMap = new HashMap<Long, GoodsCartBO>();
		Map<Long, BigDecimal> cartPriceMap = new HashMap<Long, BigDecimal>();
		for (int i = 0; i < goodsCart.size(); i++) {
			GoodsCartBO goodsCartTemp = goodsCart.get(i);
			goodsIdLong[i] = goodsCartTemp.getGoodsId();
			totleNo = totleNo + goodsCartTemp.getCount();
			cartGoodsNumMap.put(goodsIdLong[i], goodsCartTemp.getCount());
			/* 计算购物车商品总价格 */
			countPrice = countPrice.add(goodsCartTemp.getPrice().multiply(
					new BigDecimal(goodsCartTemp.getCount())));
			String specInfo = goodsCartTemp.getSpecInfo();
			if (specInfo != null && specInfo.trim().length() > 0) {
				specInfoMap.put(goodsIdLong[i], specInfo);
			}
			goodsIDForCartMap.put(goodsCartTemp.getGoodsId(), goodsCartTemp);
			BigDecimal cartPrice = goodsCartTemp.getPrice();
			cartPriceMap.put(goodsCartTemp.getGoodsId(), cartPrice);
		}
		mv.addObject("totleNo", totleNo);
		mv.addObject("cartGoodsNumMap", cartGoodsNumMap);
		mv.addObject("countPrice", countPrice);
		mv.addObject("specInfoMap", specInfoMap);
		mv.addObject("transportTools", transportTools);
		mv.addObject("cartPriceMap", cartPriceMap);
		List<GoodsBO> GoodsOfCart = this.goodsService
				.searchGoodsLikeByIds(goodsIdLong);// 购买产品集合
		/*
		 * ============= 处理商品BV值及其多规格情况下的价格 add by yuleijia on 2017.3.16
		 * ==============
		 */
		this.goodsService.handleCNGoods(null, GoodsOfCart);
		for (GoodsBO goods : GoodsOfCart) {
			Long goodsID = goods.getId();
			if (goodsIDForCartMap.containsKey(goodsID)) {
				this.goodsService.cartGoodsMulSpecHandler(
						goodsIDForCartMap.get(goodsID), goods);
			}
		}
		/* ========= 判断当前用户是否为CN用户========== */
		boolean hasCNUser = Boolean.FALSE;
		if (user != null) {
			hasCNUser = this.userAccountService.check_User_Is_CN(user.getId());
		}
		boolean hasCN = Boolean.FALSE;
		if (hasCNUser) {
			hasCN = Boolean.TRUE;
			/* 计算BV总值 */
			BigDecimal bvCount = this.goodsService.countBV(GoodsOfCart,
					cartGoodsNumMap);
			mv.addObject("bvCount", bvCount);
		}
		mv.addObject("isCN", hasCN);
		mv.addObject("goodsOfCart", GoodsOfCart);

		StringBuilder storeIdStr = new StringBuilder();
		for (int i = 0; i < GoodsOfCart.size(); i++) {

			storeIdStr.append(
					GoodsOfCart.get(i).getGoodsStoreId() == null ? "self"
							: GoodsOfCart.get(i).getGoodsStoreId()).append(",");
		}

		mv.addObject("store_id", storeIdStr);

		/*
		 * List<Address> addressList =
		 * this.addressService.queryByUserId(vo.getUserId());//收获地址
		 */List<AddressBO> addressList = this.addressService.findShopByUid(vo
				.getUserId());
		mv.addObject("addressList", addressList);
		Map erpMap = this.goodsCartService
				.calEnoughReducePrice(goodsCart, gcId);// 计算费用
		mv.addObject("order_goods_price", erpMap.get("all"));
		mv.addObject("order_er_price", erpMap.get("reduce"));
		UserCustomer customer = this.userCustomerService.findById(vo
				.getUserId());// 用户信息
		mv.addObject("customer", customer);

		mv.addObject("gcs_id", gcs_id);
		// 计算运费
		double shipFee = this.goodsCartService.countShipFee(goodsCart,
				user.getId());
		mv.addObject("shipFee", shipFee);

		return mv;
	}

	/**
	 * 确认购物车商品
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/goods_order_confirm.htm")
	public ModelAndView goods_cart1_load(HttpServletRequest request,
			HttpServletResponse response, String load_class, String gcs_id) {
		ModelAndView mv = new JModelAndView(
				"web_mobile/goods_order_confirm.html",
				configService.getSysConfig(), 1, request, response);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
				.getCurrentUserDetails();
		User user = userDetails != null ? userDetails.getUser() : null;
		Long storeId = userDetails != null ? userDetails.getStoreId() : null;

		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(
				request, response);

		List<GoodsCartBO> carts = goodsCartService.findUserCart(user, storeId,
				cart_session_id, false);

		if (carts.size() > 0) {
			List<GoodsCartBO> native_goods = new ArrayList<GoodsCartBO>();
			Map<Long, String> erString = new HashMap<Long, String>();
			for (GoodsCartBO cart : carts) {
				String[] gcId = gcs_id.split(",");
				for (String id : gcId) {
					if (String.valueOf(cart.getId()).equals(id)) {
						native_goods.add(cart);
					}
				}
			}
			mv.addObject("erString", erString);
			mv.addObject("cart", native_goods);// 无活动的商品购物车
			mv.addObject("userId", user.getId());//

			Integer totleNo = 0;
			Long[] goodsIdLong = new Long[native_goods.size()];
			for (int i = 0; i < native_goods.size(); i++) {
				goodsIdLong[i] = native_goods.get(i).getGoodsId();
				totleNo = totleNo + native_goods.get(i).getCount();
			}
			mv.addObject("totleNo", totleNo);

			// 购物车商品所属商家
			if (native_goods != null) {
				List<GoodsCartBO> store_goods = new ArrayList<GoodsCartBO>();
				store_goods = native_goods;
				for (int i = 0; i < store_goods.size(); i++) {
					for (int j = store_goods.size() - 1; j > i; j--) {
						if (store_goods.get(i).getGoods().getGoodsType() != 0
								&& store_goods.get(j).getGoods().getGoodsType() != 0) {
							if (store_goods.get(i).getStoreName()
									.equals(store_goods.get(j).getStoreName())) {
								store_goods.remove(j);
							}
						}
					}
				}
				mv.addObject("stgd", store_goods);
			}
		}
		List<AddressBO> addrs = this.addressService.findShopByUid(user.getId());
		mv.addObject("addrs", addrs);

		mv.addObject("goodsViewTools", goodsViewTools);
		return mv;
	}

	/***
	 * H5 点击立即购买
	 * 
	 * 
	 * 首先添加到购物车
	 * 
	 * 再到确认订单
	 * 
	 * @param request
	 * @param response
	 * @param goodsId
	 *            产品Id
	 * @param count
	 *            数量
	 * @param price
	 * @return
	 */
	@RequestMapping("now-buy2")
	public ModelAndView nowBuy2(HttpServletRequest request,
			HttpServletResponse response, Long id, String count, String price,
			String gsp, String buy_type, String combin_ids,
			String combin_version) {

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
				.getCurrentUserDetails();
		User user = userDetails != null ? userDetails.getUser() : null;
		Long storeId = userDetails != null ? userDetails.getStoreId() : null;

		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(
				request, response);

		/*
		 * List<GoodsCartBO>
		 * carts=goodsCartService.findUserCart(user,storeId,cart_session_id
		 * ,false);
		 */

		List<GoodsCartBO> carts = this.goodsCartService.getByUserAndGoodsId(
				user.getId(), id);//

		ModelAndView mv = new JModelAndView("web_mobile/confirm_order.html",
				configService.getSysConfig(), 1, request, response);

		Long setCartId = null;
		if (carts.size() <= 0) {
			int carId = this.goodsCartService.addGoods2(CommUtil.null2Long(id),
					count, gsp, buy_type, combin_ids, combin_version,
					cart_session_id, user, carts);
			setCartId = CommUtil.null2Long(carId);
			mv.addObject("totleNo", count);
		} else {
			setCartId = carts.get(0).getId();
			mv.addObject("totleNo", carts.get(0).getCount());
		}

		List<AddressBO> addressList = this.addressService.findShopByUid(user
				.getId());

		mv.addObject("addressList", addressList);

		BigDecimal p = new BigDecimal(price);
		BigDecimal c = new BigDecimal(count);
		BigDecimal allp = p.multiply(c).setScale(2, BigDecimal.ROUND_HALF_UP);
		mv.addObject("order_goods_price", allp);

		GoodsBO goodsBo = this.goodsService.getGoodsBOById(id);
		List<GoodsBO> list = new ArrayList();
		list.add(goodsBo);
		mv.addObject("goodsOfCart", list);
		mv.addObject("gcs_id", setCartId);
		mv.addObject("store_id", goodsBo.getGoodsStoreId() == null ? "self"
				: goodsBo.getGoodsStoreId());
		return mv;
	}

	/***
	 * 
	 * H5 确认订单 第二步，，点击提交订单
	 * 
	 * @param order_carts
	 * @param userId
	 * @param servicePath
	 * @param domain
	 * @param addr
	 *            送货地址
	 * @param transports
	 *            快递方式
	 * @param msgs
	 *            给商家的msg
	 * @param couponIds
	 *            优惠卷id
	 * @param integrals
	 *            是否积分兑购
	 * @param store_ids
	 *            所有商家id，自营为 self
	 * @param gc_ids
	 *            所有商品id
	 * @param invoiceType
	 *            发票类型
	 * @param invoice
	 *            发票抬头
	 * @param delivery_ti
	 *            \me 到时货时间，目前还没有，可空
	 * @param isMobile
	 *            是否手机端
	 * @return
	 * @throws ServiceException
	 * 
	 */
	@RequestMapping("/q/confirm-order-second")
	public ModelAndView saveOrder(String gcs_id, HttpServletRequest request,
			HttpServletResponse response, Long addrId, String store_id,
			Long userId) {
		GoodsCartMyVO vo = new GoodsCartMyVO();
		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(
				request, response);
		// vo.setCartSessionId(cart_session_id);
		User user = SecurityUserHolder.getCurrentUser();

		/*
		 * /////////////////////// 绑定手机号码 add by yuleijia
		 * ///////////////////////
		 */
		long uid = user.getId();
		UserAccountBO userAccountBo = new UserAccountBO();
		userAccountBo.setUid(uid);
		userAccountBo.setAccountType(UserContant.ACCOUNT_TYPE_4);
		UserAccount userAccount = this.userAccountService
				.findAccountByVo(userAccountBo);
		String unionId = userAccount.getLoginName(); // 微信授权后系统以unionid为loginName
		// 判断是否需要绑定手机号
		boolean isBound = this.userCustomerService
				.query_CheckWeChatBoundPhone(unionId);
		if (!isBound) {
			ModelAndView mv = new JModelAndView("boundPhone/boundPhone.html",
					configService.getSysConfig(), 1, request, response);
			String webPath = CommUtil.getURL(request);
			mv.addObject("webPath", webPath);
			return mv;
		}
		/* //////////////////////////////////////////////////////////// */

		vo.setUserId(uid);
		List<Long> gcList = new ArrayList<Long>();

		String[] gcId = null;
		if (null != gcs_id && !"".equals(gcs_id)) { // 从购物车
			gcId = gcs_id.split(",");
			for (String id : gcId) {
				gcList.add(CommUtil.null2Long(id));
			}
			vo.setIds(gcList);
		}
		vo.setIds(gcList);

		List<GoodsCartBO> order_carts = this.goodsCartService.findMyCart(vo);// 购物车信息

		System.out.println("购物车信息" + order_carts);

		// ///////////////////
		System.out.println("store_id------------>1" + store_id);
		String store_ids[] = store_id.split(","); // 购物车 商品商家ID,自营为 self
		System.out.println("store_id------------>2" + store_ids.length);

		Map<String, String> transports = Maps.newHashMap();
		Map<String, String> msgs = Maps.newHashMap();
		Map<String, Long> couponIds = Maps.newHashMap();

		for (String sid : store_ids) {
			String transport = request.getParameter("transport_" + sid);
			String msg = request.getParameter("msg_" + sid);
			String couponId = request.getParameter("coupon_id_" + sid);

			if (StringUtils.isNotBlank(transport)) {
				transports.put(sid, transport);
			}
			if (StringUtils.isNotBlank(msg)) {
				msgs.put(sid, msg);
			}
			if (StringUtils.isNotBlank(couponId)) {
				couponIds.put(sid, CommUtil.null2Long(couponId));
			}
		}

		Map<Long, String> integralIds = Maps.newHashMap();

		// 设置积分兑购参数
		for (GoodsCartBO gc : order_carts) {
			String isIntegral = request.getParameter("integral_" + gc.getId());
			if (isIntegral != null) {
				integralIds.put(gc.getId(), isIntegral);
			}
		}

		//
		List<Long> ids = Lists.newArrayList();
		String[] gc_ids = gcs_id.split(",");
		for (String gc_id : gc_ids) {
			if (StringUtils.isNotBlank(gc_id)) {
				ids.add(CommUtil.null2Long(gc_id));
			}
		}

		// 发票方式与抬头
		Integer invoiceType = CommUtil.null2Int(request
				.getParameter("invoiceType"));
		String invoice = request.getParameter("invoice");

		String servicePath = CommUtil.getURL(request);

		// //////////////////////////////////////////////////////

		ModelAndView mv = null;

		try {
			OrderFormBO bo = this.goodsCartService.createOrderForm(order_carts,
					vo.getUserId(), servicePath, addrId, transports, msgs,
					couponIds, integralIds, store_ids, gc_ids, invoiceType,
					invoice, null, false, null,null);

			// 修改订单 的相关信息
			String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
			bo.setTradeNo("order-" + trade_no + "-" + bo.getId().toString());
			PaymentBO onlinePayment = this.paymentService
					.findByMark(PaymentConstants.PAYMENT_MARK_WX_QR_PAY);
			bo.setPaymentId(onlinePayment.getId());
			bo.setPayType("online");
			this.orderFormService.update(bo);

			mv = new JModelAndView("order/cash-desk.html",
					configService.getSysConfig(), 1, request, response);
			mv.addObject("orderInfo", bo);

			mv.addObject("totalPrice", bo.getTotalPrice());
			mv.addObject("orderId", bo.getId());
			mv.addObject("orderNo", bo.getOrderId());
			mv.addObject("payType", "wxpay");
			mv.addObject("uid", userAccount.getId());
			mv.addObject("userId", userAccount.getUid());
			mv.addObject("openId", userAccount.getOpenId());

			UserAccount ac = this.userAccountService.findByUid(uid,
					UserContant.ACCOUNT_TYPE_8);
			double cnBonus = 0;
			if (null != bo.getOrderTypeFlag()
					&& bo.getOrderTypeFlag().intValue() == 2) {// 云购币订单
				double cnRepeat = 0;
				if (ac != null) {
					CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService
							.getCnUserRepeatMoney(ac.getLoginName());// 重消
					if (cnUserMoneyBO1 != null) {
						if (null != cnUserMoneyBO1.getISPAY()
								&& 1 == cnUserMoneyBO1.getISPAY().intValue()) {
							if (null != cnUserMoneyBO1.getBONUS_REPEAT()) {
								cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
							}
						}
					}
				}
				mv.addObject("cnRepeat", cnRepeat);

				mv.addObject(
						"totalPrice",
						bo.getAllygPrice()
								.add(bo.getAllCashPrice() == null ? new BigDecimal(
										0) : bo.getAllCashPrice())
								.setScale(2, BigDecimal.ROUND_HALF_UP));
			}

			if (ac != null) {
				CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService
						.getCnUserBounsMoney(ac.getLoginName());// 奖金
				if (cnUserMoneyBO != null) {
					if (null != cnUserMoneyBO.getISPAY()
							&& 1 == cnUserMoneyBO.getISPAY().intValue()) {
						if (null != cnUserMoneyBO.getBONUS()) {
							cnBonus = cnUserMoneyBO.getBONUS();
						}
					}
				}

			}
			mv.addObject("cnBonus", cnBonus);

			UserCustomerBO customer = customerService
					.findSessionUser(SecurityUserHolder.getCurrentUserId());
			mv.addObject("customer", customer);

		} catch (ServiceException e) {

			mv = new JModelAndView("order/confirm_order_error.html",
					configService.getSysConfig(), 1, request, response);
			mv.addObject("message", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/goods_cart1.htm");
		}

		return mv;
	}

	/***
	 * 
	 * H5 订单列表,去支付,到云尚 收银台
	 * 
	 * @param request
	 * @param response
	 * @param payType
	 * @param orderId
	 * @return 云尚收银台页面
	 */
	@RequestMapping("cach-desk")
	public ModelAndView cashDesk(HttpServletRequest request,
			HttpServletResponse response, MyPage<OrderFormBO> page,
			String orderId, String code) {

		ModelAndView mv = new JModelAndView("order/cash-desk.html",
				configService.getSysConfig(), 1, request, response);
		OrderFormBO obj = this.orderFormService.findByOrderNo(orderId);

		mv.addObject("orderId",obj.getId());
		mv.addObject("orderNo", obj.getOrderId());
		mv.addObject("totalPrice", obj.getTotalPrice());
		mv.addObject("orderInfo", obj);
		UserAccount userAccount = this.userAccountService.findByUid(
				obj.getUserId(), UserContant.ACCOUNT_TYPE_4);
		mv.addObject("openId", userAccount.getOpenId());
		double cnBonus = 0;
		double cnRepeat = 0;
		UserAccount ac = this.userAccountService.findByUid(obj.getUserId(),
				UserContant.ACCOUNT_TYPE_8);
		
		if (obj.getOrderTypeFlag() == 2) {
				CnUserMoneyBO cnUserMoneyBO1 = this.cnPayBaseService
						.getCnUserRepeatMoney(ac.getLoginName());// 重消
				if (cnUserMoneyBO1 != null) {
					if (null != cnUserMoneyBO1.getISPAY()
							&& 1 == cnUserMoneyBO1.getISPAY().intValue()) {
						if (null != cnUserMoneyBO1.getBONUS_REPEAT()) {
							cnRepeat = cnUserMoneyBO1.getBONUS_REPEAT();
						}
					}
				}
				mv.addObject("cnRepeat", cnRepeat);
				
				mv.addObject(
						"totalPrice",
						obj.getAllygPrice()
								.add(obj.getAllCashPrice() == null ? new BigDecimal(
										0) : obj.getAllCashPrice())
								.setScale(2, BigDecimal.ROUND_HALF_UP));
			}
			
		if (ac != null) {
			CnUserMoneyBO cnUserMoneyBO = this.cnPayBaseService
					.getCnUserBounsMoney(ac.getLoginName());// 奖金
				if (cnUserMoneyBO != null) {
					if (null != cnUserMoneyBO.getISPAY()
							&& 1 == cnUserMoneyBO.getISPAY().intValue()) {
						if (null != cnUserMoneyBO.getBONUS()) {
							cnBonus = cnUserMoneyBO.getBONUS();
						}
					}
				}
			}
			
			UserCustomerBO customer = customerService
					.findSessionUser(SecurityUserHolder.getCurrentUserId());
			mv.addObject("customer", customer);
			mv.addObject("cnBonus", cnBonus);
		
		return mv;
	}

	/****
	 * 微信 公众号支付 统一下单
	 * 
	 * 在云尚收银台点击 ---微信支付
	 * 
	 * 跳转到微信充值页面
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("weixinwapPay")
	public ModelAndView weixinwapPay(HttpServletRequest request,
			HttpServletResponse response, String totalPrice, String orderId,
			Integer sellerId, String body, String amount, String openId) {

		User user = SecurityUserHolder.getCurrentUser();
		ModelAndView mv = new JModelAndView("order/weixin-recharge.html",
				configService.getSysConfig(), 1, request, response);

		// body = "订单充值-"+ orderId.toString();
		body = "云尚大健康-产品";
		// 修改订单 的相关信息
		OrderFormBO order = this.orderFormService.findByOrderNo(orderId);// 根据订单id查询
		String trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		order.setTradeNo("order-" + trade_no + "-" + order.getId().toString());
		PaymentBO onlinePayment = this.paymentService
				.findByMark(PaymentConstants.PAYMENT_MARK_WX_QR_PAY);
		order.setPaymentId(onlinePayment.getId());
		order.setPayType("online");
		this.orderFormService.update(order);
		// 修改结束

		try {
			// body = new String(body.getBytes("iso-8859-1"),"UTF-8");
			URLEncoder.encode(body, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String timestamp = Sha1Util.getTimeStamp();
		String nonceStr = RandomStringUtils.randomAlphabetic(16);

		UserAccount res = this.userAccountService.findByUid(user.getId(), "4");
		// 统一下单
		String ip = "123.12.12.123";
		Map map = this.weiXinPayWapService.weixinWapPay(amount, body, ip,
				sellerId, orderId, openId);

		if (map != null) {

			String code_url = (String) map.get("code_url");

			/*
			 * String appid = (String) map.get("appid"); String nonce_str =
			 * (String) map.get("nonce_str"); String prepay_id = (String)
			 * map.get("prepay_id");
			 * 
			 * mv.addObject("appid", appid); mv.addObject("nonce_str",
			 * nonce_str); mv.addObject("prepay_id", "prepay_id="+prepay_id);
			 * mv.addObject("totalPrice", amount); mv.addObject("timeStamp",
			 * timestamp); String paySign =
			 * this.weiXinPayWapService.getPaySign(timestamp, prepay_id,
			 * nonceStr); mv.addObject("paySign", paySign);
			 * System.out.println(appid + nonce_str + prepay_id + paySign +
			 * amount + timestamp);
			 */
			String qrcode = QRCodeUtils.encodeQrcode(code_url);
			mv.addObject("qrcode", qrcode);
			mv.addObject("type", "goods");
			mv.addObject("orderId", orderId);
			mv.addObject("totalPrice", totalPrice);
		}

		return mv;
	}

	/***
	 * TODO
	 * 
	 * H5 微信支付 检查用户OpenId
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("check-openId")
	public void checkUserOpenId(HttpServletRequest request,
			HttpServletResponse response, String orderId, String totalPrice) {
		User user = SecurityUserHolder.getCurrentUser();
		// WxInvitationRelationBO res =
		// this.weiXinPayWapService.getUserWxAuth(user.getId());
		UserAccount res = this.userAccountService.findByUid(user.getId(),
				UserContant.ACCOUNT_TYPE_4);
		// this.userAccountService.findLastLogin(user.getId());
		String openId = "";

		if (res != null) {
			// openId = res.getOpenId();
			openId = CommUtil.null2String(res.getOpenId());
		}

		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		out.print(openId);
		out.flush();
		out.close();
	}

	/***
	 * 微信 跳转到授权页面
	 * 
	 * 微信H5点击支付
	 * 
	 * @param amount
	 * @param body
	 * @param ip
	 * @param sellerId
	 * 
	 *            验证授权页面 ，，，， 授权后 回到 云尚 收银台页面 并且 获取 code
	 * 
	 *            调到微信授权页面,点击授权,得到code ---
	 * 
	 */

	@RequestMapping("getWxCode")
	public String getWxCode() {

		String appId = "wx768e007b4c5d6817";
		/* String jumpToUrl = "http://mobile.ysysgo.com/"; */
		String jumpToUrl = "http://localhost:8080/carnation-web-mobile/weixinwapPay";// 授权之后跳转的页面
		String jumpToUrl2 = "http://localhost:8080/carnation-web-mobile/weixinwapPay";// 授权之后跳转订单列表页面
		String requestUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?";// 获取code
																					// 提交路径

		StringBuilder redirectUrl = new StringBuilder(requestUrl);
		redirectUrl.append(String.format("appid=%s", appId));
		redirectUrl.append(String.format("&redirect_uri=%s",
				URLEncoder.encode(jumpToUrl)));
		redirectUrl.append("&response_type=code");
		redirectUrl.append("&scope=snsapi_base");
		redirectUrl.append("&state=123");
		redirectUrl.append("&#wechat_redirect");
		System.out.println(redirectUrl.toString());
		return "redirect:" + redirectUrl;

	}

	/***
	 * 根据 code 获取OpenId
	 * 
	 * @param code
	 * @return
	 */
	public Map<String, String> getOpenId(String code) {
		Map<String, String> map = null;
		String appId = "wx768e007b4c5d6817";
		String appSecret = "DSADASDASDASD";

		String requestUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";

		Map<String, String> params = Maps.newHashMap();
		params.put("appid", appId);
		params.put("secret", appSecret);
		params.put("code", code);
		params.put("grant_type", "authorization_code");

		try {
			String jsonStr = WebUtils.doGet(requestUrl, params);

			Map mapJson = JSON.parseObject(jsonStr, Map.class);
			if (mapJson.get("errcode") == null
					|| StringUtils.isBlank(mapJson.get("errcode").toString())) {
				map = new HashMap<String, String>();
				map.put("openid", mapJson.get("openid").toString());
				map.put("access_token", mapJson.get("access_token").toString());
			} else {
				System.out.println("获取openId错误" + jsonStr);
			}

		} catch (Exception e) {
			System.out.println("获取openId异常" + CommUtil.getStackTrace(e));
		}
		return map;
	}

	/***
	 * 微信 公众号支付 下单
	 * 
	 * @param request
	 * @param response
	 * @param amount
	 * @param body
	 * @param ip
	 * @param sellerId
	 * @param orderId
	 * @param openId
	 * @return
	 */
	@RequestMapping("weixinWapPayCreateOrder")
	public ModelAndView weixinWapPay(HttpServletRequest request,
			HttpServletResponse response, String amount, String body,
			String ip, Integer sellerId, String orderId, String openId) {

		ModelAndView mv = new JModelAndView("order/wei-recharge.html",
				configService.getSysConfig(), 1, request, response);
		/*
		 * body = orderId; //修改订单 的相关信息 OrderFormBO order =
		 * this.orderFormService.findByOrderNo(orderId);//根据订单id查询 String
		 * trade_no = CommUtil.formatTime("yyyyMMddHHmmss", new Date());
		 * order.setTradeNo("order-" + trade_no + "-" +
		 * order.getId().toString()); PaymentBO onlinePayment =
		 * this.paymentService.findByMark(PaymentConstants.PAYMENT_MARK_WX_PAY);
		 * order.setPaymentId(onlinePayment.getId());
		 * order.setPayType("online"); this.orderFormService.update(order);
		 * //修改结束
		 * 
		 * try { body = new String(body.getBytes("iso-8859-1"),"UTF-8"); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); }
		 * 
		 * 
		 * 
		 * String timestamp = Sha1Util.getTimeStamp(); User user =
		 * SecurityUserHolder.getCurrentUser(); UserAccount res =
		 * this.userAccountService.findByUid(user.getId(), "4"); //统一下单 ip =
		 * "192.168.1.12"; Map map =
		 * this.weiXinPayWapService.weixinWapPay(amount, body, ip, sellerId,
		 * orderId, openId);
		 * 
		 * if(map != null){
		 * 
		 * String appid = (String) map.get("appId"); String nonce_str = (String)
		 * map.get("nonce_str"); String prepay_id = (String)
		 * map.get("prepay_id"); String sing = (String) map.get("sign");
		 * 
		 * mv.addObject("appid", appid); mv.addObject("nonce_str", nonce_str);
		 * mv.addObject("prepay_id", "prepay_id="+prepay_id);
		 * mv.addObject("sing", sing); mv.addObject("flag", "succ");
		 * mv.addObject("totalPrice", amount); mv.addObject("timeStamp",
		 * timestamp); }
		 */
		return mv;
	}

	/***
	 * 微信充值结果回调
	 * 
	 * 接受微信充值返回结果
	 * 
	 * 并且，返回给微信 已经 接收到
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("weixinWapPayNotify")
	public void weixinWapPayNotify(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		InputStream inStream = request.getInputStream();
		ByteArrayOutputStream outSteam = new ByteArrayOutputStream();

		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outSteam.write(buffer, 0, len);
		}

		outSteam.close();
		inStream.close();

		String info = new String(outSteam.toByteArray(), "utf-8");

		// String returnInfo = this.weiXinPayWapService.getNotifyInfo(info);

		String returnInfo = this.getNotifyInfo(info);
		PrintWriter out = response.getWriter();
		out.print(returnInfo);
		out.flush();
		out.close();
	}

	/***
	 * H5订单列表
	 * 
	 */
	@RequestMapping("order-list")
	public ModelAndView orderList(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "orderStatus", defaultValue = "all") String orderStatus,
			MyPage<OrderFormBO> page) {
		ModelAndView mv = null;
		User user = SecurityUserHolder.getCurrentUser();
		if (user != null) {
			mv = new JModelAndView("order/order_list.html",
					configService.getSysConfig(), 1, request, response);
			page.setPageSize(100);
			Integer yungouFlag = 0;// 增加订单查询
			orderFormService.queryByCnd(user.getId(), "", "", "", orderStatus,
					page, yungouFlag);

			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			mv.addObject("order_status", orderStatus);
			mv.addObject("orderFormTools", orderFormTools);
			mv.addObject("currentPage", page.getCurrentPage());
		} else {
			mv = new JModelAndView("order/order_list.html",
					configService.getSysConfig(), 1, request, response);
		}
		return mv;
	}

	/****
	 * 订单详情
	 * 
	 * @param request
	 * @param response
	 * @param orderId
	 * @return
	 */
	@RequestMapping("order-detail")
	public ModelAndView orderDetile(HttpServletRequest request,
			HttpServletResponse response, String orderId) {

		ModelAndView mv = new JModelAndView("order/order_detail.html",
				configService.getSysConfig(), 1, request, response);

		OrderFormBO obj = this.orderFormService.fetch(CommUtil
				.null2Long(orderId));

		/*
		 * if(obj.getOrderMain() == 1 &&
		 * !CommUtil.null2String(obj.getChildOrderDetail()).equals("")){
		 * List<Map> maps =
		 * this.orderFormTools.queryGoodsInfo(obj.getChildOrderDetail()); List
		 * childOrderList = new ArrayList(); for (Map child_map : maps) {
		 * OrderForm child_order =
		 * this.orderFormService.getObjById(CommUtil.null2Long
		 * (child_map.get("order_id"))); if
		 * (!CommUtil.null2String(child_order.getShipCode()).equals("")) {
		 * System.out.println("已经发货"); } childOrderList.add(child_order); } }
		 */
		User user = SecurityUserHolder.getCurrentUser();
		boolean hasCNUser = Boolean.FALSE;
		if (user != null) {
			hasCNUser = this.userAccountService.check_User_Is_CN(user.getId());
		}
		mv.addObject("isCN", hasCNUser);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("obj", obj);
		return mv;
	}

	/***
	 * H5取消订单
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("cancel-order")
	public void cancelOrder(String id, RedirectAttributes redirectAttributes,
			HttpServletResponse response) {
		OrderForm form = new OrderForm();
		form.setOrderStatus(0);// 状态为0取消订单
		form.setId(CommUtil.null2Long(id));

		boolean bl = this.orderFormService.update(form);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(bl);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/***
	 * H5 点击立即购买
	 * 
	 * 首先添加到购物车
	 * 
	 * 再到确认订单
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param count
	 * @param price
	 * @param gsp
	 * @param buy_type
	 * @param combin_ids
	 * @param combin_version
	 * @return
	 */
	@RequestMapping("now-buy")
	public ModelAndView nowBuy(HttpServletRequest request,
			HttpServletResponse response, Long id, String count, String price,
			String gsp, String buy_type, String combin_ids,
			String combin_version) {

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
				.getCurrentUserDetails();
		User user = userDetails != null ? userDetails.getUser() : null;
		Long storeId = userDetails != null ? userDetails.getStoreId() : null;
		String cart_session_id = this.goodsCaseViewTools.getCartSessionId(
				request, response);

		ModelAndView mv = new JModelAndView("web_mobile/confirm_order.html",
				configService.getSysConfig(), 1, request, response);

		// 先购物车的是否有这个产品
		List<GoodsCartBO> carts = this.goodsCartService.getByUserAndGoodsId(
				user.getId(), id);//

		List<AddressBO> addressList = this.addressService.findShopByUid(user
				.getId());// 收货地址
		mv.addObject("addressList", addressList);

		Integer buyCount = 0;
		Long setCartId = null;
		Map<Long, Integer> cartGoodsNumMap = new HashMap<Long, Integer>();
		Map<Long, String> specInfoMap = new HashMap<Long, String>();
		GoodsCartBO goodsCart = null;
		if (carts.size() <= 0) { // 购物车没有存放这个产品,现在添加

			int carId = this.goodsCartService.addGoods2(CommUtil.null2Long(id),
					count, gsp, buy_type, combin_ids, combin_version,
					cart_session_id, user, carts);

			setCartId = CommUtil.null2Long(carId);// 添加购物车的后返回购物车cartId
			mv.addObject("totleNo", count); // 购买总数量totalCount
			buyCount = Integer.parseInt(count);

			goodsCart = this.goodsCartService.findMyByIdCart(new Long(carId));
			List<GoodsCartBO> cart = new ArrayList();
			cart.add(goodsCart);
			double shipFee = this.goodsCartService.countShipFee(cart,
					user.getId());
			mv.addObject("shipFee", shipFee);

		} else {
			goodsCart = carts.get(0);
			setCartId = goodsCart.getId();
			mv.addObject("totleNo", carts.get(0).getCount());
			buyCount = carts.get(0).getCount();
			List<GoodsCartBO> cart = new ArrayList();
			cart.add(goodsCart);
			double shipFee = this.goodsCartService.countShipFee(cart,
					user.getId());
			mv.addObject("shipFee", shipFee);
		}
		if (goodsCart != null) {
			String specInfo = goodsCart.getSpecInfo();
			Long goodsID = goodsCart.getGoods().getId();
			if (specInfo != null && specInfo.trim().length() > 0) {
				specInfoMap.put(goodsID, specInfo);
			}
		}
		cartGoodsNumMap.put(CommUtil.null2Long(id), buyCount);
		BigDecimal p = new BigDecimal(price);
		BigDecimal c = new BigDecimal(buyCount);
		BigDecimal allp = p.multiply(c).setScale(2, BigDecimal.ROUND_HALF_UP);
		Map<Long, BigDecimal> cartPriceMap = new HashMap<Long, BigDecimal>();
		cartPriceMap.put(id, new BigDecimal(price));
		mv.addObject("cartPriceMap", cartPriceMap);
		mv.addObject("order_goods_price", allp);
		mv.addObject("cartGoodsNumMap", cartGoodsNumMap);
		mv.addObject("countPrice", allp);
		mv.addObject("specInfoMap", specInfoMap);

		ZeroGoods zeroGoods = this.zeroGoodsService.getByGoodsId(id);// ////0元购
		if (null != zeroGoods && zeroGoods.getGoodsStatus()) {
			mv.addObject("zeroFlag", 1);
			mv.addObject("zeroShipFee", zeroGoods.getShipFee());
		}

		GoodsBO goodsBo = this.goodsService.getGoodsBOById(id);
		List<GoodsBO> goodsList = new ArrayList<GoodsBO>();
		goodsList.add(goodsBo);
		/*
		 * ============= 处理商品BV值及其多规格情况下的价格 add by yuleijia on 2017.3.16
		 * ==============
		 */
		this.goodsService.handleCNGoods(goodsBo, null);
		// 购物车商品多规格属性的处理，根据购物车所选定规格初始化商品的BV值
		this.goodsService.cartGoodsMulSpecHandler(goodsCart, goodsBo);

		/* ========= 判断当前用户是否为CN用户========== */
		boolean hasCNUser = Boolean.FALSE;
		if (user != null) {
			hasCNUser = this.userAccountService.check_User_Is_CN(user.getId());
		}
		boolean hasCN = Boolean.FALSE;
		if (hasCNUser) {
			hasCN = Boolean.TRUE;
			/* 计算BV总值 */
			BigDecimal bvCount = this.goodsService.countBV(goodsList,
					cartGoodsNumMap);
			mv.addObject("bvCount", bvCount);
		}
		mv.addObject("isCN", hasCN);

		List<GoodsBO> list = new ArrayList();
		list.add(goodsBo);
		mv.addObject("goodsOfCart", list);// 购物车产品信息
		mv.addObject("exPressTransFee", goodsBo.getExpressTransFee());
		mv.addObject("gcs_id", setCartId);// 购物车ID
		mv.addObject("store_id", goodsBo.getGoodsStoreId() == null ? "self"
				: goodsBo.getGoodsStoreId());// 购物车产品商店
		return mv;
	}

	@RequestMapping("finished-buy")
	public ModelAndView finishedBuy(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("zeroShop/zero_download.html",
				configService.getSysConfig(), 1, request, response);
		return mv;
	}

	/**
	 * 
	 * @param type
	 * @param order_no
	 * @return
	 * @throws ServiceException
	 */
	private Object doPayHandle(String type, String tradeNo, double totalFee,
			String orderNo, String paymentType) throws ServiceException {

		String logInfo = null;
		switch (paymentType) {
		case PaymentConstants.PAYMENT_MARK_ALIPAY:
			logInfo = "支付宝在线支付";
			break;
		case PaymentConstants.PAYMENT_MARK_ALIPAY_APP:
			logInfo = "支付宝在线支付";
			break;
		case PaymentConstants.PAYMENT_MARK_ALIPAY_WAP:
			logInfo = "支付宝在线支付";
			break;
		case PaymentConstants.PAYMENT_MARK_WX_APP:
			logInfo = "微信在线支付";
			break;
		case PaymentConstants.PAYMENT_MARK_WX_PAY:
			logInfo = "微信网页支付";
			break;
		case PaymentConstants.PAYMENT_MARK_WX_QR_PAY:
			logInfo = "微信扫码支付";
			break;
		case PaymentConstants.PAYMENT_MARK_MCH_WX_QR_PAY:
			logInfo = "微信在线支付";
			break;
		}

		if (type.equals("goods")) {
			OrderForm orderForm = this.orderFormService.completePay(
					CommUtil.null2Long(orderNo), tradeNo, logInfo);
			return orderForm;
		}
		if (type.equals("group")) {
			groupOrderService.generate_groupInfos(orderNo, paymentType,
					logInfo, tradeNo);

			return groupOrderService.getObjById(CommUtil.null2Long(orderNo));
		}
		if (type.equals("cash")) {
			Predeposit predeposit = moneyService.rechargeMoney(
					CommUtil.null2Long(orderNo), logInfo);
			if (predeposit.getPdOrderId() == null) {
				return predeposit;
			} else {
				if (PaymentConstants.ORDER_TYPE_GOODS.equals(predeposit
						.getPdOrderType())) {
					// 如果充值有支付订单，进行云豆支付订单
					OrderForm orderForm = orderFormService.completeMoneyPay(
							predeposit.getPdOrderId(), null, "");
					return orderForm;

				} else if (PaymentConstants.ORDER_TYPE_INTEGRAL
						.equals(predeposit.getPdOrderType())) {
					// 有需要支付的积分定单
					IntegralGoodsOrder igOrder = this.integralGoodsOrderService
							.completeMoneyPay(predeposit.getPdOrderId(), null);
					return igOrder;
				} else if (PaymentConstants.ORDER_TYPE_GROUP.equals(predeposit
						.getPdOrderType())) {
					// 如果充值有支付订单，进行云豆支付订单
					long uid = groupOrderService.getObjById(
							predeposit.getPdOrderId()).getUserId();
					GroupOrderBO go = groupOrderService.orderPay(null,
							predeposit.getPdOrderId(), uid, true, null, null);

					return go;
				}
			}
		}

		if (type.equals("integral")) {
			IntegralGoodsOrder igOrder = this.integralGoodsOrderService
					.completePay(CommUtil.null2Long(orderNo), paymentType);
			return igOrder;
		} else if (type.equals("mchWxQrPay") || type.equals("mchAliQrPay")) {
			ShopQrPayOrderBO bo = shopQrPayOrderService
					.complateOrderByPayOrderNo(orderNo, tradeNo);
			return bo;
		}

		return null;
	}

	/***
	 * 解析 充值返回结果
	 * 
	 * @param resInfo
	 * @return
	 */
	public String getNotifyInfo(String resInfo) {

		StringBuffer bf = new StringBuffer();
		Document document = null;
		try {
			document = DocumentHelper.parseText(resInfo);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element root = document.getRootElement();
		String returnCode = root.element("return_code").getText().toString();

		if (returnCode.equals("SUCCESS")) {
			bf.append("<xml><return_code><![CDATA[SUCCESS]]></return_code>");
			bf.append("<return_msg><![CDATA[OK]]></return_msg></xml>");

			String tradeNo = root.element("transaction_id").getText()
					.toString();
			String totalFee = root.element("total_fee").getText().toString();

			String order_no = "";
			String[] order_nos = root.element("out_trade_no").getText()
					.toString().split("-");// 获取订单表的ID
			order_no = order_nos[2];

			try {

				this.doPayHandle("goods", tradeNo,
						Double.parseDouble(totalFee), order_no,
						PaymentConstants.PAYMENT_MARK_WX_PAY);

			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		return bf.toString();
	}

	// //////////////////////////////////////////////////云购币支付

	/***
	 * 
	 * 云购币订单支付、
	 * 
	 * @param request
	 * @param response
	 * @param payType
	 *            微信支付参数 wxpay
	 * @param orderId
	 *            订单ID
	 * @param isAvailableBalance
	 *            是否使用云豆支付
	 * @param paymentPassword
	 *            云豆支付密码
	 * @param isYunGouMoney
	 *            是否云购币订单
	 * @param yunGouPassword
	 *            云购币密码 和云豆密码相同
	 * @param isBonusPay
	 *            是否使用奖金 [忽略]
	 * @param orderNo
	 *            订单编号
	 * @param openId
	 * @throws ServiceException
	 */
	@RequestMapping("/q/order_yg_pay.htm")
	public void order_pay(HttpServletRequest request,
			HttpServletResponse response, String payType, String orderId,
			boolean isAvailableBalance, String paymentPassword,
			boolean isYunGouMoney, String yunGouPassword, boolean isBonusPay,
			String orderNo, String openId, Integer orderFlag)
			throws ServiceException {
		OrderForm checkOrder = this.orderFormService.getObjById(CommUtil
				.null2Long(orderId));
		if (checkOrder.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
			Log.info("订单已完成");
			throw new ServiceException("订单支付完成");
		}

		Long uid = SecurityUserHolder.getCurrentUserId();
		UserAccount ac = this.userAccountService.findByUid(uid,
				UserContant.ACCOUNT_TYPE_8);
		String accountType = "0";
		if (null != ac) {
			accountType = UserContant.ACCOUNT_TYPE_8;
		}

		boolean bl = this.orderFormService.checkOrderisPay(checkOrder
				.getActualygPrice());

		OrderFormBO order = this.orderFormService.fetch(CommUtil
				.null2Long(orderId));
		try {

			if (orderFlag != null && orderFlag.intValue() == 2) {// 普通订单支付

				order = this.orderFormService.balancePayForH5(
						CommUtil.null2Long(orderId), uid, isAvailableBalance,
						paymentPassword, accountType, payType);

			} else {

				if (bl && StringUtils.isBlank(payType) && isYunGouMoney) { // 云购币支付[非专区]
					// 和
					// 云购币+
					// 奖金支付
					order = this.orderFormService.orderPay(payType,
							CommUtil.null2Long(orderId), uid,
							isAvailableBalance, paymentPassword, isYunGouMoney,
							paymentPassword, accountType, isBonusPay);
					/*
					 * PaymentBO onlinePayment = this.paymentService
					 * .findByMark(PaymentConstants.PAYMENT_MARK_YG_BALANCE);
					 * order.setPaymentId(onlinePayment.getId());
					 * this.orderFormService.update(order);
					 */
				}

				if (bl && StringUtils.isNotBlank(payType) && isYunGouMoney) {// 云购币+微信[未支付的]
					OrderForm orderForm = this.orderFormService
							.yungouMoneyAndCashForH5(
									CommUtil.null2Long(orderId), uid,
									paymentPassword);
					order = mapper.map(orderForm, OrderFormBO.class);
					PaymentBO onlinePayment = this.paymentService
							.findByMark(PaymentConstants.PAYMENT_MARK_YG_JSWX);
					order.setPaymentId(onlinePayment.getId());
					this.orderFormService.update(order);
				}

			}

			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				Log.info("订单已完成");
				CommUtil.returnBody(response,
						Json.toJson(ActionResult.ReturnCode(3)));
			}

			if (StringUtils.isNotBlank(payType)
					&& order.getOrderStatus() < OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {

				String webPath = configService.getSysConfig().getAddress();

				if (payType.equals("wxpay")) // 微信支付
				{
					OrderFormBO obj = this.orderFormService
							.findByOrderNo(orderNo);
					// BigDecimal money =
					// CommUtil.null2BigDecimal(obj.getTotalPrice());
					Double subtractAmount = 0.0;
					if (obj.getOrderTypeFlag() != null
							&& obj.getOrderTypeFlag() == 2) {//云购币订单
						subtractAmount = this.orderFormService.subtractOrderNeedAmount(CommUtil.null2Long(orderId));
								
										

					} else if (orderFlag != null && orderFlag.intValue() == 2 && isAvailableBalance //普通订单云豆+微信组合支付
							&& StringUtils.isNotBlank(payType)) {
						subtractAmount = CommUtil
								.null2Double(obj
										.getTotalPrice()
										.subtract(
												obj.getActualygPrice() == null ? new BigDecimal(
														0) : obj
														.getActualygPrice()));
					} else {
						subtractAmount = CommUtil.null2Double(obj.getTotalPrice());//普通订单
					}

					PayH5QrCode resOrder = payTools.mchWxQrPayOrder(webPath,
							CommUtil.null2BigDecimal(subtractAmount),
							obj.getOrderId(), obj.getTradeNo(), openId);

					CommUtil.returnBody(response,
							Json.toJson(ActionResult.NewSuccess(resOrder)));
				}
			}

		} catch (ServiceException e) {
			CommUtil.returnBody(response,
					Json.toJson(ActionResult.NewFail(e.getErrorCode())));
		}

	}

}
