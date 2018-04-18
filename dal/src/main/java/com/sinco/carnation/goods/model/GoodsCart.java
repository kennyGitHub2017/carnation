package com.sinco.carnation.goods.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

@SuppressWarnings("serial")
public class GoodsCart extends BaseModel {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 手机端未登录用户会话id **/
	private String cartMobileId;

	/** 未登录用户会话id **/
	private String cartSessionId;

	/** 购物车状态 用户购物车状态，0表示没有提交为订单，1表示已经提交为订单，已经提交为订单信息的不再为缓存购物车，同时定时器也不进行删除操作 **/
	private Integer cartStatus;

	/** 默认为空，组合销售时为”combin” **/
	private String cartType;

	/** 是否套装主购物车 1为套装主购物车，0为其他套装 **/
	private Integer combinMain;

	/** 组合套装标识 **/
	private String combinMark;

	/** 组合套装购物车Id **/
	private String combinSuitIds;

	/** 数量 **/
	private Integer count;

	/** 价格 **/
	private BigDecimal price;

	/**  **/
	private Long goodsId;

	/** 对应的购物车用户 **/
	private Long userId;

	/**  **/
	private String cartGsp;

	/**  **/
	private String combinVersion;

	/** 是否选中了赠品 默认为0 未选择 1为已选择 **/
	private Integer whetherChooseGift;

	/** 兑换积分值，如果是0的话表示不设置积分兑购 **/
	private Integer exchangeIntegral;

	/** 商品积分兑换后的价格，无兑换显示原价 **/
	private BigDecimal goodsIntegralPrice;

	/** 手机专享价，如果不设置手机专享价则留空 **/
	private BigDecimal goodsMobilePrice;

	/** 自营增加价格 **/
	private BigDecimal selfAddPrice;

	/** 商品版本，用于确认购物车中商品是否与目前商品一致 **/
	private Integer goodsVersion;

	/** 套装购物车详情 **/
	private String combinSuitInfo;

	/** 规格内容 **/
	private String specInfo;

	/** 买就送赠品信息 **/
	private String giftInfo;

	private Integer isYgb;
	/**
	 * CN产品标示：0：不是 1：是
	 */
	private Integer exPriceFlag;

	public Integer getExPriceFlag() {
		return exPriceFlag;
	}

	public void setExPriceFlag(Integer exPriceFlag) {
		this.exPriceFlag = exPriceFlag;
	}

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

	public String getCartMobileId() {
		return cartMobileId;
	}

	public void setCartMobileId(String cartMobileId) {
		this.cartMobileId = cartMobileId;
	}

	public String getCartSessionId() {
		return cartSessionId;
	}

	public void setCartSessionId(String cartSessionId) {
		this.cartSessionId = cartSessionId;
	}

	public Integer getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(Integer cartStatus) {
		this.cartStatus = cartStatus;
	}

	public String getCartType() {
		return cartType;
	}

	public void setCartType(String cartType) {
		this.cartType = cartType;
	}

	public Integer getCombinMain() {
		return combinMain;
	}

	public void setCombinMain(Integer combinMain) {
		this.combinMain = combinMain;
	}

	public String getCombinMark() {
		return combinMark;
	}

	public void setCombinMark(String combinMark) {
		this.combinMark = combinMark;
	}

	public String getCombinSuitIds() {
		return combinSuitIds;
	}

	public void setCombinSuitIds(String combinSuitIds) {
		this.combinSuitIds = combinSuitIds;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCartGsp() {
		return cartGsp;
	}

	public void setCartGsp(String cartGsp) {
		this.cartGsp = cartGsp;
	}

	public String getCombinVersion() {
		return combinVersion;
	}

	public void setCombinVersion(String combinVersion) {
		this.combinVersion = combinVersion;
	}

	public Integer getWhetherChooseGift() {
		return whetherChooseGift;
	}

	public void setWhetherChooseGift(Integer whetherChooseGift) {
		this.whetherChooseGift = whetherChooseGift;
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

	public String getCombinSuitInfo() {
		return combinSuitInfo;
	}

	public void setCombinSuitInfo(String combinSuitInfo) {
		this.combinSuitInfo = combinSuitInfo;
	}

	public String getSpecInfo() {
		return specInfo;
	}

	public void setSpecInfo(String specInfo) {
		this.specInfo = specInfo;
	}

	public String getGiftInfo() {
		return giftInfo;
	}

	public void setGiftInfo(String giftInfo) {
		this.giftInfo = giftInfo;
	}

	public Integer getIsYgb() {
		return isYgb;
	}

	public void setIsYgb(Integer isYgb) {
		this.isYgb = isYgb;
	}

	/**
	 * CN购物车：非CN购物车
	 */
	public static final Integer EXPEICEFLAG_NO = 0;
	/**
	 * CN购物车：CN购物车
	 */
	public static final Integer EXPEICEFLAG_YES = 1;
}