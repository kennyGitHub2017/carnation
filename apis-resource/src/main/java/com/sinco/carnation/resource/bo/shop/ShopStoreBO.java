package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopStore", desc = "商品商铺对象")
public class ShopStoreBO {

	/** 店铺名称 **/
	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("id")
	@FieldMapping(desc = "店铺id")
	private Long id;

	@JsonProperty("storeCredit")
	@FieldMapping(desc = "店铺等级，根据好评数累加 ")
	private Integer storeCredit;

	@JsonProperty("storeInfo")
	@FieldMapping(desc = "店铺介绍")
	private String storeInfo;

	@JsonProperty("storeLogoPath")
	@FieldMapping(desc = "店铺logo")
	private String storeLogoPath;

	@JsonProperty("storeDescription")
	@FieldMapping(desc = "描述相符")
	private float storeDescription;

	@JsonProperty("storeService")
	@FieldMapping(desc = "服务态度")
	private float storeService;

	@JsonProperty("storeShip")
	@FieldMapping(desc = "发货速度")
	private float storeShip;

	public String getStoreName() {
		return storeName;
	}

	public Long getId() {
		return id;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStoreCredit() {
		return storeCredit;
	}

	public String getStoreInfo() {
		return storeInfo;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public float getStoreDescription() {
		return storeDescription;
	}

	public float getStoreService() {
		return storeService;
	}

	public float getStoreShip() {
		return storeShip;
	}

	public void setStoreCredit(Integer storeCredit) {
		this.storeCredit = storeCredit;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}

	public void setStoreDescription(float storeDescription) {
		this.storeDescription = storeDescription;
	}

	public void setStoreService(float storeService) {
		this.storeService = storeService;
	}

	public void setStoreShip(float storeShip) {
		this.storeShip = storeShip;
	}
}
