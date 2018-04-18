/**   
 * @(#)HotelInvValidateApi.java	2016年11月21日	下午3:38:07	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.api;

import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.model.elong.HotelInvValidateCondition;
import com.sinco.carnation.elong.model.elong.HotelInvValidateResult;


/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午3:38:07   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@Service
public class HotelInvValidateApi extends BaseApi<HotelInvValidateCondition, HotelInvValidateResult>{

	@Override
	public String method() {
		return "hotel.inv.validate";
	}

	@Override
	public boolean isRequiredSSL() {
		return false;
	}
}
