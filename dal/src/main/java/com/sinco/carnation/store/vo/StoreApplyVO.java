package com.sinco.carnation.store.vo;

import java.math.BigDecimal;

public class StoreApplyVO {

	/** 公司紧急联系人手机 **/
	private String licenseCMobile;

	/** 是否安装刷卡机 **/
	private Boolean isEepay;

	/** 法人身份正面照 **/
	private String licenseLegalIdCardFrontPath;
	/** 法人身份反面照 **/
	private String licenseLegalIdCardBackPath;
	/** 法人身份手拿照 **/
	private String licenseLegalIdCardReachPath;
	/** 银行卡正面照 **/
	private String bankCardFrontPath;
	/** 银行卡反面照 **/
	private String bankCardBackPath;
	/** 经营场所证明 **/
	private String businessPlacePhotoPath;

	/** 其他证明 使用 “;”分割 **/
	private String otherPhotoPath;

	/** 返润比例 **/
	private BigDecimal commissionRebate;

	/** 服务主营类目，存储类目Id **/
	private Long groupMainId;
	/** 服务详细类目 **/
	private String[] groupDetailInfo;

	/** 店铺电话号码 **/
	private String storeTelephone;

	/** 所属行业 **/
	private String industry;

	/** 经营范围 **/
	private String licenseBusinessScope;

	/** 营业执照副本电子版 **/
	private String licenseImagePath;

	/** 银行开户名 **/
	private String bankAccountName;

	/** 公司银行账号 **/
	private String bankCAccount;

	/** 开户行支行名称 **/
	private String bankName;

	/** 开户行所在地 **/
	private Long bankAreaId;

	/** 店主身份证号 **/
	private String storeOwerCard;

	/** 运营商编号 **/
	private String operateNumber;

	/**
	 * 邀请编号
	 */
	private String inviterNumber;

	/** 公司简介 **/
	private String licenseCDesc;

	/** 营业执照上公司名称 **/
	private String licenseCName;

	private String storeName;

	/** 店铺详细地址 **/
	private String storeAddress;

	/** 店铺地址，这里保存的是最底层地址 **/
	private Long areaId;

	/** 经度 **/
	private BigDecimal storeLat;

	/** 纬度 **/
	private BigDecimal storeLon;

	/** 服务折扣 **/
	private BigDecimal groupDiscount;
	private String licenseLegalName;// 法人姓名
	private String licenseLegalIdCard;// 法人身份证号
	private String licenseCContact;// 联系人姓名
	private String licenseCEmail;// 联系人邮箱
	private String organizationImagePath;// 组织机构图片
	/**
	 * 推荐运营商 
	 */
	private String recommend;  //add by yuleijia on 2017.4.15
 

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public Long getBankAreaId() {
		return bankAreaId;
	}

	public void setBankAreaId(Long bankAreaId) {
		this.bankAreaId = bankAreaId;
	}

	public String getStoreOwerCard() {
		return storeOwerCard;
	}

	public void setStoreOwerCard(String storeOwerCard) {
		this.storeOwerCard = storeOwerCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

	public BigDecimal getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(BigDecimal storeLat) {
		this.storeLat = storeLat;
	}

	public BigDecimal getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(BigDecimal storeLon) {
		this.storeLon = storeLon;
	}

	public String getLicenseCDesc() {
		return licenseCDesc;
	}

	public void setLicenseCDesc(String licenseCDesc) {
		this.licenseCDesc = licenseCDesc;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getLicenseCMobile() {
		return licenseCMobile;
	}

	public void setLicenseCMobile(String licenseCMobile) {
		this.licenseCMobile = licenseCMobile;
	}

	public Boolean getIsEepay() {
		return isEepay;
	}

	public void setIsEepay(Boolean isEepay) {
		this.isEepay = isEepay;
	}

	public String getLicenseLegalIdCardFrontPath() {
		return licenseLegalIdCardFrontPath;
	}

	public void setLicenseLegalIdCardFrontPath(String licenseLegalIdCardFrontPath) {
		this.licenseLegalIdCardFrontPath = licenseLegalIdCardFrontPath;
	}

	public String getLicenseLegalIdCardBackPath() {
		return licenseLegalIdCardBackPath;
	}

	public void setLicenseLegalIdCardBackPath(String licenseLegalIdCardBackPath) {
		this.licenseLegalIdCardBackPath = licenseLegalIdCardBackPath;
	}

	public String getLicenseLegalIdCardReachPath() {
		return licenseLegalIdCardReachPath;
	}

	public void setLicenseLegalIdCardReachPath(String licenseLegalIdCardReachPath) {
		this.licenseLegalIdCardReachPath = licenseLegalIdCardReachPath;
	}

	public String getBankCardFrontPath() {
		return bankCardFrontPath;
	}

	public void setBankCardFrontPath(String bankCardFrontPath) {
		this.bankCardFrontPath = bankCardFrontPath;
	}

	public String getBankCardBackPath() {
		return bankCardBackPath;
	}

	public void setBankCardBackPath(String bankCardBackPath) {
		this.bankCardBackPath = bankCardBackPath;
	}

	public String getBusinessPlacePhotoPath() {
		return businessPlacePhotoPath;
	}

	public void setBusinessPlacePhotoPath(String businessPlacePhotoPath) {
		this.businessPlacePhotoPath = businessPlacePhotoPath;
	}

	public String getOtherPhotoPath() {
		return otherPhotoPath;
	}

	public void setOtherPhotoPath(String otherPhotoPath) {
		this.otherPhotoPath = otherPhotoPath;
	}

	public BigDecimal getCommissionRebate() {
		return commissionRebate;
	}

	public void setCommissionRebate(BigDecimal commissionRebate) {
		this.commissionRebate = commissionRebate;
	}

	public Long getGroupMainId() {
		return groupMainId;
	}

	public void setGroupMainId(Long groupMainId) {
		this.groupMainId = groupMainId;
	}

	public String[] getGroupDetailInfo() {
		return groupDetailInfo;
	}

	public void setGroupDetailInfo(String[] groupDetailInfo) {
		this.groupDetailInfo = groupDetailInfo;
	}

	public String getLicenseCName() {
		return licenseCName;
	}

	public void setLicenseCName(String licenseCName) {
		this.licenseCName = licenseCName;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getLicenseBusinessScope() {
		return licenseBusinessScope;
	}

	public void setLicenseBusinessScope(String licenseBusinessScope) {
		this.licenseBusinessScope = licenseBusinessScope;
	}

	public String getLicenseImagePath() {
		return licenseImagePath;
	}

	public void setLicenseImagePath(String licenseImagePath) {
		this.licenseImagePath = licenseImagePath;
	}

	public String getBankAccountName() {
		return bankAccountName;
	}

	public void setBankAccountName(String bankAccountName) {
		this.bankAccountName = bankAccountName;
	}

	public String getBankCAccount() {
		return bankCAccount;
	}

	public void setBankCAccount(String bankCAccount) {
		this.bankCAccount = bankCAccount;
	}

	public String getOperateNumber() {
		return operateNumber;
	}

	public void setOperateNumber(String operateNumber) {
		this.operateNumber = operateNumber;
	}

	public String getInviterNumber() {
		return inviterNumber;
	}

	public void setInviterNumber(String inviterNumber) {
		this.inviterNumber = inviterNumber;
	}

	public String getLicenseLegalName() {
		return licenseLegalName;
	}

	public void setLicenseLegalName(String licenseLegalName) {
		this.licenseLegalName = licenseLegalName;
	}

	public String getLicenseLegalIdCard() {
		return licenseLegalIdCard;
	}

	public void setLicenseLegalIdCard(String licenseLegalIdCard) {
		this.licenseLegalIdCard = licenseLegalIdCard;
	}

	public String getLicenseCEmail() {
		return licenseCEmail;
	}

	public void setLicenseCEmail(String licenseCEmail) {
		this.licenseCEmail = licenseCEmail;
	}

	public String getOrganizationImagePath() {
		return organizationImagePath;
	}

	public void setOrganizationImagePath(String organizationImagePath) {
		this.organizationImagePath = organizationImagePath;
	}

	public String getLicenseCContact() {
		return licenseCContact;
	}

	public void setLicenseCContact(String licenseCContact) {
		this.licenseCContact = licenseCContact;
	}

}
