/**   
 * @(#)PayIndexRequest.java	2016年12月6日	下午2:10:26	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.order;

/**
 * 支付结果页
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月6日 下午2:10:26   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class OrderResultRequest {
	/**
	 * 订单ID
	 */
	private Long orderId;

	/**   
	 * 得到orderId的值   
	 *   
	 * @return orderId的值
	 */
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 设置orderId的值
	 *   
	 * @param orderId 被设置的值
	 */
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
