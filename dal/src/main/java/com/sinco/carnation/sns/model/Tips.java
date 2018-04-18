package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Tips extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1492184399906613599L;

	/**  **/
	private Long id;

	/** 举报时间 **/
	private Date addTime;

	/** 举报对象 **/
	private Long targetId;

	/** 举报类型 **/
	private String tipsType;

	/** 发起举报的用户 **/
	private Long fromUserId;

	/** 举报的IP地址 **/
	private String fromIp;

	/** 0帖子1资讯 **/
	private Integer type;

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

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getTipsType() {
		return tipsType;
	}

	public void setTipsType(String tipsType) {
		this.tipsType = tipsType;
	}

	public Long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(Long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public String getFromIp() {
		return fromIp;
	}

	public void setFromIp(String fromIp) {
		this.fromIp = fromIp;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}