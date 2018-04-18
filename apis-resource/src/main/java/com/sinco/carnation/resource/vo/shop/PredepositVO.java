package com.sinco.carnation.resource.vo.shop;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PredepositVO extends BasicParamVO {

	@Param(desc = "id")
	private Long id;

	@Param(desc = "充值金额")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private BigDecimal pdAmount;

	@Param(desc = "充值方式")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String pdPayment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPdAmount() {
		return pdAmount;
	}

	public void setPdAmount(BigDecimal pdAmount) {
		this.pdAmount = pdAmount;
	}

	public String getPdPayment() {
		return pdPayment;
	}

	public void setPdPayment(String pdPayment) {
		this.pdPayment = pdPayment;
	}

}