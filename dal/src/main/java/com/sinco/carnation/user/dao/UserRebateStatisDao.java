package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.mapper.UserRebateStatisMapper;
import com.sinco.carnation.user.model.UserRebateStatis;
import com.sinco.carnation.user.bo.UserRebateStatisBO;
import com.sinco.carnation.user.model.UserRebateStatisExample;
import com.sinco.carnation.user.vo.UserRebateStatisVO;

@Repository
public class UserRebateStatisDao {

	@Autowired
	private UserRebateStatisMapper mapper;

	/**
	 * 条件查询
	 * 
	 * @param uid
	 * @param bgTime
	 * @param edTime
	 * @return
	 */
	public List<UserRebateStatisBO> findByUidAndTime(Long uid, Date startTime, Date endTime) {
		return mapper.findByUidAndTime(uid, startTime, endTime);
	}

	// 根据时间查询
	public List<UserRebateStatisBO> findByDate(Date bgTime, Date edTime) {
		UserRebateStatisExample example = new UserRebateStatisExample();
		example.createCriteria().andCreateTimeBetween(bgTime, edTime);
		return mapper.selectByExample(example);
	}

	public UserRebateStatisBO getUserRebateStatisByTimeAndUid(UserRebateStatisVO vo) {
		if (vo == null) {
			return null;
		}
		return mapper.getUserRebateStatisByTimeAndUid(vo);
	}

	/**
	 * 精确查询统计记录
	 * 
	 * @param id
	 * @param time
	 * @param type
	 * @return
	 */
	public List<UserRebateStatisBO> findBy(Long id, Date time, String type) {
		UserRebateStatisExample example = new UserRebateStatisExample();
		example.createCriteria().andCreateTimeEqualTo(time).andIdEqualTo(id).andStatisTypeEqualTo(type);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<UserRebateStatisBO> findAll() {
		UserRebateStatisExample example = new UserRebateStatisExample();
		return mapper.selectByExample(example);
	}

	List<UserRebateStatisBO> findAll(Iterable<Long> ids) {
		UserRebateStatisExample example = new UserRebateStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		UserRebateStatisExample example = new UserRebateStatisExample();
		return mapper.countByExample(example);
	}

	public List<UserRebateStatis> save(Iterable<UserRebateStatis> entities) {
		List<UserRebateStatis> list = new ArrayList<UserRebateStatis>();
		for (UserRebateStatis UserRebateStatis : entities) {
			list.add(save(UserRebateStatis));
		}
		return list;
	}

	public UserRebateStatis save(UserRebateStatis record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserRebateStatis record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserRebateStatisBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserRebateStatisExample example = new UserRebateStatisExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserRebateStatis entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserRebateStatis> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserRebateStatis entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserRebateStatisExample example = new UserRebateStatisExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserRebateStatisExample example = new UserRebateStatisExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
