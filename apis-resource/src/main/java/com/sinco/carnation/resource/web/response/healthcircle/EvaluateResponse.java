package com.sinco.carnation.resource.web.response.healthcircle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.healthcircle.PostEvaluateBO;

@SuppressWarnings("serial")
public class EvaluateResponse extends ApiResponse {
	@JsonProperty("evalBO")
	@ReturnMapping(desc = "评论对象")
	private PostEvaluateBO evalBO;

	@JsonProperty("result")
	@ReturnMapping(desc = "评论回复结果=1成功")
	private Integer result;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	public PostEvaluateBO getEvalBO() {
		return evalBO;
	}

	public void setEvalBO(PostEvaluateBO evalBO) {
		this.evalBO = evalBO;
	}

}
