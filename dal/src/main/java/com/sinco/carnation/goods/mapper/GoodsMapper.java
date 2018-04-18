package com.sinco.carnation.goods.mapper;

import com.sinco.carnation.goods.bo.GoodsBO;
import com.sinco.carnation.goods.model.Goods;
import com.sinco.carnation.goods.model.GoodsExample;
import com.sinco.carnation.goods.vo.GoodsShowListVO;
import com.sinco.carnation.goods.vo.GoodsVO;
import com.sinco.dal.common.MyPage;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface GoodsMapper {

	/**
	 * 增加收藏数
	 * 
	 * @param id
	 * @return
	 */
	int increaseGoodsCollect(Long id);

	/**
	 * 减少收藏数
	 * 
	 * @param id
	 * @return
	 */
	int reduceGoodsCollect(Long id);

	/**
	 * 用于商城列表数据查询
	 * 
	 * @param vo
	 * @return
	 */
	List<GoodsBO> findShopListBO(GoodsShowListVO vo);

	List<Map<String, Integer>> findCountByStoreId(@Param("storeId") Long storeId);

	List<Long> findAllSellingGoods();

	GoodsBO findBOByid(Long id);

	int countByExample(GoodsExample example);

	int deleteByExample(GoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Goods record);

	int insertSelective(Goods record);

	List<Goods> selectByExampleWithBLOBs(GoodsExample example);

	List<Goods> selectByExample(GoodsExample example);

	List<GoodsBO> selectBOByVO(@Param("vo") GoodsVO vo, MyPage<GoodsBO> page);

	List<GoodsBO> selectGoodsListByVO(@Param("vo") GoodsVO vo, MyPage<GoodsBO> page);

	List<GoodsBO> searchGoodsYourLike(@Param("gcId") Long gcId, @Param("goodsId") Long goodsId,
			@Param("goodsIds") Set<Long> goodsIds, @Param("gcIds") Set<Long> gcIds,
			@Param("page") MyPage<GoodsBO> page);

	List<GoodsBO> selectGoodsYourLike(@Param("gcId") Long gcId, @Param("goodsId") Long goodsId,
			@Param("goodsIds") Set<Long> goodsIds, @Param("gcIds") Set<Long> gcIds,
			@Param("start") Integer start, @Param("offset") Integer offset);

	List<GoodsBO> selectSameClassGoodsList(@Param("gcId") Long gcId, @Param("goodsId") Long goodsId,
			@Param("start") Integer start, @Param("offset") Integer offset);

	GoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKeyWithBLOBs(Goods record);

	int updateByPrimaryKey(Goods record);

	List<GoodsBO> querygoodsYourLike(@Param("gcId") Long gcId, @Param("goodsId") Long goodsId,
			@Param("page") MyPage<GoodsBO> page);

	List<GoodsBO> findPageByVo(MyPage<GoodsBO> page, @Param("vo") GoodsVO vo);

	List<GoodsBO> queryFavaGoodsPageList(@Param("type") Integer type, @Param("uid") Long uid,
			@Param("page") MyPage<GoodsBO> page);

	List<GoodsBO> queryByIds(@Param("ids") Set<Long> ids);

	List<GoodsBO> searchGoodsLikeByIds(@Param("goodsIds") Long[] goodsIds);

	int findCountWarnGoods(@Param("storeId") Long storeId);

	List<GoodsBO> findGoodsByVoAndLimit(@Param("vo") GoodsVO vo, @Param("start") Integer start,
			@Param("offset") Integer offset);

	List<GoodsBO> selectYgGoodsListByVO(@Param("vo") GoodsVO vo, MyPage<GoodsBO> page);

	public void updateGoodStateByID(@Param("good") Goods good);

}