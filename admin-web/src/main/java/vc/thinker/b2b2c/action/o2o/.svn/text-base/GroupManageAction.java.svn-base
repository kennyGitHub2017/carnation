package vc.thinker.b2b2c.action.o2o;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsTypeService;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GroupManageAction.java
 * </p>
 * 
 * <p>
 * Description: 服务管理控制器，用来添加（编辑、删除）服务信息、审核参团服务
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
@Controller
public class GroupManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private LuceneVoTools luceneVoTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private GoodsTypeService goodsTypeService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private StoreSearchService storeSearchService;

	/**
	 * Group列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "服务列表", value = "/admin/group_goods_list.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_list.htm")
	public ModelAndView group_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo, String province, String city) {
		ModelAndView mv = new JModelAndView("admin/blue/group_goods_list.html", configService.getSysConfig(),
				0, request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		if (StringUtils.isNotEmpty(province)) {
			vo.setGgGaId(CommUtil.null2Long(province));
		}
		if (StringUtils.isNotEmpty(city)) {
			vo.setGgGaId(CommUtil.null2Long(city));
		}
		// 省份列表
		List<Area> provinces = this.areaService.getAllParentIsNull();
		// 市区列表
		List<Area> citys = this.areaService.findByParentId(CommUtil.null2Long(province));
		Long ggGcId = vo.getGgGcId();
		Set<Long> groupClassIds = new HashSet<Long>();
		if (vo.getGgGcId() != null) {
			List<GroupClassBO> childs = groupClassService.findChildList(ggGcId);
			groupClassIds.add(vo.getGgGcId());
			for (GroupClassBO child : childs) {
				groupClassIds.add(child.getId());
			}
			vo.setGroupClassIds(groupClassIds);
			vo.setGgGcId(null);
		}
		vo.setGgGcId(null);
		// 服务分类
		List<GroupClassBO> gcs = this.groupClassService.findAllParents();
		// 服务列表
		page.setPageSize(10);
		vo.setYysFlag("yys");
		vo.setOwnType(1);
		this.groupGoodsService.findListByVO(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("province", province);
		mv.addObject("city", city);
		mv.addObject("citys", citys);
		mv.addObject("provinces", provinces);
		mv.addObject("vo",vo);
		System.out.println(vo.getGgGcId());
		mv.addObject("ggcId",ggGcId);
		mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "服务列表导出", value = "/admin/group_goods_list_export.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_list_export.htm")
	public void group_goods_list_export(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo, String province, String city) {

		if (StringUtils.isNotEmpty(province)) {
			vo.setGgGaId(CommUtil.null2Long(province));
		}
		if (StringUtils.isNotEmpty(city)) {
			vo.setGgGaId(CommUtil.null2Long(city));
		}
		Long ggGcId = vo.getGgGcId();
		Set<Long> groupClassIds = new HashSet<Long>();
		if (vo.getGgGcId() != null) {
			List<GroupClassBO> childs = groupClassService.findChildList(ggGcId);
			groupClassIds.add(vo.getGgGcId());
			for (GroupClassBO child : childs) {
				groupClassIds.add(child.getId());
			}
			vo.setGroupClassIds(groupClassIds);
			vo.setGgGcId(null);
		}
		vo.setGgGcId(null);

		// 服务列表
		page.setPageSize(1000000000);
		vo.setYysFlag("yys");
		this.groupGoodsService.findListByVO(page, vo);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupGoodsBO> datas = page.getContent();

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

			String title = "服务列表";
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
			cell.setCellValue("服务名称");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("分类名");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("服务类型");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("商户名称");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("状态");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("查看次数");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGgName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGroupClassName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String getGoodsTypeName = "无";
				if (datas.get(j - 2).getGoodsType() == 1)
					getGoodsTypeName = "套餐券";
				else if (datas.get(j - 2).getGoodsType() == 2)
					getGoodsTypeName = "现金券";
				cell.setCellValue(getGoodsTypeName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String storeName = "";
				if (null != datas.get(j - 2).getStore())
					storeName = datas.get(j - 2).getStore().getStoreName();
				cell.setCellValue(storeName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String goodsStatus = "";
				if (null != datas.get(j - 2).getGgStatus()) {
					Integer ggStatus = datas.get(j - 2).getGgStatus();
					if (ggStatus == 0) {
						goodsStatus = "上架";
					}
					if (ggStatus == 1) {
						if (datas.get(j - 2).getGroupStatus() == 0) {
							goodsStatus = "待审核";
						}
						if (datas.get(j - 2).getGroupStatus() == -1) {
							goodsStatus = "审核未通过";
						}
					}
					if (ggStatus == -1) {
						goodsStatus = "手动下架";
					}
					if (ggStatus == 2) {
						goodsStatus = "定时自动上架";
					}
					if (ggStatus == 3) {
						goodsStatus = "店铺过期自动下架";
					}
					if (ggStatus == -2) {
						goodsStatus = "违规下架";
					}
					if (ggStatus == -3) {
						goodsStatus = "被举报禁售";
					}
				}
				cell.setCellValue(goodsStatus);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGgClick());
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

	/**
	 * Group列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "违规下架服务列表导出", value = "/admin/group_goods_outline_export.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_outline_export.htm")
	public void group_goods_outline_export(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo, String province, String city) {

		if (StringUtils.isNotEmpty(province)) {
			vo.setGgGaId(CommUtil.null2Long(province));
		}
		if (StringUtils.isNotEmpty(city)) {
			vo.setGgGaId(CommUtil.null2Long(city));
		}
		Long ggGcId = vo.getGgGcId();
		Set<Long> groupClassIds = new HashSet<Long>();
		if (vo.getGgGcId() != null) {
			List<GroupClassBO> childs = groupClassService.findChildList(ggGcId);
			groupClassIds.add(vo.getGgGcId());
			for (GroupClassBO child : childs) {
				groupClassIds.add(child.getId());
			}
			vo.setGroupClassIds(groupClassIds);
			vo.setGgGcId(null);
		}
		vo.setGgGcId(null);
		// 服务列表
		page.setPageSize(1000000000);
		this.groupGoodsService.findListByVO(page, vo);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<GroupGoodsBO> datas = page.getContent();

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

			String title = "违规下架服务列表";
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
			cell.setCellValue("服务名称");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("服务类型");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("分类名");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("查看次数");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("查看次数");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGgName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String getGoodsTypeName = "无";
				if (datas.get(j - 2).getGoodsType() == 1)
					getGoodsTypeName = "套餐券";
				else if (datas.get(j - 2).getGoodsType() == 2)
					getGoodsTypeName = "现金券";
				cell.setCellValue(getGoodsTypeName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGroupClassName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGgClick());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOffCause());

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

	@SecurityMapping(title = "违规下架服务列表", value = "/admin/group_goods_outline.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_outline.htm")
	public ModelAndView group_goods_outline(HttpServletRequest request, HttpServletResponse response,
			MyPage<GroupGoodsBO> page, GroupGoodsVO vo, String province, String city) {

		ModelAndView mv = new JModelAndView("admin/blue/group_goods_outline.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(province)) {
			vo.setGgGaId(CommUtil.null2Long(province));
		}
		if (StringUtils.isNotEmpty(city)) {
			vo.setGgGaId(CommUtil.null2Long(city));
		}
		// 省份列表
		List<Area> provinces = this.areaService.getAllParentIsNull();
		// 市区列表
		List<Area> citys = this.areaService.findByParentId(CommUtil.null2Long(province));
		Long ggGcId = vo.getGgGcId();
		Set<Long> groupClassIds = new HashSet<Long>();
		if (vo.getGgGcId() != null) {
			List<GroupClassBO> childs = groupClassService.findChildList(ggGcId);
			groupClassIds.add(vo.getGgGcId());
			for (GroupClassBO child : childs) {
				groupClassIds.add(child.getId());
			}
			vo.setGroupClassIds(groupClassIds);
			vo.setGgGcId(null);
		}
		vo.setGgGcId(null);
		// 服务分类
		List<GroupClassBO> gcs = this.groupClassService.findAllParents();
		// 服务列表
		page.setPageSize(10);
		this.groupGoodsService.findListByVO(page, vo);

		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		mv.addObject("province", province);
		mv.addObject("city", city);
		mv.addObject("citys", citys);
		mv.addObject("provinces", provinces);
		mv.addObject("vo", vo);
		mv.addObject("gcs", gcs);
		return mv;
	}

	@SecurityMapping(title = "服务删除", value = "/admin/group_goods_del.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_del.htm")
	public String group_del(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!"".equals(id)) {
				GroupGoods gg = this.groupGoodsService.getObjById(CommUtil.null2Long(id));
				this.groupGoodsService.delete(CommUtil.null2Long(id));
				this.storeSearchService.updateIndex(gg.getStoreId());
			}
		}
		return "redirect:group_goods_list.htm";
	}

	@SecurityMapping(title = "服务审核界面", value = "/admin/group_goods_audit_page.htm*", rtype = "admin", rname = "服务管理（审核）", rcode = "admin_group_goods_audit_page", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_audit_page.htm")
	public ModelAndView group_goods_audit_page(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/group_goods_audit.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("id", id);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "服务审核", value = "/admin/group_goods_audit.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_audit.htm")
	public String group_goods_audit(HttpServletRequest request, HttpServletResponse response, String id,
			String groupStatus, String refusedReasonDesc, String currentPage) {
		if (!"".equals(id)) {
			if (StringUtils.isNotEmpty(groupStatus)) {
				GroupGoods gg = this.groupGoodsService.getObjById(CommUtil.null2Long(id));
				gg.setGroupStatus(CommUtil.null2Int(groupStatus));
				if ("1".equals(groupStatus)) {
					gg.setGgStatus(0);
				}

				gg.setRefusedReasonDesc(StringUtils.isNotEmpty(refusedReasonDesc) ? refusedReasonDesc : null);// 审核拒绝原因(原因说明为空则不更新)

				this.groupGoodsService.update(gg);

				this.storeSearchService.updateIndex(gg.getStoreId());
			}
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		return "redirect:group_goods_list.htm?groupStatus=0&currentPage=" + currentPage;
	}

//	@SecurityMapping(title = "团购商品审核拒绝", value = "/admin/group_goods_refuse.htm*", rtype = "admin", rname = "团购管理", rcode = "group_admin", rgroup = "运营")
//	@RequestMapping("/admin/group_goods_refuse.htm")
//	public String group_goods_refuse(HttpServletRequest request,
//			HttpServletResponse response, String mulitId, String group_id,
//			String gg_status, String currentPage) {
//		String[] ids = mulitId.split(",");
//		for (String id : ids) {
//			if (!id.equals("")) {
//				GroupGoods gg = this.groupGoodsService.getObjById(CommUtil
//						.null2Long(id));
//				Goods goods = gg.getGg_goods();
//				goods.setGroup_buy(0);
//				goods.setGroup(null);
//				goods.setGoods_current_price(goods.getStore_price());
//				this.goodsService.update(goods);
//				gg.setGg_status(-1);
//				this.groupGoodsService.update(gg);
//			}
//		}
//		return "redirect:group_goods_list.htm?group_id=" + group_id
//				+ "&gg_status=" + gg_status + "&currentPage=" + currentPage;
//	}

	@SecurityMapping(title = "服务推荐", value = "/admin/group_goods_recommend.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_recommend.htm")
	public ModelAndView group_goods_recommend(HttpServletRequest request, HttpServletResponse response,
			String id) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_group_goods_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			List<AdvertPosition> apsList = advertPositionService.findList();
			GroupGoods gg = this.groupGoodsService.getObjById(CommUtil.null2Long(id));
			mv.addObject("adTypeServe", AdvertContant.ADVERT_TPYE_SERVE);
			mv.addObject("ggid", id);
			mv.addObject("gg", gg);
			mv.addObject("aps", apsList);
			mv.addObject("groupGoodsFlag", true);
		}

		return mv;
	}

//	@SecurityMapping(title = "团购商品审核推荐", value = "/admin/group_lifegoods_recommend.htm*", rtype = "admin", rname = "团购管理", rcode = "group_admin", rgroup = "运营")
//	@RequestMapping("/admin/group_lifegoods_recommend.htm")
//	public String group_lifegoods_recommend(HttpServletRequest request,
//			HttpServletResponse response, String mulitId, String group_id,
//			String gg_status, String currentPage) {
//		String[] ids = mulitId.split(",");
//		for (String id : ids) {
//			if (!id.equals("")) {
//				GroupLifeGoods gg = this.groupLifeGoodsService
//						.getObjById(CommUtil.null2Long(id));
//				if (gg.isGroup_recommend()) {
//					gg.setGroup_recommend(false);
//				} else {
//					gg.setGroup_recommend(true);
//				}
//				this.groupLifeGoodsService.update(gg);
//			}
//		}
//		return "redirect:group_goods_list.htm?group_id=" + group_id
//				+ "&gg_status=" + gg_status + "&currentPage=" + currentPage
//				+ "&type=life";
//	}

//	@SecurityMapping(title = "服务审核通过", value = "/admin/group_lifegoods_audit.htm*", rtype = "admin", rname = "团购管理", rcode = "group_admin", rgroup = "运营")
//	@RequestMapping("/admin/group_lifegoods_audit.htm")
//	public String group_lifegoods_audit(HttpServletRequest request,
//			HttpServletResponse response, String mulitId, String group_id,
//			String gg_status, String currentPage) {
//		String[] ids = mulitId.split(",");
//		for (String id : ids) {
//			if (!id.equals("")) {
//				GroupLifeGoods gg = this.groupLifeGoodsService
//						.getObjById(CommUtil.null2Long(id));
//				if (gg.getBeginTime().before(new Date())
//						|| CommUtil.formatShortDate(gg.getBeginTime()).equals(
//								CommUtil.formatShortDate(new Date()))) {
//					gg.setGroup_status(1);
//					String goods_lucene_path = System.getProperty("thinkervcb2b2c.root")
//							+ File.separator + "luence" + File.separator + "lifegoods";
//					File file = new File(goods_lucene_path);
//					if (!file.exists()) {
//						CommUtil.createFolder(goods_lucene_path);
//					}
//					//LuceneUtil lucene = LuceneUtil.instance();
//					SysConfig config = this.configService.getSysConfig();
//					luceneUtil.setLucenenQueue(config.getLucenen_queue());
//					//lucene.setIndex_path(goods_lucene_path);
//					if (id.equals("")) {
//						this.groupLifeGoodsService.save(gg);
//						LuceneVo vo = this.luceneVoTools
//								.updateLifeGoodsIndex(gg);
//						luceneUtil.writeIndex(vo);
//					} else {
//						this.groupLifeGoodsService.update(gg);
//						LuceneVo vo = this.luceneVoTools
//								.updateLifeGoodsIndex(gg);
//						luceneUtil.update(gg.getId().toString(), vo);
//					}
//				}else{
//					gg.setGroup_status(2);
//				}
//				this.groupLifeGoodsService.update(gg);
//			}
//		}
//		return "redirect:group_goods_list.htm?group_id=" + group_id
//				+ "&gg_status=" + gg_status + "&currentPage=" + currentPage
//				+ "&type=life";
//	}

//	@SecurityMapping(title = "团购商品审核拒绝", value = "/admin/group_lifegoods_refuse.htm*", rtype = "admin", rname = "团购管理", rcode = "group_admin", rgroup = "运营")
//	@RequestMapping("/admin/group_lifegoods_refuse.htm")
//	public String group_lifegoods_refuse(HttpServletRequest request,
//			HttpServletResponse response, String mulitId, String group_id,
//			String gg_status, String currentPage) {
//		String[] ids = mulitId.split(",");
//		for (String id : ids) {
//			if (!id.equals("")) {
//				GroupLifeGoods gg = this.groupLifeGoodsService
//						.getObjById(CommUtil.null2Long(id));
//				gg.setGroup_status(-1);
//				this.groupLifeGoodsService.update(gg);
//			}
//		}
//		return "redirect:group_goods_list.htm?group_id=" + group_id
//				+ "&gg_status=" + gg_status + "&currentPage=" + currentPage
//				+ "&type=life";
//	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "服务AJAX更新", value = "/admin/group_goods_ajax.htm*", rtype = "admin", rname = "服务管理", rcode = "admin_group_goods", rgroup = "商户管理")
	@RequestMapping("/admin/group_goods_ajax.htm")
	public void goods_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value, String offCause) throws ClassNotFoundException {
		GroupGoods obj = this.groupGoodsService.getObjById(Long.parseLong(id));
		Field[] fields = GroupGoods.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(obj);
		Object val = null;
		for (Field field : fields) {
			if (field.getName().equals(fieldName)) {
				Class clz = Class.forName("java.lang.String");
				if (field.getType().getName().equals("int")) {
					clz = Class.forName("java.lang.Integer");
				}
				if (field.getType().getName().equals("boolean")) {
					clz = Class.forName("java.lang.Boolean");
				}
				if (!value.equals("")) {
					val = BeanUtils.convertType(value, clz);
				} else {
					val = !CommUtil.null2Boolean(wrapper.getPropertyValue(fieldName));
				}
				wrapper.setPropertyValue(fieldName, val);
			}
		}
//		if (fieldName.equals("storeRecommend")) {
//			if (obj.getStoreRecommend() != null && obj.getStoreRecommend()) {
//				obj.setStoreRecommendTime(new Date());
//			} else
//				obj.setStoreRecommendTime(null);
//		}
		this.groupGoodsService.update(obj);
		if ("ggStatus".equals(fieldName)) {
			obj.setOffCause(offCause);
			groupGoodsService.update(obj);
			this.storeSearchService.updateIndex(obj.getStoreId());
		}
//		if (obj.getGgStatus() == 0) {
//			// 更新lucene索引
//			LuceneVo vo = this.luceneVoTools.updateGoodsIndex(obj);
//			luceneUtil.update(CommUtil.null2String(obj.getId()), vo);
//		} else {
//			luceneUtil.delete_index(GoodsDocument.class,CommUtil.null2String(id));
//		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}