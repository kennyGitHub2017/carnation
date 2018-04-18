package vc.thinker.b2b2c.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.integral.service.IntegralGoodsCartService;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.integral.tools.IntegralViewTools;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.order.tools.PayTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.pay.tools.PaymentTools;
import com.sinco.carnation.shop.bo.IntegralGoodsCartBO;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.bo.PaymentBO;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsCart;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.exception.MoneyPasswordNullConsumption;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.service.AddressService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * <p>
 * Title: IntegralViewAction.java
 * </p>
 * <p>
 * Description:积分商城控制器,用来控制积分商城所有前端展示、兑换、订单信息
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 深圳市新科聚合网络技术有限公司 www.thinker.vc
 * </p>
 * 
 * @author thinker,jy
 * 
 * @date 2014-4-30
 * 
 * @version 1.0.1
 */
@Controller
public class IntegralViewAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private IntegralGoodsService integralGoodsService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
	@Autowired
	private IntegralGoodsCartService integralGoodsCartService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private AreaServiceImpl areaServiceImpl;
	@Autowired
	private PaymentTools paymentTools;
	@Autowired
	private PayTools payTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private IntegralViewTools integralViewTools;
	@Autowired
	private PredepositLogService predepositLogService;
	private static final String INTEGRAL_GOODS_CART = "integral_goods_cart";

	/**
	 * 积分商城首页
	 * 
	 * @param request
	 * @param response
	 * @param begin
	 * @param end
	 * @param rank
	 * @return
	 */
	@SuppressWarnings({"rawtypes"})
	@RequestMapping("/integral/index.htm")
	public ModelAndView integral(HttpServletRequest request, HttpServletResponse response, String begin,
			String end, String rank) {
		ModelAndView mv = new JModelAndView("integral.html", configService.getSysConfig(), 1, request,
				response);
		if (configService.getSysConfig().getIntegralStore()) {
			boolean recommend = true;
			boolean show = true;

			// 加载推荐商品
			List recommend_igs = new ArrayList();
			if (begin != null && !begin.equals("") && end != null && !end.equals("")) {
				if (end.equals("0")) {
					recommend_igs = integralGoodsService.searchB(recommend, show, CommUtil.null2Int(begin));
				} else {
					recommend_igs = integralGoodsService.searchC(recommend, show, CommUtil.null2Int(begin),
							CommUtil.null2Int(end));
				}
			} else {
				recommend_igs = integralGoodsService.searchA(recommend, show);
			}
			mv.addObject("recommend_igs", recommend_igs);

			mv.addObject("exchange_igs", integralGoodsService.selectForDesc()); // 加载兑换排行榜商品

			// 获取用户积分
			mv.addObject("user", userCustomerService.queryUserByUid(SecurityUserHolder.getCurrentUserId()));

			mv.addObject("integral_cart", request.getSession(false).getAttribute(INTEGRAL_GOODS_CART));
			mv.addObject("integralViewTools", integralViewTools);
			if (rank != null)
				mv.addObject("rank", rank);
			else
				mv.addObject("rank", 0);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	/**
	 * 兑换商品的详情页面
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/integral/view.htm")
	public ModelAndView integral_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("integral_view.html", configService.getSysConfig(), 1, request,
				response);
		if (configService.getSysConfig().getIntegralStore()) {
			IntegralGoods obj = integralGoodsService.getObjById(CommUtil.null2Long(id));
			if (obj != null) {
				obj.setIgClickCount(obj.getIgClickCount() + 1);
				integralGoodsService.update(obj);
				List<Map> gcs = integralGoodsCartService.selectByTop20();
				mv.addObject("gcs", gcs);
				mv.addObject("obj", integralGoodsService.selectByKeyForMap(CommUtil.null2Long(id)));

				// 获取用户积分
				mv.addObject("user",
						userCustomerService.queryUserByUid(SecurityUserHolder.getCurrentUserId()));
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "不存在该商品，参数错误");
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	/**
	 * 积分兑换物品
	 * 
	 * @param request
	 * @param response
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param rang_begin
	 * @param rang_end
	 * @param rank
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/integral/list.htm")
	public ModelAndView integral_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String rang_begin, String rang_end,
			String rank) {
		ModelAndView mv = new JModelAndView("integral_list.html", configService.getSysConfig(), 1, request,
				response);
		if (configService.getSysConfig().getIntegralStore()) {
			mv.addObject("rang_begin", rang_begin);
			mv.addObject("rang_end", rang_end);

			// 兑换商品列表
			MyPage<Map> page = new MyPage<Map>();
			page.setPageSize(16);
			page.setCurrentPage(StringUtils.isEmpty(currentPage) ? 0 : Integer.parseInt(currentPage));
			integralGoodsService.selectForList(orderType, rang_begin, rang_end, page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

			mv.addObject("exchange_igs", integralGoodsService.selectForDesc()); // 加载兑换排行榜商品

			// 获取用户积分
			if (SecurityUserHolder.getCurrentUser() != null) {
				mv.addObject("user",
						userCustomerService.queryUserByUid(SecurityUserHolder.getCurrentUserId()));
			}

			mv.addObject("integral_cart", request.getSession(false).getAttribute(INTEGRAL_GOODS_CART));
			mv.addObject("integralViewTools", integralViewTools);
			if (rank != null)
				mv.addObject("rank", rank);
			else
				mv.addObject("rank", 0);
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	/**
	 * 积分兑换第一步
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param exchange_count
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@SecurityMapping(title = "积分兑换第一步", value = "/integral/exchange1.htm*", rtype = "buyer", rname = "积分兑换", rcode = "integral_exchange", rgroup = "积分兑换")
	@RequestMapping("/integral/exchange1.htm")
	public ModelAndView integral_exchange1(HttpServletRequest request, HttpServletResponse response,
			String id, Integer exchange_count) {
		ModelAndView mv = new JModelAndView("integral_exchange1.html", configService.getSysConfig(), 1,
				request, response);
		if (exchange_count == null || exchange_count == 0)
			exchange_count = 1;

		if (configService.getSysConfig().getIntegralStore()) {
			long userId = SecurityUserHolder.getCurrentUserId();
			Object[] rs = integralGoodsService.singleGoods(id, exchange_count, userId);
			int exchange_status = (int) rs[0];
			IntegralGoods obj = (IntegralGoods) rs[1];
			UserCustomerBO user = (UserCustomerBO) rs[2];

			if (obj != null) {
				if (exchange_status != 0) {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("url", CommUtil.getURL(request) + "/integral/view_" + id + ".htm");
				}

				if (exchange_status == -1)
					mv.addObject("op_title", "库存数量不足，重新选择兑换数量");
				else if (exchange_status == -2)
					mv.addObject("op_title", "限制最多兑换" + obj.getIgLimitCount() + "，重新选择兑换数量");
				else if (exchange_status == -3)
					mv.addObject("op_title", "您的积分不足");
				else if (exchange_status == -4)
					mv.addObject("op_title", "兑换已经过期");
				else if (exchange_status == -5)
					mv.addObject("op_title", "您的会员等级不够");
			}

			if (exchange_status == 0) {
				List<IntegralGoodsCartBO> integral_goods_cart = (List<IntegralGoodsCartBO>) request
						.getSession(false).getAttribute(INTEGRAL_GOODS_CART);
				if (integral_goods_cart == null) {
					integral_goods_cart = new ArrayList<IntegralGoodsCartBO>();
				}
				boolean add = obj == null ? false : true;
				for (IntegralGoodsCart igc : integral_goods_cart) {
					if (igc.getGoodsId().toString().equals(id)) {
						add = false;
						break;
					}
				}
				if (add) {
					IntegralGoodsCartBO gc = new IntegralGoodsCartBO();
					gc.setAddTime(new Date());
					gc.setCount(exchange_count);
					gc.setGoodsId(obj.getId());
					gc.setIntegralGoods(obj);
					gc.setTransFee(obj.getIgTransfee());
					gc.setIntegral(exchange_count * obj.getIgGoodsIntegral());
					integral_goods_cart.add(gc);
				}
				request.getSession(false).setAttribute(INTEGRAL_GOODS_CART, integral_goods_cart);
				int total_integral = 0;
				for (IntegralGoodsCartBO igc : integral_goods_cart) {
					total_integral = total_integral + igc.getIntegral();
				}
				mv.addObject("total_integral", total_integral);
				mv.addObject("integral_cart", integral_goods_cart);

				mv.addObject("user", user); // 获取用户积分
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	/**
	 * 删除选择好的待兑换的商品
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping("/integral/cart_remove.htm")
	public void integral_cart_remove(HttpServletRequest request, HttpServletResponse response, String id) {
		List<IntegralGoodsCartBO> igcs = (List<IntegralGoodsCartBO>) request.getSession(false).getAttribute(
				INTEGRAL_GOODS_CART);
		for (IntegralGoodsCartBO igc : igcs) {
			if (igc.getIntegralGoods().getId().toString().equals(id)) {
				igcs.remove(igc);
				break;
			}
		}
		int total_integral = 0;
		for (IntegralGoodsCart igc : igcs) {
			total_integral = total_integral + igc.getIntegral();
		}
		request.getSession(false).setAttribute(INTEGRAL_GOODS_CART, igcs);
		Map map = new HashMap();
		map.put("status", 100);
		map.put("total_integral", total_integral);
		map.put("size", igcs.size());
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

	/**
	 * 修改兑换商品的数量
	 * 
	 * @param request
	 * @param response
	 * @param goods_id
	 * @param count
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@RequestMapping("/integral/adjust_count.htm")
	public void integral_adjust_count(HttpServletRequest request, HttpServletResponse response,
			String goods_id, String count) {
		List<IntegralGoodsCartBO> igcs = (List<IntegralGoodsCartBO>) request.getSession(false).getAttribute(
				INTEGRAL_GOODS_CART);
		UserCustomerBO user = userCustomerService.queryUserByUid(SecurityUserHolder.getCurrentUserId());
		IntegralGoodsCart obj = null;
		int old_num = 0;
		int num = CommUtil.null2Int(count);
		for (IntegralGoodsCartBO igc : igcs) {
			if (igc.getIntegralGoods().getId().toString().equals(goods_id)) {
				IntegralGoods ig = igc.getIntegralGoods();
				old_num = igc.getCount();
				if (num > ig.getIgGoodsCount()) {
					num = ig.getIgGoodsCount();
				}
				if (ig.getIgLimitType() && ig.getIgLimitCount() < num) {
					num = ig.getIgLimitCount();
				}
				igc.setCount(num);
				igc.setIntegral(igc.getIntegralGoods().getIgGoodsIntegral() * CommUtil.null2Int(num));
				obj = igc;
				break;
			}
		}

		int total_integral = 0;
		for (IntegralGoodsCart igc : igcs) {
			total_integral = total_integral + igc.getIntegral();
		}
		// 判断积分
		if (total_integral > user.getIntegral()) {
			for (IntegralGoodsCartBO igc : igcs) {
				if (igc.getIntegralGoods().getId().toString().equals(goods_id)) {
					num = old_num;
					igc.setCount(num);
					igc.setIntegral(igc.getIntegralGoods().getIgGoodsIntegral() * CommUtil.null2Int(num));
					obj = igc;
					break;
				}
			}
			total_integral = 0;
			for (IntegralGoodsCart igc : igcs) {
				total_integral = total_integral + igc.getIntegral();
			}
		}
		request.getSession(false).setAttribute(INTEGRAL_GOODS_CART, igcs);
		Map map = new HashMap();
		map.put("total_integral", total_integral);
		map.put("integral", obj.getIntegral());
		map.put("count", num);
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

	/**
	 * 积分兑换第二步
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @param exchange_count
	 * @return
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	@SecurityMapping(title = "积分兑换第二步", value = "/integral/exchange2.htm*", rtype = "buyer", rname = "积分兑换", rcode = "integral_exchange", rgroup = "积分兑换")
	@RequestMapping("/integral/exchange2.htm")
	public ModelAndView integral_exchange2(HttpServletRequest request, HttpServletResponse response,
			String id, String exchange_count) {
		ModelAndView mv = new JModelAndView("integral_exchange2.html", configService.getSysConfig(), 1,
				request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			List<IntegralGoodsCartBO> igcs = (List<IntegralGoodsCartBO>) request.getSession(false)
					.getAttribute(INTEGRAL_GOODS_CART);
			if (igcs != null) {
				// 获取用户积分
				UserCustomerBO user = userCustomerService.queryUserByUid(SecurityUserHolder
						.getCurrentUserId());

				List<Map> addrs = addressService.selectByTop100(SecurityUserHolder.getCurrentUserId()
						.intValue());
				if (addrs.size() >= 1) {
					mv.addObject("addrs", addrs);
				}
				mv.addObject("igcs", igcs == null ? new ArrayList<IntegralGoodsCartBO>() : igcs);
				int total_integral = 0;
				double trans_fee = 0;
				for (IntegralGoodsCart igc : igcs) {
					total_integral = total_integral + igc.getIntegral();
					trans_fee = CommUtil.null2Double(igc.getTransFee()) + trans_fee;
				}
				if (user.getIntegral() < total_integral) {
					mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
					mv.addObject("op_title", "兑换积分不足");
					mv.addObject("url", CommUtil.getURL(request) + "/integral/index.htm");
					return mv;
				}
				mv.addObject("trans_fee", trans_fee);
				mv.addObject("total_integral", total_integral);
				String integral_order_session = CommUtil.randomString(32);
				mv.addObject("integral_order_session", integral_order_session);
				request.getSession(false).setAttribute("integral_order_session", integral_order_session);
				List<Map> areas = areaServiceImpl.selectByProvince();
				mv.addObject("areas", areas);
			} else {
				mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
				mv.addObject("op_title", "兑换购物车为空");
				mv.addObject("url", CommUtil.getURL(request) + "/integral/index.htm");
			}
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	/**
	 * 积分兑换第三步
	 * 
	 * @param request
	 * @param response
	 * @param addr_id
	 * @param igo_msg
	 * @param integral_order_session
	 * @param area_id
	 * @param trueName
	 * @param area_info
	 * @param zip
	 * @param telephone
	 * @param mobile
	 * @return
	 */
	@SuppressWarnings({"unchecked"})
	@SecurityMapping(title = "积分兑换第三步", value = "/integral/exchange3.htm*", rtype = "buyer", rname = "积分兑换", rcode = "integral_exchange", rgroup = "积分兑换")
	@RequestMapping("/integral/exchange3.htm")
	public ModelAndView integral_exchange3(HttpServletRequest request, HttpServletResponse response,
			String addr_id, String igo_msg, String integral_order_session, String area_id, String trueName,
			String area_info, String zip, String telephone, String mobile) {
		SysConfigBO config = configService.getSysConfig();
		ModelAndView mv = new JModelAndView("integral_exchange3.html", config, 1, request, response);
		if (config.getIntegralStore()) {
			List<IntegralGoodsCartBO> igcs = (List<IntegralGoodsCartBO>) request.getSession(false)
					.getAttribute(INTEGRAL_GOODS_CART);
			String integral_order_session1 = CommUtil.null2String(request.getSession(false).getAttribute(
					"integral_order_session"));
			if (integral_order_session1.equals("")) {
				mv = new JModelAndView("error.html", config, 1, request, response);
				mv.addObject("op_title", "表单已经过期");
				mv.addObject("url", CommUtil.getURL(request) + "/integral.htm");
			} else {
				long userId = SecurityUserHolder.getCurrentUserId();
				if (integral_order_session1.equals(integral_order_session.trim())) {
					if (igcs != null) {
						// 封装新地址的实体
						Address addr = new Address();
						addr.setAddTime(new Date());
						addr.setAreaInfo(area_info);
						addr.setMobile(mobile);
						addr.setTelephone(telephone);
						addr.setTrueName(trueName);
						addr.setZip(zip);
						addr.setAreaId(CommUtil.null2Long(area_id));
						addr.setUserId(userId);

						IntegralGoodsOrder order = new IntegralGoodsOrder();

						int result;
						try {
							result = integralGoodsService.exchange(igcs, addr_id, addr, igo_msg, userId,
									order);
						} catch (ServiceException e) {
							mv = new JModelAndView("error.html", config, 1, request, response);
							mv.addObject("op_title", e.getMessage());
							mv.addObject("url", CommUtil.getURL(request) + "/integral/index.htm");

							return mv;
						}

						if (result == 1) { // 无运费
							mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
							mv.addObject("order", order);
						} else if (result == 2) { // 有运费
							mv = new JModelAndView("integral_exchange4.html", config, 1, request, response);
							mv.addObject("obj", order);
							mv.addObject("paymentTools", paymentTools);
						}

						request.getSession(false).removeAttribute(INTEGRAL_GOODS_CART);
					} else {
						mv = new JModelAndView("error.html", config, 1, request, response);
						mv.addObject("op_title", "兑换购物车为空");
						mv.addObject("url", CommUtil.getURL(request) + "/integral/index.htm");
					}
				} else {
					mv = new JModelAndView("error.html", config, 1, request, response);
					mv.addObject("op_title", "参数错误，订单提交失败");
					mv.addObject("url", CommUtil.getURL(request) + "/integral/index.htm");
				}
			}
		} else {
			mv = new JModelAndView("error.html", config, 1, request, response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		return mv;
	}

	@SecurityMapping(title = "积分订单支付", value = "/integral/order_pay.htm*", rtype = "buyer", rname = "积分兑换", rcode = "integral_exchange", rgroup = "积分兑换")
	@RequestMapping("/integral/order_pay.htm")
	public ModelAndView integral_order_pay(HttpServletRequest request, HttpServletResponse response,
			String payType, String integral_order_id, boolean isAvailableBalance, String paymentPassword) {
		ModelAndView mv = null;

		if (isAvailableBalance && StringUtils.isBlank(paymentPassword)) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "支付密码不能为空");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");

			return mv;
		}

		Long uid = SecurityUserHolder.getCurrentUserId();

		try {
			IntegralGoodsOrderBO order = integralGoodsOrderService.orderPay(payType,
					CommUtil.null2Long(integral_order_id), uid, isAvailableBalance, paymentPassword);
			// 如果已经完成支付
			if (order.getIgoStatus() >= IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED) {
				mv = new JModelAndView("integral_order_finish.html", configService.getSysConfig(), 1,
						request, response);
				mv.addObject("obj", order);
				return mv;
			} else {
				String type = PaymentConstants.ORDER_TYPE_INTEGRAL;
				mv = new JModelAndView("line_pay.html", configService.getSysConfig(), 1, request, response);
				// 如果云豆支付
				if (PaymentConstants.PAYMENT_MARK_BALANCE.equals(order.getIgoPayment())) {
					mv.addObject("cash_id", order.getCashId());

					// 云豆支付的支付方式id,在云豆充值记录上
					PredepositBO predeposit = predepositService.findBOById(order.getCashId());
					mv.addObject("payment_id", predeposit.getPaymentId());

					type = PaymentConstants.ORDER_TYPE_CASH;
				} else {
					// 如果在线支付
					mv.addObject("integral_order_id", order.getId());
					type = PaymentConstants.ORDER_TYPE_INTEGRAL;
					PaymentBO onlinePayment = paymentService.findByMark(order.getIgoPayment());
					mv.addObject("payment_id", onlinePayment.getId());
				}

				String[] tPayType = payType.split("-");
				String realPayType = tPayType[0];
				mv.addObject("payType", realPayType);
				if (realPayType.equals("alipayB") || realPayType.equals("alipayC")) {
					mv.addObject("bank", payType.replace("alipayB-", "").replace("alipayC-", ""));
				}
				mv.addObject("url", this.configService.getSysConfig().getAddress()); // 测试先修改为我自己ip
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
				mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			}
		}
		return mv;
	}

	/**
	 * 积分订单支付结果
	 * 
	 * @param request
	 * @param response
	 * @param order_id
	 * @return
	 */
	@SecurityMapping(title = "积分订单支付结果", value = "/integral/order_finish.htm*", rtype = "buyer", rname = "积分兑换", rcode = "integral_exchange", rgroup = "积分兑换")
	@RequestMapping("/integral/order_finish.htm")
	public ModelAndView integral_order_finish(HttpServletRequest request, HttpServletResponse response,
			String order_id, String orderNo) {
		ModelAndView mv = new JModelAndView("integral_order_finish.html", configService.getSysConfig(), 1,
				request, response);

		if (StringUtils.isNotBlank(order_id)) {
			IntegralGoodsOrder obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(order_id));
			mv.addObject("obj", obj);
		} else if (StringUtils.isNotBlank(orderNo)) {
			IntegralGoodsOrder obj = integralGoodsOrderService.findByIgoOrderSn(orderNo);
			mv.addObject("obj", obj);
		}
		return mv;
	}

	/**
	 * 重新提交订单支付
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "订单支付详情", value = "/integral/order_pay_view.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
	@RequestMapping("/integral/order_pay_view.htm")
	public ModelAndView integral_order_pay_view(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("integral_exchange4.html", configService.getSysConfig(), 1,
				request, response);
		IntegralGoodsOrder obj = integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (obj.getIgoStatus() == 0) {
			mv.addObject("obj", obj);
			mv.addObject("paymentTools", paymentTools);
			mv.addObject("url", CommUtil.getURL(request));
		} else if (obj.getIgoStatus() < 0) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "该订单已经取消！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		} else {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "该订单已经付款！");
			mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
		}

		return mv;
	}
}
