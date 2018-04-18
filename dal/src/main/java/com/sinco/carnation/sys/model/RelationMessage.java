package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class RelationMessage extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7791170464425771014L;

	/**  **/
	private Long id;

	/** 被邀请人/消息发送人 **/
	private Long forUserId;

	/** 邀请人/消息接受人 **/
	private Long toUserId;

	/**  **/
	private Date creatTime;

	/** 0.系统，1.关系，2.解除关系,3.订单。 **/
	private Integer rmType;

	/** 删除状态 默认0 **/
	private Boolean deleteStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getForUserId() {
		return forUserId;
	}

	public void setForUserId(Long forUserId) {
		this.forUserId = forUserId;
	}

	public Long getToUserId() {
		return toUserId;
	}

	public void setToUserId(Long toUserId) {
		this.toUserId = toUserId;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Integer getRmType() {
		return rmType;
	}

	public void setRmType(Integer rmType) {
		this.rmType = rmType;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
}