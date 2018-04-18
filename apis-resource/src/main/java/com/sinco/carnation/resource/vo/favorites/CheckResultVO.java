package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CheckResultVO extends BasicParamVO {

	@Param(desc = "自测套题id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long groupId;

	@Param(desc = "自测套题结果得分")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer resultScore;

	public Integer getResultScore() {
		return resultScore;
	}

	public void setResultScore(Integer resultScore) {
		this.resultScore = resultScore;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

}
