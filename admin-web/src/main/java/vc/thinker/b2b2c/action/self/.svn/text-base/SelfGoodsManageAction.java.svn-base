package vc.thinker.b2b2c.action.self;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
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
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinco.carnation.activity.service.ActivityService;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsBrand;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.model.GoodsSpec;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsFormatService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsSpecificationService;
import com.sinco.carnation.goods.service.GoodsTypePropertyService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.goods.tools.GoodsTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.carnation.shop.model.Payment;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.vo.ZeroGoodsVO;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.contants.ActAppHotSaleContant;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.service.TransportService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.ManagerService;
import com.sinco.carnation.user.service.PhysicalService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicParentBase;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.beans.BeanUtils;
import vc.thinker.b2b2c.core.beans.BeanWrapper;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.LuceneVo;

/**
 * 
 * <p>
 * Title: GoodsSelfManageAction.java
 * </p>
 * 
 * <p>
 * Description:自营商品管理控制器，平台可发布商品并进行管理
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
 * @date 2014年4月25日
 * 
 * @version 1.0.1
 */
@Controller
public class SelfGoodsManageAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private TemplateService templateService;
	@Autowired
	private UserService userService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private MessageService messageService;
	// @Autowired
	// private MsgTools msgTools;
	@Autowired
	private DatabaseTools databaseTools;
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
	@Autowired
	private UserGoodsClassService userGoodsClassService;
	@Autowired
	private GoodsSpecPropertyService specPropertyService;
	@Autowired
	private GoodsTypePropertyService goodsTypePropertyService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private TransportService transportService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private ActivityService activityService;

	// @Autowired
	// private StoreTools storeTools;
	// @Autowired
	// private StoreViewTools storeViewTools;
	// @Autowired
	// private GoodsViewTools goodsViewTools;
	@Autowired
	private GoodsSpecificationService goodsSpecificationService;
	@Autowired
	private GoodsFormatService goodsFormatService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private GoodsTools goodsTools;
	@Autowired
	private ImageTools ImageTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private LuceneVoTools luceneVoTools;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private PhysicalService physicalService;
	@Autowired
	private SaleActivityService saleActivityService;

	/**
	 * 商品发布第一步
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品发布第一步", value = "/admin/add_goods_first.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/add_goods_first.htm")
	public ModelAndView add_goods_first(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/error.html", configService.getSysConfig(), 0,
				request, response);
		// User user = this.userService.getObjById(SecurityUserHolder
		// .getCurrentUser().getId());
		request.getSession(false).removeAttribute("goods_class_info");
		List<Payment> payments = this.paymentService.findInstalledAll();
		if (payments.size() == 0) {
			mv.addObject("op_title", "请至少开通一种支付方式");
			mv.addObject("list_url", CommUtil.getURL(request) + "/admin/payment_list.htm");
			return mv;
		} else {
			mv = new JModelAndView("admin/blue/add_goods_first.html", configService.getSysConfig(), 0,
					request, response);
			// String json_staples = "";
			// if (user.getStapleGc() != null && !user.getStapleGc().equals(""))
			// {
			// json_staples = user.getStapleGc();
			// }
			// List<Map> staples = Json.fromJson(List.class, json_staples);
			List<GoodsClassBO> goodsClass = this.goodsClassService.findAllParents();
			// mv.addObject("goodsClassStaple", staples);
			mv.addObject("goodsClass", goodsClass);
			mv.addObject("id", CommUtil.null2String(id));
			return mv;
		}
	}

	// /**
	// * 根据常用商品分类加载分类信息
	// *
	// * @param currentPage
	// * @param orderBy
	// * @param orderType
	// * @param request
	// * @return
	// */
	// @SecurityMapping(title = "根据常用商品分类加载分类信息", value =
	// "/admin/load_goods_class_staple.htm*", rtype = "admin", rname = "商品发布",
	// rcode = "goods_self_add", rgroup = "自营")
	// @RequestMapping("/admin/load_goods_class_staple.htm")
	// public void load_goods_class_staple(HttpServletRequest request,
	// HttpServletResponse response, String id, String name) {
	// GoodsClass obj = null;
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// if (id != null && !id.equals("")) {
	// List<Map> list_map = Json.fromJson(List.class, user.getStaple_gc());
	// for (Map map : list_map) {
	// if (CommUtil.null2String(map.get("id")).equals(id)) {
	// obj = this.goodsClassService.getObjById(CommUtil
	// .null2Long(map.get("id")));
	// }
	// }
	// }
	// if (name != null && !name.equals(""))
	// obj = this.goodsClassService.getObjByProperty(null, "className",
	// name);
	// List<List<Map>> list = new ArrayList<List<Map>>();
	// if (obj != null) {
	// // 该版本要求三级分类才能添加到常用分类
	// request.getSession(false).setAttribute("goods_class_info", obj);
	// Map params = new HashMap();
	// List<Map> second_list = new ArrayList<Map>();
	// List<Map> third_list = new ArrayList<Map>();
	// List<Map> other_list = new ArrayList<Map>();
	//
	// if (obj.getLevel() == 2) {
	// params.put("pid", obj.getParent().getParent().getId());
	// List<GoodsClass> second_gcs = this.goodsClassService
	// .query("select obj from GoodsClass obj where obj.parent.id=:pid order by
	// obj.sequence asc",
	// params, -1, -1);
	// for (GoodsClass gc : second_gcs) {
	// Map map = new HashMap();
	// map.put("id", gc.getId());
	// map.put("className", gc.getClassName());
	// second_list.add(map);
	// }
	// params.clear();
	// params.put("pid", obj.getParent().getId());
	// List<GoodsClass> third_gcs = this.goodsClassService
	// .query("select obj from GoodsClass obj where obj.parent.id=:pid order by
	// obj.sequence asc",
	// params, -1, -1);
	// for (GoodsClass gc : third_gcs) {
	// Map map = new HashMap();
	// map.put("id", gc.getId());
	// map.put("className", gc.getClassName());
	// third_list.add(map);
	// }
	// }
	//
	// if (obj.getLevel() == 1) {
	// params.clear();
	// params.put("pid", obj.getParent().getId());
	// List<GoodsClass> third_gcs = this.goodsClassService
	// .query("select obj from GoodsClass obj where obj.parent.id=:pid order by
	// obj.sequence asc",
	// params, -1, -1);
	// for (GoodsClass gc : third_gcs) {
	// Map map = new HashMap();
	// map.put("id", gc.getId());
	// map.put("className", gc.getClassName());
	// second_list.add(map);
	// }
	// }
	//
	// Map map = new HashMap();
	// String staple_info = this.generic_goods_class_info(obj);
	// map.put("staple_info",
	// staple_info.substring(0, staple_info.length() - 1));
	// other_list.add(map);
	//
	// list.add(second_list);
	// list.add(third_list);
	// list.add(other_list);
	// }
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(Json.toJson(list, JsonFormat.compact()));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

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
	@SecurityMapping(title = "加载商品分类", value = "/admin/load_goods_class.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/load_goods_class.htm")
	public void load_goods_class(HttpServletRequest request, HttpServletResponse response, String pid,
			String session) {
		this.goodsClassService.refreshDicCache();
		List<GoodsClassBO> childsList = this.dicContent.getDicsConvertByParentCode(GoodsClassBO.class, pid);

		GoodsClass obj = this.goodsClassService.getObjById(CommUtil.null2Long(pid));

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// /**
	// * 添加管理员常用商品分类
	// *
	// * @param request
	// * @param response
	// */
	// @SecurityMapping(title = "添加常用商品分类", value =
	// "/admin/load_goods_class.htm*", rtype = "admin", rname = "商品发布", rcode =
	// "goods_self_add", rgroup = "自营")
	// @RequestMapping("/admin/add_goods_class_staple.htm")
	// public void add_goods_class_staple(HttpServletRequest request,
	// HttpServletResponse response) {
	// String ret = "error";
	// String json = "";
	// Map map = new HashMap();
	// if (request.getSession(false).getAttribute("goods_class_info") != null) {
	// GoodsClass gc = this.goodsClassService
	// .getObjById(((GoodsClass) request.getSession(false)
	// .getAttribute("goods_class_info")).getId());
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// List<Map> list_map = new ArrayList<Map>();
	// if (user.getStaple_gc() != null && !user.getStaple_gc().equals("")) {
	// list_map = Json.fromJson(List.class, user.getStaple_gc());
	// }
	// if (list_map.size() > 0) {
	// boolean flag = true;
	// for (Map staple : list_map) {
	// if (gc.getId().toString()
	// .equals(CommUtil.null2String(staple.get("id")))) {
	// flag = false;
	// break;
	// }
	// }
	// if (flag) {
	// System.out.println(gc.getParent().getId());
	// map.put("name",
	// gc.getParent().getParent().getClassName() + ">"
	// + gc.getParent().getClassName() + ">"
	// + gc.getClassName());
	// map.put("id", gc.getId());
	// list_map.add(map);
	// json = Json.toJson(list_map, JsonFormat.compact());
	// }
	// } else {
	// map.put("name",
	// gc.getParent().getParent().getClassName() + ">"
	// + gc.getParent().getClassName() + ">"
	// + gc.getClassName());
	// map.put("id", gc.getId());
	// list_map.add(map);
	// json = Json.toJson(list_map, JsonFormat.compact());
	// }
	// user.setStaple_gc(json);
	// boolean flag = this.userService.update(user);
	// if (flag) {
	// ret = "success";
	// }
	// }
	// map.put("ret", ret);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// writer.print(json = Json.toJson(map, JsonFormat.compact()));
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	// /**
	// * 删除管理员常用商品分类
	// *
	// * @param request
	// * @param response
	// * @param id
	// */
	// @SecurityMapping(title = "删除常用商品分类", value =
	// "/admin/del_goods_class_staple.htm*", rtype = "admin", rname = "商品发布",
	// rcode = "goods_self_add", rgroup = "自营")
	// @RequestMapping("/admin/del_goods_class_staple.htm")
	// public void del_goods_class_staple(HttpServletRequest request,
	// HttpServletResponse response, String id) {
	// User user = this.userService.getObjById(SecurityUserHolder
	// .getCurrentUser().getId());
	// // List<Map> list_map = Json.fromJson(List.class, user.getStaple_gc());
	// // boolean ret = false;
	// // for (Map map : list_map) {
	// // if (CommUtil.null2String(map.get("id")).equals(id)) {
	// // ret = list_map.remove(map);
	// // }
	// // }
	// // user.setStaple_gc(Json.toJson(list_map, JsonFormat.compact()));
	// // this.userService.update(user);
	// response.setContentType("text/plain");
	// response.setHeader("Cache-Control", "no-cache");
	// response.setCharacterEncoding("UTF-8");
	// PrintWriter writer;
	// try {
	// writer = response.getWriter();
	// // writer.print(ret);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

	/**
	 * Goods列表页
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unused")
	@SecurityMapping(title = "商品发布第二步", value = "/admin/add_goods_second.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/add_goods_second.htm")
	public ModelAndView add_goods_second(HttpServletRequest request, HttpServletResponse response,
			String currentPage, String orderBy, String orderType) {
		ModelAndView mv = new JModelAndView("admin/blue/add_goods_second.html", configService.getSysConfig(),
				0, request, response);
		if (request.getSession(false).getAttribute("goods_class_info") != null) {
			GoodsClass gc = (GoodsClass) request.getSession(false).getAttribute("goods_class_info");
			gc = this.goodsClassService.getObjById(gc.getId());
			String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
			mv.addObject("goods_class", this.goodsClassService.getBOAndTpyePropertyById(gc.getId()));
			mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));
			request.getSession(false).removeAttribute("goods_class_info");
			if (gc.getLevel() == 2) {// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
				List<GoodsSpecification> goodsSpecList = goodsSpecificationService
						.findByType(GoodsConstants.GOODS_SPECI_SELF);
				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
						.findSpecProperty(goodsSpecList);
				goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO, gc.getId());

				mv.addObject("goods_spec_list", goodsSpecListBO);
			} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
				List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByTypeAndClassId(
						GoodsConstants.GOODS_SPECI_SELF, gc.getId());
				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
						.findSpecProperty(goodsSpecList);
				mv.addObject("goods_spec_list", goodsSpecListBO);
			}
			GoodsClassBO goods_class = null;
			if (gc.getLevel() == 2) {
				GoodsClassBO dicClass = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(gc.getParentId()));
				goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(dicClass.getParentId()));
			}
			if (gc.getLevel() == 1) {
				goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(gc.getParentId()));
			}
			/*List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());
			mv.addObject("gbs", gbs);*/
			List<GoodsBrand> gbs = this.goodsBrandService.findAll();
			mv.addObject("gbs", gbs);
			// mv.addObject("imageSuffix", this.storeViewTools
			// .genericImageSuffix(this.configService.getSysConfig()
			// .getImageSuffix()));
			// 查询商品版式信息
			List<GoodsFormat> gfs = this.goodsFormatService.findByGFCat(GoodsConstants.GOODS_FORMAT_SELF);
			mv.addObject("gfs", gfs);
			// 查询地址信息，前端需要商家选择发货地址
			List<Area> areas = this.areaService.getAllParentIsNull();
			mv.addObject("areas", areas);
			String goods_session = CommUtil.randomString(32);
			mv.addObject("goods_session", goods_session);
			request.getSession(false).setAttribute("goods_session", goods_session);
			// 处理上传格式
			String[] strs = this.configService.getSysConfig().getImageSuffix().split("\\|");
			StringBuffer sb = new StringBuffer();
			for (String str : strs) {
				sb.append("." + str + ",");
			}
			mv.addObject("imageSuffix1", sb);

		}
		return mv;
	}

	@SecurityMapping(title = "产品规格显示", value = "/admin/goods_inventory.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_inventory.htm")
	public ModelAndView goods_inventory(HttpServletRequest request, HttpServletResponse response,
			String goods_spec_ids) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_inventory.html", configService.getSysConfig(),
				0, request, response);
		String[] spec_ids = goods_spec_ids.split(",");

		List<GoodsSpecificationBO> specs = specPropertyService.getSpecificationByIds(spec_ids);
		List<List<GoodsSpecPropertyBO>> gsp_list = specPropertyService.genericSpecProperty(specs);
		mv.addObject("specs", specs);
		mv.addObject("gsps", gsp_list);
		return mv;
	}

	@SecurityMapping(title = "运费模板显示", value = "/admin/goods_transport.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_transport.htm")
	public ModelAndView goods_transport(HttpServletRequest request, HttpServletResponse response,
			MyPage<TransportBO> page, String ajax) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_transport.html", configService.getSysConfig(),
				0, request, response);
		if (CommUtil.null2Boolean(ajax)) {
			mv = new JModelAndView("admin/blue/goods_transport_list.html", configService.getSysConfig(), 0,
					request, response);
		}
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(1);
		transportService.list(page, GoodsConstants.TRANSPORT_TYPE_SELF);

		String params = "";

		CommUtil.saveIPageList2ModelAndView(url + "/admin/goods_transport.htm", "", params, page, mv);
		mv.addObject("transportTools", transportTools);
		return mv;
	}

	/**
	 * 
	 * 商品发布第三步
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品发布第三步", value = "/admin/add_goods_finish.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/add_goods_finish.htm")
	public ModelAndView add_goods_finish(HttpServletRequest request, HttpServletResponse response,
			GoodsBO goods, String goodsIndexPhotoPath) {
		System.out.println("current url:"+goodsIndexPhotoPath);
		if (goodsIndexPhotoPath.equals("") && goodsIndexPhotoPath.equals(null)) {
			goods.setGoodsIndexPhotoPath(goodsIndexPhotoPath);
		}
		ModelAndView mv = null;
		Long userId = SecurityUserHolder.getCurrentUser().getId();
		String goods_session1 = CommUtil.null2String(request.getSession(false).getAttribute("goods_session"));
		boolean isEdit = false;
		if (goods.getId() != null) {
			isEdit = true;
		}
		System.out.println("goods_session1:"+goods_session1);
		if (goods_session1.equals("")) {
			mv = new JModelAndView("error.html", configService.getSysConfig(), 1, request, response);
			mv.addObject("op_title", "禁止重复提交表单");
			mv.addObject("url", CommUtil.getURL(request) + "/admin/add_goods_first.htm");
		} else {
			if (goods.getId() == null) {
				mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", "商品发布成功");
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/add_goods_first.htm");
			} else {
				mv = new JModelAndView("admin/blue/success.html", configService.getSysConfig(), 0, request,
						response);
				mv.addObject("op_title", "商品编辑成功");
				mv.addObject("list_url", CommUtil.getURL(request) + "/admin/goods_self_list.htm?goodsId="
						+ goods.getId());
			}
			if (goods.getId() == null) {
				if (goods.getSelfAddPrice() == null)
					goods.setSelfAddPrice(BigDecimal.ZERO);
				if (goods.getStorePrice() == null)
					goods.setStorePrice(BigDecimal.ZERO);
				if (goods.getGoodsPrice() == null)
					goods.setGoodsPrice(BigDecimal.ZERO);
				if (goods.getNeedYgb() == null)
					goods.setNeedYgb(BigDecimal.ZERO);
				if (goods.getNeedMoney() == null)
					goods.setNeedMoney(BigDecimal.ZERO);
				if (goods.getCnSelfAddPrice() == null)
					goods.setCnSelfAddPrice(BigDecimal.ZERO);
			}
			if (!GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
				if (goods.getNeedYgb() != null && goods.getNeedYgb().compareTo(BigDecimal.ZERO) > 0) {
					goods.setExPriceFlag(1);
				} else {
					goods.setExPriceFlag(0);
				}
			}

			goods.setGoodsCurrentPrice(goods.getStorePrice());
			goods.setStorePrice(goods.getStorePrice());
			goods.setGoodsPrice(goods.getGoodsPrice());

			/*if(GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())){
				goods.getGoodsInventoryDetail()
			}*/

			// 是否有手机专享价
			if (!goods.getHasMobilePrice()) {
				goods.setGoodsMobilePrice(BigDecimal.ZERO);
			}
			/*	//是否有积分专享价
				if(!goods.getHasExchangeIntegral()){
					goods.setGoodsIntegralPrice(BigDecimal.ZERO);
				}*/

			this.goodsService.save(goods, userId);

			// 生成二维码
			// goodsTools.createGoodsQRAsync(request,
			// String.valueOf(goods.getId()), goods.getGoodsMainPhotoPath(),
			// CommUtil.getURL(request) + "/goods_" + goods.getId() + ".htm");
			if (!isEdit) {
				if ("0".equals(CommUtil.null2String(goods.getGoodsStatus()))) {
					LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
					SysConfig config = this.configService.getSysConfig();
					LuceneUtil.setLucenenQueue(config.getLucenenQueue());
					luceneUtil.writeIndex(vo);
				}
			} else {
				if ("0".equals(CommUtil.null2String(goods.getCurrentStatus()))
						&& "0".equals(CommUtil.null2String(goods.getGoodsStatus()))) {// 发布后直接上架
					LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
					luceneUtil.update(CommUtil.null2String(goods.getId()), vo);
				}
				if ("0".equals(CommUtil.null2String(goods.getCurrentStatus()))
						&& ("1".equals(CommUtil.null2String(goods.getGoodsStatus())) || "2".equals(CommUtil.null2String(goods.getGoodsStatus())))) {// 发布后在仓库中
					luceneUtil.delete_index(GoodsDocument.class, String.valueOf(goods.getId()));
				}
				if (("1".equals(CommUtil.null2String(goods.getCurrentStatus())) || "2".equals(CommUtil.null2String(goods.getCurrentStatus())))
						&& "0".equals(goods.getGoodsStatus())) {// 在仓库中发布后上架
					// 添加lucene索引
					LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
					luceneUtil.writeIndex(vo);
				}
			}
			mv.addObject("obj", goods);
			request.getSession(false).removeAttribute("goods_session");
		}
		return mv;
	}

	@SecurityMapping(title = "商品图片上传", value = "/admin/swf_upload.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/swf_upload.htm")
	public void swf_upload(HttpServletRequest request, HttpServletResponse response, String album_id,
			String session_u_id) {
		accessoryService.accessoryImgSave(request, "imgFile", album_id);
	}

	@SecurityMapping(title = "商品图片删除", value = "/admin/goods_image_del.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_image_del.htm")
	public void goods_image_del(HttpServletRequest request, HttpServletResponse response, Long image_id,
			Long goodsId) {
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			Map<String, Boolean> map = new HashMap<String, Boolean>();
			Accessory img = this.accessoryService.getObjById(CommUtil.null2Long(image_id));
			boolean ret = false;
			if (img != null) {
				goodsService.deleteByPhotoIdAndGoodsId(image_id, goodsId);
				ret = true;
			}
			map.put("result", ret);
			writer = response.getWriter();
			writer.print(Json.toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 自营商品列表
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "自营商品列表", value = "/admin/goods_self_list.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_list.htm")
	public ModelAndView goods_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBO> page, GoodsVO vo, String timeIndex) {

		ModelAndView mv = new JModelAndView("admin/blue/goods_self_list.html", configService.getSysConfig(),
				0, request, response);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		if (vo != null && StringUtils.isNotBlank(vo.getTimeIndex())) {
			if (vo.getTimeIndex().equals("3")) {// 一周
				vo.setStartTime(sdf.format(vc.thinker.b2b2c.util.DateUtils.getSundayOfWeek(new Date())));
				vo.setEndTime(sdf.format(vc.thinker.b2b2c.util.DateUtils.getMondayOfWeek(new Date())));
			} else if (vo.getTimeIndex().equals("4")) {
				vo.setStartTime(sdf.format(vc.thinker.b2b2c.util.DateUtils.getFirstDateOfMonth(new Date())));
				vo.setEndTime(sdf.format(vc.thinker.b2b2c.util.DateUtils.getLastDateOfMonth(new Date())));
			} else if (vo.getTimeIndex().equals("5")) {
				vo.setStartTime(vo.getStartTime());
				vo.setEndTime(vo.getEndTime());
			}
		}
		if (vo.getGoodsStatus() == null) {
			vo.setGoodsStatus(GoodsConstants.GOODS_STATUS_SELLING);
		} else if (GoodsConstants.GOODS_STATUS_STORE.equals(vo.getGoodsStatus())) {
			mv = new JModelAndView("admin/blue/goods_self_storage.html", configService.getSysConfig(), 0,
					request, response);
		} else if (GoodsConstants.GOODS_STATUS_ILLEGAL_DOWN.equals(vo.getGoodsStatus())) {
			mv = new JModelAndView("admin/blue/goods_self_outline.html", configService.getSysConfig(), 0,
					request, response);
		}
		vo.setGoodsType(GoodsConstants.GOODS_TYPE_SELF);
		System.out.println(vo.getGoodsBrandId());
		if(vo.getGoodsBrandId()!=null){
		String bname =  goodsClassService.findBnameById(vo.getGoodsBrandId());
		mv.addObject("bname", bname);
		}
		
		 goodsClassService.GoodsClassMv(page, vo, mv);
		// List<ManagerBO> user_admins = this.managerService.selectManageByVO(null);
		// mv.addObject("user_admins", user_admins);
		// 查询0元购是否已经开启

		List<ActivityHotSaleBO> actList = saleActivityService.findAll();
		boolean zero = false;
		if (actList != null) {
			for (ActivityHotSaleBO bo : actList) {
				if (bo.getVcode().equals(ActAppHotSaleContant.act_vecode_4)) {
					zero = true;
				}
			}
		}
		mv.addObject("zero", zero);

		return mv;
	}

	@SuppressWarnings({"unused", "rawtypes", "unchecked"})
	@SecurityMapping(title = "商品编辑", value = "/admin/goods_self_edit.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_edit.htm")
	public ModelAndView goods_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("admin/blue/add_goods_second.html", configService.getSysConfig(),
				0, request, response);

		// 根据id查找商品信息
		GoodsBO obj = this.goodsService.getFullGoodsById(Long.parseLong(id));
		if (obj.getSelfAddPrice() == null)
			obj.setSelfAddPrice(BigDecimal.ZERO);
		if (obj.getStorePrice() == null)
			obj.setStorePrice(BigDecimal.ZERO);
		if (obj.getGoodsPrice() == null)
			obj.setGoodsPrice(BigDecimal.ZERO);

		// AccessoryQueryObject aqo = new AccessoryQueryObject();
		// aqo.setPageSize(8);
		// aqo.addQuery("obj.user.userRole", new SysMap("user_role", "admin"),
		// "=");
		// aqo.setOrderBy("addTime");
		// aqo.setOrderType("desc");
		// IPageList pList = this.accessoryService.list(aqo);
		// String photo_url = CommUtil.getURL(request) +
		// "/admin/goods_img_album.htm";
		// mv.addObject("photos", pList.getResult());
		// mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(photo_url,
		// "", pList.getCurrentPage(), pList.getPages()));
		mv.addObject("edit", true);
		mv.addObject("img_remain_size", 100000);
		mv.addObject("obj", obj);
		if("1".equals(request.getParameter("iret"))){  
			request.getSession(false).setAttribute("goods_class_info",null); 
		}
		if (request.getSession(false).getAttribute("goods_class_info") != null) {
			GoodsClass session_gc = (GoodsClass) request.getSession(false).getAttribute("goods_class_info");
			GoodsClass gc = this.goodsClassService.getObjById(session_gc.getId());
			if (gc != null) {
				String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
				mv.addObject("goods_class", this.goodsClassService.getBOAndTpyePropertyById(gc.getId()));
				mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));

				GoodsClassBO goods_class = null;
				if (gc.getLevel() == 2) {
					DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
							String.valueOf(gc.getId()));
					goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
							dicClass.getParentCode());
				}
				if (gc.getLevel() == 1) {
					goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
							String.valueOf(gc.getId()));
				}
				if (gc.getLevel() == 2) {// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
					List<GoodsSpecification> goodsSpecList = goodsSpecificationService
							.findByType(GoodsConstants.GOODS_SPECI_SELF);
					List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
							.findSpecProperty(goodsSpecList);
					goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO, gc.getId());
					mv.addObject("goods_spec_list", goodsSpecListBO);
				} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
					List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByTypeAndClassId(
							GoodsConstants.GOODS_SPECI_SELF, gc.getId());
					List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
							.findSpecProperty(goodsSpecList);
					mv.addObject("goods_spec_list", goodsSpecListBO);
				}
			}
			/*List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());*/
			List<GoodsBrand> gbs = this.goodsBrandService.findAll();
			mv.addObject("gbs", gbs);
			request.getSession(false).removeAttribute("goods_class_info");
		} else {
			if (obj != null && obj.getGcId() != null) {
				GoodsClassBO gc = this.goodsClassService.getBOAndTpyePropertyById(obj.getGcId());
				if (gc != null) {
					String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
					mv.addObject("goods_class", gc);
					mv.addObject("goods_class_info",
							goods_class_info.substring(0, goods_class_info.length() - 1));

					if (gc.getLevel() == 2) {//
						// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
						List<GoodsSpecification> goodsSpecList = goodsSpecificationService
								.findByType(GoodsConstants.GOODS_SPECI_SELF);
						List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
								.findSpecProperty(goodsSpecList);
						goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO,
								gc.getId());
						mv.addObject("goods_spec_list", goodsSpecListBO);
					} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
						List<GoodsSpecification> goodsSpecList = goodsSpecificationService
								.findByTypeAndClassId(GoodsConstants.GOODS_SPECI_SELF, gc.getId());
						List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
								.findSpecProperty(goodsSpecList);
						mv.addObject("goods_spec_list", goodsSpecListBO);
					}
					GoodsClassBO goods_class = null;
					if (gc.getLevel() == 2) {
						DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
								String.valueOf(gc.getId()));
						goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
								dicClass.getParentCode());
					}
					if (gc.getLevel() == 1) {
						goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
								String.valueOf(gc.getId()));
					}
				}
				/*List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());*/
				List<GoodsBrand> gbs = this.goodsBrandService.findAll();
				mv.addObject("gbs", gbs);

				// 查询商品版式信息
				List<GoodsFormat> gfs = this.goodsFormatService.findByGFCat(GoodsConstants.GOODS_FORMAT_SELF);
				mv.addObject("gfs", gfs);
				// 查询地址信息，前端需要商家选择发货地址
				List<Area> areas = this.areaService.getAllParentIsNull();
				mv.addObject("areas", areas);
			}
		}
		List goodsOldSpecProperty = new ArrayList();
		List<GoodsSpec> goodsSpec = this.goodsService.selectGoodsSpecIdList(obj.getId());//查询产品增加时的规格
		List goodsOldSpecProperty1 = new ArrayList();
		List goodsOldSpecProperty2 = new ArrayList();
		for (int i = 0; i < goodsSpec.size(); i++) {
			Map map =  new HashMap();
			List<GoodsSpecProperty> boList = this.goodsSpecPropertyService.getPropertyByGoodsIdAndSpec(obj.getId(), CommUtil.null2Long(goodsSpec.get(i).getSpecificationId()));
			if (null != boList && boList.size() > 0) {
				
				if (boList.get(0).getSpecImageId() != null) {
					map.put("specInfo", goodsSpec.get(i));
					map.put("propertyInfo", boList);
					goodsOldSpecProperty1.add(map);
					
				} else {
					map.put("specInfo", goodsSpec.get(i));
					map.put("propertyInfo", boList);
					goodsOldSpecProperty2.add(map);
				}
			}
		}
		mv.addObject("goodsOldSpecProperty1", goodsOldSpecProperty1);
		mv.addObject("goodsOldSpecProperty2", goodsOldSpecProperty2);
		
		String goods_session = CommUtil.randomString(32);
		mv.addObject("goods_session", goods_session);
		request.getSession(false).setAttribute("goods_session", goods_session);
		String[] strs = this.configService.getSysConfig().getImageSuffix().split("\\|");
		StringBuffer sb = new StringBuffer();
		for (String str : strs) {
			sb.append("." + str + ",");
		}
		mv.addObject("imageSuffix1", sb);
		mv.addObject("jsessionid", request.getSession().getId());
		mv.addObject("keyWordType", this.physicalService.selectKeyWordTypeList());// 关键字类型 -lkn
		return mv;
	}

	@SecurityMapping(title = "商品上下架", value = "/admin/goods_self_sale.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_sale.htm")
	public String goods_sale(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String status = "0";
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("") && StringUtils.isNumeric(id)) {
				Goods goods = this.goodsService.getObjById(Long.parseLong(id));
				int goodsStatus = goods.getGoodsStatus() == 0 ? 1 : 0;
				goods.setGoodsStatus(goodsStatus);
				this.goodsService.update(goods);
				if (goodsStatus == 0) {
					status = "1";
					// 添加lucene索引
					try {
						LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
						luceneUtil.update(CommUtil.null2String(goods.getId()), vo);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					// 删除lucene索引
					try {
						luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(goods.getId()));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "redirect:" + "/admin/goods_self_list.htm?goods_status=" + status;
	}

	@SecurityMapping(title = "商品批量移分类", value = "/admin/goods_move_class.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_move_class.htm")
	public String goods_move_class(HttpServletRequest request, HttpServletResponse response, String mulitId,
			Long gcId) {
		String status = "0";
		String[] ids = mulitId.split(",");
		if (gcId != null && gcId > 0) {
			for (String id : ids) {
				if (!id.equals("") && StringUtils.isNumeric(id)) {
					Goods goods = this.goodsService.getObjById(Long.parseLong(id));
					goods.setGcId(gcId);
					this.goodsService.update(goods);
					// 更新索引
					try {
						LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
						luceneUtil.update(CommUtil.null2String(goods.getId()), vo);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return "redirect:" + "/admin/goods_self_list.htm?goods_status=" + status;
	}

	/**
	 * 商品发布第一步
	 * 
	 * @param currentPage
	 * @param orderBy
	 * @param orderType
	 * @param request
	 * @return
	 */
	@SecurityMapping(title = "商品批量移分类-分类显示", value = "/admin/goods_types.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_types.htm")
	public ModelAndView goods_types(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_types.html", configService.getSysConfig(), 0, request,
				response);
		request.getSession(false).removeAttribute("goods_class_info");
		List<GoodsClassBO> goodsClass = this.goodsClassService.findAllParents();
		mv.addObject("goodsClass", goodsClass);
		mv.addObject("mulitId", mulitId);
		return mv;
	}

	@SecurityMapping(title = "商品删除", value = "/admin/goods_self_del.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_del.htm")
	public String goods_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String op) {
		int status = 0;
		if (CommUtil.null2String(op).equals("storage")) {
			status = 1;
		}
		if (CommUtil.null2String(op).equals("out")) {
			status = -2;
		}
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				// Map map = new HashMap();
				// map.put("gid", goods.getId());
				// List<GoodsCart> goodCarts = this.goodsCartService
				// .query("select obj from GoodsCart obj where obj.goods.id =
				// :gid", map, -1, -1);
				// Long ofid = null;
				// List<Evaluate> evaluates = goods.getEvaluates();
				// for (Evaluate e : evaluates) {
				// this.evaluateService.delete(e.getId());
				// }
				// goods.getGoods_ugcs().clear();
				// goods.getGoods_ugcs().clear();
				// goods.getGoodsPhotos().clear();
				// goods.getGoodsUgcs().clear();
				// goods.getGoodsSpecs.clear();
				// for (GoodsCart gc : goods.getCarts()) {
				// gc.getGsps().clear();
				// this.goodsCartService.delete(gc.getId());
				// }
				this.goodsService.delete(CommUtil.null2Long(id));
				// 删除索引
				luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
			}
		}
		return "redirect:/admin/goods_self_list.htm?goods_status=" + status;
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品AJAX更新", value = "/admin/goods_self_ajax.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_ajax.htm")
	public void goods_self_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value, String sortWeight) throws ClassNotFoundException {
		Goods obj = this.goodsService.getObjById(Long.parseLong(id));
		Field[] fields = Goods.class.getDeclaredFields();
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
		if (fieldName.equals("store_recommend")) {
			if (obj.getStoreRecommend() != null && obj.getStoreRecommend()) {
				obj.setStoreRecommendTime(new Date());
			} else
				obj.setStoreRecommendTime(null);
		}
		if (StringUtils.isNotBlank(sortWeight)) {
			obj.setSortWeight(CommUtil.null2Int(sortWeight));
		}
		this.goodsService.update(obj);
		if (obj.getGoodsStatus() == 0) {
			// 更新lucene索引
			LuceneVo vo = this.luceneVoTools.updateGoodsIndex(obj);
			luceneUtil.update(CommUtil.null2String(obj.getId()), vo);
		} else {
			luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
		}
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

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品权重AJAX更新", value = "/admin/goods_self_weight_ajax.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_weight_ajax.htm")
	public void goods_self_weight_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value, String sortWeight) throws ClassNotFoundException {
		Goods obj = this.goodsService.getObjById(Long.parseLong(id));
		Field[] fields = Goods.class.getDeclaredFields();
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
		if (fieldName.equals("store_recommend")) {
			if (obj.getStoreRecommend() != null && obj.getStoreRecommend()) {
				obj.setStoreRecommendTime(new Date());
			} else
				obj.setStoreRecommendTime(null);
		}
		if (StringUtils.isNotBlank(sortWeight)) {
			obj.setSortWeight(CommUtil.null2Int(sortWeight));
		}
		this.goodsService.update(obj);
		if (obj.getGoodsStatus() == 0) {
			// 更新lucene索引
			LuceneVo vo = this.luceneVoTools.updateGoodsIndex(obj);
			luceneUtil.update(CommUtil.null2String(obj.getId()), vo);
		} else {
			luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
		}
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

	@SecurityMapping(title = "商品相册列表", value = "/admin/goods_album.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_album.htm")
	public ModelAndView goods_album(HttpServletRequest request, HttpServletResponse response,
			MyPage<AlbumBO> page, String ajax_type) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_album.html", configService.getSysConfig(), 0,
				request, response);
		page.setPageSize(5);
		albumService.list(SecurityUserHolder.getCurrentUser().getId(), page);

		String album_url = CommUtil.getURL(request) + "/admin/goods_album.htm";
		mv.addObject("albums", page.getResult());
		mv.addObject(
				"gotoPageAjaxHTML",
				CommUtil.showPageAjaxHtml(album_url, "", page.getCurrentPage(), page.getPages(),
						page.getPageSize(), page.getRowCount()));
		mv.addObject("ajax_type", ajax_type);
		mv.addObject("ImageTools", ImageTools);
		return mv;
	}

	@SecurityMapping(title = "商品图片列表", value = "/admin/goods_img.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_img.htm")
	public ModelAndView goods_img(HttpServletRequest request, MyPage<AccessoryBO> page,
			HttpServletResponse response, String currentPage, String type, Long album_id) {
		ModelAndView mv = new JModelAndView("admin/blue/" + type + ".html", configService.getSysConfig(), 0,
				request, response);

		accessoryService.queryAccessoriesById(album_id, page);
		String photo_url = CommUtil.getURL(request) + "/admin/goods_img.htm";
		mv.addObject("photos", page.getResult());
		mv.addObject(
				"gotoPageAjaxHTML",
				CommUtil.showPageAjaxHtml(photo_url, "", page.getCurrentPage(), page.getPages(),
						page.getPageSize(), page.getRowCount()));
		mv.addObject("album_id", album_id);
		return mv;
	}

	// @SecurityMapping(title = "商品二维码生成", value = "/admin/goods_self_qr.htm*",
	// rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup =
	// "商城管理")
	// @RequestMapping("/admin/goods_self_qr.htm")
	// public String goods_self_qr(HttpServletRequest request,
	// HttpServletResponse response, String mulitId, String currentPage)
	// throws ClassNotFoundException {
	// String ids[] = mulitId.split(",");
	// for (String id : ids) {
	// if (id != null) {
	// Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
	// if (obj.getGoodsType() == 0) {// 只能操作自营商品
	// String imgPath = goodsTools.createGoodsQRSync(request, id,
	// obj.getGoodsMainPhotoPath(), CommUtil.getURL(request) + "/goods_" + id +
	// ".htm");
	// Goods updateGoods = new Goods();
	// updateGoods.setId(obj.getId());
	// updateGoods.setQrImgPath(imgPath);
	// goodsService.update(updateGoods);
	// }
	// }
	// }
	// return "redirect:goods_self_list.htm?currentPage=" + currentPage;
	// }

	@SuppressWarnings("unused")
	@SecurityMapping(title = "商品二维码Excel生成并下载", value = "/admin/goods_self_f_code_download.htm*", rtype = "admin", rname = "商品发布", rcode = "goods_self_add", rgroup = "商城管理")
	@RequestMapping("/admin/goods_self_f_code_download.htm")
	public void goods_self_f_code_download(HttpServletRequest request, HttpServletResponse response, String id)
			throws IOException {
		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
		String excel_url = "";
		// if (obj.getF_sale_type() == 1 && obj.getGoods_type() == 0
		// && !CommUtil.null2String(obj.getGoods_f_code()).equals("")) {
		// List<Map> list = Json.fromJson(List.class, obj.getGoods_f_code());
		// String name = CommUtil.null2String(UUID.randomUUID());
		// String path = request.getSession().getServletContext()
		// .getRealPath("/")
		// + File.separator + "excel" + File.separator + name + ".xls";
		// FileOutputStream out = new FileOutputStream(new File(path));
		// this.exportList2Excel("F码列表", new String[] { "F码信息", "F码状态" },
		// list, out);
		// excel_url = CommUtil.getURL(request) + "/excel/" + name + ".xls";
		// }

		response.sendRedirect(excel_url);
	}

	@SuppressWarnings({"rawtypes", "unused"})
	private static boolean exportList2Excel(String title, String[] headers, List<Map> list, OutputStream out) {
		boolean ret = true;
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet(title);
		// 设置表格默认宽度为15个字节
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);

		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints((short) 14);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		// 把字体应用到当前的样式
		style.setFont(font);

		// 生成并设置另一个样式
		HSSFCellStyle style_ = workbook.createCellStyle();
		style_.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style_.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style_.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style_.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style_.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style_.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style_.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style_.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font_ = workbook.createFont();
		// font.setColor(color);
		font_.setFontHeightInPoints((short) 14);
		// font_.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		style_.setFont(font_);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			cell.setCellValue(new HSSFRichTextString(headers[i]));
		}
		// 遍历集合数据，产生数据行
		int index = 0;
		for (Map map : list) {
			index++;
			row = sheet.createRow(index);
			String value = CommUtil.null2String(map.get("code"));
			HSSFCell cell = row.createCell(0);
			cell.setCellStyle(style_);
			cell.setCellValue(value);
			value = CommUtil.null2Int(map.get("status")) == 0 ? "未使用" : "已使用";
			cell = row.createCell(1);
			cell.setCellStyle(style_);
			cell.setCellValue(value);
		}
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (Exception e) {
			ret = false;
			e.printStackTrace();
		}
		return ret;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@SecurityMapping(title = "0元购商品列表", value = "/admin/zero_act/goods_zero_act_list.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_list.htm")
	public ModelAndView goodsZeroActList(HttpServletRequest request, HttpServletResponse response,
			ZeroGoodsVO vo, MyPage<ZeroGoodsBO> page, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/zero_act/goods_zero_act_list.html",
				configService.getSysConfig(), 0, request, response);
		zeroGoodsService.findPageByVo(vo, page);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		return mv;
	}

	@SecurityMapping(title = "商品推到0元购", value = "/admin/zero_act/goods_zero_act_add.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_add.htm")
	public String goodsZeroActAdd(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		// 0元购开启才可以加入列表
		if (saleActivityService.findTopByCode(ActAppHotSaleContant.act_vecode_4) != null) {
			String[] ids = mulitId.split(",");
			for (String id : ids) {
				if (!id.equals("")) {
					Long goodsId = CommUtil.null2Long(id);
					ZeroGoods zeroGoods = zeroGoodsService.getByGoodsId(goodsId);
					if (zeroGoods == null) {
						zeroGoodsService.addGoodstoZeroGoods(goodsId);
					}
				}
			}
		}
		return "redirect:/admin/goods_self_list.htm?";
	}

	@SecurityMapping(title = "删除0元购商品", value = "/admin/zero_act/goods_zero_act_delete.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_delete.htm")
	public String goodsZeroActDelete(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				ZeroGoods zeroGoods = zeroGoodsService.findById(CommUtil.null2Long(id));
				if (zeroGoods != null) {
					Long goodsId = zeroGoods.getGoodsId();
					zeroGoodsService.removeZeroGoods(CommUtil.null2Long(goodsId));
				}
			}
		}
		// 0元购开启才可以加入列表
		return "redirect:/admin/zero_act/goods_zero_act_list.htm";
	}

	@SecurityMapping(title = "0元购商品下架", value = "/admin/zero_act/goods_zero_act_change_status.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_change_status.htm")
	public String goodsZeroActChangeStatus(HttpServletRequest request, HttpServletResponse response,
			String mulitId, int status) {
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				ZeroGoods zeroGoods = zeroGoodsService.findById(CommUtil.null2Long(id));
				if (zeroGoods != null) {
					Long goodsId = zeroGoods.getGoodsId();
					ZeroGoods record = zeroGoodsService.getByGoodsId(goodsId);
					zeroGoodsService.updateZeroGoodsStatus(record, status);
				}
			}
		}
		// 0元购开启才可以加入列表
		return "redirect:/admin/zero_act/goods_zero_act_list.htm";
	}

	@SecurityMapping(title = "编辑0元购商品", value = "/admin/zero_act/goods_zero_act_update.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_update.htm")
	public ModelAndView goodsZeroActUpdate(HttpServletRequest request, HttpServletResponse response,
			String id, String currentPage) {
		ModelAndView mv = new JModelAndView("admin/blue/zero_act/" + "goods_zero_act_update" + ".html",
				configService.getSysConfig(), 0, request, response);
		Long goodsId = CommUtil.null2Long(id);
		ZeroGoods zeroGoods = zeroGoodsService.getByGoodsId(goodsId);
		mv.addObject("zeroGoods", zeroGoods);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "保存编辑0元购商品", value = "/admin/zero_act/goods_zero_act_save.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_save.htm")
	public String goodsZeroActSave(HttpServletRequest request, HttpServletResponse response,
			ZeroGoods zeroGoods) {
		// 0元购开启才可以加入列表
		if (saleActivityService.findTopByCode(ActAppHotSaleContant.act_vecode_4) != null) {
			zeroGoodsService.updateZeroGoods(zeroGoods);
		}
		return "redirect:/admin/zero_act/goods_zero_act_list.htm";
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "0元购商品AJAX更新", value = "/admin/zero_act/goods_zero_act_ajax.htm*", rtype = "admin", rname = "商品管理", rcode = "goods_self", rgroup = "商城管理")
	@RequestMapping("/admin/zero_act/goods_zero_act_ajax.htm")
	public void goods_zero_act_ajax(HttpServletRequest request, HttpServletResponse response, String goodsId,
			String fieldName, String value, String sortWeight) throws ClassNotFoundException {
		ZeroGoods obj = this.zeroGoodsService.getByGoodsId(Long.parseLong(goodsId));
		if (CommUtil.isNotNull(value)) {
			obj.setGoodsName(value);
		}
		Field[] fields = Goods.class.getDeclaredFields();
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
		this.zeroGoodsService.updateZeroGoods(obj);
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