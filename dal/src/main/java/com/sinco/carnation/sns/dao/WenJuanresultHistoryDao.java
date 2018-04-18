package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.WenJuanresultHistoryBO;
import com.sinco.carnation.sns.mapper.WenJuanresultHistoryMapper;
import com.sinco.carnation.sns.model.WenJuanresultHistory;
import com.sinco.carnation.sns.model.WenJuanresultHistoryExample;

@Repository
public class WenJuanresultHistoryDao {

	@Autowired
	private WenJuanresultHistoryMapper mapper;

	/** generate code begin **/
	public List<WenJuanresultHistoryBO> findAll() {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		return mapper.selectByExample(example);
	}

	List<WenJuanresultHistoryBO> findAll(Iterable<Long> ids) {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		return mapper.countByExample(example);
	}

	public List<WenJuanresultHistory> save(Iterable<WenJuanresultHistory> entities) {
		List<WenJuanresultHistory> list = new ArrayList<WenJuanresultHistory>();
		for (WenJuanresultHistory WenJuanresultHistory : entities) {
			list.add(save(WenJuanresultHistory));
		}
		return list;
	}

	public WenJuanresultHistory save(WenJuanresultHistory record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(WenJuanresultHistory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public WenJuanresultHistoryBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(WenJuanresultHistory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<WenJuanresultHistory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (WenJuanresultHistory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		WenJuanresultHistoryExample example = new WenJuanresultHistoryExample();
		mapper.deleteByExample(example);
	}

	public WenJuanresultHistoryBO select_result_by_UserID(Long userID) {
		return this.mapper.select_result_by_UserID(userID);
	}

	public List<WenJuanresultHistoryBO> select_result_by_UserID(Long userID, long types) {
		return this.mapper.select_result_by_UserID2(userID, types);
	}

	public List<WenJuanresultHistoryBO> select_result_by_UserIDType(Long userID, long types) {
		return this.mapper.select_result_by_UserID2Type(userID, types);
	}

	public int update_result_deleted(Long id) {
		return this.mapper.update_result_deleted(id);
	}

	public int save_Result_History(WenJuanresultHistory history) {
		return this.mapper.insertSelective(history);
	}

	public int deleteResultHistoryByUserIDAndTypes(Long userID, Long type, Long resultID) {
		return this.mapper.delete_ResultHistory_By_UserIDAndTypes(userID, type, resultID);
	}

	public WenJuanresultHistoryBO selectJuanresultHistory(WenJuanresultHistory history) {
		return this.mapper.selectJuanresultHistory(history);
	}
	/** 根据type查询记录 日志类型：10：问卷，20：疾病   **/
	public List<WenJuanresultHistoryBO> listWenJuanHistoryByType(Long types){
		return this.mapper.listWenJuanHistoryByType(types);
	}
	
	/** 查询未加分记录 **/
	public List<WenJuanresultHistoryBO> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public int updateIsAddIntegralByid(Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
