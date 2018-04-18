package com.sinco.carnation.resource.web.merch;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.merch.StoreCommonInfoBO;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;

public class MerchantResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("goodsList")
	@ReturnMapping(desc = "商品列表")
	private List<ShopGoodsBo> goodsList;

	@JsonProperty("storeInfo")
	@ReturnMapping(desc = "店铺商品分类")
	private List<StoreCommonInfoBO> storeInfo;

	public List<ShopGoodsBo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<ShopGoodsBo> goodsList) {
		this.goodsList = goodsList;
	}

	public List<StoreCommonInfoBO> getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(List<StoreCommonInfoBO> storeInfo) {
		this.storeInfo = storeInfo;
	}

}
