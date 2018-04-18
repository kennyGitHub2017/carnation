package com.sinco.carnation.sns.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sns.SNSConstants;
import com.sinco.carnation.sns.bo.InformationBO;
import com.sinco.carnation.sns.mapper.InformationMapper;
import com.sinco.carnation.sns.model.Information;
import com.sinco.carnation.sns.model.InformationExample;
import com.sinco.carnation.sns.vo.InformationVO;
import com.sinco.dal.common.MyPage;

@Repository
public class InformationDao {

	@Autowired
	private InformationMapper mapper;

	public List<InformationBO> selectByClassId(Long classId) {
		InformationExample example = new InformationExample();
		example.createCriteria().andClassidEqualTo(classId).andStatusEqualTo(SNSConstants.CHECK_STATUS_PASS)
				.andDeleteStatusEqualTo(0);
		example.setOrderByClause(" add_Time desc");
		return mapper.selectBOByExample(example);
	}

	public List<InformationBO> selectPageByClassId(Long classId, MyPage<InformationBO> page) {
		return mapper.selectPageByClassId(classId, page);
	}

	public List<Information> findAll() {
		InformationExample example = new InformationExample();
		return mapper.selectByExample(example);
	}

	public List<Information> save(Iterable<Information> entities) {
		List<Information> list = new ArrayList<Information>();
		for (Information Information : entities) {
			list.add(save(Information));
		}
		return list;
	}

	public Information save(Information record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Information record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Information findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Information get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		InformationExample example = new InformationExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Information> findAll(Iterable<Long> ids) {
		InformationExample example = new InformationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		InformationExample example = new InformationExample();
		return mapper.countByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Information entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Information> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Information entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		InformationExample example = new InformationExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		InformationExample example = new InformationExample();
		mapper.deleteByExample(example);
	}

	public int add(Information record) {
		return mapper.insertSelective(record);
	}

	public List<InformationBO> selectByList(InformationVO vo, MyPage<InformationBO> page) {
		return mapper.selectByList(vo, page);
	}

	public InformationBO selectById(Long id) {
		return mapper.selectById(id);
	}

	public List<InformationBO> queryByIds(Set<Long> set) {
		return mapper.queryByIds(set);
	}
}
