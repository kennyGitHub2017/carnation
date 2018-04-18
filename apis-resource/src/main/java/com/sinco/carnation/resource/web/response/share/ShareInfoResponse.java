package com.sinco.carnation.resource.web.response.share;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 * 分享Response
 * 
 * @author yuleijia
 * 
 */
public class ShareInfoResponse extends ApiResponse {

	private static final long serialVersionUID = -3731327567586065669L;

	@JsonProperty("shareReqURL")
	@ReturnMapping(desc = "分享资源访问地址")
	private String shareReqURL;

	public String getShareReqURL() {
		return shareReqURL;
	}

	public void setShareReqURL(String shareReqURL) {
		this.shareReqURL = shareReqURL;
	}

}
