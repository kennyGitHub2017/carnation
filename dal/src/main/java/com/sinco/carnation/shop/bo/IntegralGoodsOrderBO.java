package com.sinco.carnation.shop.bo;

import com.sinco.carnation.shop.model.IntegralGoodsOrder;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class IntegralGoodsOrderBO extends IntegralGoodsOrder {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6046959763495758741L;

	private String loginName;
	private String email;
	private UserCustomer userCustomer;

	/**
	 * 云豆充值id
	 */
	private Long cashId;

	public Long getCashId() {
		return cashId;
	}

	public void setCashId(Long cashId) {
		this.cashId = cashId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}
}