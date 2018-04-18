package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.RebateLogBO;
import com.sinco.carnation.user.model.RebateLog;
import com.sinco.carnation.user.model.RebateLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebateLogMapper {
	int countByExample(RebateLogExample example);

	int deleteByExample(RebateLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RebateLog record);

	int insertSelective(RebateLog record);

	List<RebateLogBO> selectByExample(RebateLogExample example);

	RebateLogBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RebateLog record, @Param("example") RebateLogExample example);

	int updateByExample(@Param("record") RebateLog record, @Param("example") RebateLogExample example);

	int updateByPrimaryKeySelective(RebateLog record);

	int updateByPrimaryKey(RebateLog record);
}