package com.sinco.carnation.resource.vo.favorites;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class CancleFavoritesVO extends BasicParamVO {

	@Param(desc = "帖子ID")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String fid;

//	@Param(desc = "收藏类型1帖子2专家")
//	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
//	//private String type;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

}
