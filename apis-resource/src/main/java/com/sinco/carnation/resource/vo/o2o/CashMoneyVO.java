package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class CashMoneyVO extends BasicParamVO {

	@Param(desc = "提现金额")
	@NotNull
	private Double cashAmount;

	@Param(desc = "提款方式|alipay_app|chinabank")
	@NotBlank
	private String cashPayment;

	@Param(desc = "提款人姓名")
	private String cashUserName;

	@Param(desc = "银行")
	private String cashBank;

	@Param(desc = "收款账号 ")
	private String cashAccount;

	@Param(desc = "取款密码")
	@NotBlank
	private String cashPassword;

	@Param(desc = "提现备注")
	private String cashInfo;

	@Param(desc = "提现用户|1商户2营运商")
	@NotNull
	private Integer userType;

	public Double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(Double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public String getCashPayment() {
		return cashPayment;
	}

	public void setCashPayment(String cashPayment) {
		this.cashPayment = cashPayment;
	}

	public String getCashUserName() {
		return cashUserName;
	}

	public void setCashUserName(String cashUserName) {
		this.cashUserName = cashUserName;
	}

	public String getCashBank() {
		return cashBank;
	}

	public void setCashBank(String cashBank) {
		this.cashBank = cashBank;
	}

	public String getCashAccount() {
		return cashAccount;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}

	public String getCashPassword() {
		return cashPassword;
	}

	public void setCashPassword(String cashPassword) {
		this.cashPassword = cashPassword;
	}

	public String getCashInfo() {
		return cashInfo;
	}

	public void setCashInfo(String cashInfo) {
		this.cashInfo = cashInfo;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

}
