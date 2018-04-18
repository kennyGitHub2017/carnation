package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.GoodsTypeBrand;
import com.sinco.carnation.goods.model.GoodsTypeBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeBrandMapper {
	int countByExample(GoodsTypeBrandExample example);

	int deleteByExample(GoodsTypeBrandExample example);

	int deleteByPrimaryKey(@Param("brandId") Long brandId, @Param("typeId") Long typeId);

	int insert(GoodsTypeBrand record);

	int insertSelective(GoodsTypeBrand record);

	List<GoodsTypeBrand> selectByExample(GoodsTypeBrandExample example);

	int updateByExampleSelective(@Param("record") GoodsTypeBrand record,
			@Param("example") GoodsTypeBrandExample example);

	int updateByExample(@Param("record") GoodsTypeBrand record,
			@Param("example") GoodsTypeBrandExample example);
}