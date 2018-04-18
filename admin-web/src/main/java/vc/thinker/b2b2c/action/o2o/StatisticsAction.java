package vc.thinker.b2b2c.action.o2o;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.service.StatisticsService;
import com.sinco.carnation.user.vo.OperatorVO;
import com.sinco.dic.client.DicNameMappingHandle;

/**
 * 
 * @ClassName: StatisticsAction
 * @Description: TODO(服务统计)
 * @author Tang
 * @date 2015年10月23日 下午3:44:02
 * 
 */
@SuppressWarnings("deprecation")
@Controller
public class StatisticsAction {

	@Autowired
	private SysConfigService configService;
	@Autowired
	private StatisticsService statisticsService;
	@Autowired
	private AreaServiceImpl areaService;

	@Autowired
	private DicNameMappingHandle dicMapping;

	@SecurityMapping(title = "服务统计信息", value = "/group/o2o_statistics.htm*", rtype = "admin", rname = "服务统计信息", rcode = "o2o_statistics", rgroup = "商户管理")
	@RequestMapping("/admin/group/o2o_statistics.htm")
	public ModelAndView applyList(HttpServletRequest request, HttpServletResponse response, OperatorVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/o2o_statistics.html", configService.getSysConfig(),
				0, request, response);
		List<Area> areas = this.areaService.getAllParentIsNull();
		mv.addObject("areas", areas);
		Map<String, Object> resultMap = statisticsService.getAdminStatistics(vo.getOperatorAreaId());
		dicMapping.mappinHandle(vo);
		mv.addObject("vo", vo);
		mv.addObject("resultMap", resultMap);
		return mv;
	}

	@SecurityMapping(title = "服务统计信息导出", value = "/group/o2o_statistics_export_excel.htm*", rtype = "admin", rname = "服务统计信息", rcode = "o2o_statistics", rgroup = "商户管理")
	@RequestMapping("/admin/group/o2o_statistics_export_excel.htm")
	public void exportExcel(HttpServletRequest request, HttpServletResponse response, String areaId) {
		Map<String, Object> resultMap = statisticsService.getAdminStatistics(areaId);

		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("服务统计");

		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		for (int i = 0; i < 2; i++) {
			anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1, 2 + i, (short) 1, 2 + i));
		}

		// 设置excel每列宽度
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);

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

		String title = "服务统计";
		String time = CommUtil.null2String(CommUtil.formatShortDate(new Date()));
		cell.setCellValue(this.configService.getSysConfig().getTitle() + title + "（" + time + "）");
		// 设置单元格内容格式时间
		HSSFCellStyle style1 = wb.createCellStyle();
		style1.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
		style1.setWrapText(true);// 自动换行
		style1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style1.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);

		HSSFCellStyle style2 = wb.createCellStyle();
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		int rowNum = 1;

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style1);
		cell.setCellValue("条目");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style1);
		cell.setCellValue("数量");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("运营商总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("operatorCount") + "个");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("商户总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("storeCount") + "个");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("会员总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("customerCount") + "个");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("服务订单总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("orderCount") + "个");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("产生的消费反润总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("resumeSum") + "个");

		// 新建一行
		row = sheet.createRow(rowNum);
		rowNum++;
		// 填充第一列
		cell = row.createCell(0);
		cell.setCellStyle(style2);
		cell.setCellValue("产生的手续费反润总数");
		// 填充第二列
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue(resultMap.get("rechangeSum") + "个");

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
	}
}
