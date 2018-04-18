package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.KnowledgeClassBO;
import com.sinco.carnation.sns.model.KnowledgeClass;
import com.sinco.carnation.sns.model.KnowledgeClassExample;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface KnowledgeClassMapper {
	int countByExample(KnowledgeClassExample example);

	int deleteByExample(KnowledgeClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(KnowledgeClass record);

	int insertSelective(KnowledgeClass record);

	List<KnowledgeClassBO> selectByExample(KnowledgeClassExample example);

	KnowledgeClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") KnowledgeClass record,
			@Param("example") KnowledgeClassExample example);

	int updateByExample(@Param("record") KnowledgeClass record,
			@Param("example") KnowledgeClassExample example);

	int updateByPrimaryKeySelective(KnowledgeClass record);

	int updateByPrimaryKey(KnowledgeClass record);

	List<KnowledgeClassBO> queryKnowClassAll(@Param("className") String className,
			@Param("page") MyPage<KnowledgeClassBO> page);
}