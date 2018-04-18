package com.sinco.carnation.sns.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.sns.bo.CheckClassBO;
import com.sinco.carnation.sns.model.CheckClass;
import com.sinco.carnation.sns.model.CheckClassExample;
import com.sinco.carnation.sns.vo.CheckClassVO;
import com.sinco.dal.common.MyPage;

public interface CheckClassMapper {
	int countByExample(CheckClassExample example);

	int deleteByExample(CheckClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(CheckClass record);

	int insertSelective(CheckClass record);

	List<CheckClass> selectByExample(CheckClassExample example);

	CheckClass selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") CheckClass record,
			@Param("example") CheckClassExample example);

	int updateByExample(@Param("record") CheckClass record, @Param("example") CheckClassExample example);

	int updateByPrimaryKeySelective(CheckClass record);

	int updateByPrimaryKey(CheckClass record);

	List<CheckClassBO> selectAll();

	List<CheckClassBO> findPageByVO(MyPage<CheckClassBO> page, @Param("vo") CheckClassVO vo);

	List<CheckClass> findByIds(@Param("ids") Long... ids);

	void updateDeleteStatusByIds(@Param("ids") List<Long> allListWithChildren);

	List<CheckClassBO> selectCheckClaaaList(@Param("parentId") Long parentId);
}