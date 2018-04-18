package com.sinco.carnation.resource.vo.personal;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class PgoodsVO extends BasicParamVO {

	@Param(desc = "商品id逗号隔开|猜你喜欢列表需要此值")
	private String goodsId;

	@Param(desc = "商品id")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Long gId;

}
