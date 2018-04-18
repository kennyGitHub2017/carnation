package com.sinco.carnation.shop.bo;

import com.sinco.carnation.shop.model.OrderLog;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class OrderLogBO extends OrderLog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5064494457720669629L;
	private String loginName;
	private String nickName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}