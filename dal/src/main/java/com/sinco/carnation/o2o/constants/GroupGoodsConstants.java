package com.sinco.carnation.o2o.constants;

public class GroupGoodsConstants {
	/**
	 * 服务状态 0为上架
	 */
	public static final Integer GROUP_GOODS_STATUS_SELLING = 0;
	/**
	 * 服务状态 1为在仓库中
	 */
	public static final Integer GROUP_GOODS_STATUS_STORE = 1;
	/**
	 * 服务状态 2为定时自动上架
	 */
	public static final Integer GROUP_GOODS_STATUS_TIMING = 2;
	/**
	 * 服务状态 3为店铺过期自动下架
	 */
	public static final Integer GROUP_GOODS_STATUS_AUTO_DOWN = 3;
	/**
	 * 服务状态 -1为手动下架状态
	 */
	public static final Integer GROUP_GOODS_STATUS_HAND_DOWN = -1;
	/**
	 * 服务状态 -2为违规下架状态
	 */
	public static final Integer GROUP_GOODS_STATUS_ILLEGAL_DOWN = -2;
	/**
	 * 服务状态 -3被举报禁售,
	 */
	public static final Integer GROUP_GOODS_STATUS_REPORT_DOWN = -3;

	// ///////////////////////////////////////////////////////////////////////
	/** 团购类型，1为套餐券 */
	public static final Integer GROUP_GOODS_TYPE_PACKAGE_VOUCHER = 1;
	/** 团购类型，2为代金券 */
	public static final Integer GROUP_GOODS_TYPE_CASH_COUPON = 2;

	// ///////////////////////////////////////////////////////////////////////
	/** 团购信息状态，默认为0 **/
	public static final Integer GROUP_INFO_STATUS_DEFAULT = 0;
	/** 团购信息状态，使用后为1 **/
	public static final Integer GROUP_INFO_STATUS_USED = 1;
	/** 团购信息状态，过期为-1 **/
	public static final Integer GROUP_INFO_STATUS_OVERDUE = -1;
	/** 团购信息状态，审核中为3 **/
	public static final Integer GROUP_INFO_STATUS_IN_REVIEW = 3;
	/** 团购信息状态，审核通过为5 **/
	public static final Integer GROUP_INFO_STATUS_AUDIT_PASS = 5;
	/** 团购信息状态，审核不通过为6 **/
	public static final Integer GROUP_INFO_STATUS_AUDIT_FAILE = 6;
	/** 团购信息状态，退款完成为7 **/
	public static final Integer GROUP_INFO_STATUS_REFUND = 7;

}
