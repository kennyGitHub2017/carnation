package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

public class CheckGroup extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7337466651497418077L;

	/**  **/
	private Long id;

	/** 缩略图 **/
	private String thumbnail;

	/** 套题标题 **/
	private String groupTitle;

	/** 概述 **/
	private String summary;

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

	/** 内容 **/
	private String content;

	/** 是否关闭--控制app自测题的显示 **/
	private Byte isClosed;

	/** 自测题权重排序 **/
	private Integer checkGroupSequence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getIsClosed() {
		return isClosed;
	}

	public void setIsClosed(Byte isClosed) {
		this.isClosed = isClosed;
	}

	public Integer getCheckGroupSequence() {
		return checkGroupSequence;
	}

	public void setCheckGroupSequence(Integer checkGroupSequence) {
		this.checkGroupSequence = checkGroupSequence;
	}

}