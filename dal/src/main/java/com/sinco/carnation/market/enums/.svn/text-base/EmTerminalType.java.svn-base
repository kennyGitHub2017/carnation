package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 终端类型 1 通用 2 App 3 Web
 * 
 */
public enum EmTerminalType {

	/**
	 * 通用
	 */
	All(1) {
		@Override
		public String getDesc() {
			return "通用";
		}
	},
	/**
	 * App
	 */
	App(2) {
		@Override
		public String getDesc() {
			return "App";
		}
	},
	/**
	 * Web
	 */
	Web(3) {
		@Override
		public String getDesc() {
			return "Web";
		}
	};

	private int value;

	private EmTerminalType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmTerminalType em : EmTerminalType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}