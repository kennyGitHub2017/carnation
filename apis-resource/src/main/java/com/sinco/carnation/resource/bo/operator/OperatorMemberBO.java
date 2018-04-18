package com.sinco.carnation.resource.bo.operator;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorMember", desc = "营运商会员")
public class OperatorMemberBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("relationType")
	@FieldMapping(desc = "会员来源：0邀请码1首次消费")
	private Integer relationType;

	@JsonProperty("createTime")
	@FieldMapping(desc = "注册时间")
	private Date createTime;

	@JsonProperty("groupStoreName")
	@FieldMapping(desc = "商户名称")
	private String groupStoreName;

	@JsonProperty("nickname")
	@FieldMapping(desc = "昵称")
	private String nickname;

	@JsonProperty("relationName")
	@FieldMapping(desc = "会员类型")
	private String relationName;

	@JsonProperty("storeName")
	@FieldMapping(desc = "商户名称")
	private String storeName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getRelationType() {
		return relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getGroupStoreName() {
		return groupStoreName;
	}

	public void setGroupStoreName(String groupStoreName) {
		this.groupStoreName = groupStoreName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRelationName() {
		return relationName;
	}

	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
