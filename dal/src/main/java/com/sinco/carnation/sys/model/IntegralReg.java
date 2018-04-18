package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class IntegralReg extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3909352678458976410L;

	/** 主键ID **/
	private Long id;

	/** 删除状态（0：未删除 1：已删除） **/
	private Boolean deleteStatus;

	/** 积分名称 **/
	private String name;

	/** 积分标识 **/
	private String type;

	/** 积分赠送次数限制类型（1：无次数限制 2：总次数限制 3：日次数限制） **/
	private Integer timesLimitType;

	/** 赠送次数限制 **/
	private Integer times;

	/** 积分数 **/
	private Integer integral;

	/** 连续签到积分值（七个，以逗号隔开） **/
	private String signIntegral;

	/** 添加时间 **/
	private Date addTime;

	/** 是否有效（0：否 1：是） **/
	private Boolean display;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getSignIntegral() {
		return signIntegral;
	}

	public void setSignIntegral(String signIntegral) {
		this.signIntegral = signIntegral;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDisplay() {
		return display;
	}

	public void setDisplay(Boolean display) {
		this.display = display;
	}

	public Integer getTimesLimitType() {
		return timesLimitType;
	}

	public void setTimesLimitType(Integer timesLimitType) {
		this.timesLimitType = timesLimitType;
	}
}