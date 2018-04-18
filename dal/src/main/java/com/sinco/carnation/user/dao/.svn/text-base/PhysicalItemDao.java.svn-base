package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.model.CheckGroup;
import com.sinco.carnation.user.mapper.PhysicalItemMapper;
import com.sinco.carnation.user.model.PhysicalItem;
import com.sinco.carnation.user.bo.PhysicalItemBO;
import com.sinco.carnation.user.model.PhysicalItemExample;
import com.sinco.carnation.user.vo.PhysicalItemVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PhysicalItemDao {

	@Autowired
	private PhysicalItemMapper mapper;

	/** generate code begin **/
	public List<PhysicalItemBO> findAll() {
		PhysicalItemExample example = new PhysicalItemExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalItemExample example = new PhysicalItemExample();
		return mapper.countByExample(example);
	}

	public List<PhysicalItem> save(Iterable<PhysicalItem> entities) {
		List<PhysicalItem> list = new ArrayList<PhysicalItem>();
		for (PhysicalItem PhysicalItem : entities) {
			list.add(save(PhysicalItem));
		}
		return list;
	}

	public PhysicalItem save(PhysicalItem record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PhysicalItem record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalItemBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PhysicalItemBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalItemExample example = new PhysicalItemExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PhysicalItemBO> findAll(Iterable<Long> ids) {
		PhysicalItemExample example = new PhysicalItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalItem entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalItem> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalItem entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalItemExample example = new PhysicalItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalItemExample example = new PhysicalItemExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public CheckGroup selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PhysicalItemBO> findList(PhysicalItemVO vo, MyPage<PhysicalItemBO> page) {
		return mapper.selectListByVo(vo, page);
	}
}
