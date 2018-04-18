package com.sinco.carnation.resource.bo.o2o;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "StoreCustomer", desc = "商户会员")
public class StoreCustomerBO {

	@JsonProperty("relationType")
	@FieldMapping(desc = "会员来源0邀请码1首次消费")
	private Integer relationType;

	@JsonProperty("accountCreateTime")
	@FieldMapping(desc = "注册时间")
	private Date accountCreateTime;

	@JsonProperty("nickname")
	@FieldMapping(desc = "昵称")
	private String nickname;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机 ")
	private String mobile;

	public Integer getRelationType() {
		return relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

	public Date getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Date accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
