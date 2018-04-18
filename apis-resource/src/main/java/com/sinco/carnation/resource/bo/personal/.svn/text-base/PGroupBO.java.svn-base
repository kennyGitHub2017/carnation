package com.sinco.carnation.resource.bo.personal;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "PGroup", desc = "店铺详情")
public class PGroupBO {

	@JsonProperty("storeInfoBO")
	@FieldMapping(desc = "店铺信息")
	private PStoreInfoBO storeInfoBO;

	@JsonProperty("packageList")
	@FieldMapping(desc = "套餐券")
	private List<PGroupGoodsBO> packageList;

	@JsonProperty("cashList")
	@FieldMapping(desc = "现金券")
	private List<PGroupGoodsBO> cashList;

	public PStoreInfoBO getStoreInfoBO() {
		return storeInfoBO;
	}

	public void setStoreInfoBO(PStoreInfoBO storeInfoBO) {
		this.storeInfoBO = storeInfoBO;
	}

	public List<PGroupGoodsBO> getPackageList() {
		return packageList;
	}

	public void setPackageList(List<PGroupGoodsBO> packageList) {
		this.packageList = packageList;
	}

	public List<PGroupGoodsBO> getCashList() {
		return cashList;
	}

	public void setCashList(List<PGroupGoodsBO> cashList) {
		this.cashList = cashList;
	}

}
