package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.PredepositBO;
import com.sinco.carnation.shop.mapper.PredepositMapper;
import com.sinco.carnation.shop.model.Predeposit;
import com.sinco.carnation.shop.model.PredepositExample;
import com.sinco.dal.common.MyPage;

@Repository
public class PredepositDao {

	@Autowired
	private PredepositMapper mapper;

	/**
	 * 
	 * @param id
	 * @return
	 */
	public PredepositBO findBOById(Long id) {
		return mapper.findBOById(id);
	}

	/**
	 * 根据流水号查询
	 * 
	 * @param id
	 * @return
	 */
	public PredepositBO findByPdSn(String pdSn) {
		PredepositExample example = new PredepositExample();
		example.createCriteria().andPdSnEqualTo(pdSn);
		List<PredepositBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	public MyPage<PredepositBO> findPageByUid(Long uid, MyPage<PredepositBO> page) {
		mapper.findPageByUid(uid, page);
		return page;
	}

	/** generate code begin **/
	public List<PredepositBO> findAll() {
		PredepositExample example = new PredepositExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PredepositExample example = new PredepositExample();
		return mapper.countByExample(example);
	}

	public List<Predeposit> save(Iterable<Predeposit> entities) {
		List<Predeposit> list = new ArrayList<Predeposit>();
		for (Predeposit Predeposit : entities) {
			list.add(save(Predeposit));
		}
		return list;
	}

	public Predeposit save(Predeposit record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Predeposit record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PredepositBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PredepositBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PredepositExample example = new PredepositExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PredepositBO> findAll(Iterable<Long> ids) {
		PredepositExample example = new PredepositExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Predeposit entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Predeposit> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Predeposit entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PredepositExample example = new PredepositExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PredepositExample example = new PredepositExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<PredepositBO> queryPredepositPageList(String pdPayment, String pdPayStatus, String pdStatus,
			String pdRemittanceUser, String pdRemittanceBank, String pdUserName, String beginTime,
			String endTime, String pdSn, MyPage<PredepositBO> page) {
		return mapper.queryPredepositPageList(pdPayment, pdPayStatus, pdStatus, pdRemittanceUser,
				pdRemittanceBank, pdUserName, beginTime, endTime, pdSn, page);
	}
}
