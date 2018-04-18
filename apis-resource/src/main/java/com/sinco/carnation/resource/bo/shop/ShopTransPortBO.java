package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "运送方式", domainName = "ShopTransPort")
public class ShopTransPortBO {

	@JsonProperty("key")
	@FieldMapping(desc = "运送方式名称")
	private String key;

	@JsonProperty("value")
	@FieldMapping(desc = "运送方式价格")
	private Double value;

	public String getKey() {
		return key;
	}

	public Double getValue() {
		return value;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
