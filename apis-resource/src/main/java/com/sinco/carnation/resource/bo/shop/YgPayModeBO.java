package com.sinco.carnation.resource.bo.shop;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

/***
 * 云购币订单支付类
 * 
 * @author Administrator
 * 
 */
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ygPayMode", desc = "云购币订单支付类")
public class YgPayModeBO {

	@JsonProperty("res")
	@FieldMapping(desc = "10奖金账户支付JJ;20充值账户支付cZ; 30现金支付CASH")
	private int res;// 返回结果

	@JsonProperty("actualygPrice")
	@FieldMapping(desc = "实际支付云购币总和")
	private Double actualygPrice;// 实际支付云购总和

	@JsonProperty("actualPrice")
	@FieldMapping(desc = "实际支付现金总和")
	private Double actualPrice;// 实际支付现金总和

	@JsonProperty("currentYgBalance")
	@FieldMapping(desc = "当前与购币余额")
	private Double currentYgBalance;// 当前与购币余额

	@JsonProperty("currentJjBalance")
	@FieldMapping(desc = "当前奖金余额")
	private Double currentJjBalance;// 当前奖金余额

	@JsonProperty("currentCzBalance")
	@FieldMapping(desc = "当前充值余额")
	private Double currentCzBalance;// 当前充值余额

	@JsonProperty("pay_mode")
	@FieldMapping(desc = "选择支付方式")
	private String pay_mode;// 选择支付方式

	@JsonProperty("yGWallet_status")
	@FieldMapping(desc = "云购账户状态")
	private Integer yGWallet_status;// 云购账户状态

	@JsonProperty("jJWallet_status")
	@FieldMapping(desc = "工资账户状态")
	private Integer jJWallet_status;// 工资账户状态

	@JsonProperty("cZWallet_status")
	@FieldMapping(desc = "充值账户状态")
	private Integer cZWallet_status;// 充值账户状态

	@JsonProperty("currentIntegralBalance")
	@FieldMapping(desc = "当前积分余额")
	private Double currentIntegralBalance;// 当前积分余额

	@JsonProperty("actualIntegralBalance")
	@FieldMapping(desc = "实际支付积分")
	private Double actualIntegralBalance;// 实际要支付积分

	@JsonProperty("payTypeFlag")
	@FieldMapping(desc = "支付方式 1重消支付 2积分支付")
	private Integer payTypeFlag;
	
	@JsonProperty("currentBalance")
	@FieldMapping(desc = "当前平台云豆余额")
	private Double currentBalance;

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

	public Double getActualygPrice() {
		return actualygPrice;
	}

	public void setActualygPrice(Double actualygPrice) {
		this.actualygPrice = actualygPrice;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getCurrentYgBalance() {
		return currentYgBalance;
	}

	public void setCurrentYgBalance(Double currentYgBalance) {
		this.currentYgBalance = currentYgBalance;
	}

	public Double getCurrentJjBalance() {
		return currentJjBalance;
	}

	public void setCurrentJjBalance(Double currentJjBalance) {
		this.currentJjBalance = currentJjBalance;
	}

	public Double getCurrentCzBalance() {
		return currentCzBalance;
	}

	public void setCurrentCzBalance(Double currentCzBalance) {
		this.currentCzBalance = currentCzBalance;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}

	public Integer getyGWallet_status() {
		return yGWallet_status;
	}

	public void setyGWallet_status(Integer yGWallet_status) {
		this.yGWallet_status = yGWallet_status;
	}

	public Integer getjJWallet_status() {
		return jJWallet_status;
	}

	public void setjJWallet_status(Integer jJWallet_status) {
		this.jJWallet_status = jJWallet_status;
	}

	public Integer getcZWallet_status() {
		return cZWallet_status;
	}

	public void setcZWallet_status(Integer cZWallet_status) {
		this.cZWallet_status = cZWallet_status;
	}

	public Double getCurrentIntegralBalance() {
		return currentIntegralBalance;
	}

	public void setCurrentIntegralBalance(Double currentIntegralBalance) {
		this.currentIntegralBalance = currentIntegralBalance;
	}

	public Double getActualIntegralBalance() {
		return actualIntegralBalance;
	}

	public void setActualIntegralBalance(Double actualIntegralBalance) {
		this.actualIntegralBalance = actualIntegralBalance;
	}

	public Integer getPayTypeFlag() {
		return payTypeFlag;
	}

	public void setPayTypeFlag(Integer payTypeFlag) {
		this.payTypeFlag = payTypeFlag;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
	}


}
