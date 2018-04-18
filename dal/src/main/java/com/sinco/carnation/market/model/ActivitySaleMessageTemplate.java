package com.sinco.carnation.market.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ActivitySaleMessageTemplate extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8854063760743030794L;

	/** id主键 **/
	private Long id;

	/** 模板标题 **/
	private String title;

	/** 预览图片 **/
	private String picture;

	/** 创建人 **/
	private Long createBy;

	/** 创建时间 **/
	private Date createTime;

	/** 修改人 **/
	private Long modifyBy;

	/** 修改时间 **/
	private Date modifyTime;

	/** 状态0正常1删除 **/
	private Boolean deleteStatus;

	/** H5代码 **/
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}