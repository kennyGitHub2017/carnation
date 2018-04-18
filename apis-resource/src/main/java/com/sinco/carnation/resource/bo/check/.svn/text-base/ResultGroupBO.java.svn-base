package com.sinco.carnation.resource.bo.check;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ResultGroup", desc = "体检分类")
public class ResultGroupBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	/** 体检分类 **/
	@JsonProperty("groupName")
	@FieldMapping(desc = "体检分类")
	private String groupName;

	/** 创建时间 **/
	@JsonProperty("createTime")
	@FieldMapping(desc = "创建时间")
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
