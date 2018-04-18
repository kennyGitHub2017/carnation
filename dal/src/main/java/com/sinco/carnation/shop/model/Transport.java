package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Transport extends BaseModel {

	private static final long serialVersionUID = -8604296611438727596L;

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
	 * 平邮信息 使用json管理[{"city_id":-1,"city_name":"全国","trans_weight":1,"trans_fee":13.5,"trans_add_weight":1,
	 * "trans_add_fee"
	 * :2},{"city_id":1,"city_name":"沈阳","trans_weight":1,"trans_fee":13.5,"trans_add_weight":1,
	 * "trans_add_fee":2}]
	 **/
	private String transMailInfo;

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
}