package com.sinco.carnation.sns.bo;

import java.util.Date;
import java.util.List;

import com.sinco.carnation.sns.model.CheckResultReply;
import com.sinco.carnation.user.bo.UserCustomerBO;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class CheckResultReplyBO extends CheckResultReply {
	private List<CheckResultDetailsBO> checkResultDetailsBOList;
	private UserCustomerBO userCustomerBO;
	private int normalNumber, overproofNumber;
	private String nickname;
	private String mobile;
	private String email;
	private Date birthdate;

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public List<CheckResultDetailsBO> getCheckResultDetailsBOList() {
		return checkResultDetailsBOList;
	}

	public void setCheckResultDetailsBOList(List<CheckResultDetailsBO> checkResultDetailsBOList) {
		this.checkResultDetailsBOList = checkResultDetailsBOList;
	}

	public UserCustomerBO getUserCustomerBO() {
		return userCustomerBO;
	}

	public void setUserCustomerBO(UserCustomerBO userCustomerBO) {
		this.userCustomerBO = userCustomerBO;
	}

	public int getNormalNumber() {
		return normalNumber;
	}

	public void setNormalNumber(int normalNumber) {
		this.normalNumber = normalNumber;
	}

	public int getOverproofNumber() {
		return overproofNumber;
	}

	public void setOverproofNumber(int overproofNumber) {
		this.overproofNumber = overproofNumber;
	}
}