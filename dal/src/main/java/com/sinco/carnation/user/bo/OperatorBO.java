package com.sinco.carnation.user.bo;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import com.sinco.carnation.sys.contants.OperatorContants;
import com.sinco.carnation.sys.model.Area;
import com.sinco.carnation.user.model.Operator;
import com.sinco.dic.client.annotation.DicMappingModel;
import com.sinco.dic.client.annotation.DicNameMapping;

/**
 * 
 * BO 用于返回数据
 * 
 */
@DicMappingModel
public class OperatorBO extends Operator {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2223907476123898817L;
	private BigDecimal rebateConsumeAmount;
	private BigDecimal rebateFeeAmount;
	private BigDecimal currentWeekRebate;
	private BigDecimal currentMonthRebate;
	private Integer countShop;
	private Integer countShopMember;
	private Integer countRegisterUser;
	private Integer countRegisterUserOrder;
	@DicNameMapping(type = Area.class, codeField = "operatorAreaId", mergeChar = "-", isFull = true)
	private String areaName;
	private String password;
	private String invitationCode;

	private String refereeOperatorCode;
	private String refereeUserName;

	private String userStatus;
	/**
	 * 商城返润总额
	 */
	private BigDecimal b2cRebateAmount;
	/**
	 * o2o返润总额
	 */
	private BigDecimal o2oRebateAmount;
	/**
	 * 返润总额
	 */
	private BigDecimal rebateAmount;
	
	

	@SuppressWarnings("unused")
	private String levelName;

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

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public BigDecimal getCurrentWeekRebate() {
		if(currentWeekRebate == null){
			return BigDecimal.ZERO;
		}
		return currentWeekRebate.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setCurrentWeekRebate(BigDecimal currentWeekRebate) {
		this.currentWeekRebate = currentWeekRebate;
	}

	public BigDecimal getCurrentMonthRebate() {
		if(currentMonthRebate == null){
			return BigDecimal.ZERO;
		}
		return currentMonthRebate.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setCurrentMonthRebate(BigDecimal currentMonthRebate) {
		this.currentMonthRebate = currentMonthRebate;
	}

	public Integer getCountShopMember() {
		return countShopMember;
	}

	public void setCountShopMember(Integer countShopMember) {
		this.countShopMember = countShopMember;
	}

	public Integer getCountRegisterUser() {
		return countRegisterUser;
	}

	public void setCountRegisterUser(Integer countRegisterUser) {
		this.countRegisterUser = countRegisterUser;
	}

	public Integer getCountRegisterUserOrder() {
		return countRegisterUserOrder;
	}

	public void setCountRegisterUserOrder(Integer countRegisterUserOrder) {
		this.countRegisterUserOrder = countRegisterUserOrder;
	}

	public String getRefereeOperatorCode() {
		return refereeOperatorCode;
	}

	public void setRefereeOperatorCode(String refereeOperatorCode) {
		this.refereeOperatorCode = refereeOperatorCode;
	}

	public String getRefereeUserName() {
		return refereeUserName;
	}

	public void setRefereeUserName(String refereeUserName) {
		this.refereeUserName = refereeUserName;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getRebateConsumeAmount() {
		if(rebateConsumeAmount == null){
			return BigDecimal.ZERO;
		}
		return rebateConsumeAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setRebateConsumeAmount(BigDecimal rebateConsumeAmount) {
		this.rebateConsumeAmount = rebateConsumeAmount;
	}

	public BigDecimal getRebateFeeAmount() {
		if(rebateFeeAmount == null){
			return BigDecimal.ZERO;
		}
		return rebateFeeAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setRebateFeeAmount(BigDecimal rebateFeeAmount) {
		this.rebateFeeAmount = rebateFeeAmount;
	}

	public Integer getCountShop() {
		return countShop;
	}

	public void setCountShop(Integer countShop) {
		this.countShop = countShop;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getLevelName() {
		String levelName = OperatorContants.OPERATOR_LEVEL_NAME_9;
		if (null != this.getLevel()) {
			if (this.getLevel().equals(OperatorContants.OPERATOR_LEVEL_1)) {
				levelName = OperatorContants.OPERATOR_LEVEL_NAME_1;
			}
			if (this.getLevel().equals(OperatorContants.OPERATOR_LEVEL_2)) {
				levelName = OperatorContants.OPERATOR_LEVEL_NAME_2;
			}
			if (this.getLevel().equals(OperatorContants.OPERATOR_LEVEL_3)) {
				levelName = OperatorContants.OPERATOR_LEVEL_NAME_3;
			}
			if (this.getLevel().equals(OperatorContants.OPERATOR_LEVEL_7)) {
				levelName = OperatorContants.OPERATOR_LEVEL_NAME_7;
			}
			if (this.getLevel().equals(OperatorContants.OPERATOR_LEVEL_9)) {
				levelName = OperatorContants.OPERATOR_LEVEL_NAME_9;
			}
		}
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public BigDecimal getB2cRebateAmount() {
		if(b2cRebateAmount == null){
			return BigDecimal.ZERO;
		}
		return b2cRebateAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setB2cRebateAmount(BigDecimal b2cRebateAmount) {
		this.b2cRebateAmount = b2cRebateAmount;
	}

	public BigDecimal getO2oRebateAmount() {
		if(o2oRebateAmount == null){
			return BigDecimal.ZERO;
		}
		return o2oRebateAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setO2oRebateAmount(BigDecimal o2oRebateAmount) {
		this.o2oRebateAmount = o2oRebateAmount;
	}

	public BigDecimal getRebateAmount() {
		if(rebateAmount == null){
			return BigDecimal.ZERO;
		}
		return rebateAmount.setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public void setRebateAmount(BigDecimal rebateAmount) {
		this.rebateAmount = rebateAmount;
	}

}