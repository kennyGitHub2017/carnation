package com.sinco.carnation.sns.bo;

import com.sinco.carnation.sns.model.CheckGroup;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class CheckGroupBO extends CheckGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4954356957477463187L;
	private Long classId;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}
}