package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PhysicalResult", desc = "回复信息")
public class PhysicalBO {

	@JsonProperty("uid")
	@FieldMapping(desc = "用户id")
	private String createBy;

	@JsonProperty("minValue")
	@FieldMapping(desc = "体检最小值|视力检查")
	private Float rangeMin;

	@JsonProperty("maxValue")
	@FieldMapping(desc = "体检最大值|如果只有一个值或者体检最大值|色盲测试")
	private Float rangeMax;

	@JsonProperty("time")
	@FieldMapping(desc = "体检时间")
	private String time;

	@JsonProperty("itemCode")
	@FieldMapping(desc = "体检项目编号")
	private String itemCode;

	@JsonProperty("middleValue")
	@FieldMapping(desc = "散光测试")
	private Float middleValue;

	public String getCreateBy() {
		return createBy;
	}

	public Float getRangeMin() {
		return rangeMin;
	}

	public Float getRangeMax() {
		return rangeMax;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public void setRangeMin(Float rangeMin) {
		this.rangeMin = rangeMin;
	}

	public void setRangeMax(Float rangeMax) {
		this.rangeMax = rangeMax;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getTime() {

		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Float getMiddleValue() {
		return middleValue;
	}

	public void setMiddleValue(Float middleValue) {
		this.middleValue = middleValue;
	}
}
