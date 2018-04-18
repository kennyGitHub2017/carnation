package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserStepRecord extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8416634862165779088L;

	/** id **/
	private Long id;

	/** 用户id **/
	private Long uid;

	/** 步数 **/
	private Integer stepNumber;

	/** 记录时间 **/
	private Date recordDate;

	/**  **/
	private Double totalKm;

	/**  **/
	private Long calories;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Integer getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

	public Double getTotalKm() {
		return totalKm;
	}

	public void setTotalKm(Double totalKm) {
		this.totalKm = totalKm;
	}

	public Long getCalories() {
		return calories;
	}

	public void setCalories(Long calories) {
		this.calories = calories;
	}

}