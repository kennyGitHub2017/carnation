package com.sinco.carnation.config.mapper;

import com.sinco.carnation.config.bo.ConfigSetBO;
import com.sinco.carnation.config.model.ConfigSet;
import com.sinco.carnation.config.model.ConfigSetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConfigSetMapper {
	int countByExample(ConfigSetExample example);

	int deleteByExample(ConfigSetExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ConfigSet record);

	int insertSelective(ConfigSet record);

	List<ConfigSetBO> selectByExample(ConfigSetExample example);

	ConfigSetBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ConfigSet record, @Param("example") ConfigSetExample example);

	int updateByExample(@Param("record") ConfigSet record, @Param("example") ConfigSetExample example);

	int updateByPrimaryKeySelective(ConfigSet record);

	int updateByPrimaryKey(ConfigSet record);
}