package com.sinco.carnation.resource.bo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.DomainMapping;
import com.sinco.api.annotation.FieldMapping;

@JsonAutoDetect(getterVisibility = Visibility.NONE)
@DomainMapping(domainName = "UserCustomer", desc = "用户信息")
public class CustomerBO {

	@JsonProperty("uid")
	@FieldMapping(desc = "用户Id")
	private Long uid;

	@JsonProperty("name")
	@FieldMapping(desc = "用户姓名")
	private String name;

	@JsonProperty("nickName")
	@FieldMapping(desc = "用户昵称")
	private String nickName;

	@JsonProperty("allergicHistory")
	@FieldMapping(desc = "药物过敏")
	private String allergicHistory;

	@JsonProperty("sex")
	@FieldMapping(desc = "性别")
	private Long sex;

	@JsonProperty("height")
	@FieldMapping(desc = "身高")
	private Long height;

	@JsonProperty("weight")
	@FieldMapping(desc = "体重")
	private Long weight;

	@JsonProperty("birthdate")
	@FieldMapping(desc = "生日")
	private String birthDay;

	@JsonProperty("email")
	@FieldMapping(desc = "邮箱")
	private String email;

	@JsonProperty("mobile")
	@FieldMapping(desc = "手机")
	private String mobile;

	@JsonProperty("status")
	@FieldMapping(desc = "用户状态")
	private String status;

	@JsonProperty("transHistory")
	@FieldMapping(desc = "家族药物过敏史")
	private String transHistory;

	@JsonProperty("transGenetic")
	@FieldMapping(desc = "家族遗传病史")
	private String transGenetic;

	@JsonProperty("headImgPath")
	@FieldMapping(desc = "用户头像")
	private String headImgPath;

	@JsonProperty("blood")
	@FieldMapping(desc = "血型")
	private String blood;

	@JsonProperty("invitationCode")
	@FieldMapping(desc = "邀请码")
	private String invitationCode;

	@JsonProperty("referee")
	@FieldMapping(desc = "推荐人")
	private String referee;

	@JsonProperty("merchant")
	@FieldMapping(desc = "隶属商户")
	private String merchant;

	@JsonProperty("isCloudPassword")
	@FieldMapping(desc = "是否已设置云豆密码")
	private boolean isCloudPassword = false;

	@JsonProperty("inviteNumber")
	@FieldMapping(desc = "邀请人数")
	private int inviteNumber;

	@JsonProperty("address")
	@FieldMapping(desc = "居住地址")
	private String address;

	@JsonProperty("userSignature")
	@FieldMapping(desc = "个性签名")
	private String userSignature;

	@JsonProperty("isCn")
	@FieldMapping(desc = "是否是CN账号")
	private Boolean isCn;

	@JsonProperty("idCard")
	@FieldMapping(desc = "身份证号")
	private String idCard;

	public Boolean getIsCn() {
		return isCn;
	}

	public void setIsCn(Boolean isCn) {
		this.isCn = isCn;
	}

	public int getInviteNumber() {
		return inviteNumber;
	}

	public void setInviteNumber(int inviteNumber) {
		this.inviteNumber = inviteNumber;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAllergicHistory() {
		return allergicHistory;
	}

	public void setAllergicHistory(String allergicHistory) {
		this.allergicHistory = allergicHistory;
	}

	public Long getSex() {
		return sex;
	}

	public void setSex(Long sex) {
		this.sex = sex;
	}

	public Long getHeight() {
		return height;
	}

	public void setHeight(Long height) {
		this.height = height;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransHistory() {
		return transHistory;
	}

	public String getTransGenetic() {
		return transGenetic;
	}

	public void setTransHistory(String transHistory) {
		this.transHistory = transHistory;
	}

	public void setTransGenetic(String transGenetic) {
		this.transGenetic = transGenetic;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public boolean isCloudPassword() {
		return isCloudPassword;
	}

	public void setCloudPassword(boolean isCloudPassword) {
		this.isCloudPassword = isCloudPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

}
