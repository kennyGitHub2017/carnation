package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.carnation.user.model.UserExperts;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserConsultingListBO", desc = "用户专家咨询问题列表")
public class UserConsultingListBO {

	@JsonProperty("userExperts")
	@FieldMapping(desc = "专家咨询,专家信息")
	private UserExperts userExperts;

	@JsonProperty("newRepayTime")
	@FieldMapping(desc = "专家咨询最后回复时间")
	private Date newRepayTime;

	@JsonProperty("title")
	@FieldMapping(desc = "提问标题")
	private String title;

	@JsonProperty("id")
	@FieldMapping(desc = "提问Id")
	private Long id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserExperts getUserExperts() {
		return userExperts;
	}

	public void setUserExperts(UserExperts userExperts) {
		this.userExperts = userExperts;
	}

	public Date getNewRepayTime() {
		return newRepayTime;
	}

	public void setNewRepayTime(Date newRepayTime) {
		this.newRepayTime = newRepayTime;
	}

}