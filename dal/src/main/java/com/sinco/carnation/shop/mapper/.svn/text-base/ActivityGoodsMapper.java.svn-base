package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ActivityGoodsBO;
import com.sinco.carnation.shop.model.ActivityGoods;
import com.sinco.carnation.shop.model.ActivityGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityGoodsMapper {
	int countByExample(ActivityGoodsExample example);

	int deleteByExample(ActivityGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActivityGoods record);

	int insertSelective(ActivityGoods record);

	List<ActivityGoodsBO> selectByExampleWithBLOBs(ActivityGoodsExample example);

	List<ActivityGoodsBO> selectByExample(ActivityGoodsExample example);

	ActivityGoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActivityGoods record,
			@Param("example") ActivityGoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") ActivityGoods record,
			@Param("example") ActivityGoodsExample example);

	int updateByExample(@Param("record") ActivityGoods record, @Param("example") ActivityGoodsExample example);

	int updateByPrimaryKeySelective(ActivityGoods record);

	int updateByPrimaryKeyWithBLOBs(ActivityGoods record);

	int updateByPrimaryKey(ActivityGoods record);
}