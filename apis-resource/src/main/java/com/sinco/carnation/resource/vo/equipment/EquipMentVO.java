package com.sinco.carnation.resource.vo.equipment;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class EquipMentVO extends BasicParamVO {

	@Param(desc = "总步数")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer stepNumber;

	@Param(desc = "身高")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer heigth;

	@Param(desc = "体重")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer weight;

	@Param(desc = "记录时间")
	private Date recordDate;

	public Integer getStepNumber() {
		return stepNumber;
	}

	public void setStepNumber(Integer stepNumber) {
		this.stepNumber = stepNumber;
	}

	public Integer getHeigth() {
		return heigth;
	}

	public void setHeigth(Integer heigth) {
		this.heigth = heigth;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Date getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}

}
