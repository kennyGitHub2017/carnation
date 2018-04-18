package com.sinco.carnation.shop.vo;

import java.util.Date;

public class TransportVO {
	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 是否开启EMS **/
	private Boolean transEms;

	/** 是否开启快递 **/
	private Boolean transExpress;

	/** 是否开启平邮 **/
	private Boolean transMail;

	/**  **/
	private String transName;

	/** 发货时间 **/
	private Integer transTime;

	/** 运送类型 0按件数，1按重量，2按体积 **/
	private Integer transType;

	/** 模板类型 **/
	private Integer transUser;

	/** 所属店铺 对应店铺管理类 **/
	private Long storeId;

	/** EMS信息 **/
	private String transEmsInfo;

	/** 快递信息 **/
	private String transExpressInfo;

	/**
	 * 平邮信息 使用json管理 [ {"city_id":-1,"city_name":"全国","trans_weight":1,"trans_fee":13.5
	 * ,"trans_add_weight":1,"trans_add_fee":2},
	 * {"city_id":1,"city_name":"沈阳","trans_weight":1,"trans_fee":13.5,
	 * "trans_add_weight":1,"trans_add_fee":2} ]
	 **/
	private String transMailInfo;

	private Integer mailCityCount;
	private Integer expressCityCount;
	private Integer emsCityCount;
	private Float mailTransFee;
	private Float mailTransAddFee;
	private Integer mailTransWeight;
	private Integer mailTransAddWeight;
	private Integer expressTransWeight;
	private Float expressTransFee;
	private Integer expressTransAddWeight;
	private Float expressTransAddFee;
	private Integer emsTransWeight;
	private Float emsTransFee;
	private Integer emsTransAddWeight;
	private Float emsTransAddFee;

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

	public Boolean getTransEms() {
		return transEms;
	}

	public void setTransEms(Boolean transEms) {
		this.transEms = transEms;
	}

	public Boolean getTransExpress() {
		return transExpress;
	}

	public void setTransExpress(Boolean transExpress) {
		this.transExpress = transExpress;
	}

	public Boolean getTransMail() {
		return transMail;
	}

	public void setTransMail(Boolean transMail) {
		this.transMail = transMail;
	}

	public String getTransName() {
		return transName;
	}

	public void setTransName(String transName) {
		this.transName = transName;
	}

	public Integer getTransTime() {
		return transTime;
	}

	public void setTransTime(Integer transTime) {
		this.transTime = transTime;
	}

	public Integer getTransType() {
		return transType;
	}

	public void setTransType(Integer transType) {
		this.transType = transType;
	}

	public Integer getTransUser() {
		return transUser;
	}

	public void setTransUser(Integer transUser) {
		this.transUser = transUser;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getTransEmsInfo() {
		return transEmsInfo;
	}

	public void setTransEmsInfo(String transEmsInfo) {
		this.transEmsInfo = transEmsInfo;
	}

	public String getTransExpressInfo() {
		return transExpressInfo;
	}

	public void setTransExpressInfo(String transExpressInfo) {
		this.transExpressInfo = transExpressInfo;
	}

	public String getTransMailInfo() {
		return transMailInfo;
	}

	public void setTransMailInfo(String transMailInfo) {
		this.transMailInfo = transMailInfo;
	}

	public Integer getMailCityCount() {
		return mailCityCount;
	}

	public void setMailCityCount(Integer mailCityCount) {
		this.mailCityCount = mailCityCount;
	}

	public Integer getExpressCityCount() {
		return expressCityCount;
	}

	public void setExpressCityCount(Integer expressCityCount) {
		this.expressCityCount = expressCityCount;
	}

	public Integer getEmsCityCount() {
		return emsCityCount;
	}

	public void setEmsCityCount(Integer emsCityCount) {
		this.emsCityCount = emsCityCount;
	}

	public Float getMailTransFee() {
		return mailTransFee;
	}

	public void setMailTransFee(Float mailTransFee) {
		this.mailTransFee = mailTransFee;
	}

	public Integer getMailTransWeight() {
		return mailTransWeight;
	}

	public void setMailTransWeight(Integer mailTransWeight) {
		this.mailTransWeight = mailTransWeight;
	}

	public Integer getMailTransAddWeight() {
		return mailTransAddWeight;
	}

	public void setMailTransAddWeight(Integer mailTransAddWeight) {
		this.mailTransAddWeight = mailTransAddWeight;
	}

	public Float getMailTransAddFee() {
		return mailTransAddFee;
	}

	public void setMailTransAddFee(Float mailTransAddFee) {
		this.mailTransAddFee = mailTransAddFee;
	}

	public Integer getExpressTransWeight() {
		return expressTransWeight;
	}

	public void setExpressTransWeight(Integer expressTransWeight) {
		this.expressTransWeight = expressTransWeight;
	}

	public Float getExpressTransFee() {
		return expressTransFee;
	}

	public void setExpressTransFee(Float expressTransFee) {
		this.expressTransFee = expressTransFee;
	}

	public Integer getExpressTransAddWeight() {
		return expressTransAddWeight;
	}

	public void setExpressTransAddWeight(Integer expressTransAddWeight) {
		this.expressTransAddWeight = expressTransAddWeight;
	}

	public Float getExpressTransAddFee() {
		return expressTransAddFee;
	}

	public void setExpressTransAddFee(Float expressTransAddFee) {
		this.expressTransAddFee = expressTransAddFee;
	}

	public Integer getEmsTransWeight() {
		return emsTransWeight;
	}

	public void setEmsTransWeight(Integer emsTransWeight) {
		this.emsTransWeight = emsTransWeight;
	}

	public Float getEmsTransFee() {
		return emsTransFee;
	}

	public void setEmsTransFee(Float emsTransFee) {
		this.emsTransFee = emsTransFee;
	}

	public Integer getEmsTransAddWeight() {
		return emsTransAddWeight;
	}

	public void setEmsTransAddWeight(Integer emsTransAddWeight) {
		this.emsTransAddWeight = emsTransAddWeight;
	}

	public Float getEmsTransAddFee() {
		return emsTransAddFee;
	}

	public void setEmsTransAddFee(Float emsTransAddFee) {
		this.emsTransAddFee = emsTransAddFee;
	}
}