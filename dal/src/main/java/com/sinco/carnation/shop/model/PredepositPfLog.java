package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class PredepositPfLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5598698411754849546L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/** 收益金额 **/
	private BigDecimal pfLogAmount;

	/** 收益用户 **/
	private Long pfLogUserId;

	/** 订单id **/
	private Long orderId;

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

	public BigDecimal getPfLogAmount() {
		return pfLogAmount;
	}

	public void setPfLogAmount(BigDecimal pfLogAmount) {
		this.pfLogAmount = pfLogAmount;
	}

	public Long getPfLogUserId() {
		return pfLogUserId;
	}

	public void setPfLogUserId(Long pfLogUserId) {
		this.pfLogUserId = pfLogUserId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}