package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class QueryCircleInvitationVO extends BasicPageParamVo {

	@Param(desc = "收藏类型 1帖子2医生")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String type;

	@Param(desc = "帖子类型1用户2官方")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer circleType;

	@Param(desc = "最后一条记录的时间")
	private Long times;

	public Integer getCircleType() {
		return circleType;
	}

	public void setCircleType(Integer circleType) {
		this.circleType = circleType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getTimes() {
		return times;
	}

	public void setTimes(Long times) {
		this.times = times;
	}

}
