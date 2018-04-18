package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.TipsBO;
import com.sinco.carnation.sns.model.Tips;
import com.sinco.carnation.sns.model.TipsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TipsMapper {
	int countByExample(TipsExample example);

	int deleteByExample(TipsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Tips record);

	int insertSelective(Tips record);

	List<TipsBO> selectByExample(TipsExample example);

	TipsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Tips record, @Param("example") TipsExample example);

	int updateByExample(@Param("record") Tips record, @Param("example") TipsExample example);

	int updateByPrimaryKeySelective(Tips record);

	int updateByPrimaryKey(Tips record);
}