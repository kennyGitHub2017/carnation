package com.sinco.carnation.resource.bo.healthTask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "TodayHealthTaskBO", desc = "今日健康任务")
public class TodayHealthTaskBO {

	@JsonProperty("healthTaskList")
	@FieldMapping(desc = "健康任务")
	private List<HealthTaskBO> healthTaskList;

	@JsonProperty("result")
	@FieldMapping(desc = "返回结果编码")
	private Integer result;

	@JsonProperty("content")
	@FieldMapping(desc = "返回结果内容")
	private String content;

	@JsonProperty("iconURL")
	@FieldMapping(desc = "图片地址")
	private String iconURL;

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public List<HealthTaskBO> getHealthTaskList() {
		return healthTaskList;
	}

	public void setHealthTaskList(List<HealthTaskBO> healthTaskList) {
		this.healthTaskList = healthTaskList;
	}

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
