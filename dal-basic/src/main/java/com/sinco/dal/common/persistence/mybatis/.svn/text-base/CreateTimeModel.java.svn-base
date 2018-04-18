package com.sinco.dal.common.persistence.mybatis;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sinco.data.core.entity.PrePersistEntity;
import com.sinco.data.core.entity.PreUpdateEntity;
import com.sinco.mybatis.dal.model.BaseModel;

import java.io.Serializable;
import java.util.Date;

/**
 * insert和update时 createTime，modifyTime 字段的自动化处理 Created by zhoujianbo on 2016/2/25.
 */
public class CreateTimeModel extends BaseModel implements Serializable, PrePersistEntity, PreUpdateEntity {
	private static final long serialVersionUID = 1L;

	protected Date createTime;
	protected Date modifyTime;

	public CreateTimeModel() {
		super();
	}

	@Override
	public void prePersist() {
		this.createTime = new Date();
		this.modifyTime = createTime;
	}

	@Override
	public void preUpdate() {
		this.modifyTime = new Date();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
