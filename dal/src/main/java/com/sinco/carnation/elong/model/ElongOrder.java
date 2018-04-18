package com.sinco.carnation.elong.model;

import com.sinco.mybatis.dal.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class ElongOrder extends BaseModel {
	private static final long serialVersionUID = -4414831963676171769L;

	private Long id;
	// 用户ID
	private Long userId;
	// 订单编号
	private Long orderId;
	// 酒店编号
	private String hotelId;
	// 酒店名称
	private String hotelName;
	// 房型编号
	private String roomTypeId;
	// 房型名称
	private String roomTypeName;
	// 产品编号
	private int ratePlanId;
	// 产品名称
	private String ratePlanName;
	// 入住日期
	private Date arrivalDate;
	// 离店日期
	private Date departureDate;
	// 订单状态(A-已确认,B-NOSHOW,B1-有预定未查到,B2-待查,B3-暂不确定,C-已结帐,D-删除,E-取消,
	// F-已入住,G-变价,H-变更,N-新单,O-满房,S-特殊,U-特殊满房,V-已审,Z-删除,另换酒店)
	private String status;
	// 对用户展示的订单状态(V1.12新增。请将这个状态展示给客人；某些状态下的详细信息会出现在NoteToGuest。
	// 1 -- 担保失败,2 -- 等待担保,4 -- 等待确认,8 -- 等待支付,16 -- 等待核实入住,32 -- 酒店拒绝订单,64 -- 未入住,
	// 128 -- 已经离店,256 -- 已经取消,512 -- 已经确认,1024 -- 已经入住,2048 -- 正在担保-处理中,
	// 4096 -- 正在支付-处理中,8192 - 支付失败)
	private String showStatus;
	// 下一次确认反馈时间点
	private Date confirmPoint;
	// 客人类型
	private String customerType;
	// 付款类型
	private String paymentType;
	// 房间数量
	private int numberOfRooms;
	// 客人数量
	private int numberOfCustomers;
	// 最早到店时间
	private Date earliestArrivalTime;
	// 最晚到店时间
	private Date latestArrivalTime;
	// 货币类型
	private String currencyCode;
	// 总价
	private BigDecimal totalPrice;
	// 艺龙会员卡号
	private String elongCardNo;
	// 确认类型
	private String confirmationType;
	// 给酒店备注
	private String noteToHotel;
	// 给艺龙备注
	private String noteToElong;
	// 给客人的备注
	private String noteToGuest;
	// 订单产生的罚金
	private BigDecimal penaltyToCustomer;
	// 罚金货币类型
	private String penaltyCurrencyCode;
	// 预订时间
	private Date creationDate;
	// 当前是否可以取消
	private Boolean isCancelable;
	// 最晚取消时间
	private Date cancelTime;
	// 是否有发票信息
	private Boolean hasInvoice;
	// 发票
	private String invoice;
	// 联系人
	private String contact;
	// 信用卡
	private String creditCard;
	// 每个价格
	private String nightlyRates;
	// 扩展信息
	private String extendInfo;
	// 房间信息
	private String orderRooms;
	// 担保规则
	private String guaranteeRule;
	// 预付规则
	private String prepayRule;
	// 增值服务
	private String valueAdds;
	// 预付订单的发票开具模式
	private String invoiceMode;
	// 换算为人民币的订单总卖价
	private BigDecimal totalPriceExchanged;
	// 换算为人民币的订单总底价
	private BigDecimal totalCostPriceExchanged;
	// 是否及时确认
	private Boolean isInstantConfirm;
	// 代理自己的订单号
	private String affiliateConfirmationId;
	// 订单关联的酒店信息
	private String orderHotel;
	// 预付订单线下退款金额
	private BigDecimal refundAmount;
	// 备注
	private String remark;
	// 创建人
	private String createUser;
	// 创建时间
	private Date createTime;
	// 最后更新人
	private String lastUpdateUser;
	// 最后更新时间
	private Date lastUpdateTime;
	/**
	 * 最晚支付时间
	 */
	private Date paymentDeadlineTime;
	/**
	 * 是否需要支付
	 */
	private Boolean isNeedPay;
	/**
	 * 担保金额
	 */
	private BigDecimal guaranteeAmount;
	/**
	 * 是否删除1是0否
	 */
	private Integer isDelete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getHotelId() {
		return hotelId;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(String roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeName() {
		return roomTypeName;
	}

	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}

	public int getRatePlanId() {
		return ratePlanId;
	}

	public void setRatePlanId(int ratePlanId) {
		this.ratePlanId = ratePlanId;
	}

	public String getRatePlanName() {
		return ratePlanName;
	}

	public void setRatePlanName(String ratePlanName) {
		this.ratePlanName = ratePlanName;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}

	public Date getConfirmPoint() {
		return confirmPoint;
	}

	public void setConfirmPoint(Date confirmPoint) {
		this.confirmPoint = confirmPoint;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}

	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}

	public Date getEarliestArrivalTime() {
		return earliestArrivalTime;
	}

	public void setEarliestArrivalTime(Date earliestArrivalTime) {
		this.earliestArrivalTime = earliestArrivalTime;
	}

	public Date getLatestArrivalTime() {
		return latestArrivalTime;
	}

	public void setLatestArrivalTime(Date latestArrivalTime) {
		this.latestArrivalTime = latestArrivalTime;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getElongCardNo() {
		return elongCardNo;
	}

	public void setElongCardNo(String elongCardNo) {
		this.elongCardNo = elongCardNo;
	}

	public String getConfirmationType() {
		return confirmationType;
	}

	public void setConfirmationType(String confirmationType) {
		this.confirmationType = confirmationType;
	}

	public String getNoteToHotel() {
		return noteToHotel;
	}

	public void setNoteToHotel(String noteToHotel) {
		this.noteToHotel = noteToHotel;
	}

	public String getNoteToElong() {
		return noteToElong;
	}

	public void setNoteToElong(String noteToElong) {
		this.noteToElong = noteToElong;
	}

	public String getNoteToGuest() {
		return noteToGuest;
	}

	public void setNoteToGuest(String noteToGuest) {
		this.noteToGuest = noteToGuest;
	}

	public BigDecimal getPenaltyToCustomer() {
		return penaltyToCustomer;
	}

	public void setPenaltyToCustomer(BigDecimal penaltyToCustomer) {
		this.penaltyToCustomer = penaltyToCustomer;
	}

	public String getPenaltyCurrencyCode() {
		return penaltyCurrencyCode;
	}

	public void setPenaltyCurrencyCode(String penaltyCurrencyCode) {
		this.penaltyCurrencyCode = penaltyCurrencyCode;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getIsCancelable() {
		return isCancelable;
	}

	public void setIsCancelable(Boolean isCancelable) {
		this.isCancelable = isCancelable;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Boolean getHasInvoice() {
		return hasInvoice;
	}

	public void setHasInvoice(Boolean hasInvoice) {
		this.hasInvoice = hasInvoice;
	}

	public String getInvoice() {
		return invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getNightlyRates() {
		return nightlyRates;
	}

	public void setNightlyRates(String nightlyRates) {
		this.nightlyRates = nightlyRates;
	}

	public String getExtendInfo() {
		return extendInfo;
	}

	public void setExtendInfo(String extendInfo) {
		this.extendInfo = extendInfo;
	}

	public String getOrderRooms() {
		return orderRooms;
	}

	public void setOrderRooms(String orderRooms) {
		this.orderRooms = orderRooms;
	}

	public String getGuaranteeRule() {
		return guaranteeRule;
	}

	public void setGuaranteeRule(String guaranteeRule) {
		this.guaranteeRule = guaranteeRule;
	}

	public String getPrepayRule() {
		return prepayRule;
	}

	public void setPrepayRule(String prepayRule) {
		this.prepayRule = prepayRule;
	}

	public String getValueAdds() {
		return valueAdds;
	}

	public void setValueAdds(String valueAdds) {
		this.valueAdds = valueAdds;
	}

	public String getInvoiceMode() {
		return invoiceMode;
	}

	public void setInvoiceMode(String invoiceMode) {
		this.invoiceMode = invoiceMode;
	}

	public BigDecimal getTotalPriceExchanged() {
		return totalPriceExchanged;
	}

	public void setTotalPriceExchanged(BigDecimal totalPriceExchanged) {
		this.totalPriceExchanged = totalPriceExchanged;
	}

	public BigDecimal getTotalCostPriceExchanged() {
		return totalCostPriceExchanged;
	}

	public void setTotalCostPriceExchanged(BigDecimal totalCostPriceExchanged) {
		this.totalCostPriceExchanged = totalCostPriceExchanged;
	}

	public Boolean getIsInstantConfirm() {
		return isInstantConfirm;
	}

	public void setIsInstantConfirm(Boolean isInstantConfirm) {
		this.isInstantConfirm = isInstantConfirm;
	}

	public String getAffiliateConfirmationId() {
		return affiliateConfirmationId;
	}

	public void setAffiliateConfirmationId(String affiliateConfirmationId) {
		this.affiliateConfirmationId = affiliateConfirmationId;
	}

	public String getOrderHotel() {
		return orderHotel;
	}

	public void setOrderHotel(String orderHotel) {
		this.orderHotel = orderHotel;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getPaymentDeadlineTime() {
		return paymentDeadlineTime;
	}

	public void setPaymentDeadlineTime(Date paymentDeadlineTime) {
		this.paymentDeadlineTime = paymentDeadlineTime;
	}

	public Boolean getIsNeedPay() {
		return isNeedPay;
	}

	public void setIsNeedPay(Boolean isNeedPay) {
		this.isNeedPay = isNeedPay;
	}

	public BigDecimal getGuaranteeAmount() {
		return guaranteeAmount;
	}

	public void setGuaranteeAmount(BigDecimal guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}