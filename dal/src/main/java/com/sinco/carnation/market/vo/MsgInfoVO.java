package com.sinco.carnation.market.vo;

import com.sinco.carnation.market.model.MsgInfo;

public class MsgInfoVO extends MsgInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663873474747107586L;

	private String startTimeStr;

	private String endTimeStr;

	private String createName;

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getStartTimeStr() {

		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

}