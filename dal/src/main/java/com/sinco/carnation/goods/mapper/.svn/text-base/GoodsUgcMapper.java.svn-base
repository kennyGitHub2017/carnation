package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.GoodsUgc;
import com.sinco.carnation.goods.model.GoodsUgcExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsUgcMapper {
	int countByExample(GoodsUgcExample example);

	int deleteByExample(GoodsUgcExample example);

	int deleteByPrimaryKey(@Param("classId") Long classId, @Param("goodsId") Long goodsId);

	int insert(GoodsUgc record);

	int insertSelective(GoodsUgc record);

	List<GoodsUgc> selectByExample(GoodsUgcExample example);

	int updateByExampleSelective(@Param("record") GoodsUgc record, @Param("example") GoodsUgcExample example);

	int updateByExample(@Param("record") GoodsUgc record, @Param("example") GoodsUgcExample example);
}