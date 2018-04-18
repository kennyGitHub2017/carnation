package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.PhysicalRecordBO;
import com.sinco.carnation.user.model.PhysicalRecord;
import com.sinco.carnation.user.model.PhysicalRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhysicalRecordMapper {
	int countByExample(PhysicalRecordExample example);

	int deleteByExample(PhysicalRecordExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PhysicalRecord record);

	int insertSelective(PhysicalRecord record);

	List<PhysicalRecordBO> selectByExample(PhysicalRecordExample example);

	PhysicalRecordBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalRecord record,
			@Param("example") PhysicalRecordExample example);

	int updateByExample(@Param("record") PhysicalRecord record,
			@Param("example") PhysicalRecordExample example);

	int updateByPrimaryKeySelective(PhysicalRecord record);

	int updateByPrimaryKey(PhysicalRecord record);
}