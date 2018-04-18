package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.WenJuanGroupBO;
import com.sinco.carnation.sns.mapper.WenJuanGroupMapper;
import com.sinco.carnation.sns.model.WenJuanGroup;
import com.sinco.carnation.sns.model.WenJuanGroupExample;
import com.sinco.carnation.sns.vo.WenJuanGroupVO;
import com.sinco.dal.common.MyPage;

@Repository
public class WenJuanGroupDao {

	@Autowired
	private WenJuanGroupMapper mapper;

	/** generate code begin **/
	public List<WenJuanGroupBO> findAll() {
		WenJuanGroupExample example = new WenJuanGroupExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanGroupBO> findAll(Iterable<Long> ids) {
		WenJuanGroupExample example = new WenJuanGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanGroupExample example = new WenJuanGroupExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanGroup> save(Iterable<WenJuanGroup> entities) {
		List<WenJuanGroup> list = new ArrayList<WenJuanGroup>();
		for (WenJuanGroup WenJuanGroup : entities) {
			list.add(save(WenJuanGroup));
		}
		return list;
	}

	public WenJuanGroup save(WenJuanGroup record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanGroup record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanGroupBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanGroupExample example = new WenJuanGroupExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanGroup entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanGroup> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanGroup entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanGroupExample example = new WenJuanGroupExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanGroupExample example = new WenJuanGroupExample();
		mapper.deleteByExample(example);
	}

	public List<WenJuanGroupBO> getWenJuanGroupAll(WenJuanGroup obj) {
		return this.mapper.getWenJuanGroupAll(obj);
	}

	public List<WenJuanGroupBO> findByPage(MyPage<WenJuanGroupVO> page, WenJuanGroupVO vo) {
		return this.mapper.findByPage(page, vo);
	}

	public int updateWenJuanByID(WenJuanGroupVO vo) {
		return this.mapper.updateByID(vo);
	}
}
