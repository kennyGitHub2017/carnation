package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.PrepareMoneyLogBO;
import com.sinco.carnation.user.model.PrepareMoneyLog;
import com.sinco.carnation.user.model.PrepareMoneyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PrepareMoneyLogMapper {
	int countByExample(PrepareMoneyLogExample example);

	int deleteByExample(PrepareMoneyLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PrepareMoneyLog record);

	int insertSelective(PrepareMoneyLog record);

	List<PrepareMoneyLogBO> selectByExampleWithBLOBs(PrepareMoneyLogExample example);

	List<PrepareMoneyLogBO> selectByExample(PrepareMoneyLogExample example);

	PrepareMoneyLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PrepareMoneyLog record,
			@Param("example") PrepareMoneyLogExample example);

	int updateByExampleWithBLOBs(@Param("record") PrepareMoneyLog record,
			@Param("example") PrepareMoneyLogExample example);

	int updateByExample(@Param("record") PrepareMoneyLog record,
			@Param("example") PrepareMoneyLogExample example);

	int updateByPrimaryKeySelective(PrepareMoneyLog record);

	int updateByPrimaryKeyWithBLOBs(PrepareMoneyLog record);

	int updateByPrimaryKey(PrepareMoneyLog record);
}