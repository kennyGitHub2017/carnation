package com.sinco.carnation.o2o.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.o2o.bo.GroupCaseBO;
import com.sinco.carnation.o2o.model.GroupCase;
import com.sinco.carnation.o2o.model.GroupCaseExample;
import com.sinco.carnation.o2o.vo.GroupCaseShowVO;
import com.sinco.carnation.o2o.vo.GroupCaseVO;
import com.sinco.dal.common.MyPage;

public interface GroupCaseMapper {

	List<GroupCaseBO> findShow(GroupCaseShowVO vo);

	int countByExample(GroupCaseExample example);

	int deleteByExample(GroupCaseExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupCase record);

	int insertSelective(GroupCase record);

	List<GroupCaseBO> selectByExample(GroupCaseExample example);

	GroupCaseBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupCase record, @Param("example") GroupCaseExample example);

	int updateByExample(@Param("record") GroupCase record, @Param("example") GroupCaseExample example);

	int updateByPrimaryKeySelective(GroupCase record);

	int updateByPrimaryKey(GroupCase record);

	List<GroupCaseBO> findPageByVO(@Param("vo") GroupCaseVO vo, MyPage<GroupCaseBO> page);
}