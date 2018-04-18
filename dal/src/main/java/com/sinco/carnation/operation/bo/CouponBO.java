package com.sinco.carnation.operation.bo;

import com.sinco.carnation.operation.model.Coupon;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class CouponBO extends Coupon {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer couponInfoCount;

	private String storeName;

	// 优惠券信息状态，默认为0，,使用后为1,-1为过期
	private Integer couponStatus;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Integer getCouponInfoCount() {
		return couponInfoCount;
	}

	public void setCouponInfoCount(Integer couponInfoCount) {
		this.couponInfoCount = couponInfoCount;
	}

	public Integer getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(Integer couponStatus) {
		this.couponStatus = couponStatus;
	}

}