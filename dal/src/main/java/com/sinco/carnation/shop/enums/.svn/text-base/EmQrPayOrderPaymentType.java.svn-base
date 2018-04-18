package com.sinco.carnation.shop.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付方式 1-微信支付 2-支付宝 0-云豆
 * 
 */
public enum EmQrPayOrderPaymentType {
	JGPay(0) {
		@Override
		public String getDesc() {
			return "云尚";
		}
	},
	WX(1) {
		@Override
		public String getDesc() {
			return "微信";
		}
	},
	AliPay(2) {
		@Override
		public String getDesc() {
			return "支付宝";
		}
	};

	private int value;

	private EmQrPayOrderPaymentType(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> getMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmQrPayOrderPaymentType em : EmQrPayOrderPaymentType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}

}