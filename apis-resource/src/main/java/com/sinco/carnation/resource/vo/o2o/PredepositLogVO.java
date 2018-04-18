package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class PredepositLogVO extends BasicPageParamVo {

	@Param(desc = "操作类型1充值2提现3消费4兑换金币5人工操作")
	@NotNull
	private Integer opType;

	public Integer getOpType() {
		return opType;
	}

	public void setOpType(Integer opType) {
		this.opType = opType;
	}

}
