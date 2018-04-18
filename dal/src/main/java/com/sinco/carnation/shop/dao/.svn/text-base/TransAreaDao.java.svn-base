package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.TransAreaMapper;
import com.sinco.carnation.shop.model.TransArea;
import com.sinco.carnation.shop.bo.TransAreaBO;
import com.sinco.carnation.shop.model.TransAreaExample;
import com.sinco.dal.common.MyPage;
import com.sinco.carnation.shop.model.TransAreaExample.Criteria;

@Repository
public class TransAreaDao {

	@Autowired
	private TransAreaMapper mapper;

	/* grey added begin */
	public List<TransAreaBO> findByParentId(Long parentId) {
		TransAreaExample example = new TransAreaExample();
		Criteria criteria = example.createCriteria();
		if (parentId == null) {
			criteria.andParentIdIsNull();
		} else {
			criteria.andParentIdEqualTo(parentId);
		}
		example.setOrderByClause(" sequence asc ");
		return mapper.selectByExample(example);
	}

	/* grey added end */

	/** generate code begin **/
	public List<TransAreaBO> findAll() {
		TransAreaExample example = new TransAreaExample();
		example.setOrderByClause(" sequence asc ");
		return mapper.selectByExample(example);
	}

	public long count() {
		TransAreaExample example = new TransAreaExample();
		return mapper.countByExample(example);
	}

	public List<TransArea> save(Iterable<TransArea> entities) {
		List<TransArea> list = new ArrayList<TransArea>();
		for (TransArea TransArea : entities) {
			list.add(save(TransArea));
		}
		return list;
	}

	public TransArea save(TransArea record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(TransArea record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public TransAreaBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public TransAreaBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		TransAreaExample example = new TransAreaExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<TransAreaBO> findAll(Iterable<Long> ids) {
		TransAreaExample example = new TransAreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(TransArea entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<TransArea> entities) {
		List<Long> ids = Lists.newArrayList();
		for (TransArea entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		TransAreaExample example = new TransAreaExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		TransAreaExample example = new TransAreaExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<TransArea> queryTransAreaList(Long pid, MyPage<TransArea> page) {
		return mapper.queryTransAreaList(pid, page);
	}
}
