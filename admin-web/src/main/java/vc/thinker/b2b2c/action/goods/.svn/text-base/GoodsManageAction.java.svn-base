package vc.thinker.b2b2c.action.goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.GoodsConstants;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.service.GoodsBrandService;
import com.sinco.carnation.goods.service.GoodsCartService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.GoodsSpecPropertyService;
import com.sinco.carnation.goods.service.GoodsTypePropertyService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.goods.tools.GoodsTools;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.tools.LuceneVoTools;
import com.sinco.carnation.goods.tools.StoreTools;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.service.SaleActivityService;
import com.sinco.carnation.operation.service.ZTCGoldLogService;
import com.sinco.carnation.order.service.OrderFormLogService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.pay.service.PaymentService;
import com.sinco.carnation.recommend.service.AdvertPositionService;
import com.sinco.carnation.sns.contants.AdvertContant;
import com.sinco.carnation.sns.model.AdvertPosition;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.bo.SpelTemplate;
import com.sinco.carnation.sys.contants.ActAppHotSaleContant;
import com.sinco.carnation.sys.model.Message;
import com.sinco.carnation.sys.model.Template;
import com.sinco.carnation.sys.service.AccessoryServiceImpl;
import com.sinco.carnation.sys.service.MessageService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.TemplateService;
import com.sinco.carnation.sys.service.UserService;
import com.sinco.carnation.transport.service.TransportService;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.service.AlbumService;
import com.sinco.carnation.user.service.ManagerService;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.carnation.watermark.service.WaterMarkService;
import com.sinco.dal.common.MyPage;

/**
 * 
 * <p>
 * Title: GoodsManageAction.java
 * </p>
 * 
 * <p>
 * Description: 商品管理类
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
public class GoodsManageAction {
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
	private MessageService messageService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private UserCustomerService customerService;
	@Autowired
	private SellerService sellerService;
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
	// @Autowired
	// private TransportTools transportTools;
	@Autowired
	private StoreTools storeTools;
	// @Autowired
	// private StoreViewTools storeViewTools;
	@Autowired
	private GoodsViewTools goodsViewTools;
	@Autowired
	private ZTCGoldLogService ztcglService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private StoreService storeService;
	@Autowired
	private LuceneVoTools luceneVoTools;
	@Autowired
	private GoodsTools goodsTools;
	@Autowired
	private GoodsSpecPropertyService goodsSpecPropertyService;
	@Autowired
	private AdvertPositionService advertPositionService;
	@Autowired
	private SaleActivityService saleActivityService;
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;

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
	@SecurityMapping(title = "商品列表", value = "/admin/goods_list.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_list.htm")
	public ModelAndView goods_list(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBO> page, GoodsVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_list.html", configService.getSysConfig(), 0,
				request, response);
		Long gcId = vo.getGcId();
		Set<Long> goodsClassIds = new HashSet<Long>();
		if (vo.getGcId() != null) {
			List<GoodsClassBO> childs = goodsClassService.findChildList(vo.getGcId());
			goodsClassIds.add(vo.getGcId());
			for (GoodsClassBO child : childs) {
				goodsClassIds.add(child.getId());
			}
			vo.setGoodsClassIds(goodsClassIds);
			vo.setGcId(null);
		}

		this.goodsClassService.GoodsClassMv(page, vo, mv);
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

	/**
	 * 商品推荐
	 * 
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 */
	@SecurityMapping(title = "商品推荐", value = "/admin/goods_recommend.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_recommend.htm")
	public ModelAndView goods_recommend(HttpServletRequest request, HttpServletResponse response, Long id,String type) {
		ModelAndView mv = new JModelAndView("admin/blue/advert_add.html", configService.getSysConfig(), 0,
				request, response);
		if(type==null){
		if (null != id && id > 0) {
			List<AdvertPosition> apsList = advertPositionService.findByRelease(1);
			Goods goods = goodsService.getObjById(id);
			mv.addObject("adTypeGoods", AdvertContant.ADVERT_TPYE_GOODS);
			mv.addObject("goodsId", id);
			mv.addObject("goods", goods);
			mv.addObject("aps", apsList);
			mv.addObject("goodsFlag", true);
		}
		}else{
			if (null != id && id > 0) {
				String strId = id.toString();
				strId = type+strId;
				List<AdvertPosition> apsList = advertPositionService.findByRelease(1);
				JuanpiGoodsBO goods = juanpiGoodsService.findOne(id);
				mv.addObject("adTypeGoods", AdvertContant.ADVERT_TPYE_GOODS);
				mv.addObject("goodsId", strId);
				mv.addObject("goods", goods);
				mv.addObject("aps", apsList);
				mv.addObject("goodsFlag", true);
				mv.addObject("apCode", "INDEX_POPULAR_RECOMMEND");
			}	
		}
		return mv;
	}

	@SecurityMapping(title = "审核商品加价表单", value = "/admin/goods_check_form.htm*", rtype = "admin", rname = "商品管理（审核）", rcode = "admin_check_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_check_form.htm")
	public ModelAndView goods_check_form(HttpServletRequest request, HttpServletResponse response, Long id,
			Integer status) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_check_form.html", configService.getSysConfig(),
				0, request, response);
		Goods goodsModel = goodsService.getObjById(id);
		GoodsBO goods = new GoodsBO();
		BeanUtils.copyProperties(goodsModel, goods);
		boolean checkSpecFlag = false;
		if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(goods.getInventoryType())) {
			checkSpecFlag = true;
			List<GoodsSpecPropertyBO> listSpecProperty = goodsSpecPropertyService.selectBOSpecBygoodsId(id);
			List<String> specIdList = new ArrayList<>();
			if (CollectionUtils.isNotEmpty(listSpecProperty)) {
				for (GoodsSpecPropertyBO goodsSpecPropertyBO : listSpecProperty) {
					specIdList.add(CommUtil.null2String(goodsSpecPropertyBO.getId()));
				}
				List<GoodsSpecificationBO> specs = specPropertyService.getSpecificationByIds(specIdList
						.toArray(new String[specIdList.size()]));
				mv.addObject("specs", specs);
				/*List<List<GoodsSpecPropertyBO>> gsp_list = specPropertyService.genericSpecProperty(specs);*/
				List<List<GoodsSpecPropertyBO>> gsp_list = specPropertyService.genericSpecPropertySort(specs);
				mv.addObject("gsps", gsp_list);
				mv.addObject("goodsViewTools", goodsViewTools);
				String goodsInventoryDetail = goodsModel.getGoodsInventoryDetail();
				if (goodsInventoryDetail != null) {
					JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
					int size = jsonArr.size();
					if (size > 0) {
						Map<String, JSONObject> map = new HashMap<String, JSONObject>();
						for (int i = 0; i < size; i++) {
							JSONObject jsonObj = jsonArr.getJSONObject(i);
							String key = jsonObj.getString("id");
							String price = jsonObj.optString("price", "0.00");
							String selfAddPrice = jsonObj.optString("selfAddPrice", "0.00");
							BigDecimal money = new BigDecimal(price).subtract(new BigDecimal(selfAddPrice));//原始价
							jsonObj.put("storePrice", money.setScale(2, RoundingMode.DOWN).toString());
							map.put(key, jsonObj);
						}
						mv.addObject("map", map);
					}
				}

			}
		}

		mv.addObject("id", id);
		mv.addObject("checkSpecFlag", checkSpecFlag);
		mv.addObject("status", status);
		BigDecimal selfAddPriceLog = goods.getSelfAddPriceLog();
		BigDecimal selfAddPrice = goods.getSelfAddPrice();
		if (selfAddPrice.compareTo(BigDecimal.ZERO) == 1 && selfAddPriceLog.compareTo(BigDecimal.ZERO) == 0) {
			goods.setSelfAddPriceLog(selfAddPrice);
		}
		mv.addObject("goods", goods);
		return mv;
	}

	@SecurityMapping(title = "违规商品列表", value = "/admin/goods_outline.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_outline.htm")
	public ModelAndView goods_outline(HttpServletRequest request, HttpServletResponse response,
			MyPage<GoodsBO> page, GoodsVO vo) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_outline.html", configService.getSysConfig(), 0,
				request, response);
		String url = this.configService.getSysConfig().getAddress();
		if (url == null || url.equals("")) {
			url = CommUtil.getURL(request);
		}
		vo.setGoodsStatus(GoodsConstants.GOODS_STATUS_ILLEGAL_DOWN);
		this.goodsClassService.GoodsClassMv(page, vo, mv);
		return mv;
	}

	@SecurityMapping(title = "商品删除", value = "/admin/goods_del.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_del.htm")
	public String goods_del(HttpServletRequest request, String mulitId) throws Exception {

		String[] ids = mulitId.split(",");
		for (String id : ids) {
			if (!id.equals("")) {
				Goods goods = this.goodsService.getObjById(CommUtil.null2Long(id));
//				StoreBO store = storeService
//						.getObjById(goods.getGoodsStoreId());
//				Seller seller = sellerService.getByStoreId(store.getId());
				this.goodsService.delete(goods.getId());
				// 删除索引
				luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
//				if (goods.getGoodsType() == 1) {
//					this.send_site_msg(request,
//							"msg_toseller_goods_delete_by_admin_notify",
//							seller, goods, "商城存在违规");
//				}
			}
		}
		// String[] ids = mulitId.split(",");
		// for (String id : ids) {
		// if (!id.equals("")) {
		// Goods goods = this.goodsService.getObjById(CommUtil
		// .null2Long(id));
		// List<Evaluate> evaluates = goods.getEvaluates();
		// for (Evaluate e : evaluates) {
		// this.evaluateService.delete(e.getId());
		// }
		// goods.getGoods_photos().clear();
		// goods.getGoods_ugcs().clear();
		// goods.getGoods_specs().clear();
		// Map params = new HashMap();
		// params.clear();// 直通车商品记录
		// params.put("gid", goods.getId());
		// List<ZTCGoldLog> ztcgls = this.ztcglService
		// .query("select obj from ZTCGoldLog obj where obj.zgl_goods_id=:gid",
		// params, -1, -1);
		// for (ZTCGoldLog ztc : ztcgls) {
		// this.ztcglService.delete(ztc.getId());
		// }
		// goods.setGoods_main_photo(null);
		// this.goodsService.delete(goods.getId());
		// // 删除索引
		// String goods_lucene_path = System.getProperty("thinkervcb2b2c.root")
		// + File.separator + "luence" + File.separator + "goods";
		// File file = new File(goods_lucene_path);
		// if (!file.exists()) {
		// CommUtil.createFolder(goods_lucene_path);
		// }
		// //LuceneUtil lucene = LuceneUtil.instance();
		// //luceneUtil.setIndex_path(goods_lucene_path);
		// luceneUtil.delete_index(GoodsDocument.class,CommUtil.null2String(id));
		// // 发送站内短信提醒卖家
		// if (goods.getGoods_type() == 1) {
		// this.send_site_msg(request,
		// "msg_toseller_goods_delete_by_admin_notify", goods
		// .getGoods_store().getUser(), goods,
		// "商城存在违规");
		// }
		// }
		// }
		return "redirect:goods_list.htm";
	}

	@SuppressWarnings("unused")
	private void send_site_msg(HttpServletRequest request, String mark, Seller user, Goods goods,
			String reason) throws Exception {
		Template template = this.templateService.getObjByMark(mark);
		if (template.getOpen()) {
			ExpressionParser exp = new SpelExpressionParser();
			EvaluationContext context = new StandardEvaluationContext();
			context.setVariable("reason", reason);
			context.setVariable("user", user);
			context.setVariable("config", this.configService.getSysConfig());
			context.setVariable("send_time", CommUtil.formatLongDate(new Date()));
			Expression ex = exp.parseExpression(template.getContent(), new SpelTemplate());
			String content = ex.getValue(context, String.class);
			Message msg = new Message();
			msg.setAddTime(new Date());
			msg.setContent(content);
			msg.setFromUserId(SecurityUserHolder.getCurrentUser().getId());;
			msg.setTitle(template.getTitle());
			msg.setToUserId(user.getUid());
			msg.setType(0);
			this.messageService.save(msg);
		}
	}

	@SuppressWarnings("rawtypes")
	@SecurityMapping(title = "商品AJAX更新", value = "/admin/goods_ajax.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_ajax.htm")
	public void goods_ajax(HttpServletRequest request, HttpServletResponse response, String id,
			String fieldName, String value) throws ClassNotFoundException {
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
		if (fieldName.equals("storeRecommend")) {
			if (obj.getStoreRecommend() != null && obj.getStoreRecommend()) {
				obj.setStoreRecommendTime(new Date());
			} else
				obj.setStoreRecommendTime(null);
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

	@SuppressWarnings("unchecked")
	@SecurityMapping(title = "商品审核", value = "/admin/goods_audit.htm*", rtype = "admin", rname = "商品管理", rcode = "admin_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_audit.htm")
	public String goods_audit(HttpServletRequest request, HttpServletResponse response, String mulitId,
			String status, String selfAddPrice, String cnSelfAddPrice, String cnNeedYgb, String cnNeedMoney,
			String intentoryDetails) throws ClassNotFoundException {
		String ids[] = mulitId.split(",");
		for (String id : ids) {
			if (id != null) {
				Goods obj = this.goodsService.getObjById(CommUtil.null2Long(id));
				if("1".equals(String.valueOf(obj.getIsYgb()))){
					//云购币专区的商品不需要审核
					continue;
				}
				if (GoodsConstants.GOODS_INVENTORY_TYPE_SPEC.equals(obj.getInventoryType())
						&& StringUtils.isNotEmpty(intentoryDetails)) {
					Map<String, Map<String, String>> selfMap = new HashMap<>();
					if (StringUtils.isNotBlank(intentoryDetails)) {
						String[] idsArr = intentoryDetails.split(";");
						if (ArrayUtils.isNotEmpty(idsArr)) {
							for (int i = 0; i < idsArr.length; i++) {
								String[] specDetailArr = idsArr[i].split(",");
								if (specDetailArr.length != 5) {
									continue;
								}
								String idDetail = specDetailArr[0];
								String idDetail1 = this.goodsService.arraySortId(idDetail);
								String selfAdd = specDetailArr[1];
								String needYgb = specDetailArr[2];
								String needMoney = specDetailArr[3];
								String cnSelfAdd = specDetailArr[4];

								Map<String, String> map = new HashMap<>();
								map.put("idDetail", idDetail1);
								map.put("selfAdd", selfAdd);
								map.put("needYgb", needYgb);
								map.put("needMoney", needMoney);
								map.put("cnSelfAdd", cnSelfAdd);
								selfMap.put(idDetail1, map);
							}
						}
					}
					List<Map<String, String>> list = Json.fromJson(ArrayList.class,obj.getGoodsInventoryDetail());
					List<Map<String, String>> newList = new ArrayList<>();
					obj.setExPriceFlag(0);
					
					for (int i = 0; i < list.size(); i++) {
						
						Map<String, String> mapTemp = list.get(i);
						String currentId = mapTemp.get("id");
						System.out.println(currentId);
						
						if (selfMap.get(currentId) != null) {
							Map<String, String> map = selfMap.get(currentId);
							Double addPrice = StringUtils.isNotBlank(map.get("selfAdd")) ? Double
									.parseDouble(map.get("selfAdd")) : 0d;
							Double needYgb = StringUtils.isNotBlank(map.get("needYgb")) ? Double
									.parseDouble(map.get("needYgb")) : 0d;
							Double needMoney = StringUtils.isNotBlank(map.get("needMoney")) ? Double
									.parseDouble(map.get("needMoney")) : 0d;
							Double cnSelfAdd = StringUtils.isNotBlank(map.get("cnSelfAdd")) ? Double
									.parseDouble(map.get("cnSelfAdd")) : 0d;

							Double oldPrice = Double.parseDouble(mapTemp.get("price"));
							Double oldAddPrice = (null == mapTemp.get("selfAddPrice")) ? 0d : Double
									.parseDouble(mapTemp.get("selfAddPrice"));
							Double newPrice = oldPrice + addPrice - oldAddPrice;
							mapTemp.put("selfAddPrice", String.valueOf(addPrice));
							mapTemp.put("price", String.valueOf(newPrice));
							mapTemp.put("needYgb", String.valueOf(needYgb));
							mapTemp.put("needMoney", String.valueOf(needMoney));
							mapTemp.put("cnSelfAddPrice", String.valueOf(cnSelfAdd));
							if (needYgb > 0) {
								mapTemp.put("exPriceFlag", "1");
								obj.setExPriceFlag(1);
							} else {
								mapTemp.put("exPriceFlag", "0");
							}
							System.out.println(i);
							
							
							newList.add(i, mapTemp);
						}
					}
					obj.setGoodsInventoryDetail(Json.toJson(newList, JsonFormat.compact()));
				} else {
					BigDecimal selfAddPriceBig = BigDecimal.ZERO;
					if (obj.getSelfAddPrice() != null) {
						selfAddPriceBig = new BigDecimal(selfAddPrice).subtract(obj.getSelfAddPrice());
					}
					obj.setGoodsCurrentPrice(selfAddPriceBig.add(obj.getGoodsCurrentPrice()));
					obj.setStorePrice(selfAddPriceBig.add(obj.getStorePrice()));
					obj.setGoodsPrice(selfAddPriceBig.add(obj.getGoodsPrice()));
					obj.setSelfAddPrice(new BigDecimal(selfAddPrice));
					obj.setSelfAddPriceLog(new BigDecimal(selfAddPrice));
					if (StringUtils.isNotBlank(cnNeedYgb)) {
						obj.setNeedYgb(new BigDecimal(cnNeedYgb));
					} else {
						obj.setNeedYgb(BigDecimal.ZERO);
					}
					if (StringUtils.isNotBlank(cnNeedMoney)) {
						obj.setNeedMoney(new BigDecimal(cnNeedMoney));
					} else {
						obj.setNeedMoney(BigDecimal.ZERO);
					}
					if (StringUtils.isNotBlank(cnSelfAddPrice)) {
						obj.setCnSelfAddPrice(new BigDecimal(cnSelfAddPrice));
					} else {
						obj.setCnSelfAddPrice(BigDecimal.ZERO);
					}
					if (obj.getNeedYgb().compareTo(BigDecimal.ZERO) > 0) {
						obj.setExPriceFlag(1);
					} else {
						obj.setExPriceFlag(0);
					}
				}
				obj.setGoodsStatus(obj.getPublishGoodsStatus());// 设置商品发布审核后状态
				goodsService.update(obj);

				if (obj.getGoodsStatus() == 0) {
					// 更新lucene索引
					LuceneVo vo = this.luceneVoTools.updateGoodsIndex(obj);
					luceneUtil.update(CommUtil.null2String(obj.getId()), vo);
				} else {
					luceneUtil.delete_index(GoodsDocument.class, CommUtil.null2String(id));
				}
			}
		}
		return "redirect:goods_list.htm?status=" + status;
	}

	@SecurityMapping(title = "审核商品(不通过界面)", value = "/admin/goods_check_n_form.htm*", rtype = "admin", rname = "商品管理（审核）", rcode = "admin_check_goods", rgroup = "商城管理")
	@RequestMapping("/admin/goods_check_n_form.htm")
	public ModelAndView goods_check_n_form(HttpServletRequest request, HttpServletResponse response, Long id,
			Integer status) {
		ModelAndView mv = new JModelAndView("admin/blue/goods_check_n_form.html",
				configService.getSysConfig(), 0, request, response);
		mv.addObject("id", id);
		return mv;
	}

	@SecurityMapping(title = "审核商品(不通过)", value = "/admin/do_goods_check_n_form.htm*", rtype = "admin", rname = "商品管理（审核）", rcode = "admin_check_goods", rgroup = "商城管理")
	@RequestMapping("/admin/do_goods_check_n_form.htm")
	public ModelAndView do_goods_check_n_form(HttpServletRequest request, HttpServletResponse response,
			Long id, Integer goodState, String remark) {
		ModelAndView mv = new ModelAndView("redirect:goods_list.htm");
		Goods goods = new Goods();
		goods.setId(Long.valueOf(id));
		goods.setRemark(remark);
		goods.setGoodsStatus(goodState);
		this.goodsService.updateGoodStateByID(goods);
		return mv;
	}

}