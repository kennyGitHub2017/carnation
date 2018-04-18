package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.bo.StorePointBO;
import com.sinco.carnation.store.dao.StorePointDao;
import com.sinco.carnation.store.model.StorePoint;

@Service
@Transactional
public class StorePointService {

	@Autowired
	private StorePointDao storePointDao;

	public boolean save(StorePoint storePoint) {
		/**
		 * init other field here
		 */
		try {
			this.storePointDao.save(storePoint);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StorePointBO fetchByStoreId(long storeId) {
		return storePointDao.fetchByStoreId(storeId);
	}

	public StorePoint getObjById(Long id) {
		StorePoint storePoint = this.storePointDao.get(id);
		if (storePoint != null) {
			return storePoint;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storePointDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storePointIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storePointIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StorePoint storePoint) {
		try {
			this.storePointDao.update(storePoint);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StorePoint fetchByUserId(Long userId) {
		return storePointDao.fetchByUserId(userId);
	}

}
