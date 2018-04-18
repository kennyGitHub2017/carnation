package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "StoreSearch", desc = "商户搜索")
public class StoreSearchBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeInfoPath")
	@FieldMapping(desc = "店铺图片")
	private String storeInfoPath;

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺地址")
	private String storeAddress;

	@JsonProperty("sales")
	@FieldMapping(desc = "销量")
	private Long sales;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离|米")
	private Integer distance;

	@JsonProperty("storeEvaluationCount")
	@FieldMapping(desc = "评论数量")
	private Integer storeEvaluationCount;

	@JsonProperty("storeEvaluationAverage")
	@FieldMapping(desc = "星级")
	private Integer storeEvaluationAverage;

	@JsonProperty("groupDiscount")
	@FieldMapping(desc = "服务折扣")
	private BigDecimal groupDiscount;

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

	public String getStoreInfoPath() {
		return storeInfoPath;
	}

	public void setStoreInfoPath(String storeInfoPath) {
		this.storeInfoPath = storeInfoPath;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public Integer getStoreEvaluationCount() {
		return storeEvaluationCount;
	}

	public void setStoreEvaluationCount(Integer storeEvaluationCount) {
		this.storeEvaluationCount = storeEvaluationCount;
	}

	public Integer getStoreEvaluationAverage() {
		return storeEvaluationAverage;
	}

	public void setStoreEvaluationAverage(Integer storeEvaluationAverage) {
		this.storeEvaluationAverage = storeEvaluationAverage;
	}

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

}
