package com.sinco.carnation.store.constants;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 商铺相关的常量
 * 
 * @author Ｇrey
 * 
 */
public class StoreConstants {
	// 店铺状态
	public static Map<Integer, String> map = new LinkedHashMap<Integer, String>();
	// 商户状态
	public static Map<Integer, String> metchantMap = new LinkedHashMap<Integer, String>();

	static {
		if (map == null || map.size() <= 0) {
			map.put(0, "提交开店申请");
			map.put(1, "运营商审批");
			map.put(2, "运营商审批失败");
			map.put(5, "平台审核");
			map.put(6, "平台审核失败");
			// map.put(10, "第三方支付审核");
			// map.put(11, "第三方支付审批失败");
			map.put(15, "正常营业（审核成功）");
			map.put(20, "违规关闭");
			map.put(25, "到期关闭");
			map.put(26, "到期后申请续费");
		}

		if (metchantMap == null || metchantMap.size() <= 0) {
			metchantMap.put(1, "运营商待审");
			metchantMap.put(2, "运营商审批失败");
			metchantMap.put(5, "平台待审");
			metchantMap.put(6, "平台审核失败");
			metchantMap.put(15, "正常营业");
			metchantMap.put(20, "违规关闭");
		}
	}

	/** 店铺状态，0为提交开店申请 **/
	public static final Integer STORE_STATUS_SHOP_NO_APPLICATION = 0;
	/** 店铺状态，1运营商审批 **/
	public static final Integer STORE_STATUS_SHOP_OPREATE_AUDIT = 1;
	/** 店铺状态，2运营商审批失败 **/
	public static final Integer STORE_STATUS_SHOP_OPREATE_AUDIT_FAIL = 2;
	/** 店铺状态，5 平台审核 **/
	public static final Integer STORE_STATUS_SYS_AUDIT = 5;
	/** 店铺状态，6平台审核失败 **/
	public static final Integer STORE_STATUS_SYS_AUDIT_FAIL = 6;
	/** 店铺状态，10 第三方支付审核 **/
	public static final Integer STORE_STATUS_OTHER_PAY_AUDIT = 10;
	/** 店铺状态，11 第三方支付审批失败 **/
	public static final Integer STORE_STATUS_OTHER_PAY_AUDIT_FAIL = 11;
	/** 店铺状态，15为正常营业（审核成功） **/
	public static final Integer STORE_STATUS_SHOP_AUDIT_SUCCESS = 15;
	/** 店铺状态，20违规关闭 **/
	public static final Integer STORE_STATUS_SHOP_INFRACTION_CLOSE = 20;
	/** 店铺状态，25到期关闭 **/
	public static final Integer STORE_STATUS_SHOP_EXPIRE_CLOSE = 25;
	/** 店铺状态，26,到期后申请续费 **/
	public static final Integer STORE_STATUS_SHOP_EXPIRE_RENEWAL = 26;

	/** 商家付款成功短信提醒模板 **/
	public static final String SMS_TOSELLER_ONLINE_SHIPMENTS_NOTIFY = "sms_toseller_online_shipments_notify";
	/** 商户审核通过提醒模板 **/
	public static final String SMS_MERCHANTS_APPROVED = "sms_merchants_approved";
	/** 商户审核不通过提醒模板 **/
	public static final String SMS_MERCHANTS_NOT_APPROVED = "sms_merchants_not_approved";
	/** 供应商审核通过提醒模板 **/
	public static final String SMS_STORE_APPROVED = "sms_store_approved";
	/** 供应商审核不通过提醒模板 **/
	public static final String SMS_STORE_NOT_APPROVED = "sms_store_not_approved";

	/** 审核类型 merchants 商户审核，stroe 供应商审核 **/
	public static final String AUDIT_TYPE_MERCHANTS = "merchants";
	/** 审核类型 merchants 商户审核，stroe 供应商审核 **/
	public static final String AUDIT_TYPE_STORE = "store";

	/**
	 * 获取状态Map
	 * 
	 * @param status
	 * @return
	 */
	public static Map<Integer, String> getStoreStatusMap() {
		return map;
	}

	/**
	 * 获取状态Map
	 * 
	 * @param status
	 * @return
	 */
	public static Map<Integer, String> getMerchantStatusMap() {
		return metchantMap;
	}

	/**
	 * 根据店铺状态获取店铺状态值
	 * 
	 * @param status
	 * @return
	 */
	public static String getStoreStatusValue(Integer status) {
		return map.get(status);
	}

	/**
	 * 根据商户状态获取商户状态值
	 * 
	 * @param status
	 * @return
	 */
	public static String getMerchantStatusValue(Integer status) {
		return metchantMap.get(status);
	}

	/** 店铺主营限制，0-不限制 **/
	public static final Integer STORE_MAIN_CLASS_NO_LIMIT = new Integer(0);
	/** 店铺主营限制，1-限制 **/
	public static final Integer STORE_MAIN_CLASS_LIMIT = new Integer(1);

}
