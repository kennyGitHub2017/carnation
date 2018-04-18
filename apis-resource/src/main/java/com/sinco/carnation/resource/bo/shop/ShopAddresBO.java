package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopAddres", desc = "商品收获地址")
public class ShopAddresBO {

	@JsonProperty("areaName")
	@FieldMapping(desc = "名称")
	private String areaName;

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	public String getAreaName() {
		return areaName;
	}

	public Long getId() {
		return id;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
