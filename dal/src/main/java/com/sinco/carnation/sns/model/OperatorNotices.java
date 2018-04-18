package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class OperatorNotices extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7101260957549628291L;

	/** 自增ID **/
	private Long id;

	/** 添加时间 **/
	private Date addTime;

	/** 删除状态，1-已删除，0-未删除 **/
	private Boolean deleteStatus;

	/** 排序号 **/
	private Integer ntSort;

	/** 公告状态,0为待审核，1为审核通过,-1未审核失败 **/
	private Integer ntStatus;

	/** 公告标题 **/
	private String ntTitle;

	/** 运营商ID **/
	private Long operatorId;

	/** 公告内容 **/
	private String ntContent;

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

	public Integer getNtSort() {
		return ntSort;
	}

	public void setNtSort(Integer ntSort) {
		this.ntSort = ntSort;
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

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getNtContent() {
		return ntContent;
	}

	public void setNtContent(String ntContent) {
		this.ntContent = ntContent;
	}
}