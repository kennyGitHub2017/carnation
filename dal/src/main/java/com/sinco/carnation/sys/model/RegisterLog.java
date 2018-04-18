package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class RegisterLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -529107009682095049L;

	/** 主键id **/
	private Long id;

	/** 注册的手机号 **/
	private String phone;

	/** 注册填写的邀请码 **/
	private String invitationCode;

	/** 注册的ip **/
	private String ip;

	/** 注册类型 1-pc注册，2-h5注册,3-app注册 **/
	private Byte registerFrom;

	/** 删除状态 0 正常数据(默认值),1 删除状态 **/
	private Byte deleteStatus;

	/** 创建时间 **/
	private Date createTime;

	/** 注册请求内容 **/
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Byte getRegisterFrom() {
		return registerFrom;
	}

	public void setRegisterFrom(Byte registerFrom) {
		this.registerFrom = registerFrom;
	}

	public Byte getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Byte deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}