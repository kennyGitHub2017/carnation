package com.sinco.carnation.resource.web.actions.shop;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinco.api.annotation.ApiMapping;
import com.sinco.api.annotation.MethodMapping;
import com.sinco.api.annotation.Param;
import com.sinco.api.util.ActionsUtil;
import com.sinco.api.util.MapperUtils;
import com.sinco.api.web.BasicApiController;
import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.service.GoodsService;
import com.sinco.carnation.goods.service.UserGoodsClassService;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.carnation.resource.bo.merch.StoreCommonInfoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;
import com.sinco.carnation.resource.vo.favorites.MerchantVO;
import com.sinco.carnation.resource.web.actions.ApiConstants;
import com.sinco.carnation.resource.web.merch.MerchantResponse;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.service.StoreService;
import com.sinco.carnation.sys.service.SysConfigService;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.model.Seller;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.service.SellerService;
import com.sinco.dal.common.MyPage;

@Controller
@RestController
@RequestMapping(ApiConstants.API)
@ApiMapping(desc = "商户", namespace = "merch")
public class ShopMerchantAction extends BasicApiController {

	@Autowired
	private SysConfigService configService;

	@Autowired
	private StoreService storeService;

	@Autowired
	private UserGoodsClassService userGoodsClassService;

	@Autowired
	private GoodsService goodsService;

	@Autowired
	private SellerService sellerService;

	@Autowired
	private Mapper mapper;

	@RequestMapping(value = "/merch/store/list", method = RequestMethod.POST)
	@MethodMapping(desc = "商户商品列表")
	public @ResponseBody
	MerchantResponse store(@Valid @ModelAttribute @Param MerchantVO vo, BindingResult result,
			HttpServletRequest request) {
		MerchantResponse response = new MerchantResponse();
		if (result.hasErrors()) {
			ActionsUtil.handleParamError(result.getAllErrors(), response);
			return response;
		}

		String serverName = request.getServerName().toLowerCase();
		String secondDomain = "";
		if (this.configService.getSysConfig().getSecondDomainOpen()) {
			secondDomain = serverName.substring(0, serverName.indexOf("."));
		}
		StoreBO store = null;
		if (this.configService.getSysConfig().getSecondDomainOpen()
				&& serverName.indexOf(".") != serverName.lastIndexOf(".") && !secondDomain.equals("www")) {

		} else {
			store = this.storeService.getObjById(vo.getId());
		}
		if (store == null) {
			response.putErrorMessage("5.merch.store.store_info_not");
			return response;
		} else {
			if (store.getStoreStatus() == 15) {
				if (StringUtils.isEmpty(vo.getOrderType())) {
					vo.setOrderType("asc");
				}
				if (StringUtils.isEmpty(vo.getOrderBy())) {
					vo.setOrderBy("add_time");
				}
				GoodsVO vo1 = new GoodsVO();
				vo1.setOrderBy(vo.getOrderBy());
				vo1.setOrderType(vo.getOrderType());
				vo1.setStoreId(vo.getId());

				if (vo.getUgcId() != null) {
					Set<Long> userGoodsClassIds = new HashSet<>();
					UserGoodsClass currentUgc = userGoodsClassService.getObjById(vo.getUgcId());
					if (currentUgc != null) {
						userGoodsClassIds.add(vo.getUgcId());
						if (currentUgc.getParentId() == null) {
							List<UserGoodsClass> childs = userGoodsClassService.findByParentId(currentUgc
									.getId());
							if (CollectionUtils.isNotEmpty(childs)) {
								for (UserGoodsClass userGoodsClass : childs) {
									userGoodsClassIds.add(userGoodsClass.getId());
								}
							}

						}
					}
					vo1.setUserGoodsClassIds(userGoodsClassIds);
				}

				MyPage<GoodsBO> page = new MyPage<GoodsBO>();
				page.setPageNumber(vo.getPageNum());
				page.setPageSize(page.getPageSize());
				this.goodsService.selectGoodsListByVO(page, vo1);
				List<GoodsBO> goodList = page.getContent();

				// 处理多个规格商品原价 add by yuleijia
				this.goodsService.getGoodsPriceMap(goodList);
				// 存放BVMap
				Map<Long, BigDecimal> map = new HashMap<Long, BigDecimal>();
				for (GoodsBO good : goodList) {
					boolean exPriceFlag = good.getExPriceFlag() != null && good.getExPriceFlag() == 1 ? true
							: false;
					boolean boo = good.getCnSelfAddPrice() != null
							&& good.getCnSelfAddPrice().compareTo(BigDecimal.ZERO) == 1 ? true : false;
					if (exPriceFlag && boo) // cn商品 && BV值大于0
					{
						map.put(good.getId(), good.getCnSelfAddPrice());
					}
				}

				List<ShopGoodsBo> list = MapperUtils.map(mapper, page.getContent(), ShopGoodsBo.class);
				for (ShopGoodsBo shopGood : list) {
					Long id = shopGood.getId();
					BigDecimal BV = BigDecimal.ZERO;
					if (map.containsKey(id)) {
						BV = map.get(id);
					}
					shopGood.setBv(BV);
					// GoodsCurrentPrice = GoodsShowPrice 统一 IOS使用GoodsCurrentPrice Android使用 GoodsShowPrice
					// add by yuleijia
					shopGood.setGoodsCurrentPrice(shopGood.getGoodsShowPrice());
					shopGood.setStorePrice(shopGood.getGoodsShowPrice());
				}
				response.setGoodsList(list);
			}
		}

		return response;
	}

	@RequestMapping(value = "/merch/store_common/info", method = RequestMethod.POST)
	@MethodMapping(desc = "加载店铺信息 ")
	public @ResponseBody
	MerchantResponse storeCommonInfo(
			@Valid @RequestParam(value = "storeId") @Param(desc = "店铺id") Long storeId) {
		MerchantResponse response = new MerchantResponse();
		if (storeId == null) {
			response.putErrorMessage(MsgCodeConstant.ERROR_PARAM);
			return response;
		}

		Seller seller = sellerService.getByStoreId(storeId);
		if (seller != null) {
			List<UserGoodsClassBO> ugcs = this.userGoodsClassService.findParentByUserId(seller.getUid());
			List<StoreCommonInfoBO> infoBOs = MapperUtils.map(mapper, ugcs, StoreCommonInfoBO.class);
			response.setStoreInfo(infoBOs);
			return response;
		}

		return response;
	}
}
