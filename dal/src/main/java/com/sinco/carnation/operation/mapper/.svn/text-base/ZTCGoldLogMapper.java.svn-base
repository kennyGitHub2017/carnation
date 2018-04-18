package com.sinco.carnation.operation.mapper;

import com.sinco.carnation.operation.bo.ZTCGoldLogBO;
import com.sinco.carnation.operation.model.ZTCGoldLog;
import com.sinco.carnation.operation.model.ZTCGoldLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZTCGoldLogMapper {
	int countByExample(ZTCGoldLogExample example);

	int deleteByExample(ZTCGoldLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ZTCGoldLog record);

	int insertSelective(ZTCGoldLog record);

	List<ZTCGoldLogBO> selectByExample(ZTCGoldLogExample example);

	ZTCGoldLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ZTCGoldLog record,
			@Param("example") ZTCGoldLogExample example);

	int updateByExample(@Param("record") ZTCGoldLog record, @Param("example") ZTCGoldLogExample example);

	int updateByPrimaryKeySelective(ZTCGoldLog record);

	int updateByPrimaryKey(ZTCGoldLog record);
}