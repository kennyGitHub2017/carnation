package vc.thinker.b2b2c.action.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.UserAccountBO;
import com.sinco.carnation.sys.constant.IntegralConstants;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.IntegralRegService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.bo.IntegralLogBO;
import com.sinco.carnation.user.model.UserCustomer;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.user.vo.IntegralLogVO;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: IntegralLogManageAction.java
 * </p>
 * 
 * <p>
 * Description: 系统积分日志管理类
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
 * @date 2014年5月27日
 * 
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class IntegralLogManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private IUserConfigService userConfigService;
	@Autowired
	private IntegralLogService integrallogService;
	/*	@Autowired
		private IUserService userService;*/
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private UserService userService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private IntegralRegService integralRegService;
	/**
	 * IntegralLog列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "积分明细", value = "/admin/integrallog_list.htm*", rtype = "admin", rname = "积分明细", rcode = "user_integral", rgroup = "商城管理")
	@RequestMapping("/admin/integrallog_list.htm")
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, String currentPage,
			IntegralLogVO vo, String type, MyPage<IntegralLogBO> page) {
		ModelAndView mv = new JModelAndView("admin/blue/integrallog_list.html", configService.getSysConfig(),
				0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(10);
		integrallogService.selectIntegralPageList(vo.userName,type,vo.getBeginTime(),vo.getEndTime(),page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		IntegralConstants integralConstants = new IntegralConstants();
		 
		mv.addObject("integralConstants", integralConstants);
		mv.addObject("vo", vo);
		mv.addObject("type", type);
		mv.addObject("types",integralRegService.selectAllType());
		return mv;
	}

	@SecurityMapping(title = "积分管理", value = "/admin/user_integral.htm*", rtype = "admin", rname = "积分管理", rcode = "user_integral_manage", rgroup = "商城管理")
	@RequestMapping("/admin/user_integral.htm")
	public ModelAndView user_integral(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/user_integral.html", configService.getSysConfig(), 0,
				request, response);
		SysConfig config = configService.getSysConfig();
		if (!config.getIntegral()) {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分功能，设置失败");
			mv.addObject("open_url", "admin/operation_base_set.htm");
			mv.addObject("open_op", "积分开启");
			mv.addObject("open_mark", "operation_base_op");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/welcome.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "积分动态获取", value = "/admin/verify_user_integral.htm*", rtype = "admin", rname = "积分管理", rcode = "user_integral_manage", rgroup = "会员")
	@RequestMapping("/admin/verify_user_integral.htm")
	public void verify_user_integral(HttpServletRequest request, HttpServletResponse response, String userName) {
		/*UserBO user = this.userService.findByLoginName(userName);*/
		UserAccountBO account = userAccountService.fetchByLoginName(userName);
		int ret = -1;
		if (account != null) {
			UserCustomer customer = userCustomerService.findById(account.getUid());
			ret = customer.getIntegral();
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(ret);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "积分管理保存", value = "/admin/user_integral_save.htm*", rtype = "admin", rname = "积分管理", rcode = "user_integral_manage", rgroup = "商城管理")
	@RequestMapping("/admin/user_integral_save.htm")
	public ModelAndView user_integral_save(HttpServletRequest request, HttpServletResponse response,
			String userName, String operateType, String integral, String content) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		// 当前操作用户id
		Long uid = SecurityUserHolder.getCurrentUserId();
		integrallogService.saveIntegrall(userName, operateType, content, integral, uid);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/user_integral.htm");
		mv.addObject("op_title", "操作用户积分成功");
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
	@SuppressWarnings({"unused"})
	@SecurityMapping(title = "导出表格", value = "/admin/integrallog_list_excel.htm*", rtype = "admin", rname = "积分明细统计", rcode = "admin_integrallog", rgroup = "用户管理")
	@RequestMapping("/admin/integrallog_list_excel.htm")
	public void integral_order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<IntegralLogBO> page, IntegralLogVO vo,String type) {
		List<IntegralLogBO> datas = new ArrayList<IntegralLogBO>();
		page.setPageSize(1000000000);
		datas = integrallogService.selectIntegralPageList(vo.userName,type,vo.getBeginTime(),vo.getEndTime(),page);
		if (datas != null && datas.size() > 0) {
			// datas = page.getContent();
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("积分明细列表");
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
			String title = "积分明细列表";
			Date time1 = CommUtil.formatDate("");
			Date time2 = CommUtil.formatDate("");
			String time = CommUtil.null2String(CommUtil.formatShortDate(time1) + " - "
					+ CommUtil.formatShortDate(time2));
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
			cell.setCellValue("会员名");
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("管理员操作");
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("积分值");
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("积分余额");
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("连续签到天数");
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("操作时间");
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("类型名称");
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("描述");

			int offet = 0;
			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(offet + 2);
				int i = 0;

				// 会员名
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getLoginName());

				// 操作管理员
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOperateName());
				//积分值
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getIntegral());
				//积分余额
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if(datas.get(j - 2).getBalance()!=null){
				cell.setCellValue(datas.get(j - 2).getBalance());
				}else{
					cell.setCellValue("");
				}
				//连续签到天数
				String signDay = "";
				if(datas.get(j - 2).getType() == "integral_sign_day"){
					signDay = datas.get(j - 2).getSignDay().toString();
				}else{
					signDay = "—";
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(signDay);
				//操作时间
				SimpleDateFormat format = new  SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(format.format(datas.get(j - 2).getAddtime()));
				//类型
				IntegralConstants integralConstants = new IntegralConstants();
				String tp = "";
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				if(type==null||type==""){
					tp = integralConstants.getNameByType(datas.get(j - 2).getType());
					cell.setCellValue(tp);
				}else{
					tp = integralConstants.getNameByType(type);
					cell.setCellValue(tp);
				}
				//描述
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue( datas.get(j - 2).getContent());
				offet++;
			}
			// 设置底部统计信息
			int m = datas.size() + 2;
			row = sheet.createRow(offet + 2);
			// 设置单元格的样式格式
			int i = 0;
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
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
}