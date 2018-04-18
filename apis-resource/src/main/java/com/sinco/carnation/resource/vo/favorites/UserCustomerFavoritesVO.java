package com.sinco.carnation.resource.vo.favorites;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class UserCustomerFavoritesVO extends BasicParamVO {

	@Param(desc = "收藏内容的id")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String fid;

	@Param(desc = "类型1帖子2医生3商品 4店铺5服务6商户")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String type;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
