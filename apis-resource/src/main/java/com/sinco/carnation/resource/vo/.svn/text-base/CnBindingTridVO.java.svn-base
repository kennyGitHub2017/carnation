package com.sinco.carnation.resource.vo;

import org.hibernate.validator.constraints.NotBlank;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CnBindingTridVO extends BasicParamVO {
	@Param(desc = "第三方平台微信的unionID")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String unionID;

	@Param(desc = "手机号")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	public String getUnionID() {
		return unionID;
	}

	public void setUnionID(String unionID) {
		this.unionID = unionID;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
