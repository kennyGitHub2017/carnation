package cn.eeepay;

import java.util.Map;

import com.google.common.collect.Maps;

public class EeePayConstants {
	/**
	 * 客户端类型，移联商通
	 */
	public static final String APP_TYPE_6 = "6";

	/**
	 * 客户端类型，超级刷
	 */
	public static final String APP_TYPE_24 = "24";

	/**
	 * 机具类型，移联商通
	 */
	public static final String POS_TYPE_4 = "4";

	/**
	 * 机具类型，超级刷
	 */
	public static final String POS_TYPE_5 = "5";

	public static String getAppTypeName(String appType) {
		switch (appType) {
			case APP_TYPE_6:
				return "移联商通";
			case APP_TYPE_24:
				return "超级刷";
			default:
				return "未知类型";
		}
	}

	public static Map<String, String> getAppTypes() {
		Map<String, String> result = Maps.newHashMap();
		result.put(APP_TYPE_6, "移联商通");
		result.put(APP_TYPE_24, "超级刷");
		return result;
	}

	public static String getPosTypeName(String posType) {
		switch (posType) {
			case POS_TYPE_4:
				return "移联商通";
			case POS_TYPE_5:
				return "超级刷";
			default:
				return "未知类型";
		}
	}
}
