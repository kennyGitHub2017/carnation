package com.sinco.carnation.user.vo;

import java.util.Date;

public class UserRebateStatisVO {

	// 用户uid
	private Long uid;

	// 类型 1.O2O 2.B2C
	private String statisType;

	// 开始时间
	private Date startTime;

	// 结束时间
	private Date endTime;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getStatisType() {
		return statisType;
	}

	public void setStatisType(String statisType) {
		this.statisType = statisType;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}