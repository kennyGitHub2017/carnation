package vc.thinker.b2b2c.action.seller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.ParseException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.shop.tools.PayoffLogTools;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.vo.PayoffLogVO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: PayoffLogManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统结算管理类,商家可以和平台进行结算
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
 * @date 2014年5月5日
 * 
 * @version 1.0.1
 */
@Controller
public class PayoffLogsellerAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private PayoffLogService payoffLogService;
//	@Autowired
//	private UserService userService;
	@Autowired
	private PayoffLogTools payofflogTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private OrderFormService orderFormServer;
//	@Autowired
//	private GoodsCartService goodsCartService;
//	@Autowired
//	private GoodsService goodsService;
//	@Autowired
//	private IZTCGoldLogService ztcGoldLogService;
//	@Autowired
//	private StoreService storeService;
//	@Autowired
//	private TemplateService templateService;
//	@Autowired
//	private MessageService messageService;
//	@Autowired
//	private GroupLifeGoodsService groupLifeGoodsService;
//	@Autowired
//	private GroupInfoService groupInfoService;
	@Autowired
	private OrderFormService orderformService;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;

	/**
	 * 结算列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "结算列表页", value = "/seller/payofflog_list.htm*", rtype = "seller", display = false, rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_list.htm")
	public ModelAndView payofflog_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String tempStatus, PayoffLogVO vo, MyPage<PayoffLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/payofflog_list.html",
				configService.getSysConfig(), 0, request, response);

		if (tempStatus != null && !tempStatus.equals("")) {
			if (tempStatus.equals("not")) {
				vo.setStatus("1");
			}
			if (tempStatus.equals("underway")) {
				vo.setStatus("3");
			}
			if (tempStatus.equals("already")) {
				vo.setStatus("6");
			}
		} else {
			tempStatus = "not";
		}

		mv.addObject("tempStatus", tempStatus);
		page.setPageSize(20);
		vo.setSellerId(SecurityUserHolder.getCurrentUser().getId());

		this.payoffLogService.selectShopPageListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);// 当月总天数
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= maxDate; i++) {
			list.add(i);
		}
		SysConfig obj = configService.getSysConfig();
		String select = getSelectedDate(obj.getPayoffCount());
		String[] str = select.split(",");
		String ms = "";
		for (int i = 0; i < str.length; i++) {
			if (i + 1 == str.length) {
				ms = ms + str[i] + "日";
			} else {
				ms = ms + str[i] + "日、";
			}
		}
		mv.addObject("vo", vo);
		mv.addObject("payoff_mag_default",
				"今天是" + DateFormat.getDateInstance(DateFormat.FULL).format(new Date()) + "，本月的结算日期为" + ms
						+ "，请于结算日申请结算。");
		return mv;
	}

	private String getSelectedDate(int payoff_count) {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int allDate = a.get(Calendar.DATE);// 当月总天数
		String selected = "";
		if (payoff_count == 1) {
			selected = CommUtil.null2String(allDate);
		} else if (payoff_count == 2) {
			if (allDate == 31) {
				selected = "15,31";
			}
			if (allDate == 30) {
				selected = "15,30";
			}
			if (allDate == 29) {
				selected = "14,29";
			}
			if (allDate == 28) {
				selected = "14,28";
			}
		} else if (payoff_count == 3) {
			if (allDate == 31) {
				selected = "10,20,31";
			}
			if (allDate == 30) {
				selected = "10,20,30";
			}
			if (allDate == 29) {
				selected = "10,20,29";
			}
			if (allDate == 28) {
				selected = "10,20,28";
			}
		} else if (payoff_count == 4) {
			if (allDate == 31) {
				selected = "7,14,21,31";
			}
			if (allDate == 30) {
				selected = "7,14,21,30";
			}
			if (allDate == 29) {
				selected = "7,14,21,29";
			}
			if (allDate == 28) {
				selected = "7,14,21,28";
			}
		}
		return selected;
	}

//	/**
//	 * 验证今天是否为结算日，是返回true，不是返回false
//	 * 
//	 * @return
//	 */
//	@SuppressWarnings("deprecation")
//	private boolean validatePayoffDate() {
//		boolean payoff = false;
//		Date Payoff_data = this.configService.getSysConfig().getPayoffDate();
//		Date now = new Date();
//		now.setHours(0);
//		now.setMinutes(0);
//		now.setSeconds(0);
//		Date next = new Date();
//		next.setDate(next.getDate() + 1);
//		next.setHours(0);
//		next.setMinutes(0);
//		next.setSeconds(0);
//		if (Payoff_data.after(now) && Payoff_data.before(next)) {
//			payoff = true;
//		}
//		return payoff;
//	}

//	@SuppressWarnings("deprecation")
//	private void check_payoff_list() {
//		// 系统处理最近结算日期
//		SysConfig sysConfig = this.configService.getSysConfig();
//		List<PayoffLogBO> payofflogs = this.payoffLogService.selectPayoffLogNearest(0, sysConfig.getPayoffDate(), SecurityUserHolder.getCurrentUser().getId());
//		for (PayoffLogBO obj : payofflogs) {
//			OrderForm of = this.orderformService.getObjById(CommUtil.null2Long(obj.getoId()));
////			Date Payoff_date = this.configService.getSysConfig().getPayoffDate();
//			Date now = new Date();
//			now.setHours(0);
//			now.setMinutes(0);
//			now.setSeconds(0);
//			Date next = new Date();
//			next.setDate(next.getDate() + 1);
//			next.setHours(0);
//			next.setMinutes(0);
//			next.setSeconds(0);
//			if (of.getOrderCat() == 2) {
//				if (of.getOrderStatus() == 20) {// 团购消费码订单
//					obj.setStatus(1);// 设置当天可结算的账单
//				}
//			}
//			if (of.getOrderCat() == 0) {
//				if (of.getOrderStatus() == 50 || of.getOrderStatus() == 65) {// 账单对应订单已经评价完成或者不可评价时
//					obj.setStatus(1);// 设置当天可结算的账单
//				}
//				if (obj.getPayoffType() == -1) {// 账单为退款账单，系统自动判定该退款账单为申请状态
//					if (of.getOrderStatus() == 50
//							|| of.getOrderStatus() == 65) {// 账单对应订单已经评价完成或者不可评价时
//						obj.setStatus(3);
//						obj.setApplyTime(new Date());
//					}
//				}
//			}
//			this.payoffLogService.update(obj);
//		}
//	}

	/**
	 * 可结算列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "可结算列表页", value = "/seller/payofflog_ok_list.htm*", rtype = "seller", display = false, rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_ok_list.htm")
	public ModelAndView payofflog_ok_list(HttpServletRequest request, HttpServletResponse response,
			PayoffLogVO vo, MyPage<PayoffLogBO> page) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/payofflog_ok_list.html",
				configService.getSysConfig(), 0, request, response);
//		boolean verify = this.validatePayoffDate();
//		if (verify) {// 如果今天是结算日，更新可结算账单
//			this.check_payoff_list();
//		}
		vo.setStatus("1");
		vo.setTempStatus("ok");
		page.setPageSize(20);
		vo.setSellerId(SecurityUserHolder.getCurrentUser().getId());
		this.payoffLogService.selectShopPageListByVO(page, vo);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
//		boolean payoff = this.validatePayoffDate();
		mv.addObject("payoff", true);
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);
		a.roll(Calendar.DATE, -1);
		int maxDate = a.get(Calendar.DATE);// 当月总天数
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= maxDate; i++) {
			list.add(i);
		}
		SysConfig obj = configService.getSysConfig();
		String select = getSelectedDate(obj.getPayoffCount());
		String[] str = select.split(",");
		String ms = "";
		for (int i = 0; i < str.length; i++) {
			if (i + 1 == str.length) {
				ms = ms + str[i] + "日";
			} else {
				ms = ms + str[i] + "日、";
			}
		}
		mv.addObject("vo", vo);
//		mv.addObject("payoff_mag_default", "今天是" + DateFormat.getDateInstance(DateFormat.FULL).format(new Date()) + "，本月的结算日期为" + ms + "，请于结算日申请结算。");
		return mv;
	}

	/**
	 * 账单详情
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "账单详情", value = "/seller/payofflog_info.htm*", rtype = "seller", display = false, rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_info.htm")
	public ModelAndView payofflog_info(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage, String op) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/payofflog_info.html",
				configService.getSysConfig(), 0, request, response);
		if (id != null && !id.equals("")) {
			PayoffLog payofflog = this.payoffLogService.getObjById(Long.parseLong(id));
			if (SecurityUserHolder.getCurrentUser().getId().equals(payofflog.getSellerId())) {
				mv.addObject("payofflogTools", payofflogTools);
				mv.addObject("orderFormTools", orderFormTools);
				mv.addObject("obj", payofflog);
				mv.addObject("currentPage", currentPage);
				mv.addObject("op", op);
			} else {
				mv.addObject("list_url", CommUtil.getURL(request) + "/payofflog_list.htm");
				mv.addObject("op_title", "您没有该账单");
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
			}
		} else {
			mv.addObject("list_url", CommUtil.getURL(request) + "/payofflog_list.htm");
			mv.addObject("op_title", "账单不存在");
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
		}
		return mv;
	}

	/**
	 * 结算账单
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "账单结算", value = "/seller/payofflog_edit.htm*", rtype = "seller", display = false, rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_edit.htm")
	public String payofflog_edit(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage) {
		for (String id : mulitId.split(",")) {
			if (id != null && !id.equals("")) {
				PayoffLog obj = this.payoffLogService.getObjById(CommUtil.null2Long(id));
				if (obj != null
						&& returnGoodsLogService.selectReturningCountByOrderId(CommUtil.null2Long(obj
								.getoId())) < 1) {
					if (SecurityUserHolder.getCurrentUser().getId().equals(obj.getSellerId())
							&& obj.getStatus() == 1) {
						OrderForm of = this.orderFormServer.getObjById(CommUtil.null2Long(obj.getoId()));
						if (of != null) {
//							boolean payoff = this.validatePayoffDate();
							boolean goods = false;// 购物
							boolean group = false;// 团购
							if (of.getOrderStatus() == 40 || of.getOrderStatus() == 50
									|| of.getOrderStatus() == 65) {
								goods = true;
							}
							if (of.getOrderCat() == 2) {
								if (of.getOrderStatus() == 20) {// 团购消费码订单
									group = true;
								}
							}
							if (goods || group) {// 已经完成的订单，并且今天为结算日
								obj.setStatus(3);// 设置结算中
								obj.setApplyTime(new Date());
								this.payoffLogService.update(obj);
							}
						}
					}
				}
			}
		}
		return "redirect:payofflog_ok_list.htm?currentPage" + currentPage;
	}

	/**
	 * 批量统计账单
	 * 
	 * @param request
	 * @param response
	 * @param mulitId
	 * @throws ClassNotFoundException
	 */
	@SecurityMapping(title = "批量统计", value = "/seller/payofflog_ajax.htm*", rtype = "seller", display = false, rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_ajax.htm")
	public void payofflog_ajax(HttpServletRequest request, HttpServletResponse response, String mulitId)
			throws ClassNotFoundException {
		String[] ids = mulitId.split(",");
		double order_total_price = 0.00;// 账单总订单金额
		double commission_amount = 0.00;// 账单总佣金
		double total_amount = 0.00;// 账单总结算金额
		boolean error = true;
		for (String id : ids) {
			if (!id.equals("")) {
				PayoffLog obj = this.payoffLogService.getObjById(Long.parseLong(id));
				if (obj != null) {
					if (SecurityUserHolder.getCurrentUser().getId().equals(obj.getSellerId())) {
						total_amount = CommUtil.add(total_amount, obj.getTotalAmount());
						commission_amount = CommUtil.add(commission_amount, obj.getCommissionAmount());
						order_total_price = CommUtil.add(order_total_price, obj.getOrderTotalPrice());
					} else {
						error = false;
						break;
					}
				} else {
					error = false;
					break;
				}
			}
		}
		Map<String, Object> map = new HashMap<>();
		map.put("order_total_price", order_total_price);
		map.put("commission_amount", commission_amount);
		map.put("total_amount", total_amount);
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

	// 以excel形式导出账单数据
	@SecurityMapping(title = "账单数据导出", value = "/seller/payofflog_excel.htm*", rtype = "seller", rname = "我的账单", rcode = "payoff_seller", rgroup = "结算管理")
	@RequestMapping("/seller/payofflog_excel.htm")
	public void payofflog_excel(HttpServletRequest request, HttpServletResponse response, String tempStatus,
			PayoffLogVO vo) {

		if (tempStatus != null && !tempStatus.equals("")) {
			if (tempStatus.equals("not")) {
				vo.setStatus("0");
			}
			if (tempStatus.equals("underway")) {
				vo.setStatus("3");
			}
			if (tempStatus.equals("already")) {
				vo.setStatus("6");
			}
		} else {
			tempStatus = "not";
		}

		vo.setSellerId(SecurityUserHolder.getCurrentUser().getId());

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			HSSFWorkbook wb = payoffLogService.payofflogShopExcel(vo);
			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + excel_name + ".xls");
			OutputStream os = response.getOutputStream();
			wb.write(os);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}