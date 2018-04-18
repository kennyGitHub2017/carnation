package com.sinco.carnation.kuaidi100.pojo;

import com.thoughtworks.xstream.XStream;

/**
 * 
 * <p>
 * Title: NoticeResponse.java
 * </p>
 * 
 * <p>
 * Description: 该实体类来自快递100提供的接口
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * 
 * <p>
 * Company: 新科聚合 thinker.vc
 * </p>
 * 
 * @author thinker
 * 
 * @date 2014-12-9
 * 
 * @version 1.0.1
 */
public class NoticeResponse {
	private static XStream xstream;

	private Boolean result;
	private String returnCode;
	private String message;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private static XStream getXStream() {
		if (xstream == null) {
			xstream = new XStream();
			xstream.autodetectAnnotations(true);
			xstream.alias("pushResponse", NoticeResponse.class);
		}
		return xstream;
	}

	public String toXml() {
		return "<?xml version='1.0' encoding='UTF-8'?>\r\n" + getXStream().toXML(this);
	}

	public static NoticeResponse fromXml(String sXml) {
		return (NoticeResponse) getXStream().fromXML(sXml);
	}

	public static void main(String[] args) {
		NoticeResponse req = new NoticeResponse();
		req.setMessage("成功");
		req.setResult(true);
		req.setReturnCode("200");
		System.out.print(req.toXml());
	}
}
