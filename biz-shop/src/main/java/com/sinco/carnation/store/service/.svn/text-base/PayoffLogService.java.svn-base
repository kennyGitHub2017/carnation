package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.shop.model.OrderForm;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.dao.PayoffLogDao;
import com.sinco.carnation.store.dao.StoreDao;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.vo.PayoffLogVO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;

@SuppressWarnings("deprecation")
@Service
@Transactional
public class PayoffLogService {

	@Autowired
	private PayoffLogDao payoffLogDao;
	@Autowired
	private StoreDao storeDao;
	@Autowired
	private SysConfigService configService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private ReturnGoodsLogService returnGoodsLogService;
	@Autowired
	private OrderFormService orderFormServer;

	@Value(value = "${order.payofflog.daycount}")
	private Integer dayCount;

	public List<PayoffLogBO> selectPayoffLogNearest(Integer status, Date addTime, Long sellerId) {
		return payoffLogDao.selectPayoffLogNearest(status, addTime, sellerId);
	}

	public HSSFWorkbook payofflogShopExcel(PayoffLogVO vo) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.MONTH, 0);
//		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
//		String first = format.format(c.getTime());
//		Calendar ca = Calendar.getInstance();
//		ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
//		String last = format.format(ca.getTime());
		List<PayoffLogBO> datas = selectShopPageListByVO(null, vo);

		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("结算账单");
//		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
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
		String title = "结算账单";
		String time = CommUtil.null2String(CommUtil.formatDate(vo.getBeginTime()) + " - "
				+ CommUtil.formatDate(vo.getEndTime()));
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
		cell.setCellValue("账单流水号");
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue("商家名称");
		cell = row.createCell(2);
		cell.setCellStyle(style2);
		cell.setCellValue("账单说明");
		cell = row.createCell(3);
		cell.setCellStyle(style2);
		cell.setCellValue("账单入账时间");
		cell = row.createCell(4);
		cell.setCellStyle(style2);
		cell.setCellValue("申请结算时间");
		cell = row.createCell(5);
		cell.setCellStyle(style2);
		cell.setCellValue("完成结算时间");
		cell = row.createCell(6);
		cell.setCellStyle(style2);
		cell.setCellValue("账单总金额（元）");
		cell = row.createCell(7);
		cell.setCellStyle(style2);
		cell.setCellValue("账单总佣金（元）");
		cell = row.createCell(8);
		cell.setCellStyle(style2);
		cell.setCellValue("账单应结算（元）");
		cell = row.createCell(9);
		cell.setCellStyle(style2);
		cell.setCellValue("操作财务");
		cell = row.createCell(10);
		cell.setCellStyle(style2);
		cell.setCellValue("操作管理员");
		cell = row.createCell(11);
		cell.setCellStyle(style2);
		cell.setCellValue("结算备注");
		double all_order_price = 0.00;// 账单总销售金额
		double all_commission_amount = 0.00;// 账单总佣金
		double all_total_amount = 0.00;// 账单总结算
		for (int j = 2; j <= datas.size() + 1; j++) {
			row = sheet.createRow(j);
			// 设置单元格的样式格式
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getPlSn());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getSeller().getUserName());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getPlInfo());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getApplyTime()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getCompleteTime()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getOrderTotalPrice()));
			all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getOrderTotalPrice());// 计算账单总订单价格

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getCommissionAmount()));
			all_commission_amount = CommUtil.add(all_commission_amount, datas.get(j - 2)
					.getCommissionAmount());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getTotalAmount()));
			all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getTotalAmount());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getFinanceUserName()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			if (datas.get(j - 2).getAdmin() != null) {
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getAdmin().getName()));
			}
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getPayoffRemark()));
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
		cell.setCellValue("本次总销售金额：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_order_price);

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue("本次总销售佣金：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_commission_amount);

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue("本次总结算金额：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_total_amount);
		return wb;
	}

	public HSSFWorkbook payofflogExcel(PayoffLogVO vo) {
		List<PayoffLogBO> datas = payoffLogDao.selectPayoffLogListByVO(null, vo);
//		if (CollectionUtils.isEmpty(datas)) 
//		{
//			return null;
//		}
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("结算账单");
//		HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
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
		String title = "结算账单";
		Date time1 = null;
		Date time2 = null;
		if (vo.getStatus() != null && !vo.getStatus().equals("")) {
			if (vo.getStatus().equals("1")) {
				title = "未结算账单";
				time1 = CommUtil.formatDate(vo.getBeginTime());
				time2 = CommUtil.formatDate(vo.getEndTime());
			}
			if (vo.getStatus().equals("3")) {
				title = "可结算账单";
				time1 = CommUtil.formatDate(vo.getBeginTime());
				time2 = CommUtil.formatDate(vo.getEndTime());
			}
			if (vo.getStatus().equals("6")) {
				title = "已结算账单";
				time1 = CommUtil.formatDate(vo.getBeginTime());
				time2 = CommUtil.formatDate(vo.getEndTime());
			}
		}
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
		int rowNo = 0;
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("账单流水号");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("对应订单号");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("商家昵称");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("店铺名称");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("账单说明");
		if (vo.getStatus().equals("3")) {//可结算订单需显示申请时间
			cell = row.createCell(rowNo++);
			cell.setCellStyle(style2);
			cell.setCellValue("申请时间");
		}
		if (vo.getStatus().equals("6")) {//已结算订单需显示结算时间
			cell = row.createCell(rowNo++);
			cell.setCellStyle(style2);
			cell.setCellValue("结算时间");
		}
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("销售金额");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("销售佣金");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		cell.setCellValue("结算金额");
		cell = row.createCell(rowNo++);
		cell.setCellStyle(style2);
		if (vo.getStatus().equals("6")) {//已结算订单需显示结算时间
			cell = row.createCell(rowNo++);
			cell.setCellStyle(style2);
			cell.setCellValue("结算财务");
		}
		
		double all_order_price = 0.00;// 账单总销售金额
		double all_commission_amount = 0.00;// 账单总佣金
		double all_total_amount = 0.00;// 账单总结算
		for (int j = 2; j <= datas.size() + 1; j++) {
			row = sheet.createRow(j);
			// 设置单元格的样式格式
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getPlSn());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getOrderId());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getSellerNickname());

			/*cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getAddTime()));*/
			if (vo.getStatus().equals("3")) {
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getApplyTime()));//申请结算时间
			}

			if (vo.getStatus().equals("6")) {
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getCompleteTime()));//结算时间
			}
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getStoreName());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(datas.get(j - 2).getPlInfo());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getOrderTotalPrice()));
			all_order_price = CommUtil.add(all_order_price, datas.get(j - 2).getOrderTotalPrice());// 计算账单总订单价格

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getCommissionAmount()));
			all_commission_amount = CommUtil.add(all_commission_amount, datas.get(j - 2)
					.getCommissionAmount());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getTotalAmount()));
			all_total_amount = CommUtil.add(all_total_amount, datas.get(j - 2).getTotalAmount());

			if (vo.getStatus().equals("6")) {
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getFinanceUserName()));//结算财务
			}
		/*	cell = row.createCell(++i);
			cell.setCellStyle(style2);
			if (datas.get(j - 2).getAdmin() != null) {
				cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getAdmin().getName()));
			}
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.null2String(datas.get(j - 2).getPayoffRemark()));*/
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
		cell.setCellValue("本次总销售金额：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_order_price);

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue("本次总销售佣金：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_commission_amount);

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue("本次总结算金额：");

		cell = row.createCell(++i);
		cell.setCellStyle(style2);
		cell.setCellValue(all_total_amount);

		return wb;
	}

	public void selectPayoffLogListByVO(MyPage<PayoffLogBO> page, PayoffLogVO vo) {
		if ("1".equals(vo.getStatus())) {
			vo.setDayCount(dayCount + 1);
		}
		payoffLogDao.selectPayoffLogListByVO(page, vo);
	}

	public List<PayoffLogBO> selectShopPageListByVO(MyPage<PayoffLogBO> page, PayoffLogVO vo) {
		if ("1".equals(vo.getStatus())) {
			vo.setDayCount(dayCount + 1);
		}
		return payoffLogDao.selectShopPageListByVO(page, vo);
	}

	public Map<String, Object> selectPayoffLogStatByVO(PayoffLogVO vo) {
		if ("1".equals(vo.getStatus())) {
			vo.setDayCount(dayCount + 1);
		}
		return payoffLogDao.selectPayoffLogStatByVO(vo);
	}

	public PayoffLogBO selectBOByOidAndOrderId(String oid, String orderId) {
		return payoffLogDao.selectBOByOidAndOrderId(oid, orderId);
	}

	public PayoffLogBO selectBOByVO(Long id) {
		return payoffLogDao.selectBOByVO(id);
	}

	public boolean save(PayoffLog payoffLog) {
		/**
		 * init other field here
		 */
		try {
			this.payoffLogDao.save(payoffLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public PayoffLog getObjById(Long id) {
		PayoffLog payoffLog = this.payoffLogDao.get(id);
		if (payoffLog != null) {
			return payoffLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.payoffLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> payoffLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : payoffLogIds) {
			delete((Long) id);
		}
		return true;
	}

	public int updateByOrderIdAndOid(PayoffLog record) {
		return payoffLogDao.updateByOrderIdAndOid(record);
	}

	public boolean update(PayoffLog payoffLog) {
		try {
			this.payoffLogDao.update(payoffLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 订单结算
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean orderSettlement(PayoffLog obj, Long storeId) {
		obj.setStatus(6);
		obj.setCompleteTime(new Date());
		this.payoffLogDao.update(obj);
		// 结算就是将商家的应得的钱给到商家
		if (/*moneyService.addMoney(obj.getSellerId(), obj.getTotalAmount().doubleValue(), obj.getAdminId(),
				"订单结算", "订单：" + obj.getOrderId() + "结算")*/
				moneyService.addMoneyV2(obj.getSellerId(), obj.getTotalAmount().doubleValue(), obj.getAdminId(),
						"订单结算", "订单：" + obj.getOrderId() + "结算", UserContant.ACCOUNT_TYPE_SUPPLIER)) {//供应商订单结算
			try {
				// storeToUpdate.setId(store.getId());
				// storeToUpdate.setStoreSaleAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStoreSaleAmount(),
				// obj.getOrderTotalPrice())));// 减少店铺本次结算总销售金额
				// storeToUpdate.setStoreCommissionAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStoreCommissionAmount(),
				// obj.getCommissionAmount())));// 减少店铺本次结算总佣金
				// storeToUpdate.setStorePayoffAmount(BigDecimal.valueOf(CommUtil.subtract(store.getStorePayoffAmount(),
				// obj.getTotalAmount())));// 减少店铺本次结算金额
				// this.storeService.update(store);
				storeDao.addStoreAmount(
						BigDecimal.ZERO.subtract(obj.getCommissionAmount()),
						BigDecimal.ZERO.subtract(obj.getTotalAmount()),
						BigDecimal.ZERO.subtract(obj.getOrderTotalPrice().add(
								obj.getShipAmount() != null ? obj.getShipAmount() : BigDecimal.ZERO)),
						storeId);

				// SysConfig sc = this.configService.getSysConfig();
				// sc.setPayoffAllAmount(BigDecimal.valueOf(CommUtil.add(obj.getTotalAmount(),
				// sc.getPayoffAllAmount())));// 增加系统总结算（应结算）
				// sc.setPayoffAllAmountReality(BigDecimal.valueOf(CommUtil.add(obj.getRealityAmount(),
				// sc.getPayoffAllAmountReality())));// 增加系统实际总结算
				this.configService.addConfigAmount(obj.getTotalAmount(), obj.getRealityAmount(), null, null);

				return true;
			} catch (Exception ex) {
				throw new RuntimeException("结算失败了！");
			}
		} else {
			throw new RuntimeException("结算失败了！");
		}
	}

	/** 提交结算 **/
	public void submitSettlement(PayoffLog payoffLog) {
		if (payoffLog != null
				&& returnGoodsLogService
						.selectReturningCountByOrderId(CommUtil.null2Long(payoffLog.getoId())) < 1) {
			if (payoffLog.getStatus() == 1) {
				OrderForm of = this.orderFormServer.getObjById(CommUtil.null2Long(payoffLog.getoId()));
				if (of != null) {
//					boolean payoff = this.validatePayoffDate();
					boolean goods = false;// 购物
					boolean group = false;// 团购
					if (of.getOrderStatus() == 40 || of.getOrderStatus() == 50 || of.getOrderStatus() == 65) {
						goods = true;
					}
					if (of.getOrderCat() == 2) {
						if (of.getOrderStatus() == 20) {// 团购消费码订单
							group = true;
						}
					}
					if (goods || group) {// 已经完成的订单，并且今天为结算日
						payoffLog.setStatus(3);// 设置结算中
						payoffLog.setApplyTime(new Date());
						this.update(payoffLog);
					}
				}
			}
		}
	}

	/** 根据状态查询结算0为未结算，1为可结算、3为结算中，6为已结算已完成 **/
	public List<PayoffLogBO> listByStatus(String status) {
		if (org.apache.commons.lang3.StringUtils.isBlank(status)) {
			return null;
		}
		MyPage<PayoffLogBO> page = new MyPage<>();
		page.setPageSize(1000);
		PayoffLogVO vo = new PayoffLogVO();
		vo.setStatus(status);
		vo.setTempStatus("ok");
		vo.setDayCount(7);
		return this.payoffLogDao.selectPayoffLogListByVO(page, vo);
	}

}
