package com.sinco.carnation.resource.vo.favorites;

import org.hibernate.validator.constraints.NotBlank;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PraiseVO extends BasicParamVO {

	@Param(desc = "帖子id|必须")
	@NotBlank(message = MsgCodeConstant.ERROR_PARAM)
	private String fid;

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

}
