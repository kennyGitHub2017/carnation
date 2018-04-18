package com.sinco.carnation.aio.bo;

import com.sinco.carnation.aio.model.SysDia;
import com.sinco.dic.client.annotation.DicMappingModel;

/**
 * 
 * 血压 用于返回数据
 * 
 */
@DicMappingModel
public class SysDiaBO extends SysDia {
	private static final long serialVersionUID = -3224651745981479252L;
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}