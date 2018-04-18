package com.sinco.carnation.resource.web.response.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.paymet.WeiXinPaymetBO;

public class GroupTradePaymetResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("isCompletePay")
	@ReturnMapping(desc = "是否已经完成了支付")
	private Boolean isCompletePay;

	@JsonProperty("paymetType")
	@ReturnMapping(desc = "支付方式")
	private String paymetType;

	@JsonProperty("paySignature")
	@ReturnMapping(desc = "支付密文,支付宝用")
	private String paySignature;

	@JsonProperty("weiXinPaymet")
	@ReturnMapping(desc = "weixin 支付相关")
	private WeiXinPaymetBO weiXinPaymet;

	@JsonProperty("orderStatus")
	@ReturnMapping(desc = "订单状态")
	private Integer orderStatus;

	public Boolean getIsCompletePay() {
		return isCompletePay;
	}

	public void setIsCompletePay(Boolean isCompletePay) {
		this.isCompletePay = isCompletePay;
	}

	public String getPaymetType() {
		return paymetType;
	}

	public void setPaymetType(String paymetType) {
		this.paymetType = paymetType;
	}

	public String getPaySignature() {
		return paySignature;
	}

	public void setPaySignature(String paySignature) {
		this.paySignature = paySignature;
	}

	public WeiXinPaymetBO getWeiXinPaymet() {
		return weiXinPaymet;
	}

	public void setWeiXinPaymet(WeiXinPaymetBO weiXinPaymet) {
		this.weiXinPaymet = weiXinPaymet;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

}
