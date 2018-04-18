package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.PhysicalTypeBO;
import com.sinco.carnation.user.model.PhysicalType;
import com.sinco.carnation.user.model.PhysicalTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PhysicalTypeMapper {
	int countByExample(PhysicalTypeExample example);

	int deleteByExample(PhysicalTypeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(PhysicalType record);

	int insertSelective(PhysicalType record);

	List<PhysicalTypeBO> selectByExampleWithBLOBs(PhysicalTypeExample example);

	List<PhysicalTypeBO> selectByExample(PhysicalTypeExample example);

	PhysicalTypeBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") PhysicalType record,
			@Param("example") PhysicalTypeExample example);

	int updateByExampleWithBLOBs(@Param("record") PhysicalType record,
			@Param("example") PhysicalTypeExample example);

	int updateByExample(@Param("record") PhysicalType record, @Param("example") PhysicalTypeExample example);

	int updateByPrimaryKeySelective(PhysicalType record);

	int updateByPrimaryKeyWithBLOBs(PhysicalType record);

	int updateByPrimaryKey(PhysicalType record);
}