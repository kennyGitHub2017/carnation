package com.sinco.carnation.resource.vo.equipment;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class EquipMentQueryVO extends BasicParamVO {

	private Date startDate;

	private Date endDate;

	@Param(desc = "开始日期|如：2016-01-08格式年月日")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String startDateStr;

	@Param(desc = "结束日期|如：2016-01-08格式年月日")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String endDateStr;

	@Param(desc = "参数值类型：1：步数，2：卡路里，3：里程,4:睡眠时长,5:深睡时长,6:浅睡时长")
	private Integer parmType;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStartDateStr() {
		return startDateStr;
	}

	public void setStartDateStr(String startDateStr) {
		this.startDateStr = startDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public Integer getParmType() {
		return parmType;
	}

	public void setParmType(Integer parmType) {
		this.parmType = parmType;
	}

}
