package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import com.sinco.carnation.sys.vo.SysReminderTaskVO;
import com.sinco.dal.common.MyPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.sys.mapper.SysReminderTaskMapper;
import com.sinco.carnation.sys.model.SysReminderTask;
import com.sinco.carnation.sys.bo.SysReminderTaskBO;
import com.sinco.carnation.sys.model.SysReminderTaskExample;

@Repository
public class SysReminderTaskDao {

	@Autowired
	private SysReminderTaskMapper mapper;

	/** generate code begin **/
	public List<SysReminderTaskBO> findAll() {
		SysReminderTaskExample example = new SysReminderTaskExample();
		return mapper.selectByExample(example);
	}

	List<SysReminderTaskBO> findAll(Iterable<Long> ids) {
		SysReminderTaskExample example = new SysReminderTaskExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		SysReminderTaskExample example = new SysReminderTaskExample();
		return mapper.countByExample(example);
	}

	public List<SysReminderTask> save(Iterable<SysReminderTask> entities) {
		List<SysReminderTask> list = new ArrayList<SysReminderTask>();
		for (SysReminderTask SysReminderTask : entities) {
			list.add(save(SysReminderTask));
		}
		return list;
	}

	public SysReminderTask save(SysReminderTask record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(SysReminderTask record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SysReminderTaskBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SysReminderTaskExample example = new SysReminderTaskExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SysReminderTask entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SysReminderTask> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SysReminderTask entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SysReminderTaskExample example = new SysReminderTaskExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SysReminderTaskExample example = new SysReminderTaskExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<SysReminderTaskBO> findPageByVo(SysReminderTaskVO vo, MyPage<SysReminderTaskBO> page) {
		return mapper.findPageByVo(vo, page);
	}

	public List<SysReminderTaskBO> findAllByIds(List<Long> ids) {
		return this.findAll(ids);
	}

}
