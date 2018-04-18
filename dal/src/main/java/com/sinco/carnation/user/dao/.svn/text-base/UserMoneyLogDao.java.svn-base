package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinco.carnation.user.bo.UserMoneyLogBO;
import com.sinco.carnation.user.mapper.UserMoneyLogMapper;
import com.sinco.carnation.user.model.UserMoneyLog;
import com.sinco.carnation.user.model.UserMoneyLogExample;
import com.sinco.dal.common.MyPage;

@Repository
public class UserMoneyLogDao {

	@Autowired
	private UserMoneyLogMapper mapper;

	/** generate code begin **/
	public List<UserMoneyLogBO> findAll() {
		UserMoneyLogExample example = new UserMoneyLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserMoneyLogExample example = new UserMoneyLogExample();
		return mapper.countByExample(example);
	}

	public List<UserMoneyLog> save(Iterable<UserMoneyLog> entities) {
		List<UserMoneyLog> list = new ArrayList<UserMoneyLog>();
		for (UserMoneyLog UserMoneyLog : entities) {
			list.add(save(UserMoneyLog));
		}
		return list;
	}

	public UserMoneyLog save(UserMoneyLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserMoneyLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserMoneyLogBO findOne(java.lang.Integer id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Integer id) {
		UserMoneyLogExample example = new UserMoneyLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Integer id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(UserMoneyLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void deleteAll() {
		UserMoneyLogExample example = new UserMoneyLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<UserMoneyLogBO> findByUid(long uid, MyPage<UserMoneyLogBO> page) {
		return mapper.findByUid(uid, page);
	}
}
