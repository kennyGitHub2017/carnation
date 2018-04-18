package com.sinco.carnation.o2o.mapper;

import com.sinco.carnation.o2o.bo.StoreGroupAdjustBO;
import com.sinco.carnation.o2o.model.StoreGroupAdjust;
import com.sinco.carnation.o2o.model.StoreGroupAdjustExample;
import com.sinco.carnation.o2o.vo.StoreGroupAdjustVO;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreGroupAdjustMapper {
	int countByExample(StoreGroupAdjustExample example);

	int deleteByExample(StoreGroupAdjustExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreGroupAdjust record);

	int insertSelective(StoreGroupAdjust record);

	List<StoreGroupAdjustBO> selectByExampleWithBLOBs(StoreGroupAdjustExample example);

	List<StoreGroupAdjustBO> selectByExample(StoreGroupAdjustExample example);

	StoreGroupAdjustBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreGroupAdjust record,
			@Param("example") StoreGroupAdjustExample example);

	int updateByExampleWithBLOBs(@Param("record") StoreGroupAdjust record,
			@Param("example") StoreGroupAdjustExample example);

	int updateByExample(@Param("record") StoreGroupAdjust record,
			@Param("example") StoreGroupAdjustExample example);

	int updateByPrimaryKeySelective(StoreGroupAdjust record);

	int updateByPrimaryKeyWithBLOBs(StoreGroupAdjust record);

	int updateByPrimaryKey(StoreGroupAdjust record);

	List<StoreGroupAdjust> findListByVo(@Param("vo") StoreGroupAdjustVO vo);

	List<StoreGroupAdjustBO> findPageByVo(@Param("vo") StoreGroupAdjustVO vo, MyPage<StoreGroupAdjustBO> page);
}