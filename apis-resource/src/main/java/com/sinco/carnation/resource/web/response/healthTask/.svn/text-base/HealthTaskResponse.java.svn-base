package com.sinco.carnation.resource.web.response.healthTask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.healthTask.HealthTaskBO;

/**
 * 健康任务 Response
 * 
 * @author yuleijia
 */
public class HealthTaskResponse extends ApiResponse {

	private static final long serialVersionUID = 759153680623406057L;

	@JsonProperty("healthTaskBOList")
	@ReturnMapping(desc = "所有健康任务")
	private List<HealthTaskBO> healthTaskBOList;

	public List<HealthTaskBO> getHealthTaskBOList() {
		return healthTaskBOList;
	}

	public void setHealthTaskBOList(List<HealthTaskBO> healthTaskBOList) {
		this.healthTaskBOList = healthTaskBOList;
	}

}
