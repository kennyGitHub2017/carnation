package com.sinco.carnation.sys.contants;

public class UserContant {

	/** 账户类型 1:邮箱 2:手机 3:QQ 4:微信5:微博9:自定义账户 */
	public static final String ACCOUNT_TYPE_1 = "1";

	/** 账户类型 1:邮箱 2:手机 3:QQ 4:微信5:微博9:自定义账户 */
	public static final String ACCOUNT_TYPE_3 = "3";

	/** 账户类型 1:邮箱 2:手机 3:QQ 4:微信5:微博9:自定义账户 */
	public static final String ACCOUNT_TYPE_4 = "4";

	/** 账户类型 1:邮箱 2:手机 3:QQ4:微信5:微博9:自定义账户 */
	public static final String ACCOUNT_TYPE_5 = "5";

	/** 账户类型 1:邮箱 2:手机 3:QQ4:微信5:微博9:自定义账户 */
	public static final String ACCOUNT_TYPE_2 = "2";

	/** 账户类型 1:邮箱 2:手机 3: 微信 4:QQ 5:微博 9:用户名 */
	public static final String ACCOUNT_TYPE_9 = "9";

	/*** 用户状态 1 正常 **/
	public static final Integer USER_STATUS_1 = 1;

	/*** 用户类型 1 个人、商户 3专家 4运营商 9 后台管理员 */
	public static final Integer USER_TYPE_1 = 1;

	/*** 用户类型 1 个人、商户 3专家 4运营商 9 后台管理员 */
	public static final Integer USER_TYPE_3 = 3;

	/*** 用户类型 1 个人、商户 3专家 4运营商 9 后台管理员 */
	public static final Integer USER_TYPE_9 = 9;

	/*** 用户类型 1 个人、商户 3专家 4运营商 9 后台管理员 */
	public static final Integer USER_TYPE_4 = 4;

	/*** 用户类型 1 个人、商户 3专家 4运营商 9 后台管理员 10 个人、云购币供应商 */
	public static final Integer USER_TYPE_10 = 10;

	/** 账户类型 1:邮箱 2:手机 3:QQ4:微信5:微博9:自定义账户8:CN账户 */
	public static final String ACCOUNT_TYPE_8 = "8";
	public static final String ROLE_TYPE_SELLER = "SELLER";
	public static final String ROLE_TYPE_BUYER = "BUYER";
	public static final String ROLE_TYPE_ADMIN = "ADMIN";
	public static final String ROLE_TYPE_OPERATOR = "OPERATOR";

	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 */
	public static final String ACCOUNT_TYPE_RESOURCE = "resource";
	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 */
	public static final String ACCOUNT_TYPE_MERCHANT = "merchant";
	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 */
	public static final String ACCOUNT_TYPE_SUPPLIER = "supplier";
	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 */
	public static final String ACCOUNT_TYPE_CN = "CN";
	/** resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户 */
	public static final String ACCOUNT_TYPE_YY = "YY";
	public static final String ACCOUNT_TYPE_SN = "SN";

	/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
	public static final String USER_CODE_USER = "0";
	/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
	public static final String USER_CODE_B2C = "1";
	/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
	public static final String USER_CODE_O2O = "2";
	/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
	public static final String USER_CODE_CN = "3";
	/** 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商 **/
	public static final String USER_CODE_YY = "4";

	/** 状态， admin表示后台，user表示前台,seller表示商家 */
	public static final String ACCOUNT_STATUS_ADMIN = "admin";
	/** 状态， admin表示后台，user表示前台,seller表示商家 */
	public static final String ACCOUNT_STATUS_USER = "user";
	/** 状态， admin表示后台，user表示前台,seller表示商家 */
	public static final String ACCOUNT_STATUS_SELLER = "seller";
	/**AN开头**/
	public static final String ACCOUNT_TYPE_AN = "AN";

	/**
	 * 标识转换成String的数字
	 * 
	 * @param source
	 *            :resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户
	 * @return 用户角色标识 0.个人 1.供应商 2.商户 3.CN运营商 4.YY运营商
	 * **/
	public static String accountTypeToUserCode(String source) {
		String userCode = UserContant.USER_CODE_USER;
		if (null == source) {
			return userCode;
		}
		switch (source) {
			case UserContant.ACCOUNT_TYPE_RESOURCE:
				break;
			case UserContant.ACCOUNT_TYPE_SUPPLIER:
				userCode = UserContant.USER_CODE_B2C;
				break;
			case UserContant.ACCOUNT_TYPE_MERCHANT:
				userCode = UserContant.USER_CODE_O2O;
				break;
			case UserContant.ACCOUNT_TYPE_CN:
				userCode = UserContant.USER_CODE_CN;
				break;
			case UserContant.ACCOUNT_TYPE_YY:
				userCode = UserContant.USER_CODE_YY;
				break;
			default:
				userCode = UserContant.USER_CODE_USER;
				break;
		}
		return userCode;
	}

	/**
	 * code转source
	 * 
	 * @param source
	 *            :resource 会员端、 merchant 商户端、supplier 供应商端 、CN CN账户、YY YY账户
	 * @return 用户角色标识0.个人 1.供应商 2.商户 3.运营商
	 * **/
	public static String accountUserCodeToType(String userCode) {
		String source = "";
		if (null == userCode) {
			source = ACCOUNT_TYPE_RESOURCE;
		} else {
			switch (userCode) {
				case UserContant.USER_CODE_B2C:
					source = ACCOUNT_TYPE_SUPPLIER;
					break;
				case UserContant.USER_CODE_O2O:
					source = ACCOUNT_TYPE_MERCHANT;
					break;
				case UserContant.USER_CODE_CN:
					source = ACCOUNT_TYPE_CN;
					break;
				case UserContant.USER_CODE_YY:
					source = ACCOUNT_TYPE_YY;
					break;
				default:
					source = ACCOUNT_TYPE_RESOURCE;
					break;
			}
		}
		return source;
	}

	/**
	 * 判断是否第三方登录类型
	 * 
	 * @param type
	 * @return
	 */
	public static boolean isThirdAccountType(String type) {
		if (UserContant.ACCOUNT_TYPE_3.equals(type) || UserContant.ACCOUNT_TYPE_4.equals(type)
				|| UserContant.ACCOUNT_TYPE_5.equals(type)) {
			return true;
		}
		return false;
	}
}
