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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.o2o.bo.GroupOrderBO;
import com.sinco.carnation.o2o.constants.GroupOrderConstants;
import com.sinco.carnation.o2o.model.GroupOrder;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.o2o.tools.GroupOrderTools;
import com.sinco.carnation.o2o.vo.GroupOrderVO;
import com.sinco.carnation.shop.constants.PaymentConstants;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * Description 订单管理控制器
 */
@Controller
public class GroupOrderAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GroupOrderService groupOrderService;
	@Autowired
	private GroupOrderTools groupOrderTools;

	@SuppressWarnings("serial")
	private static final Map<Integer, String> STATUS_MAP = new HashMap<Integer, String>() {
		{
			put(0, "已取消");
			put(10, "未付款");
			put(20, "未消费");
			put(30, "已消费");
			put(50, "已消费");
			put(60, "已消费");
			put(65, "已消费");
		}
	};

	@SecurityMapping(title = "卖家线上服务订单列表", value = "/seller/groupOrder.htm*", rtype = "seller", rname = "服务订单管理", rcode = "group_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/group_order.htm")
	public ModelAndView group_order(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_group_order.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (vo.getStatusCode() == null) {
			vo.setStatusCode("all");
		}
		vo.setOrderType(1);
		vo.setStoreId(store.getId());
		this.groupOrderService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("groupOrderTools", groupOrderTools);
		mv.addObject("store", store);
		return mv;
	}

	@SecurityMapping(title = "卖家服务订单详情", value = "/seller/group_order_view.htm*", rtype = "seller", rname = "服务订单管理", rcode = "group_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/group_order_view.htm")
	public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/group_order_view.html",
				configService.getSysConfig(), 0, request, response);
		GroupOrderBO obj = this.groupOrderService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		if (obj != null) {
			mv.addObject("obj", obj);
			mv.addObject("store", store);
			mv.addObject("groupOrderTools", groupOrderTools);
		} else {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您店铺中没有编号为" + id + "的订单！");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/group_order.htm");
		}
		return mv;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "卖家线上服务订单导出Excel", value = "/seller/group_order_excel.htm*", rtype = "seller", rname = "服务订单管理", rcode = "group_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/group_order_excel.htm")
	public void group_order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null && userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		page.setPageSize(1000000000);
		vo.setStoreId(store.getId());
		if (vo.getStatusCode() == null) {
			vo.setStatusCode("all");
		}
		vo.setOrderType(1);
		this.groupOrderService.findPageByVo(page, vo);

		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("线上服务订单列表");
//			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();
			for (int i = 0; i < datas.size(); i++) {
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
			}
		}
		// 设置excel每列宽度
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 6000);
		sheet.setColumnWidth(4, 6000);
		sheet.setColumnWidth(5, 6000);
		sheet.setColumnWidth(6, 6000);

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
		String title = "线上服务订单列表";
		Date time1 = CommUtil.formatDate(vo.getStartDate());
		Date time2 = CommUtil.formatDate(vo.getEndDate());
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
		cell.setCellValue("服务");
		cell = row.createCell(4);
		cell.setCellStyle(style2);
		cell.setCellValue("买家");
		cell = row.createCell(5);
		cell.setCellStyle(style2);
		cell.setCellValue("订单总额");
		cell = row.createCell(6);
		cell.setCellStyle(style2);
		cell.setCellValue("订单状态");
		double all_order_price = 0.00;// 订单总金额
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();
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

				if (datas.get(j - 2).getPaymentMark() != null) {
					cell.setCellValue(PaymentConstants.getPaymentName(datas.get(j - 2).getPaymentMark()));
				} else {
					cell.setCellValue("未支付");
				}

				// cell = row.createCell(++i);
				// cell.setCellStyle(style2);
				// cell.setCellValue(TYPE_MAP.get(datas.get(j - 2).getOrderType()));

				Map map = Json.fromJson(Map.class, datas.get(j - 2).getGroupInfo());
				StringBuilder sb = new StringBuilder();
				sb.append(map.get("goods_name") + "*" + map.get("goods_count"));
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(sb.toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getUserNickname());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getTotalPrice()));
				all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(STATUS_MAP.get(datas.get(j - 2).getOrderStatus()));
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
			cell.setCellValue("本次订单总金额：");
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(all_order_price);
		}

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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SecurityMapping(title = "卖家线下刷卡订单列表", value = "/seller/groupOrderLocal.htm*", rtype = "seller", rname = "线下服务订单管理", rcode = "group_local_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/group_order_local.htm")
	public ModelAndView group_order_local(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_group_order_local.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(10);
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (user != null && user.getStoreId() != null) {
			store = storeService.getObjById(user.getStoreId());
		}
		vo.setOrderType(2);
		vo.setStoreId(store.getId());
		vo.setOrderStatus(GroupOrderConstants.ORDER_STATUS_PAYMENT);
		this.groupOrderService.findPageByVo(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("groupOrderTools", groupOrderTools);
		mv.addObject("store", store);
		return mv;
	}

	@SecurityMapping(title = "线下刷卡订单退款", value = "/seller/local_order_return.htm*", rtype = "seller", rname = "线下服务订单管理", rcode = "group_local_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/local_order_return.htm")
	public String local_order_return(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		GroupOrder obj = this.groupOrderService.getObjById(CommUtil.null2Long(id));
		CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		if (obj != null && user.getStoreId().toString().equals(obj.getStoreId())) {
			obj.setLocalReturnStatus(2);
			groupOrderService.update(obj);
		}

		return "redirect:group_order_local.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "卖家线下刷卡订单导出Excel", value = "/seller/group_order_local_excel.htm*", rtype = "seller", rname = "线下服务订单管理", rcode = "group_local_order_seller", rgroup = "服务交易管理")
	@RequestMapping("/seller/group_order_local_excel.htm")
	public void group_order_local_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupOrderBO> page, GroupOrderVO vo) {
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store = null;
		if (userDetails != null && userDetails.getStoreId() != null) {
			store = storeService.getObjById(userDetails.getStoreId());
		}
		page.setPageSize(1000000000);
		vo.setStoreId(store.getId());
		vo.setOrderType(2);
		vo.setOrderStatus(GroupOrderConstants.ORDER_STATUS_PAYMENT);
		this.groupOrderService.findPageByVo(page, vo);
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("线下刷卡订单列表");
//			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();
			for (int i = 0; i < datas.size(); i++) {
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
			}
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
		String title = "线下刷卡订单列表";
		Date time1 = CommUtil.formatDate(vo.getStartDate());
		Date time2 = CommUtil.formatDate(vo.getEndDate());
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
		cell.setCellValue("服务");
		cell = row.createCell(4);
		cell.setCellStyle(style2);
		cell.setCellValue("买家");
		cell = row.createCell(5);
		cell.setCellStyle(style2);
		cell.setCellValue("订单总额");
		cell = row.createCell(6);
		cell.setCellStyle(style2);
		cell.setCellValue("用户类型");
		cell = row.createCell(7);
		cell.setCellStyle(style2);
		cell.setCellValue("退款状态");
		cell = row.createCell(8);
		cell.setCellStyle(style2);
		cell.setCellValue("订单状态");
		double all_order_price = 0.00;// 订单总金额
		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupOrderBO> datas = page.getContent();
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
				cell.setCellValue("线下刷卡");

				// cell = row.createCell(++i);
				// cell.setCellStyle(style2);
				// cell.setCellValue(TYPE_MAP.get(datas.get(j - 2).getOrderType()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getLocalGroupName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getUserNickname());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getTotalPrice()));
				all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getTotalPrice());

				// 用户类型
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if (datas.get(j - 2).getIsSysUser()) {
					cell.setCellValue("会员用户");
				} else {
					cell.setCellValue("非会员用户");
				}

				// 退款状态
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if (datas.get(j - 2).getLocalReturnStatus() == 1) {
					cell.setCellValue("未退款");
				} else {
					cell.setCellValue("已退款");
				}

				// 订单状态
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if (datas.get(j - 2).getLocalReturnStatus() == 2) {
					cell.setCellValue("已退款");
				} else {
					cell.setCellValue("已消费");
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
			cell.setCellValue("本次订单总金额：");

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(all_order_price);
		}
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
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
