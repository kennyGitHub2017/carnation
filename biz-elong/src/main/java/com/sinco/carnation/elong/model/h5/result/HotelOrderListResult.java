/**   
 * @(#)HotelOrderListResult.java	2016年12月7日	上午10:51:40	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.sinco.carnation.elong.model.elong.OrderListResult;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 上午10:51:40   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class HotelOrderListResult extends BaseResult{
	
	@JSONField(name="Result")
	private OrderListResult result;

	/**   
	 * 得到result的值   
	 *   
	 * @return result的值
	 */
	public OrderListResult getResult() {
		return result;
	}

	/**
	 * 设置result的值
	 *   
	 * @param result 被设置的值
	 */
	public void setResult(OrderListResult result) {
		this.result = result;
	}
}
