package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.thinker.b2b2c.core.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.StoreApplyInfoBO;
import com.sinco.carnation.store.mapper.StoreApplyInfoMapper;
import com.sinco.carnation.store.model.StoreApplyInfo;
import com.sinco.carnation.store.model.StoreApplyInfoExample;
import com.sinco.carnation.store.vo.StoreApplyInfoVO;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class StoreApplyInfoDao {

	@Autowired
	private StoreApplyInfoMapper mapper;

	@Autowired
	private DicNameMappingHandle mappingHandle;

	/** generate code begin **/
	public List<StoreApplyInfoBO> findAll() {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		return mapper.countByExample(example);
	}

	public List<StoreApplyInfo> create(Iterable<StoreApplyInfo> entities) {
		List<StoreApplyInfo> list = new ArrayList<StoreApplyInfo>();
		for (StoreApplyInfo StoreApplyInfo : entities) {
			list.add(create(StoreApplyInfo));
		}
		return list;
	}

	public StoreApplyInfo create(StoreApplyInfo record) {
		mapper.insertSelective(record);
		return record;
	}

	public void update(StoreApplyInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public boolean update(StoreApplyInfoVO vo) {
		StoreApplyInfo info = null;
		if (vo != null) {
			info = new StoreApplyInfo();
			BeanUtils.copyProperties(vo, info);
		}
		this.mapper.updateByPrimaryKeySelective(info);
		return true;
	}

	public StoreApplyInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreApplyInfoBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		example.createCriteria().andStoreIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreApplyInfoBO> findAll(Iterable<Long> ids) {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		example.createCriteria().andStoreIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreApplyInfo entity) {
		mapper.deleteByPrimaryKey(entity.getStoreId());
	}

	public void delete(Iterable<StoreApplyInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreApplyInfo entity : entities) {
			ids.add(entity.getStoreId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		example.createCriteria().andStoreIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreApplyInfoExample example = new StoreApplyInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public StoreApplyInfoBO queryStoreApplyInfo(Long storeId) {
		return mapper.queryStoreApplyInfo(storeId);
	}
}
