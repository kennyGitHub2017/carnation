package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsBrandCategoryBO;
import com.sinco.carnation.goods.model.GoodsBrandCategory;
import com.sinco.carnation.goods.model.GoodsBrandCategoryExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsBrandCategoryMapper {

	List<GoodsBrandCategoryBO> selectBOByExample(GoodsBrandCategoryExample example);

	int countByExample(GoodsBrandCategoryExample example);

	int deleteByExample(GoodsBrandCategoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsBrandCategory record);

	int insertSelective(GoodsBrandCategory record);

	List<GoodsBrandCategory> selectByExample(GoodsBrandCategoryExample example);

	GoodsBrandCategory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsBrandCategory record,
			@Param("example") GoodsBrandCategoryExample example);

	int updateByExample(@Param("record") GoodsBrandCategory record,
			@Param("example") GoodsBrandCategoryExample example);

	int updateByPrimaryKeySelective(GoodsBrandCategory record);

	int updateByPrimaryKey(GoodsBrandCategory record);
}