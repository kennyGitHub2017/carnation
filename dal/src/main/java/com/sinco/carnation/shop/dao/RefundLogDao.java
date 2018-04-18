package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.RefundLogBO;
import com.sinco.carnation.shop.mapper.RefundLogMapper;
import com.sinco.carnation.shop.model.RefundLog;
import com.sinco.carnation.shop.model.RefundLogExample;
import com.sinco.carnation.shop.vo.RefundLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class RefundLogDao {

	@Autowired
	private RefundLogMapper mapper;

	/** generate code begin **/
	public List<RefundLogBO> findAll() {
		RefundLogExample example = new RefundLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		RefundLogExample example = new RefundLogExample();
		return mapper.countByExample(example);
	}

	public List<RefundLog> save(Iterable<RefundLog> entities) {
		List<RefundLog> list = new ArrayList<RefundLog>();
		for (RefundLog RefundLog : entities) {
			list.add(save(RefundLog));
		}
		return list;
	}

	@SuppressWarnings("rawtypes")
	public List<Map> search(RefundLogVO vo, MyPage<Map> page) {
		return mapper.search(vo, page);
	}

	public RefundLog save(RefundLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(RefundLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public RefundLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public RefundLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		RefundLogExample example = new RefundLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<RefundLogBO> findAll(Iterable<Long> ids) {
		RefundLogExample example = new RefundLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(RefundLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<RefundLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (RefundLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		RefundLogExample example = new RefundLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		RefundLogExample example = new RefundLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
