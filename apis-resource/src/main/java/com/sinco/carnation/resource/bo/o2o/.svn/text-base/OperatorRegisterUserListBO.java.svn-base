package com.sinco.carnation.resource.bo.o2o;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorRegisterUserList", desc = "营运商注册会员 ")
public class OperatorRegisterUserListBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("nickname")
	@FieldMapping(desc = "会员昵称")
	private String nickname;

	@JsonProperty("areaName")
	@FieldMapping(desc = "会员辖区")
	private String areaName;

	@JsonProperty("sellerNickName")
	@FieldMapping(desc = "隶属商户昵称")
	private String sellerNickName;

	@JsonProperty("operatorName")
	@FieldMapping(desc = "隶属商户运营商")
	private String operatorName;

	@JsonProperty("operatorCode")
	@FieldMapping(desc = "隶属运营商编号")
	private String operatorCode;

	@JsonProperty("createTime")
	@FieldMapping(desc = "注册时间")
	private Date createTime;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getSellerNickName() {
		return sellerNickName;
	}

	public void setSellerNickName(String sellerNickName) {
		this.sellerNickName = sellerNickName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
