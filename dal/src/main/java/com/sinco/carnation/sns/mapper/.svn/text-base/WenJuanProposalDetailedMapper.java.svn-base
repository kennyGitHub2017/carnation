package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.WenJuanProposalDetailedBO;
import com.sinco.carnation.sns.model.WenJuanProposalDetailed;
import com.sinco.carnation.sns.model.WenJuanProposalDetailedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WenJuanProposalDetailedMapper {

	int countByExample(WenJuanProposalDetailedExample example);

	int deleteByExample(WenJuanProposalDetailedExample example);

	int deleteByPrimaryKey(Long id);

	int insert(WenJuanProposalDetailed record);

	int insertSelective(WenJuanProposalDetailed record);

	List<WenJuanProposalDetailedBO> selectByExample(WenJuanProposalDetailedExample example);

	WenJuanProposalDetailedBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") WenJuanProposalDetailed record,
			@Param("example") WenJuanProposalDetailedExample example);

	int updateByExample(@Param("record") WenJuanProposalDetailed record,
			@Param("example") WenJuanProposalDetailedExample example);

	int updateByPrimaryKeySelective(WenJuanProposalDetailed record);

	int updateByPrimaryKey(WenJuanProposalDetailed record);

	public List<WenJuanProposalDetailedBO> select_ProposalDetailed_By_ProposalID(Long proposalID);

	public List<WenJuanProposalDetailedBO> select_ProposalDetailed_By_ProposalIDAndType(
			@Param("proposalID") Long proposalID, @Param("types") long types);

	public WenJuanProposalDetailedBO selectOneByProposalIDAndType(@Param("proposalID") Long proposalID,
			@Param("types") long types);
}