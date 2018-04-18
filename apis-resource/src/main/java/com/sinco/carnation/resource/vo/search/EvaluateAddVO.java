package com.sinco.carnation.resource.vo.search;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class EvaluateAddVO extends BasicParamVO {

	@Param(desc = "评论id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long evalId;

	@Param(desc = "追加评论内容")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String evaluateInfo;

	@Param(desc = "图片地址")
	private String imgPath;

	public Long getEvalId() {
		return evalId;
	}

	public String getEvaluateInfo() {
		return evaluateInfo;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setEvalId(Long evalId) {
		this.evalId = evalId;
	}

	public void setEvaluateInfo(String evaluateInfo) {
		this.evaluateInfo = evaluateInfo;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
}
