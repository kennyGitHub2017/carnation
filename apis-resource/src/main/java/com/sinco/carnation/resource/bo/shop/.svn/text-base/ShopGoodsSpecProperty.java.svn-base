package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsSpecProperty", desc = "商品规格属性")
public class ShopGoodsSpecProperty {

	@JsonProperty("spec")
	@FieldMapping(desc = "商品规格")
	private ShopGoodsSpecification spec;

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/**  **/
	@JsonProperty("specId")
	@FieldMapping(desc = "specId")
	private Long specId;

	/**  **/
	@JsonProperty("specImageId")
	@FieldMapping(desc = "specImageId")
	private String specImageId;

	/**  **/
	@JsonProperty("value")
	@FieldMapping(desc = "value")
	private String value;

	public Long getId() {
		return id;
	}

	public Long getSpecId() {
		return specId;
	}

	public String getSpecImageId() {
		return specImageId;
	}

	public String getValue() {
		return value;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public void setSpecImageId(String specImageId) {
		this.specImageId = specImageId;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ShopGoodsSpecification getSpec() {
		return spec;
	}

	public void setSpec(ShopGoodsSpecification spec) {
		this.spec = spec;
	}
}
