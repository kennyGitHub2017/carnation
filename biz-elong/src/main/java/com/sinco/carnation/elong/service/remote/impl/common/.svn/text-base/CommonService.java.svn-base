/**   
 * @(#)CommonService.java	2016年12月12日	下午2:06:49	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.service.remote.impl.common;

import org.springframework.stereotype.Service;

import com.sinco.carnation.elong.model.elong.EnumOrderStatus;
import com.sinco.carnation.elong.model.elong.EnumShowStatus;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月12日 下午2:06:49   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@Service
public class CommonService {

	/**
	 * 
	 * 是否需要或者继续支付
	 * 可支付状态 =（status in (N, V, A, H)） && (ShowStatus in (1, 2, 8, 8192))
	 *
	 * @param status
	 * @param showStatus
	 * @return
	 */
	public boolean isNeedPay(String status, long showStatus){
		if(status == null){
			return false;
		}
		
		if((status.equals(EnumOrderStatus.N.value()) 
				|| status.equals(EnumOrderStatus.V.value()) 
				|| status.equals(EnumOrderStatus.A.value()) 
				|| status.equals(EnumOrderStatus.H.value())) 
				&& 
				(showStatus == EnumShowStatus.GuaranteeFailed.getValue()
				|| showStatus == EnumShowStatus.WaitGuarantee.getValue()
				|| showStatus == EnumShowStatus.WaitPay.getValue()
				|| showStatus == EnumShowStatus.PayFailed.getValue())){
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * 获取错误码
	 *
	 * @param code
	 * @return
	 */
	public String getErrorCode(String code){
		if(code == null || "".equals(code)){
			return "";
		}
		return (code.split("\\|"))[0]; 
	}
}
