package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ArticleClassBO", desc = "文章资讯分类")
public class ArticleClassBO {

	@JsonProperty("id")
	@FieldMapping(desc = "分类id")
	private Long id;

	@JsonProperty("className")
	@FieldMapping(desc = "分类名称")
	private String className;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}