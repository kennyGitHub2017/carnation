package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsTypePropertyBO;
import com.sinco.carnation.goods.model.GoodsTypeProperty;
import com.sinco.carnation.goods.model.GoodsTypePropertyExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsTypePropertyMapper {

	List<GoodsTypePropertyBO> selectBOByExample(GoodsTypePropertyExample example);

	int countByExample(GoodsTypePropertyExample example);

	int deleteByExample(GoodsTypePropertyExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsTypeProperty record);

	int insertSelective(GoodsTypeProperty record);

	List<GoodsTypeProperty> selectByExampleWithBLOBs(GoodsTypePropertyExample example);

	List<GoodsTypeProperty> selectByExample(GoodsTypePropertyExample example);

	GoodsTypeProperty selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsTypeProperty record,
			@Param("example") GoodsTypePropertyExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsTypeProperty record,
			@Param("example") GoodsTypePropertyExample example);

	int updateByExample(@Param("record") GoodsTypeProperty record,
			@Param("example") GoodsTypePropertyExample example);

	int updateByPrimaryKeySelective(GoodsTypeProperty record);

	int updateByPrimaryKeyWithBLOBs(GoodsTypeProperty record);

	int updateByPrimaryKey(GoodsTypeProperty record);
}