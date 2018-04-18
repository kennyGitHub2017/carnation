/**   
 * @(#)OrderPayCondition.java	2016年12月7日	下午2:06:21	   
 *     
 * Copyrights (C) 2016艺龙旅行网保留所有权利
 */
package com.sinco.carnation.elong.model.elong;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * hotel.order.pay接口请求参数
 *
 * <p>
 * 修改历史:											<br>  
 * 修改日期    		修改人员   	版本	 		修改内容<br>  
 * -------------------------------------------------<br>  
 * 2016年12月7日 下午2:06:21   user     1.0    	初始化创建<br>
 * </p> 
 *
 * @author		user 
 * @version		1.0  
 * @since		JDK1.7
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderPayCondition", propOrder = {
    "orderId",
    "isGuaranteeOrCharged",
    "creditCard",
    "Amount"
})
public class OrderPayCondition {
	
	@JSONField(name = "OrderId")
	protected Long orderId;
	
	@JSONField(name = "IsGuaranteeOrCharged")
	protected Boolean isGuaranteeOrCharged;
	
	@JSONField(name = "CreditCard")
	protected CreditCard creditCard;
	
	@JSONField(name = "Amount")
	protected BigDecimal amount;

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

	/**   
	 * 得到isGuaranteeOrCharged的值   
	 *   
	 * @return isGuaranteeOrCharged的值
	 */
	public Boolean getIsGuaranteeOrCharged() {
		return isGuaranteeOrCharged;
	}

	/**
	 * 设置isGuaranteeOrCharged的值
	 *   
	 * @param isGuaranteeOrCharged 被设置的值
	 */
	public void setIsGuaranteeOrCharged(Boolean isGuaranteeOrCharged) {
		this.isGuaranteeOrCharged = isGuaranteeOrCharged;
	}

	/**   
	 * 得到creditCard的值   
	 *   
	 * @return creditCard的值
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}

	/**
	 * 设置creditCard的值
	 *   
	 * @param creditCard 被设置的值
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	/**   
	 * 得到amount的值   
	 *   
	 * @return amount的值
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 设置amount的值
	 *   
	 * @param amount 被设置的值
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
