/**   
 * @(#)ValidateCreditCardApi.java	2016年12月7日	下午1:58:12	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.api;

import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.model.elong.ValidateCreditCardCondition;
import com.sinco.carnation.elong.model.h5.result.CreditCardValidateResult;

/**
 * 验证信用卡接口
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午1:58:12   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@Service
public class ValidateCreditCardApi extends BaseApi<ValidateCreditCardCondition, CreditCardValidateResult>{

	@Override
	public String method() {
		return "common.creditcard.validate";
	}

	@Override
	public boolean isRequiredSSL() {
		return true;
	}
	
}
