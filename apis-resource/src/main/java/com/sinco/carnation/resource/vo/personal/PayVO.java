package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PayVO extends BasicParamVO {

	@Param(desc = "支付类型")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String payType;

	@Param(desc = "订单id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long orderId;

	@Param(desc = "是否用云豆")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private Boolean isAvailableBalance;

	@Param(desc = "支付密码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String paymentPassword;

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Boolean getIsAvailableBalance() {
		return isAvailableBalance;
	}

	public void setIsAvailableBalance(Boolean isAvailableBalance) {
		this.isAvailableBalance = isAvailableBalance;
	}

	public String getPaymentPassword() {
		return paymentPassword;
	}

	public void setPaymentPassword(String paymentPassword) {
		this.paymentPassword = paymentPassword;
	}
}
