package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class InformationClass extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1662083335959865124L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/** 标题 **/
	private String icName;

	/** 上级分类Id **/
	private Long icPid;

	/** 序号，正常按时间排序 **/
	private Integer icSequence;

	/** 层级 分类的层级，用于区分父类与子类 **/
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

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

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getIcName() {
		return icName;
	}

	public void setIcName(String icName) {
		this.icName = icName;
	}

	public Long getIcPid() {
		return icPid;
	}

	public void setIcPid(Long icPid) {
		this.icPid = icPid;
	}

	public Integer getIcSequence() {
		return icSequence;
	}

	public void setIcSequence(Integer icSequence) {
		this.icSequence = icSequence;
	}
}