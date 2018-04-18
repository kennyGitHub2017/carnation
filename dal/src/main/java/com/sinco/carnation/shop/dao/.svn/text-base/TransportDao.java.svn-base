package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.TransportBO;
import com.sinco.carnation.shop.mapper.TransportMapper;
import com.sinco.carnation.shop.model.Transport;
import com.sinco.carnation.shop.model.TransportExample;
import com.sinco.carnation.shop.vo.TransportVO;
import com.sinco.dal.common.MyPage;

@Repository
public class TransportDao {

	@Autowired
	private TransportMapper mapper;

	public List<TransportBO> findPageByType(MyPage<TransportBO> page, String type, Long storeId) {
		return mapper.findPageByType(page, type, storeId);
	}

	/** generate code begin **/
	public List<Transport> findAll() {
		TransportExample example = new TransportExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		TransportExample example = new TransportExample();
		return mapper.countByExample(example);
	}

	public List<Transport> save(Iterable<Transport> entities) {
		List<Transport> list = new ArrayList<Transport>();
		for (Transport Transport : entities) {
			list.add(save(Transport));
		}
		return list;
	}

	public Transport save(Transport record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Transport record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Transport findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Transport get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		TransportExample example = new TransportExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Transport> findAll(Iterable<Long> ids) {
		TransportExample example = new TransportExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Transport entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Transport> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Transport entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		TransportExample example = new TransportExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		TransportExample example = new TransportExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<TransportBO> findListByVo(TransportVO vo) {
		return this.mapper.selectByVo(vo);
	}
}
