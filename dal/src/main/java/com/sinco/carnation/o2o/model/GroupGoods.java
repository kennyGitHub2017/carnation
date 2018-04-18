package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class GroupGoods extends BaseModel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5189405799032320491L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 开始时间 **/
	private Date beginTime;

	/** 原价 **/
	private BigDecimal costPrice;

	/** 结束时间 **/
	private Date endTime;

	/** 商品名称 **/
	private String ggName;

	/** 团购折扣 **/
	private BigDecimal ggRebate;

	/** 用户浏览次数 **/
	private Integer ggClick;

	/** 团购类型，1为套餐券 2为代金券 **/
	private Integer goodsType;

	/**  **/
	private Integer groupCount;

	/** 团队价 **/
	private BigDecimal groupPrice;

	/** 商品状态 0为上架，1为在仓库中，2为定时自动上架，3为服务过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售 **/
	private Integer ggStatus;

	/** 团购审核状态 1为通过 -1为未通过 0为待审核 **/
	private Integer groupStatus;

	/** 是否推荐 **/
	private Boolean ggRecommend;

	/** 推荐时间 **/
	private Date ggRecommendTime;

	/** 已经售出的数量 **/
	private Integer selledCount;

	/** 团购地区id,这里地区为 city **/
	private Long ggGaId;

	/** 团购分类id **/
	private Long ggGcId;

	/** 团购图片 **/
	private String groupAccPath;

	/** 店铺id **/
	private Long storeId;

	/** 发布的用户id **/
	private Long userId;

	/** seo关键字 **/
	private String seoKeywords;

	/** seo描述 **/
	private String seoDescription;

	/** 收藏 **/
	private Integer goodsCollect;

	/** 下架原因 **/
	private String offCause;

	/** 审核拒绝原因 **/
	private String refusedReasonDesc;

	/** 服务库存预警数量 **/
	private Integer groupCountWarn;

	/** 服务返润金额 **/
	private BigDecimal groupRebateAmount;

	private String publishGoodsStatus;
	/** 购买须知 **/
	private String groupNotice;

	/**  **/
	private String groupMobileDesc;

	/** 服务描述 **/
	private String groupDesc;

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

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getGgName() {
		return ggName;
	}

	public void setGgName(String ggName) {
		this.ggName = ggName;
	}

	public BigDecimal getGgRebate() {
		return ggRebate;
	}

	public void setGgRebate(BigDecimal ggRebate) {
		this.ggRebate = ggRebate;
	}

	public Integer getGgClick() {
		return ggClick;
	}

	public void setGgClick(Integer ggClick) {
		this.ggClick = ggClick;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getGroupCount() {
		return groupCount;
	}

	public void setGroupCount(Integer groupCount) {
		this.groupCount = groupCount;
	}

	public BigDecimal getGroupPrice() {
		return groupPrice;
	}

	public void setGroupPrice(BigDecimal groupPrice) {
		this.groupPrice = groupPrice;
	}

	public Integer getGgStatus() {
		return ggStatus;
	}

	public void setGgStatus(Integer ggStatus) {
		this.ggStatus = ggStatus;
	}

	public Integer getGroupStatus() {
		return groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}

	public Boolean getGgRecommend() {
		return ggRecommend;
	}

	public void setGgRecommend(Boolean ggRecommend) {
		this.ggRecommend = ggRecommend;
	}

	public Integer getSelledCount() {
		return selledCount;
	}

	public void setSelledCount(Integer selledCount) {
		this.selledCount = selledCount;
	}

	public Long getGgGaId() {
		return ggGaId;
	}

	public void setGgGaId(Long ggGaId) {
		this.ggGaId = ggGaId;
	}

	public Long getGgGcId() {
		return ggGcId;
	}

	public void setGgGcId(Long ggGcId) {
		this.ggGcId = ggGcId;
	}

	public String getGroupAccPath() {
		return groupAccPath;
	}

	public void setGroupAccPath(String groupAccPath) {
		this.groupAccPath = groupAccPath;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public Integer getGoodsCollect() {
		return goodsCollect;
	}

	public void setGoodsCollect(Integer goodsCollect) {
		this.goodsCollect = goodsCollect;
	}

	public Integer getGroupCountWarn() {
		return groupCountWarn;
	}

	public void setGroupCountWarn(Integer groupCountWarn) {
		this.groupCountWarn = groupCountWarn;
	}

	public BigDecimal getGroupRebateAmount() {
		return groupRebateAmount;
	}

	public void setGroupRebateAmount(BigDecimal groupRebateAmount) {
		this.groupRebateAmount = groupRebateAmount;
	}

	public String getGroupNotice() {
		return groupNotice;
	}

	public void setGroupNotice(String groupNotice) {
		this.groupNotice = groupNotice;
	}

	public String getGroupMobileDesc() {
		return groupMobileDesc;
	}

	public void setGroupMobileDesc(String groupMobileDesc) {
		this.groupMobileDesc = groupMobileDesc;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public String getOffCause() {
		return offCause;
	}

	public void setOffCause(String offCause) {
		this.offCause = offCause;
	}

	public String getPublishGoodsStatus() {
		return publishGoodsStatus;
	}

	public void setPublishGoodsStatus(String publishGoodsStatus) {
		this.publishGoodsStatus = publishGoodsStatus;
	}

	public String getRefusedReasonDesc() {
		return refusedReasonDesc;
	}

	public void setRefusedReasonDesc(String refusedReasonDesc) {
		this.refusedReasonDesc = refusedReasonDesc;
	}

	public Date getGgRecommendTime() {
		return ggRecommendTime;
	}

	public void setGgRecommendTime(Date ggRecommendTime) {
		this.ggRecommendTime = ggRecommendTime;
	}

}