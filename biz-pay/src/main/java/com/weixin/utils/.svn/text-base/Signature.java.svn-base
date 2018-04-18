package com.weixin.utils;

import java.util.Map;

/**
 * 
 * @author louiseliu
 * 
 */
public class Signature {

	public static String generateSign(Map<String, String> map, String key, boolean keyLower) {
		Map<String, String> orderMap = MapUtil.order(map);

		String result = MapUtil.mapJoin(orderMap, keyLower, false);
		result += "&key=" + key;
		result = MD5.MD5Encode(result).toUpperCase();

		return result;
	}

	public static String generateSign(Map<String, String> map, String key) {
		/*
		 * Map<String, String> orderMap = MapUtil.order(map);
		 * 
		 * String result = MapUtil.mapJoin(orderMap,true,false); result +=
		 * "&key=" + key; result = MD5.MD5Encode(result).toUpperCase();
		 * 
		 * return result;
		 */
		return Signature.generateSign(map, key, true);
	}

	public static String toURL(Map<String, String> map) {
		Map<String, String> orderMap = MapUtil.order(map);
		String result = MapUtil.mapJoin(orderMap, true, false);
		return result;
	}

}
