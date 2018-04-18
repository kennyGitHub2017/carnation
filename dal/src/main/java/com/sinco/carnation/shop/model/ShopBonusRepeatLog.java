package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class ShopBonusRepeatLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9065449492819389059L;

	/** 自增Id **/
	private Long id;

	/** 用户Uid **/
	private Long uid;

	/** CN账户名 **/
	private String userAlias;

	/** 订单ID **/
	private String orderId;

	/** 订单总金额 **/
	private BigDecimal totalPrice;

	/** 使用金币费用 **/
	private BigDecimal usedBonusPrice;

	/** 支出0 收入(退回)1 **/
	private Integer type;

	/** 1奖金 3重消 **/
	private Integer payType;

	/** 使用的重消 **/
	private BigDecimal usedRepeatMoney;

	/** 时间 **/
	private Date dateTime;

	/** 支付返回的流水号 **/
	private String returnTracNo;
	/**订单使用的积分**/
	private BigDecimal usedIntegralMoney;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUserAlias() {
		return userAlias;
	}

	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getUsedBonusPrice() {
		return usedBonusPrice;
	}

	public void setUsedBonusPrice(BigDecimal usedBonusPrice) {
		this.usedBonusPrice = usedBonusPrice;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getPayType() {
		return payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	public BigDecimal getUsedRepeatMoney() {
		return usedRepeatMoney;
	}

	public void setUsedRepeatMoney(BigDecimal usedRepeatMoney) {
		this.usedRepeatMoney = usedRepeatMoney;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getReturnTracNo() {
		return returnTracNo;
	}

	public void setReturnTracNo(String returnTracNo) {
		this.returnTracNo = returnTracNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getUsedIntegralMoney() {
		return usedIntegralMoney;
	}

	public void setUsedIntegralMoney(BigDecimal usedIntegralMoney) {
		this.usedIntegralMoney = usedIntegralMoney;
	}

}