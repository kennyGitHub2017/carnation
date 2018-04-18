package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanProposalBO;
import com.sinco.carnation.sns.model.WenJuanProposal;
import com.sinco.carnation.sns.model.WenJuanProposalExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WenJuanProposalMapper {
	int countByExample(WenJuanProposalExample example);

	int deleteByExample(WenJuanProposalExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanProposal record);

	int insertSelective(WenJuanProposal record);

	List<WenJuanProposalBO> selectByExample(WenJuanProposalExample example);

	WenJuanProposalBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanProposal record,
			@Param("example") WenJuanProposalExample example);

	int updateByExample(@Param("record") WenJuanProposal record,
			@Param("example") WenJuanProposalExample example);

	int updateByPrimaryKeySelective(WenJuanProposal record);

	int updateByPrimaryKey(WenJuanProposal record);

	public List<WenJuanProposalBO> select_proposal_by_groupResultID(Long groupResultID);

	public List<WenJuanProposalBO> select_By_groupResultID_Type(@Param("groupResultID") Long groupResultID,
			@Param("type") Integer type);

	public List<WenJuanProposalBO> select_proposal_By_In_groupResultID(@Param("list") List<Long> list);

	public WenJuanProposalBO selectByWJGroupResultID(@Param("resultID") Long resultID);
}