package vc.thinker.b2b2c.action.self;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.nutz.json.Json;
import org.nutz.json.JsonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.sinco.carnation.express.service.ExpressCompanyCommonService;
import com.sinco.carnation.express.service.ExpressInfoService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.kuaidi100.pojo.TaskRequest;
import com.sinco.carnation.kuaidi100.pojo.TaskResponse;
import com.sinco.carnation.kuaidi100.post.HttpRequest;
import com.sinco.carnation.kuaidi100.post.JacksonHelper;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.OrderTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.ship.service.ShipAddressService;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.ShipAddressConstants;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.ExpressInfo;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title: OrderSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description: 自营商品订单管理器，显示所有自营商品订单，添加权限的管理员都可进行管理。
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
 * @date 2014年4月24日
 * 
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class SelfOrderManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private ShipAddressService shipAddressService;
	@Autowired
	private ExpressCompanyCommonService expressCompanyCommonService;
	@Autowired
	private ExpressInfoService expressInfoService;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private OrderTools orderTools;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private TransInfoService transInfoService;
	
	@Autowired
	private PaymentService paymentService;

	private static final BigDecimal WHETHER_ENOUGH = new BigDecimal(0.00);
	@SuppressWarnings("serial")
	private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {
		{
			put(0, "已取消");
			put(10, "待付款");
			put(15, "线下支付待审核");
			put(16, "货到付款待发货");
			put(20, "已付款");
			put(30, "已发货");
			put(40, "已收货");
			put(50, "已完成");
			put(60, "已结束");
		}
	};

	@SuppressWarnings({"unused", "serial"})
	private static final Map<String, String> PAYMENT_MAP = new HashMap<String, String>() {
		{
			put(null, "未支付");
			put("", "未支付");
			put("alipay", "支付宝");
			put("alipay_wap", "手机网页支付宝");
			put("alipay_app", "手机支付宝APP");
			put("tenpay", "财付通");
			put("bill", "快钱");
			put("chinabank", "网银在线");
			put("outline", "线下支付");
			put("balance", "预存款支付");
			put("payafter", "货到付款");
			put("paypal", "paypal");
		}
	};

	@SuppressWarnings("unused")
	private static final Map<Long, String> PAYMENT_ID_MAP = new HashMap<Long, String>() {
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = -2560836981535067317L;
		{
			put(null, "未支付");
			put(0L, "未支付");
			put(1L, "云豆支付");
			put(2L, "支付宝");
			put(3L, "手机网页支付宝");
			put(4L, "手机支付宝APP");
			put(5L, "财付通");
			put(6L, "快钱");
			put(7L, "网银在线");
			put(8L, "paypal");
			put(9L, "微信App支付");
			put(10L, "微信Wap支付");

			put(12L, "微信扫码支付");
			put(13L, "网银支付");
			put(14L, "信用卡支付");
			put(15L, "商家微信扫码支付");
			put(16L, "云购币支付");
			put(17L, "云购币+微信扫码支付");
			put(18L, "云购币+支付宝");
			put(19L, "云购币支+工资支付");
			put(20L, "云购币支+充值支付");
		}
	};

	@SuppressWarnings("serial")
	private static final Map<String, String> TYPE_MAP = new HashMap<String, String>() {
		{
			put(null, "PC订单");
			put("", "PC订单");
			put("weixin", "微信订单");
			put("android", "Android订单");
			put("ios", "IOS订单");
		}
	};

	@SecurityMapping(title = "自营订单列表", value = "/admin/self_order.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/self_order.htm")
	public ModelAndView self_order(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OrderFormBO> page, OrderFormVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/self_order.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(10);
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		this.orderFormService.findPageByVo(page, vo);
		if (vo.getOrderStatus() == null || vo.getOrderStatus().equals("")) {
			vo.setOrderStatus("all");
		}
		mv.addObject("vo", vo);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		mv.addObject("orderFormTools", orderFormTools);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "自营待发货订单列表", value = "/admin/self_order_ship.htm*", rtype = "admin", rname = "发货管理", rcode = "order_ship", rgroup = "商城管理")
	@RequestMapping("/admin/self_order_ship.htm")
	public ModelAndView self_order_ship(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OrderFormBO> page, OrderFormVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/self_order_ship.html", configService.getSysConfig(),
				0, request, response);
		vo.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_PAY);
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		this.orderFormService.findPageByVo(page, vo);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "自营待发货订单详情", value = "/admin/ship_order_view.htm*", rtype = "admin", rname = "发货管理", rcode = "order_ship", rgroup = "商城管理")
	@RequestMapping("/admin/ship_order_view.htm")
	public ModelAndView ship_order_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/ship_order_view.html", configService.getSysConfig(),
				0, request, response);
		OrderFormBO obj = this.orderFormService.fetch(CommUtil.null2Long(id));
		if (obj.getOrderCat() == 1) {
			mv = new JModelAndView("admin/blue/order_recharge_view.html", configService.getSysConfig(),
			/* this.userConfigService.getUserConfig(), */0, request, response);
		} else {
			mv.addObject("obj", obj);
		}
		mv.addObject("express_company_name",
				this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("obj", obj);
		mv.addObject("view_type", "self");
		return mv;
	}

	@SecurityMapping(title = "自营待收货订单列表", value = "/admin/self_order_confirm.htm*", rtype = "admin", rname = "收货管理", rcode = "order_confirm", rgroup = "商城管理")
	@RequestMapping("/admin/self_order_confirm.htm")
	public ModelAndView self_order_confirm(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<OrderFormBO> page, OrderFormVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/self_order_confirm.html",
				configService.getSysConfig(), 0, request, response);
		vo.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_NO_TAKE_DELIVERY);
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		this.orderFormService.findPageByVo(page, vo);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("orderTools", this.orderTools);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		return mv;
	}

	@SecurityMapping(title = "自营待收货订单详情", value = "/admin/confirm_order_view.htm*", rtype = "admin", rname = "收货管理", rcode = "order_confirm", rgroup = "商城管理")
	@RequestMapping("/admin/confirm_order_view.htm")
	public ModelAndView confirm_order_view(HttpServletRequest request, HttpServletResponse response,
			String id, String view_type) {
		ModelAndView mv = new JModelAndView("admin/blue/confirm_order_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj.getOrderCat() == OrderFormConstants.ORDER_CAT_MOBILE) {
			mv = new JModelAndView("admin/blue/order_recharge_view.html", configService.getSysConfig(),
			/* this.userConfigService.getUserConfig(), */0, request, response);
		} else {
			mv.addObject("obj", obj);
		}
		mv.addObject("express_company_name",
				this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("obj", obj);
		mv.addObject("view_type", view_type);
		return mv;
	}

	@SecurityMapping(title = "自营订单延长收货时间", value = "/admin/self_order_comfirm_delay.htm*", rtype = "admin", rname = "收货管理", rcode = "order_confirm", rgroup = "商城管理")
	@RequestMapping("/admin/self_order_comfirm_delay.htm")
	public ModelAndView order_comfirm_delay(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/self_order_comfirm_delay.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj.getOrderForm() == OrderFormConstants.ORDER_FORM_SELF) {// 只能处理自营订单
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(),
			/* this.userConfigService.getUserConfig(), */0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;

	}

	@SecurityMapping(title = "自营订单延长收货时间保存", value = "/admin/self_order_confirm_delay_save.htm*", rtype = "admin", rname = "收货管理", rcode = "order_confirm", rgroup = "商城管理")
	@RequestMapping("/admin/self_order_confirm_delay_save.htm")
	public String self_order_confirm_delay_save(HttpServletRequest request, HttpServletResponse response,
			String id, String delay_time, String currentPage) throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj.getOrderForm() == OrderFormConstants.ORDER_FORM_SELF) {// 只能处理自营订单
			obj.setOrderConfirmDelay(obj.getOrderConfirmDelay() + CommUtil.null2Int(delay_time));
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("延长收货时间");
			ofl.setStateInfo("延长收货时间：" + delay_time + "天");
			ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
			ofl.setOfId(obj.getId());
			this.orderFormLogService.save(ofl);
		}
		return "redirect:self_order_confirm.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "调整订单费用", value = "/admin/order_fee.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_fee.htm")
	public ModelAndView order_fee(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_order_fee.html", configService.getSysConfig(),
				0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "调整订单费用保存", value = "/admin/order_fee_save.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_fee_save.htm")
	public String order_fee_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String goods_amount, String ship_price, String totalPrice) throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			obj.setGoodsAmount(BigDecimal.valueOf(CommUtil.null2Double(goods_amount)));
			obj.setShipPrice(BigDecimal.valueOf(CommUtil.null2Double(ship_price)));
			obj.setTotalPrice(BigDecimal.valueOf(CommUtil.null2Double(totalPrice)));
			obj.setOperationPriceCount(obj.getOperationPriceCount() + 1);
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("调整订单费用");
			ofl.setStateInfo("调整订单总金额为:" + totalPrice + ",调整运费金额为:" + ship_price);
			ofl.setLogUserId((SecurityUserHolder.getCurrentUser().getId()));
			ofl.setOfId(obj.getId());
			this.orderFormLogService.save(ofl);
			UserCustomer buyer = this.userCustomerService.findById(CommUtil.null2Long(obj.getUserId()));
			Map map = new HashMap();
			map.put("buyer_id", buyer.getUid().toString());
			map.put("self_goods", this.configService.getSysConfig().getTitle());
			map.put("order_id", obj.getId());
			String json = Json.toJson(map);
			this.msgTools.sendEmailFree(CommUtil.getURL(request),
					"email_tobuyer_selforder_update_fee_notify", buyer.getEmail(), json, null);
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "sms_tobuyer_selforder_fee_notify",
					buyer.getMobile(), json, null);
		}
		return "redirect:self_order.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家个人信息", value = "/admin/order_query_userinfor.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_query_userinfor.htm")
	public ModelAndView order_query_userinfor(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/order_query_userinfor.html",
				configService.getSysConfig(), 0, request, response);
		// OrderForm obj = this.orderFormService
		// .getObjById(CommUtil.null2Long(id));
		// mv.addObject("obj", obj);
		// mv.addObject("orderFormTools", orderFormTools);
		return mv;
	}

	@SecurityMapping(title = "取消订单", value = "/admin/order_cancel.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_cancel.htm")
	public ModelAndView order_cancel(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_order_cancel.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "取消订单保存", value = "/admin/order_cancel_save.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_cancel_save.htm")
	public String order_cancel_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String state_info, String other_state_info) throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			obj.setOrderStatus(0);
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("取消订单");
			ofl.setLogUserId((SecurityUserHolder.getCurrentUser().getId()));
			ofl.setOfId(obj.getId());
			if (state_info.equals("other")) {
				ofl.setStateInfo(other_state_info);
			} else {
				ofl.setStateInfo(state_info);
			}
			this.orderFormLogService.save(ofl);
			UserCustomer buyer = this.userCustomerService.findById(CommUtil.null2Long(obj.getUserId()));
			Map map = new HashMap();
			map.put("buyer_id", buyer.getUid().toString());
			map.put("self_goods", this.configService.getSysConfig().getTitle());
			map.put("order_id", obj.getId());
			String json = Json.toJson(map);
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "email_tobuyer_selforder_cancel_notify",
					buyer.getEmail(), json, null);
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "sms_tobuyer_selforder_cancel_notify",
					buyer.getMobile(), json, null);
		}
		return "redirect:self_order.htm";
	}

	@SecurityMapping(title = "确认发货", value = "/admin/order_shipping.htm*", rtype = "admin", rname = "发货管理", rcode = "order_ship", rgroup = "商城管理")
	@RequestMapping("/admin/order_shipping.htm")
	public ModelAndView order_shipping(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String op) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_order_shipping.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (OrderFormConstants.ORDER_FORM_SELF.equals(obj.getOrderForm())) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);

			List<GoodsBO> list_goods = this.orderFormTools.queryOfGoods(id);
			List<Goods> deliveryGoods = new ArrayList<Goods>();
			boolean physicalGoods = false;
			for (Goods g : list_goods) {
				if (g.getGoodsChoiceType() == GoodsConstants.GOODS_CHOICE_TYPE_VIRTUAL) {
					deliveryGoods.add(g);
				} else {
					physicalGoods = true;
				}
			}

			List<EcCommonBO> eccs = this.expressCompanyCommonService
					.selectAllByEccType(EcCommonConstants.ECC_TYPE_SELF);
			List<ShipAddress> shipAddrs = this.shipAddressService
					.findAllBySaType(ShipAddressConstants.SA_TYPE_ADMIN);

			mv.addObject("shipAddrs", shipAddrs);
			mv.addObject("eccs", eccs);
			mv.addObject("physicalGoods", physicalGoods);
			mv.addObject("deliveryGoods", deliveryGoods);
			mv.addObject("orderFormTools", orderFormTools);
			mv.addObject("op", op);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(),
			/* this.userConfigService.getUserConfig(), */0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "确认发货保存", value = "/admin/order_shipping_save.htm*", rtype = "admin", rname = "发货管理", rcode = "order_ship", rgroup = "商城管理")
	@RequestMapping("/admin/order_shipping_save.htm")
	public String order_shipping_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String shipCode, String stateInfo, String orderSellerIntro, String eccId,
			String saId, String op) throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		EcCommon ecc = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(eccId));
		if (OrderFormConstants.ORDER_FORM_SELF.equals(obj.getOrderForm())) {
			obj.setEvaUserId(SecurityUserHolder.getCurrentUser().getId());
			obj.setOrderStatus(OrderFormConstants.ORDER_STATUS_NO_TAKE_DELIVERY_OF_GOODS);
			obj.setShipCode(shipCode);
			obj.setShipTime(new Date());
			if (ecc != null) {
				Map<String, Object> json_map = new HashMap<String, Object>();
				json_map.put("express_company_id", ecc.getEccEcId());
				json_map.put("express_company_name", ecc.getEccName());
				json_map.put("express_company_mark", ecc.getEccCode());
				json_map.put("express_company_type", ecc.getEccEcType());
				String express_json = Json.toJson(json_map);
				obj.setExpressInfo(express_json);
			}
			String[] order_seller_intros = request.getParameterValues("order_seller_intro");
			String[] goods_ids = request.getParameterValues("goods_id");
			String[] goods_names = request.getParameterValues("goods_name");
			String[] goods_counts = request.getParameterValues("goods_count");
			if (order_seller_intros != null && order_seller_intros.length > 0) {
				List<Map<String, Object>> list_map = new ArrayList<Map<String, Object>>();
				for (int i = 0; i < goods_ids.length; i++) {
					Map<String, Object> json_map = new HashMap<String, Object>();
					json_map.put("goods_id", goods_ids[i]);
					json_map.put("goods_name", goods_names[i]);
					json_map.put("goods_count", goods_counts[i]);
					json_map.put("order_seller_intro", order_seller_intros[i]);
					json_map.put("order_id", id);
					list_map.add(json_map);
				}
				obj.setOrderSellerIntro(Json.toJson(list_map));
			}
			ShipAddress sa = this.shipAddressService.getObjById(CommUtil.null2Long(saId));
			if (sa != null) {
				obj.setShipAddrId(sa.getId());
				obj.setShipAddr(sa.getSaAddr());
			}
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("确认发货");
			ofl.setStateInfo(stateInfo);
			ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
			ofl.setOfId(obj.getId());
			this.orderFormLogService.save(ofl);
			UserCustomer buyer = this.userCustomerService.findById(CommUtil.null2Long(obj.getUserId()));
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("buyer_id", buyer.getUid().toString());
			map.put("self_goods", this.configService.getSysConfig().getTitle());
			map.put("order_id", obj.getId());
			String json = Json.toJson(map);
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "email_tobuyer_selforder_ship_notify",
					buyer.getEmail(), json, null);
			this.msgTools.sendEmailFree(CommUtil.getURL(request), "sms_tobuyer_selforder_ship_notify",
					buyer.getMobile(), json, null);
			// 如果是收费接口，则通知快递100，建立订单物流查询推送
			transInfoService.createExpressSearchSend(obj);
			// if (this.configService.getSysConfig().getKuaidiType() == 1) {
			// TaskRequest req = new TaskRequest();
			// Map express_map = Json.fromJson(Map.class,
			// obj.getExpress_info());
			// req.setCompany(CommUtil.null2String(express_map
			// .get("express_company_mark")));
			// String from_addr = obj.getShip_addr();
			// req.setFrom(from_addr);
			// req.setTo(obj.getReceiver_area());
			// req.setNumber(obj.getShipCode());
			// req.getParameters().put(
			// "callbackurl",
			// CommUtil.getURL(request)
			// + "/kuaidi100_callback.htm?order_id="
			// + obj.getId() + "&orderType=0");
			// req.getParameters().put(
			// "salt",
			// Md5Encrypt.md5(CommUtil.null2String(obj.getId()))
			// .toLowerCase());
			// req.setKey(this.configService.getSysConfig().getKuaidi_id2());
			//
			// HashMap<String, String> p = new HashMap<String, String>();
			// p.put("schema", "json");
			// p.put("param", JacksonHelper.toJSON(req));
			// try {
			// String ret = HttpRequest.postData(
			// "http://www.kuaidi100.com/poll", p, "UTF-8");
			// TaskResponse resp = JacksonHelper.fromJSON(ret,
			// TaskResponse.class);
			// if (resp.getResult() == true) {
			// ExpressInfo ei = new ExpressInfo();
			// ei.setAddTime(new Date());
			// ei.setOrder_id(obj.getId());
			// ei.setOrder_express_id(obj.getShipCode());
			// ei.setOrder_type(0);
			// Map ec_map = Json.fromJson(Map.class,
			// CommUtil.null2String(obj.getExpress_info()));
			// if (ec_map != null) {
			// ei.setOrder_express_name(CommUtil
			// .null2String(ec_map
			// .get("express_company_name")));
			// }
			// //
			// System.out.println(Json.toJson(result.getData(),JsonFormat.compact()));
			// this.expressInfoService.save(ei);
			// System.out.println("订阅成功");
			// } else {
			// System.out.println("订阅失败");
			// }
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			// }
			// 异步通知支付宝,该方法用在支付宝担保支付，目的用来修改支付宝订单状态为“已发货”
			// if (obj.getPayment() != null
			// && obj.getPayment().getMark().equals("alipay")
			// && obj.getPayment().getInterfaceType() == 1) {
			// // 把请求参数打包成数组
			// boolean synch = false;
			// String safe_key = "";
			// String partner = "";
			// if (!CommUtil.null2String(obj.getPayment().getSafeKey())
			// .equals("")
			// && !CommUtil.null2String(obj.getPayment().getPartner())
			// .equals("")) {
			// safe_key = obj.getPayment().getSafeKey();
			// partner = obj.getPayment().getPartner();
			// synch = true;
			// }
			// if (synch) {
			// AlipayConfig config = new AlipayConfig();
			// config.setKey(safe_key);
			// config.setPartner(partner);
			// Map<String, String> sParaTemp = new HashMap<String, String>();
			// sParaTemp.put("service", "send_goods_confirm_by_platform");
			// sParaTemp.put("partner", config.getPartner());
			// sParaTemp.put("_input_charset", config.getInput_charset());
			// sParaTemp.put("trade_no", obj.getOut_order_id());
			// sParaTemp.put("logistics_name", ecc.getEcc_name());
			// sParaTemp.put("invoice_no", shipCode);
			// sParaTemp.put("transport_type", ecc.getEcc_ec_type());
			// // 建立请求
			// String sHtmlText = AlipaySubmit.buildRequest(config, "web",
			// sParaTemp, "", "");
			// // System.out.println(sHtmlText);
			// }
			// }
		}
		if (CommUtil.null2String(op).equals("self_order_ship")) {
			return "redirect:self_order_ship.htm?currentPage=" + currentPage;
		} else
			return "redirect:self_order.htm?currentPage=" + currentPage;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "快递单打印", value = "/admin/order_ship_print.htm*", rtype = "admin", rname = "收货管理", rcode = "order_confirm", rgroup = "商城管理")
	@RequestMapping("/admin/order_ship_print.htm")
	public ModelAndView order_ship_print(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/order_ship_print.html", configService.getSysConfig(),
				0, request, response);
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (order != null) {
			if (order.getOrderForm() == OrderFormConstants.ORDER_FORM_SELF) {// 只能打印自营的订单
				mv.addObject("obj", order);
				if (order.getExpressInfo() != null) {
					Map ec_map = Json.fromJson(Map.class, order.getExpressInfo());
					EcCommon ecc = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(ec_map
							.get("express_company_id")));
					if (ecc != null) {
						Map offset_map = Json.fromJson(Map.class, ecc.getEccTemplateOffset());
						ShipAddress ship_addr = this.shipAddressService.getObjById(order.getShipAddrId());
						mv.addObject("ecc", this.expressCompanyCommonService.getObjById(CommUtil
								.null2Long(ec_map.get("express_company_id"))));
						mv.addObject("offset_map", offset_map);
						mv.addObject("ship_addr", ship_addr);
						// mv.addObject("area",
						// this.areaService.getObjById(ship_addr.getSaAreaId()));
					}
				} else {
					mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(),
					/* this.userConfigService.getUserConfig(), */0, request, response);
					mv.addObject("op_title", "老版物流订单，无法打印！");
				}
			}
		}
		return mv;
	}

	@SecurityMapping(title = "修改物流", value = "/admin/order_shipping_code.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_shipping_code.htm")
	public ModelAndView order_shipping_code(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_order_shipping_code.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
			List<EcCommonBO> eccs = this.expressCompanyCommonService
					.selectAllByEccType(EcCommonConstants.ECC_TYPE_SELF);
			mv.addObject("eccs", eccs);

			String companyName = this.orderFormTools
					.queryExInfo(obj.getExpressInfo(), "express_company_name");
			mv.addObject("expressCompanyName", companyName);

		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "修改物流保存", value = "/admin/order_shipping_code_save.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_shipping_code_save.htm")
	public String order_shipping_code_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String shipCode, String state_info, String eccId) {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			obj.setShipCode(shipCode);
			EcCommon ecc = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(eccId));
			if (ecc != null) {
				Map<String, Object> json_map = new HashMap<String, Object>();
				json_map.put("express_company_id", ecc.getEccEcId());
				json_map.put("express_company_name", ecc.getEccName());
				json_map.put("express_company_mark", ecc.getEccCode());
				json_map.put("express_company_type", ecc.getEccEcType());
				String express_json = Json.toJson(json_map);
				obj.setExpressInfo(express_json);
			}
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("修改物流信息");
			ofl.setStateInfo(state_info);
			ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
			ofl.setOfId(obj.getId());
			this.orderFormLogService.save(ofl);
			// 如果是收费接口，则通知快递100，建立订单物流查询推送
			if (this.configService.getSysConfig().getKuaidiType() == 1) {
				TaskRequest req = new TaskRequest();
				Map express_map = Json.fromJson(Map.class, obj.getExpressInfo());
				req.setCompany(CommUtil.null2String(express_map.get("express_company_mark")));
				String from_addr = obj.getShipAddr();
				req.setFrom(from_addr);
				req.setTo(obj.getReceiverArea());
				req.setNumber(obj.getShipCode());
				req.getParameters().put(
						"callbackurl",
						CommUtil.getURL(request) + "/kuaidi100_callback.htm?order_id=" + obj.getId()
								+ "&orderType=0");
				req.getParameters().put("salt",
						Md5Encrypt.md5(CommUtil.null2String(obj.getId())).toLowerCase());
				req.setKey(this.configService.getSysConfig().getKuaidiId2());

				HashMap<String, String> p = new HashMap<String, String>();
				p.put("schema", "json");
				p.put("param", JacksonHelper.toJSON(req));
				try {
					String ret = HttpRequest.postData("http://www.kuaidi100.com/poll", p, "UTF-8");
					TaskResponse resp = JacksonHelper.fromJSON(ret, TaskResponse.class);
					if (resp.getResult() == true) {
						ExpressInfo ei = new ExpressInfo();
						ei.setAddTime(new Date());
						ei.setOrderId(obj.getId());
						ei.setOrderExpressId(obj.getShipCode());
						ei.setOrderType(0);
						Map ec_map = Json.fromJson(Map.class, CommUtil.null2String(obj.getExpressInfo()));
						if (ec_map != null) {
							ei.setOrderExpressName(CommUtil.null2String(ec_map.get("express_company_name")));
						}
						// System.out.println(Json.toJson(result.getData(),JsonFormat.compact()));
						this.expressInfoService.save(ei);
						System.out.println("订阅成功");
					} else {
						System.out.println("订阅失败");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return "redirect:self_order.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "买家退货申请详情", value = "/admin/admin_order_return_apply_view.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/admin_order_return_apply_view.htm")
	public ModelAndView admin_order_return_apply_view(HttpServletRequest request,
			HttpServletResponse response, String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/admin_order_return_apply_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (1 == obj.getOrderForm()) {
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "打印订单", value = "/admin/order_print.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_print.htm")
	public ModelAndView order_print(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/order_print.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			OrderForm orderform = this.orderFormService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", orderform);
		}
		mv.addObject("orderFormTools", orderFormTools);
		return mv;
	}

	@SecurityMapping(title = "物流详情", value = "/admin/ship_view.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/ship_view.htm")
	public ModelAndView order_ship_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/order_ship_view.html", configService.getSysConfig(),
				0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (obj != null && !obj.equals("")) {
			if (1 == obj.getOrderForm()) {
				mv.addObject("obj", obj);
				TransInfo transInfo = this.transInfoService.queryShipInfo(obj.getExpressInfo(),
						obj.getShipCode());
				mv.addObject("transInfo", transInfo);
				mv.addObject("express_company_name",
						this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "您查询的物流不存在！");
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您查询的物流不存在！");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/self_order.htm");
		}
		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@SecurityMapping(title = "导出表格", value = "/admin/order_excel.htm*", rtype = "admin", rname = "订单管理", rcode = "order_self", rgroup = "商城管理")
	@RequestMapping("/admin/order_excel.htm")
	public void order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<OrderFormBO> page, OrderFormVO vo, String ids) {
		List<OrderFormBO> datas = new ArrayList<OrderFormBO>();
		page.setPageSize(1000000000);
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		if (StringUtils.isNotBlank(ids)) {
			datas = orderFormService.selectListById(ids);
		} else {
			this.orderFormService.findPageByVo(page, vo);
			datas = page.getContent();
		}
		if (datas != null && datas.size() > 0) {
			// datas = page.getContent();
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("订单列表");
			// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
			for (int i = 0; i < datas.size(); i++) {
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
			}
			// 设置excel每列宽度
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 4000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);
			sheet.setColumnWidth(8, 6000);
			sheet.setColumnWidth(9, 6000);
			sheet.setColumnWidth(10, 6000);
			sheet.setColumnWidth(11, 8000);
			// 创建字体样式
			HSSFFont font = wb.createFont();
			font.setFontName("Verdana");
			font.setBoldweight((short) 100);
			font.setFontHeight((short) 300);
			font.setColor(HSSFColor.BLUE.index);
			// 创建单元格样式
			HSSFCellStyle style = wb.createCellStyle();
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			// 设置边框
			style.setBottomBorderColor(HSSFColor.RED.index);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setFont(font);// 设置字体
			// 创建Excel的sheet的一行
			HSSFRow row = sheet.createRow(0);
			row.setHeight((short) 500);// 设定行的高度
			// 创建一个Excel的单元格
			HSSFCell cell = row.createCell(0);
			// 合并单元格(startRow，endRow，startColumn，endColumn)
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
			// 给Excel的单元格设置样式和赋值
			cell.setCellStyle(style);
			String title = "订单列表";
			Date time1 = CommUtil.formatDate(vo.getBeginTime());
			Date time2 = CommUtil.formatDate(vo.getEndTime());
			String time = CommUtil.null2String(CommUtil.formatShortDate(time1) + " - "
					+ CommUtil.formatShortDate(time2));
			cell.setCellValue(this.configService.getSysConfig().getTitle() + title + "（" + time + "）");
			// 设置单元格内容格式时间
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
			style1.setWrapText(true);// 自动换行
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style3 = wb.createCellStyle();
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
			row = sheet.createRow(1);

			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("流水号");

			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("买家");

			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("买家手机");

			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("地址");

			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("付款时间");
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("支付方式");
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("订单类型");
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("商品");
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("物流单号");
			cell = row.createCell(11);
			cell.setCellStyle(style2);
			cell.setCellValue("运费");
			cell = row.createCell(12);
			cell.setCellStyle(style3);
			cell.setCellValue("商品总价");
			cell = row.createCell(13);
			cell.setCellStyle(style3);
			cell.setCellValue("订单总额");
			cell = row.createCell(14);
			cell.setCellStyle(style2);
			cell.setCellValue("订单状态");
			cell = row.createCell(15);
			cell.setCellStyle(style2);
			cell.setCellValue("发货时间");
			cell = row.createCell(16);
			cell.setCellStyle(style2);
			cell.setCellValue("留言");
			cell = row.createCell(17);
			cell.setCellStyle(style2);
			cell.setCellValue("用户昵称");
			cell = row.createCell(18);
			cell.setCellStyle(style2);
			cell.setCellValue("活动信息");

			double all_order_price = 0.00;// 订单总金额
			double all_total_amount = 0.00;// 商品总金
			int offet = 0;
			for (int j = 2; j <= datas.size() + 1; j++) {
				// 订单里面商品信息
				List<Map> goods_json = new ArrayList<Map>();
				if (/*datas.size()+offet >= j+offet - 2 && */
				datas.get(j - 2) != null) {
					try {
						goods_json = Json.fromJson(List.class,
								CommUtil.null2String(datas.get(j - 2).getGoodsInfo()));
					} catch (JsonException e) {
						e.printStackTrace();
					}
				}

				for (int k = 0; k < goods_json.size(); k++) {
					row = sheet.createRow(offet + 2);
					if (k == 0) {
						UserCustomer user = userCustomerService.findById(datas.get(j - 2).getUserId());
						// 如果是第一行，则要显示所以咧
						// 设置单元格的样式格式
						int i = 0;
						cell = row.createCell(i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getTradeNo());
						
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getReceiverName());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getReceiverMobile());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getReceiverArea()
								+ datas.get(j - 2).getReceiverAreaInfo());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getOrderId());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getPayTime()));
						
						
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						if (datas.get(j - 2).getPaymentId() != null) {
							cell.setCellValue(paymentService.findById(datas.get(j - 2).getPaymentId()).getName());
						} else {
							cell.setCellValue("未支付");
						}

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(TYPE_MAP.get(datas.get(j - 2).getOrderType()));

						/*			List<Map> goods_json = new ArrayList<Map>();
									if (datas.size() >= j - 2 && datas.get(j - 2) != null) {
										try {
											goods_json = Json.fromJson(List.class, CommUtil.null2String(datas.get(j - 2).getGoodsInfo()));
										} catch (JsonException e) {
											e.printStackTrace();
										}
									}*/
						StringBuilder sb = new StringBuilder();
						boolean whether_combin = false;
						if (goods_json != null) {
							for (Map map : goods_json) {
								sb.append(map.get("goods_name") + "*" + map.get("goods_count") + ",");
								if (map.get("goods_type").toString().equals("combin")) {
									whether_combin = true;
								}
							}
						}
						Map map1 = goods_json.get(k);
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(map1.get("goods_name").toString() + "*" + map1.get("goods_count"));

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getShipCode());

						cell = row.createCell(++i);
						cell.setCellStyle(style3);
						cell.setCellValue(CommUtil.null2Double(datas.get(j - 2).getShipPrice()));

						cell = row.createCell(++i);
						cell.setCellStyle(style3);
						cell.setCellValue(CommUtil.null2Double(datas.get(j - 2).getGoodsAmount()));
//						all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getGoodsAmount());// 计算商品总价

						cell = row.createCell(++i);
						cell.setCellStyle(style3);
						cell.setCellValue(CommUtil.null2Double(datas.get(j - 2).getTotalPrice()));
//						all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(STATUS_MAP.get(datas.get(j - 2).getOrderStatus()));

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getShipTime()));

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(datas.get(j - 2).getMsg());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						if (user != null) {
							cell.setCellValue(user.getNickname());
						}

						
						if (datas.get(j - 2).getWhetherGift() == 1) {
							List<Map> gifts_json = Json.fromJson(List.class, datas.get(j - 2).getGiftInfos());
							StringBuilder gsb = new StringBuilder();
							for (Map map : gifts_json) {
								gsb.append(map.get("goods_name") + ",");
							}
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue(gsb.toString());
						}

						if (datas.get(j - 2).getEnoughReduceAmount() != null
								&& datas.get(j - 2).getEnoughReduceAmount().compareTo(WHETHER_ENOUGH) == 1) {
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue("满减");
						}
						if (whether_combin) {
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue("组合销售");
						}
					} else {// 否则只显示 商品名称，数量信息
							// 设置单元格的样式格式
						int i = 0;
						cell = row.createCell(i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						if (datas.get(j - 2).getPaymentId() != null) {
							cell.setCellValue("");
						} else {
							cell.setCellValue("");
						}

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						/*			List<Map> goods_json = new ArrayList<Map>();
									if (datas.size() >= j - 2 && datas.get(j - 2) != null) {
										try {
											goods_json = Json.fromJson(List.class, CommUtil.null2String(datas.get(j - 2).getGoodsInfo()));
										} catch (JsonException e) {
											e.printStackTrace();
										}
									}*/
						StringBuilder sb = new StringBuilder();
						boolean whether_combin = false;
						if (goods_json != null) {
							for (Map map : goods_json) {
								sb.append(map.get("goods_name") + "*" + map.get("goods_count") + ",");
								if (map.get("goods_type").toString().equals("combin")) {
									whether_combin = true;
								}
							}
						}
						Map map1 = goods_json.get(k);
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(map1.get("goods_name").toString() + "*" + map1.get("goods_count"));

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");
//						all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getGoodsAmount());// 计算商品总价

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");
//						all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue("");

						if (datas.get(j - 2).getWhetherGift() == 1) {
							List<Map> gifts_json = Json.fromJson(List.class, datas.get(j - 2).getGiftInfos());
							StringBuilder gsb = new StringBuilder();
							for (Map map : gifts_json) {
								gsb.append(map.get("goods_name") + ",");
							}
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue("");
						}
						if (datas.get(j - 2).getEnoughReduceAmount() != null
								&& datas.get(j - 2).getEnoughReduceAmount().compareTo(WHETHER_ENOUGH) == 1) {
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue("满减");
						}
						if (whether_combin) {
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							cell.setCellValue("组合销售");
						}
					}

					offet++;
				}
				all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getGoodsAmount());// 计算商品总价
				all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

			}
			// 设置底部统计信息
			int m = datas.size() + 2;
			row = sheet.createRow(offet + 2);
			// 设置单元格的样式格式
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue("总计");

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue("本次订单金额：");

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(all_order_price);

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue("本次商品总金额：");

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(all_total_amount);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				String path = request.getSession().getServletContext().getRealPath("") + File.separator
						+ "excel";
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition", "attachment;filename=" + excel_name + ".xls");
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// private TransInfo query_ship_getData(String id) {
	// TransInfo info = new TransInfo();
	// OrderForm obj = this.orderFormService
	// .getObjById(CommUtil.null2Long(id));
	// try {
	// ExpressCompany ec = this.queryExpressCompany(obj.getExpress_info());
	// URL url = new URL("http://api.kuaidi100.com/api?id="
	// + this.configService.getSysConfig().getKuaidi_id()
	// + "&com=" + (ec != null ? ec.getCompany_mark() : "")
	// + "&nu=" + obj.getShipCode() + "&show=0&muti=1&order=asc");
	// URLConnection con = url.openConnection();
	// con.setAllowUserInteraction(false);
	// InputStream urlStream = url.openStream();
	// String type = con.guessContentTypeFromStream(urlStream);
	// String charSet = null;
	// if (type == null)
	// type = con.getContentType();
	// if (type == null || type.trim().length() == 0
	// || type.trim().indexOf("text/html") < 0)
	// return info;
	// if (type.indexOf("charset=") > 0)
	// charSet = type.substring(type.indexOf("charset=") + 8);
	// byte b[] = new byte[10000];
	// int numRead = urlStream.read(b);
	// String content = new String(b, 0, numRead, charSet);
	// while (numRead != -1) {
	// numRead = urlStream.read(b);
	// if (numRead != -1) {
	// // String newContent = new String(b, 0, numRead);
	// String newContent = new String(b, 0, numRead, charSet);
	// content += newContent;
	// }
	// }
	// info = Json.fromJson(TransInfo.class, content);
	// urlStream.close();
	// } catch (MalformedURLException e) {
	// e.printStackTrace();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return info;
	// }

	// private ExpressCompany queryExpressCompany(String json) {
	// ExpressCompany ec = null;
	// if (json != null && !json.equals("")) {
	// HashMap map = Json.fromJson(HashMap.class, json);
	// ec = this.expressCompanyService.getObjById(CommUtil.null2Long(map
	// .get("express_company_id")));
	// }
	// return ec;
	// }

}
