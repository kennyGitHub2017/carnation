package com.sinco.carnation.shop.mapper;

import com.sinco.carnation.shop.bo.ComplaintGoodsBO;
import com.sinco.carnation.shop.model.ComplaintGoods;
import com.sinco.carnation.shop.model.ComplaintGoodsExample;
import com.sinco.carnation.shop.vo.ComplaintGoodsVO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ComplaintGoodsMapper {
	int countByExample(ComplaintGoodsExample example);

	int deleteByExample(ComplaintGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ComplaintGoods record);

	int insertSelective(ComplaintGoods record);

	List<ComplaintGoodsBO> selectByExampleWithBLOBs(ComplaintGoodsExample example);

	List<ComplaintGoodsBO> selectByExample(ComplaintGoodsExample example);

	ComplaintGoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ComplaintGoods record,
			@Param("example") ComplaintGoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") ComplaintGoods record,
			@Param("example") ComplaintGoodsExample example);

	int updateByExample(@Param("record") ComplaintGoods record,
			@Param("example") ComplaintGoodsExample example);

	int updateByPrimaryKeySelective(ComplaintGoods record);

	int updateByPrimaryKeyWithBLOBs(ComplaintGoods record);

	int updateByPrimaryKey(ComplaintGoods record);

	List<ComplaintGoodsBO> findListByVo(@Param("vo") ComplaintGoodsVO vo);
}