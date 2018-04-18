package com.sinco.carnation.resource.bo.operator;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.api.annotation.ReturnMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorProfitList", desc = "营运商收益流水")
public class OperatorProfitListBO {

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	/** 返润金额 **/
	@JsonProperty("rebateAmount")
	@FieldMapping(desc = "返润金额")
	private BigDecimal rebateAmount;

	/** 返利类型 **/
	@JsonProperty("rebateType")
	@FieldMapping(desc = "返利类型")
	private String rebateType;

	/** 创建时间 **/
	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间")
	private Date createTime;

	/** 收益类型名称 **/
	@JsonProperty("rebateTypeName")
	@FieldMapping(desc = "收益类型名称")
	private String rebateTypeName;

	@JsonProperty("totalExpectProfit")
	@ReturnMapping(desc = "预期收益总额")
	private BigDecimal totalExpectProfit;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getRebateType() {
		return rebateType;
	}

	public void setRebateType(String rebateType) {
		this.rebateType = rebateType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRebateTypeName() {
		return rebateTypeName;
	}

	public void setRebateTypeName(String rebateTypeName) {
		this.rebateTypeName = rebateTypeName;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public BigDecimal getTotalExpectProfit() {
		return totalExpectProfit;
	}

	public void setTotalExpectProfit(BigDecimal totalExpectProfit) {
		this.totalExpectProfit = totalExpectProfit;
	}

}
