package com.sinco.carnation.resource.vo.favorites;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class SleepRecoredVO extends BasicParamVO {

	@Param(desc = "睡眠时长")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer sleepSecond;

	@Param(desc = "深睡时长")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer deepSleepSecond;

	public Integer getSleepSecond() {
		return sleepSecond;
	}

	public Integer getDeepSleepSecond() {
		return deepSleepSecond;
	}

	public Integer getShallowSleepSecond() {
		return shallowSleepSecond;
	}

	public void setSleepSecond(Integer sleepSecond) {
		this.sleepSecond = sleepSecond;
	}

	public void setDeepSleepSecond(Integer deepSleepSecond) {
		this.deepSleepSecond = deepSleepSecond;
	}

	public void setShallowSleepSecond(Integer shallowSleepSecond) {
		this.shallowSleepSecond = shallowSleepSecond;
	}

	@Param(desc = "浅睡时长")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer shallowSleepSecond;

}
