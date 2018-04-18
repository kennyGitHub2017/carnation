package com.sinco.carnation.operation;

public class OperationConstants {
	/**
	 * 优惠券信息状态，默认为0，,使用后为1,-1为过期
	 */
	public static final Integer COUPON_INFO_STATUS_0 = 0;
	public static final Integer COUPON_INFO_STATUS_1 = 1;
	public static final Integer COUPON_INFO_STATUS_NO_1 = -1;

	/**
	 * 优惠券类型，0为平台优惠券，抵消自营商品订单金额，1为商家优惠券，抵消订单中该商家商品部分金额
	 */
	public static final Integer COUPON_TYPE_0 = 0;
	public static final Integer COUPON_TYPE_1 = 1;
}
