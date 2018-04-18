package com.sinco.carnation.shop.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderFormVO {

	private String beginTime;
	private String endTime;
	private String buyerUsername;
	private String orderStatus;

	private String type;
	private String typeData;
	private String payment;
	private String beginPrice;
	private String endPrice;
	private Integer orderStatusNum;

	private String orderByClause;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 邮件提示 **/
	private Boolean autoConfirmEmail;

	/** 自动收款的短信提示 **/
	private Boolean autoConfirmSms;

	/** 佣金总费用 **/
	private BigDecimal commissionAmount;

	/** 确认收货时间 **/
	private Date confirmTime;

	/** 自提点id **/
	private Long deliveryAddressId;

	/** 快递配送时间 快递配送时间，给商家发货时候使用 **/
	private String deliveryTime;

	/** 快递配送方式 配送方式，0为快递配送，1为自提点自提 **/
	private Integer deliveryType;

	/** 满就减金额 **/
	private BigDecimal enoughReduceAmount;

	/** 确认发货管理员id **/
	private Long evaUserId;

	/** 完成时间 **/
	private Date finishTime;

	/** 商品总价格 **/
	private BigDecimal goodsAmount;

	/** 发票信息 **/
	private String invoice;

	/** 发票类型0为个人，1为单位 **/
	private Integer invoiceType;

	/** 商家手动调整费用次数 商家手动调整费用次数，0为未调整过，用于显示调整过订单费用的账单显示 **/
	private Integer operationPriceCount;

	/** 订单分类 0为购物订单，1为手机充值订单，2为生活类团购订单 **/
	private Integer orderCat;

	/** 收货时间延长 **/
	private Integer orderConfirmDelay;

	/** 订单种类 0为商家，1为自营商品订单 **/
	private Integer orderForm;

	/** 订单号 **/
	private String orderId;

	/** 是否为主订单 1为主订单，主订单用在买家用户中心显示订单内容 **/
	private Integer orderMain;

	/**
	 * 订单状态 订单状态，0为订单取消，10为已提交待付款，15为线下付款提交申请，16为货到付款，20为已付款待发货，30为已发货待收货，40为已收货，50买家评价完毕
	 * ,65订单不可评价，到达设定时间，系统自动关闭订单相互评价功能
	 **/
//    private Integer orderStatus;

	/** 订单类型 分为web:PC网页订单，weixin:手机网页订单,android:android手机客户端订单，ios:iOS手机客户端订单 **/
	private String orderType;

	/** 外部订单号 **/
	private String outOrderId;

	/** 第三方平台收取费用 充值rc_amount金额第三方平台收取的价格，通过接口自动获取 **/
	private BigDecimal outPrice;

	/** 付款时间 **/
	private Date payTime;

	/** 支持类型 **/
	private String payType;

	/** 充值金额 **/
	private Integer rcAmount;

	/** 手机充值号 **/
	private String rcMobile;

	/** 需要缴纳的费用 充值rc_amount金额需要缴纳的费用 **/
	private BigDecimal rcPrice;

	/** 充值类型 默认为mobile，手机直充，目前仅支持该类型 **/
	private String rcType;

	/** 收货人姓名 **/
	private String receiverName;

	/** 收货人地区 **/
	private String receiverArea;

	/** 收货人详细地址 **/
	private String receiverAreaInfo;

	/** 收货人手机号码 **/
	private String receiverMobile;

	/** 联系电话 **/
	private String receiverTelephone;

	/** 收货人邮编 **/
	private String receiverZip;

	/** 截止日期 买家退货发货截止日期 **/
	private Date returnShipTime;

	/** 物流单号 **/
	private String shipCode;

	/** 发货时间 **/
	private Date shipTime;

	/** 发货地址id **/
	private Long shipAddrId;

	/** 配送价格 **/
	private BigDecimal shipPrice;

	/** 订单对应店铺id **/
	private String storeId;

	/** 订单对应店铺名称 **/
	private String storeName;

	/** 订单总价格 **/
	private BigDecimal totalPrice;

	/** 流水号 在线支付时每次随机生成唯一的号码，重复提交时替换当前订单的交易流水号 **/
	private String tradeNo;

	/** 配送方式 **/
	private String transport;

	/** 买家id **/
	private Long userId;

	/** 买家姓名 **/
	private String userName;

	/** 是否有满就送活动 0为没有，1为有 **/
	private Integer whetherGift;

	/** 支付方式 **/
	private Long paymentId;

	/** 子订单 **/
	private String childOrderDetail;

	/** 优惠卷信息 **/
	private String couponInfo;

	/** 自提点信息 **/
	private String deliveryInfo;

	/** 订单中参加满就减 **/
	private String enoughReduceInfo;

	/** 物流公司信息 物流公司信息，使用json管理 **/
	private String expressInfo;

	/** 满就送商品信息 **/
	private String giftInfos;

	/** 订单商品详情 订单商品信息，使用json管理 **/
	private String goodsInfo;

	/** 生活类团购商品详情 生活类团购商品详情，使用json管理 **/
	private String groupInfo;

	/** 订单附言 **/
	private String msg;

	/** 订单卖家给说明 **/
	private String orderSellerIntro;

	/** 支付相关说明 支付相关说明，比如汇款账号、时间等 **/
	private String payMsg;

	/** 退货商品详情 退货商品信息，使用json管理 **/
	private String returnGoodsInfo;

	/** 发货详细地址 **/
	private String shipAddr;
	private Boolean isygOrder; // 是否是云购币订单
	private Integer orderTypeFlag;

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getBuyerUsername() {
		return buyerUsername;
	}

	public void setBuyerUsername(String buyerUsername) {
		this.buyerUsername = buyerUsername;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	public Boolean getAutoConfirmEmail() {
		return autoConfirmEmail;
	}

	public void setAutoConfirmEmail(Boolean autoConfirmEmail) {
		this.autoConfirmEmail = autoConfirmEmail;
	}

	public Boolean getAutoConfirmSms() {
		return autoConfirmSms;
	}

	public void setAutoConfirmSms(Boolean autoConfirmSms) {
		this.autoConfirmSms = autoConfirmSms;
	}

	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
	}

	public Long getDeliveryAddressId() {
		return deliveryAddressId;
	}

	public void setDeliveryAddressId(Long deliveryAddressId) {
		this.deliveryAddressId = deliveryAddressId;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public Integer getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(Integer deliveryType) {
		this.deliveryType = deliveryType;
	}

	public BigDecimal getEnoughReduceAmount() {
		return enoughReduceAmount;
	}

	public void setEnoughReduceAmount(BigDecimal enoughReduceAmount) {
		this.enoughReduceAmount = enoughReduceAmount;
	}

	public Long getEvaUserId() {
		return evaUserId;
	}

	public void setEvaUserId(Long evaUserId) {
		this.evaUserId = evaUserId;
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

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public Integer getOperationPriceCount() {
		return operationPriceCount;
	}

	public void setOperationPriceCount(Integer operationPriceCount) {
		this.operationPriceCount = operationPriceCount;
	}

	public Integer getOrderCat() {
		return orderCat;
	}

	public void setOrderCat(Integer orderCat) {
		this.orderCat = orderCat;
	}

	public Integer getOrderConfirmDelay() {
		return orderConfirmDelay;
	}

	public void setOrderConfirmDelay(Integer orderConfirmDelay) {
		this.orderConfirmDelay = orderConfirmDelay;
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

	public Integer getOrderMain() {
		return orderMain;
	}

	public void setOrderMain(Integer orderMain) {
		this.orderMain = orderMain;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOutOrderId() {
		return outOrderId;
	}

	public void setOutOrderId(String outOrderId) {
		this.outOrderId = outOrderId;
	}

	public BigDecimal getOutPrice() {
		return outPrice;
	}

	public void setOutPrice(BigDecimal outPrice) {
		this.outPrice = outPrice;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getRcAmount() {
		return rcAmount;
	}

	public void setRcAmount(Integer rcAmount) {
		this.rcAmount = rcAmount;
	}

	public String getRcMobile() {
		return rcMobile;
	}

	public void setRcMobile(String rcMobile) {
		this.rcMobile = rcMobile;
	}

	public BigDecimal getRcPrice() {
		return rcPrice;
	}

	public void setRcPrice(BigDecimal rcPrice) {
		this.rcPrice = rcPrice;
	}

	public String getRcType() {
		return rcType;
	}

	public void setRcType(String rcType) {
		this.rcType = rcType;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverArea() {
		return receiverArea;
	}

	public void setReceiverArea(String receiverArea) {
		this.receiverArea = receiverArea;
	}

	public String getReceiverAreaInfo() {
		return receiverAreaInfo;
	}

	public void setReceiverAreaInfo(String receiverAreaInfo) {
		this.receiverAreaInfo = receiverAreaInfo;
	}

	public String getReceiverMobile() {
		return receiverMobile;
	}

	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}

	public String getReceiverTelephone() {
		return receiverTelephone;
	}

	public void setReceiverTelephone(String receiverTelephone) {
		this.receiverTelephone = receiverTelephone;
	}

	public String getReceiverZip() {
		return receiverZip;
	}

	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}

	public Date getReturnShipTime() {
		return returnShipTime;
	}

	public void setReturnShipTime(Date returnShipTime) {
		this.returnShipTime = returnShipTime;
	}

	public String getShipCode() {
		return shipCode;
	}

	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}

	public Date getShipTime() {
		return shipTime;
	}

	public void setShipTime(Date shipTime) {
		this.shipTime = shipTime;
	}

	public Long getShipAddrId() {
		return shipAddrId;
	}

	public void setShipAddrId(Long shipAddrId) {
		this.shipAddrId = shipAddrId;
	}

	public BigDecimal getShipPrice() {
		return shipPrice;
	}

	public void setShipPrice(BigDecimal shipPrice) {
		this.shipPrice = shipPrice;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getWhetherGift() {
		return whetherGift;
	}

	public void setWhetherGift(Integer whetherGift) {
		this.whetherGift = whetherGift;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getChildOrderDetail() {
		return childOrderDetail;
	}

	public void setChildOrderDetail(String childOrderDetail) {
		this.childOrderDetail = childOrderDetail;
	}

	public String getCouponInfo() {
		return couponInfo;
	}

	public void setCouponInfo(String couponInfo) {
		this.couponInfo = couponInfo;
	}

	public String getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(String deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public String getEnoughReduceInfo() {
		return enoughReduceInfo;
	}

	public void setEnoughReduceInfo(String enoughReduceInfo) {
		this.enoughReduceInfo = enoughReduceInfo;
	}

	public String getExpressInfo() {
		return expressInfo;
	}

	public void setExpressInfo(String expressInfo) {
		this.expressInfo = expressInfo;
	}

	public String getGiftInfos() {
		return giftInfos;
	}

	public void setGiftInfos(String giftInfos) {
		this.giftInfos = giftInfos;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getGroupInfo() {
		return groupInfo;
	}

	public void setGroupInfo(String groupInfo) {
		this.groupInfo = groupInfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getOrderSellerIntro() {
		return orderSellerIntro;
	}

	public void setOrderSellerIntro(String orderSellerIntro) {
		this.orderSellerIntro = orderSellerIntro;
	}

	public String getPayMsg() {
		return payMsg;
	}

	public void setPayMsg(String payMsg) {
		this.payMsg = payMsg;
	}

	public String getReturnGoodsInfo() {
		return returnGoodsInfo;
	}

	public void setReturnGoodsInfo(String returnGoodsInfo) {
		this.returnGoodsInfo = returnGoodsInfo;
	}

	public String getShipAddr() {
		return shipAddr;
	}

	public void setShipAddr(String shipAddr) {
		this.shipAddr = shipAddr;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeData() {
		return typeData;
	}

	public void setTypeData(String typeData) {
		this.typeData = typeData;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getBeginPrice() {
		return beginPrice;
	}

	public void setBeginPrice(String beginPrice) {
		this.beginPrice = beginPrice;
	}

	public String getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Integer getOrderStatusNum() {
		return orderStatusNum;
	}

	public void setOrderStatusNum(Integer orderStatusNum) {
		this.orderStatusNum = orderStatusNum;
	}

	public Boolean getIsygOrder() {
		return isygOrder;
	}

	public void setIsygOrder(Boolean isygOrder) {
		this.isygOrder = isygOrder;
	}

	public Integer getOrderTypeFlag() {
		return orderTypeFlag;
	}

	public void setOrderTypeFlag(Integer orderTypeFlag) {
		this.orderTypeFlag = orderTypeFlag;
	}

}