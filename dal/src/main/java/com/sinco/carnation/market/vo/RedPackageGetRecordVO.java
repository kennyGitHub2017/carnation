package com.sinco.carnation.market.vo;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.market.model.RedPackageGetRecord;

public class RedPackageGetRecordVO extends RedPackageGetRecord {

	/**
	 * 
	 */
	private static final long serialVersionUID = 400932416391857651L;

	private String vcode;

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	/** 选择 0 未拆包 1 已拆包 2 已领取 **/
	private int choose;

	/** 输入框输入的数据 **/
	private String mation;

	/** 开始时间转换 **/
	private String createdTimeStr;

	/** 结束时间转换 **/
	private String offTimeStr;

	public String getCreatedTimeStr() {
		return createdTimeStr;
	}

	public void setCreatedTimeStr(String createdTimeStr) {
		this.setCreatedTime(CommUtil.formatDate(createdTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.createdTimeStr = createdTimeStr;
	}

	public String getOffTimeStr() {
		return offTimeStr;
	}

	public void setOffTimeStr(String offTimeStr) {
		this.setOffTime(CommUtil.formatDate(offTimeStr, "yyyy-MM-dd HH:mm:ss"));
		this.offTimeStr = offTimeStr;
	}

	public int getChoose() {
		return choose;
	}

	public void setChoose(int choose) {
		this.choose = choose;
	}

	public String getMation() {
		return mation;
	}

	public void setMation(String mation) {
		this.mation = mation;
	}

}