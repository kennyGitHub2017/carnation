package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.TransAreaBO;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.carnation.shop.model.TransAreaExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TransAreaMapper {
	int countByExample(TransAreaExample example);

	int deleteByExample(TransAreaExample example);

	int deleteByPrimaryKey(Long id);

	int insert(TransArea record);

	int insertSelective(TransArea record);

	List<TransAreaBO> selectByExample(TransAreaExample example);

	TransAreaBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") TransArea record, @Param("example") TransAreaExample example);

	int updateByExample(@Param("record") TransArea record, @Param("example") TransAreaExample example);

	int updateByPrimaryKeySelective(TransArea record);

	int updateByPrimaryKey(TransArea record);

	List<TransArea> queryTransAreaList(@Param("pid") Long pid, @Param("page") MyPage<TransArea> page);
}