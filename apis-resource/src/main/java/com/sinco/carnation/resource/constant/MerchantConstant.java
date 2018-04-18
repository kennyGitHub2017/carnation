package com.sinco.carnation.resource.constant;
/**
 * 商户APP常量类
 * @author yuleijia
 *
 */
public class MerchantConstant {

	/**
	 * 默认状态
	 */
	public final static int DEFAULT_STATE = 10;
	/**
	 * 新会员
	 */
	public final static int NEW_ACCOUNT_STATE = 100;
	/**
	 * 是会员但没绑定手机号
	 */
	public final static int ACCOUNT_NOT_BOUND_MOBILE_STATE = 200;
	/**
	 * 是会员绑定手机号且是商户
	 */
	public final static int ACCOUNT_BOUND_MOBILE_MERCHANT = 300;
	/**
	 * 是会员绑定手机号且不是商户未入驻
	 */
	public final static int ACCOUNT_BOUND_MOBILE_NOT_MERCHANT = 310;
	/**
	 * 待审核中
	 */
	public final static int AUDIT_STATUS_WAITFOR = 340;
	/**
	 * 审核失败
	 */
	public final static int AUDIT_STATUS_FAILE = 350;
	/**
	 * 用户为CN账号
	 */
	public final static int ACCOUNT_IS_CN = 330;
	/**
	 * 成功 
	 */
	public final static int SUCCESS = 200;
	/**
	 * 失败
	 */
	public final static int ERROR = 500;
	
	
}
