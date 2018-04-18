package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ActApply extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 923378267157324286L;

	/**  **/
	private Long id;

	/** 名字 **/
	private String name;

	/** 电话 **/
	private String mobile;

	/** 地址 **/
	private String address;

	/** 留言(可选) **/
	private String message;

	/** 邮箱(可选) **/
	private String email;

	/** 状态(0未查看，1已查看) **/
	private Integer status;

	/** 用户提交时间 **/
	private Date updateTime;

	/** 修改时间 **/
	private Date createTime;

	/**  **/
	private Boolean deleteStatus;

	/** 0加盟1活动 **/
	private Integer applyType;

	/** 向哪个活动提交(act.id) **/
	private Long applyActRelation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Integer getApplyType() {
		return applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public Long getApplyActRelation() {
		return applyActRelation;
	}

	public void setApplyActRelation(Long applyActRelation) {
		this.applyActRelation = applyActRelation;
	}
}