package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CircleClass extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4896736180014134417L;

	/**  **/
	private Long id;

	/**  **/
	private Date addTime;

	/**  **/
	private Integer deleteStatus;

	/**  **/
	private String className;

	/** 默认为0,1为在圈子导航显示 **/
	private Integer navIndex;

	/** 默认为0,1为推荐,推荐后在圈子列表热门分类显示 **/
	private Integer recommend;

	/**  **/
	private Integer sequence;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getNavIndex() {
		return navIndex;
	}

	public void setNavIndex(Integer navIndex) {
		this.navIndex = navIndex;
	}

	public Integer getRecommend() {
		return recommend;
	}

	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
}