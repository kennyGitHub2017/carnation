package com.sinco.carnation.user.vo;

import com.sinco.carnation.sys.model.IntegralReg;

/**
 * @author young
 * 
 */
public class IntegralLogVO extends IntegralReg{
	private static final long serialVersionUID = 7315522073402529929L;
	public String userName;
	private Long userId;
	private String beginTime;
	private String endTime;
	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}