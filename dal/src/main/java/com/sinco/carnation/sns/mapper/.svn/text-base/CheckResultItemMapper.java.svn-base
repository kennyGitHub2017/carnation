package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.CheckResultItemBO;
import com.sinco.carnation.sns.model.CheckResultItem;
import com.sinco.carnation.sns.model.CheckResultItemExample;
import com.sinco.carnation.sns.vo.CheckResultItemVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CheckResultItemMapper {
	int countByExample(CheckResultItemExample example);

	int deleteByExample(CheckResultItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckResultItem record);

	int insertSelective(CheckResultItem record);

	List<CheckResultItemBO> selectByExample(CheckResultItemExample example);

	List<CheckResultItemBO> search(@Param("vo") CheckResultItemVO vo,
			@Param("page") MyPage<CheckResultItemBO> page);

	CheckResultItemBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckResultItem record,
			@Param("example") CheckResultItemExample example);

	int updateByExample(@Param("record") CheckResultItem record,
			@Param("example") CheckResultItemExample example);

	int updateByPrimaryKeySelective(CheckResultItem record);

	int updateByPrimaryKey(CheckResultItem record);

	List<CheckResultItemBO> queryResultByGroupId(@Param("groupId") Long groupId);

	List<CheckResultItemBO> queryResultByUsing(@Param("usingId") Long usingId);

	List<CheckResultItemBO> queryItemSearch(@Param("name") String name);
}