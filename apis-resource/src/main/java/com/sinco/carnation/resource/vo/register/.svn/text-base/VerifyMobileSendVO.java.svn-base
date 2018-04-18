package com.sinco.carnation.resource.vo.register;

import org.hibernate.validator.constraints.NotBlank;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class VerifyMobileSendVO extends BasicParamVO {

	@Param(desc = "手机|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
