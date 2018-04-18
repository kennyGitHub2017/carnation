package com.sinco.carnation.market.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.math.BigDecimal;
import java.util.Date;

public class RedPackageGetRecord extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4773359080540857064L;

	/** id主键 **/
	private Long id;

	/** 红包id **/
	private Long packageId;

	/** 红包金额 **/
	private BigDecimal money;

	/** 32位guid,用来标志一个浏览器客户端只能拆一次 **/
	private String cookId;

	/** 红包领取人的用户Id **/
	private Long userId;

	/** 客户端ip **/
	private String ip;

	/** 拆包时间 **/
	private Date openTime;

	/** 领取时间 **/
	private Date getTime;

	/** 删除标志 **/
	private Byte deleteStatus;

	/** 0 未拆包 1已拆包 2 已领取 **/
	private Byte status;

	/** 创建时间 **/
	private Date createdTime;

	/** 过期时间 **/
	private Date offTime;

	/** 手机 **/
	private String phone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getCookId() {
		return cookId;
	}

	public void setCookId(String cookId) {
		this.cookId = cookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getGetTime() {
		return getTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}

	public Date getOffTime() {
		return offTime;
	}

	public void setOffTime(Date offTime) {
		this.offTime = offTime;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

}