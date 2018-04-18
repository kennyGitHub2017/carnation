package com.sinco.carnation.user.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 体检结果说明描述
 * 
 */
public enum EmPhysicalType {

	/**
	 * 视力表
	 */
	PHYSICAL_TYPE_1(1, "视力表"), PHYSICAL_TYPE_2(2, "视力检测"), PHYSICAL_TYPE_3(3, "色盲测试"), PHYSICAL_TYPE_4(4,
			"散光测试"), PHYSICAL_TYPE_5(5, "听力"), PHYSICAL_TYPE_6(6, "血压"), PHYSICAL_TYPE_7(7, "心率"), PHYSICAL_TYPE_8(
			8, "肺活量"), PHYSICAL_TYPE_9(9, "血氧");

	public static Map<Integer, String> getPhysicalResultTypeMap() {
		Map<Integer, String> map = new HashMap<>();
		for (EmPhysicalType em : EmPhysicalType.values()) {
			map.put(em.getCode(), em.getDesc());
		}

		return map;
	}

	public static String getPhysicalResultDesc(Integer code) {
		for (EmPhysicalType em : EmPhysicalType.values()) {
			if (em.getCode().equals(code)) {
				return em.getDesc();
			}
		}
		return null;
	}

	private EmPhysicalType(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	private Integer code;
	private String desc;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
