package com.sinco.carnation.resource.bo.shop;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GoodsSpecification", desc = "商品规格")
public class ShopGoodsSpecification {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/**  **/
	@JsonProperty("name")
	@FieldMapping(desc = "")
	private String name;

	/** 规格类型，0为平台自营规格，1为商家规格，商家规格时需要有对应的店铺 **/
	@JsonProperty("specType")
	@FieldMapping(desc = "规格类型，0为平台自营规格，1为商家规格，商家规格时需要有对应的店铺")
	private Integer specType;

	/** 规格类型(文字或图片) **/
	@JsonProperty("type")
	@FieldMapping(desc = "规格类型(文字或图片)")
	private String type;

	/** 规格对应的主营商品分类,该分类为平台二级商品分类（level=1） **/
	@JsonProperty("goodsClassId")
	@FieldMapping(desc = "规格对应的主营商品分类,该分类为平台二级商品分类（level=1）")
	private Long goodsClassId;

	/** 当规格类型为商家规格时对应的店铺 **/
	@JsonProperty("storeId")
	@FieldMapping(desc = "当规格类型为商家规格时对应的店铺")
	private Long storeId;

	@JsonProperty("specProperties")
	@FieldMapping(desc = "商品规格属性1")
	private List<ShopGoodsSpecProperty> specProperties;

	@JsonProperty("properties")
	@FieldMapping(desc = "商品规格属性")
	private List<ShopGoodsSpecProperty> properties;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getSpecType() {
		return specType;
	}

	public String getType() {
		return type;
	}

	public Long getGoodsClassId() {
		return goodsClassId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ShopGoodsSpecProperty> getSpecProperties() {
		return specProperties;
	}

	public void setSpecProperties(List<ShopGoodsSpecProperty> specProperties) {
		this.specProperties = specProperties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecType(Integer specType) {
		this.specType = specType;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setGoodsClassId(Long goodsClassId) {
		this.goodsClassId = goodsClassId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public List<ShopGoodsSpecProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<ShopGoodsSpecProperty> properties) {
		this.properties = properties;
	}
}
