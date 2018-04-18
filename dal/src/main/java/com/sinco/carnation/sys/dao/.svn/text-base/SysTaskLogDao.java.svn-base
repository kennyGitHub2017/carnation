package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.mapper.SysTaskLogMapper;
import com.sinco.carnation.sys.model.SysTaskLog;
import com.sinco.carnation.sys.bo.SysTaskLogBO;
import com.sinco.carnation.sys.model.SysTaskLogExample;
import com.sinco.carnation.sys.vo.SysTaskLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class SysTaskLogDao {

	@Autowired
	private SysTaskLogMapper mapper;

	/** generate code begin **/
	public List<SysTaskLogBO> findAll() {
		SysTaskLogExample example = new SysTaskLogExample();
		return mapper.selectByExample(example);
	}

	List<SysTaskLogBO> findAll(Iterable<Long> ids) {
		SysTaskLogExample example = new SysTaskLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		SysTaskLogExample example = new SysTaskLogExample();
		return mapper.countByExample(example);
	}

	public List<SysTaskLog> save(Iterable<SysTaskLog> entities) {
		List<SysTaskLog> list = new ArrayList<SysTaskLog>();
		for (SysTaskLog SysTaskLog : entities) {
			list.add(save(SysTaskLog));
		}
		return list;
	}

	public SysTaskLog save(SysTaskLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(SysTaskLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public SysTaskLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		SysTaskLogExample example = new SysTaskLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(SysTaskLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<SysTaskLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (SysTaskLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		SysTaskLogExample example = new SysTaskLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		SysTaskLogExample example = new SysTaskLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<SysTaskLogBO> selectByVO(SysTaskLogVO vo, MyPage<SysTaskLogBO> page) {
		return mapper.selectByVO(vo, page);
	}

	/***
	 * 添加任务
	 * 
	 * @param vo
	 * @return
	 */
	public int insertTaskLog(SysTaskLogVO vo) {
		return this.mapper.insertTaskLog(vo);
	}

}
