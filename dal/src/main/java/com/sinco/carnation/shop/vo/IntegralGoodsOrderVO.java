package com.sinco.carnation.shop.vo;

public class IntegralGoodsOrderVO {

	/** 订单编号，以igo开头 **/
	private String igoOrderSn;
	/** 会员名称 **/
	private String userName;
	/** 支付方式，使用mark标识 **/
	private String igoPayment;
	/** 订单状态，0为已提交未付款，20为付款成功，30为已发货，40为已收货完成,-1为已经取消，此时不归还用户积分 **/
	private Integer igoStatus;

	private Long igoId;
	private String igoShipCode;
	private String igoShipContent;
	private Long ecId;
	private Long uid;
	private String beginTime;
	private String endTime;

	public String getIgoOrderSn() {
		return igoOrderSn;
	}

	public void setIgoOrderSn(String igoOrderSn) {
		this.igoOrderSn = igoOrderSn;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIgoPayment() {
		return igoPayment;
	}

	public void setIgoPayment(String igoPayment) {
		this.igoPayment = igoPayment;
	}

	public Integer getIgoStatus() {
		return igoStatus;
	}

	public void setIgoStatus(Integer igoStatus) {
		this.igoStatus = igoStatus;
	}

	public String getIgoShipCode() {
		return igoShipCode;
	}

	public void setIgoShipCode(String igoShipCode) {
		this.igoShipCode = igoShipCode;
	}

	public String getIgoShipContent() {
		return igoShipContent;
	}

	public void setIgoShipContent(String igoShipContent) {
		this.igoShipContent = igoShipContent;
	}

	public Long getIgoId() {
		return igoId;
	}

	public void setIgoId(Long igoId) {
		this.igoId = igoId;
	}

	public Long getEcId() {
		return ecId;
	}

	public void setEcId(Long ecId) {
		this.ecId = ecId;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

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

}