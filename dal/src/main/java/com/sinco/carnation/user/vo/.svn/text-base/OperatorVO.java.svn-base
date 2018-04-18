package com.sinco.carnation.user.vo;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.sys.model.Area;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

@DicMappingModel
public class OperatorVO {
	@DicNameMapping(type = Area.class, codeField = "operatorAreaId", mergeChar = "-", isFull = true)
	private String areaName;

	private String userName;
	private String operatorCode;
	private String refereeUserName;
	private String refereeOperatorCode;
	private String level;
	private String idCard;
	private String operatorAreaId;
	private String startDate;
	private String endDate;
	private String status;
	private String phone;
	private String cashSn;
	private String cashStatus;
	private String cashPayment;
	private String cashPayStatus;

	private String isOwn;
	private String userLevel;
	private Long userId;
	private Integer userCode;

	private Long id;

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRefereeUserName() {
		return refereeUserName;
	}

	public void setRefereeUserName(String refereeUserName) {
		this.refereeUserName = refereeUserName;
	}

	public String getRefereeOperatorCode() {
		return refereeOperatorCode;
	}

	public void setRefereeOperatorCode(String refereeOperatorCode) {
		this.refereeOperatorCode = refereeOperatorCode;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(String operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getIsOwn() {
		return isOwn;
	}

	public void setIsOwn(String isOwn) {
		this.isOwn = isOwn;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getCashSn() {
		return cashSn;
	}

	public void setCashSn(String cashSn) {
		this.cashSn = cashSn;
	}

	public String getCashStatus() {
		return cashStatus;
	}

	public void setCashStatus(String cashStatus) {
		this.cashStatus = cashStatus;
	}

	public String getCashPayment() {
		return cashPayment;
	}

	public void setCashPayment(String cashPayment) {
		this.cashPayment = cashPayment;
	}

	public String getCashPayStatus() {
		return cashPayStatus;
	}

	public void setCashPayStatus(String cashPayStatus) {
		this.cashPayStatus = cashPayStatus;
	}

	public String getAreaSheng() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 0) {
				return areaArr[0];
			}
		}
		return null;
	}

	public String getAreaShi() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 1) {
				return areaArr[1];
			}
		}
		return null;
	}

	public String getAreaXian() {
		if (StringUtils.isNotEmpty(areaName)) {
			String[] areaArr = areaName.split("-");
			if (areaArr.length > 2) {
				return areaArr[2];
			}
		}
		return null;
	}

	public Integer getUserCode() {
		return userCode;
	}

	public void setUserCode(Integer userCode) {
		this.userCode = userCode;
	}

}