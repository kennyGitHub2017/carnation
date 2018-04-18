package com.sinco.carnation.goods.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

@SuppressWarnings("serial")
public class GoodsBrand extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 是否通过审核 **/
	private Integer audit;

	/** 品牌首字母 用户品牌页按照首字母筛选品牌 **/
	private String firstWord;

	/** 手机客户端推荐 **/
	private Integer mobileRecommend;

	/** 手机客户端推荐时间 **/
	private Date mobileRecommendTime;

	/** 品牌名称 **/
	private String name;

	/** 是否推荐 **/
	private Boolean recommend;

	/** 排序 用于品牌的排序 **/
	private Integer sequence;

	/** 首页显示 **/
	private Boolean showIndex;

	/** 用户身份 0为系统管理员，1为买家 **/
	private Integer userStatus;

	/** 商品logo 改为直接地址 **/
	private String brandLogoId;

	/** 品牌类别 **/
	private Long categoryId;

	/** 品牌申请店铺id **/
	private Long storeId;

	/** 对应分类 品牌对应的分类，商家发布商品时显示商家主营分类对应的品牌 **/
	private Long gcId;

	/** 微信商城推荐 推荐后在微信商城首页显示 **/
	private Integer weixinRecommend;

	/** 微信商城推荐时间 **/
	private Date weixinRecommendTime;

	/** 申请备注 **/
	private String remark;

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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public String getFirstWord() {
		return firstWord;
	}

	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}

	public Integer getMobileRecommend() {
		return mobileRecommend;
	}

	public void setMobileRecommend(Integer mobileRecommend) {
		this.mobileRecommend = mobileRecommend;
	}

	public Date getMobileRecommendTime() {
		return mobileRecommendTime;
	}

	public void setMobileRecommendTime(Date mobileRecommendTime) {
		this.mobileRecommendTime = mobileRecommendTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRecommend() {
		return recommend;
	}

	public void setRecommend(Boolean recommend) {
		this.recommend = recommend;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Boolean getShowIndex() {
		return showIndex;
	}

	public void setShowIndex(Boolean showIndex) {
		this.showIndex = showIndex;
	}

	public Integer getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}

	public String getBrandLogoId() {
		return brandLogoId;
	}

	public void setBrandLogoId(String brandLogoId) {
		this.brandLogoId = brandLogoId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Integer getWeixinRecommend() {
		return weixinRecommend;
	}

	public void setWeixinRecommend(Integer weixinRecommend) {
		this.weixinRecommend = weixinRecommend;
	}

	public Date getWeixinRecommendTime() {
		return weixinRecommendTime;
	}

	public void setWeixinRecommendTime(Date weixinRecommendTime) {
		this.weixinRecommendTime = weixinRecommendTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}