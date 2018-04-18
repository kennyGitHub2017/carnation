package com.sinco.carnation.shop.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.bo.PredepositLogBO;
import com.sinco.carnation.shop.mapper.PredepositLogMapper;
import com.sinco.carnation.shop.model.PredepositLog;
import com.sinco.carnation.shop.model.PredepositLogExample;
import com.sinco.carnation.shop.vo.PredepositLogVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PredepositLogDao {

	@Autowired
	private PredepositLogMapper mapper;

	/**
	 * 根据用户分页查询
	 * 
	 * @param uid
	 * @param page
	 * @param userCode
	 *            0.个人 1.供应商 2.商户 3.运营商
	 * @return
	 */
	public List<PredepositLogBO> findPageByUid(Long uid, MyPage<PredepositLogBO> page, String userCode) {
		return mapper.findPageByUid(uid, page, userCode);
	}

	public List<PredepositLogBO> findByUid(Long uid) {
		return mapper.findByUid(uid);
	}
	
	
	
	/** generate code begin **/
	public List<PredepositLogBO> findAll() {
		PredepositLogExample example = new PredepositLogExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		PredepositLogExample example = new PredepositLogExample();
		return mapper.countByExample(example);
	}

	public List<PredepositLog> save(Iterable<PredepositLog> entities) {
		List<PredepositLog> list = new ArrayList<PredepositLog>();
		for (PredepositLog PredepositLog : entities) {
			list.add(save(PredepositLog));
		}
		return list;
	}

	public PredepositLog save(PredepositLog record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PredepositLog record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PredepositLogBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public PredepositLogBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PredepositLogExample example = new PredepositLogExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<PredepositLogBO> findAll(Iterable<Long> ids) {
		PredepositLogExample example = new PredepositLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public int delete(java.lang.Long id) {
		return mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PredepositLog entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PredepositLog> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PredepositLog entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PredepositLogExample example = new PredepositLogExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PredepositLogExample example = new PredepositLogExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<PredepositLogBO> queryByUserName(PredepositLogVO vo, MyPage<PredepositLogBO> page) {
		return mapper.queryByUserName(vo, page);
	}

	public BigDecimal queryGoodsProfitAmount(String pdType, Long sellerUid, Date startTime, Date endTime) {
		return mapper.queryGoodsProfitAmount(pdType, sellerUid, startTime, endTime);
	}

	/**
	 * @param userCode
	 *            0.个人 1.供应商 2.商户 3.运营商
	 **/
	public List<PredepositLogBO> queryPredeMonth(Long sellerUid, String opType, String userCode) {
		return mapper.queryPredeMonth(sellerUid, opType, userCode);
	}
	
	List<PredepositLogBO> listByUidAndCode(Long uid,String userCode){
		if(null == uid){
			return new ArrayList<PredepositLogBO>() ;
		}
		return mapper.listByUidAndCode(uid, userCode);
	}
}
