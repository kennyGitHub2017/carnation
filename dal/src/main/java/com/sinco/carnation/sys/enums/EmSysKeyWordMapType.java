package com.sinco.carnation.sys.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * 关键字表的关联类型:1:体检建议 2:任务 3:帖子 4:商品 5:服务
 * 
 * @author JG-yes
 * 
 */
public enum EmSysKeyWordMapType {

	/**
	 * 体检建议
	 */
	PhysicalSuugestType(1) {
		@Override
		public String getDesc() {
			return "体检建议";
		}
	},
	/**
	 * 任务
	 */
	PhysicalTaskType(2) {
		@Override
		public String getDesc() {
			return "任务";
		}
	},
	/**
	 * 帖子
	 */
	SnsCircleType(3) {
		@Override
		public String getDesc() {
			return "帖子";
		}
	},
	/**
	 * 商品
	 */
	GoodsType(4) {
		@Override
		public String getDesc() {
			return "商品";
		}
	},
	/**
	 * 服务
	 */
	O2oServiceType(5) {
		@Override
		public String getDesc() {
			return "服务";
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

	private EmSysKeyWordMapType(int value) {
		this.value = value;
	}

	public abstract String getDesc();

	public static Map<Integer, String> GetMap(Map<Integer, String> map) {

		if (map == null) {
			map = new HashMap<Integer, String>();
		}

		for (EmSysKeyWordMapType em : EmSysKeyWordMapType.values()) {
			map.put(em.value, em.getDesc());
		}
		return map;
	}

}
