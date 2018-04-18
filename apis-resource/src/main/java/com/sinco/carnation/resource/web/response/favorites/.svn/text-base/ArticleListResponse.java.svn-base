package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ArticleBO;

public class ArticleListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("articles")
	@ReturnMapping(desc = "帖子列表")
	private List<ArticleBO> articles;

	public List<ArticleBO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleBO> articles) {
		this.articles = articles;
	}

}
