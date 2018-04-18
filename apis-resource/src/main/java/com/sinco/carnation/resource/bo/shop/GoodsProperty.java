package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsProperty", desc = "商品属性")
public class GoodsProperty {

	@JsonProperty("val")
	@FieldMapping(desc = "属性值")
	private String val;

	@JsonProperty("name")
	@FieldMapping(desc = "属性名称")
	private String name;

	@JsonProperty("id")
	@FieldMapping(desc = "属性id")
	private Long id;

	public String getVal() {
		return val;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
