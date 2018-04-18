package com.sinco.carnation.goldEgg.mapper;

import com.sinco.carnation.goldEgg.bo.GlodEggItemBO;
import com.sinco.carnation.goldEgg.model.GlodEggItem;
import com.sinco.carnation.goldEgg.model.GlodEggItemExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GlodEggItemMapper {
	int countByExample(GlodEggItemExample example);

	int deleteByExample(GlodEggItemExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GlodEggItem record);

	int insertSelective(GlodEggItem record);

	List<GlodEggItemBO> selectByExample(GlodEggItemExample example);

	GlodEggItemBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GlodEggItem record,
			@Param("example") GlodEggItemExample example);

	int updateByExample(@Param("record") GlodEggItem record, @Param("example") GlodEggItemExample example);

	int updateByPrimaryKeySelective(GlodEggItem record);

	int updateByPrimaryKey(GlodEggItem record);

	void addCurrentGetCount(@Param("id") Long id, @Param("num") long num);

	public void deleteByGlodEggID(@Param("glodEggId") Long goldEggID);

	public List<GlodEggItemBO> findByGlodEggID(@Param("glodEggId") Long act_GlodEgg_ID);
}