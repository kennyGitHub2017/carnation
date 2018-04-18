package com.sinco.carnation.resource.web.response.personal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.carnation.resource.web.response.base.BaseJsonResult;

public class IntegralSwapResponse extends BaseJsonResult {
	/**
	 * 
	 */
	@JsonProperty("integral")
	@ReturnMapping(desc = "用户平台积分")
	private Integer integral;
	@JsonProperty("cnIntegral")
	@ReturnMapping(desc = "用户购物积分")
	private Integer cnIntegral;
	@JsonProperty("bonusRepeat")
	@ReturnMapping(desc = "用户重消")
	private Double bonusRepeat;
	@JsonProperty("status")
	@ReturnMapping(desc = "积分兑换状态100兑换成功 |12兑换积分必须大于0|13会员编号不能为空|15流水号不能为空|16同一流水号重复兑换|90交易密码不正确|91直销会员不存在|93请先修改初始交易密码|21积分不足|22非CN用户|23平台用户不存在|24系统错误")
	private Integer status;
	@JsonProperty("statusMsg")
	@ReturnMapping(desc = "兑换状态描述")
	private String statusMsg;
	@JsonProperty("isCN")
	@ReturnMapping(desc = "是否为CN用户")
	private boolean isCN;
	@JsonProperty("nickName")
	@ReturnMapping(desc = "用户昵称")
	private String nickName;
	@JsonProperty("headImgPath")
	@ReturnMapping(desc = "用户头像")
	private String headImgPath;
	
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public boolean isCN() {
		return isCN;
	}
	public void setCN(boolean isCN) {
		this.isCN = isCN;
	}
	public Double getBonusRepeat() {
		return bonusRepeat;
	}
	public void setBonusRepeat(Double bonusRepeat) {
		this.bonusRepeat = bonusRepeat;
	}
	public Integer getCnIntegral() {
		return cnIntegral;
	}
	public void setCnIntegral(Integer cnIntegral) {
		this.cnIntegral = cnIntegral;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getHeadImgPath() {
		return headImgPath;
	}
	public void setHeadImgPath(String headImgPath) {
		this.headImgPath = headImgPath;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
}
