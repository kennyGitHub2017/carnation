package com.sinco.carnation.resource.vo.message;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class MessageVO extends BasicPageParamVo {

	/*	@Param(desc = "短信状态 0未读1已读")
	    private String status;*/

	@Param(desc = "短信类型 0系统短信 1用户短信")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
