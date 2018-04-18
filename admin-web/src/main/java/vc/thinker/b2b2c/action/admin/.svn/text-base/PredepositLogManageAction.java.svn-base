package vc.thinker.b2b2c.action.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.pay.service.PredepositLogService;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.vo.PredepositLogVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: PredepositLogManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商城预存款管理控制器，用来显示系统预存款明细数据
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
public class PredepositLogManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private PredepositLogService predepositlogService;

	/**
	 * PredepositLog列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "预存款明细列表", value = "/admin/predepositlog_list.htm*", rtype = "admin", rname = "预存款明细", rcode = "predeposit_log", rgroup = "财务管理")
	@RequestMapping("/admin/predepositlog_list.htm")
	public ModelAndView predepositlog_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String userName, PredepositLogVO vo,
			MyPage<PredepositLogBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/predepositlog_list.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getDeposit()) {
			String url = this.configService.getSysConfig().getAddress();
			if (url == null || url.equals("")) {
				url = CommUtil.getURL(request);
			}
			predepositlogService.queryByUserName(vo, page);
			CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
			CommUtil.saveIPageList2ModelAndView(url + "/admin/predepositlog_list.htm", "", "", page, mv);
			mv.addObject("userName", userName);
			mv.addObject("vo", vo);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启预存款");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}

		return mv;
	}
	
	@SuppressWarnings({"unchecked", "unused"})
	@SecurityMapping(title = "预存款明细列表", value = "/admin/predepositlog_list_excel.htm*", rtype = "admin", rname = "预存款明细", rcode = "predeposit_log", rgroup = "财务管理")
	@RequestMapping("/admin/predepositlog_list_excel.htm")
	public void predepositlog_list_excel(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType, String userName, PredepositLogVO vo,
			MyPage<PredepositLogBO> page) {
		page.setPageSize(9999999);
		if(StringUtils.isBlank(vo.getUserCode())){
			vo.setUserCode(null);
		}
		predepositlogService.queryByUserName(vo, page);
		List<PredepositLogBO> list = page.getResult();
		
		int dateSize = list!=null?list.size():0;
		String cellValue = "会员名称,提交时间,金额,云豆余额,云豆类型,会员角色,操作类型,操作管理员,描述";
		String[] cellValueArr = cellValue.split(",");
		String sheetName = "云豆明细";
		String title = "云豆明细相关信息";
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet(sheetName);
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		for (int i = 0; i < dateSize; i++) {
			anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
		}
		// 设置excel每列宽度
		for (int i = 0; i < cellValueArr.length; i++) {
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
		// 设置字体
		style.setFont(font);
		// 创建Excel的sheet的一行
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 500);// 设定行的高度
		// 创建一个Excel的单元格
		HSSFCell cell = row.createCell(0);
		// 合并单元格(startRow，endRow，startColumn，endColumn)
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 7));
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
		for (int i = 0; i < cellValueArr.length; i++) {
			cell = row.createCell(i);
			String value = cellValueArr[i];
			if (value.equals("金额") || value.equals("云豆余额")) {
				cell.setCellStyle(style3);
			} else if (value.equals("提交时间")) {
				cell.setCellStyle(style1);
			} else {
				cell.setCellStyle(style2);
			}
			cell.setCellValue(value);
		}
		//会员名称，提交时间，金额，云豆余额，云豆类型，操作类型，操作管理员，描述
		for(PredepositLogBO obj:list)
		{
			row = sheet.createRow(offet + 2);
			int i = 0;
			cell = row.createCell(i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getNickName());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(CommUtil.formatShortDate(obj.getAddTime()));
			
			cell = row.createCell(++i);
			cell.setCellStyle(style3);
			cell.setCellValue(obj.getPdLogAmount().toString());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style3);
			cell.setCellValue(obj.getBalance().toString());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdType());
			
			String userType="";
			if(obj.getUserCode().intValue()==1){
				userType = "供应商";
			}else if(obj.getUserCode().intValue()==2){
				userType = "商户";
			}else if(obj.getUserCode().intValue()==3){
				userType = "运营商";
			}else if(obj.getUserCode().intValue()==4){
				userType = "运营商";
			}else{
				userType = "个人";
			}
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(userType);
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdOpType());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getAdminName());
			
			cell = row.createCell(++i);
			cell.setCellStyle(style2);
			cell.setCellValue(obj.getPdLogInfo());
			
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
	
	/**
	 * 日志修正
	 */
	@SecurityMapping(title = "日志修正", value = "/admin/changeErrorBlance.htm*", rtype = "admin", rname = "日志修正", rcode = "predeposit_log", rgroup = "财务管理")
	@RequestMapping("/admin/changeErrorBlance.htm")
	public void changeErrorBlance(HttpServletRequest request, HttpServletResponse response) {
		
		predepositlogService.changeErrorBlance();
		
	}

}