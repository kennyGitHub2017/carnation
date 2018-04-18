package com.sinco.carnation.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.mapper.AccessoryMapper;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.sys.model.AccessoryExample;
import com.sinco.dal.common.MyPage;

@Repository
public class AccessoryDao {

	@Autowired
	private AccessoryMapper mapper;

	public List<Accessory> selectGoodsPhontListByGoodsId(Long goodsId) {

		return mapper.selectGoodsPhontListByGoodsId(goodsId);
	}

	/**
	 * 查找服务商品附件
	 * 
	 * @param goodsId
	 * @return
	 */
	public List<Accessory> selectGroupGoodsByGoodsId(Long goodsId) {
		return mapper.selectGroupGoodsByGoodsId(goodsId);
	}

	public List<Accessory> findByPath(String path) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andPathEqualTo(path).andDeleteStatusEqualTo(0);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<Accessory> findAll() {
		AccessoryExample example = new AccessoryExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		AccessoryExample example = new AccessoryExample();
		return mapper.countByExample(example);
	}

	public List<Accessory> save(Iterable<Accessory> entities) {
		List<Accessory> list = new ArrayList<Accessory>();
		for (Accessory Accessory : entities) {
			list.add(save(Accessory));
		}
		return list;
	}

	public Accessory save(Accessory record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Accessory record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public Accessory findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public Accessory get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<Accessory> findAll(Iterable<Long> ids) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Accessory entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Accessory> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Accessory entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AccessoryExample example = new AccessoryExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public int queryAlbumListCount(Long albumId, Long userId) {
		return mapper.queryAlbumListCount(albumId, userId);
	}

	public List<AccessoryBO> queryAccessoriesById(Long userId, Long albumId, MyPage<AccessoryBO> page) {
		return mapper.queryAccessoriesById(userId, albumId, page);
	}

	public int deleteAccessotyById(Long[] id) {
		return mapper.deleteAccessotyById(id);
	}

	public int updateAlbumTransfer(Long[] ids, Long toAlbumId, Long albumId) {
		return mapper.updateAlbumTransfer(ids, toAlbumId, albumId);
	}

	public int accessoryDelByAlbumId(Long albumId) {
		return mapper.accessoryDelByAlbumId(albumId);
	}

	public List<Accessory> queryAccessroyByAlbumId(Long albumId) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andAlbumIdEqualTo(albumId);
		return mapper.selectByExample(example);
	}

	public List<Accessory> queryForEvaluate(Long userId) {
		AccessoryExample example = new AccessoryExample();
		example.createCriteria().andUserIdEqualTo(userId).andInfoEqualTo("eva_temp");
		return mapper.selectByExample(example);
	}

	public List<AccessoryBO> storeAccessoryList(Long albumId, MyPage<AccessoryBO> page) {
		return mapper.storeAccessoryList(albumId, page);
	}
}
