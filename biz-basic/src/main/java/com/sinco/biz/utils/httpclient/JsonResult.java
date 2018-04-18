package com.sinco.biz.utils.httpclient;

public class JsonResult {
	private String code = "";
	private String desc = "";
	private Object data = "";
	private String tid = "";

	public JsonResult() {

	}

	public JsonResult(String code, String desc, Object data) {
		this.code = code;
		this.desc = desc;
		this.data = data;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public void setCode(String code) {
		this.code = code;
	}

	

}
