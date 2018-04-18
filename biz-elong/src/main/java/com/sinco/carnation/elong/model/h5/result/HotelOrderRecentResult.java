package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinco.carnation.elong.model.elong.RecentOrderTimeResult;

public class HotelOrderRecentResult extends BaseResult {
	@JSONField(name = "Result")
	private RecentOrderTimeResult result;

	public RecentOrderTimeResult getResult() {
		return result;
	}

	public void setResult(RecentOrderTimeResult result) {
		this.result = result;
	}
	

}
