package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopTradePaymetVO extends BasicParamVO {

	@Param(desc = "支付方式:  alipay_app,wx_app")
	private String paymentType;

	@Param(desc = "主订单 id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long mainOrderId;

	@Param(desc = "是否用户云豆支付")
	private Boolean isUserMoneyPaymet;

	@Param(desc = "用户支付密码，如果为云豆支付该密码不能为空")
	private String paymetPassword;

	@Param(desc = "类型：1商城支付；2服务支付；3积分兑换支付")
	private Integer type;

	@Param(desc = "是否使用云购币支付")
	private Boolean isYunGouMoney;

	@Param(desc = "是否使用奖金支付/保留字段不用管true/false")
	private Boolean isBonusPay;

	@Param(desc = "云购币密码; 如果使用云购币 ,密码不能为空")
	private String bonusYunGouPwd;
	
	@Param(desc = "jj;cz;cash;balance,alipay_app,wx_app")
	private String payType;
	
	@Param(desc = "已支付云购币")
	private String actualygPrice;
	
	@Param(desc = "已支付现金")
	private String actualPrice;
	
	@Param(desc = "支付积分")
	private String actualJfPrice;
	

	public Boolean getIsUserMoneyPaymet() {
		return isUserMoneyPaymet;
	}

	public void setIsUserMoneyPaymet(Boolean isUserMoneyPaymet) {
		this.isUserMoneyPaymet = isUserMoneyPaymet;
	}

	public String getPaymetPassword() {
		return paymetPassword;
	}

	public void setPaymetPassword(String paymetPassword) {
		this.paymetPassword = paymetPassword;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Long getMainOrderId() {
		return mainOrderId;
	}

	public void setMainOrderId(Long mainOrderId) {
		this.mainOrderId = mainOrderId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getIsYunGouMoney() {
		return isYunGouMoney;
	}

	public void setIsYunGouMoney(Boolean isYunGouMoney) {
		this.isYunGouMoney = isYunGouMoney;
	}

	public String getBonusYunGouPwd() {
		return bonusYunGouPwd;
	}

	public void setBonusYunGouPwd(String bonusYunGouPwd) {
		this.bonusYunGouPwd = bonusYunGouPwd;
	}

	public Boolean getIsBonusPay() {
		return isBonusPay;
	}

	public void setIsBonusPay(Boolean isBonusPay) {
		this.isBonusPay = isBonusPay;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getActualygPrice() {
		return actualygPrice;
	}

	public void setActualygPrice(String actualygPrice) {
		this.actualygPrice = actualygPrice;
	}

	public String getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(String actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getActualJfPrice() {
		return actualJfPrice;
	}

	public void setActualJfPrice(String actualJfPrice) {
		this.actualJfPrice = actualJfPrice;
	}
	
}
