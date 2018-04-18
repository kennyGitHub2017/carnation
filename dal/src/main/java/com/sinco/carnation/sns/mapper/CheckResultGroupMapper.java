package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.CheckResultGroupBO;
import com.sinco.carnation.sns.model.CheckResultGroup;
import com.sinco.carnation.sns.model.CheckResultGroupExample;
import com.sinco.carnation.sns.vo.CheckResultGroupVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CheckResultGroupMapper {
	int countByExample(CheckResultGroupExample example);

	int deleteByExample(CheckResultGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckResultGroup record);

	int insertSelective(CheckResultGroup record);

	List<CheckResultGroupBO> selectByExample(CheckResultGroupExample example);

	List<CheckResultGroupBO> search(@Param("vo") CheckResultGroupVO vo,
			@Param("page") MyPage<CheckResultGroupBO> page);

	CheckResultGroupBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckResultGroup record,
			@Param("example") CheckResultGroupExample example);

	int updateByExample(@Param("record") CheckResultGroup record,
			@Param("example") CheckResultGroupExample example);

	int updateByPrimaryKeySelective(CheckResultGroup record);

	int updateByPrimaryKey(CheckResultGroup record);

	List<CheckResultGroupBO> queryCheckResultGroupList();
}