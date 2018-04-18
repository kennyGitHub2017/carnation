package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserHealthtaskSet extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5058974983322457066L;

	/**  **/
	private Long id;

	/**  **/
	private Long userHealthtaskId;

	/**  **/
	private String remindTime;

	/**  **/
	private String remindWeek;

	/**  **/
	private Long userId;

	/**  **/
	private Long isDeleted;

	/**  **/
	private Date createTime;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long mon;

	/**  **/
	private Long tue;

	/**  **/
	private Long wed;

	/**  **/
	private Long thu;

	/**  **/
	private Long fri;

	/**  **/
	private Long sat;

	/**  **/
	private Long sun;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserHealthtaskId() {
		return userHealthtaskId;
	}

	public void setUserHealthtaskId(Long userHealthtaskId) {
		this.userHealthtaskId = userHealthtaskId;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public String getRemindWeek() {
		return remindWeek;
	}

	public void setRemindWeek(String remindWeek) {
		this.remindWeek = remindWeek;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getMon() {
		return mon;
	}

	public void setMon(Long mon) {
		this.mon = mon;
	}

	public Long getTue() {
		return tue;
	}

	public void setTue(Long tue) {
		this.tue = tue;
	}

	public Long getWed() {
		return wed;
	}

	public void setWed(Long wed) {
		this.wed = wed;
	}

	public Long getThu() {
		return thu;
	}

	public void setThu(Long thu) {
		this.thu = thu;
	}

	public Long getFri() {
		return fri;
	}

	public void setFri(Long fri) {
		this.fri = fri;
	}

	public Long getSat() {
		return sat;
	}

	public void setSat(Long sat) {
		this.sat = sat;
	}

	public Long getSun() {
		return sun;
	}

	public void setSun(Long sun) {
		this.sun = sun;
	}
}