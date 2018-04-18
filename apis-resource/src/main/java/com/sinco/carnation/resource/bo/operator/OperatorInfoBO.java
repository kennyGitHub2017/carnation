package com.sinco.carnation.resource.bo.operator;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "OperatorInfo", desc = "营运商基本信息")
public class OperatorInfoBO {

	@JsonProperty("id")
	@FieldMapping(desc = "id")
	private Long id;

	@JsonProperty("userName")
	@FieldMapping(desc = "姓名")
	private String userName;

	@JsonProperty("sex")
	@FieldMapping(desc = "性别：1男，2女 ")
	private String sex;

	@JsonProperty("phone")
	@FieldMapping(desc = "手机")
	private String phone;

	@JsonProperty("address")
	@FieldMapping(desc = "联系地址")
	private String address;

	@JsonProperty("idCard")
	@FieldMapping(desc = "身份证号")
	private String idCard;

	@JsonProperty("nation")
	@FieldMapping(desc = "民族")
	private String nation;

	@JsonProperty("level")
	@FieldMapping(desc = "运营商级别：1市，2区，3vip经销商，7金卡经销商，9银卡经销商")
	private String level;

	@JsonProperty("levelName")
	@FieldMapping(desc = "运营商级别名称")
	private String levelName;

	@JsonProperty("area")
	@FieldMapping(desc = "营运商地区")
	private String area;// 营运商地区

	@JsonProperty("operatorAreaId")
	@FieldMapping(desc = "营运商地区")
	private String operatorAreaId;

	@JsonProperty("operatorName")
	@FieldMapping(desc = "营运商名称")
	private String operatorName;// 营运商名称

	@JsonProperty("refereeName")
	@FieldMapping(desc = "推荐人")
	private String refereeName;

	@JsonProperty("bankName")
	@FieldMapping(desc = "开户行")
	private String bankName;

	@JsonProperty("subBankName")
	@FieldMapping(desc = "支行")
	private String subBankName;

	@JsonProperty("bankNo")
	@FieldMapping(desc = "帐号")
	private String bankNo;

	@JsonProperty("organizationNo")
	@FieldMapping(desc = "组织机构代码 ")
	private String organizationNo;

	@JsonProperty("organizationPath")
	@FieldMapping(desc = "组织机构代码证图片")
	private String organizationPath;

	@JsonProperty("registrationPath")
	@FieldMapping(desc = "营业执照图片")
	private String registrationPath;

	@JsonProperty("taxPath")
	@FieldMapping(desc = "税务登记证图片地址 ")
	private String taxPath;

	/** 营业执照号 **/
	@JsonProperty("registrationNo")
	@FieldMapping(desc = "营业执照号")
	private String registrationNo;

	/** 税务登记证号 **/
	@JsonProperty("taxNo")
	@FieldMapping(desc = "税务登记证号 ")
	private String taxNo;

	/** 运营商编码 **/
	@JsonProperty("operatorCode")
	@FieldMapping(desc = "运营商编码")
	private String operatorCode;

	@JsonProperty("invitationCode")
	@FieldMapping(desc = "邀请码")
	private String invitationCode;

	@JsonProperty("inviteNumber")
	@FieldMapping(desc = "邀请人数")
	private int inviteNumber;

	@JsonProperty("todayVipNumber")
	@FieldMapping(desc = "新增会员")
	private int todayVipNumber;

	@JsonProperty("totalAmount")
	@FieldMapping(desc = "收益总额")
	private double totalAmount;

	@JsonProperty("O2oTotalAmount")
	@FieldMapping(desc = "o2o收益总额")
	private double O2oTotalAmount;

	@JsonProperty("B2cTotalAmount")
	@FieldMapping(desc = "b2c收益总额")
	private double B2cTotalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
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

	public String getOrganizationNo() {
		return organizationNo;
	}

	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}

	public String getOrganizationPath() {
		return organizationPath;
	}

	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	public String getRegistrationPath() {
		return registrationPath;
	}

	public void setRegistrationPath(String registrationPath) {
		this.registrationPath = registrationPath;
	}

	public String getTaxPath() {
		return taxPath;
	}

	public void setTaxPath(String taxPath) {
		this.taxPath = taxPath;
	}

	public String getOperatorAreaId() {
		return operatorAreaId;
	}

	public void setOperatorAreaId(String operatorAreaId) {
		this.operatorAreaId = operatorAreaId;
	}

	public String getRefereeName() {
		return refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getOperatorCode() {
		return operatorCode;
	}

	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getInviteNumber() {
		return inviteNumber;
	}

	public void setInviteNumber(int inviteNumber) {
		this.inviteNumber = inviteNumber;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getO2oTotalAmount() {
		return O2oTotalAmount;
	}

	public void setO2oTotalAmount(double o2oTotalAmount) {
		O2oTotalAmount = o2oTotalAmount;
	}

	public double getB2cTotalAmount() {
		return B2cTotalAmount;
	}

	public void setB2cTotalAmount(double b2cTotalAmount) {
		B2cTotalAmount = b2cTotalAmount;
	}

	public int getTodayVipNumber() {
		return todayVipNumber;
	}

	public void setTodayVipNumber(int todayVipNumber) {
		this.todayVipNumber = todayVipNumber;
	}

}
