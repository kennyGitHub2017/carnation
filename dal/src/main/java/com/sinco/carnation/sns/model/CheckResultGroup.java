package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckResultGroup extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3539848732824644787L;

	/**  **/
	private Long id;

	/** 体检分类 **/
	private String groupName;

	/** 创建时间 **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	/** 排序 **/
	private Integer seqenc;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Integer getSeqenc() {
		return seqenc;
	}

	public void setSeqenc(Integer seqenc) {
		this.seqenc = seqenc;
	}
}