package com.sinco.carnation.o2o.model;

import com.sinco.mybatis.dal.model.BaseModel;

public class GroupAccessory extends BaseModel {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5377144207058980051L;

	/** accessoryId **/
	private Long accessoryId;

	/** groupGoodsId **/
	private Long groupGoodsId;

	public Long getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(Long accessoryId) {
		this.accessoryId = accessoryId;
	}

	public Long getGroupGoodsId() {
		return groupGoodsId;
	}

	public void setGroupGoodsId(Long groupGoodsId) {
		this.groupGoodsId = groupGoodsId;
	}
}