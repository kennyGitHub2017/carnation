package com.sinco.carnation.o2o.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupGoodsBO;
import com.sinco.carnation.o2o.constants.GroupGoodsConstants;
import com.sinco.carnation.o2o.mapper.GroupGoodsMapper;
import com.sinco.carnation.o2o.model.GroupGoods;
import com.sinco.carnation.o2o.model.GroupGoodsExample;
import com.sinco.carnation.o2o.vo.GroupGoodsListShowVO;
import com.sinco.carnation.o2o.vo.GroupGoodsVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class GroupGoodsDao {

	@Autowired
	private GroupGoodsMapper mapper;
	@Autowired
	private DicNameMappingHandle dicNameMappingHandle;

	/**
	 * 查找正常上架的服务数量
	 * 
	 * @return
	 */
	public int countByNormal(Long storeId) {
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andStoreIdEqualTo(storeId)
				.andGgStatusEqualTo(GroupGoodsConstants.GROUP_GOODS_STATUS_SELLING);
		return mapper.countByExample(example);
	}

	/**
	 * 查找店铺总销量
	 * 
	 * @param storeId
	 * @return
	 */
	public Long sumSelledCountByStore(Long storeId) {
		return mapper.sumSelledCountByStore(storeId);
	}

	/**
	 * 查找服务列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListShow(GroupGoodsListShowVO vo) {
		return mapper.findListShow(vo);
	}

	/**
	 * 查找服务列表
	 * 
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListPageShow(GroupGoodsListShowVO vo, MyPage<GroupGoodsBO> page) {
		return mapper.findListPageShow(vo, page);
	}

	/**
	 * 后端查找服务列表
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<GroupGoodsBO> findListByVO(MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		mapper.findListByVO(page, vo);
		dicNameMappingHandle.mappinHandle(page.getContent());
		return page.getContent();
	}

	public List<GroupGoodsBO> findOperatorGoodsListByVO(MyPage<GroupGoodsBO> page, GroupGoodsVO vo) {
		mapper.findOperatorGoodsListByVO(page, vo);
		dicNameMappingHandle.mappinHandle(page.getContent());
		return page.getContent();
	}

	public GroupGoodsBO findOperatorGoodsById(Long goodsId, Long operatorId) {
		return mapper.findOperatorGoodsById(goodsId, operatorId);
	}

	/**
	 * 添加收藏数
	 * 
	 * @param id
	 * @return
	 */
	public int increaseGoodsCollect(Long id) {
		return mapper.increaseGoodsCollect(id);
	}

	/** generate code begin **/
	public List<GroupGoodsBO> findAll() {
		GroupGoodsExample example = new GroupGoodsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupGoodsExample example = new GroupGoodsExample();
		return mapper.countByExample(example);
	}

	public List<GroupGoods> save(Iterable<GroupGoods> entities) {
		List<GroupGoods> list = new ArrayList<GroupGoods>();
		for (GroupGoods GroupGoods : entities) {
			list.add(save(GroupGoods));
		}
		return list;
	}

	public GroupGoods save(GroupGoods record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(GroupGoods record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public GroupGoodsBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupGoodsBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupGoodsBO> findAll(Iterable<Long> ids) {
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<GroupGoodsBO> findAllByIds(Iterable<Long> ids) {
		return this.findAll(ids);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupGoods entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<GroupGoods> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupGoods entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupGoodsExample example = new GroupGoodsExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<Map<String, Integer>> findCountByStoreId(Long storeId) {
		return mapper.findCountByStoreId(storeId);
	}

	public List<GroupGoodsBO> queryGroupGoodsPageList(Long storeId, Integer goodsType, Integer ggStatus,
			MyPage<GroupGoodsBO> page) {
		return mapper.queryGroupGoodsPageList(storeId, goodsType, ggStatus, page);
	}

	public GroupGoodsBO queryGroupGoodsById(Long goodsId) {
		return mapper.queryGroupGoodsById(goodsId);
	}

	public GroupGoodsBO queryGroupDetails(String groupSn, Long sellerUid) {
		return mapper.queryGroupDetails(groupSn, sellerUid);
	}

	public List<GroupGoodsBO> selectGoodsYourLike(Long goodsId, Integer start, Integer offset,
			Set<Long> goodsIds, Long areaId) {
		// TODO Auto-generated method stub
		return mapper.selectGoodsYourLike(goodsId, goodsIds, start, offset, areaId);
	}

	public List<GroupGoodsBO> findAllByStoreId(Long id) {
		GroupGoodsExample example = new GroupGoodsExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andStoreIdEqualTo(id);
		return mapper.selectByExample(example);
	}

	public List<GroupGoods> findTopByStoreId(Long storeId) {
		return mapper.findTopByStoreId(storeId);
	}

	public List<GroupGoodsBO> queryGroupGoodsList(Integer goodType, Integer status, Long storeId) {
		return mapper.queryGroupGoodsList(goodType, status, storeId);
	}

	public List<GroupGoodsBO> queryRefundgoodsPageList(Long storeId, MyPage<GroupGoodsBO> page) {
		return mapper.queryRefundgoodsPageList(storeId, page);
	}

	public List<GroupGoodsBO> findExpiredGroupGoods() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		String startTime = df.format(new Date(d.getTime() - 2 * 24 * 60 * 60 * 1000));
		String endTime = df.format(d);
		return this.mapper.findExpiredGroupGoods(startTime, endTime);
	}

	public GroupGoodsBO queryAwayStoreInfo(Long storeId) {
		return mapper.queryAwayStoreInfo(storeId);
	}

	public List<GroupGoodsBO> queryGroupGoodsFavaList(Long uid, MyPage<GroupGoodsBO> page) {
		return mapper.queryGroupGoodsFavaList(uid, page);
	}

	public List<GroupGoodsBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}

	public int subductionGoodsCollect(Long id) {
		return mapper.subductionGoodsCollect(id);
	}

	public int findCountWarnGoods(Long storeId) {
		return mapper.findCountWarnGoods(storeId);
	}
}
