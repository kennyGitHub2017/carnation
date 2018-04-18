package com.sinco.carnation.sns.mapper;

import com.sinco.carnation.sns.bo.FoodClassBO;
import com.sinco.carnation.sns.model.FoodClass;
import com.sinco.carnation.sns.model.FoodClassExample;
import com.sinco.carnation.sns.vo.FoodClassVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FoodClassMapper {
	int countByExample(FoodClassExample example);

	int deleteByExample(FoodClassExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(FoodClass record);

	int insertSelective(FoodClass record);

	List<FoodClassBO> selectByExample(FoodClassExample example);

	FoodClassBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") FoodClass record, @Param("example") FoodClassExample example);

	int updateByExample(@Param("record") FoodClass record, @Param("example") FoodClassExample example);

	int updateByPrimaryKeySelective(FoodClass record);

	int updateByPrimaryKey(FoodClass record);

	List<FoodClassBO> findPageByVO(MyPage<FoodClassBO> page, @Param("vo") FoodClassVO vo);

	void updateDeleteStatus(@Param("ids") Long... array);

	List<FoodClassBO> queryFoodList(@Param("parentId") Integer parentId,
			@Param("page") MyPage<FoodClassBO> page);
}