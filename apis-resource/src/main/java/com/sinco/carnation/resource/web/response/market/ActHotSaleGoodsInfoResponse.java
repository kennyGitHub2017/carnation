package com.sinco.carnation.resource.web.response.market;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.market.ActHotSaleGoodsInfoApiBO;

public class ActHotSaleGoodsInfoResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("goodsList")
	@ReturnMapping(desc = "促销活动商品信息")
	List<ActHotSaleGoodsInfoApiBO> goodsList;

	public List<ActHotSaleGoodsInfoApiBO> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<ActHotSaleGoodsInfoApiBO> goodsList) {
		this.goodsList = goodsList;
	}

}
