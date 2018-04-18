package com.sinco.carnation.resource.web.response.healthTask;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.healthTask.UserHealthTaskInfoBO;

public class UserHealthTaskInfoResponse extends ApiResponse {

	private static final long serialVersionUID = 2696967961843564477L;

	@JsonProperty("userHealthTaskBOs")
	@ReturnMapping(desc = "用户健康任务")
	private List<UserHealthTaskInfoBO> userHealthTaskInfoList;

	public List<UserHealthTaskInfoBO> getUserHealthTaskInfoList() {
		return userHealthTaskInfoList;
	}

	public void setUserHealthTaskInfoList(List<UserHealthTaskInfoBO> userHealthTaskInfoList) {
		this.userHealthTaskInfoList = userHealthTaskInfoList;
	}

}
