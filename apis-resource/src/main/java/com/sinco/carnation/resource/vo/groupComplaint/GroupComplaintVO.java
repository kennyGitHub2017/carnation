package com.sinco.carnation.resource.vo.groupComplaint;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class GroupComplaintVO extends BasicPageParamVo {

	@Param(desc = "id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Param(desc = "名称搜索")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Param(desc = "投诉状态：1为处理中，3为已完成|必须")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
