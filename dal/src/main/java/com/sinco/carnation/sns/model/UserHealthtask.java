package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.util.Date;

/**
 * 用户健康任务 author:yuleijiao
 */
public class UserHealthtask extends BaseModel {

	private static final long serialVersionUID = 1482375878459350474L;

	/**  **/
	private Long id;

	/** 任务名 **/
	private String taskName;

	/** 参加人数 **/
	private Long joinNum;

	/** 创建人 **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long isDeleted;
	/**
	 * 描述
	 */
	private String describes;
	/**
	 * 图片地址
	 */
	private String iconURL;
	/**
	 * 任务类型:0:系统 1:用户
	 */
	private int taskType;
	/**
	 * 签到类型：1：签到式 2：引导式
	 */
	private int signType;
	/**
	 * 引导式健康任务访问地址
	 */
	private String taskURL;

	public String getTaskURL() {
		return taskURL;
	}

	public void setTaskURL(String taskURL) {
		this.taskURL = taskURL;
	}

	public int getSignType() {
		return signType;
	}

	public void setSignType(int signType) {
		this.signType = signType;
	}

	public int getTaskType() {
		return taskType;
	}

	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public String getDescribes() {
		return describes;
	}

	public void setDescribes(String describe) {
		this.describes = describe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Long getJoinNum() {
		return joinNum;
	}

	public void setJoinNum(Long joinNum) {
		this.joinNum = joinNum;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
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

	public Long getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Long isDeleted) {
		this.isDeleted = isDeleted;
	}
}