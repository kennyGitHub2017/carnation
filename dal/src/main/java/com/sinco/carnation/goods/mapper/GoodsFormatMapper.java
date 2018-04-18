package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsFormatBO;
import com.sinco.carnation.goods.model.GoodsFormat;
import com.sinco.carnation.goods.model.GoodsFormatExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsFormatMapper {
	int countByExample(GoodsFormatExample example);

	int deleteByExample(GoodsFormatExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsFormat record);

	int insertSelective(GoodsFormat record);

	List<GoodsFormat> selectByExampleWithBLOBs(GoodsFormatExample example);

	List<GoodsFormat> selectByExample(GoodsFormatExample example);

	List<GoodsFormatBO> selectBOPageByCat(@Param("page") MyPage<GoodsFormatBO> page, @Param("cat") Integer cat);

	List<GoodsFormatBO> selectBOPageByStoreId(@Param("page") MyPage<GoodsFormatBO> page,
			@Param("gfStoreId") Long gfStoreId);

	GoodsFormat selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsFormat record,
			@Param("example") GoodsFormatExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsFormat record,
			@Param("example") GoodsFormatExample example);

	int updateByExample(@Param("record") GoodsFormat record, @Param("example") GoodsFormatExample example);

	int updateByPrimaryKeySelective(GoodsFormat record);

	int updateByPrimaryKeyWithBLOBs(GoodsFormat record);

	int updateByPrimaryKey(GoodsFormat record);
}