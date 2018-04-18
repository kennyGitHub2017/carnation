package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AwayStore", desc = "离我最近")
public class AwayStoreBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离|米")
	private Integer distance;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "服务名称")
	private String goodsName;

	@JsonProperty("goodsPath")
	@FieldMapping(desc = "服务图片")
	private String goodsPath;

	@JsonProperty("price")
	@FieldMapping(desc = "价格")
	private BigDecimal price;

	@JsonProperty("sales")
	@FieldMapping(desc = "销量")
	private Integer sales;

	@JsonProperty("goodsId")
	@FieldMapping(desc = "服务id")
	private Long goodsId;

	@JsonProperty("groupDiscount")
	@FieldMapping(desc = "服务折扣")
	private BigDecimal groupDiscount;

	@JsonProperty("costPrice")
	@FieldMapping(desc = "原价")
	private BigDecimal costPrice;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPath() {
		return goodsPath;
	}

	public void setGoodsPath(String goodsPath) {
		this.goodsPath = goodsPath;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

}
