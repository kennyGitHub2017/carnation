package vc.thinker.b2b2c.action.merchant;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
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
import org.elasticsearch.common.collect.Maps;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.AdminUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;

import com.alibaba.fastjson.JSON;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.service.GroupClassService;
import com.sinco.carnation.o2o.service.GroupGoodsService;
import com.sinco.carnation.o2o.service.GroupOrderService;
import com.sinco.carnation.operation.service.CouponInfoService;
import com.sinco.carnation.operation.service.CouponService;
import com.sinco.carnation.operation.service.ZTCGoldLogService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.PredepositService;
import com.sinco.carnation.rebate.service.RebateService;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.shop.RebateConstants;
import com.sinco.carnation.shop.service.ComplaintGoodsService;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.constants.StoreConstants;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreApplyInfo;
import com.sinco.carnation.store.service.PayoffLogService;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StorePointService;
import com.sinco.carnation.store.service.StoreSearchService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.vo.StoreApplyInfoVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.RoleService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.tools.MsgTools;
import com.sinco.carnation.user.bo.RebateRecordBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.service.GoldLogService;
import com.sinco.carnation.user.service.GoldRecordService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserOwnService;
import com.sinco.carnation.user.service.UserRelationService;
import com.sinco.carnation.user.vo.RebateRecordVO;
import com.sinco.carnation.user.vo.SellerVO;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.messager.MessageHandler;

/**
 * 
 * <p>
 * Title: MerchantManageAction.java
 * </p>
 * 
 * <p>
 * Description: 运营商商户管理控制器，用来管理商户，可以添加、修改、删除店铺，运营商所有对商户的操作均通过该管理控制器完成
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
 * @date 2015-9-5
 * 
 * @version 1.0.1
 */
@Controller
public class MerchantManageAction {

	private static final Logger log = LoggerFactory.getLogger(MerchantManageAction.class);
	@Autowired
	private SysConfigService configService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private ConsultService consultService;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	// @Autowired
	// private AlbumService albumService;
	@Autowired
	private GoodsClassService goodsclassService;
	@Autowired
	private StorePointService storePointService;
	// @Autowired
	// private Favorite favoriteService;
	@Autowired
	private ComplaintGoodsService complaintGoodsService;
	@Autowired
	private PredepositService predepositService;
	@Autowired
	private CouponInfoService couponInfoService;
	@Autowired
	private PayoffLogService paylogService;
	@Autowired
	private GoodsSpecPropertyService specpropertyService;
	@Autowired
	private GoodsSpecificationService specService;
	@Autowired
	private GoldRecordService grService;
	@Autowired
	private ZTCGoldLogService ztcglService;
	@Autowired
	private GoldLogService glService;
	@Autowired
	private CouponService couponService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private SellerService sellerService;
	@Autowired
	private UserOwnService userOwnService;
	@Autowired
	private GroupClassService groupClassService;
	@Autowired
	private GroupGoodsService groupGoodsService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private StoreSearchService searchService;
	@Resource(name = "smsMessageHandler")
	private MessageHandler smsHandler;
	@Autowired
	private MsgTools msgTools;

	@Autowired
	private GroupOrderService groupOrderService;

	@Autowired
	private RebateService rebateService;

	@Autowired
	private UserRelationService userRelationService;

	@Autowired
	private DicContent dicContent;

	/**
	 * 商户标签
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商户标签", value = "/admin/merchant_target_add.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_target_add.htm")
	public ModelAndView merchant_target(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_target_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotBlank(id)) {
			StoreBO storeBO = storeService.getObjById(CommUtil.null2Long(id));
			mv.addObject("obj", storeBO);
		}
		return mv;
	}

	/**
	 * 商户标签保存
	 * 
	 * @param request
	 * @param response
	 * @param id
	 */
	@SecurityMapping(title = "商户标签保存", value = "/admin/merchant_target_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_target_save.htm")
	public ModelAndView merchant_target_save(HttpServletRequest request, HttpServletResponse response,
			String id, String storeTarget) {
		if (StringUtils.isNotBlank(id) && StringUtils.isNotBlank(storeTarget)) {
			StoreBO store = storeService.getObjById(CommUtil.null2Long(id));
			store.setStoreTarget(storeTarget);
			if (storeService.save(store)) {
				// 更新索引
				this.searchService.updateIndex(CommUtil.null2Long(id));
			}
		}

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/merchant_list.htm?currentPage=1");
		return mv;
	}

	/**
	 * Merchant列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商户列表", value = "/admin/merchant_list.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_list.htm")
	public ModelAndView merchant_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<StoreBO> page, StoreVO vo, String province, String city,
			String operProvince, String operCity) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_list.html", configService.getSysConfig(), 0,
				request, response);
		vo.setIsO2o(true);
//		vo.setOwnType(1); userowns表不存在的商户应该也能搜出来
		if (StringUtils.isNotEmpty(province)) {
			String[] provinceArr = province.split(",");
			vo.setAreaId(CommUtil.null2Long(provinceArr[0]));
		}
		if (StringUtils.isNotEmpty(city)) {
			String[] cityArr = city.split(",");
			vo.setAreaId(CommUtil.null2Long(cityArr[0]));
		}
		if (StringUtils.isNotEmpty(operProvince)) {
			String[] provinceArr = operProvince.split(",");
			vo.setOperatorAreaId(CommUtil.null2Long(provinceArr[0]));
		}
		if (StringUtils.isNotEmpty(operCity)) {
			String[] cityArr = operCity.split(",");
			vo.setOperatorAreaId(CommUtil.null2Long(cityArr[0]));
		}
		this.storeService.findPageByVo(page, vo);
		List<Area> provinces = this.areaService.getAllParentIsNull();
		List<Area> citys = this.areaService.findByParentId(CommUtil.null2Long(province));
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		int a = 0;
		if (vo.getStoreRecommend() == null) {
			a = 0;
		} else if (vo.getStoreRecommend()) {
			a = 1;
		} else {
			a = 2;
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		AdminUserDetails basicUserDetails = (AdminUserDetails) SecurityUserHolder.getCurrentUserDetails();
		mv.addObject("basicUserDetails", basicUserDetails);
		mv.addObject("province", province);
		mv.addObject("city", city);
		mv.addObject("citys", citys);
		mv.addObject("vo", vo);
		mv.addObject("a", a);
		mv.addObject("provinces", provinces);
		mv.addObject("StoreConstants", new StoreConstants());
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "商户列表导出Excel", value = "/admin/merchant_list_excel.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_list_excel.htm")
	public void merchant_list_excel(HttpServletRequest request, HttpServletResponse response, StoreVO vo,
			String province, String city) {
		vo.setIsO2o(true);
		if (StringUtils.isNotEmpty(province)) {
			vo.setAreaId(CommUtil.null2Long(province));
		}
		if (StringUtils.isNotEmpty(city)) {
			vo.setAreaId(CommUtil.null2Long(city));
		}
		List<StoreBO> list = this.storeService.findPageByVo(null, vo);

		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet("商户列表");
		// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
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
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 给Excel的单元格设置样式和赋值
		cell.setCellStyle(style);
		String title = "商户列表";

		cell.setCellValue(this.configService.getSysConfig().getTitle() + title);
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
		cell.setCellValue("商户名称");
		cell = row.createCell(1);
		cell.setCellStyle(style2);
		cell.setCellValue("商户用户名 | 店主姓名");
		cell = row.createCell(2);
		cell.setCellStyle(style2);
		cell.setCellValue("所在地");
		cell = row.createCell(3);
		cell.setCellStyle(style2);
		cell.setCellValue("状态");

		if (list != null && list.size() > 0) {
			for (int j = 2; j <= list.size() + 1; j++) {
				row = sheet.createRow(j);
				// 设置单元格的样式格式
				int i = 0;
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(list.get(j - 2).getStoreName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String sellerName1 = "";
				String sellerName2 = "";
				if (list.get(j - 2).getLoginName() != null && !list.get(j - 2).getLoginName().equals("")) {
					sellerName1 = list.get(j - 2).getLoginName();
				}
				if (list.get(j - 2).getNickname() != null && !list.get(j - 2).getNickname().equals("")) {
					sellerName2 = list.get(j - 2).getNickname();
				}
				cell.setCellValue(sellerName1 + " | " + sellerName2);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String areaName = "";
				if (list.get(j - 2).getAreaName() != null && !list.get(j - 2).getAreaName().equals("")) {
					if (list.get(j - 2).getParentAreaName() != null
							&& !list.get(j - 2).getParentAreaName().equals("")) {
						areaName = "[" + list.get(j - 2).getParentAreaName() + "]";
					}
					areaName = areaName + list.get(j - 2).getAreaName();
				}
				cell.setCellValue(areaName);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(StoreConstants.getMerchantStatusValue(list.get(j - 2).getStoreStatus()));
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

	@RequestMapping("/admin/get_city_by_province.htm")
	public void get_city_by_province(HttpServletRequest request, HttpServletResponse response, String parentId) {
		List<Area> citys = new ArrayList<Area>();
		citys = this.areaService.findByParentId(CommUtil.null2Long(parentId));
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			String city = Json.toJson(citys, JsonFormat.compact());
			writer.print(city);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 商户违规关闭
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商户违规关闭", value = "/admin/merchant_violation_close.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_violation_close.htm")
	public String merchant_violation_close(HttpServletRequest request, HttpServletResponse response,
			String currentPage, StoreVO vo) {
		this.storeService.merchantViolationClose(vo);
		// 更新索引
		searchService.updateIndex(vo.getId());

		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}

		return "redirect:merchant_list.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "商户推荐", value = "/admin/merchant_recommend.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_recommend.htm")
	public ModelAndView merchant_recommend(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_merchant_add.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			List<AdvertPosition> apsList = advertPositionService.findList();
			StoreBO ss = this.storeService.getObjById(CommUtil.null2Long(id));
			mv.addObject("adTypeMerchant", AdvertContant.ADVERT_TPYE_GROUP_MERCHANT);
			mv.addObject("sid", id);
			mv.addObject("ss", ss);
			mv.addObject("aps", apsList);
			mv.addObject("merchantFlag", true);
		}

		return mv;
	}

	/**
	 * 商户推荐APP首页/取消推荐APP首页
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "推荐APP首页", value = "/admin/merchant_app_recommend.htm.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_app_recommend.htm")
	public ModelAndView merchant_app_recommend(HttpServletRequest request, HttpServletResponse response,
			String currentPage, StoreVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (vo.getId() != null) {
			Boolean storeRecommend = vo.getStoreRecommend();
			if (storeRecommend) {
				vo.setStoreRecommend(true);
				vo.setStoreRecommendTime(new Date());
				mv.addObject("op_title", "推荐成功");
			} else {
				vo.setStoreRecommend(false);
				vo.setStoreRecommendTime(null);
				mv.addObject("op_title", "取消推荐成功");
			}
			// 更新APP推荐状态
			this.storeService.update(vo);
			// 更新索引
			searchService.updateIndex(vo.getId());
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}

		mv.addObject("currentPage", currentPage);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/merchant_list.htm?currentPage="
				+ currentPage);
		return mv;
	}

	@SecurityMapping(title = "商户审核", value = "/admin/merchant_audit.htm*", rtype = "admin", rname = "商户管理（审核）", rcode = "admin_merchant_check", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_audit.htm")
	public ModelAndView merchant_audit(HttpServletRequest request, HttpServletResponse response, StoreVO vo,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_audit.html", configService.getSysConfig(),
				0, request, response);
		if (vo.getId() != null) {
			StoreBO store = this.storeService.getObjById(vo.getId());
			mv.addObject("vo", vo);
			mv.addObject("store", store);
			mv.addObject("currentPage", currentPage);
			mv.addObject("audit", true);
		}

		return mv;
	}

	@SecurityMapping(title = "商户审核保存", value = "/admin/merchant_audit_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_audit_save.htm")
	public ModelAndView merchant_audit_save(HttpServletRequest request, HttpServletResponse response,
			StoreVO vo, StoreApplyInfoVO svo, SellerVO sellerVO, String currentPage) {
		String returnStr = StringUtils.EMPTY;
		try {
			returnStr = this.storeService.saveMerchantAudit(vo, svo);
		} catch (Exception e) {
			log.error("审批失败", e);
			returnStr = "审核失败";
		}
		// 更新索引
		this.searchService.updateIndex(vo.getId());
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/merchant_list.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", returnStr);
		return mv;
	}

	@SecurityMapping(title = "修改机具编码页面", value = "/admin/merchant_edit_num.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_edit_num.htm")
	public ModelAndView merchant_edit_num(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_edit_num.html",
				configService.getSysConfig(), 0, request, response);
		StoreBO bo = null;
		if (StringUtils.isNotEmpty(id)) {
			bo = this.storeService.getObjById(CommUtil.null2Long(id));
		}
		if (StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("obj", bo);
		mv.addObject("edit", "edit");
		mv.addObject("currentPage", currentPage);

		return mv;
	}

	@SecurityMapping(title = "修改机具编码保存", value = "/admin/merchant_edit_num_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_edit_num_save.htm")
	public ModelAndView merchant_edit_num_save(HttpServletRequest request, HttpServletResponse response,
			StoreVO vo, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (null != vo.getId()) {
			this.storeService.update(vo);
			// 更新索引
			this.searchService.updateIndex(vo.getId());
		}
		if (StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}
		mv.addObject("currentPage", currentPage);
		mv.addObject("list_url", CommUtil.getURL(request) + "/admin/merchant_list.htm?currentPage="
				+ currentPage);
		mv.addObject("op_title", "修改成功");
		return mv;
	}

	/**
	 * 商户恢复营业
	 * 
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商户恢复营业", value = "/admin/merchant_recovery.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_recovery.htm")
	public String merchant_recovery(HttpServletRequest request, HttpServletResponse response,
			String currentPage, StoreVO vo) {
		if (vo.getId() != null) {
			vo.setStoreStatus(15);
			this.storeService.update(vo);
			// 更新索引
			searchService.updateIndex(vo.getId());
		}
		if (!StringUtils.isNotEmpty(currentPage)) {
			currentPage = "1";
		}

		return "redirect:merchant_list.htm?currentPage=" + currentPage;
	}

	/**
	 * Merchant商户信息查看
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商户信息查看", value = "/admin/merchant_company.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_company.htm")
	public ModelAndView merchant_company(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {

		ModelAndView mv = new JModelAndView("admin/blue/merchant_company.html", configService.getSysConfig(),
				0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
			StoreApplyInfoBO storeInfo = this.storeService.getStoreApplyInfoBO(CommUtil.null2Long(id));
			GroupClass gc = this.groupClassService.getObjById(store.getGroupMainId());
			Set<GroupClass> groupClassDetailSet = this.storeTools.queryStoreDetailInfo(store
					.getGroupDetailInfo());
			Long bankAreaId = store.getBankAreaId();
			Area areaCity = this.areaService.getObjById(bankAreaId);
			String city = StringUtils.EMPTY;
			String province = StringUtils.EMPTY;
			if (null != areaCity) {
				city = areaCity.getAreaName();
				Area areaProvince = this.areaService.getObjById(areaCity.getParentId());
				if (areaProvince != null) {
					province = areaProvince.getAreaName();
				}
			}
			String[] otherPhotos = null;
			if (storeInfo != null) {
				String otherphoto = storeInfo.getOtherPhotoPath();
				if (StringUtils.isNotEmpty(otherphoto)) {
					otherPhotos = otherphoto.split(";");
				}
			}
			mv.addObject("groupClassDetail", groupClassDetailSet);
			mv.addObject("groupClass_main", gc);
			mv.addObject("store", store);
			mv.addObject("storeInfo", storeInfo);
			mv.addObject("otherPhotos", otherPhotos);
			Integer ownType = 1;
			mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId(),ownType));
			mv.addObject("StoreConstants", new StoreConstants());
			mv.addObject("city", city);
			mv.addObject("currentPage", currentPage);
			mv.addObject("province", province);
		}

		return mv;
	}

	/**
	 * Merchant商户信息编辑
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商户信息编辑", value = "/admin/merchant_company_edit.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_company_edit.htm")
	public ModelAndView merchant_company_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {

		ModelAndView mv = new JModelAndView("admin/blue/merchant_company_edit.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
			StoreApplyInfoBO storeInfo = this.storeService.getStoreApplyInfoBO(CommUtil.null2Long(id));
			GroupClass gc = this.groupClassService.getObjById(store.getGroupMainId());
			Set<GroupClass> groupClassDetailSet = this.storeTools.queryStoreDetailInfo(store
					.getGroupDetailInfo());
			Long bankAreaId = store.getBankAreaId();
			Long areaId = store.getAreaId();
			setViewArea(mv, areaId); // 详细地址
			setViewBankArea(mv, bankAreaId);// 银行地址
			String[] otherPhotos = null;
			if (storeInfo != null) {
				String otherphoto = storeInfo.getOtherPhotoPath();
				if (StringUtils.isNotEmpty(otherphoto)) {
					otherPhotos = otherphoto.split(";");
				}
			}
			List<Area> areas = this.areaService.queryParentArea();

			mv.addObject("areas", areas);
			mv.addObject("groupClassDetail", groupClassDetailSet);
			mv.addObject("groupClass_main", gc);
			mv.addObject("store", store);
			mv.addObject("storeInfo", storeInfo);
			mv.addObject("otherPhotos", otherPhotos);
			// mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId()));
			Integer ownType = 1;
			mv.addObject("operatorName", this.userOwnService.getOperatorName(store.getCreateUserId(), ownType));
			mv.addObject("groupClassList", groupClassService.findCacheLevelAll());
			mv.addObject("subGroupClassList", groupClassService.findCahceByParent(store.getGroupMainId()));
			mv.addObject("StoreConstants", new StoreConstants());
			mv.addObject("currentPage", currentPage);
		}

		return mv;
	}

	private void setViewArea(ModelAndView mv, Long areaCode) {
		Area area = (Area) dicContent.getDic(Area.class, String.valueOf(areaCode));
		if (area != null) {
			mv.addObject("areaTowId", area.getParentCode());
			mv.addObject("areas3", dicContent.getDicsByParentCode(Area.class, area.getParentCode()));

			Area parentArea = (Area) dicContent.getDic(Area.class, area.getParentCode());
			if (parentArea != null) {
				mv.addObject("areaOneId", parentArea.getParentCode());
				mv.addObject("areas2", dicContent.getDicsByParentCode(Area.class, parentArea.getParentCode()));
			}

		}

	}

	private void setViewBankArea(ModelAndView mv, Long areaCode) {
		Area area = (Area) dicContent.getDic(Area.class, String.valueOf(areaCode));
		if (area != null) {
			mv.addObject("bankAreaOneId", area.getParentCode());
			mv.addObject("bankAreas2", dicContent.getDicsByParentCode(Area.class, area.getParentCode()));
		}

	}

	/**
	 * 商户信息保存
	 * 
	 * @param request
	 * @param response
	 * @param applyVO
	 * @return
	 */
	@SecurityMapping(title = "商户信息保存", value = "/admin/merchant_company_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_company_save.htm")
	private ModelAndView merchant_company_save(HttpServletRequest request, HttpServletResponse response,
			String list_url, String add_url, StoreApplyInfo apply, Store store) throws Exception {

		storeService.applyStoreEdit(apply, store);

		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存商户成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
		/*CustomerUserDetails user = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		StoreBO store=storeService.queryStoreStatus(user.getId());
		try {
			if(store != null){
				if(store.getStoreStatus() >= StoreConstants.STORE_STATUS_SHOP_AUDIT_SUCCESS){
					mv = new JModelAndView("error.html",configService.getSysConfig(),1, request, response);
					mv.addObject("op_title", "您已经是商户!");
					mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
					return mv;
				}else if(store.getStoreStatus() == StoreConstants.STORE_STATUS_SHOP_OPREATE_AUDIT_FAIL 
						|| store.getStoreStatus() == StoreConstants.STORE_STATUS_SYS_AUDIT_FAIL
						|| store.getStoreStatus() == StoreConstants.STORE_STATUS_OTHER_PAY_AUDIT_FAIL ){
					//如果为审批失败，修改申请
					storeService.applyStore(applyVO, user.getId(),store.getId());
				} else {
					return mv;//"seller_store_query(request, response)";
				}
			}else{
				//新增申请
				storeService.applyStore(applyVO, user.getId());
			}
		} catch (ServiceException e) {
			mv = new JModelAndView("error.html",configService.getSysConfig(),1, request, response);
			mv.addObject("op_title", e.getErrorCode());
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
			return mv;
		}
		
		mv = new JModelAndView("success.html",configService.getSysConfig(),1, request, response);
		mv.addObject("op_title", "商户申请成功，请等待审批！");
		mv.addObject("url", CommUtil.getURL(request) + "/seller_apply/group/query.htm");
		return mv;*/
	}

	/**
	 * 商家照片保存上传
	 * 
	 * @param request
	 * @param response
	 */
	@SecurityMapping(title = "商品图片上传", value = "/admin/image_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/image_save.htm")
	public void seller_apply_image_save(HttpServletRequest request, HttpServletResponse response,
			String mark, Long storeId) {
		// Long uid=SecurityUserHolder.getCurrentUserId();
		Seller seller = sellerService.findByStore(storeId);
		Long uid = seller.getUid();
		Map<String, String> map = Maps.newHashMap();
//		String path = accessoryService.uploadForPath(request, mark + "_file", "seller/" + uid + "/" + mark + "_file");
//		map.put("path", path);
		if ("other".equals(mark)) {
			String path = accessoryService.uploadForPath2(request, mark + "_file",  "seller/" + uid + "/" + mark + "_file");
			map.put("path", path);
		} else {
			// 以商户id为目录存储（商户id=用户id）
			String path = accessoryService.uploadForPath(request, mark + "_file", "seller/" + uid + "/" + mark + "_file");
			map.put("path", path);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(JSON.toJSONString(map));
			writer.flush();
			writer.close();
		} catch (IOException e) {
		}
	}

	/**
	 * Merchant商户审核-信息查看
	 * 
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 */
	@SecurityMapping(title = "商户信息查看", value = "/admin/merchant_audit_view.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_audit_view.htm")
	public ModelAndView merchant_audit_view(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String audit_view) {

		ModelAndView mv = new JModelAndView("admin/blue/merchant_audit_view.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
			StoreApplyInfoBO storeInfo = this.storeService.getStoreApplyInfoBO(CommUtil.null2Long(id));
			GroupClass gc = this.groupClassService.getObjById(store.getGroupMainId());
			Set<GroupClass> groupClassDetailSet = this.storeTools.queryStoreDetailInfo(store
					.getGroupDetailInfo());
			Long bankAreaId = store.getBankAreaId();
			Area areaCity = this.areaService.getObjById(bankAreaId);
			String city = StringUtils.EMPTY;
			String province = StringUtils.EMPTY;
			if (null != areaCity) {
				city = areaCity.getAreaName();
				Area areaProvince = this.areaService.getObjById(areaCity.getParentId());
				if (areaProvince != null) {
					province = areaProvince.getAreaName();
				}
			}
			String[] otherPhotos = null;
			if (storeInfo != null) {
				String otherphoto = storeInfo.getOtherPhotoPath();
				if (StringUtils.isNotEmpty(otherphoto)) {
					otherPhotos = otherphoto.split(";");
				}
			}
			mv.addObject("groupClassDetail", groupClassDetailSet);
			mv.addObject("groupClass_main", gc);
			mv.addObject("store", store);
			mv.addObject("storeInfo", storeInfo);
			mv.addObject("otherPhotos", otherPhotos);
			Integer ownType = 1;
			mv.addObject("operatorName", this.userOwnService.getUserName(store.getCreateUserId(),ownType));
			mv.addObject("StoreConstants", new StoreConstants());
			mv.addObject("city", city);
			mv.addObject("currentPage", currentPage);
			mv.addObject("province", province);
			if ("1".equals(audit_view)) {
				mv.addObject("audit_view", true);
			}
		}

		return mv;
	}

	/**
	 * Merchant编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商户编辑", value = "/admin/merchant_edit.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_edit.htm")
	public ModelAndView store_edit(HttpServletRequest request, HttpServletResponse response, String id,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_edit.html", configService.getSysConfig(), 0,
				request, response);
		if (id != null && !id.equals("")) {
			StoreBO store = this.storeService.getObjById(Long.parseLong(id));
			List<Area> areas = this.areaService.queryParentArea();
			mv.addObject("areas", areas);
			mv.addObject("obj", store);
			mv.addObject("currentPage", currentPage);
			mv.addObject("edit", true);
			mv.addObject("goodsClass_main", this.goodsclassService.getObjById(store.getGcMainId()));
			Set<GoodsClass> goodsClassDetailSet = this.storeTools.query_store_DetailGc(store
					.getGcDetailInfo());
			mv.addObject("goodsClass_detail", goodsClassDetailSet);
			mv.addObject("area_info", store.getAreaInfo());
		}
		return mv;
	}

	/**
	 * Merchant保存管理
	 * 
	 * @param id
	 * @param gc_main_id
	 *            :主营类目id
	 * @param gc_detail_ids
	 *            ：详细类目id
	 * @param id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "商户保存", value = "/admin/merchant_save.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_save.htm")
	public ModelAndView store_save(HttpServletRequest request, HttpServletResponse response, String list_url,
			String add_url, StoreVO store) throws Exception {

		SysConfigBO config = configService.getSysConfig();
		if (store != null) {
			if (StringUtils.isNotBlank(store.getValidityStr())) {
				store.setValidity(CommUtil.formatDate(store.getValidityStr()));
			}
			if (store.getId() != null && store.getId() > 0) {// 更新
				this.storeService.update(store);
			}
			// update by james 这里只有修改
			// else { // 新增
			// store.setAddTime(new Date());
			// //设置默认logo
			// if(config.getStoreImage() != null){
			// store.setStoreLogoPath(config.getStoreImage().getPath());
			// }
			// this.storeService.save(store);
			// }
		}
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		mv.addObject("list_url", list_url);
		mv.addObject("op_title", "保存商户成功");
		if (add_url != null) {
			mv.addObject("add_url", add_url);
		}
		return mv;
	}

	@SecurityMapping(title = "商户统计", value = "/admin/merchant_stat.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_stat.htm")
	public ModelAndView merchant_stat(HttpServletRequest request, HttpServletResponse response,
			String startDate, String endDate, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_stat.html", configService.getSysConfig(), 0,
				request, response);
		if (StringUtils.isNotEmpty(id)) {
			StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
			// CustomerUserDetails userDetails = (CustomerUserDetails)
			// SecurityUserHolder.getCurrentUserDetails();
			// 订单成交金额
			BigDecimal of_totalPrice = groupOrderService.queryOrderPriceByDate(CommUtil.null2Long(id),
					startDate, endDate);
			mv.addObject("of_totalPrice", of_totalPrice == null ? 0 : of_totalPrice);
			// 订单成交总数
			int of_totalCount = groupOrderService.queryOrderCountByDate(CommUtil.null2Long(id), startDate,
					endDate);
			mv.addObject("of_totalCount", of_totalCount);

			// 总的反润金额
			RebateRecordBO bo = rebateService.queryrebatesum(store.getCreateUserId(), startDate, endDate);
			mv.addObject("of_totalRebate", bo == null ? 0 : bo.getTotalRebateAmout());

			// 推荐会员数
			int ownUser = userRelationService.queryOwnCustomerCount(store.getCreateUserId(), startDate,
					endDate);
			mv.addObject("ownUser", ownUser);

			// 推荐商户数
			int reSeller = userRelationService.queryRefereeSellerCount(store.getCreateUserId(), startDate,
					endDate);
			mv.addObject("reSeller", reSeller);

			mv.addObject("id", id);
			mv.addObject("startDate", startDate);
			mv.addObject("endDate", endDate);
		}
		return mv;
	}

	@SecurityMapping(title = "商户收益记录", value = "/admin/merchant_share_details.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_share_details.htm")
	public ModelAndView merchant_share_details(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<RebateRecordBO> page, String id, StoreVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/merchant_share_details.html",
				configService.getSysConfig(), 0, request, response);
		if (StringUtils.isNotEmpty(id)) {
			StoreBO store = this.storeService.getObjById(CommUtil.null2Long(id));
			rebateService.queryShareDetails(store.getCreateUserId(), null, page);
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("id", id);
			mv.addObject("vo", vo);
		}
		return mv;
	}

	@SecurityMapping(title = "商户反润明细", value = "/admin/merchant_share_list.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_share_list.htm")
	public ModelAndView merchant_share_list(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<RebateRecordBO> page, RebateRecordVO vo) {
		SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
		if(vo.getBeginTimeStr()==null){
			vo.setBeginTimeStr(shortSdf.format(new Date()));
		}
		if(vo.getEndTimeStr()==null){
			vo.setBeginTimeStr(shortSdf.format(new Date()));
		}
		ModelAndView mv = new JModelAndView("admin/blue/merchant_share_list.html",
				configService.getSysConfig(), 0, request, response);
		rebateService.queryShareListByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("listCode",RebateConstants.listRebateCode());
		mv.addObject("vo", vo);
		mv.addObject("rebateConstants", new RebateConstants());
		return mv;
	}

	@SecurityMapping(title = "商户反润明细导出", value = "/admin/merchant_share_export_excel.htm*", rtype = "admin", rname = "商户管理", rcode = "admin_merchant", rgroup = "商户管理")
	@RequestMapping("/admin/merchant_share_export_excel.htm")
	public void merchant_share_export_excel(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<RebateRecordBO> page, RebateRecordVO vo) {
		page.setPageSize(1000000000);
		rebateService.queryShareListByVO(vo, page);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<RebateRecordBO> datas = page.getContent();

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

			String title = "商户反润明细列表";
			Date time1 = CommUtil.formatDate(vo.getBeginTimeStr());
			Date time2 = CommUtil.formatDate(vo.getEndTimeStr());
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

			// 创建标题行
			row = sheet.createRow(1);
			//
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("商户名称");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("商户手机号");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("服务名称");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("会员用户名 |会员姓名");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("消费码");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("结算时间");
			//
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("会员消费反润");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getStoreName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getLoginName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGgName());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getMobile() + " | " + datas.get(j - 2).getNickname());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getRebateCode());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2).getCreateTime()));

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getRebateAmount().toString());
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

	// private void send_site_msg(HttpServletRequest request, String mark,
	// Store store) throws Exception {
	// Template template = this.templateService.getObjByProperty(null, "mark",
	// mark);
	// if (template != null && template.isOpen()) {
	// if (store.getUser() != null) {
	// ExpressionParser exp = new SpelExpressionParser();
	// EvaluationContext context = new StandardEvaluationContext();
	// context.setVariable("reason", store.getViolation_reseaon());
	// context.setVariable("user", store.getUser());
	// context.setVariable("store", store);
	// context.setVariable("config", this.configService.getSysConfig());
	// context.setVariable("send_time",
	// CommUtil.formatLongDate(new Date()));
	// Expression ex = exp.parseExpression(template.getContent(),
	// new SpelTemplate());
	// String content = ex.getValue(context, String.class);
	// Map params = new HashMap();
	// params.put("userName", "admin");
	// params.put("userRole", "ADMIN");
	// List<User> fromUsers = this.userService
	// .query("select obj from User obj where obj.userName=:userName and obj.userRole=:userRole",
	// params, -0, 1);
	// if (fromUsers.size() > 0) {
	// Message msg = new Message();
	// msg.setAddTime(new Date());
	// msg.setContent(content);
	// msg.setFromUser(fromUsers.get(0));
	// msg.setTitle(template.getTitle());
	// msg.setToUser(store.getUser());
	// msg.setType(0);
	// this.messageService.save(msg);
	// }
	// }
	// }
	// }
	//
	// @SecurityMapping(title = "店铺删除", value = "/admin/store_del.htm*", rtype =
	// "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup = "店铺")
	// @RequestMapping("/admin/store_del.htm")
	// public String store_del(HttpServletRequest request, String mulitId)
	// throws Exception {
	// String[] ids = mulitId.split(",");
	// for (String id : ids) {
	// if (!id.equals("")) {
	// Store store = this.storeService.getObjById(CommUtil
	// .null2Long(id));
	// Map params = new HashMap();
	// if (store.getUser() != null) {
	// store.getUser().setStore(null);
	// User user = store.getUser();
	// if (user != null) {
	// Set<Role> roles = user.getRoles();
	// Set<Role> new_roles = new HashSet<Role>();
	// for (Role role : roles) {
	// if (!role.getType().equals("SELLER")) {
	// new_roles.add(role);
	// }
	// }
	// user.getRoles().clear();// 清除所有权限，重新添加不含商家的权限信息
	// user.getRoles().addAll(new_roles);//
	// user.setStore_apply_step(0);
	// this.userService.update(user);
	// for (User u : user.getChilds()) {// 清除子账户所有权限信息
	// roles = u.getRoles();
	// Set<Role> new_roles2 = new HashSet<Role>();
	// for (Role role : roles) {
	// if (!role.getType().equals("SELLER")) {
	// new_roles2.add(role);
	// }
	// }
	// u.getRoles().clear();// 清除所有权限，重新添加不含商家的权限信息
	// u.getRoles().addAll(new_roles2);//
	// u.setStore_apply_step(0);
	// this.userService.update(u);
	// }
	// }
	// params.clear();// 删除商家优惠券
	// params.put("store_id", store.getId());
	// List<Coupon> coupons = this.couponService
	// .query("select obj from Coupon obj where obj.store.id=:store_id",
	// params, -1, -1);
	// for (Coupon coupon : coupons) {
	// for (CouponInfo couponInfo : coupon.getCouponinfos()) {
	// this.couponInfoService.delete(couponInfo.getId());
	// }
	// this.couponService.delete(coupon.getId());
	// }
	//
	// for (GoldRecord gr : user.getGold_record()) {// 商家充值记录
	// this.grService.delete(gr.getId());
	// }
	// params.clear();
	// params.put("uid", user.getId());
	// List<GoldLog> gls = this.glService
	// .query("select obj from GoldLog obj where obj.gl_user.id=:uid",
	// params, -1, -1);
	// for (GoldLog gl : gls) {
	// this.glService.delete(gl.getId());
	// }
	// for (GoldRecord gr : user.getGold_record()) {
	// this.grService.delete(gr.getId());
	// }
	// for (GroupLifeGoods glg : user.getGrouplifegoods()) {// 商家发布的生活购
	// for (GroupInfo gi : glg.getGroupInfos()) {
	// this.groupinfoService.delete(gi.getId());
	// }
	// glg.getGroupInfos().removeAll(glg.getGroupInfos());
	// this.grouplifegoodsService.delete(CommUtil
	// .null2Long(glg.getId()));
	// }
	// for (PayoffLog log : user.getPaylogs()) {// 商家结算日志
	// this.paylogService.delete(log.getId());
	// }
	// for (Album album : user.getAlbums()) {// 商家相册删除
	// album.setAlbum_cover(null);
	// this.albumService.update(album);
	// params.clear();
	// params.put("album_id", album.getId());
	// List<Accessory> accs = this.accessoryService
	// .query("select obj from Accessory obj where obj.album_id=:album_id",
	// params, -1, -1);
	// for (Accessory acc : accs) {
	// CommUtil.del_acc(request, acc);
	// this.accessoryService.delete(acc.getId());
	// }
	// this.albumService.delete(album.getId());
	// }
	// }
	// for (Goods goods : store.getGoods_list()) {// 店铺内的商品
	// goods.setGoods_main_photo(null);
	// goods.setGoods_brand(null);
	// this.goodsService.update(goods);
	// goods.getGoods_photos().clear();
	// goods.getGoods_specs().clear();
	// goods.getGoods_ugcs().clear();
	// }
	// for (Goods goods : store.getGoods_list()) {// 删除店铺内的商品
	// for (GoodsCart gc : goods.getCarts()) {
	// this.goodsCartService.delete(gc.getId());
	// }
	// List<Evaluate> evaluates = goods.getEvaluates();
	// for (Evaluate e : evaluates) {
	// this.evaluateService.delete(e.getId());
	// }
	// for (ComplaintGoods cg : goods.getCgs()) {
	// this.complaintGoodsService.delete(cg.getId());
	// }
	// goods.getCarts().removeAll(goods.getCarts());// 移除对象中的购物车
	// goods.getEvaluates().removeAll(goods.getEvaluates());
	// goods.getCgs().removeAll(goods.getCgs());
	// params.clear();// 直通车商品记录
	// params.put("gid", goods.getId());
	// List<ZTCGoldLog> ztcgls = this.ztcglService
	// .query("select obj from ZTCGoldLog obj where obj.zgl_goods_id=:gid",
	// params, -1, -1);
	// for (ZTCGoldLog ztc : ztcgls) {
	// this.ztcglService.delete(ztc.getId());
	// }
	// this.goodsService.delete(goods.getId());
	// }
	// store.getGoods_list().removeAll(store.getGoods_list());
	//
	// for (GoodsSpecification spec : store.getSpecs()) {// 店铺规格
	// for (GoodsSpecProperty pro : spec.getProperties()) {
	// this.specpropertyService.delete(pro.getId());
	// }
	// spec.getProperties().removeAll(spec.getProperties());
	// }
	// String path = request.getSession().getServletContext()
	// .getRealPath("/")
	// + this.configService.getSysConfig().getUploadFilePath()
	// + File.separator
	// + "store"
	// + File.separator
	// + store.getId();
	// CommUtil.deleteFolder(path);
	// //删除店铺之前删除店铺的水印
	// params.clear();
	// params.put("sid", CommUtil.null2Long(id));
	// List<WaterMark> wm = this.waterMarkService
	// .query("select obj from WaterMark obj where obj.store.id=:sid",
	// params, 0, 1);
	// if(wm.size()>0){
	// this.waterMarkService.delete(wm.get(0).getId());
	// }
	// this.storeService.delete(CommUtil.null2Long(id));
	// this.send_site_msg(request, "msg_toseller_store_delete_notify",
	// store);
	// }
	// }
	// return "redirect:store_list.htm";
	// }
	//
	// @SecurityMapping(title = "店铺AJAX更新", value = "/admin/store_ajax.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/store_ajax.htm")
	// public void store_ajax(HttpServletRequest request,
	// HttpServletResponse response, String id, String fieldName,
	// String value) throws ClassNotFoundException {
	// Store obj = this.storeService.getObjById(Long.parseLong(id));
	// Field[] fields = Store.class.getDeclaredFields();
	// BeanWrapper wrapper = new BeanWrapper(obj);
	// Object val = null;
	// for (Field field : fields) {
	// // System.out.println(field.getName());
	// if (field.getName().equals(fieldName)) {
	// Class clz = Class.forName("java.lang.String");
	// if (field.getType().getName().equals("int")) {
	// clz = Class.forName("java.lang.Integer");
	// }
	// if (field.getType().getName().equals("boolean")) {
	// clz = Class.forName("java.lang.Boolean");
	// }
	// if (!value.equals("")) {
	// val = BeanUtils.convertType(value, clz);
	// } else {
	// val = !CommUtil.null2Boolean(wrapper
	// .getPropertyValue(fieldName));
	// }
	// wrapper.setPropertyValue(fieldName, val);
	// }
	// }
	// if (fieldName.equals("store_recommend")) {
	// if (obj.isStore_recommend()) {
	// obj.setStore_recommend_time(new Date());
	// } else {
	// obj.setStore_recommend_time(null);
	// }
	// }
	// this.storeService.update(obj);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(val.toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
	//
	// @SecurityMapping(title = "入驻管理", value = "/admin/store_base.htm*", rtype
	// = "admin", rname = "入驻管理", rcode = "admin_store_base", rgroup = "店铺")
	// @RequestMapping("/admin/store_base.htm")
	// public ModelAndView store_base(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView("admin/blue/store_base_set.html",
	// configService.getSysConfig(),
	// /* this.userConfigService.getUserConfig(), */0, request,
	// response);
	// return mv;
	// }

	// @SecurityMapping(title = "店铺设置保存", value = "/admin/store_set_save.htm*",
	// rtype = "admin", rname = "入驻管理", rcode = "admin_store_base", rgroup =
	// "店铺")
	// @RequestMapping("/admin/store_set_save.htm")
	// public ModelAndView store_set_save(HttpServletRequest request,
	// HttpServletResponse response, String id, String list_url,
	// String store_allow) {
	// ModelAndView mv = new JModelAndView("admin/blue/success.html",
	// configService.getSysConfig(),
	// /*this.userConfigService.getUserConfig(),*/ 0, request, response);
	// SysConfig sc = this.configService.getSysConfig();
	// sc.setStoreAllow(CommUtil.null2Boolean(store_allow));
	// if (id.equals("")) {
	// this.configService.save(sc);
	// } else
	// this.configService.update(sc);
	// mv.addObject("list_url", list_url);
	// mv.addObject("op_title", "保存店铺设置成功");
	// return mv;
	// }

	// @SecurityMapping(title = "开店申请Ajax更新", value =
	// "/admin/store_base_ajax.htm*", rtype = "admin", rname = "入驻管理", rcode =
	// "admin_store_base", rgroup = "店铺")
	// @RequestMapping("/admin/store_base_ajax.htm")
	// public void integral_goods_ajax(HttpServletRequest request,
	// HttpServletResponse response, String fieldName)
	// throws ClassNotFoundException {
	// SysConfig sc = this.configService.getSysConfig();
	// Field[] fields = SysConfig.class.getDeclaredFields();
	// BeanWrapper wrapper = new BeanWrapper(sc);
	// Object val = null;
	// for (Field field : fields) {
	// if (field.getName().equals(fieldName)) {
	// Class clz = Class.forName("java.lang.Boolean");
	// val = !CommUtil.null2Boolean(wrapper
	// .getPropertyValue(fieldName));
	// wrapper.setPropertyValue(fieldName, val);
	// break;
	// }
	// }
	// this.configService.update(sc);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(val.toString());
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// // 店铺模板管理
	// // @SecurityMapping(title = "店铺模板", value = "/admin/store_template.htm*",
	// // rtype = "admin", rname = "店铺模板", rcode = "admin_store_template",
	// rgroup =
	// // "店铺")
	// // @RequestMapping("/admin/store_template.htm")
	// public ModelAndView store_template(HttpServletRequest request,
	// HttpServletResponse response) {
	// ModelAndView mv = new JModelAndView("admin/blue/store_template.html",
	// configService.getSysConfig(),
	// this.userConfigService.getUserConfig(), 0, request, response);
	// mv.addObject("path", request.getSession().getServletContext()
	// .getRealPath("/"));
	// mv.addObject("separator", File.separator);
	// return mv;
	// }

	// @SecurityMapping(title = "等级限制时可选的类目", value = "/admin/sg_limit_gc.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/sg_limit_gc.htm")
	// public void storeGrade_limit_goodsClass(HttpServletRequest request,
	// HttpServletResponse response,
	// String storeGrade_id, String goodsClass_id) {
	// String jsonList = "";
	// StoreGrade storeGrade =
	// this.storeGradeService.getObjById(CommUtil.null2Long(storeGrade_id));
	// if (storeGrade != null && storeGrade.getMainLimit() != 0) {
	// GoodsClass goodsClass =
	// this.goodsclassService.getObjById(CommUtil.null2Long(goodsClass_id));
	// if (goodsClass != null) {
	// List<Map<String, String>> gcList = new ArrayList<Map<String, String>>();
	// List<GoodsClassBO> childsList = new ArrayList<GoodsClassBO>();
	// childsList = this.goodsclassService.findChildList(goodsClass.getId());
	// for (GoodsClassBO gc : childsList) {
	// Map<String, String> map = new HashMap<String, String>();
	// map.put("gc_id", gc.getId().toString());
	// map.put("gc_name", gc.getClassName());
	// gcList.add(map);
	// }
	// jsonList = Json.toJson(gcList, JsonFormat.compact());
	// }
	// }
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(jsonList);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
	// @SecurityMapping(title = "新增详细经营类目", value = "/admin/add_gc_detail.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/add_gc_detail.htm")
	// public ModelAndView addStore_GoodsClass_detail(HttpServletRequest
	// request, HttpServletResponse response, String did,
	// String gc_detail_info) {
	// ModelAndView mv = new
	// JModelAndView("admin/blue/store_detailgc_ajax.html",
	// configService.getSysConfig(),
	// 0, request, response);
	// GoodsClass gc =
	// this.goodsclassService.getObjById(CommUtil.null2Long(did));
	// List<Map> list = null;// 用于转换成店铺中的详细经营类目json
	// if (gc != null && gc.getParentId()!=null && gc.getParentId()>0) {
	// GoodsClass parent = this.goodsclassService.getObjById(gc.getParentId());
	// if (gc_detail_info != null && !gc_detail_info.equals("")) {
	// if (storeTools.query_MainGc_Map(parent.getId().toString(),
	// gc_detail_info) == null) {// 不在一个大分类下
	// list = Json.fromJson(ArrayList.class, gc_detail_info);
	// List<Integer> gc_list = new ArrayList();
	// Map map = new HashMap();
	// gc_list.add(CommUtil.null2Int(did));
	// map.put("gc_list", gc_list);
	// map.put("m_id", parent.getId());
	// list.add(map);
	// String listJson = Json.toJson(list, JsonFormat.compact());
	// mv.addObject("gc_detail_info", listJson);
	// mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
	// } else {// 在一个大分类下
	// List<Map> oldList = Json.fromJson(ArrayList.class, gc_detail_info);
	// list = new ArrayList<Map>();
	// for (Map map : oldList) {
	// if (CommUtil.null2Long(map.get("m_id")).equals(parent.getId())) {
	// List<Integer> gc_list = (List<Integer>) map.get("gc_list");
	// gc_list.add(CommUtil.null2Int(did));
	// Map map2 = new HashMap();
	// HashSet set = new HashSet(gc_list);
	// gc_list = new ArrayList<Integer>(set);
	// map2.put("gc_list", gc_list);
	// map2.put("m_id", parent.getId());
	// list.add(map2);
	// } else {
	// list.add(map);
	// }
	// }
	// String listJson = Json.toJson(list, JsonFormat.compact());
	// mv.addObject("gc_detail_info", listJson);
	// mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
	// }
	// ;
	// } else {
	// list = new ArrayList<Map>();
	// Map map = new HashMap();
	// List<Integer> gc_list = new ArrayList();
	// gc_list.add(CommUtil.null2Int(did));
	// map.put("gc_list", gc_list);
	// map.put("m_id", parent.getId());
	// list.add(map);
	// String listJson = Json.toJson(list, JsonFormat.compact());
	// mv.addObject("gc_detail_info", listJson);
	// mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
	// }
	// mv.addObject("parentName", parent.getClassName());
	// }
	// return mv;
	// }
	//
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// @SecurityMapping(title = "删除详细经营类目", value = "/admin/del_gc_detail.htm*",
	// rtype = "admin", rname = "店铺管理", rcode = "admin_store_set", rgroup =
	// "店铺")
	// @RequestMapping("/admin/del_gc_detail.htm")
	// public ModelAndView delStore_GoodsClass_detail(HttpServletRequest
	// request,
	// HttpServletResponse response, String did, String gc_detail_info) {
	// ModelAndView mv = new JModelAndView(
	// "admin/blue/store_detailgc_ajax.html",
	// configService.getSysConfig(), 0, request, response);
	// GoodsClass gc = this.goodsclassService.getObjById(CommUtil
	// .null2Long(did));
	// if (gc_detail_info != null && !gc_detail_info.equals("") && gc != null) {
	// Long parentId = gc.getParentId();
	// List<Map> oldList = Json.fromJson(ArrayList.class, gc_detail_info);
	// List<Map> list = new ArrayList<Map>();
	// for (Map oldMap : oldList) {
	// if (!CommUtil.null2Long(oldMap.get("m_id")).equals(parentId)) {
	// list.add(oldMap);
	// } else {
	// List<Integer> gc_list = (List<Integer>) oldMap.get("gc_list");
	// for (Integer integer : gc_list) {
	// if (integer.equals(CommUtil.null2Int(did))) {
	// gc_list.remove(integer);
	// break;
	// }
	// }
	// if (gc_list.size() > 0) {
	// Map map = new HashMap();
	// map.put("gc_list", gc_list);
	// map.put("m_id", parentId);
	// list.add(oldMap);
	// }
	// }
	// }
	// if (list.size() > 0) {
	// String listJson = Json.toJson(list, JsonFormat.compact());
	// mv.addObject("gc_detail_info", listJson);
	// mv.addObject("gcs", storeTools.query_store_DetailGc(listJson));
	// }
	// }
	//
	// return mv;
	// }
}
