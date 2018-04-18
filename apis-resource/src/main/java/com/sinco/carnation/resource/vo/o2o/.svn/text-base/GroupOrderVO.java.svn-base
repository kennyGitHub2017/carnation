package com.sinco.carnation.resource.vo.o2o;

import javax.validation.constraints.NotNull;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;
import com.sinco.carnation.resource.constant.MsgCodeConstant;

public class GroupOrderVO extends BasicPageParamVo {

	@Param(desc = "订单状态|0为订单取消，10为已提交待付款，20为已付款，30为买家已使用，全部使用后更新该值,50买家评价完毕 ,60卖家已评价,65订单不可评价")
	private Integer orderStatus;

	@Param(desc = "订单类型|1线上订单2线下订单")
	@NotNull(message = MsgCodeConstant.ERROR_PARAM)
	private Integer orderType;

	@Param(desc = "线下订单状态")
	private Integer localStatus;

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public Integer getLocalStatus() {
		return localStatus;
	}

	public void setLocalStatus(Integer localStatus) {
		this.localStatus = localStatus;
	}
}