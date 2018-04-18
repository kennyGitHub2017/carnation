package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "RecommStoreInfo", desc = "推荐店铺信息")
public class RecommStoreInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺详细地址")
	private String storeAddress;

	@JsonProperty("area")
	@FieldMapping(desc = "地区")
	private String area;

	@JsonProperty("star")
	@FieldMapping(desc = "星级")
	private Integer star;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double distance;

	@JsonProperty("storeInfoPath")
	@FieldMapping(desc = "banner图片")
	private String storeInfoPath;

	@JsonProperty("evaluationAverage")
	@FieldMapping(desc = "服务评分")
	private Float evaluationAverage;// 服务评分

	@JsonProperty("groupDiscount")
	@FieldMapping(desc = "服务折扣")
	private BigDecimal groupDiscount;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getStoreInfoPath() {
		return storeInfoPath;
	}

	public void setStoreInfoPath(String storeInfoPath) {
		this.storeInfoPath = storeInfoPath;
	}

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}
}
