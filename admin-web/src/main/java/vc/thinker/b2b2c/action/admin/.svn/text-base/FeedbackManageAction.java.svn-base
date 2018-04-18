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
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.FeedbackBO;
import com.sinco.carnation.user.service.FeedbackService;
import com.sinco.carnation.user.vo.FeedbackVO;
import com.sinco.dal.common.MyPage;

/**
 * 客户端反馈记录
 * 
 * @author young
 * 
 */
@SuppressWarnings("deprecation")
@Controller
public class FeedbackManageAction {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private FeedbackService feedbackService;

	@SecurityMapping(title = "反馈记录列表", value = "/admin/feedback_list.htm*", rtype = "admin", rname = "反馈记录列表", rcode = "admin_feedback", rgroup = "用户管理")
	@RequestMapping("/admin/feedback_list.htm")
	public ModelAndView feedback_list(FeedbackVO vo, MyPage<FeedbackBO> page, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/feedback_list.html", configService.getSysConfig(), 0,
				request, response);
		feedbackService.query(vo, page);
		mv.addObject("vo", vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "反馈记录详情", value = "/admin/feedback_content.htm*", rtype = "admin", rname = "反馈记录详情", rcode = "admin_feedback", rgroup = "用户管理")
	@RequestMapping("/admin/feedback_content.htm")
	public ModelAndView feedback_content(Long id, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("admin/blue/feedback_content.html", configService.getSysConfig(),
				0, request, response);
		mv.addObject("obj", feedbackService.fetch(id));
		return mv;
	}

	@SecurityMapping(title = "处理反馈记录", value = "/admin/feedback_list.htm*", rtype = "admin", rname = "处理反馈记录", rcode = "admin_feedback", rgroup = "用户管理")
	@RequestMapping("/admin/feedback_deal.htm")
	public void feedback_deal(Long id, Integer status, HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;

		String err = "";
		try {
			feedbackService.deal(id, status);
		} catch (ServiceException e) {
			err = e.getErrorCode();
		}

		try {
			writer = response.getWriter();
			writer.print(err);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings({"unused"})
	@SecurityMapping(title = "导出表格", value = "/admin/feedback_list_excel.htm*", rtype = "admin", rname = "处理反馈记录", rcode = "admin_feedback", rgroup = "用户管理")
	@RequestMapping("/admin/feedback_list_excel.htm")
	public void integral_order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<FeedbackBO> page, FeedbackVO vo) {
		List<FeedbackBO> datas = new ArrayList<FeedbackBO>();
		page.setPageSize(1000000000);
		datas = feedbackService.findForExcel(page, vo);
		if (datas != null && datas.size() > 0) {
			// datas = page.getContent();
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("反馈列表");
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
			String title = "反馈列表";
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
			cell.setCellValue("反馈用户");
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("反馈用户来源手机号");
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("来源APP");
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("反馈时间");
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("状态");
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("内容");

			int offet = 0;
			for (int j = 2; j <= datas.size() + 1; j++) {
				// 订单里面商品信息
				row = sheet.createRow(offet + 2);
				int i = 0;

				// 反馈用户
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getNickName());

				// 反馈用户来源手机号
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getMobile());

				// 来源APP
				String source = "";
				switch (datas.get(j - 2).getSource()) {
					case 1:
						source = "IOS个人端APP";
						break;
					case 2:
						source = "IOS商户端APP ";
						break;
					case 3:
						source = "IOS运营商APP";
						break;
					case 4:
						source = "安卓个人端APP";
						break;
					case 5:
						source = "安卓商户端APP";
						break;
					default:
						source = "安卓运营商APP";
						break;
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(source);

				// 反馈时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(sdf.format(datas.get(j - 2).getCreateTime()));

				// 状态
				String status = "";
				switch (datas.get(j - 2).getStatus()) {
					case 0:
						status = "未做任何处理";
						break;
					case 1:
						status = "处理";
						break;
					default:
						status = "不做处理 ";
						break;
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(status);
				// 内容
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getContent());
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
