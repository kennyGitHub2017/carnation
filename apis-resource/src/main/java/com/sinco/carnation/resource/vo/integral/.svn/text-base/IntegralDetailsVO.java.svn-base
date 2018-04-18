package com.sinco.carnation.resource.vo.integral;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class IntegralDetailsVO extends BasicParamVO {

	@Param(desc = "积分商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long id;

	@Param(desc = "数量")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer count;

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
}
