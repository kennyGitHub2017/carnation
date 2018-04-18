package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.model.Watermark;
import com.sinco.carnation.shop.model.WatermarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WatermarkMapper {
	int countByExample(WatermarkExample example);

	int deleteByExample(WatermarkExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Watermark record);

	int insertSelective(Watermark record);

	List<Watermark> selectByExample(WatermarkExample example);

	Watermark selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Watermark record, @Param("example") WatermarkExample example);

	int updateByExample(@Param("record") Watermark record, @Param("example") WatermarkExample example);

	int updateByPrimaryKeySelective(Watermark record);

	int updateByPrimaryKey(Watermark record);
}