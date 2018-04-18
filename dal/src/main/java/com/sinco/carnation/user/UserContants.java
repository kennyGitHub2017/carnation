package com.sinco.carnation.user;

import java.math.BigDecimal;

public class UserContants {

	/**
	 * 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换
	 */
	public final static String INTEGRAL_LOG_TYPE_REG = "reg";
	/**
	 * 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换
	 */
	public final static String INTEGRAL_LOG_TYPE_SYSTEM = "system";
	/**
	 * 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换
	 */
	public final static String INTEGRAL_LOG_TYPE_LOGIN = "login";
	/**
	 * 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换
	 */
	public final static String INTEGRAL_LOG_TYPE_ORDER = "order";
	/**
	 * 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换
	 */
	public final static String INTEGRAL_LOG_TYPE_INTEGRAL_ORDER = "integral_order";

	/** 收藏类型 1，帖子 2，医生 3,商品 4店铺,5服务,6商户 **/
	public final static String FAVORITES_TYPE_1 = "1";
	public final static String FAVORITES_TYPE_2 = "2";
	public final static String FAVORITES_TYPE_3 = "3";
	public final static String FAVORITES_TYPE_4 = "4";
	public final static String FAVORITES_TYPE_5 = "5";
	public final static String FAVORITES_TYPE_6 = "6";

	/** 预存款状态，0为未完成，1为成功，-1已关闭 **/
	public final static Integer PD_STATUS_0 = 0;
	public final static Integer PD_STATUS_1 = 1;
	public final static Integer PD_STATUS_NO_1 = -1;

	/** 支付状态，0为等待支付，1为线下提交支付完成申请，2为支付成功 **/
	public final static Integer PD_PAY_STATUS_0 = 0;
	public final static Integer PD_PAY_STATUS_1 = 1;
	public final static Integer PD_PAY_STATUS_2 = 2;

	/** 支付状态，0审核中，1审核通过，2审核不通过 **/
	public final static String OPERATOR_CHECK_STATUS_CHECKING = "0";
	public final static String OPERATOR_CHECK_STATUS_PASS = "1";
	public final static String OPERATOR_CHECK_STATUS_FAILD = "-1";
	/** 运营商级别 ： 1市级，2区级，3VIP经销商,7金卡，9银卡 **/
	public final static String OPERATOR_LEVEL_SHI = "1";
	public final static String OPERATOR_LEVEL_QU = "2";
	public final static String OPERATOR_LEVEL_QUYU = "3";
	public final static String OPERATOR_LEVEL_GOLD = "7";
	public final static String OPERATOR_LEVEL_SILVER = "9";

	/** 云豆操作类型，分为充值、提现、消费、兑换金币、人工操作 **/
	public final static String PD_OP_TYPE_RECHARGE = "充值";
	public final static String PD_OP_TYPE_WITHDRAW = "提现";
	public final static String PD_OP_TYPE_WITHDRAW_POUNDAGE = "提现手续费";
	public final static String PD_OP_TYPE_CONSUMPTION = "消费";
	public final static String PD_OP_TYPE_MANUAL_OPERATION = "人工操作";
	public final static String PD_OP_TYPE_REBATE = "返润";
	public final static String PD_OP_TYPE_SELL = "销售";

	/** 云豆类型，分为可用云豆，冻结云豆 **/
	public final static String PD_TYPE_AVAILABLE_MONEY = "可用云豆";
	public final static String PD_OP_TYPE_FREEZE_MONEY = "冻结云豆";

	/** 返利类型比例值 :MEMBER_GOOD_REBATE_RATE 会员反润比例，SHOP_GOOD_REBATE_RATE-店铺反润比例 **/
	public final static BigDecimal MEMBER_GOOD_REBATE_RATE = new BigDecimal("0.2");
	public final static BigDecimal SHOP_GOOD_REBATE_RATE = new BigDecimal("0.2");
	/**
	 * 用户类型：商户
	 */
	public final static Integer CUSTOMER_TYPE_MERCHANT = 1;
	/**
	 * 用户类型：供应商
	 */
	public final static Integer CUSTOMER_TYPE_SUPPLIER = 2;
	/**
	 * 用户类型：运营商
	 */
	public final static Integer CUSTOMER_TYPE_OPERATOR = 3;
}
