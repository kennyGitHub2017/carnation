package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.ExpertKnowledgeBO;
import com.sinco.carnation.sns.model.ExpertKnowledge;
import com.sinco.carnation.sns.model.ExpertKnowledgeExample;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpertKnowledgeMapper {
	int countByExample(ExpertKnowledgeExample example);

	int deleteByExample(ExpertKnowledgeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ExpertKnowledge record);

	int insertSelective(ExpertKnowledge record);

	List<ExpertKnowledgeBO> selectByExampleWithBLOBs(ExpertKnowledgeExample example);

	List<ExpertKnowledgeBO> selectByExample(ExpertKnowledgeExample example);

	ExpertKnowledgeBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ExpertKnowledge record,
			@Param("example") ExpertKnowledgeExample example);

	int updateByExampleWithBLOBs(@Param("record") ExpertKnowledge record,
			@Param("example") ExpertKnowledgeExample example);

	int updateByExample(@Param("record") ExpertKnowledge record,
			@Param("example") ExpertKnowledgeExample example);

	int updateByPrimaryKeySelective(ExpertKnowledge record);

	int updateByPrimaryKeyWithBLOBs(ExpertKnowledge record);

	int updateByPrimaryKey(ExpertKnowledge record);

	List<ExpertKnowledgeBO> queryExpertKnowledgeList(@Param("title") String title,
			@Param("page") MyPage<ExpertKnowledgeBO> page);

	List<ExpertKnowledgeBO> queryKnowledgeByclassId(@Param("id") Long id);

	List<ExpertKnowledgeBO> searchKnowList(@Param("id") String id, @Param("name") String name);
}