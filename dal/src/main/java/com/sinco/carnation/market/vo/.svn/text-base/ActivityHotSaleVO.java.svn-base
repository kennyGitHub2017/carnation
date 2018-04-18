package com.sinco.carnation.market.vo;

import org.springframework.util.StringUtils;

import com.sinco.carnation.market.model.ActivityHotSale;

public class ActivityHotSaleVO extends ActivityHotSale {

	private static final long serialVersionUID = 444265099572031528L;
	private String strStartTime; // 用于接收日期控件传入的String类型的日期
	private String strEndTime;// 用于接收日期控件传入的String类型的日期

	private ActivitySaleMessageVO saleMessage;
	private String strOpenStartTime;
	private String strOpenEndTime;

	public String getStrStartTime() {
		return strStartTime;
	}

	public void setStrStartTime(String strStartTime) {
		this.strStartTime = strStartTime;
	}

	public String getStrEndTime() {
		return strEndTime;
	}

	public void setStrEndTime(String strEndTime) {
		this.strEndTime = strEndTime;
	}

	public ActivitySaleMessageVO getSaleMessage() {
		return saleMessage;
	}

	public void setSaleMessage(ActivitySaleMessageVO saleMessage) {
		this.saleMessage = saleMessage;
	}

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