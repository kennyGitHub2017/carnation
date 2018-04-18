package com.sinco.carnation.resource.vo.healthcircle;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class LabelAddVO extends BasicParamVO {
	@Param(desc = "标签名称")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String labelName;

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

}
