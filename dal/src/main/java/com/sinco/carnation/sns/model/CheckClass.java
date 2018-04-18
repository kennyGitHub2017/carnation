package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckClass extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3946778835698677856L;

	/**  **/
	private Long id;

	/** 类型父级id **/
	private Long parentId;

	/** 分类名称 **/
	private String className;

	/** 分类描述 **/
	private String classDesc;

	/**  **/
	private Long updateBy;

	/** 更新时间 **/
	private Date updateTime;

	/**  **/
	private Long createBy;

	/** 创建时间 **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	/** 层级 分类的层级，用于区分父类与子类 **/
	private Integer level;

	/** 索引 分类的索引，用于排序 **/
	private Integer sequence;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
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