package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupCaseContentBO;
import com.sinco.carnation.o2o.model.GroupCaseContent;
import com.sinco.carnation.o2o.model.GroupCaseContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupCaseContentMapper {
	int countByExample(GroupCaseContentExample example);

	int deleteByExample(GroupCaseContentExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupCaseContent record);

	int insertSelective(GroupCaseContent record);

	List<GroupCaseContentBO> selectByExample(GroupCaseContentExample example);

	GroupCaseContentBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupCaseContent record,
			@Param("example") GroupCaseContentExample example);

	int updateByExample(@Param("record") GroupCaseContent record,
			@Param("example") GroupCaseContentExample example);

	int updateByPrimaryKeySelective(GroupCaseContent record);

	int updateByPrimaryKey(GroupCaseContent record);
}