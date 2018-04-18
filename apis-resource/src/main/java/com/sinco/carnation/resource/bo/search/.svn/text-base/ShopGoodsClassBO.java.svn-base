package com.sinco.carnation.resource.bo.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "商品分类BO", domainName = "ShopGoodsClass")
public class ShopGoodsClassBO {

	@JsonProperty("goodsType")
	@FieldMapping(desc = "商品类型")
	private ShopGoodsTypeBO goodsType;

	public ShopGoodsTypeBO getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(ShopGoodsTypeBO goodsType) {
		this.goodsType = goodsType;
	}

}
