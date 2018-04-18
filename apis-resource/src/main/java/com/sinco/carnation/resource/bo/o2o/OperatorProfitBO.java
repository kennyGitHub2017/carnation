package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorProfit", desc = "营运商收益统计")
public class OperatorProfitBO {

	@JsonProperty("profitAmount")
	@FieldMapping(desc = "注册返润收益|辖区返润收益|隶属返润收益|支付手续收益")
	private Double profitAmount;

	@JsonProperty("recommedAmount")
	@FieldMapping(desc = "推荐运营商|本辖本消|本隶本消|隶属支付")
	private Double recommedAmount;

	@JsonProperty("storeAmount")
	@FieldMapping(desc = "推荐商户|本辖外销|本隶外消|辖区支付")
	private Double storeAmount;

	@JsonProperty("userAmount")
	@FieldMapping(desc = "推荐会员|外辖本消|外隶本消|推荐收益")
	private Double userAmount;

	@JsonProperty("type")
	@FieldMapping(desc = "类型|1注册返润2辖区返润3隶属返润4支付手续")
	private Integer type;

	@JsonProperty("rcRebate")
	@FieldMapping(desc = "推荐购买分润")
	private Double rcRebate;

	@JsonProperty("rsRebate")
	@FieldMapping(desc = "推荐产品分润")
	private Double rsRebate;

	public Double getProfitAmount() {
		return profitAmount;
	}

	public void setProfitAmount(Double profitAmount) {
		this.profitAmount = profitAmount;
	}

	public Double getRecommedAmount() {
		return recommedAmount;
	}

	public void setRecommedAmount(Double recommedAmount) {
		this.recommedAmount = recommedAmount;
	}

	public Double getStoreAmount() {
		return storeAmount;
	}

	public void setStoreAmount(Double storeAmount) {
		this.storeAmount = storeAmount;
	}

	public Double getUserAmount() {
		return userAmount;
	}

	public void setUserAmount(Double userAmount) {
		this.userAmount = userAmount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Double getRcRebate() {
		return rcRebate;
	}

	public void setRcRebate(Double rcRebate) {
		this.rcRebate = rcRebate;
	}

	public Double getRsRebate() {
		return rsRebate;
	}

	public void setRsRebate(Double rsRebate) {
		this.rsRebate = rsRebate;
	}

}
