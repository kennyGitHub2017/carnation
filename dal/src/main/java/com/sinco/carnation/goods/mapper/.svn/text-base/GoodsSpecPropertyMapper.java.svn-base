package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsSpecPropertyBO;
import com.sinco.carnation.goods.model.GoodsSpecProperty;
import com.sinco.carnation.goods.model.GoodsSpecPropertyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsSpecPropertyMapper {

	List<GoodsSpecPropertyBO> selectBOByExample(GoodsSpecPropertyExample example);

	List<GoodsSpecPropertyBO> selectBOSpecBygoodsId(@Param("goodsId") Long goodsId);

	List<GoodsSpecPropertyBO> selectBOSpecByCartId(@Param("cartId") Long cartId);

	List<GoodsSpecPropertyBO> selectBOSpecByIds(@Param("ids") String[] ids);

	GoodsSpecPropertyBO findBOById(Long id);

	int countByExample(GoodsSpecPropertyExample example);

	int deleteByExample(GoodsSpecPropertyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsSpecProperty record);

	int insertSelective(GoodsSpecProperty record);

	List<GoodsSpecProperty> selectByExampleWithBLOBs(GoodsSpecPropertyExample example);

	List<GoodsSpecProperty> selectByExample(GoodsSpecPropertyExample example);

	GoodsSpecProperty selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsSpecProperty record,
			@Param("example") GoodsSpecPropertyExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsSpecProperty record,
			@Param("example") GoodsSpecPropertyExample example);

	int updateByExample(@Param("record") GoodsSpecProperty record,
			@Param("example") GoodsSpecPropertyExample example);

	int updateByPrimaryKeySelective(GoodsSpecProperty record);

	int updateByPrimaryKeyWithBLOBs(GoodsSpecProperty record);

	int updateByPrimaryKey(GoodsSpecProperty record);
	
	List<GoodsSpecPropertyBO> getGoodsPropertyByStoreId(@Param("specId")Long specId, @Param("storeId") Long storeId);
	
	List<GoodsSpecProperty> getPropertyByGoodsIdAndSpec(@Param("goodsId")Long goodsId, @Param("specId") Long specId);
	int deletePropertyByGoodsId(@Param("goodsId")Long goodsId);
}