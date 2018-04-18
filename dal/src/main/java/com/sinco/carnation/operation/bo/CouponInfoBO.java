package com.sinco.carnation.operation.bo;

import java.util.Date;

import com.sinco.carnation.operation.model.CouponInfo;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class CouponInfoBO extends CouponInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CouponBO coupon;
	/** 优惠券使用开始时间 **/
	private Date couponBeginTime;

	/** 优惠券发行数量 **/
	private Integer couponCount;

	/** 优惠券使用结束时间 **/
	private Date couponEndTime;

	/** 优惠券名称 **/
	private String couponName;
	/**
	 * 用户名
	 */
	private String loginName;

	/** 优惠券金额 **/
	private Long couponAmount;

	/** 优惠券使用的订单金额，订单满足该金额时才可以使用该优惠券 **/
	private Long couponOrderAmount;

	public CouponBO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponBO coupon) {
		this.coupon = coupon;
	}

	public String getLoginName() {
		return loginName;
	}

	public Long getCouponAmount() {
		return couponAmount;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setCouponAmount(Long couponAmount) {
		this.couponAmount = couponAmount;
	}

	public Date getCouponBeginTime() {
		return couponBeginTime;
	}

	public void setCouponBeginTime(Date couponBeginTime) {
		this.couponBeginTime = couponBeginTime;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public Date getCouponEndTime() {
		return couponEndTime;
	}

	public void setCouponEndTime(Date couponEndTime) {
		this.couponEndTime = couponEndTime;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public Long getCouponOrderAmount() {
		return couponOrderAmount;
	}

	public void setCouponOrderAmount(Long couponOrderAmount) {
		this.couponOrderAmount = couponOrderAmount;
	}

}