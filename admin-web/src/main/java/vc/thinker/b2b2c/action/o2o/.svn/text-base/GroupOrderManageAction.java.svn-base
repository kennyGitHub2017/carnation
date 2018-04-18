package vc.thinker.b2b2c.action.o2o;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
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
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.elong.bo.ElongOrderBO;
import com.sinco.carnation.elong.service.ElongOrderService;
import com.sinco.carnation.elong.util.DateUtil;
import com.sinco.carnation.elong.vo.ElongOrderVO;
import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.bo.GroupOrderLogBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.service.GroupInfoService;
import com.sinco.carnation.o2o.service.GroupOrderLogService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.vo.GroupOrderLogVO;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
/**
 * 
 * <p>
 * Title: GroupOrderManageAction.java
 * </p>
 * 
 * <p>
 * Description:后台服务订单管理器
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
 * @date 2015-9-8
 * 
 * @version 1.0.1
 */
@Controller
public class GroupOrderManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupOrderLogService groupOrderLogService;
	@Autowired
	private GroupInfoService groupInfoService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private ElongOrderService elongOrderService;
	
	
	// 0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价
	@SuppressWarnings("serial")
	private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {
		{
			put(10, "待付款");
			put(20, "未消费");
		}
	};

	
	
	
//	private static final Map<Integer,String> ORDER_STATUS_MAP = new HashMap<Integer,String>(){
//		{
//			put(8,"等待支付");
//			put(512,"已确认-等待入住");
//			put(1024,"已入住");
//			put(256,"已取消");
//			put(32,"酒店拒绝订单");
//			put(2,"等待支付担保金");
//			put(4,"等待酒店确认");
//			put(64,"未入住");
//			put(1,"担保失败");
//			put(128,"已经离店");
//			put(2048,"正在担保-处理中");
//			put(4096,"正在支付-处理中");
//			put(8192,"支付失败");
//			put(16,"等待核实入住");
//		}
//	};
	@SuppressWarnings("serial")
	private static final List<ElongOrderVO> ORDER_STATUS_LIST = new ArrayList<ElongOrderVO>(){{
		add(new ElongOrderVO(8,"等待支付"));
		add(new ElongOrderVO(512,"已确认-等待入住"));
		add(new ElongOrderVO(1024,"已入住"));
		add(new ElongOrderVO(256,"已取消"));
		add(new ElongOrderVO(32,"酒店拒绝订单"));
		add(new ElongOrderVO(2,"等待支付担保金"));
		add(new ElongOrderVO(4,"等待酒店确认"));
		add(new ElongOrderVO(64,"未入住"));
		add(new ElongOrderVO(1,"担保失败"));
		add(new ElongOrderVO(128,"已经离店"));
		add(new ElongOrderVO(2048,"正在担保-处理中"));
		add(new ElongOrderVO(4096,"正在支付-处理中"));
		add(new ElongOrderVO(8192,"支付失败"));
		add(new ElongOrderVO(16,"等待核实入住"));
	}
	};
	
	
	@SecurityMapping(title = "线上服务订单列表", value = "/admin/online_group_order_list.htm*", rtype = "admin", rname = "线上服务订单管理", rcode = "admin_online_order", rgroup = "商户管理")
	@RequestMapping("/admin/online_group_order_list.htm")
	public ModelAndView order_list(HttpServletRequest request, HttpServletResponse response, GroupOrderVO vo,
			MyPage<GroupOrderBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/online_group_order_list.html",
				configService.getSysConfig(), 0, request, response);
		vo.setOrderType(1);

		if (vo != null && (vo.getOrderStatus() != null && vo.getOrderStatus() > 0)) {
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_SUBMIT)) {
				mv = new JModelAndView("admin/blue/online_group_order_list_no_pay.html",
						configService.getSysConfig(), 0, request, response);
			}
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_PAYMENT)) {
				mv = new JModelAndView("admin/blue/online_group_order_list_paid.html",
						configService.getSysConfig(), 0, request, response);
			}
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_USEED)) {
				mv = new JModelAndView("admin/blue/online_group_order_list_used.html",
						configService.getSysConfig(), 0, request, response);
			}
		}
		this.groupOrderService.queryGroupOrderListByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("PaymentConstants", new PaymentConstants());
		return mv;
	}
	
	@SecurityMapping(title = "酒店订单列表", value = "/admin/hotel_group_order_list.htm*", rtype = "admin", rname = "酒店订单管理", rcode = "admin_hotel_order", rgroup = "商户管理")
	@RequestMapping("/admin/hotel_group_order_list.htm")
	public ModelAndView hotel_order_list(HttpServletRequest request, HttpServletResponse response, ElongOrderVO vo,
			MyPage<ElongOrderBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/hotel_group_order_list.html",
				configService.getSysConfig(), 0, request, response);
		List<ElongOrderBO> elOrderBOs = elongOrderService.findElongOrderVOs(vo,page);
			for (ElongOrderBO elongOrderBO : elOrderBOs) {
					for(ElongOrderVO status : ORDER_STATUS_LIST) {	
						if(elongOrderBO.getShowStatus().equals(status.getStatusId().toString())){
							elongOrderBO.setShowStatus(status.getShowStatus());
							break;
						}
					}
					long day =  DateUtil.getDifferenceBetweenDay(elongOrderBO.getDepartureDate(), 
							elongOrderBO.getArrivalDate());
					elongOrderBO.setDayCount(day);
			}
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("vo", vo);
			mv.addObject("statusList", ORDER_STATUS_LIST);
		return mv;	
	}

	@SecurityMapping(title = "线上服务订单列表导出", value = "/admin/order_list_export_excel.htm*", rtype = "admin", rname = "线上服务订单管理", rcode = "admin_online_order", rgroup = "商户管理")
	@RequestMapping("/admin/order_list_export_excel.htm")
	public void order_list_export_excel(HttpServletRequest request, HttpServletResponse response,
			GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		page.setPageSize(1000000000);
		vo.setOrderType(1);
		this.groupOrderService.queryGroupOrderListByVO(vo, page);
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("订单列表");
			// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
			int p = 0;
			for (int i = 0; i < datas.size(); i++) {
				if(datas.get(i).getOrderStatus()==10){
					p++;
				}
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
			}
			// 设置excel每列宽度
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);
		
			sheet.setColumnWidth(8, 6000);
			
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

			String title = "线上服务订单";
			cell.setCellValue(this.configService.getSysConfig().getTitle() + title);

			// 设置单元格内容格式时间
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
			style1.setWrapText(true);// 自动换行
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 创建标题行
			row = sheet.createRow(1);
			//
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("流水号");

			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("商户名称");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("服务名称");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("买家昵称");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");	
			//
		
			if(p!=datas.size()){
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("付款时间");
			//
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("订单总额");
			//
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("支付方式");
			//
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("订单状态");
			}
			else{
				//
				cell = row.createCell(6);
				cell.setCellStyle(style2);
				cell.setCellValue("订单总额");
				//
				cell = row.createCell(7);
				cell.setCellStyle(style2);
				cell.setCellValue("支付方式");
				//
				cell = row.createCell(8);
				cell.setCellStyle(style2);
				cell.setCellValue("订单状态");
				}

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getTradeNo());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String storeName = "";
				if (null != datas.get(j - 2).getStore())
					storeName = datas.get(j - 2).getStore().getStoreName();
				cell.setCellValue(storeName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getLocalGroupName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderId());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String nickName = "";
				if (null != datas.get(j - 2).getUserCustomer())
					nickName = datas.get(j - 2).getUserCustomer().getNickname();
				cell.setCellValue(nickName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));
				
				
				if(p!=datas.size()){
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getPayTime()));
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getTotalPrice().toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(PaymentConstants.getPaymentName(datas.get(j - 2).getPaymentMark()));

				// 0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String orderTypeName = STATUS_MAP.get(datas.get(j - 2).getOrderStatus());
				if (StringUtils.isEmpty(orderTypeName)) {
					orderTypeName = "已完成";
				}
				cell.setCellValue(orderTypeName);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				// String path =
				// request.getSession().getServletContext().getRealPath("") +
				// File.separator + "excel";
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

	@SecurityMapping(title = "线上服务订单详情", value = "/admin/online_group_order_view.htm*", rtype = "admin", rname = "线上服务订单管理", rcode = "admin_online_order", rgroup = "商户管理")
	@RequestMapping("/admin/online_group_order_view.htm")
	public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/online_group_order_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			GroupOrderBO order = groupOrderService.getObjById(CommUtil.null2Long(id));
			if (null != order) {
				Store store = this.storeService.getStoreBOById(CommUtil.null2Long(order.getStoreId()));
				GroupOrderLogVO vo = new GroupOrderLogVO();
				vo.setOfId(CommUtil.null2Long(id));
				List<GroupOrderLogBO> logs = this.groupOrderLogService.selectByVO(vo);
				mv.addObject("store", store);
				mv.addObject("logs", logs);
				mv.addObject("infos", order.getGroupInfoBOList());
				mv.addObject("order", order);
				mv.addObject("orderFormTools", orderFormTools);
			}
		}
		return mv;
	}

	@SecurityMapping(title = "线下刷卡服务订单列表", value = "/admin/offline_group_order_list.htm*", rtype = "admin", rname = "线下刷卡服务订单管理", rcode = "admin_offline_order", rgroup = "商户管理")
	@RequestMapping("/admin/offline_group_order_list.htm")
	public ModelAndView offline_group_order_list(HttpServletRequest request, HttpServletResponse response,
			GroupOrderVO vo, MyPage<GroupOrderBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/offline_group_order_list.html",
				configService.getSysConfig(), 0, request, response);
		vo.setOrderType(2);

		if (vo != null && (vo.getOrderStatus() != null && vo.getOrderStatus() > 0)) {
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_SUBMIT)) {
				mv = new JModelAndView("admin/blue/offline_group_order_list_no_pay.html",
						configService.getSysConfig(), 0, request, response);
			}
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_PAYMENT)) {
				mv = new JModelAndView("admin/blue/offline_group_order_list_paid.html",
						configService.getSysConfig(), 0, request, response);
			}
			if (vo.getOrderStatus().equals(GroupOrderConstants.ORDER_STATUS_USEED)) {
				mv = new JModelAndView("admin/blue/offline_group_order_list_used.html",
						configService.getSysConfig(), 0, request, response);
			}
		}

		this.groupOrderService.queryGroupOrderListByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		return mv;
	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "酒店订单导出", value = "/admin/hotel_order_export.htm*", rtype = "admin", rname = "订单管理", rcode = "hotel_order_export", rgroup = "商户管理")
	@RequestMapping("/admin/hotel_order_export.htm")
	public void hotel_order_export(HttpServletRequest request, HttpServletResponse response,
			ElongOrderVO vo, MyPage<ElongOrderBO> page) {

		page.setPageSize(1000000000);
		List<ElongOrderBO> elOrderBOs = this.elongOrderService.findElongOrderVOs(vo,page);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<ElongOrderBO> datas = page.getContent();

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
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);
			sheet.setColumnWidth(8, 6000);
			sheet.setColumnWidth(9, 6000);
			sheet.setColumnWidth(10, 6000);
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

			String title = "酒店订单统计列表";
			cell.setCellValue(this.configService.getSysConfig().getTitle() + title);

			// 设置单元格内容格式时间
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
			style1.setWrapText(true);// 自动换行
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 创建标题行
			row = sheet.createRow(1);
			//
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("酒店名称");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("房型");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("姓名");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("手机号");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("金额");
			//
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("订单创建时间");
			//
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("入住时间");
			//
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("离开时间");
			//
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("天数/晚");
			//
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("状态");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderId());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getHotelName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getRoomTypeName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getMobile());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getTotalPrice().toString());
				
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getCreateTime()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getArrivalDate()));
				
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getDepartureDate()));
				
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(DateUtil.getDifferenceBetweenDay(datas.get(j - 2).getDepartureDate(), 
						datas.get(j - 2).getArrivalDate()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
					for(ElongOrderVO status : ORDER_STATUS_LIST) {	
						if(datas.get(j - 2).getShowStatus().equals(status.getStatusId().toString())){
							cell.setCellValue(status.getShowStatus());
							break;
						}
					}
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				// String path =
				// request.getSession().getServletContext().getRealPath("") +
				// File.separator + "excel";
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

	@SecurityMapping(title = "线下刷卡服务订单详情", value = "/admin/offline_group_order_view.htm*", rtype = "admin", rname = "线下刷卡服务订单管理", rcode = "admin_offline_order", rgroup = "商户管理")
	@RequestMapping("/admin/offline_group_order_view.htm")
	public ModelAndView offline_group_order_view(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/offline_group_order_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			GroupOrderBO obj = this.groupOrderService.getGroupOrderBOById(CommUtil.null2Long(id));
//			GroupInfoVO gvo=new GroupInfoVO();
//			gvo.setOrderId(id);
//			List<GroupInfoBO> ggs=this.groupInfoService.selectGroupGoodsByOrderId(gvo);
//			GroupInfo gi=this.groupInfoService.findByOrder(CommUtil.null2Long(id));
//			Map map = null;
//			if(null != gi){
//				String groupInfo=obj.getGroupInfo();
//				if(StringUtils.isNotEmpty(groupInfo)){
//					map = (Map) Json.fromJson(groupInfo);
//				}
//			}
			Store store = this.storeService.getStoreBOById(CommUtil.null2Long(obj.getStoreId()));
//			GroupOrderLogVO vo=new GroupOrderLogVO();
//			vo.setOfId(CommUtil.null2Long(id));
//			List<GroupOrderLogBO> logs=this.groupOrderLogService.selectByVO(vo);
			mv.addObject("store", store);
//			mv.addObject("logs", logs);
			mv.addObject("obj", obj);
//			mv.addObject("gi", gi);
//			mv.addObject("ggs", map);
		}
		return mv;
	}
	
	
	@SecurityMapping(title = "线下刷卡服务订单导出", value = "/admin/offline_group_order_export.htm*", rtype = "admin", rname = "线下刷卡服务订单管理", rcode = "admin_offline_order", rgroup = "商户管理")
	@RequestMapping("/admin/offline_group_order_export.htm")
	public void offline_group_order_export(HttpServletRequest request, HttpServletResponse response,
			GroupOrderVO vo, MyPage<GroupOrderBO> page) {

		page.setPageSize(1000000000);
		vo.setOrderType(2);
		vo.setOrderStatus(-1);
		this.groupOrderService.queryGroupOrderListByVO(vo, page);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();

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
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);

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

			String title = "线下刷卡服务订单";
			cell.setCellValue(this.configService.getSysConfig().getTitle() + title);

			// 设置单元格内容格式时间
			HSSFCellStyle style1 = wb.createCellStyle();
			style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
			style1.setWrapText(true);// 自动换行
			style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			HSSFCellStyle style2 = wb.createCellStyle();
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 创建标题行
			row = sheet.createRow(1);
			//
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("商户名称");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("服务名称");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("订单号");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("买家昵称");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("支付状态");
			//
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("订单总额");
			//
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("是否会员");
			//
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("退款状态");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				String storeName = "";
				if (null != datas.get(j - 2).getStore())
					storeName = datas.get(j - 2).getStore().getStoreName();
				cell.setCellValue(storeName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getLocalGroupName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderId());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String nickName = "非会员";
				if (null != datas.get(j - 2).getUserCustomer())
					nickName = datas.get(j - 2).getUserCustomer().getNickname();
				cell.setCellValue(nickName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if(datas.get(j - 2).getOrderStatus() != null){
					switch (datas.get(j - 2).getOrderStatus()) {
					case 0:
						cell.setCellValue("已取消");
						break;
					case 10:
						cell.setCellValue("待付款");
						break;
					case 20:
						cell.setCellValue("已付款");
						break;
					case 30:
						cell.setCellValue("已使用");
						break;
					case 50:
						cell.setCellValue("已评价");
						break;
					case 60:
						cell.setCellValue("卖家评价");
						break;
					case 65:
						cell.setCellValue("订单关闭");
						break;
					default:
						cell.setCellValue("");
						break;
					}
				}else{
					cell.setCellValue("");
				}
				
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getTotalPrice().toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);

				String isSysUser = "否";
				if (null != datas.get(j - 2).getUserCustomer()) {
					isSysUser = "是";
				}

				/*	String isSysUser = "否";
					if (datas.get(j - 2).getIsSysUser() != null) {
						isSysUser = "是";
					}*/
				cell.setCellValue(isSysUser);

				String localReturnStatus = "未退款";
				if (datas.get(j - 2).getLocalReturnStatus() != null
						&& datas.get(j - 2).getLocalReturnStatus().equals(2))
					localReturnStatus = "已退款";
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(localReturnStatus);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				// String path =
				// request.getSession().getServletContext().getRealPath("") +
				// File.separator + "excel";
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
}
