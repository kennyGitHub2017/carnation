package com.sinco.carnation.market.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动位置 0 无 1登录前 2 登录后3 活动页面 4 首页 5 购物车 6 付款后(逗号拆分)
 * 
 */
public enum EmActPosition {

	/**
	 * 无
	 */
	None(0) {
		@Override
		public String getDesc() {
			return "无";
		}
	},
	/**
	 * 登录前
	 */
	BeforeLogin(1) {
		@Override
		public String getDesc() {
			return "登录前";
		}
	},
	/**
	 * 登录后
	 */
	AfterLogin(2) {
		@Override
		public String getDesc() {
			return "登录后";
		}
	},
	/**
	 * 活动页面
	 */
	ActPage(3) {
		@Override
		public String getDesc() {
			return "活动页面";
		}
	},
	/**
	 * 首页
	 */
	IndexPage(4) {
		@Override
		public String getDesc() {
			return "首页";
		}
	},
	/**
	 * 购物车
	 */
	BullerCart(5) {
		@Override
		public String getDesc() {
			return "购物车";
		}
	},
	/**
	 * 付款后
	 */
	AfterPaid(6) {
		@Override
		public String getDesc() {
			return "付款后";
		}
	};

	private int value;

	private EmActPosition(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmActPosition em : EmActPosition.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}
}