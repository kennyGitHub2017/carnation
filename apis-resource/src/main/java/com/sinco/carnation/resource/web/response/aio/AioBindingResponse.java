package com.sinco.carnation.resource.web.response.aio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class AioBindingResponse extends BaseJsonResult {

	@JsonProperty("result")
	@ReturnMapping(desc = "是否已绑定")
	private boolean result;

	@JsonProperty("updateNum")
	@ReturnMapping(desc = "更新次数")
	private int updateNum;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public int getUpdateNum() {
		return updateNum;
	}

	public void setUpdateNum(int updateNum) {
		this.updateNum = updateNum;
	}

}
