package com.sinco.carnation.recommend.mapper;

import com.sinco.carnation.recommend.model.RecommendGroup;
import com.sinco.carnation.recommend.model.RecommendGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendGroupMapper {
	int countByExample(RecommendGroupExample example);

	int deleteByExample(RecommendGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RecommendGroup record);

	int insertSelective(RecommendGroup record);

	List<RecommendGroup> selectByExample(RecommendGroupExample example);

	RecommendGroup selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RecommendGroup record,
			@Param("example") RecommendGroupExample example);

	int updateByExample(@Param("record") RecommendGroup record,
			@Param("example") RecommendGroupExample example);

	int updateByPrimaryKeySelective(RecommendGroup record);

	int updateByPrimaryKey(RecommendGroup record);
}