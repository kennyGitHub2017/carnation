package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.RebateTrackMapper;
import com.sinco.carnation.user.model.RebateTrack;
import com.sinco.carnation.user.bo.RebateTrackBO;
import com.sinco.carnation.user.model.RebateTrackExample;

@Repository
public class RebateTrackDao {

	@Autowired
	private RebateTrackMapper mapper;

	/** generate code begin **/
	public List<RebateTrackBO> findAll() {
		RebateTrackExample example = new RebateTrackExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RebateTrackExample example = new RebateTrackExample();
		return mapper.countByExample(example);
	}

	public List<RebateTrack> save(Iterable<RebateTrack> entities) {
		List<RebateTrack> list = new ArrayList<RebateTrack>();
		for (RebateTrack RebateTrack : entities) {
			list.add(save(RebateTrack));
		}
		return list;
	}

	public RebateTrack save(RebateTrack record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RebateTrack record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RebateTrackBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RebateTrackBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RebateTrackExample example = new RebateTrackExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RebateTrackBO> findAll(Iterable<Long> ids) {
		RebateTrackExample example = new RebateTrackExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RebateTrack entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RebateTrack> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RebateTrack entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RebateTrackExample example = new RebateTrackExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RebateTrackExample example = new RebateTrackExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
