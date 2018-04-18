package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsTypeBO;
import com.sinco.carnation.goods.model.GoodsType;
import com.sinco.carnation.goods.model.GoodsTypeExample;
import com.sinco.dal.common.MyPage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {

	List<GoodsTypeBO> findByPage(@Param("page") MyPage<GoodsTypeBO> page);

	List<GoodsTypeBO> selectBOByExample(GoodsTypeExample example);

	int countByExample(GoodsTypeExample example);

	int deleteByExample(GoodsTypeExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsType record);

	int insertSelective(GoodsType record);

	List<GoodsType> selectByExample(GoodsTypeExample example);

	GoodsType selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

	int updateByExample(@Param("record") GoodsType record, @Param("example") GoodsTypeExample example);

	int updateByPrimaryKeySelective(GoodsType record);

	int updateByPrimaryKey(GoodsType record);
}