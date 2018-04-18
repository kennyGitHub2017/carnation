package com.sinco.carnation.resource.vo.register;

import com.sinco.api.annotation.DateFormatValidate;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

/**
 * 
 * @author muxi
 * 
 */
public class UpdateAccountUpdateVO extends BasicParamVO {

	@Param(desc = "身高|必须")
	private Integer height;

	@Param(desc = "体重|必须")
	private Integer weight;

	@Param(desc = "用户昵称")
	private String nickname;

	@Param(desc = "性别|1，男 2，女|必须")
	private Integer sex;

	@Param(desc = "生日|格式：yyyy-MM-dd")
	@DateFormatValidate(format = "yyyy-MM-dd")
	private String birthDate;

	@Param(desc = "城市名(下拉框选择)")
	private String paddress;

	@Param(desc = "县区名(下拉框选择)")
	private String address;

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
