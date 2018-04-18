package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.GoldLogBO;
import com.sinco.carnation.user.model.GoldLog;
import com.sinco.carnation.user.model.GoldLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoldLogMapper {
	int countByExample(GoldLogExample example);

	int deleteByExample(GoldLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoldLog record);

	int insertSelective(GoldLog record);

	List<GoldLogBO> selectByExampleWithBLOBs(GoldLogExample example);

	List<GoldLogBO> selectByExample(GoldLogExample example);

	GoldLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoldLog record, @Param("example") GoldLogExample example);

	int updateByExampleWithBLOBs(@Param("record") GoldLog record, @Param("example") GoldLogExample example);

	int updateByExample(@Param("record") GoldLog record, @Param("example") GoldLogExample example);

	int updateByPrimaryKeySelective(GoldLog record);

	int updateByPrimaryKeyWithBLOBs(GoldLog record);

	int updateByPrimaryKey(GoldLog record);
}