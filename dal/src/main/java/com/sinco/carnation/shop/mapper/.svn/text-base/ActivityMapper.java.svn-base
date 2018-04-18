package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ActivityBO;
import com.sinco.carnation.shop.model.Activity;
import com.sinco.carnation.shop.model.ActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {
	int countByExample(ActivityExample example);

	int deleteByExample(ActivityExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Activity record);

	int insertSelective(Activity record);

	List<ActivityBO> selectByExampleWithBLOBs(ActivityExample example);

	List<ActivityBO> selectByExample(ActivityExample example);

	ActivityBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByExampleWithBLOBs(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByPrimaryKeySelective(Activity record);

	int updateByPrimaryKeyWithBLOBs(Activity record);

	int updateByPrimaryKey(Activity record);
}