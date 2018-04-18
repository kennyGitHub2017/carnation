package com.sinco.carnation.store.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.store.dao.StorePartnerDao;
import com.sinco.carnation.store.model.StorePartner;

@Service
@Transactional
public class StorePartnerService {
	@Autowired
	private StorePartnerDao storePartnerDao;

	public boolean save(StorePartner storePartner) {
		/**
		 * init other field here
		 */
		try {
			this.storePartnerDao.save(storePartner);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public StorePartner getObjById(Long id) {
		StorePartner storePartner = this.storePartnerDao.get(id);
		if (storePartner != null) {
			return storePartner;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.storePartnerDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> storePartnerIds) {
		// TODO Auto-generated method stub
		for (Serializable id : storePartnerIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(StorePartner storePartner) {
		try {
			this.storePartnerDao.update(storePartner);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
