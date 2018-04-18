package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.shop.mapper.ShopQrServerInfoMapper;
import com.sinco.carnation.shop.model.ShopQrServerInfo;
import com.sinco.carnation.shop.bo.ShopQrServerInfoBO;
import com.sinco.carnation.shop.model.ShopQrServerInfoExample;

@Repository
public class ShopQrServerInfoDao {

	@Autowired
	private ShopQrServerInfoMapper mapper;

	/** generate code begin **/
	public List<ShopQrServerInfoBO> findAll() {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		return mapper.selectByExample(example);
	}

	List<ShopQrServerInfoBO> findAll(Iterable<Long> ids) {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		return mapper.countByExample(example);
	}

	public List<ShopQrServerInfo> save(Iterable<ShopQrServerInfo> entities) {
		List<ShopQrServerInfo> list = new ArrayList<ShopQrServerInfo>();
		for (ShopQrServerInfo ShopQrServerInfo : entities) {
			list.add(save(ShopQrServerInfo));
		}
		return list;
	}

	public ShopQrServerInfo save(ShopQrServerInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ShopQrServerInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ShopQrServerInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ShopQrServerInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ShopQrServerInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ShopQrServerInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ShopQrServerInfoExample example = new ShopQrServerInfoExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
