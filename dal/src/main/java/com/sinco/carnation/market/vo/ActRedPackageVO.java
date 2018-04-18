package com.sinco.carnation.market.vo;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.model.ActRedPackage;

public class ActRedPackageVO extends ActRedPackage {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3809352911713166234L;

	/** 开始时间 **/
	private String startTimeStr;

	/** 结束时间 **/
	private String endTimeStr;

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.setStartTime(CommUtil.formatDate(startTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.setEndTime(CommUtil.formatDate(endTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.endTimeStr = endTimeStr;
	}

	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}