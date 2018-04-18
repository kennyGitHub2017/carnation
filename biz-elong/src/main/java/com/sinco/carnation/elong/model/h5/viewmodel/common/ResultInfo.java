package com.sinco.carnation.elong.model.h5.viewmodel.common;

import java.io.Serializable;

/**
 * 公用实体
 * @author 高乃峰
 *
 * @param <E>
 */
public class ResultInfo<E> implements Serializable{

	private static final long serialVersionUID = 3308127197317129191L;

	private Boolean isSuccess;
	
	private String msg;
	
	private E data;
	
	public ResultInfo(){
		this.isSuccess = false;
		this.msg = "error";
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}
	
}
