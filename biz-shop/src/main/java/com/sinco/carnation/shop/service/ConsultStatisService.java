package com.sinco.carnation.shop.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinco.carnation.shop.dao.ConsultStatisDao;
import com.sinco.carnation.shop.model.ConsultStatis;

@Service
@Transactional
public class ConsultStatisService {
	@Autowired
	private ConsultStatisDao ConsultStatisDao;

	public boolean save(ConsultStatis ConsultStatis) {
		/**
		 * init other field here
		 */
		try {
			this.ConsultStatisDao.save(ConsultStatis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ConsultStatis getObjById(Long id) {
		ConsultStatis ConsultStatis = this.ConsultStatisDao.get(id);
		if (ConsultStatis != null) {
			return ConsultStatis;
		}
		return null;
	}

	public boolean delete(Long id) {
		try {
			this.ConsultStatisDao.remove(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean batchDelete(List<Serializable> ConsultStatisIds) {
		// TODO Auto-generated method stub
		for (Serializable id : ConsultStatisIds) {
			delete((Long) id);
		}
		return true;
	}

	public boolean update(ConsultStatis ConsultStatis) {
		try {
			this.ConsultStatisDao.update(ConsultStatis);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
