package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.ShipAddressMapper;
import com.sinco.carnation.shop.model.ShipAddress;
import com.sinco.carnation.shop.bo.ShipAddressBO;
import com.sinco.carnation.shop.model.ShipAddressExample;
import com.sinco.carnation.shop.vo.ShipAddressVO;
import com.sinco.dal.common.MyPage;
import com.sinco.dic.client.DicNameMappingHandle;

@Repository
public class ShipAddressDao {

	@Autowired
	private ShipAddressMapper mapper;

	@Autowired
	private DicNameMappingHandle mappingHandle;

	/** generate code begin **/
	public List<ShipAddressBO> findAll() {
		ShipAddressExample example = new ShipAddressExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ShipAddressExample example = new ShipAddressExample();
		return mapper.countByExample(example);
	}

	public List<ShipAddress> save(Iterable<ShipAddress> entities) {
		List<ShipAddress> list = new ArrayList<ShipAddress>();
		for (ShipAddress ShipAddress : entities) {
			list.add(save(ShipAddress));
		}
		return list;
	}

	public ShipAddress save(ShipAddress record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ShipAddress record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ShipAddressBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ShipAddressBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ShipAddressBO findBO(java.lang.Long id) {

		ShipAddressBO bo = mapper.selectByPrimaryKey(id);
		mappingHandle.mappinHandle(bo);
		return bo;
	}

	public boolean exists(java.lang.Long id) {
		ShipAddressExample example = new ShipAddressExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ShipAddressBO> findAll(Iterable<Long> ids) {
		ShipAddressExample example = new ShipAddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ShipAddress entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ShipAddress> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ShipAddress entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ShipAddressExample example = new ShipAddressExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ShipAddressExample example = new ShipAddressExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ShipAddressBO> queryShipAddress(Integer saType, MyPage<ShipAddressBO> page) {
		return mapper.queryShipAddress(saType, page);
	}

	public ShipAddressBO queryShipAddressById(Long id) {
		return mapper.queryShipAddressById(id);
	}

	public List<ShipAddress> findAllBySaType(Integer saType) {
		return mapper.selectBySaType(saType);
	}

	public List<ShipAddressBO> findAllByCondition(Integer saType, Long saUserId, Boolean saDefault) {
		return mapper.findAllByCondition(saType, saUserId, saDefault);
	}

	public List<ShipAddressBO> findPageByVo(MyPage<ShipAddressBO> page, ShipAddressVO vo) {
		return mapper.findPageByVo(page, vo);
	}
}
