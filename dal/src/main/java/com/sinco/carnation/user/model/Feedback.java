package com.sinco.carnation.user.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class Feedback extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7407464326779985933L;

	/**  **/
	private Long id;

	/** 用户id **/
	private Long userId;

	/**
	 * 来源 1：IOS个人端APP 2：IOS商户端APP 3：IOS运营商APP 4：安卓个人端APP 5：安卓商户端APP 6：安卓运营商APP
	 **/
	private Integer source;

	/** 反馈内容 **/
	private String content;

	/**  **/
	private Date createTime;

	/** 状态 0:未做任何处理 1 处理 2不做处理 **/
	private Integer status;

	/**  **/
	private Date dealTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getDealTime() {
		return dealTime;
	}

	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}
}