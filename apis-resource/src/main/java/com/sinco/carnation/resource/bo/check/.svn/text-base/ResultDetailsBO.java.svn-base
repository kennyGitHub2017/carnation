package com.sinco.carnation.resource.bo.check;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "体检明细", domainName = "ResultDetails")
public class ResultDetailsBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 体检项目 **/
	@JsonProperty("physicalName")
	@FieldMapping(desc = "体检项目")
	private String physicalName;

	/** 最小值 **/
	@JsonProperty("minVale")
	@FieldMapping(desc = "最小值")
	private String minVale;

	/** 最大值 **/
	@JsonProperty("maxValue")
	@FieldMapping(desc = "最大值")
	private String maxValue;

	/** 实际值 **/
	@JsonProperty("referenceValue")
	@FieldMapping(desc = "实际值 ")
	private String referenceValue;

	/** 阳性 **/
	@JsonProperty("positive")
	@FieldMapping(desc = "阴阳参考值0阴1阳阳性")
	private String positive;

	/** 单位 **/
	@JsonProperty("unit")
	@FieldMapping(desc = "单位")
	private String unit;

	/** 结果 **/
	@JsonProperty("result")
	@FieldMapping(desc = "结果|0正常、1超标")
	private String result;

	@JsonProperty("value")
	@FieldMapping(desc = "结果|输入型参考值")
	private String value;

	@JsonProperty("type")
	@FieldMapping(desc = "结果|0数值型（录入）、1选项型（阴、阳值）")
	private Integer type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhysicalName() {
		return physicalName;
	}

	public void setPhysicalName(String physicalName) {
		this.physicalName = physicalName;
	}

	public String getMinVale() {
		return minVale;
	}

	public void setMinVale(String minVale) {
		this.minVale = minVale;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(String referenceValue) {
		this.referenceValue = referenceValue;
	}

	public String getPositive() {
		return positive;
	}

	public void setPositive(String positive) {
		this.positive = positive;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
