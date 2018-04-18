package com.sinco.carnation.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.dao.GoldRecordDao;
import com.sinco.carnation.user.model.GoldRecord;

@Service
@Transactional
public class GoldRecordService {
	@Autowired
	private GoldRecordDao goldRecordDao;

	public boolean save(GoldRecord goldRecord) {
		/**
		 * init other field here
		 */
		try {
			this.goldRecordDao.save(goldRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoldRecord getObjById(Long id) {
		GoldRecord goldRecord = this.goldRecordDao.get(id);
		if (goldRecord != null) {
			return goldRecord;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goldRecordDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goldRecordIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goldRecordIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(GoldRecord goldRecord) {
		try {
			this.goldRecordDao.update(goldRecord);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
