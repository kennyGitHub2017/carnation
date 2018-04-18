package com.sinco.carnation.user.bo;

import com.sinco.carnation.user.model.PhysicalResult;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class PhysicalResultBO extends PhysicalResult {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3185782773192300047L;
	private String nickname;
	private Integer sex;
	private Integer age;
	private String typeName;
	private Integer resultType;
	private String memo;
	/** 范围最大值(血压，存储高压范围) **/
	private float rangeMax1;
	/** 范围最小值(血压，存储高压范围) **/
	private float rangeMin1;
	/** 范围最大值(血压，存储低压范围) **/
	private float rangeMax2;
	/** 范围最小值(血压，存储低压范围) **/
	private float rangeMin2;
	/** 范围最大值(血压，存储脉压差范围) **/
	private float rangeMax3;
	/** 范围最小值(血压，存储脉压差范围) **/
	private float rangeMin3;
	private String unit;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Integer getResultType() {
		return resultType;
	}

	public void setResultType(Integer resultType) {
		this.resultType = resultType;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public float getRangeMax1() {
		return rangeMax1;
	}

	public void setRangeMax1(float rangeMax1) {
		this.rangeMax1 = rangeMax1;
	}

	public float getRangeMin1() {
		return rangeMin1;
	}

	public void setRangeMin1(float rangeMin1) {
		this.rangeMin1 = rangeMin1;
	}

	public float getRangeMax2() {
		return rangeMax2;
	}

	public void setRangeMax2(float rangeMax2) {
		this.rangeMax2 = rangeMax2;
	}

	public float getRangeMin2() {
		return rangeMin2;
	}

	public void setRangeMin2(float rangeMin2) {
		this.rangeMin2 = rangeMin2;
	}

	public float getRangeMax3() {
		return rangeMax3;
	}

	public void setRangeMax3(float rangeMax3) {
		this.rangeMax3 = rangeMax3;
	}

	public float getRangeMin3() {
		return rangeMin3;
	}

	public void setRangeMin3(float rangeMin3) {
		this.rangeMin3 = rangeMin3;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}