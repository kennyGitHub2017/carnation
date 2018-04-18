package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class Comsume extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 712407973706745491L;

	/**  **/
	private Long id;

	/**  **/
	private BigDecimal couponPayAmount;

	/**  **/
	private BigDecimal chargePayAmount;

	/**  **/
	private BigDecimal rebateAmount;

	/**  **/
	private Date addTime;

	/**  **/
	private Long storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCouponPayAmount() {
		return couponPayAmount;
	}

	public void setCouponPayAmount(BigDecimal couponPayAmount) {
		this.couponPayAmount = couponPayAmount;
	}

	public BigDecimal getChargePayAmount() {
		return chargePayAmount;
	}

	public void setChargePayAmount(BigDecimal chargePayAmount) {
		this.chargePayAmount = chargePayAmount;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
}