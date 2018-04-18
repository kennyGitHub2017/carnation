package com.sinco.carnation.sys.mapper;

import com.sinco.carnation.sys.bo.BindingHistoryBO;
import com.sinco.carnation.sys.model.BindingHistory;
import com.sinco.carnation.sys.model.BindingHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BindingHistoryMapper {
	int countByExample(BindingHistoryExample example);

	int deleteByExample(BindingHistoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(BindingHistory record);

	int insertSelective(BindingHistory record);

	List<BindingHistoryBO> selectByExample(BindingHistoryExample example);

	BindingHistoryBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") BindingHistory record,
			@Param("example") BindingHistoryExample example);

	int updateByExample(@Param("record") BindingHistory record,
			@Param("example") BindingHistoryExample example);

	int updateByPrimaryKeySelective(BindingHistory record);

	int updateByPrimaryKey(BindingHistory record);
}