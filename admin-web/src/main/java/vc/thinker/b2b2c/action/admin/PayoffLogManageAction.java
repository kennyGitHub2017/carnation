package vc.thinker.b2b2c.action.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.tools.PayoffLogTools;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.PayoffLogVO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.SellerBO;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: PayoffLogManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统结算管理类,只要设置一次每月结算次数，系统根据次数自动计算每月的结算日期，
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
public class PayoffLogManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PayoffLogService payofflogService;
	@Autowired
	private PayoffLogTools payofflogTools;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private SellerService sellerService;

	/**
	 * 结算设置
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "结算设置", value = "/admin/payofflog_set.htm*", rtype = "admin", rname = "结算设置", rcode = "admin_payoff_set", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_set.htm")
	public ModelAndView payofflog_set(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/payofflog_set.html", configService.getSysConfig(), 0,
				request, response);
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
		mv.addObject("ms", "今天是" + DateFormat.getDateInstance(DateFormat.FULL).format(new Date())
				+ "，本月的结算日期为" + ms + "，请于结算日申请结算。");
		mv.addObject("now", DateFormat.getDateInstance(DateFormat.FULL).format(new Date()));
		mv.addObject("list", list);
		return mv;
	}

	/**
	 * 结算设置切换月结算次数
	 * 
	 * @param request
	 * @param response
	 * @param payoff_type
	 * @throws ClassNotFoundException
	 */
	@SecurityMapping(title = "结算设置切换月结算次数", value = "/admin/payofflog_set_ajax.htm*", rtype = "admin", rname = "结算设置", rcode = "admin_payoff_set", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_set_ajax.htm")
	public void payofflog_set_ajax(HttpServletRequest request, HttpServletResponse response,
			String payoff_count) throws ClassNotFoundException {
		String selected = getSelectedDate(CommUtil.null2Int(payoff_count));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(selected);
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	/**
	 * 结算设置保存
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	@SecurityMapping(title = "结算设置保存", value = "/admin/payofflog_set_save.htm*", rtype = "admin", rname = "结算设置", rcode = "admin_payoff_set", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_set_save.htm")
	public ModelAndView payofflog_set_save(HttpServletRequest request, HttpServletResponse response, String id) {
		SysConfig obj = this.configService.getSysConfig();
		WebForm wf = new WebForm();
		SysConfig sysConfig = null;
		if (id.equals("")) {
			sysConfig = wf.toPo(request, SysConfig.class);
			sysConfig.setAddTime(new Date());
		} else {
			sysConfig = (SysConfig) wf.toPo(request, obj);
		}
		Date now = new Date();
		int now_date = now.getDate();
		String select = getSelectedDate(CommUtil.null2Int(sysConfig.getPayoffCount()));
		String str[] = select.split(",");
		for (String payoff_date : str) {
			if (CommUtil.null2Int(payoff_date) >= now_date) {
				now.setDate(CommUtil.null2Int(payoff_date));
				now.setHours(0);
				now.setMinutes(00);
				now.setSeconds(01);
				break;
			}
		}
		sysConfig.setPayoffDate(now);
		if (id.equals("")) {
			this.configService.save(sysConfig);
		} else {
			this.configService.update(sysConfig);
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "结算周期设置成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/payofflog_set.htm");
		return mv;
	}

	/**
	 * PayoffLog列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "账单列表", value = "/admin/payofflog_list.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_list.htm")
	public ModelAndView payofflog_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<PayoffLogBO> page, PayoffLogVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/payofflog_list.html", configService.getSysConfig(),
				0, request, response);
		// 刷新显示
		configService.refreshSysConfig();
//		PayoffLogQueryObject qo = new PayoffLogQueryObject(currentPage, mv,
//				orderBy, orderType);
//		String status2 = "0";
//		if (!StringUtils.isBlank(vo.getStatus())) 
//		{
//			status2 = CommUtil.null2String(vo.getStatus());
//		}
//		vo.setStatus(status2);
//		
//		qo.addQuery("obj.status",
//				new SysMap("status", CommUtil.null2Int(status2)), "=");
//		if (type != null && !type.equals("")) {
//			if (type_data != null && !type_data.equals("")) {
//				if (type.equals("payoff")) {
//					qo.addQuery("obj.pl_sn", new SysMap("pl_sn", type_data),
//							"=");
//				}
//				if (type.equals("seller")) {
//					qo.addQuery("obj.seller.userName", new SysMap("userName",
//							type_data), "=");
//				}
//				if (type.equals("order")) {
//					qo.addQuery("obj.order_id", new SysMap("order_id",
//							type_data), "=");
//				}
//			}
//			mv.addObject("type", type);
//			mv.addObject("type_data", type_data);
//		}
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.MONTH, 0);
//		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
//		String first = format.format(c.getTime());
//		Calendar ca = Calendar.getInstance();
//		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//		String last = format.format(ca.getTime());
//		if (StringUtils.isBlank(vo.getAddTimeBeginTime())) 
//		{
//			vo.setAddTimeBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getAddTimeEndTime())) 
//		{
//			vo.setAddTimeEndTime(last);
//		}
//		if (StringUtils.isBlank(vo.getApplyBeginTime())) 
//		{
//			vo.setApplyBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getApplyEndTime())) 
//		{
//			vo.setApplyEndTime(last);
//		}
//		if (StringUtils.isBlank(vo.getCompleteBeginTime())) 
//		{
//			vo.setCompleteBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getCompleteEndTime())) 
//		{
//			vo.setCompleteEndTime(last);
//		}
//		if (status2 != null && !status2.equals("")) {
//			if (status2.equals("0")) {
//				qo.addQuery(
//						"obj.addTime",
//						new SysMap("addTime1", CommUtil
//								.formatDate(addTime_beginTime)), ">=");
//				qo.addQuery(
//						"obj.addTime",
//						new SysMap("addTime2", CommUtil
//								.formatDate(addTime_endTime)), "<=");
//				qo.setOrderBy("addTime");
//			}
//			if (status2.equals("3")) {
//				qo.addQuery("obj.apply_time", new SysMap("apply_time2",
//						CommUtil.formatDate(apply_endTime)), "<=");
//				qo.addQuery("obj.apply_time", new SysMap("apply_time1",
//						CommUtil.formatDate(apply_beginTime)), ">=");
//				qo.setOrderBy("apply_time");
//			}
//			if (status2.equals("6")) {
//				qo.addQuery("obj.complete_time", new SysMap("complete_endTime",
//						CommUtil.formatDate(complete_endTime)), "<=");
//				qo.addQuery(
//						"obj.complete_time",
//						new SysMap("complete_beginTime", CommUtil
//								.formatDate(complete_beginTime)), ">=");
//				qo.setOrderBy("complete_time");
//			}
//		}
//		qo.setOrderType("desc");
//		IPageList pList = this.payofflogService.list(qo);
		getPayoffLogVO(vo);
		payofflogService.selectPayoffLogListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
//		mv.addObject("begin_price", begin_price);
//		mv.addObject("end_price", end_price);
//		mv.addObject("addTime_beginTime", addTime_beginTime);
//		mv.addObject("addTime_endTime", addTime_endTime);
//		mv.addObject("apply_beginTime", apply_beginTime);
//		mv.addObject("apply_endTime", apply_endTime);
//		mv.addObject("complete_beginTime", complete_beginTime);
//		mv.addObject("complete_endTime", complete_endTime);
		mv.addObject("status", vo.getStatus());
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	/**
	 * 账单详情
	 * 
	 * @return
	 */
	@SecurityMapping(title = "账单详情", value = "/admin/payofflog_view.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_view.htm")
	public ModelAndView payofflog_view(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/payofflog_view.html", configService.getSysConfig(),
				0, request, response);
		PayoffLogBO obj = this.payofflogService.selectBOByVO(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("payofflogTools", payofflogTools);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 账单结算
	 * 
	 * @return
	 */
	@SecurityMapping(title = "账单结算", value = "/admin/payofflog_edit.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_edit.htm")
	public ModelAndView payofflog_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/payofflog_edit.html", configService.getSysConfig(),
				0, request, response);
		PayoffLogBO obj = this.payofflogService.selectBOByVO(CommUtil.null2Long(id));
		mv.addObject("obj", obj);
		mv.addObject("payofflogTools", payofflogTools);
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	/**
	 * 账单结算保存
	 * 
	 * @return
	 */
	@SecurityMapping(title = "账单结算保存", value = "/admin/payofflog_save.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_save.htm")
	public String payofflog_save(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		PayoffLog obj = this.payofflogService.getObjById(CommUtil.null2Long(id));
		SellerBO seller = sellerService.findByUid(obj.getSellerId());
		StoreBO store = storeService.getObjById(seller.getStoreId());
		WebForm wf = new WebForm();
		obj = (PayoffLog) wf.toPo(request, obj);
		obj.setAdminId(SecurityUserHolder.getCurrentUserId());
		payofflogService.orderSettlement(obj, store.getId());
		// 结算就是将商家的应得的钱给到商家
		if (currentPage == null) {
			currentPage = "1";
		}

//		PayoffLog payOffLog = payofflogService.getObjById(obj.getId());
//		SellerBO seller = sellerService.findByUid(payOffLog.getSellerId());
//		StoreBO store = storeService.getObjById(seller.getStoreId());
//		Store storeToUpdate = new Store();
//		storeToUpdate.setId(store.getId());
//		storeToUpdate.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStoreSaleAmount(), obj.getOrderTotalPrice())));// 减少店铺本次结算总销售金额
//		storeToUpdate.setStoreCommissionAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStoreCommissionAmount(), obj.getCommissionAmount())));// 减少店铺本次结算总佣金
//		storeToUpdate.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStorePayoffAmount(), obj.getTotalAmount())));// 减少店铺本次结算金额
//		this.storeService.update(store);
//		SysConfig sc = this.configService.getSysConfig();
//		sc.setPayoffAllAmount(BigDecimal.valueOf(CommUtil.add(obj.getTotalAmount(), sc.getPayoffAllAmount())));// 增加系统总结算（应结算）
//		sc.setPayoffAllAmountReality(BigDecimal.valueOf(CommUtil.add(obj.getRealityAmount(), sc.getPayoffAllAmountReality())));// 增加系统实际总结算
//		this.configService.update(sc);

		return "redirect:payofflog_list.htm?currentPage=" + currentPage;
	}

	/**
	 * PayoffLog列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "账单列表", value = "/admin/payofflog_stat.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_stat.htm")
	public void payofflog_stat(HttpServletRequest request, HttpServletResponse response, String currentPage,
			PayoffLogVO vo) {
//		PayoffLogQueryObject qo = new PayoffLogQueryObject();
//		String status2 = "0";
//		if (vo.getStatus() != null && !vo.getStatus().equals("")) {
//			status2 = CommUtil.null2String(vo.getStatus());
//		}
//		qo.addQuery("obj.status",
//				new SysMap("status", CommUtil.null2Int(status2)), "=");
//		if (type != null && !type.equals("")) {
//			if (type_data != null && !type_data.equals("")) {
//				if (type.equals("payoff")) {
//					qo.addQuery("obj.pl_sn", new SysMap("pl_sn", type_data),
//							"=");
//				}
//				if (type.equals("seller")) {
//					qo.addQuery("obj.seller.userName", new SysMap("userName",
//							type_data), "=");
//				}
//				if (type.equals("order")) {
//					qo.addQuery("obj.order_id", new SysMap("order_id",
//							type_data), "=");
//				}
//			}
//		}
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.MONTH, 0);
//		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
//		String first = format.format(c.getTime());
//		Calendar ca = Calendar.getInstance();
//		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//		String last = format.format(ca.getTime());
//		if (StringUtils.isBlank(vo.getAddTimeBeginTime())) 
//		{
//			vo.setAddTimeBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getAddTimeEndTime())) 
//		{
//			vo.setAddTimeEndTime(last);
//		}
//		if (StringUtils.isBlank(vo.getApplyBeginTime())) 
//		{
//			vo.setApplyBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getApplyEndTime())) 
//		{
//			vo.setApplyEndTime(last);
//		}
//		if (StringUtils.isBlank(vo.getCompleteBeginTime())) 
//		{
//			vo.setCompleteBeginTime(first);
//		}
//		if (StringUtils.isBlank(vo.getCompleteEndTime())) 
//		{
//			vo.setCompleteEndTime(last);
//		}
		getPayoffLogVO(vo);
		Map<String, Object> map = payofflogService.selectPayoffLogStatByVO(vo);
//		List<PayoffLog> objs = pList.getResult();
//		double all_order_price = 0.00;// 账单总金额
//		double all_commission_price = 0.00;// 账单总佣金
//		double all_total_amount = 0.00;// 账单总结算金额
//		boolean code = false;
//		if (objs != null) {
//			code = true;
//			for (PayoffLog obj : objs) {
//				all_order_price = CommUtil.add(all_order_price,
//						obj.getOrder_total_price());
//				all_commission_price = CommUtil.add(all_commission_price,
//						obj.getCommission_amount());
//				all_total_amount = CommUtil.add(all_total_amount,
//						obj.getTotal_amount());
//			}
//		}
//		Map map = new HashMap();
//		map.put("all_order_price", all_order_price);
//		map.put("all_commission_price", all_commission_price);
//		map.put("all_total_amount", all_total_amount);
//		if (objs != null) {
//			map.put("data_size", objs.size());
//		}
		if (Integer.parseInt(map.get("data_size").toString()) > 0) {
			map.put("code", true);
		} else {
			map.put("code", false);
		}

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
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 * @param userName
	 */

	// 以excel形式导出账单数据
	@SecurityMapping(title = "账单数据导出", value = "/admin/payofflog_excel.htm*", rtype = "admin", rname = "结算管理", rcode = "admin_payoff", rgroup = "财务管理")
	@RequestMapping("/admin/payofflog_excel.htm")
	public void payofflog_excel(HttpServletRequest request, HttpServletResponse response, PayoffLogVO vo) {

		getPayoffLogVO(vo);
//		if (begin_price != null && !begin_price.equals("")) {
//			qo.addQuery("obj.total_amount", new SysMap("begin_price",
//					BigDecimal.valueOf(CommUtil.null2Double(begin_price))),
//					">=");
//		}
//		if (end_price != null && !end_price.equals("")) {
//			qo.addQuery(
//					"obj.total_amount",
//					new SysMap("end_price", BigDecimal.valueOf(CommUtil
//							.null2Double(end_price))), "<=");
//		}
//		if (status2 != null && !status2.equals("")) {
//			if (status2.equals("0")) {
//				qo.addQuery(
//						"obj.addTime",
//						new SysMap("addTime1", CommUtil
//								.formatDate(addTime_beginTime)), ">=");
//				qo.addQuery(
//						"obj.addTime",
//						new SysMap("addTime2", CommUtil
//								.formatDate(addTime_endTime)), "<=");
//				qo.setOrderBy("addTime");
//			}
//			if (status2.equals("3")) {
//				qo.addQuery("obj.apply_time", new SysMap("apply_time2",
//						CommUtil.formatDate(apply_endTime)), "<=");
//				qo.addQuery("obj.apply_time", new SysMap("apply_time1",
//						CommUtil.formatDate(apply_beginTime)), ">=");
//				qo.setOrderBy("apply_time");
//			}
//			if (status2.equals("6")) {
//				qo.addQuery("obj.complete_time", new SysMap("complete_endTime",
//						CommUtil.formatDate(complete_endTime)), "<=");
//				qo.addQuery(
//						"obj.complete_time",
//						new SysMap("complete_beginTime", CommUtil
//								.formatDate(complete_beginTime)), ">=");
//				qo.setOrderBy("complete_time");
//			}
//		}
//		qo.setOrderType("desc");
//		IPageList pList = this.payofflogService.list(qo);
//		if (pList.getResult() != null) {
//			List<PayoffLog> datas = pList.getResult();

		HSSFWorkbook wb = payofflogService.payofflogExcel(vo);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String excel_name = sdf.format(new Date());
		try {
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
//		}
	}

	private void getPayoffLogVO(PayoffLogVO vo) {
		String status2 = "0";
		if (vo.getStatus() != null && !vo.getStatus().equals("")) {
			status2 = CommUtil.null2String(vo.getStatus());
		}
		vo.setStatus(status2);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		String first = format.format(c.getTime());
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
		String last = format.format(ca.getTime());
		if (StringUtils.isBlank(vo.getBeginTime())) {
			vo.setBeginTime(first);
		}
		if (StringUtils.isBlank(vo.getEndTime())) {
			vo.setEndTime(last);
		}

		if ("0".equals(vo.getStatus())) {
			vo.setStatus("1");
			vo.setTempStatus("ok");
		}

		if (vo.getStatus().equals(1)) {
			vo.setBeginTime(null);
			vo.setEndTime(null);
		}
	}
}