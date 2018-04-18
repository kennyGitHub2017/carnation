package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.ConsultingRepayBO;
import com.sinco.carnation.sns.mapper.ConsultingRepayMapper;
import com.sinco.carnation.sns.model.ConsultingRepay;
import com.sinco.carnation.sns.model.ConsultingRepayExample;

@Repository
public class ConsultingRepayDao {

	@Autowired
	private ConsultingRepayMapper mapper;

	public List<ConsultingRepay> findByConsultingId(Long consultingId) {
		ConsultingRepayExample example = new ConsultingRepayExample();
		example.createCriteria().andConsultingIdEqualTo(consultingId).andIsDeletedEqualTo(false);
		example.setOrderByClause(" create_time desc");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<ConsultingRepay> findAll() {
		ConsultingRepayExample example = new ConsultingRepayExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ConsultingRepayExample example = new ConsultingRepayExample();
		return mapper.countByExample(example);
	}

	public List<ConsultingRepay> save(Iterable<ConsultingRepay> entities) {
		List<ConsultingRepay> list = new ArrayList<ConsultingRepay>();
		for (ConsultingRepay ConsultingRepay : entities) {
			list.add(save(ConsultingRepay));
		}
		return list;
	}

	public ConsultingRepay save(ConsultingRepay record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(ConsultingRepay record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ConsultingRepay findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ConsultingRepay get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ConsultingRepayExample example = new ConsultingRepayExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ConsultingRepay> findAll(Iterable<Long> ids) {
		ConsultingRepayExample example = new ConsultingRepayExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ConsultingRepay entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ConsultingRepay> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ConsultingRepay entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ConsultingRepayExample example = new ConsultingRepayExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ConsultingRepayExample example = new ConsultingRepayExample();
		mapper.deleteByExample(example);
	}

	public ConsultingRepay selectById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	/** generate code end **/

	public List<ConsultingRepayBO> consultReplyList(Long conId) {
		return mapper.consultReplyList(conId);
	}

	public int insert(ConsultingRepay repay) {
		return mapper.insert(repay);
	}
}
