package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupFloorBO;
import com.sinco.carnation.o2o.model.GroupFloor;
import com.sinco.carnation.o2o.model.GroupFloorExample;
import com.sinco.carnation.o2o.vo.GroupFloorVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupFloorMapper {
	int countByExample(GroupFloorExample example);

	int deleteByExample(GroupFloorExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupFloor record);

	int insertSelective(GroupFloor record);

	List<GroupFloorBO> selectByExample(GroupFloorExample example);

	GroupFloorBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupFloor record,
			@Param("example") GroupFloorExample example);

	int updateByExample(@Param("record") GroupFloor record, @Param("example") GroupFloorExample example);

	int updateByPrimaryKeySelective(GroupFloor record);

	int updateByPrimaryKey(GroupFloor record);

	List<GroupFloorBO> findPageByVO(@Param("vo") GroupFloorVO vo, MyPage<GroupFloorVO> page);
}