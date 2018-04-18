package com.sinco.carnation.store.bo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.store.model.StoreApplyInfo;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class StoreApplyInfoBO extends StoreApplyInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long areaId;// 地区id,第三级
	private Long groupMainId;// 主营类目
	private String storeName;// 店铺名称
	private String groupDetailInfo;// 详细类目
	private String storeAddress;// 详细地址
	private String storeTelephone;// 店铺电话
	private String licenseCMobile;// 紧急联系人电话
	private BigDecimal commissionRebate;// 反佣比例
	private String bankAccountName;// 开户名
	private String bankCAccount;// 开户帐号
	private Boolean isEepay;// 是否安装pos机
	private String bankName;// 开户行
	private Long storeId;// 店铺id
	private BigDecimal storeLon;
	private BigDecimal storeLat;
	private BigDecimal groupDiscount;// 折扣
	private Long bankAreaId;// 开户行所在id
	private String cartCode;// 身份证号
	private String licensecName;// 营业执照上公司名称

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getGroupMainId() {
		return groupMainId;
	}

	public void setGroupMainId(Long groupMainId) {
		this.groupMainId = groupMainId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getGroupDetailInfo() {
		return groupDetailInfo;
	}

	public void setGroupDetailInfo(String groupDetailInfo) {
		this.groupDetailInfo = groupDetailInfo;
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

	public BigDecimal getCommissionRebate() {
		return commissionRebate;
	}

	public void setCommissionRebate(BigDecimal commissionRebate) {
		this.commissionRebate = commissionRebate;
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

	public Boolean getIsEepay() {
		return isEepay;
	}

	public void setIsEepay(Boolean isEepay) {
		this.isEepay = isEepay;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public BigDecimal getStoreLon() {
		return storeLon;
	}

	public void setStoreLon(BigDecimal storeLon) {
		this.storeLon = storeLon;
	}

	public BigDecimal getStoreLat() {
		return storeLat;
	}

	public void setStoreLat(BigDecimal storeLat) {
		this.storeLat = storeLat;
	}

	public String[] getOtherPhotoList() {
		if (StringUtils.isNotEmpty(getOtherPhotoPath())) {
			if (getOtherPhotoPath().contains(";")) {
				return getOtherPhotoPath().split(";");
			}
		}
		return new String[] {getOtherPhotoPath()};
	}

	public BigDecimal getGroupDiscount() {
		return groupDiscount;
	}

	public void setGroupDiscount(BigDecimal groupDiscount) {
		this.groupDiscount = groupDiscount;
	}

	public Long getBankAreaId() {
		return bankAreaId;
	}

	public void setBankAreaId(Long bankAreaId) {
		this.bankAreaId = bankAreaId;
	}

	public String getCartCode() {
		return cartCode;
	}

	public void setCartCode(String cartCode) {
		this.cartCode = cartCode;
	}

	public String getLicensecName() {
		return licensecName;
	}

	public void setLicensecName(String licensecName) {
		this.licensecName = licensecName;
	}

}