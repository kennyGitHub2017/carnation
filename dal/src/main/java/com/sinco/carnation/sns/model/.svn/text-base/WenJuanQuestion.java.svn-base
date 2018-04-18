package com.sinco.carnation.sns.model;

import java.util.Date;
import java.util.List;

import com.sinco.carnation.sns.bo.WenJuanQuestionOptionBO;
import com.sinco.mybatis.dal.model.BaseModel;

public class WenJuanQuestion extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7893617717196006325L;

	/**  **/
	private Long id;

	/** 套题ID **/
	private Long wjGroupId;

	/** 问题标题 **/
	private String questionTitle;

	/** 题目排序 **/
	private Integer questionIndex;

	/**  **/
	private Long updateBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private Date createTime;

	/**  **/
	private Long createBy;

	/**  **/
	private Boolean isDeleted;
	/**
	 * 题目选项集合
	 */
	private List<WenJuanQuestionOptionBO> question_option_List;

	public List<WenJuanQuestionOptionBO> getQuestion_option_List() {
		return question_option_List;
	}

	public void setQuestion_option_List(List<WenJuanQuestionOptionBO> question_option_List) {
		this.question_option_List = question_option_List;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getWjGroupId() {
		return wjGroupId;
	}

	public void setWjGroupId(Long wjGroupId) {
		this.wjGroupId = wjGroupId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Integer getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(Integer questionIndex) {
		this.questionIndex = questionIndex;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}