package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.AddressBO;
import com.sinco.carnation.user.mapper.AddressMapper;
import com.sinco.carnation.user.model.Address;
import com.sinco.carnation.user.model.AddressExample;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class AddressDao {

	@Autowired
	private AddressMapper mapper;

	@Autowired
	private DicNameMappingHandle mappingHandle;

	public AddressBO get(java.lang.Long id) {
		AddressBO bo = mapper.selectByPrimaryKey(id);
		mappingHandle.mappinHandle(bo);
		return bo;
	}

	public int countByUid(Long uid) {
		AddressExample example = new AddressExample();
		example.createCriteria().andUserIdEqualTo(uid);
		return mapper.countByExample(example);
	}

	/**
	 * 根据用户id查找商城列表
	 * 
	 * @param uid
	 * @return
	 */
	public List<AddressBO> findShopByUid(Long uid) {
		AddressExample example = new AddressExample();
		example.createCriteria().andUserIdEqualTo(uid);
		example.setOrderByClause(" default_val desc,add_time desc");
		List<AddressBO> list = mapper.selectByExample(example);
		mappingHandle.mappinHandle(list);
		return list;
	}

	/** generate code begin **/
	public List<AddressBO> findAll() {
		AddressExample example = new AddressExample();
		return mapper.selectByExample(example);
	}

	@SuppressWarnings("rawtypes")
	public List<Map> selectByTop100(int userId) {
		return mapper.selectByTop100(userId);
	}

	public List<AddressBO> selectByUser(Long userId) {
		AddressExample example = new AddressExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<AddressBO> list = mapper.selectByExample(example);
		mappingHandle.mappinHandle(list);

		return list;
	}

	public long count() {
		AddressExample example = new AddressExample();
		return mapper.countByExample(example);
	}

	public List<Address> save(Iterable<Address> entities) {
		List<Address> list = new ArrayList<Address>();
		for (Address Address : entities) {
			list.add(save(Address));
		}
		return list;
	}

	public Address save(Address record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Address record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public void update(Address record, Long id, Long uid) {
		AddressExample example = new AddressExample();
		example.createCriteria().andIdEqualTo(id).andUserIdEqualTo(uid);
		mapper.updateByExampleSelective(record, example);
	}

	public void updateByUid(Address record, Long uid) {
		AddressExample example = new AddressExample();
		example.createCriteria().andUserIdEqualTo(uid);
		mapper.updateByExampleSelective(record, example);
	}

	public AddressBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Address fetch(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AddressExample example = new AddressExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<AddressBO> findAll(Iterable<Long> ids) {
		AddressExample example = new AddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Address entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Address> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Address entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AddressExample example = new AddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AddressExample example = new AddressExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public Address getDefaultByUserId(Long userId) {
		return mapper.getDefaultByUserId(userId);
	}

	public List<Address> queryByUserId(Long userId) {
		return mapper.queryByUserId(userId);
	}
}
