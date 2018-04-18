package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ComplaintHandlerVO extends BasicParamVO {

	@Param(desc = "id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long id;

	@Param(desc = "处理结果")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String result;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
