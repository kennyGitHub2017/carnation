package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.nutz.json.Json;
import org.nutz.json.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneResult;
import vc.thinker.b2b2c.lucene.LuceneUtil;
import vc.thinker.b2b2c.lucene.WordFind;

import com.alibaba.fastjson.JSON;
import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.HelperUtils;
import com.sinco.api.util.JsoupUtils;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.evaluate.service.EvaluateService;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsCaseBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsPhotoBO;
import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsCase;
import com.sinco.carnation.goods.service.GoodsCaseService;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.ZeroGoodsService;
import com.sinco.carnation.goods.tools.GoodsViewTools;
import com.sinco.carnation.goods.vo.GoodsCaseVO;
import com.sinco.carnation.goods.vo.GoodsClassCountVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.order.service.OrderFormService;
import com.sinco.carnation.resource.bo.search.ShopLuceneResultBO;
import com.sinco.carnation.resource.bo.shop.GoodsClassBo;
import com.sinco.carnation.resource.bo.shop.GoodsConsultBO;
import com.sinco.carnation.resource.bo.shop.GoodsInventoryDetail;
import com.sinco.carnation.resource.bo.shop.GoodsProperty;
import com.sinco.carnation.resource.bo.shop.ShopEvaluateBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsCaseBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsPhotoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsSpecProperty;
import com.sinco.carnation.resource.bo.shop.ShopGoodsSpecification;
import com.sinco.carnation.resource.bo.shop.ShopStoreBO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.shop.ShopConsultVO;
import com.sinco.carnation.resource.vo.shop.ShopEvalualteVO;
import com.sinco.carnation.resource.vo.shop.ShopGoodsClassVO;
import com.sinco.carnation.resource.vo.shop.ShopGoodsLikeVO;
import com.sinco.carnation.resource.vo.shop.ShopGoodsVO;
import com.sinco.carnation.resource.vo.shop.ShopIndexVo;
import com.sinco.carnation.resource.vo.shop.ShopYouGoodsLikeVO;
import com.sinco.carnation.resource.vo.shop.YunGouGoodsVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.shop.ShopGoodsDetailsResponse;
import com.sinco.carnation.resource.web.response.shop.ShopIndexResponse;
import com.sinco.carnation.shop.bo.ConsultBO;
import com.sinco.carnation.shop.bo.EvaluateBO;
import com.sinco.carnation.shop.bo.UserSawGoodsBO;
import com.sinco.carnation.shop.dao.UserSawGoodsDao;
import com.sinco.carnation.shop.model.Consult;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.service.ConsultService;
import com.sinco.carnation.shop.tools.ConsultViewTools;
import com.sinco.carnation.shop.vo.EvaluateVO;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.carnation.user.bo.UserCustomerBO;
import com.sinco.carnation.user.service.UserCustomerService;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.model.DicBase;

import edu.emory.mathcs.backport.java.util.Collections;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "商城首页", namespace = "shop")
public class IndexShopAction extends BasicApiController {

	@SuppressWarnings("unused")
	private final Logger log = LoggerFactory.getLogger(IndexShopAction.class);

	@Autowired
	private GoodsCaseService goodsCaseService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsClassService goodsClassService;

	@Autowired
	private EvaluateService evaluateService;

	@Autowired
	private Mapper mapper;

	@Autowired
	private ConsultViewTools consultViewTools;

	@Autowired
	private GoodsViewTools goodsViewTools;

	@Autowired
	private SysConfigService configService;

	@Autowired
	private UserCustomerService userCustomerService;

	@Autowired
	private ConsultService consultService;

	@Autowired
	private StoreService storeService;
	@Autowired
	private WordFind wordFind;
	@Autowired
	private ZeroGoodsService zeroGoodsService;
	@Autowired
	private OrderFormService orderFormService;
	@Autowired
	private UserAccountService userAccountService;
	@Autowired
	private LuceneUtil luceneUtil;
	@Autowired
	private UserSawGoodsDao userSawGoodsDao;
	
	@Autowired
	private JuanpiGoodsService juanpiGoodsService;

	@RequestMapping(value = "/case/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商城首页橱窗列表")
	public @ResponseBody
	ShopIndexResponse goodsCaseList(@Valid @ModelAttribute @Param ShopIndexVo vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		MyPage<GoodsCaseBO> page = new MyPage<GoodsCaseBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		GoodsCaseVO caseVo = new GoodsCaseVO();
		caseVo.setDisplay("0");
		goodsCaseService.findPageByVO(caseVo, page);

		List<ShopGoodsCaseBo> list = MapperUtils.map(mapper, page.getContent(), ShopGoodsCaseBo.class);
		response.setGoodsCaseList(list);
		response.setTotalSize(page.getSize());
		return response;
	}

	@RequestMapping(value = "/goods/case/list", method = RequestMethod.POST)
	@MethodMapping(desc = "橱窗商品列表")
	@SuppressWarnings("rawtypes")
	public @ResponseBody
	ShopIndexResponse goodsCaseGoodsList(@Valid @RequestParam(value = "id") @Param(desc = "橱窗id") Long id,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		if (null == id) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		GoodsCase goodsCase = goodsCaseService.getObjById(id);
		List<Goods> list = new ArrayList<Goods>();
		if (goodsCase != null && StringUtils.isNotBlank(goodsCase.getCaseContent())) {
			List ids = (List) Json.fromJson(goodsCase.getCaseContent());
			for (Object goodsId : ids) {
				GoodsBO goods = goodsService.getGoodsBOById(CommUtil.null2Long(goodsId));
				// 上架商品
				if (goods != null && goods.getGoodsStatus() == 0) {
					list.add(goods);
				}
			}
		}
		List<ShopGoodsBo> goodsList = MapperUtils.map(mapper, list, ShopGoodsBo.class);
		for (ShopGoodsBo shopGoodsBo : goodsList) {
			if (shopGoodsBo.getMobilePrice() == null) {
				if (shopGoodsBo.getHasMobilePrice()) {
					shopGoodsBo.setMobilePrice(shopGoodsBo.getGoodsMobilePrice());
				}
			}

		}
		response.setGoodsList(goodsList);
		response.setTotalSize(goodsList.size());
		return response;
	}

	@RequestMapping(value = "/goods/class/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商品分类列表")
	public @ResponseBody
	ShopIndexResponse goodsClassList(@Valid @ModelAttribute @Param ShopGoodsClassVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 第一级分类
		if (vo.getClassNum() == 1) {
			goodsClassService.refreshDicCache();
			List<GoodsClassBO> list = goodsClassService.rootGoodsClassList();
			Collections.sort(list, new Comparator<GoodsClassBO>() {
				public int compare(GoodsClassBO arg0, GoodsClassBO arg1) {
					return arg0.getSequence().compareTo(arg1.getSequence());
				}
			});
			List<GoodsClassBO> resultList = new ArrayList<>();
			for (GoodsClassBO bo : list) {// 过滤类型为不显示的
				if (bo.getDisplay()) {
					resultList.add(bo);
				}
			}
			List<GoodsClassBo> firstGoodsClassList = MapperUtils.map(mapper, resultList, GoodsClassBo.class);

			response.setGoodsClassList(firstGoodsClassList);
		}
		// 第二级分类
		if (vo.getClassNum() == 2) {
			if (null != vo.getClassId()) {
				List<DicBase> list = goodsClassService.childGoodsClassList(CommUtil.null2String(vo
						.getClassId()));

				Collections.sort(list, new Comparator<GoodsClassBO>() {
					public int compare(GoodsClassBO arg0, GoodsClassBO arg1) {
						return arg0.getSequence().compareTo(arg1.getSequence());
					}
				});

				List<GoodsClassBo> listGoodsClass = MapperUtils.map(mapper, list, GoodsClassBo.class);
				response.setGoodsClassList(listGoodsClass);
			}
		}
		// 第二级分类
		if (vo.getClassNum() == 3) {
			if (null != vo.getClassId()) {
				List<DicBase> list = goodsClassService.childGoodsClassList(CommUtil.null2String(vo
						.getClassId()));

				Collections.sort(list, new Comparator<GoodsClassBO>() {
					public int compare(GoodsClassBO arg0, GoodsClassBO arg1) {
						return arg0.getSequence().compareTo(arg1.getSequence());
					}
				});

				List<GoodsClassBo> listGoodsClass = MapperUtils.map(mapper, list, GoodsClassBo.class);
				response.setGoodsClassList(listGoodsClass);
			}
		}

		return response;
	}

	@RequestMapping(value = "/goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "第三级分类下的商品列表")
	public @ResponseBody
	ShopIndexResponse goodsList(@Valid @ModelAttribute @Param ShopGoodsVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		MyPage<GoodsBO> page = new MyPage<GoodsBO>();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// 设置分类id
		Set<Long> classIdSet = new HashSet<Long>();
		classIdSet.add(vo.getClassId());
		GoodsVO goodsVO = new GoodsVO();
		goodsVO.setGoodsClassIds(classIdSet);
		// 分类商品列表
		goodsVO.setIsYgb(0);// 非云购币产品
		goodsService.selectGoodsListByVO(page, goodsVO);

		List<ShopGoodsBo> goodsBos = MapperUtils.map(mapper, page.getContent(), ShopGoodsBo.class);
		response.setGoodsList(goodsBos);
		response.setTotalSize(page.getSize());
		return response;
	}

	@RequestMapping(value = "/like/goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "猜你喜欢的商品列表")
	public @ResponseBody
	ShopIndexResponse likeGoods(@Valid @ModelAttribute @Param ShopGoodsLikeVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		Long your_like_GoodsClass = null;
		List<GoodsBO> your_like_goods = new ArrayList<GoodsBO>();
		// 如果likeGcid不为空，则把商品对象加入list
		if (StringUtils.isNotBlank(vo.getLikeIds())) {
			String[] ids = vo.getLikeIds().split(",");
			for (String id : ids) {
				Goods goods = goodsService.getObjById(CommUtil.null2Long(id));
				if (goods == null)
					break;
				your_like_GoodsClass = goods.getGcId();
				your_like_goods = this.goodsService.selectGoodsYourLike(your_like_GoodsClass, goods.getId(),0, 8, null, null);
						
				int gcs_size = your_like_goods.size();
				if (gcs_size < 20) {
					List<GoodsBO> like_goods = this.goodsService.selectGoodsYourLike(null, goods.getId(), 0,4, null, null);
				
					for (int i = 0; i < like_goods.size(); i++) {
						// 去除重复商品
						int k = 0;
						for (int j = 0; j < your_like_goods.size(); j++) {
							if (like_goods.get(i).getId().equals(your_like_goods.get(j).getId())) {
								k++;
							}
						}
						if (k == 0) {
							your_like_goods.add(like_goods.get(i));
						}
					}
					
					List<JuanpiGoodsBO> juanpiGoodsBO = this.juanpiGoodsService.selectByRand(0, 4);
					for (JuanpiGoodsBO bo : juanpiGoodsBO) {
						GoodsBO goodsBO = new GoodsBO();
						goodsBO.setIsJuanpi(1);
						goodsBO.setGoodsName(bo.getGoodsTitle());
						goodsBO.setTargetUrlM(bo.getTargetUrlM());
						goodsBO.setGoodsShowPrice(bo.getGoodsCprice());
						goodsBO.setId(bo.getId());
						goodsBO.setInventoryType("juanpi");
						goodsBO.setGoodsCurrentPrice(bo.getGoodsCprice());
						goodsBO.setGoodsMainPhotoPath(bo.getImageUrl());
						your_like_goods.add(goodsBO);
					}
					
				}
				break;
			}
		} else {
			your_like_goods = this.goodsService.selectGoodsYourLike(null, null, 0, 8, null, null);
		}
		Map<Long, BigDecimal> map = new HashMap<Long, BigDecimal>();
		for (GoodsBO good : your_like_goods) {
			boolean exPriceFlag = good.getExPriceFlag() != null && good.getExPriceFlag() == 1 ? true : false;
			boolean boo = good.getCnSelfAddPrice() != null
					&& good.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
			if (exPriceFlag && boo) {
				map.put(good.getId(), good.getCnSelfAddPrice());
			}
		}
		List<ShopGoodsBo> list = MapperUtils.map(mapper, your_like_goods, ShopGoodsBo.class);
		for (ShopGoodsBo shopGoods : list) {
			Long goodID = shopGoods.getId();
			BigDecimal bv = BigDecimal.ZERO;
			if (map.containsKey(goodID)) {
				bv = map.get(goodID);
			}
			shopGoods.setBv(bv);
		}
//		List<ShopGoodsBo> list = MapperUtils.map(mapper, your_like_goods, ShopGoodsBo.class);
		response.setGoodsLikeList(list);
		return response;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/goods/details", method = RequestMethod.POST)
	@MethodMapping(desc = "商品详情")
	public @ResponseBody
	ShopGoodsDetailsResponse goodsDetails(
			@Valid @RequestParam(value = "goodsId") @Param(desc = "商品id") Long goodsId,
			@Param(desc = "用户id") Long uid,
			HttpServletRequest request) {

		ShopGoodsDetailsResponse response = new ShopGoodsDetailsResponse();
		if (goodsId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}
		if(null == uid || uid == 0L){
			uid = ActionsUtil.getOwnerUid();
		}
		
		this.goodsService.saveUserSawGoods(uid,goodsId);
		boolean isCN = userAccountService.check_User_Is_CN(uid);
		// 查询商品
		GoodsBO goods = this.goodsService.getFullGoodsById(goodsId);
		String warnInfo = "";
		if (goods != null && goods.getGoodsStatus() == 0) {
			
			if(uid != null){//检查用户积分是否足够购买商品	
				Double needIntegral = 0.00;
				try {
					needIntegral = goods.getNeedIntegral().doubleValue();
				} catch (Exception e) {
				}
				if(needIntegral>0){
					Integer userIntegral = 0;
					if(isCN){
						
					}else{
						UserCustomerBO user = userCustomerService.findSessionUser(uid);
						if(null != user){
							userIntegral = user.getIntegral();
						}
						if(needIntegral>userIntegral){
							warnInfo="积分不够！";
						}
					}
				}
			}
			
			try {
				
				//设置goodsDetailsMobile，goodsDetails 两个HTML样式，防止出现图片间隔
				String imgStyle="<style>img{vertical-align: middle;}</style>";
				goods.setGoodsDetails(goods.getGoodsDetails()==null?"":imgStyle+goods.getGoodsDetails());
				goods.setGoodsDetailsMobile(goods.getGoodsDetailsMobile()==null? "":imgStyle+imgStyle+goods.getGoodsDetailsMobile());
				
				if (goods.getGoodsType() == 1) {
					// goods.setGoodsPrice(goods.getGoodsPrice().subtract(goods.getSelfAddPrice()));
				}

				String inventory_type = goods.getInventoryType();
				if (StringUtils.isBlank(inventory_type)) {
					inventory_type = "all";
				}
				if (inventory_type.equals("spec") && goods.getGoodsType() == 1) {
					goods.getGoodsShowPrice();
					BigDecimal goodsPrice = goods.getGoodsPrice().add(goods.getSelfAddPrice());
					goods.setGoodsPrice(goodsPrice); // 商品原价
				}

				ZeroGoods zeroGoods = this.zeroGoodsService.getByGoodsId(goodsId);
				if (null != zeroGoods && zeroGoods.getGoodsStatus()) // O云购商品
				{

					goods.setStorePrice(zeroGoods.getGoodsPrice());
					goods.setGoodsMobilePrice(zeroGoods.getGoodsPrice());
					goods.setMobilePrice(zeroGoods.getGoodsPrice());
					goods.setGoodsCurrentPrice(zeroGoods.getGoodsPrice());
					goods.setExpressTransFee(zeroGoods.getShipFee());
					goods.setGoodsInventory(zeroGoods.getGoodsInventory());
					goods.setHasMobilePrice(false);
					goods.setGoodsTransfee(0);
					response.setZeroFlag(1);// 0元购标识
				}
				/**
				 * 商品有多规格时 显示云购币+现金 BV值
				 */
				String goodsInventoryDetail = goods.getGoodsInventoryDetail();
				Map<String, JSONObject> jsonMap = new HashMap<String, JSONObject>();
				Map<String, Double> priceMap = new HashMap<String, Double>();
				List<Double> priceList = new ArrayList<Double>();
				if (goodsInventoryDetail != null && goodsInventoryDetail.length() > 0) {
					JSONArray jsonArr = JSONArray.fromObject(goodsInventoryDetail);
					int size = jsonArr.size();
					if (size > 0) {
						for (int i = 0; i < size; i++) {
							JSONObject json = jsonArr.getJSONObject(i);
							if (json.containsKey("id")) {
								String id = json.getString("id");
								jsonMap.put(id, json);
								if (json.containsKey("price")) {
									priceMap.put(id, new Double(json.getString("price")));
									priceList.add(new Double(json.getString("price")));
								}
							}

						}
						if (priceList.size() > 0) {
							Collections.sort(priceList);
							Double bigPrice = priceList.get(0);
							Iterator<Map.Entry<String, Double>> entries = priceMap.entrySet().iterator();
							while (entries.hasNext()) {
								Map.Entry<String, Double> entry = entries.next();
								if (entry.getValue().equals(bigPrice)) {
									String key = entry.getKey();
									JSONObject jsonObj = jsonMap.get(key);
									if (jsonObj.containsKey("needYgb")) {
										BigDecimal needYgb = new BigDecimal(jsonObj.getString("needYgb"));
										goods.setNeedYgb(needYgb);
									}
									if (jsonObj.containsKey("needMoney")) {
										BigDecimal needMoney = new BigDecimal(jsonObj.getString("needMoney"));
										goods.setNeedMoney(needMoney);
									}
//									if(jsonObj.containsKey("cnSelfAddPrice"))
//									{
//										BigDecimal cnSelfAddPrice = new BigDecimal(jsonObj.getString("cnSelfAddPrice"));
//										goods.setCnSelfAddPrice(cnSelfAddPrice);
//									}
									break;
								}
							}
						}
					}
				}
				Integer proType = 0 ;
				if(null != goods.getNeedIntegral() && null != goods.getNeedYgb() && goods.getIsYgb() == 1){
					proType = goodsService.proType(goods.getNeedIntegral(), goods.getNeedYgb(), goods.getIsYgb());
				}
				if(!isCN && (proType == 2 || proType == 3)){//会员不是CN会员 并且商品是积分支付商品
					proType = 4;
				}
				ShopGoodsBo shopGoodsBo = mapper.map(goods, ShopGoodsBo.class);
				shopGoodsBo.setProType(proType);
				shopGoodsBo.setHasYgb(false);
				// 是否云购币
				if (goods.getIsYgb() == 1) {
					shopGoodsBo.setHasYgb(true);
				}
				/**
				 * 商品：BV值
				 */
				BigDecimal BV = BigDecimal.ZERO;
				boolean is_cn_self_add_price = goods.getCnSelfAddPrice() != null
						&& goods.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
				boolean isFlay = goods.getExPriceFlag() != null && goods.getExPriceFlag() == 1 ? true : false;
				if (is_cn_self_add_price && isFlay) {
					BV = goods.getCnSelfAddPrice();
				}
				shopGoodsBo.setBv(BV);
				/**
				 * 商品：现金 云购币
				 */
				BigDecimal needMoney = goods.getNeedMoney();
				boolean isCase = needMoney != null && needMoney.compareTo(BigDecimal.ZERO) == 1 ? true
						: false;
				BigDecimal ygb = goods.getNeedYgb();
				boolean isYgb = ygb != null && ygb.compareTo(BigDecimal.ZERO) == 1 ? true : false;
				BigDecimal cash = BigDecimal.ZERO;
				BigDecimal yunGouBi = BigDecimal.ZERO;
				if (isCase || isYgb) {
					cash = needMoney;
					yunGouBi = ygb;
				}
				if(isYgb){
					shopGoodsBo.setGoodsTransfee(0);//精选专区商品都是不包邮的
				}
				shopGoodsBo.setCash(cash);
				shopGoodsBo.setYunGouBi(yunGouBi);
				// 统一取值 add by yuleijia
				shopGoodsBo.setStorePrice(shopGoodsBo.getGoodsShowPrice());
				shopGoodsBo.setGoodsCurrentPrice(shopGoodsBo.getGoodsShowPrice());

				if (shopGoodsBo.getMobilePrice() == null) {
					if (shopGoodsBo.getHasMobilePrice()) {
						shopGoodsBo.setMobilePrice(shopGoodsBo.getGoodsMobilePrice());
					}
				}

				// 设置app图文清单模版
				shopGoodsBo.setGoodsDetails(JsoupUtils.queryHtml(goods.getGoodsDetails()));

				// 将商品属性归类,便于前台显示
				List<GoodsSpecificationBO> ficationList = goodsViewTools.generic_spec(CommUtil
						.null2String(goods.getId()));
				List<ShopGoodsSpecification> fictionBo = MapperUtils.map(mapper, ficationList,
						ShopGoodsSpecification.class);
				shopGoodsBo.setCationList(fictionBo);

				ZeroGoods resZeroGoods = this.zeroGoodsService.getByGoodsId(goodsId);
				if (null != resZeroGoods && resZeroGoods.getGoodsStatus()) // O云购商品，去掉规格
				{
					shopGoodsBo.setCationList(null);
				}

				// 商品图片
				List<GoodsPhotoBO> goodsPhotosList = goods.getGoodsPhotosList();
				List<ShopGoodsPhotoBO> photoList = MapperUtils.map(mapper, goodsPhotosList,
						ShopGoodsPhotoBO.class);
				shopGoodsBo.setGoodsPhotosList(photoList);

				// 商品规格
				List<GoodsSpecPropertyBO> goodsSpecsList = goods.getGoodsSpecsList();
				List<ShopGoodsSpecProperty> propertyList = MapperUtils.map(mapper, goodsSpecsList,
						ShopGoodsSpecProperty.class);
				shopGoodsBo.setFicPropertyList(propertyList);

				// 商品sku
				if (StringUtils.isNotBlank(goods.getGoodsInventoryDetail())) {
					List<GoodsInventoryDetail> detail = JSON.parseArray(goods.getGoodsInventoryDetail(),
							GoodsInventoryDetail.class);
					shopGoodsBo.setDetail(detail);
				}
				// 商品属性
				if (StringUtils.isNotBlank(goods.getGoodsProperty())) {
					List<GoodsProperty> property = JSON.parseArray(goods.getGoodsProperty(),
							GoodsProperty.class);
					shopGoodsBo.setProperty(property);
				}

				// 商品店铺
				if (goods.getGoodsStoreId() != null) {
					StoreBO storeBO = storeService.getObjById(goods.getGoodsStoreId());
					if (storeBO != null && StringUtils.isNotBlank(storeBO.getStoreName())) {
						shopGoodsBo.setGoodsStoreName(storeBO.getStoreName());
						shopGoodsBo.setStorePhoto(storeBO.getStoreLogoPath());
					}
					// 折扣
					if (storeBO != null && storeBO.getIsO2o()) {
						if (storeBO.getGroupDiscount() != null && shopGoodsBo.getGoodsMobilePrice() != null
								&& storeBO.getGroupDiscount().compareTo(BigDecimal.ZERO) == 1) {
							BigDecimal discount = shopGoodsBo.getGoodsMobilePrice().multiply(
									storeBO.getGroupDiscount());
							shopGoodsBo.setDiscount(shopGoodsBo.getGoodsMobilePrice().subtract(discount));
						} else {
							shopGoodsBo.setDiscount(BigDecimal.ZERO);
						}
					}
					/**
					 * 店铺Logo
					 */
					String webPath = CommUtil.getURL(request);
					String storeLogo = webPath + "/resources/default/logo.jpg";
					String storeLogPath = storeBO.getStoreLogoPath();
					if (storeLogPath != null) {
						storeLogo = storeLogPath;
					}
					shopGoodsBo.setStoreLogo(storeLogo);
					
					if(null != storeBO && storeBO.getStoreStatus()!=15){
						warnInfo ="商品下架,添加失败";
					}
				}

				// 商品主图+相册图片
				if (shopGoodsBo != null) {
					String path = goodsService.getPhotoListByGoodId(shopGoodsBo.getId());
					shopGoodsBo.setGoodsMainPhotoPath(shopGoodsBo.getGoodsMainPhotoPath()/*+";"+path*/);
				}
				response.setWarnInfo(warnInfo);
				response.setGoodsDetails(shopGoodsBo);
			} catch (Exception e) {
				response.putErrorMessage("5.shop.goodsDetails.transfor_mation");
			}
		} else {
			response.putErrorMessage("4.shop.goodsDetails.goods_time_got");
			return response;
		}
		return response;
	}

	@RequestMapping(value = "/goods/evaluate", method = RequestMethod.POST)
	@MethodMapping(desc = "商品评论列表")
	public @ResponseBody
	ShopGoodsDetailsResponse shopGoodsEvaluate(@Valid @ModelAttribute @Param ShopEvalualteVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopGoodsDetailsResponse response = new ShopGoodsDetailsResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		// 设置分页
		MyPage<EvaluateBO> page = new MyPage<EvaluateBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		// 设置参数
		EvaluateVO evVo = new EvaluateVO();
		evVo.setEvaluateType(vo.getEvaluateType());
		evVo.setEvaluateGoodsId(vo.getGoodsId());
		evVo.setEvaluateStatus(0);
		if (!CommUtil.null2String(vo.getGoodsEva()).equals("")) {
			if (vo.getGoodsEva().equals("100")) {
				evVo.setEvaluatePhotos("");
			} else {
				evVo.setEvaluateBuyerVal(CommUtil.null2Int(vo.getGoodsEva()));
			}
		}
		evaluateService.queryEvaluateListByVO(evVo, page);
		List<ShopEvaluateBO> list = MapperUtils.map(mapper, page.getContent(), ShopEvaluateBO.class);
		response.setShopEvaluateList(list);
		response.setTotalSize(page.getTotalElements());
		return response;
	}

	@RequestMapping(value = "/goods/consult/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商品咨询列表")
	public @ResponseBody
	ShopGoodsDetailsResponse goodsConsultList(
			@Valid @RequestParam(value = "consulType") @Param(desc = "咨询类型|0全部咨询1产品咨询|2库存及配送3支付及发票4售后咨询5促销活动") Integer consulType,
			@Valid @RequestParam(value = "goodsId") @Param(desc = "商品id|必填") Long goodsId) {
		ShopGoodsDetailsResponse response = new ShopGoodsDetailsResponse();

		if (goodsId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		List<ConsultBO> consultList = consultViewTools.queryByType(HelperUtils.consultTypeArray[consulType],
				CommUtil.null2String(goodsId));
		List<GoodsConsultBO> list = MapperUtils.map(mapper, consultList, GoodsConsultBO.class);
		response.setGoodsConsultList(list);
		return response;
	}

	@RequestMapping(value = "/shop/goods_consult/save", method = RequestMethod.POST)
	@MethodMapping(desc = "商品咨询保存")
	public @ResponseBody
	ShopGoodsDetailsResponse goods_consult_save(@Valid @ModelAttribute @Param ShopConsultVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopGoodsDetailsResponse response = new ShopGoodsDetailsResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		// 帖子内容有敏感词
		if (wordFind.find(vo.getContent()).length > 0) {
			response.putErrorMessage("5.invitation.goods_consult_save.word_fail");
			return response;
		}

		Long uid = ActionsUtil.getOwnerUid();
		if (uid == null) {
			response.putErrorMessage("3.user.feedList.rid_null");
			return response;
		}

		Consult obj = new Consult();
		GoodsBO goods = this.goodsService.getFullGoodsById(vo.getGoodsId());
		obj.setAddTime(new Date());
		obj.setConsultType("产品咨询");
		obj.setConsultContent(vo.getContent());
		UserCustomerBO userCustomerBO = userCustomerService.findSessionUser(uid);
		if (userCustomerBO != null) {
			obj.setConsultUserId(uid);
			obj.setConsultUserName(userCustomerBO.getNickname());
			obj.setConsultEmail(userCustomerBO.getEmail());
		} else {
			obj.setConsultUserName("游客");
		}
		List<Map<String, String>> maps = new ArrayList<Map<String, String>>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("goods_id", CommUtil.null2String(goods.getId()));
		map.put("goods_name", goods.getGoodsName());
		map.put("goods_main_photo", goods.getGoodsMainPhotoPath());
		map.put("goods_price", CommUtil.null2String(goods.getGoodsCurrentPrice()));
		String goods_domainPath = CommUtil.getURL(request) + "/goods_" + goods.getId() + ".htm";
		if (this.configService.getSysConfig().getSecondDomainOpen() && goods.getGoodsStore() != null
				&& goods.getGoodsStore().getStoreSecondDomain() != "" && goods.getGoodsType() == 1) {
			String store_second_domain = "http://" + goods.getGoodsStore().getStoreSecondDomain() + "."
					+ CommUtil.generic_domain(request);
			goods_domainPath = store_second_domain + "/goods_" + goods.getId() + ".htm";
		}
		map.put("goods_domainPath", goods_domainPath);// 商品二级域名路径
		maps.add(map);
		obj.setGoodsInfo(Json.toJson(maps, JsonFormat.compact()));
		obj.setGoodsId(goods.getId());
		if (goods.getGoodsStore() != null) {
			obj.setStoreId(goods.getGoodsStore().getId());
			obj.setStoreName(goods.getGoodsStore().getStoreName());
		} else {
			obj.setWhetherSelf(1);
		}
		consultService.save(obj);
		return response;
	}

	@RequestMapping(value = "/shop/store_info/get", method = RequestMethod.POST)
	@MethodMapping(desc = "店铺详情")
	public @ResponseBody
	ShopIndexResponse getStoreInfo(@Valid @RequestParam(value = "storeId") @Param(desc = "店铺id") Long storeId) {
		ShopIndexResponse response = new ShopIndexResponse();
		if (storeId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		StoreBO store = storeService.getObjById(storeId);
		ShopStoreBO storeBO = mapper.map(store, ShopStoreBO.class);
		if (store != null && store.getPoint() != null) {
			float storeDescription = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
			float storeService = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
			float storeShip = CommUtil.null2Float(store.getPoint().getShipEvaluate());
			storeBO.setStoreDescription(storeDescription);
			storeBO.setStoreService(storeService);
			storeBO.setStoreShip(storeShip);
		}

		response.setStoreInfo(storeBO);
		return response;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/like/you_goods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "猜你喜欢的商品列表")
	public @ResponseBody
	ShopIndexResponse likeYouGoods(@Valid @ModelAttribute @Param ShopYouGoodsLikeVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		List<GoodsBO> your_like_goods = new ArrayList<GoodsBO>();

		MyPage<GoodsBO> page = new MyPage<GoodsBO>();
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		LuceneResult pList = null;
		// 如果likeGcid不为空，则把商品对象加入list
		if (StringUtils.isNotBlank(vo.getLikeIds())) {
			String[] ids = vo.getLikeIds().split(",");
			Long[] longIds = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				if (i < vo.getPageSize()) {
					longIds[i] = CommUtil.null2Long(ids[i]);
				}
			}

			your_like_goods = goodsService.searchGoodsLikeByIds(longIds);
			if (your_like_goods.size() < vo.getPageSize()) {
				List<GoodsBO> like_goods = this.goodsService
						.searchGoodsYourLike(null, null, null, null, page);
				for (int i = 0; i < like_goods.size(); i++) {
					// 去除重复商品
					int k = 0;
					for (int j = 0; j < your_like_goods.size(); j++) {
						if (like_goods.get(i).getId().equals(your_like_goods.get(j).getId())) {
							k++;
						}
					}
					if (k == 0 && your_like_goods.size() < vo.getPageSize()) {
						your_like_goods.add(like_goods.get(i));
					}
				}

			}
		} else {
			Long uid = ActionsUtil.getOwnerUid();
			String queryGc = null;
			String juanpi_class = null;
			
			if (uid != null) {
				UserSawGoodsBO userSawGoodsBO = this.userSawGoodsDao.getByUid(CommUtil.null2Long(uid));
				juanpi_class = userSawGoodsBO.getClass3id();
				String[] ids = userSawGoodsBO.getClass3id().split(",");
				if (ids != null && ids.length >0) {
					GoodsClassBO goodsClassBO = this.goodsClassService.getBOById(CommUtil.null2Long(ids[0]));
					Long parentId = goodsClassBO.getParentId();
					queryGc = parentId+"_*";
				}
			}

			
			//your_like_goods = this.goodsService.searchGoodsYourLike(null, null, null, null, page);
			
				pList = luceneUtil.search(GoodsDocument.class, 
							null,
							CommUtil.null2Int(page.getCurrentPage() - 1),
							null, 
							null,
							queryGc,
							null,
							null, 
							null, null, null, null, false, 0, null, 
							null, juanpi_class);
			
				List<ShopLuceneResultBO> lucene = MapperUtils.map(mapper, pList.getVo_list(),ShopLuceneResultBO.class);
				//安桌IOS取字段不一致，重复操作
				if(lucene != null && lucene.size() > 0){
					for(ShopLuceneResultBO lu : lucene){
						lu.setVo_goods_price(new BigDecimal(lu.getVo_store_price()));
					}
				}
				response.setKeywordGoodsList(lucene);
			
		}
/*		Map<Long, BigDecimal> map = new HashMap<Long, BigDecimal>();
		for (GoodsBO good : your_like_goods) {
//			BigDecimal cnSelfAddPrice = good.getCnSelfAddPrice();
			boolean exPriceFlag = good.getExPriceFlag() != null && good.getExPriceFlag() == 1 ? true : false;
			boolean boo = good.getCnSelfAddPrice() != null
					&& good.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
			if (exPriceFlag && boo) {
				map.put(good.getId(), good.getCnSelfAddPrice());
			}
		}
		List<ShopGoodsBo> list = MapperUtils.map(mapper, pList.getVo_list(), ShopLuceneResultBO.class);
		for (ShopGoodsBo shopGoods : list) {
			Long goodID = shopGoods.getId();
			BigDecimal bv = BigDecimal.ZERO;
			if (map.containsKey(goodID)) {
				bv = map.get(goodID);
			}
			shopGoods.setBv(bv);
		}*/
		//response.setYouLikelist(list);
		
		
		return response;
	}

	@RequestMapping(value = "/goods/getOrderIsBought", method = RequestMethod.POST)
	@MethodMapping(desc = "检查是否购买过")
	public @ResponseBody
	ShopGoodsDetailsResponse getIsBought(
			@Valid @RequestParam(value = "goodsId") @Param(desc = "商品id") Long goodsId,
			HttpServletRequest request) {

		ShopGoodsDetailsResponse response = new ShopGoodsDetailsResponse();
		Long uid = ActionsUtil.getOwnerUid();
		boolean bl = this.orderFormService.isBought(null, uid, goodsId);
		if (!bl) {
			response.setIsBought(true);// 表示买过
		}
		return response;
	}

	@RequestMapping(value = "/yunGougoods/list", method = RequestMethod.POST)
	@MethodMapping(desc = "云购币商品列表")
	public @ResponseBody
	ShopIndexResponse yunGougoodsList(@Valid @ModelAttribute @Param YunGouGoodsVO vo, BindingResult result,
			HttpServletRequest request) {
		ShopIndexResponse response = new ShopIndexResponse();
		MyPage<GoodsBO> page = new MyPage<GoodsBO>();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}
		page.setPageNumber(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		// 设置分类id
		Set<Long> classIdSet = new HashSet<Long>();
		if (vo.getClassId() != null) {
			classIdSet.add(vo.getClassId());
		}
		GoodsVO goodsVO = new GoodsVO();
		goodsVO.setGoodsClassIds(classIdSet);
		// 分类商品列表
		goodsVO.setIsYgb(1);// 云购币产品
		
		// 判断账号是否为CN账号
		Long uid = ActionsUtil.getOwnerUid();
		boolean isCNAccount = userAccountService.check_User_Is_CN(uid);
		if(!isCNAccount){
			goodsVO.setHasIntegral(1);
		}
		goodsService.selectGoodsListByVO(page, goodsVO);
		List<ShopGoodsBo> goodsBos = MapperUtils.map(mapper, page.getContent(), ShopGoodsBo.class);
		for(ShopGoodsBo bo : goodsBos){
			bo.setProType(goodsService.proType(bo.getNeedIntegral(), bo.getNeedYgb(), 1));
		}
		response.setGoodsList(goodsBos);
		response.setTotalSize(page.getSize());
		return response;
	}

	@RequestMapping(value = "/goods/class/list/all", method ={RequestMethod.POST,RequestMethod.GET})
	@MethodMapping(desc = "所有商品分类列表")
	public ShopIndexResponse goodsClassListAll() {
		ShopIndexResponse response = new ShopIndexResponse();
		GoodsClassCountVO vo = new GoodsClassCountVO();
		vo.setLevel(0);
		List<GoodsClassBO> list0 = goodsClassService.findByCountVO(vo);
		vo.setLevel(1);
		List<GoodsClassBO> list1 = goodsClassService.findByCountVO(vo);
		vo.setLevel(2);
		List<GoodsClassBO> list2 = goodsClassService.findByCountVO(vo);

		List<GoodsClassBo> listMap0 = MapperUtils.map(mapper, list0, GoodsClassBo.class);
		List<GoodsClassBo> listMap1 = MapperUtils.map(mapper, list1, GoodsClassBo.class);
		List<GoodsClassBo> listMap2 = MapperUtils.map(mapper, list2, GoodsClassBo.class);
		for (GoodsClassBo parentBo : listMap1) {
			List<GoodsClassBo> childList = new ArrayList<>();
			for (GoodsClassBo childBo : listMap2) {
				if (null != childBo.getParentId()
						&& childBo.getParentId().intValue() == parentBo.getId().intValue()) {
					childList.add(childBo);
				}
			}
			parentBo.setChildList(childList);
		}

		for (GoodsClassBo parentBo : listMap0) {
			List<GoodsClassBo> childList = new ArrayList<>();
			for (GoodsClassBo childBo : listMap1) {
				if (null != childBo.getParentId()
						&& childBo.getParentId().intValue() == parentBo.getId().intValue()) {
					childList.add(childBo);
				}
			}
			parentBo.setChildList(childList);
		}
		response.setGoodsClassList(listMap0);
		return response;
	}
}