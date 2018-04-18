package com.sinco.carnation.recommend.mapper;

import com.sinco.carnation.recommend.model.RecommendItem;
import com.sinco.carnation.recommend.model.RecommendItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendItemMapper {
	int countByExample(RecommendItemExample example);

	int deleteByExample(RecommendItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RecommendItem record);

	int insertSelective(RecommendItem record);

	List<RecommendItem> selectByExample(RecommendItemExample example);

	RecommendItem selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RecommendItem record,
			@Param("example") RecommendItemExample example);

	int updateByExample(@Param("record") RecommendItem record, @Param("example") RecommendItemExample example);

	int updateByPrimaryKeySelective(RecommendItem record);

	int updateByPrimaryKey(RecommendItem record);
}