package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class BindingMobileVO extends BasicParamVO {

	@Param(desc = "手机")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
	private String mobile;

	@Param(desc = "验证码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String code;

	@Param(desc = "密码")
	private String password;

	@Param(desc = "第三方平台id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String openId;

	@Param(desc = "类型|3:QQ 4:微信5:微博")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	@Param(desc = "token")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String token;

	@Param(desc = "平台unionid")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String unionId;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
