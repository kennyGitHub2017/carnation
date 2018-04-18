package com.sinco.carnation.resource.web.response.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.shop.ShopCouponInfoBO;

public class CouponInfoResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("couponInfos")
	@ReturnMapping(desc = "优惠券列表")
	private List<ShopCouponInfoBO> couponInfos;

	@JsonProperty("userCouponCount")
	@ReturnMapping(desc = "优惠券列表记录总数")
	private Long userCouponCount;

	public List<ShopCouponInfoBO> getCouponInfos() {
		return couponInfos;
	}

	public void setCouponInfos(List<ShopCouponInfoBO> couponInfos) {
		this.couponInfos = couponInfos;
	}

	public Long getUserCouponCount() {
		return userCouponCount;
	}

	public void setUserCouponCount(Long userCouponCount) {
		this.userCouponCount = userCouponCount;
	}

}
