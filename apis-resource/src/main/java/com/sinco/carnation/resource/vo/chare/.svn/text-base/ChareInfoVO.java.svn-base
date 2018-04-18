package com.sinco.carnation.resource.vo.chare;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

/**
 * 分享请求参数
 * 
 * @author yuleijia
 */
public class ChareInfoVO extends BasicParamVO {

	@Param(desc = "微商城域名")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String mobilePath;

	@Param(desc = "分享资源请求地址")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private String url;

	public String getMobilePath() {
		return mobilePath;
	}

	public void setMobilePath(String mobilePath) {
		this.mobilePath = mobilePath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
