package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class UserSleepRecord extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5257650838243810504L;

	/** id **/
	private Long id;

	/** 用户id **/
	private Long uid;

	/** 睡眠时长 **/
	private Integer sleepSecond;

	/** 深睡时长 **/
	private Integer deepSleepSecond;

	/** 浅睡时长 **/
	private Integer shallowSleepSecond;

	/** 记录时间 **/
	private Date recordDate;

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

	public Integer getSleepSecond() {
		return sleepSecond;
	}

	public Integer getDeepSleepSecond() {
		return deepSleepSecond;
	}

	public Integer getShallowSleepSecond() {
		return shallowSleepSecond;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setSleepSecond(Integer sleepSecond) {
		this.sleepSecond = sleepSecond;
	}

	public void setDeepSleepSecond(Integer deepSleepSecond) {
		this.deepSleepSecond = deepSleepSecond;
	}

	public void setShallowSleepSecond(Integer shallowSleepSecond) {
		this.shallowSleepSecond = shallowSleepSecond;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

}