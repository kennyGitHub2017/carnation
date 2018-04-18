package com.sinco.carnation.resource.vo.o2o;

import com.sinco.api.annotation.Param;
import com.sinco.api.util.BasicPageParamVo;

public class OperatorProfitVO extends BasicPageParamVo {

	@Param(desc = "开始时间|yyyy-MM-dd HH:mm:ss")
	private String startTime;

	@Param(desc = "结束时间|yyyy-MM-dd HH:mm:ss")
	private String endTime;

	@Param(desc = "查询类型|0全部(时间段),w本周统计,m本月统计,q本季统计,h本半年统计,y本年统计,a全部,t今日统计")
	private String queryType;

	@Param(desc = "请求类型|0 O2O , 1 B2C")
	private String type;

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

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
