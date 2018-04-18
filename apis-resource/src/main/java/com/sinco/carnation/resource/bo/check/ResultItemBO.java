package com.sinco.carnation.resource.bo.check;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "体检项", domainName = "ResultItem")
public class ResultItemBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 体检项目名称 **/
	@JsonProperty("itemName")
	@FieldMapping(desc = "体检项目名称")
	private String itemName;

	/** 创建时间 **/
	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间 ")
	private Date createTime;

	/**  **/
	@JsonProperty("groupId")
	@FieldMapping(desc = "分类id ")
	private Long groupId;

	/** 0数值型（录入）、1选项型（阴、阳值） **/
	@JsonProperty("type")
	@FieldMapping(desc = "0数值型（录入）、1选项型（阴、阳值）")
	private Integer type;

	/** 0常用、1取消常用 **/
	@JsonProperty("usingItem")
	@FieldMapping(desc = "0常用、1取消常用")
	private Integer using;

	/** 最小值 **/
	@JsonProperty("minValue")
	@FieldMapping(desc = "参考最小值")
	private String minValue;

	/** 最大值 **/
	@JsonProperty("maxValue")
	@FieldMapping(desc = "参考最大值")
	private String maxValue;

	/** 单位 **/
	@JsonProperty("unit")
	@FieldMapping(desc = "单位 ")
	private String unit;

	/** 阴阳参考值0阴1阳 **/
	@JsonProperty("referenceValue")
	@FieldMapping(desc = "阴阳参考值0阴1阳 ")
	private Integer referenceValue;

	@JsonProperty("value")
	@FieldMapping(desc = "参考值")
	private String value;

	public Integer getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(Integer referenceValue) {
		this.referenceValue = referenceValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUsing() {
		return using;
	}

	public void setUsing(Integer using) {
		this.using = using;
	}

	public String getMinValue() {
		return minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
