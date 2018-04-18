package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ExpressCompany extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -6558903183120057671L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 快递公司代码，根据该代码查询对应的物流信息，代码见：http://code.google.com/p/kuaidi-api/wiki/Open_API_API_URL **/
	private String companyMark;

	/** 快递公司名称 **/
	private String companyName;

	/** 公司序号，默认按照升序排列 **/
	private Integer companySequence;

	/** 快递公司状态，0为启用，-1为关闭状态 **/
	private Integer companyStatus;

	/** 快递模板高度，单位为毫米 **/
	private Integer companyTemplateHeigh;

	/** 快递模板宽度,单位为毫米 **/
	private Integer companyTemplateWidth;

	/** 快递公司类型，POST为平邮、EXPRESS为快递、EMS **/
	private String companyType;

	/** 快递模板路径 **/
	private String companyTemplate;

	/** 快递模板各个参数的偏移量，用来定位模板上的相关信息 **/
	private String companyTemplateOffset;

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

	public String getCompanyMark() {
		return companyMark;
	}

	public void setCompanyMark(String companyMark) {
		this.companyMark = companyMark;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getCompanySequence() {
		return companySequence;
	}

	public void setCompanySequence(Integer companySequence) {
		this.companySequence = companySequence;
	}

	public Integer getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(Integer companyStatus) {
		this.companyStatus = companyStatus;
	}

	public Integer getCompanyTemplateHeigh() {
		return companyTemplateHeigh;
	}

	public void setCompanyTemplateHeigh(Integer companyTemplateHeigh) {
		this.companyTemplateHeigh = companyTemplateHeigh;
	}

	public Integer getCompanyTemplateWidth() {
		return companyTemplateWidth;
	}

	public void setCompanyTemplateWidth(Integer companyTemplateWidth) {
		this.companyTemplateWidth = companyTemplateWidth;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public String getCompanyTemplate() {
		return companyTemplate;
	}

	public void setCompanyTemplate(String companyTemplate) {
		this.companyTemplate = companyTemplate;
	}

	public String getCompanyTemplateOffset() {
		return companyTemplateOffset;
	}

	public void setCompanyTemplateOffset(String companyTemplateOffset) {
		this.companyTemplateOffset = companyTemplateOffset;
	}
}