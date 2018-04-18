package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.dao.StoreStatDao;
import com.sinco.carnation.store.model.StoreStat;

@Service
@Transactional
public class StoreStatService {

	@Autowired
	private StoreStatDao storeStatDao;

	public boolean save(StoreStat storeStat) {
		/**
		 * init other field here
		 */
		try {
			this.storeStatDao.save(storeStat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StoreStat getObjById(Long id) {
		StoreStat storeStat = this.storeStatDao.get(id);
		if (storeStat != null) {
			return storeStat;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storeStatDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storeStatIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storeStatIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StoreStat storeStat) {
		try {
			this.storeStatDao.update(storeStat);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
