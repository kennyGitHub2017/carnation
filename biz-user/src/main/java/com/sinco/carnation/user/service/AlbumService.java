package com.sinco.carnation.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vc.thinker.b2b2c.core.tools.CommUtil;

import com.sinco.carnation.sys.bo.AccessoryBO;
import com.sinco.carnation.sys.dao.AccessoryDao;
import com.sinco.carnation.sys.dao.UserDao;
import com.sinco.carnation.sys.model.Accessory;
import com.sinco.carnation.user.bo.AlbumBO;
import com.sinco.carnation.user.dao.AlbumDao;
import com.sinco.carnation.user.model.Album;
import com.sinco.dal.common.MyPage;

@Service
@Transactional(readOnly = true)
public class AlbumService {

	@Autowired
	private AlbumDao albumDao;

	@Autowired
	private AccessoryDao accessoryDao;

	@Autowired
	private UserDao userDAO;

	public Album getObjById(Long id) {
		Album album = albumDao.get(id);
		if (album != null) {
			return album;
		}
		return null;
	}

	public List<AlbumBO> findAllByUserId(Long userId, Integer isStore) {
		return albumDao.findAllByUserId(userId, isStore);
	}

	public void list(Long userId, MyPage<AlbumBO> page) {
		List<AlbumBO> list = albumDao.queryAlbumList(userId, page);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Integer count = accessoryDao.queryAlbumListCount(list.get(i).getId(), userId);
				if (count != null && count > 0)
					list.get(i).setAccessorySize(count);
				else
					list.get(i).setAccessorySize(0);
			}
		}
		page.setContent(list);
	}

	public void listStoreAlbum(Long userId, MyPage<AlbumBO> page) {
		List<AlbumBO> list = albumDao.queryStoreAlbumList(userId, page);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Integer count = accessoryDao.queryAlbumListCount(list.get(i).getId(), userId);
				if (count != null && count > 0)
					list.get(i).setAccessorySize(count);
				else
					list.get(i).setAccessorySize(0);
			}
		}
		page.setContent(list);
	}

	public AlbumBO queryAlbumById(Long id) {
		return albumDao.queryAlbumById(id);
	}

	@Transactional(readOnly = false)
	public void updateAlbum(Album album) {
		albumDao.update(album);
	}

	@Transactional(readOnly = false)
	public void albumSave(Long userId, Album album) {

		if (album.getId() != null) {
			// id不为空，修改相册信息
			albumDao.update(album);
		} else {
			// 添加相册
			album.setAddTime(new Date());
			album.setUserId(userId);
			album.setAlbumDefault(false);
			albumDao.save(album);
		}
	}

	@Transactional(readOnly = false)
	public void albumDelete(String mulitId) {
		if (StringUtils.isNotBlank(mulitId)) {
			String[] ids = mulitId.split(",");
			Long[] longId = new Long[ids.length];
			for (int i = 0; i < ids.length; i++) {
				longId[i] = CommUtil.null2Long(ids[i]);
			}
			// 先删除相册下面所有图片
			for (int i = 0; i < longId.length; i++) {
				accessoryDao.accessoryDelByAlbumId(longId[i]);
			}
			// 再删除相册
			albumDao.ablumDelete(longId);

		}
	}

	public AlbumBO queryAblumAccessory(Long coverId, Long userId) {
		return albumDao.queryAblumAccessory(coverId, userId);
	}

	public void queryAlbumByUserNameList(String loginName, MyPage<AlbumBO> page) {
		List<AlbumBO> list = albumDao.queryAlbumByUserNameList(loginName, page);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Integer count = accessoryDao.queryAlbumListCount(list.get(i).getId(), null);
				if (count != null && count > 0)
					list.get(i).setAccessorySize(count);
				else
					list.get(i).setAccessorySize(0);
			}
		}
		page.setContent(list);
	}

	public void albumUserList(String albumName, MyPage<AlbumBO> page) {
		List<AlbumBO> list = albumDao.albumUserList(albumName, page);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Integer count = accessoryDao.queryAlbumListCount(list.get(i).getId(), null);
				if (count != null && count > 0)
					list.get(i).setAccessorySize(count);
				else
					list.get(i).setAccessorySize(0);
			}
		}
		page.setContent(list);
	}

	/**
	 * 获取商户环境相册(分页)
	 */
	public void getStoreAlbum(Long sellerUid, MyPage<AccessoryBO> page) {
		AlbumBO albumBO = albumDao.getStoreAlbum(sellerUid);
		if (albumBO != null) {
			page.setContent(accessoryDao.storeAccessoryList(albumBO.getId(), page));
		}
	}

	/**
	 * 查询o2o商户默认环境相册
	 * 
	 * @param userId
	 * @return
	 */
	public List<Accessory> queryAccessories(Long userId) {
		if (null == userId) {
			return new ArrayList<>();
		}
		AlbumBO albumBO = albumDao.fetchStoreInfoDefaultAlbum(userId);
		if (null == albumBO)
			return new ArrayList<>();
		return accessoryDao.queryAccessroyByAlbumId(albumBO.getId());
	}

	public AlbumBO getStoreAlbum(Long sellerUid) {
		return albumDao.getStoreAlbum(sellerUid);
	}
}
