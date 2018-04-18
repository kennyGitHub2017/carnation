package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 限领用户条件 0 无条件 1 新会员 2 老会员（无消费）3 老会员（有消费）
 * 
 */
public enum EmRepPackageUserType {
	All(0) {
		@Override
		public String getDesc() {
			return "无条件";
		}
	},

	NewMember(1) {
		@Override
		public String getDesc() {
			return "新会员";
		}
	},
	MemberWithoutOrder(2) {
		@Override
		public String getDesc() {
			return "老会员（无消费）";
		}
	},
	MemberWithOrder(3) {
		@Override
		public String getDesc() {
			return "老会员（有消费）";
		}
	};

	private int value;

	private EmRepPackageUserType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRepPackageUserType em : EmRepPackageUserType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}