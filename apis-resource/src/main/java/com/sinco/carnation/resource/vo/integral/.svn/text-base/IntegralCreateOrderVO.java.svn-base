package com.sinco.carnation.resource.vo.integral;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class IntegralCreateOrderVO extends BasicParamVO {
	@Param(desc = "积分商品：[{\"goodsId\":1,\"count\":2}]")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String goodsJson;

	@Param(desc = "收货地址ID")
	private Long addressId;

	@Param(desc = "收货人")
	private String trueName;

	@Param(desc = "收货地区ID")
	private Long areaId;

	@Param(desc = "邮政编码")
	private String zip;

	@Param(desc = "详细收货地址")
	private String areaInfo;

	@Param(desc = "联系手机")
	private String mobile;

	@Param(desc = "联系电话")
	private String telephone;

	@Param(desc = "兑换附言")
	private String igoMsg;

	public String getGoodsJson() {
		return goodsJson;
	}

	public void setGoodsJson(String goodsJson) {
		this.goodsJson = goodsJson;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getAreaInfo() {
		return areaInfo;
	}

	public void setAreaInfo(String areaInfo) {
		this.areaInfo = areaInfo;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getIgoMsg() {
		return igoMsg;
	}

	public void setIgoMsg(String igoMsg) {
		this.igoMsg = igoMsg;
	}
}
