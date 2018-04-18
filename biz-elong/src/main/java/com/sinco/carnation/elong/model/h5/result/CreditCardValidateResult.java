/**   
 * @(#)CreditCardValidateResult.java	2016年12月7日	下午1:52:50	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinco.carnation.elong.model.elong.ValidateCreditCardResult;

/**
 * 信用卡验证结果实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午1:52:50   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class CreditCardValidateResult extends BaseResult{
	
	@JSONField(name="Result")
	private ValidateCreditCardResult result;

	/**   
	 * 得到result的值   
	 *   
	 * @return result的值
	 */
	public ValidateCreditCardResult getResult() {
		return result;
	}

	/**
	 * 设置result的值
	 *   
	 * @param result 被设置的值
	 */
	public void setResult(ValidateCreditCardResult result) {
		this.result = result;
	}
}
