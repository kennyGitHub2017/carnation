package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.mapper.StoreGroupAdjustMapper;
import com.sinco.carnation.o2o.model.StoreGroupAdjust;
import com.sinco.carnation.o2o.bo.StoreGroupAdjustBO;
import com.sinco.carnation.o2o.model.StoreGroupAdjustExample;
import com.sinco.carnation.o2o.vo.StoreGroupAdjustVO;
import com.sinco.dal.common.MyPage;

@Repository
public class StoreGroupAdjustDao {

	@Autowired
	private StoreGroupAdjustMapper mapper;

	/** generate code begin **/
	public List<StoreGroupAdjustBO> findAll() {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		return mapper.countByExample(example);
	}

	public List<StoreGroupAdjust> save(Iterable<StoreGroupAdjust> entities) {
		List<StoreGroupAdjust> list = new ArrayList<StoreGroupAdjust>();
		for (StoreGroupAdjust StoreGroupAdjust : entities) {
			list.add(save(StoreGroupAdjust));
		}
		return list;
	}

	public StoreGroupAdjust save(StoreGroupAdjust record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreGroupAdjust record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreGroupAdjustBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreGroupAdjustBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreGroupAdjustBO> findAll(Iterable<Long> ids) {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreGroupAdjust entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreGroupAdjust> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreGroupAdjust entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreGroupAdjustExample example = new StoreGroupAdjustExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<StoreGroupAdjust> findListByVo(StoreGroupAdjustVO vo) {
		return mapper.findListByVo(vo);
	}

	public List<StoreGroupAdjustBO> findPageByVo(StoreGroupAdjustVO vo, MyPage<StoreGroupAdjustBO> page) {
		return mapper.findPageByVo(vo, page);
	}
}
