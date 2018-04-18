package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.bo.ConsultingBO;
import com.sinco.carnation.sns.mapper.ConsultingMapper;
import com.sinco.carnation.sns.model.Consulting;
import com.sinco.carnation.sns.model.ConsultingExample;
import com.sinco.carnation.sns.vo.ConsultingVO;
import com.sinco.dal.common.MyPage;

@Repository
public class ConsultingDao {

	@Autowired
	private ConsultingMapper mapper;

	public ConsultingBO selectConsultingById(Long id) {
		return mapper.selectConsultingById(id);
	}

	public Consulting selectConsultingModelById(Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public List<ConsultingBO> selectConsultingPageByUserId(Long userId, MyPage<ConsultingBO> page) {
		return mapper.selectConsultingPageByUserId(userId, page);
	}

	/** generate code begin **/
	public List<Consulting> findAll() {
		ConsultingExample example = new ConsultingExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ConsultingExample example = new ConsultingExample();
		return mapper.countByExample(example);
	}

	public List<Consulting> save(Iterable<Consulting> entities) {
		List<Consulting> list = new ArrayList<Consulting>();
		for (Consulting Consulting : entities) {
			list.add(save(Consulting));
		}
		return list;
	}

	public Consulting save(Consulting record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Consulting record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Consulting findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Consulting get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ConsultingExample example = new ConsultingExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Consulting> findAll(Iterable<Long> ids) {
		ConsultingExample example = new ConsultingExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Consulting entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Consulting> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Consulting entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ConsultingExample example = new ConsultingExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ConsultingExample example = new ConsultingExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ConsultingBO> queryConsulListByExp(Long uid, ConsultingVO vo, MyPage<ConsultingBO> page) {
		return mapper.queryConsulListByExp(uid, vo, page);
	}

	public List<ConsultingBO> queryConsulList(ConsultingVO vo, MyPage<ConsultingBO> page) {
		return mapper.queryConsulList(vo, page);
	}

	public List<ConsultingBO> queryNotDoConsulListByExp(Long id) {
		return mapper.queryNotDoConsulListByExp(id);
	}

	public ConsultingBO queryConsulDetails(Long conId) {
		return mapper.queryConsulDetails(conId);

	}

	public void updateConsulting(Consulting consulting) {
		mapper.updateConsulting(consulting);
	}

	public List<ConsultingBO> queryConsultingByExpId(Long expId, String title, MyPage<ConsultingBO> page) {
		return mapper.queryConsultingByExpId(expId, title, page);
	}

}
