package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户信息 1 手机号 2 邀请码 3 昵称
 * 
 */
public enum EmRepPackageGetUserMation {

	/**
	 * 手机号
	 */
	Phone(1) {
		@Override
		public String getDesc() {
			return "手机号";
		}
	},
	/**
	 * 邀请码
	 */
	InvitationCode(2) {
		@Override
		public String getDesc() {
			return "邀请码";
		}
	},
	/**
	 * 昵称
	 */
	NickName(3) {
		@Override
		public String getDesc() {
			return "昵称";
		}
	};

	private int value;

	private EmRepPackageGetUserMation(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmRepPackageGetUserMation em : EmRepPackageGetUserMation.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}