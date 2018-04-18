package com.sinco.carnation.store.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreExample;
import com.sinco.carnation.store.vo.GroupStoreListVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.dal.common.MyPage;

public interface StoreMapper {

	List<StoreBO> findInitRoleList();

	List<Long> findInitLuceneList();

	List<StoreBO> findGroupStoreList(GroupStoreListVO vo);

	StoreBO getStoreStatus(Long id);

	int increaseFavoriteCount(Long id);

	int addStoreAmount(@Param("storeCommissionAmount") BigDecimal storeCommissionAmount,
			@Param("storePayoffAmount") BigDecimal storePayoffAmount,
			@Param("storeSaleAmount") BigDecimal storeSaleAmount, @Param("id") Long id);

	int countByExample(StoreExample example);

	int deleteByExample(StoreExample example);

	int deleteByPrimaryKey(Long id);

	int insert(Store record);

	int insertSelective(Store record);

	List<StoreBO> selectByExampleWithBLOBs(StoreExample example);

	List<StoreBO> findStoreByKeywords(@Param("keywords") String keywords);

	List<StoreBO> selectByExample(StoreExample example);

	StoreBO selectByPrimaryKey(Long id);

	int updateByExampleSelective(@Param("record") Store record, @Param("example") StoreExample example);

	int updateByExampleWithBLOBs(@Param("record") Store record, @Param("example") StoreExample example);

	int updateByExample(@Param("record") Store record, @Param("example") StoreExample example);

	int updateByPrimaryKeySelective(Store record);

	int updateByPrimaryKeyWithBLOBs(Store record);

	int updateByPrimaryKey(Store record);

	List<StoreBO> findListByVO(MyPage<StoreBO> page, @Param("vo") StoreVO vo);

	List<StoreBO> findStore(@Param("storeName") String storeName, @Param("id") Long id);

	List<StoreBO> queryFavaStorePageList(@Param("userid") Long userid, @Param("type") String type,
			MyPage<StoreBO> page);

	StoreBO queryStoreInfo(@Param("uid") Long uid,@Param("group") boolean group, @Param("shop") boolean shop);

//	StoreBO queryStoreInfoByUid(@Param("uid") Long uid);

	StoreBO queryStoreStatus(@Param("uid") Long uid,@Param("group") boolean group, @Param("shop") boolean shop);

	StoreBO queryStoreById(@Param("storeId") Long storeId);

	List<StoreBO> selectOperatorCheckList(MyPage<StoreBO> page, @Param("operatorCode") String operatorCode,
			@Param("operatorName") String operatorName, @Param("storeName") String storeName,
			@Param("operatorUserName") String operatorUserName);

	List<StoreBO> selectAllotStoreList(MyPage<StoreBO> page, @Param("vo") StoreVO vo);

	List<StoreBO> selectCheckListByOperatorId(MyPage<StoreBO> page, @Param("operatorId") Long operatorId,
			@Param("storeName") String storeName, @Param("operatorLevel") String operatorLevel);

	StoreBO selectOwnStoreByOperatorId(@Param("operatorAreaId") String operatorAreaId,
			@Param("storeId") Long storeId, @Param("operatorLevel") String operatorLevel);

	List<StoreBO> queryStoreFavorites(@Param("uid") Long uid, @Param("type") Integer type,
			@Param("page") MyPage<StoreBO> page);

	List<StoreBO> queryRecommStore(@Param("storeLat") Double storeLat, @Param("storeLon") Double storeLon,
			@Param("store_recommend") Boolean store_recommend, @Param("page") MyPage<StoreBO> page);

	List<StoreBO> queryRecommStoreByArea(@Param("areaIds") Set<Long> areaIds,
			@Param("store_recommend") Boolean store_recommend, @Param("page") MyPage<StoreBO> page);

	List<StoreBO> queryStoreGoods(@Param("storeLat") Double storeLat, @Param("storeLon") Double storeLon,
			@Param("store_recommend") Boolean store_recommend, @Param("page") MyPage<StoreBO> page);

	List<StoreBO> queryStoreGoodsByArea(@Param("areaIds") Set<Long> areaIds,
			@Param("store_recommend") Boolean store_recommend, @Param("page") MyPage<StoreBO> page);

	StoreBO fetchStoreByCreateUserId(@Param("userId") Long userId);

	List<StoreBO> queryByIds(@Param("ids") Set<Long> ids);

	List<StoreBO> queryBusinessPageList(@Param("vo") StoreVO vo, @Param("page") MyPage<StoreBO> page);

	StoreBO queryStoreByCreateUserId(@Param("uid") Long uid);

	int subductionFavoriteCount(Long id);

	int selectStoreByArea(@Param("areaId") String areaId);

	public int update_Store_IsExtension_By_IDList(@Param("list") List<Long> idList,
			@Param("isExtension") Boolean isExtension);
}