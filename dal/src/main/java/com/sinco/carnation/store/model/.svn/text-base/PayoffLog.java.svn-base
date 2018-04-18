package com.sinco.carnation.store.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class PayoffLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6783776921839783668L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 结算申请时间 **/
	private Date applyTime;

	/** 结算账单总佣金 **/
	private BigDecimal commissionAmount;

	/** 结算完成时间 **/
	private Date completeTime;

	/** 结算该账单的财务人员姓名 **/
	private String financeUserName;

	/** 结算账单对应的订单id **/
	private String oId;

	/** 结算账单对应的订单号 **/
	private String orderId;

	/** 对应订单商品总金额 **/
	private BigDecimal orderTotalPrice;

	/** 结算账单类型，0为进账，-1为出账 **/
	private Integer payoffType;

	/** 结算账单说明 **/
	private String plInfo;

	/** 结算结算账单唯一编号记录，使用pl为前缀 **/
	private String plSn;

	/** 实际结算金额， **/
	private BigDecimal realityAmount;

	/** 退货完成后进行退款时的收款人姓名 **/
	private String refundUserName;

	/** 退货完成后进行退款时的收款人id **/
	private Long refundUserId;

	/** 退货服务单的服务号 **/
	private String returnServiceId;

	/** 结算账单状态，0为未结算，1为可结算、3为结算中，6为已结算已完成。 **/
	private Integer status;

	/** 结算金额=订单总金额-总佣金费用 **/
	private BigDecimal totalAmount;

	/** 结算邮费 */
	private BigDecimal shipAmount;

	/** 结算账单操作管理员 **/
	private Long adminId;

	/** 结算账单对应的店铺商家 **/
	private Long sellerId;

	/**  **/
	private String goodsInfo;

	/** 结算说明 **/
	private String payoffRemark;

	/** 退货商品详细信息json数据 **/
	private String returnGoodsInfo;

	/** 退款金额 */
	private BigDecimal returnAmount;

	public BigDecimal getReturnAmount() {
		return returnAmount;
	}

	public void setReturnAmount(BigDecimal returnAmount) {
		this.returnAmount = returnAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getShipAmount() {
		return shipAmount;
	}

	public void setShipAmount(BigDecimal shipAmount) {
		this.shipAmount = shipAmount;
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

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public BigDecimal getCommissionAmount() {
		return commissionAmount;
	}

	public void setCommissionAmount(BigDecimal commissionAmount) {
		this.commissionAmount = commissionAmount;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public String getFinanceUserName() {
		return financeUserName;
	}

	public void setFinanceUserName(String financeUserName) {
		this.financeUserName = financeUserName;
	}

	public String getoId() {
		return oId;
	}

	public void setoId(String oId) {
		this.oId = oId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Integer getPayoffType() {
		return payoffType;
	}

	public void setPayoffType(Integer payoffType) {
		this.payoffType = payoffType;
	}

	public String getPlInfo() {
		return plInfo;
	}

	public void setPlInfo(String plInfo) {
		this.plInfo = plInfo;
	}

	public String getPlSn() {
		return plSn;
	}

	public void setPlSn(String plSn) {
		this.plSn = plSn;
	}

	public BigDecimal getRealityAmount() {
		return realityAmount;
	}

	public void setRealityAmount(BigDecimal realityAmount) {
		this.realityAmount = realityAmount;
	}

	public String getRefundUserName() {
		return refundUserName;
	}

	public void setRefundUserName(String refundUserName) {
		this.refundUserName = refundUserName;
	}

	public Long getRefundUserId() {
		return refundUserId;
	}

	public void setRefundUserId(Long refundUserId) {
		this.refundUserId = refundUserId;
	}

	public String getReturnServiceId() {
		return returnServiceId;
	}

	public void setReturnServiceId(String returnServiceId) {
		this.returnServiceId = returnServiceId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public String getPayoffRemark() {
		return payoffRemark;
	}

	public void setPayoffRemark(String payoffRemark) {
		this.payoffRemark = payoffRemark;
	}

	public String getReturnGoodsInfo() {
		return returnGoodsInfo;
	}

	public void setReturnGoodsInfo(String returnGoodsInfo) {
		this.returnGoodsInfo = returnGoodsInfo;
	}
}