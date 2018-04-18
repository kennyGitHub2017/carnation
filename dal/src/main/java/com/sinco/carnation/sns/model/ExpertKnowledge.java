package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class ExpertKnowledge extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5728925357596163750L;

	/**  **/
	private Long id;

	/** 标题 **/
	private String title;

	/** 类型 **/
	private Long knowledgeType;

	/** 创建时间 **/
	private Date createTime;

	/** 用户id **/
	private Long userId;

	/** 类容 **/
	private String context;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getKnowledgeType() {
		return knowledgeType;
	}

	public void setKnowledgeType(Long knowledgeType) {
		this.knowledgeType = knowledgeType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}
}