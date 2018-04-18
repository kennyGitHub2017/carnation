package com.sinco.carnation.sys.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册类型 1-pc注册，2-h5注册,3-app注册
 * 
 */
public enum EmRegisterFromType {

	/**
	 * 电脑端
	 */
	Pc(1) {
		@Override
		public String getDesc() {
			return "电脑端";
		}
	},
	/**
	 * H5
	 */
	H5(2) {
		@Override
		public String getDesc() {
			return "网页前端";
		}
	},
	/**
	 * APP
	 */
	APP(3) {
		@Override
		public String getDesc() {
			return "APP";
		}
	},
	;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private int value;

	private EmRegisterFromType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRegisterFromType em : EmRegisterFromType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}