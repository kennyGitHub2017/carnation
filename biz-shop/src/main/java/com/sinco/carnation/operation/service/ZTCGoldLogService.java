package com.sinco.carnation.operation.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.operation.dao.ZTCGoldLogDao;
import com.sinco.carnation.operation.model.ZTCGoldLog;

@Service
@Transactional
public class ZTCGoldLogService {
	@Autowired
	private ZTCGoldLogDao zTCGlodLogDao;

	public boolean save(ZTCGoldLog zTCGlodLog) {
		/**
		 * init other field here
		 */
		try {
			this.zTCGlodLogDao.save(zTCGlodLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ZTCGoldLog getObjById(Long id) {
		ZTCGoldLog zTCGlodLog = this.zTCGlodLogDao.get(id);
		if (zTCGlodLog != null) {
			return zTCGlodLog;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.zTCGlodLogDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> zTCGlodLogIds) {
		// TODO Auto-generated method stub
		for (Serializable id : zTCGlodLogIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(ZTCGoldLog zTCGlodLog) {
		try {
			this.zTCGlodLogDao.update(zTCGlodLog);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
