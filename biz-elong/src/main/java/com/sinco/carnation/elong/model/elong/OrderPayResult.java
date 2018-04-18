/**   
 * @(#)OrderPayResult.java	2016年12月7日	下午2:13:36	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.elong;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 支付结果实体
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午2:13:36   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderPayResult", propOrder = {
    "isSuccess",
    "notes"
})
public class OrderPayResult {

	@JSONField(name = "IsSuccess")
	protected Boolean isSuccess;
	
	@JSONField(name = "Notes")
	protected String notes;

	/**   
	 * 得到isSuccess的值   
	 *   
	 * @return isSuccess的值
	 */
	public Boolean getIsSuccess() {
		return isSuccess;
	}

	/**
	 * 设置isSuccess的值
	 *   
	 * @param isSuccess 被设置的值
	 */
	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	/**   
	 * 得到notes的值   
	 *   
	 * @return notes的值
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * 设置notes的值
	 *   
	 * @param notes 被设置的值
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
