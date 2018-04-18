package com.sinco.carnation.o2o.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.model.GroupGoodsExample;
import com.sinco.carnation.o2o.vo.GroupGoodsListShowVO;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.dal.common.MyPage;

public interface GroupGoodsMapper {

	Long sumSelledCountByStore(Long storeId);

	List<GroupGoodsBO> findListShow(GroupGoodsListShowVO vo);

	List<GroupGoodsBO> findListPageShow(@Param("vo") GroupGoodsListShowVO vo,
			@Param("page") MyPage<GroupGoodsBO> page);

	int increaseGoodsCollect(Long id);

	int countByExample(GroupGoodsExample example);

	int deleteByExample(GroupGoodsExample example);

	int deleteByPrimaryKey(Long id);

	int insert(GroupGoods record);

	int insertSelective(GroupGoods record);

	List<GroupGoodsBO> selectByExampleWithBLOBs(GroupGoodsExample example);

	List<GroupGoodsBO> selectByExample(GroupGoodsExample example);

	GroupGoodsBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") GroupGoods record,
			@Param("example") GroupGoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") GroupGoods record,
			@Param("example") GroupGoodsExample example);

	int updateByExample(@Param("record") GroupGoods record, @Param("example") GroupGoodsExample example);

	int updateByPrimaryKeySelective(GroupGoods record);

	int updateByPrimaryKeyWithBLOBs(GroupGoods record);

	int updateByPrimaryKey(GroupGoods record);

	List<Map<String, Integer>> findCountByStoreId(@Param("storeId") Long storeId);

	List<GroupGoodsBO> findListByVO(MyPage<GroupGoodsBO> page, @Param("vo") GroupGoodsVO vo);

	List<GroupGoodsBO> findOperatorGoodsListByVO(MyPage<GroupGoodsBO> page, @Param("vo") GroupGoodsVO vo);

	GroupGoodsBO findOperatorGoodsById(@Param("ggId") Long goodsId, @Param("operatorId") Long operatorId);

	GroupGoodsBO queryGroupGoodsById(@Param("goodsId") Long goodsId);

	List<GroupGoodsBO> queryGroupGoodsPageList(@Param("storeId") Long storeId,
			@Param("goodsType") Integer goodsType, @Param("ggStatus") Integer ggStatus,
			@Param("page") MyPage<GroupGoodsBO> page);

	GroupGoodsBO queryGroupDetails(@Param("groupSn") String groupSn, @Param("sellerUid") Long sellerUid);

	List<GroupGoods> findTopByStoreId(@Param("storeId") Long storeId);

	List<GroupGoodsBO> selectGoodsYourLike(@Param("goodsId") Long goodsId,
			@Param("goodsIds") Set<Long> goodsIds, @Param("start") Integer start,
			@Param("offset") Integer offset, @Param("areaId") Long areaId);

	List<GroupGoodsBO> queryGroupGoodsList(@Param("goodType") Integer goodType,
			@Param("status") Integer status, @Param("storeId") Long storeId);

	List<GroupGoodsBO> queryRefundgoodsPageList(@Param("storeId") Long storeId,
			@Param("page") MyPage<GroupGoodsBO> page);

	List<GroupGoodsBO> findExpiredGroupGoods(@Param("startTime") String startTime,
			@Param("endTime") String endTime);

	GroupGoodsBO queryAwayStoreInfo(@Param("storeId") Long storeId);

	List<GroupGoodsBO> queryGroupGoodsFavaList(@Param("uid") Long uid,
			@Param("page") MyPage<GroupGoodsBO> page);

	List<GroupGoodsBO> queryByIds(@Param("ids") Set<Long> ids);

	int subductionGoodsCollect(Long id);

	int findCountWarnGoods(@Param("storeId") Long storeId);
}