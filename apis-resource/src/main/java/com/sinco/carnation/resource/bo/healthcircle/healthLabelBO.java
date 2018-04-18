package com.sinco.carnation.resource.bo.healthcircle;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "LabelBO", desc = "帖子标签")
public class healthLabelBO {
	@JsonProperty("id")
	@FieldMapping(desc = "标签id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	@JsonProperty("labelName")
	@FieldMapping(desc = "标签名称")
	private String labelName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

}