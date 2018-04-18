package com.sinco.carnation.o2o.constants;

public class GroupOrderConstants {
	/**
	 * 订单取消
	 */
	public final static Integer ORDER_STATUS_CANCEL = 0;
	/**
	 * 待付款
	 */
	public final static Integer ORDER_STATUS_SUBMIT = 10;
	/**
	 * 已付款
	 */
	public final static Integer ORDER_STATUS_PAYMENT = 20;
	/**
	 * 已使用
	 */
	public final static Integer ORDER_STATUS_USEED = 30;
	/**
	 * 已评价
	 */
	public final static Integer ORDER_STATUS_EVALUATE = 50;
	/**
	 * 不可评价
	 */
	public final static Integer ORDER_STATUS_NOT_EVALUATE = 60;
	/**
	 * 过期
	 */
	public final static Integer ORDER_STATUS_OVERDUE = 80;
	/**
	 * PC网页订单
	 */
	public final static String ORDER_SOURCE_WEB = "web";
	/**
	 * 手机网页订单
	 */
	public final static String ORDER_SOURCE_WEIXIN = "weixin";
	/**
	 * 安卓客户端
	 */
	public final static String ORDER_SOURCE_ANDROID = "android";
	/**
	 * 苹果客户端
	 */
	public final static String ORDER_SOURCE_IOS = "ios";
}
