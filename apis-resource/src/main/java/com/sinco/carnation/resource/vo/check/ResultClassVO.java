package com.sinco.carnation.resource.vo.check;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class ResultClassVO extends BasicParamVO {

	@Param(desc = "体检项名称")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
