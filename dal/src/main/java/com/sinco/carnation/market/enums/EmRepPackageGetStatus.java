package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 领取方式 0 未拆包 1已拆包 2 已领取
 * 
 */
public enum EmRepPackageGetStatus {
	All(0) {
		@Override
		public String getDesc() {
			return "未拆包";
		}
	},
	Register(1) {
		@Override
		public String getDesc() {
			return "已拆包";
		}
	},
	AfterBuy(2) {
		@Override
		public String getDesc() {
			return "已领取";
		}
	};

	private int value;

	private EmRepPackageGetStatus(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRepPackageGetStatus em : EmRepPackageGetStatus.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}