package vc.thinker.b2b2c.action.seller;

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

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.nutz.json.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.Md5Encrypt;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.express.service.ExpressCompanyCommonService;
import com.sinco.carnation.express.service.ExpressInfoService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.kuaidi100.pojo.TaskRequest;
import com.sinco.carnation.kuaidi100.pojo.TaskResponse;
import com.sinco.carnation.kuaidi100.post.HttpRequest;
import com.sinco.carnation.kuaidi100.post.JacksonHelper;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.OrderTools;
import com.sinco.carnation.ship.service.ShipAddressService;
import com.sinco.carnation.shop.bo.EcCommonBO;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.constants.EcCommonConstants;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.model.EcCommon;
import com.sinco.carnation.shop.model.ExpressInfo;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.OrderLog;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.model.TransInfo;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.UserBO;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: OrderSellerAction.java
 * </p>
 * 
 * <p>
 * Description:卖家订单控制器，卖家中心订单管理所有控制器都在这里
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
 * @date 2014-5-20
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"rawtypes", "unchecked"})
public class OrderSellerAction {

	private static final Logger log = LoggerFactory.getLogger(OrderSellerAction.class);

	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private UserConfigService userConfigService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
//	@Autowired
//	private IRefundLogService refundLogService;
//	@Autowired
//	private IGoodsService goodsService;
//	@Autowired
//	private IGoodsReturnService goodsReturnService;
//	@Autowired
//	private IGoodsCartService goodsCartService;
//	@Autowired
//	private IEvaluateService evaluateService;
//	@Autowired
//	private UserService userService;
//	@Autowired
//	private IIntegralLogService integralLogService;
//	@Autowired
//	private IGroupGoodsService groupGoodsService;
//	@Autowired
//	private ITemplateService templateService;
//	@Autowired
//	private IPaymentService paymentService;
//	@Autowired
//	private IExpressCompanyService expressCompanyService;
	@Autowired
	private ExpressCompanyCommonService expressCompanyCommonService;
	@Autowired
	private ShipAddressService shipAddressService;
	@Autowired
	private AreaServiceImpl areaService;
//	@Autowired
//	private StoreViewTools storeViewTools;
	@Autowired
	private MsgTools msgTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private StoreService storeService;
//	@Autowired
//	private PaymentTools paymentTools;
//	@Autowired
//	private IPayoffLogService payoffservice;
	@Autowired
	private ExpressInfoService expressInfoService;
	@Autowired
	private OrderTools orderTools;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private TransInfoService transInfoService;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private UserAccountService userAccountService;

	private static final BigDecimal WHETHER_ENOUGH = new BigDecimal(0.00);

	// 0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价
	@SuppressWarnings("serial")
	private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {
		{
			put(0, "已取消");
			put(10, "待付款");
			put(15, "线下支付待审核");
			put(16, "货到付款待发货");
			put(20, "已付款");
			put(30, "已发货");
			put(35, "自提点代收");
			put(40, "已收货");
			put(50, "已完成");
			put(60, "已结束");
		}
	};

//	private static final Map<String, String> PAYMENT_MAP = new HashMap<String, String>() {
//		{
//			put(null, "未支付");
//			put("", "未支付");
//			put("alipay", "支付宝");
//			put("alipay_wap", "手机网页支付宝");
//			put("alipay_app", "手机支付宝APP");
//			put("tenpay", "财付通");
//			put("bill", "快钱");
//			put("chinabank", "网银在线");
//			put("outline", "线下支付");
//			put("balance", "预存款支付");
//			put("payafter", "货到付款");
//			put("paypal", "paypal");
//		}
//	};

	private static final Map<Long, String> PAYMENT_ID_MAP = new HashMap<Long, String>() {
		/**
		 * serialVersionUID
		 */
		private static final long serialVersionUID = -2560836981535067317L;

		{
			put(null, "未支付");
			put(0L, "未支付");
			put(2L, "支付宝");
			put(3L, "手机网页支付宝");
			put(4L, "手机支付宝APP");
			put(5L, "财付通");
			put(6L, "快钱");
			put(7L, "网银在线");
			put(8L, "paypal");
			put(9L, "微信App支付");
			put(10L, "微信Wap支付");
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

	@SecurityMapping(title = "卖家订单列表", value = "/seller/order.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order.htm")
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response,
			MyPage<OrderFormBO> page, OrderFormVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (vo.getOrderStatus() == null) {
			vo.setOrderStatus("all");
		}
		List<ShipAddressBO> shipAddrs = this.shipAddressService.findAllByCondition(0, user.getUser().getId());
		boolean address=true;
		if (null == shipAddrs || shipAddrs.size() == 0) {
			address = false;
		}
		vo.setStoreId(store.getId().toString());
		this.orderFormService.findPageByVo(page, vo);
		/* 积分订单也需要运费2017-06-05 tw
		 * if(page.getContent() != null && page.getContent().size() > 0){
			for(OrderFormBO obj : page.getContent()){
				if("2".equals(String.valueOf(obj.getPayTypeFlag()))){
					BigDecimal max = new BigDecimal(2000);
					if(obj.getActualPrice().add(obj.getActualIntegral()).compareTo(max) != -1){
						obj.setTotalPrice(obj.getTotalPrice().subtract(obj.getShipPrice()));
						obj.setShipPrice(new BigDecimal(0));
					}
				}
			}
		}*/
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("store", store);
		// 云购币专区供应商后台 订单列表需要显示购买人CN账号
		UserBO userBO = user.getUser();
		mv.addObject("type", userBO.getUserType());
		mv.addObject("userAccountService", userAccountService);
		mv.addObject("address", address);
		return mv;
	}

	@SecurityMapping(title = "卖家待发货订单管理", value = "/seller/order_ship.htm*", rtype = "seller", rname = "发货管理", rcode = "order_ship_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_ship.htm")
	public ModelAndView order_ship(HttpServletRequest request, HttpServletResponse response,
			String currentPage, OrderFormVO vo, MyPage<OrderFormBO> page, String yungouFlag) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order_ship.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null && userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
			vo.setStoreId(userDetails.getStoreId().toString());
		}

		List<ShipAddressBO> shipAddrs = this.shipAddressService.findAllByCondition(0, userDetails.getUser().getId());
		boolean address=true;
		if (null == shipAddrs || shipAddrs.size() == 0) {
			address = false;
		}
		vo.setOrderStatus(OrderFormConstants.ORDER_STATUS_ORDER_PAY);
		vo.setOrderByClause("pay_Time desc");
		this.orderFormService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("address", address);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("store", store);
		if (null != yungouFlag && yungouFlag.equals("1")) {
			mv.addObject("yungouFlag", 1);
		}
		return mv;
	}

//	@SecurityMapping(title = "卖家发货待收货订单管理", value = "/seller/order_confirm.htm*", rtype = "seller", rname = "收货管理", rcode = "order_confirm_seller", rgroup = "交易管理")
//	@RequestMapping("/seller/order_confirm.htm")
//	public ModelAndView order_confirm(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String order_id,
//			String beginTime, String endTime, String buyer_userName) {
//		ModelAndView mv = new JModelAndView(
//				"user/default/sellercenter/seller_order_confirm.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 0, request, response);
//		OrderFormQueryObject ofqo = new OrderFormQueryObject(currentPage, mv,
//				"shipTime", "desc");
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		ofqo.addQuery("obj.store_id", new SysMap("store_id", user.getStore()
//				.getId().toString()), "=");
//		ofqo.addQuery("obj.order_cat", new SysMap("order_cat", 2), "!=");
//		Map temp = new HashMap();
//		temp.put("order_status1", 30);
//		temp.put("order_status2", 35);
//		ofqo.addQuery(
//				"and (obj.order_status =:order_status1 or obj.order_status =:order_status2)",
//				temp);
//		if (!CommUtil.null2String(order_id).equals("")) {
//			ofqo.addQuery("obj.order_id", new SysMap("order_id", "%" + order_id
//					+ "%"), "like");
//		}
//		if (!CommUtil.null2String(beginTime).equals("")) {
//			ofqo.addQuery("obj.addTime",
//					new SysMap("beginTime", CommUtil.formatDate(beginTime)),
//					">=");
//			mv.addObject("beginTime", beginTime);
//		}
//		if (!CommUtil.null2String(endTime).equals("")) {
//			String ends = endTime + " 23:59:59";
//			ofqo.addQuery(
//					"obj.addTime",
//					new SysMap("endTime", CommUtil.formatDate(ends,
//							"yyyy-MM-dd hh:mm:ss")), "<=");
//			mv.addObject("endTime", endTime);
//		}
//		if (!CommUtil.null2String(buyer_userName).equals("")) {
//			ofqo.addQuery("obj.user_name", new SysMap("user_name",
//					buyer_userName), "=");
//		}
//		// System.out.println(ofqo.getQuery());
//		IPageList pList = this.orderFormService.list(ofqo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		mv.addObject("order_id", order_id);
//		mv.addObject("beginTime", beginTime);
//		mv.addObject("endTime", endTime);
//		mv.addObject("buyer_userName", buyer_userName);
//		mv.addObject("orderFormTools", orderFormTools);
//		mv.addObject("store", user.getStore());
//		mv.addObject("orderTools", this.orderTools);
//		return mv;
//	}

	@SecurityMapping(title = "卖家订单详情", value = "/seller/order_view.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_view.htm")
	public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/order_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.fetch(CommUtil.null2Long(id));

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
//		Store store = this.storeService.getObjById(CommUtil.null2Long(obj.getStore_id()));
//		User user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		if (user.getStore().getId().equals(store.getId())) {
		if (obj != null) {
			/* 积分订单也需要运费2017-06-05 tw
			 * if("2".equals(String.valueOf(obj.getPayTypeFlag()))){
				BigDecimal max = new BigDecimal(2000);
				if(obj.getActualPrice().add(obj.getActualIntegral()).compareTo(max) != -1){
					obj.setTotalPrice(obj.getTotalPrice().subtract(obj.getShipPrice()));
					obj.setShipPrice(new BigDecimal(0));
				}
			}*/
			mv.addObject("obj", obj);
			mv.addObject("store", store);
			mv.addObject("orderFormTools", orderFormTools);
			mv.addObject("goodsViewTools", goodsViewTools);
			mv.addObject("express_company_name",
					this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您店铺中没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "卖家取消订单", value = "/seller/order_cancel.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_cancel.htm")
	public ModelAndView order_cancel(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String yungouFlag) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order_cancel.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		// Store store =
		// this.storeService.getObjById(CommUtil.null2Long(obj.getStoreId()));
		// User user =
		// this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
		// user = user.getParent() == null ? user : user.getParent();
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		if (null != yungouFlag && yungouFlag.equals("1")) {
			mv.addObject("yungouFlag", 1);
		}
		return mv;
	}

	@SecurityMapping(title = "卖家取消订单保存", value = "/seller/order_cancel_save.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_cancel_save.htm")
	public String order_cancel_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String state_info, String other_state_info, String yungouFlag)
			throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		// Store store =
		// this.storeService.getObjById(CommUtil.null2Long(obj.getStore_id()));
		// User user =
		// this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
		// user = user.getParent() == null ? user : user.getParent();
		// if (user.getStore().getId().equals(store.getId())) {
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
			obj.setOrderStatus(0);
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("取消订单");
			ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
			ofl.setOfId(obj.getId());
			if (state_info.equals("其他原因")) {
				ofl.setStateInfo(other_state_info);
			} else {
				ofl.setStateInfo(state_info);
			}
			this.orderFormLogService.save(ofl);
			UserCustomer buyer = this.userCustomerService.findById(obj.getUserId());
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("buyer_id", buyer.getUid().toString());
			map.put("seller_id", store.getCreateUserId());
			map.put("order_id", obj.getId());
			String json = Json.toJson(map);
			if (obj.getOrderForm() == 0) {
				this.msgTools.sendEmailCharge(CommUtil.getURL(request), "email_tobuyer_order_cancel_notify",
						buyer.getEmail(), json, null, obj.getStoreId());
				this.msgTools.sendSmsCharge(CommUtil.getURL(request), "sms_tobuyer_order_cancel_notify",
						buyer.getMobile(), json, null, obj.getStoreId());
			} else {
				this.msgTools.sendEmailFree(CommUtil.getURL(request), "email_tobuyer_order_cancel_notify",
						buyer.getEmail(), json, null);
				this.msgTools.sendSmsFree(CommUtil.getURL(request), "sms_tobuyer_order_cancel_notify",
						buyer.getMobile(), json, null);
			}

		}
		String page = "redirect:order.htm";
		if (null != yungouFlag && yungouFlag.equals("1")) {
			page = "redirect:yungou_order.htm";
		}
		return page;
//		return "redirect:order.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "卖家调整订单费用", value = "/seller/order_fee.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_fee.htm")
	public ModelAndView order_fee(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order_fee.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "卖家调整订单费用保存", value = "/seller/order_fee_save.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_fee_save.htm")
	public String order_fee_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, @RequestParam("goodsAmount") String goodsAmount,
			@RequestParam("shipPrice") String shipPrice, @RequestParam("totalPrice") String totalPrice)
			throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		if (CommUtil.null2Double(obj.getCommissionAmount()) <= CommUtil.null2Double(goodsAmount)) {
			CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
			StoreBO store = null;
			if (user != null && user.getStoreId() != null) {
				store = storeService.getObjById(user.getStoreId());
			}
			if (store != null && store.getId() != null) {
				obj.setGoodsAmount(BigDecimal.valueOf(CommUtil.null2Double(goodsAmount)));
				obj.setShipPrice(BigDecimal.valueOf(CommUtil.null2Double(shipPrice)));
				obj.setTotalPrice(BigDecimal.valueOf(CommUtil.null2Double(totalPrice)));
				obj.setOperationPriceCount(obj.getOperationPriceCount() + 1);
				this.orderFormService.update(obj);
				OrderLog ofl = new OrderLog();
				ofl.setAddTime(new Date());
				ofl.setLogInfo("调整订单费用");
				ofl.setStateInfo("调整订单总金额为:" + totalPrice + ",调整运费金额为:" + shipPrice);
				ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
				ofl.setOfId(obj.getId());
				this.orderFormLogService.save(ofl);
				UserCustomer buyer = this.userCustomerService.findById(CommUtil.null2Long(obj.getUserId()));
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("buyer_id", buyer.getUid().toString());
				map.put("seller_id", store.getCreateUserId());
				map.put("order_id", obj.getId());
				String json = Json.toJson(map);
				if (obj.getOrderForm() == 0) {
					this.msgTools.sendEmailCharge(CommUtil.getURL(request),
							"email_tobuyer_order_update_fee_notify", buyer.getEmail(), json, null,
							obj.getStoreId());
					this.msgTools.sendSmsCharge(CommUtil.getURL(request), "sms_tobuyer_order_fee_notify",
							buyer.getMobile(), json, null, obj.getStoreId());
				} else {
					this.msgTools.sendEmailFree(CommUtil.getURL(request),
							"email_tobuyer_order_update_fee_notify", buyer.getEmail(), json, null);
					this.msgTools.sendSmsFree(CommUtil.getURL(request), "sms_tobuyer_order_fee_notify",
							buyer.getMobile(), json, null);
				}
			}
		}
		return "redirect:order.htm";
		// return "redirect:order.htm?currentPage=" + currentPage;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "卖家确认发货", value = "/seller/order_shipping.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_shipping.htm")
	public ModelAndView order_shipping(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String page_status, String yungouFlag) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order_shipping.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
			// 当前订单中的虚拟商品
			List<GoodsBO> list_goods = this.orderFormTools.queryOfGoods(id);
			List<Goods> deliveryGoods = new ArrayList<Goods>();
			boolean physicalGoods = false;
			for (Goods g : list_goods) {
				if (g.getGoodsChoiceType() == 1) {
					deliveryGoods.add(g);
				} else {
					physicalGoods = true;
				}
			}
//			Map params = new HashMap();
//			params.put("ecc_type", 0);
//			params.put("ecc_store_id", store.getId());
//			List<ExpressCompanyCommon> eccs = this.expressCompanyCommonService
//					.query("select obj from ExpressCompanyCommon obj where obj.ecc_type=:ecc_type and obj.ecc_store_id=:ecc_store_id",
//							params, -1, -1);
//			params.clear();
//			params.put("sa_type", 0);
//			params.put("sa_user_id", user.getId());
//			List<ShipAddress> shipAddrs = this.shipAddressService
//					.query("select obj from ShipAddress obj where obj.sa_type=:sa_type and obj.sa_user_id=:sa_user_id order by obj.sa_default desc,obj.sa_sequence asc",
//							params, -1, -1);// 按照默认地址倒叙、其他地址按照索引升序排序，保证默认地址在第一位

			List<EcCommonBO> eccs = this.expressCompanyCommonService
					.selectAllByEccType(EcCommonConstants.ECC_TYPE_SELF);

			List<ShipAddressBO> shipAddrs = this.shipAddressService.findAllByCondition(0, user.getUser()
					.getId());
			if (null == shipAddrs || shipAddrs.size() == 0) {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "对不起，您尚末设置发货地址，请完善后才可进行发货操作！");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/order_ship.htm");
			}
			mv.addObject("eccs", eccs);
			mv.addObject("shipAddrs", shipAddrs);
			mv.addObject("physicalGoods", physicalGoods);
			mv.addObject("deliveryGoods", deliveryGoods);
			mv.addObject("page_status", page_status);
			mv.addObject("orderFormTools", orderFormTools);
			if (null != yungouFlag && yungouFlag.equals("1")) {
				mv.addObject("yungouFlag", 1);
			}
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "订单参数错误！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "卖家确认发货保存", value = "/seller/order_shipping_save.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_shipping_save.htm")
	public String order_shipping_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String shipCode, String state_info, String order_seller_intro, String ecc_id,
			String sa_id, String page_status, String yungouFlag, String eccName) {

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		String[] order_seller_intros = request.getParameterValues("order_seller_intro");
		String[] goods_ids = request.getParameterValues("goods_id");
		String[] goods_names = request.getParameterValues("goods_name");
		String[] goods_counts = request.getParameterValues("goods_count");

		try {
			this.orderFormService.deliverySeller(CommUtil.null2Long(id), CommUtil.null2Long(ecc_id),
					shipCode, CommUtil.null2Long(sa_id), state_info, user.getId(), user.getStoreId(),
					order_seller_intros, goods_ids, goods_names, goods_counts, eccName);
		} catch (ServiceException e) {
			// 这里没有处理
			log.error("发货错误", e);
		}

		if (page_status.equals("order_ship")) {
			return "redirect:order_ship.htm?currentPage=" + currentPage + "&yungouFlag=" + yungouFlag;
		} else {

			String page = "redirect:order.htm?currentPage=" + currentPage;
			if (null != yungouFlag && yungouFlag.equals("1")) {
				page = "redirect:yungou_order.htm?currentPage=" + currentPage;
			}
			return page;
		}
	}

	@SecurityMapping(title = "卖家修改物流", value = "/seller/order_shipping_code.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_shipping_code.htm")
	public ModelAndView order_shipping_code(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String yungouFlag) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_order_shipping_code.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "卖家修改物流保存", value = "/seller/order_shipping_code_save.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_shipping_code_save.htm")
	public String order_shipping_code_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String shipCode, String stateInfo, String yungouFlag) {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));

		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {

//		Store store = this.storeService.getObjById(CommUtil.null2Long(obj.getStore_id()));
//		User user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		if (user.getStore().getId().equals(store.getId())) {
			obj.setShipCode(shipCode);
			this.orderFormService.update(obj);
			OrderLog ofl = new OrderLog();
			ofl.setAddTime(new Date());
			ofl.setLogInfo("修改物流信息");
			ofl.setStateInfo(stateInfo);
			ofl.setLogUserId(user.getId());
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
						Map map = Json.fromJson(Map.class, CommUtil.null2String(obj.getExpressInfo()));
						if (map != null) {
							ei.setOrderExpressName(CommUtil.null2String(map.get("express_company_name")));
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
		String page = "redirect:order.htm?currentPage=" + currentPage;
		if (null != yungouFlag && yungouFlag.equals("1")) {
			page = "redirect:yungou_order.htm?currentPage=" + currentPage;
		}
		return page;
	}

	@SecurityMapping(title = "打印订单", value = "/seller/order_print.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_print.htm")
	public ModelAndView order_print(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/order_print.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			OrderForm orderform = this.orderFormService.getObjById(CommUtil.null2Long(id));
			Store store = this.storeService.getObjById(CommUtil.null2Long(orderform.getStoreId()));
			mv.addObject("store", store);
			mv.addObject("obj", orderform);
			mv.addObject("orderFormTools", orderFormTools);
		}
		return mv;
	}

	@SecurityMapping(title = "卖家物流详情", value = "/seller/ship_view.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/ship_view.htm")
	public ModelAndView order_ship_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/order_ship_view.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {

			mv.addObject("obj", obj);
			// TransInfo transInfo =
			// this.query_ship_getData(CommUtil.null2String(obj.getId()));
			TransInfo transInfo = transInfoService.queryShipInfo(obj.getExpressInfo(), obj.getShipCode(),
					CommUtil.null2Long(obj.getOrderId()));
			mv.addObject("transInfo", transInfo);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您店铺中没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "卖家订单导出Excel", value = "/seller/order_excel.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_excel.htm")
	public void order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<OrderFormBO> page, OrderFormVO vo) {

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null && userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		page.setPageSize(1000000000);
		vo.setStoreId(store.getId().toString());
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELLER);
		this.orderFormService.findPageByVo(page, vo);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<OrderFormBO> datas = page.getContent();
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("订单列表");
//			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
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
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("支付方式");
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("订单类型");
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("商品");
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("物流单号");
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("运费");
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("商品总价");
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("订单总额");
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("订单状态");
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("发货时间");
			cell = row.createCell(11);
			cell.setCellStyle(style2);
			cell.setCellValue("活动信息");
			double all_order_price = 0.00;// 订单总金额
			double all_total_amount = 0.00;// 商品总金额
			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				// 设置单元格的样式格式
				int i = 0;
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderId());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);

				if (datas.get(j - 2).getPaymentId() != null) {
					cell.setCellValue(PAYMENT_ID_MAP.get(datas.get(j - 2).getPaymentId()));
				} else {
					cell.setCellValue("未支付");
				}

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(TYPE_MAP.get(datas.get(j - 2).getOrderType()));

				List<Map> goods_json = Json.fromJson(List.class, datas.get(j - 2).getGoodsInfo());
				StringBuilder sb = new StringBuilder();
				boolean whether_combin = false;
				for (Map map : goods_json) {
					sb.append(map.get("goods_name") + "*" + map.get("goods_count") + ",");
					if (map.get("goods_type").toString().equals("combin")) {
						whether_combin = true;
					}
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(sb.toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getShipCode());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getShipPrice().toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodsAmount().toString());
				all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getGoodsAmount());// 计算商品总价

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getTotalPrice()));
				all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(STATUS_MAP.get(datas.get(j - 2).getOrderStatus()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getShipTime()));

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
			}
			// 设置底部统计信息
			int m = datas.size() + 2;
			row = sheet.createRow(m);
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
				// String path = request.getSession().getServletContext().getRealPath("") + File.separator +
				// "excel";
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

	@SecurityMapping(title = "延长收货时间", value = "/seller/order_comfirm_delay.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_comfirm_delay.htm")
	public ModelAndView order_comfirm_delay(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/order_comfirm_delay.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/order.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "延长收货时间保存", value = "/seller/order_confirm_delay_save.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_confirm_delay_save.htm")
	public String order_confirm_delay_save(HttpServletRequest request, HttpServletResponse response,
			String id, String delay_time, String currentPage) throws Exception {
		OrderForm obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (store != null && store.getId() != null) {
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
		return "redirect:order_confirm.htm?currentPage=" + currentPage;
	}

//	private ExpressCompany queryExpressCompany(String json) {
//		ExpressCompany ec = null;
//		if (json != null && !json.equals("")) {
//			HashMap map = Json.fromJson(HashMap.class, json);
//			ec = this.expressCompanyService.getObjById(CommUtil.null2Long(map
//					.get("express_company_id")));
//		}
//		return ec;
//	}

	@SecurityMapping(title = "打印快递运单", value = "/seller/order_ship_print.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/order_ship_print.htm")
	public ModelAndView order_ship_print(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/order_ship_print.html",
				configService.getSysConfig(), 0, request, response);
		OrderForm order = this.orderFormService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		StoreBO store = null;
		if (user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (order.getStoreId().equals(CommUtil.null2String(store.getId()))) {// 只能打印自己店铺的订单
			Map ec_map = Json.fromJson(Map.class, order.getExpressInfo());
			EcCommon ecc = this.expressCompanyCommonService.getObjById(CommUtil.null2Long(ec_map
					.get("express_company_id")));
			if (ecc != null) {
				Map offset_map = Json.fromJson(Map.class, ecc.getEccTemplateOffset());
				ShipAddress ship_addr = this.shipAddressService.getObjById(order.getShipAddrId());
				mv.addObject("ecc", this.expressCompanyCommonService.getObjById(CommUtil.null2Long(ec_map
						.get("express_company_id"))));
				mv.addObject("offset_map", offset_map);
				mv.addObject("obj", order);
				mv.addObject("ship_addr", ship_addr);
				mv.addObject("area", this.areaService.getObjById(ship_addr.getSaAreaId()));
			} else {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "老版物流订单，无法打印！");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/ecc_list.htm");
			}
		}
		return mv;
	}

	/***
	 * 云购币专区--卖家订单列表
	 * 
	 * @param request
	 * @param response
	 * @param page
	 * @param vo
	 * @return
	 */
	// ////////////////////////////////////////////////////////////////////////////////////////
	@SecurityMapping(title = "云购币订单列表", value = "/seller/yungou_order.htm*", rtype = "seller", rname = "订单管理", rcode = "order_seller", rgroup = "交易管理")
	@RequestMapping("/seller/yungou_order.htm")
	public ModelAndView yungou_order(HttpServletRequest request, HttpServletResponse response,
			MyPage<OrderFormBO> page, OrderFormVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_yungou_order.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (vo.getOrderStatus() == null) {
			vo.setOrderStatus("all");
		}
		vo.setStoreId(store.getId().toString());
		this.orderFormService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("store", store);
		mv.addObject("yungouFlag", 1);
		return mv;
	}
}
