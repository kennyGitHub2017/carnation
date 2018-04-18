package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.bo.PayoffLogBO;
import com.sinco.carnation.store.mapper.PayoffLogMapper;
import com.sinco.carnation.store.model.PayoffLog;
import com.sinco.carnation.store.model.PayoffLogExample;
import com.sinco.carnation.store.model.PayoffLogExample.Criteria;
import com.sinco.carnation.store.vo.PayoffLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PayoffLogDao {

	@Autowired
	private PayoffLogMapper mapper;

	public int selectCountByStatus(Integer status) {
		PayoffLogExample example = new PayoffLogExample();
		example.createCriteria().andDeleteStatusEqualTo(false).andStatusEqualTo(status);
		return mapper.countByExample(example);
	}

	public Map<String, Object> selectPayoffLogStatByVO(PayoffLogVO vo) {
		return mapper.selectPayoffLogStatByVO(vo);
	}

	public List<PayoffLogBO> selectPayoffLogListByVO(MyPage<PayoffLogBO> page, PayoffLogVO vo) {
		return mapper.selectPayoffLogListByVO(page, vo);
	}

	public List<PayoffLogBO> selectShopPageListByVO(MyPage<PayoffLogBO> page, PayoffLogVO vo) {
		return mapper.selectShopPageListByVO(page, vo);
	}

	/**
	 * 系统处理最近结算日期
	 * 
	 * @param page
	 * @param vo
	 * @return
	 */
	public List<PayoffLogBO> selectPayoffLogNearest(Integer status, Date addTime) {
		return selectPayoffLogNearest(status, addTime, null);
	}

	public List<PayoffLogBO> selectPayoffLogNearest(Integer status, Date addTime, Long sellerId) {
		PayoffLogExample example = new PayoffLogExample();
		Criteria criteria = example.createCriteria().andStatusEqualTo(status);
		if (addTime != null) {
			criteria.andAddTimeLessThanOrEqualTo(addTime);
		}
		if (sellerId != null) {
			criteria.andSellerIdEqualTo(sellerId);
		}
		example.setOrderByClause(" add_time desc");
		return mapper.selectByExample(example);
	}

	public PayoffLogBO selectBOByVO(Long id) {
		return mapper.selectBOByVO(id);
	}

	public PayoffLogBO selectBOByOidAndOrderId(String oid, String orderId) {
		List<PayoffLogBO> list = mapper.selectBOByOidAndOrderId(oid, orderId);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<PayoffLogBO> findAll() {
		PayoffLogExample example = new PayoffLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PayoffLogExample example = new PayoffLogExample();
		return mapper.countByExample(example);
	}

	public List<PayoffLog> save(Iterable<PayoffLog> entities) {
		List<PayoffLog> list = new ArrayList<PayoffLog>();
		for (PayoffLog PayoffLog : entities) {
			list.add(save(PayoffLog));
		}
		return list;
	}

	public PayoffLog save(PayoffLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public int updateByOrderIdAndOid(PayoffLog record) {
		PayoffLogExample example = new PayoffLogExample();
		example.createCriteria().andOIdEqualTo(record.getoId()).andOrderIdEqualTo(record.getOrderId());
		return mapper.updateByExampleSelective(record, example);
	}

	public void update(PayoffLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PayoffLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PayoffLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PayoffLogExample example = new PayoffLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PayoffLogBO> findAll(Iterable<Long> ids) {
		PayoffLogExample example = new PayoffLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PayoffLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PayoffLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PayoffLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PayoffLogExample example = new PayoffLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PayoffLogExample example = new PayoffLogExample();
		mapper.deleteByExample(example);
	}
	/** generate code end **/
}
