package com.sinco.carnation.resource.bo.healthTask;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/**
 * 返回数据 所有用户健康任务 author:yuleijia
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "HealthTaskBO", desc = "健康任务")
public class HealthTaskBO {

	@JsonProperty("id")
	@FieldMapping(desc = "ID")
	private Long id;

	@JsonProperty("taskName")
	@FieldMapping(desc = "任务名称")
	private String taskName;

	@JsonProperty("joinNum")
	@FieldMapping(desc = "参与人数")
	private Long joinNum;

	@JsonProperty("finishState")
	@FieldMapping(desc = "任务完成状态 | 0：未完成  1：已完成")
	private Integer finishState;

	@JsonProperty("describe")
	@FieldMapping(desc = "任务描述")
	private String describes;

	@JsonProperty("iconURL")
	@FieldMapping(desc = "图片")
	private String iconURL;

	@JsonProperty("yinDaoURL")
	@FieldMapping(desc = "引导式")
	private String yinDaoURL;

	@JsonProperty("finishTaskURL")
	@FieldMapping(desc = "健康任务完成结果访问地址")
	private String finishTaskURL;

	public String getFinishTaskURL() {
		if (finishTaskURL == null) {
			finishTaskURL = "";
		}
		return finishTaskURL;
	}

	public void setFinishTaskURL(String finishTaskURL) {
		this.finishTaskURL = finishTaskURL;
	}

	public String getYinDaoURL() {
		return yinDaoURL;
	}

	public void setYinDaoURL(String yinDaoURL) {
		this.yinDaoURL = yinDaoURL;
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

	public Integer getFinishState() {
		return finishState;
	}

	public void setFinishState(Integer finishState) {
		this.finishState = finishState;
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

}
