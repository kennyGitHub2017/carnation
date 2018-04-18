package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import vc.thinker.b2b2c.core.tools.CommUtil;
import vc.thinker.b2b2c.lucene.GoodsDocument;
import vc.thinker.b2b2c.lucene.LuceneResult;
import vc.thinker.b2b2c.lucene.LuceneUtil;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.bo.GoodsClassBO;
import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;
import com.sinco.carnation.goods.service.GoodsClassService;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsBO;
import com.sinco.carnation.juanpi.bo.JuanpiGoodsClassBO;
import com.sinco.carnation.juanpi.service.JuanpiGoodsClassService;
import com.sinco.carnation.juanpi.service.JuanpiGoodsService;
import com.sinco.carnation.resource.bo.search.SearchBO;
import com.sinco.carnation.resource.bo.search.ShopGoodsClassBO;
import com.sinco.carnation.resource.bo.search.ShopGoodsTypePropertyBO;
import com.sinco.carnation.resource.bo.search.ShopLuceneResultBO;
import com.sinco.carnation.resource.bo.search.ShopSearchGoodsBO;
import com.sinco.carnation.resource.vo.search.ShopSearchGoodsVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.response.search.ShopSearchResponse;
import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.contants.UserContant;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.sys.service.UserAccountService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "搜索", namespace = "search")
public class ShopSearchAction extends BasicApiController {

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private GoodsClassService goodsClassService;

	@Autowired
	private LuceneUtil luceneUtil;

	@Autowired
	private SysConfigService config;

	@Autowired
	private Mapper mapper;
	
	@Autowired
	private UserAccountService accountService;
	@Autowired
	private JuanpiGoodsClassService juanpiGoodsClassService;
	@Autowired
	private JuanpiGoodsService JuanpiGoodsService;
	
	@RequestMapping(value = "/search/class/goods", method = RequestMethod.POST)
	@MethodMapping(desc = "分类搜索")
	public @ResponseBody
	ShopSearchResponse searchClassGoods(@Valid @ModelAttribute @Param ShopSearchGoodsVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopSearchResponse response = new ShopSearchResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<GoodsBO> page = new MyPage<GoodsBO>();
		page.setCurrentPage(vo.getPageNum());
		page.setPageSize(vo.getPageSize());

		SearchBO searchBO = new SearchBO();
		
		if (vo != null && vo.getIsTuangou() != null && vo.getIsTuangou() ==1) {//大类搜索 并且 卷皮拼团 返回空
			return response;
		}

		// 品牌
		GoodsClassBO gc = goodsService.getFullGoodsClassByClassId(CommUtil.null2String(vo.getGcId()));
		GoodsVO goodsVO = mapper.map(vo, GoodsVO.class);
		/**
		 * 只看BV值
		 */
		Integer onlyCN = vo.getOnlyCN();
		if (onlyCN != null && onlyCN == 1) {
			goodsVO.setExPriceFlag(1);
		}
		// goodsVO.setGcId(vo.getGcId());// 商品对应的大分类
		goodsVO.setIsYgb(0);// 只能查询非云购币产品
		goodsService.queryGoodsByClass(goodsVO, gc, page);
		// 品牌
		ShopGoodsClassBO classBO = mapper.map(gc, ShopGoodsClassBO.class);
		searchBO.setClassBO(classBO);
		// 属性
		List<GoodsTypePropertyBO> filter = goodsVO.getFilterProperties();
		List<ShopGoodsTypePropertyBO> filterBoList = MapperUtils.map(mapper, filter,
				ShopGoodsTypePropertyBO.class);
		searchBO.setShopgoodsProperty(filterBoList);

		// 储存商品原价
		Map<Long, BigDecimal> goodsPriceMap = this.goodsService.getGoodsPriceMap(page.getContent());
		// 储存CN产品BV值
		Map<Long, BigDecimal> cn_self_add_priceMap = this.goodsService.getCn_self_add_priceMap(page
				.getContent());

		// 商品列表
		List<ShopSearchGoodsBO> searchGoodsBO = MapperUtils.map(mapper, page.getContent(),
				ShopSearchGoodsBO.class);

		for (ShopSearchGoodsBO shopSearchGoodsBO : searchGoodsBO) {
			Long goodsID = shopSearchGoodsBO.getId();
			BigDecimal BV = BigDecimal.ZERO;
			if (cn_self_add_priceMap.containsKey(goodsID)) {
				BV = cn_self_add_priceMap.get(goodsID);
			}
			BigDecimal goodPrice = BigDecimal.ZERO;
			if (goodsPriceMap.containsKey(goodsID)) {
				goodPrice = goodsPriceMap.get(goodsID);
			}
			shopSearchGoodsBO.setGoodPrice(goodPrice);
			shopSearchGoodsBO.setBv(BV);
			// add by yuleijia
			shopSearchGoodsBO.setGoodsCurrentPrice(shopSearchGoodsBO.getGoodsShowPrice());
		}
		// 按价格排序
		GoodsPriceSort(vo, searchGoodsBO);
		searchBO.setSearchGoodsList(searchGoodsBO);
		response.setSearchGoodsList(searchBO);
		
		List<ShopLuceneResultBO> listLucene = new ArrayList<ShopLuceneResultBO>();
		for (ShopSearchGoodsBO bo : searchGoodsBO ) {
			ShopLuceneResultBO shopLuceneResultBO = new ShopLuceneResultBO();
			
			shopLuceneResultBO.setVo_store_price(CommUtil.null2Double(bo.getGoodsShowPrice()));
			shopLuceneResultBO.setVo_id(bo.getId());
			shopLuceneResultBO.setVo_main_photo_url(bo.getGoodsMainPhotoPath());
			shopLuceneResultBO.setVo_title(bo.getGoodsName());
			shopLuceneResultBO.setVo_has_mobile_price(bo.getHasMobilePrice());
			shopLuceneResultBO.setVo_mobile_price(bo.getMobilePrice());
			shopLuceneResultBO.setVo_goods_price(bo.getGoodPrice());
			listLucene.add(shopLuceneResultBO);
		}
		
		List<ShopLuceneResultBO> lucene = MapperUtils.map(mapper, listLucene,ShopLuceneResultBO.class);
		response.setKeywordGoodsList(lucene);
		return response;
	}

	/**
	 * 按价格排序
	 * 
	 * @param vo
	 * @param searchGoodsBO
	 */
	private void GoodsPriceSort(ShopSearchGoodsVO vo, List<ShopSearchGoodsBO> searchGoodsBO) {
		if (null != vo && "goods_current_price".equals(vo.getOrderBy())) {
			final String orderType = vo.getOrderType();
			Collections.sort(searchGoodsBO, new Comparator<ShopSearchGoodsBO>() {
				@Override
				public int compare(ShopSearchGoodsBO o1, ShopSearchGoodsBO o2) {
					if ("asc".equals(orderType)) {
						return o1.getGoodsCurrentPrice().compareTo(o2.getGoodsCurrentPrice());
					} else {
						return o2.getGoodsCurrentPrice().compareTo(o1.getGoodsCurrentPrice());
					}
				}
			});
		}
	}
	
	/****
	 * 此方法修改为 关键字搜索和分类搜索接口
	 * @param vo
	 * @param result
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search/goods/keyword", method = RequestMethod.POST)
	@MethodMapping(desc = "关键字搜索")
	public @ResponseBody
	ShopSearchResponse searchKeywordGoods(@Valid @ModelAttribute @Param ShopSearchGoodsVO vo,
			BindingResult result, HttpServletRequest request) {
		ShopSearchResponse response = new ShopSearchResponse();

		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		MyPage<GoodsBO> page = new MyPage<GoodsBO>();
		page.setCurrentPage(vo.getPageNum());
		page.setPageSize(vo.getPageSize());
		System.out.println("vogetGcId"+vo.getGcId());
		if (vo != null && vo.getGcId() != null) {//这里是是一级类目搜索，保持原来不变，无卷皮商品
			return this.searchClassGoods(vo, result, request);
		}
		System.out.println("vogetQueryGc"+vo.getQueryGc());
		boolean order_type = true;
		if (CommUtil.null2String(vo.getOrderType()).equals("")) {
			vo.setOrderType("desc");
		}
		if (!vo.getOrderType().equals("desc")) {
			order_type = false;
		}
		if (StringUtils.isEmpty(vo.getOrderBy())) {
			vo.setOrderBy("add_time");
		}

		SortBuilder sort = null;
		String order_by = vo.getOrderBy();
		if (CommUtil.null2String(vo.getOrderBy()).equals("goods_current_price")) {
			order_by = "store_price";
		}
		Boolean onlyBV = Boolean.FALSE;
		if (vo.getOnlyCN() != null && vo.getOnlyCN() == 1) {
			onlyBV = Boolean.TRUE;
		}
		Integer isYgb = null;
		Long userId = ActionsUtil.getOwnerUid();
		if (userId == null || this.accountService.findByUid(userId, UserContant.ACCOUNT_TYPE_8) == null) {
			isYgb = 0;
		}
		sort = new FieldSortBuilder(order_by).order(order_type ? SortOrder.DESC : SortOrder.ASC);
		LuceneResult pList = null;
		
		String juanpi_class = "";
		if (StringUtils.isNotBlank(vo.getQueryGc())) {
			String[] classArray = vo.getQueryGc().split("_");
			String thisid = classArray[1];
			List<JuanpiGoodsClassBO>  juanpiClass = this.juanpiGoodsClassService.findByClass3Id(CommUtil.null2Long(thisid));
			if (juanpiClass != null && juanpiClass.size() > 0) {
				for (JuanpiGoodsClassBO jgc : juanpiClass) {
					juanpi_class += jgc.getCate3Id() + ",";
				}
			}
		}
		boolean tuangou = false;
		if (vo.getIsTuangou() != null && vo.getIsTuangou().intValue() == 1)  {
			 tuangou = true;
		}
		if (juanpi_class.length() > 1) {
			juanpi_class = juanpi_class.substring(0, juanpi_class.length()-1);
		}
		System.out.println("juanpi_class"+juanpi_class);
		if (sort != null) {
			pList = luceneUtil.search(GoodsDocument.class, vo.getKeyword(),
					CommUtil.null2Int(page.getCurrentPage() - 1),
					CommUtil.null2String(vo.getGoodsInventory()), CommUtil.null2String(vo.getGoodsType()),
					vo.getQueryGc(),
					CommUtil.null2String(vo.getGoodsTransfee()),
					CommUtil.null2String(vo.getGoodsCod()), null, null, null, sort, onlyBV, isYgb, null, tuangou, juanpi_class);
		} else {
			pList = luceneUtil.search(GoodsDocument.class, vo.getKeyword(),
					CommUtil.null2Int(page.getCurrentPage() - 1),
					CommUtil.null2String(vo.getGoodsInventory()), 
					CommUtil.null2String(vo.getGoodsType()),
					vo.getQueryGc(), 
					CommUtil.null2String(vo.getGoodsTransfee()),
					CommUtil.null2String(vo.getGoodsCod()), 
					null, null, null, null, onlyBV, isYgb, null, tuangou, juanpi_class);
		}
		List<ShopLuceneResultBO> lucene = MapperUtils.map(mapper, pList.getVo_list(),
				ShopLuceneResultBO.class);
		
		for (int i = 0; i < lucene.size(); i++) {//去出卷皮下架产品
			ShopLuceneResultBO lu = lucene.get(i);
			System.out.println("取出卷皮下架产品"+lu.getVo_id() + lu.getVo_title()+"--"+i);
			if (lu.getVo_is_juanpi() != null && lu.getVo_is_juanpi() == 1) {
				JuanpiGoodsBO juanpiGoodsBO = this.JuanpiGoodsService.findOne(lu.getVo_id());
				if (juanpiGoodsBO != null) {
					Date GoodsOffShelf = juanpiGoodsBO.getGoodsOffShelf();
					Date nowDate = new Date();
					if (GoodsOffShelf.getTime() < nowDate.getTime()) {
						System.out.println("实际取出取出卷皮下架产品"+lu.getVo_id() + lu.getVo_title());
						lucene.remove(lu);
						i--;
					}
				}
			}
		}
		
		response.setKeywordGoodsList(lucene);
		return response;
	}

	@RequestMapping(value = "/search/goods_hot/keyword", method = RequestMethod.POST)
	@MethodMapping(desc = "热门关键字")
	public @ResponseBody
	ShopSearchResponse searchHotKeyWord() {
		ShopSearchResponse response = new ShopSearchResponse();
		SysConfigBO con = config.getSysConfig();
		if (con != null && StringUtils.isNotBlank(con.getHotSearch())) {
			String[] hotKey = CommUtil.splitByChar(con.getHotSearch(), ",");
			response.setHotKey(hotKey);
		}

		return response;
	}

}
