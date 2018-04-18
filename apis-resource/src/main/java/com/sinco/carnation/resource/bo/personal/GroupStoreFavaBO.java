package com.sinco.carnation.resource.bo.personal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "GroupStoreFava", desc = "收藏商户")
public class GroupStoreFavaBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeCredit")
	@FieldMapping(desc = "店铺等级，根据好评数累加")
	private Integer storeCredit;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double distance;

	@JsonProperty("createUserId")
	@FieldMapping(desc = "买家id")
	private Long createUserId;

	@JsonProperty("storeLat")
	@FieldMapping(desc = "经度")
	private Double storeLat;

	@JsonProperty("storeLon")
	@FieldMapping(desc = "纬度 ")
	private Double storeLon;

	@JsonProperty("evaluationAverage")
	@FieldMapping(desc = "服务评分")
	private Float evaluationAverage;

	@JsonProperty("storeInfoPath")
	@FieldMapping(desc = "图片")
	private String storeInfoPath;

	public Float getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Float evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStoreCredit() {
		return storeCredit;
	}

	public void setStoreCredit(Integer storeCredit) {
		this.storeCredit = storeCredit;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Double getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Double storeLat) {
		this.storeLat = storeLat;
	}

	public Double getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Double storeLon) {
		this.storeLon = storeLon;
	}

	public String getStoreInfoPath() {
		return storeInfoPath;
	}

	public void setStoreInfoPath(String storeInfoPath) {
		this.storeInfoPath = storeInfoPath;
	}

}
