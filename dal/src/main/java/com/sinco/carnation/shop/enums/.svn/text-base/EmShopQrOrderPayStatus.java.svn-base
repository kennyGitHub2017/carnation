package com.sinco.carnation.shop.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动位置 0 无 1登录前 2 登录后3 活动页面 4 首页 5 购物车 6 付款后(逗号拆分)
 * 
 */
public enum EmShopQrOrderPayStatus {

	/**
	 * 无
	 */
	NoPay(0) {
		@Override
		public String getDesc() {
			return "无";
		}
	},
	/**
	 * 登录前
	 */
	PaySuccess(1) {
		@Override
		public String getDesc() {
			return "登录前";
		}
	},
	/**
	 * 登录后
	 */
	PayFail(2) {
		@Override
		public String getDesc() {
			return "登录后";
		}
	};

	private int value;

	private EmShopQrOrderPayStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> getMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmShopQrOrderPayStatus em : EmShopQrOrderPayStatus.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}