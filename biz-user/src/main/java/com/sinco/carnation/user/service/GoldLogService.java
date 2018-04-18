package com.sinco.carnation.user.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.user.dao.GoldLogDao;
import com.sinco.carnation.user.model.GoldLog;

@Service
@Transactional
public class GoldLogService {
	@Autowired
	private GoldLogDao goldLogDao;

	public boolean save(GoldLog goldLog) {
		/**
		 * init other field here
		 */
		try {
			this.goldLogDao.save(goldLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public GoldLog getObjById(Long id) {
		GoldLog goldLog = this.goldLogDao.get(id);
		if (goldLog != null) {
			return goldLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.goldLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> goldLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : goldLogIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(GoldLog goldLog) {
		try {
			this.goldLogDao.update(goldLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
