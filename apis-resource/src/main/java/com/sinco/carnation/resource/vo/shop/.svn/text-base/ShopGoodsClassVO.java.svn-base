package com.sinco.carnation.resource.vo.shop;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class ShopGoodsClassVO extends BasicParamVO {

	@Param(desc = "商品分类编号|1一级2二级3三级")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer classNum;

	@Param(desc = "商品分类编号|第一级为空")
	private Long classId;

	public Integer getClassNum() {
		return classNum;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassNum(Integer classNum) {
		this.classNum = classNum;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}
