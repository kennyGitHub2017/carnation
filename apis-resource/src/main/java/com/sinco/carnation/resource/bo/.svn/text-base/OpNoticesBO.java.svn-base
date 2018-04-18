package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OpNotices", desc = "营运商发给商户的公告")
public class OpNoticesBO {

	/** 自增ID **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 添加时间 **/
	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	/** 公告状态,0为待审核，1为审核通过,-1未审核失败 **/
	@JsonProperty("ntStatus")
	@FieldMapping(desc = "公告状态,0为待审核，1为审核通过,-1未审核失败")
	private Integer ntStatus;

	/** 公告标题 **/
	@JsonProperty("ntTitle")
	@FieldMapping(desc = "公告标题")
	private String ntTitle;

	/** 公告内容 **/
	@JsonProperty("ntContent")
	@FieldMapping(desc = "公告内容")
	private String ntContent;

	/** 运营商 **/
	@JsonProperty("operatorName")
	@FieldMapping(desc = "运营商 ")
	private String operatorName;

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

	public Integer getNtStatus() {
		return ntStatus;
	}

	public void setNtStatus(Integer ntStatus) {
		this.ntStatus = ntStatus;
	}

	public String getNtTitle() {
		return ntTitle;
	}

	public void setNtTitle(String ntTitle) {
		this.ntTitle = ntTitle;
	}

	public String getNtContent() {
		return ntContent;
	}

	public void setNtContent(String ntContent) {
		this.ntContent = ntContent;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

}
