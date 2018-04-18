package com.sinco.carnation.resource.bo.shop;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopCoupon", desc = "优惠券")
public class ShopCouponBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("couponAmount")
	@FieldMapping(desc = "优惠券金额")
	private Long couponAmount;

	@JsonProperty("couponCount")
	@FieldMapping(desc = "优惠券发行数量")
	private Integer couponCount;

	@JsonProperty("couponName")
	@FieldMapping(desc = "优惠券名称")
	private String couponName;

	@JsonProperty("couponOrderAmount")
	@FieldMapping(desc = "优惠券使用的订单金额，订单满足该金额时才可以使用该优惠券")
	private Long couponOrderAmount;
    
	@JsonProperty("couponStatus")
	@FieldMapping(desc = "优惠券信息状态，默认为0，,使用后为1,-1为过期")
    private Integer couponStatus;
    
	@JsonProperty("couponType")
	@FieldMapping(desc = "优惠券类型，0为平台优惠券，抵消自营商品订单金额，1为商家优惠券，抵消订单中该商家商品部分金额")
    private Integer couponType;
    
	@JsonProperty("couponBeginTime")
	@FieldMapping(desc = "优惠券使用开始时间")
    private Date couponBeginTime;


	@JsonProperty("couponEndTime")
	@FieldMapping(desc = "优惠券使用结束时间")
    private Date couponEndTime;
    
	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
    private String storeName;
    
	
	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}

	public Long getId() {
		return id;
	}

	public Long getCouponAmount() {
		return couponAmount;
	}

	public Integer getCouponCount() {
		return couponCount;
	}

	public String getCouponName() {
		return couponName;
	}

	public Long getCouponOrderAmount() {
		return couponOrderAmount;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCouponAmount(Long couponAmount) {
		this.couponAmount = couponAmount;
	}

	public void setCouponCount(Integer couponCount) {
		this.couponCount = couponCount;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public void setCouponOrderAmount(Long couponOrderAmount) {
		this.couponOrderAmount = couponOrderAmount;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public Integer getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(Integer couponStatus) {
		this.couponStatus = couponStatus;
	}

	
	
}
