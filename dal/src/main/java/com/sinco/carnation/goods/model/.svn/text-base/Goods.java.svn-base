package com.sinco.carnation.goods.model;

import java.math.BigDecimal;
import java.util.Date;

import com.sinco.mybatis.dal.model.UniqueModel;

@SuppressWarnings("serial")
public class Goods extends UniqueModel {

	public Goods() {
	}

	public Goods(Long id) {
		this.id = id;
	}

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 活动商品id 对应的活动商品id **/
	private Long activityGoodsId;

	/** 活动状态 0为无活动，1为待审核，2为审核通过，3为活动商品已经卖完 **/
	private Integer activityStatus;

	/** 预售时间 **/
	private Date advanceDate;

	/** 是否为预售商品 **/
	private Integer advanceSaleType;

	/** 商品差评率 **/
	private BigDecimal badEvaluate;

	/** 满就送条件金额 **/
	private BigDecimal buyGiftAmount;

	/** 满就送id **/
	private Long buyGiftId;

	/** 组合配件方案id **/
	private Long combinPartsId;

	/** 组合销售商品 0为无组合销售，1为有组合销售，当该商品参加组合销售时（无论组合商品是否通过审核），该状态为1，当组合时间到期或者组合方案完全删除后该商品状态变为0 **/
	private Integer combinStatus;

	/** 组合套装方案id **/
	private Long combinSuitId;

	/** 发货地址 **/
	private String deliveryArea;

	/** 发货地址idf **/
	private Long deliveryAreaId;

	/** 商品描述评分 **/
	private Long descriptionEvaluate;

	/** ems费用 **/
	private BigDecimal emsTransFee;

	/** 是否参加满就减 **/
	private Integer enoughReduce;

	/** 快递费用 **/
	private BigDecimal expressTransFee;

	/** 是否为F码销售商品 **/
	private Integer fSaleType;

	/** 商品底部版式id **/
	private Long goodsBottomFormatId;

	/** 商品是否实体 0实体商品，1为虚拟商品 **/
	private Integer goodsChoiceType;

	/** 浏览次数 **/
	private Integer goodsClick;

	/** 是否支持货到付款 0为支持，-1为不支持 **/
	private Integer goodsCod;

	/** 收藏次数 **/
	private Integer goodsCollect;

	/** 是否有积分兑换价格 */
	private Boolean hasExchangeIntegral;
	/** 兑换积分值，如果是0的话表示不设置积分兑购（适用于全局设置） **/
	private Integer exchangeIntegral;
	/** 商品积分兑换后的价格，无兑换显示原价（适用于全局设置） **/
	private BigDecimal goodsIntegralPrice;
	/** 是否有手机专享价 */
	private Boolean hasMobilePrice;
	/** 手机专享价，如果不设置手机专享价则留空（适用于全局设置） **/
	private BigDecimal goodsMobilePrice;
	/** 自营增加价格，紧紧用于显示在新增的时候已经将价格添加到goodscurrentprice */
	private BigDecimal selfAddPrice;

	/** 商品当前价格 **/
	private BigDecimal goodsCurrentPrice;

	/** 运费 **/
	private String goodsFee;

	/** 库存数量 **/
	private Integer goodsInventory;

	/** 兑换时的支付方式 **/
	private String goodsName;

	/** 兑换时的人民币数，只接受整数兑换 **/
	private BigDecimal goodsPrice;

	/** 是否推荐 **/
	private Boolean goodsRecommend;

	/** 商品售出数量 **/
	private Integer goodsSalenum;

	/** 上架时间 系统根据商品上架时间倒序排列 **/
	private Date goodsSellerTime;

	/** 商品货号 **/
	private String goodsSerial;

	/** 商品状态 0为上架，1为在仓库中，2为定时自动上架，3为店铺过期自动下架，-1为手动下架状态，-2为违规下架状态,-3被举报禁售 **/
	private Integer goodsStatus;

	/** 商品顶部版式id **/
	private Long goodsTopFormatId;

	/** 商品运费承担方式 0为买家承担，1为卖家承担 **/
	private Integer goodsTransfee;

	/** 商品类型 0为自营商品，1为第三方经销商 **/
	private Integer goodsType;

	/** 商品体积 **/
	private BigDecimal goodsVolume;

	/** 商品库存预警数量 **/
	private Integer goodsWarnInventory;

	/** 商品重量 **/
	private BigDecimal goodsWeight;

	/** 团购状态 **/
	private Integer groupBuy;

	/** 库存方式 All为全局库存，spec按规格库存 **/
	private String inventoryType;

	/** 平邮费用 **/
	private BigDecimal mailTransFee;

	/** 商品中评率 **/
	private BigDecimal middleEvaluate;

	/** 手机客户端热卖 **/
	private Integer mobileHot;

	/** 手机热卖时间 **/
	private Date mobileHottime;

	/** 手机客户端推荐 **/
	private Integer mobileRecommend;

	/** 手机推荐时间 **/
	private Date mobileRecommendtime;

	/** 满就送状态 **/
	private Integer orderEnoughGiveStatus;

	/** 是否是满就送 **/
	private Integer orderEnoughIfGive;

	/** 对应满就减的id **/
	private String orderEnoughReduceId;

	/** 纪录每次商品价格变动时的价格 **/
	private BigDecimal priceHistory;

	/** 审核状态 0为发布后上架，1为发布后在仓库中，2为发布后定时自动上架，平台审核商品后根据该字段设定商品当前状态 **/
	private Integer publishGoodsStatus;

	/** 商品二维码 **/
	private String qrImgPath;

	/** 用于记录本页面商品的关键字，多个关键字间请用半角逗号 "," 隔开 **/
	private String seoKeywords;

	/** 店铺价格 **/
	private BigDecimal storePrice;

	/** 商城推荐 **/
	private Boolean storeRecommend;

	/** 推荐时间 **/
	private Date storeRecommendTime;

	/** 是否支持增值税发票 **/
	private Integer taxInvoice;

	/** 预警状态 **/
	private Integer warnInventoryStatus;

	/** 商品好评率 **/
	private BigDecimal wellEvaluate;

	/** 是否有0元购 **/
	private Integer whetherFree;

	/** 直通车申请时间 **/
	private Date ztcApplyTime;

	/** 直通车开始时间 **/
	private Date ztcBeginTime;

	/** 直通车商品浏览数 **/
	private Integer ztcClickNum;

	/** 已经开通的直通车价格,和ztc_price值一样 由系统定制器控制该值，在用户设定的开始日期后该值才会存在 **/
	private Integer ztcDredgePrice;

	/** 直通车开通金币 扣除完以后自动取消直通车状态 **/
	private Integer ztcGold;

	/** 直通车金币支付状态1为支付成功，0为待支付 **/
	private Integer ztcPayStatus;

	/** 直通车价格 按照金币计算，单位为个 **/
	private Integer ztcPrice;

	/** 直通车状态 1为开通申请待审核，2为审核通过,-1为审核失败,3为已经开通 **/
	private Integer ztcStatus;

	/** 商品对应的大分类 **/
	private Long gcId;

	/** 商品品牌 **/
	private Long goodsBrandId;

	/** 商品主图片 **/
	private String goodsMainPhotoPath;

	/** 所属店铺 **/
	private Long goodsStoreId;

	/** 商品对应的团购 **/
	private Long groupId;

	/** 调用的运费模板 **/
	private Long transportId;

	/** 商品发布管理员 当商品为自营商品时，商品发布的管理员 **/
	private Long userAdminId;

	/** 直通车审核管理员 **/
	private Long ztcAdminId;

	/** 评论数 **/
	private Integer evaluateCount;

	/** 微信商城热卖 **/
	private Integer weixinHot;

	/** 微信商城热卖时间 **/
	private Date weixinHottime;

	/** 微信商城推荐 推荐后在微信商城首页显示，（预留字段） **/
	private Integer weixinRecommend;

	/** 微信商城推荐时间 **/
	private Date weixinRecommendtime;

	/** 商品底部版式内容 **/
	private String goodsBottomFormatContent;

	/** 详细说明 **/
	private String goodsDetails;

	/** F码信息 **/
	private String goodsFCode;

	/** 商品规格详细库存 **/
	private String goodsInventoryDetail;

	/** 商品属性 **/
	private String goodsProperty;

	/** 商品售后保障 **/
	private String goodsService;

	/**  **/
	private String goodsTopFormatContent;

	/** 商品包装清单 **/
	private String packDetails;

	/** 用于记录本页面商品的描述 **/
	private String seoDescription;

	/** 直通车审核信息 **/
	private String ztcAdminContent;

	/** 详细说明app **/
	private String goodsDetailsMobile;

	/** 商品当前加价金额 **/
	private BigDecimal goodsCommissionAmount;

	/** 商品标签 **/
	private String goodsTarget;

	/** 商品排序权重，降序排序，越大排在越前 */
	private Integer sortWeight;

	/** 商品推荐长方形图片 **/
	private String goodsIndexPhotoPath;

	/** 是否是云购币 **/
	private Integer isYgb;
	private BigDecimal needMoney;
	private BigDecimal needYgb;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 自营增加价格记录
	 */
	private BigDecimal selfAddPriceLog;
	/**
	 * 扩展价格标识 1CN
	 */
	private Integer exPriceFlag;
	/**
	 * CN会员平台加价
	 */
	private BigDecimal cnSelfAddPrice;
	
	/**
	 * 需要的积分-精品专区
	 */
	private BigDecimal needIntegral;
	private BigDecimal goodsShowPrice;
	
	private Integer isJuanpi; //是否是卷皮商品

	public BigDecimal getSelfAddPriceLog() {
		return selfAddPriceLog;
	}

	public void setSelfAddPriceLog(BigDecimal selfAddPriceLog) {
		this.selfAddPriceLog = selfAddPriceLog;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSortWeight() {
		return sortWeight;
	}

	public void setSortWeight(Integer sortWeight) {
		this.sortWeight = sortWeight;
	}

	public String getGoodsTarget() {
		return goodsTarget;
	}

	public void setGoodsTarget(String goodsTarget) {
		this.goodsTarget = goodsTarget;
	}

	public BigDecimal getGoodsCommissionAmount() {
		return goodsCommissionAmount;
	}

	public void setGoodsCommissionAmount(BigDecimal goodsCommissionAmount) {
		this.goodsCommissionAmount = goodsCommissionAmount;
	}

	/**
	 * 商品版本
	 */
	private Integer goodsVersion;

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

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getActivityGoodsId() {
		return activityGoodsId;
	}

	public void setActivityGoodsId(Long activityGoodsId) {
		this.activityGoodsId = activityGoodsId;
	}

	public Integer getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(Integer activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Date getAdvanceDate() {
		return advanceDate;
	}

	public void setAdvanceDate(Date advanceDate) {
		this.advanceDate = advanceDate;
	}

	public Integer getAdvanceSaleType() {
		return advanceSaleType;
	}

	public void setAdvanceSaleType(Integer advanceSaleType) {
		this.advanceSaleType = advanceSaleType;
	}

	public BigDecimal getBadEvaluate() {
		return badEvaluate;
	}

	public void setBadEvaluate(BigDecimal badEvaluate) {
		this.badEvaluate = badEvaluate;
	}

	public BigDecimal getBuyGiftAmount() {
		return buyGiftAmount;
	}

	public void setBuyGiftAmount(BigDecimal buyGiftAmount) {
		this.buyGiftAmount = buyGiftAmount;
	}

	public Long getBuyGiftId() {
		return buyGiftId;
	}

	public void setBuyGiftId(Long buyGiftId) {
		this.buyGiftId = buyGiftId;
	}

	public Long getCombinPartsId() {
		return combinPartsId;
	}

	public void setCombinPartsId(Long combinPartsId) {
		this.combinPartsId = combinPartsId;
	}

	public Integer getCombinStatus() {
		return combinStatus;
	}

	public void setCombinStatus(Integer combinStatus) {
		this.combinStatus = combinStatus;
	}

	public Long getCombinSuitId() {
		return combinSuitId;
	}

	public void setCombinSuitId(Long combinSuitId) {
		this.combinSuitId = combinSuitId;
	}

	public String getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	public Long getDeliveryAreaId() {
		return deliveryAreaId;
	}

	public void setDeliveryAreaId(Long deliveryAreaId) {
		this.deliveryAreaId = deliveryAreaId;
	}

	public Long getDescriptionEvaluate() {
		return descriptionEvaluate;
	}

	public void setDescriptionEvaluate(Long descriptionEvaluate) {
		this.descriptionEvaluate = descriptionEvaluate;
	}

	public BigDecimal getEmsTransFee() {
		return emsTransFee;
	}

	public void setEmsTransFee(BigDecimal emsTransFee) {
		this.emsTransFee = emsTransFee;
	}

	public Integer getEnoughReduce() {
		return enoughReduce;
	}

	public void setEnoughReduce(Integer enoughReduce) {
		this.enoughReduce = enoughReduce;
	}

	public BigDecimal getExpressTransFee() {
		return expressTransFee;
	}

	public void setExpressTransFee(BigDecimal expressTransFee) {
		this.expressTransFee = expressTransFee;
	}

	public Integer getfSaleType() {
		return fSaleType;
	}

	public void setfSaleType(Integer fSaleType) {
		this.fSaleType = fSaleType;
	}

	public Long getGoodsBottomFormatId() {
		return goodsBottomFormatId;
	}

	public void setGoodsBottomFormatId(Long goodsBottomFormatId) {
		this.goodsBottomFormatId = goodsBottomFormatId;
	}

	public Integer getGoodsChoiceType() {
		return goodsChoiceType;
	}

	public void setGoodsChoiceType(Integer goodsChoiceType) {
		this.goodsChoiceType = goodsChoiceType;
	}

	public Integer getGoodsClick() {
		return goodsClick;
	}

	public void setGoodsClick(Integer goodsClick) {
		this.goodsClick = goodsClick;
	}

	public Integer getGoodsCod() {
		return goodsCod;
	}

	public void setGoodsCod(Integer goodsCod) {
		this.goodsCod = goodsCod;
	}

	public Integer getGoodsCollect() {
		return goodsCollect;
	}

	public void setGoodsCollect(Integer goodsCollect) {
		this.goodsCollect = goodsCollect;
	}

	public BigDecimal getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public String getGoodsFee() {
		return goodsFee;
	}

	public void setGoodsFee(String goodsFee) {
		this.goodsFee = goodsFee;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Boolean getGoodsRecommend() {
		return goodsRecommend;
	}

	public void setGoodsRecommend(Boolean goodsRecommend) {
		this.goodsRecommend = goodsRecommend;
	}

	public Integer getGoodsSalenum() {
		return goodsSalenum;
	}

	public void setGoodsSalenum(Integer goodsSalenum) {
		this.goodsSalenum = goodsSalenum;
	}

	public Date getGoodsSellerTime() {
		return goodsSellerTime;
	}

	public void setGoodsSellerTime(Date goodsSellerTime) {
		this.goodsSellerTime = goodsSellerTime;
	}

	public String getGoodsSerial() {
		return goodsSerial;
	}

	public void setGoodsSerial(String goodsSerial) {
		this.goodsSerial = goodsSerial;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public Long getGoodsTopFormatId() {
		return goodsTopFormatId;
	}

	public void setGoodsTopFormatId(Long goodsTopFormatId) {
		this.goodsTopFormatId = goodsTopFormatId;
	}

	public Integer getGoodsTransfee() {
		return goodsTransfee;
	}

	public void setGoodsTransfee(Integer goodsTransfee) {
		this.goodsTransfee = goodsTransfee;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public BigDecimal getGoodsVolume() {
		return goodsVolume;
	}

	public void setGoodsVolume(BigDecimal goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public Integer getGoodsWarnInventory() {
		return goodsWarnInventory;
	}

	public void setGoodsWarnInventory(Integer goodsWarnInventory) {
		this.goodsWarnInventory = goodsWarnInventory;
	}

	public BigDecimal getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(BigDecimal goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public Integer getGroupBuy() {
		return groupBuy;
	}

	public void setGroupBuy(Integer groupBuy) {
		this.groupBuy = groupBuy;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public BigDecimal getMailTransFee() {
		return mailTransFee;
	}

	public void setMailTransFee(BigDecimal mailTransFee) {
		this.mailTransFee = mailTransFee;
	}

	public BigDecimal getMiddleEvaluate() {
		return middleEvaluate;
	}

	public void setMiddleEvaluate(BigDecimal middleEvaluate) {
		this.middleEvaluate = middleEvaluate;
	}

	public Integer getMobileHot() {
		return mobileHot;
	}

	public void setMobileHot(Integer mobileHot) {
		this.mobileHot = mobileHot;
	}

	public Date getMobileHottime() {
		return mobileHottime;
	}

	public void setMobileHottime(Date mobileHottime) {
		this.mobileHottime = mobileHottime;
	}

	public Integer getMobileRecommend() {
		return mobileRecommend;
	}

	public void setMobileRecommend(Integer mobileRecommend) {
		this.mobileRecommend = mobileRecommend;
	}

	public Date getMobileRecommendtime() {
		return mobileRecommendtime;
	}

	public void setMobileRecommendtime(Date mobileRecommendtime) {
		this.mobileRecommendtime = mobileRecommendtime;
	}

	public Integer getOrderEnoughGiveStatus() {
		return orderEnoughGiveStatus;
	}

	public void setOrderEnoughGiveStatus(Integer orderEnoughGiveStatus) {
		this.orderEnoughGiveStatus = orderEnoughGiveStatus;
	}

	public Integer getOrderEnoughIfGive() {
		return orderEnoughIfGive;
	}

	public void setOrderEnoughIfGive(Integer orderEnoughIfGive) {
		this.orderEnoughIfGive = orderEnoughIfGive;
	}

	public String getOrderEnoughReduceId() {
		return orderEnoughReduceId;
	}

	public void setOrderEnoughReduceId(String orderEnoughReduceId) {
		this.orderEnoughReduceId = orderEnoughReduceId;
	}

	public BigDecimal getPriceHistory() {
		return priceHistory;
	}

	public void setPriceHistory(BigDecimal priceHistory) {
		this.priceHistory = priceHistory;
	}

	public Integer getPublishGoodsStatus() {
		return publishGoodsStatus;
	}

	public void setPublishGoodsStatus(Integer publishGoodsStatus) {
		this.publishGoodsStatus = publishGoodsStatus;
	}

	public String getQrImgPath() {
		return qrImgPath;
	}

	public void setQrImgPath(String qrImgPath) {
		this.qrImgPath = qrImgPath;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public BigDecimal getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(BigDecimal storePrice) {
		this.storePrice = storePrice;
	}

	public Boolean getStoreRecommend() {
		return storeRecommend;
	}

	public void setStoreRecommend(Boolean storeRecommend) {
		this.storeRecommend = storeRecommend;
	}

	public Date getStoreRecommendTime() {
		return storeRecommendTime;
	}

	public void setStoreRecommendTime(Date storeRecommendTime) {
		this.storeRecommendTime = storeRecommendTime;
	}

	public Integer getTaxInvoice() {
		return taxInvoice;
	}

	public void setTaxInvoice(Integer taxInvoice) {
		this.taxInvoice = taxInvoice;
	}

	public Integer getWarnInventoryStatus() {
		return warnInventoryStatus;
	}

	public void setWarnInventoryStatus(Integer warnInventoryStatus) {
		this.warnInventoryStatus = warnInventoryStatus;
	}

	public BigDecimal getWellEvaluate() {
		return wellEvaluate;
	}

	public void setWellEvaluate(BigDecimal wellEvaluate) {
		this.wellEvaluate = wellEvaluate;
	}

	public Integer getWhetherFree() {
		return whetherFree;
	}

	public void setWhetherFree(Integer whetherFree) {
		this.whetherFree = whetherFree;
	}

	public Date getZtcApplyTime() {
		return ztcApplyTime;
	}

	public void setZtcApplyTime(Date ztcApplyTime) {
		this.ztcApplyTime = ztcApplyTime;
	}

	public Date getZtcBeginTime() {
		return ztcBeginTime;
	}

	public void setZtcBeginTime(Date ztcBeginTime) {
		this.ztcBeginTime = ztcBeginTime;
	}

	public Integer getZtcClickNum() {
		return ztcClickNum;
	}

	public void setZtcClickNum(Integer ztcClickNum) {
		this.ztcClickNum = ztcClickNum;
	}

	public Integer getZtcDredgePrice() {
		return ztcDredgePrice;
	}

	public void setZtcDredgePrice(Integer ztcDredgePrice) {
		this.ztcDredgePrice = ztcDredgePrice;
	}

	public Integer getZtcGold() {
		return ztcGold;
	}

	public void setZtcGold(Integer ztcGold) {
		this.ztcGold = ztcGold;
	}

	public Integer getZtcPayStatus() {
		return ztcPayStatus;
	}

	public void setZtcPayStatus(Integer ztcPayStatus) {
		this.ztcPayStatus = ztcPayStatus;
	}

	public Integer getZtcPrice() {
		return ztcPrice;
	}

	public void setZtcPrice(Integer ztcPrice) {
		this.ztcPrice = ztcPrice;
	}

	public Integer getZtcStatus() {
		return ztcStatus;
	}

	public void setZtcStatus(Integer ztcStatus) {
		this.ztcStatus = ztcStatus;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Long getGoodsBrandId() {
		return goodsBrandId;
	}

	public void setGoodsBrandId(Long goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}

	public String getGoodsMainPhotoPath() {
		return goodsMainPhotoPath;
	}

	public void setGoodsMainPhotoPath(String goodsMainPhotoPath) {
		this.goodsMainPhotoPath = goodsMainPhotoPath;
	}

	public Long getGoodsStoreId() {
		return goodsStoreId;
	}

	public void setGoodsStoreId(Long goodsStoreId) {
		this.goodsStoreId = goodsStoreId;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getTransportId() {
		return transportId;
	}

	public void setTransportId(Long transportId) {
		this.transportId = transportId;
	}

	public Long getUserAdminId() {
		return userAdminId;
	}

	public void setUserAdminId(Long userAdminId) {
		this.userAdminId = userAdminId;
	}

	public Long getZtcAdminId() {
		return ztcAdminId;
	}

	public void setZtcAdminId(Long ztcAdminId) {
		this.ztcAdminId = ztcAdminId;
	}

	public Integer getEvaluateCount() {
		return evaluateCount;
	}

	public void setEvaluateCount(Integer evaluateCount) {
		this.evaluateCount = evaluateCount;
	}

	public Integer getWeixinHot() {
		return weixinHot;
	}

	public void setWeixinHot(Integer weixinHot) {
		this.weixinHot = weixinHot;
	}

	public Date getWeixinHottime() {
		return weixinHottime;
	}

	public void setWeixinHottime(Date weixinHottime) {
		this.weixinHottime = weixinHottime;
	}

	public Integer getWeixinRecommend() {
		return weixinRecommend;
	}

	public void setWeixinRecommend(Integer weixinRecommend) {
		this.weixinRecommend = weixinRecommend;
	}

	public Date getWeixinRecommendtime() {
		return weixinRecommendtime;
	}

	public void setWeixinRecommendtime(Date weixinRecommendtime) {
		this.weixinRecommendtime = weixinRecommendtime;
	}

	public String getGoodsBottomFormatContent() {
		return goodsBottomFormatContent;
	}

	public void setGoodsBottomFormatContent(String goodsBottomFormatContent) {
		this.goodsBottomFormatContent = goodsBottomFormatContent;
	}

	public String getGoodsDetails() {
		return goodsDetails;
	}

	public void setGoodsDetails(String goodsDetails) {
		this.goodsDetails = goodsDetails;
	}

	public String getGoodsFCode() {
		return goodsFCode;
	}

	public void setGoodsFCode(String goodsFCode) {
		this.goodsFCode = goodsFCode;
	}

	public String getGoodsInventoryDetail() {
		return goodsInventoryDetail;
	}

	public void setGoodsInventoryDetail(String goodsInventoryDetail) {
		this.goodsInventoryDetail = goodsInventoryDetail;
	}

	public String getGoodsProperty() {
		return goodsProperty;
	}

	public void setGoodsProperty(String goodsProperty) {
		this.goodsProperty = goodsProperty;
	}

	public String getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(String goodsService) {
		this.goodsService = goodsService;
	}

	public String getGoodsTopFormatContent() {
		return goodsTopFormatContent;
	}

	public void setGoodsTopFormatContent(String goodsTopFormatContent) {
		this.goodsTopFormatContent = goodsTopFormatContent;
	}

	public String getPackDetails() {
		return packDetails;
	}

	public void setPackDetails(String packDetails) {
		this.packDetails = packDetails;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}

	public String getZtcAdminContent() {
		return ztcAdminContent;
	}

	public void setZtcAdminContent(String ztcAdminContent) {
		this.ztcAdminContent = ztcAdminContent;
	}

	public String getGoodsDetailsMobile() {
		return goodsDetailsMobile;
	}

	public void setGoodsDetailsMobile(String goodsDetailsMobile) {
		this.goodsDetailsMobile = goodsDetailsMobile;
	}

	public Integer getExchangeIntegral() {
		return exchangeIntegral;
	}

	public void setExchangeIntegral(Integer exchangeIntegral) {
		this.exchangeIntegral = exchangeIntegral;
	}

	public BigDecimal getGoodsIntegralPrice() {
		return goodsIntegralPrice;
	}

	public void setGoodsIntegralPrice(BigDecimal goodsIntegralPrice) {
		this.goodsIntegralPrice = goodsIntegralPrice;
	}

	public BigDecimal getGoodsMobilePrice() {
		return goodsMobilePrice;
	}

	public void setGoodsMobilePrice(BigDecimal goodsMobilePrice) {
		this.goodsMobilePrice = goodsMobilePrice;
	}

	public Boolean getHasExchangeIntegral() {
		return hasExchangeIntegral;
	}

	public void setHasExchangeIntegral(Boolean hasExchangeIntegral) {
		this.hasExchangeIntegral = hasExchangeIntegral;
	}

	public Boolean getHasMobilePrice() {
		return hasMobilePrice;
	}

	public void setHasMobilePrice(Boolean hasMobilePrice) {
		this.hasMobilePrice = hasMobilePrice;
	}

	public BigDecimal getSelfAddPrice() {
		return selfAddPrice;
	}

	public void setSelfAddPrice(BigDecimal selfAddPrice) {
		this.selfAddPrice = selfAddPrice;
	}

	public Integer getGoodsVersion() {
		return goodsVersion;
	}

	public void setGoodsVersion(Integer goodsVersion) {
		this.goodsVersion = goodsVersion;
	}

	@Override
	public Object getUniqueCode() {
		return this.getId();
	}

	public String getGoodsIndexPhotoPath() {
		return goodsIndexPhotoPath;
	}

	public void setGoodsIndexPhotoPath(String goodsIndexPhotoPath) {
		this.goodsIndexPhotoPath = goodsIndexPhotoPath;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

	public BigDecimal getNeedMoney() {
		return needMoney;
	}

	public void setNeedMoney(BigDecimal needMoney) {
		this.needMoney = needMoney;
	}

	public BigDecimal getNeedYgb() {
		return needYgb;
	}

	public void setNeedYgb(BigDecimal needYgb) {
		this.needYgb = needYgb;
	}

	public Integer getExPriceFlag() {
		return exPriceFlag;
	}

	public void setExPriceFlag(Integer exPriceFlag) {
		this.exPriceFlag = exPriceFlag;
	}

	public BigDecimal getCnSelfAddPrice() {
		return cnSelfAddPrice;
	}

	public void setCnSelfAddPrice(BigDecimal cnSelfAddPrice) {
		this.cnSelfAddPrice = cnSelfAddPrice;
	}

	public BigDecimal getNeedIntegral() {
		return needIntegral;
	}

	public void setNeedIntegral(BigDecimal needIntegral) {
		this.needIntegral = needIntegral;
	}

	public BigDecimal getGoodsShowPrice() {
		return goodsShowPrice;
	}

	public void setGoodsShowPrice(BigDecimal goodsShowPrice) {
		this.goodsShowPrice = goodsShowPrice;
	}

	public Integer getIsJuanpi() {
		return isJuanpi;
	}

	public void setIsJuanpi(Integer isJuanpi) {
		this.isJuanpi = isJuanpi;
	}

}