package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserHealthtaskSignlog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9223050726017082251L;

	/**  **/
	private Long id;

	/**  **/
	private Long userId;

	/**  **/
	private Long userHealthtaskId;

	/**  **/
	private Date signTime;

	/**  **/
	private Long isDeleted;

	private Long signWeek;

	private String days;

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public Long getSignWeek() {
		return signWeek;
	}

	public void setSignWeek(Long signWeek) {
		this.signWeek = signWeek;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUserHealthtaskId() {
		return userHealthtaskId;
	}

	public void setUserHealthtaskId(Long userHealthtaskId) {
		this.userHealthtaskId = userHealthtaskId;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}
}