package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.FreeGoodsBO;
import com.sinco.carnation.shop.model.FreeGoods;
import com.sinco.carnation.shop.model.FreeGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreeGoodsMapper {
	int countByExample(FreeGoodsExample example);

	int deleteByExample(FreeGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(FreeGoods record);

	int insertSelective(FreeGoods record);

	List<FreeGoodsBO> selectByExampleWithBLOBs(FreeGoodsExample example);

	List<FreeGoodsBO> selectByExample(FreeGoodsExample example);

	FreeGoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") FreeGoods record, @Param("example") FreeGoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") FreeGoods record, @Param("example") FreeGoodsExample example);

	int updateByExample(@Param("record") FreeGoods record, @Param("example") FreeGoodsExample example);

	int updateByPrimaryKeySelective(FreeGoods record);

	int updateByPrimaryKeyWithBLOBs(FreeGoods record);

	int updateByPrimaryKey(FreeGoods record);
}