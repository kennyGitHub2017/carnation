package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息发送状态 0-未发送,1-已发送
 * 
 */
public enum EmSendStatus {

	/**
	 * 0-未发送
	 */
	NoSend(0) {
		@Override
		public String getDesc() {
			return "未发送";
		}
	},
	/**
	 * 已发送
	 */
	Send(1) {
		@Override
		public String getDesc() {
			return "已发送";
		}
	};

	private int value;

	private EmSendStatus(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmSendStatus em : EmSendStatus.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}