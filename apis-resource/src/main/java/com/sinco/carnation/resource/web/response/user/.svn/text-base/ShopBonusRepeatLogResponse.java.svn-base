package com.sinco.carnation.resource.web.response.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.UserYunGouMoneyBO;

public class ShopBonusRepeatLogResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("UserYunGouMoneyBO")
	@ReturnMapping(desc = "用户云购币明细")
	private List<UserYunGouMoneyBO> ShopBonusRepeatList;

	@JsonProperty("yunGouMoney")
	@ReturnMapping(desc = "用户云购币")
	private double yunGouMoney;

	public List<UserYunGouMoneyBO> getShopBonusRepeatList() {
		return ShopBonusRepeatList;
	}

	public void setShopBonusRepeatList(List<UserYunGouMoneyBO> shopBonusRepeatList) {
		ShopBonusRepeatList = shopBonusRepeatList;
	}

	public double getYunGouMoney() {
		return yunGouMoney;
	}

	public void setYunGouMoney(double yunGouMoney) {
		this.yunGouMoney = yunGouMoney;
	}
}
