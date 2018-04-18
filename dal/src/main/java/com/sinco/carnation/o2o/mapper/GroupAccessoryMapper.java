package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.GroupAccessoryBO;
import com.sinco.carnation.o2o.model.GroupAccessory;
import com.sinco.carnation.o2o.model.GroupAccessoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupAccessoryMapper {
	int countByExample(GroupAccessoryExample example);

	int deleteByExample(GroupAccessoryExample example);

	int deleteByPrimaryKey(@Param("accessoryId") Long accessoryId, @Param("groupGoodsId") Long groupGoodsId);

	int insert(GroupAccessory record);

	int insertSelective(GroupAccessory record);

	List<GroupAccessoryBO> selectByExample(GroupAccessoryExample example);

	int updateByExampleSelective(@Param("record") GroupAccessory record,
			@Param("example") GroupAccessoryExample example);

	int updateByExample(@Param("record") GroupAccessory record,
			@Param("example") GroupAccessoryExample example);
}