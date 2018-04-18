package com.sinco.carnation.sns.vo;

import java.util.List;

import com.sinco.carnation.sns.model.CheckGroup;

public class CheckGroupVO extends CheckGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2793489084895752680L;

	private Long classId;

	private Long oldClassId;

	private List<Long> classIds;

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getOldClassId() {
		return oldClassId;
	}

	public void setOldClassId(Long oldClassId) {
		this.oldClassId = oldClassId;
	}

	public List<Long> getClassIds() {
		return classIds;
	}

	public void setClassIds(List<Long> classIds) {
		this.classIds = classIds;
	}

}