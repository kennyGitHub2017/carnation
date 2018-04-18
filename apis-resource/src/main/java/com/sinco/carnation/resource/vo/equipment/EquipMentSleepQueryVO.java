package com.sinco.carnation.resource.vo.equipment;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class EquipMentSleepQueryVO extends BasicParamVO {

	@Param(desc = "日期|某一天")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
