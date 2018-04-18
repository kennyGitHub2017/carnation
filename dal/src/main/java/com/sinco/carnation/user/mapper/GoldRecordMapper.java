package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.GoldRecordBO;
import com.sinco.carnation.user.model.GoldRecord;
import com.sinco.carnation.user.model.GoldRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoldRecordMapper {
	int countByExample(GoldRecordExample example);

	int deleteByExample(GoldRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoldRecord record);

	int insertSelective(GoldRecord record);

	List<GoldRecordBO> selectByExampleWithBLOBs(GoldRecordExample example);

	List<GoldRecordBO> selectByExample(GoldRecordExample example);

	GoldRecordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoldRecord record,
			@Param("example") GoldRecordExample example);

	int updateByExampleWithBLOBs(@Param("record") GoldRecord record,
			@Param("example") GoldRecordExample example);

	int updateByExample(@Param("record") GoldRecord record, @Param("example") GoldRecordExample example);

	int updateByPrimaryKeySelective(GoldRecord record);

	int updateByPrimaryKeyWithBLOBs(GoldRecord record);

	int updateByPrimaryKey(GoldRecord record);
}