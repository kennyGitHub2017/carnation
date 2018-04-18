package vc.thinker.b2b2c.action.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ReturnGoodsLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.refund.service.RefundLogService;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * <p>
 * Title: PredepositManageAction.java
 * </p>
 * 
 * <p>
 * Description: 平台预存款管理控制器，用来显示预存款信息、审核预存款、修改预存款等所有系统预存款操作
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
 * @date 2014-5-26
 * 
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class PredepositManageAction {
	@Autowired
	private SysConfigService configService;
	// @Autowired
	// private UserConfigService userConfigService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private UserCustomerService customerService;
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
	// @Autowired
	// private GroupInfoService groupinfoService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private MessageService messageService;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Predeposit列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "预存款列表", value = "/admin/predeposit_list.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_list.htm")
	public ModelAndView predeposit_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pdPayment, String pdPayStatus, String pdStatus, String pdUserName,
			String beginTime, String endTime, String pdRemittanceUser, String pdRemittanceBank, String pdSn,
			MyPage<PredepositBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_list.html", configService.getSysConfig(),
				0, request, response);
		if (configService.getSysConfig().getDeposit()) {
			String url = this.configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}
			predepositService.queryPredepositPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
					pdRemittanceBank, pdUserName, beginTime, endTime, pdSn, page);
			List<PredepositBO> list = page.getContent();
			BigDecimal amount = BigDecimal.ZERO;
			if(null != list && list.size() > 0){
				for(PredepositBO bo : list){
					amount=amount.add(bo.getPdAmount());
				}
			}
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			mv.addObject("pd_payment", pdPayment);
			mv.addObject("pd_pay_status", pdPayStatus);
			mv.addObject("pd_status", pdStatus);
			mv.addObject("nickName", pdUserName);
			mv.addObject("beginTime", beginTime);
			mv.addObject("endTime", endTime);
			mv.addObject("pd_remittance_user", pdRemittanceUser);
			mv.addObject("pd_remittance_bank", pdRemittanceBank);
			mv.addObject("pdSn", pdSn);
			mv.addObject("amount", amount);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * predeposit添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "预存款列表", value = "/admin/predeposit_view.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_view.htm")
	public ModelAndView predeposit_view(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_view.html", configService.getSysConfig(),
				0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			PredepositBO obj = predepositService.findBOById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * predeposit编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "预存款编辑", value = "/admin/predeposit_edit.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_edit.htm")
	public ModelAndView predeposit_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_edit.html", configService.getSysConfig(),
				0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			if (id != null && !id.equals("")) {
				Predeposit predeposit = this.predepositService.getObjById(Long.parseLong(id));
				mv.addObject("obj", predeposit);
				mv.addObject("currentPage", currentPage);
				mv.addObject("edit", true);
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * predeposit保存管理
	 * 
	 * @param id
	 * @return
	 */
//	@SecurityMapping(title = "预存款保存", value = "/admin/predeposit_save.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "会员")
//	@RequestMapping("/admin/predeposit_save.htm")
//	public ModelAndView predeposit_save(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String cmd, String list_url) {
//		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request, response);
//		 if (this.configService.getSysConfig().getDeposit()) {
//		 WebForm wf = new WebForm();
//		 Predeposit obj =
//		 this.predepositService.getObjById(Long.parseLong(id));
//		 Predeposit predeposit = (Predeposit) wf.toPo(request, obj);
//		 predeposit.setPd_admin(SecurityUserHolder.getCurrentUser());
//		 this.predepositService.update(predeposit);
//		 if (predeposit.getPdStatus() == 1) {
//		 User pd_user = predeposit.getPd_user();
//		 pd_user.setAvailableBalance(BigDecimal.valueOf(CommUtil.add(
//		 pd_user.getAvailableBalance(),
//		 predeposit.getPd_amount())));
//		 this.userService.update(pd_user);
//		 }
//		 // 保存充值日志
//		 PredepositLog log = obj.getLog();
//		 log.setPd_log_admin(SecurityUserHolder.getCurrentUser());
//		 this.predepositLogService.update(log);
//		
//		 mv.addObject("list_url", list_url);
//		 mv.addObject("op_title", "审核预存款成功");
//		 } else {
//		 mv = new JModelAndView("admin/blue/error.html",
//		 configService.getSysConfig(),
//		 this.userConfigService.getUserConfig(), 0, request,
//		 response);
//		 mv.addObject("op_title", "系统未开启预存款");
//		 mv.addObject("list_url", CommUtil.getURL(request)
//		 + "/admin/operation_base_set.htm");
//		 }
//		return mv;
//	}

	//
//	@SecurityMapping(title = "预存款手动修改", value = "/admin/predeposit_modify.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "会员")
//	@RequestMapping("/admin/predeposit_modify.htm")
//	public ModelAndView predeposit_modify(HttpServletRequest request, HttpServletResponse response) {
//		ModelAndView mv = new JModelAndView("admin/blue/predeposit_modify.html", configService.getSysConfig(), 0, request, response);
//		if (!this.configService.getSysConfig().getDeposit()) {
//			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request, response);
//			mv.addObject("op_title", "系统未开启预存款");
//			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
//		}
//		return mv;
//	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	//
	@SecurityMapping(title = "加载用户预存款信息", value = "/admin/predeposit_user.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_user.htm")
	public void predeposit_user(HttpServletRequest request, HttpServletResponse response, String userName) {
		UserCustomerBO user = this.customerService.selectByNickname(userName);
		Map map = new HashMap<>();
		if (user != null) {
			map.put("freezeBlance", CommUtil.null2Double(user.getFreezeBlance()));
			map.put("availableBalance", CommUtil.null2Double(user.getAvailableBalance()));
			map.put("id", user.getUid());
			map.put("status", "success");
		} else {
			map.put("status", "error");
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(JSON.toJSON(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//
//	@SecurityMapping(title = "预存款手动修改保存", value = "/admin/predeposit_modify_save.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "会员")
//	@RequestMapping("/admin/predeposit_modify_save.htm")
//	public ModelAndView predeposit_modify_save(HttpServletRequest request, HttpServletResponse response, String user_id, String amount, String type, String info, String list_url,
//			String refund_user_id, String obj_id, String gi_id) {
//		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request, response);
//		if (this.configService.getSysConfig().getDeposit()) {
//			UserCustomer user = null;
//			if (user_id != null && !user_id.equals("")) {
////				user = this.userService.getObjById(CommUtil.null2Long(user_id));
//				user = customerService.findById(CommUtil.null2Long(user_id));
//			} else {
////				user = this.userService.getObjById(CommUtil.null2Long(refund_user_id));
//				user = customerService.findById(CommUtil.null2Long(refund_user_id));
//			}
//
//			if (type.equals("free")) {
//				user.setFreezeBlance(BigDecimal.valueOf(CommUtil.add(user.getFreezeBlance(), amount)));
//			} else {
////				user.setAvailableBalance(BigDecimal.valueOf(CommUtil.add(user.getAvailableBalance(), amount)));
//			}
////			this.userService.update(user);
////			customerService.updateUser(user);
//			// 保存充值日志
////			PredepositLog log = new PredepositLog();
////			log.setPd_log_admin(SecurityUserHolder.getCurrentUser());
////			log.setAddTime(new Date());
////			log.setPd_log_amount(BigDecimal.valueOf(CommUtil.null2Double(amount)));
////			log.setPd_log_info(info);
////			log.setPd_log_user(user);
////			log.setPd_op_type("手动修改");
////			if (type.equals("free")) {
////				log.setPd_type("冻结预存款");
////			} else {
////				log.setPd_type("可用预存款");
////			}
////			this.predepositLogService.save(log);
//			mv.addObject("list_url", list_url);
//			mv.addObject("op_title", "审核预存款成功");
//		} else {
//			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request, response);
//			mv.addObject("op_title", "系统未开启预存款");
//			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
//		}
//		return mv;
//	}

	@SuppressWarnings({"unused"})
	@SecurityMapping(title = "导出表格", value = "/admin/predeposit_excel.htm*", rtype = "admin", rname = "云豆管理", rcode = "predeposit", rgroup = "云豆管理")
	@RequestMapping("/admin/predeposit_excel.htm")
	public void predeposit_excel(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String pdPayment, String pdPayStatus, String pdStatus, String pdUserName,
			String beginTime, String endTime, String pdRemittanceUser, String pdRemittanceBank, String pdSn,
			MyPage<PredepositBO> page ,Integer excelPageSize) {
		excelPageSize = 9999999;
		if(null != excelPageSize && excelPageSize.intValue() > 0){
			page.setPageSize(excelPageSize);
		}
		List<PredepositBO> list = predepositService.queryPredepositPageList(pdPayment, pdPayStatus, pdStatus,
				pdRemittanceUser, pdRemittanceBank, pdUserName, beginTime, endTime, pdSn, page);

		String sheetName = "充值管理";
		String title = "用户充值相关信息";
		int dateSize = list != null && list.size() > 0 ? list.size() : 0;
		List<String> cellValueList = new ArrayList<String>();
		cellValueList.add("云豆编号");
		cellValueList.add("会员名称");
		cellValueList.add("提交时间");
		cellValueList.add("支付方式");
		cellValueList.add("充值金额");
		cellValueList.add("支付状态");
		cellValueList.add("云豆状态");
		cellValueList.add("云豆备注");
		cellValueList.add("操作备注");

		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet(sheetName);
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		for (int i = 0; i < dateSize; i++) {
			anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
		}
		// 设置excel每列宽度
		for (int i = 0; i < cellValueList.size(); i++) {
			sheet.setColumnWidth(i, 6000);
		}
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
		cell.setCellValue(title);
		// 设置单元格内容格式时间
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
		style1.setWrapText(true);// 自动换行
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 文本格式
		HSSFCellStyle style2 = wb.createCellStyle();
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 金额格式
		HSSFCellStyle style3 = wb.createCellStyle();
		style3.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		row = sheet.createRow(1);
		int offet = 0;
		for (int i = 0; i < cellValueList.size(); i++) {
			cell = row.createCell(i);
			String value = cellValueList.get(i);
			if (value.equals("充值金额")) {
				cell.setCellStyle(style3);
			} else if (value.equals("提交时间")) {
				cell.setCellStyle(style1);
			} else {
				cell.setCellStyle(style2);
			}
			cell.setCellValue(value);
		}
		for (PredepositBO obj : list) {
			row = sheet.createRow(offet + 2);
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdNo());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getNickName());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatShortDate(obj.getAddTime()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositService.pdPayment(obj.getPdPayment()));

			cell = row.createCell(++i);
			cell.setCellStyle(style3);
			if(null == obj.getPdAmount()){
				obj.setPdAmount(BigDecimal.ZERO);
			}
			cell.setCellValue(obj.getPdAmount().toString());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositService.payStatus(obj.getPdPayStatus()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositService.pdStatus(obj.getPdStatus()));

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdRemittanceInfo());

			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdAdminInfo());
			offet++;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String excel_name = sdf.format(new Date());
		try {
			String path = request.getSession().getServletContext().getRealPath("") + File.separator + "excel";
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