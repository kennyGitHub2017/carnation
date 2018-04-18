package com.sinco.carnation.sns.model;

import com.sinco.mybatis.dal.model.BaseModel;
import java.util.Date;

public class CheckQuestionOption extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1452818976229363461L;

	/**  **/
	private Long id;

	/**  **/
	private Integer score;

	/**  **/
	private Long questionId;

	/**  **/
	private String optionDesc;

	/** 选项排序 **/
	private Integer optionIndex;

	/**  **/
	private Long updateBy;

	/**  **/
	private Date updateTime;

	/**  **/
	private Long createBy;

	/**  **/
	private Date createTime;

	/**  **/
	private Boolean isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getOptionDesc() {
		return optionDesc;
	}

	public void setOptionDesc(String optionDesc) {
		this.optionDesc = optionDesc;
	}

	public Integer getOptionIndex() {
		return optionIndex;
	}

	public void setOptionIndex(Integer optionIndex) {
		this.optionIndex = optionIndex;
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

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}