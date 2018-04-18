package com.sinco.carnation.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.goods.bo.GoodsSpecificationBO;
import com.sinco.carnation.goods.model.GoodsSpecification;
import com.sinco.carnation.goods.model.GoodsSpecificationExample;
import com.sinco.carnation.goods.vo.GoodsSpecificationVO;
import com.sinco.dal.common.MyPage;

public interface GoodsSpecificationMapper {

	public List<GoodsSpecificationBO> selectGoodsSpecList(@Param("goodsId") Long goodsId);

	int countByExample(GoodsSpecificationExample example);

	int deleteByExample(GoodsSpecificationExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GoodsSpecification record);

	int insertSelective(GoodsSpecification record);

	List<GoodsSpecification> selectByExample(GoodsSpecificationExample example);

	List<GoodsSpecificationBO> findBOPage(MyPage<GoodsSpecificationBO> page, @Param("specType") Integer type,
			@Param("storeId") Long storeId);

	GoodsSpecification selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GoodsSpecification record,
			@Param("example") GoodsSpecificationExample example);

	int updateByExample(@Param("record") GoodsSpecification record,
			@Param("example") GoodsSpecificationExample example);

	int updateByPrimaryKeySelective(GoodsSpecification record);

	int updateByPrimaryKey(GoodsSpecification record);

	List<GoodsSpecificationBO> findByVO(MyPage<GoodsSpecificationBO> page,
			@Param("vo") GoodsSpecificationVO vo);

}