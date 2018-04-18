package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopExpressTransViewVO extends BasicParamVO {

	@Param(desc = "快递号")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String expressCode;

	@Param(desc = "快递公司 id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long expressCompanyId;

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public Long getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Long expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}
}
