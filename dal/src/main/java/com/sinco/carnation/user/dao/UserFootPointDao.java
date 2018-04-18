package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.mapper.UserFootPointMapper;
import com.sinco.carnation.user.model.UserFootPoint;
import com.sinco.carnation.user.model.UserFootPointExample;
import com.sinco.carnation.user.model.UserFootPointExample.Criteria;
import com.sinco.dal.common.MyPage;

@Repository
public class UserFootPointDao {

	@Autowired
	private UserFootPointMapper mapper;

	public List<UserFootPoint> findListByUserId(Long fpUserId, Date fpDate) {
		UserFootPointExample example = new UserFootPointExample();
		Criteria criteria = example.createCriteria().andFpUserIdEqualTo(fpUserId);
		if (fpDate != null) {
			criteria.andFpDateEqualTo(fpDate);
		} else {
			example.setOrderByClause("fp_date desc");
		}
		return mapper.selectByExampleWithBLOBs(example);
	}

	/** generate code begin **/
	public List<UserFootPoint> findAll() {
		UserFootPointExample example = new UserFootPointExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserFootPointExample example = new UserFootPointExample();
		return mapper.countByExample(example);
	}

	public List<UserFootPoint> save(Iterable<UserFootPoint> entities) {
		List<UserFootPoint> list = new ArrayList<UserFootPoint>();
		for (UserFootPoint UserFootPoint : entities) {
			list.add(save(UserFootPoint));
		}
		return list;
	}

	public UserFootPoint save(UserFootPoint record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserFootPoint record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserFootPoint findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserFootPoint get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserFootPointExample example = new UserFootPointExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserFootPoint> findAll(Iterable<Long> ids) {
		UserFootPointExample example = new UserFootPointExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserFootPoint entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserFootPoint> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserFootPoint entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserFootPointExample example = new UserFootPointExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserFootPointExample example = new UserFootPointExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<UserFootPoint> queryByUserId(Long userId, MyPage<UserFootPoint> page) {
		return mapper.queryByUserId(userId, page);
	}
}
