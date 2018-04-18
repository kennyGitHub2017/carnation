package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ConsultStatis extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8222564183819369677L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 对应的评论id **/
	private Long csConsultId;

	/** 评论满意度的ip **/
	private String csIp;

	/** 满意度类型0为满意，-1为不满意 **/
	private Integer csType;

	/** 评论人id **/
	private Long csUserId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Boolean getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public Long getCsConsultId() {
		return csConsultId;
	}

	public void setCsConsultId(Long csConsultId) {
		this.csConsultId = csConsultId;
	}

	public String getCsIp() {
		return csIp;
	}

	public void setCsIp(String csIp) {
		this.csIp = csIp;
	}

	public Integer getCsType() {
		return csType;
	}

	public void setCsType(Integer csType) {
		this.csType = csType;
	}

	public Long getCsUserId() {
		return csUserId;
	}

	public void setCsUserId(Long csUserId) {
		this.csUserId = csUserId;
	}
}