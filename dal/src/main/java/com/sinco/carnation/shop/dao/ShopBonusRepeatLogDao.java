package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.ShopBonusRepeatLogBO;
import com.sinco.carnation.shop.mapper.ShopBonusRepeatLogMapper;
import com.sinco.carnation.shop.model.ShopBonusRepeatLog;
import com.sinco.carnation.shop.model.ShopBonusRepeatLogExample;
import com.sinco.carnation.shop.vo.ShopBonusRepeatLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ShopBonusRepeatLogDao {

	@Autowired
	private ShopBonusRepeatLogMapper mapper;

	/** generate code begin **/
	public List<ShopBonusRepeatLogBO> findAll() {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		return mapper.selectByExample(example);
	}

	List<ShopBonusRepeatLogBO> findAll(Iterable<Long> ids) {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		return mapper.countByExample(example);
	}

	public List<ShopBonusRepeatLog> save(Iterable<ShopBonusRepeatLog> entities) {
		List<ShopBonusRepeatLog> list = new ArrayList<ShopBonusRepeatLog>();
		for (ShopBonusRepeatLog ShopBonusRepeatLog : entities) {
			list.add(save(ShopBonusRepeatLog));
		}
		return list;
	}

	public ShopBonusRepeatLog save(ShopBonusRepeatLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ShopBonusRepeatLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ShopBonusRepeatLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ShopBonusRepeatLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ShopBonusRepeatLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ShopBonusRepeatLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ShopBonusRepeatLogExample example = new ShopBonusRepeatLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public ShopBonusRepeatLog getByVo(ShopBonusRepeatLog vo) {
		return this.mapper.getByVo(vo);
	}

	public List<ShopBonusRepeatLogBO> getPageRepeatByVo(ShopBonusRepeatLogVO vo,
			MyPage<ShopBonusRepeatLogBO> page) {
		return this.mapper.getByVo(vo, page);
	}

}
