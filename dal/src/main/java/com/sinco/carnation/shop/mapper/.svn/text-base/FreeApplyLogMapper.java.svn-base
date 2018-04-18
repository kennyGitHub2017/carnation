package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.FreeApplyLogBO;
import com.sinco.carnation.shop.model.FreeApplyLog;
import com.sinco.carnation.shop.model.FreeApplyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreeApplyLogMapper {
	int countByExample(FreeApplyLogExample example);

	int deleteByExample(FreeApplyLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(FreeApplyLog record);

	int insertSelective(FreeApplyLog record);

	List<FreeApplyLogBO> selectByExampleWithBLOBs(FreeApplyLogExample example);

	List<FreeApplyLogBO> selectByExample(FreeApplyLogExample example);

	FreeApplyLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") FreeApplyLog record,
			@Param("example") FreeApplyLogExample example);

	int updateByExampleWithBLOBs(@Param("record") FreeApplyLog record,
			@Param("example") FreeApplyLogExample example);

	int updateByExample(@Param("record") FreeApplyLog record, @Param("example") FreeApplyLogExample example);

	int updateByPrimaryKeySelective(FreeApplyLog record);

	int updateByPrimaryKeyWithBLOBs(FreeApplyLog record);

	int updateByPrimaryKey(FreeApplyLog record);
}