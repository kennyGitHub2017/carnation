/**   
 * @(#)CardValidateRequest.java	2016年12月7日	下午2:28:47	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.h5.viewmodel.pay;

/**
 * (类型功能说明描述)
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午2:28:47   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
public class CardValidateRequest {
	
	/**
	 * 信用卡号
	 */
	private String cardNo;

	/**   
	 * 得到cardNo的值   
	 *   
	 * @return cardNo的值
	 */
	public String getCardNo() {
		return cardNo;
	}

	/**
	 * 设置cardNo的值
	 *   
	 * @param cardNo 被设置的值
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
}
