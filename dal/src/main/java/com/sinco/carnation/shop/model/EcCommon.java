package com.sinco.carnation.shop.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class EcCommon extends BaseModel {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1448834209112945721L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Boolean deleteStatus;

	/** 常用物流公司代码 **/
	private String eccCode;

	/** 是否为默认物流公司，1为默认，只允许有一个默认物流公司 **/
	private Integer eccDefault;

	/** 对应的物流公司id **/
	private Long eccEcId;

	/** 对应的快递类型 对应ExpressCompany中的company_type **/
	private String eccEcType;

	/** 模板来源类型,0为直接使用系统模板，1为自建模板 **/
	private Integer eccFromType;

	/** 常用物流公司名称 **/
	private String eccName;

	/** 常用物流公司所属的商家 **/
	private Long eccStoreId;

	/** 物流模板高度,单位为毫米 **/
	private Integer eccTemplateHeigh;

	/** 物流模板宽度,单位为毫米 **/
	private Integer eccTemplateWidth;

	/** 常用物流公司类型，0为商家的常用物流公司，1为自营的常用物流公司 **/
	private Integer eccType;

	/** 常用物流公司的模板路径 **/
	private String eccTemplate;

	/** 快递模板各个参数的偏移量，用来定位模板上的相关信息 **/
	private String eccTemplateOffset;

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

	public String getEccCode() {
		return eccCode;
	}

	public void setEccCode(String eccCode) {
		this.eccCode = eccCode;
	}

	public Integer getEccDefault() {
		return eccDefault;
	}

	public void setEccDefault(Integer eccDefault) {
		this.eccDefault = eccDefault;
	}

	public Long getEccEcId() {
		return eccEcId;
	}

	public void setEccEcId(Long eccEcId) {
		this.eccEcId = eccEcId;
	}

	public String getEccEcType() {
		return eccEcType;
	}

	public void setEccEcType(String eccEcType) {
		this.eccEcType = eccEcType;
	}

	public Integer getEccFromType() {
		return eccFromType;
	}

	public void setEccFromType(Integer eccFromType) {
		this.eccFromType = eccFromType;
	}

	public String getEccName() {
		return eccName;
	}

	public void setEccName(String eccName) {
		this.eccName = eccName;
	}

	public Long getEccStoreId() {
		return eccStoreId;
	}

	public void setEccStoreId(Long eccStoreId) {
		this.eccStoreId = eccStoreId;
	}

	public Integer getEccTemplateHeigh() {
		return eccTemplateHeigh;
	}

	public void setEccTemplateHeigh(Integer eccTemplateHeigh) {
		this.eccTemplateHeigh = eccTemplateHeigh;
	}

	public Integer getEccTemplateWidth() {
		return eccTemplateWidth;
	}

	public void setEccTemplateWidth(Integer eccTemplateWidth) {
		this.eccTemplateWidth = eccTemplateWidth;
	}

	public Integer getEccType() {
		return eccType;
	}

	public void setEccType(Integer eccType) {
		this.eccType = eccType;
	}

	public String getEccTemplate() {
		return eccTemplate;
	}

	public void setEccTemplate(String eccTemplate) {
		this.eccTemplate = eccTemplate;
	}

	public String getEccTemplateOffset() {
		return eccTemplateOffset;
	}

	public void setEccTemplateOffset(String eccTemplateOffset) {
		this.eccTemplateOffset = eccTemplateOffset;
	}
}