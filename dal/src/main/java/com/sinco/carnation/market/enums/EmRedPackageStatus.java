package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 红包类型 1-未开始,2-进行中 ,3-已结束
 * 
 */
public enum EmRedPackageStatus {

	/**
	 * 未开始
	 */
	UnStart(1) {
		@Override
		public String getDesc() {
			return "未开始";
		}
	},
	/**
	 * 进行中
	 */
	Doing(2) {
		@Override
		public String getDesc() {
			return "进行中";
		}
	},
	/**
	 * 已结束
	 */
	End(3) {
		@Override
		public String getDesc() {
			return "已结束";
		}
	},

	/**
	 * 停用
	 */
	Disables(4) {
		@Override
		public String getDesc() {
			return "停用";
		}
	},
	/**
	 * 启用
	 */
	Unlock(5) {
		@Override
		public String getDesc() {
			return "启用";
		}
	};

	private int value;

	public int GetValue() {
		return this.value;
	}

	private EmRedPackageStatus(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRedPackageStatus em : EmRedPackageStatus.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}

}