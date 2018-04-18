package com.sinco.carnation.resource.bo.market;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ActHotSaleGoodsInfoApiBO", desc = "促销活动商品列表信息")
public class ActHotSaleGoodsInfoApiBO {

	@JsonProperty("id")
	@FieldMapping(desc = "商品id")
	private Long goodsId;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "手机专享价")
	private BigDecimal goodsMobilePrice;

	@JsonProperty("goodsCurrentPrice")
	@FieldMapping(desc = "商品当前价格")
	private BigDecimal goodsCurrentPrice;

	@JsonProperty("goodsPrice")
	@FieldMapping(desc = "商品价格")
	private BigDecimal goodsPrice;

	// 活动促销商品广告名称
	@JsonProperty("adTitle")
	@FieldMapping(desc = "活动促销商品广告名称")
	private String adTitle;

	// 商品广告图片地址
	@JsonProperty("adImgPath")
	@FieldMapping(desc = "商品广告图片地址")
	private String adImgPath;

	// 热销商品的销量
	@JsonProperty("goodsSalenum")
	@FieldMapping(desc = "热销商品的销量")
	private Integer goodsSalenum;

	// 热销商品的库存
	@JsonProperty("goodsInventory")
	@FieldMapping(desc = "热销商品的库存")
	private Integer goodsInventory;

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getAdTitle() {
		return adTitle;
	}

	public void setAdTitle(String adTitle) {
		this.adTitle = adTitle;
	}

	public String getAdImgPath() {
		return adImgPath;
	}

	public void setAdImgPath(String adImgPath) {
		this.adImgPath = adImgPath;
	}

	public Integer getGoodsSalenum() {
		return goodsSalenum;
	}

	public void setGoodsSalenum(Integer goodsSalenum) {
		this.goodsSalenum = goodsSalenum;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

}
