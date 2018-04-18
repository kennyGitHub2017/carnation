package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserIntegralDetailBO", desc = "用户积分|云豆明细")
public class UserIntegralDetailBO {

	@JsonProperty("type")
	@FieldMapping(desc = "积分来源描述")
	private String type;

	@JsonProperty("addtime")
	@FieldMapping(desc = "获取积分时间")
	private Date addtime;

	@JsonProperty("integral")
	@FieldMapping(desc = "积分数")
	private Integer integral;

	@JsonProperty("balance")
	@FieldMapping(desc = "积分余额")
	private Integer balance;

	@JsonProperty("typeName")
	@FieldMapping(desc = "积分类型名")
	private String typeName;

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
