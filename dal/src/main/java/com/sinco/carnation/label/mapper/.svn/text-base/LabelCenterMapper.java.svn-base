package com.sinco.carnation.label.mapper;

import com.sinco.carnation.label.bo.LabelCenterBO;
import com.sinco.carnation.label.model.LabelCenter;
import com.sinco.carnation.label.model.LabelCenterExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LabelCenterMapper {
	int countByExample(LabelCenterExample example);

	int deleteByExample(LabelCenterExample example);

	int deleteByPrimaryKey(Long id);

	int insert(LabelCenter record);

	int insertSelective(LabelCenter record);

	List<LabelCenterBO> selectByExample(LabelCenterExample example);

	LabelCenterBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") LabelCenter record,
			@Param("example") LabelCenterExample example);

	int updateByExample(@Param("record") LabelCenter record, @Param("example") LabelCenterExample example);

	int updateByPrimaryKeySelective(LabelCenter record);

	int updateByPrimaryKey(LabelCenter record);

	int batchInsert(@Param("valu") String values);
}