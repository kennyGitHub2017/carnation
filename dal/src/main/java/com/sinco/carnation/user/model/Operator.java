package com.sinco.carnation.user.model;

import java.util.Date;

import com.sinco.mybatis.dal.model.BaseModel;

public class Operator extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 291515380865366805L;

	/**  **/
	private Long id;

	private String operatorName;

	/** 用户id **/
	private Long userId;

	/** 运营商级别：1市，2区，3vip经销商，7金卡经销商，9银卡经销商 **/
	private String level;

	/** 运营商编码 **/
	private String operatorCode;

	/** 姓名 **/
	private String userName;
	/** 运营商状态：0审核中，1审核通过，-1审核不通过 **/
	private String status;
	/**  **/
	private String idCard;

	/** 性别：1男，2女 **/
	private String sex;

	/**  **/
	private String operatorAreaId;

	/** 民族 **/
	private String nation;

	/**  **/
	private String phone;

	/**  **/
	private String address;

	/**  **/
	private String bankName;

	/**  **/
	private String subBankName;

	/**  **/
	private String bankNo;

	/** 营业执照号 **/
	private String registrationNo;

	/** 营业执照图片 **/
	private String registrationPath;

	/** 组织机构代码 **/
	private String organizationNo;

	/** 组织机构代码证图片 **/
	private String organizationPath;

	/** 税务登记证号 **/
	private String taxNo;

	/** 税务登记证图片地址 **/
	private String taxPath;

	private Date assignedTime;
	/**  **/
	private String updateBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private String createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	/** CN账户会员编号 **/
	private String cn_username;
	/**
	 * 推广商户卖家UID
	 */
	private Long extensionSellerUid;

	public Long getExtensionSellerUid() {
		return extensionSellerUid;
	}

	public void setExtensionSellerUid(Long extensionSellerUid) {
		this.extensionSellerUid = extensionSellerUid;
	}

	public String getCn_username() {
		return cn_username;
	}

	public void setCn_username(String cn_username) {
		this.cn_username = cn_username;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 运营商级别：1市，2区，3vip经销商，7金卡经销商，9银卡经销商
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * 运营商级别：1市，2区，3vip经销商，7金卡经销商，9银卡经销商
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(String operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSubBankName() {
		return subBankName;
	}

	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getRegistrationPath() {
		return registrationPath;
	}

	public void setRegistrationPath(String registrationPath) {
		this.registrationPath = registrationPath;
	}

	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getTaxPath() {
		return taxPath;
	}

	public void setTaxPath(String taxPath) {
		this.taxPath = taxPath;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getAssignedTime() {
		return assignedTime;
	}

	public void setAssignedTime(Date assignedTime) {
		this.assignedTime = assignedTime;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
}