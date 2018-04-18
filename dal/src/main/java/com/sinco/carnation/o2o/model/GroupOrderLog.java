package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class GroupOrderLog extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3619671410029116137L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/**  **/
	private String logInfo;

	/**  **/
	private Long logUserId;

	/**  **/
	private Long ofId;

	/**  **/
	private String stateInfo;

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

	public String getLogInfo() {
		return logInfo;
	}

	public void setLogInfo(String logInfo) {
		this.logInfo = logInfo;
	}

	public Long getLogUserId() {
		return logUserId;
	}

	public void setLogUserId(Long logUserId) {
		this.logUserId = logUserId;
	}

	public Long getOfId() {
		return ofId;
	}

	public void setOfId(Long ofId) {
		this.ofId = ofId;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
}