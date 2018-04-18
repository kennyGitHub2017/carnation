package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 红包类型 1-随机,2-固定(取min_money)
 * 
 */
public enum EmFixType {

	/**
	 * 随机
	 */
	Random(1) {
		@Override
		public String getDesc() {
			return "随机";
		}
	},
	/**
	 * 固定*
	 */
	Fixed(2) {
		@Override
		public String getDesc() {
			return "固定";
		}
	};

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private EmFixType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmFixType em : EmFixType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}

	public static EmFixType fromInt(int i) {
		for (EmFixType em : EmFixType.values()) {
			if (em.value == i)
				return em;
		}
		return null;
	}
}