package com.sinco.carnation.user.enums;

import java.util.HashMap;
import java.util.Map;

/***
 * 体检建议分类
 * 
 * @author JG-yes
 * 
 */
public enum EmPhysicalSuggestType {

	DIET(1, "饮食"),

	SPORTS(2, "运动"),

	LIFE(3, "生活"),

	MEDICAL(4, "医疗"),

	OTHER(5, "其他");

	public static Map<Integer, String> getPhysicalSuggestTypeMap() {

		Map<Integer, String> map = new HashMap<Integer, String>();

		for (EmPhysicalSuggestType em : EmPhysicalSuggestType.values()) {

			map.put(em.getCode(), em.getDesc());
		}

		return map;
	}

	private EmPhysicalSuggestType(Integer code, String desc) {
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
