package com.sinco.carnation.aio.model;

import com.sinco.mybatis.dal.model.BaseModel;

/**
 * 思创健康一体机 血压
 */
public class SysDia extends BaseModel {

	private static final long serialVersionUID = -5001646401532244537L;
	private Long id;
	// 设备ID
	private String did;
	// 数据同步时间
	private String syncTime;
	// 用户身份证号码
	private String idCard;
	// 用户ID类型，身份证还是手机号
	private String ctype;
	// 收缩压/舒张压
	private String sysDia;
	// 脉率
	private String pr;
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

	public String getSysDia() {
		return sysDia;
	}

	public void setSysDia(String sysDia) {
		this.sysDia = sysDia;
	}

	public String getPr() {
		return pr;
	}

	public void setPr(String pr) {
		this.pr = pr;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}