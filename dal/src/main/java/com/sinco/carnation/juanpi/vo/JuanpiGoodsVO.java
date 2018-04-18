package com.sinco.carnation.juanpi.vo;

import com.sinco.carnation.juanpi.model.JuanpiGoods;

public class JuanpiGoodsVO extends JuanpiGoods{
	private String timeType;
	private String sortBy;
	public String getTimeType() {
		return timeType;
	}

	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	private Long fgcId;
	private Long sgcId;
	private Long tgcId;
	public Long getFgcId() {
		return fgcId;
	}

	public void setFgcId(Long fgcId) {
		this.fgcId = fgcId;
	}

	public Long getSgcId() {
		return sgcId;
	}

	public void setSgcId(Long sgcId) {
		this.sgcId = sgcId;
	}

	public Long getTgcId() {
		return tgcId;
	}

	public void setTgcId(Long tgcId) {
		this.tgcId = tgcId;
	}

	private static final long serialVersionUID = 4479184851176589015L;

	private String beginTime;
	
	private String endTime;
	
	private String type;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}