package com.sinco.carnation.resource.bo.search;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopSearchGoods", desc = "搜索商品列表")
public class ShopSearchGoodsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "商品id")
	private Long id;

	@JsonProperty("goodsName")
	@FieldMapping(desc = "商品名称")
	private String goodsName;

	@JsonProperty("goodsMainPhotoPath")
	@FieldMapping(desc = "商品主图片")
	private String goodsMainPhotoPath;

	@JsonProperty("hasExchangeIntegral")
	@FieldMapping(desc = "是否有积分兑换价格")
	private Boolean hasExchangeIntegral;

	@JsonProperty("goodsIntegralPrice")
	@FieldMapping(desc = "商品积分兑换后的价格，无兑换显示原价")
	private BigDecimal goodsIntegralPrice;

	@JsonProperty("hasMobilePrice")
	@FieldMapping(desc = "是否有手机专享价")
	private Boolean hasMobilePrice;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "手机专享价，如果不设置手机专享价则留空")
	private BigDecimal goodsMobilePrice;

	/** 商品当前价格 **/
	@JsonProperty("goodsCurrentPrice")
	@FieldMapping(desc = "商品当前价格")
	private BigDecimal goodsCurrentPrice;

	@JsonProperty("exchangeIntegral")
	@FieldMapping(desc = "兑换积分值")
	private Integer exchangeIntegral;

	@JsonProperty("goodsShowPrice")
	@FieldMapping(desc = "商品显示价格")
	private BigDecimal goodsShowPrice;

	@JsonProperty("mobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal mobilePrice;

	@JsonProperty("bv")
	@FieldMapping(desc = "商品BV值")
	private BigDecimal bv;

	@JsonProperty("goodPrice")
	@FieldMapping(desc = "商品原价")
	private BigDecimal goodPrice;

	public BigDecimal getGoodPrice() {
		return goodPrice;
	}

	public void setGoodPrice(BigDecimal goodPrice) {
		this.goodPrice = goodPrice;
	}

	public BigDecimal getBv() {
		return bv;
	}

	public void setBv(BigDecimal bv) {
		this.bv = bv;
	}

	public Long getId() {
		return id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public Boolean getHasExchangeIntegral() {
		return hasExchangeIntegral;
	}

	public BigDecimal getGoodsIntegralPrice() {
		return goodsIntegralPrice;
	}

	public Boolean getHasMobilePrice() {
		return hasMobilePrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public void setHasExchangeIntegral(Boolean hasExchangeIntegral) {
		this.hasExchangeIntegral = hasExchangeIntegral;
	}

	public void setGoodsIntegralPrice(BigDecimal goodsIntegralPrice) {
		this.goodsIntegralPrice = goodsIntegralPrice;
	}

	public void setHasMobilePrice(Boolean hasMobilePrice) {
		this.hasMobilePrice = hasMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public Integer getExchangeIntegral() {
		return exchangeIntegral;
	}

	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}

	public BigDecimal getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(BigDecimal mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public BigDecimal getGoodsShowPrice() {
		return goodsShowPrice;
	}

	public void setGoodsShowPrice(BigDecimal goodsShowPrice) {
		this.goodsShowPrice = goodsShowPrice;
	}

}
