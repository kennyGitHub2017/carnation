package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckResultReply extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6181492950260096381L;

	/**  **/
	private Long id;

	/** 报告名称 **/
	private String resultName;

	/** 用户id **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/** 机构/医院 **/
	private String hospital;

	/** 体检报告状态：1未提交、2待处理、3已处理 **/
	private Integer status;

	/** 处理结果 **/
	private String result;

	/** 体检时间 */
	private Date checkTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getResultName() {
		return resultName;
	}

	public void setResultName(String resultName) {
		this.resultName = resultName;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}