package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckResultItem extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1238750890703328068L;

	/**  **/
	private Long id;

	/** 体检项目名称 **/
	private String itemName;

	/** 创建时间 **/
	private Date createTime;

	/**  **/
	private Long groupId;

	/** 0数值型（录入）、1选项型（阴、阳值） **/
	private Integer type;

	/** 0常用、1取消常用 **/
	private Integer using;

	/** 排序 **/
	private Integer seqenc;

	/** 最小值 **/
	private String minValue;

	/** 最大值 **/
	private String maxValue;

	/** 单位 **/
	private String unit;

	/** 阴阳参考值0阴1阳 **/
	private Integer referenceValue;

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

	public Integer getSeqenc() {
		return seqenc;
	}

	public void setSeqenc(Integer seqenc) {
		this.seqenc = seqenc;
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

	public Integer getReferenceValue() {
		return referenceValue;
	}

	public void setReferenceValue(Integer referenceValue) {
		this.referenceValue = referenceValue;
	}
}