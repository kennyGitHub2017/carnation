package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "CheckGroup", desc = "自测题")
public class CheckGroupBO {

	@JsonProperty("id")
	@FieldMapping(desc = "自测题套题Id")
	private Long id;

	@JsonProperty("thumbnail")
	@FieldMapping(desc = "缩略图")
	private String thumbnail;

	@JsonProperty("groupTitle")
	@FieldMapping(desc = "标题")
	private String groupTitle;

	@JsonProperty("summary")
	@FieldMapping(desc = "概述")
	private String summary;

	@JsonProperty("content")
	@FieldMapping(desc = "内容")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getGroupTitle() {
		return groupTitle;
	}

	public void setGroupTitle(String groupTitle) {
		this.groupTitle = groupTitle;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}