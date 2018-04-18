package com.sinco.carnation.sys.bo;

import com.sinco.carnation.sys.model.User;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class RelationBO extends User {

	private static final long serialVersionUID = 1L;

	/** 推荐人所属商户id **/
	private Integer sellerUserId;

	private Integer refereeUserId;

	private String areaName;

	/** shopareaid 商户所在城市id **/
	private Integer sid;

	public Integer getSellerUserId() {
		return sellerUserId;
	}

	public void setSellerUserId(Integer sellerUserId) {
		this.sellerUserId = sellerUserId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Integer getRefereeUserId() {
		return refereeUserId;
	}

	public void setRefereeUserId(Integer refereeUserId) {
		this.refereeUserId = refereeUserId;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

}