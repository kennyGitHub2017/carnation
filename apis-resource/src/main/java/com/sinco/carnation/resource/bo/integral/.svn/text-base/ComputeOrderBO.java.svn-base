package com.sinco.carnation.resource.bo.integral;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ComputeOrderBO", desc = "返回订单所需的积分与费用等相关信息")
public class ComputeOrderBO {
	@JsonProperty("totalIntegral")
	@FieldMapping(desc = "总共需要消费的积分")
	private Integer totalIntegral;

	@JsonProperty("totalTransportFee")
	@FieldMapping(desc = "总共需要支付的邮费")
	private Double totalTransportFee;

	@JsonProperty("userIntegral")
	@FieldMapping(desc = "用户当前剩余的积分")
	private Integer userIntegral;

	public Integer getTotalIntegral() {
		return totalIntegral;
	}

	public void setTotalIntegral(Integer totalIntegral) {
		this.totalIntegral = totalIntegral;
	}

	public Double getTotalTransportFee() {
		return totalTransportFee;
	}

	public void setTotalTransportFee(Double totalTransportFee) {
		this.totalTransportFee = totalTransportFee;
	}

	public Integer getUserIntegral() {
		return userIntegral;
	}

	public void setUserIntegral(Integer userIntegral) {
		this.userIntegral = userIntegral;
	}
}
