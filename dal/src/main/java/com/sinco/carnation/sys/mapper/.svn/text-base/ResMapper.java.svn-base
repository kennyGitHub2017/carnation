package com.sinco.carnation.sys.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.ResBO;
import com.sinco.carnation.sys.model.Res;
import com.sinco.carnation.sys.model.ResExample;

public interface ResMapper {
	int countByExample(ResExample example);

	int deleteByExample(ResExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Res record);

	int insertSelective(Res record);

	List<ResBO> selectByExample(ResExample example);

	Res selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Res record, @Param("example") ResExample example);

	int updateByExample(@Param("record") Res record, @Param("example") ResExample example);

	int updateByPrimaryKeySelective(Res record);

	int updateByPrimaryKey(Res record);

	List<ResBO> findResByRoleType(@Param("roleType") String roleType, @Param("value") String value);
}