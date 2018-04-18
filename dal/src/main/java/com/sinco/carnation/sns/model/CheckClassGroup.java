package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckClassGroup extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7630097101704104146L;

	/**  **/
	private Long id;

	/** 分类id **/
	private Long classId;

	/** 套题id **/
	private Long groupId;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
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
}