package com.sinco.carnation.user.mapper;

import com.sinco.carnation.user.bo.RebateRateBO;
import com.sinco.carnation.user.model.RebateRate;
import com.sinco.carnation.user.model.RebateRateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RebateRateMapper {
	int countByExample(RebateRateExample example);

	int deleteByExample(RebateRateExample example);

	int deleteByPrimaryKey(Long id);

	int insert(RebateRate record);

	int insertSelective(RebateRate record);

	List<RebateRateBO> selectByExample(RebateRateExample example);

	RebateRateBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") RebateRate record,
			@Param("example") RebateRateExample example);

	int updateByExample(@Param("record") RebateRate record, @Param("example") RebateRateExample example);

	int updateByPrimaryKeySelective(RebateRate record);

	int updateByPrimaryKey(RebateRate record);
}