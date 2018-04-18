package com.sinco.carnation.resource.web.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;
import com.sinco.carnation.resource.bo.SysVersionControlBO;

public class VersionControlResponse extends ApiResponse implements Utf8mb4ToJson {

	private static final long serialVersionUID = 1L;

	@JsonProperty("SysVersionControlBO")
	@ReturnMapping(desc = "最新版本信息")
	private SysVersionControlBO sysVersionControlBO;

	public SysVersionControlBO getSysVersionControlBO() {
		return sysVersionControlBO;
	}

	public void setSysVersionControlBO(SysVersionControlBO sysVersionControlBO) {
		this.sysVersionControlBO = sysVersionControlBO;
	}

}
