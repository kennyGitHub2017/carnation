package com.sinco.carnation.juanpi.bo;

import java.util.Date;

import com.sinco.carnation.juanpi.model.JuanpiOrderGoods;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class JuanpiOrderGoodsBO extends JuanpiOrderGoods {
	private static final long serialVersionUID = 7499125389826962853L;
	private String orderNo;
	private Date addOrderTime;
	private Integer platId;
	private Long uid;

	public Date getAddOrderTime() {
		return addOrderTime;
	}

	public void setAddOrderTime(Date addOrderTime) {
		this.addOrderTime = addOrderTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public Integer getPlatId() {
		return platId;
	}

	public void setPlatId(Integer platId) {
		this.platId = platId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

}