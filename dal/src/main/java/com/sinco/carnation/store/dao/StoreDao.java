package com.sinco.carnation.store.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.StoreBO;
import com.sinco.carnation.store.mapper.StoreMapper;
import com.sinco.carnation.store.model.Store;
import com.sinco.carnation.store.model.StoreExample;
import com.sinco.carnation.store.vo.GroupStoreListVO;
import com.sinco.carnation.store.vo.StoreVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class StoreDao {
	private static final Logger logger = LoggerFactory.getLogger(StoreDao.class);
	@Autowired
	private StoreMapper mapper;

	@Autowired
	private DicNameMappingHandle mappingHandle;

	/**
	 * 查找用于重跑搜索引擎的店铺
	 * 
	 * @return
	 */
	public List<Long> findInitLuceneList() {
		return mapper.findInitLuceneList();
	}

	/**
	 * 查找初始化权限的店铺
	 * 
	 * @return
	 */
	public List<StoreBO> findInitRoleList() {
		return mapper.findInitRoleList();
	}

	/**
	 * 得到店铺状态
	 * 
	 * @param id
	 * @return
	 */
	public StoreBO getStoreStatus(Long id) {
		return mapper.getStoreStatus(id);
	}

	public List<StoreBO> selectCheckListByOperatorId(MyPage<StoreBO> page, Long operatorId, String storeName,
			String operatorLevel) {
		List<StoreBO> list = mapper.selectCheckListByOperatorId(page, operatorId, storeName, operatorLevel);
		mappingHandle.mappinHandle(list);
		return list;
	}

	public List<StoreBO> selectOperatorCheckList(MyPage<StoreBO> page, String operatorCode,
			String operatorName, String storeName, String operatorUserName) {
		List<StoreBO> list = mapper.selectOperatorCheckList(page, operatorCode, operatorName, storeName,
				operatorUserName);
		mappingHandle.mappinHandle(list);
		return list;
	}

	public List<StoreBO> selectAllotStoreList(MyPage<StoreBO> page, StoreVO vo) {
		List<StoreBO> list = mapper.selectAllotStoreList(page, vo);
		mappingHandle.mappinHandle(list);
		mappingHandle.mappinHandle(vo);
		return list;
	}

	public StoreBO selectOwnStoreByOperatorId(String operatorAreaId, Long storeId, String operatorLevel) {
		return mapper.selectOwnStoreByOperatorId(operatorAreaId, storeId, operatorLevel);
	}

	/**
	 * 查找用户是否有店铺
	 * 
	 * @param uid
	 * @return
	 */
	public int countByCreateUserId(Long uid) {
		StoreExample example = new StoreExample();
		example.createCriteria().andCreateUserIdEqualTo(uid);
		return mapper.countByExample(example);
	}

	/**
	 * 查找服务店铺
	 * 
	 * @param vo
	 * @return
	 */
	public List<StoreBO> findGroupStoreList(GroupStoreListVO vo) {
		return mapper.findGroupStoreList(vo);
	}

	/**
	 * 根据时间查询店铺数量
	 * 
	 * @return
	 */
	public int selectAuditStoreCount(List<Integer> list) {
		StoreExample example = new StoreExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andStoreStatusIn(list);
		return mapper.countByExample(example);
	}

	/**
	 * 根据时间查询店铺数量
	 * 
	 * @return
	 */
	public int selectStoreCountByTime(Date time) {
		StoreExample example = new StoreExample();
		example.createCriteria().andAddTimeGreaterThanOrEqualTo(time).andDeleteStatusEqualTo(false);
		return mapper.countByExample(example);
	}

	/**
	 * 增加店铺收藏
	 * 
	 * @param id
	 * @return
	 */
	public int increaseFavoriteCount(Long id) {
		return mapper.increaseFavoriteCount(id);
	}

	public int addStoreAmount(BigDecimal storeCommissionAmount, BigDecimal storePayoffAmount,
			BigDecimal storeSaleAmount, Long id) {
		return mapper.addStoreAmount(storeCommissionAmount, storePayoffAmount, storeSaleAmount, id);
	}

	public List<StoreBO> findStoreByKeywords(String keywords) {
		return mapper.findStoreByKeywords(keywords);
	}

	/** generate code begin **/
	public List<StoreBO> findAll() {
		StoreExample example = new StoreExample();
		return mapper.selectByExample(example);
	}

	public int count() {
		StoreExample example = new StoreExample();
		return mapper.countByExample(example);
	}

	public List<Store> save(Iterable<Store> entities) {
		List<Store> list = new ArrayList<Store>();
		for (Store Store : entities) {
			list.add(save(Store));
		}
		return list;
	}

	public Store save(Store record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Store record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public void update(StoreVO vo) {
		try {
			Store s = null;
			if (vo != null) {
				s = new Store();
				BeanUtils.copyProperties(vo, s);
			}
			this.mapper.updateByPrimaryKeySelective(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public StoreBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreBO findObjById(java.lang.Long id) {
		StoreExample example = new StoreExample();
		example.createCriteria().andIdEqualTo(id).andDeleteStatusEqualTo(false);
		List<StoreBO> list = mapper.selectByExample(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public StoreBO get(java.lang.Long id) {
		StoreBO store = mapper.selectByPrimaryKey(id);
		try {
			mappingHandle.mappinHandle(store);
		} catch (Exception e) {
			logger.error("[load redis] error.", e);
		}
		return store;
	}

	public boolean exists(java.lang.Long id) {
		StoreExample example = new StoreExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreBO> findAll(Iterable<Long> ids) {
		StoreExample example = new StoreExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Store entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Store> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Store entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreExample example = new StoreExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreExample example = new StoreExample();
		mapper.deleteByExample(example);
	}

	/**
	 * generate code end
	 * 
	 * @param page
	 **/

	public List<StoreBO> findListByVO(MyPage<StoreBO> page, StoreVO vo) {
		return mapper.findListByVO(page, vo);
	}

	public List<StoreBO> findStore(String storeName, Long id) {
		return mapper.findStore(storeName, id);
	}

	public List<StoreBO> queryFavaStorePageList(Long uid, String type, MyPage<StoreBO> page) {
		return mapper.queryFavaStorePageList(uid, type, page);
	}

	public StoreBO queryStoreInfo(Long uid,boolean group, boolean shop) {
		return mapper.queryStoreInfo(uid, group, shop);
	}

	// public StoreBO queryStoreInfoByUid(Long uid) {
	// return mapper.queryStoreInfoByUid(uid);
	// }

	public StoreBO queryStoreStatus(Long uid,Boolean group, Boolean shop) {
		return mapper.queryStoreStatus(uid,group,shop);
	}

	public StoreBO queryStoreById(Long storeId) {
		return mapper.queryStoreById(storeId);
	}

	public StoreBO fetchStoreByCreateUserId(Long userId) {
		return mapper.fetchStoreByCreateUserId(userId);
	}

	public List<StoreBO> queryStoreFavorites(Long uid, Integer type, MyPage<StoreBO> page) {
		return mapper.queryStoreFavorites(uid, type, page);
	}

	public List<StoreBO> queryRecommStore(Double storeLat, Double storeLon, Boolean store_recommend,
			MyPage<StoreBO> page) {
		return mapper.queryRecommStore(storeLat, storeLon, store_recommend, page);
	}

	public List<StoreBO> queryRecommStoreByArea(Set<Long> areaIds, Boolean store_recommend,
			MyPage<StoreBO> page) {
		return mapper.queryRecommStoreByArea(areaIds, store_recommend, page);
	}

	public List<StoreBO> queryStoreGoods(Double storeLat, Double storeLon, Boolean store_recommend,
			MyPage<StoreBO> page) {
		return mapper.queryStoreGoods(storeLat, storeLon, store_recommend, page);
	}

	public List<StoreBO> queryStoreGoodsByArea(Set<Long> areaIds, Boolean store_recommend,
			MyPage<StoreBO> page) {
		return mapper.queryStoreGoodsByArea(areaIds, store_recommend, page);
	}

	public List<StoreBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}

	public List<StoreBO> queryBusinessPageList(StoreVO vo, MyPage<StoreBO> page) {
		return mapper.queryBusinessPageList(vo, page);
	}

	public StoreBO queryStoreByCreateUserId(Long uid) {
		return mapper.queryStoreByCreateUserId(uid);
	}

	public int subductionFavoriteCount(Long id) {
		return mapper.subductionFavoriteCount(id);
	}

	public int selectStoreByArea(String areaId) {
		return mapper.selectStoreByArea(areaId);
	}

	public StoreBO getStoreByUserId(Long userId) {
		StoreExample example = new StoreExample();
		example.createCriteria().andCreateUserIdEqualTo(userId);
		List<StoreBO> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int update_Store_IsExtension_By_IDList(List<Long> idList, Boolean isExtension) {
		return this.mapper.update_Store_IsExtension_By_IDList(idList, isExtension);
	}

}
