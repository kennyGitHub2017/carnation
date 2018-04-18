package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.mapper.StoreAdjustInfoMapper;
import com.sinco.carnation.store.model.StoreAdjustInfo;
import com.sinco.carnation.store.bo.StoreAdjustInfoBO;
import com.sinco.carnation.store.model.StoreAdjustInfoExample;
import com.sinco.carnation.store.vo.StoreAdjustInfoVO;

@Repository
public class StoreAdjustInfoDao {

	@Autowired
	private StoreAdjustInfoMapper mapper;

	/** generate code begin **/
	public List<StoreAdjustInfoBO> findAll() {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		return mapper.countByExample(example);
	}

	public List<StoreAdjustInfo> save(Iterable<StoreAdjustInfo> entities) {
		List<StoreAdjustInfo> list = new ArrayList<StoreAdjustInfo>();
		for (StoreAdjustInfo StoreAdjustInfo : entities) {
			list.add(save(StoreAdjustInfo));
		}
		return list;
	}

	public StoreAdjustInfo save(StoreAdjustInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreAdjustInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreAdjustInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreAdjustInfoBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreAdjustInfoBO> findAll(Iterable<Long> ids) {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreAdjustInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreAdjustInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreAdjustInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreAdjustInfoExample example = new StoreAdjustInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<StoreAdjustInfo> findListByVo(StoreAdjustInfoVO vo) {
		return mapper.findListByVo(vo);
	}
}
