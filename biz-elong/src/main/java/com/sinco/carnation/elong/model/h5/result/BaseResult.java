package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;


public class BaseResult {

 	@JSONField(name="Code")
	private String code;
 	
// 	@XmlElement(name = "Code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
		
}
