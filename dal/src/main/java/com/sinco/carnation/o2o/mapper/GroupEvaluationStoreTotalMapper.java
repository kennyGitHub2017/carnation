package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupEvaluationStoreTotalBO;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotal;
import com.sinco.carnation.o2o.model.GroupEvaluationStoreTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupEvaluationStoreTotalMapper {
	int countByExample(GroupEvaluationStoreTotalExample example);

	int deleteByExample(GroupEvaluationStoreTotalExample example);

	int deleteByPrimaryKey(Long storeId);

	int insert(GroupEvaluationStoreTotal record);

	int insertSelective(GroupEvaluationStoreTotal record);

	List<GroupEvaluationStoreTotalBO> selectByExample(GroupEvaluationStoreTotalExample example);

	GroupEvaluationStoreTotalBO selectByPrimaryKey(Long storeId);

	int updateByExampleSelective(@Param("record") GroupEvaluationStoreTotal record,
			@Param("example") GroupEvaluationStoreTotalExample example);

	int updateByExample(@Param("record") GroupEvaluationStoreTotal record,
			@Param("example") GroupEvaluationStoreTotalExample example);

	int updateByPrimaryKeySelective(GroupEvaluationStoreTotal record);

	int updateByPrimaryKey(GroupEvaluationStoreTotal record);
}