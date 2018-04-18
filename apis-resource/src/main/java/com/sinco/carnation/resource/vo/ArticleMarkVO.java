package com.sinco.carnation.resource.vo;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ArticleMarkVO extends BasicPageParamVo {

	@Param(desc = "标识|gonggao 公告 ")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mark;

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
