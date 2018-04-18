package com.sinco.carnation.resource.web.response.healthTask;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 * 签到界面Response类
 */
public class UserHealthTaskRelationResponse extends ApiResponse {

	private static final long serialVersionUID = 7781762803306123868L;

	@JsonProperty("id")
	@ReturnMapping(desc = "ID")
	private Long id;

	@JsonProperty("taskID")
	@ReturnMapping(desc = "任务ID")
	private Long taskID;

	@JsonProperty("taskName")
	@ReturnMapping(desc = "任务名称")
	private String taskName;

	@JsonProperty("doDays")
	@ReturnMapping(desc = "坚持天数")
	private Long doDays;

	@JsonProperty("weeks")
	@ReturnMapping(desc = "任务坚持周期")
	private String weeks;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskID() {
		return taskID;
	}

	public void setTaskID(Long taskID) {
		this.taskID = taskID;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Long getDoDays() {
		return doDays;
	}

	public void setDoDays(Long doDays) {
		this.doDays = doDays;
	}

	public String getWeeks() {
		return weeks;
	}

	public void setWeeks(String weeks) {
		this.weeks = weeks;
	}

}
