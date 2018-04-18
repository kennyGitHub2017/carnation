package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.GoodsSpec;
import com.sinco.carnation.goods.model.GoodsSpecExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpecMapper {

	int countBySpec(@Param("specIds") List<Long> specIds);

	int countByExample(GoodsSpecExample example);

	int deleteByExample(GoodsSpecExample example);

	int deleteByPrimaryKey(@Param("goodsId") Long goodsId, @Param("specId") Long specId);

	int insert(GoodsSpec record);

	int insertSelective(GoodsSpec record);

	List<GoodsSpec> selectByExample(GoodsSpecExample example);

	int updateByExampleSelective(@Param("record") GoodsSpec record, @Param("example") GoodsSpecExample example);

	int updateByExample(@Param("record") GoodsSpec record, @Param("example") GoodsSpecExample example);
	
	int insertGoodsSpecId(@Param("goodsId")Long goodsId, @Param("specificationId") Long specificationId);
	
	List<GoodsSpec> selectGoodsSpecIdList(@Param("goodsId") Long goodsId);
	
	int deleteGoodsSpecId(@Param("goodsId") Long goodsId);
}