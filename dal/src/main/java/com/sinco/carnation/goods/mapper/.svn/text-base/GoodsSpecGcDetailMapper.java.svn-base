package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.model.GoodsSpecGcDetail;
import com.sinco.carnation.goods.model.GoodsSpecGcDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSpecGcDetailMapper {
	int countByExample(GoodsSpecGcDetailExample example);

	int deleteByExample(GoodsSpecGcDetailExample example);

	int deleteByPrimaryKey(@Param("specGcId") Long specGcId, @Param("specId") Long specId);

	int insert(GoodsSpecGcDetail record);

	int insertSelective(GoodsSpecGcDetail record);

	List<GoodsSpecGcDetail> selectByExample(GoodsSpecGcDetailExample example);

	int updateByExampleSelective(@Param("record") GoodsSpecGcDetail record,
			@Param("example") GoodsSpecGcDetailExample example);

	int updateByExample(@Param("record") GoodsSpecGcDetail record,
			@Param("example") GoodsSpecGcDetailExample example);
}