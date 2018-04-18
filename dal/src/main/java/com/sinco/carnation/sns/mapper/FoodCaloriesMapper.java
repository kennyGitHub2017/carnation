package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.FoodCaloriesBO;
import com.sinco.carnation.sns.model.FoodCalories;
import com.sinco.carnation.sns.model.FoodCaloriesExample;
import com.sinco.carnation.sns.vo.FoodCaloriesVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodCaloriesMapper {
	int countByExample(FoodCaloriesExample example);

	int deleteByExample(FoodCaloriesExample example);

	int deleteByPrimaryKey(Long id);

	int insert(FoodCalories record);

	int insertSelective(FoodCalories record);

	List<FoodCaloriesBO> selectByExample(FoodCaloriesExample example);

	FoodCaloriesBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") FoodCalories record,
			@Param("example") FoodCaloriesExample example);

	int updateByExample(@Param("record") FoodCalories record, @Param("example") FoodCaloriesExample example);

	int updateByPrimaryKeySelective(FoodCalories record);

	int updateByPrimaryKey(FoodCalories record);

	List<FoodCaloriesBO> findPageByVO(MyPage<FoodCaloriesBO> page, @Param("vo") FoodCaloriesVO vo);

	List<FoodCaloriesBO> queryFoodCaloriesById(@Param("classId") Long classId);

	void deleteByIdList(@Param("ids") List<Long> idList);
}