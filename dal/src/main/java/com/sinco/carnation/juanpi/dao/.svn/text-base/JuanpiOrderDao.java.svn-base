package com.sinco.carnation.juanpi.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.juanpi.bo.JuanpiOrderBO;
import com.sinco.carnation.juanpi.mapper.JuanpiOrderMapper;
import com.sinco.carnation.juanpi.model.JuanpiOrder;
import com.sinco.carnation.juanpi.model.JuanpiOrderExample;
import com.sinco.carnation.juanpi.vo.JuanpiOrderVO;
import com.sinco.dal.common.MyPage;

@Repository
public class JuanpiOrderDao {

	@Autowired
	private JuanpiOrderMapper mapper;

	/** generate code begin **/
	public List<JuanpiOrderBO> findAll() {
		JuanpiOrderExample example = new JuanpiOrderExample();
		return mapper.selectByExample(example);
	}

	List<JuanpiOrderBO> findAll(Iterable<Long> ids) {
		JuanpiOrderExample example = new JuanpiOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		JuanpiOrderExample example = new JuanpiOrderExample();
		return mapper.countByExample(example);
	}

	public List<JuanpiOrder> save(Iterable<JuanpiOrder> entities) {
		List<JuanpiOrder> list = new ArrayList<JuanpiOrder>();
		for (JuanpiOrder JuanpiOrder : entities) {
			list.add(save(JuanpiOrder));
		}
		return list;
	}

	public JuanpiOrder save(JuanpiOrder record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(JuanpiOrder record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public JuanpiOrderBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		JuanpiOrderExample example = new JuanpiOrderExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(JuanpiOrder entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<JuanpiOrder> entities) {
		List<Long> ids = Lists.newArrayList();
		for (JuanpiOrder entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		JuanpiOrderExample example = new JuanpiOrderExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		JuanpiOrderExample example = new JuanpiOrderExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<JuanpiOrderBO> selectOrderListByVO(JuanpiOrderVO vo, MyPage<JuanpiOrderBO> page) {
		return mapper.selectOrderListByVO(vo, page);
	}

	public JuanpiOrderBO getByOrderNo(String orderno) {
		JuanpiOrderExample example = new JuanpiOrderExample();
		example.createCriteria().andOrdernoEqualTo(orderno);
		List<JuanpiOrderBO> orders = mapper.selectByExample(example);
		if (orders != null && orders.size() > 0) {
			return orders.get(0);
		}
		return null;
	}

	public List<String> findUnsynOrderGroupByDate() {
		return mapper.findUnsynOrderGroupByDate();
	}

	public List<JuanpiOrderBO> selectRebateByJuanPiOrderStatus() {
		return mapper.selectRebateByJuanPiOrderStatus();
	}

	public JuanpiOrder selectFindById(long id) {
		return mapper.selectFindById(id);
	}
}
