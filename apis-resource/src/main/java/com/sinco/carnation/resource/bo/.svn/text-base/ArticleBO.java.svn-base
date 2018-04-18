package com.sinco.carnation.resource.bo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "ArticleBO", desc = "系统文章")
public class ArticleBO {

	@JsonProperty("id")
	@FieldMapping(desc = "文章id")
	private Long id;

	@JsonProperty("addTime")
	@FieldMapping(desc = "添加时间")
	private Date addTime;

	@JsonProperty("title")
	@FieldMapping(desc = "文章标题")
	private String title;

	@JsonProperty("content")
	@FieldMapping(desc = "文章内容")
	private String content;

	@JsonProperty("articleClassName")
	@FieldMapping(desc = "文章分类名称")
	private String articleClassName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getArticleClassName() {
		return articleClassName;
	}

	public void setArticleClassName(String articleClassName) {
		this.articleClassName = articleClassName;
	}

}