package com.sinco.carnation.resource.web.response.chunyu;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class AccountSynResponse extends ApiResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5784022429959582134L;
	@JsonProperty("userId")
	@ReturnMapping(desc = "用户ID")
	private Long userId;
	@JsonProperty("partner")
	@ReturnMapping(desc = "合作方")
	private String partner;
	@JsonProperty("sign")
	@ReturnMapping(desc = "签名字串")
	private String sign;
	@JsonProperty("atime")
	@ReturnMapping(desc = "时间戳")
	private Long atime;
	@JsonProperty("url")
	@ReturnMapping(desc = "登陆链接")
	private String url;
	@JsonProperty("sessionid")
	@ReturnMapping(desc = "登陆会话")
	private String sessionid;
	@JsonProperty("signUrl")
	@ReturnMapping(desc = "签名URL")
	private String signUrl;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public Long getAtime() {
		return atime;
	}
	public void setAtime(Long atime) {
		this.atime = atime;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getSignUrl() {
		return signUrl;
	}
	public void setSignUrl(String signUrl) {
		this.signUrl = signUrl;
	}
	
}
