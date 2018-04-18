package com.sinco.carnation.shop.vo;

import java.util.Date;

/**
 * 用于shop查询显示
 * 
 * @author james
 * 
 */
public class ActivityShopVO {

	private Date beginTime;

	private Date endTime;

	private Integer acStatus;

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getAcStatus() {
		return acStatus;
	}

	public void setAcStatus(Integer acStatus) {
		this.acStatus = acStatus;
	}
}