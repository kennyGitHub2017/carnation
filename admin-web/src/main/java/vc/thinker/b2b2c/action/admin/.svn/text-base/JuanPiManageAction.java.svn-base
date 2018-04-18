package vc.thinker.b2b2c.action.admin;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
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
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.biz.common.service.ServiceException;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.bo.JuanpiOrderGoodsBO;
import com.sinco.carnation.juanpi.model.JuanpiGoodsClass;
import com.sinco.carnation.juanpi.service.JuanpiGoodsClassService;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.juanpi.service.JuanpiOrderService;
import com.sinco.carnation.juanpi.service.SynJuanpiDataService;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsClassVO;
import com.sinco.carnation.juanpi.vo.JuanpiGoodsVO;
import com.sinco.carnation.juanpi.vo.JuanpiOrderGoodsVO;
import com.sinco.carnation.juanpi.vo.JuanpiOrderVO;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;

import freemarker.core.ParseException;

/**
 * <p>
 * Title: GoodsCaseManageAction.java
 * </p>
 * 
 * <p>
 * Description: 卷皮管理控制器
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
 * @date 2014-9-16
 * @version 1.0.1
 */
@SuppressWarnings("deprecation")
@Controller
public class JuanPiManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private JuanpiGoodsClassService juanpiGoodsClassService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;
	@Autowired
	private SynJuanpiDataService synJuanpiDataService;
	@Autowired
	private JuanpiOrderService juanpiOrderService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private DicContent dicContent;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * juanpi 类目管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "类目管理", value = "/admin/juanpi_leimu.htm*", rtype = "admin", rname = "类目管理", rcode = "juanpi_settlement", rgroup = "类目管理")
	@RequestMapping("/admin/juanpi_leimu.htm")
	public ModelAndView juanpi_leimu(HttpServletRequest request,
			HttpServletResponse response, MyPage<JuanpiGoodsClassBO> page,
			JuanpiGoodsClassVO vo) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_leimu.html",
				configService.getSysConfig(), 0, request, response);
		vo.setIsJoin(1);
		juanpiGoodsClassService.pageViewClassByVO(page, vo, mv);
		mv.addObject("vo", vo);
		mv.addObject("page", page);
		return mv;
	}

	/**
	 * juanpi 类目管理 > 绑定类目
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "绑定类目", value = "/admin/juanpi_leimu_add.htm*", rtype = "admin", rname = "绑定类目", rcode = "juanpi_leimu_add", rgroup = "绑定类目")
	@RequestMapping("/admin/juanpi_leimu_add.htm")
	public ModelAndView juanpi_leimu_add(HttpServletRequest request,
			HttpServletResponse response, Integer level) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_leimu_add.html",
				configService.getSysConfig(), 0, request, response);
		List<JuanpiGoodsClassBO> jpClass = new ArrayList<>();
		List<GoodsClassBO> ysClass = new ArrayList<>();
		if (level == null) {
			level = 1;
		}
		Integer isJoin = 0;
		jpClass = juanpiGoodsClassService.listByLevelId(level.toString(), null,
				isJoin);
		ysClass = goodsClassService.findGoodsClassByLevel(level - 1);
		mv.addObject("jpClass", jpClass);
		mv.addObject("ysClass", ysClass);
		return mv;
	}

	/**
	 * juanpi 类目管理 > 更改类目
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "类目管理", value = "/admin/juanpi_leimu_edit.htm*", rtype = "admin", rname = "类目管理", rcode = "juanpi_leimu_edit", rgroup = "类目管理")
	@RequestMapping("/admin/juanpi_leimu_edit.htm")
	public ModelAndView juanpi_leimu_edit(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String type) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_leimu_edit.html",
				configService.getSysConfig(), 0, request, response);

		List<GoodsClassBO> goodsClass = this.goodsClassService.findAllParents();
		mv.addObject("goodsClass", goodsClass);
		mv.addObject("mulitId", mulitId);
		mv.addObject("type", type);
		return mv;
	}

	@SecurityMapping(title = "卷皮类目映射云尚类目", value = "/admin/juanpi_class_move_class.htm*", rtype = "admin", rname = "商品管理", rcode = "juanpi_goods_move_class", rgroup = "商城管理")
	@RequestMapping("/admin/juanpi_class_move_class.htm")
	public void juanpi_class_move_class(HttpServletRequest request,
			HttpServletResponse response, String mulitId, String level,
			Long gcId) {
		String result = "更改成功";
		if (StringUtils.isBlank(level) || gcId == null || gcId <= 0) {
			result = "请选择正确的分类";
			responseWriter(response, result);
			return;
		}
		if (level.equals("3")) {// 3级分类
			juanpi_class_move_class3(request, response, mulitId, gcId);
			return;
		}

		String[] ids = mulitId.split(",");
		MyPage<JuanpiGoodsClassBO> page = new MyPage<>();
		JuanpiGoodsClassVO vo = new JuanpiGoodsClassVO();
		mulitId = "";
		if (level.equals("2")) {// 2级分类
			for (String id : ids) {
				vo.setCate2Id(Long.valueOf(id));
				vo.setIsJoin(0);// 只修改未映射的
				List<JuanpiGoodsClassBO> list = juanpiGoodsClassService
						.pageClassByVO(page, vo);
				if (list != null && list.size() > 0) {
					for (JuanpiGoodsClassBO bo : list) {
						mulitId = mulitId + bo.getId().toString() + ",";
					}
				}
			}
		}
		if (level.equals("1")) {// 1级分类
			for (String id : ids) {
				vo.setCateId(Long.valueOf(id));
				vo.setIsJoin(0);// 只修改未映射的
				List<JuanpiGoodsClassBO> list = juanpiGoodsClassService
						.pageClassByVO(page, vo);
				if (list != null && list.size() > 0) {
					for (JuanpiGoodsClassBO bo : list) {
						mulitId = mulitId + bo.getId().toString() + ",";
					}
				}
			}
		}
		juanpi_class_move_class3(request, response, mulitId, gcId);
		return;
	}

	@SecurityMapping(title = "卷皮类目映射云尚类目", value = "/admin/juanpi_class_move_class3.htm*", rtype = "admin", rname = "商品管理", rcode = "juanpi_goods_move_class", rgroup = "商城管理")
	@RequestMapping("/admin/juanpi_class_move_class3.htm")
	public void juanpi_class_move_class3(HttpServletRequest request,
			HttpServletResponse response, String mulitId, Long gcId) {
		String result = "更改成功";
		String[] ids = mulitId.split(",");
		if (gcId != null && gcId > 0) {
			for (String id : ids) {
				try {
					// 判断商品是否存在 改变商品分类字段值 保存商品 更新索引
					// JuanpiGoods goods =
					// this.juanpiGoodsService.findOne(Long.parseLong(id));
					juanpiGoodsClassService.findOne(Long.valueOf(id));
					GoodsClass level3 = goodsClassService.getObjById(gcId);
					if (level3.getLevel() != 2) {
						result = "选择的分类必须是三级分类";
						break;
					}
					GoodsClass level2 = goodsClassService.getObjById(level3
							.getParentId());
					GoodsClass level1 = goodsClassService.getObjById(level2
							.getParentId());
					JuanpiGoodsClass goodsClass = new JuanpiGoodsClass();
					goodsClass.setId(Long.valueOf(id));
					goodsClass.setClassId(level1.getId());
					goodsClass.setClass2Id(level2.getId());
					goodsClass.setClass3Id(level3.getId());
					goodsClass.setClassName(level1.getClassName());
					goodsClass.setClass2Name(level2.getClassName());
					goodsClass.setClass3Name(level3.getClassName());
					juanpiGoodsClassService.edit(goodsClass);
				} catch (ServiceException e) {
					log.error(e.getMessage());
					result = e.getErrorCode();
				} catch (Exception e) {
					log.error(e.getMessage());
					result = "分类更改失败";
				}
				if (!id.equals("") && StringUtils.isNumeric(id)) {
					// this.goodsService.update(goods);
					// 更新索引
					try {
						// synJuanpiDataService.updateLucene(Long.valueOf(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		responseWriter(response, result);
	}

	@SecurityMapping(title = "卷皮商品更改类目", value = "/admin/juanpi_goods_move_class.htm*", rtype = "admin", rname = "商品管理", rcode = "juanpi_goods_move_class", rgroup = "商城管理")
	@RequestMapping("/admin/juanpi_goods_move_class.htm")
	public void juanpi_goods_move_class(HttpServletRequest request,
			HttpServletResponse response, String mulitId, Long gcId) {
		String result = "更改成功";
		String[] ids = mulitId.split(",");
		if (gcId != null && gcId > 0) {
			for (String id : ids) {
				if (!id.equals("") && StringUtils.isNumeric(id)) {
					GoodsClass level3 = goodsClassService.getObjById(gcId);
					if (level3.getLevel() != 2) {
						result = "选择的分类必须是三级分类";
						break;
					}
					// 判断商品是否存在 改变商品分类字段值 保存商品 更新索引
					// JuanpiGoods goods =
					// this.juanpiGoodsService.findOne(Long.parseLong(id));
					JuanpiGoodsVO vo = new JuanpiGoodsVO();
					vo.setId(Long.valueOf(id));
					vo.setClassId(gcId);
					juanpiGoodsService.updateClass(vo);
					// this.goodsService.update(goods);
					// 更新索引
					try {
						synJuanpiDataService.updateLucene(Long.valueOf(id));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		responseWriter(response, result);
	}

	/**
	 * 根据父id查找服务子类
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/admin/load_juanpi_class.htm")
	public void loadJuanpiClass(HttpServletRequest request,
			HttpServletResponse response, String level, Long pid) {
		List<JuanpiGoodsClassBO> bos = juanpiGoodsClassService.listByLevelId(
				level, pid, 0);
		List<Map> list = new ArrayList<Map>();
		for (JuanpiGoodsClassBO bo : bos) {
			Map map = new HashMap();
			// map.put("id", area.getCode());
			// map.put("gcName", area.getName());
			map.put("id", bo.getId());
			map.put("jpGcId", bo.getJpGcId());
			map.put("className", bo.getJpGcName());
			list.add(map);
		}
		String temp = Json.toJson(list, JsonFormat.compact());
		responseWriter(response, temp);
	}

	private void responseWriter(HttpServletResponse response, String result) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// /**
	// * 商品推荐
	// *
	// * @param request
	// * @param response
	// * @param id
	// * @return
	// */
	// @SecurityMapping(title = "商品推荐", value =
	// "/admin/juanpi_goods_recommend.htm*", rtype = "admin", rname = "商品管理",
	// rcode = "admin_goods", rgroup = "商城管理")
	// @RequestMapping("/admin/juanpi_goods_recommend.htm")
	// public ModelAndView goods_recommend(HttpServletRequest request,
	// HttpServletResponse response, String id) {
	// ModelAndView mv = new JModelAndView("admin/blue/advert_add.html",
	// configService.getSysConfig(), 0,
	// request, response);
	// if (StringUtils.isNotBlank(id)) {
	// List<AdvertPosition> apsList = advertPositionService.findByRelease(1);
	// mv.addObject("adTypeGoods", AdvertContant.ADVERT_TPYE_GOODS);
	// mv.addObject("goodsId", id);
	// mv.addObject("aps", apsList);
	// mv.addObject("goodsFlag", true);
	// mv.addObject("apCode", "INDEX_POPULAR_RECOMMEND");
	// }
	//
	// return mv;
	// }

	/**
	 * juanpi 订单管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "订单管理", value = "/admin/juanpi_order.htm*", rtype = "admin", rname = "订单管理", rcode = "juanpi_order", rgroup = "订单管理")
	@RequestMapping("/admin/juanpi_order.htm")
	public ModelAndView juanpi_order(HttpServletRequest request,
			HttpServletResponse response, JuanpiOrderVO vo,
			MyPage<JuanpiOrderBO> page) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_order.html",
				configService.getSysConfig(), 0, request, response);
		juanpiOrderService.selectOrderListByVO(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		return mv;
	}

	/**
	 * juanpi 订单管理 》 详情
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "订单详情", value = "/admin/juanpi_order_detail.htm*", rtype = "admin", rname = "订单详情", rcode = "juanpi_order_detail", rgroup = "订单详情")
	@RequestMapping("/admin/juanpi_order_detail.htm")
	public ModelAndView juanpi_order_detail(HttpServletRequest request,
			HttpServletResponse response, MyPage<JuanpiOrderGoodsBO> page,
			Integer orderId) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_order_detail.html",
				configService.getSysConfig(), 0, request, response);
		juanpiGoodsService.findGoodsByOrderId(orderId, page);
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);

		return mv;
	}

	/**
	 * juanpi 结算管理
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "结算管理", value = "/admin/juanpi_settlement.htm*", rtype = "admin", rname = "结算管理", rcode = "juanpi_settlement", rgroup = "结算管理")
	@RequestMapping("/admin/juanpi_settlement.htm")
	public ModelAndView juanpi_settlement(HttpServletRequest request,
			HttpServletResponse response, MyPage<JuanpiOrderGoodsBO> page,
			JuanpiOrderGoodsVO vo) {
		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_settlement.html",
				configService.getSysConfig(), 0, request, response);
		juanpiOrderService.selectOrderGoodsListByVO(vo, page);
		JuanpiOrderGoodsBO orderTotals = juanpiOrderService
				.selectMoneyTotal(new JuanpiOrderGoodsVO());
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("orderTotals", orderTotals);
		return mv;
	}

	/**
	 * juanpi 结算统计
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "结算统计", value = "/admin/juanpi_total.htm*", rtype = "admin", rname = "结算管理", rcode = "juanpi_total", rgroup = "结算管理")
	@RequestMapping("/admin/juanpi_total.htm")
	public void juanpi_total(HttpServletRequest request,
			HttpServletResponse response, JuanpiOrderGoodsVO vo) {
		JuanpiOrderGoodsBO orderTotals = juanpiOrderService
				.selectMoneyTotal(vo);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(orderTotals));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * juanpi 商品列表
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "商品列表", value = "/admin/juanpi_goods_list.htm*", rtype = "admin", rname = "商品列表", rcode = "juanpi_settlement", rgroup = "商品列表")
	@RequestMapping("/admin/juanpi_goods_list.htm")
	public ModelAndView juanpi_goods_list(HttpServletRequest request,
			HttpServletResponse response, MyPage<JuanpiGoodsBO> page,
			JuanpiGoodsVO vo) {
		// sell 出售中；warehouse 仓库中；stop 已下架
		switch (vo.getType()) {
		case "sell":
			vo.setIsShow(1);
			vo.setDeleteStatus(0);
			break;
		case "warehouse":
			vo.setIsShow(0);
			vo.setDeleteStatus(0);
			break;
		case "stop":
			vo.setDeleteStatus(1);
			break;
		default:
			break;
		}

		ModelAndView mv = new JModelAndView(
				"admin/blue/juanpi/juanpi_goods_list.html",
				configService.getSysConfig(), 0, request, response);
		juanpiGoodsService.findGoodsByVO(vo, page);
		List<JuanpiGoodsBO> goodsList = new ArrayList<>();
		List<JuanpiGoodsBO> goodsLists = page.getResult();
		for (JuanpiGoodsBO juanpiGoodsBO : goodsLists) {
			if (juanpiGoodsBO.getClassId() != null) {
				List<JuanpiGoodsBO> cNames = juanpiGoodsService
						.findClassNameById(juanpiGoodsBO.getClassId());
				for (JuanpiGoodsBO cName : cNames) {
					if (cName != null) {
						juanpiGoodsBO.setClassName(cName.getClassName());
						juanpiGoodsBO.setClass2Name(cName.getClass2Name());
						juanpiGoodsBO.setClass3Name(cName.getClass3Name());
						break;
					}
				}
			}
		}
		if ("stop".equals(vo.getType())) {
			for (JuanpiGoodsBO goodsBO : goodsLists) {
				if (goodsBO.getDeleteStatus() == 1
						|| goodsBO.getGoodsOffShelf().before(new Date())) {
					goodsBO.setSta(1);
				} else {
					goodsBO.setSta(2);
				}
				goodsList.add(goodsBO);
			}
		} else {
			goodsList = goodsLists;
		}
		List<GoodsClassBO> gcs = this.goodsClassService.findAllParents();
		List<GoodsClassBO> gcs2 = this.goodsClassService.findByParent(vo
				.getFgcId());
		List<GoodsClassBO> gcs3 = this.goodsClassService.findByParent(vo
				.getSgcId());
		if (null != vo.getFgcId()) {
			gcs2 = this.goodsClassService.findByParent(vo.getFgcId());
		}
		if (null != vo.getSgcId()) {
			gcs3 = this.goodsClassService.findByParent(vo.getSgcId());
		}
		CommUtil.saveIPageList2ModelAndView("", "", null, page, mv);
		mv.addObject("vo", vo);
		mv.addObject("gcs", gcs);
		mv.addObject("gcs2", gcs2);
		mv.addObject("gcs3", gcs3);
		mv.addObject("goodsList", goodsList);
		mv.addObject("uid", SecurityUserHolder.getCurrentUserId());
		return mv;
	}

	/**
	 * AJAX加载商品分类数据
	 * 
	 * @param request
	 * @param response
	 * @param pid
	 *            上级分类Id
	 * @param session
	 *            是否加载到session中
	 */
	@SecurityMapping(title = "加载商品分类", value = "/admin/goods_load_class.htm*", rtype = "admin", rname = "卷皮管理", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_load_class.htm")
	public void load_goods_class(HttpServletRequest request,
			HttpServletResponse response, String pid, String session) {
		List<GoodsClassBO> childsList = this.dicContent
				.getDicsConvertByParentCode(GoodsClassBO.class, pid);

		GoodsClass obj = this.goodsClassService.getObjById(CommUtil
				.null2Long(pid));

		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		if (!CollectionUtils.isEmpty(childsList)) {
			for (GoodsClassBO gc : childsList) {
				Map<String, String> map = new HashMap<String, String>();
				if (gc.getGoodsTypeId() != null) {// 不显示没有指定类型的商品分类
					map.put("id", gc.getId().toString());
					map.put("className", gc.getClassName());
					list.add(map);
				}

			}
		}
		if (obj != null && CommUtil.null2Boolean(session)) {
			request.getSession(false).setAttribute("goods_class_info", obj);
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(list));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * juanpi 删除下架的卷皮商品
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	@SecurityMapping(title = "删除下架的卷皮商品", value = "/admin/juanpi_delete.htm*", rtype = "admin", rname = "删除下架的卷皮商品", rcode = "juanpi_delete", rgroup = "删除下架的卷皮商品")
	@RequestMapping("/admin/juanpi_delete.htm")
	public void juanpi_delete(HttpServletRequest request,
			HttpServletResponse response, String[] ids) {

		boolean flag = false;
		int iret = 0;
		for (int i = 0; i < ids.length; i++) {
			if (i < ids.length - 1) {
				iret = juanpiGoodsService.deleteGood(Long.parseLong(ids[i]
						.toString()));
			}
			if (iret > 0) {
				flag = true;
			} else {
				flag = false;
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SecurityMapping(title = "卷皮商品改变显示状态", value = "/admin/update_juanpiGoods_IsShow.htm*", rtype = "admin", rname = "商品列表", rcode = "juanpi_settlement", rgroup = "商品列表")
	@RequestMapping("/admin/update_juanpiGoods_IsShow.htm")
	public void update_juanpiGoods_IsShow(HttpServletRequest request,
			HttpServletResponse response, String[] ids, Integer isShow) {
		JuanpiGoodsVO vo = new JuanpiGoodsVO();
		vo.setIsShow(isShow);
		boolean flag = false;
		if (ids != null) {
			for (int i = 0; i < ids.length; i++) {
				vo.setId(Long.parseLong(ids[i].toString()));
				int iret = juanpiGoodsService.updateIsShow(vo);
				try {
					// 更新索引
					synJuanpiDataService.updateLucene(Long.valueOf(ids[i]));
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (iret > 0 && i == ids.length - 1) {
					flag = true;
				} else {
					flag = false;
				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "卷皮订单导出", value = "/admin/juanpi_order_export.htm*", rtype = "admin", rname = "卷皮订单管理", rcode = "juanpi_order_export", rgroup = "卷皮管理")
	@RequestMapping("/admin/juanpi_order_export.htm")
	public ModelAndView juanpi_order_export(HttpServletRequest request,
			HttpServletResponse response, JuanpiOrderVO vo,
			MyPage<JuanpiOrderBO> page) {

		page.setPageSize(1000000000);
		List<JuanpiOrderBO> juanpiOrderList = juanpiOrderService
				.selectOrderListByVO(vo, page);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<JuanpiOrderBO> datas = page.getContent();

			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("卷皮订单列表");
			// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
			for (int i = 0; i < datas.size(); i++) {
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1,
						2 + i, (short) 1, 2 + i));
			}

			// 设置excel每列宽度
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);
			sheet.setColumnWidth(8, 6000);
			sheet.setColumnWidth(9, 6000);
			sheet.setColumnWidth(10, 6000);
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

			String title = "卷皮订单统计报表";
			cell.setCellValue(this.configService.getSysConfig().getTitle()
					+ title);

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
			cell.setCellValue("订单号");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("来源");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("商品总量");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("订单金额");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("商品名称");
			//
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("商品数量");
			//
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("商品价格");
			//
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("结算比例");
			//
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("可得佣金");
			//
			cell = row.createCell(10);
			cell.setCellStyle(style2);
			cell.setCellValue("结算状态");
			int y = 2;
			for (int j = 2; j <= datas.size() + 1; j++) { // 第一个外层循环
				row = sheet.createRow(y);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderno());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2)
						.getOrdertime()));

				String str = "";
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				switch (datas.get(j - 2).getPlatid()) {
				case 1:
					str = "PC";
					break;
				case 2:
					str = "M站";
					break;
				case 3:
					str = "卷皮Android";
					break;
				case 4:
					str = "卷皮iPhone";
					break;
				case 5:
					str = "卷皮iPad";
					break;
				case 6:
					str = "九块邮Android";
					break;
				case 7:
					str = "九块邮iPhone";
					break;
				case 8:
					str = "九块邮iPad";
					break;
				case 9:
					str = "微信特卖";
					break;
				case 10:
					str = "安卓Pad";
					break;
				default:
					break;
				}
				cell.setCellValue(str);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodsnumber());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodsmoney().toString());

				// int y = j;
				List<JuanpiOrderGoodsBO> goods = juanpiGoodsService
						.findGoodsByOrderId(
								Integer.parseInt(datas.get(j - 2).getId()
										.toString()), null);
				// for (JuanpiOrderGoodsBO good : goods) {
				// y++;
				// if (y == j) {
				// cell = row.createCell(++i);
				// cell.setCellStyle(style2);
				// cell.setCellValue(2);
				// } else {
				// cell = row.createCell(i);
				// cell.setCellStyle(style2);
				// cell.setCellValue(3);
				// }
				// row = sheet.createRow(y);
				// }
				int x = 0;
				int z = 5;
				for (JuanpiOrderGoodsBO good : goods) { // 第二个迭代商品
					if (x == 0) {
						cell = row.createCell(z);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodstitle());

						cell = row.createCell(z + 1);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodsnumber());

						cell = row.createCell(z + 2);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodsmoney().toString());

						cell = row.createCell(z + 3);
						cell.setCellStyle(style2);
						cell.setCellValue(new java.text.DecimalFormat("#.00")
								.format(good.getBrokerageratiocale()) + "%");

						cell = row.createCell(z + 4);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getCommission().toString());

						String statusName = "";
						switch (good.getStatus()) {
						case 1:
							statusName = "待处理";
							break;
						case 2:
							statusName = "待结算";
							break;
						case 3:
							statusName = "已结算";
							break;
						case 4:
							statusName = "不可结算";
							break;
						default:
							break;
						}
						cell = row.createCell(z + 5);
						cell.setCellStyle(style2);
						cell.setCellValue(statusName);

					} else {
						row = sheet.createRow(y);
						cell = row.createCell(z);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodstitle());

						cell = row.createCell(z + 1);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodsnumber());

						cell = row.createCell(z + 2);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getGoodsmoney().toString());

						cell = row.createCell(z + 3);
						cell.setCellStyle(style2);
						cell.setCellValue(new java.text.DecimalFormat("#.00")
								.format(good.getBrokerageratiocale()) + "%");

						cell = row.createCell(z + 4);
						cell.setCellStyle(style2);
						cell.setCellValue(good.getCommission().toString());

						String statusName = "";
						switch (good.getStatus()) {
						case 1:
							statusName = "待处理";
							break;
						case 2:
							statusName = "待结算";
							break;
						case 3:
							statusName = "已结算";
							break;
						case 4:
							statusName = "不可结算";
							break;
						default:
							break;
						}
						cell = row.createCell(z + 5);
						cell.setCellStyle(style2);
						cell.setCellValue(statusName);
					}
					x += 1;
					y += 1;
				}
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				// String path =
				// request.getSession().getServletContext().getRealPath("") +
				// File.separator + "excel";
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition",
						"attachment;filename=" + excel_name + ".xls");
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return new ModelAndView("redirect:/admin/juanpi_order.htm");

	}

	@SuppressWarnings("unused")
	@SecurityMapping(title = "卷皮结算导出", value = "/admin/total_order_export.htm*", rtype = "admin", rname = "卷皮结算管理", rcode = "total_order_export", rgroup = "卷皮管理")
	@RequestMapping("/admin/total_order_export.htm")
	public ModelAndView total_order_export(HttpServletRequest request,
			HttpServletResponse response, JuanpiOrderGoodsVO vo,
			MyPage<JuanpiOrderGoodsBO> page) {

		page.setPageSize(1000000000);
		List<JuanpiOrderGoodsBO> juanpiOrderList = juanpiOrderService
				.selectOrderGoodsListByVO(vo, page);

		if (page.getContent() != null && page.getContent().size() > 0) {
			List<JuanpiOrderGoodsBO> datas = page.getContent();

			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook();
			// 创建Excel的工作sheet,对应到一个excel文档的tab
			HSSFSheet sheet = wb.createSheet("卷皮订单列表");
			// HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			List<HSSFClientAnchor> anchor = new ArrayList<HSSFClientAnchor>();
			for (int i = 0; i < datas.size(); i++) {
				anchor.add(new HSSFClientAnchor(0, 0, 1000, 255, (short) 1,
						2 + i, (short) 1, 2 + i));
			}

			// 设置excel每列宽度
			sheet.setColumnWidth(0, 6000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 6000);
			sheet.setColumnWidth(3, 6000);
			sheet.setColumnWidth(4, 6000);
			sheet.setColumnWidth(5, 6000);
			sheet.setColumnWidth(6, 6000);
			sheet.setColumnWidth(7, 6000);
			sheet.setColumnWidth(8, 6000);
			sheet.setColumnWidth(9, 6000);
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

			String title = "卷皮结算统计报表";
			cell.setCellValue(this.configService.getSysConfig().getTitle()
					+ title);

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
			cell.setCellValue("订单号");
			//
			cell = row.createCell(1);
			cell.setCellStyle(style2);
			cell.setCellValue("商品名称");
			//
			cell = row.createCell(2);
			cell.setCellStyle(style2);
			cell.setCellValue("商品数量");
			//
			cell = row.createCell(3);
			cell.setCellStyle(style2);
			cell.setCellValue("商品总价");
			//
			cell = row.createCell(4);
			cell.setCellStyle(style2);
			cell.setCellValue("下单时间");
			//
			cell = row.createCell(5);
			cell.setCellStyle(style2);
			cell.setCellValue("来源");
			//
			cell = row.createCell(6);
			cell.setCellStyle(style2);
			cell.setCellValue("结算比例");
			//
			cell = row.createCell(7);
			cell.setCellStyle(style2);
			cell.setCellValue("卷皮佣金");
			//
			cell = row.createCell(8);
			cell.setCellStyle(style2);
			cell.setCellValue("云尚佣金");
			//
			cell = row.createCell(9);
			cell.setCellStyle(style2);
			cell.setCellValue("结算状态");

			for (int j = 2; j <= datas.size() + 1; j++) {
				row = sheet.createRow(j);
				int i = 0;

				cell = row.createCell(i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getOrderNo());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodstitle());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodsnumber());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getGoodsmoney().toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(CommUtil.formatLongDate(datas.get(j - 2)
						.getAddOrderTime()));

				String str = "";
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				switch (datas.get(j - 2).getPlatId()) {
				case 1:
					str = "PC";
					break;
				case 2:
					str = "M站";
					break;
				case 3:
					str = "卷皮Android";
					break;
				case 4:
					str = "卷皮iPhone";
					break;
				case 5:
					str = "卷皮iPad";
					break;
				case 6:
					str = "九块邮Android";
					break;
				case 7:
					str = "九块邮iPhone";
					break;
				case 8:
					str = "九块邮iPad";
					break;
				case 9:
					str = "微信特卖";
					break;
				case 10:
					str = "安卓Pad";
					break;
				default:
					break;
				}
				cell.setCellValue(str);

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(new java.text.DecimalFormat("#.00")
						.format(datas.get(j - 2).getBrokerageratiocale()) + "%");
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getCommission().toString());

				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(datas.get(j - 2).getYunCommission()
						.toString());

				String statusName = "";
				switch (datas.get(j - 2).getStatus()) {
				case 1:
					statusName = "待处理";
					break;
				case 2:
					statusName = "待结算";
					break;
				case 3:
					statusName = "已结算";
					break;
				case 4:
					statusName = "不可结算";
					break;
				default:
					break;
				}
				cell = row.createCell(++i);
				cell.setCellStyle(style2);
				cell.setCellValue(statusName);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String excel_name = sdf.format(new Date());
			try {
				// String path =
				// request.getSession().getServletContext().getRealPath("") +
				// File.separator + "excel";
				response.setContentType("application/x-download");
				response.addHeader("Content-Disposition",
						"attachment;filename=" + excel_name + ".xls");
				OutputStream os = response.getOutputStream();
				wb.write(os);
				os.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return new ModelAndView("redirect:/admin/juanpi_settlement.htm");
	}

}