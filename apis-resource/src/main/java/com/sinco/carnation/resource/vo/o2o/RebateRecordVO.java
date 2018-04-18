package com.sinco.carnation.resource.vo.o2o;

import com.sinco.api.annotation.Param;
import com.sinco.api.request.BasicParamVO;

public class RebateRecordVO extends BasicParamVO {

	@Param(desc = "订单状态|线上线下服务收入必传|1 线上订单  2 线下刷卡订单")
	private Integer orderType;

	@Param(desc = "开始时间")
	private String startTime;

	@Param(desc = "结束时间")
	private String endTime;

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

}
