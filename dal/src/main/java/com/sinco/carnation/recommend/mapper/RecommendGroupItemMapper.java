package com.sinco.carnation.recommend.mapper;

import com.sinco.carnation.recommend.model.RecommendGroupItem;
import com.sinco.carnation.recommend.model.RecommendGroupItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RecommendGroupItemMapper {
	int countByExample(RecommendGroupItemExample example);

	int deleteByExample(RecommendGroupItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RecommendGroupItem record);

	int insertSelective(RecommendGroupItem record);

	List<RecommendGroupItem> selectByExample(RecommendGroupItemExample example);

	RecommendGroupItem selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RecommendGroupItem record,
			@Param("example") RecommendGroupItemExample example);

	int updateByExample(@Param("record") RecommendGroupItem record,
			@Param("example") RecommendGroupItemExample example);

	int updateByPrimaryKeySelective(RecommendGroupItem record);

	int updateByPrimaryKey(RecommendGroupItem record);
}