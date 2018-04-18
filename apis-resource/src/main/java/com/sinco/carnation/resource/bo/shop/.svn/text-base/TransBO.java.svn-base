package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Trans", desc = "运送方式")
public class TransBO {

	public Long getStoreId() {
		return storeId;
	}

	public List<ShopTransPortBO> getTrans() {
		return trans;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public void setTrans(List<ShopTransPortBO> trans) {
		this.trans = trans;
	}

	@JsonProperty("storeId")
	@FieldMapping(desc = "店铺id")
	private Long storeId;

	@JsonProperty("trans")
	@FieldMapping(desc = "运送方式")
	List<ShopTransPortBO> trans;

}
