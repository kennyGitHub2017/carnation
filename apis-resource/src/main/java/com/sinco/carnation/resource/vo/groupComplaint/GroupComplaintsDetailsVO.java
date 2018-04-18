package com.sinco.carnation.resource.vo.groupComplaint;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class GroupComplaintsDetailsVO extends BasicParamVO {

	@Param(desc = "id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
