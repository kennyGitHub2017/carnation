package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class TipsVO extends BasicParamVO {

	/** 举报对象 **/
	@Param(desc = "举报对象 id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long targetId;

	/** 举报类型 **/
	@Param(desc = "举报名称")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String tipsType;

	@Param(desc = "举报类型|0帖子1资讯")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public Long getTargetId() {
		return targetId;
	}

	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public String getTipsType() {
		return tipsType;
	}

	public void setTipsType(String tipsType) {
		this.tipsType = tipsType;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
