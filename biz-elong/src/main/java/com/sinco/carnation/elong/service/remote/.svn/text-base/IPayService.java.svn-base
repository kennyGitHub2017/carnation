/**   
 * @(#)IPayService.java	2016年11月21日	下午4:01:29	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.service.remote;

import com.sinco.carnation.elong.model.h5.viewmodel.common.ResultInfo;
import com.sinco.carnation.elong.model.h5.viewmodel.pay.PaySubmitRequest;


/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年11月21日 下午4:01:29   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public interface IPayService {
	
	/**
	 * 
	 * 验证信用卡号是否有效
	 * Data属性标示是否需要提供CVV
	 *
	 * @param plainCardNo
	 * @return 
	 *
	 * @see com.elong.nb.service.IPayService#validateCreditCard(java.lang.String)
	 */
	public ResultInfo<Boolean> validateCreditCard(String plainCardNo);
	
	/**
	 * 
	 * 提交支付信息
	 *
	 * @param paySubmitReq
	 * @return
	 */
	public ResultInfo<Boolean> submitOrderPay(PaySubmitRequest paySubmitReq);
}
