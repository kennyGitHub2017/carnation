package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CheckGroupBO;
import com.sinco.carnation.sns.model.CheckGroup;
import com.sinco.carnation.sns.model.CheckGroupExample;
import com.sinco.carnation.sns.vo.CheckGroupVO;
import com.sinco.dal.common.MyPage;

public interface CheckGroupMapper {
	int countByExample(CheckGroupExample example);

	int deleteByExample(CheckGroupExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckGroup record);

	int insertSelective(CheckGroup record);

	List<CheckGroup> selectByExampleWithBLOBs(CheckGroupExample example);

	List<CheckGroup> selectByExample(CheckGroupExample example);

	CheckGroup selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckGroup record,
			@Param("example") CheckGroupExample example);

	int updateByExampleWithBLOBs(@Param("record") CheckGroup record,
			@Param("example") CheckGroupExample example);

	int updateByExample(@Param("record") CheckGroup record, @Param("example") CheckGroupExample example);

	int updateByPrimaryKeySelective(CheckGroup record);

	int updateByPrimaryKeyWithBLOBs(CheckGroup record);

	int updateByPrimaryKey(CheckGroup record);

	List<CheckGroupBO> selectByList(@Param("vo") CheckGroupVO vo, MyPage<CheckGroupBO> page);

	CheckGroupBO selectById(Long id);
}