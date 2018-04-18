package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "商户银行信息", domainName = "StoreBank")
public class StoreBankBO {

	/** 银行开户名 **/
	@JsonProperty("bankAccountName")
	@FieldMapping(desc = "银行开户名")
	private String bankAccountName;

	/** 公司银行账号 **/
	@JsonProperty("bankCAccount")
	@FieldMapping(desc = "公司银行账号")
	private String bankCAccount;

	/** 开户行支行名称 **/
	@JsonProperty("bankName")
	@FieldMapping(desc = "开户行支行名称 ")
	private String bankName;

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

}
