package com.sinco.carnation.store.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.store.mapper.StoreGradeMapper;
import com.sinco.carnation.store.model.StoreGrade;
import com.sinco.carnation.store.bo.StoreGradeBO;
import com.sinco.carnation.store.model.StoreGradeExample;
import com.sinco.carnation.store.vo.StoreGradeVO;

@Repository
public class StoreGradeDao {

	@Autowired
	private StoreGradeMapper mapper;

	/** generate code begin **/
	public List<StoreGradeBO> findAll() {
		StoreGradeExample example = new StoreGradeExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		StoreGradeExample example = new StoreGradeExample();
		return mapper.countByExample(example);
	}

	public List<StoreGrade> save(Iterable<StoreGrade> entities) {
		List<StoreGrade> list = new ArrayList<StoreGrade>();
		for (StoreGrade StoreGrade : entities) {
			list.add(save(StoreGrade));
		}
		return list;
	}

	public StoreGrade save(StoreGrade record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(StoreGrade record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public StoreGradeBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public StoreGradeBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		StoreGradeExample example = new StoreGradeExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<StoreGradeBO> findAll(Iterable<Long> ids) {
		StoreGradeExample example = new StoreGradeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(StoreGrade entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<StoreGrade> entities) {
		List<Long> ids = Lists.newArrayList();
		for (StoreGrade entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		StoreGradeExample example = new StoreGradeExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		StoreGradeExample example = new StoreGradeExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<StoreGradeBO> findPageByVo(StoreGradeVO vo) {
		return this.mapper.findPageByVo(vo);
	}

	public List<StoreGradeBO> queryStoreGradePageList() {
		return mapper.queryStoreGradePageList();
	}

	public List<StoreGrade> findAllList() {
		return mapper.findAllList();
	}
}
