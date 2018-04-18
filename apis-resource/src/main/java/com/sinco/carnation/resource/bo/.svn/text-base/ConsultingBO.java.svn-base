package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;
import com.sinco.dal.common.persistence.mybatis.DataModel;

@SuppressWarnings("serial")
@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ConsultingBO", desc = "专家提问")
public class ConsultingBO extends DataModel {

	@JsonProperty("id")
	@FieldMapping(desc = "提问id")
	private Long id;

	@JsonProperty("expertsUserId")
	@FieldMapping(desc = "专家用户id")
	private Long expertsUserId;

	@JsonProperty("userId")
	@FieldMapping(desc = "提问用户id")
	private Long userId;

	@JsonProperty("title")
	@FieldMapping(desc = "提问标题")
	private String title;

	@JsonProperty("images")
	@FieldMapping(desc = "提问图片")
	private String images;

	@JsonProperty("content")
	@FieldMapping(desc = "提问内容")
	private String content;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExpertsUserId() {
		return expertsUserId;
	}

	public void setExpertsUserId(Long expertsUserId) {
		this.expertsUserId = expertsUserId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}