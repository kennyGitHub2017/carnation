package com.sinco.carnation.resource.bo.personal;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PGroupGoods", desc = "服务")
public class PGroupGoodsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("ggName")
	@FieldMapping(desc = "商品名称")
	private String ggName;

	@JsonProperty("costPrice")
	@FieldMapping(desc = "原价")
	private BigDecimal costPrice;

	@JsonProperty("ggRebate")
	@FieldMapping(desc = "团购折扣")
	private BigDecimal ggRebate;

	@JsonProperty("groupPrice")
	@FieldMapping(desc = "团队价 ")
	private BigDecimal groupPrice;

	@JsonProperty("ggStatus")
	@FieldMapping(desc = "商品状态 |  0为上架，1为在仓库中，3为店铺过期自动下架，-2为违规下架状态")
	private Integer ggStatus;

	@JsonProperty("groupAccPath")
	@FieldMapping(desc = "团购图片")
	private String groupAccPath;

	@JsonProperty("groupDesc")
	@FieldMapping(desc = "服务描述")
	private String groupDesc;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺地址")
	private String storeAddress;

	@JsonProperty("distance")
	@FieldMapping(desc = "距离")
	private Double distance;

	@JsonProperty("storeId")
	@FieldMapping(desc = "店铺id ")
	private Long storeId;

	@JsonProperty("evaluationAverage")
	@FieldMapping(desc = "服务评分")
	private Float evaluationAverage;

	@JsonProperty("selledCount")
	@FieldMapping(desc = "已经售出的数量")
	private Integer selledCount;

	@JsonProperty("gradeId")
	@FieldMapping(desc = "店铺等级")
	private Integer gradeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getGgRebate() {
		return ggRebate;
	}

	public void setGgRebate(BigDecimal ggRebate) {
		this.ggRebate = ggRebate;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Integer getGgStatus() {
		return ggStatus;
	}

	public void setGgStatus(Integer ggStatus) {
		this.ggStatus = ggStatus;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Float getEvaluationAverage() {
		return evaluationAverage;
	}

	public void setEvaluationAverage(Float evaluationAverage) {
		this.evaluationAverage = evaluationAverage;
	}

	public Integer getSelledCount() {
		return selledCount;
	}

	public void setSelledCount(Integer selledCount) {
		this.selledCount = selledCount;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

}
