package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.mapper.DocumentMapper;
import com.sinco.carnation.sys.model.Document;
import com.sinco.carnation.sys.bo.DocumentBO;
import com.sinco.carnation.sys.model.DocumentExample;
import com.sinco.dal.common.MyPage;

@Repository
public class DocumentDao {

	@Autowired
	private DocumentMapper mapper;

	public DocumentBO findByMark(String mark) {
		DocumentExample example = new DocumentExample();
		example.createCriteria().andMarkEqualTo(mark);
		List<DocumentBO> list = mapper.selectByExampleWithBLOBs(example);
		return list.size() > 0 ? list.get(0) : null;
	}

	/** generate code begin **/
	public List<DocumentBO> findAll() {
		DocumentExample example = new DocumentExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		DocumentExample example = new DocumentExample();
		return mapper.countByExample(example);
	}

	public List<Document> save(Iterable<Document> entities) {
		List<Document> list = new ArrayList<Document>();
		for (Document Document : entities) {
			list.add(save(Document));
		}
		return list;
	}

	public Document save(Document record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Document record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public DocumentBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public DocumentBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		DocumentExample example = new DocumentExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<DocumentBO> findAll(Iterable<Long> ids) {
		DocumentExample example = new DocumentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Document entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Document> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Document entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		DocumentExample example = new DocumentExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		DocumentExample example = new DocumentExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<DocumentBO> queryDocumetAllList(MyPage<DocumentBO> page) {
		return mapper.queryDocumetAllList(page);
	}
}
