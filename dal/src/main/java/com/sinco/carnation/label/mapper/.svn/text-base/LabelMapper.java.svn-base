package com.sinco.carnation.label.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.label.bo.LabelBO;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.label.model.LabelExample;
import com.sinco.carnation.label.vo.LabelVO;
import com.sinco.dal.common.MyPage;

public interface LabelMapper {
	int countByExample(LabelExample example);

	int deleteByExample(LabelExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Label record);

	int insertSelective(Label record);

	List<LabelBO> selectByExample(LabelExample example);

	LabelBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelExample example);

	int updateByExample(@Param("record") Label record, @Param("example") LabelExample example);

	int updateByPrimaryKeySelective(Label record);

	int updateByPrimaryKey(Label record);

	List<Label> selectList(@Param("vo") LabelVO labelvo);

	List<LabelBO> findByPage(@Param("page") MyPage<LabelBO> page, @Param("name") String name);

	Label getObjById(long parseLong);

	List<Label> getIdNameMap();
}