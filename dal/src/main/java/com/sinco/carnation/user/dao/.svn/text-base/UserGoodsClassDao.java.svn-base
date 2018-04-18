package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.goods.bo.GoodsYgClassBO;
import com.sinco.carnation.goods.vo.GoodsYgClassCountVO;
import com.sinco.carnation.user.bo.UserGoodsClassBO;
import com.sinco.carnation.user.mapper.UserGoodsClassMapper;
import com.sinco.carnation.user.model.UserGoodsClass;
import com.sinco.carnation.user.model.UserGoodsClassExample;
import com.sinco.carnation.user.vo.UserGoodsClassVO;
import com.sinco.dal.common.MyPage;

@Repository
public class UserGoodsClassDao {

	@Autowired
	private UserGoodsClassMapper mapper;

	public List<UserGoodsClassBO> selectParentPageByVO(UserGoodsClassVO vo, MyPage<UserGoodsClassBO> page) {
		return mapper.selectParentPageByVO(vo, page);
	}

	public List<UserGoodsClassBO> selectByGoodsId(Long goodsId) {
		return mapper.selectByGoodsId(goodsId);
	}

	public List<UserGoodsClass> findParentByUserId(Long userId) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andDeletestatusEqualTo(0).andParentIdIsNull().andDisplayEqualTo(true)
				.andUserIdEqualTo(userId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	public List<UserGoodsClass> findByParentId(Long parentId) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andDeletestatusEqualTo(0).andDisplayEqualTo(true)
				.andParentIdEqualTo(parentId);
		example.setOrderByClause(" sequence asc");
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<UserGoodsClass> findAll() {
		UserGoodsClassExample example = new UserGoodsClassExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		UserGoodsClassExample example = new UserGoodsClassExample();
		return mapper.countByExample(example);
	}

	public List<UserGoodsClass> save(Iterable<UserGoodsClass> entities) {
		List<UserGoodsClass> list = new ArrayList<UserGoodsClass>();
		for (UserGoodsClass UserGoodsClass : entities) {
			list.add(save(UserGoodsClass));
		}
		return list;
	}

	public UserGoodsClass save(UserGoodsClass record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(UserGoodsClass record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public UserGoodsClass findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public UserGoodsClass get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<UserGoodsClass> findAll(Iterable<Long> ids) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void removeByParentId(java.lang.Long parentId) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andParentIdEqualTo(parentId);
		mapper.deleteByExample(example);
	}

	public void delete(UserGoodsClass entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<UserGoodsClass> entities) {
		List<Long> ids = Lists.newArrayList();
		for (UserGoodsClass entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		UserGoodsClassExample example = new UserGoodsClassExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		UserGoodsClassExample example = new UserGoodsClassExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/
	/**
	 * 查找子集
	 * 
	 * @param parentId
	 * @return
	 */
	public List<GoodsYgClassBO> findByParent(Long parentId) {
		return mapper.findByParent(parentId);
	}

	public List<GoodsYgClassBO> findYgNormalAll(GoodsYgClassCountVO vo) {

		return mapper.findYgNormalAll(vo);
	}
}
