package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ConsultingRepayVO extends BasicParamVO {
	/** 咨询id **/
	@Param(desc = "咨询提问id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long consultingId;

	/** 回复内容 **/
	@Param(desc = "回复内容")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	public Long getConsultingId() {
		return consultingId;
	}

	public void setConsultingId(Long consultingId) {
		this.consultingId = consultingId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
