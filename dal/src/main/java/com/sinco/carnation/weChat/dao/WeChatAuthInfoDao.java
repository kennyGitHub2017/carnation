package com.sinco.carnation.weChat.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.common.collect.Lists;

import com.sinco.carnation.weChat.mapper.WeChatAuthInfoMapper;
import com.sinco.carnation.weChat.model.WeChatAuthInfo;
import com.sinco.carnation.weChat.bo.WeChatAuthInfoBO;
import com.sinco.carnation.weChat.model.WeChatAuthInfoExample;

@Repository
public class WeChatAuthInfoDao {

	@Autowired
	private WeChatAuthInfoMapper mapper;

	/** generate code begin **/
	public List<WeChatAuthInfoBO> findAll() {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		return mapper.selectByExample(example);
	}

	List<WeChatAuthInfoBO> findAll(Iterable<Long> ids) {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		return mapper.countByExample(example);
	}

	public List<WeChatAuthInfo> save(Iterable<WeChatAuthInfo> entities) {
		List<WeChatAuthInfo> list = new ArrayList<WeChatAuthInfo>();
		for (WeChatAuthInfo WeChatAuthInfo : entities) {
			list.add(save(WeChatAuthInfo));
		}
		return list;
	}

	public WeChatAuthInfo save(WeChatAuthInfo record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WeChatAuthInfo record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WeChatAuthInfoBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WeChatAuthInfo entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WeChatAuthInfo> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WeChatAuthInfo entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WeChatAuthInfoExample example = new WeChatAuthInfoExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public WeChatAuthInfoBO findOneByOpenID(String openID) {
		return this.mapper.findOneByOpenID(openID);
	}

}
