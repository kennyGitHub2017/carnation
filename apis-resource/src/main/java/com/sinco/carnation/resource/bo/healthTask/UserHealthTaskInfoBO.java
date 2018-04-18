package com.sinco.carnation.resource.bo.healthTask;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 返回数据 用户健康任务信息
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserHealthTaskInfoBO", desc = "会员健康任务")
public class UserHealthTaskInfoBO {

	@JsonProperty("healthTaskID")
	@FieldMapping(desc = "healthTaskID")
	private Long healthTaskID;

	@JsonProperty("taskName")
	@FieldMapping(desc = "任务名称")
	private String taskName;

	@JsonProperty("doDays")
	@FieldMapping(desc = "已坚持天数")
	private Integer doDays;

	public Long getHealthTaskID() {
		return healthTaskID;
	}

	public void setHealthTaskID(Long healthTaskID) {
		this.healthTaskID = healthTaskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Integer getDoDays() {
		return doDays;
	}

	public void setDoDays(Integer doDays) {
		this.doDays = doDays;
	}

}
