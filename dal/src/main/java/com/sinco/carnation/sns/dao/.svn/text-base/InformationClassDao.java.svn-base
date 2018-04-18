package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.InformationClassBO;
import com.sinco.carnation.sns.mapper.InformationClassMapper;
import com.sinco.carnation.sns.model.InformationClass;
import com.sinco.carnation.sns.model.InformationClassExample;
import com.sinco.carnation.sns.vo.InformationClassVO;
import com.sinco.dal.common.MyPage;

@Repository
public class InformationClassDao {

	@Autowired
	private InformationClassMapper mapper;

	public List<InformationClassBO> findInformationClassByParentId(Long parentId) {
		InformationClassExample example = new InformationClassExample();
		example.createCriteria().andIcPidEqualTo(parentId).andDeleteStatusEqualTo(0);
		example.setOrderByClause(" ic_sequence asc");
		return mapper.selectBOByExample(example);
	}

	public List<InformationClass> findAll() {
		InformationClassExample example = new InformationClassExample();
		return mapper.selectByExample(example);
	}

	public List<InformationClass> save(Iterable<InformationClass> entities) {
		List<InformationClass> list = new ArrayList<InformationClass>();
		for (InformationClass InformationClass : entities) {
			list.add(save(InformationClass));
		}
		return list;
	}

	public InformationClass save(InformationClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(InformationClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public InformationClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public InformationClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		InformationClassExample example = new InformationClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<InformationClass> findAll(Iterable<Long> ids) {
		InformationClassExample example = new InformationClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		InformationClassExample example = new InformationClassExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(InformationClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<InformationClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (InformationClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		InformationClassExample example = new InformationClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		InformationClassExample example = new InformationClassExample();
		mapper.deleteByExample(example);
	}

	public List<InformationClass> queryChildClass(Long id) {
		InformationClassExample example = new InformationClassExample();
		example.createCriteria().andIcPidEqualTo(id);
		return mapper.selectByExample(example);

	}

	public List<InformationClassBO> selectAll() {
		return mapper.selectAll();
	}

	public List<InformationClassBO> findPageByVO(MyPage<InformationClassBO> page, InformationClassVO vo) {
		return this.mapper.findPageByVO(page, vo);
	}

	public List<InformationClassBO> findAllChild(Long... ids) {
		List<InformationClassBO> list = findByParent(ids);

		if (list != null && list.size() > 0) {
			Long[] parents = new Long[list.size()];
			for (int i = 0; i < list.size(); i++) {
				parents[i] = list.get(i).getId();
			}
			list.addAll(findAllChild(parents));
		}
		return list;
	}

	private List<InformationClassBO> findByParent(Long... ids) {
		InformationClassExample ex = new InformationClassExample();
		ex.createCriteria().andDeleteStatusEqualTo(0).andIcPidIn(Lists.newArrayList(ids));
		return this.mapper.selectBOByExample(ex);
	}

	public void updateDeleteStatusByIds(List<Long> childIds) {
		this.mapper.updateDeleteStatusByIds(childIds);
	}

	public List<InformationClassBO> selectInfomationClassList(Long parentId) {
		return mapper.selectInfomationClassList(parentId);
	}
}
