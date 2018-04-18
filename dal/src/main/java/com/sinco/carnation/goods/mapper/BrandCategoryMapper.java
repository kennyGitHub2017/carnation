package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.BrandCategory;
import com.sinco.carnation.goods.model.BrandCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandCategoryMapper {
	int countByExample(BrandCategoryExample example);

	int deleteByExample(BrandCategoryExample example);

	int deleteByPrimaryKey(Long id);

	int insert(BrandCategory record);

	int insertSelective(BrandCategory record);

	List<BrandCategory> selectByExample(BrandCategoryExample example);

	BrandCategory selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") BrandCategory record,
			@Param("example") BrandCategoryExample example);

	int updateByExample(@Param("record") BrandCategory record, @Param("example") BrandCategoryExample example);

	int updateByPrimaryKeySelective(BrandCategory record);

	int updateByPrimaryKey(BrandCategory record);
}