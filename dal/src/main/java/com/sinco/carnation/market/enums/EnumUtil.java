package com.sinco.carnation.market.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public class EnumUtil {

	public static final Integer NEW_ENUM_INT = -1;

	/**
	 * 默认一个Map
	 * 
	 * @param str
	 * @return
	 */
	public static Map<Integer, String> NewEnumMap(String str) {
		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(NEW_ENUM_INT, str);
		return map;
	}

}
