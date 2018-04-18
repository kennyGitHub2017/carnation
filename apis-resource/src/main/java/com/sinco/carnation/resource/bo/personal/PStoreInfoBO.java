package com.sinco.carnation.resource.bo.personal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PStoreInfo", desc = "店铺基本信息")
public class PStoreInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 店铺名称 **/
	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	/** 店铺详细地址 **/
	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺详细地址")
	private String storeAddress;

	/** 店铺等级，根据好评数累加 **/
	@JsonProperty("storeCredit")
	@FieldMapping(desc = "店铺等级，根据好评数累加")
	private Integer storeCredit;

	@JsonProperty("storeEvaluationAverage")
	@FieldMapping(desc = "服务评分")
	private Float storeEvaluationAverage;

	/** 店铺介绍 **/
	@JsonProperty("storeInfo")
	@FieldMapping(desc = "店铺介绍")
	private String storeInfo;

	@JsonProperty("photoPath")
	@FieldMapping(desc = "图片")
	private String photoPath;

	@JsonProperty("photoSize")
	@FieldMapping(desc = "图片数量")
	private Integer photoSize;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double Distance;

	@JsonProperty("storeLon")
	@FieldMapping(desc = "纬度")
	private Double storeLon;

	@JsonProperty("storeLat")
	@FieldMapping(desc = "经度")
	private Double storeLat;

	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话")
	private String storeTelephone;// 店铺电话

	/** 公司简介 **/
	@JsonProperty("licenseCDesc")
	@FieldMapping(desc = "公司简介")
	private String licenseCDesc;
	
	@JsonProperty("createUserId")
	@FieldMapping(desc = "商户ID")
	private Long createUserId;

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

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Integer getStoreCredit() {
		return storeCredit;
	}

	public void setStoreCredit(Integer storeCredit) {
		this.storeCredit = storeCredit;
	}

	public String getStoreInfo() {
		return storeInfo;
	}

	public void setStoreInfo(String storeInfo) {
		this.storeInfo = storeInfo;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public Integer getPhotoSize() {
		return photoSize;
	}

	public void setPhotoSize(Integer photoSize) {
		this.photoSize = photoSize;
	}

	public Float getStoreEvaluationAverage() {
		return storeEvaluationAverage;
	}

	public void setStoreEvaluationAverage(Float storeEvaluationAverage) {
		this.storeEvaluationAverage = storeEvaluationAverage;
	}

	public Double getDistance() {
		return Distance;
	}

	public void setDistance(Double distance) {
		Distance = distance;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getLicenseCDesc() {
		return licenseCDesc;
	}

	public void setLicenseCDesc(String licenseCDesc) {
		this.licenseCDesc = licenseCDesc;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

}
