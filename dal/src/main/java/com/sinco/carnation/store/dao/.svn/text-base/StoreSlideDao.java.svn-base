package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.mapper.StoreSlideMapper;
import com.sinco.carnation.store.model.StoreSlide;
import com.sinco.carnation.store.bo.StoreSlideBO;
import com.sinco.carnation.store.model.StoreSlideExample;
import com.sinco.carnation.store.vo.StoreSlideVO;

@Repository
public class StoreSlideDao {

	@Autowired
	private StoreSlideMapper mapper;

	/** generate code begin **/
	public List<StoreSlideBO> findAll() {
		StoreSlideExample example = new StoreSlideExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreSlideExample example = new StoreSlideExample();
		return mapper.countByExample(example);
	}

	public List<StoreSlide> save(Iterable<StoreSlide> entities) {
		List<StoreSlide> list = new ArrayList<StoreSlide>();
		for (StoreSlide StoreSlide : entities) {
			list.add(save(StoreSlide));
		}
		return list;
	}

	public StoreSlide save(StoreSlide record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreSlide record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreSlideBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreSlideBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreSlideExample example = new StoreSlideExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreSlideBO> findAll(Iterable<Long> ids) {
		StoreSlideExample example = new StoreSlideExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreSlide entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreSlide> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreSlide entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreSlideExample example = new StoreSlideExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreSlideExample example = new StoreSlideExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<StoreSlide> findListByVo(StoreSlideVO vo) {
		return mapper.findListByVo(vo);
	}
}
