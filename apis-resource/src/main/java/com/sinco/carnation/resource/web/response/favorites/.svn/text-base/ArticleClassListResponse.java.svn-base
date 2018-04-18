package com.sinco.carnation.resource.web.response.favorites;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.ArticleClassBO;

public class ArticleClassListResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("articleClasses")
	@ReturnMapping(desc = "帖子分类列表")
	private List<ArticleClassBO> articleClasses;

	public List<ArticleClassBO> getArticleClasses() {
		return articleClasses;
	}

	public void setArticleClasses(List<ArticleClassBO> articleClasses) {
		this.articleClasses = articleClasses;
	}
}
