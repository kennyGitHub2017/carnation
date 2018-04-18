package com.sinco.carnation.market.bo;

import com.sinco.carnation.market.model.MsgInfo;

import vc.thinker.b2b2c.core.tools.CommUtil;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class MsgInfoBO extends MsgInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6067571824006385198L;

	public String createName;

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public boolean isReceiveLocation(int v) {
		return (CommUtil.null2Int(this.getReceiveLocation()) & v) == 1;
	}
}