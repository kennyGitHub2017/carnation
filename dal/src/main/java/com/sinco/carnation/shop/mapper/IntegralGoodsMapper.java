package com.sinco.carnation.shop.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.shop.bo.IntegralGoodsBO;
import com.sinco.carnation.shop.model.IntegralGoods;
import com.sinco.carnation.shop.model.IntegralGoodsExample;
import com.sinco.carnation.shop.vo.IntegralGoodsVO;
import com.sinco.dal.common.MyPage;

public interface IntegralGoodsMapper {

	int subtractGoodsCount(@Param("id") Long id, @Param("count") int count);

	int addExchangeCount(@Param("id") Long id, @Param("count") int count);

	int countByExample(IntegralGoodsExample example);

	int deleteByExample(IntegralGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IntegralGoods record);

	int insertSelective(IntegralGoods record);

	List<IntegralGoodsBO> selectByExampleWithBLOBs(IntegralGoodsExample example);

	List<IntegralGoodsBO> selectByExample(IntegralGoodsExample example);

	@SuppressWarnings("rawtypes")
	List<Map> searchA(@Param("recommend") boolean recommend, @Param("show") boolean show);

	@SuppressWarnings("rawtypes")
	List<Map> searchB(@Param("recommend") boolean recommend, @Param("show") boolean show,
			@Param("begin") int begin);

	@SuppressWarnings("rawtypes")
	List<Map> searchC(@Param("recommend") boolean recommend, @Param("show") boolean show,
			@Param("begin") int begin, @Param("end") int end);

	@SuppressWarnings("rawtypes")
	List<Map> selectForDesc();

	@SuppressWarnings("rawtypes")
	List<Map> selectForList(@Param("orderType") String orderType, @Param("rang_begin") String rang_begin,
			@Param("rang_end") String rang_end, MyPage<Map> page);

	List<IntegralGoodsBO> selectForListBean(@Param("orderType") String orderType,
			@Param("rang_begin") String rang_begin, @Param("rang_end") String rang_end,
			MyPage<IntegralGoodsBO> page);

	IntegralGoodsBO selectByPrimaryKey(Long id);

	@SuppressWarnings("rawtypes")
	Map selectByKeyForMap(Long id);

	int updateByExampleSelective(@Param("record") IntegralGoods record,
			@Param("example") IntegralGoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") IntegralGoods record,
			@Param("example") IntegralGoodsExample example);

	int updateByExample(@Param("record") IntegralGoods record, @Param("example") IntegralGoodsExample example);

	int updateByPrimaryKeySelective(IntegralGoods record);

	int updateByPrimaryKeyWithBLOBs(IntegralGoods record);

	int updateByPrimaryKey(IntegralGoods record);

	List<IntegralGoodsBO> findListByVo(MyPage<IntegralGoodsBO> page, @Param("vo") IntegralGoodsVO vo);

	List<IntegralGoodsBO> queryIntegralGoodsCountList(@Param("goodIds") Long[] goodIds);

	List<IntegralGoodsBO> selectListByCriteria(@Param("orderType") String orderType,
			@Param("rang_begin") String rang_begin, @Param("rang_end") String rang_end,
			MyPage<IntegralGoodsBO> page);
}