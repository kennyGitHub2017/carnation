package com.sinco.carnation.resource.bo.o2o;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "Merchant", desc = "商户信息")
public class MerchantBO {

	@JsonProperty("id")
	@FieldMapping(desc = "商户id")
	private Long id;

	@JsonProperty("storeName")
	@FieldMapping(desc = "店铺名称")
	private String storeName;

	@JsonProperty("industry")
	@FieldMapping(desc = "所属行业")
	private String industry;

	@JsonProperty("licenseBusinessScope")
	@FieldMapping(desc = "经营范围")
	private String licenseBusinessScope;

	// 主营类目

	// 商户所在地

	@JsonProperty("storeAddress")
	@FieldMapping(desc = "店铺详细地址")
	private String storeAddress;

	@JsonProperty("storeTelephone")
	@FieldMapping(desc = "店铺电话号码")
	private String storeTelephone;

	@JsonProperty("licenseCMobile")
	@FieldMapping(desc = "店铺手机号")
	private String licenseCMobile;

	@JsonProperty("storeOwerCard")
	@FieldMapping(desc = "所属身份和编号")
	private String storeOwerCard;

	@JsonProperty("commissionRebate")
	@FieldMapping(desc = "返润比例")
	private BigDecimal commissionRebate;

	@JsonProperty("bankAccountName")
	@FieldMapping(desc = "结算账户名")
	private String bankAccountName;

	@JsonProperty("bankCAccount")
	@FieldMapping(desc = "结算账户")
	private String bankCAccount;

	@JsonProperty("bankName")
	@FieldMapping(desc = "开户行")
	private String bankName;

	// 安装pos机

	// 隶属运营商编号

	@JsonProperty("licenseLegalIdCardFrontPath")
	@FieldMapping(desc = "法人身份正面照")
	private String licenseLegalIdCardFrontPath;

	@JsonProperty("licenseLegalIdCardBackPath")
	@FieldMapping(desc = "法人身份反面照 ")
	private String licenseLegalIdCardBackPath;

	@JsonProperty("businessPlacePhotoPath")
	@FieldMapping(desc = "经营场所证明")
	private String businessPlacePhotoPath;

	@JsonProperty("otherPhotoPath")
	@FieldMapping(desc = "其他证明")
	private String otherPhotoPath;

	@JsonProperty("invitationCode")
	@FieldMapping(desc = "邀请码")
	private String invitationCode;

	@JsonProperty("couponPayAmount")
	@FieldMapping(desc = "劵销售总额")
	private BigDecimal couponPayAmount;

	@JsonProperty("chargePayAmount")
	@FieldMapping(desc = "刷卡销售额")
	private BigDecimal chargePayAmount;

	@JsonProperty("rebateAmount")
	@FieldMapping(desc = "消费返润总额")
	private BigDecimal rebateAmount;

	@JsonProperty("storeBannerPath")
	@FieldMapping(desc = "商户图片")
	private String storeBannerPath;

	@JsonProperty("storeLogoPath")
	@FieldMapping(desc = "店铺logo")
	private String storeLogoPath;

	public Long getId() {
		return id;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public BigDecimal getCouponPayAmount() {
		return couponPayAmount;
	}

	public BigDecimal getChargePayAmount() {
		return chargePayAmount;
	}

	public BigDecimal getRebateAmount() {
		return rebateAmount;
	}

	public String getStoreBannerPath() {
		return storeBannerPath;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public void setCouponPayAmount(BigDecimal couponPayAmount) {
		this.couponPayAmount = couponPayAmount;
	}

	public void setChargePayAmount(BigDecimal chargePayAmount) {
		this.chargePayAmount = chargePayAmount;
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

	public void setStoreBannerPath(String storeBannerPath) {
		this.storeBannerPath = storeBannerPath;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLicenseBusinessScope() {
		return licenseBusinessScope;
	}

	public void setLicenseBusinessScope(String licenseBusinessScope) {
		this.licenseBusinessScope = licenseBusinessScope;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getLicenseCMobile() {
		return licenseCMobile;
	}

	public void setLicenseCMobile(String licenseCMobile) {
		this.licenseCMobile = licenseCMobile;
	}

	public String getStoreOwerCard() {
		return storeOwerCard;
	}

	public void setStoreOwerCard(String storeOwerCard) {
		this.storeOwerCard = storeOwerCard;
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

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getStoreLogoPath() {
		return storeLogoPath;
	}

	public void setStoreLogoPath(String storeLogoPath) {
		this.storeLogoPath = storeLogoPath;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public BigDecimal getCommissionRebate() {
		return commissionRebate;
	}

	public void setCommissionRebate(BigDecimal commissionRebate) {
		this.commissionRebate = commissionRebate;
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

}
