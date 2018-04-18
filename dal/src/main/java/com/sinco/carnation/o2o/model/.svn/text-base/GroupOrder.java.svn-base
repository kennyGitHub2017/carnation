package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class GroupOrder extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 完成时间 **/
	private Date finishTime;

	/** 商品总价格 **/
	private BigDecimal goodsAmount;

	/** 订单种类 0为商家，1为自营商品订单 **/
	private Integer orderForm;

	/** 订单号 **/
	private String orderId;

	/** 订单状态 订单状态，0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,65订单不可评价，到达设定时间，系统自动关闭订单相互评价功能 **/
	private Integer orderStatus;

	/** 订单退款数量 **/
	private Integer orderReturnCount;

	/** 订单类型，1线上订单2扫码支付3优惠买单4套餐券5代金券 **/
	private Integer orderType;

	/** 订单来源 分为web:PC网页订单，weixin:手机网页订单,android:android手机客户端订单，ios:iOS手机客户端订单 **/
	private String orderSource;

	/** 外部订单号 **/
	private String outOrderId;

	/** 截止日期 买家退款截止日期 **/
	private Date returnShipTime;

	/** 付款时间 **/
	private Date payTime;

	/** 订单对应店铺id **/
	private String storeId;

	/** 订单总价格 **/
	private BigDecimal totalPrice;

	/** 流水号 在线支付时每次随机生成唯一的号码，重复提交时替换当前订单的交易流水号 **/
	private String tradeNo;

	/** 是否为系统用户，该字段给线下刷卡订单使用 **/
	private Boolean isSysUser;

	/** 买家id **/
	private Long userId;

	/** 支付方式 **/
	private String paymentMark;

	/** 是否为移动订单 **/
	private Boolean isMobile;

	/** 用户昵称,非会员的就显示手机号码 **/
	private String userNickname;

	/** 线下服务退款状态 **/
	private Integer localReturnStatus;

	/** 线下服务名称 **/
	private String localGroupName;

	/** 优惠卷信息 **/
	private String couponInfo;

	/** 团购商品详情 生活类团购商品详情，使用json管理 **/
	private String groupInfo;

	/** 支付相关说明 支付相关说明，比如汇款账号、时间等 **/
	private String payMsg;

	/**  */
	private Long cashId;

	private BigDecimal proportion;// 返润比例(下线刷卡用)

	private Long sellerUserId;

	/**
	 * 订单原始价格
	 */
	private BigDecimal originalPrice;

	/** 服务返润金额 **/
	private BigDecimal groupRebateAmount;

	public Long getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId) {
		this.sellerUserId = sellerUserId;
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

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public BigDecimal getGoodsAmount() {
		return goodsAmount;
	}

	public void setGoodsAmount(BigDecimal goodsAmount) {
		this.goodsAmount = goodsAmount;
	}

	public Integer getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(Integer orderForm) {
		this.orderForm = orderForm;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderReturnCount() {
		return orderReturnCount;
	}

	public void setOrderReturnCount(Integer orderReturnCount) {
		this.orderReturnCount = orderReturnCount;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getOutOrderId() {
		return outOrderId;
	}

	public void setOutOrderId(String outOrderId) {
		this.outOrderId = outOrderId;
	}

	public Date getReturnShipTime() {
		return returnShipTime;
	}

	public void setReturnShipTime(Date returnShipTime) {
		this.returnShipTime = returnShipTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Boolean getIsSysUser() {
		return isSysUser;
	}

	public void setIsSysUser(Boolean isSysUser) {
		this.isSysUser = isSysUser;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPaymentMark() {
		return paymentMark;
	}

	public void setPaymentMark(String paymentMark) {
		this.paymentMark = paymentMark;
	}

	public Boolean getIsMobile() {
		return isMobile;
	}

	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getLocalGroupName() {
		return localGroupName;
	}

	public void setLocalGroupName(String localGroupName) {
		this.localGroupName = localGroupName;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getPayMsg() {
		return payMsg;
	}

	public void setPayMsg(String payMsg) {
		this.payMsg = payMsg;
	}

	public Long getCashId() {
		return cashId;
	}

	public void setCashId(Long cashId) {
		this.cashId = cashId;
	}

	public Integer getLocalReturnStatus() {
		return localReturnStatus;
	}

	public void setLocalReturnStatus(Integer localReturnStatus) {
		this.localReturnStatus = localReturnStatus;
	}

	public BigDecimal getProportion() {
		return proportion;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}

	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}

	public BigDecimal getGroupRebateAmount() {
		return groupRebateAmount;
	}

	public void setGroupRebateAmount(BigDecimal groupRebateAmount) {
		this.groupRebateAmount = groupRebateAmount;
	}

}