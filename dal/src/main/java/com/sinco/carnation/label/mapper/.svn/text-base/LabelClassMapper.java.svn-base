package com.sinco.carnation.label.mapper;

import com.sinco.carnation.label.bo.LabelClassBO;
import com.sinco.carnation.label.model.LabelClass;
import com.sinco.carnation.label.model.LabelClassExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LabelClassMapper {
	int countByExample(LabelClassExample example);

	int deleteByExample(LabelClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(LabelClass record);

	int insertSelective(LabelClass record);

	List<LabelClassBO> selectByExample(LabelClassExample example);

	LabelClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") LabelClass record,
			@Param("example") LabelClassExample example);

	int updateByExample(@Param("record") LabelClass record, @Param("example") LabelClassExample example);

	int updateByPrimaryKeySelective(LabelClass record);

	int updateByPrimaryKey(LabelClass record);

	List<LabelClassBO> findByPage(@Param("page") MyPage<LabelClassBO> page);

	List<LabelClassBO> selectBOByExample(LabelClassExample example);
}