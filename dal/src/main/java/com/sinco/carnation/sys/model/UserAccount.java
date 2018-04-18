package com.sinco.carnation.sys.model;

import java.util.Date;

import com.sinco.dal.common.persistence.mybatis.DataModel;

public class UserAccount extends DataModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6638324283011193263L;

	/**  */
	private Long id;

	/**  */
	private Long uid;

	/**  */
	private String loginName;

	/** 普通会员密码 */
	private String password;

	/** 商户登录密码 */
	private String sellerPassword;

	/** 供应商登录密码 */
	private String supplierPassword;

	/** 运营商登录密码 */
	private String operatorPassword;

	/** 账户类型 1:邮箱 2:手机 */
	private String accountType;

	/**  */
	private Date lastLoginTime;

	/**  */
	private String lastLoginIp;

	/** 是否删除 */
	private Boolean isDeleted;

	/** 用户app分享设置内容 */
	private String appShareInfo;

	private String openId;

	/** 用户第三方昵称 **/
	private String thirdNickName;

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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAppShareInfo() {
		return appShareInfo;
	}

	public void setAppShareInfo(String appShareInfo) {
		this.appShareInfo = appShareInfo;
	}

	public String getThirdNickName() {
		return thirdNickName;
	}

	public void setThirdNickName(String thirdNickName) {
		this.thirdNickName = thirdNickName;
	}

	public String getSellerPassword() {
		return sellerPassword;
	}

	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}

	public String getSupplierPassword() {
		return supplierPassword;
	}

	public void setSupplierPassword(String supplierPassword) {
		this.supplierPassword = supplierPassword;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String operatorPassword) {
		this.operatorPassword = operatorPassword;
	}

}