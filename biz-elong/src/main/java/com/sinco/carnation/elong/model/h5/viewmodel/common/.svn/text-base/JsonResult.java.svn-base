package com.sinco.carnation.elong.model.h5.viewmodel.common;

import java.io.Serializable;

public class JsonResult<E> implements Serializable{
	private static final long serialVersionUID = -5080067791922599325L;

	public JsonResult(){
		this.state = false;
        this.errorCode = "1";
        this.msg = "failed";
	}
	
	public JsonResult(Boolean state, String errorCode, String msg){
		this.state = state;
        this.errorCode = errorCode;
        this.msg = msg;
	}
	
	private Boolean state;
	
	private String errorCode;
	
	private String msg;
	
	private E data;
	
	public void setState(Boolean state){
		this.state = state;
	}
	
	public Boolean getState(){
		return this.state;
	}
	
	public void setErrorCode(String errorCode){
		this.errorCode = errorCode;
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public void setData(E data){
		this.data = data;
	}
	
	public E getData(){
		return this.data;
	}
}
