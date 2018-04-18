package com.sinco.carnation.shop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.shop.mapper.ComplaintSubjectMapper;
import com.sinco.carnation.shop.model.ComplaintSubject;
import com.sinco.carnation.shop.bo.ComplaintSubjectBO;
import com.sinco.carnation.shop.model.ComplaintSubjectExample;
import com.sinco.dal.common.MyPage;

@Repository
public class ComplaintSubjectDao {

	@Autowired
	private ComplaintSubjectMapper mapper;

	/** generate code begin **/
	public List<ComplaintSubjectBO> findAll() {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		return mapper.countByExample(example);
	}

	public List<ComplaintSubject> save(Iterable<ComplaintSubject> entities) {
		List<ComplaintSubject> list = new ArrayList<ComplaintSubject>();
		for (ComplaintSubject ComplaintSubject : entities) {
			list.add(save(ComplaintSubject));
		}
		return list;
	}

	public ComplaintSubject save(ComplaintSubject record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public List<ComplaintSubjectBO> allSeller() {
		return mapper.allSeller();
	}

	public void update(ComplaintSubject record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public ComplaintSubjectBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public ComplaintSubjectBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<ComplaintSubjectBO> findAll(Iterable<Long> ids) {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(ComplaintSubject entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<ComplaintSubject> entities) {
		List<Long> ids = Lists.newArrayList();
		for (ComplaintSubject entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		ComplaintSubjectExample example = new ComplaintSubjectExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<ComplaintSubject> queryComplaintPageList(String type, MyPage<ComplaintSubject> page) {
		return mapper.queryComplaintPageList(type, page);
	}

	public int deleteComplaint(Long[] ids) {
		return mapper.deleteComplaint(ids);
	}

}
