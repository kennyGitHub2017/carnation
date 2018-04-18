package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class FeedBackVO extends BasicParamVO {

	@Param(desc = "来源n1：IOS个人端APP 2：IOS商户端APP 3：IOS运营商APP 4：安卓个人端APP 5：安卓商户端APP 6：安卓运营商APP")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer source;

	@Param(desc = "反馈内容")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String content;

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
