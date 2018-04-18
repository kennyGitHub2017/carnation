package com.sinco.carnation.operation.vo;

import java.math.BigDecimal;
import java.util.Date;

public class CouponInfoMyVO {
	private BigDecimal couponOrderAmount;

	private Long uid;

	private Long id;

	private Date couponBeginTime;

	private Date couponEndTime;

	private Integer status;

	private Integer couponType;

	private Long storeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCouponOrderAmount() {
		return couponOrderAmount;
	}

	public void setCouponOrderAmount(BigDecimal couponOrderAmount) {
		this.couponOrderAmount = couponOrderAmount;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Date getCouponBeginTime() {
		return couponBeginTime;
	}

	public void setCouponBeginTime(Date couponBeginTime) {
		this.couponBeginTime = couponBeginTime;
	}

	public Date getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
}