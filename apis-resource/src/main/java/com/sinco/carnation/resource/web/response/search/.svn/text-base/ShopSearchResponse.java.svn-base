package com.sinco.carnation.resource.web.response.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.search.SearchBO;
import com.sinco.carnation.resource.bo.search.ShopLuceneResultBO;

public class ShopSearchResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("searchGoodsList")
	@ReturnMapping(desc = "搜索的分类商品列表")
	private SearchBO searchGoodsList;

	@JsonProperty("keywordGoodsList")
	@ReturnMapping(desc = "关键字搜索商品列表")
	private List<ShopLuceneResultBO> keywordGoodsList;

	@JsonProperty("hotKey")
	@ReturnMapping(desc = "热门关键字")
	private String[] hotKey;

	public SearchBO getSearchGoodsList() {
		return searchGoodsList;
	}

	public void setSearchGoodsList(SearchBO searchGoodsList) {
		this.searchGoodsList = searchGoodsList;
	}

	public List<ShopLuceneResultBO> getKeywordGoodsList() {
		return keywordGoodsList;
	}

	public void setKeywordGoodsList(List<ShopLuceneResultBO> keywordGoodsList) {
		this.keywordGoodsList = keywordGoodsList;
	}

	public String[] getHotKey() {
		return hotKey;
	}

	public void setHotKey(String[] hotKey) {
		this.hotKey = hotKey;
	}

}
