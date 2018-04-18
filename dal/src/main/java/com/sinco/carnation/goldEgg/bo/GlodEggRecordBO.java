package com.sinco.carnation.goldEgg.bo;

import com.sinco.carnation.goldEgg.model.GlodEggRecord;

/**
 * 
 * BO 用于返回数据
 * 
 */
@SuppressWarnings("serial")
public class GlodEggRecordBO extends GlodEggRecord {

	private String addTime;

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

}