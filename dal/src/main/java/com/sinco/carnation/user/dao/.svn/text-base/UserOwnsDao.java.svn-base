package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.user.mapper.UserOwnsMapper;
import com.sinco.carnation.user.model.UserOwns;
import com.sinco.carnation.user.bo.UserOwnsBO;
import com.sinco.carnation.user.model.UserOwnsExample;

@Repository
public class UserOwnsDao {

	@Autowired
	private UserOwnsMapper mapper;

	/** generate code begin **/
	public List<UserOwnsBO> findAll() {
		UserOwnsExample example = new UserOwnsExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserOwnsExample example = new UserOwnsExample();
		return mapper.countByExample(example);
	}

	public List<UserOwns> save(Iterable<UserOwns> entities) {
		List<UserOwns> list = new ArrayList<UserOwns>();
		for (UserOwns UserOwns : entities) {
			list.add(save(UserOwns));
		}
		return list;
	}

	public UserOwns insert(UserOwns record) {
		mapper.insertSelective(record);
		return record;
	}

	public UserOwns save(UserOwns record) {
		if (record.getSellerUserId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserOwns record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserOwnsBO findOne(java.lang.Long id,Integer ownType) {
		return mapper.selectByPrimaryKey(id,ownType);
	}

	public UserOwnsBO selectBOBySellerId(java.lang.Long id, Integer ownType) {
		return mapper.selectBOBySellerId(id,ownType);
	}

	public UserOwnsBO get(java.lang.Long id, Integer ownType) {
		return mapper.selectByPrimaryKey(id,ownType);
	}

	public boolean exists(java.lang.Long id) {
		UserOwnsExample example = new UserOwnsExample();
		example.createCriteria().andSellerUserIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserOwnsBO> findAll(Iterable<Long> ids) {
		UserOwnsExample example = new UserOwnsExample();
		example.createCriteria().andSellerUserIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id,Integer ownType) {
		mapper.deleteByPrimaryKey(id,ownType);
	}

	public void remove(java.lang.Long id,Integer ownType) {
		mapper.deleteByPrimaryKey(id, ownType);
	}

	public void delete(UserOwns entity) {
		mapper.deleteByPrimaryKey(entity.getSellerUserId(),entity.getOwnType());
	}

	public void delete(Iterable<UserOwns> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserOwns entity : entities) {
			ids.add(entity.getSellerUserId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserOwnsExample example = new UserOwnsExample();
		example.createCriteria().andSellerUserIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserOwnsExample example = new UserOwnsExample();
		mapper.deleteByExample(example);
	}

	public List<UserOwnsBO> findAllSellerByOperId(Long operId) {
		return mapper.findAllSellerByOperId(operId);
	}

	public List<UserOwnsBO> findAllSellerNotBySellerUID(Long operId, Long sellerUID) {
		return mapper.findAllSellerNotBySellerUID(operId, sellerUID);
	}

	/** generate code end **/
}
