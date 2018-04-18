package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorRelationList", desc = "营运商关系统计")
public class OperatorRelationBO {

	@JsonProperty("userRegisterCount")
	@FieldMapping(desc = "注册的会员")
	private Integer userRegisterCount;

	@JsonProperty("storeRegisterCount")
	@FieldMapping(desc = "注册的商户")
	private Integer storeRegisterCount;

	@JsonProperty("goodsRegisterCount")
	@FieldMapping(desc = "注册的供应商")
	private Integer goodsRegisterCount;

	@JsonProperty("operatorRegisterCount")
	@FieldMapping(desc = "注册运营商")
	private Integer operatorRegisterCount;

	@JsonProperty("areaOperatorCount")
	@FieldMapping(desc = " 辖区运营商")
	private Integer areaOperatorCount;

	@JsonProperty("membershipCount")
	@FieldMapping(desc = "隶属的商户")
	private Integer membershipCount;

	@JsonProperty("membershipUserCount")
	@FieldMapping(desc = "隶属商户的会员")
	private Integer membershipUserCount;

	@JsonProperty("storeRegisterUserCount")
	@FieldMapping(desc = "商户注册会员")
	private Integer storeRegisterUserCount;

	@JsonProperty("cnRegisterUserCount")
	@FieldMapping(desc = "团队注册会员")
	private Integer cnRegisterUserCount;

	@JsonProperty("cnStoreRegisterUserCount")
	@FieldMapping(desc = "团队商户注册会员")
	private Integer cnStoreRegisterUserCount;

	public Integer getOperatorRegisterCount() {
		return operatorRegisterCount;
	}

	public void setOperatorRegisterCount(Integer operatorRegisterCount) {
		this.operatorRegisterCount = operatorRegisterCount;
	}

	public Integer getStoreRegisterCount() {
		return storeRegisterCount;
	}

	public void setStoreRegisterCount(Integer storeRegisterCount) {
		this.storeRegisterCount = storeRegisterCount;
	}

	public Integer getUserRegisterCount() {
		return userRegisterCount;
	}

	public void setUserRegisterCount(Integer userRegisterCount) {
		this.userRegisterCount = userRegisterCount;
	}

	public Integer getAreaOperatorCount() {
		return areaOperatorCount;
	}

	public void setAreaOperatorCount(Integer areaOperatorCount) {
		this.areaOperatorCount = areaOperatorCount;
	}

	public Integer getMembershipCount() {
		return membershipCount;
	}

	public void setMembershipCount(Integer membershipCount) {
		this.membershipCount = membershipCount;
	}

	public Integer getMembershipUserCount() {
		return membershipUserCount;
	}

	public void setMembershipUserCount(Integer membershipUserCount) {
		this.membershipUserCount = membershipUserCount;
	}

	public Integer getGoodsRegisterCount() {
		return goodsRegisterCount;
	}

	public void setGoodsRegisterCount(Integer goodsRegisterCount) {
		this.goodsRegisterCount = goodsRegisterCount;
	}

	public Integer getStoreRegisterUserCount() {
		return storeRegisterUserCount;
	}

	public void setStoreRegisterUserCount(Integer storeRegisterUserCount) {
		this.storeRegisterUserCount = storeRegisterUserCount;
	}

	public Integer getCnRegisterUserCount() {
		return cnRegisterUserCount;
	}

	public void setCnRegisterUserCount(Integer cnRegisterUserCount) {
		this.cnRegisterUserCount = cnRegisterUserCount;
	}

	public Integer getCnStoreRegisterUserCount() {
		return cnStoreRegisterUserCount;
	}

	public void setCnStoreRegisterUserCount(Integer cnStoreRegisterUserCount) {
		this.cnStoreRegisterUserCount = cnStoreRegisterUserCount;
	}

}
