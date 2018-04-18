package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinco.carnation.elong.model.elong.CreateOrderResult;


public class HotelOrderCreateResult extends BaseResult {
	@JSONField(name="Result")
	private CreateOrderResult result;
	
	public CreateOrderResult getResult() {
		return result;
	}
	public void setResult(CreateOrderResult result) {
		this.result = result;
	}
}
