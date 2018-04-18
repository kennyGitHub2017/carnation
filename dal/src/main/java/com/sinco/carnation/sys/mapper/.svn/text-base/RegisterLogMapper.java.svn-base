package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.RegisterLogBO;
import com.sinco.carnation.sys.model.RegisterLog;
import com.sinco.carnation.sys.model.RegisterLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegisterLogMapper {
	int countByExample(RegisterLogExample example);

	int deleteByExample(RegisterLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RegisterLog record);

	int insertSelective(RegisterLog record);

	List<RegisterLogBO> selectByExampleWithBLOBs(RegisterLogExample example);

	List<RegisterLogBO> selectByExample(RegisterLogExample example);

	RegisterLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RegisterLog record,
			@Param("example") RegisterLogExample example);

	int updateByExampleWithBLOBs(@Param("record") RegisterLog record,
			@Param("example") RegisterLogExample example);

	int updateByExample(@Param("record") RegisterLog record, @Param("example") RegisterLogExample example);

	int updateByPrimaryKeySelective(RegisterLog record);

	int updateByPrimaryKeyWithBLOBs(RegisterLog record);

	int updateByPrimaryKey(RegisterLog record);
}