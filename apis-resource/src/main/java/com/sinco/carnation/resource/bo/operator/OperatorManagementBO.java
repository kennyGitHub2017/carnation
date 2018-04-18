package com.sinco.carnation.resource.bo.operator;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorManagement", desc = "营运商商户管理")
public class OperatorManagementBO {

	/** 店铺名称 **/
	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称 ")
	private String storeName;

	/** 店铺电话号码 **/
	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话号码 ")
	private String storeTelephone;

	@JsonProperty("rebateConsumeAmount")
	@FieldMapping(desc = "商户返润 ")
	private BigDecimal rebateConsumeAmount;// 商户返润

	@JsonProperty("rebateFeeAmount")
	@FieldMapping(desc = "手续费返润 ")
	private BigDecimal rebateFeeAmount;// 手续费返润

	@JsonProperty("rebateTotal")
	@FieldMapping(desc = "返润总额")
	private BigDecimal rebateTotal;

	@JsonProperty("tradingTotal")
	@FieldMapping(desc = "交易总额")
	private BigDecimal tradingTotal;

	@JsonProperty("storeId")
	@FieldMapping(desc = "商户id")
	private Long storeId;// 商户id

	@JsonProperty("isExtension")
	@FieldMapping(desc = "是否被所属运营商推广(即为他注册会员功能标签) Y:是  N:否")
	private String isExtension;

	@JsonProperty("uid")
	@FieldMapping(desc = "卖家uid")
	private Long uid;

	public String getIsExtension() {
		return isExtension;
	}

	public void setIsExtension(String isExtension) {
		this.isExtension = isExtension;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public BigDecimal getRebateConsumeAmount() {
		return rebateConsumeAmount;
	}

	public void setRebateConsumeAmount(BigDecimal rebateConsumeAmount) {
		this.rebateConsumeAmount = rebateConsumeAmount;
	}

	public BigDecimal getRebateFeeAmount() {
		return rebateFeeAmount;
	}

	public void setRebateFeeAmount(BigDecimal rebateFeeAmount) {
		this.rebateFeeAmount = rebateFeeAmount;
	}

	public BigDecimal getRebateTotal() {
		return rebateTotal;
	}

	public void setRebateTotal(BigDecimal rebateTotal) {
		this.rebateTotal = rebateTotal;
	}

	public BigDecimal getTradingTotal() {
		return tradingTotal;
	}

	public void setTradingTotal(BigDecimal tradingTotal) {
		this.tradingTotal = tradingTotal;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}
