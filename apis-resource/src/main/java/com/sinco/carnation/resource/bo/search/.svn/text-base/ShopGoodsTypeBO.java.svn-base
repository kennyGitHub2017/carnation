package com.sinco.carnation.resource.bo.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "商品类型", domainName = "ShopGoodsType")
public class ShopGoodsTypeBO {

	@JsonProperty("goodBrandList")
	@FieldMapping(desc = "商品品牌")
	private List<ShopGoodsBrandBO> gbs;

	public List<ShopGoodsBrandBO> getGbs() {
		return gbs;
	}

	public void setGbs(List<ShopGoodsBrandBO> gbs) {
		this.gbs = gbs;
	}

}
