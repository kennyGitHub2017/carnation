package com.sinco.carnation.shop.bo;

import java.math.BigDecimal;

import com.sinco.carnation.shop.model.PredepositPfLog;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class PredepositPfLogBO extends PredepositPfLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6942815201372527863L;
	private Integer years;// 年
	private Integer months;// 月
	private BigDecimal monthTotalPrice;// 月总收入

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