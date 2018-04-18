package com.sinco.carnation.resource.vo.o2o;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class OperatorVO extends BasicParamVO {

	@Param(desc = "身份证")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String idCard;

	@Param(desc = "运营地")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String operatorAreaId;

	@Param(desc = "手机号码")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String phone;

	@Param(desc = "姓名")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String userName;

	@Param(desc = "性别")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String sex;

	@Param(desc = "民族")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String nation;

	@Param(desc = "开卡行")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String bankName;

	@Param(desc = "开户支行")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String subBankName;

	@Param(desc = "银行账户")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String bankNo;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSubBankName() {
		return subBankName;
	}

	public void setSubBankName(String subBankName) {
		this.subBankName = subBankName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

}
