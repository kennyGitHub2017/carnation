package com.sinco.carnation.sns.bo;

import com.sinco.carnation.sns.model.SnsActivity;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class SnsActivityBO extends SnsActivity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2062344329193581161L;
	private String name;
	private Long cid;
	private Long pid;
	private String areaname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

}