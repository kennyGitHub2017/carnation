package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckGroupResult extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6229298155165653792L;

	/**  **/
	private Long id;

	/** 套题id **/
	private Long groupId;

	/** 套题分数开始 **/
	private Integer startScore;

	/** 套题分结束 **/
	private Integer endScore;

	/** 结果描述 **/
	private String resultDesc;

	/**  **/
	private Long updateBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	/****/
	private String resultTarget;

	public String getResultTarget() {
		return resultTarget;
	}

	public void setResultTarget(String resultTarget) {
		this.resultTarget = resultTarget;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getStartScore() {
		return startScore;
	}

	public void setStartScore(Integer startScore) {
		this.startScore = startScore;
	}

	public Integer getEndScore() {
		return endScore;
	}

	public void setEndScore(Integer endScore) {
		this.endScore = endScore;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}