package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PayCartOrderVO extends BasicParamVO {

	@Param(desc = "手机号码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	@Param(desc = "价格")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double price;

	@Param(desc = "服务项目")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String goodsName;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
