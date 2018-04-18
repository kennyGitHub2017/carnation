package com.sinco.carnation.goods.vo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;

public class GoodsVO {
	private Integer goodsStatus;

	/** 商品对应的大分类 **/
	private Long gcId;

	private Boolean storeRecommend;

	private String goodsBrandId;

	private String goodsName;

	private String userAdminId;

	private String storeName;

	private Integer goodsType;

	private Set<Integer> goodsStatusList;

	private Set<Long> goodsClassIds;

	private Set<Long> userGoodsClassIds;

	private Set<Long> goodsBrandIds;

	private Set<Long> goodsSpecIds;

	private String goodsCod;

	private String goodsTransfee;

	private String gtpName;
	private String gtpValue;

	private String brandIds;

	private String properties;

	private Integer goodsInventory;

	private Long storeId;

	private Long userGoodsClassId;

	private List<GoodsTypePropertyBO> filterProperties;
	private List<Map<String, String>> goodsProperty;
	/**
	 * 排序字段，排序方式，asc,desc
	 */
	private String orderBy;
	private String orderType;

	private Set<Long> gcIds;
	private String gsIdsStr;

	private String target;

	private String startDate;
	private String endDate;

	private String timeIndex;
	private String startTime;
	private String endTime;
	private String searchName;
	private String goodsId;// 商品Id
	private Integer isYgb;// 是否是云购币

	private Long fgcId;
	private Long sgcId;
	private Long tgcId;
	/**
	 * 扩展价格标识 1CN
	 */
	private Integer exPriceFlag;
	/**
	 * 是否有库存  0：否  1：有
	 */
	private Integer hasStock;
	/**
	 * 是否有积分  0：否  1：有
	 */
	private Integer hasIntegral;
	
	public Integer getHasStock() {
		return hasStock;
	}

	public void setHasStock(Integer hasStock) {
		this.hasStock = hasStock;
	}

	public Integer getExPriceFlag() {
		return exPriceFlag;
	}

	public void setExPriceFlag(Integer exPriceFlag) {
		this.exPriceFlag = exPriceFlag;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Map<String, String>> getGoodsProperty() {
		return goodsProperty;
	}

	public void setGoodsProperty(List<Map<String, String>> goodsProperty) {
		this.goodsProperty = goodsProperty;
	}

	public List<GoodsTypePropertyBO> getFilterProperties() {
		return filterProperties;
	}

	public void setFilterProperties(List<GoodsTypePropertyBO> filterProperties) {
		this.filterProperties = filterProperties;
	}

	public String getGsIdsStr() {
		return gsIdsStr;
	}

	public void setGsIdsStr(String gsIdsStr) {
		this.gsIdsStr = gsIdsStr;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getBrandIds() {
		return brandIds;
	}

	public void setBrandIds(String brandIds) {
		this.brandIds = brandIds;
	}

	public Set<Integer> getGoodsStatusList() {
		return goodsStatusList;
	}

	public void setGoodsStatusList(Set<Integer> goodsStatusList) {
		this.goodsStatusList = goodsStatusList;
	}

	public Long getUserGoodsClassId() {
		return userGoodsClassId;
	}

	public void setUserGoodsClassId(Long userGoodsClassId) {
		this.userGoodsClassId = userGoodsClassId;
	}

	public Set<Long> getUserGoodsClassIds() {
		return userGoodsClassIds;
	}

	public void setUserGoodsClassIds(Set<Long> userGoodsClassIds) {
		this.userGoodsClassIds = userGoodsClassIds;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Boolean getStoreRecommend() {
		return storeRecommend;
	}

	public void setStoreRecommend(Boolean storeRecommend) {
		this.storeRecommend = storeRecommend;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public String getGtpName() {
		return gtpName;
	}

	public void setGtpName(String gtpName) {
		this.gtpName = gtpName;
	}

	public String getGtpValue() {
		return gtpValue;
	}

	public void setGtpValue(String gtpValue) {
		this.gtpValue = gtpValue;
	}

	public Set<Long> getGoodsSpecIds() {
		return goodsSpecIds;
	}

	public void setGoodsSpecIds(Set<Long> goodsSpecIds) {
		this.goodsSpecIds = goodsSpecIds;
	}

	public Set<Long> getGoodsBrandIds() {
		return goodsBrandIds;
	}

	public void setGoodsBrandIds(Set<Long> goodsBrandIds) {
		this.goodsBrandIds = goodsBrandIds;
	}

	public String getGoodsTransfee() {
		return goodsTransfee;
	}

	public void setGoodsTransfee(String goodsTransfee) {
		this.goodsTransfee = goodsTransfee;
	}

	public String getGoodsCod() {
		return goodsCod;
	}

	public void setGoodsCod(String goodsCod) {
		this.goodsCod = goodsCod;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Set<Long> getGoodsClassIds() {
		return goodsClassIds;
	}

	public void setGoodsClassIds(Set<Long> goodsClassIds) {
		this.goodsClassIds = goodsClassIds;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getGoodsBrandId() {
		return goodsBrandId;
	}

	public void setGoodsBrandId(String goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUserAdminId() {
		return userAdminId;
	}

	public void setUserAdminId(String userAdminId) {
		this.userAdminId = userAdminId;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Set<Long> getGcIds() {
		return gcIds;
	}

	public void setGcIds(Set<Long> gcIds) {
		this.gcIds = gcIds;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getTimeIndex() {
		return timeIndex;
	}

	public void setTimeIndex(String timeIndex) {
		this.timeIndex = timeIndex;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

	/**
	 * 扩展价格标识:CN
	 */
	public final static Integer EXPRICEFLAG_CN_PRODUCT = 1;
	/**
	 * 扩展价格标识:普通
	 */
	public final static Integer EXPRICEFLAG_CN_NOTPRODUCT = 0;


	public Long getFgcId() {
		return fgcId;
	}

	public void setFgcId(Long fgcId) {
		this.fgcId = fgcId;
	}

	public Long getSgcId() {
		return sgcId;
	}

	public void setSgcId(Long sgcId) {
		this.sgcId = sgcId;
	}

	public Long getTgcId() {
		return tgcId;
	}

	public void setTgcId(Long tgcId) {
		this.tgcId = tgcId;
	}

	public Integer getHasIntegral() {
		return hasIntegral;
	}

	public void setHasIntegral(Integer hasIntegral) {
		this.hasIntegral = hasIntegral;
	}

}