package com.sinco.carnation.user.bo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.user.model.Seller;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@DicMappingModel
public class SellerBO extends Seller {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2370011896114675541L;

	private Store store;
	private String loginName;
	private String gcName;
	@DicNameMapping(type = Area.class, isFull = true, mergeChar = "", codeField = "store.areaId")
	private String areaName;
	private BigDecimal rebateConsumeAmount;
	private BigDecimal rebateFeeAmount;
	private Integer userCount;
	private String shopName;
	private String shopAddress;

	public String getShopAddress() {
		shopAddress = "";
		if (StringUtils.isNotEmpty(areaName)) {
			shopAddress = shopAddress + areaName;
		}
		if (store != null && StringUtils.isNotEmpty(store.getStoreAddress())) {
			shopAddress = shopAddress + store.getStoreAddress();
		}
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopName() {
		if (store != null) {
			return store.getStoreName();
		}
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public BigDecimal getRebateFeeAmount() {
		return rebateFeeAmount;
	}

	public void setRebateFeeAmount(BigDecimal rebateFeeAmount) {
		this.rebateFeeAmount = rebateFeeAmount;
	}

	public String getGcName() {
		return gcName;
	}

	public void setGcName(String gcName) {
		this.gcName = gcName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public BigDecimal getRebateConsumeAmount() {
		return rebateConsumeAmount;
	}

	public void setRebateConsumeAmount(BigDecimal rebateConsumeAmount) {
		this.rebateConsumeAmount = rebateConsumeAmount;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
}