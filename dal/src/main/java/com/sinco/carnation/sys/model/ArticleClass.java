package com.sinco.carnation.sys.model;

import com.sinco.dal.common.persistence.mybatis.AddTimeModel;

public class ArticleClass extends AddTimeModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 823229522821261535L;

	/**  **/
	private Long id;

	/**  **/
	private Integer deleteStatus;

	/**  **/
	private String className;

	/**  **/
	private Integer level;

	/**  **/
	private String mark;

	/**  **/
	private Integer sequence;

	/** 是否系统分类 **/
	private Boolean sysClass;

	/**  **/
	private Long parentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Boolean getSysClass() {
		return sysClass;
	}

	public void setSysClass(Boolean sysClass) {
		this.sysClass = sysClass;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
}