package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 领取方式 0 无限 1 注册2 买后3 买前 4 随机
 * 
 */
public enum EmRepPackageGetType {
	All(0) {
		@Override
		public String getDesc() {
			return "无限";
		}
	},
	Register(1) {
		@Override
		public String getDesc() {
			return "注册";
		}
	},
	AfterBuy(2) {
		@Override
		public String getDesc() {
			return "买后";
		}
	},
	BeforeBuy(3) {
		@Override
		public String getDesc() {
			return "买前";
		}
	},
	Random(4) {
		@Override
		public String getDesc() {
			return "随机";
		}
	};

	private int value;

	private EmRepPackageGetType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRepPackageGetType em : EmRepPackageGetType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}