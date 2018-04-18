package vc.thinker.b2b2c.model.elong.vo;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.sinco.api.annotation.Param;

public class PaySubmitRequestVO {
	/**
	 * 数据库主键ID
	 */
	@Param(desc = "订单ID")
	@NotNull(message = "订单ID不能为空")
	private Long id;
	
	/**
	 * 订单号
	 */
	@Param(desc = "订单号")
	@NotNull(message = "订单号错误")
	private Long orderId;
	
	/**
	 * 支付金额
	 */
	@Param(desc = "订单金额")
	@NotNull(message = "订单金额错误")
	private BigDecimal amount;
	
	/**
	 * 卡号
	 */
	@Param(desc = "信用卡卡号")
	@NotEmpty(message = "信用卡卡号不能为空")
	@Length(max = 20, message = "信用卡卡号错误")
	private String cardNo;
	/**
	 * 信用卡过期时间：4位年+2位月
	 */
	@Param(desc = "信用卡过期时间")
	@NotEmpty(message = "信用卡过期时间不能为空")
	@Length(min = 6, message = "信用卡过期时间错误")
	private String expiration;
	/**
	 * 持卡人名称
	 */
	@Param(desc = "持卡人")
	@NotEmpty(message = "持卡人不能为空")
	@Length(max = 20, message = "持卡人信息错误")
	private String holderName;
	
	/**
	 * 证件类型
	 */
	@Param(desc = "证件类型")
	@NotEmpty(message = "证件类型不能为空")
	private String idType;
	
	/**
	 * 证件号码
	 */
	@Param(desc = "证件号码")
	@NotEmpty(message = "证件号码不能为空")
	@Length(max = 20, message = "证件号码错误")
	private String idNo;
	
	@Param(desc = "验证码")
	private String cvv;
	
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

	/**   
	 * 得到cvv的值   
	 *   
	 * @return cvv的值
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * 设置cvv的值
	 *   
	 * @param cvv 被设置的值
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	/**   
	 * 得到expiration的值   
	 *   
	 * @return expiration的值
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * 设置expiration的值
	 *   
	 * @param expiration 被设置的值
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**   
	 * 得到holderName的值   
	 *   
	 * @return holderName的值
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * 设置holderName的值
	 *   
	 * @param holderName 被设置的值
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**   
	 * 得到idType的值   
	 *   
	 * @return idType的值
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * 设置idType的值
	 *   
	 * @param idType 被设置的值
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**   
	 * 得到idNo的值   
	 *   
	 * @return idNo的值
	 */
	public String getIdNo() {
		return idNo;
	}

	/**
	 * 设置idNo的值
	 *   
	 * @param idNo 被设置的值
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
