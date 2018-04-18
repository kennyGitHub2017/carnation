package com.sinco.carnation.healthcircle.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.sinco.carnation.healthcircle.bo.PostBO;
import com.sinco.carnation.healthcircle.mapper.PostMapper;
import com.sinco.carnation.healthcircle.model.Post;
import com.sinco.carnation.healthcircle.model.PostEvaluate;
import com.sinco.carnation.healthcircle.model.PostExample;
import com.sinco.carnation.healthcircle.vo.PostSelectVO;
import com.sinco.carnation.healthcircle.vo.PostVO;
import com.sinco.carnation.healthcircle.vo.SelectPriseCenterVO;
import com.sinco.dal.common.MyPage;

@Repository
public class PostDao {

	@Autowired
	private PostMapper mapper;

	/** generate code begin **/
	public List<PostBO> findAll() {
		PostExample example = new PostExample();
		return mapper.selectByExample(example);
	}

	List<PostBO> findAll(Iterable<Long> ids) {
		PostExample example = new PostExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public long count() {
		PostExample example = new PostExample();
		return mapper.countByExample(example);
	}

	public List<Post> save(Iterable<Post> entities) {
		List<Post> list = new ArrayList<Post>();
		for (Post Post : entities) {
			list.add(save(Post));
		}
		return list;
	}

	public Post save(Post record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Post record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public PostBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		PostExample example = new PostExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Post entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Post> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Post entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		PostExample example = new PostExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		PostExample example = new PostExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	public List<Post> findPageByVo(MyPage<Post> page, PostVO vo) {
		List<Post> list = mapper.findPageByVo(page, vo);
		if (list != null && list.size() > 0) {
			/*List<Long> postIds = new ArrayList<Long>();
			for(Post ll : list){
				postIds.add(ll.getId());
				ll.setEvaluateList(new ArrayList<PostEvaluate>());
			}
			List<PostEvaluate> postEvaluates = mapper.getEvaluate(postIds);
			if(postEvaluates != null && postEvaluates.size() > 0){
				for(Post ll : list){
					for(PostEvaluate postEvaluate : postEvaluates){
						if(ll.getId().equals(postEvaluate.getPostId())){
							ll.getEvaluateList().add(postEvaluate);
						}
					}
				}
			}*/
			for (Post ll : list) {
				List<PostEvaluate> datas = convertToPostEvaluate(ll.getTopThirdEvaluate());
				ll.setEvaluateList(datas);
			}
		}
		return list;
	}

	public Post selectById(Long id) {
		Post post = mapper.selectById(id);
		return post;
	}

	public int updatePraiseNum(Long id) {
		// TODO Auto-generated method stub
		return mapper.updatePraiseNum(id);
	}

	public int updateEvalueteNum(Long postId, String topThirdEvaluate) {
		return mapper.updateEvalueteNum(postId, topThirdEvaluate);
	}

	public int insert(Post post) {
		return mapper.insert(post);
	}

	public int updateDecPraiseNum(Long postId) {
		return mapper.updateDecPraiseNum(postId);

	}

	public List<Post> findPageByLabel(MyPage<Post> page, SelectPriseCenterVO vo) {
		List<Post> list = mapper.findPageByLabel(page, vo);
		if (list != null && list.size() > 0) {
			/*List<Long> postIds = new ArrayList<Long>();
			for(Post ll : list){
				postIds.add(ll.getId());
				ll.setEvaluateList(new ArrayList<PostEvaluate>());
			}
			List<PostEvaluate> postEvaluates = mapper.getEvaluate(postIds);
			if(postEvaluates != null && postEvaluates.size() > 0){
				for(Post ll : list){
					for(PostEvaluate postEvaluate : postEvaluates){
						if(ll.getId().equals(postEvaluate.getPostId())){
							ll.getEvaluateList().add(postEvaluate);
						}
					}
				}
			}*/
			for (Post ll : list) {
				List<PostEvaluate> datas = convertToPostEvaluate(ll.getTopThirdEvaluate());
				ll.setEvaluateList(datas);
			}
		}
		return list;
	}

	public List<Post> findHotPageByVo(MyPage<Post> page, PostVO vo) {
		List<Post> list = mapper.findHotPageByVo(page, vo);
		if (list != null && list.size() > 0) {
			/*List<Long> postIds = new ArrayList<Long>();
			for(Post ll : list){
				postIds.add(ll.getId());
				ll.setEvaluateList(new ArrayList<PostEvaluate>());
			}
			List<PostEvaluate> postEvaluates = mapper.getEvaluate(postIds);
			if(postEvaluates != null && postEvaluates.size() > 0){
				for(Post ll : list){
					for(PostEvaluate postEvaluate : postEvaluates){
						if(ll.getId().equals(postEvaluate.getPostId())){
							ll.getEvaluateList().add(postEvaluate);
						}
					}
				}
			}*/
			for (Post ll : list) {
				List<PostEvaluate> datas = convertToPostEvaluate(ll.getTopThirdEvaluate());
				ll.setEvaluateList(datas);
			}
		}
		return list;
	}

	public List<PostEvaluate> getTopThirdEvaluate(Long postId) {
		List<Long> postIds = new ArrayList<Long>();
		postIds.add(postId);
		return mapper.getEvaluate(postIds);
	}

	private List<PostEvaluate> convertToPostEvaluate(String postEvaluate) {
		List<PostEvaluate> datas = new ArrayList<PostEvaluate>();
		if (StringUtils.hasText(postEvaluate)) {
			JSONArray jsonArray = JSONArray.parseArray(postEvaluate);
			if (jsonArray != null && jsonArray.size() > 0) {
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject json = jsonArray.getJSONObject(i);
					PostEvaluate data = new PostEvaluate();
					data.setFromUserName(json.getString("fromUserName"));
					data.setContent(json.getString("content"));
					datas.add(data);
				}
			}
		}
		return datas;
	}

	public List<PostBO> findByPage(MyPage<PostBO> page, PostSelectVO vo) {
		List<PostBO> list = mapper.findByPage(page, vo);
		page.setContent(list);
		return list;
	}

	public Post get(long parseLong) {
		return mapper.selectByPrimaryKey(parseLong);
	}

	public void deleteByUIdPId(Long userId, Long postId) {
		mapper.deleteByUIdPId(userId, postId);
	}

	public int selectCurrentNumber(Long userId) {
		// TODO Auto-generated method stub
		return mapper.selectCurrentNumber(userId);
	}

	public Post selectLatelyPost(Long userId) {

		return mapper.selectLatelyPost(userId);
	}
	
	/** 查询未加分记录 **/
	public List<Post> listByisAddIntegral(){
		return mapper.listByisAddIntegral();
	}
	/** 更新加分状态 **/
	public int updateIsAddIntegralByid(@Param("id") Long id){
		return mapper.updateIsAddIntegralByid(id);
	}
}
