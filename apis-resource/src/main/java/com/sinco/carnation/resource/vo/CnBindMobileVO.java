package com.sinco.carnation.resource.vo;

import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * CN账号登录
 * 
 * @author Administrator
 * 
 */
public class CnBindMobileVO extends BasicParamVO {
	@Param(desc = "手机")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(17([0-9]))|(18[0-9]))\\d{8}$")
	private String mobile;

	@Param(desc = "验证码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String code;

	@Param(desc = "CN账号")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String cn_username;

	@Param(desc = "CN密码")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCn_username() {
		return cn_username;
	}

	public void setCn_username(String cn_username) {
		this.cn_username = cn_username;
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

}
