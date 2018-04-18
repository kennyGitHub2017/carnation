package com.sinco.carnation.resource.vo.operator;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class OperatorCashMoneyVO extends BasicParamVO {

	@Param(desc = "提现金额")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double money;

	@Param(desc = "密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String password;

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
