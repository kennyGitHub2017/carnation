package com.sinco.carnation.operation.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CouponInfo extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6873391915672798113L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 优惠券编号 **/
	private String couponSn;

	/** 优惠券信息状态，默认为0，,使用后为1,-1为过期 **/
	private Integer status;

	/** 对应的优惠券信息 **/
	private Long couponId;

	/** 优惠券拥有的用户 **/
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getCouponSn() {
		return couponSn;
	}

	public void setCouponSn(String couponSn) {
		this.couponSn = couponSn;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCouponId() {
		return couponId;
	}

	public void setCouponId(Long couponId) {
		this.couponId = couponId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}