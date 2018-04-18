package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "FoodClass", desc = "食物类型")
public class FoodClassBO {

	/**  **/
	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Integer id;

	/**  **/
	@JsonProperty("name")
	@FieldMapping(desc = "食物名称")
	private String name;

	/** 热量，单位为100克 **/
	@JsonProperty("calories")
	@FieldMapping(desc = "热量，单位为100克")
	private Integer calories;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
}
