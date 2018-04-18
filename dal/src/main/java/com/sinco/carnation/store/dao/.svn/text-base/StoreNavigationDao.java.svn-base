package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.mapper.StoreNavigationMapper;
import com.sinco.carnation.store.model.StoreNavigation;
import com.sinco.carnation.store.bo.StoreNavigationBO;
import com.sinco.carnation.store.model.StoreNavigationExample;
import com.sinco.carnation.store.vo.StoreNavigationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class StoreNavigationDao {

	@Autowired
	private StoreNavigationMapper mapper;

	public List<StoreNavigationBO> findAllByStoreId(Long storeId) {
		StoreNavigationExample example = new StoreNavigationExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andDisplayEqualTo(true)
				.andStoreIdEqualTo(storeId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<StoreNavigationBO> findAll() {
		StoreNavigationExample example = new StoreNavigationExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreNavigationExample example = new StoreNavigationExample();
		return mapper.countByExample(example);
	}

	public List<StoreNavigation> save(Iterable<StoreNavigation> entities) {
		List<StoreNavigation> list = new ArrayList<StoreNavigation>();
		for (StoreNavigation StoreNavigation : entities) {
			list.add(save(StoreNavigation));
		}
		return list;
	}

	public StoreNavigation save(StoreNavigation record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreNavigation record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreNavigationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreNavigationBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreNavigationExample example = new StoreNavigationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreNavigationBO> findAll(Iterable<Long> ids) {
		StoreNavigationExample example = new StoreNavigationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreNavigation entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreNavigation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreNavigation entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreNavigationExample example = new StoreNavigationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreNavigationExample example = new StoreNavigationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<StoreNavigationBO> findListByVo(MyPage<StoreNavigationBO> page, StoreNavigationVO vo) {
		return mapper.findListByVo(page, vo);
	}
}
