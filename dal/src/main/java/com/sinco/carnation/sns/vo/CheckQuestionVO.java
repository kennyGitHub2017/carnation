package com.sinco.carnation.sns.vo;

import com.sinco.carnation.sns.model.CheckQuestion;

public class CheckQuestionVO extends CheckQuestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 473141879643677205L;

	private Long[] optionIds;

	private String[] optionDescs;

	private Integer[] score;

	private Long groupId;

	private Integer questionIndex;

	public Long[] getOptionIds() {
		return optionIds;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Integer getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(Integer questionIndex) {
		this.questionIndex = questionIndex;
	}

	public void setOptionIds(Long[] optionIds) {
		this.optionIds = optionIds;
	}

	public String[] getOptionDescs() {
		return optionDescs;
	}

	public void setOptionDescs(String[] optionDescs) {
		this.optionDescs = optionDescs;
	}

	public Integer[] getScore() {
		return score;
	}

	public void setScore(Integer[] score) {
		this.score = score;
	}
}