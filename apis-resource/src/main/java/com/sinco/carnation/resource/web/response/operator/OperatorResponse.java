package com.sinco.carnation.resource.web.response.operator;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;
import com.sinco.carnation.resource.bo.o2o.OperatorAmountBO;
import com.sinco.carnation.resource.bo.o2o.OperatorProfitBO;
import com.sinco.carnation.resource.bo.o2o.OperatorRegisterUserListBO;
import com.sinco.carnation.resource.bo.o2o.OperatorRelationBO;
import com.sinco.carnation.resource.bo.operator.CashMoneyDetailsBO;
import com.sinco.carnation.resource.bo.operator.OperatorInfoBO;
import com.sinco.carnation.resource.bo.operator.OperatorManagementBO;
import com.sinco.carnation.resource.bo.operator.OperatorMemberBO;
import com.sinco.carnation.resource.bo.operator.OperatorProfitListBO;

public class OperatorResponse extends ApiResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("operatorInfo")
	@ReturnMapping(desc = "营运商信息")
	private OperatorInfoBO operatorInfo;

	@JsonProperty("cashMoneyDetailsBOs")
	@ReturnMapping(desc = "营运商提现明细")
	private List<CashMoneyDetailsBO> cashMoneyDetailsBOs;

	@JsonProperty("memberList")
	@ReturnMapping(desc = "营运商会员")
	private List<OperatorMemberBO> memberList;

	@JsonProperty("operatorList")
	@ReturnMapping(desc = "收益列表")
	private List<OperatorProfitListBO> operatorList;

	@JsonProperty("invitationCode")
	@ReturnMapping(desc = "营运商邀请码")
	private String invitationCode;

	@JsonProperty("operatorRebateList")
	@ReturnMapping(desc = "营运商商户管理")
	public List<OperatorManagementBO> operatorRebateList;

	@JsonProperty("operatorpProfitList")
	@ReturnMapping(desc = "营运商收益")
	private List<OperatorProfitBO> operatorpProfitList;

	@JsonProperty("profitTotal")
	@ReturnMapping(desc = "收益总计")
	private Double profitTotal;

	@JsonProperty("operatorRelation")
	@ReturnMapping(desc = "营运商关系统计")
	private OperatorRelationBO operatorRelation;

	@JsonProperty("todayOperatorRelation")
	@ReturnMapping(desc = "营运商今日新增关系统计")
	private OperatorRelationBO todayOperatorRelation;

	@JsonProperty("operatorRegisterList")
	@ReturnMapping(desc = "营运商注册会员列表")
	private List<OperatorRegisterUserListBO> operatorRegisterList;

	@JsonProperty("expectProfit")
	@ReturnMapping(desc = "预期收益")
	private List<OperatorProfitListBO> expectProfit;

	@JsonProperty("expectProfitTotal")
	@ReturnMapping(desc = "预期收益总额")
	private BigDecimal expectProfitTotal;

	@JsonProperty("isCN")
	@ReturnMapping(desc = "是否为CN账号(true=是  false=否)")
	private Boolean isCN;

	@JsonProperty("isFirst")
	@ReturnMapping(desc = "是否首次登陆(true=是  false=否)")
	private Boolean isFirst;

	@JsonProperty("isExamine")
	@ReturnMapping(desc = "是否已审核(0=审核中，1=审核通过，-1=审核不通过)")
	private String suditAtatus;

	@JsonProperty("operatorAmountBO")
	@ReturnMapping(desc = "营运商收益")
	private OperatorAmountBO operatorAmountBO;

	public String getSuditAtatus() {
		return suditAtatus;
	}

	public void setSuditAtatus(String suditAtatus) {
		this.suditAtatus = suditAtatus;
	}

	public Boolean getIsFirst() {
		return isFirst;
	}

	public void setIsFirst(Boolean isFirst) {
		this.isFirst = isFirst;
	}

	public Boolean getIsCN() {
		return isCN;
	}

	public void setIsCN(Boolean isCN) {
		this.isCN = isCN;
	}

	public OperatorInfoBO getOperatorInfo() {
		return operatorInfo;
	}

	public void setOperatorInfo(OperatorInfoBO operatorInfo) {
		this.operatorInfo = operatorInfo;
	}

	public List<CashMoneyDetailsBO> getCashMoneyDetailsBOs() {
		return cashMoneyDetailsBOs;
	}

	public void setCashMoneyDetailsBOs(List<CashMoneyDetailsBO> cashMoneyDetailsBOs) {
		this.cashMoneyDetailsBOs = cashMoneyDetailsBOs;
	}

	public List<OperatorMemberBO> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<OperatorMemberBO> memberList) {
		this.memberList = memberList;
	}

	public List<OperatorProfitListBO> getOperatorList() {
		return operatorList;
	}

	public void setOperatorList(List<OperatorProfitListBO> operatorList) {
		this.operatorList = operatorList;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public List<OperatorManagementBO> getOperatorRebateList() {
		return operatorRebateList;
	}

	public void setOperatorRebateList(List<OperatorManagementBO> operatorRebateList) {
		this.operatorRebateList = operatorRebateList;
	}

	public List<OperatorProfitBO> getOperatorpProfitList() {
		return operatorpProfitList;
	}

	public void setOperatorpProfitList(List<OperatorProfitBO> operatorpProfitList) {
		this.operatorpProfitList = operatorpProfitList;
	}

	public Double getProfitTotal() {
		return profitTotal;
	}

	public void setProfitTotal(Double profitTotal) {
		this.profitTotal = profitTotal;
	}

	public OperatorRelationBO getOperatorRelation() {
		return operatorRelation;
	}

	public void setOperatorRelation(OperatorRelationBO operatorRelation) {
		this.operatorRelation = operatorRelation;
	}

	public List<OperatorRegisterUserListBO> getOperatorRegisterList() {
		return operatorRegisterList;
	}

	public void setOperatorRegisterList(List<OperatorRegisterUserListBO> operatorRegisterList) {
		this.operatorRegisterList = operatorRegisterList;
	}

	public List<OperatorProfitListBO> getExpectProfit() {
		return expectProfit;
	}

	public void setExpectProfit(List<OperatorProfitListBO> expectProfit) {
		this.expectProfit = expectProfit;
	}

	public BigDecimal getExpectProfitTotal() {
		return expectProfitTotal;
	}

	public void setExpectProfitTotal(BigDecimal expectProfitTotal) {
		this.expectProfitTotal = expectProfitTotal;
	}

	public OperatorAmountBO getOperatorAmountBO() {
		return operatorAmountBO;
	}

	public void setOperatorAmountBO(OperatorAmountBO operatorAmountBO) {
		this.operatorAmountBO = operatorAmountBO;
	}

	public OperatorRelationBO getTodayOperatorRelation() {
		return todayOperatorRelation;
	}

	public void setTodayOperatorRelation(OperatorRelationBO todayOperatorRelation) {
		this.todayOperatorRelation = todayOperatorRelation;
	}

}
