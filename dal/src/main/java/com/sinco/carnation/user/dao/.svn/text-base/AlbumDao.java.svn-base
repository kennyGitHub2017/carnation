package com.sinco.carnation.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.sinco.carnation.user.mapper.AlbumMapper;
import com.sinco.carnation.user.model.Album;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.model.AlbumExample;
import com.sinco.dal.common.MyPage;

@Repository
public class AlbumDao {

	@Autowired
	private AlbumMapper mapper;

	public List<AlbumBO> getDefaultAlbum(Long userId) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andAlbumDefaultEqualTo(true).andUserIdEqualTo(userId);
		return mapper.selectByExample(example);
	}

	public AlbumBO fetchStoreInfoDefaultAlbum(Long userId) {

		return mapper.fetchStoreInfoDefaultAlbum(userId);
	}

	public List<AlbumBO> findAllByUserId(Long userId, Integer isStore) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andDeleteStatusEqualTo(0).andUserIdEqualTo(userId)
				.andStoreInfoDefaultEqualTo(isStore);
		return mapper.selectByExample(example);
	}

	/** generate code begin **/
	public List<AlbumBO> findAll() {
		AlbumExample example = new AlbumExample();
		return mapper.selectByExample(example);
	}

	public long count() {
		AlbumExample example = new AlbumExample();
		return mapper.countByExample(example);
	}

	public List<Album> save(Iterable<Album> entities) {
		List<Album> list = new ArrayList<Album>();
		for (Album Album : entities) {
			list.add(save(Album));
		}
		return list;
	}

	public Album save(Album record) {
		if (record.getId() == null) {
			mapper.insertSelective(record);
		} else {
			mapper.updateByPrimaryKeySelective(record);
		}
		return record;
	}

	public void update(Album record) {
		mapper.updateByPrimaryKeySelective(record);
	}

	public AlbumBO findOne(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public AlbumBO get(java.lang.Long id) {
		return mapper.selectByPrimaryKey(id);
	}

	public boolean exists(java.lang.Long id) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andIdEqualTo(id);
		return mapper.countByExample(example) > 0;
	}

	List<AlbumBO> findAll(Iterable<Long> ids) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		return mapper.selectByExample(example);
	}

	public void delete(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void remove(java.lang.Long id) {
		mapper.deleteByPrimaryKey(id);
	}

	public void delete(Album entity) {
		mapper.deleteByPrimaryKey(entity.getId());
	}

	public void delete(Iterable<Album> entities) {
		List<Long> ids = Lists.newArrayList();
		for (Album entity : entities) {
			ids.add(entity.getId());
		}
		deleteByIds(ids);
	}

	public void deleteByIds(Iterable<Long> ids) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andIdIn(Lists.newArrayList(ids));
		mapper.deleteByExample(example);
	}

	public void deleteAll() {
		AlbumExample example = new AlbumExample();
		mapper.deleteByExample(example);
	}

	/** generate code end **/

	public List<AlbumBO> queryAlbumList(Long userId, MyPage<AlbumBO> page) {
		return mapper.queryAlbumList(userId, page);
	}

	public AlbumBO queryAlbumById(Long id) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andIdEqualTo(id);
		List<AlbumBO> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}

	public int ablumDelete(Long[] ids) {
		return mapper.ablumDelete(ids);
	}

	public AlbumBO queryAblumAccessory(Long coverId, Long userId) {
		List<AlbumBO> list = mapper.queryAblumAccessory(coverId, userId);
		return list.isEmpty() ? null : list.get(0);
	}

	public List<AlbumBO> queryAlbumByUserNameList(String loginName, MyPage<AlbumBO> page) {
		return mapper.queryAlbumByUserNameList(loginName, page);
	}

	public List<AlbumBO> albumUserList(String albumName, MyPage<AlbumBO> page) {
		return mapper.albumUserList(albumName, page);
	}

	public List<AlbumBO> queryAlbumListByUid(Long userId) {
		return mapper.queryAlbumListByUid(userId);
	}

	public List<AlbumBO> queryStoreAlbumList(Long userId, MyPage<AlbumBO> page) {
		return mapper.queryStoreAlbumList(userId, page);
	}

	public AlbumBO getStoreAlbum(Long sellerUid) {
		AlbumExample example = new AlbumExample();
		example.createCriteria().andUserIdEqualTo(sellerUid).andStoreInfoDefaultEqualTo(1);
		List<AlbumBO> list = mapper.selectByExample(example);
		return list.isEmpty() ? null : list.get(0);
	}
}
