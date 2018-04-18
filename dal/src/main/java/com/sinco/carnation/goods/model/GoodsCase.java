package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

@SuppressWarnings("serial")
public class GoodsCase extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 橱窗标识 **/
	private String caseId;

	/** 橱窗名称 **/
	private String caseName;

	/** 显示 **/
	private Integer display;

	/** 排序 **/
	private Integer sequence;

	/** 其他类型的橱窗，默认0 **/
	private Integer otherCase;

	/** 橱窗信息 **/
	private String caseContent;

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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public Integer getDisplay() {
		return display;
	}

	public void setDisplay(Integer display) {
		this.display = display;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getOtherCase() {
		return otherCase;
	}

	public void setOtherCase(Integer otherCase) {
		this.otherCase = otherCase;
	}

	public String getCaseContent() {
		return caseContent;
	}

	public void setCaseContent(String caseContent) {
		this.caseContent = caseContent;
	}
}