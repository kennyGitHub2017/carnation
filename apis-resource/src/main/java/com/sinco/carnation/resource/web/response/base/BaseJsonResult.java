package com.sinco.carnation.resource.web.response.base;

public class BaseJsonResult {

	/**
	 * 执行结果0-正常/1-错误
	 */
	private int m_status = 0;

	/**
	 * 错误编码
	 */
	private String m_errorCode = "";

	/**
	 * 错误信息
	 */
	private String m_errorMsg = "";

	public int getM_status() {
		return m_status;
	}

	public void setM_status(int m_status) {
		this.m_status = m_status;
	}

	public String getM_errorCode() {
		return m_errorCode;
	}

	public void setM_errorCode(String m_errorCode) {
		this.m_errorCode = m_errorCode;
	}

	public String getM_errorMsg() {
		return m_errorMsg;
	}

	public void setM_errorMsg(String m_errorMsg) {
		this.m_errorMsg = m_errorMsg;
	}

}
