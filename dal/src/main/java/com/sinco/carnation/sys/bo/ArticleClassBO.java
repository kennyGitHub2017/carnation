package com.sinco.carnation.sys.bo;

import java.util.List;

import com.sinco.carnation.sys.model.ArticleClass;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class ArticleClassBO extends ArticleClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9090435772783976407L;

	private List<ArticleClassBO> childs;

	private List<ArticleBO> articles;

	public List<ArticleBO> getArticles() {
		return articles;
	}

	public void setArticles(List<ArticleBO> articles) {
		this.articles = articles;
	}

	public List<ArticleClassBO> getChilds() {
		return childs;
	}

	public void setChilds(List<ArticleClassBO> childs) {
		this.childs = childs;
	}
}