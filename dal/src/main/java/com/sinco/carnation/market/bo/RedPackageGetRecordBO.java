package com.sinco.carnation.market.bo;

import com.sinco.carnation.market.model.RedPackageGetRecord;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class RedPackageGetRecordBO extends RedPackageGetRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8713740264838143199L;

	private String headImgPath;

	/** 名称 **/
	private String nickname;

	/** 邀请码 **/
	private String invitationCode;

	/** IP详情 **/
	private String ipDetail;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public String getIpDetail() {
		return ipDetail;
	}

	public void setIpDetail(String ipDetail) {
		this.ipDetail = ipDetail;
	}

}