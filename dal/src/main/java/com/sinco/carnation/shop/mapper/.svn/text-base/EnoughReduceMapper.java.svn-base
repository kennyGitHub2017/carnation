package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.EnoughReduceBO;
import com.sinco.carnation.shop.model.EnoughReduce;
import com.sinco.carnation.shop.model.EnoughReduceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnoughReduceMapper {
	int countByExample(EnoughReduceExample example);

	int deleteByExample(EnoughReduceExample example);

	int deleteByPrimaryKey(Long id);

	int insert(EnoughReduce record);

	int insertSelective(EnoughReduce record);

	List<EnoughReduceBO> selectByExampleWithBLOBs(EnoughReduceExample example);

	List<EnoughReduceBO> selectByExample(EnoughReduceExample example);

	EnoughReduceBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") EnoughReduce record,
			@Param("example") EnoughReduceExample example);

	int updateByExampleWithBLOBs(@Param("record") EnoughReduce record,
			@Param("example") EnoughReduceExample example);

	int updateByExample(@Param("record") EnoughReduce record, @Param("example") EnoughReduceExample example);

	int updateByPrimaryKeySelective(EnoughReduce record);

	int updateByPrimaryKeyWithBLOBs(EnoughReduce record);

	int updateByPrimaryKey(EnoughReduce record);
}