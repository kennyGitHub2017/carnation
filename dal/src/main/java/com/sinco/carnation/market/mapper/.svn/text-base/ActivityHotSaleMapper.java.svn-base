package com.sinco.carnation.market.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.market.bo.ActivityHotSaleBO;
import com.sinco.carnation.market.bo.ActivityHotSaleGoodsInfoBO;
import com.sinco.carnation.market.model.ActivityHotSale;
import com.sinco.carnation.market.model.ActivityHotSaleExample;
import com.sinco.carnation.market.vo.ActivityHotSaleVO;
import com.sinco.dal.common.MyPage;

public interface ActivityHotSaleMapper {
	int countByExample(ActivityHotSaleExample example);

	int deleteByExample(ActivityHotSaleExample example);

	int deleteByPrimaryKey(Long id);

	int insert(ActivityHotSale record);

	int insertSelective(ActivityHotSale record);

	List<ActivityHotSaleBO> selectByExample(ActivityHotSaleExample example);

	ActivityHotSaleBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") ActivityHotSale record,
			@Param("example") ActivityHotSaleExample example);

	int updateByExample(@Param("record") ActivityHotSale record, @Param("example") ActivityHotSaleExample example);

	int updateByPrimaryKeySelective(ActivityHotSale record);

	int updateByPrimaryKey(ActivityHotSale record);

	// 查询参加促销活动的商品列表信息
	List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsList(@Param("id") Long actHotSaleId,
			@Param("vcode") String vcode);

	// 查询参加促销活动的商品分页列表信息
	List<ActivityHotSaleGoodsInfoBO> findActHotSaleGoodsListByPage(@Param("id") Long actHotSaleId,
			@Param("vcode") String vcode, MyPage<ActivityHotSaleGoodsInfoBO> page);

	List<ActivityHotSaleGoodsInfoBO> queryActHotSaleGoodsListByPage(@Param("maxId") Long maxId,
			@Param("vcode") String vcode, @Param("start") Integer start, @Param("pageSize") Integer pageSize);

	List<ActivityHotSaleBO> findAllByPage(@Param("vo") ActivityHotSaleVO vo, MyPage<ActivityHotSaleBO> page);

	public List<ActivityHotSale> findByActHotSaleGoodsList(ActivityHotSale obj);

	ActivityHotSaleBO findNewAppHotSaleInfo(@Param("vcode") String vcode, @Param("currentTime") Date currentTime,
			@Param("dayOfMinutes") Integer dayOfMinutes);
}