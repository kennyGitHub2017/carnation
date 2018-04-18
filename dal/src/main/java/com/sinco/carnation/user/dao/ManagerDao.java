package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.ManagerBO;
import com.sinco.carnation.user.mapper.ManagerMapper;
import com.sinco.carnation.user.model.Manager;
import com.sinco.carnation.user.model.ManagerExample;
import com.sinco.carnation.user.vo.ManagerVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ManagerDao {

	@Autowired
	private ManagerMapper mapper;

	/** generate code begin **/
	public List<Manager> findAll() {
		ManagerExample example = new ManagerExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ManagerExample example = new ManagerExample();
		return mapper.countByExample(example);
	}

	public List<Manager> save(Iterable<Manager> entities) {
		List<Manager> list = new ArrayList<Manager>();
		for (Manager Manager : entities) {
			list.add(save(Manager));
		}
		return list;
	}

	public Manager save(Manager record) {
		mapper.insertSelective(record);
		return record;
	}

	public void update(Manager record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ManagerBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Manager get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ManagerExample example = new ManagerExample();
		example.createCriteria().andUidEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Manager> findAll(Iterable<Long> ids) {
		ManagerExample example = new ManagerExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public List<ManagerBO> selectManagePageByVO(ManagerVO vo, MyPage<ManagerBO> page) {
		return mapper.selectManagePageByVO(vo, page);
	}

	public List<ManagerBO> selectManageByVO(ManagerVO vo) {
		return mapper.selectManagePageByVO(vo);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Manager entity) {
		mapper.deleteByPrimaryKey(entity.getUid());
	}

	public void delete(Iterable<Manager> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Manager entity : entities) {
			ids.add(entity.getUid());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ManagerExample example = new ManagerExample();
		example.createCriteria().andUidIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ManagerExample example = new ManagerExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<HashMap<String, Object>> getResultBySql(String sql) {
		return mapper.getResultBySql(sql);
	}
}
