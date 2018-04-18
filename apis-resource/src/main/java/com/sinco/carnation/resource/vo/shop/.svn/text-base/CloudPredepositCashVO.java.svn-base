package com.sinco.carnation.resource.vo.shop;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CloudPredepositCashVO extends BasicParamVO {

	@Param(desc = "提现金额")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private BigDecimal cashAmount;

	@Param(desc = "提现方式")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String cashPayment;

	@Param(desc = "收款人姓名")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String cashUserName;

	@Param(desc = "收款银行")
	private String cashBank;

	@Param(desc = "收款账号")
	private String cashAccount;

	@Param(desc = "提现密码")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String cashPassword;

	@Param(desc = "提现备注")
	private String cashInfo;

	@Param(desc = "用户类型")
	private Integer userType;

	@Param(desc = "银行支行")
	private String cashSubbranch;

	@Param(desc = "提现类型0,web端1,APP端")
	private Integer cashRelation;

	@Param(desc = "云豆提现id")
	private Long cashId;

	public Long getCashId() {
		return cashId;
	}

	public void setCashId(Long cashId) {
		this.cashId = cashId;
	}

	public String getCashSubbranch() {
		return cashSubbranch;
	}

	public void setCashSubbranch(String cashSubbranch) {
		this.cashSubbranch = cashSubbranch;
	}

	public Integer getCashRelation() {
		return cashRelation;
	}

	public void setCashRelation(Integer cashRelation) {
		this.cashRelation = cashRelation;
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
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