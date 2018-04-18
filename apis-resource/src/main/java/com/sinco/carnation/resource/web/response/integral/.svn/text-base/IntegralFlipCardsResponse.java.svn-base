package com.sinco.carnation.resource.web.response.integral;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class IntegralFlipCardsResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("ifSenior")
	@ReturnMapping(desc = "是否高级牌 true 高级牌 false 普通牌")
	private boolean ifSenior;

	@JsonProperty("ifFlip")
	@ReturnMapping(desc = "是否已翻牌 true 已翻牌 false 未翻牌")
	private boolean ifFlip;

	@JsonProperty("signDayFlip")
	@ReturnMapping(desc = "连续翻牌天数")
	private int signDayFlip;

	@JsonProperty("ifRemedy")
	@ReturnMapping(desc = "是否需要补签")
	private boolean ifRemedy;

	@JsonProperty("ytdSignDay")
	@ReturnMapping(desc = "昨日连续翻牌次数")
	private int ytdSignDay;

	@JsonProperty("flipIntegral")
	@ReturnMapping(desc = "翻牌积分")
	private int flipIntegral;

	@JsonProperty("remedy")
	@ReturnMapping(desc = "补救 成功true 失败false")
	private boolean remedy;

	public boolean isIfSenior() {
		return ifSenior;
	}

	public void setIfSenior(boolean ifSenior) {
		this.ifSenior = ifSenior;
	}

	public boolean isIfFlip() {
		return ifFlip;
	}

	public void setIfFlip(boolean ifFlip) {
		this.ifFlip = ifFlip;
	}

	public int getSignDayFlip() {
		return signDayFlip;
	}

	public void setSignDayFlip(int signDayFlip) {
		this.signDayFlip = signDayFlip;
	}

	public boolean isIfRemedy() {
		return ifRemedy;
	}

	public void setIfRemedy(boolean ifRemedy) {
		this.ifRemedy = ifRemedy;
	}

	public int getYtdSignDay() {
		return ytdSignDay;
	}

	public void setYtdSignDay(int ytdSignDay) {
		this.ytdSignDay = ytdSignDay;
	}

	public int getFlipIntegral() {
		return flipIntegral;
	}

	public void setFlipIntegral(int flipIntegral) {
		this.flipIntegral = flipIntegral;
	}

	public boolean isRemedy() {
		return remedy;
	}

	public void setRemedy(boolean remedy) {
		this.remedy = remedy;
	}

}
