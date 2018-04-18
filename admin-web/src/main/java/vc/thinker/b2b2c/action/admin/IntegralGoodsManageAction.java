package vc.thinker.b2b2c.action.admin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.maven.model.Model;
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
import org.nutz.json.JsonException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.express.service.ExpressCompanyService;
import com.sinco.carnation.integral.service.IntegralGoodsOrderService;
import com.sinco.carnation.integral.service.IntegralGoodsService;
import com.sinco.carnation.order.tools.OrderFormTools;
import com.sinco.carnation.shop.bo.ExpressCompanyBO;
import com.sinco.carnation.shop.bo.IntegralGoodsBO;
import com.sinco.carnation.shop.bo.IntegralGoodsOrderBO;
import com.sinco.carnation.shop.constants.ExpressCompanyConstants;
import com.sinco.carnation.shop.constants.IntegralGoodsOrderConstants;
import com.sinco.carnation.shop.model.ExpressCompany;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.shop.vo.IntegralGoodsOrderVO;
import com.sinco.carnation.shop.vo.IntegralGoodsVO;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.user.service.IntegralLogService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;

import net.weedfs.client.RequestResult;
import net.weedfs.client.WeedFSClient;
import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.constant.UploadConstants;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.FileUploadTools;

/**
 * 
 * <p>
 * Title: IntegralGoodsManageAction.java
 * </p>
 * 
 * <p>
 * Description: 积分商品管理控制器，积分商品由平台运营商发布
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
 * @date 2014-5-25
 * 
 * @version 1.0.1
 */
@SuppressWarnings({"unchecked", "unused", "rawtypes", "deprecation"})
@Controller
public class IntegralGoodsManageAction {
	@Autowired
	private SysConfigService configService;
//	@Autowired
//	private UserConfigService userConfigService;
	@Autowired
	private IntegralGoodsService integralgoodsService;
	@Autowired
	private IntegralGoodsOrderService integralGoodsOrderService;
//	@Autowired
//	private AccessoryService accessoryService;
	@Autowired
	private UserService userService;
	@Autowired
	private IntegralLogService integralLogService;
	@Autowired
	private ExpressCompanyService expressCompanyService;
//	@Autowired
//	private MessageService messageService;
	@Autowired
	private UserCustomerService userCustomerService;
	@Autowired
	private OrderFormTools orderFormTools;
	@Autowired
	private WeedFSClient fsClient;

	/**
	 * IntegralGoods列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "积分礼品列表", value = "/admin/integral_goods.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods.htm")
	public ModelAndView integral_goods(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<IntegralGoodsBO> page, IntegralGoodsVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_goods.html", configService.getSysConfig(),
				0, request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			page.setPageSize(10);
			this.integralgoodsService.findPageByVo(page, vo);
			// add by yuleijia on 2017.4.13
			// 将上架且库存为0的兑换商品排最前
			List<IntegralGoodsBO> content = page.getContent();
			List<IntegralGoodsBO> zeroInventoryList = new ArrayList<IntegralGoodsBO>();
			List<IntegralGoodsBO> otherList = new ArrayList<IntegralGoodsBO>();
			for (IntegralGoodsBO obj : content) {
				Integer goodCount = obj.getIgGoodsCount();
				if (goodCount != null && goodCount == 0 && obj.getIgShow()) {
					zeroInventoryList.add(obj);
				} else {
					otherList.add(obj);
				}
			}
			List<IntegralGoodsBO> responseList = new ArrayList<IntegralGoodsBO>();
			for (IntegralGoodsBO zeroInv : zeroInventoryList) {
				responseList.add(zeroInv);
			}
			for (IntegralGoodsBO otherInv : otherList) {
				responseList.add(otherInv);
			}
			page.setContent(responseList);

			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("vo", vo);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * integralgoods添加管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "积分礼品添加", value = "/admin/integral_goods_add.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods_add.htm")
	public ModelAndView integral_goods_add(HttpServletRequest request, HttpServletResponse response,
			String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_goods_add.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			mv.addObject("currentPage", currentPage);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, 1);
			mv.addObject("default_begin_time", CommUtil.formatShortDate(cal.getTime()));
			cal.add(Calendar.DATE, 1);
			mv.addObject("default_end_time", CommUtil.formatShortDate(cal.getTime()));
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * integralgoods编辑管理
	 * 
	 * @param id
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "积分礼品编辑", value = "/admin/integral_goods_edit.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods_edit.htm")
	public ModelAndView integral_goods_edit(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_goods_add.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			if (id != null && !id.equals("")) {
				IntegralGoods integralgoods = this.integralgoodsService.getObjById(Long.parseLong(id));
				mv.addObject("obj", integralgoods);
				mv.addObject("currentPage", currentPage);
				mv.addObject("edit", true);
				if (integralgoods.getIgTimeType()) {
					mv.addObject("default_begin_time",
							CommUtil.formatShortDate(integralgoods.getIgBeginTime()));
					mv.addObject("default_end_time", CommUtil.formatShortDate(integralgoods.getIgEndTime()));
				} else {
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 1);
					mv.addObject("default_begin_time", CommUtil.formatShortDate(cal.getTime()));
					cal.add(Calendar.DATE, 1);
					mv.addObject("default_end_time", CommUtil.formatShortDate(cal.getTime()));
				}
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	/**
	 * integralgoods保存管理
	 * 
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "积分礼品保存", value = "/admin/integral_goods_save.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods_save.htm")
	public ModelAndView integral_goods_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String list_url, String add_url, IntegralGoodsVO goods,
			@RequestParam("integralGoodsImg") MultipartFile file) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			if (goods != null) {
				// 图片上传
				if (file != null && file.getSize() != 0) {
					RequestResult result;
					try {
						String module="integral/goods/main";
						String fileUrl=FileUploadTools.fileUpload(file, module);	
						goods.setIgGoodsImg(fileUrl);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 设置ig_goods_sn内容
				goods.setIgGoodsSn("gift" + CommUtil.formatTime("yyyyMMddHHmmss", new Date())
						+ SecurityUserHolder.getCurrentUser().getId());

				if (goods.getIgTimeType()) {// 如果限制退换时间 ,则添加

					// 设置兑换时间
					Calendar cal = Calendar.getInstance();
					if (StringUtils.isNotBlank(goods.getBeginTime())
							&& StringUtils.isNotBlank(goods.getBeginHour())) {
						cal.setTime(CommUtil.formatDate(goods.getBeginTime()));
						cal.add(Calendar.HOUR, CommUtil.null2Int(goods.getBeginHour()));
						goods.setIgBeginTime(cal.getTime());
					}
					if (StringUtils.isNotBlank(goods.getEndTime())
							&& StringUtils.isNotBlank(goods.getEndHour())) {
						cal.setTime(CommUtil.formatDate(goods.getEndTime()));
						cal.add(Calendar.HOUR, CommUtil.null2Int(goods.getEndHour()));
						goods.setIgEndTime(cal.getTime());
					}

				}

				// 判断如果id是空的则执行保存，否则执行应该更新
				if (goods.getId() != null && goods.getId() > 0) {
					this.integralgoodsService.update(goods);
				} else {
					goods.setAddTime(new Date());
					this.integralgoodsService.save(goods);
				}
			}
			mv.addObject("list_url", list_url);
			mv.addObject("op_title", "保存积分商品成功");
			if (add_url != null) {
				mv.addObject("add_url", add_url);// + "?currentPage=" + currentPage);
			}
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "积分礼品删除", value = "/admin/integral_goods_del.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods_del.htm")
	public String integral_goods_del(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				// IntegralGoods integralgoods = this.integralgoodsService.getObjById(Long.parseLong(id));
				this.integralgoodsService.delete(Long.parseLong(id));
			}
		}
		return "redirect:integral_goods.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "积分礼品Ajax更新", value = "/admin/integral_goods_ajax.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_goods_ajax.htm")
	public void integral_goods_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
		IntegralGoods ig = this.integralgoodsService.getObjById(Long.parseLong(id));
		Field[] fields = IntegralGoods.class.getDeclaredFields();
		BeanWrapper wrapper = new BeanWrapper(ig);
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
		this.integralgoodsService.update(ig);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(val.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "积分礼品兑换列表", value = "/admin/integral_order.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order.htm")
	public ModelAndView integral_order(HttpServletRequest request, HttpServletResponse response,
			String currentPage, MyPage<IntegralGoodsOrderBO> page, IntegralGoodsOrderVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_order.html", configService.getSysConfig(),
				0, request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			page.setPageSize(10);
			this.integralGoodsOrderService.findPageByVo(page, vo);
			CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
			mv.addObject("vo", vo);
			BigDecimal transFee = integralGoodsOrderService.countTransFeeByVO(vo);
			Long allIntegral = integralGoodsOrderService.countIntegralByVO(vo);
			mv.addObject("transFee", transFee);
			mv.addObject("allIntegral", allIntegral);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "积分礼品兑换详情", value = "/admin/integral_order_view.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_view.htm")
	public ModelAndView integral_order_view(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_order_view.html",
				configService.getSysConfig(), 0, request, response);
		if (this.configService.getSysConfig().getIntegralStore()) {
			IntegralGoodsOrder obj = this.integralGoodsOrderService.getById(CommUtil.null2Long(id));
			mv.addObject("obj", obj);
			mv.addObject("express_company_name",
					this.orderFormTools.queryExInfo(obj.getIgoExpressInfo(), "express_company_name"));
			mv.addObject("orderFormTools", orderFormTools);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "取消积分订单", value = "/admin/integral_order_cancel.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_cancel.htm")
	public ModelAndView integral_order_cancel(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (this.configService.getSysConfig().getIntegralStore()) {
			this.integralGoodsOrderService.integralGoodsOrderCancel(SecurityUserHolder.getCurrentUser()
					.getId(), obj);
			mv.addObject("op_title", "积分兑换取消成功");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/integral_order.htm");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单确认付款", value = "/admin/integral_order_payok.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_payok.htm")
	public ModelAndView integral_order_payok(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (this.configService.getSysConfig().getIntegralStore()) {
			obj.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED);
			this.integralGoodsOrderService.update(obj);
			mv.addObject("op_title", "确认收款成功");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/integral_order.htm");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单删除", value = "/admin/integral_order_del.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_del.htm")
	public ModelAndView integral_order_del(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0,
				request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (this.configService.getSysConfig().getIntegralStore()) {
			if (obj.getIgoStatus() == IntegralGoodsOrderConstants.IGO_STATUS_HAVE_CANCELLED) {
				this.integralGoodsOrderService.delete(obj.getId());
			}
			mv.addObject("op_title", "删除兑换订单成功");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/integral_order.htm");
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单费用调整", value = "/admin/integral_order_fee.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_fee.htm")
	public ModelAndView integral_order_fee(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_order_fee.html",
				configService.getSysConfig(), 0, request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getById(CommUtil.null2Long(id));
		if (this.configService.getSysConfig().getIntegralStore()) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "订单费用调整保存", value = "/admin/integral_order_fee_save.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_fee_save.htm")
	public String integral_order_fee_save(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage, String igoTransFee) {
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
		if (this.configService.getSysConfig().getIntegralStore()) {
			obj.setIgoTransFee(BigDecimal.valueOf(CommUtil.null2Double(igoTransFee)));
			if (CommUtil.null2Double(obj.getIgoTransFee()) == 0) {
				obj.setIgoPayTime(new Date());
				obj.setIgoStatus(IntegralGoodsOrderConstants.IGO_STATUS_HAVE_PAYED);
			}
			this.integralGoodsOrderService.update(obj);
		}
		return "redirect:integral_order.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "确认发货", value = "/admin/integral_order_ship.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_ship.htm")
	public ModelAndView integral_order_ship(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/integral_order_ship.html",
				configService.getSysConfig(), 0, request, response);
		IntegralGoodsOrder obj = this.integralGoodsOrderService.getById(CommUtil.null2Long(id));
		mv.addObject("express_company_id",
				this.orderFormTools.queryExInfo(obj.getIgoExpressInfo(), "express_company_id"));
		if (this.configService.getSysConfig().getIntegralStore()) {
			mv.addObject("obj", obj);
			mv.addObject("currentPage", currentPage);
			List<ExpressCompanyBO> expressCompanys = this.expressCompanyService
					.findListByStatus(ExpressCompanyConstants.COMPANY_STATUS_ENABLE);
			mv.addObject("expressCompanys", expressCompanys);
		} else {
			mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0, request,
					response);
			mv.addObject("op_title", "系统未开启积分商城");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/operation_base_set.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "确认发货保存", value = "/admin/integral_order_ship_save.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_ship_save.htm")
	public String integral_order_ship_save(HttpServletRequest request, HttpServletResponse response,
			String currentPage, IntegralGoodsOrderVO vo) {
		if (vo != null && vo.getIgoId() != null && vo.getEcId() != null) {
			IntegralGoodsOrder obj = this.integralGoodsOrderService.getById(vo.getIgoId());
			ExpressCompany ec = this.expressCompanyService.getObjById(vo.getEcId());
			vo.setUid(SecurityUserHolder.getCurrentUser().getId());
			if (configService.getSysConfig().getIntegralStore())
				integralGoodsOrderService.integralGoodsOrderShipSave(vo, obj, ec);
		}
		return "redirect:integral_order.htm?currentPage=" + currentPage;
	}

	@SecurityMapping(title = "导出表格", value = "/admin/integral_order_excel.htm*", rtype = "admin", rname = "积分商城", rcode = "integral_goods_admin", rgroup = "商城管理")
	@RequestMapping("/admin/integral_order_excel.htm")
	public void integral_order_excel(HttpServletRequest request, HttpServletResponse response,
			MyPage<IntegralGoodsOrderBO> page, IntegralGoodsOrderVO vo) {

		String title = "订单列表";

		List<IntegralGoodsOrderBO> datas = new ArrayList<IntegralGoodsOrderBO>();
		page.setPageSize(1000000000);
		this.integralGoodsOrderService.findPageByVo(page, vo);
		datas = page.getContent();
//		String goodsName = "";
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
		HSSFWorkbook wb = new HSSFWorkbook();
		// 创建Excel的工作sheet,对应到一个excel文档的tab
		HSSFSheet sheet = wb.createSheet(title);
		// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
		// 创建Excel的sheet的一行
		HSSFRow row = sheet.createRow(0);
		row.setHeight((short) 500);// 设定行的高度
		// 创建一个Excel的单元格
		HSSFCell cell = row.createCell(0);

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

		// 合并单元格(startRow，endRow，startColumn，endColumn)
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 11));
		// 给Excel的单元格设置样式和赋值
		cell.setCellStyle(style);
		Date time1 = CommUtil.formatDate(vo.getBeginTime());
		Date time2 = CommUtil.formatDate(vo.getEndTime());
		String time = CommUtil.null2String(CommUtil.formatShortDate(time1) + " - "
				+ CommUtil.formatShortDate(time2));
		cell.setCellValue(this.configService.getSysConfig().getTitle() + title + "（" + time + "）");
		// 设置单元格内容格式时间
		HSSFCellStyle style2 = wb.createCellStyle();// 普通
		HSSFCellStyle styleDay = wb.createCellStyle();// 日期
		HSSFCellStyle styleTime = wb.createCellStyle();// 日期时间
		HSSFCellStyle styleMoney = wb.createCellStyle();// 小数点格式
		styleDay.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-mm-dd"));
		styleDay.setWrapText(true);// 自动换行
		styleDay.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleTime.setDataFormat(HSSFDataFormat.getBuiltinFormat("yyyy-MM-dd HH:mm:ss"));
		styleTime.setWrapText(true);// 自动换行
		styleTime.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		styleMoney.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
		styleMoney.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		row = sheet.createRow(1);

		if (datas != null && datas.size() > 0) {
			// datas = page.getContent();
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
			sheet.setColumnWidth(6, 4000);
			sheet.setColumnWidth(7, 4000);
			sheet.setColumnWidth(8, 6000);
			sheet.setColumnWidth(9, 6000);
			sheet.setColumnWidth(10, 6000);
			sheet.setColumnWidth(11, 6000);
			sheet.setColumnWidth(12, 8000);

			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("兑换单号");
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("买家姓名");
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("买家手机");
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("买家地址");
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("采购单号");
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("物流信息");
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("兑换积分");
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("运费");
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("兑换时间");
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("订单状态");
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("留言");
			cell = row.createCell(11);
			cell.setCellStyle(style2);
			cell.setCellValue("产品名称");
			cell = row.createCell(12);
			cell.setCellStyle(style2);
			cell.setCellValue("产品数量");
			cell = row.createCell(13);
			cell.setCellStyle(style2);

			double all_order_price = 0.00;// 订单总金额
			double all_total_amount = 0.00;// 商品总金
			int offet = 0;
			for (int j = 2; j <= datas.size() + 1; j++) {
				// 订单里面商品信息
				List<Map> goods_json = new ArrayList<Map>();
				if (datas.get(j - 2) != null) {
					try {
						goods_json = Json.fromJson(List.class,
								CommUtil.null2String(datas.get(j - 2).getGoodsInfo()));
					} catch (JsonException e) {
						e.printStackTrace();
					}
				}
				row = sheet.createRow(offet + 2);
				int i = 0;
				// 兑换单号
				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getIgoOrderSn());
				// 买家姓名
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getReceiverName());
				// 买家手机
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getReceiverMobile());
				// 买家地址
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getReceiverArea() + datas.get(j - 2).getReceiverAreaInfo());
				// 采购单号
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue("");
				// 物流信息
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue("");
				// 兑换积分
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getIgoTotalIntegral());
				// 运费
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getIgoTransFee().toString());
				// 兑换时间
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(sdf.format(datas.get(j - 2).getAddTime()));
				// 订单状态
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				String status = "";
				if (datas.get(j - 2).getIgoStatus() == -1) {
					status = "已取消";
				}
				if (datas.get(j - 2).getIgoStatus() == -0) {
					status = "待付款";
				}
				if (datas.get(j - 2).getIgoStatus() == 20) {
					status = "已付款，待发货";
				}
				if (datas.get(j - 2).getIgoStatus() == 30) {
					status = "已发货";
				}
				if (datas.get(j - 2).getIgoStatus() == 40) {
					status = "已收货完成";
				}
				cell.setCellValue(status);
				// 留言
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getIgoMsg());

				if (goods_json != null) {
					for (Map<?, ?> map : goods_json) {
						String name = (String) map.get("ig_goods_name");
						// 产品名称
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(name);

						Integer count = (Integer) map.get("ig_goods_count");
						// 产品数量
						cell = row.createCell(++i);
						cell.setCellStyle(style2);
						cell.setCellValue(count);
						--i;
						--i;
						offet++;
						row = sheet.createRow(offet + 2);
					}
				}
			}
			// 设置底部统计信息
			int m = datas.size() + 2;
			row = sheet.createRow(offet + 2);
			// 设置单元格的样式格式
			int i = 0;
		} else {
			sheet.setColumnWidth(0, 6000);
			cell = row.createCell(0);
			cell.setCellStyle(style2);
			cell.setCellValue("当前条件无订单信息");
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
