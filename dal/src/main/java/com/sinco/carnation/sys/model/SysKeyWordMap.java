package com.sinco.carnation.sys.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class SysKeyWordMap extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5915511055938499655L;

	/**  **/
	private Long id;

	/** 关联类型 1:体检建议 2:任务 3:帖子 4:商品 5:服务 **/
	private Long typeCode;

	/** 任务名称 **/
	private Long typeId;

	/** 关键字Id **/
	private Long keyWordId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(Long typeCode) {
		this.typeCode = typeCode;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getKeyWordId() {
		return keyWordId;
	}

	public void setKeyWordId(Long keyWordId) {
		this.keyWordId = keyWordId;
	}
}