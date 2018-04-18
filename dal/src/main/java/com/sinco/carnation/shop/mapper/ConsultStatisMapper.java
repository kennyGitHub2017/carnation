package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ConsultStatisBO;
import com.sinco.carnation.shop.model.ConsultStatis;
import com.sinco.carnation.shop.model.ConsultStatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ConsultStatisMapper {
	int countByExample(ConsultStatisExample example);

	int deleteByExample(ConsultStatisExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ConsultStatis record);

	int insertSelective(ConsultStatis record);

	List<ConsultStatisBO> selectByExample(ConsultStatisExample example);

	ConsultStatisBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ConsultStatis record,
			@Param("example") ConsultStatisExample example);

	int updateByExample(@Param("record") ConsultStatis record, @Param("example") ConsultStatisExample example);

	int updateByPrimaryKeySelective(ConsultStatis record);

	int updateByPrimaryKey(ConsultStatis record);
}