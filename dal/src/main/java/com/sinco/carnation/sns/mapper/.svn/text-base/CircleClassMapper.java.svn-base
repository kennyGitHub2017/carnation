package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.model.CircleClass;
import com.sinco.carnation.sns.model.CircleClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CircleClassMapper {
	int countByExample(CircleClassExample example);

	int deleteByExample(CircleClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CircleClass record);

	int insertSelective(CircleClass record);

	List<CircleClass> selectByExample(CircleClassExample example);

	CircleClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CircleClass record,
			@Param("example") CircleClassExample example);

	int updateByExample(@Param("record") CircleClass record, @Param("example") CircleClassExample example);

	int updateByPrimaryKeySelective(CircleClass record);

	int updateByPrimaryKey(CircleClass record);
}