package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopGoodsPhoto", desc = "商品浏览图片列表")
public class ShopGoodsPhotoBO {

	@JsonProperty("accessory")
	@FieldMapping(desc = "图片对象")
	private ShopAccessoryBO accessory;

	public ShopAccessoryBO getAccessory() {
		return accessory;
	}

	public void setAccessory(ShopAccessoryBO accessory) {
		this.accessory = accessory;
	}

}
