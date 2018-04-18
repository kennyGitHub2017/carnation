package com.sinco.carnation.sys.model;

import java.util.Date;

import com.sinco.dal.common.persistence.mybatis.CreateTimeModel;

public class SysReminderTask extends CreateTimeModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8756996796592224705L;

	/**  **/
	private Long id;

	/** 任务名称 **/
	private String taskName;

	/** 任务类型，1表示改进建议 **/
	private Integer taskType;

	/** 是否推荐 1：是 0：否 **/
	private Integer isTop;

	/** 任务状态,是否启用 1：是 0：否 **/
	private Integer isEnabled;

	/** 默认周期 用逗号隔开 0:星期天，1:星期一，... **/
	private String defaultDay;

	/** 默认时间 **/
	private Date defaultTime;

	/** 权重 **/
	private Integer priority;

	/** 删除状态 0 正常数据(默认值),1 删除状态 **/
	private Byte deleteStatus;

	/**  **/
	private Long createBy;

	/**  **/
	private Long modifyBy;

	/** 任务内容 **/
	private String content;

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

	public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public Integer getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getDefaultDay() {
		return defaultDay;
	}

	public void setDefaultDay(String defaultDay) {
		this.defaultDay = defaultDay;
	}

	public Date getDefaultTime() {
		return defaultTime;
	}

	public void setDefaultTime(Date defaultTime) {
		this.defaultTime = defaultTime;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(Long modifyBy) {
		this.modifyBy = modifyBy;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}