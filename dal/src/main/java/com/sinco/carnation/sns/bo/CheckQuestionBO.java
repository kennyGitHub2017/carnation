package com.sinco.carnation.sns.bo;

import java.util.List;

import com.sinco.carnation.sns.model.CheckQuestion;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class CheckQuestionBO extends CheckQuestion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1824716414713560168L;

	private Integer totleCount;

	private Integer maxScore;

	private Integer minScore;

	private List<CheckQuestionOptionBO> options;

	public Integer getTotleCount() {
		return totleCount;
	}

	public void setTotleCount(Integer totleCount) {
		this.totleCount = totleCount;
	}

	public List<CheckQuestionOptionBO> getOptions() {
		return options;
	}

	public void setOptions(List<CheckQuestionOptionBO> options) {
		this.options = options;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public Integer getMinScore() {
		return minScore;
	}

	public void setMinScore(Integer minScore) {
		this.minScore = minScore;
	}
}