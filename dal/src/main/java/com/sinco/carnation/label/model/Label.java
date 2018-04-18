package com.sinco.carnation.label.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Label extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3384564554048376372L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 标签名字 **/
	private String labelName;

	/** 状态，初始化状态0，审核通过状态1，失败状态2 **/
	private Integer state;

	/** 标签类型：1用户自定义，2系统自定义标签，3后台维护成圈子 **/
	private Integer type;

	/** 是否显示在前台列表:0默认不显示，1显示 **/
	private Integer ispush;

	/** 用户自定义标签用户id **/
	private Long userId;

	/** 排序 **/
	private Integer ordering;

	/** 分类id **/
	private Long class_id;
	/** 备注 **/
	private String memo;
	/** 服务类型 **/
	private Integer serviceType;

	public Long getClass_id() {
		return class_id;
	}

	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getOrdering() {
		return ordering;
	}

	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}

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

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getIspush() {
		return ispush;
	}

	public void setIspush(Integer ispush) {
		this.ispush = ispush;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}