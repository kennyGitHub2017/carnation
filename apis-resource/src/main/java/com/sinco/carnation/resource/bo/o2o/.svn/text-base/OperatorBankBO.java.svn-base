package com.sinco.carnation.resource.bo.o2o;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(desc = "营运商银行信息", domainName = "OperatorBank")
public class OperatorBankBO {

	@JsonProperty("bankName")
	@FieldMapping(desc = "银行")
	private String bankName;

	@JsonProperty("subBankName")
	@FieldMapping(desc = "支行")
	private String subBankName;

	@JsonProperty("bankNo")
	@FieldMapping(desc = "卡号")
	private String bankNo;

	@JsonProperty("userName")
	@FieldMapping(desc = "姓名")
	private String userName;

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
