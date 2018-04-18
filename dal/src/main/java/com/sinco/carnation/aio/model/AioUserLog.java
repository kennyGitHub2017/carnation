package com.sinco.carnation.aio.model;

import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 思创健康一体机  用户检测历史记录
 */
public class AioUserLog extends BaseModel {
	private static final long serialVersionUID = -8634755878326271710L;
	private Long id;
	// 设备ID
	private String did;
	// 数据同步时间
	private String syncTime;
	// 用户身份证号码
	private String idCard;
	// 用户ID类型，身份证还是手机号
	private String ctype;
	// 检测项目
	private String subject;
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

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}