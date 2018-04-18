package com.sinco.carnation.shop.bo;

import com.sinco.carnation.shop.model.Predeposit;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class PredepositBO extends Predeposit {

	/**
	 * 会员名
	 */
	private String nickName;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long paymentId;

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

}