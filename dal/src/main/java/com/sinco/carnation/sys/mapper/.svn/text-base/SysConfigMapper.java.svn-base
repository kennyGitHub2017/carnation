package com.sinco.carnation.sys.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sys.bo.SysConfigBO;
import com.sinco.carnation.sys.model.SysConfig;
import com.sinco.carnation.sys.model.SysConfigExample;

public interface SysConfigMapper {
	int countByExample(SysConfigExample example);

	int deleteByExample(SysConfigExample example);

	int deleteByPrimaryKey(Long id);

	int insert(SysConfig record);

	int insertSelective(SysConfig record);

	List<SysConfig> selectByExampleWithBLOBs(SysConfigExample example);

	List<SysConfigBO> selectByExample(SysConfigExample example);

	SysConfig selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

	int updateByExampleWithBLOBs(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

	int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

	int updateByPrimaryKeySelective(SysConfig record);

	int updateByPrimaryKeyWithBLOBs(SysConfig record);

	int updateByPrimaryKey(SysConfig record);

	int addConfigAmount(@Param("payoffAllAmount") BigDecimal payoffAllAmount,
			@Param("payoffAllAmountReality") BigDecimal payoffAllAmountReality,
			@Param("payoffAllCommission") BigDecimal payoffAllCommission,
			@Param("payoffAllSale") BigDecimal payoffAllSale);
}