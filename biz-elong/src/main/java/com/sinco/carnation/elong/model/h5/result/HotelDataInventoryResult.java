package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinco.carnation.elong.model.elong.InventoryResult;

public class HotelDataInventoryResult extends BaseResult {

	
		 @JSONField(name="Result")
		private InventoryResult result;
		
		public InventoryResult getResult() {
			return result;
		}
		public void setResult(InventoryResult result) {
			this.result = result;
		}
}
