package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ShopCouponInfo", desc = "优惠券")
public class ShopCouponInfoBO {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "优惠券id")
	private Long id;

	@JsonProperty("coupon")
	@FieldMapping(desc = "优惠券信息")
	private ShopCouponBO coupon;

	public ShopCouponBO getCoupon() {
		return coupon;
	}

	public void setCoupon(ShopCouponBO coupon) {
		this.coupon = coupon;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
