package com.sinco.carnation.resource.vo.register;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.DateFormatValidate;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 
 * @author muxi
 * 
 */
public class RegisterAccountUpdateVO extends BasicParamVO {

	@Param(desc = "昵称|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String nickname;

	@Param(desc = "姓名|必须")
	private String name;

	@Param(desc = "身高|必须")
	// @NotNull(message=MsgCodeConstant.ERROR_PARAM)
	private Integer height;

	@Param(desc = "体重|必须")
	// @NotNull(message=MsgCodeConstant.ERROR_PARAM)
	private Integer weight;

	@Param(desc = "性别|1，男 2，女|必须")
	// @NotNull(message=MsgCodeConstant.ERROR_PARAM)
	// @Range(max=2,min=1,message=MsgCodeConstant.ERROR_PARAM)
	private Integer sex;

	@Param(desc = "手机|必须")
	private String mobile;

	@Param(desc = "生日|格式：yyyy-MM-dd")
	@DateFormatValidate(format = "yyyy-MM-dd")
	private String birthDate;

	@Param(desc = "电子邮箱")
	@Email(message = MsgCodeConstant.ERROR_PARAM)
	private String email;

	@Param(desc = "头像路径")
	private String headImgPath;

	@Param(desc = "药物过敏史")
	private String allergHistory;

	@Param(desc = "家族药物过敏史")
	private String transHistory;

	@Param(desc = "家族遗传病史")
	private String transGenetic;

	@Param(desc = "血型")
	@Pattern(regexp = "^((A)|(B)|(AB)|(O)|(OTHER))$", message = MsgCodeConstant.ERROR_PARAM)
	private String blood;

	@Param(desc = "用户个性签名")
	private String userSignature;

	public String getNickname() {
		return nickname;
	}

	public String getName() {
		return name;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getSex() {
		return sex;
	}

	public String getMobile() {
		return mobile;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getHeadImgPath() {
		return headImgPath;
	}

	public String getAllergHistory() {
		return allergHistory;
	}

	public String getTransHistory() {
		return transHistory;
	}

	public String getTransGenetic() {
		return transGenetic;
	}

	public String getBlood() {
		return blood;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}

	public void setAllergHistory(String allergHistory) {
		this.allergHistory = allergHistory;
	}

	public void setTransHistory(String transHistory) {
		this.transHistory = transHistory;
	}

	public void setTransGenetic(String transGenetic) {
		this.transGenetic = transGenetic;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

}
