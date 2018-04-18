package com.sinco.carnation.resource.web.response.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.shop.YgPayModeBO;
import com.sinco.carnation.resource.bo.shop.ShopOrderFormBO;

/**
 * 
 * @author james
 * 
 */
public class ShopOrderCreateCreateResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ReturnMapping(desc = "主订单对象")
	@JsonProperty("order")
	private ShopOrderFormBO order;

	@ReturnMapping(desc = "订单总价")
	@JsonProperty("totalPrice")
	private double totalPrice;
	
	@ReturnMapping(desc = "云购币专区订单支付相关")
	@JsonProperty("ygPayMode")
	private YgPayModeBO ygPayMode;
	
	@ReturnMapping(desc = "支付方式")
	@JsonProperty("payTypeFlag")
	private Integer payTypeFlag;

	public ShopOrderFormBO getOrder() {
		return order;
	}

	public void setOrder(ShopOrderFormBO order) {
		this.order = order;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public YgPayModeBO getYgPayMode() {
		return ygPayMode;
	}

	public void setYgPayMode(YgPayModeBO ygPayMode) {
		this.ygPayMode = ygPayMode;
	}

	public Integer getPayTypeFlag() {
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}
	/**
	 * 执行结果0-正常/1-错误
	 */
	private int m_status = 0;

	/**
	 * 错误编码
	 */
	private String m_errorCode = "";

	/**
	 * 错误信息
	 */
	private String m_errorMsg = "";

	public int getM_status() {
		return m_status;
	}

	public void setM_status(int m_status) {
		this.m_status = m_status;
	}

	public String getM_errorCode() {
		return m_errorCode;
	}

	public void setM_errorCode(String m_errorCode) {
		this.m_errorCode = m_errorCode;
	}

	public String getM_errorMsg() {
		return m_errorMsg;
	}

	public void setM_errorMsg(String m_errorMsg) {
		this.m_errorMsg = m_errorMsg;
	}
	
}
