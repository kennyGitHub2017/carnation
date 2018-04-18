package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.GoodsReturn;
import com.sinco.carnation.goods.model.GoodsReturnExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsReturnMapper {
	int countByExample(GoodsReturnExample example);

	int deleteByExample(GoodsReturnExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsReturn record);

	int insertSelective(GoodsReturn record);

	List<GoodsReturn> selectByExampleWithBLOBs(GoodsReturnExample example);

	List<GoodsReturn> selectByExample(GoodsReturnExample example);

	GoodsReturn selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsReturn record,
			@Param("example") GoodsReturnExample example);

	int updateByExampleWithBLOBs(@Param("record") GoodsReturn record,
			@Param("example") GoodsReturnExample example);

	int updateByExample(@Param("record") GoodsReturn record, @Param("example") GoodsReturnExample example);

	int updateByPrimaryKeySelective(GoodsReturn record);

	int updateByPrimaryKeyWithBLOBs(GoodsReturn record);

	int updateByPrimaryKey(GoodsReturn record);
}