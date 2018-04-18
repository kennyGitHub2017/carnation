package com.sinco.carnation.resource.bo.shop;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopOrderList", desc = "订单列表")
public class ShopOrderListBO {

	@JsonProperty("shopStore")
	@FieldMapping(desc = "商品商铺对象")
	private ShopStoreBO shopStore;

	@JsonProperty("goodsCartList")
	@FieldMapping(desc = "商品列表")
	private List<ShopGoodsCartBO> goodsCartList;

	@JsonProperty("goodsCod")
	@FieldMapping(desc = "是否支持货到付款|true支持，false不支持")
	private boolean goodsCod = true;// 默认支持货到付款，这样有一款产品不支持货到付款，这个订单就不支持货到付款

	@JsonProperty("taxInvoice")
	@FieldMapping(desc = "默认可以开具增值税发票|1可以")
	private int taxInvoice = 1;// 默认可以开具增值税发票，只要存在一款产品不支持增值税发票，整体订单不可以开具增值税发票

	@JsonProperty("transList")
	@FieldMapping(desc = "运送方式")
	private List<ShopTransPortBO> transList;

	@JsonProperty("couponInfoList")
	@FieldMapping(desc = "优惠券")
	private List<ShopCouponInfoBO> couponInfoList;

	@JsonProperty("bvCount")
	@FieldMapping(desc = "BV值合计")
	private BigDecimal bvCount;

	@JsonProperty("isYgb")
	@FieldMapping(desc = "是否为云购币专区订单")
	private Boolean isYgb;
	
	@JsonProperty("needIntegral")
	@FieldMapping(desc = "需要的积分-精品专区")
	private BigDecimal needIntegral;

	@JsonProperty("needMoney")
	@FieldMapping(desc = "需要的现金")
	private BigDecimal needMoney;

	@JsonProperty("needYgb")
	@FieldMapping(desc = "需要的云购币")
	private BigDecimal needYgb;

	@JsonProperty("shopingIntegral")
	@FieldMapping(desc = "购物积分")
	private BigDecimal shopingIntegral;
	
	@JsonProperty("cnRepeat")
	@FieldMapping(desc = "重消")
	private BigDecimal cnRepeat;
	
	@JsonProperty("proType")
	@FieldMapping(desc = "商品支付类型 1 重消,2购物积分 3重消+购物积分 4平台积分")
	private Integer proType;

	public BigDecimal getBvCount() {
		return bvCount;
	}

	public void setBvCount(BigDecimal bvCount) {
		this.bvCount = bvCount;
	}

	public ShopStoreBO getShopStore() {
		return shopStore;
	}

	public void setShopStore(ShopStoreBO shopStore) {
		this.shopStore = shopStore;
	}

	public List<ShopGoodsCartBO> getGoodsCartList() {
		return goodsCartList;
	}

	public void setGoodsCartList(List<ShopGoodsCartBO> goodsCartList) {
		this.goodsCartList = goodsCartList;
	}

	public boolean isGoodsCod() {
		return goodsCod;
	}

	public int getTaxInvoice() {
		return taxInvoice;
	}

	public void setGoodsCod(boolean goodsCod) {
		this.goodsCod = goodsCod;
	}

	public void setTaxInvoice(int taxInvoice) {
		this.taxInvoice = taxInvoice;
	}

	public List<ShopTransPortBO> getTransList() {
		return transList;
	}

	public void setTransList(List<ShopTransPortBO> transList) {
		this.transList = transList;
	}

	public List<ShopCouponInfoBO> getCouponInfoList() {
		return couponInfoList;
	}

	public void setCouponInfoList(List<ShopCouponInfoBO> couponInfoList) {
		this.couponInfoList = couponInfoList;
	}

	public Boolean getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Boolean isYgb) {
		this.isYgb = isYgb;
	}

	public BigDecimal getNeedIntegral() {
		return needIntegral;
	}

	public void setNeedIntegral(BigDecimal needIntegral) {
		this.needIntegral = needIntegral;
	}

	public BigDecimal getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}

	public BigDecimal getNeedYgb() {
		return needYgb;
	}

	public void setNeedYgb(BigDecimal needYgb) {
		this.needYgb = needYgb;
	}

	public BigDecimal getShopingIntegral() {
		return shopingIntegral;
	}

	public void setShopingIntegral(BigDecimal shopingIntegral) {
		this.shopingIntegral = shopingIntegral;
	}

	public BigDecimal getCnRepeat() {
		return cnRepeat;
	}

	public void setCnRepeat(BigDecimal cnRepeat) {
		this.cnRepeat = cnRepeat;
	}

	public Integer getProType() {
		return proType;
	}

	public void setProType(Integer proType) {
		this.proType = proType;
	}

}
