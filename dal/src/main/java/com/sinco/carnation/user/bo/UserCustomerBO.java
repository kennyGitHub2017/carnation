package com.sinco.carnation.user.bo;

import java.math.BigDecimal;
import java.util.Date;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.model.UserAccount;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class UserCustomerBO extends UserCustomer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserCustomerBO parentBO;
	private UserAccount userAccount;
	private String loginName;
	private Date lastLoginTime;
	private String lastLoginIp;
	private Long refreeUserId;
	private String birthDay;
	private Long refereeUserId;
	private Date registerTime;
	private Long id;
	private String freezed;
	/**
	 * 如果个人是有店铺
	 */
	private Long storeId;
	private Long storeIdTwo;

	/** 可用余额 个人 **/
	private BigDecimal availableBalance;
	/** 可用余额 商户 **/
	private BigDecimal o2oBalance;
	/** 可用余额 供应商 **/
	private BigDecimal b2cBalance;
	/** 可用余额 运营商 **/
	private BigDecimal yysBalance;

	private Integer relationType;

	private Date accountCreateTime;

	private String sellerNickName;
	private Long ownOperatorId;
	private OperatorBO operator;
	private BigDecimal totlePrice;
	private String storeName;
	private int num;

	private String invitationCode;

	private String reUserName;// 推荐人
	private String reInvitationCode;// 推荐人邀请码
	private String reMobile;// 推荐人
	private String operatorName;
	private String userStatus;
	private Long sellerUid;// 卖家用户id
	private String extend;
	// 身份证号
	private String idCard;

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getReMobile() {
		return reMobile;
	}

	public void setReMobile(String reMobile) {
		this.reMobile = reMobile;
	}

	public Long getRefreeUserId() {
		return refreeUserId;
	}

	public void setRefreeUserId(Long refreeUserId) {
		this.refreeUserId = refreeUserId;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public BigDecimal getTotlePrice() {
		return totlePrice;
	}

	public void setTotlePrice(BigDecimal totlePrice) {
		this.totlePrice = totlePrice;
	}

	public OperatorBO getOperator() {
		return operator;
	}

	public void setOperator(OperatorBO operator) {
		this.operator = operator;
	}

	public String getSellerNickName() {
		return sellerNickName;
	}

	public void setSellerNickName(String sellerNickName) {
		this.sellerNickName = sellerNickName;
	}

	public Long getOwnOperatorId() {
		return ownOperatorId;
	}

	public void setOwnOperatorId(Long ownOperatorId) {
		this.ownOperatorId = ownOperatorId;
	}

	public BigDecimal getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(BigDecimal availableBalance) {
		this.availableBalance = availableBalance;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public UserCustomerBO getParentBO() {
		return parentBO;
	}

	public void setParentBO(UserCustomerBO parentBO) {
		this.parentBO = parentBO;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getLoginName() {
		return loginName;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getBirthDay() {
		if (null != getBirthdate()) {
			return CommUtil.formatShortDate(getBirthdate().getTime());
		}
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Integer getRelationType() {
		return relationType;
	}

	public void setRelationType(Integer relationType) {
		this.relationType = relationType;
	}

	public Date getAccountCreateTime() {
		return accountCreateTime;
	}

	public void setAccountCreateTime(Date accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFreezed() {
		return freezed;
	}

	public void setFreezed(String freezed) {
		this.freezed = freezed;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getReUserName() {
		return reUserName;
	}

	public void setReUserName(String reUserName) {
		this.reUserName = reUserName;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Long getSellerUid() {
		return sellerUid;
	}

	public void setSellerUid(Long sellerUid) {
		this.sellerUid = sellerUid;
	}

	public Long getRefereeUserId() {
		return refereeUserId;
	}

	public void setRefereeUserId(Long refereeUserId) {
		this.refereeUserId = refereeUserId;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getReInvitationCode() {
		return reInvitationCode;
	}

	public void setReInvitationCode(String reInvitationCode) {
		this.reInvitationCode = reInvitationCode;
	}

	public BigDecimal getO2oBalance() {
		return o2oBalance;
	}

	public void setO2oBalance(BigDecimal o2oBalance) {
		this.o2oBalance = o2oBalance;
	}

	public BigDecimal getB2cBalance() {
		return b2cBalance;
	}

	public void setB2cBalance(BigDecimal b2cBalance) {
		this.b2cBalance = b2cBalance;
	}

	public BigDecimal getYysBalance() {
		return yysBalance;
	}

	public void setYysBalance(BigDecimal yysBalance) {
		this.yysBalance = yysBalance;
	}

	public Long getStoreIdTwo() {
		return storeIdTwo;
	}

	public void setStoreIdTwo(Long storeIdTwo) {
		this.storeIdTwo = storeIdTwo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}