package com.sinco.carnation.resource.web.response.personal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.GroupAreaBO;
import com.sinco.carnation.resource.bo.o2o.GroupServiceBO;
import com.sinco.carnation.resource.bo.o2o.OGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.AwayStoreBO;
import com.sinco.carnation.resource.bo.personal.FavaGroupGoodsBO;
import com.sinco.carnation.resource.bo.personal.GroupStoreFavaBO;
import com.sinco.carnation.resource.bo.personal.RecommStoreInfoBO;
import com.sinco.carnation.resource.bo.personal.StoreSearchBO;

public class PersonalIndexResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("areaListBos")
	@ReturnMapping(desc = "所有城市")
	private List<GroupAreaBO[]> areaListBos;

	@JsonProperty("searchStoreList")
	@ReturnMapping(desc = "搜索商户")
	private List<StoreSearchBO> searchStoreList;

	@JsonProperty("keyWordList")
	@ReturnMapping(desc = "关键字搜索")
	private List<StoreSearchBO> keyWordList;

	@JsonProperty("areaList")
	@ReturnMapping(desc = "城市下面的区域")
	private List<GroupAreaBO> areaList;

	@JsonProperty("isEvaluation")
	@ReturnMapping(desc = "是否评论成功")
	private Boolean isEvaluation;

	@JsonProperty("service")
	@ReturnMapping(desc = "评论页面")
	private GroupServiceBO service;

	@JsonProperty("favaStoreList")
	@ReturnMapping(desc = "收藏的商户")
	private List<GroupStoreFavaBO> favaStoreList;

	@JsonProperty("recommStoreInfo")
	@ReturnMapping(desc = "首页推荐")
	private List<RecommStoreInfoBO> recommStoreInfo;

	@JsonProperty("awayStoreList")
	@ReturnMapping(desc = "离我最近")
	private List<AwayStoreBO> awayStoreList;

	@JsonProperty("youLike")
	@ReturnMapping(desc = "猜你喜欢")
	private List<OGroupGoodsBO> youLike;

	@JsonProperty("favaList")
	@ReturnMapping(desc = "收藏服务列表")
	private List<FavaGroupGoodsBO> favaList;

	@JsonProperty("hotSearch")
	@ReturnMapping(desc = "服务热门搜索")
	private String[] hotSearch;

	public List<GroupAreaBO[]> getAreaListBos() {
		return areaListBos;
	}

	public void setAreaListBos(List<GroupAreaBO[]> areaListBos) {
		this.areaListBos = areaListBos;
	}

	public List<StoreSearchBO> getSearchStoreList() {
		return searchStoreList;
	}

	public void setSearchStoreList(List<StoreSearchBO> searchStoreList) {
		this.searchStoreList = searchStoreList;
	}

	public List<StoreSearchBO> getKeyWordList() {
		return keyWordList;
	}

	public void setKeyWordList(List<StoreSearchBO> keyWordList) {
		this.keyWordList = keyWordList;
	}

	public List<GroupAreaBO> getAreaList() {
		return areaList;
	}

	public void setAreaList(List<GroupAreaBO> areaList) {
		this.areaList = areaList;
	}

	public GroupServiceBO getService() {
		return service;
	}

	public void setService(GroupServiceBO service) {
		this.service = service;
	}

	public Boolean getIsEvaluation() {
		return isEvaluation;
	}

	public void setIsEvaluation(Boolean isEvaluation) {
		this.isEvaluation = isEvaluation;
	}

	public List<GroupStoreFavaBO> getFavaStoreList() {
		return favaStoreList;
	}

	public void setFavaStoreList(List<GroupStoreFavaBO> favaStoreList) {
		this.favaStoreList = favaStoreList;
	}

	public List<RecommStoreInfoBO> getRecommStoreInfo() {
		return recommStoreInfo;
	}

	public void setRecommStoreInfo(List<RecommStoreInfoBO> recommStoreInfo) {
		this.recommStoreInfo = recommStoreInfo;
	}

	public List<AwayStoreBO> getAwayStoreList() {
		return awayStoreList;
	}

	public void setAwayStoreList(List<AwayStoreBO> awayStoreList) {
		this.awayStoreList = awayStoreList;
	}

	public List<OGroupGoodsBO> getYouLike() {
		return youLike;
	}

	public void setYouLike(List<OGroupGoodsBO> youLike) {
		this.youLike = youLike;
	}

	public List<FavaGroupGoodsBO> getFavaList() {
		return favaList;
	}

	public void setFavaList(List<FavaGroupGoodsBO> favaList) {
		this.favaList = favaList;
	}

	public String[] getHotSearch() {
		return hotSearch;
	}

	public void setHotSearch(String[] hotSearch) {
		this.hotSearch = hotSearch;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
