package com.sinco.carnation.market.bo;

import org.springframework.util.StringUtils;

import com.sinco.carnation.market.model.ActivityHotSale;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ActivityHotSaleBO extends ActivityHotSale {
	private static final long serialVersionUID = 5733093720813859590L;
	private String strOpenStartTime;
	private String strOpenEndTime;

	public String getStrOpenStartTime() {
		if (getOpenStartTime() != null && getOpenStartTime() > 0) {
			int hour = getOpenStartTime() / 60;
			int min = getOpenStartTime() % 60;
			if (hour < 10 && min < 10) {
				setStrOpenStartTime("0" + hour + ":" + "0" + min);
			} else if (hour < 10) {
				setStrOpenStartTime("0" + hour + ":" + min);
			} else if (min < 10) {
				setStrOpenStartTime(hour + ":" + "0" + min);
			} else {
				setStrOpenStartTime(hour + ":" + min);
			}
		} else {
			setStrOpenStartTime("00:00");
		}
		return strOpenStartTime;
	}

	public void setStrOpenStartTime(String strOpenStartTime) {
		if (StringUtils.hasText(strOpenStartTime)) {
			String[] times = strOpenStartTime.split(":");
			setOpenStartTime(Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
		}
		this.strOpenStartTime = strOpenStartTime;
	}

	public String getStrOpenEndTime() {
		if (getOpenEndTime() != null && getOpenEndTime() > 0) {
			int hour = getOpenEndTime() / 60;
			int min = getOpenEndTime() % 60;
			if (hour < 10 && min < 10) {
				setStrOpenEndTime("0" + hour + ":" + "0" + min);
			} else if (hour < 10) {
				setStrOpenEndTime("0" + hour + ":" + min);
			} else if (min < 10) {
				setStrOpenEndTime(hour + ":" + "0" + min);
			} else {
				setStrOpenEndTime(hour + ":" + min);
			}
		} else {
			setStrOpenStartTime("00:00");
		}
		return strOpenEndTime;
	}

	public void setStrOpenEndTime(String strOpenEndTime) {
		if (StringUtils.hasText(strOpenEndTime)) {
			String[] times = strOpenEndTime.split(":");
			setOpenEndTime(Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]));
		}
		this.strOpenEndTime = strOpenEndTime;
	}
}