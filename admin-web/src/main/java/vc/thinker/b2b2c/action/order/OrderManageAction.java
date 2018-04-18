package vc.thinker.b2b2c.action.order;

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
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.kuaidi100.service.TransInfoService;
import com.sinco.carnation.operation.bo.CouponBO;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.OrderFormBO;
import com.sinco.carnation.shop.constants.OrderFormConstants;
import com.sinco.carnation.shop.vo.OrderFormVO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: OrderManageAction.java
 * </p>
 * 
 * <p>
 * Description:商城后台订单管理器
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
 * @date 2014-5-21
 * 
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class OrderManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private ExpressCompanyService ecService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private TransInfoService transInfoService;
	@Autowired
	private CouponInfoService couponInfoService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private CouponService couponService;
	
	@Autowired
	private PaymentService paymentService;
	
	private static final BigDecimal WHETHER_ENOUGH = new BigDecimal(0.00);
	
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
	
	@SecurityMapping(title = "订单设置", value = "/admin/set_order_confirm.htm*", rtype = "admin", rname = "订单设置", rcode = "set_order_confirm", rgroup = "系统管理")
	@RequestMapping("/admin/set_order_confirm.htm")
	public ModelAndView set_order_confirm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/set_order_confirm.html",
				configService.getSysConfig(), 0, request, response);
		return mv;
	}

	@SecurityMapping(title = "订单设置保存", value = "/admin/set_order_confirm_save.htm*", rtype = "admin", rname = "订单设置", rcode = "set_order_confirm", rgroup = "系统管理")
	@RequestMapping("/admin/set_order_confirm_save.htm")
	public ModelAndView set_order_confirm_save(HttpServletRequest request, HttpServletResponse response,
			SysConfig config) {
		if (config != null) {
			if (config.getId() != null && config.getId() > 0) {
				this.configService.update(config);
			}
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("op_title", "订单设置成功");
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/set_order_confirm.htm");
		return mv;
	}

	@SecurityMapping(title = "订单列表", value = "/admin/order_list.htm*", rtype = "admin", rname = "订单管理", rcode = "order_admin", rgroup = "商城管理")
	@RequestMapping("/admin/order_list.htm")
	public ModelAndView order_list(HttpServletRequest request, HttpServletResponse response, OrderFormVO vo,
			MyPage<OrderFormBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/order_list.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(10);
		if (!CommUtil.null2String(vo.getType()).equals("")) {
			if (vo.getType().equals("store")) {
				vo.setStoreName(vo.getTypeData());
			}
			if (vo.getType().equals("buyer")) {
				vo.setBuyerUsername(vo.getTypeData());
			}
			if (vo.getType().equals("order")) {
				vo.setOrderId(vo.getTypeData());
			}
		}
			orderFormService.findAllPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		// 是否显示催单功能
		boolean isShowReminderl = false;
		if ("20".equals(vo.getOrderStatus())) {
			isShowReminderl = true;
		}
		mv.addObject("vo", vo);
		mv.addObject("isShowReminderl", isShowReminderl);
		return mv;
	}

	@SecurityMapping(title = "手机充值订单列表", value = "/admin/order_recharge.htm*", rtype = "admin", rname = "充值列表", rcode = "ofcard_list", rgroup = "商城管理")
	@RequestMapping("/admin/order_recharge.htm")
	public ModelAndView order_recharge(HttpServletRequest request, HttpServletResponse response,
			String order_status, String beginTime, String endTime, String begin_price, String end_price,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/order_recharge.html", configService.getSysConfig(),
				0, request, response);
//		OrderFormQueryObject ofqo = new OrderFormQueryObject(currentPage, mv,
//				"addTime", "desc");
//		ofqo.addQuery("obj.order_cat", new SysMap("order_cat", 1), "=");// 这里只查手机充值订单
//		if (!CommUtil.null2String(order_status).equals("")) {
//			ofqo.addQuery("obj.order_status", new SysMap("order_status",
//					CommUtil.null2Int(order_status)), "=");
//		}
//		if (!CommUtil.null2String(beginTime).equals("")) {
//			ofqo.addQuery("obj.addTime",
//					new SysMap("beginTime", CommUtil.formatDate(beginTime)),
//					">=");
//		}
//		if (!CommUtil.null2String(endTime).equals("")) {
//			ofqo.addQuery("obj.addTime",
//					new SysMap("endTime", CommUtil.formatDate(endTime)), "<=");
//		}
//		if (!CommUtil.null2String(begin_price).equals("")) {
//			ofqo.addQuery("obj.totalPrice", new SysMap("begin_price",
//					BigDecimal.valueOf(CommUtil.null2Double(begin_price))),
//					">=");
//		}
//		if (!CommUtil.null2String(end_price).equals("")) {
//			ofqo.addQuery(
//					"obj.totalPrice",
//					new SysMap("end_price", BigDecimal.valueOf(CommUtil
//							.null2Double(end_price))), "<=");
//		}
//		IPageList pList = this.orderFormService.list(ofqo);
//		CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
//		mv.addObject("order_status", order_status);
//		mv.addObject("beginTime", beginTime);
//		mv.addObject("endTime", endTime);
//		mv.addObject("begin_price", begin_price);
//		mv.addObject("end_price", end_price);
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "订单详情", value = "/admin/order_view.htm*", rtype = "admin", rname = "订单管理", rcode = "order_admin", rgroup = "商城管理")
	@RequestMapping("/admin/order_view.htm")
	public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id,
			String view_type) {
		ModelAndView mv = new JModelAndView("admin/blue/order_view.html", configService.getSysConfig(), 0,
				request, response);
		OrderFormBO obj = this.orderFormService.fetch(CommUtil.null2Long(id));
		if (obj.getOrderCat() == OrderFormConstants.ORDER_CAT_MOBILE) {
			mv = new JModelAndView("admin/blue/order_recharge_view.html", configService.getSysConfig(), 0,
					request, response);
		} else {
			Store store = this.storeService.getObjById(CommUtil.null2Long(obj.getStoreId()));
			mv.addObject("store", store);
		}

		// 查询物流追踪信息
		if (obj.getShipCode() != null) {
			String exMark = this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_mark");
			try {
				List<String> list = this.getTrackingInfo(obj.getShipCode(), exMark);
				mv.addObject("trackInfo", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (obj.getCouponInfo() != null) {//增加优惠券信息
			Map map = this.orderFormTools.queryCouponInfo(obj.getCouponInfo());
			Integer val = (Integer) map.get("couponinfo_id");
			String sn = (String) map.get("couponinfo_sn");
			
			CouponBO couponBO = this.couponService.getByCouponInfoId(CommUtil.null2Long(val));
			if (couponBO != null){
				mv.addObject("coupon", couponBO);
				mv.addObject("couponSn", sn);
			}
			
			
		}

		mv.addObject("ofls", orderFormLogService.queryByOrderId(obj.getId()));
		mv.addObject("express_company_name",
				this.orderFormTools.queryExInfo(obj.getExpressInfo(), "express_company_name"));
		mv.addObject("orderFormTools", orderFormTools);
		mv.addObject("obj", obj);
		mv.addObject("view_type", view_type);
		return mv;
	}

	/***
	 * 查询订单物流信息
	 * 
	 * @param shippType
	 *            物流方式代码
	 * @param trackNo
	 *            跟踪号
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<String> getTrackingInfo(String shippType, String trackNo) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String exTrackingInfo = TransInfoService.getOrderExpress(trackNo, shippType);
		Map<?, ?> obj = objectMapper.readValue(exTrackingInfo, Map.class);
		List<String> obj2 = (List<String>) obj.get("data");
		return obj2;
	}

	@SecurityMapping(title = "催单", value = "/admin/order_reminderl.htm*", rtype = "admin", rname = "订单管理", rcode = "order_admin", rgroup = "商城管理")
	@RequestMapping("/admin/order_reminder.htm")
	public String orderReminder(HttpServletRequest request, String mulitId) throws Exception {
		String[] storeIds = mulitId.split(",");
		for (String storeId : storeIds) {
			orderFormService.sendMsgToSeller(storeId);
		}
		return "redirect:order_list.htm?orderStatus=20";
	
	}

	
	
	
	
	
	@SuppressWarnings({"rawtypes", "unchecked", "unused"})
	@SecurityMapping(title = "导出表格", value = "/admin/order_excel_next.htm*", rtype = "admin", rname = "商家管理", rcode = "order_list", rgroup = "商城管理")
	@RequestMapping("/admin/order_excel_next.htm")
	public void order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<OrderFormBO> page, OrderFormVO vo, String ids) {
		response.setCharacterEncoding("text/html;charset=UTF-8");
		List<OrderFormBO> datas = new ArrayList<OrderFormBO>();
		page.setPageSize(1000000000);
		vo.setOrderForm(OrderFormConstants.ORDER_FORM_SELF);
		if (!CommUtil.null2String(vo.getType()).equals("")) {
			if (vo.getType().equals("store")) {
				vo.setStoreName(vo.getTypeData());
			}

			if (vo.getType().equals("buyer")) {
				vo.setBuyerUsername(vo.getTypeData());
			}
			if (vo.getType().equals("order")) {
				vo.setOrderId(vo.getTypeData());
			}
		}
		if (StringUtils.isNotBlank(ids)) {
			datas = orderFormService.selectListById(ids);
		} else {
			datas = this.orderFormService.findAllPageByVo(page, vo);
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
//			Date time1 = CommUtil.formatDate(vo.getBeginTime());
//			Date time2 = CommUtil.formatDate(vo.getEndTime());
//			String time = CommUtil.null2String(CommUtil.formatShortDate(time1) + " - "
//					+ CommUtil.formatShortDate(time2));
//			cell.setCellValue(this.configService.getSysConfig().getTitle() + title + "（" + time + "）");
			cell.setCellValue(this.configService.getSysConfig().getTitle() + title);
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
			cell.setCellValue("店铺名称");
			
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("买家");

			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("买家手机");

			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("地址");

			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("付款时间");
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("支付方式");
			
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("支付金额");
			
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("订单类型");
			cell = row.createCell(11);
			cell.setCellStyle(style2);
			cell.setCellValue("商品");
			cell = row.createCell(12);
			cell.setCellStyle(style2);
			cell.setCellValue("物流单号");
			cell = row.createCell(13);
			cell.setCellStyle(style2);
			cell.setCellValue("运费");
			cell = row.createCell(14);
			cell.setCellStyle(style3);
			cell.setCellValue("商品总价");
			cell = row.createCell(15);
			cell.setCellStyle(style3);
			cell.setCellValue("订单总额");
			cell = row.createCell(16);
			cell.setCellStyle(style2);
			cell.setCellValue("订单状态");
			cell = row.createCell(17);
			cell.setCellStyle(style2);
			cell.setCellValue("发货时间");
			cell = row.createCell(18);
			cell.setCellStyle(style2);
			cell.setCellValue("留言");
			cell = row.createCell(19);
			cell.setCellStyle(style2);
			cell.setCellValue("用户昵称");
			cell = row.createCell(20);
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
						cell.setCellValue(datas.get(j - 2).getStoreName());
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
							if(datas.get(j - 2).getPaymentId()==null){
							cell.setCellValue("");
							}else{
								cell.setCellValue(paymentService.findById(datas.get(j - 2).getPaymentId()).getName());
							}
							cell = row.createCell(++i);
							cell.setCellStyle(style2);
							String jf = null;
							double money = 0;
							Integer flagtype = datas.get(j - 2).getPayTypeFlag();
							if(flagtype == null){
								flagtype =99;
							}
							if(flagtype==1){
								jf = datas.get(j - 2).getAllygPrice().toString()+"重消";
								money = datas.get(j - 2).getTotalPrice().doubleValue()+datas.get(j - 2).getAllygPrice().doubleValue();
							}else if(flagtype==2){
								jf = datas.get(j - 2).getAllIntegral().toString()+"购物积分";
								money = datas.get(j - 2).getAllCashPrice().doubleValue();
							}else if(flagtype==3){
								jf = datas.get(j - 2).getAllIntegral().toString()+"积分";
								money = datas.get(j - 2).getAllCashPrice().doubleValue();
							}else if(flagtype==0){
								jf = "";
								money = datas.get(j - 2).getTotalPrice().doubleValue();
							}else if(flagtype==99){
								jf = "暂未支付";
							}
							if(jf!=""	||jf==null){
							cell.setCellValue((jf+" + "+money).toString()+" 元");
							}
							else{
								cell.setCellValue(money+" 元");
							}
							if(jf.equals("暂未支付")){
								cell.setCellValue("");
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
				response.setContentType("applicationei/x-download");
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
	
	
	
	
	
	
}
