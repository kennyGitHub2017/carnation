package com.sinco.carnation.resource.web.response.activity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

public class ActGoldEggResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ReturnMapping(desc = "中奖金额")
	@JsonProperty("money")
	private BigDecimal money;
	@ReturnMapping(desc = "金蛋索引")
	@JsonProperty("index")
	private Integer index;

	@ReturnMapping(desc = "第一个金蛋是否被砸开")
	@JsonProperty("indexOneUsed")
	private Boolean indexOneUsed;
	@ReturnMapping(desc = "第二个金蛋是否被砸开")
	@JsonProperty("indexTwoUsed")
	private Boolean indexTwoUsed;
	@ReturnMapping(desc = "第三个金蛋是否被砸开")
	@JsonProperty("indexThreeUsed")
	private Boolean indexThreeUsed;
	@ReturnMapping(desc = "还有几次机会砸蛋")
	@JsonProperty("hasEgg")
	private Integer hasEgg;

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Boolean isIndexOneUsed() {
		return indexOneUsed;
	}

	public void setIndexOneUsed(Boolean indexOneUsed) {
		this.indexOneUsed = indexOneUsed;
	}

	public Boolean isIndexTwoUsed() {
		return indexTwoUsed;
	}

	public void setIndexTwoUsed(Boolean indexTwoUsed) {
		this.indexTwoUsed = indexTwoUsed;
	}

	public Boolean isIndexThreeUsed() {
		return indexThreeUsed;
	}

	public void setIndexThreeUsed(Boolean indexThreeUsed) {
		this.indexThreeUsed = indexThreeUsed;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public Integer getHasEgg() {
		return hasEgg;
	}

	public void setHasEgg(Integer hasEgg) {
		this.hasEgg = hasEgg;
	}

}
