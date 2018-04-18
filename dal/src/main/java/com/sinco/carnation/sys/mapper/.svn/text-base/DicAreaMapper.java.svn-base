package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.model.DicArea;
import com.sinco.carnation.sys.model.DicAreaExample;
import com.sinco.dic.client.model.DicBase;

public interface DicAreaMapper {
	int countByExample(DicAreaExample example);

	int deleteByExample(DicAreaExample example);

	int deleteByPrimaryKey(Long id);

	int insert(DicArea record);

	int insertSelective(DicArea record);

	List<DicArea> selectByExample(DicAreaExample example);
	
	List<DicArea> findChenShi(@Param("pid") Long pid);
	
	DicArea findShen(@Param("id")Long id);

	List<DicBase> selectBaseByExample(DicAreaExample example);

	DicArea selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") DicArea record, @Param("example") DicAreaExample example);

	int updateByExample(@Param("record") DicArea record, @Param("example") DicAreaExample example);

	int updateByPrimaryKeySelective(DicArea record);

	int updateByPrimaryKey(DicArea record);
	
}