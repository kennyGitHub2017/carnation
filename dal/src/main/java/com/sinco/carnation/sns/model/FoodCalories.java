package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class FoodCalories extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -867118728820845392L;

	/**  **/
	private Long id;

	/** 食物名称 **/
	private String name;

	/** 热量，单位为100克 **/
	private Integer calories;

	/** 食物类别id **/
	private Long classId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}