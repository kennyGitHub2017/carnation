package com.sinco.carnation.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsFloorBO;
import com.sinco.carnation.goods.model.GoodsFloor;
import com.sinco.carnation.goods.model.GoodsFloorExample;
import com.sinco.dal.common.MyPage;

public interface GoodsFloorMapper {
	List<GoodsFloorBO> selectBOByExample(GoodsFloorExample example);

	List<GoodsFloorBO> findByPage(@Param("level") Integer level, MyPage<GoodsFloorBO> page);

	int countByExample(GoodsFloorExample example);

	int deleteByExample(GoodsFloorExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsFloor record);

	int insertSelective(GoodsFloor record);

	List<GoodsFloor> selectByExampleWithBLOBs(GoodsFloorExample example);

	List<GoodsFloor> selectByExample(GoodsFloorExample example);

	GoodsFloor selectByPrimaryKey(Long id);

	GoodsFloorBO selectBOByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsFloor record,
			@Param("example") GoodsFloorExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsFloor record,
			@Param("example") GoodsFloorExample example);

	int updateByExample(@Param("record") GoodsFloor record, @Param("example") GoodsFloorExample example);

	int updateByPrimaryKeySelective(GoodsFloor record);

	int updateByPrimaryKeyWithBLOBs(GoodsFloor record);

	int updateByPrimaryKey(GoodsFloor record);
}