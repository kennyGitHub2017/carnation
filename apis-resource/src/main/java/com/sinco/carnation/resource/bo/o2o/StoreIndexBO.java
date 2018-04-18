package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "StoreIndex", desc = "商户首页")
public class StoreIndexBO {

	@JsonProperty("id")
	@FieldMapping(desc = "商户id")
	private long id;

	@JsonProperty("invitationCode")
	@FieldMapping(desc = "邀请码")
	private String invitatCode;

	@JsonProperty("totalPayAmount")
	@FieldMapping(desc = "销售总额")
	private BigDecimal totalPayAmount;

	@JsonProperty("couponPayAmount")
	@FieldMapping(desc = "劵收益总额")
	private BigDecimal couponPayAmount;

	@JsonProperty("chargePayAmount")
	@FieldMapping(desc = "扫码总额")
	private BigDecimal chargePayAmount;

	@JsonProperty("rebateAmount")
	@FieldMapping(desc = "返润总额")
	private BigDecimal rebateAmount;

	@JsonProperty("profitAmount")
	@FieldMapping(desc = "收益总额")
	private BigDecimal profitAmount;

	@JsonProperty("storeBannerPath")
	@FieldMapping(desc = "商户binner")
	private String storeBannerPath;

	@JsonProperty("storeLogoPath")
	@FieldMapping(desc = "店铺logo")
	private String storeLogoPath;

	@JsonProperty("coverPath")
	@FieldMapping(desc = "商户封面")
	private String coverPath;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("totalPhoto")
	@FieldMapping(desc = "图片总数")
	private Integer totalPhoto;

	/** 店铺电话号码 **/
	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话号码")
	private String storeTelephone;

	@JsonProperty("area")
	@FieldMapping(desc = "地区")
	private String area;

	/** 店铺详细地址 **/
	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺详细地址")
	private String storeAddress;

	@JsonProperty("isO2o")
	@FieldMapping(desc = "店铺类型")
	private boolean isO2o;

	public boolean getIsO2o() {
		return isO2o;
	}

	public void setIsO2o(boolean isO2o) {
		this.isO2o = isO2o;
	}

	public String getInvitatCode() {
		return invitatCode;
	}

	public void setInvitatCode(String invitatCode) {
		this.invitatCode = invitatCode;
	}

	public BigDecimal getCouponPayAmount() {
		return couponPayAmount;
	}

	public void setCouponPayAmount(BigDecimal couponPayAmount) {
		this.couponPayAmount = couponPayAmount;
	}

	public BigDecimal getChargePayAmount() {
		return chargePayAmount;
	}

	public void setChargePayAmount(BigDecimal chargePayAmount) {
		this.chargePayAmount = chargePayAmount;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public String getStoreBannerPath() {
		return storeBannerPath;
	}

	public void setStoreBannerPath(String storeBannerPath) {
		this.storeBannerPath = storeBannerPath;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}

	public BigDecimal getTotalPayAmount() {
		return totalPayAmount;
	}

	public void setTotalPayAmount(BigDecimal totalPayAmount) {
		this.totalPayAmount = totalPayAmount;
	}

	public String getCoverPath() {
		return coverPath;
	}

	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getTotalPhoto() {
		return totalPhoto;
	}

	public void setTotalPhoto(Integer totalPhoto) {
		this.totalPhoto = totalPhoto;
	}

	public BigDecimal getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(BigDecimal profitAmount) {
		this.profitAmount = profitAmount;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
