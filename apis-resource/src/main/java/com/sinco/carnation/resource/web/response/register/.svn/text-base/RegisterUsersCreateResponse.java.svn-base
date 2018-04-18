package com.sinco.carnation.resource.web.response.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.Utf8mb4ToJson;

/**
 * 
 * @author dengwei
 * @date 2014年6月17日 下午9:01:26
 * 
 */
public class RegisterUsersCreateResponse extends ApiResponse implements Utf8mb4ToJson {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5528239087867058978L;

	@JsonProperty("uid")
	@ReturnMapping(desc = "用户ID")
	private Long uid;

	@JsonProperty("login_name")
	@ReturnMapping(desc = "登陆账号")
	private String loginName;

	@JsonProperty("addressbyphone")
	@ReturnMapping(desc = "手机归属地")
	private String addressbyphone;

	@JsonProperty("invitationCode")
	@ReturnMapping(desc = "邀请码")
	private String invitationCode;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getAddressbyphone() {
		return addressbyphone;
	}

	public void setAddressbyphone(String addressbyphone) {
		this.addressbyphone = addressbyphone;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

}
