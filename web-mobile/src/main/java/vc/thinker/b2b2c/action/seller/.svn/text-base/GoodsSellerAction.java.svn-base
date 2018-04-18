package vc.thinker.b2b2c.action.seller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vc.thinker.b2b2c.core.annotation.SecurityMapping;
import vc.thinker.b2b2c.core.mv.JModelAndView;
import vc.thinker.b2b2c.core.security.support.CustomerUserDetails;
import vc.thinker.b2b2c.core.security.support.SecurityUserHolder;
import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.core.tools.database.DatabaseTools;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.LuceneVo;

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsBrandBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsClass;
import com.sinco.carnation.goods.model.GoodsFormat;
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
import com.sinco.carnation.goods.tools.GoodsTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.operation.service.ZTCGoldLogService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.service.ComplaintGoodsService;
import com.sinco.carnation.shop.service.ComplaintService;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.service.StoreGradeService;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.store.tools.StoreViewTools;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.AreaServiceImpl;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.transport.service.TransportService;
import com.sinco.carnation.transport.tools.TransportTools;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.tools.ImageTools;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicContent;
import com.sinco.dic.client.model.DicParentBase;

/**
 * 
 * <p>
 * Title: GoodsSellerAction.java
 * </p>
 * 
 * <p>
 * Description:商家后台商品管理控制器
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
 * @date 2014-5-7
 * 
 * @version 1.0.1
 */
@Controller
@SuppressWarnings({"unchecked", "rawtypes"})
public class GoodsSellerAction {
	@Autowired
	private SysConfigService configService;
	@Autowired
	private GoodsClassService goodsClassService;
	@Autowired
	private AccessoryServiceImpl accessoryService;
	@Autowired
	private UserGoodsClassService userGoodsClassService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private GoodsBrandService goodsBrandService;
	@Autowired
	private GoodsSpecPropertyService specPropertyService;
	@Autowired
	private GoodsTypePropertyService goodsTypePropertyService;
	@Autowired
	private WaterMarkService waterMarkService;
	@Autowired
	private GoodsCartService goodsCartService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private OrderFormLogService orderFormLogService;
	@Autowired
	private EvaluateService evaluateService;
	@Autowired
	private TransportService transportService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private AreaServiceImpl areaService;
	@Autowired
	private TransportTools transportTools;
	@Autowired
	private StoreTools storeTools;
	@Autowired
	private StoreViewTools storeViewTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private DatabaseTools databaseTools;
	@Autowired
	private GoodsSpecificationService goodsSpecificationService;
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private ComplaintGoodsService complaintGoodsService;
	@Autowired
	private LuceneVoTools luceneVoTools;
//	@Autowired
//	private GroupGoodsService groupGoodsService;
	@Autowired
	private GoodsFormatService goodsFormatService;
	@Autowired
	private ZTCGoldLogService iztcGoldLogService;
	@Autowired
	private GoodsCartService cartService;
	@Autowired
	private GoodsTools goodsTools;
	@Autowired
	private ImageTools ImageTools;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private StoreGradeService storeGradeService;
	@Autowired
	private DicContent dicContent;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;

	@SecurityMapping(title = "发布商品第一步", value = "/seller/add_goods_first.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/add_goods_first.htm")
	public ModelAndView add_goods_first(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		request.getSession(false).removeAttribute("goods_class_info");
		Long storeId = userDetails.getSeller().getStoreId();
		StoreBO store = storeService.getObjById(storeId);
		int store_status = (store == null ? 0 : store.getStoreStatus());
		if (store_status == 15) {
//			StoreGrade grade = storeGradeService.getObjById(store.getGradeId());
//			int user_goods_count = goodsService.findGoodsCountByStoreId(store.getId());
//			if (grade.getGoodsCount() == 0 || user_goods_count < grade.getGoodsCount()) {
//				if (grade.getGoodsCount() == 0) {
			mv = new JModelAndView("user/default/sellercenter/add_goods_first.html",
					configService.getSysConfig(), 0, request, response);
//				String json_staples = "";
//				if (userDetails.getSeller().getStapleGc() != null && !userDetails.getSeller().getStapleGc().equals("")) {
//					json_staples = userDetails.getSeller().getStapleGc();
//				}
//				List<Map> staples = Json.fromJson(List.class, json_staples);
//				mv.addObject("staples", staples);
			if (store.getGcDetailInfo() != null) {// 店铺详细类目
				List<GoodsClass> gcs = this.storeTools.query_store_detail_MainGc(store.getGcDetailInfo());
				mv.addObject("gcs", gcs);
			} else {
				List<GoodsClassBO> list = dicContent.getDicsConvertByParentCode(GoodsClassBO.class,
						CommUtil.null2String(store.getGcMainId()));
				mv.addObject("gcs", list);
			}
			mv.addObject("id", CommUtil.null2String(id));
//			} else {
//				mv.addObject("op_title", "您的店铺等级只允许上传" + grade.getGoodsCount() + "件商品!");
//				mv.addObject("url", CommUtil.getURL(request) + "/seller/store_grade.htm");
//			}
		}
		if (store_status == 0) {
			mv.addObject("op_title", "您尚未开通店铺，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else if (store_status == 10) {
			mv.addObject("op_title", "您的店铺在审核中，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		} else if (store_status == 20) {
			mv.addObject("op_title", "您的店铺已被关闭，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
//		else {
//			mv.addObject("op_title", "店铺信息错误，不能发布商品");
//			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
//		}
		return mv;
	}

	@SecurityMapping(title = "商品运费模板分页显示", value = "/seller/goods_transport.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_transport.htm")
	public ModelAndView goods_transport(HttpServletRequest request, HttpServletResponse response,
			MyPage<TransportBO> page, String ajax) {

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_transport.html",
				configService.getSysConfig(), 0, request, response);
		if (CommUtil.null2Boolean(ajax)) {
			mv = new JModelAndView("user/default/sellercenter/goods_transport_list.html",
					configService.getSysConfig(), 0, request, response);
		}
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		page.setPageSize(1);
		transportService.list(page, userDetails.getStoreId());

		String params = "";

		CommUtil.saveIPageList2ModelAndView(url + "/seller/goods_transport.htm", "", params, page, mv);
		mv.addObject("transportTools", transportTools);

		return mv;
	}

	@SuppressWarnings("deprecation")
	@SecurityMapping(title = "发布商品第二步", value = "/seller/add_goods_second.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/add_goods_second.htm")
	public ModelAndView add_goods_second(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/seller_error.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
//		request.getSession(false).removeAttribute("goods_class_info");
		Long storeId = userDetails.getSeller().getStoreId();
		StoreBO store = storeService.getObjById(storeId);
		int store_status = store.getStoreStatus();

		if (store_status == 15) {
			if (request.getSession(false).getAttribute("goods_class_info") != null) {
				mv = new JModelAndView("user/default/sellercenter/add_goods_second.html",
						configService.getSysConfig(), 0, request, response);
				GoodsClass gc = (GoodsClass) request.getSession(false).getAttribute("goods_class_info");
				gc = this.goodsClassService.getObjById(gc.getId());
				String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
				mv.addObject("goods_class", this.goodsClassService.getBOAndTpyePropertyById(gc.getId()));
				mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));
				request.getSession(false).removeAttribute("goods_class_info");
//				if (gc.getLevel() == 2) {// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
//					Map spec_map = new HashMap();
//					spec_map.put("store_id", user.getStore().getId());
//					List<GoodsSpecification> goods_spec_list = this.goodsSpecificationService
//							.query("select obj from GoodsSpecification obj where obj.store.id=:store_id order by sequence asc",
//									spec_map, -1, -1);
//					List<GoodsSpecification> spec_list = new ArrayList<GoodsSpecification>();
//					for (GoodsSpecification gspec : goods_spec_list) {
//						for (GoodsClass spec_goodsclass_detail : gspec
//								.getSpec_goodsClass_detail()) {
//							if (gc.getId().equals(
//									spec_goodsclass_detail.getId())) {
//								spec_list.add(gspec);
//							}
//						}
//					}
//					mv.addObject("goods_spec_list", spec_list);
//				} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
//					Map spec_map = new HashMap();
//					spec_map.put("store_id", user.getStore().getId());
//					spec_map.put("gc_id", gc.getId());
//					List<GoodsSpecification> goods_spec_list = this.goodsSpecificationService
//							.query("select obj from GoodsSpecification obj where obj.store.id=:store_id and obj.goodsclass.id=:gc_id order by sequence asc",
//									spec_map, -1, -1);
//					mv.addObject("goods_spec_list", goods_spec_list);
//				}
				if (gc.getLevel() == 2) {//
					// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
					List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByStoreId(storeId);
					List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
							.findSpecProperty(goodsSpecList);
					goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO, gc.getId());
					mv.addObject("goods_spec_list", goodsSpecListBO);
				} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
					List<GoodsSpecification> goodsSpecList = goodsSpecificationService
							.findByStoreIdAndClassId(storeId, gc.getId());
					List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
							.findSpecProperty(goodsSpecList);
					mv.addObject("goods_spec_list", goodsSpecListBO);
				}
//				String path = this.storeTools.createUserFolder(request, user.getStore());
//				double csize = CommUtil.fileSize(new File(path));
//				double img_remain_size = 0;
//				if (user.getStore().getGrade().getSpaceSize() >0) {
//					img_remain_size = CommUtil.div(user.getStore().getGrade().getSpaceSize() * 1024 - csize, 1024);
//					mv.addObject("img_remain_size", img_remain_size);
//				}
				List<UserGoodsClassBO> ugcs = this.userGoodsClassService.findParentByUserId(userDetails
						.getUser().getId());
				GoodsClassBO goods_class = null;
				if (gc.getLevel() == 2) {
					DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
							String.valueOf(gc.getParentId()));
					goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
							dicClass.getParentCode());
				}
				if (gc.getLevel() == 1) {
					goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class,
							String.valueOf(gc.getParentId()));
				}
				List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());
				mv.addObject("gbs", gbs);
				mv.addObject("ugcs", ugcs);

//				mv.addObject("imageSuffix", this.storeViewTools.genericImageSuffix(this.configService.getSysConfig().getImageSuffix()));
				// 处理上传格式
				String[] strs = this.configService.getSysConfig().getImageSuffix().split("\\|");
				StringBuffer sb = new StringBuffer();
				for (String str : strs) {
					sb.append("." + str + ",");
				}
				mv.addObject("imageSuffix1", sb);
				Date now = new Date();
				now.setDate(now.getDate() + 1);
				mv.addObject("default_publish_day", CommUtil.formatShortDate(now));
				String goods_session = CommUtil.randomString(32);
				mv.addObject("goods_session", goods_session);
				request.getSession(false).setAttribute("goods_session", goods_session);
				mv.addObject("store", store);
				// 查询商品版式信息
				List<GoodsFormat> gfs = this.goodsFormatService.findByStoreId(storeId);
				mv.addObject("gfs", gfs);
				// 查询地址信息，前端需要商家选择发货地址
				List<Area> areas = this.dicContent.getRootTreeDic(Area.class);
				mv.addObject("areas", areas);
			} else {
				mv.addObject("op_title", "Session信息丢失，请重新发布商品");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/add_goods_first.htm");
			}
		}
		if (store_status == 0) {
			mv.addObject("op_title", "您尚未开通店铺，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		if (store_status == 10) {
			mv.addObject("op_title", "您的店铺在审核中，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		if (store_status == 20) {
			mv.addObject("op_title", "您的店铺已被关闭，不能发布商品");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/index.htm");
		}
		return mv;
	}

	@SecurityMapping(title = "产品规格显示", value = "/seller/goods_inventory.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_inventory.htm")
	public ModelAndView goods_inventory(HttpServletRequest request, HttpServletResponse response,
			String goods_spec_ids, String supplement) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_inventory.html",
				configService.getSysConfig(), 0, request, response);
		String[] spec_ids = goods_spec_ids.split(",");
		List<GoodsSpecificationBO> specs = specPropertyService.getSpecificationByIds(spec_ids);
		List<List<GoodsSpecPropertyBO>> gsp_list = specPropertyService.genericSpecProperty(specs);
		mv.addObject("specs", specs);
		mv.addObject("gsps", gsp_list);
		return mv;
	}

//	@SecurityMapping(title = "上传商品图片", value = "/seller/swf_upload.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/swf_upload.htm")
//	public void swf_upload(HttpServletRequest request, HttpServletResponse response, String album_id, String session_u_id) {
//		accessoryService.accessoryImgSave(request, "imgFile", album_id);
//	}

	@SecurityMapping(title = "商品图片删除", value = "/seller/goods_image_del.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_image_del.htm")
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

	@SecurityMapping(title = "发布商品第三步", value = "/seller/add_goods_finish.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/add_goods_finish.htm")
	public ModelAndView add_goods_finish(HttpServletRequest request, HttpServletResponse response,
			GoodsBO goods, String goods_session) {
		ModelAndView mv = null;
		String goods_session1 = CommUtil.null2String(request.getSession(false).getAttribute("goods_session"));
		if (goods_session1.equals("")) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "禁止重复提交表单");
			mv.addObject("url", CommUtil.getURL(request) + "/seller/goods.htm");
		} else {
			CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
					.getCurrentUserDetails();
			Store store = storeService.getObjById(userDetails.getStoreId());
			// 判断所发布的商品分类是否和店铺经营分类匹配
			GoodsClassBO gc = (GoodsClassBO) this.dicContent.getDic(GoodsClassBO.class,
					CommUtil.null2String(goods.getGcId()));
			boolean m = false;
			if (StringUtils.isEmpty(store.getGcDetailInfo())) {
				if (gc.getParentId().equals(store.getGcMainId())) {
					m = true;
				}
				GoodsClassBO gcParent = (GoodsClassBO) this.dicContent.getDic(GoodsClassBO.class,
						CommUtil.null2String(gc.getParentId()));
				if (gcParent.getParentId() != null && gcParent.getParentId().equals(store.getGcMainId())) {
					m = true;
				}
			} else {
				Set<GoodsClass> store_gcs = this.storeTools.query_store_DetailGc(store.getGcDetailInfo());
				if (CollectionUtils.isNotEmpty(store_gcs)) {
					for (GoodsClass goodsClass : store_gcs) {
						if (goodsClass.getId().equals(gc.getParentId())
								|| goodsClass.getId().equals(gc.getId())) {
							m = true;
							break;
						}
					}
				}
			}
			if (goods_session1.equals(goods_session) && m) {
				StoreGrade grade = storeGradeService.getObjById(store.getGradeId());
				if (goods.getId() == null) {
					mv = new JModelAndView("user/default/sellercenter/add_goods_finish.html",
							configService.getSysConfig(), 0, request, response);
					if (grade.getGoodsAudit() == 0) {
						mv.addObject("op_title", "商品发布成功,平台会尽快为您审核！");
					}
					if (grade.getGoodsAudit() == 1) {
						mv.addObject("op_title", "商品发布成功！");
					}
				} else {
					mv = new JModelAndView("user/default/sellercenter/seller_success.html",
							configService.getSysConfig(), 0, request, response);
					if (grade.getGoodsAudit() == 0) {
						mv.addObject("op_title", "商品编辑成功,平台会尽快为您审核");
						mv.addObject("url", CommUtil.getURL(request) + "/seller/goods.htm");
					}
					if (grade.getGoodsAudit() == 1) {
						mv.addObject("op_title", "商品编辑成功");
						mv.addObject("url", CommUtil.getURL(request) + "/seller/goods.htm");
					}
				}
				goods.setSelfAddPrice(BigDecimal.ZERO);
				goods.setHasExchangeIntegral(false);
				goods.setHasMobilePrice(false);
				goods.setGoodsRecommend(false);
				goods.setStoreRecommend(false);
				this.goodsService.save(goods, userDetails.getUser().getId(), store);

				// 生成二维码
//				goodsTools.createGoodsQRAsync(request, String.valueOf(goods.getId()), goods.getGoodsMainPhotoPath(),
//						CommUtil.getURL(request) + "/goods_" + goods.getId() + ".htm");
				if (goods.getId() == null) {
					if ("0".equals(goods.getGoodsStatus())) {
						LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
						SysConfig config = this.configService.getSysConfig();
						LuceneUtil.setLucenenQueue(config.getLucenenQueue());
						luceneUtil.writeIndex(vo);
					}
				} else {
					if ("0".equals(goods.getPublishGoodsStatus())
							&& "0".equals(CommUtil.null2String(goods.getGoodsStatus()))) {// 发布后直接上架
						LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
						luceneUtil.update(CommUtil.null2String(goods.getId()), vo);
					}
					if ("0".equals(goods.getPublishGoodsStatus())
							&& ("1".equals(goods.getGoodsStatus()) || "2".equals(goods.getGoodsStatus()))) {// 发布后在仓库中
						// 添加lucene索引
						LuceneVo vo = this.luceneVoTools.updateGoodsIndex(goods);
						luceneUtil.writeIndex(vo);
					}
					if (("1".equals(goods.getPublishGoodsStatus()) || "2".equals(goods
							.getPublishGoodsStatus())) && "0".equals(goods.getGoodsStatus())) {// 在仓库中发布后上架
						luceneUtil.delete_index(GoodsDocument.class, String.valueOf(goods.getId()));
					}
				}
				String goods_view_url = CommUtil.getURL(request) + "/goods_" + goods.getId() + ".htm";
				if (this.configService.getSysConfig().getSecondDomainOpen()
						&& store.getStoreSecondDomain() != "" && goods.getGoodsType() == 1) {
					String store_second_domain = "http://" + store.getStoreSecondDomain() + "."
							+ CommUtil.generic_domain(request);
					goods_view_url = store_second_domain + "/goods_" + goods.getId() + ".htm";
				}
				mv.addObject("goods_view_url", goods_view_url);
				mv.addObject("goods_edit_url", CommUtil.getURL(request) + "/seller/goods_edit.htm?id="
						+ goods.getId());
				request.getSession(false).removeAttribute("goods_session");
			} else {
				mv = new JModelAndView("user/default/sellercenter/seller_error.html",
						configService.getSysConfig(), 0, request, response);
				mv.addObject("op_title", "参数错误");
				mv.addObject("url", CommUtil.getURL(request) + "/seller/goods.htm");
			}
		}
		return mv;
	}

//	@SecurityMapping(title = "发布商品上传图片", value = "/seller/add_goods_image.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/add_goods_image.htm")
//	public void add_goods_image(HttpServletRequest request,
//			HttpServletResponse response) {
//		Map json_map = new HashMap();
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		String path = this.storeTools
//				.createUserFolder(request, user.getStore());
//		String url = this.storeTools.createUserFolderURL(user.getStore());
//		double csize = CommUtil.fileSize(new File(path));
//		double img_remain_size = 0;
//		if (user.getStore().getGrade().getSpaceSize() > 0) {
//			img_remain_size = CommUtil.div(user.getStore().getGrade()
//					.getSpaceSize()
//					* 1024 - csize, 1024);
//			json_map.put("remainSpace", img_remain_size);
//		}
//		if (img_remain_size >= 0) {
//			try {
//				Map map = CommUtil.saveFileToServer(request, "imgFile", path,
//						null, null);
//				Map params = new HashMap();
//				params.put("store_id", user.getStore().getId());
//				List<WaterMark> wms = this.waterMarkService
//						.query("select obj from WaterMark obj where obj.store.id=:store_id",
//								params, -1, -1);
//				if (wms.size() > 0) {
//					WaterMark mark = wms.get(0);
//					if (mark.isWm_image_open()) {
//						String pressImg = request.getSession()
//								.getServletContext().getRealPath("")
//								+ File.separator
//								+ mark.getWm_image().getPath()
//								+ File.separator + mark.getWm_image().getName();
//						System.out.println(mark.getWm_image().getPath()
//								.replace("//", File.separator));
//						System.out.println(mark.getWm_image().getName());
//						String targetImg = path + File.separator
//								+ map.get("fileName");
//						int pos = mark.getWm_image_pos();
//						float alpha = mark.getWm_image_alpha();
//						CommUtil.waterMarkWithImage(pressImg, targetImg, pos,
//								alpha);
//					}
//					if (mark.isWm_text_open()) {
//						String targetImg = path + File.separator
//								+ map.get("fileName");
//						int pos = mark.getWm_text_pos();
//						String text = mark.getWm_text();
//						String markContentColor = mark.getWm_text_color();
//						CommUtil.waterMarkWithText(targetImg, targetImg, text,
//								markContentColor,
//								new Font(mark.getWm_text_font(), Font.BOLD,
//										mark.getWm_text_font_size()), pos, 100f);
//					}
//				}
//				Accessory image = new Accessory();
//				image.setAddTime(new Date());
//				image.setExt((String) map.get("mime"));
//				image.setPath(url);
//				image.setWidth(CommUtil.null2Int(map.get("width")));
//				image.setHeight(CommUtil.null2Int(map.get("height")));
//				image.setName(CommUtil.null2String(map.get("fileName")));
//				image.setUser(user);
//				Album album = this.albumService.getDefaultAlbum(user.getId());
//				if (album == null) {
//					album = new Album();
//					album.setAddTime(new Date());
//					album.setAlbum_name("默认相册");
//					album.setAlbum_sequence(-10000);
//					album.setAlbum_default(true);
//					this.albumService.save(album);
//				}
//				image.setAlbum(album);
//				this.accessoryService.save(image);
//				// 同步生成小图片
//				String ext = image.getExt().indexOf(".") < 0 ? "."
//						+ image.getExt() : image.getExt();
//				String source = request.getSession().getServletContext()
//						.getRealPath("/")
//						+ image.getPath() + File.separator + image.getName();
//				String target = source + "_small" + ext;
//				CommUtil.createSmall(source, target, this.configService
//						.getSysConfig().getSmallWidth(), this.configService
//						.getSysConfig().getSmallHeight());
//				// 同步生成中等图片
//				String midext = image.getExt().indexOf(".") < 0 ? "."
//						+ image.getExt() : image.getExt();
//				String midtarget = source + "_middle" + ext;
//				CommUtil.createSmall(source, midtarget, this.configService
//						.getSysConfig().getMiddleWidth(), this.configService
//						.getSysConfig().getMiddleHeight());
//				json_map.put("url", CommUtil.getURL(request) + "/" + url + "/"
//						+ image.getName());
//				json_map.put("id", image.getId());
//				double csize2 = CommUtil.fileSize(new File(path));
//				double img_remain_size2 = 0;
//				if (user.getStore().getGrade().getSpaceSize() > 0) {
//					img_remain_size2 = CommUtil.div(user.getStore().getGrade()
//							.getSpaceSize()
//							* 1024 - csize2, 1024);
//					json_map.put("remainSpace", img_remain_size2);
//				} else {
//					json_map.put("remainSpace", "null");
//				}
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			json_map.put("url", "");
//			json_map.put("id", "");
//			json_map.put("remainSpace", -1);
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(Json.toJson(json_map));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//
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
	@SecurityMapping(title = "加载商品分类", value = "/seller/load_goods_class.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/load_goods_class.htm")
	public void load_goods_class(HttpServletRequest request, HttpServletResponse response, String pid,
			String session) {
		GoodsClassBO obj = this.dicContent.getTreeDic(GoodsClassBO.class, pid);

		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		Store store = storeService.getObjById(userDetails.getSeller().getStoreId());
		List<Map> list = new ArrayList<Map>();
		if (obj != null) {
			if (obj.getLevel() == 0) {// 加载二级分类
				Map map = this.storeTools.query_MainGc_Map(CommUtil.null2String(obj.getId()),
						store.getGcDetailInfo());
				if (map != null) {
					List<Integer> ls = (List) map.get("gc_list");
					if (ls != null && !ls.equals("")) {
						for (Integer l : ls) {
							Map map_gc = new HashMap();
							GoodsClass gc = this.goodsClassService.getObjById(CommUtil.null2Long(l));
							map_gc.put("id", gc.getId());
							map_gc.put("className", gc.getClassName());
							list.add(map_gc);
						}
					}
				}
			} else if (obj.getLevel() == 1) {// 加载三级分类
				for (GoodsClass child : obj.getChilds()) {
					Map map_gc = new HashMap();
					map_gc.put("id", child.getId());
					map_gc.put("className", child.getClassName());
					list.add(map_gc);
				}
			}
			if (CommUtil.null2Boolean(session)) {
				request.getSession(false).setAttribute("goods_class_info", obj);
			}
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

//	@SecurityMapping(title = "添加用户常用商品分类", value = "/seller/load_goods_class.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/add_goods_class_staple.htm")
//	public void add_goods_class_staple(HttpServletRequest request,
//			HttpServletResponse response) {
//		String ret = "error";
//		if (request.getSession(false).getAttribute("goods_class_info") != null) {
//			GoodsClass session_gc = (GoodsClass) request.getSession(false)
//					.getAttribute("goods_class_info");
//			GoodsClass gc = this.goodsClassService.getObjById(session_gc
//					.getId());
//			User user = this.userService.getObjById(SecurityUserHolder
//					.getCurrentUser().getId());
//			user = user.getParent() == null ? user : user.getParent();
//			String json = "";
//			List<Map> list_map = new ArrayList<Map>();
//			if (user.getStaple_gc() != null && !user.getStaple_gc().equals("")) {
//				json = user.getStaple_gc();
//				list_map = Json.fromJson(List.class, json);
//			}
//			if (list_map.size() > 0) {
//				boolean flag = true;
//				for (Map staple : list_map) {
//					if (gc.getId().toString()
//							.equals(CommUtil.null2String(staple.get("id")))) {
//						flag = false;
//						break;
//					}
//				}
//				if (flag) {
//					Map map = new HashMap();
//					map.put("name",
//							gc.getParent().getParent().getClassName() + ">"
//									+ gc.getParent().getClassName() + ">"
//									+ gc.getClassName());
//					map.put("id", gc.getId());
//					list_map.add(map);
//					json = Json.toJson(list_map, JsonFormat.compact());
//					ret = Json.toJson(map);
//				}
//			} else {
//				Map map = new HashMap();
//				map.put("name",
//						gc.getParent().getParent().getClassName() + ">"
//								+ gc.getParent().getClassName() + ">"
//								+ gc.getClassName());
//				map.put("id", gc.getId());
//				map.put("id", gc.getId());
//				list_map.add(map);
//				json = Json.toJson(list_map, JsonFormat.compact());
//				ret = Json.toJson(map);
//			}
//			user.setStaple_gc(json);
//			this.userService.update(user);
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@SecurityMapping(title = "删除用户常用商品分类", value = "/seller/del_goods_class_staple.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/del_goods_class_staple.htm")
//	public void del_goods_class_staple(HttpServletRequest request,
//			HttpServletResponse response, String id) {
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		List<Map> list_map = Json.fromJson(List.class, user.getStaple_gc());
//		boolean ret = false;
//		for (Map map : list_map) {
//			if (CommUtil.null2String(map.get("id")).equals(id)) {
//				ret = list_map.remove(map);
//			}
//		}
//		user.setStaple_gc(Json.toJson(list_map, JsonFormat.compact()));
//		this.userService.update(user);
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(ret);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	@SecurityMapping(title = "根据用户常用商品分类加载分类信息", value = "/seller/load_goods_class_staple.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/load_goods_class_staple.htm")
//	public void load_goods_class_staple(HttpServletRequest request,
//			HttpServletResponse response, String id, String name) {
//		GoodsClass obj = null;
//		User user = this.userService.getObjById(SecurityUserHolder
//				.getCurrentUser().getId());
//		user = user.getParent() == null ? user : user.getParent();
//		if (id != null && !id.equals("")) {
//			List<Map> list_map = Json.fromJson(List.class, user.getStaple_gc());
//			for (Map map : list_map) {
//				if (CommUtil.null2String(map.get("id")).equals(id)) {
//					obj = this.goodsClassService.getObjById(CommUtil
//							.null2Long(map.get("id")));
//				}
//			}
//		}
//		if (name != null && !name.equals(""))
//			obj = this.goodsClassService.getObjByProperty(null, "className",
//					name);
//		List<List<Map>> list = new ArrayList<List<Map>>();
//		if (obj != null) {
//			// 该版本要求三级分类才能添加到常用分类
//			request.getSession(false).setAttribute("goods_class_info", obj);
//			Map params = new HashMap();
//			List<Map> second_list = new ArrayList<Map>();
//			List<Map> third_list = new ArrayList<Map>();
//			List<Map> other_list = new ArrayList<Map>();
//
//			if (obj.getLevel() == 2) {
//				params.put("pid", obj.getParent().getParent().getId());
//				List<GoodsClass> second_gcs = this.goodsClassService
//						.query("select obj from GoodsClass obj where obj.parent.id=:pid order by obj.sequence asc",
//								params, -1, -1);
//				for (GoodsClass gc : second_gcs) {
//					Map map = new HashMap();
//					map.put("id", gc.getId());
//					map.put("className", gc.getClassName());
//					second_list.add(map);
//				}
//				params.clear();
//				params.put("pid", obj.getParent().getId());
//				List<GoodsClass> third_gcs = this.goodsClassService
//						.query("select obj from GoodsClass obj where obj.parent.id=:pid order by obj.sequence asc",
//								params, -1, -1);
//				for (GoodsClass gc : third_gcs) {
//					Map map = new HashMap();
//					map.put("id", gc.getId());
//					map.put("className", gc.getClassName());
//					third_list.add(map);
//				}
//			}
//
//			if (obj.getLevel() == 1) {
//				params.clear();
//				params.put("pid", obj.getParent().getId());
//				List<GoodsClass> third_gcs = this.goodsClassService
//						.query("select obj from GoodsClass obj where obj.parent.id=:pid order by obj.sequence asc",
//								params, -1, -1);
//				for (GoodsClass gc : third_gcs) {
//					Map map = new HashMap();
//					map.put("id", gc.getId());
//					map.put("className", gc.getClassName());
//					second_list.add(map);
//				}
//			}
//
//			Map map = new HashMap();
//			String staple_info = this.generic_goods_class_info(obj);
//			map.put("staple_info",
//					staple_info.substring(0, staple_info.length() - 1));
//			other_list.add(map);
//
//			list.add(second_list);
//			list.add(third_list);
//			list.add(other_list);
//		}
//		response.setContentType("text/plain");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setCharacterEncoding("UTF-8");
//		PrintWriter writer;
//		try {
//			writer = response.getWriter();
//			writer.print(Json.toJson(list, JsonFormat.compact()));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@SecurityMapping(title = "出售中的商品列表", value = "/seller/goods.htm*", rtype = "seller", rname = "出售中的商品", rcode = "goods_list_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods.htm")
	public ModelAndView goods(HttpServletRequest request, HttpServletResponse response, MyPage<GoodsBO> page,
			GoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		page.setPageSize(10);
		vo.setGoodsStatus(GoodsConstants.GOODS_STATUS_SELLING);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		vo.setOrderBy("addTime");
		vo.setOrderType(" desc");
		this.goodsService.list(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

		List<UserGoodsClassBO> userGoodsClassList = userGoodsClassService.findParentByUserId(userDetails
				.getUser().getId());

		mv.addObject("userGoodsClassList", userGoodsClassList);
		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "仓库中的商品列表", value = "/seller/goods_storage.htm*", rtype = "seller", rname = "仓库中的商品", rcode = "goods_storage_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_storage.htm")
	public ModelAndView goods_storage(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBO> page, GoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_storage.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		page.setPageSize(10);
		Set<Integer> status = new HashSet<>();
		status.add(GoodsConstants.GOODS_STATUS_STORE);
		status.add(GoodsConstants.GOODS_STATUS_CHECKING);
		vo.setGoodsStatusList(status);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		vo.setOrderBy("goods_seller_time");
		vo.setOrderType(" desc");
		this.goodsService.list(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		List<UserGoodsClassBO> userGoodsClassList = userGoodsClassService.findParentByUserId(userDetails
				.getUser().getId());
		mv.addObject("userGoodsClassList", userGoodsClassList);
		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "违规下架商品", value = "/seller/goods_out.htm*", rtype = "seller", rname = "违规下架商品", rcode = "goods_out_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_out.htm")
	public ModelAndView goods_out(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBO> page, GoodsVO vo) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_out.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		page.setPageSize(10);
		vo.setGoodsStatus(GoodsConstants.GOODS_STATUS_ILLEGAL_DOWN);
		vo.setStoreId(userDetails.getSeller().getStoreId());
		vo.setOrderBy("goods_seller_time");
		vo.setOrderType(" desc");
		this.goodsService.list(page, vo);
		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		List<UserGoodsClassBO> userGoodsClassList = userGoodsClassService.findParentByUserId(userDetails
				.getUser().getId());
		mv.addObject("userGoodsClassList", userGoodsClassList);

		CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
		mv.addObject("storeTools", storeTools);
		mv.addObject("goodsViewTools", goodsViewTools);
		mv.addObject("vo", vo);
		mv.addObject("currentPage", page.getCurrentPage());
		return mv;
	}

	@SecurityMapping(title = "商品编辑", value = "/seller/goods_edit.htm*", rtype = "seller", rname = "出售中的商品", rcode = "goods_list_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_edit.htm")
	public ModelAndView goods_edit(HttpServletRequest request, HttpServletResponse response, String id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/add_goods_second.html",
				configService.getSysConfig(), 0, request, response);
		GoodsBO obj = this.goodsService.getFullGoodsById(Long.parseLong(id));
		if (obj.getSelfAddPrice() != null) {
			obj.setStorePrice(obj.getStorePrice().subtract(obj.getSelfAddPrice()));
			obj.setGoodsPrice(obj.getGoodsPrice().subtract(obj.getSelfAddPrice()));
			obj.setGoodsCurrentPrice(obj.getGoodsCurrentPrice().subtract(obj.getSelfAddPrice()));
		}
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();

		if (!obj.getGoodsStoreId().equals(userDetails.getStoreId())) {
			mv = new JModelAndView("user/default/sellercenter/seller_error.html",
					configService.getSysConfig(), 0, request, response);
			mv.addObject("op_title", "您没有该商品信息！");
			mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
		}

		mv.addObject("edit", true);
		mv.addObject("img_remain_size", 10000000);
		mv.addObject("obj", obj);
		List<UserGoodsClassBO> ugcs = this.userGoodsClassService.findParentByUserId(userDetails.getUser()
				.getId());
		mv.addObject("ugcs", ugcs);

//		if (request.getSession(false).getAttribute("goods_class_info") != null) {
//			GoodsClass session_gc = (GoodsClass) request.getSession(false).getAttribute("goods_class_info");
//			GoodsClass gc = this.goodsClassService.getObjById(session_gc.getId());
//			String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
//			mv.addObject("goods_class",this.goodsClassService.getBOAndTpyePropertyById(gc.getId()));
//			mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));
//			
//			GoodsClassBO goods_class = null;
//			if (gc.getLevel() == 2) {
//				DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class, String.valueOf(gc.getId()));
//				goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class, dicClass.getParentCode());
//			}
//			if (gc.getLevel() == 1) {
//				goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class, String.valueOf(gc.getId()));
//			}
//			List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());
//			mv.addObject("gbs", gbs);
//			
//			if (gc.getLevel() == 2) {// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
//				List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByStoreId(userDetails.getStoreId());
//				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService.findSpecProperty(goodsSpecList);
//				goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO, gc.getId());
//				mv.addObject("goods_spec_list", goodsSpecListBO);
//			} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
//				List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByStoreIdAndClassId(userDetails.getStoreId(), gc.getId());
//				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService.findSpecProperty(goodsSpecList);
//				mv.addObject("goods_spec_list", goodsSpecListBO);
//			}
//			request.getSession(false).removeAttribute("goods_class_info");
//		} else {
		if (obj.getGcId() != null) {
			GoodsClassBO gc = this.goodsClassService.getBOAndTpyePropertyById(obj.getGcId());
			String goods_class_info = this.goodsService.genericGoodsClassInfo(gc);
			mv.addObject("goods_class", gc);
			mv.addObject("goods_class_info", goods_class_info.substring(0, goods_class_info.length() - 1));

			if (gc.getLevel() == 2) {//
				// 发布商品选择分类时选择三级分类,查询出所有与该三级分类关联的规格，即规格对应的详细商品分类
				List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByStoreId(userDetails
						.getStoreId());
				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
						.findSpecProperty(goodsSpecList);
				goodsSpecListBO = goodsSpecificationService.findSpecGCDetail(goodsSpecListBO, gc.getId());
				mv.addObject("goods_spec_list", goodsSpecListBO);
			} else if (gc.getLevel() == 1) {// 发布商品选择分类时选择二级分类,规格对应的主营商品分类
				List<GoodsSpecification> goodsSpecList = goodsSpecificationService.findByStoreIdAndClassId(
						userDetails.getStoreId(), gc.getId());
				List<GoodsSpecificationBO> goodsSpecListBO = goodsSpecificationService
						.findSpecProperty(goodsSpecList);
				mv.addObject("goods_spec_list", goodsSpecListBO);
			}
			GoodsClassBO goods_class = null;
			if (gc.getLevel() == 2) {
				DicParentBase dicClass = (DicParentBase) dicContent.getDic(GoodsClassBO.class,
						String.valueOf(gc.getId()));
				goods_class = (GoodsClassBO) dicContent.getDic(GoodsClassBO.class, dicClass.getParentCode());
			}
			if (gc.getLevel() == 1) {
				goods_class = (GoodsClassBO) dicContent
						.getDic(GoodsClassBO.class, String.valueOf(gc.getId()));
			}
			List<GoodsBrandBO> gbs = this.goodsBrandService.findByGoodsClass(goods_class.getId());
			mv.addObject("gbs", gbs);

			// 查询商品版式信息
			List<GoodsFormat> gfs = this.goodsFormatService.findByStoreId(userDetails.getStoreId());
			mv.addObject("gfs", gfs);
			// 查询地址信息，前端需要商家选择发货地址
//				List<Area> areas = this.areaService.getAllParentIsNull();
//				mv.addObject("areas", areas);
//				if (obj.getDeliveryAreaId() != null) 
//				{
//					Area xian = (Area) dicContent.getDic(Area.class, CommUtil.null2String(obj.getDeliveryAreaId()));
//					Area shi = (Area) dicContent.getDic(Area.class, xian.getParentCode());
//					obj.setDeliveryAreaSheng(shi.getParentCode());
//					obj.setDeliveryAreaShi(shi.getAreaName());
//					obj.setDeliveryAreaXian(xian.getAreaName());
//				}
		}
//		}
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
		return mv;
	}

	@SecurityMapping(title = "商品上下架", value = "/seller/goods_sale.htm*", rtype = "seller", rname = "违规下架商品", rcode = "goods_out_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_sale.htm")
	public String goods_sale(HttpServletRequest request, HttpServletResponse response, String mulitId) {
		String url = "/seller/goods.htm";
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Goods goods = this.goodsService.getObjById(Long.parseLong(id));
				if (goods.getGoodsStatus() != -5) {
					CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
							.getCurrentUserDetails();
					if (goods.getGoodsStoreId().equals(userDetails.getStoreId())) {
						int goods_status = goods.getGoodsStatus() == 0 ? 1 : 0;
						Goods goodsUpdate = new Goods();
						goodsUpdate.setId(goods.getId());
						goodsUpdate.setGoodsStatus(goods_status);
						this.goodsService.update(goodsUpdate);
						if (goods_status == 0) {
							url = "/seller/goods_storage.htm";
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
								luceneUtil.delete_index(GoodsDocument.class,
										CommUtil.null2String(goods.getId()));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return "redirect:" + url;
	}

	@SecurityMapping(title = "商品删除", value = "/seller/goods_del.htm*", rtype = "seller", rname = "出售中的商品", rcode = "goods_list_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_del.htm")
	public String goods_del(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String op) {
		String url = "/seller/goods.htm";
		if (CommUtil.null2String(op).equals("storage")) {
			url = "/seller/goods_storage.htm";
		}
		if (CommUtil.null2String(op).equals("out")) {
			url = "/seller/goods_out.htm";
		}
		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
				CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder
						.getCurrentUserDetails();
				if (goods.getGoodsStoreId().equals(userDetails.getStoreId())) {
					this.goodsService.delete(CommUtil.null2Long(id));
					// 删除索引
					luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
				}
			}
		}
		return "redirect:" + url;
	}

	@SecurityMapping(title = "商家商品相册列表", value = "/seller/goods_album.htm*", rtype = "seller", rname = "发布新商品", rcode = "album_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_album.htm")
	public ModelAndView goods_album(HttpServletRequest request, HttpServletResponse response,
			MyPage<AlbumBO> page, String ajax_type) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_album.html",
				configService.getSysConfig(), 0, request, response);
		page.setPageSize(5);
		albumService.list(SecurityUserHolder.getCurrentUser().getId(), page);

		String album_url = CommUtil.getURL(request) + "/seller/goods_album.htm";
		mv.addObject("albums", page.getResult());
		mv.addObject(
				"gotoPageAjaxHTML",
				CommUtil.showPageAjaxHtml(album_url, "", page.getCurrentPage(), page.getPages(),
						page.getPageSize(), page.getRowCount()));
		mv.addObject("ajax_type", ajax_type);
		mv.addObject("ImageTools", ImageTools);
		return mv;
	}

	@SecurityMapping(title = "商家商品图片列表", value = "/seller/goods_img.htm*", rtype = "seller", rname = "发布新商品", rcode = "album_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_img.htm")
	public ModelAndView goods_img(HttpServletRequest request, HttpServletResponse response,
			MyPage<AccessoryBO> page, String type, Long album_id) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/" + type + ".html",
				configService.getSysConfig(), 0, request, response);
		accessoryService.queryAccessoriesById(album_id, page);
		String photo_url = CommUtil.getURL(request) + "/seller/goods_img.htm";
		mv.addObject("photos", page.getResult());
		mv.addObject(
				"gotoPageAjaxHTML",
				CommUtil.showPageAjaxHtml(photo_url, "", page.getCurrentPage(), page.getPages(),
						page.getPageSize(), page.getRowCount()));
		mv.addObject("album_id", album_id);
		return mv;
	}

//	@SecurityMapping(title = "商品二维码生成", value = "/seller/goods_qr.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/goods_qr.htm")
//	public String goods_qr(HttpServletRequest request, HttpServletResponse response, String mulitId, String currentPage) throws ClassNotFoundException {
//		String ids[] = mulitId.split(",");
//		for (String id : ids) {
//			if (id != null) {
//				Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
//				if (obj.getGoodsType() == 0) {// 只能操作自营商品
//					String imgPath = goodsTools.createGoodsQRSync(request, id, obj.getGoodsMainPhotoPath(), CommUtil.getURL(request) + "/goods_" + id + ".htm");
//					Goods updateGoods = new Goods();
//					updateGoods.setId(obj.getId());
//					updateGoods.setQrImgPath(imgPath);
//					goodsService.update(updateGoods);
//				}
//			}
//		}
//		return "redirect:goods.htm?currentPage=" + currentPage;
//	}

	@SecurityMapping(title = "打开关联商品版式", value = "/seller/goods_format.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format.htm")
	public ModelAndView goods_format(HttpServletRequest request, HttpServletResponse response,
			String mulitId, String currentPage) {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_format.html",
				configService.getSysConfig(), 0, request, response);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		// 查询商品版式信息
		List<GoodsFormat> gfs = this.goodsFormatService.findByStoreId(userDetails.getStoreId());
		mv.addObject("gfs", gfs);
		mv.addObject("mulitId", mulitId);
		mv.addObject("currentPage", currentPage);
		return mv;
	}

	@SecurityMapping(title = "批量保存关联商品版式", value = "/seller/goods_format_link.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_format_link.htm")
	public void goods_format_link(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String currentPage, String goods_top_format_id, String goods_bottom_format_id) {
		String[] ids = mulitId.split(",");
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		for (String id : ids) {
			if (!CommUtil.null2String(id).equals("")) {
				Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
				Goods goodsUpdate = new Goods();
				goodsUpdate.setId(goods.getId());
				if (goods.getGoodsStoreId().equals(userDetails.getStoreId())) {
					goodsUpdate.setGoodsTopFormatId(CommUtil.null2Long(goods_top_format_id));
					GoodsFormat gf = this.goodsFormatService.getObjById(CommUtil
							.null2Long(goods_top_format_id));
					if (gf != null) {
						goodsUpdate.setGoodsTopFormatId(CommUtil.null2Long(goods_top_format_id));
						goodsUpdate.setGoodsTopFormatContent(gf.getGfContent());
					} else {
						goodsUpdate.setGoodsTopFormatContent("");
						goodsUpdate.setGoodsTopFormatId(0L);
					}
					goods.setGoodsBottomFormatId(CommUtil.null2Long(goods_bottom_format_id));
					gf = this.goodsFormatService.getObjById(CommUtil.null2Long(goods_bottom_format_id));
					if (gf != null) {
						goodsUpdate.setGoodsBottomFormatContent(gf.getGfContent());
						goodsUpdate.setGoodsBottomFormatId(CommUtil.null2Long(goods_bottom_format_id));
					} else {
						goodsUpdate.setGoodsBottomFormatContent("");
						goodsUpdate.setGoodsBottomFormatId(0L);
					}
					this.goodsService.update(goods);
				}
			}
		}
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@SecurityMapping(title = "商品F码Excel下载", value = "/seller/goods_self_f_code_download.htm*", rtype = "seller", rname = "发布新商品", rcode = "goods_seller", rgroup = "商品管理")
//	@RequestMapping("/seller/goods_self_f_code_download.htm")
//	public void goods_self_f_code_download(HttpServletRequest request,
//			HttpServletResponse response, String id) throws IOException {
//		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
//		String excel_url = "";
//		Store store = this.userService.getObjById(
//				SecurityUserHolder.getCurrentUser().getId()).getStore();
//		if (obj.getF_sale_type() == 1 && obj.getGoods_type() == 1
//				&& obj.getGoods_store().getId().equals(store.getId())
//				&& !CommUtil.null2String(obj.getGoods_f_code()).equals("")) {
//			List<Map> list = Json.fromJson(List.class, obj.getGoods_f_code());
//			String name = CommUtil.null2String(UUID.randomUUID());
//			String path = request.getSession().getServletContext()
//					.getRealPath("/")
//					+ File.separator + "excel" + File.separator + name + ".xls";
//			this.exportList2Excel("F码列表", new String[] { "F码信息", "F码状态" },
//					list, response, name);
//		}
//	}
//
	@SecurityMapping(title = "商品补货", value = "/seller/goods_supplement.htm*", rtype = "seller", rname = "出售中的商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_supplement.htm")
	public ModelAndView goods_supplement(HttpServletRequest request, HttpServletResponse response, Long id)
			throws IOException {
		ModelAndView mv = new JModelAndView("user/default/sellercenter/goods_supplement.html",
				configService.getSysConfig(), 0, request, response);
		Goods obj = this.goodsService.getObjById(id);
		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
		String gsp_ids = "";
		boolean showDetail = false;
		if (obj != null && obj.getGoodsStoreId().equals(userDetails.getStoreId())) {
			if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(obj.getInventoryType())
					&& StringUtils.isNotEmpty(obj.getGoodsInventoryDetail())) {
				List<GoodsSpecPropertyBO> listSpecProperty = goodsSpecPropertyService
						.selectBOSpecBygoodsId(id);
				List<String> specIdList = new ArrayList<>();
				if (CollectionUtils.isNotEmpty(listSpecProperty)) {
					for (GoodsSpecPropertyBO goodsSpecPropertyBO : listSpecProperty) {
						gsp_ids = gsp_ids + "," + goodsSpecPropertyBO.getId();
						specIdList.add(CommUtil.null2String(goodsSpecPropertyBO.getId()));
					}
					List<GoodsSpecificationBO> specs = specPropertyService.getSpecificationByIds(specIdList
							.toArray(new String[specIdList.size()]));
					mv.addObject("goods_spec_list", specs);
					mv.addObject("gsp_ids", gsp_ids);
					showDetail = true;
				}
			}
			mv.addObject("obj", obj);
		}
		mv.addObject("showDetail", showDetail);

		return mv;
	}

	// supplement
	@SecurityMapping(title = "商品补货保存", value = "/seller/goods_supplement_save.htm*", rtype = "seller", rname = "出售中的商品", rcode = "goods_seller", rgroup = "商品管理")
	@RequestMapping("/seller/goods_supplement_save.htm")
	public void goods_supplement_save(HttpServletRequest request, HttpServletResponse response, String id,
			Integer inventory, String intentoryDetails) throws IOException {
		Map json_map = new HashMap();
		int code = -100;

		if (id != null) {
			Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
			Goods objUpdate = new Goods();
			objUpdate.setId(CommUtil.null2Long(id));
			if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(obj.getInventoryType())
					&& StringUtils.isNotEmpty(intentoryDetails)) {
				Map<String, String> countMap = new HashMap<>();
				if (StringUtils.isNotBlank(intentoryDetails)) {
					String[] idsArr = intentoryDetails.split(";");
					if (ArrayUtils.isNotEmpty(idsArr)) {
						for (int i = 0; i < idsArr.length; i++) {
							String[] specDetailArr = idsArr[i].split(",");
							String idDetail = specDetailArr[0];
							String count = specDetailArr[1];
							countMap.put(idDetail, count);
						}
					}
				}
				List<Map<String, String>> list = Json
						.fromJson(ArrayList.class, obj.getGoodsInventoryDetail());
				List<Map<String, String>> newList = new ArrayList<>();
				Integer inventorySum = 0;
				for (int i = 0; i < list.size(); i++) {
					Map<String, String> mapTemp = list.get(i);
					String currentId = mapTemp.get("id");
					if (countMap.containsKey(currentId) && StringUtils.isNotBlank(countMap.get(currentId))) {
						String count = countMap.get(currentId);
						inventorySum = inventorySum + Integer.parseInt(count);
						mapTemp.put("count", count);
						newList.add(i, mapTemp);
					}
				}
				objUpdate.setGoodsInventoryDetail(Json.toJson(newList, org.nutz.json.JsonFormat.compact()));
				objUpdate.setGoodsInventory(inventorySum);;
				code = 100;
			} else {
				objUpdate.setGoodsInventory(inventory);;
				code = 100;
			}
			goodsService.update(objUpdate);

			if (obj.getGoodsStatus() == 0) {
				// 更新lucene索引
				LuceneVo vo = this.luceneVoTools.updateGoodsIndex(obj);
				luceneUtil.update(CommUtil.null2String(obj.getId()), vo);
			} else {
				luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
			}
		}

//		Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
//		CustomerUserDetails userDetails = (CustomerUserDetails) SecurityUserHolder.getCurrentUserDetails();
//		boolean warn_suppment = true;
//		if (obj != null && obj.getGoods_store().getId().equals(user.getStore().getId())) {
//			if (obj.getInventory_type().equals("all")) {
//				obj.setGoods_inventory(CommUtil.null2Int(inventory));
//				if (CommUtil.null2Int(inventory) - obj.getGoods_warn_inventory() > 0) {
//					obj.setWarn_inventory_status(0);// 预警状态恢复
//				}
//				code = 100;
//			}
//			if (obj.getInventory_type().equals("spec")) {
//				List<Map> maps = (List<Map>) Json.fromJson(obj.getGoods_inventory_detail());
//				for (Map map : maps) {
//					String[] inventory_list = intentory_details.split(";");
//					for (String temp_inventory : inventory_list) {
//						if (!temp_inventory.equals("")) {
//							String[] list = temp_inventory.split(",");
//							if (list[0].equals(CommUtil.null2String(map.get("id")))) {
//								map.put("count", list[1]);
//								if (CommUtil.null2Int(map.get("count")) <= CommUtil.null2Int(map.get("supp"))) {
//									warn_suppment = false;
//								}
//							}
//						}
//					}
//				}
//				if (warn_suppment) {
//					obj.setWarn_inventory_status(0);// 预警状态恢复
//				}
//				obj.setGoods_inventory_detail(Json.toJson(maps, JsonFormat.compact()));
//				code = 100;
//			}
//			this.goodsService.update(obj);
//		}
		json_map.put("code", code);
		response.setContentType("text/plain");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.print(Json.toJson(json_map, org.nutz.json.JsonFormat.compact()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	private static boolean exportList2Excel(String title, String[] headers,
//			List<Map> list, HttpServletResponse response, String name) {
//		boolean ret = true;
//		// 声明一个工作薄
//		HSSFWorkbook workbook = new HSSFWorkbook();
//		// 生成一个表格
//		HSSFSheet sheet = workbook.createSheet(title);
//		// 设置表格默认宽度为15个字节
//		sheet.setDefaultColumnWidth(20);
//		// 生成一个样式
//		HSSFCellStyle style = workbook.createCellStyle();
//		// 设置这些样式
//		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
//
//		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//
//		// 生成一个字体
//		HSSFFont font = workbook.createFont();
//		font.setColor(HSSFColor.VIOLET.index);
//		font.setFontHeightInPoints((short) 14);
//		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
//
//		// 把字体应用到当前的样式
//		style.setFont(font);
//
//		// 生成并设置另一个样式
//		HSSFCellStyle style_ = workbook.createCellStyle();
//		style_.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
//		style_.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//		style_.setBorderBottom(HSSFCellStyle.BORDER_THIN);
//		style_.setBorderLeft(HSSFCellStyle.BORDER_THIN);
//		style_.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		style_.setBorderTop(HSSFCellStyle.BORDER_THIN);
//		style_.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style_.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//		// 生成另一个字体
//		HSSFFont font_ = workbook.createFont();
//		// font.setColor(color);
//		font_.setFontHeightInPoints((short) 14);
//		// font_.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
//		style_.setFont(font_);
//		// 产生表格标题行
//		HSSFRow row = sheet.createRow(0);
//		for (int i = 0; i < headers.length; i++) {
//			HSSFCell cell = row.createCell(i);
//			cell.setCellStyle(style);
//			cell.setCellValue(new HSSFRichTextString(headers[i]));
//		}
//		// 遍历集合数据，产生数据行
//		int index = 0;
//		for (Map map : list) {
//			index++;
//			row = sheet.createRow(index);
//			String value = CommUtil.null2String(map.get("code"));
//			HSSFCell cell = row.createCell(0);
//			cell.setCellStyle(style_);
//			cell.setCellValue(value);
//			value = CommUtil.null2Int(map.get("status")) == 0 ? "未使用" : "已使用";
//			cell = row.createCell(1);
//			cell.setCellStyle(style_);
//			cell.setCellValue(value);
//		}
//		try {
//			response.setContentType("application/x-download");
//			response.addHeader("Content-Disposition", "attachment;filename="
//					+ name + ".xls");
//			OutputStream os = response.getOutputStream();
//			workbook.write(os);
//			os.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ret;
//	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
