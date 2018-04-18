package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ExpressInfo extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4542807221688134195L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 快递公司名称 **/
	private String orderExpressName;

	/** 订单id **/
	private Long orderId;

	/** 订单的快递状态，初次订阅为0，快递100回调推送后变为1,根据此状态快递查询快递100是否有回调推送 **/
	private Integer orderStatus;

	/** 0为发货快递单，1为退货快递单 **/
	private Integer orderType;

	/** 快递单号 **/
	private String orderExpressId;

	/** 订单的快递信息 **/
	private String orderExpressInfo;

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

	public String getOrderExpressName() {
		return orderExpressName;
	}

	public void setOrderExpressName(String orderExpressName) {
		this.orderExpressName = orderExpressName;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderExpressId() {
		return orderExpressId;
	}

	public void setOrderExpressId(String orderExpressId) {
		this.orderExpressId = orderExpressId;
	}

	public String getOrderExpressInfo() {
		return orderExpressInfo;
	}

	public void setOrderExpressInfo(String orderExpressInfo) {
		this.orderExpressInfo = orderExpressInfo;
	}
}