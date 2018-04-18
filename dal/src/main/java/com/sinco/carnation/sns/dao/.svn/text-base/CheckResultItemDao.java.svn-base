package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.CheckResultItemBO;
import com.sinco.carnation.sns.mapper.CheckResultItemMapper;
import com.sinco.carnation.sns.model.CheckResultItem;
import com.sinco.carnation.sns.model.CheckResultItemExample;
import com.sinco.carnation.sns.vo.CheckResultItemVO;
import com.sinco.dal.common.MyPage;

@Repository
public class CheckResultItemDao {

	@Autowired
	private CheckResultItemMapper mapper;

	/** generate code begin **/
	public List<CheckResultItemBO> findAll() {
		CheckResultItemExample example = new CheckResultItemExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		CheckResultItemExample example = new CheckResultItemExample();
		return mapper.countByExample(example);
	}

	public List<CheckResultItem> save(Iterable<CheckResultItem> entities) {
		List<CheckResultItem> list = new ArrayList<CheckResultItem>();
		for (CheckResultItem CheckResultItem : entities) {
			list.add(save(CheckResultItem));
		}
		return list;
	}

	public List<CheckResultItemBO> search(CheckResultItemVO vo, MyPage<CheckResultItemBO> page) {
		return mapper.search(vo, page);
	}

	public CheckResultItem save(CheckResultItem record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(CheckResultItem record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public CheckResultItemBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public CheckResultItemBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CheckResultItemExample example = new CheckResultItemExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<CheckResultItemBO> findAll(Iterable<Long> ids) {
		CheckResultItemExample example = new CheckResultItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(CheckResultItem entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<CheckResultItem> entities) {
		List<Long> ids = Lists.newArrayList();
		for (CheckResultItem entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CheckResultItemExample example = new CheckResultItemExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CheckResultItemExample example = new CheckResultItemExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<CheckResultItemBO> queryResultByGroupId(Long groupId) {
		return mapper.queryResultByGroupId(groupId);
	}

	public List<CheckResultItemBO> queryResultByUsing(Long usingId) {
		return mapper.queryResultByUsing(usingId);
	}

	public List<CheckResultItemBO> queryItemSearch(String name) {
		return mapper.queryItemSearch(name);
	}
}
