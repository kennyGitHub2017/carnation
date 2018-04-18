package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupClassBO;
import com.sinco.carnation.o2o.model.GroupClass;
import com.sinco.carnation.o2o.model.GroupClassExample;
import com.sinco.dal.common.MyPage;
import com.sinco.data.core.Page;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GroupClassMapper {
	int countByExample(GroupClassExample example);

	int deleteByExample(GroupClassExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupClass record);

	int insertSelective(GroupClass record);

	List<GroupClassBO> selectByExample(GroupClassExample example);

	GroupClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupClass record,
			@Param("example") GroupClassExample example);

	int updateByExample(@Param("record") GroupClass record, @Param("example") GroupClassExample example);

	int updateByPrimaryKeySelective(GroupClass record);

	int updateByPrimaryKey(GroupClass record);

	List<GroupClassBO> findParentIsNullPage(@Param("page") Page<GroupClassBO> page);

	List<GroupClassBO> findByParent(@Param("parentId") Long parentId);

	List<GroupClassBO> queryGroupClassList(@Param("page") MyPage<GroupClassBO> page);
}