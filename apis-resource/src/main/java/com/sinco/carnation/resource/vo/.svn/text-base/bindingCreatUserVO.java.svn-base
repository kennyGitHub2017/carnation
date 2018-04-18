package com.sinco.carnation.resource.vo;

import javax.validation.constraints.NotNull;
import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class bindingCreatUserVO extends BasicParamVO {

	@Param(desc = "邀请码")
	private String InvitationCode;

	@Param(desc = "第三方平台id")
	private String openId;

	@Param(desc = "平台unionid")
	private String unionId;

	@Param(desc = "类型|3:QQ 4:微信5:微博")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer type;

	public String getInvitationCode() {
		return InvitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		InvitationCode = invitationCode;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
