package com.sinco.carnation.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.bo.PhysicalSuggestBO;
import com.sinco.carnation.user.mapper.PhysicalSuggestMapper;
import com.sinco.carnation.user.model.PhysicalSuggest;
import com.sinco.carnation.user.model.PhysicalSuggestExample;
import com.sinco.carnation.user.vo.PhysicalSuggestVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PhysicalSuggestDao {

	@Autowired
	private PhysicalSuggestMapper mapper;

	/** generate code begin **/
	public List<PhysicalSuggestBO> findAll() {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		return mapper.selectByExample(example);
	}

	List<PhysicalSuggestBO> findAll(Iterable<Long> ids) {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		return mapper.countByExample(example);
	}

	/*	public List<PhysicalSuggest> save(Iterable<PhysicalSuggest> entities){
			List<PhysicalSuggest> list=new ArrayList<PhysicalSuggest>();
			for (PhysicalSuggest PhysicalSuggest : entities) {
				list.add(save(PhysicalSuggest));
			}
			return list;
		}*/

	public PhysicalSuggest save(PhysicalSuggestVO record) {
		if (record.getId() == null) {
			int result = mapper.insert(record);
			record.setId(Long.valueOf(result));
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PhysicalSuggestVO record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PhysicalSuggestBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PhysicalSuggest entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PhysicalSuggest> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PhysicalSuggest entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PhysicalSuggestExample example = new PhysicalSuggestExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	/** 体检建议管理lkn **/

	public List<PhysicalSuggestBO> selectByVo(PhysicalSuggestVO vo, MyPage<PhysicalSuggestBO> page) {
		return this.mapper.selectListByVo(vo, page);
	}

	/**
	 * 根据体检测试结果值匹配对应的建议结果
	 * 
	 * @param suggestVO
	 * @return
	 */
	public List<PhysicalSuggestBO> queryPhysicalSuggestByCond(PhysicalSuggestVO suggestVO) {
		return this.mapper.queryPhysicalSuggestByCond(suggestVO);
	}

	/**
	 * 查找建议和任务结果
	 * 
	 * @param suggestVO
	 * @return
	 */
	/*
	public List<PhysicalSuggestBO> queryPhySuggestAndTaskByCond(
		PhysicalSuggestVO suggestVO) {
	return this.mapper.queryPhySuggestAndTaskByCond(suggestVO);
	}*/

	/***
	 * 添加
	 * 
	 * @param vo
	 * @return
	 */
	public int insertSuggest(PhysicalSuggestVO vo) {
		return this.mapper.insert(vo);

	}

}
