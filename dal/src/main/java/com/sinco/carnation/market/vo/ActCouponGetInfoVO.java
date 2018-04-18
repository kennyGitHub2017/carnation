package com.sinco.carnation.market.vo;

import java.util.Date;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.model.ActCouponGetInfo;

public class ActCouponGetInfoVO extends ActCouponGetInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** 优惠券活动开始结束时间 **/
	private String startGetTimeStr;

	/** 优惠券活动结束时间 **/
	private String endGetTimeStr;

	// 查询范围(开始时间-结束时间)
	private Date queryStartTime;

	private Date queryEndTime;

	private String mobile;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String nickName;

	public Date getQueryStartTime() {
		return queryStartTime;
	}

	public void setQueryStartTime(Date queryStartTime) {
		this.queryStartTime = queryStartTime;
	}

	public Date getQueryEndTime() {
		return queryEndTime;
	}

	public void setQueryEndTime(Date queryEndTime) {
		this.queryEndTime = queryEndTime;
	}

	public String getStartGetTimeStr() {
		return startGetTimeStr;
	}

	public void setStartGetTimeStr(String startGetTimeStr) {
		this.setQueryStartTime(CommUtil.formatDate(startGetTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.startGetTimeStr = startGetTimeStr;
	}

	public String getEndGetTimeStr() {
		return endGetTimeStr;
	}

	public void setEndGetTimeStr(String endGetTimeStr) {
		this.setQueryEndTime(CommUtil.formatDate(endGetTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.endGetTimeStr = endGetTimeStr;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}