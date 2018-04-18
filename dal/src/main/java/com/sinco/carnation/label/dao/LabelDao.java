package com.sinco.carnation.label.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.label.bo.LabelBO;
import com.sinco.carnation.label.mapper.LabelMapper;
import com.sinco.carnation.label.model.Label;
import com.sinco.carnation.label.model.LabelExample;
import com.sinco.carnation.label.vo.LabelVO;
import com.sinco.dal.common.MyPage;

@Repository
public class LabelDao {

	@Autowired
	private LabelMapper mapper;

	/** generate code begin **/
	public List<LabelBO> findAll() {
		LabelExample example = new LabelExample();
		return mapper.selectByExample(example);
	}

	List<LabelBO> findAll(Iterable<Long> ids) {
		LabelExample example = new LabelExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		LabelExample example = new LabelExample();
		return mapper.countByExample(example);
	}

	public List<Label> save(Iterable<Label> entities) {
		List<Label> list = new ArrayList<Label>();
		for (Label Label : entities) {
			list.add(save(Label));
		}
		return list;
	}

	public Label save(Label record) {
		if (record.getId() == null) {
			mapper.insert(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Label record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public LabelBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		LabelExample example = new LabelExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Label entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Label> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Label entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		LabelExample example = new LabelExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		LabelExample example = new LabelExample();
		mapper.deleteByExample(example);
	}

	public List<Label> selectList(LabelVO labelvo) {
		// TODO Auto-generated method stub
		return mapper.selectList(labelvo);
	}

	public List<LabelBO> findByPage(MyPage<LabelBO> page, String name) {
		List<LabelBO> list = mapper.findByPage(page, name);
		page.setContent(list);
		return list;
	}

	public Label getObjById(long parseLong) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(parseLong);
	}

	public List<Label> getIdNameMap() {
		// TODO Auto-generated method stub
		return mapper.getIdNameMap();
	}
}
