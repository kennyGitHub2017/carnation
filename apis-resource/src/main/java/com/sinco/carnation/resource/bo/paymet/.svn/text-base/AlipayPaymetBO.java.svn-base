package com.sinco.carnation.resource.bo.paymet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "AlipayPaymet", desc = "支付宝相关参数")
public class AlipayPaymetBO {

	@JsonProperty("safeKey")
	@FieldMapping(desc = "安全验证号")
	private String safeKey;

	@JsonProperty("sellerEmail")
	@FieldMapping(desc = "支付宝账号")
	private String sellerEmail;

	@JsonProperty("partner")
	@FieldMapping(desc = "合作者身份Id")
	private String partner;

	@JsonProperty("appPrivateKey")
	@FieldMapping(desc = "私钥")
	private String appPrivateKey;

	@JsonProperty("appPublicKey")
	@FieldMapping(desc = "公钥")
	private String appPublicKey;

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getAppPrivateKey() {
		return appPrivateKey;
	}

	public void setAppPrivateKey(String appPrivateKey) {
		this.appPrivateKey = appPrivateKey;
	}

	public String getAppPublicKey() {
		return appPublicKey;
	}

	public void setAppPublicKey(String appPublicKey) {
		this.appPublicKey = appPublicKey;
	}

	public String getSafeKey() {
		return safeKey;
	}

	public void setSafeKey(String safeKey) {
		this.safeKey = safeKey;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
}
