package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.mapper.CircleMapper;
import com.sinco.carnation.sns.model.Circle;
import com.sinco.carnation.sns.model.CircleExample;
import com.sinco.carnation.sns.model.CircleExample.Criteria;
import com.sinco.carnation.sns.vo.CircleVO;
import com.sinco.common.utils.StringUtils;

@Repository
public class CircleDao {

	@Autowired
	private CircleMapper mapper;

	public List<Circle> findAll() {
		CircleExample example = new CircleExample();
		return mapper.selectByExample(example);
	}

	public List<Circle> save(Iterable<Circle> entities) {
		List<Circle> list = new ArrayList<Circle>();
		for (Circle Circle : entities) {
			list.add(save(Circle));
		}
		return list;
	}

	public Circle save(Circle record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Circle record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Circle findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Circle get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		CircleExample example = new CircleExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Circle> findAll(Iterable<Long> ids) {
		CircleExample example = new CircleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<Circle> findAllOrderByTimeDesc(CircleVO vo) {
		CircleExample example = new CircleExample();
		Criteria criteria = example.createCriteria().andDeleteStatusEqualTo(0);

		if (StringUtils.isNotBlank(vo.getTitle())) {
			criteria.andTitleLike("%" + CommUtil.null2String(vo.getTitle()) + "%");
		}

		example.setOrderByClause("add_time desc");
		return mapper.selectByExampleWithBLOBs(example);
	}

	public long count() {
		CircleExample example = new CircleExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Circle entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Circle> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Circle entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		CircleExample example = new CircleExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		CircleExample example = new CircleExample();
		mapper.deleteByExample(example);
	}

	public int updateById(Circle circle) {
		CircleExample example = new CircleExample();
		example.createCriteria().andIdEqualTo(circle.getId());
		return mapper.updateByExampleSelective(circle, example);
	}

	public Circle findById(Long circleId) {
		return mapper.selectByPrimaryKey(circleId);
	}

	public List<Circle> searchCircleList() {
		return mapper.searchCircleList();
	}

	public List<Circle> queryCircle(Long circleId) {
		CircleExample example = new CircleExample();
		example.createCriteria().andIdEqualTo(circleId);
		return mapper.selectByExampleWithBLOBs(example);
	}

	public List<Circle> findAllByIds(List<Long> relationIds) {
		return this.findAll(relationIds);
	}

}
