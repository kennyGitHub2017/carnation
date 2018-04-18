package com.sinco.carnation.shop.bo;

import java.math.BigDecimal;

import com.sinco.carnation.shop.model.PredepositLog;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class PredepositLogBO extends PredepositLog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2214509201156355220L;
	private String nickName;
	private String adminName;
	private Integer years;// 年
	private Integer months;// 月
	private BigDecimal monthTotalPrice;// 月总收入

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public Integer getYears() {
		return years;
	}

	public void setYears(Integer years) {
		this.years = years;
	}

	public Integer getMonths() {
		return months;
	}

	public void setMonths(Integer months) {
		this.months = months;
	}

	public BigDecimal getMonthTotalPrice() {
		return monthTotalPrice;
	}

	public void setMonthTotalPrice(BigDecimal monthTotalPrice) {
		this.monthTotalPrice = monthTotalPrice;
	}

}