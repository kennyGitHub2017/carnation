package com.sinco.carnation.resource.web.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

public class ShareInfoResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("shareInfo")
	@ReturnMapping(desc = "app我的分享设置内容")
	private String shareInfo;

	@JsonProperty("isSaveSuccess")
	@ReturnMapping(desc = "是否保存成功")
	private boolean isSaveSuccess;

	public String getShareInfo() {
		return shareInfo;
	}

	public void setShareInfo(String shareInfo) {
		this.shareInfo = shareInfo;
	}

	public boolean isSaveSuccess() {
		return isSaveSuccess;
	}

	public void setSaveSuccess(boolean isSaveSuccess) {
		this.isSaveSuccess = isSaveSuccess;
	}

}
