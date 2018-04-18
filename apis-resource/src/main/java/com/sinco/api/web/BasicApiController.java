package com.sinco.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinco.api.response.ApiResponse;
import com.sinco.api.response.ErrorCommonResponse;
import com.sinco.biz.common.service.ServiceException;

public class BasicApiController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 用于处理异常的
	 * 
	 * @return
	 */
	@ExceptionHandler({ServiceException.class})
	public @ResponseBody
	ApiResponse exception(Exception e) {
		ApiResponse apiResponse = new ErrorCommonResponse();
		/*	 if(e instanceof Exception){
				 //错误处理
				apiResponse.putErrorMessage("2.code");
				

			 }else*/
		if (e instanceof ServiceException) {
			log.error("调用SDK 出错误", e);
			apiResponse.putErrorMessage(((ServiceException) e).getErrorCode());
		}
		return apiResponse;
	}
}
