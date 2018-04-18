package com.sinco.carnation.o2o.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.o2o.bo.GroupEvaluationBO;
import com.sinco.carnation.o2o.mapper.GroupEvaluationMapper;
import com.sinco.carnation.o2o.model.GroupEvaluation;
import com.sinco.carnation.o2o.model.GroupEvaluationExample;
import com.sinco.carnation.o2o.vo.GroupEvaluationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class GroupEvaluationDao {

	@Autowired
	private GroupEvaluationMapper mapper;

	public long count(GroupEvaluationExample example) {
		return mapper.countByExample(example);
	}

	public List<GroupEvaluationBO> query(GroupEvaluationExample example) {
		return mapper.selectByExample(example);
	}

	/**
	 * 插入对象
	 * 
	 * @param evaluation
	 * @return
	 */
	public GroupEvaluation insert(GroupEvaluation evaluation) {
		if (mapper.insertSelective(evaluation) > 0)
			return evaluation;
		return null;
	}

	/**
	 * 
	 * 更新对象所有字段
	 * 
	 * @param evaluation
	 * @return
	 */
	public int update(GroupEvaluation evaluation) {
		if (null == evaluation.getUpdateTime()) {
			Date date = new Date();
			evaluation.setUpdateTime(date);
		}
		return mapper.updateByPrimaryKey(evaluation);
	}

	/**
	 * 更新对象不为null的字段
	 * 
	 * @param evaluation
	 * @return
	 */
	public int updateIgnoreNull(GroupEvaluation evaluation) {
		Date date = new Date();
		evaluation.setUpdateTime(date);
		return mapper.updateByPrimaryKeySelective(evaluation);
	}

	/** generate code begin **/
	public List<GroupEvaluationBO> findAll() {
		GroupEvaluationExample example = new GroupEvaluationExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		GroupEvaluationExample example = new GroupEvaluationExample();
		return mapper.countByExample(example);
	}

	public List<GroupEvaluation> save(Iterable<GroupEvaluation> entities) {
		List<GroupEvaluation> list = new ArrayList<GroupEvaluation>();
		for (GroupEvaluation GroupEvaluation : entities) {
			list.add(save(GroupEvaluation));
		}
		return list;
	}

	public GroupEvaluation save(GroupEvaluation record) {
		if (record.getOrderId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public GroupEvaluationBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public GroupEvaluationBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		GroupEvaluationExample example = new GroupEvaluationExample();
		example.createCriteria().andOrderIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<GroupEvaluationBO> findAll(Iterable<Long> ids) {
		GroupEvaluationExample example = new GroupEvaluationExample();
		example.createCriteria().andOrderIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(GroupEvaluation entity) {
		mapper.deleteByPrimaryKey(entity.getOrderId());
	}

	public void delete(Iterable<GroupEvaluation> entities) {
		List<Long> ids = Lists.newArrayList();
		for (GroupEvaluation entity : entities) {
			ids.add(entity.getOrderId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		GroupEvaluationExample example = new GroupEvaluationExample();
		example.createCriteria().andOrderIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		GroupEvaluationExample example = new GroupEvaluationExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<GroupEvaluationBO> query(GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page) {
		return mapper.query(vo, page);
	}

	public List<GroupEvaluationBO> queryByVO(GroupEvaluationVO vo, MyPage<GroupEvaluationBO> page) {
		return mapper.queryByVO(vo, page);
	}

	public GroupEvaluationBO fetchStoreTotal(Long storeId) {
		return mapper.fetchStoreTotal(storeId);
	}

	public List<GroupEvaluationBO> queryStoreByScores(Long storeId) {
		return mapper.queryStoreByScores(storeId);
	}

//	public GroupEvaluationBO queryStoreTotal(Long storeId){
//		List<GroupEvaluationBO> list = mapper.queryStoreTotal(storeId, null);
//		if (null==list ||list.size()==0) {
//			return null;
//		}
//		return list.get(0);
//	}

//	public List<GroupEvaluationBO> queryScoreTotal(Long storeId){
//		 return mapper.queryScoreTotal(storeId, null);
//	}

	public List<GroupEvaluationBO> queryByStoreName(String storeName, MyPage<GroupEvaluationBO> page) {
		return mapper.queryByStoreName(storeName, page);
	}
}
