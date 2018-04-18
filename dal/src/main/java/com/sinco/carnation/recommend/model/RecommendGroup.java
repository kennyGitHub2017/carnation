package com.sinco.carnation.recommend.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class RecommendGroup extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8674556568678215709L;

	/**  **/
	private Long id;

	/**  **/
	private String groupKey;

	/**  **/
	private String groupName;

	/**  **/
	private String groupDesc;

	/** 推荐位图片宽 **/
	private Integer imgWidth;

	/** 推荐位图片高 **/
	private Integer imgHeight;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Integer getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(Integer imgWidth) {
		this.imgWidth = imgWidth;
	}

	public Integer getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(Integer imgHeight) {
		this.imgHeight = imgHeight;
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