package vc.thinker.b2b2c.action.o2o;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
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
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.tools.GoodsClassViewTools;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.tools.GroupViewTools;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.tools.NavViewTools;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;

/**
 * 
 * <p>
 * Title: GroupViewAction.java
 * </p>
 * 
 * <p>
 * Description:团购管理控制器，超级后台用来发起团购、审核团购商品，添加团购商品类目、价格区间等等
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
 * @date 2014-5-28
 * 
 * @version 1.0.1
 */
@Controller
public class GroupViewAction {
	@Autowired
	PaymentService paymentService;
	@Autowired
	PayTools payTools;
	@Autowired
	PredepositService predepositService;
	@Autowired
	OrderFormTools orderFormTools;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	GroupOrderService groupOrderService;
	@Autowired
	private GroupViewTools groupViewTools;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private NavViewTools navTools;
	@Autowired
	UserCustomerService userCustomerService;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private PaymentTools paymentTools;
	@Autowired
	private GoodsClassViewTools gcViewTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private UserAccountService userAccountService;

//
//	/**
//	 *
//	 * @param request
//	 * @param response
//	 * @param id
//	 * @param goods_id
//	 * @param currentPage
//	 * @return
//	 */
//	@RequestMapping("/group_evaluation.htm")
//	public ModelAndView group_evaluation(HttpServletRequest request,
//			HttpServletResponse response, String id, String goods_id,
//			String currentPage) {
//		Store store = this.storeService.getObjById(CommUtil.null2Long(id));
//		ModelAndView mv = new JModelAndView("group_evaluate.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		EvaluateQueryObject qo = new EvaluateQueryObject(currentPage, mv,
//				"addTime", "desc");
//		qo.addQuery("obj.evaluate_goods.id",
//				new SysMap("goods_id", CommUtil.null2Long(goods_id)), "=");
//		qo.addQuery("obj.evaluate_type", new SysMap("evaluate_type", "goods"),
//				"=");
//		qo.addQuery("obj.evaluate_status", new SysMap("evaluate_status", 0),
//				"=");
//		qo.setPageSize(8);
//		IPageList pList = this.evaluateService.list(qo);
//		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request)
//				+ "/group_evaluation.htm", "", "", pList, mv);
//		mv.addObject("storeViewTools", storeViewTools);
//		mv.addObject("store", store);
//		Goods goods = this.goodsService
//				.getObjById(CommUtil.null2Long(goods_id));
//		mv.addObject("goods", goods);
//		return mv;
//	}
//
//	@RequestMapping("/group_order.htm")
//	public ModelAndView group_order(HttpServletRequest request,
//			HttpServletResponse response, String id, String goods_id,
//			String currentPage) {
//		ModelAndView mv = new JModelAndView("group_order.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		EvaluateQueryObject qo = new EvaluateQueryObject(currentPage, mv,
//				"addTime", "desc");
//		qo.addQuery("obj.evaluate_goods.id",
//				new SysMap("goods_id", CommUtil.null2Long(goods_id)), "=");
//		qo.setPageSize(8);
//		IPageList pList = this.evaluateService.list(qo);
//		CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request)
//				+ "/group_order.htm", "", "", pList, mv);
//		return mv;
//	}

	@SecurityMapping(title = "生活类团购订单购买", value = "/life_order.htm*", rtype = "buyer", rname = "团购", rcode = "buyer_group", rgroup = "团购")
	@RequestMapping("/life_order.htm")
	public ModelAndView life_order(HttpServletRequest request, HttpServletResponse response, String gid,
			Integer number) {
		ModelAndView mv = new JModelAndView("life_order.html", configService.getSysConfig(), 1, request,
				response);
		UserCustomer user = userCustomerService.findById(SecurityUserHolder.getCurrentUserId());
		GroupGoods goods = groupGoodsService.getObjById(CommUtil.null2Long(gid));
		DecimalFormat df = new DecimalFormat("0.00");
		if (number == null || number < 1)
			number = 1;
		if (goods != null) {
			if (!user.getUid().equals(goods.getUserId())) {
				if (goods.getGroupCount() <= 0
						|| DateUtils.truncatedCompareTo(goods.getEndTime(), new Date(), Calendar.DATE) < 0) {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "团购已到期或已售完");
					mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm?type=life");
				} else {
					if (user.getMobile() != null && !"".equals(user.getMobile())) {
						mv.addObject("number", number);
						mv.addObject("total", df.format(goods.getGroupPrice().doubleValue() * number));
						mv.addObject("user", user);
						mv.addObject("obj", goods);
						int isAdd = 0;
						SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
						int d1Number = Integer.parseInt(f.format(goods.getAddTime()).toString()); // 将第一个时间格式化后转为int
						if (d1Number < 20161028) {
							isAdd = 1;
						}
						mv.addObject("isAdd", isAdd);
						String orderForm_session = CommUtil.randomString(32);
						request.getSession(false).setAttribute("orderForm_session", orderForm_session);
						mv.addObject("orderForm_session", orderForm_session);
					} else {
						mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request,
								response);
						mv.addObject("op_title", "请先绑定您的手机");
						mv.addObject("url", CommUtil.getURL(request) + "/buyer/account_mobile.htm");
					}
				}
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "无法购买自己的团购商品");
				mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm?type=life");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "您所访问的团购不存在");
			mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm?type=life");
		}

		return mv;
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "生活类团购订单保存", value = "/life_order_save.htm*", rtype = "buyer", rname = "团购", rcode = "buyer_group", rgroup = "团购")
	@RequestMapping("/life_order_save.htm")
	public ModelAndView life_order_save(HttpServletRequest request, HttpServletResponse response,
			String orderForm_session, String group_id, String order_count) {
		long currUserid = SecurityUserHolder.getCurrentUserId();
		if (CommUtil.null2Int(order_count) <= 0) {
			order_count = "1";
		}
		ModelAndView mv = new JModelAndView("life_order_pay.html", configService.getSysConfig(), 1, request,
				response);
		UserCustomer user = userCustomerService.findById(currUserid);
		if (group_id != null && !group_id.equals("")) {
			String orderForm_session2 = CommUtil.null2String(request.getSession(false).getAttribute(
					"orderForm_session"));
			if (orderForm_session2.equals(orderForm_session)) {
				GroupOrder orderForm = new GroupOrder();
				GroupGoods goods = groupGoodsService.getObjById(CommUtil.null2Long(group_id));
				double group_total_price = CommUtil.null2Double(goods.getGroupPrice())
						* CommUtil.null2Int(order_count);
				orderForm.setAddTime(new Date());
				orderForm.setUserId(user.getUid());
				orderForm.setUserNickname(user.getNickname());
				orderForm.setOrderType(1);
				if (goods.getGoodsType() != null) {
					if (goods.getGoodsType() == 1) {
						orderForm.setOrderType(4);
					} else if (goods.getGoodsType() == 2) {
						orderForm.setOrderType(5);
					}
				}
				Map json = new HashMap();
				json.put("goods_id", goods.getId().toString());
				json.put("goods_name", goods.getGgName());
				json.put("goods_type", goods.getGoodsType());
				json.put("goods_price", goods.getGroupPrice());
				json.put("goods_count", CommUtil.null2Int(order_count));
				json.put("goods_total_price", group_total_price);
				json.put("goods_mainphoto_path", goods.getGroupAccPath());
				json.put("goods_begin_time", CommUtil.formatShortDate(goods.getBeginTime()));
				json.put("goods_end_time", CommUtil.formatShortDate(goods.getEndTime()));
				orderForm.setGroupInfo(Json.toJson(json, JsonFormat.compact()));
				orderForm.setTotalPrice(new BigDecimal(group_total_price));
				orderForm.setStoreId(goods.getStoreId().toString());
				orderForm.setOrderForm(0);
				orderForm.setOrderSource(GroupOrderConstants.ORDER_SOURCE_WEB);
				orderForm.setTotalPrice(BigDecimal.valueOf(group_total_price));
				orderForm.setOrderId("life" + currUserid + CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
				orderForm.setOrderStatus(GroupOrderConstants.ORDER_STATUS_SUBMIT);
				orderForm.setGroupRebateAmount(goods.getGroupRebateAmount());
				groupOrderService.save(orderForm);
				request.getSession(false).removeAttribute("orderForm_session");
				mv.addObject("order_count", order_count);
				String orderpayment_session = CommUtil.randomString(32);
				request.getSession(false).setAttribute("orderpayment_session", orderpayment_session);
				mv.addObject("orderpayment_session", orderpayment_session);
				mv.addObject("order", orderForm);
				mv.addObject("all_of_price",
						BigDecimal.valueOf(group_total_price).setScale(2, BigDecimal.ROUND_HALF_UP));
				mv.addObject("paymentTools", paymentTools);
				mv.addObject("group", true);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "禁止重复提交");
				mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm?type=life");
				request.getSession(false).removeAttribute("orderForm_session");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "此页面不存在");
			mv.addObject("url", CommUtil.getURL(request) + "/group/index.htm?type=life");
			request.getSession(false).removeAttribute("orderForm_session");

		}

		return mv;
	}

	/**
	 * 当使用微信进行支付时，支付成功后跳转的链接
	 * 
	 * @param request
	 * @param response
	 * @param orderNo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/group/orderPaySuccessRedirect.htm")
	public ModelAndView orderPaySuccessRedirect(HttpServletRequest request, HttpServletResponse response,
			String orderNo) {
		GroupOrderBO order = groupOrderService.findByOrderNoBig(orderNo);
		ModelAndView mv = new JModelAndView("order_life_finish.html", configService.getSysConfig(), 1,
				request, response);
		Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
		mv.addObject("all_price", map.get("goods_total_price"));
		mv.addObject("obj", order);

		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "订单支付", value = "/group/order_pay.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/group/order_pay.htm")
	public ModelAndView order_pay(HttpServletRequest request, HttpServletResponse response, String payType,
			String order_id, boolean isAvailableBalance, String paymentPassword) {
		ModelAndView mv = null;
		Long uid = SecurityUserHolder.getCurrentUserId();

		if (StringUtils.isBlank(order_id) || (isAvailableBalance && StringUtils.isBlank(paymentPassword))) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			if (isAvailableBalance && StringUtils.isBlank(paymentPassword))
				mv.addObject("op_title", "支付密码不能为空");
			else
				mv.addObject("op_title", "参数错误，付款失败");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}

		List<UserAccountBO> userAccount = this.userAccountService.findUserAccountByUid(uid);// 增加CN账号判断
		String accountType = "0";
		for (UserAccountBO type : userAccount) {
			if ("8".equals(type.getAccountType())) {
				accountType = type.getAccountType();
				break;
			}
		}

		try {
			GroupOrderBO order = groupOrderService.orderPay(payType, CommUtil.null2Long(order_id), uid,
					isAvailableBalance, paymentPassword, accountType);
			// 如果完成支付
			if (order.getOrderStatus() >= OrderFormConstants.ORDER_STATUS_TO_BE_SHIPPED) {
				mv = new JModelAndView("order_life_finish.html", configService.getSysConfig(), 1, request,
						response);
				Map map = orderFormTools.queryGroupInfo(order.getGroupInfo());
				mv.addObject("all_price", map.get("goods_total_price"));
				mv.addObject("obj", order);
				return mv;
			} else {
				String type = PaymentConstants.ORDER_TYPE_GROUP;
				mv = new JModelAndView("line_pay.html", configService.getSysConfig(), 1, request, response);
				PaymentBO payment = paymentService.findByMark(order.getPaymentMark());
				// 如果云豆支付
				if (OrderFormConstants.ORDER_PAY_TYPE_BALANCE.equals(order.getPaymentMark())) {
					mv.addObject("cash_id", order.getCashId());
					type = PaymentConstants.ORDER_TYPE_CASH;

					// 云豆支付的支付方式id,在云豆充值记录上
					PredepositBO predeposit = predepositService.findBOById(order.getCashId());
					mv.addObject("payment_id", predeposit.getPaymentId());

				} else if (OrderFormConstants.ORDER_PAY_TYPE_ONLINE.equals(order.getPaymentMark())) {
					mv.addObject("order", order);
					mv.addObject("order_id", order.getId());
					mv.addObject("payment_id", payment.getId());
					type = PaymentConstants.ORDER_TYPE_GROUP;
				} else {
					mv.addObject("order", order);
					mv.addObject("order_id", order.getId());
					mv.addObject("payment_id", payment.getId());
					type = PaymentConstants.ORDER_TYPE_GROUP;
				}

				String[] tPayType = payType.split("-");
				String realPayType = tPayType[0];
				mv.addObject("payType", realPayType);
				if (realPayType.equals("alipayB") || realPayType.equals("alipayC")) {
					mv.addObject("bank", payType.replace("alipayB-", "").replace("alipayC-", ""));
				}
				mv.addObject("url", configService.getSysConfig().getAddress()); // 测试先修改为我自己ip
				mv.addObject("payTools", payTools);
				mv.addObject("type", type);
				return mv;
			}
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			if (e instanceof MoneyPasswordNullConsumption) {
				mv.addObject("op_title", "用户支付密码为空，请进行设置！");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/money_password.htm");
			} else {
				mv.addObject("op_title", e.getErrorCode());
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/group.htm?orderType=1");
			}
		}

		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "订单支付详情", value = "/life_order_pay_view.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/life_order_pay_view.htm")
	public ModelAndView order_pay_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("life_order_pay.html", configService.getSysConfig(), 1, request,
				response);
		GroupOrderBO of = groupOrderService.getObjById(CommUtil.null2Long(id));
		long currUserId = SecurityUserHolder.getCurrentUserId();

		if (of != null && of.getUserId().equals(currUserId)) {
			if (of.getOrderStatus() == GroupOrderConstants.ORDER_STATUS_SUBMIT) {

				Map map = orderFormTools.queryGroupInfo(of.getGroupInfo());
				long goods_id = Long.parseLong(map.get("goods_id").toString());
				int goods_count = Integer.parseInt(map.get("goods_count").toString());
				double group_total_price = Double.parseDouble(map.get("goods_total_price").toString());
				GroupGoodsBO goods = groupGoodsService.getObjById(goods_id);

				if (goods.getGroupCount() >= goods_count) { // 订单中商品库存验证成功
					UserCustomerBO customer = userCustomerService.findSessionUser(currUserId);
					mv.addObject("order", of);// 将主订单信息封装到前台视图中
					mv.addObject("customer", customer);
					mv.addObject("all_of_price", group_total_price);
					mv.addObject("paymentTools", paymentTools);
					mv.addObject("payTools", payTools);
				} else {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "订单中商品库存不足，请重新下单");
					mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
				}
			} else if (of.getOrderStatus() < GroupOrderConstants.ORDER_STATUS_SUBMIT) {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "该订单已经取消");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "该订单已付款");
				mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "该订单已失效");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
		}

		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "订单支付结果", value = "/order_life_finish.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/order_life_finish.htm")
	public ModelAndView order_finish(HttpServletRequest request, HttpServletResponse response, String order_id) {
		ModelAndView mv = new JModelAndView("order_life_finish.html", configService.getSysConfig(), 1,
				request, response);
		GroupOrderBO obj = groupOrderService.getObjById(CommUtil.null2Long(order_id));
		Map map = orderFormTools.queryGroupInfo(obj.getGroupInfo());
		mv.addObject("obj", obj);
		mv.addObject("all_price", map.get("goods_total_price"));
		return mv;
	}

	/**
	 * 数量调整
	 * 
	 * @param request
	 * @param response
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "团购订单数量", value = "/group_count_adjust.htm*", rtype = "buyer", rname = "团购", rcode = "buyer_group", rgroup = "团购")
	@RequestMapping("/group_count_adjust.htm")
	public void group_count_adjust(HttpServletRequest request, HttpServletResponse response, String group_id,
			String count) {
		double group_total_price = 0;
		String error = "100";// 100表示修改成功，200表示库存不足
		GroupGoods group = null;
		if (group_id != null && !group_id.equals("")) {
			group = groupGoodsService.getObjById(CommUtil.null2Long(group_id));
		}
		if (CommUtil.null2Int(count) > group.getGroupCount()) {
			error = "200";
			count = CommUtil.null2String(group.getGroupCount());
		}
		group_total_price = CommUtil.null2Double(CommUtil.null2Double(group.getGroupPrice())
				* CommUtil.null2Int(count));
		DecimalFormat df = new DecimalFormat("0.00");
		Map map = new HashMap();
		map.put("count", count);
		map.put("group_total_price", df.format(group_total_price));
		map.put("error", error);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(map, JsonFormat.compact()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	@RequestMapping("/grouplife/search.htm")
//	public ModelAndView grouplife_search(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String orderBy,
//			String orderType, String gc_id, String gpr_id, String ga_id,
//			String type, String keyword) {
//		ModelAndView mv = new JModelAndView("search_grouplife_list.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		GroupClass groupClass = null;
//		if (gc_id != null && !gc_id.equals("")) {
//			groupClass = this.groupClassService.getObjById(CommUtil
//					.null2Long(gc_id));
//		}
//		GroupArea grouparea = null;
//		if (gc_id != null && !gc_id.equals("")) {
//			grouparea = this.groupAreaService.getObjById(CommUtil
//					.null2Long(ga_id));
//		}
//		String path = System.getProperty("thinkervcb2b2c.root") + File.separator
//				+ "luence" + File.separator + "lifegoods";
//		//LuceneUtil lucene = LuceneUtil.instance();
//		//lucene.setIndex_path(path);
//		boolean order_type = true;
//		String order_by = "";
//		int begin_price = 0;
//		int end_price = 0;
//		GroupPriceRange gpr = this.groupPriceRangeService.getObjById(CommUtil
//				.null2Long(gpr_id));
//		if (gpr != null) {
//			begin_price = gpr.getGpr_begin();
//			end_price = gpr.getGpr_end();
//		}
//		if (CommUtil.null2String(orderType).equals("asc")) {
//			order_type = false;
//		}
//		if (CommUtil.null2String(orderType).equals("")) {
//			orderType = "desc";
//		}
//		if (CommUtil.null2String(orderBy).equals("group_price")) {
//			order_by = "store_price";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_salenum")) {
//			order_by = "goods_salenum";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_collect")) {
//			order_by = "goods_collect";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_addTime")) {
//			order_by = "addTime";
//		}
//		SortBuilder sort = null;
//		if (!CommUtil.null2String(order_by).equals("")) {
//			//sort = new Sort(new SortField(order_by, SortField.Type.DOUBLE,
//				//	order_type));// 排序false升序,true降序
//			sort = new FieldSortBuilder(order_by).order(order_type?SortOrder.DESC:SortOrder.ASC);
//		}
//		String c_id = groupClass != null ? groupClass.getId().toString() : "";
//		String a_id = grouparea != null ? grouparea.getId().toString() : "";
//		LuceneResult pList = null;
//		if (sort != null) {
//			/*pList = luceneUtil.search(keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, sort, c_id, a_id, null);*/
//			pList = luceneUtil.search(LifeGoodsDocument.class,keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, c_id, a_id, null,sort);
//		} else {
//			pList = luceneUtil.search(LifeGoodsDocument.class,keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, c_id, a_id, null,null);
//		}
//		LuceneCommonUtil.saveLucene2ModelAndView(pList, mv);
//		List<GroupClass> gcs = this.groupClassService
//				.query("select obj from GroupClass obj where obj.gc_type=1 and obj.parent.id is null order by obj.gc_sequence asc",
//						null, -1, -1);
//		List<GroupPriceRange> gprs = this.groupPriceRangeService
//				.query("select obj from GroupPriceRange obj order by obj.gpr_begin asc",
//						null, -1, -1);
//		Map params = new HashMap();
//		params.put("beginTime", new Date());
//		params.put("endTime", new Date());
//		params.put("group_type", 1);
//		List<Group> groups = this.groupService
//				.query("select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime and obj.group_type=:group_type",
//						params, -1, -1);
//		mv.addObject("keyword", keyword);
//		mv.addObject("gprs", gprs);
//		mv.addObject("gcs", gcs);
//		if (groups.size() > 0) {
//			mv.addObject("group", groups.get(0));
//		}
//		if (orderBy == null || orderBy.equals("")) {
//			orderBy = "addTime";
//		}
//		if (orderType == null || orderType.equals("")) {
//			orderType = "desc";
//		}
//		mv.addObject("gc_id", gc_id);
//		mv.addObject("gpr_id", gpr_id);
//		mv.addObject("groupViewTools", groupViewTools);
//		mv.addObject("type", "life");
//		mv.addObject("order_type", CommUtil.null2String(orderBy) + "_"
//				+ CommUtil.null2String(orderType));
//		mv.addObject("orderType", orderType);
//		return mv;
//	}
//
//	@RequestMapping("/group/search.htm")
//	public ModelAndView group_search(HttpServletRequest request,
//			HttpServletResponse response, String currentPage, String orderBy,
//			String orderType, String gc_id, String gpr_id, String ga_id,
//			String type, String keyword) {
//		ModelAndView mv = new JModelAndView("search_group_list.html",
//				configService.getSysConfig(),
//				this.userConfigService.getUserConfig(), 1, request, response);
//		GroupClass groupClass = null;
//		if (gc_id != null && !gc_id.equals("")) {
//			groupClass = this.groupClassService.getObjById(CommUtil
//					.null2Long(gc_id));
//		}
//		GroupArea grouparea = null;
//		if (gc_id != null && !gc_id.equals("")) {
//			grouparea = this.groupAreaService.getObjById(CommUtil
//					.null2Long(ga_id));
//		}
//		String path = System.getProperty("thinkervcb2b2c.root") + File.separator
//				+ "luence" + File.separator + "groupgoods";
//		//LuceneUtil lucene = LuceneUtil.instance();
//		//lucene.setIndex_path(path);
//		boolean order_type = true;
//		String order_by = "";
//		int begin_price = 0;
//		int end_price = 0;
//		GroupPriceRange gpr = this.groupPriceRangeService.getObjById(CommUtil
//				.null2Long(gpr_id));
//		if (gpr != null) {
//			begin_price = gpr.getGpr_begin();
//			end_price = gpr.getGpr_end();
//		}
//		if (CommUtil.null2String(orderType).equals("asc")) {
//			order_type = false;
//		}
//		if (CommUtil.null2String(orderType).equals("")) {
//			orderType = "desc";
//		}
//		if (CommUtil.null2String(orderBy).equals("group_price")) {
//			order_by = "store_price";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_salenum")) {
//			order_by = "goods_salenum";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_collect")) {
//			order_by = "goods_collect";
//		}
//		if (CommUtil.null2String(orderBy).equals("goods_addTime")) {
//			order_by = "addTime";
//		}
//		SortBuilder sort = null;
//		if (!CommUtil.null2String(order_by).equals("")) {
//			/*sort = new Sort(new SortField(order_by, SortField.Type.DOUBLE,
//					order_type));// 排序false升序,true降序
//			*/
//			sort = new FieldSortBuilder(order_by).order(order_type?SortOrder.DESC:SortOrder.ASC);
//		}
//		String c_id = groupClass != null ? groupClass.getId().toString() : "";
//		String a_id = grouparea != null ? grouparea.getId().toString() : "";
//		LuceneResult pList = null;
//		if (sort != null) {
//			/*pList = luceneUtil.search(keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, sort, c_id, a_id, null);*/
//			pList = luceneUtil.search(GroupGoodsDocument.class,keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, c_id, a_id, null,sort);
//		} else {
//			pList = luceneUtil.search(GroupGoodsDocument.class,keyword, CommUtil.null2Int(currentPage),
//					null, null, null, null, null, c_id, a_id, null,null);
//		}
//		LuceneCommonUtil.saveLucene2ModelAndView(pList, mv);
//		List<GroupClass> gcs = this.groupClassService
//				.query("select obj from GroupClass obj where obj.gc_type=0 and obj.parent.id is null order by obj.gc_sequence asc",
//						null, -1, -1);
//		List<GroupPriceRange> gprs = this.groupPriceRangeService
//				.query("select obj from GroupPriceRange obj order by obj.gpr_begin asc",
//						null, -1, -1);
//		Map params = new HashMap();
//		params.put("beginTime", new Date());
//		params.put("endTime", new Date());
//		params.put("group_type", 0);
//		List<Group> groups = this.groupService
//				.query("select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime and obj.group_type=:group_type",
//						params, -1, -1);
//		mv.addObject("keyword", keyword);
//		mv.addObject("gprs", gprs);
//		mv.addObject("gcs", gcs);
//		if (groups.size() > 0) {
//			mv.addObject("group", groups.get(0));
//		}
//		if (orderBy == null || orderBy.equals("")) {
//			orderBy = "addTime";
//		}
//		if (orderType == null || orderType.equals("")) {
//			orderType = "desc";
//		}
//		mv.addObject("gc_id", gc_id);
//		mv.addObject("gpr_id", gpr_id);
//		mv.addObject("groupViewTools", groupViewTools);
//		mv.addObject("type", "goods");
//		mv.addObject("order_type", CommUtil.null2String(orderBy) + "_"
//				+ CommUtil.null2String(orderType));
//		mv.addObject("orderType", orderType);
//		return mv;
//	}
//
//	private Set<Long> genericIds(Long id) {
//		Set<Long> ids = new HashSet<Long>();
//		if (id != null) {
//			ids.add(id);
//			Map params = new HashMap();
//			params.put("pid", id);
//			List id_list = this.groupAreaService
//					.query("select obj.id from GroupArea obj where obj.parent.id=:pid",
//							params, -1, -1);
//			ids.addAll(id_list);
//			for (int i = 0; i < id_list.size(); i++) {
//				Long cid = CommUtil.null2Long(id_list.get(i));
//				Set<Long> cids = genericIds(cid);
//				ids.add(cid);
//				ids.addAll(cids);
//			}
//		}
//		return ids;
//	}

}
