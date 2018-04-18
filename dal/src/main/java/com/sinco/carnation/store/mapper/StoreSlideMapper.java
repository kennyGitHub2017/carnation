package com.sinco.carnation.store.mapper;

import com.sinco.carnation.store.bo.StoreSlideBO;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.model.StoreSlideExample;
import com.sinco.carnation.store.vo.StoreSlideVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StoreSlideMapper {
	int countByExample(StoreSlideExample example);

	int deleteByExample(StoreSlideExample example);

	int deleteByPrimaryKey(Long id);

	int insert(StoreSlide record);

	int insertSelective(StoreSlide record);

	List<StoreSlideBO> selectByExample(StoreSlideExample example);

	StoreSlideBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") StoreSlide record,
			@Param("example") StoreSlideExample example);

	int updateByExample(@Param("record") StoreSlide record, @Param("example") StoreSlideExample example);

	int updateByPrimaryKeySelective(StoreSlide record);

	int updateByPrimaryKey(StoreSlide record);

	List<StoreSlide> findListByVo(@Param("vo") StoreSlideVO vo);
}