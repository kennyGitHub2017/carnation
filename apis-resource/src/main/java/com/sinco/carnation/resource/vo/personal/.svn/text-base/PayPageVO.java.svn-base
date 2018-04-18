package com.sinco.carnation.resource.vo.personal;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PayPageVO extends BasicParamVO {

	@Param(desc = "id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long id;

	@Param(desc = "count")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer count;

	@Param(desc = "money")
	private BigDecimal money;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

}
