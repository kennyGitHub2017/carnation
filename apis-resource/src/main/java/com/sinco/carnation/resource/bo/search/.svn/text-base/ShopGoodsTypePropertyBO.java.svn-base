package com.sinco.carnation.resource.bo.search;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "商品类型属性", domainName = "ShopGoodsTypeProperty")
public class ShopGoodsTypePropertyBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("display")
	@FieldMapping(desc = "属性可见性")
	private Boolean display;

	@JsonProperty("name")
	@FieldMapping(desc = "属性名称")
	private String name;

	@JsonProperty("sequence")
	@FieldMapping(desc = "sequence")
	private Integer sequence;

	@JsonProperty("goodsTypeId")
	@FieldMapping(desc = "商品类型")
	private Long goodsTypeId;

	@JsonProperty("hcValue")
	@FieldMapping(desc = "互斥属性值")
	private String hcValue;

	@JsonProperty("value")
	@FieldMapping(desc = "值")
	private String value;

	public Long getId() {
		return id;
	}

	public Boolean getDisplay() {
		return display;
	}

	public String getName() {
		return name;
	}

	public Integer getSequence() {
		return sequence;
	}

	public Long getGoodsTypeId() {
		return goodsTypeId;
	}

	public String getHcValue() {
		return hcValue;
	}

	public String getValue() {
		return value;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public void setGoodsTypeId(Long goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}

	public void setHcValue(String hcValue) {
		this.hcValue = hcValue;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
