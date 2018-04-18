package com.sinco.carnation.aio.model;

import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 思创健康一体机 尿酸
 */
public class Ua extends BaseModel {
	private static final long serialVersionUID = 8463748843216937313L;
	private Long id;
	// 设备ID
	private String did;
	// 数据同步时间
	private String syncTime;
	// 用户身份证号码
	private String idCard;
	// 用户ID类型，身份证还是手机号
	private String ctype;
	// 尿酸
	private String ua;
	// 测量的日期和时间
	private String time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(String syncTime) {
		this.syncTime = syncTime;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	public String getUa() {
		return ua;
	}

	public void setUa(String ua) {
		this.ua = ua;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}