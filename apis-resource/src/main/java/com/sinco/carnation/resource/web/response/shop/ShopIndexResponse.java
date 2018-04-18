package com.sinco.carnation.resource.web.response.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.search.ShopLuceneResultBO;
import com.sinco.carnation.resource.bo.shop.GoodsClassBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsBo;
import com.sinco.carnation.resource.bo.shop.ShopGoodsCaseBo;
import com.sinco.carnation.resource.bo.shop.ShopStoreBO;

/**
 * 商城首页
 * 
 * @author king
 * 
 */
public class ShopIndexResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("goodsCaseList")
	@ReturnMapping(desc = "商城首页橱窗列表")
	private List<ShopGoodsCaseBo> goodsCaseList;

	@JsonProperty("goodsList")
	@ReturnMapping(desc = "商品列表")
	private List<ShopGoodsBo> goodsList;

	@JsonProperty("goodsClassList")
	@ReturnMapping(desc = "商品分类列表")
	private List<GoodsClassBo> goodsClassList;

	@JsonProperty("goodsLikeList")
	@ReturnMapping(desc = "猜你喜欢商品列表")
	private List<ShopGoodsBo> goodsLikeList;

	@JsonProperty("totalSize")
	@ReturnMapping(desc = "列表总记录数")
	private Integer totalSize;

	@JsonProperty("storeInfo")
	@ReturnMapping(desc = "店铺信息")
	private ShopStoreBO storeInfo;

	@JsonProperty("youLikelist")
	@ReturnMapping(desc = "有你喜欢")
	private List<ShopGoodsBo> youLikelist;
	
	@JsonProperty("keywordGoodsList")
	@ReturnMapping(desc = "首页有你喜欢列表new搜索引擎")
	private List<ShopLuceneResultBO> keywordGoodsList;
	
	

	public List<ShopGoodsCaseBo> getGoodsCaseList() {
		return goodsCaseList;
	}

	public void setGoodsCaseList(List<ShopGoodsCaseBo> goodsCaseList) {
		this.goodsCaseList = goodsCaseList;
	}

	public List<ShopGoodsBo> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<ShopGoodsBo> goodsList) {
		this.goodsList = goodsList;
	}

	public List<GoodsClassBo> getGoodsClassList() {
		return goodsClassList;
	}

	public void setGoodsClassList(List<GoodsClassBo> goodsClassList) {
		this.goodsClassList = goodsClassList;
	}

	public List<ShopGoodsBo> getGoodsLikeList() {
		return goodsLikeList;
	}

	public void setGoodsLikeList(List<ShopGoodsBo> goodsLikeList) {
		this.goodsLikeList = goodsLikeList;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public ShopStoreBO getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(ShopStoreBO storeInfo) {
		this.storeInfo = storeInfo;
	}

	public List<ShopGoodsBo> getYouLikelist() {
		return youLikelist;
	}

	public void setYouLikelist(List<ShopGoodsBo> youLikelist) {
		this.youLikelist = youLikelist;
	}

	public List<ShopLuceneResultBO> getKeywordGoodsList() {
		return keywordGoodsList;
	}

	public void setKeywordGoodsList(List<ShopLuceneResultBO> keywordGoodsList) {
		this.keywordGoodsList = keywordGoodsList;
	}

}
