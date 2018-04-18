package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "StoreApplyInfo", desc = "商户审核")
public class ApplyInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("storeStatus")
	@FieldMapping(desc = "店铺状态，0为提交开店申请，1运营商审批,2运营商审批失败 5平台审核,6平台审核失败,10第三方支付审核,11第三方支付审批失败,15为正常营业（审核成功）,20违规关闭 , 25到期关闭,26,到期后申请续费'")
	private Integer storeStatus;

	/** 是否安装刷卡机 **/
	@JsonProperty("isEepay")
	@FieldMapping(desc = "是否安装刷卡机")
	private Boolean isEepay;

	@JsonProperty("failReseaon")
	@FieldMapping(desc = "商户申请失败原因")
	private String failReseaon;// 商户申请失败原因

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(Integer storeStatus) {
		this.storeStatus = storeStatus;
	}

	public Boolean getIsEepay() {
		return isEepay;
	}

	public void setIsEepay(Boolean isEepay) {
		this.isEepay = isEepay;
	}

	public String getFailReseaon() {
		return failReseaon;
	}

	public void setFailReseaon(String failReseaon) {
		this.failReseaon = failReseaon;
	}

}
