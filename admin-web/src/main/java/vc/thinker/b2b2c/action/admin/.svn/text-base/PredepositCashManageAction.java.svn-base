package vc.thinker.b2b2c.action.admin;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.ActionResult;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.WebForm;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.pay.service.PredepositCashService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.shop.bo.PredepositCashBO;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.model.PredepositCash;
import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.service.UserMoneyService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: PredepositCashManageAction.java
 * </p>
 * 
 * <p>
 * Description:商城用户提现管理控制器，用来显示用户提现列表、处理用户提现申请、查询提现详情
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
 * @date 2014-5-30
 * 
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class PredepositCashManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PredepositCashService predepositcashService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private UserMoneyService moneyService;
	@Autowired
	private UserAccountService userAccountService;

	/**
	 * PredepositCash列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "提现申请列表", value = "/admin/predeposit_cash.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash.htm")
	public ModelAndView predeposit_cash(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String pd_userName, String beginTime,
			String userType, String endTime, String cash_payment, String cash_pay_status, String cash_status,
			String cash_userName, String cash_remittance_user, String cash_remittance_bank,
			MyPage<PredepositCashBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_cash.html", configService.getSysConfig(),
				0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			String url = this.configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}

			predepositcashService.queryPredepositCashPageList(cash_payment, cash_pay_status, cash_status,
					cash_remittance_user, cash_remittance_bank, cash_userName, beginTime, endTime, userType,
					page);
			BigDecimal amount = predepositcashService.sumPredepositCashPageList(cash_payment, cash_pay_status, cash_status,
					cash_remittance_user, cash_remittance_bank, cash_userName, beginTime, endTime, userType);
			
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			mv.addObject("amount", amount);
			mv.addObject("cash_payment", cash_payment);
			mv.addObject("cash_pay_status", cash_pay_status);
			mv.addObject("cash_userName", cash_userName);
			mv.addObject("cash_status", cash_status);
			mv.addObject("cash_remittance_user", cash_remittance_user);
			mv.addObject("cash_remittance_bank", cash_remittance_bank);
			mv.addObject("beginTime", beginTime);
			mv.addObject("endTime", endTime);
			mv.addObject("userType", userType);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm");
		}
		return mv;
	}

	/**
	 * predepositcash编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "提现申请编辑", value = "/admin/predeposit_cash_edit.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash_edit.htm")
	public ModelAndView predeposit_cash_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_cash_edit.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			if (id != null && !id.equals("")) {
				PredepositCash predepositcash = this.predepositcashService.getObjById(Long.parseLong(id));
				mv.addObject("obj", predepositcash);
				mv.addObject("currentPage", currentPage);
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm");
		}
		return mv;
	}

	/**
	 * predepositcash保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "提现审核编辑保存", value = "/admin/predeposit_cash_save.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash_save.htm")
	public ModelAndView predeposit_cash_save(HttpServletRequest request, String cash_admin_info,
			Integer cash_status, HttpServletResponse response, String id, String currentPage, String cmd,
			String list_url) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			try {
				moneyService.audit(SecurityUserHolder.getCurrentUserId(), Long.parseLong(id),
						cash_admin_info, CommUtil.null2Int(cash_status));

			} catch (ServiceException e) {
				// e.printStackTrace();
				mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", e.getErrorCode());
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash_edit.htm?id="
						+ id);
				return mv;
			}

			mv.addObject("list_url", list_url);
			mv.addObject("op_title", "审核提现申请成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "提现申请详情", value = "/admin/predeposit_cash_view.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash_view.htm")
	public ModelAndView predeposit_cash_view(HttpServletRequest request, HttpServletResponse response, Long id) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_cash_view.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			if (id != null && !id.equals("")) {
				PredepositCashBO cashBO = predepositcashService.fetch(CommUtil.null2Long(id));
				mv.addObject("obj", cashBO);
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash_view.htm?id=" + id);
		}
		return mv;
	}

	/**
	 * predepositcash编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "提现支付操作", value = "/admin/predeposit_cash_complete.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash_complete.htm")
	public ModelAndView predeposit_cash_complete(HttpServletRequest request, HttpServletResponse response,
			Long id, Integer complete, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			try {
				PredepositCash predepositcash = new PredepositCash();
				predepositcash.setId(id);
				if (complete == 1) {
					predepositcash.setCashPayStatus(1);
				} else {
					predepositcash.setCashPayStatus(0);
				}
				this.predepositcashService.update(predepositcash);

			} catch (Exception e) {
				// e.printStackTrace();
				mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", "更新失败");
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash_edit.htm?id="
						+ id);
				return mv;
			}

			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm?currentPage="
					+ currentPage);
			mv.addObject("op_title", "审核提现申请成功");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "用户充值", value = "/admin/predeposit_recharge.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_recharge.htm")
	public ModelAndView predeposit_recharge(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/predeposit_recharge.html",
				configService.getSysConfig(), 0, request, response);
		if (!this.configService.getSysConfig().getDeposit()) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/predeposit_cash.htm");
		}
		return mv;
	}

	@Autowired
	private PredepositService predepositService;

	@Autowired
	private UserMoneyService userMoneyService;

	@ResponseBody
	@RequestMapping("/admin/check_user_phone.htm")
	public String check_user_phone(String phone) {
		if (StringUtils.isBlank(phone)) {
			return Json.toJson(ActionResult.NewFail("手机号不能为空"));
		}
		// TODO
		// UserCustomerBO bo = customerService.findByMobile(phone);
		UserAccountBO bo = userAccountService.findByLoginName(phone);// 以account表为主
		if (bo == null) {
			return Json.toJson(ActionResult.NewFail("不存在该会员"));
		}
		double balance = userMoneyService.getAvailableBalance(bo.getUid());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", bo.getUid());
		map.put("balance", balance);
		return Json.toJson(ActionResult.NewSuccess(map));

	}

	@SecurityMapping(title = "用户充值", value = "/admin/predeposit_recharge_save.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_recharge_save.htm")
	public ModelAndView predeposit_recharge_save(HttpServletRequest request, HttpServletResponse response,
			String phone, String op, BigDecimal amount, String info) {
		if (!this.configService.getSysConfig().getDeposit()) {
			return jumpToUrl(request, response, false, "系统未开启预存款", "/admin/predeposit_recharge.htm");
		}

		if (StringUtils.isBlank(phone)) {
			return jumpToUrl(request, response, false, "手机号不能为空！", "/admin/predeposit_recharge.htm");
		}

		if (amount == null) {
			return jumpToUrl(request, response, false, "金额不能为空！", "/admin/predeposit_recharge.htm");
		}

		try {
			// UserCustomerBO bo = customerService.findByMobile(phone);
			UserAccountBO bo = userAccountService.findByLoginName(phone);// 以account表为主
			if (bo == null) {
				return jumpToUrl(request, response, false, "该用户不存在！", "/admin/predeposit_recharge.htm");
			}

			WebForm wf = new WebForm();
			Predeposit obj = wf.toPo(request, Predeposit.class);
			obj.setPdPayment("后台调整");
			obj.setPdAdminId(SecurityUserHolder.getCurrentUserId());
			obj.setPdUserId(bo.getUid());
			obj.setPdAdminInfo(info);
			obj.setPdPayStatus(1);

			if ("add".equals(op)) {
				obj.setPdAmount(amount);
			} else {
				obj.setPdAmount(amount.multiply(BigDecimal.valueOf(-1)));
			}

			this.moneyService.rechargeMoneySave(obj, bo.getUid());

		} catch (ServiceException e) {
			return jumpToUrl(request, response, false, e.getErrorCode(), "/admin/predeposit_recharge.htm");
		} catch (Exception e) {
			return jumpToUrl(request, response, false, "充值失败", "/admin/predeposit_recharge.htm");
		}

		return jumpToUrl(request, response, true, "充值成功!", "/admin/predeposit_recharge.htm");
	}

	private ModelAndView jumpToUrl(HttpServletRequest request, HttpServletResponse response,
			boolean isSuccess, String title, String listUrl) {
		ModelAndView mv;
		String jumpUrl = "admin/blue/success.html";
		if (!isSuccess) {
			jumpUrl = "admin/blue/error.html";
		}

		mv = new JModelAndView(jumpUrl, configService.getSysConfig(), 0, request, response);
		mv.addObject("op_title", title);
		mv.addObject("list_url", CommUtil.getURL(request) + listUrl);
		return mv;
	}
	@SuppressWarnings("unused")
	@SecurityMapping(title = "导出提现申请列表", value = "/admin/predeposit_cash_excel.htm*", rtype = "admin", rname = "预存款管理", rcode = "predeposit", rgroup = "财务管理")
	@RequestMapping("/admin/predeposit_cash_excel.htm")
	public void predeposit_cash_excel(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String pd_userName, String beginTime,
			String userType, String endTime, String cash_payment, String cash_pay_status, String cash_status,
			String cash_userName, String cash_remittance_user, String cash_remittance_bank,
			MyPage<PredepositCashBO> page){
		page.setPageSize(9999999);
		List<PredepositCashBO> list = predepositcashService.queryPredepositCashPageList(cash_payment, cash_pay_status, cash_status,
				cash_remittance_user, cash_remittance_bank, cash_userName, beginTime, endTime, userType,
				page);
		int dateSize = list!=null?list.size():0;
		String cellValue = "提现编号,会员名称,会员类型,手机号码,提交时间,提现方式,收款账号,收款姓名,收款银行, 提现金额,支付状态,提现状态,提现备注,操作备注";
		String[] cellValueArr = cellValue.split(",");
		String sheetName = "提现管理";
		String title = "用户提现相关信息";
		
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet(sheetName);
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		for (int i = 0; i < dateSize; i++) {
			anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
		}
		//设置excel每列宽度
		for (int i = 0; i < cellValueArr.length; i++) {
			sheet.setColumnWidth(i, 6000);
		}
		
		//创建字体样式
		HSSFFont font = wb.createFont();
		font.setFontName("Verdana");
		font.setBoldweight((short) 100);
		font.setFontHeight((short) 300);
		font.setColor(HSSFColor.BLUE.index);
		//创建单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		style.setFillForegroundColor(HSSFColor.LIGHT_TURQUOISE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		//设置边框
		style.setBottomBorderColor(HSSFColor.RED.index);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		//设置字体
		style.setFont(font);
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
		for(int i = 0;i<cellValueArr.length;i++)
		{
			cell = row.createCell(i);
			String value = cellValueArr[i];
			if(value.equals("提现金额"))
			{
				cell.setCellStyle(style3);
			}
			else if(value.equals("提交时间"))
			{
				cell.setCellStyle(style1);
			}
			else
			{
				cell.setCellStyle(style2);
			}
			cell.setCellValue(value);
		}
		//提现编号,会员名称,会员类型,手机号码,提交时间,提现方式,收款账号,收款姓名,收款银行, 提现金额,支付状态,提现状态,提现备注,操作备注
		for(PredepositCashBO obj:list)
		{
			row = sheet.createRow(offet + 2);
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashSn());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getNickName());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositcashService.userType(obj.getUserType(), obj.getSerllerId()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getMobile());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatShortDate(obj.getAddTime()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositcashService.cashPayment(obj.getCashPayment()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashAccount());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashUserName());
			
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashBank());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style3);
			cell.setCellValue(obj.getCashAmount().subtract(obj.getCashPoundage()).toString());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositcashService.cashPayStatus(obj.getCashPayStatus()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(this.predepositcashService.cashStatus(obj.getCashStatus()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashInfo());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashAdminInfo());
			
			/*cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getCashAdminInfo());*/
			
			offet++;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String excel_name = sdf.format(new Date());
		try {
			String path = request.getSession().getServletContext().getRealPath("") + File.separator
					+ "excel";
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