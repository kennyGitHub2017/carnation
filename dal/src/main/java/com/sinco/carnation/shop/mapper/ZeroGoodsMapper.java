package com.sinco.carnation.shop.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.ZeroGoodsBO;
import com.sinco.carnation.shop.model.ZeroGoods;
import com.sinco.carnation.shop.model.ZeroGoodsExample;
import com.sinco.carnation.shop.vo.ZeroGoodsVO;
import com.sinco.dal.common.MyPage;

public interface ZeroGoodsMapper {
	int countByExample(ZeroGoodsExample example);

	int deleteByExample(ZeroGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ZeroGoods record);

	int insertSelective(ZeroGoods record);

	List<ZeroGoodsBO> selectByExample(ZeroGoodsExample example);

	ZeroGoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ZeroGoods record, @Param("example") ZeroGoodsExample example);

	int updateByExample(@Param("record") ZeroGoods record, @Param("example") ZeroGoodsExample example);

	int updateByPrimaryKeySelective(ZeroGoods record);

	int updateByPrimaryKey(ZeroGoods record);

	public ZeroGoodsBO getByGoodsId(@Param("goodsId") Long goodsId);

	List<ZeroGoodsBO> findByVo(@Param("vo") ZeroGoodsVO vo);

	List<ZeroGoodsBO> findPageByVo(@Param("vo") ZeroGoodsVO vo, MyPage<ZeroGoodsBO> page);
}