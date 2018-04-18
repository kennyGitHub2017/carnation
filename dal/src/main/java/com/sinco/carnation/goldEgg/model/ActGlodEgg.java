package com.sinco.carnation.goldEgg.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;

@SuppressWarnings("serial")
public class ActGlodEgg extends BaseModel {
	/**  **/
	private Long id;

	/** 发行总量 **/
	private Long totalCount;

	/** 发行总额 **/
	private BigDecimal totalMoney;

	/** 日限金额 **/
	private BigDecimal dayLimitMoney;

	/** 已领取金额(总金额) **/
	private BigDecimal currentGetMoney;

	/** 权重(0-100) **/
	private Integer priority;

	/** 活动act_app_hot_sale.id **/
	private Long actId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getDayLimitMoney() {
		return dayLimitMoney;
	}

	public void setDayLimitMoney(BigDecimal dayLimitMoney) {
		this.dayLimitMoney = dayLimitMoney;
	}

	public BigDecimal getCurrentGetMoney() {
		return currentGetMoney;
	}

	public void setCurrentGetMoney(BigDecimal currentGetMoney) {
		this.currentGetMoney = currentGetMoney;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}
}