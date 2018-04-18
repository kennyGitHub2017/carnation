package vc.thinker.b2b2c.action.refund;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.model.ReturnGoodsLog;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.goods.vo.ReturnGoodsLogVO;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.refund.service.RefundLogService;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.vo.RefundLogVO;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.User;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * 
 * <p>
 * Title: RefundManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台向买家进行退款，退款统一给买家发放预存款，买家通过预存款兑换现金
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
 * @date 2014年5月14日
 * 
 * @version 1.0.1
 */
@Controller
public class RefundManageAction {
	@Autowired
	private ExpressCompanyService expressCompayService;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private UserService userService;
	@Autowired
	private PredepositLogService predepositLogService;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;
	@Autowired
	private RefundLogService refundLogService;
	@Autowired
	private PayoffLogService payoffLogService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private GoodsService goodsService;
//	@Autowired
//	private GroupInfoService groupinfoService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private PaymentService paymentService;

	/**
	 * refund_list列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品退款列表", value = "/admin/refund_list.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/refund_list.htm")
	public ModelAndView refund_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, ReturnGoodsLogVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/refund_list.html", configService.getSysConfig(), 0,
				request, response);
		MyPage<Map> page = new MyPage<Map>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		List<Integer> statusList = Lists.newArrayList(
				Integer.parseInt(GoodsConstants.GOODS_RETURN_STATUS_10),
				Integer.parseInt(GoodsConstants.GOODS_RETURN_STATUS_11));
		vo.setGoodsRefundStatusList(statusList);
		returnGoodsLogService.search(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("vo", vo);

		return mv;
	}

	/**
	 * refund_list列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "消费码退款列表", value = "/admin/groupinfo_refund_list.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/groupinfo_refund_list.htm")
	public ModelAndView groupinfo_refund_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String group_sn, String user_name,
			String refund_status) {
		ModelAndView mv = new JModelAndView("admin/blue/groupinfo_refund_list.html",
				configService.getSysConfig(), 0, request, response);
//		GroupInfoQueryObject qo = new GroupInfoQueryObject(currentPage, mv,
//				orderBy, orderType);
//		qo.addQuery("obj.status", new SysMap("status", 5), "=");
//		if (group_sn != null && !group_sn.equals("")) {
//			qo.addQuery("obj.group_sn", new SysMap("group_sn", group_sn), "=");
//			mv.addObject("group_sn", group_sn);
//		}
//		if (user_name != null && !user_name.equals("")) {
//			qo.addQuery("obj.user_name", new SysMap("user_name", user_name),
//					"=");
//			mv.addObject("user_name", user_name);
//		}
//		if (refund_status != null && !refund_status.equals("")) {
//			qo.addQuery("obj.status",
//					new SysMap("status", CommUtil.null2Int(refund_status)), "=");
//			mv.addObject("refund_status", refund_status);
//		}
//		WebForm wf = new WebForm();
//		wf.toQueryPo(request, qo, GroupInfo.class, mv);
//		IPageList pList = this.groupinfoService.list(qo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
		return mv;
	}

	/**
	 * refund_view查看
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return 退款1
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	@SecurityMapping(title = "查看退款", value = "/admin/refund_view.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/refund_view.htm")
	public ModelAndView refund_view(HttpServletRequest request, HttpServletResponse response, String id,
			String type) {
		ModelAndView mv = new JModelAndView("admin/blue/refund_predeposit_modify.html",
				configService.getSysConfig(), 0, request, response);
		if (type != null && !type.equals("")) {
			if (type.equals("groupinfo")) {// 消费码退款
				mv.addObject("type", type);
//				GroupInfo gi = this.groupinfoService.getObjById(CommUtil
//						.null2Long(id));
//				User user = this.userService.getObjById(gi.getUser_id());
//				mv.addObject("refund_money", gi.getLifeGoods().getGroup_price());
//				mv.addObject("user", user);
//				mv.addObject("gi", gi);
//				mv.addObject(
//						"msg",
//						gi.getLifeGoods().getGg_name() + "消费码"
//								+ gi.getGroup_sn() + "退款成功，预存款"
//								+ gi.getLifeGoods().getGroup_price()
//								+ "元已存入您的账户");
			}
		} else {// 商品退款
			ReturnGoodsLog obj = returnGoodsLogService.getObjById(CommUtil.null2Long(id));// shop_return_goods_log
			OrderForm of = orderFormService.getObjById(obj.getReturnOrderId());// shop_order_form
			double temp_refund_money = 0.0;
			if (of.getCouponInfo() != null && !of.getCouponInfo().equals("")) {
				Map map = orderFormTools.queryCouponInfo(of.getCouponInfo());
				BigDecimal rate = new BigDecimal(map.get("coupon_goods_rate").toString());
				BigDecimal old_price = new BigDecimal(obj.getGoodsAllPrice());
				double refund_money = mul(rate, old_price);
				temp_refund_money = CommUtil.subtract(old_price, refund_money);
				mv.addObject("refund_money", temp_refund_money);
			} else {
				temp_refund_money = CommUtil.null2Double(obj.getGoodsAllPrice());
				mv.addObject("refund_money", obj.getGoodsAllPrice());
			}
			mv.addObject("msg", "退货服务号为" + obj.getReturnServiceId() + "的商品退款成功，预存款" + temp_refund_money
					+ "元已存入您的账户");

			if (CommUtil.null2Double(of.getEnoughReduceAmount()) > 0) {// 满就减金额退款
				Map er_info = (Map) Json.fromJson(of.getEnoughReduceInfo());
				Iterator<String> it = er_info.keySet().iterator();
				// {"all_23":1110.0,"enouhg_23":"500.00","23":[13],"reduce23":100.0}
				while (it.hasNext()) {
					String key = it.next();
					if (key.substring(0, 1).equals("a")) {// 查找该商品的满就减信息
						String key2 = key.substring(4, key.length());
						List list = (List) er_info.get(key2);
						for (Object good_id : list) {

							if (CommUtil.null2Double(good_id) == obj.getGoodsId()) {// 有该商品
								double goods_price = CommUtil.null2Double(obj.getGoodsAllPrice());
								double all = CommUtil.null2Double(er_info.get(key).toString());
								double enouhg = CommUtil
										.null2Double(er_info.get("enouhg_" + key2).toString());
								if (all - goods_price < enouhg) {// 去掉该商品后不满足满就减
									double reduce = CommUtil.null2Double(er_info.get("reduce_" + key2)
											.toString());
									double return_account = goods_price / all * reduce;
									temp_refund_money = CommUtil.null2Double(new BigDecimal(temp_refund_money
											- return_account));
									mv.addObject("refund_money", temp_refund_money);
									mv.addObject("msg", "退货服务号为" + obj.getReturnServiceId() + "的商品退款成功，预存款"
											+ temp_refund_money + "元已存入您的账户,其中扣除了" + return_account + "元满减金额");
								}
							}
						}
					}
				}
			}

			mv.addObject("obj", obj);
			User user = userService.getObjById(obj.getUserId());
			UserCustomerBO ucbo = userCustomerService.queryUserByUid(obj.getUserId()); // user_customer
			mv.addObject("user", user);
			mv.addObject("ucbo", ucbo);
			mv.addObject("of", of);
		}

		return mv;
	}

	/**
	 * 浮点数乘法，保留精度
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static double mul(Object a, Object b) {// 乘法
		BigDecimal e = new BigDecimal(CommUtil.null2Double(a));
		BigDecimal f = new BigDecimal(CommUtil.null2Double(b));
		return e.multiply(f).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
	}

	/**
	 * refundlog_list列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "退款日志列表", value = "/admin/refundlog_list.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/refundlog_list.htm")
	public ModelAndView refundlog_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, RefundLogVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/refundlog_list.html", configService.getSysConfig(),
				0, request, response);
		MyPage<Map> page = new MyPage<Map>();
		page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 1 : Integer.parseInt(currentPage));
		refundLogService.search(vo, page);

		String url = configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		String params = "";
		CommUtil.saveIPageList2ModelAndView(url + "/admin/refundlog_list.htm", "", params, page, mv);
		mv.addObject("vo", vo);

		return mv;
	}

	// 退款2
	@SecurityMapping(title = "平台退款完成", value = "/admin/refund_finish.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/refund_finish.htm")
	public ModelAndView predeposit_modify_save(HttpServletRequest request, HttpServletResponse response,
			String user_id, String amount, String type, String info, String list_url, String refund_user_id,
			String obj_id, String gi_id, String orderPaymentId) {

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (configService.getSysConfig().getDeposit()) {
			if (user_id == null || user_id.equals(""))
				user_id = refund_user_id;

			refundLogService.refunding(user_id, amount, info, refund_user_id, obj_id, SecurityUserHolder
					.getCurrentUser().getId());

			if (obj_id != null && !obj_id.equals("")) {// 商品退款
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/refund_list.htm");
			}
//			if (gi_id != null && !gi_id.equals("")) {// 消费码退款
//				GroupInfo gi = groupinfoService.getObjById(CommUtil
//						.null2Long(gi_id));
//				gi.setStatus(7);// 退款完成
//				this.groupinfoService.update(gi);
//				OrderForm of = this.orderFormService.getObjById(gi
//						.getOrder_id());
//				if (of.getOrder_form() == 0) {// 商家订单生成退款结算账单
//					Store store = this.storeService.getObjById(CommUtil
//							.null2Long(of.getStore_id()));
//					PayoffLog pol = new PayoffLog();
//					pol.setPl_sn("pl"
//							+ CommUtil.formatTime("yyyyMMddHHmmss", new Date())
//							+ store.getUser().getId());
//					pol.setAddTime(new Date());
//					pol.setGoods_info(of.getReturn_goods_info());
//					pol.setRefund_user_id(gi.getUser_id());
//					pol.setSeller(store.getUser());
//					pol.setRefund_userName(gi.getUser_name());
//					pol.setPayoff_type(-1);
//					pol.setPl_info("退款完成");
//					BigDecimal price = BigDecimal.valueOf(CommUtil
//							.null2Double(amount)); // 商品的原价
//					BigDecimal final_money = BigDecimal.valueOf(CommUtil
//							.subtract(0, price));
//					pol.setTotal_amount(final_money);
//					// 将订单中group_info（{}）转换为List<Map>([{}])
//					List<Map> Map_list = new ArrayList<Map>();
//					Map group_map = this.orderFormTools.queryGroupInfo(of
//							.getGroup_info());
//					Map_list.add(group_map);
//					pol.setReturn_goods_info(Json.toJson(Map_list,
//							JsonFormat.compact()));
//					pol.setO_id(of.getId().toString());
//					pol.setOrder_id(of.getOrder_id());
//					pol.setCommission_amount(BigDecimal.valueOf(0));
//					pol.setOrder_total_price(final_money);
//					this.payoffLogService.save(pol);
//
//					store.setStore_sale_amount(BigDecimal.valueOf(CommUtil
//							.subtract(store.getStore_sale_amount(), amount)));// 减少店铺本次结算总销售金额
//					store.setStore_payoff_amount(BigDecimal.valueOf(CommUtil
//							.subtract(store.getStore_payoff_amount(), price)));// 减少店铺本次结算总金额
//					this.storeService.update(store);
//					// 减少系统总销售金额、总结算金额
//					SysConfig sc = this.configService.getSysConfig();
//					sc.setPayoff_all_sale(BigDecimal.valueOf(CommUtil.subtract(
//							sc.getPayoff_all_sale(), amount)));
//					sc.setPayoff_all_amount(BigDecimal.valueOf(CommUtil
//							.subtract(sc.getPayoff_all_amount(),
//									CommUtil.mul(amount, 0))));
//					sc.setPayoff_all_amount_reality(BigDecimal.valueOf(CommUtil
//							.add(pol.getReality_amount(),
//									sc.getPayoff_all_amount_reality())));// 增加系统实际总结算
//					this.configService.update(sc);
//				}
//				// 生成退款日志
//				RefundLog r_log = new RefundLog();
//				r_log.setAddTime(new Date());
//				r_log.setRefund_id(CommUtil.formatTime("yyyyMMddHHmmss",
//						new Date()) + user.getId());
//				r_log.setReturnLog_id(gi.getId());
//				r_log.setReturnService_id(gi.getGroup_sn());
//				r_log.setRefund(BigDecimal.valueOf(CommUtil.null2Double(amount)));
//				r_log.setRefund_log(info);
//				r_log.setRefund_type("预存款");
//				r_log.setRefund_user(SecurityUserHolder.getCurrentUser());
//				r_log.setReturnLog_userName(gi.getUser_name());
//				r_log.setReturnLog_userId(gi.getUser_id());
//				this.refundLogService.save(r_log);
//				String msg_content = "您的团购商品：" + gi.getLifeGoods().getGg_name()
//						+ "消费码已经成功退款，退款金额为："
//						+ gi.getLifeGoods().getGroup_price() + "，退款消费码:"
//						+ gi.getGroup_sn();
//				// 发送系统站内信
//				Message msg = new Message();
//				msg.setAddTime(new Date());
//				msg.setStatus(0);
//				msg.setType(0);
//				msg.setContent(msg_content);
//				msg.setFromUser(SecurityUserHolder.getCurrentUser());
//				msg.setToUser(user);
//				this.messageService.save(msg);
//				mv.addObject("op_title", "退款成功");
//				mv.addObject("list_url", CommUtil.getURL(request)
//						+ "/admin/groupinfo_refund_list.htm");
//			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}

		return mv;
	}

	/****
	 * 新的退款接口，可以直接替换
	 * 
	 * @param request
	 * @param response
	 * @param user_id
	 * @param amount
	 * @param type
	 * @param info
	 * @param list_url
	 * @param refund_user_id
	 * @param obj_id
	 * @param gi_id
	 * @param orderPaymentId
	 * @return
	 */
	@SecurityMapping(title = "平台退款完成", value = "/admin/refund_finish.htm*", rtype = "admin", rname = "退款管理", rcode = "refund_log", rgroup = "商户管理")
	@RequestMapping("/admin/_refund_finish.htm")
	public ModelAndView _predeposit_modify_save(HttpServletRequest request, HttpServletResponse response,
			String user_id, String amount, String type, String info, String list_url, String refund_user_id,
			String obj_id, String gi_id, String orderPaymentId) {

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);

		Payment payment = this.paymentService.findById(Long.parseLong(orderPaymentId));// 查询订单支付方式

		if (payment.getMark().equals(PaymentConstants.PAYMENT_MARK_YG_MONEY)) {
			// 表示云购币{针对CN用户}
			this.refundLogService.refunding2(user_id, amount, info, refund_user_id, obj_id,
					SecurityUserHolder.getCurrentUser().getId(), type);

		} else if (payment.getMark().equals(PaymentConstants.PAYMENT_MARK_BONUS)) {
			// 表示奖金支付{针对CN用户}支付订单需要修改订单的方式
			this.refundLogService.refunding3(user_id, amount, info, refund_user_id, obj_id,
					SecurityUserHolder.getCurrentUser().getId(), type);

		} else { // 其他支付{针对普通用户}

			if (configService.getSysConfig().getDeposit()) {

				if (user_id == null || user_id.equals(""))
					user_id = refund_user_id;

				refundLogService.refunding(user_id, amount, info, refund_user_id, obj_id, SecurityUserHolder
						.getCurrentUser().getId());

				if (obj_id != null && !obj_id.equals("")) {// 商品退款
					mv.addObject("list_url", CommUtil.getURL(request) + "/admin/refund_list.htm");
				}

			} else {
				mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", "系统未开启预存款");
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
			}
		}
		return mv;
	}
}
