package com.sinco.carnation.sns.bo;

import java.util.List;

import com.sinco.carnation.sns.model.WenJuanresultHistory;
import com.sinco.carnation.user.model.UserCustomer;

/**
 * 
 * BO 用于返回数据
 * 
 */
public class WenJuanresultHistoryBO extends WenJuanresultHistory {

	private static final long serialVersionUID = -7662997227755969030L;

	private UserCustomer userCustomer;

	private WenJuanGroupResultBO groupResultBo;

	private List<WenJuanProposalBO> proposalBO_List;

	private List<WenJuanProposalBO> jianYi_List;
	/**
	 * 建议详细
	 */
	private List<WenJuanProposalDetailedBO> proposalDetailedBO_List;
	/**
	 * 健康任务
	 */
	private List<UserHealthtaskBO> userHealthtaskBO_List;

	public List<UserHealthtaskBO> getUserHealthtaskBO_List() {
		return userHealthtaskBO_List;
	}

	public void setUserHealthtaskBO_List(List<UserHealthtaskBO> userHealthtaskBO_List) {
		this.userHealthtaskBO_List = userHealthtaskBO_List;
	}

	public List<WenJuanProposalBO> getJianYi_List() {
		return jianYi_List;
	}

	public void setJianYi_List(List<WenJuanProposalBO> jianYi_List) {
		this.jianYi_List = jianYi_List;
	}

	public List<WenJuanProposalDetailedBO> getProposalDetailedBO_List() {
		return proposalDetailedBO_List;
	}

	public void setProposalDetailedBO_List(List<WenJuanProposalDetailedBO> proposalDetailedBO_List) {
		this.proposalDetailedBO_List = proposalDetailedBO_List;
	}

	public List<WenJuanProposalBO> getProposalBO_List() {
		return proposalBO_List;
	}

	public void setProposalBO_List(List<WenJuanProposalBO> proposalBO_List) {
		this.proposalBO_List = proposalBO_List;
	}

	public UserCustomer getUserCustomer() {
		return userCustomer;
	}

	public void setUserCustomer(UserCustomer userCustomer) {
		this.userCustomer = userCustomer;
	}

	public WenJuanGroupResultBO getGroupResultBo() {
		return groupResultBo;
	}

	public void setGroupResultBo(WenJuanGroupResultBO groupResultBo) {
		this.groupResultBo = groupResultBo;
	}

}