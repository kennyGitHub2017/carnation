package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsPhotoBO;
import com.sinco.carnation.goods.model.GoodsPhoto;
import com.sinco.carnation.goods.model.GoodsPhotoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsPhotoMapper {

	List<GoodsPhotoBO> findBOByGoodsId(@Param("goodsId") Long goodsId);

	int countByExample(GoodsPhotoExample example);

	int deleteByExample(GoodsPhotoExample example);

	int deleteByPrimaryKey(@Param("goodsId") Long goodsId, @Param("photoId") Long photoId);

	int insert(GoodsPhoto record);

	int insertSelective(GoodsPhoto record);

	List<GoodsPhoto> selectByExample(GoodsPhotoExample example);

	int updateByExampleSelective(@Param("record") GoodsPhoto record,
			@Param("example") GoodsPhotoExample example);

	int updateByExample(@Param("record") GoodsPhoto record, @Param("example") GoodsPhotoExample example);
}