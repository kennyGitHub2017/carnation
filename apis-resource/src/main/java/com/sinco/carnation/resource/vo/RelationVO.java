package com.sinco.carnation.resource.vo;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class RelationVO extends BasicPageParamVo {
	@Param(desc = "会员级别 1,2,3")
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
