package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class IntegralLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2162144740240881505L;

	/**  **/
	private Long id;

	/**  **/
	private Date addtime;

	/**  **/
	private Integer deletestatus;

	/**  **/
	private Integer integral;

	/** 操作类型，包括reg：注册赠送，system：管理员操作,login:用户登录,order:订单获得,integral_order:积分兑换 **/
	private String type;

	/** 余额 **/
	private Integer balance;

	/**  **/
	private Long integralUserId;

	/**  **/
	private Long operateUserId;

	/**  **/
	private String content;

	/** 连续签到天数 **/
	private Integer signDay;

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(Integer deletestatus) {
		this.deletestatus = deletestatus;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getIntegralUserId() {
		return integralUserId;
	}

	public void setIntegralUserId(Long integralUserId) {
		this.integralUserId = integralUserId;
	}

	public Long getOperateUserId() {
		return operateUserId;
	}

	public void setOperateUserId(Long operateUserId) {
		this.operateUserId = operateUserId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getSignDay() {
		return signDay;
	}

	public void setSignDay(Integer signDay) {
		this.signDay = signDay;
	}

}