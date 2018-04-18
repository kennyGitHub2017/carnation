package com.sinco.carnation.user.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 体检结果说明描述
 * 
 */
public enum EmPhysicalResultType {

	/**
	 * 视力表
	 */
	RESULT_TYPE_ERE_1(1, "正常", true), RESULT_TYPE_ERE_2(2, "不正常", false),

	/**
	 * 血压
	 */
	RESULT_TYPE_BLOOD_PRESSURE_1(11, "理想血压", true), RESULT_TYPE_BLOOD_PRESSURE_2(12, "正常", true), RESULT_TYPE_BLOOD_PRESSURE_3(
			13, "低血压", false), RESULT_TYPE_BLOOD_PRESSURE_4(14, "轻度", false), RESULT_TYPE_BLOOD_PRESSURE_5(
			15, "中度", false), RESULT_TYPE_BLOOD_PRESSURE_6(16, "重度", false),

	/**
	 * 肺活量
	 */
	RESULT_TYPE_LUNG_CAPACITY_1(21, "偏低", false), RESULT_TYPE_LUNG_CAPACITY_2(22, "正常", true), RESULT_TYPE_LUNG_CAPACITY_3(
			23, "偏高", false);

	public static Map<Integer, String> getPhysicalResultTypeMap() {
		Map<Integer, String> map = new HashMap<>();
		for (EmPhysicalResultType em : EmPhysicalResultType.values()) {
			map.put(em.getCode(), em.getDesc());
		}

		return map;
	}

	public static String getPhysicalResultDesc(Integer code) {
		for (EmPhysicalResultType em : EmPhysicalResultType.values()) {
			if (em.getCode().equals(code)) {
				return em.getDesc();
			}
		}
		return null;
	}

	private EmPhysicalResultType(Integer code, String desc, boolean ishealth) {
		this.code = code;
		this.desc = desc;
		this.ishealth = ishealth;
	}

	public static Boolean getPhysicalResultStatusMap(Integer code) {
		Map<Integer, Boolean> map = new HashMap<>();
		for (EmPhysicalResultType em : EmPhysicalResultType.values()) {
			map.put(em.getCode(), em.isIshealth());
			if (em.getCode().equals(code)) {
				return em.isIshealth();
			}
		}
		return null;
	}

	private Integer code;
	private String desc;
	private Boolean ishealth;

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

	public boolean isIshealth() {
		return ishealth;
	}

	public void setIshealth(boolean ishealth) {
		this.ishealth = ishealth;
	}
}
