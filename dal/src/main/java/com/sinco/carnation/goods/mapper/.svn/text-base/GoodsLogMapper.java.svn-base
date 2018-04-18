package com.sinco.carnation.goods.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsLogBO;
import com.sinco.carnation.goods.model.GoodsLog;
import com.sinco.carnation.goods.model.GoodsLogExample;

public interface GoodsLogMapper {
	int countByExample(GoodsLogExample example);

	int deleteByExample(GoodsLogExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsLog record);

	int insertSelective(GoodsLog record);

	List<GoodsLog> selectByExampleWithBLOBs(GoodsLogExample example);

	List<GoodsLog> selectByExample(GoodsLogExample example);

	List<GoodsLogBO> selectGoodsTop(@Param("storeId") Long storeId, @Param("startTime") Date startTime,
			@Param("endTime") Date endTime, @Param("orderType") String orderType,
			@Param("offset") Integer offset, @Param("start") Integer start,
			@Param("columeName") String columeName);

	GoodsLog selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsLog record, @Param("example") GoodsLogExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsLog record, @Param("example") GoodsLogExample example);

	int updateByExample(@Param("record") GoodsLog record, @Param("example") GoodsLogExample example);

	int updateByPrimaryKeySelective(GoodsLog record);

	int updateByPrimaryKeyWithBLOBs(GoodsLog record);

	int updateByPrimaryKey(GoodsLog record);
}