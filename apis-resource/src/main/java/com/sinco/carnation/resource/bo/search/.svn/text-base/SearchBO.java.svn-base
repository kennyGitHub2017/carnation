package com.sinco.carnation.resource.bo.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Search", desc = "分类查询")
public class SearchBO {

	@JsonProperty("searchGoodsList")
	@FieldMapping(desc = "商品列表")
	private List<ShopSearchGoodsBO> searchGoodsList;

	@JsonProperty("classBO")
	@FieldMapping(desc = "商品分类|品牌")
	private ShopGoodsClassBO classBO;

	@JsonProperty("shopgoodsProperty")
	@FieldMapping(desc = "商品属性")
	private List<ShopGoodsTypePropertyBO> shopgoodsProperty;

	public List<ShopSearchGoodsBO> getSearchGoodsList() {
		return searchGoodsList;
	}

	public void setSearchGoodsList(List<ShopSearchGoodsBO> searchGoodsList) {
		this.searchGoodsList = searchGoodsList;
	}

	public ShopGoodsClassBO getClassBO() {
		return classBO;
	}

	public void setClassBO(ShopGoodsClassBO classBO) {
		this.classBO = classBO;
	}

	public List<ShopGoodsTypePropertyBO> getShopgoodsProperty() {
		return shopgoodsProperty;
	}

	public void setShopgoodsProperty(List<ShopGoodsTypePropertyBO> shopgoodsProperty) {
		this.shopgoodsProperty = shopgoodsProperty;
	}

}
