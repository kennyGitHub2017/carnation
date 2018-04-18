/**   
 * @(#)HotelDataValidateApi.java	2016年11月21日	下午3:18:09	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.api;

import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.model.elong.ValidateCondition;
import com.sinco.carnation.elong.model.h5.result.HotelDataValidateResult;


/**
 * 酒店库存验证
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午3:18:09   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@Service
public class HotelDataValidateApi extends BaseApi<ValidateCondition, HotelDataValidateResult>{
	@Override
	public String method() {
		return "hotel.data.validate";
	}

	@Override
	public boolean isRequiredSSL() {
		return false;
	}
}
