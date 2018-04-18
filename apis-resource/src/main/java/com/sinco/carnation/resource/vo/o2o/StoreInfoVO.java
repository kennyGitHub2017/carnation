package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class StoreInfoVO extends BasicParamVO {

	/** 店铺名称 **/
	@Param(desc = "店铺名称")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String storeName;

	/** 所属行业 **/
	@Param(desc = "所属行业")
	private String industry;

	/** 经营范围 **/
	@Param(desc = "经营范围 ")
	private String licenseBusinessScope;

	/** 公司简介 **/
	@Param(desc = "公司简介 ")
	private String licenseCDesc;

	/** 营业类目 **/
	@Param(desc = "营业类目")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long gcMainId;

	/** 服务详细类目 **/
	@Param(desc = "服务详细类目|以逗号隔开|青菜,个、黄瓜.....")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String groupDetailInfo;

	/** 店铺地址，这里保存的是最底层地址 **/
	@Param(desc = "店铺地址，这里保存的是最底层地址")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long areaId;

	/** 店铺详细地址 **/
	@Param(desc = "店铺详细地址")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String storeAddress;

	/** 店铺电话号码 **/
	@Param(desc = "店铺电话号码")
	private String storeTelephone;

	/** 公司紧急联系人手机 **/
	@Param(desc = "公司紧急联系人手机")
	private String licenseCMobile;

	/** 返拥比例 **/
	@Param(desc = "返拥比例")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Float commissionRebate;

	/** 银行开户名 **/
	@Param(desc = "银行开户名")
	private String bankAccountName;

	/** 公司银行账号 **/
	@Param(desc = "公司银行账号")
	private String bankCAccount;

	/** 开户行支行名称 **/
	@Param(desc = "开户行支行名称")
	private String bankName;

	/** 是否安装刷卡机 **/
	@Param(desc = "是否安装刷卡机")
	private Boolean isEepay;

	/** 法人身份正面照 **/
	@Param(desc = "法人身份正面照")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String licenseLegalIdCardFrontPath;

	/** 法人身份反面照 **/
	@Param(desc = "法人身份反面照")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String licenseLegalIdCardBackPath;

	/** 经营场所证明 **/
	@Param(desc = "经营场所证明")
	private String businessPlacePhotoPath;

	/** 其他证明 **/
	@Param(desc = "其他证明")
	private String otherPhotoPath;

	/** 法人身份证手拿照 **/
	@Param(desc = "法人身份证手拿照")
	private String licenseLegalIdCardReachPath;

	/** 银行卡正面照 **/
	@Param(desc = "银行卡正面照")
	private String bankCardFrontPath;

	/** 银行卡反面照 **/
	@Param(desc = "银行卡反面照 ")
	private String bankCardBackPath;

	/** 营业执照副本电子版 **/
	@Param(desc = "营业执照")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String licenseImagePath;

	/** 运营商编号 **/
	@Param(desc = "运营商编号")
	private String operateNumber;

	/** 经度 **/
	@Param(desc = "经度")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Float storeLat;

	/** 纬度 **/
	@Param(desc = "纬度 ")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Float storeLon;

	@Param(desc = "折扣")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Double groupDiscount;

	@Param(desc = "身份证号码")
	private String cardCode;

	@Param(desc = "bankAreaId")
	private Long bankAreaId;

	@Param(desc = "商户全称")
	/*@NotNull(message = MsgCodeConstant.ERROR_PARAM)*/
	private String licenseCName;
	
	@Param(desc = "推荐运营商")
	private String recommend;

	
	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
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

	public Long getGcMainId() {
		return gcMainId;
	}

	public void setGcMainId(Long gcMainId) {
		this.gcMainId = gcMainId;
	}

	public String getGroupDetailInfo() {
		return groupDetailInfo;
	}

	public void setGroupDetailInfo(String groupDetailInfo) {
		this.groupDetailInfo = groupDetailInfo;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
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

	public String getLicenseCName() {
		return licenseCName;
	}

	public void setLicenseCName(String licenseCName) {
		this.licenseCName = licenseCName;
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

	public String getLicenseCDesc() {
		return licenseCDesc;
	}

	public void setLicenseCDesc(String licenseCDesc) {
		this.licenseCDesc = licenseCDesc;
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

	public String getLicenseImagePath() {
		return licenseImagePath;
	}

	public void setLicenseImagePath(String licenseImagePath) {
		this.licenseImagePath = licenseImagePath;
	}

	public String getOperateNumber() {
		return operateNumber;
	}

	public void setOperateNumber(String operateNumber) {
		this.operateNumber = operateNumber;
	}

	public Float getCommissionRebate() {
		return commissionRebate;
	}

	public void setCommissionRebate(Float commissionRebate) {
		this.commissionRebate = commissionRebate;
	}

	public Float getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(Float storeLat) {
		this.storeLat = storeLat;
	}

	public Float getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(Float storeLon) {
		this.storeLon = storeLon;
	}

	public Double getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(Double groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

	public String getCardCode() {
		return cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public Long getBankAreaId() {
		return bankAreaId;
	}

	public void setBankAreaId(Long bankAreaId) {
		this.bankAreaId = bankAreaId;
	}
}
