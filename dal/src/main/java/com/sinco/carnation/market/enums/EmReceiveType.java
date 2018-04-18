package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 接受类型 1-只读,2-链接,3-富文本
 * 
 */
public enum EmReceiveType {

	/**
	 * 1-只读
	 */
	ReadOnly(1) {
		@Override
		public String getDesc() {
			return "只读";
		}
	},
	/**
	 * 链接
	 */
	Link(2) {
		@Override
		public String getDesc() {
			return "链接";
		}
	},
	/**
	 * 富文本
	 */
	Html(3) {
		@Override
		public String getDesc() {
			return "富文本";
		}
	};

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private EmReceiveType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmReceiveType em : EmReceiveType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}