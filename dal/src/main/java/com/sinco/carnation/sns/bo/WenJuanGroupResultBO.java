package com.sinco.carnation.sns.bo;

import java.util.List;

import com.sinco.carnation.sns.model.WenJuanGroupResult;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class WenJuanGroupResultBO extends WenJuanGroupResult {

	/**
	 * 最大分数
	 */
	private int maxScore;
	/**
	 * 最小分数
	 */
	private int minScore;

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

	public int getMinScore() {
		return minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}

	private static final long serialVersionUID = 6785316842822537489L;

	private List<WenJuanProposalBO> proposal_List;

	public List<WenJuanProposalBO> getProposal_List() {
		return proposal_List;
	}

	public void setProposal_List(List<WenJuanProposalBO> proposal_List) {
		this.proposal_List = proposal_List;
	}

}