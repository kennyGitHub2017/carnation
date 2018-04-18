package com.sinco.carnation.resource.web.response.merchant;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinco.api.annotation.ReturnMapping;
import com.sinco.api.response.ApiResponse;

/**
 * 商户APP
 * 微信授权后用户数据校验
 * @author yuleijia
 *
 */
public class MerchantWeChatAutoCheckResponse extends ApiResponse{

	private static final long serialVersionUID = -2278540380634940334L;
	
	@JsonProperty("state")
	@ReturnMapping(desc = "校验后状态：10:默认状态无数据   100：新会员  200：是会员但没绑定手机号  300：是会员绑定手机号且是商户 310：是会员绑定手机号且不是商户  320:在审核中 330：审核失败")
	private Integer state;
	
	@JsonProperty("content")
	@ReturnMapping(desc = "状态描述")
	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
	
	

}
