package com.sinco.carnation.resource.vo.aio;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class AioBindingVO extends BasicPageParamVo {
	@Param(desc = "验证码")
	private String code;

	@Param(desc = "手机号")
	private String mobile;

	@Param(desc = "身份证号码")
	private String idCard;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}