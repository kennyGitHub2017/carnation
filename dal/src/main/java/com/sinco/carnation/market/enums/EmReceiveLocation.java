package com.sinco.carnation.market.enums;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 活动位置 0 无 1登录前 2 登录后3 活动页面 4 首页 5 购物车 6 付款后(逗号拆分)
 * 
 */
public enum EmReceiveLocation {

	/**
	 * 2^0:云尚APP
	 */
	YesApp(1) {
		@Override
		public String getDesc() {
			return "云尚APP";
		}
	};
//	,
//	/**
//	 * 云e店APP
//	 */
//	YesMerchantApp(2) {
//		@Override
//		public String getDesc() {
//			return "云e店APP";
//		}
//	},
//	/**
//	 * 云e商APP
//	 */
//	YesOperatorApp(4) {
//		@Override
//		public String getDesc() {
//			return "云e商APP";
//		}
//	},
//	/**
//	 * pc商家管理中心
//	 */
//	YesMerchantPc(8) {
//		@Override
//		public String getDesc() {
//			return "pc商家管理中心";
//		}
//	},
//	/**
//	 * pc商户管理中心
//	 */
//	YesMerchantO2OPc(16) {
//		@Override
//		public String getDesc() {
//			return "pc商户管理中心";
//		}
//	},
//	/**
//	 * pc运营商
//	 */
//	YesOperatorPc(32) {
//		@Override
//		public String getDesc() {
//			return "pc运营商";
//		}
//	},
//	/**
//	 * pc会员个人中心
//	 */
//	YesMemberPc(64) {
//		@Override
//		public String getDesc() {
//			return "pc会员个人中心";
//		}
//	};

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private EmReceiveLocation(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new LinkedHashMap<Integer, String>();
		}

		for (EmReceiveLocation em : EmReceiveLocation.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}