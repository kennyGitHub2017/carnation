package com.sinco.carnation.healthcircle.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.healthcircle.mapper.PostEvaluateMapper;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.bo.PostEvaluateBO;
import com.sinco.carnation.healthcircle.model.PostEvaluateExample;
import com.sinco.dal.common.MyPage;

@Repository
public class PostEvaluateDao {

	@Autowired
	private PostEvaluateMapper mapper;

	/** generate code begin **/
	public List<PostEvaluateBO> findAll() {
		PostEvaluateExample example = new PostEvaluateExample();
		return mapper.selectByExample(example);
	}

	List<PostEvaluateBO> findAll(Iterable<Long> ids) {
		PostEvaluateExample example = new PostEvaluateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PostEvaluateExample example = new PostEvaluateExample();
		return mapper.countByExample(example);
	}

	public List<PostEvaluate> save(Iterable<PostEvaluate> entities) {
		List<PostEvaluate> list = new ArrayList<PostEvaluate>();
		for (PostEvaluate PostEvaluate : entities) {
			list.add(save(PostEvaluate));
		}
		return list;
	}

	public PostEvaluate save(PostEvaluate record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PostEvaluate record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PostEvaluateBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PostEvaluateExample example = new PostEvaluateExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PostEvaluate entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PostEvaluate> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PostEvaluate entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PostEvaluateExample example = new PostEvaluateExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PostEvaluateExample example = new PostEvaluateExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public List<PostEvaluate> selectAllByPid(Long id) {
		List<PostEvaluate> list = mapper.selectAllByPid(id);
		return list;
	}

	public List<PostEvaluate> selectPageByPostId(MyPage<PostEvaluate> page, Long postId) {
		return mapper.selectPageByPostId(page, postId);
	}

	/** 查询未加分记录 **/
	public List<PostEvaluate> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
