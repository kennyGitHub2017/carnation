package com.sinco.carnation.healthcircle.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.healthcircle.bo.PostPraiseBO;
import com.sinco.carnation.healthcircle.mapper.PostPraiseMapper;
import com.sinco.carnation.healthcircle.model.PostPraise;
import com.sinco.carnation.healthcircle.model.PostPraiseExample;

@Repository
public class PostPraiseDao {

	@Autowired
	private PostPraiseMapper mapper;

	/** generate code begin **/
	public List<PostPraiseBO> findAll() {
		PostPraiseExample example = new PostPraiseExample();
		return mapper.selectByExample(example);
	}

	List<PostPraiseBO> findAll(Iterable<Long> ids) {
		PostPraiseExample example = new PostPraiseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PostPraiseExample example = new PostPraiseExample();
		return mapper.countByExample(example);
	}

	public List<PostPraise> save(Iterable<PostPraise> entities) {
		List<PostPraise> list = new ArrayList<PostPraise>();
		for (PostPraise PostPraise : entities) {
			list.add(save(PostPraise));
		}
		return list;
	}

	public PostPraise save(PostPraise record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(PostPraise record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PostPraiseBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PostPraiseExample example = new PostPraiseExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(PostPraise entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<PostPraise> entities) {
		List<Long> ids = Lists.newArrayList();
		for (PostPraise entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PostPraiseExample example = new PostPraiseExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PostPraiseExample example = new PostPraiseExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public int saveByVo(PostPraise vo) {
		return mapper.insertByVo(vo);
	}

	public PostPraise selectByVo(PostPraise vo) {
		// TODO Auto-generated method stub
		return mapper.selectByVo(vo);
	}

	public int deleteByVo(PostPraise vo) {

		return mapper.deleteByVo(vo);
	}

	public List<PostPraise> selectByUserId(Long userId) {
		return mapper.selectByUserId(userId);
	}

	public List<String> selectUsernameByPostId(Long postId) {
		return mapper.selectUsernameByPostId(postId);
	}

	/** 查询未加分记录 **/
	public List<PostPraise> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
