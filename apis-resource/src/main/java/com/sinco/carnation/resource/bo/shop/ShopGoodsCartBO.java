package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopGoodsCart", desc = "我购物车列表")
public class ShopGoodsCartBO {

	@JsonProperty("id")
	@FieldMapping(desc = "购物车id")
	private Long id;

	@JsonProperty("subtotalPrice")
	@FieldMapping(desc = "商品小计")
	private BigDecimal subtotalPrice;

	@JsonProperty("storeSecondDomain")
	@FieldMapping(desc = "商铺名称")
	private String storeSecondDomain;

	/** 规格内容 **/
	@JsonProperty("specInfo")
	@FieldMapping(desc = "商品规格")
	private String specInfo;

	@JsonProperty("goods")
	@FieldMapping(desc = "商品列表")
	private ShopGoodsBo goods;

	/** 数量 **/
	@JsonProperty("count")
	@FieldMapping(desc = "数量")
	private Integer count;

	@JsonProperty("price")
	@FieldMapping(desc = "单价")
	private BigDecimal price;

	@JsonProperty("whetherChooseGift")
	@FieldMapping(desc = "是否选中了赠品 默认为0 未选择 1为已选择 ")
	private Integer whetherChooseGift;

	@JsonProperty("exchangeIntegral")
	@FieldMapping(desc = "兑换积分值，如果是0的话表示不设置积分兑购")
	private Integer exchangeIntegral;

	@JsonProperty("goodsIntegralPrice")
	@FieldMapping(desc = "商品积分兑换后的价格，无兑换显示原价")
	private BigDecimal goodsIntegralPrice;

	@JsonProperty("goodsMobilePrice")
	@FieldMapping(desc = "手机专享价，如果不设置手机专享价则留空")
	private BigDecimal goodsMobilePrice;

	@JsonProperty("selfAddPrice")
	@FieldMapping(desc = "自营增加价格")
	private BigDecimal selfAddPrice;

	/** 所属店铺 **/
	@JsonProperty("goodsStoreId")
	@FieldMapping(desc = "所属店铺")
	private Long goodsStoreId;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;
	
	@JsonProperty("isYgb")
	@FieldMapping(desc = "是否为云购币专区订单")
	private Integer isYgb;

	public String getStoreSecondDomain() {
		return storeSecondDomain;
	}

	public ShopGoodsBo getGoods() {
		return goods;
	}

	public void setGoods(ShopGoodsBo goods) {
		this.goods = goods;
	}

	public void setStoreSecondDomain(String storeSecondDomain) {
		this.storeSecondDomain = storeSecondDomain;
	}

	public String getSpecInfo() {
		return specInfo;
	}

	public void setSpecInfo(String specInfo) {
		this.specInfo = specInfo;
	}

	public Integer getCount() {
		return count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getWhetherChooseGift() {
		return whetherChooseGift;
	}

	public Integer getExchangeIntegral() {
		return exchangeIntegral;
	}

	public BigDecimal getGoodsIntegralPrice() {
		return goodsIntegralPrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public BigDecimal getSelfAddPrice() {
		return selfAddPrice;
	}

	public void setWhetherChooseGift(Integer whetherChooseGift) {
		this.whetherChooseGift = whetherChooseGift;
	}

	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}

	public void setGoodsIntegralPrice(BigDecimal goodsIntegralPrice) {
		this.goodsIntegralPrice = goodsIntegralPrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public void setSelfAddPrice(BigDecimal selfAddPrice) {
		this.selfAddPrice = selfAddPrice;
	}

	public BigDecimal getSubtotalPrice() {
		return subtotalPrice;
	}

	public void setSubtotalPrice(BigDecimal subtotalPrice) {
		this.subtotalPrice = subtotalPrice;
	}

	public Long getGoodsStoreId() {
		return goodsStoreId;
	}

	public void setGoodsStoreId(Long goodsStoreId) {
		this.goodsStoreId = goodsStoreId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

}
