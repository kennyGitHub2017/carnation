package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopAddressVO extends BasicParamVO {

	@Param(desc = "地址id")
	private Long id;

	@Param(desc = "true为默认地址")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Boolean defaultValue;

	@Param(desc = "收货人姓名")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String trueName;

	@Param(desc = "收货人电话")
	private String telephone;

	@Param(desc = "收货人手机")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String mobile;

	@Param(desc = "地区")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long areaId;

	@Param(desc = "街道地址")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String areaInfo;

	@Param(desc = "邮编")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String zip;

	public String getTrueName() {
		return trueName;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public Long getAreaId() {
		return areaId;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public String getZip() {
		return zip;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Boolean defaultValue) {
		this.defaultValue = defaultValue;
	}
}
